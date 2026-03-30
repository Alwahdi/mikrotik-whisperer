package defpackage;

import androidx.lifecycle.DispatchQueue;

/* renamed from: rg  reason: default package */
public final /* synthetic */ class rg implements Runnable {
    public final /* synthetic */ DispatchQueue a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Runnable f4896a;

    public /* synthetic */ rg(DispatchQueue dispatchQueue, Runnable runnable) {
        this.a = dispatchQueue;
        this.f4896a = runnable;
    }

    public final void run() {
        DispatchQueue.dispatchAndEnqueue$lambda$2$lambda$1(this.a, this.f4896a);
    }
}
