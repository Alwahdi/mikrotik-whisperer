package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;
import com.wang.avi.Indicator;
import java.util.ArrayList;

public class BallTrianglePathIndicator extends Indicator {
    float[] translateX = new float[3];
    float[] translateY = new float[3];

    public void draw(Canvas canvas, Paint paint) {
        paint.setStrokeWidth(3.0f);
        paint.setStyle(Paint.Style.STROKE);
        for (int i = 0; i < 3; i++) {
            canvas.save();
            canvas.translate(this.translateX[i], this.translateY[i]);
            canvas.drawCircle(0.0f, 0.0f, (float) (getWidth() / 10), paint);
            canvas.restore();
        }
    }

    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> animators = new ArrayList<>();
        float startX = (float) (getWidth() / 5);
        float startY = (float) (getWidth() / 5);
        for (int i = 0; i < 3; i++) {
            final int index = i;
            ValueAnimator translateXAnim = ValueAnimator.ofFloat(new float[]{(float) (getWidth() / 2), ((float) getWidth()) - startX, startX, (float) (getWidth() / 2)});
            if (i == 1) {
                translateXAnim = ValueAnimator.ofFloat(new float[]{((float) getWidth()) - startX, startX, (float) (getWidth() / 2), ((float) getWidth()) - startX});
            } else if (i == 2) {
                translateXAnim = ValueAnimator.ofFloat(new float[]{startX, (float) (getWidth() / 2), ((float) getWidth()) - startX, startX});
            }
            ValueAnimator translateYAnim = ValueAnimator.ofFloat(new float[]{startY, ((float) getHeight()) - startY, ((float) getHeight()) - startY, startY});
            if (i == 1) {
                translateYAnim = ValueAnimator.ofFloat(new float[]{((float) getHeight()) - startY, ((float) getHeight()) - startY, startY, ((float) getHeight()) - startY});
            } else if (i == 2) {
                translateYAnim = ValueAnimator.ofFloat(new float[]{((float) getHeight()) - startY, startY, ((float) getHeight()) - startY, ((float) getHeight()) - startY});
            }
            translateXAnim.setDuration(2000);
            translateXAnim.setInterpolator(new LinearInterpolator());
            translateXAnim.setRepeatCount(-1);
            addUpdateListener(translateXAnim, new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator animation) {
                    BallTrianglePathIndicator.this.translateX[index] = ((Float) animation.getAnimatedValue()).floatValue();
                    BallTrianglePathIndicator.this.postInvalidate();
                }
            });
            translateYAnim.setDuration(2000);
            translateYAnim.setInterpolator(new LinearInterpolator());
            translateYAnim.setRepeatCount(-1);
            addUpdateListener(translateYAnim, new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator animation) {
                    BallTrianglePathIndicator.this.translateY[index] = ((Float) animation.getAnimatedValue()).floatValue();
                    BallTrianglePathIndicator.this.postInvalidate();
                }
            });
            animators.add(translateXAnim);
            animators.add(translateYAnim);
        }
        return animators;
    }
}
