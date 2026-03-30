package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;

public final class ViewKt {
    public static final void doOnNextLayout(View $this$doOnNextLayout, vn<? super View, jt0> action) {
        lu.f($this$doOnNextLayout, "<this>");
        lu.f(action, "action");
        $this$doOnNextLayout.addOnLayoutChangeListener(new ViewKt$doOnNextLayout$1(action));
    }

    public static final void doOnLayout(View $this$doOnLayout, vn<? super View, jt0> action) {
        lu.f($this$doOnLayout, "<this>");
        lu.f(action, "action");
        if (!ViewCompat.isLaidOut($this$doOnLayout) || $this$doOnLayout.isLayoutRequested()) {
            $this$doOnLayout.addOnLayoutChangeListener(new ViewKt$doOnLayout$$inlined$doOnNextLayout$1(action));
        } else {
            action.invoke($this$doOnLayout);
        }
    }

    public static final OneShotPreDrawListener doOnPreDraw(View $this$doOnPreDraw, vn<? super View, jt0> action) {
        lu.f($this$doOnPreDraw, "<this>");
        lu.f(action, "action");
        OneShotPreDrawListener add = OneShotPreDrawListener.add($this$doOnPreDraw, new ViewKt$doOnPreDraw$1(action, $this$doOnPreDraw));
        lu.e(add, "View.doOnPreDraw(\n    cr…dd(this) { action(this) }");
        return add;
    }

    public static final void doOnAttach(View $this$doOnAttach, vn<? super View, jt0> action) {
        lu.f($this$doOnAttach, "<this>");
        lu.f(action, "action");
        if (ViewCompat.isAttachedToWindow($this$doOnAttach)) {
            action.invoke($this$doOnAttach);
        } else {
            $this$doOnAttach.addOnAttachStateChangeListener(new ViewKt$doOnAttach$1($this$doOnAttach, action));
        }
    }

    public static final void doOnDetach(View $this$doOnDetach, vn<? super View, jt0> action) {
        lu.f($this$doOnDetach, "<this>");
        lu.f(action, "action");
        if (!ViewCompat.isAttachedToWindow($this$doOnDetach)) {
            action.invoke($this$doOnDetach);
        } else {
            $this$doOnDetach.addOnAttachStateChangeListener(new ViewKt$doOnDetach$1($this$doOnDetach, action));
        }
    }

    public static /* synthetic */ void updatePaddingRelative$default(View $this$updatePaddingRelative_u24default, int start, int top, int end, int bottom, int i, Object obj) {
        if ((i & 1) != 0) {
            start = $this$updatePaddingRelative_u24default.getPaddingStart();
        }
        if ((i & 2) != 0) {
            top = $this$updatePaddingRelative_u24default.getPaddingTop();
        }
        if ((i & 4) != 0) {
            end = $this$updatePaddingRelative_u24default.getPaddingEnd();
        }
        if ((i & 8) != 0) {
            bottom = $this$updatePaddingRelative_u24default.getPaddingBottom();
        }
        lu.f($this$updatePaddingRelative_u24default, "<this>");
        $this$updatePaddingRelative_u24default.setPaddingRelative(start, top, end, bottom);
    }

    @RequiresApi(17)
    public static final void updatePaddingRelative(View $this$updatePaddingRelative, @Px int start, @Px int top, @Px int end, @Px int bottom) {
        lu.f($this$updatePaddingRelative, "<this>");
        $this$updatePaddingRelative.setPaddingRelative(start, top, end, bottom);
    }

    public static /* synthetic */ void updatePadding$default(View $this$updatePadding_u24default, int left, int top, int right, int bottom, int i, Object obj) {
        if ((i & 1) != 0) {
            left = $this$updatePadding_u24default.getPaddingLeft();
        }
        if ((i & 2) != 0) {
            top = $this$updatePadding_u24default.getPaddingTop();
        }
        if ((i & 4) != 0) {
            right = $this$updatePadding_u24default.getPaddingRight();
        }
        if ((i & 8) != 0) {
            bottom = $this$updatePadding_u24default.getPaddingBottom();
        }
        lu.f($this$updatePadding_u24default, "<this>");
        $this$updatePadding_u24default.setPadding(left, top, right, bottom);
    }

    public static final void updatePadding(View $this$updatePadding, @Px int left, @Px int top, @Px int right, @Px int bottom) {
        lu.f($this$updatePadding, "<this>");
        $this$updatePadding.setPadding(left, top, right, bottom);
    }

    public static final void setPadding(View $this$setPadding, @Px int size) {
        lu.f($this$setPadding, "<this>");
        $this$setPadding.setPadding(size, size, size, size);
    }

    public static final Runnable postDelayed(View $this$postDelayed, long delayInMillis, tn<jt0> action) {
        lu.f($this$postDelayed, "<this>");
        lu.f(action, "action");
        Runnable runnable = new ViewKt$postDelayed$runnable$1(action);
        $this$postDelayed.postDelayed(runnable, delayInMillis);
        return runnable;
    }

    @RequiresApi(16)
    public static final Runnable postOnAnimationDelayed(View $this$postOnAnimationDelayed, long delayInMillis, tn<jt0> action) {
        lu.f($this$postOnAnimationDelayed, "<this>");
        lu.f(action, "action");
        Runnable runnable = new fv0(action);
        Api16Impl.postOnAnimationDelayed($this$postOnAnimationDelayed, runnable, delayInMillis);
        return runnable;
    }

    /* access modifiers changed from: private */
    /* renamed from: postOnAnimationDelayed$lambda-1  reason: not valid java name */
    public static final void m0postOnAnimationDelayed$lambda1(tn $action) {
        lu.f($action, "$action");
        $action.invoke();
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View view, Bitmap.Config config, int i, Object obj) {
        if ((i & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return drawToBitmap(view, config);
    }

    public static final Bitmap drawToBitmap(View $this$drawToBitmap, Bitmap.Config config) {
        lu.f($this$drawToBitmap, "<this>");
        lu.f(config, "config");
        if (ViewCompat.isLaidOut($this$drawToBitmap)) {
            Bitmap $this$applyCanvas$iv = Bitmap.createBitmap($this$drawToBitmap.getWidth(), $this$drawToBitmap.getHeight(), config);
            lu.e($this$applyCanvas$iv, "createBitmap(width, height, config)");
            Canvas $this$drawToBitmap_u24lambda_u2d2 = new Canvas($this$applyCanvas$iv);
            $this$drawToBitmap_u24lambda_u2d2.translate(-((float) $this$drawToBitmap.getScrollX()), -((float) $this$drawToBitmap.getScrollY()));
            $this$drawToBitmap.draw($this$drawToBitmap_u24lambda_u2d2);
            return $this$applyCanvas$iv;
        }
        throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
    }

    public static final boolean isVisible(View $this$isVisible) {
        lu.f($this$isVisible, "<this>");
        return $this$isVisible.getVisibility() == 0;
    }

    public static final void setVisible(View $this$isVisible, boolean value) {
        lu.f($this$isVisible, "<this>");
        $this$isVisible.setVisibility(value ? 0 : 8);
    }

    public static final boolean isInvisible(View $this$isInvisible) {
        lu.f($this$isInvisible, "<this>");
        return $this$isInvisible.getVisibility() == 4;
    }

    public static final void setInvisible(View $this$isInvisible, boolean value) {
        lu.f($this$isInvisible, "<this>");
        $this$isInvisible.setVisibility(value ? 4 : 0);
    }

    public static final boolean isGone(View $this$isGone) {
        lu.f($this$isGone, "<this>");
        return $this$isGone.getVisibility() == 8;
    }

    public static final void setGone(View $this$isGone, boolean value) {
        lu.f($this$isGone, "<this>");
        $this$isGone.setVisibility(value ? 8 : 0);
    }

    public static final void updateLayoutParams(View $this$updateLayoutParams, vn<? super ViewGroup.LayoutParams, jt0> block) {
        lu.f($this$updateLayoutParams, "<this>");
        lu.f(block, "block");
        View $this$updateLayoutParams$iv = $this$updateLayoutParams;
        ViewGroup.LayoutParams params$iv = $this$updateLayoutParams$iv.getLayoutParams();
        if (params$iv != null) {
            block.invoke(params$iv);
            $this$updateLayoutParams$iv.setLayoutParams(params$iv);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public static final /* synthetic */ <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(View $this$updateLayoutParams, vn<? super T, jt0> block) {
        lu.f($this$updateLayoutParams, "<this>");
        lu.f(block, "block");
        ViewGroup.LayoutParams params = $this$updateLayoutParams.getLayoutParams();
        lu.j(1, "T");
        block.invoke(params);
        $this$updateLayoutParams.setLayoutParams(params);
    }

    public static final int getMarginLeft(View $this$marginLeft) {
        lu.f($this$marginLeft, "<this>");
        ViewGroup.LayoutParams layoutParams = $this$marginLeft.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.leftMargin;
        }
        return 0;
    }

    public static final int getMarginTop(View $this$marginTop) {
        lu.f($this$marginTop, "<this>");
        ViewGroup.LayoutParams layoutParams = $this$marginTop.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.topMargin;
        }
        return 0;
    }

    public static final int getMarginRight(View $this$marginRight) {
        lu.f($this$marginRight, "<this>");
        ViewGroup.LayoutParams layoutParams = $this$marginRight.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.rightMargin;
        }
        return 0;
    }

    public static final int getMarginBottom(View $this$marginBottom) {
        lu.f($this$marginBottom, "<this>");
        ViewGroup.LayoutParams layoutParams = $this$marginBottom.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.bottomMargin;
        }
        return 0;
    }

    public static final int getMarginStart(View $this$marginStart) {
        lu.f($this$marginStart, "<this>");
        ViewGroup.LayoutParams lp = $this$marginStart.getLayoutParams();
        if (lp instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) lp);
        }
        return 0;
    }

    public static final int getMarginEnd(View $this$marginEnd) {
        lu.f($this$marginEnd, "<this>");
        ViewGroup.LayoutParams lp = $this$marginEnd.getLayoutParams();
        if (lp instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) lp);
        }
        return 0;
    }

    public static final ck0<ViewParent> getAncestors(View $this$ancestors) {
        lu.f($this$ancestors, "<this>");
        return ik0.e($this$ancestors.getParent(), ViewKt$ancestors$1.INSTANCE);
    }

    public static final ck0<View> getAllViews(View $this$allViews) {
        lu.f($this$allViews, "<this>");
        return gk0.b(new ViewKt$allViews$1($this$allViews, (rc<? super ViewKt$allViews$1>) null));
    }
}
