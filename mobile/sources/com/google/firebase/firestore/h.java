package com.google.firebase.firestore;

import android.content.Context;
import com.google.firebase.firestore.core.q;
import com.google.firebase.firestore.j;
import com.google.firebase.firestore.util.c;
import com.google.firebase.firestore.util.i;

public class h {
    private final Context a;

    /* renamed from: a  reason: collision with other field name */
    private volatile q f2259a;

    /* renamed from: a  reason: collision with other field name */
    private final a f2260a;

    /* renamed from: a  reason: collision with other field name */
    private j f2261a = new j.b().f();

    /* renamed from: a  reason: collision with other field name */
    private final q f2262a;

    /* renamed from: a  reason: collision with other field name */
    private final c f2263a;

    /* renamed from: a  reason: collision with other field name */
    private final gl f2264a;

    /* renamed from: a  reason: collision with other field name */
    private final gq f2265a;

    /* renamed from: a  reason: collision with other field name */
    private final String f2266a;

    /* renamed from: a  reason: collision with other field name */
    private final vd f2267a;

    /* renamed from: a  reason: collision with other field name */
    private final ve f2268a;

    public interface a {
    }

    public static h g() {
        gl app = gl.j();
        if (app != null) {
            return h(app, "(default)");
        }
        throw new IllegalStateException("You must call FirebaseApp.initializeApp first.");
    }

    private static h h(gl app, String database) {
        v90.o(app, "Provided FirebaseApp must not be null.");
        k component = (k) app.g(k.class);
        v90.o(component, "Firestore component is not present.");
        return component.a(database);
    }

    static h i(Context context, gl app, cu authProvider, String database, a instanceRegistry, gq metadataProvider) {
        vd provider;
        cu cuVar = authProvider;
        String projectId = app.m().e();
        if (projectId != null) {
            ve databaseId = ve.b(projectId, database);
            c queue = new c();
            if (cuVar == null) {
                i.a("FirebaseFirestore", "Firebase Auth not available, falling back to unauthenticated usage.", new Object[0]);
                provider = new hi();
            } else {
                provider = new ll(cuVar);
            }
            return new h(context, databaseId, app.l(), provider, queue, app, instanceRegistry, metadataProvider);
        }
        String str = database;
        throw new IllegalArgumentException("FirebaseOptions.getProjectId() cannot be null");
    }

    h(Context context, ve databaseId, String persistenceKey, vd credentialsProvider, c asyncQueue, gl firebaseApp, a instanceRegistry, gq metadataProvider) {
        this.a = (Context) v90.n(context);
        this.f2268a = (ve) v90.n((ve) v90.n(databaseId));
        this.f2262a = new q(databaseId);
        this.f2266a = (String) v90.n(persistenceKey);
        this.f2267a = (vd) v90.n(credentialsProvider);
        this.f2263a = (c) v90.n(asyncQueue);
        this.f2264a = firebaseApp;
        this.f2260a = instanceRegistry;
        this.f2265a = metadataProvider;
    }

    public j f() {
        return this.f2261a;
    }

    private void b() {
        if (this.f2259a == null) {
            synchronized (this.f2268a) {
                if (this.f2259a == null) {
                    this.f2259a = new q(this.a, new we(this.f2268a, this.f2266a, this.f2261a.c(), this.f2261a.e()), this.f2261a, this.f2267a, this.f2263a, this.f2265a);
                }
            }
        }
    }

    public a a(String collectionPath) {
        v90.o(collectionPath, "Provided collection path must not be null.");
        b();
        return new a(me0.t(collectionPath), this);
    }

    /* access modifiers changed from: package-private */
    public q c() {
        return this.f2259a;
    }

    /* access modifiers changed from: package-private */
    public ve e() {
        return this.f2268a;
    }

    /* access modifiers changed from: package-private */
    public q d() {
        return this.f2262a;
    }
}
