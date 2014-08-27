package siteseeker.web;

import java.net.URL;
import java.security.MessageDigest;
import java.text.MessageFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;


import org.apache.commons.logging.LogFactory;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.codec.binary.Base64;

/**
 * A class for handling user session identities. 
 * @author B. Andrist
 */
public class SearchSession {

  private String sessionId;
  private Long time;
  private String host;

  /**
   * <p>Constructs a session identifier based on the specified HttpRequest.
   * <p>A new session identifier is generated if:
   * <li> HttpRequest does not contain any session id parameter.
   * <li> The session id parameter from the HttpRequest object
   * has expired or does not match the hostname of the current HTTP client.
   *
   * @param remoteAddress The IP address of the HTTP client
   * @param sessionStr The session string
   */
  public SearchSession(String remoteAddress, String sessionStr) {
    this.host = hexStringFromBytes(remoteAddress.getBytes());
    this.time = Calendar.getInstance().getTimeInMillis();
    this.sessionId = parse(sessionStr);
    if (this.sessionId == null) {
      this.sessionId = generateSessionID();
    }
  }
    
  /**
   * The session id.
   */
  public String getUserIdentifierKey() {
    return sessionId; 
  }
    
  /**
   * <p>Generates a String that represents this session instance (including the session id).
   * This String is intended to be used as an URL parameter.
   * The session id can be extracted from the String by using <code>GetSessionID(String s)</code>.
   * 
   * @return a String that represents this session
   */
  public String toString() {
    return sessionId + ":" + host + ":" + time;
  }

  private String parse(String sessionStr) {	
    if (StringUtils.isEmpty(sessionStr))
      return null;
    String[] tokens = sessionStr.split(":");
    if (tokens.length != 3)
      return null;
    if (!host.equals(tokens[1])) {
      LogFactory.getLog(getClass()).debug("invalid host");
      return null;
    }
    Long sessionTime = new Long(tokens[2]);
    if (time > (sessionTime + (1000*60*60*24))) {
      LogFactory.getLog(getClass()).debug("invalid time");
      return null;
    }
    return tokens[0];
  }

  private String generateSessionID() {
    byte[] b = null;
    try {
      MessageDigest tMd = MessageDigest.getInstance("MD5");
      b = tMd.digest((host + time).getBytes());
    }
    catch (Exception e) {
      LogFactory.getLog(getClass()).debug("Excpetion while generating session id: " + e);
      b = defaultUserIdentifier;
    }
    return hexStringFromBytes(b);
  }

  private static final char[] hexChars ={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
  private static byte[] defaultUserIdentifier = new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

  private static String hexStringFromBytes(byte[] b) {
    StringBuilder hex = new StringBuilder("");
    for (int i = 0; i < b.length; i++) {
      int msb = ((int)b[i] & 0x000000FF) / 16;
      int lsb = ((int)b[i] & 0x000000FF) % 16;
      hex = hex.append(hexChars[msb]).append(hexChars[lsb]);
    }
    return(hex.toString());
  }
}
