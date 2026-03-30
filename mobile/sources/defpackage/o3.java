package defpackage;

import defpackage.i3;
import defpackage.i3.d;

/* renamed from: o3  reason: default package */
public final class o3<O extends i3.d> {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final O f4477a;

    /* renamed from: a  reason: collision with other field name */
    private final i3<O> f4478a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f4479a = false;

    private o3(i3<O> i3Var, O o) {
        this.f4478a = i3Var;
        this.f4477a = o;
        this.a = e40.b(i3Var, o);
    }

    public static <O extends i3.d> o3<O> b(i3<O> i3Var, O o) {
        return new o3<>(i3Var, o);
    }

    public final String a() {
        return this.f4478a.a();
    }

    public final int hashCode() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o3)) {
            return false;
        }
        o3 o3Var = (o3) obj;
        if (this.f4479a || o3Var.f4479a || !e40.a(this.f4478a, o3Var.f4478a) || !e40.a(this.f4477a, o3Var.f4477a)) {
            return false;
        }
        return true;
    }
}
