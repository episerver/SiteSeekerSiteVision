package siteseeker;

import siteseeker.web.RequestParameters;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleRequestParameters implements RequestParameters {
    private Map<String, String> valuesByName = new ConcurrentHashMap<String, String>();

    public String getValue(String name) {
        return valuesByName.get(name);
    }

    public String[] getValues(String name) {
        return new String[] {getValue(name)};
    }

    public Enumeration<String> getParameterNames() {
        final Iterator<String> keys = valuesByName.keySet().iterator();
        return new Enumeration<String>() {
            public boolean hasMoreElements() {
                return keys.hasNext();
            }

            public String nextElement() {
                return keys.next();
            }
        };
    }

    public void setParameter(String parameterName, String value) {
        valuesByName.put(parameterName, value);
    }

    public SimpleRequestParameters withQuery(String query) {
        return this;
    }
}
