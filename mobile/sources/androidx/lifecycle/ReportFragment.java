package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ReportFragment extends Fragment {
    public static final Companion Companion = new Companion((Cif) null);
    private static final String REPORT_FRAGMENT_TAG = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag";
    private ActivityInitializationListener processListener;

    public interface ActivityInitializationListener {
        void onCreate();

        void onResume();

        void onStart();
    }

    public static final void dispatch$lifecycle_runtime_release(Activity activity, Lifecycle.Event event) {
        Companion.dispatch$lifecycle_runtime_release(activity, event);
    }

    public static final ReportFragment get(Activity activity) {
        return Companion.get(activity);
    }

    public static final void injectIfNeededIn(Activity activity) {
        Companion.injectIfNeededIn(activity);
    }

    private final void dispatchCreate(ActivityInitializationListener listener) {
        if (listener != null) {
            listener.onCreate();
        }
    }

    private final void dispatchStart(ActivityInitializationListener listener) {
        if (listener != null) {
            listener.onStart();
        }
    }

    private final void dispatchResume(ActivityInitializationListener listener) {
        if (listener != null) {
            listener.onResume();
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dispatchCreate(this.processListener);
        dispatch(Lifecycle.Event.ON_CREATE);
    }

    public void onStart() {
        super.onStart();
        dispatchStart(this.processListener);
        dispatch(Lifecycle.Event.ON_START);
    }

    public void onResume() {
        super.onResume();
        dispatchResume(this.processListener);
        dispatch(Lifecycle.Event.ON_RESUME);
    }

    public void onPause() {
        super.onPause();
        dispatch(Lifecycle.Event.ON_PAUSE);
    }

    public void onStop() {
        super.onStop();
        dispatch(Lifecycle.Event.ON_STOP);
    }

    public void onDestroy() {
        super.onDestroy();
        dispatch(Lifecycle.Event.ON_DESTROY);
        this.processListener = null;
    }

    private final void dispatch(Lifecycle.Event event) {
        if (Build.VERSION.SDK_INT < 29) {
            Companion companion = Companion;
            Activity activity = getActivity();
            lu.e(activity, "activity");
            companion.dispatch$lifecycle_runtime_release(activity, event);
        }
    }

    public final void setProcessListener(ActivityInitializationListener processListener2) {
        this.processListener = processListener2;
    }

    @RequiresApi(29)
    public static final class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        public static final Companion Companion = new Companion((Cif) null);

        public static final void registerIn(Activity activity) {
            Companion.registerIn(activity);
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            lu.f(activity, "activity");
        }

        public void onActivityPostCreated(Activity activity, Bundle savedInstanceState) {
            lu.f(activity, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_CREATE);
        }

        public void onActivityStarted(Activity activity) {
            lu.f(activity, "activity");
        }

        public void onActivityPostStarted(Activity activity) {
            lu.f(activity, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_START);
        }

        public void onActivityResumed(Activity activity) {
            lu.f(activity, "activity");
        }

        public void onActivityPostResumed(Activity activity) {
            lu.f(activity, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_RESUME);
        }

        public void onActivityPrePaused(Activity activity) {
            lu.f(activity, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_PAUSE);
        }

        public void onActivityPaused(Activity activity) {
            lu.f(activity, "activity");
        }

        public void onActivityPreStopped(Activity activity) {
            lu.f(activity, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_STOP);
        }

        public void onActivityStopped(Activity activity) {
            lu.f(activity, "activity");
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            lu.f(activity, "activity");
            lu.f(bundle, "bundle");
        }

        public void onActivityPreDestroyed(Activity activity) {
            lu.f(activity, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_DESTROY);
        }

        public void onActivityDestroyed(Activity activity) {
            lu.f(activity, "activity");
        }

        public static final class Companion {
            public /* synthetic */ Companion(Cif ifVar) {
                this();
            }

            private Companion() {
            }

            public final void registerIn(Activity activity) {
                lu.f(activity, "activity");
                activity.registerActivityLifecycleCallbacks(new LifecycleCallbacks());
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(Cif ifVar) {
            this();
        }

        public static /* synthetic */ void get$annotations(Activity activity) {
        }

        private Companion() {
        }

        public final void injectIfNeededIn(Activity activity) {
            lu.f(activity, "activity");
            if (Build.VERSION.SDK_INT >= 29) {
                LifecycleCallbacks.Companion.registerIn(activity);
            }
            FragmentManager manager = activity.getFragmentManager();
            if (manager.findFragmentByTag(ReportFragment.REPORT_FRAGMENT_TAG) == null) {
                manager.beginTransaction().add(new ReportFragment(), ReportFragment.REPORT_FRAGMENT_TAG).commit();
                manager.executePendingTransactions();
            }
        }

        public final void dispatch$lifecycle_runtime_release(Activity activity, Lifecycle.Event event) {
            lu.f(activity, "activity");
            lu.f(event, NotificationCompat.CATEGORY_EVENT);
            if (activity instanceof LifecycleRegistryOwner) {
                ((LifecycleRegistryOwner) activity).getLifecycle().handleLifecycleEvent(event);
            } else if (activity instanceof LifecycleOwner) {
                Lifecycle lifecycle = ((LifecycleOwner) activity).getLifecycle();
                if (lifecycle instanceof LifecycleRegistry) {
                    ((LifecycleRegistry) lifecycle).handleLifecycleEvent(event);
                }
            }
        }

        public final ReportFragment get(Activity $this$reportFragment) {
            lu.f($this$reportFragment, "<this>");
            Fragment findFragmentByTag = $this$reportFragment.getFragmentManager().findFragmentByTag(ReportFragment.REPORT_FRAGMENT_TAG);
            lu.d(findFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            return (ReportFragment) findFragmentByTag;
        }
    }
}
