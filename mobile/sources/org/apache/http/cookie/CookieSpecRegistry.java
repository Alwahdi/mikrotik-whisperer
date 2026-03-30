package org.apache.http.cookie;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.params.HttpParams;

@ThreadSafe
public final class CookieSpecRegistry {
    private final ConcurrentHashMap<String, CookieSpecFactory> registeredSpecs = new ConcurrentHashMap<>();

    public void register(String name, CookieSpecFactory factory) {
        if (name == null) {
            throw new IllegalArgumentException("Name may not be null");
        } else if (factory != null) {
            this.registeredSpecs.put(name.toLowerCase(Locale.ENGLISH), factory);
        } else {
            throw new IllegalArgumentException("Cookie spec factory may not be null");
        }
    }

    public void unregister(String id) {
        if (id != null) {
            this.registeredSpecs.remove(id.toLowerCase(Locale.ENGLISH));
            return;
        }
        throw new IllegalArgumentException("Id may not be null");
    }

    public CookieSpec getCookieSpec(String name, HttpParams params) throws IllegalStateException {
        if (name != null) {
            CookieSpecFactory factory = this.registeredSpecs.get(name.toLowerCase(Locale.ENGLISH));
            if (factory != null) {
                return factory.newInstance(params);
            }
            throw new IllegalStateException("Unsupported cookie spec: " + name);
        }
        throw new IllegalArgumentException("Name may not be null");
    }

    public CookieSpec getCookieSpec(String name) throws IllegalStateException {
        return getCookieSpec(name, (HttpParams) null);
    }

    public List<String> getSpecNames() {
        return new ArrayList(this.registeredSpecs.keySet());
    }

    public void setItems(Map<String, CookieSpecFactory> map) {
        if (map != null) {
            this.registeredSpecs.clear();
            this.registeredSpecs.putAll(map);
        }
    }
}
