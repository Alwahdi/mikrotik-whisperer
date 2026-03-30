package defpackage;

import com.google.firebase.database.collection.c;
import com.google.firebase.database.collection.e;
import com.google.firebase.firestore.model.b;

/* renamed from: ub0  reason: default package */
public class ub0 {
    private final c<mh, b> a;

    /* renamed from: a  reason: collision with other field name */
    private final e<mh> f5240a;

    public ub0(c<mh, b> documents, e<mh> remoteKeys) {
        this.a = documents;
        this.f5240a = remoteKeys;
    }

    public c<mh, b> a() {
        return this.a;
    }

    public e<mh> b() {
        return this.f5240a;
    }
}
