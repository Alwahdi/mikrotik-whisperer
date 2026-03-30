package com.google.android.material.carousel;

import android.view.View;

public abstract class d {
    /* access modifiers changed from: package-private */
    public abstract f c(b bVar, View view);

    /* access modifiers changed from: package-private */
    public abstract boolean d(b bVar, int i);

    static float b(float maskedSize, float unmaskedSize, float childMargins) {
        return 1.0f - ((maskedSize - childMargins) / (unmaskedSize - childMargins));
    }

    static int[] a(int[] count) {
        int[] doubledCount = new int[count.length];
        for (int i = 0; i < doubledCount.length; i++) {
            doubledCount[i] = count[i] * 2;
        }
        return doubledCount;
    }
}
