package defpackage;

import android.content.Context;
import android.os.Build;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.e;

/* renamed from: jj0  reason: default package */
public abstract class jj0 {
    static yv0 a(Context context, hj eventStore, e config, c9 clock) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new iv(context, eventStore, config);
        }
        return new g2(context, eventStore, clock, config);
    }
}
