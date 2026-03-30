package com.google.firebase.firestore.remote;

import android.content.Context;
import com.google.firebase.firestore.util.c;
import com.google.firebase.firestore.util.i;
import defpackage.gm;
import io.grpc.ManagedChannelBuilder;
import io.grpc.b;
import io.grpc.e;
import io.grpc.m;
import java.util.concurrent.TimeUnit;

public class v {
    private static po0<sz<?>> a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f2368a;

    /* renamed from: a  reason: collision with other field name */
    private c.b f2369a;

    /* renamed from: a  reason: collision with other field name */
    private final c f2370a;

    /* renamed from: a  reason: collision with other field name */
    private eq0<rz> f2371a;

    /* renamed from: a  reason: collision with other field name */
    private final m7 f2372a;

    /* renamed from: a  reason: collision with other field name */
    private n7 f2373a;

    /* renamed from: a  reason: collision with other field name */
    private final we f2374a;

    v(c asyncQueue, Context context, we databaseInfo, m7 firestoreHeaders) {
        this.f2370a = asyncQueue;
        this.f2368a = context;
        this.f2374a = databaseInfo;
        this.f2372a = firestoreHeaders;
        d();
    }

    private rz c(Context context, we databaseInfo) {
        ManagedChannelBuilder<?> channelBuilder;
        try {
            nb0.a(context);
        } catch (IllegalStateException | xp | yp e) {
            i.d("GrpcCallProvider", "Failed to update ssl context: %s", e);
        }
        po0<sz<?>> po0 = a;
        if (po0 != null) {
            channelBuilder = (sz) po0.get();
        } else {
            channelBuilder = sz.b(databaseInfo.b());
            if (!databaseInfo.d()) {
                channelBuilder.d();
            }
        }
        channelBuilder.c(30, TimeUnit.SECONDS);
        return b3.k(channelBuilder).i(context).a();
    }

    /* access modifiers changed from: package-private */
    public <ReqT, RespT> eq0<b<ReqT, RespT>> b(m<ReqT, RespT> methodDescriptor) {
        return this.f2371a.l(this.f2370a.h(), p.b(this, methodDescriptor));
    }

    /* access modifiers changed from: private */
    public void k(rz channel) {
        e newState = channel.j(true);
        i.a("GrpcCallProvider", "Current gRPC connectivity state: " + newState, new Object[0]);
        a();
        if (newState == e.CONNECTING) {
            i.a("GrpcCallProvider", "Setting the connectivityAttemptTimer", new Object[0]);
            this.f2369a = this.f2370a.f(c.d.CONNECTIVITY_ATTEMPT_TIMER, 15000, q.a(this, channel));
        }
        channel.k(newState, r.a(this, channel));
    }

    static /* synthetic */ void g(v vVar, rz channel) {
        i.a("GrpcCallProvider", "connectivityAttemptTimer elapsed. Resetting the channel.", new Object[0]);
        vVar.a();
        vVar.l(channel);
    }

    private void l(rz channel) {
        this.f2370a.g(s.a(this, channel));
    }

    static /* synthetic */ void j(v vVar, rz channel) {
        channel.m();
        vVar.d();
    }

    private void d() {
        this.f2371a = lq0.c(xj.c, t.a(this));
    }

    static /* synthetic */ rz f(v vVar) {
        rz channel = vVar.c(vVar.f2368a, vVar.f2374a);
        vVar.k(channel);
        vVar.f2373a = ((gm.b) ((gm.b) gm.c(channel).c(vVar.f2372a)).d(vVar.f2370a.h())).b();
        i.a("GrpcCallProvider", "Channel successfully reset.", new Object[0]);
        return channel;
    }

    private void a() {
        if (this.f2369a != null) {
            i.a("GrpcCallProvider", "Clearing the connectivityAttemptTimer", new Object[0]);
            this.f2369a.c();
            this.f2369a = null;
        }
    }
}
