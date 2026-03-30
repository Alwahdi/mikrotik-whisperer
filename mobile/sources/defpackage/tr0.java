package defpackage;

import androidx.appcompat.widget.Toolbar;

/* renamed from: tr0  reason: default package */
public final /* synthetic */ class tr0 implements Runnable {
    public final /* synthetic */ Toolbar a;

    public /* synthetic */ tr0(Toolbar toolbar) {
        this.a = toolbar;
    }

    public final void run() {
        this.a.invalidateMenu();
    }
}
