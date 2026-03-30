package com.google.firebase.firestore;

import android.app.Activity;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.core.AsyncEventListener;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.core.f;
import com.google.firebase.firestore.core.f0;
import com.google.firebase.firestore.core.x;
import com.google.firebase.firestore.i;
import com.google.firebase.firestore.model.b;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public class e {
    private final h a;

    /* renamed from: a  reason: collision with other field name */
    private final mh f2253a;

    e(mh key, h firestore) {
        this.f2253a = (mh) v90.n(key);
        this.a = firestore;
    }

    static e c(me0 path, h firestore) {
        if (path.n() % 2 == 0) {
            return new e(mh.e(path), firestore);
        }
        throw new IllegalArgumentException("Invalid document reference. Document references must have an even number of segments, but " + path.c() + " has " + path.n());
    }

    /* access modifiers changed from: package-private */
    public mh g() {
        return this.f2253a;
    }

    public h f() {
        return this.a;
    }

    public eq0<Void> l(Object data) {
        return m(data, n.a);
    }

    public eq0<Void> m(Object data, n options) {
        du0 parsed;
        v90.o(data, "Provided data must not be null.");
        v90.o(options, "Provided options must not be null.");
        if (options.b()) {
            parsed = this.a.d().e(data, options.a());
        } else {
            parsed = this.a.d().h(data);
        }
        return this.a.c().u(parsed.a(this.f2253a, u90.a)).j(xj.b, qu0.o());
    }

    public eq0<f> d() {
        return e(p.DEFAULT);
    }

    public eq0<f> e(p source) {
        if (source == p.CACHE) {
            return this.a.c().g(this.f2253a).j(xj.b, b.b(this));
        }
        return h(source);
    }

    static /* synthetic */ f j(e eVar, eq0 task) {
        b doc = (b) task.n();
        return new f(eVar.a, eVar.f2253a, doc, true, doc != null && doc.h());
    }

    private eq0<f> h(p source) {
        TaskCompletionSource<DocumentSnapshot> res = new gq0<>();
        TaskCompletionSource<ListenerRegistration> registration = new gq0<>();
        f.a options = new f.a();
        options.a = true;
        options.b = true;
        options.c = true;
        registration.c(a(xj.b, options, (Activity) null, c.b(res, registration, source)));
        return res.a();
    }

    static /* synthetic */ void k(gq0 res, gq0 registration, p source, f snapshot, i error) {
        if (error != null) {
            res.b(error);
            return;
        }
        try {
            ((rx) lq0.a(registration.a())).remove();
            if (!snapshot.g() && snapshot.l().a()) {
                res.b(new i("Failed to get document because the client is offline.", i.a.UNAVAILABLE));
            } else if (!snapshot.g() || !snapshot.l().a() || source != p.SERVER) {
                res.c(snapshot);
            } else {
                res.b(new i("Failed to get document from server. (However, this document does exist in the local cache. Run again without setting source to SERVER to retrieve the cached document.)", i.a.UNAVAILABLE));
            }
        } catch (ExecutionException e) {
            throw n4.b(e, "Failed to register a listener for a single document", new Object[0]);
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            throw n4.b(e2, "Failed to register a listener for a single document", new Object[0]);
        }
    }

    private rx a(Executor userExecutor, f.a options, Activity activity, bj<f> userListener) {
        AsyncEventListener<ViewSnapshot> asyncListener = new p4<>(userExecutor, d.b(this, userListener));
        return r0.a(activity, new sx(this.a.c(), this.a.c().r(b(), options, asyncListener), asyncListener));
    }

    static /* synthetic */ void i(e eVar, bj userListener, f0 snapshot, i error) {
        f documentSnapshot;
        if (error != null) {
            userListener.a(null, error);
            return;
        }
        boolean z = true;
        n4.d(snapshot != null, "Got event without value or error set", new Object[0]);
        if (snapshot.e().size() > 1) {
            z = false;
        }
        n4.d(z, "Too many documents returned on a document query", new Object[0]);
        b document = snapshot.e().c(eVar.f2253a);
        if (document != null) {
            documentSnapshot = f.h(eVar.a, document, snapshot.j(), snapshot.f().contains(document.a()));
        } else {
            documentSnapshot = f.i(eVar.a, eVar.f2253a, snapshot.j(), false);
        }
        userListener.a(documentSnapshot, (i) null);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof e)) {
            return false;
        }
        e that = (e) o;
        if (!this.f2253a.equals(that.f2253a) || !this.a.equals(that.a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f2253a.hashCode() * 31) + this.a.hashCode();
    }

    private x b() {
        return x.b(this.f2253a.h());
    }
}
