package defpackage;

import com.google.firebase.firestore.model.b;
import com.google.firebase.firestore.model.c;

/* renamed from: u90  reason: default package */
public final class u90 {
    public static final u90 a = new u90((hm0) null, (Boolean) null);

    /* renamed from: a  reason: collision with other field name */
    private final hm0 f5237a;

    /* renamed from: a  reason: collision with other field name */
    private final Boolean f5238a;

    private u90(hm0 updateTime, Boolean exists) {
        n4.d(updateTime == null || exists == null, "Precondition can specify \"exists\" or \"updateTime\" but not both", new Object[0]);
        this.f5237a = updateTime;
        this.f5238a = exists;
    }

    public static u90 a(boolean exists) {
        return new u90((hm0) null, Boolean.valueOf(exists));
    }

    public static u90 f(hm0 version) {
        return new u90(version, (Boolean) null);
    }

    public boolean d() {
        return this.f5237a == null && this.f5238a == null;
    }

    public hm0 c() {
        return this.f5237a;
    }

    public Boolean b() {
        return this.f5238a;
    }

    public boolean e(c maybeDoc) {
        if (this.f5237a == null) {
            Boolean bool = this.f5238a;
            if (bool == null) {
                n4.d(d(), "Precondition should be empty", new Object[0]);
                return true;
            } else if (bool.booleanValue() == (maybeDoc instanceof b)) {
                return true;
            } else {
                return false;
            }
        } else if (!(maybeDoc instanceof b) || !maybeDoc.b().equals(this.f5237a)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        u90 that = (u90) o;
        hm0 hm0 = this.f5237a;
        if (hm0 == null ? that.f5237a != null : !hm0.equals(that.f5237a)) {
            return false;
        }
        Boolean bool = this.f5238a;
        if (bool != null) {
            return bool.equals(that.f5238a);
        }
        if (that.f5238a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        hm0 hm0 = this.f5237a;
        int i = 0;
        int hashCode = (hm0 != null ? hm0.hashCode() : 0) * 31;
        Boolean bool = this.f5238a;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        if (d()) {
            return "Precondition{<none>}";
        }
        if (this.f5237a != null) {
            return "Precondition{updateTime=" + this.f5237a + "}";
        } else if (this.f5238a != null) {
            return "Precondition{exists=" + this.f5238a + "}";
        } else {
            throw n4.a("Invalid Precondition", new Object[0]);
        }
    }
}
