package defpackage;

import com.google.firebase.firestore.model.b;
import com.google.firebase.firestore.model.c;
import com.google.firebase.firestore.model.e;

/* renamed from: o50  reason: default package */
public final class o50 extends u20 {
    private final c40 a;

    /* renamed from: a  reason: collision with other field name */
    private final ok f4482a;

    public o50(mh key, c40 value, ok mask, u90 precondition) {
        super(key, precondition);
        this.a = value;
        this.f4482a = mask;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        o50 that = (o50) o;
        if (!g(that) || !this.a.equals(that.a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (h() * 31) + this.a.hashCode();
    }

    public String toString() {
        return "PatchMutation{" + i() + ", mask=" + this.f4482a + ", value=" + this.a + "}";
    }

    public c40 l() {
        return this.a;
    }

    public ok k() {
        return this.f4482a;
    }

    public c b(c maybeDoc, y20 mutationResult) {
        j(maybeDoc);
        n4.d(mutationResult.a() == null, "Transform results received by PatchMutation.", new Object[0]);
        if (!f().e(maybeDoc)) {
            return new e(d(), mutationResult.b());
        }
        return new b(d(), mutationResult.b(), b.a.COMMITTED_MUTATIONS, m(maybeDoc));
    }

    public c a(c maybeDoc, c baseDoc, pr0 localWriteTime) {
        j(maybeDoc);
        if (!f().e(maybeDoc)) {
            return maybeDoc;
        }
        return new b(d(), u20.e(maybeDoc), b.a.LOCAL_MUTATIONS, m(maybeDoc));
    }

    public c40 c(c maybeDoc) {
        return null;
    }

    private c40 m(c maybeDoc) {
        c40 data;
        if (maybeDoc instanceof b) {
            data = ((b) maybeDoc).d();
        } else {
            data = c40.g();
        }
        return n(data);
    }

    private c40 n(c40 obj) {
        for (pk path : this.f4482a.c()) {
            if (!path.j()) {
                rk newValue = this.a.j(path);
                if (newValue == null) {
                    obj = obj.e(path);
                } else {
                    obj = obj.n(path, newValue);
                }
            }
        }
        return obj;
    }
}
