package com.carffrey.rest.auth.resource;

import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import net.oauth.jsontoken.JsonToken;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.OAuthProviderType;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.apache.oltu.oauth2.common.token.OAuthToken;

import com.carffrey.rest.service.OAuthSimpleService;
import com.google.gson.JsonPrimitive;

@Path("oauth2callback")
public class GoogleAuthorizationResource {
    @Context
    private UriInfo uriInfo;

    @GET
    public String authorize(@QueryParam("code") String code, @QueryParam("state") String state) {

	final URI uri = UriBuilder.fromUri(uriInfo.getBaseUriBuilder().path("/..").build().normalize())
			.path("index.jsp").build();
    	try {
		OAuthClientRequest request = OAuthClientRequest
				.tokenProvider(OAuthProviderType.GOOGLE)
				.setCode(code)
				.setClientId("your-client-id")
				.setClientSecret("your-client-secret")
				.setRedirectURI(UriBuilder.fromUri(uriInfo.getBaseUri())
						.path("oauth2callback").build().toString())
				.setGrantType(GrantType.AUTHORIZATION_CODE)
				.buildBodyMessage();


		OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
		OAuthJSONAccessTokenResponse oAuthResponse = oAuthClient.accessToken(request);

		OAuthToken accessToken = oAuthResponse.getOAuthToken();
		String jwtToken = oAuthResponse.getParam("id_token");
		JsonToken jsonToken = AuthUtil.deserializeJwt(jwtToken);
		JsonPrimitive id = jsonToken.getParamAsPrimitive("sub");
		
		OAuthSimpleService.addAuthenticatedUser(accessToken, id.getAsString());
    		return accessToken.getAccessToken();
	} catch (OAuthSystemException e) {
		throw new WebApplicationException(e);
	} catch (OAuthProblemException e) {
		throw new WebApplicationException(e);
	}
    }
}
