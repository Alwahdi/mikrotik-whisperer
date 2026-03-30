package defpackage;

import java.util.AbstractMap;

/* renamed from: o21  reason: default package */
final class o21 extends t11 {
    private final /* synthetic */ j21 a;

    o21(j21 j21) {
        this.a = j21;
    }

    public final int size() {
        return this.a.b;
    }

    public final /* synthetic */ Object get(int i) {
        t01.a(i, this.a.b);
        int i2 = i * 2;
        return new AbstractMap.SimpleImmutableEntry(this.a.f4028b[i2], this.a.f4028b[i2 + 1]);
    }
}
