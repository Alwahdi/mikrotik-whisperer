package defpackage;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/* renamed from: f3  reason: default package */
public abstract class f3 {
    public static final TimeInterpolator a = new LinearInterpolator();
    public static final TimeInterpolator b = new FastOutSlowInInterpolator();
    public static final TimeInterpolator c = new FastOutLinearInInterpolator();
    public static final TimeInterpolator d = new LinearOutSlowInInterpolator();
    public static final TimeInterpolator e = new DecelerateInterpolator();

    public static float a(float startValue, float endValue, float fraction) {
        return ((endValue - startValue) * fraction) + startValue;
    }

    public static int c(int startValue, int endValue, float fraction) {
        return Math.round(((float) (endValue - startValue)) * fraction) + startValue;
    }

    public static float b(float outputMin, float outputMax, float inputMin, float inputMax, float value) {
        if (value <= inputMin) {
            return outputMin;
        }
        if (value >= inputMax) {
            return outputMax;
        }
        return a(outputMin, outputMax, (value - inputMin) / (inputMax - inputMin));
    }
}
