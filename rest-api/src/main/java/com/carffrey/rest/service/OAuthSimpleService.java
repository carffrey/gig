package com.carffrey.rest.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.oltu.oauth2.common.token.OAuthToken;

public class OAuthSimpleService {
	// TODO purge expired tokens
	// TODO store in DB 
	// TODO note we are not validating tokens, what about invalidation
	// We can check expiry accessToken.getExpiresIn()
	private static Map<String,String> accessTokenToId = new HashMap<String,String>();
	
	/**
	 * Add a new authenticated user, the user is logged in as long as
	 * the token is valid
	 *
	 * @param id
	 * @param accessToken
	 */
    public static void addAuthenticatedUser(OAuthToken accessToken, String id) {
    	OAuthSimpleService.accessTokenToId.put(accessToken.getAccessToken(), id);
	}
    
    /**
     * Return the user id for this token, or null if the user
     * is not authenticated
     * @param accessToken
     * @return the user idg
     */
	public static String getAuthenticatedUser(String accessToken) {
		return OAuthSimpleService.accessTokenToId.get(accessToken);
	}
}