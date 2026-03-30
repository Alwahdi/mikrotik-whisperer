package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ LocationManagerCompat.CancellableLocationListener a;

    public /* synthetic */ c(LocationManagerCompat.CancellableLocationListener cancellableLocationListener) {
        this.a = cancellableLocationListener;
    }

    public final void run() {
        this.a.lambda$startTimeout$0();
    }
}
