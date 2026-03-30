package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.CompoundButtonCompat;

/* renamed from: n00  reason: default package */
public class n00 extends AppCompatRadioButton {
    private static final int a = uc0.Widget_MaterialComponents_CompoundButton_RadioButton;

    /* renamed from: a  reason: collision with other field name */
    private static final int[][] f4394a = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};

    /* renamed from: a  reason: collision with other field name */
    private ColorStateList f4395a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f4396a;

    public n00(Context context, AttributeSet attrs) {
        this(context, attrs, yb0.P);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public n00(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = a
            android.content.Context r0 = defpackage.t00.c(r8, r9, r10, r4)
            r7.<init>(r0, r9, r10)
            android.content.Context r8 = r7.getContext()
            int[] r2 = defpackage.xc0.f5605E0
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r0 = defpackage.vq0.i(r0, r1, r2, r3, r4, r5)
            int r1 = defpackage.xc0.i3
            boolean r2 = r0.hasValue(r1)
            if (r2 == 0) goto L_0x0029
            android.content.res.ColorStateList r1 = defpackage.o00.a(r8, r0, r1)
            androidx.core.widget.CompoundButtonCompat.setButtonTintList(r7, r1)
        L_0x0029:
            int r1 = defpackage.xc0.j3
            boolean r1 = r0.getBoolean(r1, r6)
            r7.f4396a = r1
            r0.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.n00.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f4396a && CompoundButtonCompat.getButtonTintList(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean useMaterialThemeColors) {
        this.f4396a = useMaterialThemeColors;
        if (useMaterialThemeColors) {
            CompoundButtonCompat.setButtonTintList(this, getMaterialThemeColorsTintList());
        } else {
            CompoundButtonCompat.setButtonTintList(this, (ColorStateList) null);
        }
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f4395a == null) {
            int colorControlActivated = k00.d(this, yb0.h);
            int colorOnSurface = k00.d(this, yb0.colorOnSurface);
            int colorSurface = k00.d(this, yb0.colorSurface);
            int[][] iArr = f4394a;
            int[] radioButtonColorList = new int[iArr.length];
            radioButtonColorList[0] = k00.k(colorSurface, colorControlActivated, 1.0f);
            radioButtonColorList[1] = k00.k(colorSurface, colorOnSurface, 0.54f);
            radioButtonColorList[2] = k00.k(colorSurface, colorOnSurface, 0.38f);
            radioButtonColorList[3] = k00.k(colorSurface, colorOnSurface, 0.38f);
            this.f4395a = new ColorStateList(iArr, radioButtonColorList);
        }
        return this.f4395a;
    }
}
