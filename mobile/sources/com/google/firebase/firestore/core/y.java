package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.d;
import com.google.firebase.firestore.core.f;
import com.google.firebase.firestore.i;
import java.util.ArrayList;
import java.util.List;

public class y {
    private final bj<f0> a;

    /* renamed from: a  reason: collision with other field name */
    private final f.a f2245a;

    /* renamed from: a  reason: collision with other field name */
    private f0 f2246a;

    /* renamed from: a  reason: collision with other field name */
    private v f2247a = v.UNKNOWN;

    /* renamed from: a  reason: collision with other field name */
    private final x f2248a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f2249a = false;

    public y(x query, f.a options, bj<f0> listener) {
        this.f2248a = query;
        this.a = listener;
        this.f2245a = options;
    }

    public x a() {
        return this.f2248a;
    }

    public boolean d(f0 newSnapshot) {
        n4.d(!newSnapshot.d().isEmpty() || newSnapshot.a(), "We got a new snapshot with no changes?", new Object[0]);
        boolean raisedEvent = false;
        if (!this.f2245a.a) {
            List<DocumentViewChange> documentChanges = new ArrayList<>();
            for (d change : newSnapshot.d()) {
                if (change.c() != d.a.METADATA) {
                    documentChanges.add(change);
                }
            }
            newSnapshot = new f0(newSnapshot.h(), newSnapshot.e(), newSnapshot.g(), documentChanges, newSnapshot.j(), newSnapshot.f(), newSnapshot.a(), true);
        }
        if (!this.f2249a) {
            if (g(newSnapshot, this.f2247a)) {
                e(newSnapshot);
                raisedEvent = true;
            }
        } else if (f(newSnapshot)) {
            this.a.a(newSnapshot, (i) null);
            raisedEvent = true;
        }
        this.f2246a = newSnapshot;
        return raisedEvent;
    }

    public void b(i error) {
        this.a.a(null, error);
    }

    public boolean c(v onlineState) {
        this.f2247a = onlineState;
        f0 f0Var = this.f2246a;
        if (f0Var == null || this.f2249a || !g(f0Var, onlineState)) {
            return false;
        }
        e(this.f2246a);
        return true;
    }

    private boolean g(f0 snapshot, v onlineState) {
        n4.d(!this.f2249a, "Determining whether to raise first event but already had first event.", new Object[0]);
        if (!snapshot.j()) {
            return true;
        }
        v vVar = v.OFFLINE;
        boolean maybeOnline = !onlineState.equals(vVar);
        if (this.f2245a.c && maybeOnline) {
            n4.d(snapshot.j(), "Waiting for sync, but snapshot is not from cache", new Object[0]);
            return false;
        } else if (!snapshot.e().isEmpty() || onlineState.equals(vVar)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean f(f0 snapshot) {
        boolean z = true;
        if (!snapshot.d().isEmpty()) {
            return true;
        }
        f0 f0Var = this.f2246a;
        if (f0Var == null || f0Var.i() == snapshot.i()) {
            z = false;
        }
        boolean hasPendingWritesChanged = z;
        if (snapshot.a() || hasPendingWritesChanged) {
            return this.f2245a.b;
        }
        return false;
    }

    private void e(f0 snapshot) {
        n4.d(!this.f2249a, "Trying to raise initial event for second time", new Object[0]);
        f0 snapshot2 = f0.c(snapshot.h(), snapshot.e(), snapshot.f(), snapshot.j(), snapshot.b());
        this.f2249a = true;
        this.a.a(snapshot2, (i) null);
    }
}
