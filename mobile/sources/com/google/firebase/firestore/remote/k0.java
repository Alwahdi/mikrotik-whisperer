package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.model.mutation.MutationResult;
import com.google.firebase.firestore.util.c;
import com.google.firestore.v1.s;
import com.google.firestore.v1.t;
import com.google.protobuf.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class k0 extends b<s, t, a> {
    public static final e b = e.f2563a;
    private final a0 a;

    /* renamed from: a  reason: collision with other field name */
    private e f2349a = b;

    /* renamed from: a  reason: collision with other field name */
    protected boolean f2350a = false;

    public interface a extends jn0 {
        void c();

        void e(hm0 hm0, List<y20> list);
    }

    public /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    public /* bridge */ /* synthetic */ boolean k() {
        return super.k();
    }

    public /* bridge */ /* synthetic */ void r() {
        super.r();
    }

    k0(n channel, c workerQueue, a0 serializer, a listener) {
        super(channel, gm.b(), workerQueue, c.d.WRITE_STREAM_CONNECTION_BACKOFF, c.d.WRITE_STREAM_IDLE, listener);
        this.a = serializer;
    }

    public void q() {
        this.f2350a = false;
        super.q();
    }

    /* access modifiers changed from: protected */
    public void s() {
        if (this.f2350a) {
            z(Collections.emptyList());
        }
    }

    /* access modifiers changed from: package-private */
    public boolean v() {
        return this.f2350a;
    }

    /* access modifiers changed from: package-private */
    public e u() {
        return this.f2349a;
    }

    /* access modifiers changed from: package-private */
    public void x(e streamToken) {
        this.f2349a = (e) v90.n(streamToken);
    }

    /* access modifiers changed from: package-private */
    public void y() {
        n4.d(j(), "Writing handshake requires an opened stream", new Object[0]);
        n4.d(!this.f2350a, "Handshake already completed", new Object[0]);
        t((s) s.U().y(this.a.a()).q());
    }

    /* access modifiers changed from: package-private */
    public void z(List<u20> mutations) {
        n4.d(j(), "Writing mutations requires an opened stream", new Object[0]);
        n4.d(this.f2350a, "Handshake must be complete before writing mutations", new Object[0]);
        s.b request = s.U();
        for (u20 mutation : mutations) {
            request.x(this.a.Q(mutation));
        }
        request.z(this.f2349a);
        t((s) request.q());
    }

    /* renamed from: w */
    public void n(t response) {
        this.f2349a = response.O();
        if (!this.f2350a) {
            this.f2350a = true;
            ((a) this.f2310a).c();
            return;
        }
        this.f2307a.e();
        hm0 commitVersion = this.a.y(response.L());
        int count = response.Q();
        List<MutationResult> results = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            results.add(this.a.p(response.P(i), commitVersion));
        }
        ((a) this.f2310a).e(commitVersion, results);
    }
}
