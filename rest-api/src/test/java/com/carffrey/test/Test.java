package com.carffrey.test;

import java.security.SignatureException;
import java.util.regex.Pattern;

import javax.xml.bind.DatatypeConverter;

import net.oauth.jsontoken.Checker;
import net.oauth.jsontoken.JsonToken;
import net.oauth.jsontoken.JsonTokenParser;
import net.oauth.jsontoken.SystemClock;
import net.oauth.jsontoken.discovery.VerifierProviders;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.joda.time.Duration;
import org.joda.time.Instant;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Test {
	public static void main(String[] args) throws SignatureException {
		//String idToken ="eyJhbGciOiJSUzI1NiIsImtpZCI6ImRiMjdhOTM1MTdkYjE2ZDhhYjU5MjU0YjllZDJmODA0NDcxNzI4YzAifQ.eyJpc3MiOiJhY2NvdW50cy5nb29nbGUuY29tIiwiYXVkIjoiMjQ5MTIxNDY0MTQ3LWduc2xxOWQ1ZzBlNGM1ZGxlbjlnMDF0cGlzMm44YzlvLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwic3ViIjoiMTA4MzA0MjYwMDYwODA2OTU1MjUzIiwiYXpwIjoiMjQ5MTIxNDY0MTQ3LWduc2xxOWQ1ZzBlNGM1ZGxlbjlnMDF0cGlzMm44YzlvLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwiYXRfaGFzaCI6Ii1jR29zTXVtNEZDdnRaeHhqbXhwcUEiLCJpYXQiOjEzOTEzODg4NTQsImV4cCI6MTM5MTM5Mjc1NH0.sVqd2JeeRhuabhpzu3RrzwEFLFJHrwrd40-7zLjQOsta2Pf83gV-1B46X6fq9JvDjevB_71jzjCVnyrqMOSPt-P10_Fgeh3rOeaPRNudBUsPgWr4Zt4fM1FFuJFqOsau-Kl4nid_s550RQgTUFHwV8-TUow_7jQA4y7VwEaGr-Q, access_token=ya29.1.AADtN_UzoonrGi4ikMaXLdCzdtN2m72DiOtpkLjtj-sk2d4y6cc1PNi6UeInvEOOKJMLUemv-THxF_WR_uh0jESEfPTmQ53_N00b5A4pD0pLpBpkwbWlTn853vzEk-pXGg";
		String idToken ="eyJhbGciOiJSUzI1NiIsImtpZCI6ImRiMjdhOTM1MTdkYjE2ZDhhYjU5MjU0YjllZDJmODA0NDcxNzI4YzAifQ.eyJpc3MiOiJhY2NvdW50cy5nb29nbGUuY29tIiwiYXVkIjoiMjQ5MTIxNDY0MTQ3LWduc2xxOWQ1ZzBlNGM1ZGxlbjlnMDF0cGlzMm44YzlvLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwic3ViIjoiMTA4MzA0MjYwMDYwODA2OTU1MjUzIiwiYXpwIjoiMjQ5MTIxNDY0MTQ3LWduc2xxOWQ1ZzBlNGM1ZGxlbjlnMDF0cGlzMm44YzlvLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwiYXRfaGFzaCI6Ii1jR29zTXVtNEZDdnRaeHhqbXhwcUEiLCJpYXQiOjEzOTEzODg4NTQsImV4cCI6MTM5MTM5Mjc1NH0.sVqd2JeeRhuabhpzu3RrzwEFLFJHrwrd40-7zLjQOsta2Pf83gV-1B46X6fq9JvDjevB_71jzjCVnyrqMOSPt-P10_Fgeh3rOeaPRNudBUsPgWr4Zt4fM1FFuJFqOsau-Kl4nid_s550RQgTUFHwV8-TUow_7jQA4y7VwEaGr-Q";
		String[] parts = idToken.split("\\.");
		
//		final Verifier hmacVerifier = new HmacSHA256Verifier(SYMMETRIC_KEY);
//
//	    VerifierProvider hmacLocator = new VerifierProvider() {
//	      @Override
//	      public List<Verifier> findVerifier(String signerId, String keyId) {
//	        return Lists.newArrayList(hmacVerifier);
//	      }
//	    };
//
//	    VerifierProvider rsaLocator = new DefaultPublicKeyLocator(
//	        new IdentityServerDescriptorProvider(),
//	        new ServerInfoResolver() {
//	          @Override
//	          public ServerInfo resolve(URI uri) {
//	            return JsonServerInfo.getDocument(SERVER_INFO_DOCUMENT);
//	          }
//	        });
//		
//		VerifierProviders locators = new VerifierProviders();
//	    locators.setVerifierProvider(SignatureAlgorithm.HS256, hmacLocator);
//	    locators.setVerifierProvider(SignatureAlgorithm.RS256, rsaLocator);

	    // SystemClock may need some skew time
	    JsonTokenParser parser = new JsonTokenParser(new FakeClock(), new VerifierProviders(), new Checker() {

			@Override
			public void check(JsonObject payload) throws SignatureException {
				// do nothing
				
			}});
	    //JsonToken token = parser.verifyAndDeserialize(idToken);
	    // use Sub as user identifier
	    JsonToken token = deserialize(idToken);
	    System.out.println(token.getParamAsPrimitive("sub"));
	    System.out.println(token);
//		System.out.println(base64Decode(parts[0]));
//		System.out.println(base64Decode(parts[1]));
//		System.out.println(base64Decode(parts[2]));
//		JsonParserFactory t;
//	    JsonObject header = parser.parse(JsonTokenUtil.fromBase64ToJsonString(jwtHeaderSegment))
//	        .getAsJsonObject();
//	    JsonObject payload = parser.parse(JsonTokenUtil.fromBase64ToJsonString(jwtPayloadSegment))
//	        .getAsJsonObject();
//	    
//	    JsonToken jsonToken = new JsonToken(header, payload, clock, tokenString);
//	    return jsonToken;
	}
	
	  /**
	   * Decodes the JWT token string into a JsonToken object. Does not perform
	   * any validation of headers or claims.
	   * 
	   * @param tokenString The original encoded representation of a JWT
	   * @return Unverified contents of the JWT as a JsonToken
	   */
	  public static JsonToken deserialize(String tokenString) {
	    String[] pieces = splitTokenString(tokenString);
	    String jwtHeaderSegment = pieces[0];
	    String jwtPayloadSegment = pieces[1];
	    byte[] signature = Base64.decodeBase64(pieces[2]);
	    JsonParser parser = new JsonParser();
	    JsonObject header = parser.parse(fromBase64ToJsonString(jwtHeaderSegment))
	        .getAsJsonObject();
	    JsonObject payload = parser.parse(fromBase64ToJsonString(jwtPayloadSegment))
	        .getAsJsonObject();
	    
	    //JsonToken jsonToken = new JsonToken(header, payload, clock, tokenString);
	    JsonToken jsonToken = new JsonToken(payload, new SystemClock());
	    return jsonToken;
	  }
	  static public final String DELIMITER = ".";
	  /**
	   * @param tokenString The original encoded representation of a JWT
	   * @return Three components of the JWT as an array of strings
	   */
	  private static String[] splitTokenString(String tokenString) {
	    String[] pieces = tokenString.split(Pattern.quote(DELIMITER));
	    if (pieces.length != 3) {
	      throw new IllegalStateException("Expected JWT to have 3 segments separated by '" + 
	          DELIMITER + "', but it has " + pieces.length + " segments");
	    }
	    return pieces;
	  }

//	  public static String decodeFromBase64String(String encoded) {
//	    return new String(Base64.decodeBase64(encoded));
//	  }
//	  
	  public static String fromBase64ToJsonString(String source) {
	    return StringUtils.newStringUtf8(Base64.decodeBase64(source));
	  }
	
	public static String base64Decode(String s) {
		byte[] bytes = DatatypeConverter.parseBase64Binary(s);
		return DatatypeConverter.printBase64Binary(bytes);
	}
	
	public static class FakeClock extends SystemClock {

		  private Instant now = new Instant();

		  public FakeClock() {
		    super(Duration.ZERO);
		  }

		  public FakeClock(Duration acceptableClockSkew) {
		    super(acceptableClockSkew);
		  }

		  public void setNow(Instant i) {
		    now = i;
		  }

		  @Override
		  public Instant now() {
		    return now;
		  }
	}
//	
//	public static class MyBase64 {
//
//	    private final static char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
//
//	    private static int[]  toInt   = new int[128];
//
//	    static {
//	        for(int i=0; i< ALPHABET.length; i++){
//	            toInt[ALPHABET[i]]= i;
//	        }
//	    }
//
//	    /**
//	     * Translates the specified byte array into Base64 string.
//	     *
//	     * @param buf the byte array (not null)
//	     * @return the translated Base64 string (not null)
//	     */
//	    public static String encode(byte[] buf){
//	        int size = buf.length;
//	        char[] ar = new char[((size + 2) / 3) * 4];
//	        int a = 0;
//	        int i=0;
//	        while(i < size){
//	            byte b0 = buf[i++];
//	            byte b1 = (i < size) ? buf[i++] : 0;
//	            byte b2 = (i < size) ? buf[i++] : 0;
//
//	            int mask = 0x3F;
//	            ar[a++] = ALPHABET[(b0 >> 2) & mask];
//	            ar[a++] = ALPHABET[((b0 << 4) | ((b1 & 0xFF) >> 4)) & mask];
//	            ar[a++] = ALPHABET[((b1 << 2) | ((b2 & 0xFF) >> 6)) & mask];
//	            ar[a++] = ALPHABET[b2 & mask];
//	        }
//	        switch(size % 3){
//	            case 1: ar[--a]  = '=';
//	            case 2: ar[--a]  = '=';
//	        }
//	        return new String(ar);
//	    }
//
//	    /**
//	     * Translates the specified Base64 string into a byte array.
//	     *
//	     * @param s the Base64 string (not null)
//	     * @return the byte array (not null)
//	     */
//	    public static byte[] decode(String s){
//	        int delta = s.endsWith( "==" ) ? 2 : s.endsWith( "=" ) ? 1 : 0;
//	        byte[] buffer = new byte[s.length()*3/4 - delta];
//	        int mask = 0xFF;
//	        int index = 0;
//	        for(int i=0; i< s.length(); i+=4){
//	            int c0 = toInt[s.charAt( i )];
//	            int c1 = toInt[s.charAt( i + 1)];
//	            buffer[index++]= (byte)(((c0 << 2) | (c1 >> 4)) & mask);
//	            if(index >= buffer.length){
//	                return buffer;
//	            }
//	            int c2 = toInt[s.charAt( i + 2)];
//	            buffer[index++]= (byte)(((c1 << 4) | (c2 >> 2)) & mask);
//	            if(index >= buffer.length){
//	                return buffer;
//	            }
//	            int c3 = toInt[s.charAt( i + 3 )];
//	            buffer[index++]= (byte)(((c2 << 6) | c3) & mask);
//	        }
//	        return buffer;
//	    } 
//
//	}
}
