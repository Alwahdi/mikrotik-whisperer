package org.apache.http.impl.auth;

import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.ContextAwareAuthScheme;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public abstract class AuthSchemeBase implements ContextAwareAuthScheme {
    private boolean proxy;

    /* access modifiers changed from: protected */
    public abstract void parseChallenge(CharArrayBuffer charArrayBuffer, int i, int i2) throws MalformedChallengeException;

    public void processChallenge(Header header) throws MalformedChallengeException {
        int pos;
        CharArrayBuffer buffer;
        if (header != null) {
            String authheader = header.getName();
            if (authheader.equalsIgnoreCase("WWW-Authenticate")) {
                this.proxy = false;
            } else if (authheader.equalsIgnoreCase("Proxy-Authenticate")) {
                this.proxy = true;
            } else {
                throw new MalformedChallengeException("Unexpected header name: " + authheader);
            }
            if (header instanceof FormattedHeader) {
                buffer = ((FormattedHeader) header).getBuffer();
                pos = ((FormattedHeader) header).getValuePos();
            } else {
                String s = header.getValue();
                if (s != null) {
                    CharArrayBuffer buffer2 = new CharArrayBuffer(s.length());
                    buffer2.append(s);
                    buffer = buffer2;
                    pos = 0;
                } else {
                    throw new MalformedChallengeException("Header value is null");
                }
            }
            while (pos < buffer.length() && HTTP.isWhitespace(buffer.charAt(pos))) {
                pos++;
            }
            int beginIndex = pos;
            while (pos < buffer.length() && !HTTP.isWhitespace(buffer.charAt(pos))) {
                pos++;
            }
            String s2 = buffer.substring(beginIndex, pos);
            if (s2.equalsIgnoreCase(getSchemeName())) {
                parseChallenge(buffer, pos, buffer.length());
                return;
            }
            throw new MalformedChallengeException("Invalid scheme identifier: " + s2);
        }
        throw new IllegalArgumentException("Header may not be null");
    }

    public Header authenticate(Credentials credentials, HttpRequest request, HttpContext context) throws AuthenticationException {
        return authenticate(credentials, request);
    }

    public boolean isProxy() {
        return this.proxy;
    }

    public String toString() {
        return getSchemeName();
    }
}
