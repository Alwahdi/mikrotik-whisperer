package defpackage;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
import java.util.List;

/* renamed from: g20  reason: default package */
public class g20 {
    private final SimpleArrayMap<String, h20> a = new SimpleArrayMap<>();
    private final SimpleArrayMap<String, PropertyValuesHolder[]> b = new SimpleArrayMap<>();

    public boolean f(String name) {
        return this.a.get(name) != null;
    }

    public h20 e(String name) {
        if (f(name)) {
            return this.a.get(name);
        }
        throw new IllegalArgumentException();
    }

    public void h(String name, h20 timing) {
        this.a.put(name, timing);
    }

    public void g(String name, PropertyValuesHolder[] values) {
        this.b.put(name, values);
    }

    public static g20 b(Context context, TypedArray attributes, int index) {
        int resourceId;
        if (!attributes.hasValue(index) || (resourceId = attributes.getResourceId(index, 0)) == 0) {
            return null;
        }
        return c(context, resourceId);
    }

    public static g20 c(Context context, int id) {
        try {
            Animator animator = AnimatorInflater.loadAnimator(context, id);
            if (animator instanceof AnimatorSet) {
                return d(((AnimatorSet) animator).getChildAnimations());
            }
            if (animator == null) {
                return null;
            }
            List<Animator> animators = new ArrayList<>();
            animators.add(animator);
            return d(animators);
        } catch (Exception e) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(id), e);
            return null;
        }
    }

    private static g20 d(List<Animator> animators) {
        g20 spec = new g20();
        int count = animators.size();
        for (int i = 0; i < count; i++) {
            a(spec, animators.get(i));
        }
        return spec;
    }

    private static void a(g20 spec, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator anim = (ObjectAnimator) animator;
            spec.g(anim.getPropertyName(), anim.getValues());
            spec.h(anim.getPropertyName(), h20.b(anim));
            return;
        }
        throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof g20)) {
            return false;
        }
        return this.a.equals(((g20) o).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return 10 + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.a + "}\n";
    }
}
