package com.google.firebase.firestore.core;

import com.google.firebase.database.collection.e;
import com.google.firebase.firestore.core.d;
import com.google.firebase.firestore.model.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class f0 {
    private final e<mh> a;

    /* renamed from: a  reason: collision with other field name */
    private final x f2206a;

    /* renamed from: a  reason: collision with other field name */
    private final List<d> f2207a;

    /* renamed from: a  reason: collision with other field name */
    private final rh f2208a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f2209a;
    private final rh b;

    /* renamed from: b  reason: collision with other field name */
    private final boolean f2210b;
    private boolean c;

    public enum a {
        NONE,
        LOCAL,
        SYNCED
    }

    public f0(x query, rh documents, rh oldDocuments, List<d> changes, boolean isFromCache, e<mh> mutatedKeys, boolean didSyncStateChange, boolean excludesMetadataChanges) {
        this.f2206a = query;
        this.f2208a = documents;
        this.b = oldDocuments;
        this.f2207a = changes;
        this.f2209a = isFromCache;
        this.a = mutatedKeys;
        this.f2210b = didSyncStateChange;
        this.c = excludesMetadataChanges;
    }

    public static f0 c(x query, rh documents, e<mh> mutatedKeys, boolean fromCache, boolean excludesMetadataChanges) {
        List<DocumentViewChange> viewChanges = new ArrayList<>();
        Iterator<b> it = documents.iterator();
        while (it.hasNext()) {
            viewChanges.add(d.a(d.a.ADDED, it.next()));
        }
        return new f0(query, documents, rh.b(query.c()), viewChanges, fromCache, mutatedKeys, true, excludesMetadataChanges);
    }

    public x h() {
        return this.f2206a;
    }

    public rh e() {
        return this.f2208a;
    }

    public rh g() {
        return this.b;
    }

    public List<d> d() {
        return this.f2207a;
    }

    public boolean j() {
        return this.f2209a;
    }

    public boolean i() {
        return !this.a.isEmpty();
    }

    public e<mh> f() {
        return this.a;
    }

    public boolean a() {
        return this.f2210b;
    }

    public boolean b() {
        return this.c;
    }

    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof f0)) {
            return false;
        }
        f0 that = (f0) o;
        if (this.f2209a == that.f2209a && this.f2210b == that.f2210b && this.c == that.c && this.f2206a.equals(that.f2206a) && this.a.equals(that.a) && this.f2208a.equals(that.f2208a) && this.b.equals(that.b)) {
            return this.f2207a.equals(that.f2207a);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((this.f2206a.hashCode() * 31) + this.f2208a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.f2207a.hashCode()) * 31) + this.a.hashCode()) * 31) + (this.f2209a ? 1 : 0)) * 31) + (this.f2210b ? 1 : 0)) * 31) + (this.c ? 1 : 0);
    }

    public String toString() {
        return "ViewSnapshot(" + this.f2206a + ", " + this.f2208a + ", " + this.b + ", " + this.f2207a + ", isFromCache=" + this.f2209a + ", mutatedKeys=" + this.a.size() + ", didSyncStateChange=" + this.f2210b + ", excludesMetadataChanges=" + this.c + ")";
    }
}
