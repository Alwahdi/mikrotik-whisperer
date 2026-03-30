package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;
import com.wang.avi.Indicator;
import java.util.ArrayList;

public class BallScaleIndicator extends Indicator {
    int alpha = 255;
    float scale = 1.0f;

    public void draw(Canvas canvas, Paint paint) {
        paint.setAlpha(this.alpha);
        float f = this.scale;
        canvas.scale(f, f, (float) (getWidth() / 2), (float) (getHeight() / 2));
        paint.setAlpha(this.alpha);
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), ((float) (getWidth() / 2)) - 4.0f, paint);
    }

    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> animators = new ArrayList<>();
        ValueAnimator scaleAnim = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        scaleAnim.setInterpolator(new LinearInterpolator());
        scaleAnim.setDuration(1000);
        scaleAnim.setRepeatCount(-1);
        addUpdateListener(scaleAnim, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                BallScaleIndicator.this.scale = ((Float) animation.getAnimatedValue()).floatValue();
                BallScaleIndicator.this.postInvalidate();
            }
        });
        ValueAnimator alphaAnim = ValueAnimator.ofInt(new int[]{255, 0});
        alphaAnim.setInterpolator(new LinearInterpolator());
        alphaAnim.setDuration(1000);
        alphaAnim.setRepeatCount(-1);
        addUpdateListener(alphaAnim, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                BallScaleIndicator.this.alpha = ((Integer) animation.getAnimatedValue()).intValue();
                BallScaleIndicator.this.postInvalidate();
            }
        });
        animators.add(scaleAnim);
        animators.add(alphaAnim);
        return animators;
    }
}
