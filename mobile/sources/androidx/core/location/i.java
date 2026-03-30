package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f99a;

    public /* synthetic */ i(LocationManagerCompat.LocationListenerTransport locationListenerTransport, int i) {
        this.f99a = locationListenerTransport;
        this.a = i;
    }

    public final void run() {
        this.f99a.lambda$onFlushComplete$2(this.a);
    }
}
