package com.carffrey.model.service;

import org.apache.oltu.oauth2.common.token.OAuthToken;

public class OAuthSimpleService {
    private static String accessToken = null;
	
    public static void setAccessToken(OAuthToken accessToken) {
    	OAuthSimpleService.accessToken = accessToken.getAccessToken();
	}
    
	public static String getAccessToken() {
		return accessToken;
	}

//    /**
//     * Contains null or actually authorization flow.
//     */
//    private static OAuth2CodeGrantFlow flow;
//    private static ClientIdentifier clientIdentifier;
//


//    public static OAuth2CodeGrantFlow getFlow() {
//        return flow;
//    }
//
//    public static void setFlow(OAuth2CodeGrantFlow flow) {
//    	OAuthSimpleService.flow = flow;
//    }
//
//    public static ClientIdentifier getClientIdentifier() {
//        return clientIdentifier;
//    }
//
//    public static void setClientIdentifier(ClientIdentifier clientIdentifier) {
//    	OAuthSimpleService.clientIdentifier = clientIdentifier;
//    }
}