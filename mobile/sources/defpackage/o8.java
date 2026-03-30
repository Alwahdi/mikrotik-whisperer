package defpackage;

import android.util.Property;
import android.view.ViewGroup;

/* renamed from: o8  reason: default package */
public class o8 extends Property<ViewGroup, Float> {
    public static final Property<ViewGroup, Float> a = new o8("childrenAlpha");

    private o8(String name) {
        super(Float.class, name);
    }

    /* renamed from: a */
    public Float get(ViewGroup object) {
        Float alpha = (Float) object.getTag(ic0.mtrl_internal_children_alpha_tag);
        if (alpha != null) {
            return alpha;
        }
        return Float.valueOf(1.0f);
    }

    /* renamed from: b */
    public void set(ViewGroup object, Float value) {
        float alpha = value.floatValue();
        object.setTag(ic0.mtrl_internal_children_alpha_tag, Float.valueOf(alpha));
        int count = object.getChildCount();
        for (int i = 0; i < count; i++) {
            object.getChildAt(i).setAlpha(alpha);
        }
    }
}
