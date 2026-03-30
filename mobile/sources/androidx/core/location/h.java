package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ GnssStatusCompat a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f97a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Executor f98a;

    public /* synthetic */ h(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor, GnssStatusCompat gnssStatusCompat) {
        this.f97a = gpsStatusTransport;
        this.f98a = executor;
        this.a = gnssStatusCompat;
    }

    public final void run() {
        this.f97a.lambda$onGpsStatusChanged$3(this.f98a, this.a);
    }
}
