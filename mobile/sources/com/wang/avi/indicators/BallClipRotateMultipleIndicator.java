package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.wang.avi.Indicator;
import java.util.ArrayList;

public class BallClipRotateMultipleIndicator extends Indicator {
    float degrees;
    float scaleFloat = 1.0f;

    public void draw(Canvas canvas, Paint paint) {
        paint.setStrokeWidth(3.0f);
        paint.setStyle(Paint.Style.STROKE);
        float x = (float) (getWidth() / 2);
        float y = (float) (getHeight() / 2);
        canvas.save();
        canvas.translate(x, y);
        float f = this.scaleFloat;
        canvas.scale(f, f);
        canvas.rotate(this.degrees);
        float[] bStartAngles = {135.0f, -45.0f};
        for (int i = 0; i < 2; i++) {
            canvas.drawArc(new RectF((-x) + 12.0f, (-y) + 12.0f, x - 12.0f, y - 12.0f), bStartAngles[i], 90.0f, false, paint);
        }
        canvas.restore();
        canvas.translate(x, y);
        float f2 = this.scaleFloat;
        canvas.scale(f2, f2);
        canvas.rotate(-this.degrees);
        float[] sStartAngles = {225.0f, 45.0f};
        for (int i2 = 0; i2 < 2; i2++) {
            canvas.drawArc(new RectF(((-x) / 1.8f) + 12.0f, ((-y) / 1.8f) + 12.0f, (x / 1.8f) - 12.0f, (y / 1.8f) - 12.0f), sStartAngles[i2], 90.0f, false, paint);
        }
    }

    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> animators = new ArrayList<>();
        ValueAnimator scaleAnim = ValueAnimator.ofFloat(new float[]{1.0f, 0.6f, 1.0f});
        scaleAnim.setDuration(1000);
        scaleAnim.setRepeatCount(-1);
        addUpdateListener(scaleAnim, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                BallClipRotateMultipleIndicator.this.scaleFloat = ((Float) animation.getAnimatedValue()).floatValue();
                BallClipRotateMultipleIndicator.this.postInvalidate();
            }
        });
        ValueAnimator rotateAnim = ValueAnimator.ofFloat(new float[]{0.0f, 180.0f, 360.0f});
        rotateAnim.setDuration(1000);
        rotateAnim.setRepeatCount(-1);
        addUpdateListener(rotateAnim, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                BallClipRotateMultipleIndicator.this.degrees = ((Float) animation.getAnimatedValue()).floatValue();
                BallClipRotateMultipleIndicator.this.postInvalidate();
            }
        });
        animators.add(scaleAnim);
        animators.add(rotateAnim);
        return animators;
    }
}
