package defpackage;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;

/* renamed from: e00  reason: default package */
public abstract class e00 {
    public static TypedValue a(Context context, int attributeResId) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(attributeResId, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static TypedValue f(View componentView, int attributeResId) {
        return e(componentView.getContext(), attributeResId, componentView.getClass().getCanonicalName());
    }

    public static TypedValue e(Context context, int attributeResId, String errorMessageComponent) {
        TypedValue typedValue = a(context, attributeResId);
        if (typedValue != null) {
            return typedValue;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", new Object[]{errorMessageComponent, context.getResources().getResourceName(attributeResId)}));
    }

    public static int d(Context context, int attributeResId, String errorMessageComponent) {
        return e(context, attributeResId, errorMessageComponent).data;
    }

    public static boolean b(Context context, int attributeResId, boolean defaultValue) {
        TypedValue typedValue = a(context, attributeResId);
        if (typedValue == null || typedValue.type != 18) {
            return defaultValue;
        }
        return typedValue.data != 0;
    }

    public static int c(Context context, int attributeResId, int defaultValue) {
        TypedValue typedValue = a(context, attributeResId);
        if (typedValue == null || typedValue.type != 16) {
            return defaultValue;
        }
        return typedValue.data;
    }
}
