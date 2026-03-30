package org.apache.http.impl.cookie;

import java.util.List;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SM;
import org.apache.http.cookie.SetCookie2;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public class BestMatchSpec implements CookieSpec {
    private BrowserCompatSpec compat;
    private final String[] datepatterns;
    private RFC2109Spec obsoleteStrict;
    private final boolean oneHeader;
    private RFC2965Spec strict;

    public BestMatchSpec(String[] datepatterns2, boolean oneHeader2) {
        this.datepatterns = datepatterns2 == null ? null : (String[]) datepatterns2.clone();
        this.oneHeader = oneHeader2;
    }

    public BestMatchSpec() {
        this((String[]) null, false);
    }

    private RFC2965Spec getStrict() {
        if (this.strict == null) {
            this.strict = new RFC2965Spec(this.datepatterns, this.oneHeader);
        }
        return this.strict;
    }

    private RFC2109Spec getObsoleteStrict() {
        if (this.obsoleteStrict == null) {
            this.obsoleteStrict = new RFC2109Spec(this.datepatterns, this.oneHeader);
        }
        return this.obsoleteStrict;
    }

    private BrowserCompatSpec getCompat() {
        if (this.compat == null) {
            this.compat = new BrowserCompatSpec(this.datepatterns);
        }
        return this.compat;
    }

    public List<Cookie> parse(Header header, CookieOrigin origin) throws MalformedCookieException {
        ParserCursor cursor;
        CharArrayBuffer buffer;
        if (header == null) {
            throw new IllegalArgumentException("Header may not be null");
        } else if (origin != null) {
            HeaderElement[] helems = header.getElements();
            boolean versioned = false;
            boolean netscape = false;
            for (HeaderElement helem : helems) {
                if (helem.getParameterByName(ClientCookie.VERSION_ATTR) != null) {
                    versioned = true;
                }
                if (helem.getParameterByName(ClientCookie.EXPIRES_ATTR) != null) {
                    netscape = true;
                }
            }
            if (netscape || !versioned) {
                NetscapeDraftHeaderParser parser = NetscapeDraftHeaderParser.DEFAULT;
                if (header instanceof FormattedHeader) {
                    buffer = ((FormattedHeader) header).getBuffer();
                    cursor = new ParserCursor(((FormattedHeader) header).getValuePos(), buffer.length());
                } else {
                    String s = header.getValue();
                    if (s != null) {
                        CharArrayBuffer buffer2 = new CharArrayBuffer(s.length());
                        buffer2.append(s);
                        buffer = buffer2;
                        cursor = new ParserCursor(0, buffer2.length());
                    } else {
                        throw new MalformedCookieException("Header value is null");
                    }
                }
                return getCompat().parse(new HeaderElement[]{parser.parseHeader(buffer, cursor)}, origin);
            } else if (SM.SET_COOKIE2.equals(header.getName())) {
                return getStrict().parse(helems, origin);
            } else {
                return getObsoleteStrict().parse(helems, origin);
            }
        } else {
            throw new IllegalArgumentException("Cookie origin may not be null");
        }
    }

    public void validate(Cookie cookie, CookieOrigin origin) throws MalformedCookieException {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        } else if (origin == null) {
            throw new IllegalArgumentException("Cookie origin may not be null");
        } else if (cookie.getVersion() <= 0) {
            getCompat().validate(cookie, origin);
        } else if (cookie instanceof SetCookie2) {
            getStrict().validate(cookie, origin);
        } else {
            getObsoleteStrict().validate(cookie, origin);
        }
    }

    public boolean match(Cookie cookie, CookieOrigin origin) {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        } else if (origin == null) {
            throw new IllegalArgumentException("Cookie origin may not be null");
        } else if (cookie.getVersion() <= 0) {
            return getCompat().match(cookie, origin);
        } else {
            if (cookie instanceof SetCookie2) {
                return getStrict().match(cookie, origin);
            }
            return getObsoleteStrict().match(cookie, origin);
        }
    }

    public List<Header> formatCookies(List<Cookie> cookies) {
        if (cookies != null) {
            int version = Integer.MAX_VALUE;
            boolean isSetCookie2 = true;
            for (Cookie cookie : cookies) {
                if (!(cookie instanceof SetCookie2)) {
                    isSetCookie2 = false;
                }
                if (cookie.getVersion() < version) {
                    version = cookie.getVersion();
                }
            }
            if (version <= 0) {
                return getCompat().formatCookies(cookies);
            }
            if (isSetCookie2) {
                return getStrict().formatCookies(cookies);
            }
            return getObsoleteStrict().formatCookies(cookies);
        }
        throw new IllegalArgumentException("List of cookies may not be null");
    }

    public int getVersion() {
        return getStrict().getVersion();
    }

    public Header getVersionHeader() {
        return getStrict().getVersionHeader();
    }

    public String toString() {
        return CookiePolicy.BEST_MATCH;
    }
}
