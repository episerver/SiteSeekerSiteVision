package siteseeker.web;

import java.io.Serializable;

import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

public class SearchPortletUtil implements Serializable {

  public static final long serialVersionUID = 1L;

  public String escapeXml(String s) {
    return StringEscapeUtils.escapeXml(s);
  }
  public String unescapeXml(String s) {
    return StringEscapeUtils.unescapeXml(s);
  }
  public String urlEncode(String s) {
    return URLEncoder.encode(s);
  }
  public String urlDecode(String s) {
    return URLDecoder.decode(s);
  }

}
