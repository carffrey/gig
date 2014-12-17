package com.carffrey.rest.auth.resource;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.common.OAuthProviderType;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;

@Path("google")
public class GoogleResource {
    @Context
    private UriInfo uriInfo;

	@GET
	@Produces("text/html")
	public Response authenticate() {
		try {
			OAuthClientRequest request = OAuthClientRequest
					.authorizationProvider(OAuthProviderType.GOOGLE)
					.setClientId("your-client-id")
					.setResponseType("code")
					.setScope("openid https://www.googleapis.com/auth/plus.login") //openid profile email https://www.googleapis.com/auth/plus.login
					.setRedirectURI(
							UriBuilder.fromUri(uriInfo.getBaseUri())
									.path("oauth2callback").build().toString())
					.buildQueryMessage();
			URI redirect = new URI(request.getLocationUri());

			return Response.seeOther(redirect).build();
		} catch (OAuthSystemException e) {
			throw new WebApplicationException(e);
		} catch (URISyntaxException e) {
			throw new WebApplicationException(e);
		}
	}

}
