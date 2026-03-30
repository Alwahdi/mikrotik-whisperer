package io.grpc;

import java.security.cert.Certificate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class h {
    private static final h a = new h();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public static final Logger f3267a = Logger.getLogger(h.class.getName());

    /* renamed from: a  reason: collision with other field name */
    private final ConcurrentMap<Long, gu<Object>> f3268a = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with other field name */
    private final ConcurrentNavigableMap<Long, gu<Object>> f3269a = new ConcurrentSkipListMap();
    private final ConcurrentMap<Long, gu<Object>> b = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with other field name */
    private final ConcurrentNavigableMap<Long, gu<Object>> f3270b = new ConcurrentSkipListMap();
    private final ConcurrentMap<Long, Object> c = new ConcurrentHashMap();

    public static h g() {
        return a;
    }

    public void e(gu<Object> subchannel) {
        b(this.f3268a, subchannel);
    }

    public void d(gu<Object> rootChannel) {
        b(this.f3270b, rootChannel);
    }

    public void c(gu<Object> socket) {
        b(this.b, socket);
    }

    public void k(gu<Object> subchannel) {
        h(this.f3268a, subchannel);
    }

    public void j(gu<Object> channel) {
        h(this.f3270b, channel);
    }

    public void i(gu<Object> socket) {
        h(this.b, socket);
    }

    private static <T extends gu<?>> void b(Map<Long, T> map, T object) {
        if (((gu) map.put(Long.valueOf(object.b().d()), object)) != null) {
            throw new AssertionError();
        }
    }

    private static <T extends gu<?>> void h(Map<Long, T> map, T object) {
        if (((gu) map.remove(Long.valueOf(f(object)))) == null) {
            throw new AssertionError();
        }
    }

    public static final class b {
        public final c a;

        public b(c tls) {
            this.a = (c) v90.n(tls);
        }
    }

    public static final class c {
        public final String a;

        /* renamed from: a  reason: collision with other field name */
        public final Certificate f3271a;
        public final Certificate b;

        public c(SSLSession session) {
            String cipherSuiteStandardName = session.getCipherSuite();
            Certificate localCert = null;
            Certificate remoteCert = null;
            Certificate[] localCerts = session.getLocalCertificates();
            localCert = localCerts != null ? localCerts[0] : localCert;
            try {
                Certificate[] peerCerts = session.getPeerCertificates();
                if (peerCerts != null) {
                    remoteCert = peerCerts[0];
                }
            } catch (SSLPeerUnverifiedException e) {
                h.f3267a.log(Level.FINE, String.format("Peer cert not available for peerHost=%s", new Object[]{session.getPeerHost()}), e);
            }
            this.a = cipherSuiteStandardName;
            this.f3271a = localCert;
            this.b = remoteCert;
        }
    }

    public static long f(ku withLogId) {
        return withLogId.b().d();
    }
}
