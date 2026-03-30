package org.apache.http.impl.auth;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.auth.params.AuthParams;
import org.apache.http.message.BasicHeaderValueFormatter;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.BufferedHeader;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EncodingUtils;

@NotThreadSafe
public class DigestScheme extends RFC2617Scheme {
    private static final char[] HEXADECIMAL = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final int QOP_AUTH = 2;
    private static final int QOP_AUTH_INT = 1;
    private static final int QOP_MISSING = 0;
    private static final int QOP_UNKNOWN = -1;
    private String a1;
    private String a2;
    private String cnonce;
    private boolean complete = false;
    private String lastNonce;
    private long nounceCount;

    public void processChallenge(Header header) throws MalformedChallengeException {
        super.processChallenge(header);
        if (getParameter("realm") == null) {
            throw new MalformedChallengeException("missing realm in challenge");
        } else if (getParameter("nonce") != null) {
            this.complete = true;
        } else {
            throw new MalformedChallengeException("missing nonce in challenge");
        }
    }

    public boolean isComplete() {
        if ("true".equalsIgnoreCase(getParameter("stale"))) {
            return false;
        }
        return this.complete;
    }

    public String getSchemeName() {
        return "digest";
    }

    public boolean isConnectionBased() {
        return false;
    }

    public void overrideParamter(String name, String value) {
        getParameters().put(name, value);
    }

    public Header authenticate(Credentials credentials, HttpRequest request) throws AuthenticationException {
        if (credentials == null) {
            throw new IllegalArgumentException("Credentials may not be null");
        } else if (request != null) {
            getParameters().put("methodname", request.getRequestLine().getMethod());
            getParameters().put("uri", request.getRequestLine().getUri());
            if (getParameter("charset") == null) {
                getParameters().put("charset", AuthParams.getCredentialCharset(request.getParams()));
            }
            return createDigestHeader(credentials);
        } else {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
    }

    private static MessageDigest createMessageDigest(String digAlg) throws UnsupportedDigestAlgorithmException {
        try {
            return MessageDigest.getInstance(digAlg);
        } catch (Exception e) {
            throw new UnsupportedDigestAlgorithmException("Unsupported algorithm in HTTP Digest authentication: " + digAlg);
        }
    }

    private Header createDigestHeader(Credentials credentials) throws AuthenticationException {
        String str;
        String variant;
        String method;
        MessageDigest digester;
        String algorithm;
        String uri;
        String digestValue;
        String digest;
        String str2;
        String uri2 = getParameter("uri");
        String realm = getParameter("realm");
        String nonce = getParameter("nonce");
        String opaque = getParameter("opaque");
        String method2 = getParameter("methodname");
        String algorithm2 = getParameter("algorithm");
        if (uri2 == null) {
            String algorithm3 = uri2;
            throw new IllegalStateException("URI may not be null");
        } else if (realm == null) {
            String algorithm4 = uri2;
            throw new IllegalStateException("Realm may not be null");
        } else if (nonce != null) {
            String qoplist = getParameter("qop");
            if (qoplist != null) {
                str = "opaque";
                StringTokenizer tok = new StringTokenizer(qoplist, ",");
                while (true) {
                    if (tok.hasMoreTokens()) {
                        if (tok.nextToken().trim().equals("auth")) {
                            variant = 2;
                            break;
                        }
                    } else {
                        variant = -1;
                        break;
                    }
                }
            } else {
                str = "opaque";
                variant = null;
            }
            if (variant != -1) {
                if (algorithm2 == null) {
                    algorithm2 = "MD5";
                }
                String charset = getParameter("charset");
                if (charset == null) {
                    charset = "ISO-8859-1";
                }
                String str3 = "auth";
                String str4 = qoplist;
                String digAlg = algorithm2;
                if (digAlg.equalsIgnoreCase("MD5-sess")) {
                    digAlg = "MD5";
                }
                String opaque2 = opaque;
                try {
                    MessageDigest digester2 = createMessageDigest(digAlg);
                    String uname = credentials.getUserPrincipal().getName();
                    String str5 = digAlg;
                    String pwd = credentials.getPassword();
                    String str6 = "algorithm";
                    String uri3 = uri2;
                    String str7 = "realm";
                    if (nonce.equals(this.lastNonce)) {
                        method = method2;
                        this.nounceCount++;
                    } else {
                        method = method2;
                        this.nounceCount = 1;
                        this.cnonce = null;
                        this.lastNonce = nonce;
                    }
                    StringBuilder sb = new StringBuilder(256);
                    Formatter formatter = new Formatter(sb, Locale.US);
                    formatter.format("%08x", new Object[]{Long.valueOf(this.nounceCount)});
                    String nc = sb.toString();
                    if (this.cnonce == null) {
                        this.cnonce = createCnonce();
                    }
                    this.a1 = null;
                    this.a2 = null;
                    if (algorithm2.equalsIgnoreCase("MD5-sess")) {
                        sb.setLength(0);
                        sb.append(uname);
                        sb.append(':');
                        sb.append(realm);
                        sb.append(':');
                        sb.append(pwd);
                        digester = digester2;
                        String checksum = encode(digester.digest(EncodingUtils.getBytes(sb.toString(), charset)));
                        Formatter formatter2 = formatter;
                        sb.setLength(0);
                        sb.append(checksum);
                        sb.append(':');
                        sb.append(nonce);
                        sb.append(':');
                        sb.append(this.cnonce);
                        this.a1 = sb.toString();
                    } else {
                        digester = digester2;
                        Formatter formatter3 = formatter;
                        sb.setLength(0);
                        sb.append(uname);
                        sb.append(':');
                        sb.append(realm);
                        sb.append(':');
                        sb.append(pwd);
                        this.a1 = sb.toString();
                    }
                    String hasha1 = encode(digester.digest(EncodingUtils.getBytes(this.a1, charset)));
                    if (variant == 2) {
                        StringBuilder sb2 = new StringBuilder();
                        String str8 = pwd;
                        String method3 = method;
                        sb2.append(method3);
                        algorithm = algorithm2;
                        sb2.append(':');
                        uri = uri3;
                        sb2.append(uri);
                        this.a2 = sb2.toString();
                        String str9 = method3;
                    } else {
                        String method4 = method;
                        algorithm = algorithm2;
                        uri = uri3;
                        if (variant != 1) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(method4);
                            String str10 = method4;
                            sb3.append(':');
                            sb3.append(uri);
                            this.a2 = sb3.toString();
                        } else {
                            throw new AuthenticationException("qop-int method is not suppported");
                        }
                    }
                    String hasha2 = encode(digester.digest(EncodingUtils.getBytes(this.a2, charset)));
                    if (variant == null) {
                        String str11 = charset;
                        sb.setLength(0);
                        sb.append(hasha1);
                        sb.append(':');
                        sb.append(nonce);
                        sb.append(':');
                        sb.append(hasha2);
                        digestValue = sb.toString();
                        String str12 = hasha1;
                    } else {
                        sb.setLength(0);
                        sb.append(hasha1);
                        sb.append(':');
                        sb.append(nonce);
                        sb.append(':');
                        sb.append(nc);
                        sb.append(':');
                        String str13 = hasha1;
                        sb.append(this.cnonce);
                        sb.append(':');
                        if (variant == 1) {
                            str2 = "auth-int";
                        } else {
                            str2 = str3;
                        }
                        sb.append(str2);
                        sb.append(':');
                        sb.append(hasha2);
                        digestValue = sb.toString();
                    }
                    String digest2 = encode(digester.digest(EncodingUtils.getAsciiBytes(digestValue)));
                    StringBuilder sb4 = sb;
                    String str14 = digestValue;
                    CharArrayBuffer buffer = new CharArrayBuffer(128);
                    if (isProxy()) {
                        buffer.append("Proxy-Authorization");
                    } else {
                        buffer.append("Authorization");
                    }
                    buffer.append(": Digest ");
                    String str15 = hasha2;
                    List<BasicNameValuePair> params = new ArrayList<>(20);
                    String str16 = "auth-int";
                    params.add(new BasicNameValuePair("username", uname));
                    params.add(new BasicNameValuePair(str7, realm));
                    params.add(new BasicNameValuePair("nonce", nonce));
                    params.add(new BasicNameValuePair("uri", uri));
                    params.add(new BasicNameValuePair("response", digest2));
                    String str17 = "nc";
                    if (variant != null) {
                        params.add(new BasicNameValuePair("qop", variant == 1 ? str16 : str3));
                        params.add(new BasicNameValuePair(str17, nc));
                        params.add(new BasicNameValuePair("cnonce", this.cnonce));
                    }
                    params.add(new BasicNameValuePair(str6, algorithm));
                    if (opaque2 != null) {
                        params.add(new BasicNameValuePair(str, opaque2));
                    }
                    int i = 0;
                    while (i < params.size()) {
                        BasicNameValuePair param = params.get(i);
                        if (i > 0) {
                            digest = digest2;
                            buffer.append(", ");
                        } else {
                            digest = digest2;
                        }
                        boolean noQuotes = str17.equals(param.getName()) || "qop".equals(param.getName());
                        String str18 = str17;
                        boolean z = noQuotes;
                        BasicHeaderValueFormatter.DEFAULT.formatNameValuePair(buffer, (NameValuePair) param, !noQuotes);
                        i++;
                        digest2 = digest;
                        str17 = str18;
                    }
                    return new BufferedHeader(buffer);
                } catch (UnsupportedDigestAlgorithmException e) {
                    String str19 = charset;
                    String str20 = method2;
                    String str21 = algorithm2;
                    String digAlg2 = digAlg;
                    String digAlg3 = opaque2;
                    String algorithm5 = uri2;
                    UnsupportedDigestAlgorithmException unsupportedDigestAlgorithmException = e;
                    throw new AuthenticationException("Unsuppported digest algorithm: " + digAlg2);
                }
            } else {
                String str22 = algorithm2;
                String algorithm6 = uri2;
                throw new AuthenticationException("None of the qop methods is supported: " + qoplist);
            }
        } else {
            String algorithm7 = uri2;
            throw new IllegalStateException("Nonce may not be null");
        }
    }

    /* access modifiers changed from: package-private */
    public String getCnonce() {
        return this.cnonce;
    }

    /* access modifiers changed from: package-private */
    public String getA1() {
        return this.a1;
    }

    /* access modifiers changed from: package-private */
    public String getA2() {
        return this.a2;
    }

    private static String encode(byte[] binaryData) {
        int n = binaryData.length;
        char[] buffer = new char[(n * 2)];
        for (int i = 0; i < n; i++) {
            char[] cArr = HEXADECIMAL;
            buffer[i * 2] = cArr[(binaryData[i] & 240) >> 4];
            buffer[(i * 2) + 1] = cArr[binaryData[i] & 15];
        }
        return new String(buffer);
    }

    public static String createCnonce() {
        byte[] tmp = new byte[8];
        new SecureRandom().nextBytes(tmp);
        return encode(tmp);
    }
}
