package com.wang.avi;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.wang.avi.indicators.BallPulseIndicator;

public class AVLoadingIndicatorView extends View {
    private static final BallPulseIndicator DEFAULT_INDICATOR = new BallPulseIndicator();
    private static final int MIN_DELAY = 500;
    private static final int MIN_SHOW_TIME = 500;
    private static final String TAG = "AVLoadingIndicatorView";
    private final Runnable mDelayedHide = new Runnable() {
        public void run() {
            boolean unused = AVLoadingIndicatorView.this.mPostedHide = false;
            long unused2 = AVLoadingIndicatorView.this.mStartTime = -1;
            AVLoadingIndicatorView.this.setVisibility(8);
        }
    };
    private final Runnable mDelayedShow = new Runnable() {
        public void run() {
            boolean unused = AVLoadingIndicatorView.this.mPostedShow = false;
            if (!AVLoadingIndicatorView.this.mDismissed) {
                long unused2 = AVLoadingIndicatorView.this.mStartTime = System.currentTimeMillis();
                AVLoadingIndicatorView.this.setVisibility(0);
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean mDismissed = false;
    private Indicator mIndicator;
    private int mIndicatorColor;
    int mMaxHeight;
    int mMaxWidth;
    int mMinHeight;
    int mMinWidth;
    /* access modifiers changed from: private */
    public boolean mPostedHide = false;
    /* access modifiers changed from: private */
    public boolean mPostedShow = false;
    private boolean mShouldStartAnimationDrawable;
    /* access modifiers changed from: private */
    public long mStartTime = -1;

    public AVLoadingIndicatorView(Context context) {
        super(context);
        init(context, (AttributeSet) null, 0, 0);
    }

    public AVLoadingIndicatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0, R.style.AVLoadingIndicatorView);
    }

    public AVLoadingIndicatorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, R.style.AVLoadingIndicatorView);
    }

    public AVLoadingIndicatorView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, R.style.AVLoadingIndicatorView);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.mMinWidth = 24;
        this.mMaxWidth = 48;
        this.mMinHeight = 24;
        this.mMaxHeight = 48;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AVLoadingIndicatorView, defStyleAttr, defStyleRes);
        this.mMinWidth = a.getDimensionPixelSize(R.styleable.AVLoadingIndicatorView_minWidth, this.mMinWidth);
        this.mMaxWidth = a.getDimensionPixelSize(R.styleable.AVLoadingIndicatorView_maxWidth, this.mMaxWidth);
        this.mMinHeight = a.getDimensionPixelSize(R.styleable.AVLoadingIndicatorView_minHeight, this.mMinHeight);
        this.mMaxHeight = a.getDimensionPixelSize(R.styleable.AVLoadingIndicatorView_maxHeight, this.mMaxHeight);
        String indicatorName = a.getString(R.styleable.AVLoadingIndicatorView_indicatorName);
        this.mIndicatorColor = a.getColor(R.styleable.AVLoadingIndicatorView_indicatorColor, -1);
        setIndicator(indicatorName);
        if (this.mIndicator == null) {
            setIndicator((Indicator) DEFAULT_INDICATOR);
        }
        a.recycle();
    }

    public Indicator getIndicator() {
        return this.mIndicator;
    }

    public void setIndicator(Indicator d) {
        Indicator indicator = this.mIndicator;
        if (indicator != d) {
            if (indicator != null) {
                indicator.setCallback((Drawable.Callback) null);
                unscheduleDrawable(this.mIndicator);
            }
            this.mIndicator = d;
            setIndicatorColor(this.mIndicatorColor);
            if (d != null) {
                d.setCallback(this);
            }
            postInvalidate();
        }
    }

    public void setIndicatorColor(int color) {
        this.mIndicatorColor = color;
        this.mIndicator.setColor(color);
    }

    public void setIndicator(String indicatorName) {
        if (!TextUtils.isEmpty(indicatorName)) {
            StringBuilder drawableClassName = new StringBuilder();
            if (!indicatorName.contains(".")) {
                drawableClassName.append(getClass().getPackage().getName());
                drawableClassName.append(".indicators");
                drawableClassName.append(".");
            }
            drawableClassName.append(indicatorName);
            try {
                setIndicator((Indicator) Class.forName(drawableClassName.toString()).newInstance());
            } catch (ClassNotFoundException e) {
                Log.e(TAG, "Didn't find your class , check the name again !");
            } catch (InstantiationException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            }
        }
    }

    public void smoothToShow() {
        startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
        setVisibility(0);
    }

    public void smoothToHide() {
        startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
        setVisibility(8);
    }

    public void hide() {
        this.mDismissed = true;
        removeCallbacks(this.mDelayedShow);
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.mStartTime;
        long diff = currentTimeMillis - j;
        if (diff >= 500 || j == -1) {
            setVisibility(8);
        } else if (!this.mPostedHide) {
            postDelayed(this.mDelayedHide, 500 - diff);
            this.mPostedHide = true;
        }
    }

    public void show() {
        this.mStartTime = -1;
        this.mDismissed = false;
        removeCallbacks(this.mDelayedHide);
        if (!this.mPostedShow) {
            postDelayed(this.mDelayedShow, 500);
            this.mPostedShow = true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable who) {
        return who == this.mIndicator || super.verifyDrawable(who);
    }

    /* access modifiers changed from: package-private */
    public void startAnimation() {
        if (getVisibility() == 0) {
            if (this.mIndicator instanceof Animatable) {
                this.mShouldStartAnimationDrawable = true;
            }
            postInvalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public void stopAnimation() {
        Indicator indicator = this.mIndicator;
        if (indicator instanceof Animatable) {
            indicator.stop();
            this.mShouldStartAnimationDrawable = false;
        }
        postInvalidate();
    }

    public void setVisibility(int v) {
        if (getVisibility() != v) {
            super.setVisibility(v);
            if (v == 8 || v == 4) {
                stopAnimation();
            } else {
                startAnimation();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == 8 || visibility == 4) {
            stopAnimation();
        } else {
            startAnimation();
        }
    }

    public void invalidateDrawable(Drawable dr) {
        if (verifyDrawable(dr)) {
            Rect dirty = dr.getBounds();
            int scrollX = getScrollX() + getPaddingLeft();
            int scrollY = getScrollY() + getPaddingTop();
            invalidate(dirty.left + scrollX, dirty.top + scrollY, dirty.right + scrollX, dirty.bottom + scrollY);
            return;
        }
        super.invalidateDrawable(dr);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        updateDrawableBounds(w, h);
    }

    private void updateDrawableBounds(int w, int h) {
        int w2 = w - (getPaddingRight() + getPaddingLeft());
        int h2 = h - (getPaddingTop() + getPaddingBottom());
        int right = w2;
        int bottom = h2;
        int top = 0;
        int left = 0;
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            float intrinsicAspect = ((float) indicator.getIntrinsicWidth()) / ((float) this.mIndicator.getIntrinsicHeight());
            float boundAspect = ((float) w2) / ((float) h2);
            if (intrinsicAspect != boundAspect) {
                if (boundAspect > intrinsicAspect) {
                    int width = (int) (((float) h2) * intrinsicAspect);
                    int left2 = (w2 - width) / 2;
                    right = width + left2;
                    left = left2;
                } else {
                    int height = (int) (((float) w2) * (1.0f / intrinsicAspect));
                    int top2 = (h2 - height) / 2;
                    bottom = top2 + height;
                    top = top2;
                }
            }
            this.mIndicator.setBounds(left, top, right, bottom);
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawTrack(canvas);
    }

    /* access modifiers changed from: package-private */
    public void drawTrack(Canvas canvas) {
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            int saveCount = canvas.save();
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            indicator.draw(canvas);
            canvas.restoreToCount(saveCount);
            if (this.mShouldStartAnimationDrawable) {
                indicator.start();
                this.mShouldStartAnimationDrawable = false;
            }
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int dw = 0;
        int dh = 0;
        Drawable d = this.mIndicator;
        if (d != null) {
            dw = Math.max(this.mMinWidth, Math.min(this.mMaxWidth, d.getIntrinsicWidth()));
            dh = Math.max(this.mMinHeight, Math.min(this.mMaxHeight, d.getIntrinsicHeight()));
        }
        updateDrawableState();
        setMeasuredDimension(View.resolveSizeAndState(dw + getPaddingLeft() + getPaddingRight(), widthMeasureSpec, 0), View.resolveSizeAndState(dh + getPaddingTop() + getPaddingBottom(), heightMeasureSpec, 0));
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        updateDrawableState();
    }

    private void updateDrawableState() {
        int[] state = getDrawableState();
        Indicator indicator = this.mIndicator;
        if (indicator != null && indicator.isStateful()) {
            this.mIndicator.setState(state);
        }
    }

    public void drawableHotspotChanged(float x, float y) {
        super.drawableHotspotChanged(x, y);
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            indicator.setHotspot(x, y);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnimation();
        removeCallbacks();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        stopAnimation();
        super.onDetachedFromWindow();
        removeCallbacks();
    }

    private void removeCallbacks() {
        removeCallbacks(this.mDelayedHide);
        removeCallbacks(this.mDelayedShow);
    }
}
