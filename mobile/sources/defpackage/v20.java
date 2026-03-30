package defpackage;

import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.c;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: v20  reason: default package */
public final class v20 {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final List<u20> f5294a;

    /* renamed from: a  reason: collision with other field name */
    private final pr0 f5295a;
    private final List<u20> b;

    public v20(int batchId, pr0 localWriteTime, List<u20> baseMutations, List<u20> mutations) {
        n4.d(!mutations.isEmpty(), "Cannot create an empty mutation batch", new Object[0]);
        this.a = batchId;
        this.f5295a = localWriteTime;
        this.f5294a = baseMutations;
        this.b = mutations;
    }

    public c c(mh documentKey, c maybeDoc, w20 batchResult) {
        if (maybeDoc != null) {
            n4.d(maybeDoc.a().equals(documentKey), "applyToRemoteDocument: key %s doesn't match maybeDoc key %s", documentKey, maybeDoc.a());
        }
        int size = this.b.size();
        List<y20> e = batchResult.e();
        n4.d(e.size() == size, "Mismatch between mutations length (%d) and results length (%d)", Integer.valueOf(size), Integer.valueOf(e.size()));
        for (int i = 0; i < size; i++) {
            u20 mutation = this.b.get(i);
            if (mutation.d().equals(documentKey)) {
                maybeDoc = mutation.b(maybeDoc, e.get(i));
            }
        }
        return maybeDoc;
    }

    public c b(mh documentKey, c maybeDoc) {
        if (maybeDoc != null) {
            n4.d(maybeDoc.a().equals(documentKey), "applyToRemoteDocument: key %s doesn't match maybeDoc key %s", documentKey, maybeDoc.a());
        }
        for (int i = 0; i < this.f5294a.size(); i++) {
            u20 mutation = this.f5294a.get(i);
            if (mutation.d().equals(documentKey)) {
                maybeDoc = mutation.a(maybeDoc, maybeDoc, this.f5295a);
            }
        }
        c baseDoc = maybeDoc;
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            u20 mutation2 = this.b.get(i2);
            if (mutation2.d().equals(documentKey)) {
                maybeDoc = mutation2.a(maybeDoc, baseDoc, this.f5295a);
            }
        }
        return maybeDoc;
    }

    public com.google.firebase.database.collection.c<mh, c> a(com.google.firebase.database.collection.c<mh, c> maybeDocumentMap) {
        com.google.firebase.database.collection.c<mh, c> cVar = maybeDocumentMap;
        for (mh key : f()) {
            c mutatedDocument = b(key, cVar.b(key));
            if (mutatedDocument != null) {
                cVar = cVar.g(mutatedDocument.a(), mutatedDocument);
            }
        }
        return cVar;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        v20 that = (v20) o;
        if (this.a != that.a || !this.f5295a.equals(that.f5295a) || !this.f5294a.equals(that.f5294a) || !this.b.equals(that.b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((this.a * 31) + this.f5295a.hashCode()) * 31) + this.f5294a.hashCode()) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "MutationBatch(batchId=" + this.a + ", localWriteTime=" + this.f5295a + ", baseMutations=" + this.f5294a + ", mutations=" + this.b + ')';
    }

    public Set<mh> f() {
        HashSet<DocumentKey> set = new HashSet<>();
        for (u20 mutation : this.b) {
            set.add(mutation.d());
        }
        return set;
    }

    public int e() {
        return this.a;
    }

    public pr0 g() {
        return this.f5295a;
    }

    public List<u20> h() {
        return this.b;
    }

    public List<u20> d() {
        return this.f5294a;
    }
}
