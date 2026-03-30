package defpackage;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.database.collection.e;
import com.google.firebase.firestore.core.d;
import com.google.firebase.firestore.core.f0;
import com.google.firebase.firestore.model.DocumentKey;
import java.util.ArrayList;

/* renamed from: ly  reason: default package */
public final class ly {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final e<mh> f4298a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f4299a;
    private final e<mh> b;

    public static ly a(int targetId, f0 snapshot) {
        ImmutableSortedSet<DocumentKey> addedKeys = new e<>(new ArrayList(), mh.a());
        ImmutableSortedSet<DocumentKey> removedKeys = new e<>(new ArrayList(), mh.a());
        for (d docChange : snapshot.d()) {
            switch (a.a[docChange.c().ordinal()]) {
                case 1:
                    addedKeys = addedKeys.c(docChange.b().a());
                    break;
                case 2:
                    removedKeys = removedKeys.c(docChange.b().a());
                    break;
            }
        }
        return new ly(targetId, snapshot.j(), addedKeys, removedKeys);
    }

    /* renamed from: ly$a */
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
                a[d.a.REMOVED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public ly(int targetId, boolean fromCache, e<mh> added, e<mh> removed) {
        this.a = targetId;
        this.f4299a = fromCache;
        this.f4298a = added;
        this.b = removed;
    }

    public int d() {
        return this.a;
    }

    public boolean e() {
        return this.f4299a;
    }

    public e<mh> b() {
        return this.f4298a;
    }

    public e<mh> c() {
        return this.b;
    }
}
