package defpackage;

import android.database.Cursor;
import android.util.SparseArray;

/* renamed from: ai0  reason: default package */
final /* synthetic */ class ai0 implements hc {
    private final SparseArray a;

    /* renamed from: a  reason: collision with other field name */
    private final di0 f65a;

    /* renamed from: a  reason: collision with other field name */
    private final int[] f66a;

    private ai0(di0 di0, SparseArray sparseArray, int[] iArr) {
        this.f65a = di0;
        this.a = sparseArray;
        this.f66a = iArr;
    }

    public static hc a(di0 di0, SparseArray sparseArray, int[] iArr) {
        return new ai0(di0, sparseArray, iArr);
    }

    public void accept(Object obj) {
        di0.q(this.f65a, this.a, this.f66a, (Cursor) obj);
    }
}
