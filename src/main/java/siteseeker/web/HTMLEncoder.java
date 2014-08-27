package siteseeker.web;

public class HTMLEncoder {
  public static final String encodeHTML(String s){
    StringBuffer sb = new StringBuffer();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      switch (c) {
      case '<': sb.append("&lt;"); break;
      case '>': sb.append("&gt;"); break;
      case '&': sb.append("&amp;"); break;
      case '"': sb.append("&quot;"); break;
        // be carefull with this one (non-breaking white space)
      case ' ': sb.append("&nbsp;");break;         
      default:  sb.append(c); break;
      }
    }
    return sb.toString();
  }
}