package siteseeker.web;

public class VelocityTemplateInfo {
    
  private String name;
  private String path;
  private String content;

  public VelocityTemplateInfo(String name, String path) {
    this.name = name;
    this.path = path;
  }
  public String getName() {
    return name;
  }
  public String getPath() {
    return path;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
}

