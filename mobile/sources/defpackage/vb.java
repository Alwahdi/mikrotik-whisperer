package defpackage;

import androidx.lifecycle.ComputableLiveData;

/* renamed from: vb  reason: default package */
public final /* synthetic */ class vb implements Runnable {
    public final /* synthetic */ ComputableLiveData a;

    public /* synthetic */ vb(ComputableLiveData computableLiveData) {
        this.a = computableLiveData;
    }

    public final void run() {
        ComputableLiveData.refreshRunnable$lambda$0(this.a);
    }
}
