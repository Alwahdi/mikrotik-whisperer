package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* renamed from: ak  reason: default package */
public final class ak {
    private int a = 0;

    /* renamed from: a  reason: collision with other field name */
    private final View f68a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f69a = false;

    public ak(zj widget) {
        this.f68a = (View) widget;
    }

    public boolean c() {
        return this.f69a;
    }

    public Bundle e() {
        Bundle state = new Bundle();
        state.putBoolean("expanded", this.f69a);
        state.putInt("expandedComponentIdHint", this.a);
        return state;
    }

    public void d(Bundle state) {
        this.f69a = state.getBoolean("expanded", false);
        this.a = state.getInt("expandedComponentIdHint", 0);
        if (this.f69a) {
            a();
        }
    }

    public void f(int expandedComponentIdHint) {
        this.a = expandedComponentIdHint;
    }

    public int b() {
        return this.a;
    }

    private void a() {
        ViewParent parent = this.f68a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).dispatchDependentViewsChanged(this.f68a);
        }
    }
}
