package org.apache.http.impl.auth;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.CharArrayBuffer;
import org.ietf.jgss.GSSContext;
import org.ietf.jgss.GSSManager;
import org.ietf.jgss.Oid;

public class NegotiateScheme extends AuthSchemeBase {
    private static final String KERBEROS_OID = "1.2.840.113554.1.2.2";
    private static final String SPNEGO_OID = "1.3.6.1.5.5.2";
    private GSSContext gssContext;
    private final Log log;
    private Oid negotiationOid;
    private final SpnegoTokenGenerator spengoGenerator;
    private State state;
    private final boolean stripPort;
    private byte[] token;

    enum State {
        UNINITIATED,
        CHALLENGE_RECEIVED,
        TOKEN_GENERATED,
        FAILED
    }

    public NegotiateScheme(SpnegoTokenGenerator spengoGenerator2, boolean stripPort2) {
        this.log = LogFactory.getLog(getClass());
        this.gssContext = null;
        this.negotiationOid = null;
        this.state = State.UNINITIATED;
        this.spengoGenerator = spengoGenerator2;
        this.stripPort = stripPort2;
    }

    public NegotiateScheme(SpnegoTokenGenerator spengoGenerator2) {
        this(spengoGenerator2, false);
    }

    public NegotiateScheme() {
        this((SpnegoTokenGenerator) null, false);
    }

    public boolean isComplete() {
        State state2 = this.state;
        return state2 == State.TOKEN_GENERATED || state2 == State.FAILED;
    }

    public String getSchemeName() {
        return "Negotiate";
    }

    @Deprecated
    public Header authenticate(Credentials credentials, HttpRequest request) throws AuthenticationException {
        return authenticate(credentials, request, (HttpContext) null);
    }

    /* access modifiers changed from: protected */
    public GSSManager getManager() {
        return GSSManager.getInstance();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x016f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0170, code lost:
        r12.state = org.apache.http.impl.auth.NegotiateScheme.State.FAILED;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x017d, code lost:
        throw new org.apache.http.auth.AuthenticationException(r0.getMessage());
     */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x016f A[ExcHandler: IOException (r0v4 'ex' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:5:0x000b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.http.Header authenticate(org.apache.http.auth.Credentials r13, org.apache.http.HttpRequest r14, org.apache.http.protocol.HttpContext r15) throws org.apache.http.auth.AuthenticationException {
        /*
            r12 = this;
            java.lang.String r0 = "HTTP@"
            if (r14 == 0) goto L_0x01e4
            org.apache.http.impl.auth.NegotiateScheme$State r1 = r12.state
            org.apache.http.impl.auth.NegotiateScheme$State r2 = org.apache.http.impl.auth.NegotiateScheme.State.CHALLENGE_RECEIVED
            if (r1 != r2) goto L_0x01dc
            r1 = 0
            boolean r2 = r12.isProxy()     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            if (r2 == 0) goto L_0x0015
            java.lang.String r2 = "http.proxy_host"
            r1 = r2
            goto L_0x0018
        L_0x0015:
            java.lang.String r2 = "http.target_host"
            r1 = r2
        L_0x0018:
            java.lang.Object r2 = r15.getAttribute(r1)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            org.apache.http.HttpHost r2 = (org.apache.http.HttpHost) r2     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            if (r2 == 0) goto L_0x0167
            boolean r3 = r12.stripPort     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            if (r3 != 0) goto L_0x002f
            int r3 = r2.getPort()     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            if (r3 <= 0) goto L_0x002f
            java.lang.String r3 = r2.toHostString()     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            goto L_0x0033
        L_0x002f:
            java.lang.String r3 = r2.getHostName()     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
        L_0x0033:
            org.apache.commons.logging.Log r4 = r12.log     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            boolean r4 = r4.isDebugEnabled()     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            if (r4 == 0) goto L_0x0051
            org.apache.commons.logging.Log r4 = r12.log     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            r5.<init>()     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            java.lang.String r6 = "init "
            r5.append(r6)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            r5.append(r3)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            java.lang.String r5 = r5.toString()     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            r4.debug(r5)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
        L_0x0051:
            org.ietf.jgss.Oid r4 = new org.ietf.jgss.Oid     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            java.lang.String r5 = "1.3.6.1.5.5.2"
            r4.<init>(r5)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            r12.negotiationOid = r4     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            r4 = 0
            r5 = 0
            r6 = 1
            r7 = 0
            org.ietf.jgss.GSSManager r8 = r12.getManager()     // Catch:{ GSSException -> 0x008e, IOException -> 0x016f }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ GSSException -> 0x008e, IOException -> 0x016f }
            r9.<init>()     // Catch:{ GSSException -> 0x008e, IOException -> 0x016f }
            r9.append(r0)     // Catch:{ GSSException -> 0x008e, IOException -> 0x016f }
            r9.append(r3)     // Catch:{ GSSException -> 0x008e, IOException -> 0x016f }
            java.lang.String r9 = r9.toString()     // Catch:{ GSSException -> 0x008e, IOException -> 0x016f }
            org.ietf.jgss.Oid r10 = org.ietf.jgss.GSSName.NT_HOSTBASED_SERVICE     // Catch:{ GSSException -> 0x008e, IOException -> 0x016f }
            org.ietf.jgss.GSSName r9 = r8.createName(r9, r10)     // Catch:{ GSSException -> 0x008e, IOException -> 0x016f }
            org.ietf.jgss.Oid r10 = r12.negotiationOid     // Catch:{ GSSException -> 0x008e, IOException -> 0x016f }
            org.ietf.jgss.GSSName r10 = r9.canonicalize(r10)     // Catch:{ GSSException -> 0x008e, IOException -> 0x016f }
            org.ietf.jgss.Oid r11 = r12.negotiationOid     // Catch:{ GSSException -> 0x008e, IOException -> 0x016f }
            org.ietf.jgss.GSSContext r10 = r8.createContext(r10, r11, r5, r7)     // Catch:{ GSSException -> 0x008e, IOException -> 0x016f }
            r12.gssContext = r10     // Catch:{ GSSException -> 0x008e, IOException -> 0x016f }
            r10.requestMutualAuth(r6)     // Catch:{ GSSException -> 0x008e, IOException -> 0x016f }
            org.ietf.jgss.GSSContext r10 = r12.gssContext     // Catch:{ GSSException -> 0x008e, IOException -> 0x016f }
            r10.requestCredDeleg(r6)     // Catch:{ GSSException -> 0x008e, IOException -> 0x016f }
            goto L_0x009e
        L_0x008e:
            r8 = move-exception
            int r9 = r8.getMajor()     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            r10 = 2
            if (r9 != r10) goto L_0x0165
            org.apache.commons.logging.Log r9 = r12.log     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            java.lang.String r10 = "GSSException BAD_MECH, retry with Kerberos MECH"
            r9.debug(r10)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            r4 = 1
        L_0x009e:
            java.lang.String r8 = "1.2.840.113554.1.2.2"
            if (r4 == 0) goto L_0x00df
            org.apache.commons.logging.Log r9 = r12.log     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            java.lang.String r10 = "Using Kerberos MECH 1.2.840.113554.1.2.2"
            r9.debug(r10)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            org.ietf.jgss.Oid r9 = new org.ietf.jgss.Oid     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            r9.<init>(r8)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            r12.negotiationOid = r9     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            org.ietf.jgss.GSSManager r9 = r12.getManager()     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            r10.<init>()     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            r10.append(r0)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            r10.append(r3)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            java.lang.String r0 = r10.toString()     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            org.ietf.jgss.Oid r10 = org.ietf.jgss.GSSName.NT_HOSTBASED_SERVICE     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            org.ietf.jgss.GSSName r0 = r9.createName(r0, r10)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            org.ietf.jgss.Oid r10 = r12.negotiationOid     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            org.ietf.jgss.GSSName r10 = r0.canonicalize(r10)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            org.ietf.jgss.Oid r11 = r12.negotiationOid     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            org.ietf.jgss.GSSContext r5 = r9.createContext(r10, r11, r5, r7)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            r12.gssContext = r5     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            r5.requestMutualAuth(r6)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            org.ietf.jgss.GSSContext r5 = r12.gssContext     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            r5.requestCredDeleg(r6)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
        L_0x00df:
            byte[] r0 = r12.token     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            if (r0 != 0) goto L_0x00e7
            byte[] r0 = new byte[r7]     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            r12.token = r0     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
        L_0x00e7:
            org.ietf.jgss.GSSContext r0 = r12.gssContext     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            byte[] r5 = r12.token     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            int r6 = r5.length     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            byte[] r0 = r0.initSecContext(r5, r7, r6)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            r12.token = r0     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            if (r0 == 0) goto L_0x0159
            org.apache.http.impl.auth.SpnegoTokenGenerator r0 = r12.spengoGenerator     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            if (r0 == 0) goto L_0x010e
            org.ietf.jgss.Oid r0 = r12.negotiationOid     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            java.lang.String r0 = r0.toString()     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            boolean r0 = r0.equals(r8)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            if (r0 == 0) goto L_0x010e
            org.apache.http.impl.auth.SpnegoTokenGenerator r0 = r12.spengoGenerator     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            byte[] r5 = r12.token     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            byte[] r0 = r0.generateSpnegoDERObject(r5)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            r12.token = r0     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
        L_0x010e:
            org.apache.http.impl.auth.NegotiateScheme$State r0 = org.apache.http.impl.auth.NegotiateScheme.State.TOKEN_GENERATED     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            r12.state = r0     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            java.lang.String r0 = new java.lang.String     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            byte[] r5 = r12.token     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            byte[] r5 = org.apache.commons.codec.binary.Base64.encodeBase64(r5, r7)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            r0.<init>(r5)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            org.apache.commons.logging.Log r5 = r12.log     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            boolean r5 = r5.isDebugEnabled()     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            if (r5 == 0) goto L_0x0140
            org.apache.commons.logging.Log r5 = r12.log     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            r6.<init>()     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            java.lang.String r7 = "Sending response '"
            r6.append(r7)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            r6.append(r0)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            java.lang.String r7 = "' back to the auth server"
            r6.append(r7)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            java.lang.String r6 = r6.toString()     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            r5.debug(r6)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
        L_0x0140:
            org.apache.http.message.BasicHeader r5 = new org.apache.http.message.BasicHeader     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            java.lang.String r6 = "Authorization"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            r7.<init>()     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            java.lang.String r8 = "Negotiate "
            r7.append(r8)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            r7.append(r0)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            java.lang.String r7 = r7.toString()     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            r5.<init>(r6, r7)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            return r5
        L_0x0159:
            org.apache.http.impl.auth.NegotiateScheme$State r0 = org.apache.http.impl.auth.NegotiateScheme.State.FAILED     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            r12.state = r0     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            org.apache.http.auth.AuthenticationException r0 = new org.apache.http.auth.AuthenticationException     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            java.lang.String r5 = "GSS security context initialization failed"
            r0.<init>(r5)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            throw r0     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
        L_0x0165:
            throw r8     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
        L_0x0167:
            org.apache.http.auth.AuthenticationException r0 = new org.apache.http.auth.AuthenticationException     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            java.lang.String r3 = "Authentication host is not set in the execution context"
            r0.<init>(r3)     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
            throw r0     // Catch:{ GSSException -> 0x017e, IOException -> 0x016f }
        L_0x016f:
            r0 = move-exception
            org.apache.http.impl.auth.NegotiateScheme$State r1 = org.apache.http.impl.auth.NegotiateScheme.State.FAILED
            r12.state = r1
            org.apache.http.auth.AuthenticationException r1 = new org.apache.http.auth.AuthenticationException
            java.lang.String r2 = r0.getMessage()
            r1.<init>(r2)
            throw r1
        L_0x017e:
            r0 = move-exception
            org.apache.http.impl.auth.NegotiateScheme$State r1 = org.apache.http.impl.auth.NegotiateScheme.State.FAILED
            r12.state = r1
            int r1 = r0.getMajor()
            r2 = 9
            if (r1 == r2) goto L_0x01d2
            int r1 = r0.getMajor()
            r2 = 8
            if (r1 == r2) goto L_0x01d2
            int r1 = r0.getMajor()
            r2 = 13
            if (r1 == r2) goto L_0x01c8
            int r1 = r0.getMajor()
            r2 = 10
            if (r1 == r2) goto L_0x01be
            int r1 = r0.getMajor()
            r2 = 19
            if (r1 == r2) goto L_0x01be
            int r1 = r0.getMajor()
            r2 = 20
            if (r1 != r2) goto L_0x01b4
            goto L_0x01be
        L_0x01b4:
            org.apache.http.auth.AuthenticationException r1 = new org.apache.http.auth.AuthenticationException
            java.lang.String r2 = r0.getMessage()
            r1.<init>(r2)
            throw r1
        L_0x01be:
            org.apache.http.auth.AuthenticationException r1 = new org.apache.http.auth.AuthenticationException
            java.lang.String r2 = r0.getMessage()
            r1.<init>(r2, r0)
            throw r1
        L_0x01c8:
            org.apache.http.auth.InvalidCredentialsException r1 = new org.apache.http.auth.InvalidCredentialsException
            java.lang.String r2 = r0.getMessage()
            r1.<init>(r2, r0)
            throw r1
        L_0x01d2:
            org.apache.http.auth.InvalidCredentialsException r1 = new org.apache.http.auth.InvalidCredentialsException
            java.lang.String r2 = r0.getMessage()
            r1.<init>(r2, r0)
            throw r1
        L_0x01dc:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Negotiation authentication process has not been initiated"
            r0.<init>(r1)
            throw r0
        L_0x01e4:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "HTTP request may not be null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.auth.NegotiateScheme.authenticate(org.apache.http.auth.Credentials, org.apache.http.HttpRequest, org.apache.http.protocol.HttpContext):org.apache.http.Header");
    }

    public String getParameter(String name) {
        if (name != null) {
            return null;
        }
        throw new IllegalArgumentException("Parameter name may not be null");
    }

    public String getRealm() {
        return null;
    }

    public boolean isConnectionBased() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void parseChallenge(CharArrayBuffer buffer, int beginIndex, int endIndex) throws MalformedChallengeException {
        String challenge = buffer.substringTrimmed(beginIndex, endIndex);
        if (this.log.isDebugEnabled()) {
            Log log2 = this.log;
            log2.debug("Received challenge '" + challenge + "' from the auth server");
        }
        if (this.state == State.UNINITIATED) {
            this.token = new Base64().decode(challenge.getBytes());
            this.state = State.CHALLENGE_RECEIVED;
            return;
        }
        this.log.debug("Authentication already attempted");
        this.state = State.FAILED;
    }
}
