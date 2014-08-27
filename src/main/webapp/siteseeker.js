
var ess_latestServerQuery = "undefined";
var ESS_SEARCH_BOX_UPDATE_DELAY = 150;
var ess_lastUpdate = 0;
var ess_lastSearchBoxUpdate = 0;

// Load style sheet for search form
function ess_loadStyleSheet() {
    if(document.createStyleSheet) {
        document.createStyleSheet('/siteseeker-search/siteseeker.css');
    } else {
        var styles = '/siteseeker-search/siteseeker.css';
        var newStyleSheet = document.createElement('link');
        newStyleSheet.rel = 'stylesheet';
        newStyleSheet.href = styles;
        document.getElementsByTagName("head")[0].appendChild(newStyleSheet);
    }
}

ess_loadStyleSheet();

function ess_showObject(id) {
    var obj = document.getElementById(id);
    obj.style.display = "block";
}
function ess_hideObject(id) {
    var obj = document.getElementById(id);
    obj.style.display = "none";
}

function ess_showAdvancedSearch() {
    var as = document.getElementById("as");
    if (as != null) as.value = "true";
    ess_onCategoryChange(true);
    return false;
}

function ess_escape(str) {
    if (encodeURIComponent) {
	str = encodeURIComponent(str);
    } else {
	str = escape(str);
    }
    return str;
}


function ess_deselectCategories(elements, name) {
  for (var i = 0; i < elements.length; i++) {
    if (elements[i].name == name) 
      elements[i].checked = false;
  }
}


// Register click - num is zero-indexed
function ess_registerClick(url, hitNumber, sessionId, portletId, uiLanguage, type) {
    if (!type) type = "0";
    var path = "/siteseeker-search/SiteSeekerAjaxServlet?as_rc=y"
	+ "&cm=" + type
	+ "&hn=" + hitNumber
	+ "&sid=" + sessionId
	+ "&si=" + portletId+uiLanguage
	+ "&hu=" + ess_escape(url);
    ess_ajaxCaller.get(path, null, function() { document.location.href = url; }, true, null);
    return false;
}

function ess_handleKeypress(e, url, hitNumber, sessionId, portletId, uiLanguage, type) {
  if (!type) type = "0";
  if (!e) e = window.event;
  key = e.keycode ? e.keycode : e.which;
  if (key == 13) 
    return ess_registerClick(url, hitNumber, sessionId, portletId, uiLanguage, type);
  return true;
}

// Activate click tracking
function ess_activateClickTracking(sessionId, portletId, uiLanguage) {
    var path = "/siteseeker-search/SiteSeekerAjaxServlet?as_rc=y"
	+ "&cm=" + "2";
    path += "&sid=" + sessionId;
    path += "&si=" + portletId + uiLanguage;
    ess_ajaxCaller.get(path, null, function() { return; }, true, null);
}

// Returns the current search query.
function ess_query() {
    return document.getElementById("search-word").value;
}

// Returns the number of milliseconds since midnight
function ess_currentTime() {
    var d = new Date();
    return (((d.getHours() * 60 + d.getMinutes()) * 60 + d.getSeconds()) * 1000) + d.getMilliseconds();
}


function ess_hasClass(obj, c) {
    return new RegExp('\\b'+c+'\\b').test(obj.className)
}

function ess_addClass(obj, c) {
    if(!ess_hasClass(obj, c)) {
	obj.className += obj.className ? ' '+c : c;
    }
}

function ess_removeClass(obj, c) {
      var rep = obj.className.match(' '+c) ? ' '+c : c;
      obj.className = obj.className.replace(rep,'');
    
}

// Replaces class c1 with c2 if c1 is a class of obj,
// otherwise it replaces c2 with c1
function ess_replaceClasses(obj, c1, c2) {
    if (ess_hasClass(obj, c1)) 
	obj.className = obj.className.replace(c1, c2);
    else 
	obj.className = obj.className.replace(c2, c1);
}

// Returns value of the first child node of the specified element,
// or null if no element matched the specified element name.
function ess_getElementValue(domObject, tagName) {
    var elem = domObject.getElementsByTagName(tagName);
    if (elem != null && elem.length != 0 && elem[0].hasChildNodes())  {
	return elem[0].childNodes[0].nodeValue;
    }
    return null;
}

var ess_ajaxCaller = {

  shouldDebug: false,
  shouldEscapeVars: false,
  shouldMakeHeaderMap: true,

  calls : new Array(),
  pendingResponseCount : 0,

   /**************************************************************************
      PUBLIC METHODS
   *************************************************************************/

  getXML: function(url, callbackFunction) {
    this.get(url, null, callbackFunction, true, null);
  },

  getPlainText: function(url, callbackFunction) {
    this.get(url, null, callbackFunction, false, null);
  },

  postForPlainText: function(url, vars, callbackFunction) {
    this.postVars(url, vars, null, callbackFunction, false,
                    null, "POST", null, null, null);
  },

  postForXML: function(url, vars, callbackFunction) {
    this.postVars(url, vars, null, callbackFunction, true,
                    null, "POST", null, null, null);
  },

  get: function(url, urlVars, callbackFunction, expectingXML, callingContext) {
	return this._callServer(url, urlVars, callbackFunction, expectingXML,
				callingContext, "GET", null, null, null);
  },

  postVars:
    function(url, bodyVars, optionalURLVars, callbackFunction, expectingXML,
             callingContext) {
      this._callServer(url, optionalURLVars, callbackFunction, expectingXML,
                      callingContext, "POST", bodyVars, null, null);
  },

  postBody:
    function(url, optionalURLVars, callbackFunction, expectingXML,
             callingContext, bodyType, body) {
      this._callServer(url, optionalURLVars, callbackFunction, expectingXML,
                      callingContext, "POST", null, bodyType, body);
  },

  putBody:
    function(url, optionalURLVars, callbackFunction, expectingXML,
             callingContext, bodyType, body) {
      this._callServer(url, optionalURLVars, callbackFunction, expectingXML,
                      callingContext, "PUT", null, bodyType, body);
  },

  options:
    function(url, optionalURLVars, callbackFunction, expectingXML,
             callingContext, bodyType, body) {
      this._callServer(url, optionalURLVars, callbackFunction, expectingXML,
                      callingContext, "OPTIONS", null, bodyType, body);
  },

  trace:
    function(url, optionalURLVars, callbackFunction, expectingXML,
             callingContext, bodyType, body) {
      this._debug("trace");
      this._callServer(url, optionalURLVars, callbackFunction, expectingXML,
                      callingContext, "TRACE", null, bodyType, body);
  },

  deleteIt: function(url, urlVars, callbackFunction,
                     expectingXML, callingContext) {
    this._callServer(url, urlVars, callbackFunction, expectingXML,
                    callingContext, "DELETE", null, null, null);
  },

  head: function(url, urlVars, callbackFunction, expectingXML, callingContext)
  {
    this._callServer(url, urlVars, callbackFunction, expectingXML,
                    callingContext, "HEAD", null, null, null);
  },

  /**************************************************************************
     PRIVATE METHODS
  *************************************************************************/

  _callServer: function(url, urlVars, callbackFunction, expectingXML,
                       callingContext, requestMethod, bodyVars,
                       explicitBodyType, explicitBody) {

    if (urlVars==null) {
      urlVars = new Array();
    }

    var xReq = this._createXMLHttpRequest();
    xReq.onreadystatechange = function() {
      ess_ajaxCaller._onResponseStateChange(call);
    }

    var call = {xReq: xReq,
                callbackFunction: callbackFunction,
                expectingXML: expectingXML,
                callingContext: callingContext,
                url: url};

    if (urlVars!=null) {
      var urlVarsString = this._createHTTPVarSpec(urlVars);
      if (urlVarsString.length > 0) { // TODO check if appending with & instead
        url += "?" + urlVarsString;
      }
    }

    xReq.open(requestMethod, url, true);
    if (   requestMethod=="GET"
        || requestMethod=="HEAD"
        || requestMethod=="DELETE") {
	//this._debug("Body-less request to URL " + url);
      xReq.send(null);
      return xReq;
    }
   
    if (   requestMethod=="POST"
        || requestMethod=="PUT"
        || requestMethod=="OPTIONS"
        || requestMethod=="TRACE") {
      bodyType = null;
      body = null;
      if (explicitBodyType==null) { // It's a form
        bodyType = 'application/x-www-form-urlencoded; charset=UTF-8';
        body = this._createHTTPVarSpec(bodyVars);
      } else {
        bodyType = explicitBodyType;
        body = explicitBody;
      }
      //      this._debug("Content-Type: [" + bodyType + "]\nBody: [" + body + "].");
      xReq.setRequestHeader('Content-Type',  bodyType);
      xReq.send(body);
      return xReq;
    }

    //    this._debug("ERROR: Unknown Request Method: " + requestMethod);


  },

  // The callback of xmlHttpRequest is a dynamically-generated function which
  // immediately calls this function.
  _onResponseStateChange: function(call) {

    xReq = call.xReq;

    if (xReq.readyState < 4) { //Still waiting
      return xReq;
    }

    if (xReq.readyState == 4) { //Transmit to actual callback
      callbackFunction = call.callbackFunction;
      if (!callbackFunction) { // Maybe still loading, e.g. in another JS file
        setTimeout(function() {
          _onResponseStateChange(call);
        }, 100);
      }
      var content = call.expectingXML ? xReq.responseXML : xReq.responseText;
      responseHeaders = xReq.getAllResponseHeaders();
      headersForCaller = this.shouldMakeHeaderMap ?
        this._createHeaderMap(responseHeaders) : responseHeaders;
      callbackFunction(content, headersForCaller, call.callingContext);
    }

    call = null; // Technically the responsibility of GC
    this.pendingResponseCount--;

  },

  // Browser-agnostic factory function
  _createXMLHttpRequest: function() {
    if (window.XMLHttpRequest) {
      return new XMLHttpRequest();
    } else if (window.ActiveXObject) {
      return new ActiveXObject('Microsoft.XMLHTTP')
    } else {
      _error("Could not create XMLHttpRequest on this browser");
      return null;
    }
  },

  _createHTTPVarSpec: function(vars) {
      var varsString = "";
      for( key in vars ) {
        var value = vars[key];
        if (this.shouldEscapeVars) {
          escapePlusRE =  new RegExp("\\\+");
          value = value.replace(escapePlusRE, "%2B");
        }
        varsString += '&' + key + '=' + value;
      }
      if (varsString.length > 0) {
        varsString = varsString.substring(1); // chomp initial '&'
      }
      //      this._debug("Built var String: " + varsString)
      return varsString;
   },

  /* Creates associative array from header type to header */
  _createHeaderMap: function(headersText) {
    extractedHeaders = headersText.split("\n");
    delete extractedHeaders[extractedHeaders.length]; // Del blank line at end
    headerMap = new Array();
    for (i=0; i<extractedHeaders.length-2; i++) {
      head = extractedHeaders[i];
      fieldNameEnding = head.indexOf(":");
      field = head.substring(0, fieldNameEnding);
      value = head.substring(fieldNameEnding + 2, head.length);
      value = value.replace(/\s$/, "");
      headerMap[field] = value;
    }
    return headerMap;
  },

  _error: function(message) {
      if (this.shouldDebug) {
        alert("AjaxJS ERROR:\n\n" + message);
      }
  }

};
