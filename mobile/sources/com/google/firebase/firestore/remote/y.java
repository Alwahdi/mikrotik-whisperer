package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.core.v;
import com.google.firebase.firestore.util.c;
import com.google.firebase.firestore.util.i;
import io.grpc.p;
import java.util.Locale;

class y {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private v f2375a = v.UNKNOWN;

    /* renamed from: a  reason: collision with other field name */
    private final a f2376a;

    /* renamed from: a  reason: collision with other field name */
    private c.b f2377a;

    /* renamed from: a  reason: collision with other field name */
    private final c f2378a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f2379a = true;

    interface a {
        void a(v vVar);
    }

    y(c workerQueue, a onlineStateCallback) {
        this.f2378a = workerQueue;
        this.f2376a = onlineStateCallback;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.a == 0) {
            f(v.UNKNOWN);
            n4.d(this.f2377a == null, "onlineStateTimer shouldn't be started yet", new Object[0]);
            this.f2377a = this.f2378a.f(c.d.ONLINE_STATE_TIMEOUT, 10000, x.a(this));
        }
    }

    static /* synthetic */ void d(y yVar) {
        yVar.f2377a = null;
        n4.d(yVar.f2375a == v.UNKNOWN, "Timer should be canceled if we transitioned to a different state.", new Object[0]);
        yVar.e(String.format(Locale.ENGLISH, "Backend didn't respond within %d seconds\n", new Object[]{10}));
        yVar.f(v.OFFLINE);
    }

    /* access modifiers changed from: package-private */
    public void b(p status) {
        boolean z = true;
        if (this.f2375a == v.ONLINE) {
            f(v.UNKNOWN);
            n4.d(this.a == 0, "watchStreamFailures must be 0", new Object[0]);
            if (this.f2377a != null) {
                z = false;
            }
            n4.d(z, "onlineStateTimer must be null", new Object[0]);
            return;
        }
        int i = this.a + 1;
        this.a = i;
        if (i >= 1) {
            a();
            e(String.format(Locale.ENGLISH, "Connection failed %d times. Most recent error: %s", new Object[]{1, status}));
            f(v.OFFLINE);
        }
    }

    /* access modifiers changed from: package-private */
    public void g(v newState) {
        a();
        this.a = 0;
        if (newState == v.ONLINE) {
            this.f2379a = false;
        }
        f(newState);
    }

    private void f(v newState) {
        if (newState != this.f2375a) {
            this.f2375a = newState;
            this.f2376a.a(newState);
        }
    }

    private void e(String reason) {
        String message = String.format("Could not reach Cloud Firestore backend. %s\nThis typically indicates that your device does not have a healthy Internet connection at the moment. The client will operate in offline mode until it is able to successfully connect to the backend.", new Object[]{reason});
        if (this.f2379a) {
            i.d("OnlineStateTracker", "%s", message);
            this.f2379a = false;
            return;
        }
        i.a("OnlineStateTracker", "%s", message);
    }

    private void a() {
        c.b bVar = this.f2377a;
        if (bVar != null) {
            bVar.c();
            this.f2377a = null;
        }
    }
}
