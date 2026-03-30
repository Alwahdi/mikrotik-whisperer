package defpackage;

import com.google.firebase.firestore.model.c;
import java.util.Map;
import java.util.Set;

/* renamed from: ee0  reason: default package */
public final class ee0 {
    private final hm0 a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<Integer, aq0> f2903a;

    /* renamed from: a  reason: collision with other field name */
    private final Set<Integer> f2904a;
    private final Map<mh, c> b;

    /* renamed from: b  reason: collision with other field name */
    private final Set<mh> f2905b;

    public ee0(hm0 snapshotVersion, Map<Integer, aq0> targetChanges, Set<Integer> targetMismatches, Map<mh, c> documentUpdates, Set<mh> resolvedLimboDocuments) {
        this.a = snapshotVersion;
        this.f2903a = targetChanges;
        this.f2904a = targetMismatches;
        this.b = documentUpdates;
        this.f2905b = resolvedLimboDocuments;
    }

    public hm0 c() {
        return this.a;
    }

    public Map<Integer, aq0> d() {
        return this.f2903a;
    }

    public Set<Integer> e() {
        return this.f2904a;
    }

    public Map<mh, c> a() {
        return this.b;
    }

    public Set<mh> b() {
        return this.f2905b;
    }

    public String toString() {
        return "RemoteEvent{snapshotVersion=" + this.a + ", targetChanges=" + this.f2903a + ", targetMismatches=" + this.f2904a + ", documentUpdates=" + this.b + ", resolvedLimboDocuments=" + this.f2905b + '}';
    }
}
