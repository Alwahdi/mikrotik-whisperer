package com.wang.avi.indicators;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.wang.avi.indicators.BallSpinFadeLoaderIndicator;

public class LineSpinFadeLoaderIndicator extends BallSpinFadeLoaderIndicator {
    public void draw(Canvas canvas, Paint paint) {
        float radius = (float) (getWidth() / 10);
        for (int i = 0; i < 8; i++) {
            canvas.save();
            BallSpinFadeLoaderIndicator.Point point = circleAt(getWidth(), getHeight(), (((float) getWidth()) / 2.5f) - radius, 0.7853981633974483d * ((double) i));
            canvas.translate(point.x, point.y);
            float[] fArr = this.scaleFloats;
            canvas.scale(fArr[i], fArr[i]);
            canvas.rotate((float) (i * 45));
            paint.setAlpha(this.alphas[i]);
            canvas.drawRoundRect(new RectF(-radius, (-radius) / 1.5f, radius * 1.5f, radius / 1.5f), 5.0f, 5.0f, paint);
            canvas.restore();
        }
    }
}
