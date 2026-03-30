package defpackage;

import com.google.firebase.database.collection.e;

/* renamed from: aq0  reason: default package */
public final class aq0 {
    private final e<mh> a;

    /* renamed from: a  reason: collision with other field name */
    private final com.google.protobuf.e f119a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f120a;
    private final e<mh> b;
    private final e<mh> c;

    public static aq0 a(boolean isCurrent) {
        return new aq0(com.google.protobuf.e.f2563a, isCurrent, mh.d(), mh.d(), mh.d());
    }

    public aq0(com.google.protobuf.e resumeToken, boolean current, e<mh> addedDocuments, e<mh> modifiedDocuments, e<mh> removedDocuments) {
        this.f119a = resumeToken;
        this.f120a = current;
        this.a = addedDocuments;
        this.b = modifiedDocuments;
        this.c = removedDocuments;
    }

    public com.google.protobuf.e e() {
        return this.f119a;
    }

    public boolean f() {
        return this.f120a;
    }

    public e<mh> b() {
        return this.a;
    }

    public e<mh> c() {
        return this.b;
    }

    public e<mh> d() {
        return this.c;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        aq0 that = (aq0) o;
        if (this.f120a == that.f120a && this.f119a.equals(that.f119a) && this.a.equals(that.a) && this.b.equals(that.b)) {
            return this.c.equals(that.c);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.f119a.hashCode() * 31) + (this.f120a ? 1 : 0)) * 31) + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }
}
