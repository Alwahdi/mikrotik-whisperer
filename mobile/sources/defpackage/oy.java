package defpackage;

import android.location.Location;
import androidx.core.util.Consumer;

/* renamed from: oy  reason: default package */
public final /* synthetic */ class oy implements Runnable {
    public final /* synthetic */ Location a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Consumer f4611a;

    public /* synthetic */ oy(Consumer consumer, Location location) {
        this.f4611a = consumer;
        this.a = location;
    }

    public final void run() {
        this.f4611a.accept(this.a);
    }
}
