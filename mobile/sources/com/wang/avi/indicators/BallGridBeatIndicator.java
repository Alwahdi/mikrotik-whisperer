package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.wang.avi.Indicator;
import java.util.ArrayList;
import org.apache.http.HttpStatus;

public class BallGridBeatIndicator extends Indicator {
    public static final int ALPHA = 255;
    int[] alphas = {255, 255, 255, 255, 255, 255, 255, 255, 255};

    public void draw(Canvas canvas, Paint paint) {
        float radius = (((float) getWidth()) - (4.0f * 4.0f)) / 6.0f;
        float x = ((float) (getWidth() / 2)) - ((radius * 2.0f) + 4.0f);
        float y = ((float) (getWidth() / 2)) - ((radius * 2.0f) + 4.0f);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                canvas.save();
                canvas.translate((radius * 2.0f * ((float) j)) + x + (((float) j) * 4.0f), (radius * 2.0f * ((float) i)) + y + (((float) i) * 4.0f));
                paint.setAlpha(this.alphas[(i * 3) + j]);
                canvas.drawCircle(0.0f, 0.0f, radius, paint);
                canvas.restore();
            }
        }
    }

    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> animators = new ArrayList<>();
        int[] durations = {960, 930, 1190, 1130, 1340, 940, 1200, 820, 1190};
        int[] delays = {360, HttpStatus.SC_BAD_REQUEST, 680, HttpStatus.SC_GONE, 710, -150, -120, 10, 320};
        for (int i = 0; i < 9; i++) {
            final int index = i;
            ValueAnimator alphaAnim = ValueAnimator.ofInt(new int[]{255, 168, 255});
            alphaAnim.setDuration((long) durations[i]);
            alphaAnim.setRepeatCount(-1);
            alphaAnim.setStartDelay((long) delays[i]);
            addUpdateListener(alphaAnim, new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator animation) {
                    BallGridBeatIndicator.this.alphas[index] = ((Integer) animation.getAnimatedValue()).intValue();
                    BallGridBeatIndicator.this.postInvalidate();
                }
            });
            animators.add(alphaAnim);
        }
        return animators;
    }
}
