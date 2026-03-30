package defpackage;

import com.google.firebase.firestore.model.b;
import com.google.firebase.firestore.model.c;

/* renamed from: u20  reason: default package */
public abstract class u20 {
    private final mh a;

    /* renamed from: a  reason: collision with other field name */
    private final u90 f5187a;

    public abstract c a(c cVar, c cVar2, pr0 pr0);

    public abstract c b(c cVar, y20 y20);

    public abstract c40 c(c cVar);

    u20(mh key, u90 precondition) {
        this.a = key;
        this.f5187a = precondition;
    }

    public mh d() {
        return this.a;
    }

    public u90 f() {
        return this.f5187a;
    }

    /* access modifiers changed from: package-private */
    public boolean g(u20 other) {
        return this.a.equals(other.a) && this.f5187a.equals(other.f5187a);
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return (d().hashCode() * 31) + this.f5187a.hashCode();
    }

    /* access modifiers changed from: package-private */
    public String i() {
        return "key=" + this.a + ", precondition=" + this.f5187a;
    }

    /* access modifiers changed from: package-private */
    public void j(c maybeDoc) {
        if (maybeDoc != null) {
            n4.d(maybeDoc.a().equals(d()), "Can only apply a mutation to a document with the same key", new Object[0]);
        }
    }

    static hm0 e(c maybeDoc) {
        if (maybeDoc instanceof b) {
            return maybeDoc.b();
        }
        return hm0.a;
    }
}
