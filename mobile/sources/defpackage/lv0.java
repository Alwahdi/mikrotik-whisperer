package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.core.content.ContextCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

/* renamed from: lv0  reason: default package */
public abstract class lv0 {

    /* renamed from: lv0$c */
    public interface c {
        WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, d dVar);
    }

    public static void l(View view, boolean useWindowInsetsController) {
        WindowInsetsControllerCompat windowController;
        if (!useWindowInsetsController || (windowController = ViewCompat.getWindowInsetsController(view)) == null) {
            e(view).showSoftInput(view, 1);
        } else {
            windowController.show(WindowInsetsCompat.Type.ime());
        }
    }

    public static void k(View view, boolean useWindowInsetsController) {
        view.requestFocus();
        view.post(new kv0(view, useWindowInsetsController));
    }

    private static InputMethodManager e(View view) {
        return (InputMethodManager) ContextCompat.getSystemService(view.getContext(), InputMethodManager.class);
    }

    public static PorterDuff.Mode i(int value, PorterDuff.Mode defaultMode) {
        switch (value) {
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case 9:
                return PorterDuff.Mode.SRC_ATOP;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return defaultMode;
        }
    }

    public static boolean g(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    public static float c(Context context, int dp) {
        return TypedValue.applyDimension(1, (float) dp, context.getResources().getDisplayMetrics());
    }

    /* renamed from: lv0$d */
    public static class d {
        public int a;
        public int b;
        public int c;
        public int d;

        public d(int start, int top, int end, int bottom) {
            this.a = start;
            this.b = top;
            this.c = end;
            this.d = bottom;
        }

        public d(d other) {
            this.a = other.a;
            this.b = other.b;
            this.c = other.c;
            this.d = other.d;
        }
    }

    public static void b(View view, c listener) {
        ViewCompat.setOnApplyWindowInsetsListener(view, new a(listener, new d(ViewCompat.getPaddingStart(view), view.getPaddingTop(), ViewCompat.getPaddingEnd(view), view.getPaddingBottom())));
        j(view);
    }

    /* renamed from: lv0$a */
    class a implements OnApplyWindowInsetsListener {
        final /* synthetic */ c a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ d f4295a;

        a(c cVar, d dVar) {
            this.a = cVar;
            this.f4295a = dVar;
        }

        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat insets) {
            return this.a.a(view, insets, new d(this.f4295a));
        }
    }

    public static void j(View view) {
        if (ViewCompat.isAttachedToWindow(view)) {
            ViewCompat.requestApplyInsets(view);
        } else {
            view.addOnAttachStateChangeListener(new b());
        }
    }

    /* renamed from: lv0$b */
    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        public void onViewAttachedToWindow(View v) {
            v.removeOnAttachStateChangeListener(this);
            ViewCompat.requestApplyInsets(v);
        }

        public void onViewDetachedFromWindow(View v) {
        }
    }

    public static float f(View view) {
        float absoluteElevation = 0.0f;
        for (ViewParent viewParent = view.getParent(); viewParent instanceof View; viewParent = viewParent.getParent()) {
            absoluteElevation += ViewCompat.getElevation((View) viewParent);
        }
        return absoluteElevation;
    }

    public static Integer d(View view) {
        ColorStateList backgroundColorStateList = yh.f(view.getBackground());
        if (backgroundColorStateList != null) {
            return Integer.valueOf(backgroundColorStateList.getDefaultColor());
        }
        return null;
    }
}
