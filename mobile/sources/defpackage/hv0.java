package defpackage;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;

/* renamed from: hv0  reason: default package */
public final /* synthetic */ class hv0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ViewPropertyAnimatorUpdateListener f3182a;

    public /* synthetic */ hv0(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener, View view) {
        this.f3182a = viewPropertyAnimatorUpdateListener;
        this.a = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f3182a.onAnimationUpdate(this.a);
    }
}
