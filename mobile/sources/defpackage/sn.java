package defpackage;

import androidx.activity.FullyDrawnReporter;

/* renamed from: sn  reason: default package */
public final /* synthetic */ class sn implements Runnable {
    public final /* synthetic */ FullyDrawnReporter a;

    public /* synthetic */ sn(FullyDrawnReporter fullyDrawnReporter) {
        this.a = fullyDrawnReporter;
    }

    public final void run() {
        FullyDrawnReporter.reportRunnable$lambda$2(this.a);
    }
}
