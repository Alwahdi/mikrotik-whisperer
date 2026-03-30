package com.google.android.material.carousel;

import android.content.Context;
import com.google.android.material.carousel.f;

abstract class e {
    static float f(Context context) {
        return context.getResources().getDimension(cc0.m3_carousel_gone_size);
    }

    static float h(Context context) {
        return context.getResources().getDimension(cc0.m3_carousel_small_item_size_min);
    }

    static float g(Context context) {
        return context.getResources().getDimension(cc0.m3_carousel_small_item_size_max);
    }

    static f d(Context context, float childMargins, float availableSpace, a arrangement, int alignment) {
        if (alignment == 1) {
            return c(context, childMargins, availableSpace, arrangement);
        }
        return e(context, childMargins, availableSpace, arrangement);
    }

    static f e(Context context, float childHorizontalMargins, float availableSpace, a arrangement) {
        float f = childHorizontalMargins;
        float f2 = availableSpace;
        a aVar = arrangement;
        float extraSmallChildWidth = Math.min(f(context) + f, aVar.c);
        float largeStartCenterX = b(0.0f, aVar.c, aVar.f1590d);
        float start = j(0.0f, a(largeStartCenterX, aVar.c, aVar.f1590d), aVar.c, aVar.f1590d);
        float mediumCenterX = b(start, aVar.b, aVar.f1589c);
        float smallStartCenterX = b(j(start, mediumCenterX, aVar.b, aVar.f1589c), aVar.a, aVar.f1588b);
        float extraSmallTailCenterX = (extraSmallChildWidth / 2.0f) + f2;
        float extraSmallMask = d.b(extraSmallChildWidth, aVar.c, f);
        float smallMask = d.b(aVar.a, aVar.c, f);
        float mediumMask = d.b(aVar.b, aVar.c, f);
        float mediumMask2 = mediumMask;
        float smallMask2 = smallMask;
        float extraSmallMask2 = extraSmallMask;
        float smallStartCenterX2 = smallStartCenterX;
        f.b builder = new f.b(aVar.c, f2).a(0.0f - (extraSmallChildWidth / 2.0f), extraSmallMask, extraSmallChildWidth).g(largeStartCenterX, 0.0f, aVar.c, aVar.f1590d, true);
        if (aVar.f1589c > 0) {
            builder.b(mediumCenterX, mediumMask2, aVar.b);
        }
        int i = aVar.f1588b;
        if (i > 0) {
            builder.f(smallStartCenterX2, smallMask2, aVar.a, i);
        }
        builder.a(extraSmallTailCenterX, extraSmallMask2, extraSmallChildWidth);
        return builder.h();
    }

    static f c(Context context, float childHorizontalMargins, float availableSpace, a arrangement) {
        float extraSmallMask;
        float f = childHorizontalMargins;
        float f2 = availableSpace;
        a aVar = arrangement;
        float extraSmallChildWidth = Math.min(f(context) + f, aVar.c);
        float halfSmallStartCenterX = b(0.0f, aVar.a, aVar.f1588b);
        float halfSmallEndCenterX = a(halfSmallStartCenterX, aVar.a, (int) Math.floor((double) (((float) aVar.f1588b) / 2.0f)));
        float start = j(0.0f, halfSmallEndCenterX, aVar.a, aVar.f1588b);
        float halfMediumStartCenterX = b(start, aVar.b, aVar.f1589c);
        float halfMediumEndCenterX = a(halfMediumStartCenterX, aVar.b, (int) Math.floor((double) (((float) aVar.f1589c) / 2.0f)));
        float start2 = j(start, halfMediumEndCenterX, aVar.b, aVar.f1589c);
        float largeStartCenterX = b(start2, aVar.c, aVar.f1590d);
        float largeEndCenterX = a(largeStartCenterX, aVar.c, aVar.f1590d);
        float start3 = j(start2, largeEndCenterX, aVar.c, aVar.f1590d);
        float secondHalfMediumStartCenterX = b(start3, aVar.b, aVar.f1589c);
        float secondHalfMediumEndCenterX = a(secondHalfMediumStartCenterX, aVar.b, (int) Math.ceil((double) (((float) aVar.f1589c) / 2.0f)));
        float start4 = j(start3, secondHalfMediumEndCenterX, aVar.b, aVar.f1589c);
        float secondHalfSmallStartCenterX = b(start4, aVar.a, aVar.f1588b);
        float extraSmallTailCenterX = (extraSmallChildWidth / 2.0f) + f2;
        float extraSmallMask2 = d.b(extraSmallChildWidth, aVar.c, f);
        float f3 = start4;
        float f4 = secondHalfMediumEndCenterX;
        float smallMask = d.b(aVar.a, aVar.c, f);
        float f5 = halfSmallEndCenterX;
        float mediumMask = d.b(aVar.b, aVar.c, f);
        float f6 = halfMediumEndCenterX;
        float extraSmallHeadCenterX = 0.0f - (extraSmallChildWidth / 2.0f);
        f.b builder = new f.b(aVar.c, f2).a(extraSmallHeadCenterX, extraSmallMask2, extraSmallChildWidth);
        int i = aVar.f1588b;
        if (i > 0) {
            float f7 = extraSmallHeadCenterX;
            float f8 = largeEndCenterX;
            extraSmallMask = extraSmallMask2;
            builder.f(halfSmallStartCenterX, smallMask, aVar.a, (int) Math.floor((double) (((float) i) / 2.0f)));
        } else {
            float f9 = largeEndCenterX;
            extraSmallMask = extraSmallMask2;
        }
        int i2 = aVar.f1589c;
        if (i2 > 0) {
            builder.f(halfMediumStartCenterX, mediumMask, aVar.b, (int) Math.floor((double) (((float) i2) / 2.0f)));
        }
        float extraSmallMask3 = extraSmallMask;
        float f10 = halfSmallStartCenterX;
        float extraSmallTailCenterX2 = extraSmallTailCenterX;
        float f11 = halfMediumStartCenterX;
        float secondHalfMediumStartCenterX2 = secondHalfMediumStartCenterX;
        builder.g(largeStartCenterX, 0.0f, aVar.c, aVar.f1590d, true);
        int i3 = aVar.f1589c;
        if (i3 > 0) {
            builder.f(secondHalfMediumStartCenterX2, mediumMask, aVar.b, (int) Math.ceil((double) (((float) i3) / 2.0f)));
        }
        int i4 = aVar.f1588b;
        if (i4 > 0) {
            builder.f(secondHalfSmallStartCenterX, smallMask, aVar.a, (int) Math.ceil((double) (((float) i4) / 2.0f)));
        }
        builder.a(extraSmallTailCenterX2, extraSmallMask3, extraSmallChildWidth);
        return builder.h();
    }

    static int i(int[] array) {
        int largest = Integer.MIN_VALUE;
        for (int j : array) {
            if (j > largest) {
                largest = j;
            }
        }
        return largest;
    }

    static float b(float start, float itemSize, int count) {
        if (count > 0) {
            return (itemSize / 2.0f) + start;
        }
        return start;
    }

    static float a(float startKeylinePos, float itemSize, int count) {
        return (((float) Math.max(0, count - 1)) * itemSize) + startKeylinePos;
    }

    static float j(float curPosition, float lastEndKeyline, float itemSize, int count) {
        if (count > 0) {
            return (itemSize / 2.0f) + lastEndKeyline;
        }
        return curPosition;
    }
}
