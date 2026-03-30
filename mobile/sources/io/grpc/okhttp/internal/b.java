package io.grpc.okhttp.internal;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class b {
    public static final b a;

    /* renamed from: a  reason: collision with other field name */
    private static final a[] f3927a;
    public static final b b;
    public static final b c = new C0048b(false).e();

    /* renamed from: a  reason: collision with other field name */
    final boolean f3928a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final String[] f3929a;

    /* renamed from: b  reason: collision with other field name */
    final boolean f3930b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public final String[] f3931b;

    static {
        a[] aVarArr = {a.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, a.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, a.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, a.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, a.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, a.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, a.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, a.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, a.TLS_DHE_DSS_WITH_AES_128_CBC_SHA, a.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, a.TLS_RSA_WITH_AES_128_GCM_SHA256, a.TLS_RSA_WITH_AES_128_CBC_SHA, a.TLS_RSA_WITH_AES_256_CBC_SHA, a.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        f3927a = aVarArr;
        C0048b f = new C0048b(true).f(aVarArr);
        e eVar = e.TLS_1_0;
        b e = f.i(e.TLS_1_2, e.TLS_1_1, eVar).h(true).e();
        a = e;
        b = new C0048b(e).i(eVar).h(true).e();
    }

    private b(C0048b builder) {
        this.f3928a = builder.a;
        this.f3929a = builder.f3932a;
        this.f3931b = builder.f3933b;
        this.f3930b = builder.b;
    }

    public List<a> d() {
        String[] strArr = this.f3929a;
        if (strArr == null) {
            return null;
        }
        a[] result = new a[strArr.length];
        int i = 0;
        while (true) {
            String[] strArr2 = this.f3929a;
            if (i >= strArr2.length) {
                return ru0.a(result);
            }
            result[i] = a.forJavaName(strArr2[i]);
            i++;
        }
    }

    public List<e> g() {
        e[] result = new e[this.f3931b.length];
        int i = 0;
        while (true) {
            String[] strArr = this.f3931b;
            if (i >= strArr.length) {
                return ru0.a(result);
            }
            result[i] = e.forJavaName(strArr[i]);
            i++;
        }
    }

    public boolean f() {
        return this.f3930b;
    }

    public void c(SSLSocket sslSocket, boolean isFallback) {
        b specToApply = e(sslSocket, isFallback);
        sslSocket.setEnabledProtocols(specToApply.f3931b);
        String[] cipherSuitesToEnable = specToApply.f3929a;
        if (cipherSuitesToEnable != null) {
            sslSocket.setEnabledCipherSuites(cipherSuitesToEnable);
        }
    }

    /* JADX WARNING: type inference failed for: r3v9, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private io.grpc.okhttp.internal.b e(javax.net.ssl.SSLSocket r10, boolean r11) {
        /*
            r9 = this;
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r1 = 0
            java.lang.String[] r2 = r9.f3929a
            if (r2 == 0) goto L_0x0014
            java.lang.String[] r2 = r10.getEnabledCipherSuites()
            java.lang.String[] r3 = r9.f3929a
            java.lang.Object[] r3 = defpackage.ru0.c(r0, r3, r2)
            r1 = r3
            java.lang.String[] r1 = (java.lang.String[]) r1
        L_0x0014:
            if (r11 == 0) goto L_0x0042
            java.lang.String r2 = "TLS_FALLBACK_SCSV"
            java.lang.String[] r3 = r10.getSupportedCipherSuites()
            java.util.List r3 = java.util.Arrays.asList(r3)
            java.lang.String r4 = "TLS_FALLBACK_SCSV"
            boolean r3 = r3.contains(r4)
            if (r3 == 0) goto L_0x0042
            if (r1 == 0) goto L_0x002d
            r5 = r1
            goto L_0x0031
        L_0x002d:
            java.lang.String[] r5 = r10.getEnabledCipherSuites()
        L_0x0031:
            int r6 = r5.length
            int r6 = r6 + 1
            java.lang.String[] r6 = new java.lang.String[r6]
            int r7 = r5.length
            r8 = 0
            java.lang.System.arraycopy(r5, r8, r6, r8, r7)
            int r7 = r6.length
            int r7 = r7 + -1
            r6[r7] = r4
            r1 = r6
        L_0x0042:
            java.lang.String[] r2 = r10.getEnabledProtocols()
            java.lang.String[] r3 = r9.f3931b
            java.lang.Object[] r0 = defpackage.ru0.c(r0, r3, r2)
            java.lang.String[] r0 = (java.lang.String[]) r0
            io.grpc.okhttp.internal.b$b r3 = new io.grpc.okhttp.internal.b$b
            r3.<init>((io.grpc.okhttp.internal.b) r9)
            io.grpc.okhttp.internal.b$b r3 = r3.g(r1)
            io.grpc.okhttp.internal.b$b r3 = r3.j(r0)
            io.grpc.okhttp.internal.b r3 = r3.e()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.internal.b.e(javax.net.ssl.SSLSocket, boolean):io.grpc.okhttp.internal.b");
    }

    public boolean equals(Object other) {
        if (!(other instanceof b)) {
            return false;
        }
        if (other == this) {
            return true;
        }
        b that = (b) other;
        boolean z = this.f3928a;
        if (z != that.f3928a) {
            return false;
        }
        if (!z || (Arrays.equals(this.f3929a, that.f3929a) && Arrays.equals(this.f3931b, that.f3931b) && this.f3930b == that.f3930b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f3928a) {
            return (((((17 * 31) + Arrays.hashCode(this.f3929a)) * 31) + Arrays.hashCode(this.f3931b)) * 31) + (this.f3930b ^ true ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f3928a) {
            return "ConnectionSpec()";
        }
        List<a> d = d();
        String cipherSuitesString = d == null ? "[use default]" : d.toString();
        return "ConnectionSpec(cipherSuites=" + cipherSuitesString + ", tlsVersions=" + g() + ", supportsTlsExtensions=" + this.f3930b + ")";
    }

    /* renamed from: io.grpc.okhttp.internal.b$b  reason: collision with other inner class name */
    public static final class C0048b {
        /* access modifiers changed from: private */
        public boolean a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public String[] f3932a;
        /* access modifiers changed from: private */
        public boolean b;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with other field name */
        public String[] f3933b;

        public C0048b(boolean tls) {
            this.a = tls;
        }

        public C0048b(b connectionSpec) {
            this.a = connectionSpec.f3928a;
            this.f3932a = connectionSpec.f3929a;
            this.f3933b = connectionSpec.f3931b;
            this.b = connectionSpec.f3930b;
        }

        public C0048b f(a... cipherSuites) {
            if (this.a) {
                String[] strings = new String[cipherSuites.length];
                for (int i = 0; i < cipherSuites.length; i++) {
                    strings[i] = cipherSuites[i].javaName;
                }
                this.f3932a = strings;
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public C0048b g(String... cipherSuites) {
            if (this.a) {
                if (cipherSuites == null) {
                    this.f3932a = null;
                } else {
                    this.f3932a = (String[]) cipherSuites.clone();
                }
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public C0048b i(e... tlsVersions) {
            if (!this.a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (tlsVersions.length != 0) {
                String[] strings = new String[tlsVersions.length];
                for (int i = 0; i < tlsVersions.length; i++) {
                    strings[i] = tlsVersions[i].javaName;
                }
                this.f3933b = strings;
                return this;
            } else {
                throw new IllegalArgumentException("At least one TlsVersion is required");
            }
        }

        public C0048b j(String... tlsVersions) {
            if (this.a) {
                if (tlsVersions == null) {
                    this.f3933b = null;
                } else {
                    this.f3933b = (String[]) tlsVersions.clone();
                }
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public C0048b h(boolean supportsTlsExtensions) {
            if (this.a) {
                this.b = supportsTlsExtensions;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public b e() {
            return new b(this);
        }
    }
}
