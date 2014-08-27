package siteseeker.web;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.lang.StringUtils;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.runtime.resource.loader.StringResourceLoader;
import org.apache.velocity.runtime.resource.util.StringResourceRepository;

import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletContext;
import javax.portlet.ReadOnlyException;

import javax.servlet.ServletContext;

import org.apache.velocity.runtime.resource.util.StringResourceRepository;
import org.apache.velocity.runtime.resource.loader.StringResourceLoader;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import org.apache.commons.lang.StringUtils;


public class VelocityTemplateManager {
    private static Map<String, InputStream> streamsByName = new ConcurrentHashMap<String, InputStream>();

  public static VelocityEngine getVelocityEngine(PortletContext context) {
    synchronized (context) {
      VelocityEngine engine = (VelocityEngine)context.getAttribute("velocityEngine");
      if (engine == null)  {
        engine = createVelocityEngine();
        context.setAttribute("velocityEngine", engine);
      }
      return engine;
    }
  }
  public static VelocityEngine getVelocityEngine(ServletContext context) {
    synchronized (context) {
      VelocityEngine engine = (VelocityEngine)context.getAttribute("velocityEngine");
      if (engine == null)  {
        engine = createVelocityEngine();
        context.setAttribute("velocityEngine", engine);
      }
      return engine;
    }
  }
  public static VelocityEngine createVelocityEngine() {
    try {
	    
      Properties p = new Properties();
      p.setProperty(VelocityEngine.RESOURCE_LOADER, "string");
      p.setProperty("string.resource.loader.class",
                    "org.apache.velocity.runtime.resource.loader.StringResourceLoader");
      p.setProperty(VelocityEngine.OUTPUT_ENCODING, "UTF-8");
      p.setProperty(VelocityEngine.INPUT_ENCODING, "UTF-8");
      p.setProperty("velocimacro.permissions.allow.inline.to.replace.global", "true");
      VelocityEngine engine = new VelocityEngine();
      engine.init(p);
      return engine;
    } catch (Exception e) {
      LogFactory.getLog(VelocityTemplateManager.class).error("Error: " + e);
    }
    return null;
  }

  public VelocityTemplateManager(VelocityEngine engine, 
                                 String mainTemplateName, 
                                 String mainTemplatePath) 
    throws IOException {
    velocityEngine = engine;
    templates = new ArrayList<VelocityTemplateInfo>();
    templates.add(MAIN_TEMPLATE_INDEX, createTemplateInfo(mainTemplateName, mainTemplatePath));
  }

  public void addTemplate(String name, String path) 
    throws IOException {
    templates.add(createTemplateInfo(name, path));
  }
  public static VelocityTemplateInfo createTemplateInfo(String name, String path) 
    throws IOException {
    VelocityTemplateInfo t = new VelocityTemplateInfo(name, path);
    t.setContent(getTemplateFromFile(path));
    return t;
  }

  public void updateCustomTemplateInfo(ActionRequest request, PortletPreferences preferences) 
    throws ReadOnlyException {
    // Get and validate the name of the template to update
    for (VelocityTemplateInfo tmpl : templates) { 
      // Get updated custom template
      String newTemplateContent = request.getParameter(tmpl.getName() + TMPL_SUFFIX);
      if (StringUtils.isNotEmpty(newTemplateContent)) {
        // LogFactory.getLog(getClass()).debug("tmpl-content: " + newTemplateContent);
        preferences.setValue(tmpl.getName() + TMPL_SUFFIX, newTemplateContent.replace("\r\n", "\n").replace("\r", "\n"));
      }
      // Should we use the custom template (or default)
      String useCustomTemplate = request.getParameter(tmpl.getName() + USE_CUSTOM_SUFFIX);
      if (StringUtils.isEmpty(useCustomTemplate)) {
        preferences.setValue(tmpl.getName() + USE_CUSTOM_SUFFIX, "");
      } else {
        preferences.setValue(tmpl.getName() + USE_CUSTOM_SUFFIX, "on");
      }
    }
  }

  public List<CustomVelocityTemplateInfo> getCustomTemplates(PortletPreferences preferences) {
    List<CustomVelocityTemplateInfo> customTemplates = new ArrayList<CustomVelocityTemplateInfo>();
    for (VelocityTemplateInfo tmpl : templates) {
      String customContent = preferences.getValue(tmpl.getName() + TMPL_SUFFIX, "");
      boolean useCustom = "on".equals(preferences.getValue(tmpl.getName() + USE_CUSTOM_SUFFIX, ""));
      customTemplates.add(new CustomVelocityTemplateInfo(tmpl, customContent, useCustom));
    }
    return customTemplates;
  }
 
  /**
   * Render velocity templates and print generated output to the
   * specified writer.
   *
   * @param preferences Use custom templates from portlet preferences
   * @param context Velocity context with data to be rendered
   * @param writer Generate output to writer
   */
  public void render(PortletPreferences preferences, VelocityContext context, Writer writer)
    throws IOException, ResourceNotFoundException, ParseErrorException {
    LogFactory.getLog(getClass()).debug("render START");
    StringResourceRepository repository = StringResourceLoader.getRepository();
    if (preferences != null) {
      for (CustomVelocityTemplateInfo tmpl : getCustomTemplates(preferences)) {
        repository.putStringResource(tmpl.getName(), tmpl.getContent());
      }
    } else {
      for (VelocityTemplateInfo tmpl : templates) {
        repository.putStringResource(tmpl.getName(), tmpl.getContent());
      }
    }
    try {
      Template t = velocityEngine.getTemplate(templates.get(MAIN_TEMPLATE_INDEX).getName());
      t.merge(context, writer);
    } catch (IOException e) {
      LogFactory.getLog(getClass()).error("Failed to merge template: " + e);
      throw e;
    } catch (Exception e) {
      LogFactory.getLog(getClass()).error("Error while initializing template: " + e);
      throw new RuntimeException(e);
    }
    LogFactory.getLog(getClass()).debug("render END");
  }
    
  private static final String TMPL_SUFFIX = "-tmpl";
  private static final String USE_CUSTOM_SUFFIX = "-use-custom";
  private static final int    MAIN_TEMPLATE_INDEX = 0;

  private final List<VelocityTemplateInfo> templates;
  private VelocityEngine velocityEngine;

  private static String getTemplateFromFile(String path) 
    throws IOException {
      InputStream in = getResourceAsStream(path);
      return SearchPortlet.getFileContent(in);
  }

    private static InputStream getResourceAsStream(String path) {
        InputStream inputStream = streamsByName.get(path);
        return inputStream!=null?inputStream:VelocityTemplateInfo.class.getClassLoader().getResourceAsStream(path);
    }

    public static void addStream(String name, InputStream stream) {
        streamsByName.put(name, stream);
    }

    private boolean templateNameExist(String tmplName) {
    if (!StringUtils.isEmpty(tmplName)) {
      for (VelocityTemplateInfo tmpl : templates) {
        if (tmpl.getName().equals(tmplName)) {
          return true;
        }
      }
    }
    return false;
  }
}