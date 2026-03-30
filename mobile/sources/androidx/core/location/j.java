package androidx.core.location;

import android.location.Location;
import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class j implements Runnable {
    public final /* synthetic */ Location a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f100a;

    public /* synthetic */ j(LocationManagerCompat.LocationListenerTransport locationListenerTransport, Location location) {
        this.f100a = locationListenerTransport;
        this.a = location;
    }

    public final void run() {
        this.f100a.lambda$onLocationChanged$0(this.a);
    }
}
