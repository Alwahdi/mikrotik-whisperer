package defpackage;

import androidx.core.widget.ContentLoadingProgressBar;

/* renamed from: oc  reason: default package */
public final /* synthetic */ class oc implements Runnable {
    public final /* synthetic */ ContentLoadingProgressBar a;

    public /* synthetic */ oc(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.a = contentLoadingProgressBar;
    }

    public final void run() {
        this.a.showOnUiThread();
    }
}
