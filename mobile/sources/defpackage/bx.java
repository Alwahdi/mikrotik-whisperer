package defpackage;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;

/* renamed from: bx  reason: default package */
public class bx {
    private final Object a;

    public bx(Activity activity) {
        y90.k(activity, "Activity must not be null");
        this.a = activity;
    }

    public boolean c() {
        return this.a instanceof FragmentActivity;
    }

    public final boolean d() {
        return this.a instanceof Activity;
    }

    public Activity a() {
        return (Activity) this.a;
    }

    public FragmentActivity b() {
        return (FragmentActivity) this.a;
    }
}
