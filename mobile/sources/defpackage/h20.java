package defpackage;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* renamed from: h20  reason: default package */
public class h20 {
    private int a = 0;

    /* renamed from: a  reason: collision with other field name */
    private long f3131a = 0;

    /* renamed from: a  reason: collision with other field name */
    private TimeInterpolator f3132a = null;
    private int b = 1;

    /* renamed from: b  reason: collision with other field name */
    private long f3133b = 300;

    public h20(long delay, long duration) {
        this.f3131a = delay;
        this.f3133b = duration;
    }

    public h20(long delay, long duration, TimeInterpolator interpolator) {
        this.f3131a = delay;
        this.f3133b = duration;
        this.f3132a = interpolator;
    }

    public void a(Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ((ValueAnimator) animator).setRepeatCount(g());
            ((ValueAnimator) animator).setRepeatMode(h());
        }
    }

    public long c() {
        return this.f3131a;
    }

    public long d() {
        return this.f3133b;
    }

    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f3132a;
        return timeInterpolator != null ? timeInterpolator : f3.b;
    }

    public int g() {
        return this.a;
    }

    public int h() {
        return this.b;
    }

    static h20 b(ValueAnimator animator) {
        h20 timing = new h20(animator.getStartDelay(), animator.getDuration(), f(animator));
        timing.a = animator.getRepeatCount();
        timing.b = animator.getRepeatMode();
        return timing;
    }

    private static TimeInterpolator f(ValueAnimator animator) {
        TimeInterpolator interpolator = animator.getInterpolator();
        if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
            return f3.b;
        }
        if (interpolator instanceof AccelerateInterpolator) {
            return f3.c;
        }
        if (interpolator instanceof DecelerateInterpolator) {
            return f3.d;
        }
        return interpolator;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof h20)) {
            return false;
        }
        h20 that = (h20) o;
        if (c() == that.c() && d() == that.d() && g() == that.g() && h() == that.h()) {
            return e().getClass().equals(that.e().getClass());
        }
        return false;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    public String toString() {
        return 10 + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }
}
