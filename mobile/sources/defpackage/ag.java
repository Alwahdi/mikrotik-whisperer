package defpackage;

import com.google.firebase.firestore.model.c;
import com.google.firebase.firestore.model.d;

/* renamed from: ag  reason: default package */
public final class ag extends u20 {
    public ag(mh key, u90 precondition) {
        super(key, precondition);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return g((ag) o);
    }

    public int hashCode() {
        return h();
    }

    public String toString() {
        return "DeleteMutation{" + i() + "}";
    }

    public c b(c maybeDoc, y20 mutationResult) {
        j(maybeDoc);
        n4.d(mutationResult.a() == null, "Transform results received by DeleteMutation.", new Object[0]);
        return new d(d(), mutationResult.b(), true);
    }

    public c a(c maybeDoc, c baseDoc, pr0 localWriteTime) {
        j(maybeDoc);
        if (!f().e(maybeDoc)) {
            return maybeDoc;
        }
        return new d(d(), hm0.a, false);
    }

    public c40 c(c maybeDoc) {
        return null;
    }
}
