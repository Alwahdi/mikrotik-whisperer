package defpackage;

import android.database.Cursor;

/* renamed from: ng0  reason: default package */
final /* synthetic */ class ng0 implements hc {
    private final og0 a;

    /* renamed from: a  reason: collision with other field name */
    private final int[] f4439a;

    private ng0(og0 og0, int[] iArr) {
        this.a = og0;
        this.f4439a = iArr;
    }

    public static hc a(og0 og0, int[] iArr) {
        return new ng0(og0, iArr);
    }

    public void accept(Object obj) {
        og0.t(this.a, this.f4439a, (Cursor) obj);
    }
}
