package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.atomic.AtomicBoolean;

public final class LifecycleDispatcher {
    public static final LifecycleDispatcher INSTANCE = new LifecycleDispatcher();
    private static final AtomicBoolean initialized = new AtomicBoolean(false);

    private LifecycleDispatcher() {
    }

    public static final void init(Context context) {
        lu.f(context, "context");
        if (!initialized.getAndSet(true)) {
            Context applicationContext = context.getApplicationContext();
            lu.d(applicationContext, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext).registerActivityLifecycleCallbacks(new DispatcherActivityCallback());
        }
    }

    @VisibleForTesting
    public static final class DispatcherActivityCallback extends EmptyActivityLifecycleCallbacks {
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            lu.f(activity, "activity");
            ReportFragment.Companion.injectIfNeededIn(activity);
        }
    }
}
