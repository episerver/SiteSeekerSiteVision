package siteseeker.search;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;


public class WSConnectionInfo {

    private String url;
    private String username;
    private String password;
    public static final String HIDDEN_PASSWORD = "password";

    public WSConnectionInfo(String url, String username) {
	this(url, username, HIDDEN_PASSWORD);
    }
    public WSConnectionInfo(String url, String username, String password) {
	this.url = url.trim();
	this.username = username.trim();
	this.password = password;
    }
    public String getUrl() {
	return url;
    }
    public String getUsername() {
	return username;
    }
    public String getPassword() {
	return password;
    }
    public String toString() {
	return "Url: " + url + ", Username: "
	    + username + ", Password: " + password;
    }
}
