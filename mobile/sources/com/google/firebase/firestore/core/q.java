package com.google.firebase.firestore.core;

import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.collection.e;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.core.f;
import com.google.firebase.firestore.i;
import com.google.firebase.firestore.j;
import com.google.firebase.firestore.model.b;
import com.google.firebase.firestore.model.d;
import com.google.firebase.firestore.remote.a0;
import com.google.firebase.firestore.remote.e0;
import com.google.firebase.firestore.remote.g;
import com.google.firebase.firestore.remote.h;
import com.google.firebase.firestore.util.c;
import com.google.firebase.firestore.util.i;
import defpackage.iz;
import io.grpc.p;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

public final class q implements e0.c {
    private c90 a;

    /* renamed from: a  reason: collision with other field name */
    private a0 f2225a;

    /* renamed from: a  reason: collision with other field name */
    private f f2226a;

    /* renamed from: a  reason: collision with other field name */
    private e0 f2227a;

    /* renamed from: a  reason: collision with other field name */
    private final c f2228a;

    /* renamed from: a  reason: collision with other field name */
    private final gq f2229a;

    /* renamed from: a  reason: collision with other field name */
    private iz.d f2230a;

    /* renamed from: a  reason: collision with other field name */
    private ky f2231a;

    /* renamed from: a  reason: collision with other field name */
    private final vd f2232a;

    /* renamed from: a  reason: collision with other field name */
    private final we f2233a;

    public q(Context context, we databaseInfo, j settings, vd credentialsProvider, c asyncQueue, gq metadataProvider) {
        this.f2233a = databaseInfo;
        this.f2232a = credentialsProvider;
        this.f2228a = asyncQueue;
        this.f2229a = metadataProvider;
        TaskCompletionSource<User> firstUser = new gq0<>();
        AtomicBoolean initialized = new AtomicBoolean(false);
        asyncQueue.g(k.a(this, firstUser, context, settings));
        credentialsProvider.c(l.b(this, initialized, firstUser, asyncQueue));
    }

    static /* synthetic */ void m(q qVar, gq0 firstUser, Context context, j settings) {
        try {
            qVar.h(context, (yt0) lq0.a(firstUser.a()), settings.d(), settings.b());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    static /* synthetic */ void o(q qVar, AtomicBoolean initialized, gq0 firstUser, c asyncQueue, yt0 user) {
        if (initialized.compareAndSet(false, true)) {
            n4.d(true ^ firstUser.a().q(), "Already fulfilled first user task", new Object[0]);
            firstUser.c(user);
            return;
        }
        asyncQueue.g(j.a(qVar, user));
    }

    static /* synthetic */ void n(q qVar, yt0 user) {
        n4.d(qVar.f2225a != null, "SyncEngine not yet initialized", new Object[0]);
        i.a("FirestoreClient", "Credential changed. Current user: %s", user.a());
        qVar.f2225a.l(user);
    }

    public boolean i() {
        return this.f2228a.i();
    }

    public y r(x query, f.a options, bj<f0> listener) {
        t();
        y queryListener = new y(query, options, listener);
        this.f2228a.g(m.a(this, queryListener));
        return queryListener;
    }

    public void s(y listener) {
        if (!i()) {
            this.f2228a.g(n.a(this, listener));
        }
    }

    public eq0<b> g(mh docKey) {
        t();
        return this.f2228a.e(o.a(this, docKey)).i(p.b());
    }

    static /* synthetic */ b k(eq0 result) {
        com.google.firebase.firestore.model.c maybeDoc = (com.google.firebase.firestore.model.c) result.n();
        if (maybeDoc instanceof b) {
            return (b) maybeDoc;
        }
        if (maybeDoc instanceof d) {
            return null;
        }
        throw new com.google.firebase.firestore.i("Failed to get document from cache. (However, this document may exist on the server. Run again without setting source to CACHE to attempt to retrieve the document from the server.)", i.a.UNAVAILABLE);
    }

    public eq0<Void> u(List<u20> mutations) {
        t();
        TaskCompletionSource<Void> source = new gq0<>();
        this.f2228a.g(i.a(this, mutations, source));
        return source.a();
    }

    private void h(Context context, yt0 user, boolean usePersistence, long cacheSizeBytes) {
        com.google.firebase.firestore.util.i.a("FirestoreClient", "Initializing. user=%s", user.a());
        iz gc = null;
        if (usePersistence) {
            Context context2 = context;
            dh0 sqlitePersistence = new dh0(context2, this.f2233a.c(), this.f2233a.a(), new zx(new a0(this.f2233a.a())), iz.a.a(cacheSizeBytes));
            gc = sqlitePersistence.c().i();
            this.a = sqlitePersistence;
        } else {
            this.a = b10.j();
        }
        this.a.i();
        ky kyVar = new ky(this.a, new js(), user);
        this.f2231a = kyVar;
        if (gc != null) {
            iz.d i = gc.i(this.f2228a, kyVar);
            this.f2230a = i;
            i.c();
        }
        h connectivityMonitor = new g(context);
        ky kyVar2 = this.f2231a;
        this.f2227a = new e0(this, kyVar2, new com.google.firebase.firestore.remote.i(this.f2233a, this.f2228a, this.f2232a, context, this.f2229a), this.f2228a, connectivityMonitor);
        a0 a0Var = new a0(this.f2231a, this.f2227a, user);
        this.f2225a = a0Var;
        this.f2226a = new f(a0Var);
        this.f2231a.B();
        this.f2227a.J();
    }

    private void t() {
        if (i()) {
            throw new IllegalStateException("The client has already been terminated");
        }
    }

    public void c(ee0 remoteEvent) {
        this.f2225a.c(remoteEvent);
    }

    public void e(int targetId, p error) {
        this.f2225a.e(targetId, error);
    }

    public void f(w20 mutationBatchResult) {
        this.f2225a.f(mutationBatchResult);
    }

    public void d(int batchId, p error) {
        this.f2225a.d(batchId, error);
    }

    public void a(v onlineState) {
        this.f2225a.a(onlineState);
    }

    public e<mh> b(int targetId) {
        return this.f2225a.b(targetId);
    }
}
