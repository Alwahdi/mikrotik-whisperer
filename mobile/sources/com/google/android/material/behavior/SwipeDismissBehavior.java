package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.widget.ViewDragHelper;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private float a = 0.0f;

    /* renamed from: a  reason: collision with other field name */
    int f1476a = 2;

    /* renamed from: a  reason: collision with other field name */
    private final ViewDragHelper.Callback f1477a = new a();

    /* renamed from: a  reason: collision with other field name */
    ViewDragHelper f1478a;

    /* renamed from: a  reason: collision with other field name */
    c f1479a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f1480a;
    float b = 0.5f;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public boolean f1481b;
    float c = 0.0f;

    /* renamed from: c  reason: collision with other field name */
    private boolean f1482c;
    float d = 0.5f;

    public interface c {
        void a(int i);

        void b(View view);
    }

    public void h(c listener) {
        this.f1479a = listener;
    }

    public void j(int direction) {
        this.f1476a = direction;
    }

    public void i(float fraction) {
        this.c = c(0.0f, fraction, 1.0f);
    }

    public void g(float fraction) {
        this.d = c(0.0f, fraction, 1.0f);
    }

    public boolean onLayoutChild(CoordinatorLayout parent, V child, int layoutDirection) {
        boolean handled = super.onLayoutChild(parent, child, layoutDirection);
        if (ViewCompat.getImportantForAccessibility(child) == 0) {
            ViewCompat.setImportantForAccessibility(child, 1);
            k(child);
        }
        return handled;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        boolean dispatchEventToHelper = this.f1480a;
        switch (event.getActionMasked()) {
            case 0:
                this.f1480a = parent.isPointInChildBounds(child, (int) event.getX(), (int) event.getY());
                dispatchEventToHelper = this.f1480a;
                break;
            case 1:
            case 3:
                this.f1480a = false;
                break;
        }
        if (!dispatchEventToHelper) {
            return false;
        }
        e(parent);
        if (this.f1481b || !this.f1478a.shouldInterceptTouchEvent(event)) {
            return false;
        }
        return true;
    }

    public boolean onTouchEvent(CoordinatorLayout parent, V v, MotionEvent event) {
        if (this.f1478a == null) {
            return false;
        }
        if (this.f1481b && event.getActionMasked() == 3) {
            return true;
        }
        this.f1478a.processTouchEvent(event);
        return true;
    }

    public boolean b(View view) {
        return true;
    }

    class a extends ViewDragHelper.Callback {
        private int a;
        private int b = -1;

        a() {
        }

        public boolean tryCaptureView(View child, int pointerId) {
            int i = this.b;
            return (i == -1 || i == pointerId) && SwipeDismissBehavior.this.b(child);
        }

        public void onViewCaptured(View capturedChild, int activePointerId) {
            this.b = activePointerId;
            this.a = capturedChild.getLeft();
            ViewParent parent = capturedChild.getParent();
            if (parent != null) {
                boolean unused = SwipeDismissBehavior.this.f1481b = true;
                parent.requestDisallowInterceptTouchEvent(true);
                boolean unused2 = SwipeDismissBehavior.this.f1481b = false;
            }
        }

        public void onViewDragStateChanged(int state) {
            c cVar = SwipeDismissBehavior.this.f1479a;
            if (cVar != null) {
                cVar.a(state);
            }
        }

        public void onViewReleased(View child, float xVelocity, float yVelocity) {
            int targetLeft;
            c cVar;
            int i;
            int i2;
            this.b = -1;
            int childWidth = child.getWidth();
            boolean dismiss = false;
            if (a(child, xVelocity)) {
                if (xVelocity < 0.0f || child.getLeft() < (i2 = this.a)) {
                    i = this.a - childWidth;
                } else {
                    i = i2 + childWidth;
                }
                targetLeft = i;
                dismiss = true;
            } else {
                targetLeft = this.a;
            }
            if (SwipeDismissBehavior.this.f1478a.settleCapturedViewAt(targetLeft, child.getTop())) {
                ViewCompat.postOnAnimation(child, new d(child, dismiss));
            } else if (dismiss && (cVar = SwipeDismissBehavior.this.f1479a) != null) {
                cVar.b(child);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0026 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0035 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean a(android.view.View r7, float r8) {
            /*
                r6 = this;
                r0 = 0
                r1 = 0
                r2 = 1
                int r3 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r3 == 0) goto L_0x0039
                int r3 = androidx.core.view.ViewCompat.getLayoutDirection(r7)
                if (r3 != r2) goto L_0x0010
                r3 = 1
                goto L_0x0011
            L_0x0010:
                r3 = 0
            L_0x0011:
                com.google.android.material.behavior.SwipeDismissBehavior r4 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r4 = r4.f1476a
                r5 = 2
                if (r4 != r5) goto L_0x0019
                return r2
            L_0x0019:
                if (r4 != 0) goto L_0x0028
                if (r3 == 0) goto L_0x0022
                int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r0 >= 0) goto L_0x0027
                goto L_0x0026
            L_0x0022:
                int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r0 <= 0) goto L_0x0027
            L_0x0026:
                r1 = 1
            L_0x0027:
                return r1
            L_0x0028:
                if (r4 != r2) goto L_0x0037
                if (r3 == 0) goto L_0x0031
                int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r0 <= 0) goto L_0x0036
                goto L_0x0035
            L_0x0031:
                int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r0 >= 0) goto L_0x0036
            L_0x0035:
                r1 = 1
            L_0x0036:
                return r1
            L_0x0037:
                return r1
            L_0x0039:
                int r0 = r7.getLeft()
                int r3 = r6.a
                int r0 = r0 - r3
                int r3 = r7.getWidth()
                float r3 = (float) r3
                com.google.android.material.behavior.SwipeDismissBehavior r4 = com.google.android.material.behavior.SwipeDismissBehavior.this
                float r4 = r4.b
                float r3 = r3 * r4
                int r3 = java.lang.Math.round(r3)
                int r4 = java.lang.Math.abs(r0)
                if (r4 < r3) goto L_0x0056
                r1 = 1
            L_0x0056:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.a.a(android.view.View, float):boolean");
        }

        public int getViewHorizontalDragRange(View child) {
            return child.getWidth();
        }

        public int clampViewPositionHorizontal(View child, int left, int dx) {
            int max;
            int min;
            boolean isRtl = ViewCompat.getLayoutDirection(child) == 1;
            int max2 = SwipeDismissBehavior.this.f1476a;
            if (max2 == 0) {
                if (isRtl) {
                    min = this.a - child.getWidth();
                    max = this.a;
                } else {
                    min = this.a;
                    max = this.a + child.getWidth();
                }
            } else if (max2 != 1) {
                min = this.a - child.getWidth();
                max = this.a + child.getWidth();
            } else if (isRtl) {
                min = this.a;
                max = this.a + child.getWidth();
            } else {
                min = this.a - child.getWidth();
                max = this.a;
            }
            return SwipeDismissBehavior.d(min, left, max);
        }

        public int clampViewPositionVertical(View child, int top, int dy) {
            return child.getTop();
        }

        public void onViewPositionChanged(View child, int left, int top, int dx, int dy) {
            float startAlphaDistance = ((float) child.getWidth()) * SwipeDismissBehavior.this.c;
            float endAlphaDistance = ((float) child.getWidth()) * SwipeDismissBehavior.this.d;
            float currentDistance = (float) Math.abs(left - this.a);
            if (currentDistance <= startAlphaDistance) {
                child.setAlpha(1.0f);
            } else if (currentDistance >= endAlphaDistance) {
                child.setAlpha(0.0f);
            } else {
                child.setAlpha(SwipeDismissBehavior.c(0.0f, 1.0f - SwipeDismissBehavior.f(startAlphaDistance, endAlphaDistance, currentDistance), 1.0f));
            }
        }
    }

    private void e(ViewGroup parent) {
        ViewDragHelper viewDragHelper;
        if (this.f1478a == null) {
            if (this.f1482c) {
                viewDragHelper = ViewDragHelper.create(parent, this.a, this.f1477a);
            } else {
                viewDragHelper = ViewDragHelper.create(parent, this.f1477a);
            }
            this.f1478a = viewDragHelper;
        }
    }

    private class d implements Runnable {
        private final View a;

        /* renamed from: a  reason: collision with other field name */
        private final boolean f1485a;

        d(View view, boolean dismiss) {
            this.a = view;
            this.f1485a = dismiss;
        }

        public void run() {
            c cVar;
            ViewDragHelper viewDragHelper = SwipeDismissBehavior.this.f1478a;
            if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.a, this);
            } else if (this.f1485a && (cVar = SwipeDismissBehavior.this.f1479a) != null) {
                cVar.b(this.a);
            }
        }
    }

    private void k(View child) {
        ViewCompat.removeAccessibilityAction(child, 1048576);
        if (b(child)) {
            ViewCompat.replaceAccessibilityAction(child, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, (CharSequence) null, new b());
        }
    }

    class b implements AccessibilityViewCommand {
        b() {
        }

        public boolean perform(View view, AccessibilityViewCommand.CommandArguments arguments) {
            boolean dismissToLeft = false;
            if (!SwipeDismissBehavior.this.b(view)) {
                return false;
            }
            boolean isRtl = ViewCompat.getLayoutDirection(view) == 1;
            int i = SwipeDismissBehavior.this.f1476a;
            if ((i == 0 && isRtl) || (i == 1 && !isRtl)) {
                dismissToLeft = true;
            }
            int offset = view.getWidth();
            if (dismissToLeft) {
                offset = -offset;
            }
            ViewCompat.offsetLeftAndRight(view, offset);
            view.setAlpha(0.0f);
            c cVar = SwipeDismissBehavior.this.f1479a;
            if (cVar != null) {
                cVar.b(view);
            }
            return true;
        }
    }

    static float c(float min, float value, float max) {
        return Math.min(Math.max(min, value), max);
    }

    static int d(int min, int value, int max) {
        return Math.min(Math.max(min, value), max);
    }

    static float f(float startValue, float endValue, float value) {
        return (value - startValue) / (endValue - startValue);
    }
}
