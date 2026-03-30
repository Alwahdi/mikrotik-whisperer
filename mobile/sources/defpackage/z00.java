package defpackage;

import com.google.firebase.firestore.model.ResourcePath;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* renamed from: z00  reason: default package */
class z00 implements ks {
    private final a a = new a();

    z00() {
    }

    public void b(me0 collectionPath) {
        this.a.a(collectionPath);
    }

    public List<me0> a(String collectionId) {
        return this.a.b(collectionId);
    }

    /* renamed from: z00$a */
    static class a {
        private final HashMap<String, HashSet<me0>> a = new HashMap<>();

        a() {
        }

        /* access modifiers changed from: package-private */
        public boolean a(me0 collectionPath) {
            boolean z = true;
            if (collectionPath.n() % 2 != 1) {
                z = false;
            }
            n4.d(z, "Expected a collection path.", new Object[0]);
            String collectionId = collectionPath.h();
            me0 parentPath = (me0) collectionPath.q();
            HashSet<ResourcePath> existingParents = this.a.get(collectionId);
            if (existingParents == null) {
                existingParents = new HashSet<>();
                this.a.put(collectionId, existingParents);
            }
            return existingParents.add(parentPath);
        }

        /* access modifiers changed from: package-private */
        public List<me0> b(String collectionId) {
            HashSet<ResourcePath> existingParents = this.a.get(collectionId);
            return existingParents != null ? new ArrayList(existingParents) : Collections.emptyList();
        }
    }
}
