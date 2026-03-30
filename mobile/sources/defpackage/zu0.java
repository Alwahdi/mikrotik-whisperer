package defpackage;

import com.google.firebase.firestore.model.c;

/* renamed from: zu0  reason: default package */
public final class zu0 extends u20 {
    public zu0(mh key, u90 precondition) {
        super(key, precondition);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return g((zu0) o);
    }

    public int hashCode() {
        return h();
    }

    public String toString() {
        return "VerifyMutation{" + i() + "}";
    }

    public c b(c maybeDoc, y20 mutationResult) {
        throw n4.a("VerifyMutation should only be used in Transactions.", new Object[0]);
    }

    public c a(c maybeDoc, c baseDoc, pr0 localWriteTime) {
        throw n4.a("VerifyMutation should only be used in Transactions.", new Object[0]);
    }

    public c40 c(c maybeDoc) {
        throw n4.a("VerifyMutation should only be used in Transactions.", new Object[0]);
    }
}
