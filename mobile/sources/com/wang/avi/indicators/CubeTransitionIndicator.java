package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;
import com.wang.avi.Indicator;
import java.util.ArrayList;

public class CubeTransitionIndicator extends Indicator {
    float degrees;
    float scaleFloat = 1.0f;
    float[] translateX = new float[2];
    float[] translateY = new float[2];

    public void draw(Canvas canvas, Paint paint) {
        float rWidth = (float) (getWidth() / 5);
        float rHeight = (float) (getHeight() / 5);
        for (int i = 0; i < 2; i++) {
            canvas.save();
            canvas.translate(this.translateX[i], this.translateY[i]);
            canvas.rotate(this.degrees);
            float f = this.scaleFloat;
            canvas.scale(f, f);
            canvas.drawRect(new RectF((-rWidth) / 2.0f, (-rHeight) / 2.0f, rWidth / 2.0f, rHeight / 2.0f), paint);
            canvas.restore();
        }
    }

    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> animators = new ArrayList<>();
        int i = 5;
        float startX = (float) (getWidth() / 5);
        float startY = (float) (getHeight() / 5);
        int i2 = 0;
        while (i2 < 2) {
            final int index = i2;
            this.translateX[index] = startX;
            float[] fArr = new float[i];
            fArr[0] = startX;
            fArr[1] = ((float) getWidth()) - startX;
            fArr[2] = ((float) getWidth()) - startX;
            fArr[3] = startX;
            fArr[4] = startX;
            ValueAnimator translationXAnim = ValueAnimator.ofFloat(fArr);
            if (i2 == 1) {
                float[] fArr2 = new float[i];
                fArr2[0] = ((float) getWidth()) - startX;
                fArr2[1] = startX;
                fArr2[2] = startX;
                fArr2[3] = ((float) getWidth()) - startX;
                fArr2[4] = ((float) getWidth()) - startX;
                translationXAnim = ValueAnimator.ofFloat(fArr2);
            }
            translationXAnim.setInterpolator(new LinearInterpolator());
            translationXAnim.setDuration(1600);
            translationXAnim.setRepeatCount(-1);
            translationXAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator animation) {
                    CubeTransitionIndicator.this.translateX[index] = ((Float) animation.getAnimatedValue()).floatValue();
                    CubeTransitionIndicator.this.postInvalidate();
                }
            });
            this.translateY[index] = startY;
            ValueAnimator translationYAnim = ValueAnimator.ofFloat(new float[]{startY, startY, ((float) getHeight()) - startY, ((float) getHeight()) - startY, startY});
            if (i2 == 1) {
                translationYAnim = ValueAnimator.ofFloat(new float[]{((float) getHeight()) - startY, ((float) getHeight()) - startY, startY, startY, ((float) getHeight()) - startY});
            }
            translationYAnim.setDuration(1600);
            translationYAnim.setInterpolator(new LinearInterpolator());
            translationYAnim.setRepeatCount(-1);
            addUpdateListener(translationYAnim, new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator animation) {
                    CubeTransitionIndicator.this.translateY[index] = ((Float) animation.getAnimatedValue()).floatValue();
                    CubeTransitionIndicator.this.postInvalidate();
                }
            });
            animators.add(translationXAnim);
            animators.add(translationYAnim);
            i2++;
            i = 5;
        }
        ValueAnimator scaleAnim = ValueAnimator.ofFloat(new float[]{1.0f, 0.5f, 1.0f, 0.5f, 1.0f});
        scaleAnim.setDuration(1600);
        scaleAnim.setInterpolator(new LinearInterpolator());
        scaleAnim.setRepeatCount(-1);
        addUpdateListener(scaleAnim, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                CubeTransitionIndicator.this.scaleFloat = ((Float) animation.getAnimatedValue()).floatValue();
                CubeTransitionIndicator.this.postInvalidate();
            }
        });
        ValueAnimator rotateAnim = ValueAnimator.ofFloat(new float[]{0.0f, 180.0f, 360.0f, 540.0f, 720.0f});
        rotateAnim.setDuration(1600);
        rotateAnim.setInterpolator(new LinearInterpolator());
        rotateAnim.setRepeatCount(-1);
        addUpdateListener(rotateAnim, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                CubeTransitionIndicator.this.degrees = ((Float) animation.getAnimatedValue()).floatValue();
                CubeTransitionIndicator.this.postInvalidate();
            }
        });
        animators.add(scaleAnim);
        animators.add(rotateAnim);
        return animators;
    }
}
