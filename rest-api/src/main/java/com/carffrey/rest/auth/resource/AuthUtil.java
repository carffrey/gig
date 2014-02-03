package com.carffrey.rest.auth.resource;

import java.util.regex.Pattern;

import net.oauth.jsontoken.JsonToken;
import net.oauth.jsontoken.SystemClock;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

class AuthUtil {
	private static final String DELIMITER = ".";

	/**
	 * Decodes the JWT token string into a JsonToken object. Does not perform
	 * any validation of headers or claims.
	 * 
	 * @param tokenString
	 *            The original encoded representation of a JWT
	 * @return Unverified contents of the JWT as a JsonToken
	 */
	public static JsonToken deserializeJwt(String tokenString) {
		String[] pieces = splitTokenString(tokenString);
		String jwtPayloadSegment = pieces[1];

		JsonParser parser = new JsonParser();
		JsonObject payload = parser.parse(
				fromBase64ToJsonString(jwtPayloadSegment)).getAsJsonObject();

		JsonToken jsonToken = new JsonToken(payload, new SystemClock());
		return jsonToken;

		// String jwtHeaderSegment = pieces[0];
		// byte[] signature = Base64.decodeBase64(pieces[2]);
		// JsonObject header =
		// parser.parse(fromBase64ToJsonString(jwtHeaderSegment))
		// .getAsJsonObject();
	}

	/**
	 * @param tokenString
	 *            The original encoded representation of a JWT
	 * @return Three components of the JWT as an array of strings
	 */
	private static String[] splitTokenString(String tokenString) {
		String[] pieces = tokenString.split(Pattern.quote(DELIMITER));
		if (pieces.length != 3) {
			throw new IllegalStateException("JWT must have three segments");
		}
		return pieces;
	}

	private static String fromBase64ToJsonString(String source) {
		return StringUtils.newStringUtf8(Base64.decodeBase64(source));
	}

}
