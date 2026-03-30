package defpackage;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;

/* renamed from: gw0  reason: default package */
public class gw0 implements ViewPager2.PageTransformer {
    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();
        if (position < -1.0f) {
            view.setAlpha(0.0f);
        } else if (position <= 1.0f) {
            float scaleFactor = Math.max(0.85f, 1.0f - Math.abs(position));
            float vertMargin = (((float) pageHeight) * (1.0f - scaleFactor)) / 2.0f;
            float horzMargin = (((float) pageWidth) * (1.0f - scaleFactor)) / 2.0f;
            if (position < 0.0f) {
                view.setTranslationX(horzMargin - (vertMargin / 2.0f));
            } else {
                view.setTranslationX((-horzMargin) + (vertMargin / 2.0f));
            }
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
            view.setAlpha((((scaleFactor - 0.85f) / 0.14999998f) * 0.5f) + 0.5f);
        } else {
            view.setAlpha(0.0f);
        }
    }
}
