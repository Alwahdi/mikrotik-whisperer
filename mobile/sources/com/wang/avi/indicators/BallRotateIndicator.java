package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.wang.avi.Indicator;
import java.util.ArrayList;

public class BallRotateIndicator extends Indicator {
    float degress;
    private Matrix mMatrix = new Matrix();
    float scaleFloat = 0.5f;

    public void draw(Canvas canvas, Paint paint) {
        float radius = (float) (getWidth() / 10);
        float x = (float) (getWidth() / 2);
        float y = (float) (getHeight() / 2);
        canvas.rotate(this.degress, (float) centerX(), (float) centerY());
        canvas.save();
        canvas.translate((x - (radius * 2.0f)) - radius, y);
        float f = this.scaleFloat;
        canvas.scale(f, f);
        canvas.drawCircle(0.0f, 0.0f, radius, paint);
        canvas.restore();
        canvas.save();
        canvas.translate(x, y);
        float f2 = this.scaleFloat;
        canvas.scale(f2, f2);
        canvas.drawCircle(0.0f, 0.0f, radius, paint);
        canvas.restore();
        canvas.save();
        canvas.translate((2.0f * radius) + x + radius, y);
        float f3 = this.scaleFloat;
        canvas.scale(f3, f3);
        canvas.drawCircle(0.0f, 0.0f, radius, paint);
        canvas.restore();
    }

    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> animators = new ArrayList<>();
        ValueAnimator scaleAnim = ValueAnimator.ofFloat(new float[]{0.5f, 1.0f, 0.5f});
        scaleAnim.setDuration(1000);
        scaleAnim.setRepeatCount(-1);
        addUpdateListener(scaleAnim, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                BallRotateIndicator.this.scaleFloat = ((Float) animation.getAnimatedValue()).floatValue();
                BallRotateIndicator.this.postInvalidate();
            }
        });
        ValueAnimator rotateAnim = ValueAnimator.ofFloat(new float[]{0.0f, 180.0f, 360.0f});
        addUpdateListener(rotateAnim, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                BallRotateIndicator.this.degress = ((Float) animation.getAnimatedValue()).floatValue();
                BallRotateIndicator.this.postInvalidate();
            }
        });
        rotateAnim.setDuration(1000);
        rotateAnim.setRepeatCount(-1);
        animators.add(scaleAnim);
        animators.add(rotateAnim);
        return animators;
    }
}
