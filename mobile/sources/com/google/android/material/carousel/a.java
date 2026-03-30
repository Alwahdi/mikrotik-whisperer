package com.google.android.material.carousel;

import androidx.core.math.MathUtils;

final class a {
    float a;

    /* renamed from: a  reason: collision with other field name */
    final int f1587a;
    float b;

    /* renamed from: b  reason: collision with other field name */
    int f1588b;
    float c;

    /* renamed from: c  reason: collision with other field name */
    int f1589c;
    final float d;

    /* renamed from: d  reason: collision with other field name */
    final int f1590d;

    a(int priority, float targetSmallSize, float minSmallSize, float maxSmallSize, int smallCount, float targetMediumSize, int mediumCount, float targetLargeSize, int largeCount, float availableSpace) {
        this.f1587a = priority;
        this.a = MathUtils.clamp(targetSmallSize, minSmallSize, maxSmallSize);
        this.f1588b = smallCount;
        this.b = targetMediumSize;
        this.f1589c = mediumCount;
        this.c = targetLargeSize;
        this.f1590d = largeCount;
        d(availableSpace, minSmallSize, maxSmallSize, targetLargeSize);
        this.d = b(targetLargeSize);
    }

    public String toString() {
        return "Arrangement [priority=" + this.f1587a + ", smallCount=" + this.f1588b + ", smallSize=" + this.a + ", mediumCount=" + this.f1589c + ", mediumSize=" + this.b + ", largeCount=" + this.f1590d + ", largeSize=" + this.c + ", cost=" + this.d + "]";
    }

    private float f() {
        return (this.c * ((float) this.f1590d)) + (this.b * ((float) this.f1589c)) + (this.a * ((float) this.f1588b));
    }

    private void d(float availableSpace, float minSmallSize, float maxSmallSize, float targetLargeSize) {
        float delta = availableSpace - f();
        int i = this.f1588b;
        if (i > 0 && delta > 0.0f) {
            float f = this.a;
            this.a = f + Math.min(delta / ((float) i), maxSmallSize - f);
        } else if (i > 0 && delta < 0.0f) {
            float f2 = this.a;
            this.a = f2 + Math.max(delta / ((float) i), minSmallSize - f2);
        }
        int i2 = this.f1588b;
        float f3 = i2 > 0 ? this.a : 0.0f;
        this.a = f3;
        float a2 = a(availableSpace, i2, f3, this.f1589c, this.f1590d);
        this.c = a2;
        float f4 = (this.a + a2) / 2.0f;
        this.b = f4;
        int i3 = this.f1589c;
        if (i3 > 0 && a2 != targetLargeSize) {
            float targetAdjustment = (targetLargeSize - a2) * ((float) this.f1590d);
            float distribute = Math.min(Math.abs(targetAdjustment), f4 * 0.1f * ((float) i3));
            if (targetAdjustment > 0.0f) {
                this.b -= distribute / ((float) this.f1589c);
                this.c += distribute / ((float) this.f1590d);
                return;
            }
            this.b += distribute / ((float) this.f1589c);
            this.c -= distribute / ((float) this.f1590d);
        }
    }

    private float a(float availableSpace, int smallCount, float smallSize, int mediumCount, int largeCount) {
        return (availableSpace - ((((float) smallCount) + (((float) mediumCount) / 2.0f)) * (smallCount > 0 ? smallSize : 0.0f))) / (((float) largeCount) + (((float) mediumCount) / 2.0f));
    }

    private boolean g() {
        int i = this.f1590d;
        if (i > 0 && this.f1588b > 0 && this.f1589c > 0) {
            float f = this.c;
            float f2 = this.b;
            if (f <= f2 || f2 <= this.a) {
                return false;
            }
            return true;
        } else if (i <= 0 || this.f1588b <= 0 || this.c > this.a) {
            return true;
        } else {
            return false;
        }
    }

    private float b(float targetLargeSize) {
        if (!g()) {
            return Float.MAX_VALUE;
        }
        return Math.abs(targetLargeSize - this.c) * ((float) this.f1587a);
    }

    static a c(float availableSpace, float targetSmallSize, float minSmallSize, float maxSmallSize, int[] smallCounts, float targetMediumSize, int[] mediumCounts, float targetLargeSize, int[] largeCounts) {
        int[] iArr = smallCounts;
        int[] iArr2 = mediumCounts;
        a lowestCostArrangement = null;
        int priority = 1;
        for (int largeCount : largeCounts) {
            int length = iArr2.length;
            int i = 0;
            while (i < length) {
                int mediumCount = iArr2[i];
                int length2 = iArr.length;
                int i2 = 0;
                while (i2 < length2) {
                    int i3 = i2;
                    int i4 = length2;
                    int i5 = i;
                    int i6 = length;
                    a arrangement = new a(priority, targetSmallSize, minSmallSize, maxSmallSize, iArr[i2], targetMediumSize, mediumCount, targetLargeSize, largeCount, availableSpace);
                    if (lowestCostArrangement == null || arrangement.d < lowestCostArrangement.d) {
                        lowestCostArrangement = arrangement;
                        if (lowestCostArrangement.d == 0.0f) {
                            return lowestCostArrangement;
                        }
                    }
                    priority++;
                    i2 = i3 + 1;
                    length2 = i4;
                    i = i5;
                    length = i6;
                }
                int i7 = length;
                i++;
            }
        }
        return lowestCostArrangement;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f1588b + this.f1589c + this.f1590d;
    }
}
