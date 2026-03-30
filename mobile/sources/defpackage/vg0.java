package defpackage;

import android.database.Cursor;

/* renamed from: vg0  reason: default package */
final /* synthetic */ class vg0 implements ko {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final ah0 f5384a;

    private vg0(ah0 ah0, int i) {
        this.f5384a = ah0;
        this.a = i;
    }

    public static ko a(ah0 ah0, int i) {
        return new vg0(ah0, i);
    }

    public Object apply(Object obj) {
        return this.f5384a.m(this.a, ((Cursor) obj).getBlob(0));
    }
}
