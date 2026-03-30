package defpackage;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.x;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.b;
import com.google.firebase.firestore.model.c;
import com.google.firebase.firestore.model.d;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: xx  reason: default package */
class xx {
    private final de0 a;

    /* renamed from: a  reason: collision with other field name */
    private final ks f5782a;

    /* renamed from: a  reason: collision with other field name */
    private final x20 f5783a;

    xx(de0 remoteDocumentCache, x20 mutationQueue, ks indexManager) {
        this.a = remoteDocumentCache;
        this.f5783a = mutationQueue;
        this.f5782a = indexManager;
    }

    /* access modifiers changed from: package-private */
    public c c(mh key) {
        return d(key, this.f5783a.j(key));
    }

    private c d(mh key, List<v20> inBatches) {
        c document = this.a.d(key);
        for (v20 batch : inBatches) {
            document = batch.b(key, document);
        }
        return document;
    }

    private Map<mh, c> b(Map<mh, c> docs, List<v20> batches) {
        for (Map.Entry<DocumentKey, MaybeDocument> base : docs.entrySet()) {
            c localView = (c) base.getValue();
            for (v20 batch : batches) {
                localView = batch.b((mh) base.getKey(), localView);
            }
            base.setValue(localView);
        }
        return docs;
    }

    /* access modifiers changed from: package-private */
    public com.google.firebase.database.collection.c<mh, c> e(Iterable<mh> keys) {
        return j(this.a.e(keys));
    }

    /* access modifiers changed from: package-private */
    public com.google.firebase.database.collection.c<mh, c> j(Map<mh, c> baseDocs) {
        ImmutableSortedMap<DocumentKey, MaybeDocument> results = hh.b();
        for (Map.Entry<DocumentKey, MaybeDocument> entry : b(baseDocs, this.f5783a.d(baseDocs.keySet())).entrySet()) {
            mh key = (mh) entry.getKey();
            c maybeDoc = (c) entry.getValue();
            if (maybeDoc == null) {
                maybeDoc = new d(key, hm0.a, false);
            }
            results = results.g(key, maybeDoc);
        }
        return results;
    }

    /* access modifiers changed from: package-private */
    public com.google.firebase.database.collection.c<mh, b> i(x query, hm0 sinceReadTime) {
        me0 path = query.m();
        if (query.s()) {
            return h(path);
        }
        if (query.r()) {
            return f(query, sinceReadTime);
        }
        return g(query, sinceReadTime);
    }

    private com.google.firebase.database.collection.c<mh, b> h(me0 path) {
        ImmutableSortedMap<DocumentKey, Document> result = hh.a();
        c doc = c(mh.e(path));
        if (doc instanceof b) {
            return result.g(doc.a(), (b) doc);
        }
        return result;
    }

    private com.google.firebase.database.collection.c<mh, b> f(x query, hm0 sinceReadTime) {
        n4.d(query.m().j(), "Currently we only support collection group queries at the root.", new Object[0]);
        String collectionId = query.d();
        ImmutableSortedMap<DocumentKey, Document> results = hh.a();
        for (me0 parent : this.f5782a.a(collectionId)) {
            Iterator<Map.Entry<mh, b>> it = g(query.a((me0) parent.b(collectionId)), sinceReadTime).iterator();
            while (it.hasNext()) {
                Map.Entry<DocumentKey, Document> docEntry = it.next();
                results = results.g((mh) docEntry.getKey(), (b) docEntry.getValue());
            }
        }
        return results;
    }

    private com.google.firebase.database.collection.c<mh, b> g(x query, hm0 sinceReadTime) {
        ImmutableSortedMap<DocumentKey, Document> results = this.a.a(query, sinceReadTime);
        List<v20> i = this.f5783a.i(query);
        ImmutableSortedMap<DocumentKey, Document> results2 = a(i, results);
        for (v20 batch : i) {
            for (u20 mutation : batch.h()) {
                if (query.m().k(mutation.d().h())) {
                    mh key = mutation.d();
                    c baseDoc = results2.b(key);
                    c mutatedDoc = mutation.a(baseDoc, baseDoc, batch.g());
                    if (mutatedDoc instanceof b) {
                        results2 = results2.g(key, (b) mutatedDoc);
                    } else {
                        results2 = results2.j(key);
                    }
                }
            }
        }
        Iterator<Map.Entry<mh, b>> it = results2.iterator();
        while (it.hasNext()) {
            Map.Entry<DocumentKey, Document> docEntry = it.next();
            if (!query.t((b) docEntry.getValue())) {
                results2 = results2.j((mh) docEntry.getKey());
            }
        }
        return results2;
    }

    private com.google.firebase.database.collection.c<mh, b> a(List<v20> matchingBatches, com.google.firebase.database.collection.c<mh, b> existingDocs) {
        HashSet<DocumentKey> missingDocKeys = new HashSet<>();
        for (v20 batch : matchingBatches) {
            for (u20 mutation : batch.h()) {
                if ((mutation instanceof o50) && !existingDocs.a(mutation.d())) {
                    missingDocKeys.add(mutation.d());
                }
            }
        }
        com.google.firebase.database.collection.c<mh, b> cVar = existingDocs;
        for (Map.Entry<DocumentKey, MaybeDocument> entry : this.a.e(missingDocKeys).entrySet()) {
            if (entry.getValue() != null && (entry.getValue() instanceof b)) {
                cVar = cVar.g((mh) entry.getKey(), (b) entry.getValue());
            }
        }
        return cVar;
    }
}
