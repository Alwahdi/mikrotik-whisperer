package com.google.firebase.firestore;

import android.content.Context;
import com.google.firebase.firestore.h;
import java.util.HashMap;
import java.util.Map;

class k implements hl, h.a {
    private final Context a;

    /* renamed from: a  reason: collision with other field name */
    private final cu f2273a;

    /* renamed from: a  reason: collision with other field name */
    private final gl f2274a;

    /* renamed from: a  reason: collision with other field name */
    private final gq f2275a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<String, h> f2276a = new HashMap();

    k(Context context, gl app, cu authProvider, gq metadataProvider) {
        this.a = context;
        this.f2274a = app;
        this.f2273a = authProvider;
        this.f2275a = metadataProvider;
        app.e(this);
    }

    /* access modifiers changed from: package-private */
    public synchronized h a(String databaseId) {
        h firestore;
        firestore = this.f2276a.get(databaseId);
        if (firestore == null) {
            firestore = h.i(this.a, this.f2274a, this.f2273a, databaseId, this, this.f2275a);
            this.f2276a.put(databaseId, firestore);
        }
        return firestore;
    }
}
