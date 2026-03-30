package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: sv0  reason: default package */
public abstract class sv0 {
    /* access modifiers changed from: private */
    public static final String a = sv0.class.getSimpleName();

    public static Rect b(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            return c.a(windowManager);
        }
        if (i >= 17) {
            return b.a(windowManager);
        }
        return a.a(windowManager);
    }

    /* renamed from: sv0$c */
    private static class c {
        static Rect a(WindowManager windowManager) {
            return windowManager.getCurrentWindowMetrics().getBounds();
        }
    }

    /* renamed from: sv0$b */
    private static class b {
        static Rect a(WindowManager windowManager) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point defaultDisplaySize = new Point();
            defaultDisplay.getRealSize(defaultDisplaySize);
            Rect bounds = new Rect();
            bounds.right = defaultDisplaySize.x;
            bounds.bottom = defaultDisplaySize.y;
            return bounds;
        }
    }

    /* renamed from: sv0$a */
    private static class a {
        static Rect a(WindowManager windowManager) {
            int i;
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point defaultDisplaySize = b(defaultDisplay);
            Rect bounds = new Rect();
            int i2 = defaultDisplaySize.x;
            if (i2 == 0 || (i = defaultDisplaySize.y) == 0) {
                defaultDisplay.getRectSize(bounds);
            } else {
                bounds.right = i2;
                bounds.bottom = i;
            }
            return bounds;
        }

        private static Point b(Display display) {
            Point size = new Point();
            try {
                Method getRealSizeMethod = Display.class.getDeclaredMethod("getRealSize", new Class[]{Point.class});
                getRealSizeMethod.setAccessible(true);
                getRealSizeMethod.invoke(display, new Object[]{size});
            } catch (NoSuchMethodException e) {
                Log.w(sv0.a, e);
            } catch (IllegalAccessException e2) {
                Log.w(sv0.a, e2);
            } catch (InvocationTargetException e3) {
                Log.w(sv0.a, e3);
            }
            return size;
        }
    }
}
