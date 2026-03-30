package defpackage;

import defpackage.xo0;

/* renamed from: tt0  reason: default package */
final /* synthetic */ class tt0 implements xo0.a {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final es0 f5171a;

    /* renamed from: a  reason: collision with other field name */
    private final ut0 f5172a;

    private tt0(ut0 ut0, es0 es0, int i) {
        this.f5172a = ut0;
        this.f5171a = es0;
        this.a = i;
    }

    public static xo0.a b(ut0 ut0, es0 es0, int i) {
        return new tt0(ut0, es0, i);
    }

    public Object a() {
        return this.f5172a.f5271a.a(this.f5171a, this.a + 1);
    }
}
