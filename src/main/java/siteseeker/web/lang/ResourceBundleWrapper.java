package siteseeker.web.lang;

import java.util.ResourceBundle;
import java.util.Enumeration;

import org.apache.commons.logging.LogFactory;

import org.apache.commons.lang.StringUtils;

public class ResourceBundleWrapper {
  ResourceBundle bundle;
  public ResourceBundleWrapper(ResourceBundle bundle) {
    this.bundle = bundle;
  }
  public String get(String key) {
    try {
      return bundle.getString(key);
    } catch (java.util.MissingResourceException e) {
      LogFactory.getLog(getClass()).error("Failed to translate key: '" + key + 
          "'. Exception: " + e);
      return "";
    }
  }
  public Enumeration getKeys() {
    return bundle.getKeys();
  }
}
