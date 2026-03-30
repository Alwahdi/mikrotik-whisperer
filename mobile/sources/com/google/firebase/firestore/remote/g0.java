package com.google.firebase.firestore.remote;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.core.d;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.protobuf.e;
import java.util.HashMap;
import java.util.Map;

final class g0 {
    private int a = 0;

    /* renamed from: a  reason: collision with other field name */
    private e f2333a = e.f2563a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<mh, d.a> f2334a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    private boolean f2335a = true;
    private boolean b = false;

    g0() {
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return this.a != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.f2335a;
    }

    /* access modifiers changed from: package-private */
    public void k(e resumeToken) {
        if (!resumeToken.isEmpty()) {
            this.f2335a = true;
            this.f2333a = resumeToken;
        }
    }

    /* access modifiers changed from: package-private */
    public aq0 j() {
        ImmutableSortedSet<DocumentKey> addedDocuments = mh.d();
        ImmutableSortedSet<DocumentKey> modifiedDocuments = mh.d();
        ImmutableSortedSet<DocumentKey> removedDocuments = mh.d();
        for (Map.Entry<DocumentKey, DocumentViewChange.Type> entry : this.f2334a.entrySet()) {
            mh key = (mh) entry.getKey();
            d.a changeType = (d.a) entry.getValue();
            switch (a.a[changeType.ordinal()]) {
                case 1:
                    addedDocuments = addedDocuments.c(key);
                    break;
                case 2:
                    modifiedDocuments = modifiedDocuments.c(key);
                    break;
                case 3:
                    removedDocuments = removedDocuments.c(key);
                    break;
                default:
                    throw n4.a("Encountered invalid change type: %s", changeType);
            }
        }
        return new aq0(this.f2333a, this.b, addedDocuments, modifiedDocuments, removedDocuments);
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.a.values().length];
            a = iArr;
            try {
                iArr[d.a.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[d.a.MODIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[d.a.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f2335a = false;
        this.f2334a.clear();
    }

    /* access modifiers changed from: package-private */
    public void a(mh key, d.a changeType) {
        this.f2335a = true;
        this.f2334a.put(key, changeType);
    }

    /* access modifiers changed from: package-private */
    public void i(mh key) {
        this.f2335a = true;
        this.f2334a.remove(key);
    }

    /* access modifiers changed from: package-private */
    public void g() {
        this.a++;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        this.a--;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f2335a = true;
        this.b = true;
    }
}
