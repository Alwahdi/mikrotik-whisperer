package defpackage;

import com.google.firebase.firestore.model.ResourcePath;
import defpackage.z00;
import java.util.ArrayList;
import java.util.List;

/* renamed from: kg0  reason: default package */
final class kg0 implements ks {
    private final dh0 a;

    /* renamed from: a  reason: collision with other field name */
    private final z00.a f4116a = new z00.a();

    kg0(dh0 persistence) {
        this.a = persistence;
    }

    public void b(me0 collectionPath) {
        n4.d(collectionPath.n() % 2 == 1, "Expected a collection path.", new Object[0]);
        if (this.f4116a.a(collectionPath)) {
            this.a.o("INSERT OR REPLACE INTO collection_parents (collection_id, parent) VALUES (?, ?)", collectionPath.h(), oi.c((me0) collectionPath.q()));
        }
    }

    public List<me0> a(String collectionId) {
        ArrayList<ResourcePath> parentPaths = new ArrayList<>();
        this.a.x("SELECT parent FROM collection_parents WHERE collection_id = ?").a(collectionId).d(jg0.a(parentPaths));
        return parentPaths;
    }
}
