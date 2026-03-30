package defpackage;

import java.util.List;

/* renamed from: x11  reason: default package */
final class x11 extends t11 {
    private final transient int a;

    /* renamed from: a  reason: collision with other field name */
    private final /* synthetic */ t11 f5563a;
    private final transient int b;

    x11(t11 t11, int i, int i2) {
        this.f5563a = t11;
        this.a = i;
        this.b = i2;
    }

    public final int size() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public final Object[] d() {
        return this.f5563a.d();
    }

    /* access modifiers changed from: package-private */
    public final int f() {
        return this.f5563a.f() + this.a;
    }

    /* access modifiers changed from: package-private */
    public final int h() {
        return this.f5563a.f() + this.a + this.b;
    }

    public final Object get(int i) {
        t01.a(i, this.b);
        return this.f5563a.get(i + this.a);
    }

    public final t11 l(int i, int i2) {
        t01.d(i, i2, this.b);
        t11 t11 = this.f5563a;
        int i3 = this.a;
        return (t11) t11.subList(i + i3, i2 + i3);
    }

    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
