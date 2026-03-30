package defpackage;

import defpackage.i3;

/* renamed from: rl0  reason: default package */
public final class rl0 implements i3.d {
    public static final rl0 a = new rl0(false, false, (String) null, false, (String) null, (String) null, false, (Long) null, (Long) null);

    /* renamed from: a  reason: collision with other field name */
    private final Long f4902a = null;

    /* renamed from: a  reason: collision with other field name */
    private final String f4903a = null;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f4904a = false;
    private final Long b = null;

    /* renamed from: b  reason: collision with other field name */
    private final String f4905b = null;

    /* renamed from: b  reason: collision with other field name */
    private final boolean f4906b = false;
    private final String c = null;

    /* renamed from: c  reason: collision with other field name */
    private final boolean f4907c = false;
    private final boolean d = false;

    /* renamed from: rl0$a */
    public static final class a {
    }

    private rl0(boolean z, boolean z2, String str, boolean z3, String str2, String str3, boolean z4, Long l, Long l2) {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof rl0)) {
            return false;
        }
        rl0 rl0 = (rl0) obj;
        if (this.f4904a != rl0.f4904a || this.f4906b != rl0.f4906b || !e40.a(this.f4903a, rl0.f4903a) || this.f4907c != rl0.f4907c || this.d != rl0.d || !e40.a(this.f4905b, rl0.f4905b) || !e40.a(this.c, rl0.c) || !e40.a(this.f4902a, rl0.f4902a) || !e40.a(this.b, rl0.b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return e40.b(Boolean.valueOf(this.f4904a), Boolean.valueOf(this.f4906b), this.f4903a, Boolean.valueOf(this.f4907c), Boolean.valueOf(this.d), this.f4905b, this.c, this.f4902a, this.b);
    }

    public final boolean h() {
        return this.f4904a;
    }

    public final boolean g() {
        return this.f4906b;
    }

    public final String e() {
        return this.f4903a;
    }

    public final boolean f() {
        return this.f4907c;
    }

    public final String b() {
        return this.f4905b;
    }

    public final String c() {
        return this.c;
    }

    public final boolean i() {
        return this.d;
    }

    public final Long a() {
        return this.f4902a;
    }

    public final Long d() {
        return this.b;
    }

    static {
        new a();
    }
}
