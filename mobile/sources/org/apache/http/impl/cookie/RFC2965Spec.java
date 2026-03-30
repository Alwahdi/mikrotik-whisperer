package org.apache.http.impl.cookie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SM;
import org.apache.http.message.BufferedHeader;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public class RFC2965Spec extends RFC2109Spec {
    public RFC2965Spec() {
        this((String[]) null, false);
    }

    public RFC2965Spec(String[] datepatterns, boolean oneHeader) {
        super(datepatterns, oneHeader);
        registerAttribHandler(ClientCookie.DOMAIN_ATTR, new RFC2965DomainAttributeHandler());
        registerAttribHandler(ClientCookie.PORT_ATTR, new RFC2965PortAttributeHandler());
        registerAttribHandler(ClientCookie.COMMENTURL_ATTR, new RFC2965CommentUrlAttributeHandler());
        registerAttribHandler(ClientCookie.DISCARD_ATTR, new RFC2965DiscardAttributeHandler());
        registerAttribHandler(ClientCookie.VERSION_ATTR, new RFC2965VersionAttributeHandler());
    }

    public List<Cookie> parse(Header header, CookieOrigin origin) throws MalformedCookieException {
        if (header == null) {
            throw new IllegalArgumentException("Header may not be null");
        } else if (origin == null) {
            throw new IllegalArgumentException("Cookie origin may not be null");
        } else if (header.getName().equalsIgnoreCase(SM.SET_COOKIE2)) {
            return createCookies(header.getElements(), adjustEffectiveHost(origin));
        } else {
            throw new MalformedCookieException("Unrecognized cookie header '" + header.toString() + "'");
        }
    }

    /* access modifiers changed from: protected */
    public List<Cookie> parse(HeaderElement[] elems, CookieOrigin origin) throws MalformedCookieException {
        return createCookies(elems, adjustEffectiveHost(origin));
    }

    private List<Cookie> createCookies(HeaderElement[] elems, CookieOrigin origin) throws MalformedCookieException {
        HeaderElement[] arr$;
        List<Cookie> cookies = new ArrayList<>(elems.length);
        HeaderElement[] arr$2 = elems;
        int len$ = arr$2.length;
        int i$ = 0;
        while (i$ < len$) {
            HeaderElement headerelement = arr$2[i$];
            String name = headerelement.getName();
            String value = headerelement.getValue();
            if (name == null || name.length() == 0) {
                HeaderElement[] headerElementArr = arr$2;
                throw new MalformedCookieException("Cookie name may not be empty");
            }
            BasicClientCookie2 cookie = new BasicClientCookie2(name, value);
            cookie.setPath(CookieSpecBase.getDefaultPath(origin));
            cookie.setDomain(CookieSpecBase.getDefaultDomain(origin));
            cookie.setPorts(new int[]{origin.getPort()});
            NameValuePair[] attribs = headerelement.getParameters();
            Map<String, NameValuePair> attribmap = new HashMap<>(attribs.length);
            for (int j = attribs.length - 1; j >= 0; j--) {
                NameValuePair param = attribs[j];
                attribmap.put(param.getName().toLowerCase(Locale.ENGLISH), param);
            }
            for (Map.Entry<String, NameValuePair> entry : attribmap.entrySet()) {
                NameValuePair attrib = entry.getValue();
                String s = attrib.getName().toLowerCase(Locale.ENGLISH);
                cookie.setAttribute(s, attrib.getValue());
                CookieAttributeHandler handler = findAttribHandler(s);
                if (handler != null) {
                    arr$ = arr$2;
                    handler.parse(cookie, attrib.getValue());
                } else {
                    arr$ = arr$2;
                }
                HeaderElement[] headerElementArr2 = elems;
                arr$2 = arr$;
            }
            HeaderElement[] headerElementArr3 = arr$2;
            cookies.add(cookie);
            i$++;
            HeaderElement[] headerElementArr4 = elems;
        }
        return cookies;
    }

    public void validate(Cookie cookie, CookieOrigin origin) throws MalformedCookieException {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        } else if (origin != null) {
            super.validate(cookie, adjustEffectiveHost(origin));
        } else {
            throw new IllegalArgumentException("Cookie origin may not be null");
        }
    }

    public boolean match(Cookie cookie, CookieOrigin origin) {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        } else if (origin != null) {
            return super.match(cookie, adjustEffectiveHost(origin));
        } else {
            throw new IllegalArgumentException("Cookie origin may not be null");
        }
    }

    /* access modifiers changed from: protected */
    public void formatCookieAsVer(CharArrayBuffer buffer, Cookie cookie, int version) {
        String s;
        int[] ports;
        super.formatCookieAsVer(buffer, cookie, version);
        if ((cookie instanceof ClientCookie) && (s = ((ClientCookie) cookie).getAttribute(ClientCookie.PORT_ATTR)) != null) {
            buffer.append("; $Port");
            buffer.append("=\"");
            if (s.trim().length() > 0 && (ports = cookie.getPorts()) != null) {
                int len = ports.length;
                for (int i = 0; i < len; i++) {
                    if (i > 0) {
                        buffer.append(",");
                    }
                    buffer.append(Integer.toString(ports[i]));
                }
            }
            buffer.append("\"");
        }
    }

    private static CookieOrigin adjustEffectiveHost(CookieOrigin origin) {
        String host = origin.getHost();
        boolean isLocalHost = true;
        int i = 0;
        while (true) {
            if (i >= host.length()) {
                break;
            }
            char ch = host.charAt(i);
            if (ch == '.' || ch == ':') {
                isLocalHost = false;
            } else {
                i++;
            }
        }
        if (!isLocalHost) {
            return origin;
        }
        return new CookieOrigin(host + ".local", origin.getPort(), origin.getPath(), origin.isSecure());
    }

    public int getVersion() {
        return 1;
    }

    public Header getVersionHeader() {
        CharArrayBuffer buffer = new CharArrayBuffer(40);
        buffer.append(SM.COOKIE2);
        buffer.append(": ");
        buffer.append("$Version=");
        buffer.append(Integer.toString(getVersion()));
        return new BufferedHeader(buffer);
    }

    public String toString() {
        return CookiePolicy.RFC_2965;
    }
}
