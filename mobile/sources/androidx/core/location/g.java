package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f95a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Executor f96a;

    public /* synthetic */ g(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor, int i) {
        this.f95a = gpsStatusTransport;
        this.f96a = executor;
        this.a = i;
    }

    public final void run() {
        this.f95a.lambda$onGpsStatusChanged$2(this.f96a, this.a);
    }
}
