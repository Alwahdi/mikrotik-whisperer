package org.apache.http.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.params.HttpParams;

@ThreadSafe
public final class AuthSchemeRegistry {
    private final ConcurrentHashMap<String, AuthSchemeFactory> registeredSchemes = new ConcurrentHashMap<>();

    public void register(String name, AuthSchemeFactory factory) {
        if (name == null) {
            throw new IllegalArgumentException("Name may not be null");
        } else if (factory != null) {
            this.registeredSchemes.put(name.toLowerCase(Locale.ENGLISH), factory);
        } else {
            throw new IllegalArgumentException("Authentication scheme factory may not be null");
        }
    }

    public void unregister(String name) {
        if (name != null) {
            this.registeredSchemes.remove(name.toLowerCase(Locale.ENGLISH));
            return;
        }
        throw new IllegalArgumentException("Name may not be null");
    }

    public AuthScheme getAuthScheme(String name, HttpParams params) throws IllegalStateException {
        if (name != null) {
            AuthSchemeFactory factory = this.registeredSchemes.get(name.toLowerCase(Locale.ENGLISH));
            if (factory != null) {
                return factory.newInstance(params);
            }
            throw new IllegalStateException("Unsupported authentication scheme: " + name);
        }
        throw new IllegalArgumentException("Name may not be null");
    }

    public List<String> getSchemeNames() {
        return new ArrayList(this.registeredSchemes.keySet());
    }

    public void setItems(Map<String, AuthSchemeFactory> map) {
        if (map != null) {
            this.registeredSchemes.clear();
            this.registeredSchemes.putAll(map);
        }
    }
}
