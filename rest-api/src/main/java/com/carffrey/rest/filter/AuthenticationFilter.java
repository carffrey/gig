package com.carffrey.rest.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

import com.carffrey.rest.service.OAuthSimpleService;

@Provider
public class AuthenticationFilter implements ContainerRequestFilter {

	private static Set<String> open; 
	static {
		 open = new HashSet<String>();
		 open.add("google");
		 open.add("oauth2callback");
	}
	
    @Override
    public void filter(ContainerRequestContext requestContext)
            throws IOException {
    	UriInfo uriInfo = requestContext.getUriInfo();
    	int lastSegIndex = uriInfo.getPathSegments().size() - 1;
    	PathSegment ps = uriInfo.getPathSegments().get(lastSegIndex);
    	
    	if (open.contains(ps.getPath())) {
    		// Authorized
    		return;
    	}
    	
    	String authHeader = requestContext.getHeaderString("Authorization");
    	authHeader = authHeader.replaceFirst("Bearer ", "");
    	// TODO get accessToken
		if (OAuthSimpleService.getAuthenticatedUser(authHeader) != null) {
			// TODO OAuthSimpleService keeps one and only one token
			// Requires updating to support more than one user
			// Token found for user, authorized
			return;
		} else {
			requestContext.abortWith(Response
					.status(Response.Status.UNAUTHORIZED)
					.entity("Requires authorization.").build());
			return;
		}
    }
}