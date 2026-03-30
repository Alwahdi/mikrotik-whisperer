package defpackage;

import androidx.activity.ComponentActivity;

/* renamed from: gb  reason: default package */
public final /* synthetic */ class gb implements Runnable {
    public final /* synthetic */ ComponentActivity a;

    public /* synthetic */ gb(ComponentActivity componentActivity) {
        this.a = componentActivity;
    }

    public final void run() {
        this.a.invalidateMenu();
    }
}
