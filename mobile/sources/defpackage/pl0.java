package defpackage;

import com.google.android.material.sidesheet.SideSheetBehavior;

/* renamed from: pl0  reason: default package */
public final /* synthetic */ class pl0 implements Runnable {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ SideSheetBehavior f4718a;

    public /* synthetic */ pl0(SideSheetBehavior sideSheetBehavior, int i) {
        this.f4718a = sideSheetBehavior;
        this.a = i;
    }

    public final void run() {
        this.f4718a.N(this.a);
    }
}
