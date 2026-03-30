package defpackage;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.database.collection.c;
import com.google.firebase.database.collection.e;
import com.google.firebase.firestore.core.x;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.b;
import com.google.firebase.firestore.util.i;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* renamed from: js  reason: default package */
public class js implements tb0 {
    private xx a;

    public void b(xx localDocuments) {
        this.a = localDocuments;
    }

    public c<mh, b> a(x query, hm0 lastLimboFreeSnapshotVersion, e<mh> remoteKeys) {
        n4.d(this.a != null, "setLocalDocumentsView() not called", new Object[0]);
        if (query.u()) {
            return d(query);
        }
        if (lastLimboFreeSnapshotVersion.equals(hm0.a)) {
            return d(query);
        }
        ImmutableSortedSet<Document> previousResults = c(query, this.a.e(remoteKeys));
        if ((query.o() || query.p()) && e(query.k(), previousResults, remoteKeys, lastLimboFreeSnapshotVersion)) {
            return d(query);
        }
        if (i.c()) {
            i.a("IndexFreeQueryEngine", "Re-using previous result from %s to execute query: %s", lastLimboFreeSnapshotVersion.toString(), query.toString());
        }
        ImmutableSortedMap<DocumentKey, Document> updatedResults = this.a.i(query, lastLimboFreeSnapshotVersion);
        Iterator<b> it = previousResults.iterator();
        while (it.hasNext()) {
            b result = it.next();
            updatedResults = updatedResults.g(result.a(), result);
        }
        return updatedResults;
    }

    private e<b> c(x query, c<mh, com.google.firebase.firestore.model.c> documents) {
        ImmutableSortedSet<Document> queryResults = new e<>(Collections.emptyList(), query.c());
        Iterator<Map.Entry<mh, com.google.firebase.firestore.model.c>> it = documents.iterator();
        while (it.hasNext()) {
            com.google.firebase.firestore.model.c maybeDoc = (com.google.firebase.firestore.model.c) it.next().getValue();
            if ((maybeDoc instanceof b) && query.t((b) maybeDoc)) {
                queryResults = queryResults.c((b) maybeDoc);
            }
        }
        return queryResults;
    }

    private boolean e(x.a limitType, e<b> sortedPreviousResults, e<mh> remoteKeys, hm0 limboFreeSnapshotVersion) {
        b documentAtLimitEdge;
        if (remoteKeys.size() != sortedPreviousResults.size()) {
            return true;
        }
        if (limitType == x.a.LIMIT_TO_FIRST) {
            documentAtLimitEdge = sortedPreviousResults.a();
        } else {
            documentAtLimitEdge = sortedPreviousResults.b();
        }
        if (documentAtLimitEdge == null) {
            return false;
        }
        if (documentAtLimitEdge.c() || documentAtLimitEdge.b().compareTo(limboFreeSnapshotVersion) > 0) {
            return true;
        }
        return false;
    }

    private c<mh, b> d(x query) {
        if (i.c()) {
            i.a("IndexFreeQueryEngine", "Using full collection scan to execute query: %s", query.toString());
        }
        return this.a.i(query, hm0.a);
    }
}
