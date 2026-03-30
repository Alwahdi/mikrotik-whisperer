package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Executor f93a;

    public /* synthetic */ e(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor) {
        this.a = gpsStatusTransport;
        this.f93a = executor;
    }

    public final void run() {
        this.a.lambda$onGpsStatusChanged$0(this.f93a);
    }
}
