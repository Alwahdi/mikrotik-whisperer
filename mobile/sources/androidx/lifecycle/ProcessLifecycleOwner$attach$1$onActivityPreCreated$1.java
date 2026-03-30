package androidx.lifecycle;

import android.app.Activity;

public final class ProcessLifecycleOwner$attach$1$onActivityPreCreated$1 extends EmptyActivityLifecycleCallbacks {
    final /* synthetic */ ProcessLifecycleOwner this$0;

    ProcessLifecycleOwner$attach$1$onActivityPreCreated$1(ProcessLifecycleOwner $receiver) {
        this.this$0 = $receiver;
    }

    public void onActivityPostStarted(Activity activity) {
        lu.f(activity, "activity");
        this.this$0.activityStarted$lifecycle_process_release();
    }

    public void onActivityPostResumed(Activity activity) {
        lu.f(activity, "activity");
        this.this$0.activityResumed$lifecycle_process_release();
    }
}
