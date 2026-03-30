package com.itextpdf.text;

public class e {
    protected char a;

    /* renamed from: a  reason: collision with other field name */
    protected float f2633a;

    /* renamed from: a  reason: collision with other field name */
    protected b f2634a;

    /* renamed from: a  reason: collision with other field name */
    protected xh f2635a;

    public enum b {
        LEFT,
        RIGHT,
        CENTER,
        ANCHOR
    }

    public static e f(float currentPosition, float tabInterval) {
        float currentPosition2 = ((float) Math.round(currentPosition * 1000.0f)) / 1000.0f;
        float tabInterval2 = ((float) Math.round(tabInterval * 1000.0f)) / 1000.0f;
        return new e((currentPosition2 + tabInterval2) - (currentPosition2 % tabInterval2));
    }

    public e(float position) {
        this(position, b.LEFT);
    }

    public e(float position, b alignment) {
        this(position, (xh) null, alignment);
    }

    public e(float position, xh leader, b alignment) {
        this(position, leader, alignment, '.');
    }

    public e(float position, xh leader, b alignment, char anchorChar) {
        this.f2634a = b.LEFT;
        this.a = '.';
        this.f2633a = position;
        this.f2635a = leader;
        this.f2634a = alignment;
        this.a = anchorChar;
    }

    public float d() {
        return this.f2633a;
    }

    public void g(float position) {
        this.f2633a = position;
    }

    public b a() {
        return this.f2634a;
    }

    public xh c() {
        return this.f2635a;
    }

    public char b() {
        return this.a;
    }

    public float e(float tabPosition, float currentPosition, float anchorPosition) {
        float newPosition = this.f2633a;
        float textWidth = currentPosition - tabPosition;
        switch (a.a[this.f2634a.ordinal()]) {
            case 1:
                float f = this.f2633a;
                if (tabPosition + textWidth < f) {
                    return f - textWidth;
                }
                return tabPosition;
            case 2:
                float f2 = this.f2633a;
                if ((textWidth / 2.0f) + tabPosition < f2) {
                    return f2 - (textWidth / 2.0f);
                }
                return tabPosition;
            case 3:
                if (!Float.isNaN(anchorPosition)) {
                    float f3 = this.f2633a;
                    if (anchorPosition < f3) {
                        return f3 - (anchorPosition - tabPosition);
                    }
                    return tabPosition;
                }
                float f4 = this.f2633a;
                if (tabPosition + textWidth < f4) {
                    return f4 - textWidth;
                }
                return tabPosition;
            default:
                return newPosition;
        }
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[b.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[b.ANCHOR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }
}
