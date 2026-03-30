package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f102a;

    public /* synthetic */ l(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str) {
        this.a = locationListenerTransport;
        this.f102a = str;
    }

    public final void run() {
        this.a.lambda$onProviderDisabled$5(this.f102a);
    }
}
