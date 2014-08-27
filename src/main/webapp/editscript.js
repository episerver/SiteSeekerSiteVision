var TabbablePanes = {
  panes: new Array('settings', 'templates'),
  defaultPane: 'settings',
  namespace: 'edit',
  
  init: function () {
    var pane;
    for (var i = 0; i < this.panes.length; i++) {
      var oT = document.getElementById(this.panes[i] + 'Tab');
      var oTA = oT.getElementsByTagName('a')[0]; // Själva länken
      pane = this.panes[i];
      //this.addEvent(oTA, 'click', function() { this.togglePanePersistent(); return false; } );
      // oTA.onclick = function () { TabbablePanes.togglePanePersistent(event); return false; };
      addEvent(oTA, 'click', function(event) { TabbablePanes.togglePanePersistent(event); return false; } );
      // oTA.setAttribute('onclick', 'TabbablePanes.togglePanePersistent(event); return false;')
    }
    this.setActivePane(false);
  },
  
  togglePanePersistent: function (e) {
    var targ;
    if (!e) var e = window.event;
    cancelEvent(e, true);
    
    if (e.target) targ = e.target;
    else if (e.srcElement) targ = e.srcElement;
    if (targ.nodeType == 3) { // defeat Safari bug
      targ = targ.parentNode;
    }
    
    var pane = targ.parentNode.id.replace('Tab', ''); // Hämta id från <li>-elementet, förälder till <a>-elementet
    this.createCookie('siteseeker-' + this.namespace + '-tab', pane, 10);

    this.iteratePanes(pane);
  },
  
  setActivePane: function (paneOverride) {
    var pane = false;
    if (paneOverride) {
      pane = paneOverride;
    } else {
      pane = this.readCookie('siteseeker-' + this.namespace + '-tab');
    }
    pane = this.isPaneValid(pane)?pane:this.defaultPane;

    this.iteratePanes(pane);
  },
  
  isPaneValid: function (pane) {
    for (var i = 0; i < this.panes.length; i++) {
      if (pane == this.panes[i]) {
        return true;
      }
    }
    return false;
  },
  
  iteratePanes: function (pane) {
    if (!pane) return;
    
    for (var i = 0; i < this.panes.length; i++) {
      o = document.getElementById(this.panes[i]);
      oT = document.getElementById(this.panes[i] + 'Tab');
      if (this.panes[i] == pane) {
        o.className = 'pane visible';
        oT.className = 'current';
      } else {
        o.className = 'pane';
        oT.className = '';
      }
    }
  },
  
  /*
  addEvent function from http://www.quirksmode.org/blog/archives/2005/10/_and_the_winner_1.html
  */
  /*
  addEvent: function (obj, type, fn) {
  	if (obj.addEventListener)
  		obj.addEventListener(type, fn, false);
  	else if (obj.attachEvent) {
  		obj["e"+type+fn] = fn;
  		obj[type+fn] = function() {obj["e"+type+fn]( window.event );}
  		obj.attachEvent("on"+type, obj[type+fn]);
  	}
  },
  */
  
  // Cookie functions found at http://www.quirksmode.org/js/cookies.html.
  // Since edited for readability
  createCookie: function(name, value, days) {
    if (days) {
      var date = new Date();
      date.setTime(date.getTime()+(days*24*60*60*1000));
      var expires = "; expires="+date.toGMTString();
    }
    else var expires = "";
    document.cookie = name+"="+value+expires+"; path=/";
  },

  readCookie: function (name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for(var i=0;i < ca.length;i++) {
      var c = ca[i];
      while (c.charAt(0)==' ') c = c.substring(1,c.length);
      if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
    }
    return false;
  },
  
  eraseCookie: function (name) {
    createCookie(name, "", -1);
  }
}


function activateTemplate(checkbox, templateId) {
  var o = document.getElementById(templateId);
  if (o) {
    if (checkbox.checked) {
      o.style.display = 'block';
      o.getElementsByTagName('textarea')[0].focus();
      document.getElementById('template-' + templateId).className = 'expanded';
    } else {
      o.style.display = 'none';
    }
  }
}

// Load style sheet for search form
function ess_loadStyleSheet() {
    if(document.createStyleSheet) {
        document.createStyleSheet('/siteseeker-search/editstyle.css');
    } else {
        var styles = '/siteseeker-search/editstyle.css';
        var newStyleSheet = document.createElement('link');
        newStyleSheet.rel = 'stylesheet';
        newStyleSheet.href = styles;
        document.getElementsByTagName("head")[0].appendChild(newStyleSheet);
    }
}

function revertTemplate(templateId, message) {
    if (confirm(message)) { 
        /*
        if (hasInnerText)
            document.getElementById(templateId + '-tmpl').value = document.getElementById('default-' + templateId).innerText;
        else
            document.getElementById(templateId + '-tmpl').value = document.getElementById('default-' + templateId).textContent;
        */
        document.getElementById(templateId + '-tmpl').value = document.getElementById(templateId + '-default').value;
        document.getElementById('revert-' + templateId).style.display = 'none';
    } 
}

function templateChanged(textarea, templateId) {
    if (textarea.value != textarea.defaultValue) 
        textarea.className = 'changed'; 
    else 
        textarea.className = '';
    //
    if (textarea.value != document.getElementById(templateId + '-default').value)
        document.getElementById('revert-' + templateId).style.display = 'block';
    else
        document.getElementById('revert-' + templateId).style.display = 'none';
}

/*
AddEvent Manager (c) 2005-2006 Angus Turnbull http://www.twinhelix.com
Free usage permitted as long as this credit notice remains intact.
*/

if (typeof addEvent != 'function')
{
 var addEvent = function(o, t, f, l)
 {
  var d = 'addEventListener', n = 'on' + t, rO = o, rT = t, rF = f, rL = l;
  if (o[d] && !l) return o[d](t, f, false);
  if (!o._evts) o._evts = {};
  if (!o._evts[t])
  {
   o._evts[t] = o[n] ? { b: o[n] } : {};
   o[n] = new Function('e',
    'var r = true, o = this, a = o._evts["' + t + '"], i; for (i in a) {' +
     'o._f = a[i]; r = o._f(e||window.event) != false && r; o._f = null;' +
     '} return r');
   if (t != 'unload') addEvent(window, 'unload', function() {
    removeEvent(rO, rT, rF, rL);
   });
  }
  if (!f._i) f._i = addEvent._i++;
  o._evts[t][f._i] = f;
 };
 addEvent._i = 1;
 var removeEvent = function(o, t, f, l)
 {
  var d = 'removeEventListener';
  if (o[d] && !l) return o[d](t, f, false);
  if (o._evts && o._evts[t] && f._i) delete o._evts[t][f._i];
 };
}

// Optional cancelEvent() function you can call within your event handlers to
// stop them performing the normal browser action or kill the event entirely.
// Pass an event object, and the second "c" parameter cancels event bubbling.
function cancelEvent(e, c)
{
  e.returnValue = false;
  if (e.preventDefault) e.preventDefault();
  if (c)
  {
    e.cancelBubble = true;
    if (e.stopPropagation) e.stopPropagation();
  }
};

function resizeDocumentTo(setw,seth) {
	return window.resizeTo(setw,seth),window.resizeTo(setw*2-((typeof window.innerWidth ==
	'undefined')?document.body.clientWidth:window.innerWidth),seth*2-((typeof window.innerHeight ==
	'undefined')?document.documentElement.clientHeight:window.innerHeight));
}

/*
JSTarget function by Roger Johansson, www.456bereastreet.com
*/
var JSTarget = {
 init: function(att,val,warning) {
    if (document.getElementById && document.createElement && document.appendChild) {
      var strAtt = ((typeof att == 'undefined') || (att == null)) ? 'class' : att;
      var strVal = ((typeof val == 'undefined') || (val == null)) ? 'non-html' : val;
      var strWarning = ((typeof warning == 'undefined') || (warning == null)) ? ' (opens in a new window)' : warning;
      var oWarning;
      var arrLinks = document.getElementsByTagName('a');
      var oLink;
      var oRegExp = new RegExp("(^|\\s)" + strVal + "(\\s|$)");
      for (var i = 0; i < arrLinks.length; i++) {
        oLink = arrLinks[i];
        if ((strAtt == 'class') && (oRegExp.test(oLink.className)) || (oRegExp.test(oLink.getAttribute(strAtt)))) {
          oWarning = document.createElement("em");
          oWarning.appendChild( document.createTextNode(strWarning) );
          oLink.appendChild(oWarning);
          oLink.onclick = JSTarget.openWin;
        }
        oWarning = null;
      }
    }
  },
 
 openWin: function(e) {
    var event = (!e) ? window.event : e;
    if (event.shiftKey || event.altKey || event.ctrlKey || event.metaKey) return true;
    else {
      var oWin = window.open(this.getAttribute('href'), '_blank');
      if (oWin) {
        if (oWin.focus) oWin.focus();
        return false;
      }
      oWin = null;
      return true;
    }
  }
};


var hasInnerText = false;
addEvent(window, 'load', function() { hasInnerText = (document.getElementsByTagName("body")[0].innerText != undefined)?true:false; } )
addEvent(window, 'load', function() { TabbablePanes.init(); });
addEvent(window, 'load', ess_loadStyleSheet);
addEvent(window, 'load', function () { if (/MSIE 6/i.test(navigator.userAgent)) return; var width; if (window.innerWidth) width = window.innerWidth; else width = document.body.clientWidth; resizeDocumentTo(width, 700); });
addEvent(window, 'load', function() { JSTarget.init("rel", "external", ""); });

