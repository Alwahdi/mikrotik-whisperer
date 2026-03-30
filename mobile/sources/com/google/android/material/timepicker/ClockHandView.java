package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;

class ClockHandView extends View {
    private double a;

    /* renamed from: a  reason: collision with other field name */
    private float f2104a;

    /* renamed from: a  reason: collision with other field name */
    private final int f2105a;

    /* renamed from: a  reason: collision with other field name */
    private final TimeInterpolator f2106a;

    /* renamed from: a  reason: collision with other field name */
    private final ValueAnimator f2107a;

    /* renamed from: a  reason: collision with other field name */
    private final Paint f2108a;

    /* renamed from: a  reason: collision with other field name */
    private final RectF f2109a;

    /* renamed from: a  reason: collision with other field name */
    private b f2110a;

    /* renamed from: a  reason: collision with other field name */
    private final List<c> f2111a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f2112a;
    private float b;

    /* renamed from: b  reason: collision with other field name */
    private final int f2113b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f2114b;
    private final float c;

    /* renamed from: c  reason: collision with other field name */
    private final int f2115c;

    /* renamed from: c  reason: collision with other field name */
    private boolean f2116c;
    private float d;

    /* renamed from: d  reason: collision with other field name */
    private final int f2117d;

    /* renamed from: d  reason: collision with other field name */
    private boolean f2118d;
    private int e;
    private int f;

    public interface b {
        void a(float f, boolean z);
    }

    public interface c {
        void a(float f, boolean z);
    }

    public ClockHandView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, yb0.materialClockStyle);
    }

    public ClockHandView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f2107a = new ValueAnimator();
        this.f2111a = new ArrayList();
        Paint paint = new Paint();
        this.f2108a = paint;
        this.f2109a = new RectF();
        this.f = 1;
        TypedArray a2 = context.obtainStyledAttributes(attrs, xc0.f5613H, defStyleAttr, uc0.Widget_MaterialComponents_TimePicker_Clock);
        this.f2105a = i20.f(context, yb0.motionDurationLong2, 200);
        this.f2106a = i20.g(context, yb0.motionEasingEmphasizedInterpolator, f3.b);
        this.e = a2.getDimensionPixelSize(xc0.d1, 0);
        this.f2115c = a2.getDimensionPixelSize(xc0.e1, 0);
        Resources res = getResources();
        this.f2117d = res.getDimensionPixelSize(cc0.material_clock_hand_stroke_width);
        this.c = (float) res.getDimensionPixelSize(cc0.material_clock_hand_center_dot_radius);
        int selectorColor = a2.getColor(xc0.c1, 0);
        paint.setAntiAlias(true);
        paint.setColor(selectorColor);
        n(0.0f);
        this.f2113b = ViewConfiguration.get(context).getScaledTouchSlop();
        ViewCompat.setImportantForAccessibility(this, 2);
        a2.recycle();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (!this.f2107a.isRunning()) {
            n(g());
        }
    }

    public void n(float degrees) {
        o(degrees, false);
    }

    public void o(float degrees, boolean animate) {
        ValueAnimator valueAnimator = this.f2107a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!animate) {
            p(degrees, false);
            return;
        }
        Pair<Float, Float> animationValues = j(degrees);
        this.f2107a.setFloatValues(new float[]{((Float) animationValues.first).floatValue(), ((Float) animationValues.second).floatValue()});
        this.f2107a.setDuration((long) this.f2105a);
        this.f2107a.setInterpolator(this.f2106a);
        this.f2107a.addUpdateListener(new a(this));
        this.f2107a.addListener(new a());
        this.f2107a.start();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(ValueAnimator animation) {
        p(((Float) animation.getAnimatedValue()).floatValue(), true);
    }

    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationCancel(Animator animation) {
            animation.end();
        }
    }

    private Pair<Float, Float> j(float degrees) {
        float currentDegrees = g();
        if (Math.abs(currentDegrees - degrees) > 180.0f) {
            if (currentDegrees > 180.0f && degrees < 180.0f) {
                degrees += 360.0f;
            }
            if (currentDegrees < 180.0f && degrees > 180.0f) {
                currentDegrees += 360.0f;
            }
        }
        return new Pair<>(Float.valueOf(currentDegrees), Float.valueOf(degrees));
    }

    private void p(float degrees, boolean animate) {
        float degrees2 = degrees % 360.0f;
        this.d = degrees2;
        this.a = Math.toRadians((double) (degrees2 - 90.0f));
        int leveledCircleRadius = h(this.f);
        float selCenterX = ((float) (getWidth() / 2)) + (((float) leveledCircleRadius) * ((float) Math.cos(this.a)));
        float selCenterY = ((float) (getHeight() / 2)) + (((float) leveledCircleRadius) * ((float) Math.sin(this.a)));
        RectF rectF = this.f2109a;
        int i = this.f2115c;
        rectF.set(selCenterX - ((float) i), selCenterY - ((float) i), ((float) i) + selCenterX, ((float) i) + selCenterY);
        for (c listener : this.f2111a) {
            listener.a(degrees2, animate);
        }
        invalidate();
    }

    public void b(c listener) {
        this.f2111a.add(listener);
    }

    public float g() {
        return this.d;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d(canvas);
    }

    private void d(Canvas canvas) {
        Canvas canvas2 = canvas;
        int yCenter = getHeight() / 2;
        int xCenter = getWidth() / 2;
        int leveledCircleRadius = h(this.f);
        float selCenterX = ((float) xCenter) + (((float) leveledCircleRadius) * ((float) Math.cos(this.a)));
        float selCenterY = ((float) yCenter) + (((float) leveledCircleRadius) * ((float) Math.sin(this.a)));
        this.f2108a.setStrokeWidth(0.0f);
        canvas2.drawCircle(selCenterX, selCenterY, (float) this.f2115c, this.f2108a);
        double sin = Math.sin(this.a);
        double cos = Math.cos(this.a);
        float lineLength = (float) (leveledCircleRadius - this.f2115c);
        float linePointX = (float) (((int) (((double) lineLength) * cos)) + xCenter);
        this.f2108a.setStrokeWidth((float) this.f2117d);
        Canvas canvas3 = canvas;
        float linePointY = (float) (((int) (((double) lineLength) * sin)) + yCenter);
        float f2 = linePointX;
        float f3 = lineLength;
        canvas3.drawLine((float) xCenter, (float) yCenter, linePointX, linePointY, this.f2108a);
        canvas2.drawCircle((float) xCenter, (float) yCenter, this.c, this.f2108a);
    }

    public RectF e() {
        return this.f2109a;
    }

    public int i() {
        return this.f2115c;
    }

    public void m(int circleRadius) {
        this.e = circleRadius;
        invalidate();
    }

    public boolean onTouchEvent(MotionEvent event) {
        b bVar;
        int action = event.getActionMasked();
        boolean forceSelection = false;
        boolean actionDown = false;
        boolean actionUp = false;
        float x = event.getX();
        float y = event.getY();
        boolean z = false;
        switch (action) {
            case 0:
                this.f2104a = x;
                this.b = y;
                this.f2114b = true;
                this.f2118d = false;
                actionDown = true;
                break;
            case 1:
            case 2:
                int deltaX = (int) (x - this.f2104a);
                int deltaY = (int) (y - this.b);
                this.f2114b = (deltaX * deltaX) + (deltaY * deltaY) > this.f2113b;
                if (this.f2118d) {
                    forceSelection = true;
                }
                if (action == 1) {
                    z = true;
                }
                actionUp = z;
                if (this.f2116c) {
                    c(x, y);
                    break;
                }
                break;
        }
        boolean k = k(x, y, forceSelection, actionDown, actionUp) | this.f2118d;
        this.f2118d = k;
        if (k && actionUp && (bVar = this.f2110a) != null) {
            bVar.a((float) f(x, y), this.f2114b);
        }
        return true;
    }

    private void c(float x, float y) {
        int i = 2;
        if (v00.a((float) (getWidth() / 2), (float) (getHeight() / 2), x, y) > ((float) h(2)) + lv0.c(getContext(), 12)) {
            i = 1;
        }
        this.f = i;
    }

    private boolean k(float x, float y, boolean forceSelection, boolean touchDown, boolean actionUp) {
        int degrees = f(x, y);
        boolean z = false;
        boolean valueChanged = g() != ((float) degrees);
        if (touchDown && valueChanged) {
            return true;
        }
        if (!valueChanged && !forceSelection) {
            return false;
        }
        float f2 = (float) degrees;
        if (actionUp && this.f2112a) {
            z = true;
        }
        o(f2, z);
        return true;
    }

    private int f(float x, float y) {
        int degrees = ((int) Math.toDegrees(Math.atan2((double) (y - ((float) (getHeight() / 2))), (double) (x - ((float) (getWidth() / 2)))))) + 90;
        if (degrees < 0) {
            return degrees + 360;
        }
        return degrees;
    }

    /* access modifiers changed from: package-private */
    public void q(boolean isMultiLevel) {
        if (this.f2116c && !isMultiLevel) {
            this.f = 1;
        }
        this.f2116c = isMultiLevel;
        invalidate();
    }

    private int h(int level) {
        return level == 2 ? Math.round(((float) this.e) * 0.66f) : this.e;
    }
}
