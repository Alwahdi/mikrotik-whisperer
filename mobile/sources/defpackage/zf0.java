package defpackage;

import defpackage.hg0;

/* renamed from: zf0  reason: default package */
final /* synthetic */ class zf0 implements hg0.d {
    private final oj0 a;

    private zf0(oj0 oj0) {
        this.a = oj0;
    }

    public static hg0.d b(oj0 oj0) {
        return new zf0(oj0);
    }

    public Object a() {
        return this.a.getWritableDatabase();
    }
}
