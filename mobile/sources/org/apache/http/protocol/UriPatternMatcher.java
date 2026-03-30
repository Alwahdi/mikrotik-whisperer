package org.apache.http.protocol;

import java.util.HashMap;
import java.util.Map;

public class UriPatternMatcher {
    private final Map map = new HashMap();

    public synchronized void register(String pattern, Object obj) {
        if (pattern != null) {
            this.map.put(pattern, obj);
        } else {
            throw new IllegalArgumentException("URI request pattern may not be null");
        }
    }

    public synchronized void unregister(String pattern) {
        if (pattern != null) {
            this.map.remove(pattern);
        }
    }

    public synchronized void setHandlers(Map map2) {
        if (map2 != null) {
            this.map.clear();
            this.map.putAll(map2);
        } else {
            throw new IllegalArgumentException("Map of handlers may not be null");
        }
    }

    public synchronized void setObjects(Map map2) {
        if (map2 != null) {
            this.map.clear();
            this.map.putAll(map2);
        } else {
            throw new IllegalArgumentException("Map of handlers may not be null");
        }
    }

    public synchronized Object lookup(String requestURI) {
        Object obj;
        if (requestURI != null) {
            int index = requestURI.indexOf("?");
            if (index != -1) {
                requestURI = requestURI.substring(0, index);
            }
            obj = this.map.get(requestURI);
            if (obj == null) {
                String bestMatch = null;
                for (String pattern : this.map.keySet()) {
                    if (matchUriRequestPattern(pattern, requestURI) && (bestMatch == null || bestMatch.length() < pattern.length() || (bestMatch.length() == pattern.length() && pattern.endsWith("*")))) {
                        obj = this.map.get(pattern);
                        bestMatch = pattern;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Request URI may not be null");
        }
        return obj;
    }

    /* access modifiers changed from: protected */
    public boolean matchUriRequestPattern(String pattern, String requestUri) {
        if (pattern.equals("*")) {
            return true;
        }
        if (pattern.endsWith("*") && requestUri.startsWith(pattern.substring(0, pattern.length() - 1))) {
            return true;
        }
        if (!pattern.startsWith("*") || !requestUri.endsWith(pattern.substring(1, pattern.length()))) {
            return false;
        }
        return true;
    }
}
