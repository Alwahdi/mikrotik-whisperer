package defpackage;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import java.util.List;

/* renamed from: r0  reason: default package */
public abstract class r0 {

    /* renamed from: r0$b */
    private static class b {
        private final List<Runnable> a;

        private b() {
            this.a = new ArrayList();
        }

        /* access modifiers changed from: package-private */
        public void b() {
            for (Runnable callback : this.a) {
                if (callback != null) {
                    callback.run();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized void a(Runnable callback) {
            this.a.add(callback);
        }
    }

    /* renamed from: r0$d */
    public static class d extends Fragment {
        b a = new b();

        public void onStop() {
            b callbacksCopy;
            super.onStop();
            synchronized (this.a) {
                callbacksCopy = this.a;
                this.a = new b();
            }
            callbacksCopy.b();
        }
    }

    /* renamed from: r0$c */
    public static class c extends android.app.Fragment {
        b a = new b();

        public void onStop() {
            b callbacksCopy;
            super.onStop();
            synchronized (this.a) {
                callbacksCopy = this.a;
                this.a = new b();
            }
            callbacksCopy.b();
        }
    }

    private static <T> T b(Class<T> fragmentClass, Object fragment, String tag) {
        if (fragment == null) {
            return null;
        }
        try {
            return fragmentClass.cast(fragment);
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag '" + tag + "' is a " + fragment.getClass().getName() + " but should be a " + fragmentClass.getName());
        }
    }

    private static void e(Activity activity, Runnable callback) {
        n4.d(!(activity instanceof FragmentActivity), "onActivityStopCallOnce must be called with a *non*-FragmentActivity Activity.", new Object[0]);
        activity.runOnUiThread(n0.a(activity, callback));
    }

    static /* synthetic */ void c(Activity activity, Runnable callback) {
        c fragment = (c) b(c.class, activity.getFragmentManager().findFragmentByTag("FirestoreOnStopObserverFragment"), "FirestoreOnStopObserverFragment");
        if (fragment == null || fragment.isRemoving()) {
            fragment = new c();
            activity.getFragmentManager().beginTransaction().add(fragment, "FirestoreOnStopObserverFragment").commitAllowingStateLoss();
            activity.getFragmentManager().executePendingTransactions();
        }
        fragment.a.a(callback);
    }

    private static void f(FragmentActivity activity, Runnable callback) {
        activity.runOnUiThread(o0.a(activity, callback));
    }

    static /* synthetic */ void d(FragmentActivity activity, Runnable callback) {
        d fragment = (d) b(d.class, activity.getSupportFragmentManager().findFragmentByTag("FirestoreOnStopObserverSupportFragment"), "FirestoreOnStopObserverSupportFragment");
        if (fragment == null || fragment.isRemoving()) {
            fragment = new d();
            activity.getSupportFragmentManager().beginTransaction().add((Fragment) fragment, "FirestoreOnStopObserverSupportFragment").commitAllowingStateLoss();
            activity.getSupportFragmentManager().executePendingTransactions();
        }
        fragment.a.a(callback);
    }

    public static rx a(Activity activity, rx registration) {
        if (activity != null) {
            if (activity instanceof FragmentActivity) {
                registration.getClass();
                f((FragmentActivity) activity, p0.a(registration));
            } else {
                registration.getClass();
                e(activity, q0.a(registration));
            }
        }
        return registration;
    }
}
