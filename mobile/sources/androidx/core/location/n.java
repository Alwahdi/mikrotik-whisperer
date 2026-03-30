package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.List;

public final /* synthetic */ class n implements Runnable {
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ List f106a;

    public /* synthetic */ n(LocationManagerCompat.LocationListenerTransport locationListenerTransport, List list) {
        this.a = locationListenerTransport;
        this.f106a = list;
    }

    public final void run() {
        this.a.lambda$onLocationChanged$1(this.f106a);
    }
}
