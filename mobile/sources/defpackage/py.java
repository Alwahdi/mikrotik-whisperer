package defpackage;

import android.location.Location;
import java.util.function.Consumer;

/* renamed from: py  reason: default package */
public final /* synthetic */ class py implements Consumer {
    public final /* synthetic */ androidx.core.util.Consumer a;

    public /* synthetic */ py(androidx.core.util.Consumer consumer) {
        this.a = consumer;
    }

    public final void accept(Object obj) {
        this.a.accept((Location) obj);
    }
}
