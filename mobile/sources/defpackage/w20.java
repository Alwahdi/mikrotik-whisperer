package defpackage;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.c;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.protobuf.e;
import java.util.List;

/* renamed from: w20  reason: default package */
public final class w20 {
    private final c<mh, hm0> a;

    /* renamed from: a  reason: collision with other field name */
    private final e f5425a;

    /* renamed from: a  reason: collision with other field name */
    private final hm0 f5426a;

    /* renamed from: a  reason: collision with other field name */
    private final List<y20> f5427a;

    /* renamed from: a  reason: collision with other field name */
    private final v20 f5428a;

    private w20(v20 batch, hm0 commitVersion, List<y20> mutationResults, e streamToken, c<mh, hm0> docVersions) {
        this.f5428a = batch;
        this.f5426a = commitVersion;
        this.f5427a = mutationResults;
        this.f5425a = streamToken;
        this.a = docVersions;
    }

    public static w20 a(v20 batch, hm0 commitVersion, List<y20> mutationResults, e streamToken) {
        n4.d(batch.h().size() == mutationResults.size(), "Mutations sent %d must equal results received %d", Integer.valueOf(batch.h().size()), Integer.valueOf(mutationResults.size()));
        ImmutableSortedMap<DocumentKey, SnapshotVersion> docVersions = hh.c();
        List<u20> h = batch.h();
        for (int i = 0; i < h.size(); i++) {
            docVersions = docVersions.g(h.get(i).d(), mutationResults.get(i).b());
        }
        return new w20(batch, commitVersion, mutationResults, streamToken, docVersions);
    }

    public v20 b() {
        return this.f5428a;
    }

    public hm0 c() {
        return this.f5426a;
    }

    public List<y20> e() {
        return this.f5427a;
    }

    public e f() {
        return this.f5425a;
    }

    public c<mh, hm0> d() {
        return this.a;
    }
}
