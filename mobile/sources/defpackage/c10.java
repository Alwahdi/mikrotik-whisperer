package defpackage;

import android.util.Pair;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.c;
import com.google.firebase.firestore.core.x;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: c10  reason: default package */
final class c10 implements de0 {
    private final b10 a;

    /* renamed from: a  reason: collision with other field name */
    private c<mh, Pair<com.google.firebase.firestore.model.c, hm0>> f280a = c.a.b(mh.a());

    c10(b10 persistence) {
        this.a = persistence;
    }

    public void b(com.google.firebase.firestore.model.c document, hm0 readTime) {
        n4.d(!readTime.equals(hm0.a), "Cannot add document to the RemoteDocumentCache with a read time of zero", new Object[0]);
        this.f280a = this.f280a.g(document.a(), new Pair(document, readTime));
        this.a.a().b((me0) document.a().h().q());
    }

    public void c(mh key) {
        this.f280a = this.f280a.j(key);
    }

    public com.google.firebase.firestore.model.c d(mh key) {
        Pair<MaybeDocument, SnapshotVersion> entry = this.f280a.b(key);
        if (entry != null) {
            return (com.google.firebase.firestore.model.c) entry.first;
        }
        return null;
    }

    public Map<mh, com.google.firebase.firestore.model.c> e(Iterable<mh> keys) {
        Map<DocumentKey, MaybeDocument> result = new HashMap<>();
        for (mh key : keys) {
            result.put(key, d(key));
        }
        return result;
    }

    public c<mh, b> a(x query, hm0 sinceReadTime) {
        n4.d(!query.r(), "CollectionGroup queries should be handled in LocalDocumentsView", new Object[0]);
        ImmutableSortedMap<DocumentKey, Document> result = hh.a();
        me0 queryPath = query.m();
        Iterator<Map.Entry<mh, Pair<com.google.firebase.firestore.model.c, hm0>>> h = this.f280a.h(mh.e((me0) queryPath.b("")));
        while (h.hasNext()) {
            Map.Entry<DocumentKey, Pair<MaybeDocument, SnapshotVersion>> entry = h.next();
            if (!queryPath.l(((mh) entry.getKey()).h())) {
                break;
            }
            com.google.firebase.firestore.model.c maybeDoc = (com.google.firebase.firestore.model.c) entry.getValue().first;
            if ((maybeDoc instanceof b) && ((hm0) entry.getValue().second).compareTo(sinceReadTime) > 0) {
                b doc = (b) maybeDoc;
                if (query.t(doc)) {
                    result = result.g(doc.a(), doc);
                }
            }
        }
        return result;
    }
}
