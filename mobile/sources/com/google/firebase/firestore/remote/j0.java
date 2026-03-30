package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.util.c;
import com.google.firestore.v1.j;
import com.google.firestore.v1.k;
import com.google.protobuf.e;
import java.util.Map;

public class j0 extends b<j, k, a> {
    public static final e a = e.f2563a;

    /* renamed from: a  reason: collision with other field name */
    private final a0 f2348a;

    interface a extends jn0 {
        void d(hm0 hm0, h0 h0Var);
    }

    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    public /* bridge */ /* synthetic */ boolean k() {
        return super.k();
    }

    public /* bridge */ /* synthetic */ void q() {
        super.q();
    }

    public /* bridge */ /* synthetic */ void r() {
        super.r();
    }

    j0(n channel, c workerQueue, a0 serializer, a listener) {
        super(channel, gm.a(), workerQueue, c.d.LISTEN_STREAM_CONNECTION_BACKOFF, c.d.LISTEN_STREAM_IDLE, listener);
        this.f2348a = serializer;
    }

    public void w(bq0 targetData) {
        n4.d(j(), "Watching queries requires an open stream", new Object[0]);
        j.b request = j.V().z(this.f2348a.a()).y(this.f2348a.W(targetData));
        Map<String, String> labels = this.f2348a.O(targetData);
        if (labels != null) {
            request.x(labels);
        }
        t((j) request.q());
    }

    public void v(int targetId) {
        n4.d(j(), "Unwatching targets requires an open stream", new Object[0]);
        t((j) j.V().z(this.f2348a.a()).A(targetId).q());
    }

    /* renamed from: u */
    public void n(k listenResponse) {
        this.f2307a.e();
        h0 watchChange = this.f2348a.A(listenResponse);
        ((a) this.f2310a).d(this.f2348a.z(listenResponse), watchChange);
    }
}
