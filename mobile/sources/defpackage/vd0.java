package defpackage;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.database.collection.e;
import com.google.firebase.firestore.model.DocumentKey;
import java.util.Collections;
import java.util.Iterator;

/* renamed from: vd0  reason: default package */
public class vd0 {
    private e<ph> a = new e<>(Collections.emptyList(), ph.a);
    private e<ph> b = new e<>(Collections.emptyList(), ph.b);

    public void a(mh key, int targetOrBatchId) {
        ph ref = new ph(key, targetOrBatchId);
        this.a = this.a.c(ref);
        this.b = this.b.c(ref);
    }

    public void b(e<mh> keys, int targetOrBatchId) {
        Iterator<mh> it = keys.iterator();
        while (it.hasNext()) {
            a(it.next(), targetOrBatchId);
        }
    }

    public void e(mh key, int targetOrBatchId) {
        f(new ph(key, targetOrBatchId));
    }

    public void g(e<mh> keys, int targetOrBatchId) {
        Iterator<mh> it = keys.iterator();
        while (it.hasNext()) {
            e(it.next(), targetOrBatchId);
        }
    }

    public e<mh> h(int targetId) {
        Iterator<ph> d = this.b.d(new ph(mh.c(), targetId));
        ImmutableSortedSet<DocumentKey> keys = mh.d();
        while (d.hasNext()) {
            ph ref = d.next();
            if (ref.a() != targetId) {
                break;
            }
            keys = keys.c(ref.b());
            f(ref);
        }
        return keys;
    }

    private void f(ph ref) {
        this.a = this.a.f(ref);
        this.b = this.b.f(ref);
    }

    public e<mh> d(int target) {
        Iterator<ph> d = this.b.d(new ph(mh.c(), target));
        ImmutableSortedSet<DocumentKey> keys = mh.d();
        while (d.hasNext()) {
            ph reference = d.next();
            if (reference.a() != target) {
                break;
            }
            keys = keys.c(reference.b());
        }
        return keys;
    }

    public boolean c(mh key) {
        Iterator<ph> d = this.a.d(new ph(key, 0));
        if (!d.hasNext()) {
            return false;
        }
        return d.next().b().equals(key);
    }
}
