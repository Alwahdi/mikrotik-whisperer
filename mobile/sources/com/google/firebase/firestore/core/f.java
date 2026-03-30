package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.a0;
import com.google.firebase.firestore.i;
import io.grpc.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class f implements a0.c {
    private final a0 a;

    /* renamed from: a  reason: collision with other field name */
    private v f2201a = v.UNKNOWN;

    /* renamed from: a  reason: collision with other field name */
    private final Map<x, b> f2202a;

    /* renamed from: a  reason: collision with other field name */
    private final Set<bj<Void>> f2203a = new HashSet();

    public static class a {
        public boolean a;
        public boolean b;
        public boolean c;
    }

    private static class b {
        /* access modifiers changed from: private */
        public int a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public f0 f2204a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public final List<y> f2205a = new ArrayList();

        b() {
        }
    }

    public f(a0 syncEngine) {
        this.a = syncEngine;
        this.f2202a = new HashMap();
        syncEngine.t(this);
    }

    public int d(y queryListener) {
        x query = queryListener.a();
        b queryInfo = this.f2202a.get(query);
        boolean firstListen = queryInfo == null;
        if (firstListen) {
            queryInfo = new b();
            this.f2202a.put(query, queryInfo);
        }
        queryInfo.f2205a.add(queryListener);
        n4.d(!queryListener.c(this.f2201a), "onOnlineStateChanged() shouldn't raise an event for brand-new listeners.", new Object[0]);
        if (queryInfo.f2204a != null && queryListener.d(queryInfo.f2204a)) {
            e();
        }
        if (firstListen) {
            int unused = queryInfo.a = this.a.n(query);
        }
        return queryInfo.a;
    }

    public void f(y listener) {
        x query = listener.a();
        b queryInfo = this.f2202a.get(query);
        boolean lastListen = false;
        if (queryInfo != null) {
            queryInfo.f2205a.remove(listener);
            lastListen = queryInfo.f2205a.isEmpty();
        }
        if (lastListen) {
            this.f2202a.remove(query);
            this.a.u(query);
        }
    }

    private void e() {
        Iterator<bj<Void>> it = this.f2203a.iterator();
        while (it.hasNext()) {
            ((bj) it.next()).a(null, (i) null);
        }
    }

    public void b(List<f0> snapshotList) {
        boolean raisedEvent = false;
        for (f0 viewSnapshot : snapshotList) {
            b info = this.f2202a.get(viewSnapshot.h());
            if (info != null) {
                for (y listener : info.f2205a) {
                    if (listener.d(viewSnapshot)) {
                        raisedEvent = true;
                    }
                }
                f0 unused = info.f2204a = viewSnapshot;
            }
        }
        if (raisedEvent) {
            e();
        }
    }

    public void c(x query, p error) {
        b info = this.f2202a.get(query);
        if (info != null) {
            for (y listener : info.f2205a) {
                listener.b(qu0.j(error));
            }
        }
        this.f2202a.remove(query);
    }

    public void a(v onlineState) {
        boolean raisedEvent = false;
        this.f2201a = onlineState;
        for (b info : this.f2202a.values()) {
            for (y listener : info.f2205a) {
                if (listener.c(onlineState)) {
                    raisedEvent = true;
                }
            }
        }
        if (raisedEvent) {
            e();
        }
    }
}
