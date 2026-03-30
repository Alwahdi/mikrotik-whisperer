package com.google.android.material.carousel;

import android.view.View;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

public final class h extends d {
    private static final int[] a = {1};
    private static final int[] b = {1, 0};

    /* renamed from: a  reason: collision with other field name */
    private int f1605a = 0;

    /* access modifiers changed from: package-private */
    public f c(b carousel, View child) {
        float measuredChildSize;
        float childMargins;
        int[] mediumCounts;
        int[] smallCounts;
        float availableSpace = (float) carousel.c();
        if (carousel.b()) {
            availableSpace = (float) carousel.a();
        }
        RecyclerView.LayoutParams childLayoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
        float childMargins2 = (float) (childLayoutParams.topMargin + childLayoutParams.bottomMargin);
        float measuredChildSize2 = (float) child.getMeasuredHeight();
        if (carousel.b()) {
            childMargins = (float) (childLayoutParams.leftMargin + childLayoutParams.rightMargin);
            measuredChildSize = (float) child.getMeasuredWidth();
        } else {
            childMargins = childMargins2;
            measuredChildSize = measuredChildSize2;
        }
        float smallChildSizeMin = e.h(child.getContext()) + childMargins;
        float smallChildSizeMax = e.g(child.getContext()) + childMargins;
        float targetLargeChildSize = Math.min(measuredChildSize + childMargins, availableSpace);
        float targetSmallChildSize = MathUtils.clamp((measuredChildSize / 3.0f) + childMargins, e.h(child.getContext()) + childMargins, e.g(child.getContext()) + childMargins);
        float targetMediumChildSize = (targetLargeChildSize + targetSmallChildSize) / 2.0f;
        int[] smallCounts2 = a;
        if (availableSpace < 2.0f * smallChildSizeMin) {
            smallCounts2 = new int[]{0};
        }
        int[] mediumCounts2 = b;
        if (carousel.d() == 1) {
            smallCounts = d.a(smallCounts2);
            mediumCounts = d.a(mediumCounts2);
        } else {
            smallCounts = smallCounts2;
            mediumCounts = mediumCounts2;
        }
        int largeCountMin = (int) Math.max(1.0d, Math.floor((double) (((availableSpace - (((float) e.i(mediumCounts)) * targetMediumChildSize)) - (((float) e.i(smallCounts)) * smallChildSizeMax)) / targetLargeChildSize)));
        int largeCountMax = (int) Math.ceil((double) (availableSpace / targetLargeChildSize));
        int[] largeCounts = new int[((largeCountMax - largeCountMin) + 1)];
        for (int i = 0; i < largeCounts.length; i++) {
            largeCounts[i] = largeCountMax - i;
        }
        int i2 = largeCountMax;
        int i3 = largeCountMin;
        RecyclerView.LayoutParams layoutParams = childLayoutParams;
        a arrangement = a.c(availableSpace, targetSmallChildSize, smallChildSizeMin, smallChildSizeMax, smallCounts, targetMediumChildSize, mediumCounts, targetLargeChildSize, largeCounts);
        this.f1605a = arrangement.e();
        if (e(arrangement, carousel.getItemCount())) {
            a aVar = arrangement;
            arrangement = a.c(availableSpace, targetSmallChildSize, smallChildSizeMin, smallChildSizeMax, new int[]{arrangement.f1588b}, targetMediumChildSize, new int[]{arrangement.f1589c}, targetLargeChildSize, new int[]{arrangement.f1590d});
        } else {
            a aVar2 = arrangement;
        }
        return e.d(child.getContext(), childMargins, availableSpace, arrangement, carousel.d());
    }

    /* access modifiers changed from: package-private */
    public boolean e(a arrangement, int carouselItemCount) {
        int keylineSurplus = arrangement.e() - carouselItemCount;
        boolean changed = keylineSurplus > 0 && (arrangement.f1588b > 0 || arrangement.f1589c > 1);
        while (keylineSurplus > 0) {
            int i = arrangement.f1588b;
            if (i > 0) {
                arrangement.f1588b = i - 1;
            } else {
                int i2 = arrangement.f1589c;
                if (i2 > 1) {
                    arrangement.f1589c = i2 - 1;
                }
            }
            keylineSurplus--;
        }
        return changed;
    }

    /* access modifiers changed from: package-private */
    public boolean d(b carousel, int oldItemCount) {
        return (oldItemCount < this.f1605a && carousel.getItemCount() >= this.f1605a) || (oldItemCount >= this.f1605a && carousel.getItemCount() < this.f1605a);
    }
}
