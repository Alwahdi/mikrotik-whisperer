package org.apache.http.impl.cookie;

import java.util.Locale;
import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieRestrictionViolationException;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

@Immutable
public class RFC2965DomainAttributeHandler implements CookieAttributeHandler {
    public void parse(SetCookie cookie, String domain) throws MalformedCookieException {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        } else if (domain == null) {
            throw new MalformedCookieException("Missing value for domain attribute");
        } else if (domain.trim().length() != 0) {
            String domain2 = domain.toLowerCase(Locale.ENGLISH);
            if (!domain2.startsWith(".")) {
                domain2 = '.' + domain2;
            }
            cookie.setDomain(domain2);
        } else {
            throw new MalformedCookieException("Blank value for domain attribute");
        }
    }

    public boolean domainMatch(String host, String domain) {
        return host.equals(domain) || (domain.startsWith(".") && host.endsWith(domain));
    }

    public void validate(Cookie cookie, CookieOrigin origin) throws MalformedCookieException {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        } else if (origin != null) {
            String host = origin.getHost();
            Locale locale = Locale.ENGLISH;
            String host2 = host.toLowerCase(locale);
            if (cookie.getDomain() != null) {
                String cookieDomain = cookie.getDomain().toLowerCase(locale);
                if (!(cookie instanceof ClientCookie) || !((ClientCookie) cookie).containsAttribute(ClientCookie.DOMAIN_ATTR)) {
                    if (!cookie.getDomain().equals(host2)) {
                        throw new CookieRestrictionViolationException("Illegal domain attribute: \"" + cookie.getDomain() + "\"." + "Domain of origin: \"" + host2 + "\"");
                    }
                } else if (cookieDomain.startsWith(".")) {
                    int dotIndex = cookieDomain.indexOf(46, 1);
                    if ((dotIndex < 0 || dotIndex == cookieDomain.length() - 1) && !cookieDomain.equals(".local")) {
                        throw new CookieRestrictionViolationException("Domain attribute \"" + cookie.getDomain() + "\" violates RFC 2965: the value contains no embedded dots " + "and the value is not .local");
                    } else if (!domainMatch(host2, cookieDomain)) {
                        throw new CookieRestrictionViolationException("Domain attribute \"" + cookie.getDomain() + "\" violates RFC 2965: effective host name does not " + "domain-match domain attribute.");
                    } else if (host2.substring(0, host2.length() - cookieDomain.length()).indexOf(46) != -1) {
                        throw new CookieRestrictionViolationException("Domain attribute \"" + cookie.getDomain() + "\" violates RFC 2965: " + "effective host minus domain may not contain any dots");
                    }
                } else {
                    throw new CookieRestrictionViolationException("Domain attribute \"" + cookie.getDomain() + "\" violates RFC 2109: domain must start with a dot");
                }
            } else {
                throw new CookieRestrictionViolationException("Invalid cookie state: domain not specified");
            }
        } else {
            throw new IllegalArgumentException("Cookie origin may not be null");
        }
    }

    public boolean match(Cookie cookie, CookieOrigin origin) {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        } else if (origin != null) {
            String host = origin.getHost().toLowerCase(Locale.ENGLISH);
            String cookieDomain = cookie.getDomain();
            if (domainMatch(host, cookieDomain) && host.substring(0, host.length() - cookieDomain.length()).indexOf(46) == -1) {
                return true;
            }
            return false;
        } else {
            throw new IllegalArgumentException("Cookie origin may not be null");
        }
    }
}
