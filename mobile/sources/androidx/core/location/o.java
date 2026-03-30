package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class o implements Runnable {
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Executor f107a;

    public /* synthetic */ o(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor) {
        this.a = preRGnssStatusTransport;
        this.f107a = executor;
    }

    public final void run() {
        this.a.lambda$onStopped$1(this.f107a);
    }
}
