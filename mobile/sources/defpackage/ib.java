package defpackage;

import androidx.activity.ComponentDialog;

/* renamed from: ib  reason: default package */
public final /* synthetic */ class ib implements Runnable {
    public final /* synthetic */ ComponentDialog a;

    public /* synthetic */ ib(ComponentDialog componentDialog) {
        this.a = componentDialog;
    }

    public final void run() {
        ComponentDialog.onBackPressedDispatcher$lambda$1(this.a);
    }
}
