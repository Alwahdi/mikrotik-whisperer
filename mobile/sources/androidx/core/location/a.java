package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import androidx.core.os.CancellationSignal;

public final /* synthetic */ class a implements CancellationSignal.OnCancelListener {
    public final /* synthetic */ LocationManagerCompat.CancellableLocationListener a;

    public /* synthetic */ a(LocationManagerCompat.CancellableLocationListener cancellableLocationListener) {
        this.a = cancellableLocationListener;
    }

    public final void onCancel() {
        this.a.cancel();
    }
}
