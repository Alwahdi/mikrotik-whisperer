package org.apache.http.impl.cookie;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.client.utils.Punycode;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

public class PublicSuffixFilter implements CookieAttributeHandler {
    private Set<String> exceptions;
    private Set<String> suffixes;
    private final CookieAttributeHandler wrapped;

    public PublicSuffixFilter(CookieAttributeHandler wrapped2) {
        this.wrapped = wrapped2;
    }

    public void setPublicSuffixes(Collection<String> suffixes2) {
        this.suffixes = new HashSet(suffixes2);
    }

    public void setExceptions(Collection<String> exceptions2) {
        this.exceptions = new HashSet(exceptions2);
    }

    public boolean match(Cookie cookie, CookieOrigin origin) {
        if (isForPublicSuffix(cookie)) {
            return false;
        }
        return this.wrapped.match(cookie, origin);
    }

    public void parse(SetCookie cookie, String value) throws MalformedCookieException {
        this.wrapped.parse(cookie, value);
    }

    public void validate(Cookie cookie, CookieOrigin origin) throws MalformedCookieException {
        this.wrapped.validate(cookie, origin);
    }

    private boolean isForPublicSuffix(Cookie cookie) {
        String domain = cookie.getDomain();
        if (domain.startsWith(".")) {
            domain = domain.substring(1);
        }
        String domain2 = Punycode.toUnicode(domain);
        Set<String> set = this.exceptions;
        if ((set != null && set.contains(domain2)) || this.suffixes == null) {
            return false;
        }
        while (!this.suffixes.contains(domain2)) {
            if (domain2.startsWith("*.")) {
                domain2 = domain2.substring(2);
            }
            int nextdot = domain2.indexOf(46);
            if (nextdot != -1) {
                domain2 = "*" + domain2.substring(nextdot);
                if (domain2.length() <= 0) {
                }
            }
            return false;
        }
        return true;
    }
}
