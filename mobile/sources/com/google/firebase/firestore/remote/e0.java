package com.google.firebase.firestore.remote;

import com.google.firebase.database.collection.e;
import com.google.firebase.firestore.core.v;
import com.google.firebase.firestore.remote.h0;
import com.google.firebase.firestore.remote.i0;
import com.google.firebase.firestore.remote.j0;
import com.google.firebase.firestore.remote.k0;
import com.google.firebase.firestore.util.i;
import io.grpc.p;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e0 implements i0.b {
    private final c a;

    /* renamed from: a  reason: collision with other field name */
    private final h f2316a;

    /* renamed from: a  reason: collision with other field name */
    private i0 f2317a;

    /* renamed from: a  reason: collision with other field name */
    private final i f2318a;

    /* renamed from: a  reason: collision with other field name */
    private final j0 f2319a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final k0 f2320a;

    /* renamed from: a  reason: collision with other field name */
    private final y f2321a;

    /* renamed from: a  reason: collision with other field name */
    private final Deque<v20> f2322a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<Integer, bq0> f2323a;

    /* renamed from: a  reason: collision with other field name */
    private final ky f2324a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f2325a = false;

    public interface c {
        void a(v vVar);

        e<mh> b(int i);

        void c(ee0 ee0);

        void d(int i, p pVar);

        void e(int i, p pVar);

        void f(w20 w20);
    }

    public e0(c remoteStoreCallback, ky localStore, i datastore, com.google.firebase.firestore.util.c workerQueue, h connectivityMonitor) {
        this.a = remoteStoreCallback;
        this.f2324a = localStore;
        this.f2318a = datastore;
        this.f2316a = connectivityMonitor;
        this.f2323a = new HashMap();
        this.f2322a = new ArrayDeque();
        remoteStoreCallback.getClass();
        this.f2321a = new y(workerQueue, b0.b(remoteStoreCallback));
        this.f2319a = datastore.a(new a());
        this.f2320a = datastore.b(new b());
        connectivityMonitor.a(c0.a(this, workerQueue));
    }

    class a implements j0.a {
        a() {
        }

        public void b() {
            e0.this.t();
        }

        public void d(hm0 snapshotVersion, h0 watchChange) {
            e0.this.r(snapshotVersion, watchChange);
        }

        public void a(p status) {
            e0.this.s(status);
        }
    }

    class b implements k0.a {
        b() {
        }

        public void b() {
            e0.this.f2320a.y();
        }

        public void c() {
            e0.this.x();
        }

        public void e(hm0 commitVersion, List<y20> mutationResults) {
            e0.this.y(commitVersion, mutationResults);
        }

        public void a(p status) {
            e0.this.w(status);
        }
    }

    static /* synthetic */ void z(e0 e0Var) {
        if (e0Var.l()) {
            i.a("RemoteStore", "Restarting streams for network reachability change.", new Object[0]);
            e0Var.E();
        }
    }

    public void o() {
        this.f2325a = true;
        if (l()) {
            this.f2320a.x(this.f2324a.h());
            if (H()) {
                K();
            } else {
                this.f2321a.g(v.UNKNOWN);
            }
            p();
        }
    }

    private void n() {
        this.f2319a.r();
        this.f2320a.r();
        if (!this.f2322a.isEmpty()) {
            i.a("RemoteStore", "Stopping write stream with %d pending writes", Integer.valueOf(this.f2322a.size()));
            this.f2322a.clear();
        }
        m();
    }

    private void E() {
        this.f2325a = false;
        n();
        this.f2321a.g(v.UNKNOWN);
        o();
    }

    public void J() {
        o();
    }

    public void q() {
        if (l()) {
            i.a("RemoteStore", "Restarting streams for new credential.", new Object[0]);
            E();
        }
    }

    public void B(bq0 targetData) {
        Integer targetId = Integer.valueOf(targetData.g());
        if (!this.f2323a.containsKey(targetId)) {
            this.f2323a.put(targetId, targetData);
            if (H()) {
                K();
            } else if (this.f2319a.j()) {
                G(targetData);
            }
        }
    }

    private void G(bq0 targetData) {
        this.f2317a.l(targetData.g());
        this.f2319a.w(targetData);
    }

    public void M(int targetId) {
        n4.d(this.f2323a.remove(Integer.valueOf(targetId)) != null, "stopListening called on target no currently watched: %d", Integer.valueOf(targetId));
        if (this.f2319a.j()) {
            F(targetId);
        }
        if (!this.f2323a.isEmpty()) {
            return;
        }
        if (this.f2319a.j()) {
            this.f2319a.m();
        } else if (l()) {
            this.f2321a.g(v.UNKNOWN);
        }
    }

    private void F(int targetId) {
        this.f2317a.l(targetId);
        this.f2319a.v(targetId);
    }

    private boolean I() {
        return l() && !this.f2320a.k() && !this.f2322a.isEmpty();
    }

    private boolean H() {
        return l() && !this.f2319a.k() && !this.f2323a.isEmpty();
    }

    private void m() {
        this.f2317a = null;
    }

    private void K() {
        n4.d(H(), "startWatchStream() called when shouldStartWatchStream() is false.", new Object[0]);
        this.f2317a = new i0(this);
        this.f2319a.q();
        this.f2321a.c();
    }

    /* access modifiers changed from: private */
    public void t() {
        for (bq0 targetData : this.f2323a.values()) {
            G(targetData);
        }
    }

    /* access modifiers changed from: private */
    public void r(hm0 snapshotVersion, h0 watchChange) {
        this.f2321a.g(v.ONLINE);
        n4.d((this.f2319a == null || this.f2317a == null) ? false : true, "WatchStream and WatchStreamAggregator should both be non-null", new Object[0]);
        h0.d watchTargetChange = watchChange instanceof h0.d ? (h0.d) watchChange : null;
        if (watchTargetChange == null || !watchTargetChange.b().equals(h0.e.Removed) || watchTargetChange.a() == null) {
            if (watchChange instanceof h0.b) {
                this.f2317a.g((h0.b) watchChange);
            } else if (watchChange instanceof h0.c) {
                this.f2317a.h((h0.c) watchChange);
            } else {
                n4.d(watchChange instanceof h0.d, "Expected watchChange to be an instance of WatchTargetChange", new Object[0]);
                this.f2317a.i((h0.d) watchChange);
            }
            if (!snapshotVersion.equals(hm0.a) && snapshotVersion.compareTo(this.f2324a.g()) >= 0) {
                D(snapshotVersion);
                return;
            }
            return;
        }
        C(watchTargetChange);
    }

    /* access modifiers changed from: private */
    public void s(p status) {
        if (p.f3953a.equals(status)) {
            n4.d(!H(), "Watch stream was stopped gracefully while still needed.", new Object[0]);
        }
        m();
        if (H()) {
            this.f2321a.b(status);
            K();
            return;
        }
        this.f2321a.g(v.UNKNOWN);
    }

    public boolean l() {
        return this.f2325a;
    }

    private void D(hm0 snapshotVersion) {
        n4.d(!snapshotVersion.equals(hm0.a), "Can't raise event for unknown SnapshotVersion", new Object[0]);
        ee0 remoteEvent = this.f2317a.b(snapshotVersion);
        for (Map.Entry<Integer, TargetChange> entry : remoteEvent.d().entrySet()) {
            aq0 targetChange = (aq0) entry.getValue();
            if (!targetChange.e().isEmpty()) {
                int targetId = entry.getKey().intValue();
                bq0 targetData = this.f2323a.get(Integer.valueOf(targetId));
                if (targetData != null) {
                    this.f2323a.put(Integer.valueOf(targetId), targetData.i(targetChange.e(), snapshotVersion));
                }
            }
        }
        for (Integer intValue : remoteEvent.e()) {
            int targetId2 = intValue.intValue();
            bq0 targetData2 = this.f2323a.get(Integer.valueOf(targetId2));
            if (targetData2 != null) {
                this.f2323a.put(Integer.valueOf(targetId2), targetData2.i(com.google.protobuf.e.f2563a, targetData2.e()));
                F(targetId2);
                G(new bq0(targetData2.f(), targetId2, targetData2.d(), com.google.firebase.firestore.local.a.EXISTENCE_FILTER_MISMATCH));
            }
        }
        this.a.c(remoteEvent);
    }

    private void C(h0.d targetChange) {
        n4.d(targetChange.a() != null, "Processing target error without a cause", new Object[0]);
        for (Integer targetId : targetChange.d()) {
            if (this.f2323a.containsKey(targetId)) {
                this.f2323a.remove(targetId);
                this.f2317a.n(targetId.intValue());
                this.a.e(targetId.intValue(), targetChange.a());
            }
        }
    }

    public void p() {
        int lastBatchIdRetrieved = this.f2322a.isEmpty() ? -1 : this.f2322a.getLast().e();
        while (true) {
            if (!k()) {
                break;
            }
            v20 batch = this.f2324a.i(lastBatchIdRetrieved);
            if (batch != null) {
                j(batch);
                lastBatchIdRetrieved = batch.e();
            } else if (this.f2322a.size() == 0) {
                this.f2320a.m();
            }
        }
        if (I()) {
            L();
        }
    }

    private boolean k() {
        return l() && this.f2322a.size() < 10;
    }

    private void j(v20 mutationBatch) {
        n4.d(k(), "addToWritePipeline called when pipeline is full", new Object[0]);
        this.f2322a.add(mutationBatch);
        if (this.f2320a.j() && this.f2320a.v()) {
            this.f2320a.z(mutationBatch.h());
        }
    }

    private void L() {
        n4.d(I(), "startWriteStream() called when shouldStartWriteStream() is false.", new Object[0]);
        this.f2320a.q();
    }

    /* access modifiers changed from: private */
    public void x() {
        this.f2324a.z(this.f2320a.u());
        for (v20 batch : this.f2322a) {
            this.f2320a.z(batch.h());
        }
    }

    /* access modifiers changed from: private */
    public void y(hm0 commitVersion, List<y20> results) {
        this.a.f(w20.a(this.f2322a.poll(), commitVersion, results, this.f2320a.u()));
        p();
    }

    /* access modifiers changed from: private */
    public void w(p status) {
        if (p.f3953a.equals(status)) {
            n4.d(!I(), "Write stream was stopped gracefully while still needed.", new Object[0]);
        }
        if (!status.o() && !this.f2322a.isEmpty()) {
            if (this.f2320a.v()) {
                u(status);
            } else {
                v(status);
            }
        }
        if (I()) {
            L();
        }
    }

    private void v(p status) {
        n4.d(!status.o(), "Handling write error with status OK.", new Object[0]);
        if (i.e(status)) {
            i.a("RemoteStore", "RemoteStore error before completed handshake; resetting stream token %s: %s", qu0.m(this.f2320a.u()), status);
            k0 k0Var = this.f2320a;
            com.google.protobuf.e eVar = k0.b;
            k0Var.x(eVar);
            this.f2324a.z(eVar);
        }
    }

    private void u(p status) {
        n4.d(!status.o(), "Handling write error with status OK.", new Object[0]);
        if (i.f(status)) {
            this.f2320a.i();
            this.a.d(this.f2322a.poll().e(), status);
            p();
        }
    }

    public e<mh> b(int targetId) {
        return this.a.b(targetId);
    }

    public bq0 a(int targetId) {
        return this.f2323a.get(Integer.valueOf(targetId));
    }
}
