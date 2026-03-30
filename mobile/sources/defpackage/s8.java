package defpackage;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

/* renamed from: s8  reason: default package */
public abstract /* synthetic */ class s8 {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[CircularProgressBar.b.values().length];
        a = iArr;
        iArr[CircularProgressBar.b.LEFT_TO_RIGHT.ordinal()] = 1;
        iArr[CircularProgressBar.b.RIGHT_TO_LEFT.ordinal()] = 2;
        iArr[CircularProgressBar.b.TOP_TO_BOTTOM.ordinal()] = 3;
        iArr[CircularProgressBar.b.BOTTOM_TO_END.ordinal()] = 4;
    }
}
