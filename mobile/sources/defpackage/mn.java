package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.GravityCompat;

/* renamed from: mn  reason: default package */
public abstract class mn extends LinearLayoutCompat {
    private int a = 119;

    /* renamed from: a  reason: collision with other field name */
    private final Rect f4373a = new Rect();

    /* renamed from: a  reason: collision with other field name */
    private Drawable f4374a;

    /* renamed from: a  reason: collision with other field name */
    protected boolean f4375a = true;
    private final Rect b = new Rect();

    /* renamed from: b  reason: collision with other field name */
    boolean f4376b = false;

    public mn(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a2 = vq0.i(context, attrs, xc0.f5664c0, defStyle, 0, new int[0]);
        this.a = a2.getInt(xc0.Y1, this.a);
        Drawable d = a2.getDrawable(xc0.X1);
        if (d != null) {
            setForeground(d);
        }
        this.f4375a = a2.getBoolean(xc0.Z1, true);
        a2.recycle();
    }

    public int getForegroundGravity() {
        return this.a;
    }

    public void setForegroundGravity(int foregroundGravity) {
        if (this.a != foregroundGravity) {
            if ((8388615 & foregroundGravity) == 0) {
                foregroundGravity |= GravityCompat.START;
            }
            if ((foregroundGravity & 112) == 0) {
                foregroundGravity |= 48;
            }
            this.a = foregroundGravity;
            if (foregroundGravity == 119 && this.f4374a != null) {
                this.f4374a.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable who) {
        return super.verifyDrawable(who) || who == this.f4374a;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f4374a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f4374a;
        if (drawable != null && drawable.isStateful()) {
            this.f4374a.setState(getDrawableState());
        }
    }

    public void setForeground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f4374a;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
                unscheduleDrawable(this.f4374a);
            }
            this.f4374a = drawable;
            this.f4376b = true;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.a == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Nullable
    public Drawable getForeground() {
        return this.f4374a;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.f4376b |= changed;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.f4376b = true;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f4374a != null) {
            Drawable foreground = this.f4374a;
            if (this.f4376b) {
                this.f4376b = false;
                Rect selfBounds = this.f4373a;
                Rect overlayBounds = this.b;
                int w = getRight() - getLeft();
                int h = getBottom() - getTop();
                if (this.f4375a) {
                    selfBounds.set(0, 0, w, h);
                } else {
                    selfBounds.set(getPaddingLeft(), getPaddingTop(), w - getPaddingRight(), h - getPaddingBottom());
                }
                Gravity.apply(this.a, foreground.getIntrinsicWidth(), foreground.getIntrinsicHeight(), selfBounds, overlayBounds);
                foreground.setBounds(overlayBounds);
            }
            foreground.draw(canvas);
        }
    }

    public void drawableHotspotChanged(float x, float y) {
        super.drawableHotspotChanged(x, y);
        Drawable drawable = this.f4374a;
        if (drawable != null) {
            drawable.setHotspot(x, y);
        }
    }
}
