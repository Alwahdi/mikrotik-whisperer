package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class q implements Runnable {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f109a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Executor f110a;

    public /* synthetic */ q(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, int i) {
        this.f109a = preRGnssStatusTransport;
        this.f110a = executor;
        this.a = i;
    }

    public final void run() {
        this.f109a.lambda$onFirstFix$2(this.f110a, this.a);
    }
}
