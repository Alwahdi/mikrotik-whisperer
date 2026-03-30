package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

/* renamed from: zm0  reason: default package */
public final class zm0 {
    private final Animator.AnimatorListener a = new a();

    /* renamed from: a  reason: collision with other field name */
    ValueAnimator f6041a = null;

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<b> f6042a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private b f6043a = null;

    /* renamed from: zm0$a */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationEnd(Animator animator) {
            zm0 zm0 = zm0.this;
            if (zm0.f6041a == animator) {
                zm0.f6041a = null;
            }
        }
    }

    public void a(int[] specs, ValueAnimator animator) {
        b tuple = new b(specs, animator);
        animator.addListener(this.a);
        this.f6042a.add(tuple);
    }

    public void d(int[] state) {
        b match = null;
        int count = this.f6042a.size();
        int i = 0;
        while (true) {
            if (i >= count) {
                break;
            }
            b tuple = this.f6042a.get(i);
            if (StateSet.stateSetMatches(tuple.f6044a, state)) {
                match = tuple;
                break;
            }
            i++;
        }
        b bVar = this.f6043a;
        if (match != bVar) {
            if (bVar != null) {
                b();
            }
            this.f6043a = match;
            if (match != null) {
                e(match);
            }
        }
    }

    private void e(b match) {
        ValueAnimator valueAnimator = match.a;
        this.f6041a = valueAnimator;
        valueAnimator.start();
    }

    private void b() {
        ValueAnimator valueAnimator = this.f6041a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f6041a = null;
        }
    }

    public void c() {
        ValueAnimator valueAnimator = this.f6041a;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f6041a = null;
        }
    }

    /* renamed from: zm0$b */
    static class b {
        final ValueAnimator a;

        /* renamed from: a  reason: collision with other field name */
        final int[] f6044a;

        b(int[] specs, ValueAnimator animator) {
            this.f6044a = specs;
            this.a = animator;
        }
    }
}
