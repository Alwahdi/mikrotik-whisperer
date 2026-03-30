package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* renamed from: fg  reason: default package */
public abstract class fg {
    private static final ThreadLocal<Matrix> a = new ThreadLocal<>();
    private static final ThreadLocal<RectF> b = new ThreadLocal<>();

    public static void c(ViewGroup parent, View descendant, Rect rect) {
        ThreadLocal<Matrix> threadLocal = a;
        Matrix m = threadLocal.get();
        if (m == null) {
            m = new Matrix();
            threadLocal.set(m);
        } else {
            m.reset();
        }
        b(parent, descendant, m);
        ThreadLocal<RectF> threadLocal2 = b;
        RectF rectF = threadLocal2.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal2.set(rectF);
        }
        rectF.set(rect);
        m.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public static void a(ViewGroup parent, View descendant, Rect out) {
        out.set(0, 0, descendant.getWidth(), descendant.getHeight());
        c(parent, descendant, out);
    }

    private static void b(ViewParent target, View view, Matrix m) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != target) {
            View vp = (View) parent;
            b(target, vp, m);
            m.preTranslate((float) (-vp.getScrollX()), (float) (-vp.getScrollY()));
        }
        m.preTranslate((float) view.getLeft(), (float) view.getTop());
        if (!view.getMatrix().isIdentity()) {
            m.preConcat(view.getMatrix());
        }
    }
}
