package defpackage;

import com.google.firebase.firestore.model.b;
import com.google.firebase.firestore.model.c;

/* renamed from: xk0  reason: default package */
public final class xk0 extends u20 {
    private final c40 a;

    public xk0(mh key, c40 value, u90 precondition) {
        super(key, precondition);
        this.a = value;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        xk0 that = (xk0) o;
        if (!g(that) || !this.a.equals(that.a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (h() * 31) + this.a.hashCode();
    }

    public String toString() {
        return "SetMutation{" + i() + ", value=" + this.a + "}";
    }

    public c b(c maybeDoc, y20 mutationResult) {
        j(maybeDoc);
        n4.d(mutationResult.a() == null, "Transform results received by SetMutation.", new Object[0]);
        return new b(d(), mutationResult.b(), b.a.COMMITTED_MUTATIONS, this.a);
    }

    public c a(c maybeDoc, c baseDoc, pr0 localWriteTime) {
        j(maybeDoc);
        if (!f().e(maybeDoc)) {
            return maybeDoc;
        }
        return new b(d(), u20.e(maybeDoc), b.a.LOCAL_MUTATIONS, this.a);
    }

    public c40 k() {
        return this.a;
    }

    public c40 c(c maybeDoc) {
        return null;
    }
}
