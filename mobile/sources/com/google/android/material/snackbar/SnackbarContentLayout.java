package com.google.android.material.snackbar;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SnackbarContentLayout extends LinearLayout implements pc {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private final TimeInterpolator f1895a;

    /* renamed from: a  reason: collision with other field name */
    private Button f1896a;

    /* renamed from: a  reason: collision with other field name */
    private TextView f1897a;

    public SnackbarContentLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.f1895a = i20.g(context, yb0.motionEasingEmphasizedInterpolator, f3.b);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1897a = (TextView) findViewById(ic0.snackbar_text);
        this.f1896a = (Button) findViewById(ic0.snackbar_action);
    }

    public TextView getMessageView() {
        return this.f1897a;
    }

    public Button getActionView() {
        return this.f1896a;
    }

    /* access modifiers changed from: package-private */
    public void c(float actionTextColorAlpha) {
        if (actionTextColorAlpha != 1.0f) {
            this.f1896a.setTextColor(k00.k(k00.d(this, yb0.colorSurface), this.f1896a.getCurrentTextColor(), actionTextColorAlpha));
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getOrientation() != 1) {
            int multiLineVPadding = getResources().getDimensionPixelSize(cc0.design_snackbar_padding_vertical_2lines);
            int singleLineVPadding = getResources().getDimensionPixelSize(cc0.design_snackbar_padding_vertical);
            Layout messageLayout = this.f1897a.getLayout();
            boolean isMultiLine = messageLayout != null && messageLayout.getLineCount() > 1;
            boolean remeasure = false;
            if (!isMultiLine || this.a <= 0 || this.f1896a.getMeasuredWidth() <= this.a) {
                int messagePadding = isMultiLine ? multiLineVPadding : singleLineVPadding;
                if (e(0, messagePadding, messagePadding)) {
                    remeasure = true;
                }
            } else if (e(1, multiLineVPadding, multiLineVPadding - singleLineVPadding)) {
                remeasure = true;
            }
            if (remeasure) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }
        }
    }

    private boolean e(int orientation, int messagePadTop, int messagePadBottom) {
        boolean changed = false;
        if (orientation != getOrientation()) {
            setOrientation(orientation);
            changed = true;
        }
        if (this.f1897a.getPaddingTop() == messagePadTop && this.f1897a.getPaddingBottom() == messagePadBottom) {
            return changed;
        }
        d(this.f1897a, messagePadTop, messagePadBottom);
        return true;
    }

    private static void d(View view, int topPadding, int bottomPadding) {
        if (ViewCompat.isPaddingRelative(view)) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), topPadding, ViewCompat.getPaddingEnd(view), bottomPadding);
        } else {
            view.setPadding(view.getPaddingLeft(), topPadding, view.getPaddingRight(), bottomPadding);
        }
    }

    public void a(int delay, int duration) {
        this.f1897a.setAlpha(0.0f);
        this.f1897a.animate().alpha(1.0f).setDuration((long) duration).setInterpolator(this.f1895a).setStartDelay((long) delay).start();
        if (this.f1896a.getVisibility() == 0) {
            this.f1896a.setAlpha(0.0f);
            this.f1896a.animate().alpha(1.0f).setDuration((long) duration).setInterpolator(this.f1895a).setStartDelay((long) delay).start();
        }
    }

    public void b(int delay, int duration) {
        this.f1897a.setAlpha(1.0f);
        this.f1897a.animate().alpha(0.0f).setDuration((long) duration).setInterpolator(this.f1895a).setStartDelay((long) delay).start();
        if (this.f1896a.getVisibility() == 0) {
            this.f1896a.setAlpha(1.0f);
            this.f1896a.animate().alpha(0.0f).setDuration((long) duration).setInterpolator(this.f1895a).setStartDelay((long) delay).start();
        }
    }

    public void setMaxInlineActionWidth(int width) {
        this.a = width;
    }
}
