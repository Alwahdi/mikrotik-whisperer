package defpackage;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* renamed from: us  reason: default package */
public class us implements View.OnTouchListener {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final Dialog f5262a;
    private final int b;
    private final int c;

    public us(Dialog dialog, Rect insets) {
        this.f5262a = dialog;
        this.a = insets.left;
        this.b = insets.top;
        this.c = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    public boolean onTouch(View view, MotionEvent event) {
        View insetView = view.findViewById(16908290);
        int insetLeft = this.a + insetView.getLeft();
        int insetTop = this.b + insetView.getTop();
        if (new RectF((float) insetLeft, (float) insetTop, (float) (insetView.getWidth() + insetLeft), (float) (insetView.getHeight() + insetTop)).contains(event.getX(), event.getY())) {
            return false;
        }
        MotionEvent outsideEvent = MotionEvent.obtain(event);
        if (event.getAction() == 1) {
            outsideEvent.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            outsideEvent.setAction(0);
            int i = this.c;
            outsideEvent.setLocation((float) ((-i) - 1), (float) ((-i) - 1));
        }
        view.performClick();
        return this.f5262a.onTouchEvent(outsideEvent);
    }
}
