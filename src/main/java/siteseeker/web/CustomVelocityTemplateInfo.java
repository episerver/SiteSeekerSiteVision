package siteseeker.web;

import org.apache.commons.lang.StringUtils;

import org.apache.commons.logging.LogFactory;

public class CustomVelocityTemplateInfo {
  VelocityTemplateInfo defaultInfo;
  String customContent;
  boolean useCustom;

  public CustomVelocityTemplateInfo(VelocityTemplateInfo defaultInfo, 
                                    String customContent, 
                                    boolean useCustomContent) {
    this.defaultInfo = defaultInfo;
    this.customContent = customContent;
    this.useCustom = useCustomContent;
  }
  public String getName() {
    return defaultInfo.getName();
  }
  public String getPath() {
    return defaultInfo.getPath();
  }
  public String getDefaultContent() {
    return defaultInfo.getContent();
  }
  public String getContent() {
    if (useCustom && !StringUtils.isEmpty(customContent)) 
      return customContent;
    else 
      return defaultInfo.getContent();
  }
  public String getCustomContent() {
    return customContent;
  }
  public boolean getUseCustom() {
    return useCustom;
  }
  public boolean isCustomized() {
    if (StringUtils.isEmpty(customContent))
      return false;
    if (defaultInfo.getContent().equals(customContent))
      return false;
    return true;
  }
}

