package defpackage;

import android.view.View;

/* renamed from: kv0  reason: default package */
public final /* synthetic */ class kv0 implements Runnable {
    public final /* synthetic */ View a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f4154a;

    public /* synthetic */ kv0(View view, boolean z) {
        this.a = view;
        this.f4154a = z;
    }

    public final void run() {
        lv0.l(this.a, this.f4154a);
    }
}
