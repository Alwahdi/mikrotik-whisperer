package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    private static final int[] b;
    private static final int[] c;

    /* renamed from: b  reason: collision with other field name */
    private final AccessibilityManager f1894b;
    private boolean e;

    static {
        int i = yb0.snackbarButtonStyle;
        b = new int[]{i};
        c = new int[]{i, yb0.snackbarTextViewStyle};
    }

    private Snackbar(Context context, ViewGroup parent, View content, pc contentViewCallback) {
        super(context, parent, content, contentViewCallback);
        this.f1894b = (AccessibilityManager) parent.getContext().getSystemService("accessibility");
    }

    public void V() {
        super.V();
    }

    public void x() {
        super.x();
    }

    public static Snackbar k0(View view, CharSequence text, int duration) {
        return l0((Context) null, view, text, duration);
    }

    private static Snackbar l0(Context context, View view, CharSequence text, int duration) {
        int i;
        ViewGroup parent = e0(view);
        if (parent != null) {
            if (context == null) {
                context = parent.getContext();
            }
            LayoutInflater inflater = LayoutInflater.from(context);
            if (i0(context)) {
                i = nc0.mtrl_layout_snackbar_include;
            } else {
                i = nc0.design_layout_snackbar_include;
            }
            SnackbarContentLayout content = (SnackbarContentLayout) inflater.inflate(i, parent, false);
            Snackbar snackbar = new Snackbar(context, parent, content, content);
            snackbar.n0(text);
            snackbar.R(duration);
            return snackbar;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    private static boolean i0(Context context) {
        TypedArray a = context.obtainStyledAttributes(c);
        int snackbarButtonStyleResId = a.getResourceId(0, -1);
        int snackbarTextViewStyleResId = a.getResourceId(1, -1);
        a.recycle();
        if (snackbarButtonStyleResId == -1 || snackbarTextViewStyleResId == -1) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: type inference failed for: r1v4, types: [android.view.ViewParent] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.view.ViewGroup e0(android.view.View r3) {
        /*
            r0 = 0
        L_0x0001:
            boolean r1 = r3 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout
            if (r1 == 0) goto L_0x0009
            r1 = r3
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            return r1
        L_0x0009:
            boolean r1 = r3 instanceof android.widget.FrameLayout
            if (r1 == 0) goto L_0x001d
            int r1 = r3.getId()
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            if (r1 != r2) goto L_0x001a
            r1 = r3
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            return r1
        L_0x001a:
            r0 = r3
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
        L_0x001d:
            if (r3 == 0) goto L_0x002d
            android.view.ViewParent r1 = r3.getParent()
            boolean r2 = r1 instanceof android.view.View
            if (r2 == 0) goto L_0x002b
            r2 = r1
            android.view.View r2 = (android.view.View) r2
            goto L_0x002c
        L_0x002b:
            r2 = 0
        L_0x002c:
            r3 = r2
        L_0x002d:
            if (r3 != 0) goto L_0x0030
            return r0
        L_0x0030:
            goto L_0x0001
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.Snackbar.e0(android.view.View):android.view.ViewGroup");
    }

    public Snackbar n0(CharSequence message) {
        h0().setText(message);
        return this;
    }

    public Snackbar m0(CharSequence text, View.OnClickListener listener) {
        TextView tv = f0();
        if (TextUtils.isEmpty(text) || listener == null) {
            tv.setVisibility(8);
            tv.setOnClickListener((View.OnClickListener) null);
            this.e = false;
        } else {
            this.e = true;
            tv.setVisibility(0);
            tv.setText(text);
            tv.setOnClickListener(new gm0(this, listener));
        }
        return this;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j0(View.OnClickListener listener, View view) {
        listener.onClick(view);
        y(1);
    }

    public int B() {
        int userSetDuration = super.B();
        if (userSetDuration == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return this.f1894b.getRecommendedTimeoutMillis(userSetDuration, (this.e ? 4 : 0) | 1 | 2);
        } else if (!this.e || !this.f1894b.isTouchExplorationEnabled()) {
            return userSetDuration;
        } else {
            return -2;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class SnackbarLayout extends BaseTransientBottomBar.s {
        public /* bridge */ /* synthetic */ void setBackground(@Nullable Drawable drawable) {
            super.setBackground(drawable);
        }

        public /* bridge */ /* synthetic */ void setBackgroundDrawable(@Nullable Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        public /* bridge */ /* synthetic */ void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        public /* bridge */ /* synthetic */ void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        public /* bridge */ /* synthetic */ void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
        }

        public /* bridge */ /* synthetic */ void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }

        public SnackbarLayout(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            int childCount = getChildCount();
            int availableWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i = 0; i < childCount; i++) {
                View child = getChildAt(i);
                if (child.getLayoutParams().width == -1) {
                    child.measure(View.MeasureSpec.makeMeasureSpec(availableWidth, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(child.getMeasuredHeight(), BasicMeasure.EXACTLY));
                }
            }
        }
    }

    private TextView h0() {
        return g0().getMessageView();
    }

    private Button f0() {
        return g0().getActionView();
    }

    private SnackbarContentLayout g0() {
        return (SnackbarContentLayout) this.f1868a.getChildAt(0);
    }
}
