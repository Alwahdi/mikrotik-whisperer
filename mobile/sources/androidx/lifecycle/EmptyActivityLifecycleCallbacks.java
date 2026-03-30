package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

public class EmptyActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        lu.f(activity, "activity");
    }

    public void onActivityStarted(Activity activity) {
        lu.f(activity, "activity");
    }

    public void onActivityResumed(Activity activity) {
        lu.f(activity, "activity");
    }

    public void onActivityPaused(Activity activity) {
        lu.f(activity, "activity");
    }

    public void onActivityStopped(Activity activity) {
        lu.f(activity, "activity");
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        lu.f(activity, "activity");
        lu.f(outState, "outState");
    }

    public void onActivityDestroyed(Activity activity) {
        lu.f(activity, "activity");
    }
}
