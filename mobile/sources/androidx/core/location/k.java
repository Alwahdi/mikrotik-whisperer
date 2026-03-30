package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class k implements Runnable {
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f101a;

    public /* synthetic */ k(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str) {
        this.a = locationListenerTransport;
        this.f101a = str;
    }

    public final void run() {
        this.a.lambda$onProviderEnabled$4(this.f101a);
    }
}
