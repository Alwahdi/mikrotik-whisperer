package defpackage;

import com.google.firebase.database.collection.c;

/* renamed from: my  reason: default package */
public final class my {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final c<mh, com.google.firebase.firestore.model.c> f4391a;

    my(int batchId, c<mh, com.google.firebase.firestore.model.c> changes) {
        this.a = batchId;
        this.f4391a = changes;
    }

    public int a() {
        return this.a;
    }

    public c<mh, com.google.firebase.firestore.model.c> b() {
        return this.f4391a;
    }
}
