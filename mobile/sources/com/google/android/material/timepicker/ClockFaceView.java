package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Arrays;

class ClockFaceView extends d implements ClockHandView.c {
    private float a;

    /* renamed from: a  reason: collision with other field name */
    private final ColorStateList f2094a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Rect f2095a;

    /* renamed from: a  reason: collision with other field name */
    private final RectF f2096a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final SparseArray<TextView> f2097a;

    /* renamed from: a  reason: collision with other field name */
    private final AccessibilityDelegateCompat f2098a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final ClockHandView f2099a;

    /* renamed from: a  reason: collision with other field name */
    private final float[] f2100a;

    /* renamed from: a  reason: collision with other field name */
    private final int[] f2101a;

    /* renamed from: a  reason: collision with other field name */
    private String[] f2102a;
    /* access modifiers changed from: private */
    public final int b;

    /* renamed from: b  reason: collision with other field name */
    private final Rect f2103b;
    private final int c;
    private final int d;
    private final int e;

    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, yb0.materialClockStyle);
    }

    public ClockFaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f2095a = new Rect();
        this.f2096a = new RectF();
        this.f2103b = new Rect();
        this.f2097a = new SparseArray<>();
        this.f2100a = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray a2 = context.obtainStyledAttributes(attrs, xc0.f5610G, defStyleAttr, uc0.Widget_MaterialComponents_TimePicker_Clock);
        Resources res = getResources();
        ColorStateList a3 = o00.a(context, a2, xc0.b1);
        this.f2094a = a3;
        LayoutInflater.from(context).inflate(nc0.material_clockface_view, this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(ic0.material_clock_hand);
        this.f2099a = clockHandView;
        this.b = res.getDimensionPixelSize(cc0.material_clock_hand_padding);
        int clockHandTextColor = a3.getColorForState(new int[]{16842913}, a3.getDefaultColor());
        this.f2101a = new int[]{clockHandTextColor, clockHandTextColor, a3.getDefaultColor()};
        clockHandView.b(this);
        int defaultBackgroundColor = AppCompatResources.getColorStateList(context, zb0.material_timepicker_clockface).getDefaultColor();
        ColorStateList backgroundColor = o00.a(context, a2, xc0.a1);
        setBackgroundColor(backgroundColor == null ? defaultBackgroundColor : backgroundColor.getDefaultColor());
        getViewTreeObserver().addOnPreDrawListener(new a());
        setFocusable(true);
        a2.recycle();
        this.f2098a = new b();
        String[] initialValues = new String[12];
        Arrays.fill(initialValues, "");
        r(initialValues, 0);
        this.c = res.getDimensionPixelSize(cc0.material_time_picker_minimum_screen_height);
        this.d = res.getDimensionPixelSize(cc0.material_time_picker_minimum_screen_width);
        this.e = res.getDimensionPixelSize(cc0.material_clock_size);
    }

    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        public boolean onPreDraw() {
            if (!ClockFaceView.this.isShown()) {
                return true;
            }
            ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ClockFaceView.this.f(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.f2099a.i()) - ClockFaceView.this.b);
            return true;
        }
    }

    class b extends AccessibilityDelegateCompat {
        b() {
        }

        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            super.onInitializeAccessibilityNodeInfo(host, info);
            int index = ((Integer) host.getTag(ic0.material_value_index)).intValue();
            if (index > 0) {
                info.setTraversalAfter((View) ClockFaceView.this.f2097a.get(index - 1));
            }
            info.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, index, 1, false, host.isSelected()));
            info.setClickable(true);
            info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        }

        public boolean performAccessibilityAction(View host, int action, Bundle args) {
            if (action == 16) {
                long time = SystemClock.uptimeMillis();
                host.getHitRect(ClockFaceView.this.f2095a);
                float y = (float) ClockFaceView.this.f2095a.centerY();
                long j = time;
                float centerX = (float) ClockFaceView.this.f2095a.centerX();
                float f = y;
                ClockFaceView.this.f2099a.onTouchEvent(MotionEvent.obtain(time, j, 0, centerX, f, 0));
                ClockFaceView.this.f2099a.onTouchEvent(MotionEvent.obtain(time, j, 1, centerX, f, 0));
                return true;
            }
            View view = host;
            return super.performAccessibilityAction(host, action, args);
        }
    }

    public void r(String[] values, int contentDescription) {
        this.f2102a = values;
        s(contentDescription);
    }

    /* JADX WARNING: type inference failed for: r6v6, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void s(int r11) {
        /*
            r10 = this;
            r0 = 0
            android.content.Context r1 = r10.getContext()
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r1)
            android.util.SparseArray<android.widget.TextView> r2 = r10.f2097a
            int r2 = r2.size()
            r3 = 0
        L_0x0010:
            java.lang.String[] r4 = r10.f2102a
            int r4 = r4.length
            int r4 = java.lang.Math.max(r4, r2)
            if (r3 >= r4) goto L_0x0085
            android.util.SparseArray<android.widget.TextView> r4 = r10.f2097a
            java.lang.Object r4 = r4.get(r3)
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.String[] r5 = r10.f2102a
            int r5 = r5.length
            if (r3 < r5) goto L_0x002f
            r10.removeView(r4)
            android.util.SparseArray<android.widget.TextView> r5 = r10.f2097a
            r5.remove(r3)
            goto L_0x0082
        L_0x002f:
            r5 = 0
            if (r4 != 0) goto L_0x0043
            int r6 = defpackage.nc0.material_clockface_textview
            android.view.View r6 = r1.inflate(r6, r10, r5)
            r4 = r6
            android.widget.TextView r4 = (android.widget.TextView) r4
            android.util.SparseArray<android.widget.TextView> r6 = r10.f2097a
            r6.put(r3, r4)
            r10.addView(r4)
        L_0x0043:
            java.lang.String[] r6 = r10.f2102a
            r6 = r6[r3]
            r4.setText(r6)
            int r6 = defpackage.ic0.material_value_index
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
            r4.setTag(r6, r7)
            int r6 = r3 / 12
            r7 = 1
            int r6 = r6 + r7
            int r8 = defpackage.ic0.material_clock_level
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)
            r4.setTag(r8, r9)
            if (r6 <= r7) goto L_0x0063
            r0 = 1
        L_0x0063:
            androidx.core.view.AccessibilityDelegateCompat r8 = r10.f2098a
            androidx.core.view.ViewCompat.setAccessibilityDelegate(r4, r8)
            android.content.res.ColorStateList r8 = r10.f2094a
            r4.setTextColor(r8)
            if (r11 == 0) goto L_0x0082
            android.content.res.Resources r8 = r10.getResources()
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.lang.String[] r9 = r10.f2102a
            r9 = r9[r3]
            r7[r5] = r9
            java.lang.String r5 = r8.getString(r11, r7)
            r4.setContentDescription(r5)
        L_0x0082:
            int r3 = r3 + 1
            goto L_0x0010
        L_0x0085:
            com.google.android.material.timepicker.ClockHandView r3 = r10.f2099a
            r3.q(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.timepicker.ClockFaceView.s(int):void");
    }

    /* access modifiers changed from: protected */
    public void h() {
        super.h();
        for (int i = 0; i < this.f2097a.size(); i++) {
            this.f2097a.get(i).setVisibility(0);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        AccessibilityNodeInfoCompat.wrap(info).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.f2102a.length, false, 1));
    }

    public void f(int radius) {
        if (radius != e()) {
            super.f(radius);
            this.f2099a.m(e());
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        n();
    }

    private void n() {
        RectF selectorBox = this.f2099a.e();
        TextView selected = p(selectorBox);
        for (int i = 0; i < this.f2097a.size(); i++) {
            TextView tv = this.f2097a.get(i);
            if (tv != null) {
                tv.setSelected(tv == selected);
                tv.getPaint().setShader(o(selectorBox, tv));
                tv.invalidate();
            }
        }
    }

    private TextView p(RectF selectorBox) {
        float minArea = Float.MAX_VALUE;
        TextView selected = null;
        for (int i = 0; i < this.f2097a.size(); i++) {
            TextView tv = this.f2097a.get(i);
            if (tv != null) {
                tv.getHitRect(this.f2095a);
                this.f2096a.set(this.f2095a);
                this.f2096a.union(selectorBox);
                float area = this.f2096a.width() * this.f2096a.height();
                if (area < minArea) {
                    minArea = area;
                    selected = tv;
                }
            }
        }
        return selected;
    }

    private RadialGradient o(RectF selectorBox, TextView tv) {
        tv.getHitRect(this.f2095a);
        this.f2096a.set(this.f2095a);
        tv.getLineBounds(0, this.f2103b);
        RectF rectF = this.f2096a;
        Rect rect = this.f2103b;
        rectF.inset((float) rect.left, (float) rect.top);
        if (!RectF.intersects(selectorBox, this.f2096a)) {
            return null;
        }
        return new RadialGradient(selectorBox.centerX() - this.f2096a.left, selectorBox.centerY() - this.f2096a.top, 0.5f * selectorBox.width(), this.f2101a, this.f2100a, Shader.TileMode.CLAMP);
    }

    public void a(float rotation, boolean animating) {
        if (Math.abs(this.a - rotation) > 0.001f) {
            this.a = rotation;
            n();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int size = (int) (((float) this.e) / q(((float) this.c) / ((float) displayMetrics.heightPixels), ((float) this.d) / ((float) displayMetrics.widthPixels), 1.0f));
        int spec = View.MeasureSpec.makeMeasureSpec(size, BasicMeasure.EXACTLY);
        setMeasuredDimension(size, size);
        super.onMeasure(spec, spec);
    }

    private static float q(float a2, float b2, float c2) {
        return Math.max(Math.max(a2, b2), c2);
    }
}
