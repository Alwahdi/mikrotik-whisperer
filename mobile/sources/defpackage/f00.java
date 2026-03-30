package defpackage;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.View;
import androidx.core.view.animation.PathInterpolatorCompat;
import org.apache.http.HttpStatus;

/* renamed from: f00  reason: default package */
public abstract class f00<V extends View> {
    protected final int a;

    /* renamed from: a  reason: collision with other field name */
    private final TimeInterpolator f2932a;

    /* renamed from: a  reason: collision with other field name */
    protected final V f2933a;
    protected final int b;
    protected final int c;

    public f00(V view) {
        this.f2933a = view;
        Context context = view.getContext();
        this.f2932a = i20.g(context, yb0.motionEasingStandardDecelerateInterpolator, PathInterpolatorCompat.create(0.0f, 0.0f, 0.0f, 1.0f));
        this.a = i20.f(context, yb0.motionDurationMedium2, HttpStatus.SC_MULTIPLE_CHOICES);
        this.b = i20.f(context, yb0.motionDurationShort3, 150);
        this.c = i20.f(context, yb0.motionDurationShort2, 100);
    }
}
