package defpackage;

import androidx.core.widget.ContentLoadingProgressBar;

/* renamed from: mc  reason: default package */
public final /* synthetic */ class mc implements Runnable {
    public final /* synthetic */ ContentLoadingProgressBar a;

    public /* synthetic */ mc(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.a = contentLoadingProgressBar;
    }

    public final void run() {
        this.a.hideOnUiThread();
    }
}
