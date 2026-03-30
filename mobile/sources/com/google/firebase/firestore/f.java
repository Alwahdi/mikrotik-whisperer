package com.google.firebase.firestore;

import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.util.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class f {
    private final h a;

    /* renamed from: a  reason: collision with other field name */
    private final com.google.firebase.firestore.model.b f2254a;

    /* renamed from: a  reason: collision with other field name */
    private final o f2255a;

    /* renamed from: a  reason: collision with other field name */
    private final mh f2256a;

    public enum c {
        NONE,
        ESTIMATE,
        PREVIOUS;
        
        static final c DEFAULT = null;

        static {
            c cVar;
            DEFAULT = cVar;
        }
    }

    static class b {
        final c a;

        /* renamed from: a  reason: collision with other field name */
        final boolean f2257a;

        /* synthetic */ b(c x0, boolean x1, a x2) {
            this(x0, x1);
        }

        private b(c serverTimestampBehavior, boolean timestampsInSnapshotsEnabled) {
            this.a = serverTimestampBehavior;
            this.f2257a = timestampsInSnapshotsEnabled;
        }
    }

    f(h firestore, mh key, com.google.firebase.firestore.model.b doc, boolean isFromCache, boolean hasPendingWrites) {
        this.a = (h) v90.n(firestore);
        this.f2256a = (mh) v90.n(key);
        this.f2254a = doc;
        this.f2255a = new o(hasPendingWrites, isFromCache);
    }

    static f h(h firestore, com.google.firebase.firestore.model.b doc, boolean fromCache, boolean hasPendingWrites) {
        return new f(firestore, doc.a(), doc, fromCache, hasPendingWrites);
    }

    static f i(h firestore, mh key, boolean fromCache, boolean hasPendingWrites) {
        return new f(firestore, key, (com.google.firebase.firestore.model.b) null, fromCache, hasPendingWrites);
    }

    public o l() {
        return this.f2255a;
    }

    public boolean g() {
        return this.f2254a != null;
    }

    public Map<String, Object> j() {
        return k(c.DEFAULT);
    }

    public Map<String, Object> k(c serverTimestampBehavior) {
        v90.o(serverTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
        com.google.firebase.firestore.model.b bVar = this.f2254a;
        if (bVar == null) {
            return null;
        }
        return b(bVar.d(), new b(serverTimestampBehavior, this.a.f().a(), (a) null));
    }

    private Object f(rk value, b options) {
        if (value instanceof c40) {
            return b((c40) value, options);
        }
        if (value instanceof g4) {
            return a((g4) value, options);
        }
        if (value instanceof wd0) {
            return c((wd0) value);
        }
        if (value instanceof qr0) {
            return e((qr0) value, options);
        }
        if (value instanceof pk0) {
            return d((pk0) value, options);
        }
        return value.d();
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            a = iArr;
            try {
                iArr[c.PREVIOUS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[c.ESTIMATE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private Object d(pk0 value, b options) {
        switch (a.a[options.a.ordinal()]) {
            case 1:
                return value.g();
            case 2:
                return value.e();
            default:
                return value.d();
        }
    }

    private Object e(qr0 value, b options) {
        pr0 timestamp = value.d();
        if (options.f2257a) {
            return timestamp;
        }
        return timestamp.r();
    }

    private Object c(wd0 value) {
        mh key = value.d();
        ve refDatabase = value.e();
        ve database = this.a.e();
        if (!refDatabase.equals(database)) {
            i.d("DocumentSnapshot", "Document %s contains a document reference within a different database (%s/%s) which is not supported. It will be treated as a reference in the current database (%s/%s) instead.", key.h(), refDatabase.d(), refDatabase.c(), database.d(), database.c());
        }
        return new e(key, this.a);
    }

    private Map<String, Object> b(c40 objectValue, b options) {
        Map<String, Object> result = new HashMap<>();
        Iterator<Map.Entry<String, rk>> it = objectValue.l().iterator();
        while (it.hasNext()) {
            Map.Entry<String, FieldValue> entry = it.next();
            result.put(entry.getKey(), f((rk) entry.getValue(), options));
        }
        return result;
    }

    private List<Object> a(g4 arrayValue, b options) {
        ArrayList<Object> result = new ArrayList<>(arrayValue.g().size());
        for (rk v : arrayValue.g()) {
            result.add(f(v, options));
        }
        return result;
    }

    public boolean equals(Object obj) {
        com.google.firebase.firestore.model.b bVar;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f other = (f) obj;
        if (!this.a.equals(other.a) || !this.f2256a.equals(other.f2256a) || ((bVar = this.f2254a) != null ? !bVar.equals(other.f2254a) : other.f2254a != null) || !this.f2255a.equals(other.f2255a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hash = ((this.a.hashCode() * 31) + this.f2256a.hashCode()) * 31;
        com.google.firebase.firestore.model.b bVar = this.f2254a;
        return ((hash + (bVar != null ? bVar.hashCode() : 0)) * 31) + this.f2255a.hashCode();
    }

    public String toString() {
        return "DocumentSnapshot{key=" + this.f2256a + ", metadata=" + this.f2255a + ", doc=" + this.f2254a + '}';
    }
}
