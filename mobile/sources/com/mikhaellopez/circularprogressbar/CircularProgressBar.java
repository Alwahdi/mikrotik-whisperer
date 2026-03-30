package com.mikhaellopez.circularprogressbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;

public final class CircularProgressBar extends View {
    public static final a a = new a((Cif) null);

    /* renamed from: a  reason: collision with other field name */
    private float f2646a;

    /* renamed from: a  reason: collision with other field name */
    private int f2647a;

    /* renamed from: a  reason: collision with other field name */
    private ValueAnimator f2648a;

    /* renamed from: a  reason: collision with other field name */
    private Paint f2649a;

    /* renamed from: a  reason: collision with other field name */
    private RectF f2650a = new RectF();

    /* renamed from: a  reason: collision with other field name */
    private Handler f2651a;

    /* renamed from: a  reason: collision with other field name */
    private b f2652a;

    /* renamed from: a  reason: collision with other field name */
    private c f2653a;

    /* renamed from: a  reason: collision with other field name */
    private Integer f2654a;

    /* renamed from: a  reason: collision with other field name */
    private final Runnable f2655a;

    /* renamed from: a  reason: collision with other field name */
    private vn<? super Float, jt0> f2656a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f2657a;
    private float b;

    /* renamed from: b  reason: collision with other field name */
    private int f2658b;

    /* renamed from: b  reason: collision with other field name */
    private Paint f2659b;

    /* renamed from: b  reason: collision with other field name */
    private b f2660b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public c f2661b;

    /* renamed from: b  reason: collision with other field name */
    private Integer f2662b;

    /* renamed from: b  reason: collision with other field name */
    private vn<? super Boolean, jt0> f2663b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f2664b;
    private float c;

    /* renamed from: c  reason: collision with other field name */
    private Integer f2665c;
    private float d;

    /* renamed from: d  reason: collision with other field name */
    private Integer f2666d;
    private float e;
    private float f;
    private float g;

    public final void setProgressWithAnimation(float f2) {
        r(this, f2, (Long) null, (TimeInterpolator) null, (Long) null, 14, (Object) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CircularProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        lu.g(context, "context");
        Paint paint = new Paint();
        Paint $this$apply = paint;
        $this$apply.setAntiAlias(true);
        $this$apply.setStyle(Paint.Style.STROKE);
        this.f2649a = paint;
        Paint paint2 = new Paint();
        Paint $this$apply2 = paint2;
        $this$apply2.setAntiAlias(true);
        $this$apply2.setStyle(Paint.Style.STROKE);
        this.f2659b = paint2;
        this.b = 100.0f;
        this.c = getResources().getDimension(dc0.default_stroke_width);
        this.d = getResources().getDimension(dc0.default_background_stroke_width);
        this.f2647a = ViewCompat.MEASURED_STATE_MASK;
        b bVar = b.LEFT_TO_RIGHT;
        this.f2652a = bVar;
        this.f2658b = -7829368;
        this.f2660b = bVar;
        this.e = 270.0f;
        c cVar = c.TO_RIGHT;
        this.f2653a = cVar;
        this.f2661b = cVar;
        this.g = 270.0f;
        this.f2655a = new d(this);
        j(context, attrs);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(Cif $constructor_marker) {
            this();
        }
    }

    public final float getProgress() {
        return this.f2646a;
    }

    public final void setProgress(float value) {
        float f2 = this.f2646a;
        float f3 = this.b;
        if (f2 <= f3) {
            f3 = value;
        }
        this.f2646a = f3;
        vn<? super Float, jt0> vnVar = this.f2656a;
        if (vnVar != null) {
            jt0 invoke = vnVar.invoke(Float.valueOf(f3));
        }
        invalidate();
    }

    public final float getProgressMax() {
        return this.b;
    }

    public final void setProgressMax(float value) {
        this.b = this.b >= ((float) 0) ? value : 100.0f;
        invalidate();
    }

    public final float getProgressBarWidth() {
        return this.c;
    }

    public final void setProgressBarWidth(float value) {
        float i = i(value);
        this.c = i;
        this.f2659b.setStrokeWidth(i);
        requestLayout();
        invalidate();
    }

    public final float getBackgroundProgressBarWidth() {
        return this.d;
    }

    public final void setBackgroundProgressBarWidth(float value) {
        float i = i(value);
        this.d = i;
        this.f2649a.setStrokeWidth(i);
        requestLayout();
        invalidate();
    }

    public final int getProgressBarColor() {
        return this.f2647a;
    }

    public final void setProgressBarColor(int value) {
        this.f2647a = value;
        m();
        invalidate();
    }

    public final Integer getProgressBarColorStart() {
        return this.f2654a;
    }

    public final void setProgressBarColorStart(Integer value) {
        this.f2654a = value;
        m();
        invalidate();
    }

    public final Integer getProgressBarColorEnd() {
        return this.f2662b;
    }

    public final void setProgressBarColorEnd(Integer value) {
        this.f2662b = value;
        m();
        invalidate();
    }

    public final b getProgressBarColorDirection() {
        return this.f2652a;
    }

    public final void setProgressBarColorDirection(b value) {
        lu.g(value, "value");
        this.f2652a = value;
        m();
        invalidate();
    }

    public final int getBackgroundProgressBarColor() {
        return this.f2658b;
    }

    public final void setBackgroundProgressBarColor(int value) {
        this.f2658b = value;
        l();
        invalidate();
    }

    public final Integer getBackgroundProgressBarColorStart() {
        return this.f2665c;
    }

    public final void setBackgroundProgressBarColorStart(Integer value) {
        this.f2665c = value;
        l();
        invalidate();
    }

    public final Integer getBackgroundProgressBarColorEnd() {
        return this.f2666d;
    }

    public final void setBackgroundProgressBarColorEnd(Integer value) {
        this.f2666d = value;
        l();
        invalidate();
    }

    public final b getBackgroundProgressBarColorDirection() {
        return this.f2660b;
    }

    public final void setBackgroundProgressBarColorDirection(b value) {
        lu.g(value, "value");
        this.f2660b = value;
        l();
        invalidate();
    }

    public final boolean getRoundBorder() {
        return this.f2657a;
    }

    public final void setRoundBorder(boolean value) {
        this.f2657a = value;
        this.f2659b.setStrokeCap(value ? Paint.Cap.ROUND : Paint.Cap.BUTT);
        invalidate();
    }

    public final float getStartAngle() {
        return this.e;
    }

    public final void setStartAngle(float value) {
        float f2;
        float angle = 270.0f + value;
        while (true) {
            f2 = (float) 360;
            if (angle <= f2) {
                break;
            }
            angle -= f2;
        }
        this.e = angle < ((float) 0) ? 0.0f : angle > f2 ? 360.0f : angle;
        invalidate();
    }

    public final c getProgressDirection() {
        return this.f2653a;
    }

    public final void setProgressDirection(c value) {
        lu.g(value, "value");
        this.f2653a = value;
        invalidate();
    }

    public final boolean getIndeterminateMode() {
        return this.f2664b;
    }

    public final void setIndeterminateMode(boolean value) {
        this.f2664b = value;
        vn<? super Boolean, jt0> vnVar = this.f2663b;
        if (vnVar != null) {
            jt0 invoke = vnVar.invoke(Boolean.valueOf(value));
        }
        setProgressIndeterminateMode(0.0f);
        setProgressDirectionIndeterminateMode(c.TO_RIGHT);
        setStartAngleIndeterminateMode(270.0f);
        Handler handler = this.f2651a;
        if (handler != null) {
            handler.removeCallbacks(this.f2655a);
        }
        ValueAnimator valueAnimator = this.f2648a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        Handler handler2 = new Handler();
        this.f2651a = handler2;
        if (this.f2664b) {
            handler2.post(this.f2655a);
        }
    }

    public final vn<Float, jt0> getOnProgressChangeListener() {
        return this.f2656a;
    }

    public final void setOnProgressChangeListener(vn<? super Float, jt0> vnVar) {
        this.f2656a = vnVar;
    }

    public final vn<Boolean, jt0> getOnIndeterminateModeChangeListener() {
        return this.f2663b;
    }

    public final void setOnIndeterminateModeChangeListener(vn<? super Boolean, jt0> vnVar) {
        this.f2663b = vnVar;
    }

    /* access modifiers changed from: private */
    public final void setProgressIndeterminateMode(float value) {
        this.f = value;
        invalidate();
    }

    /* access modifiers changed from: private */
    public final void setProgressDirectionIndeterminateMode(c value) {
        this.f2661b = value;
        invalidate();
    }

    /* access modifiers changed from: private */
    public final void setStartAngleIndeterminateMode(float value) {
        this.g = value;
        invalidate();
    }

    static final class d implements Runnable {
        final /* synthetic */ CircularProgressBar a;

        d(CircularProgressBar circularProgressBar) {
            this.a = circularProgressBar;
        }

        public final void run() {
            if (this.a.getIndeterminateMode()) {
                this.a.n();
                CircularProgressBar circularProgressBar = this.a;
                circularProgressBar.setProgressDirectionIndeterminateMode(circularProgressBar.p(circularProgressBar.f2661b));
                CircularProgressBar circularProgressBar2 = this.a;
                if (circularProgressBar2.k(circularProgressBar2.f2661b)) {
                    CircularProgressBar.r(this.a, 0.0f, 1500L, (TimeInterpolator) null, (Long) null, 12, (Object) null);
                    return;
                }
                CircularProgressBar circularProgressBar3 = this.a;
                CircularProgressBar.r(circularProgressBar3, circularProgressBar3.getProgressMax(), 1500L, (TimeInterpolator) null, (Long) null, 12, (Object) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void n() {
        Handler handler = this.f2651a;
        if (handler != null) {
            handler.postDelayed(this.f2655a, 1500);
        }
    }

    private final void j(Context context, AttributeSet attrs) {
        TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, yc0.f5873a, 0, 0);
        setProgress(attributes.getFloat(yc0.g, this.f2646a));
        setProgressMax(attributes.getFloat(yc0.i, this.b));
        setProgressBarWidth(o(attributes.getDimension(yc0.n, this.c)));
        setBackgroundProgressBarWidth(o(attributes.getDimension(yc0.e, this.d)));
        setProgressBarColor(attributes.getInt(yc0.j, this.f2647a));
        int it = attributes.getColor(yc0.m, 0);
        if (it != 0) {
            setProgressBarColorStart(Integer.valueOf(it));
        }
        int it2 = attributes.getColor(yc0.l, 0);
        if (it2 != 0) {
            setProgressBarColorEnd(Integer.valueOf(it2));
        }
        setProgressBarColorDirection(s(attributes.getInteger(yc0.k, this.f2652a.getValue())));
        setBackgroundProgressBarColor(attributes.getInt(yc0.a, this.f2658b));
        int it3 = attributes.getColor(yc0.d, 0);
        if (it3 != 0) {
            setBackgroundProgressBarColorStart(Integer.valueOf(it3));
        }
        int it4 = attributes.getColor(yc0.c, 0);
        if (it4 != 0) {
            setBackgroundProgressBarColorEnd(Integer.valueOf(it4));
        }
        setBackgroundProgressBarColorDirection(s(attributes.getInteger(yc0.b, this.f2660b.getValue())));
        setProgressDirection(t(attributes.getInteger(yc0.h, this.f2653a.getValue())));
        setRoundBorder(attributes.getBoolean(yc0.o, this.f2657a));
        setStartAngle(attributes.getFloat(yc0.p, 0.0f));
        setIndeterminateMode(attributes.getBoolean(yc0.f, this.f2664b));
        attributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f2648a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        Handler handler = this.f2651a;
        if (handler != null) {
            handler.removeCallbacks(this.f2655a);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        m();
        l();
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        lu.g(canvas, "canvas");
        super.onDraw(canvas);
        canvas.drawOval(this.f2650a, this.f2649a);
        boolean z = this.f2664b;
        float realProgress = ((z ? this.f : this.f2646a) * 100.0f) / this.b;
        boolean isToRightFromNormalMode = true;
        boolean isToRightFromIndeterminateMode = z && k(this.f2661b);
        if (this.f2664b || !k(this.f2653a)) {
            isToRightFromNormalMode = false;
        }
        canvas.drawArc(this.f2650a, this.f2664b ? this.g : this.e, (((float) ((isToRightFromIndeterminateMode || isToRightFromNormalMode) ? 360 : -360)) * realProgress) / ((float) 100), false, this.f2659b);
    }

    public void setBackgroundColor(int backgroundColor) {
        setBackgroundProgressBarColor(backgroundColor);
    }

    private final void m() {
        Paint paint = this.f2659b;
        Integer num = this.f2654a;
        int intValue = num != null ? num.intValue() : this.f2647a;
        Integer num2 = this.f2662b;
        paint.setShader(h(intValue, num2 != null ? num2.intValue() : this.f2647a, this.f2652a));
    }

    private final void l() {
        Paint paint = this.f2649a;
        Integer num = this.f2665c;
        int intValue = num != null ? num.intValue() : this.f2658b;
        Integer num2 = this.f2666d;
        paint.setShader(h(intValue, num2 != null ? num2.intValue() : this.f2658b, this.f2660b));
    }

    private final LinearGradient h(int startColor, int endColor, b gradientDirection) {
        float x0 = 0.0f;
        float y0 = 0.0f;
        float x1 = 0.0f;
        float y1 = 0.0f;
        switch (s8.a[gradientDirection.ordinal()]) {
            case 1:
                x1 = (float) getWidth();
                break;
            case 2:
                x0 = (float) getWidth();
                break;
            case 3:
                y1 = (float) getHeight();
                break;
            case 4:
                y0 = (float) getHeight();
                break;
        }
        return new LinearGradient(x0, y0, x1, y1, startColor, endColor, Shader.TileMode.CLAMP);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int min = Math.min(View.getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec), View.getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec));
        setMeasuredDimension(min, min);
        float highStroke = this.c;
        float f2 = this.d;
        if (highStroke <= f2) {
            highStroke = f2;
        }
        float f3 = (float) 0;
        float f4 = (float) 2;
        this.f2650a.set((highStroke / f4) + f3, f3 + (highStroke / f4), ((float) min) - (highStroke / f4), ((float) min) - (highStroke / f4));
    }

    public static /* synthetic */ void r(CircularProgressBar circularProgressBar, float f2, Long l, TimeInterpolator timeInterpolator, Long l2, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        if ((i & 4) != 0) {
            timeInterpolator = null;
        }
        if ((i & 8) != 0) {
            l2 = null;
        }
        circularProgressBar.q(f2, l, timeInterpolator, l2);
    }

    public final void q(float progress, Long duration, TimeInterpolator interpolator, Long startDelay) {
        ValueAnimator valueAnimator = this.f2648a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        float[] fArr = new float[2];
        fArr[0] = this.f2664b ? this.f : this.f2646a;
        fArr[1] = progress;
        this.f2648a = ValueAnimator.ofFloat(fArr);
        if (duration != null) {
            long it = duration.longValue();
            ValueAnimator valueAnimator2 = this.f2648a;
            if (valueAnimator2 != null) {
                valueAnimator2.setDuration(it);
            }
        }
        if (interpolator != null) {
            TimeInterpolator it2 = interpolator;
            ValueAnimator valueAnimator3 = this.f2648a;
            if (valueAnimator3 != null) {
                valueAnimator3.setInterpolator(it2);
            }
        }
        if (startDelay != null) {
            long it3 = startDelay.longValue();
            ValueAnimator valueAnimator4 = this.f2648a;
            if (valueAnimator4 != null) {
                valueAnimator4.setStartDelay(it3);
            }
        }
        ValueAnimator valueAnimator5 = this.f2648a;
        if (valueAnimator5 != null) {
            valueAnimator5.addUpdateListener(new e(this));
        }
        ValueAnimator valueAnimator6 = this.f2648a;
        if (valueAnimator6 != null) {
            valueAnimator6.start();
        }
    }

    static final class e implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ CircularProgressBar a;

        e(CircularProgressBar circularProgressBar) {
            this.a = circularProgressBar;
        }

        public final void onAnimationUpdate(ValueAnimator animation) {
            lu.b(animation, "animation");
            Object animatedValue = animation.getAnimatedValue();
            if (!(animatedValue instanceof Float)) {
                animatedValue = null;
            }
            Float f = (Float) animatedValue;
            if (f != null) {
                float value = f.floatValue();
                if (this.a.getIndeterminateMode()) {
                    this.a.setProgressIndeterminateMode(value);
                } else {
                    this.a.setProgress(value);
                }
                if (this.a.getIndeterminateMode()) {
                    float updateAngle = (((float) 360) * value) / ((float) 100);
                    CircularProgressBar circularProgressBar = this.a;
                    circularProgressBar.setStartAngleIndeterminateMode((circularProgressBar.k(circularProgressBar.f2661b) ? updateAngle : -updateAngle) + 270.0f);
                }
            }
        }
    }

    private final float i(float $this$dpToPx) {
        Resources system = Resources.getSystem();
        lu.b(system, "Resources.getSystem()");
        return system.getDisplayMetrics().density * $this$dpToPx;
    }

    private final float o(float $this$pxToDp) {
        Resources system = Resources.getSystem();
        lu.b(system, "Resources.getSystem()");
        return $this$pxToDp / system.getDisplayMetrics().density;
    }

    private final c t(int $this$toProgressDirection) {
        switch ($this$toProgressDirection) {
            case 1:
                return c.TO_RIGHT;
            case 2:
                return c.TO_LEFT;
            default:
                throw new IllegalArgumentException("This value is not supported for ProgressDirection: " + $this$toProgressDirection);
        }
    }

    /* access modifiers changed from: private */
    public final c p(c $this$reverse) {
        return k($this$reverse) ? c.TO_LEFT : c.TO_RIGHT;
    }

    /* access modifiers changed from: private */
    public final boolean k(c $this$isToRight) {
        return $this$isToRight == c.TO_RIGHT;
    }

    private final b s(int $this$toGradientDirection) {
        switch ($this$toGradientDirection) {
            case 1:
                return b.LEFT_TO_RIGHT;
            case 2:
                return b.RIGHT_TO_LEFT;
            case 3:
                return b.TOP_TO_BOTTOM;
            case 4:
                return b.BOTTOM_TO_END;
            default:
                throw new IllegalArgumentException("This value is not supported for GradientDirection: " + $this$toGradientDirection);
        }
    }

    public enum c {
        TO_RIGHT(1),
        TO_LEFT(2);
        
        private final int value;

        private c(int value2) {
            this.value = value2;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public enum b {
        LEFT_TO_RIGHT(1),
        RIGHT_TO_LEFT(2),
        TOP_TO_BOTTOM(3),
        BOTTOM_TO_END(4);
        
        private final int value;

        private b(int value2) {
            this.value = value2;
        }

        public final int getValue() {
            return this.value;
        }
    }
}
