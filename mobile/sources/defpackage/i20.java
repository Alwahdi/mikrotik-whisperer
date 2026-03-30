package defpackage;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import androidx.core.graphics.PathParser;
import androidx.core.view.animation.PathInterpolatorCompat;
import org.apache.http.cookie.ClientCookie;

/* renamed from: i20  reason: default package */
public abstract class i20 {
    public static int f(Context context, int attrResId, int defaultDuration) {
        return e00.c(context, attrResId, defaultDuration);
    }

    public static TimeInterpolator g(Context context, int attrResId, TimeInterpolator defaultInterpolator) {
        TypedValue easingValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(attrResId, easingValue, true)) {
            return defaultInterpolator;
        }
        if (easingValue.type == 3) {
            String easingString = String.valueOf(easingValue.string);
            if (d(easingString)) {
                return c(easingString);
            }
            return AnimationUtils.loadInterpolator(context, easingValue.resourceId);
        }
        throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
    }

    private static TimeInterpolator c(String easingString) {
        if (e(easingString, "cubic-bezier")) {
            String[] controlPoints = b(easingString, "cubic-bezier").split(",");
            if (controlPoints.length == 4) {
                return PathInterpolatorCompat.create(a(controlPoints, 0), a(controlPoints, 1), a(controlPoints, 2), a(controlPoints, 3));
            }
            throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + controlPoints.length);
        } else if (e(easingString, ClientCookie.PATH_ATTR)) {
            return PathInterpolatorCompat.create(PathParser.createPathFromPathData(b(easingString, ClientCookie.PATH_ATTR)));
        } else {
            throw new IllegalArgumentException("Invalid motion easing type: " + easingString);
        }
    }

    private static boolean d(String easingString) {
        return e(easingString, "cubic-bezier") || e(easingString, ClientCookie.PATH_ATTR);
    }

    private static boolean e(String easingString, String easingType) {
        StringBuilder sb = new StringBuilder();
        sb.append(easingType);
        sb.append("(");
        return easingString.startsWith(sb.toString()) && easingString.endsWith(")");
    }

    private static String b(String easingString, String easingType) {
        return easingString.substring(easingType.length() + "(".length(), easingString.length() - ")".length());
    }

    private static float a(String[] controlPoints, int index) {
        float controlPoint = Float.parseFloat(controlPoints[index]);
        if (controlPoint >= 0.0f && controlPoint <= 1.0f) {
            return controlPoint;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + controlPoint);
    }
}
