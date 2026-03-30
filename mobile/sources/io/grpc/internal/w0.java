package io.grpc.internal;

import defpackage.m7;
import io.grpc.l;
import io.grpc.m;
import io.grpc.p;

final class w0 extends m7.a {
    private final p a;

    /* renamed from: a  reason: collision with other field name */
    v f3779a;

    /* renamed from: a  reason: collision with other field name */
    private final l f3780a;

    /* renamed from: a  reason: collision with other field name */
    private final m<?, ?> f3781a;

    /* renamed from: a  reason: collision with other field name */
    private final Object f3782a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private final n7 f3783a;

    /* renamed from: a  reason: collision with other field name */
    private final qc f3784a;

    /* renamed from: a  reason: collision with other field name */
    private z8 f3785a;

    /* renamed from: a  reason: collision with other field name */
    boolean f3786a;

    w0(p transport, m<?, ?> method, l origHeaders, n7 callOptions) {
        this.a = transport;
        this.f3781a = method;
        this.f3780a = origHeaders;
        this.f3783a = callOptions;
        this.f3784a = qc.e();
    }

    /* JADX INFO: finally extract failed */
    public void a(l headers) {
        v90.u(!this.f3786a, "apply() or fail() already called");
        v90.o(headers, "headers");
        this.f3780a.l(headers);
        qc origCtx = this.f3784a.b();
        try {
            z8 realStream = this.a.f(this.f3781a, this.f3780a, this.f3783a);
            this.f3784a.f(origCtx);
            c(realStream);
        } catch (Throwable th) {
            this.f3784a.f(origCtx);
            throw th;
        }
    }

    public void b(p status) {
        v90.e(!status.o(), "Cannot fail with OK status");
        v90.u(!this.f3786a, "apply() or fail() already called");
        c(new z(status));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        if (r3.f3779a == null) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        defpackage.v90.u(r1, "delayedStream is null");
        r3.f3779a.t(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(defpackage.z8 r4) {
        /*
            r3 = this;
            boolean r0 = r3.f3786a
            r1 = 1
            r0 = r0 ^ r1
            java.lang.String r2 = "already finalized"
            defpackage.v90.u(r0, r2)
            r3.f3786a = r1
            java.lang.Object r0 = r3.f3782a
            monitor-enter(r0)
            z8 r2 = r3.f3785a     // Catch:{ all -> 0x0028 }
            if (r2 != 0) goto L_0x0016
            r3.f3785a = r4     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return
        L_0x0016:
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            io.grpc.internal.v r0 = r3.f3779a
            if (r0 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r1 = 0
        L_0x001d:
            java.lang.String r0 = "delayedStream is null"
            defpackage.v90.u(r1, r0)
            io.grpc.internal.v r0 = r3.f3779a
            r0.t(r4)
            return
        L_0x0028:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.w0.c(z8):void");
    }

    /* access modifiers changed from: package-private */
    public z8 d() {
        synchronized (this.f3782a) {
            z8 z8Var = this.f3785a;
            if (z8Var != null) {
                return z8Var;
            }
            v vVar = new v();
            this.f3779a = vVar;
            this.f3785a = vVar;
            return vVar;
        }
    }
}
