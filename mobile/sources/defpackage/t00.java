package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.view.ContextThemeWrapper;

/* renamed from: t00  reason: default package */
public abstract class t00 {
    private static final int[] a = {16842752, yb0.e0};
    private static final int[] b = {yb0.materialThemeOverlay};

    public static Context c(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        int materialThemeOverlayId = b(context, attrs, defStyleAttr, defStyleRes);
        boolean contextHasOverlay = (context instanceof ContextThemeWrapper) && ((ContextThemeWrapper) context).getThemeResId() == materialThemeOverlayId;
        if (materialThemeOverlayId == 0 || contextHasOverlay) {
            return context;
        }
        Context contextThemeWrapper = new ContextThemeWrapper(context, materialThemeOverlayId);
        int androidThemeOverlayId = a(context, attrs);
        if (androidThemeOverlayId != 0) {
            contextThemeWrapper.getTheme().applyStyle(androidThemeOverlayId, true);
        }
        return contextThemeWrapper;
    }

    private static int a(Context context, AttributeSet attrs) {
        TypedArray a2 = context.obtainStyledAttributes(attrs, a);
        int androidThemeId = a2.getResourceId(0, 0);
        int appThemeId = a2.getResourceId(1, 0);
        a2.recycle();
        return androidThemeId != 0 ? androidThemeId : appThemeId;
    }

    private static int b(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray a2 = context.obtainStyledAttributes(attrs, b, defStyleAttr, defStyleRes);
        int materialThemeOverlayId = a2.getResourceId(0, 0);
        a2.recycle();
        return materialThemeOverlayId;
    }
}
