package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Executor f94a;

    public /* synthetic */ f(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor) {
        this.a = gpsStatusTransport;
        this.f94a = executor;
    }

    public final void run() {
        this.a.lambda$onGpsStatusChanged$1(this.f94a);
    }
}
