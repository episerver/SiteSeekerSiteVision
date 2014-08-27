/*
 * Copyright (C) Senselogic 2008, all rights reserved
 */
package siteseeker.web;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.GenericPortlet;
import java.io.IOException;

import senselogic.sitevision.api.Utils;
import senselogic.sitevision.api.security.PermissionUtil;

/**
 * Abstract base portlet for dispatching of the SiteVision config PortletMode to the doConfig method.
 * The config PortletMode is used by SiteVision when an editor doubleclicks on a portlet inside the editor.
 *
 */
public abstract class SiteVisionDispatcher extends GenericPortlet {

  protected static final String SITEVISION_CONFIG_PORTLET_MODE = "config";

  protected void doDispatch(RenderRequest aRenderRequest, RenderResponse aRenderResponse)
    throws PortletException, IOException {
    // Handle SiteVision custom portlet mode "config".
    if (SITEVISION_CONFIG_PORTLET_MODE.equals(aRenderRequest.getPortletMode().toString())) {
      doConfig(aRenderRequest, aRenderResponse);
    } else {
      super.doDispatch(aRenderRequest, aRenderResponse);
    }
  }

  /**
   * Checks if current user has write permission on current page (write permissions == permissions to write/update shared portlet preferences).
   *
   * Note! This method uses SiteVision Utility API functionality only available in SiteVision 2.6 and later.
   * If executed in previous versions (SiteVision 2.5 etc.) an AbstractMethodError or such will occur.
   *
   * @param aPortletRequest current request (RenderRequest or ActionRequest)
   * @return true if current user has write permissions on current page, false otherwise
   */
  protected final boolean hasWritePermission(PortletRequest aPortletRequest) {
    Utils siteVisionUtils = (Utils) aPortletRequest.getAttribute("sitevision.utils");
    PermissionUtil permissionUtil = siteVisionUtils.getPermissionUtil();
    return permissionUtil.hasWritePermission();
  }

  protected abstract void doConfig(RenderRequest aRenderRequest, RenderResponse aRenderResponse)
    throws PortletException, IOException;
}
