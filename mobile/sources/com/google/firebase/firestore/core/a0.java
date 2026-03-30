package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.database.collection.e;
import com.google.firebase.firestore.core.e0;
import com.google.firebase.firestore.core.f0;
import com.google.firebase.firestore.core.u;
import com.google.firebase.firestore.i;
import com.google.firebase.firestore.local.LocalViewChanges;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.d;
import com.google.firebase.firestore.remote.TargetChange;
import com.google.firebase.firestore.remote.e0;
import io.grpc.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a0 implements e0.c {
    private static final String a = a0.class.getSimpleName();

    /* renamed from: a  reason: collision with other field name */
    private c f2178a;

    /* renamed from: a  reason: collision with other field name */
    private final e0 f2179a;

    /* renamed from: a  reason: collision with other field name */
    private final cq0 f2180a = cq0.a();

    /* renamed from: a  reason: collision with other field name */
    private final Map<x, z> f2181a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    private final ky f2182a;

    /* renamed from: a  reason: collision with other field name */
    private final vd0 f2183a = new vd0();

    /* renamed from: a  reason: collision with other field name */
    private yt0 f2184a;
    private final Map<Integer, List<x>> b = new HashMap();
    private final Map<mh, Integer> c = new HashMap();
    private final Map<Integer, b> d = new HashMap();
    private final Map<yt0, Map<Integer, gq0<Void>>> e = new HashMap();
    private final Map<Integer, List<gq0<Void>>> f;

    interface c {
        void a(v vVar);

        void b(List<f0> list);

        void c(x xVar, p pVar);
    }

    private static class b {
        /* access modifiers changed from: private */
        public final mh a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public boolean f2185a;

        b(mh key) {
            this.a = key;
        }
    }

    public a0(ky localStore, e0 remoteStore, yt0 initialUser) {
        this.f2182a = localStore;
        this.f2179a = remoteStore;
        this.f2184a = initialUser;
        this.f = new HashMap();
    }

    public void t(c callback) {
        this.f2178a = callback;
    }

    private void h(String method) {
        n4.d(this.f2178a != null, "Trying to call %s before setting callback", method);
    }

    public int n(x query) {
        h("listen");
        n4.d(!this.f2181a.containsKey(query), "We already listen to query: %s", query);
        bq0 targetData = this.f2182a.b(query.z());
        this.f2178a.b(Collections.singletonList(m(query, targetData.g())));
        this.f2179a.B(targetData);
        return targetData.g();
    }

    private f0 m(x query, int targetId) {
        ub0 queryResult = this.f2182a.f(query, true);
        f0.a aVar = f0.a.NONE;
        aq0 synthesizedCurrentChange = null;
        if (this.b.get(Integer.valueOf(targetId)) != null) {
            synthesizedCurrentChange = aq0.a(this.f2181a.get((x) this.b.get(Integer.valueOf(targetId)).get(0)).c().i() == f0.a.SYNCED);
        }
        e0 view = new e0(query, queryResult.b());
        cv0 viewChange = view.b(view.f(queryResult.a()), synthesizedCurrentChange);
        n4.d(view.h().size() == 0, "View returned limbo docs before target ack from the server", new Object[0]);
        this.f2181a.put(query, new z(query, targetId, view));
        if (!this.b.containsKey(Integer.valueOf(targetId))) {
            this.b.put(Integer.valueOf(targetId), new ArrayList(1));
        }
        this.b.get(Integer.valueOf(targetId)).add(query);
        return viewChange.b();
    }

    /* access modifiers changed from: package-private */
    public void u(x query) {
        h("stopListening");
        z queryView = this.f2181a.get(query);
        n4.d(queryView != null, "Trying to stop listening to a query not found", new Object[0]);
        this.f2181a.remove(query);
        int targetId = queryView.b();
        List<Query> targetQueries = this.b.get(Integer.valueOf(targetId));
        targetQueries.remove(query);
        if (targetQueries.isEmpty()) {
            this.f2182a.y(targetId);
            this.f2179a.M(targetId);
            q(targetId, p.f3953a);
        }
    }

    public void x(List<u20> mutations, gq0<Void> userTask) {
        h("writeMutations");
        my result = this.f2182a.D(mutations);
        g(result.a(), userTask);
        i(result.b(), (ee0) null);
        this.f2179a.p();
    }

    private void g(int batchId, gq0<Void> userTask) {
        Map<Integer, TaskCompletionSource<Void>> userTasks = this.e.get(this.f2184a);
        if (userTasks == null) {
            userTasks = new HashMap<>();
            this.e.put(this.f2184a, userTasks);
        }
        userTasks.put(Integer.valueOf(batchId), userTask);
    }

    public void c(ee0 event) {
        h("handleRemoteEvent");
        for (Map.Entry<Integer, TargetChange> entry : event.d().entrySet()) {
            aq0 targetChange = (aq0) entry.getValue();
            b limboResolution = this.d.get(entry.getKey());
            if (limboResolution != null) {
                n4.d((targetChange.b().size() + targetChange.c().size()) + targetChange.d().size() <= 1, "Limbo resolution for single document contains multiple changes.", new Object[0]);
                if (targetChange.b().size() > 0) {
                    boolean unused = limboResolution.f2185a = true;
                } else if (targetChange.c().size() > 0) {
                    n4.d(limboResolution.f2185a, "Received change for limbo target document without add.", new Object[0]);
                } else if (targetChange.d().size() > 0) {
                    n4.d(limboResolution.f2185a, "Received remove for limbo target document without add.", new Object[0]);
                    boolean unused2 = limboResolution.f2185a = false;
                }
            }
        }
        i(this.f2182a.c(event), event);
    }

    public void a(v onlineState) {
        h("handleOnlineStateChange");
        ArrayList<ViewSnapshot> newViewSnapshots = new ArrayList<>();
        for (Map.Entry<x, z> entry : this.f2181a.entrySet()) {
            cv0 viewChange = ((z) entry.getValue()).c().c(onlineState);
            n4.d(viewChange.a().isEmpty(), "OnlineState should not affect limbo documents.", new Object[0]);
            if (viewChange.b() != null) {
                newViewSnapshots.add(viewChange.b());
            }
        }
        this.f2178a.b(newViewSnapshots);
        this.f2178a.a(onlineState);
    }

    public e<mh> b(int targetId) {
        b limboResolution = this.d.get(Integer.valueOf(targetId));
        if (limboResolution != null && limboResolution.f2185a) {
            return mh.d().c(limboResolution.a);
        }
        List<DocumentKey> remoteKeys = tx.f();
        if (this.b.containsKey(Integer.valueOf(targetId))) {
            for (x query : this.b.get(Integer.valueOf(targetId))) {
                if (this.f2181a.containsKey(query)) {
                    remoteKeys.addAll(tx.g(this.f2181a.get(query).c().j()));
                }
            }
        }
        return new e<>(remoteKeys, mh.a());
    }

    public void e(int targetId, p error) {
        h("handleRejectedListen");
        b limboResolution = this.d.get(Integer.valueOf(targetId));
        mh limboKey = limboResolution != null ? limboResolution.a : null;
        if (limboKey != null) {
            this.c.remove(limboKey);
            this.d.remove(Integer.valueOf(targetId));
            hm0 hm0 = hm0.a;
            c(new ee0(hm0, Collections.emptyMap(), Collections.emptySet(), Collections.singletonMap(limboKey, new d(limboKey, hm0, false)), Collections.singleton(limboKey)));
            return;
        }
        this.f2182a.y(targetId);
        q(targetId, error);
    }

    public void f(w20 mutationBatchResult) {
        h("handleSuccessfulWrite");
        p(mutationBatchResult.b().e(), (p) null);
        s(mutationBatchResult.b().e());
        i(this.f2182a.a(mutationBatchResult), (ee0) null);
    }

    public void d(int batchId, p status) {
        h("handleRejectedWrite");
        ImmutableSortedMap<DocumentKey, MaybeDocument> changes = this.f2182a.x(batchId);
        if (!changes.isEmpty()) {
            o(status, "Write failed at %s", changes.f().h());
        }
        p(batchId, status);
        s(batchId);
        i(changes, (ee0) null);
    }

    private void s(int batchId) {
        if (this.f.containsKey(Integer.valueOf(batchId))) {
            Iterator it = this.f.get(Integer.valueOf(batchId)).iterator();
            while (it.hasNext()) {
                ((gq0) it.next()).c(null);
            }
            this.f.remove(Integer.valueOf(batchId));
        }
    }

    private void k() {
        for (Map.Entry<Integer, List<gq0<Void>>> entry : this.f.entrySet()) {
            for (TaskCompletionSource<Void> task : entry.getValue()) {
                task.b(new i("'waitForPendingWrites' task is cancelled due to User change.", i.a.CANCELLED));
            }
        }
        this.f.clear();
    }

    private void p(int batchId, p status) {
        Map<Integer, TaskCompletionSource<Void>> userTasks = this.e.get(this.f2184a);
        if (userTasks != null) {
            Integer boxedBatchId = Integer.valueOf(batchId);
            TaskCompletionSource<Void> userTask = (gq0) userTasks.get(boxedBatchId);
            if (userTask != null) {
                if (status != null) {
                    userTask.b(qu0.j(status));
                } else {
                    userTask.c(null);
                }
                userTasks.remove(boxedBatchId);
            }
        }
    }

    private void q(int targetId, p status) {
        for (x query : this.b.get(Integer.valueOf(targetId))) {
            this.f2181a.remove(query);
            if (!status.o()) {
                this.f2178a.c(query, status);
                o(status, "Listen for %s failed", query);
            }
        }
        this.b.remove(Integer.valueOf(targetId));
        ImmutableSortedSet<DocumentKey> limboKeys = this.f2183a.d(targetId);
        this.f2183a.h(targetId);
        Iterator<mh> it = limboKeys.iterator();
        while (it.hasNext()) {
            mh key = it.next();
            if (!this.f2183a.c(key)) {
                r(key);
            }
        }
    }

    private void r(mh key) {
        Integer targetId = this.c.get(key);
        if (targetId != null) {
            this.f2179a.M(targetId.intValue());
            this.c.remove(key);
            this.d.remove(targetId);
        }
    }

    private void i(com.google.firebase.database.collection.c<mh, com.google.firebase.firestore.model.c> changes, ee0 remoteEvent) {
        List<ViewSnapshot> newSnapshots = new ArrayList<>();
        List<LocalViewChanges> documentChangesInAllViews = new ArrayList<>();
        for (Map.Entry<x, z> entry : this.f2181a.entrySet()) {
            z queryView = (z) entry.getValue();
            e0 view = queryView.c();
            e0.b viewDocChanges = view.f(changes);
            if (viewDocChanges.b()) {
                viewDocChanges = view.g(this.f2182a.f(queryView.a(), false).a(), viewDocChanges);
            }
            cv0 viewChange = queryView.c().b(viewDocChanges, remoteEvent == null ? null : remoteEvent.d().get(Integer.valueOf(queryView.b())));
            w(viewChange.a(), queryView.b());
            if (viewChange.b() != null) {
                newSnapshots.add(viewChange.b());
                documentChangesInAllViews.add(ly.a(queryView.b(), viewChange.b()));
            }
        }
        this.f2178a.b(newSnapshots);
        this.f2182a.v(documentChangesInAllViews);
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[u.a.values().length];
            a = iArr;
            try {
                iArr[u.a.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[u.a.REMOVED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private void w(List<u> limboChanges, int targetId) {
        for (u limboChange : limboChanges) {
            switch (a.a[limboChange.b().ordinal()]) {
                case 1:
                    this.f2183a.a(limboChange.a(), targetId);
                    v(limboChange);
                    break;
                case 2:
                    com.google.firebase.firestore.util.i.a(a, "Document no longer in limbo: %s", limboChange.a());
                    mh limboDocKey = limboChange.a();
                    this.f2183a.e(limboDocKey, targetId);
                    if (this.f2183a.c(limboDocKey)) {
                        break;
                    } else {
                        r(limboDocKey);
                        break;
                    }
                default:
                    throw n4.a("Unknown limbo change type: %s", limboChange.b());
            }
        }
    }

    private void v(u change) {
        mh key = change.a();
        if (!this.c.containsKey(key)) {
            com.google.firebase.firestore.util.i.a(a, "New document in limbo: %s", key);
            int limboTargetId = this.f2180a.c();
            bq0 targetData = new bq0(x.b(key.h()).z(), limboTargetId, -1, com.google.firebase.firestore.local.a.LIMBO_RESOLUTION);
            this.d.put(Integer.valueOf(limboTargetId), new b(key));
            this.f2179a.B(targetData);
            this.c.put(key, Integer.valueOf(limboTargetId));
        }
    }

    public void l(yt0 user) {
        boolean userChanged = !this.f2184a.equals(user);
        this.f2184a = user;
        if (userChanged) {
            k();
            i(this.f2182a.k(user), (ee0) null);
        }
        this.f2179a.q();
    }

    private void o(p error, String contextString, Object... contextArgs) {
        if (j(error)) {
            com.google.firebase.firestore.util.i.d("Firestore", "%s: %s", String.format(contextString, contextArgs), error);
        }
    }

    private boolean j(p error) {
        p.b code = error.m();
        String description = error.n() != null ? error.n() : "";
        if ((code != p.b.FAILED_PRECONDITION || !description.contains("requires an index")) && code != p.b.PERMISSION_DENIED) {
            return false;
        }
        return true;
    }
}
