package defpackage;

import androidx.lifecycle.ComputableLiveData;

/* renamed from: wb  reason: default package */
public final /* synthetic */ class wb implements Runnable {
    public final /* synthetic */ ComputableLiveData a;

    public /* synthetic */ wb(ComputableLiveData computableLiveData) {
        this.a = computableLiveData;
    }

    public final void run() {
        ComputableLiveData.invalidationRunnable$lambda$1(this.a);
    }
}
