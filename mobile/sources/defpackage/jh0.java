package defpackage;

import android.database.Cursor;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.x;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.b;
import com.google.firebase.firestore.model.c;
import com.google.firebase.firestore.proto.a;
import com.google.protobuf.m;
import com.google.protobuf.p;
import defpackage.dh0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: jh0  reason: default package */
final class jh0 implements de0 {
    private final dh0 a;

    /* renamed from: a  reason: collision with other field name */
    private final zx f4062a;

    jh0(dh0 persistence, zx serializer) {
        this.a = persistence;
        this.f4062a = serializer;
    }

    public void b(c maybeDocument, hm0 readTime) {
        n4.d(!readTime.equals(hm0.a), "Cannot add document to the RemoteDocumentCache with a read time of zero", new Object[0]);
        String path = k(maybeDocument.a());
        pr0 timestamp = readTime.b();
        p message = this.f4062a.h(maybeDocument);
        this.a.o("INSERT OR REPLACE INTO remote_documents (path, read_time_seconds, read_time_nanos, contents) VALUES (?, ?, ?, ?)", path, Long.valueOf(timestamp.p()), Integer.valueOf(timestamp.o()), message.e());
        this.a.a().b((me0) maybeDocument.a().h().q());
    }

    public void c(mh documentKey) {
        String path = k(documentKey);
        this.a.o("DELETE FROM remote_documents WHERE path = ?", path);
    }

    public c d(mh documentKey) {
        String path = k(documentKey);
        return (c) this.a.x("SELECT contents FROM remote_documents WHERE path = ?").a(path).c(fh0.a(this));
    }

    public Map<mh, c> e(Iterable<mh> documentKeys) {
        List<Object> args = new ArrayList<>();
        for (mh key : documentKeys) {
            args.add(oi.c(key.h()));
        }
        Map<DocumentKey, MaybeDocument> results = new HashMap<>();
        for (mh key2 : documentKeys) {
            results.put(key2, (Object) null);
        }
        dh0.b longQuery = new dh0.b(this.a, "SELECT contents FROM remote_documents WHERE path IN (", args, ") ORDER BY path");
        while (longQuery.b()) {
            longQuery.c().d(gh0.a(this, results));
        }
        return results;
    }

    static /* synthetic */ void h(jh0 jh0, Map results, Cursor row) {
        c decoded = jh0.f(row.getBlob(0));
        results.put(decoded.a(), decoded);
    }

    public com.google.firebase.database.collection.c<mh, b> a(x query, hm0 sinceReadTime) {
        dh0.d sqlQuery;
        n4.d(!query.r(), "CollectionGroup queries should be handled in LocalDocumentsView", new Object[0]);
        me0 prefix = query.m();
        int immediateChildrenPathLength = prefix.n() + 1;
        String prefixPath = oi.c(prefix);
        String prefixSuccessorPath = oi.f(prefixPath);
        pr0 readTime = sinceReadTime.b();
        l5 backgroundQueue = new l5();
        ImmutableSortedMap<DocumentKey, Document>[] matchingDocuments = {hh.a()};
        if (sinceReadTime.equals(hm0.a)) {
            sqlQuery = this.a.x("SELECT path, contents FROM remote_documents WHERE path >= ? AND path < ?").a(prefixPath, prefixSuccessorPath);
        } else {
            sqlQuery = this.a.x("SELECT path, contents FROM remote_documents WHERE path >= ? AND path < ?AND (read_time_seconds > ? OR (read_time_seconds = ? AND read_time_nanos > ?))").a(prefixPath, prefixSuccessorPath, Long.valueOf(readTime.p()), Long.valueOf(readTime.p()), Integer.valueOf(readTime.o()));
        }
        sqlQuery.d(hh0.a(this, immediateChildrenPathLength, backgroundQueue, query, matchingDocuments));
        try {
            backgroundQueue.a();
        } catch (InterruptedException e) {
            n4.a("Interrupted while deserializing documents", e);
        }
        return matchingDocuments[0];
    }

    static /* synthetic */ void j(jh0 jh0, int immediateChildrenPathLength, l5 backgroundQueue, x query, com.google.firebase.database.collection.c[] matchingDocuments, Cursor row) {
        if (oi.b(row.getString(0)).n() == immediateChildrenPathLength) {
            (row.isLast() ? xj.b : backgroundQueue).execute(ih0.a(jh0, row.getBlob(1), query, matchingDocuments));
        }
    }

    static /* synthetic */ void i(jh0 jh0, byte[] rawDocument, x query, com.google.firebase.database.collection.c[] matchingDocuments) {
        c maybeDoc = jh0.f(rawDocument);
        if ((maybeDoc instanceof b) && query.t((b) maybeDoc)) {
            synchronized (jh0) {
                matchingDocuments[0] = matchingDocuments[0].g(maybeDoc.a(), (b) maybeDoc);
            }
        }
    }

    private String k(mh key) {
        return oi.c(key.h());
    }

    /* access modifiers changed from: private */
    public c f(byte[] bytes) {
        try {
            return this.f4062a.b(a.V(bytes));
        } catch (m e) {
            throw n4.a("MaybeDocument failed to parse: %s", e);
        }
    }
}
