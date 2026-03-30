package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import androidx.core.math.MathUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ColorStateListInflaterCompat {
    private static final ThreadLocal<TypedValue> sTempTypedValue = new ThreadLocal<>();

    private ColorStateListInflaterCompat() {
    }

    @Nullable
    public static ColorStateList inflate(@NonNull Resources resources, @XmlRes int resId, @Nullable Resources.Theme theme) {
        try {
            return createFromXml(resources, resources.getXml(resId), theme);
        } catch (Exception e) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0012  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0017  */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.res.ColorStateList createFromXml(@androidx.annotation.NonNull android.content.res.Resources r4, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser r5, @androidx.annotation.Nullable android.content.res.Resources.Theme r6) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r5)
        L_0x0004:
            int r1 = r5.next()
            r2 = r1
            r3 = 2
            if (r1 == r3) goto L_0x0010
            r1 = 1
            if (r2 == r1) goto L_0x0010
            goto L_0x0004
        L_0x0010:
            if (r2 != r3) goto L_0x0017
            android.content.res.ColorStateList r1 = createFromXmlInner(r4, r5, r0, r6)
            return r1
        L_0x0017:
            org.xmlpull.v1.XmlPullParserException r1 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r3 = "No start tag found"
            r1.<init>(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ColorStateListInflaterCompat.createFromXml(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }

    @NonNull
    public static ColorStateList createFromXmlInner(@NonNull Resources r, @NonNull XmlPullParser parser, @NonNull AttributeSet attrs, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = parser.getName();
        if (name.equals("selector")) {
            return inflate(r, parser, attrs, theme);
        }
        throw new XmlPullParserException(parser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    /* JADX WARNING: type inference failed for: r5v5, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList inflate(@androidx.annotation.NonNull android.content.res.Resources r21, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser r22, @androidx.annotation.NonNull android.util.AttributeSet r23, @androidx.annotation.Nullable android.content.res.Resources.Theme r24) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r1 = r21
            r2 = r23
            r3 = r24
            int r0 = r22.getDepth()
            r4 = 1
            int r5 = r0 + 1
            r0 = 20
            int[][] r0 = new int[r0][]
            int r6 = r0.length
            int[] r6 = new int[r6]
            r7 = 0
            r8 = r7
            r7 = r6
            r6 = r0
        L_0x0018:
            int r0 = r22.next()
            r9 = r0
            if (r0 == r4) goto L_0x011f
            int r0 = r22.getDepth()
            r11 = r0
            if (r0 >= r5) goto L_0x0030
            r0 = 3
            if (r9 == r0) goto L_0x002a
            goto L_0x0030
        L_0x002a:
            r17 = r5
            r18 = r9
            goto L_0x0123
        L_0x0030:
            r0 = 2
            if (r9 != r0) goto L_0x0112
            if (r11 > r5) goto L_0x0112
            java.lang.String r0 = r22.getName()
            java.lang.String r12 = "item"
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x0045
            r17 = r5
            goto L_0x0116
        L_0x0045:
            int[] r0 = androidx.core.R.styleable.ColorStateListItem
            android.content.res.TypedArray r12 = obtainAttributes(r1, r3, r2, r0)
            int r0 = androidx.core.R.styleable.ColorStateListItem_android_color
            r13 = -1
            int r14 = r12.getResourceId(r0, r13)
            r15 = -65281(0xffffffffffff00ff, float:NaN)
            if (r14 == r13) goto L_0x0072
            boolean r13 = isColorInt(r1, r14)
            if (r13 != 0) goto L_0x0072
            android.content.res.XmlResourceParser r0 = r1.getXml(r14)     // Catch:{ Exception -> 0x006a }
            android.content.res.ColorStateList r0 = createFromXml(r1, r0, r3)     // Catch:{ Exception -> 0x006a }
            int r0 = r0.getDefaultColor()     // Catch:{ Exception -> 0x006a }
            goto L_0x0071
        L_0x006a:
            r0 = move-exception
            int r13 = androidx.core.R.styleable.ColorStateListItem_android_color
            int r0 = r12.getColor(r13, r15)
        L_0x0071:
            goto L_0x0076
        L_0x0072:
            int r0 = r12.getColor(r0, r15)
        L_0x0076:
            r13 = 1065353216(0x3f800000, float:1.0)
            int r15 = androidx.core.R.styleable.ColorStateListItem_android_alpha
            boolean r16 = r12.hasValue(r15)
            if (r16 == 0) goto L_0x0085
            float r13 = r12.getFloat(r15, r13)
            goto L_0x0091
        L_0x0085:
            int r15 = androidx.core.R.styleable.ColorStateListItem_alpha
            boolean r16 = r12.hasValue(r15)
            if (r16 == 0) goto L_0x0091
            float r13 = r12.getFloat(r15, r13)
        L_0x0091:
            int r15 = android.os.Build.VERSION.SDK_INT
            r4 = 31
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r15 < r4) goto L_0x00a6
            int r4 = androidx.core.R.styleable.ColorStateListItem_android_lStar
            boolean r15 = r12.hasValue(r4)
            if (r15 == 0) goto L_0x00a6
            float r4 = r12.getFloat(r4, r10)
            goto L_0x00ac
        L_0x00a6:
            int r4 = androidx.core.R.styleable.ColorStateListItem_lStar
            float r4 = r12.getFloat(r4, r10)
        L_0x00ac:
            r12.recycle()
            r10 = 0
            int r15 = r23.getAttributeCount()
            int[] r1 = new int[r15]
            r17 = 0
            r3 = r17
        L_0x00ba:
            if (r3 >= r15) goto L_0x00ef
            r17 = r5
            int r5 = r2.getAttributeNameResource(r3)
            r18 = r9
            r9 = 16843173(0x10101a5, float:2.3694738E-38)
            if (r5 == r9) goto L_0x00e8
            r9 = 16843551(0x101031f, float:2.3695797E-38)
            if (r5 == r9) goto L_0x00e8
            int r9 = androidx.core.R.attr.alpha
            if (r5 == r9) goto L_0x00e8
            int r9 = androidx.core.R.attr.lStar
            if (r5 == r9) goto L_0x00e8
            int r9 = r10 + 1
            r19 = r9
            r9 = 0
            boolean r20 = r2.getAttributeBooleanValue(r3, r9)
            if (r20 == 0) goto L_0x00e3
            r9 = r5
            goto L_0x00e4
        L_0x00e3:
            int r9 = -r5
        L_0x00e4:
            r1[r10] = r9
            r10 = r19
        L_0x00e8:
            int r3 = r3 + 1
            r5 = r17
            r9 = r18
            goto L_0x00ba
        L_0x00ef:
            r17 = r5
            r18 = r9
            int[] r1 = android.util.StateSet.trimStateSet(r1, r10)
            int r3 = modulateColorAlpha(r0, r13, r4)
            int[] r7 = androidx.core.content.res.GrowingArrayUtils.append((int[]) r7, (int) r8, (int) r3)
            java.lang.Object[] r5 = androidx.core.content.res.GrowingArrayUtils.append((T[]) r6, (int) r8, r1)
            r6 = r5
            int[][] r6 = (int[][]) r6
            int r8 = r8 + 1
            r1 = r21
            r3 = r24
            r5 = r17
            r4 = 1
            goto L_0x0018
        L_0x0112:
            r17 = r5
            r18 = r9
        L_0x0116:
            r1 = r21
            r3 = r24
            r5 = r17
            r4 = 1
            goto L_0x0018
        L_0x011f:
            r17 = r5
            r18 = r9
        L_0x0123:
            int[] r0 = new int[r8]
            int[][] r1 = new int[r8][]
            r3 = 0
            java.lang.System.arraycopy(r7, r3, r0, r3, r8)
            java.lang.System.arraycopy(r6, r3, r1, r3, r8)
            android.content.res.ColorStateList r3 = new android.content.res.ColorStateList
            r3.<init>(r1, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ColorStateListInflaterCompat.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }

    private static boolean isColorInt(@NonNull Resources r, @ColorRes int resId) {
        TypedValue value = getTypedValue();
        r.getValue(resId, value, true);
        int i = value.type;
        if (i < 28 || i > 31) {
            return false;
        }
        return true;
    }

    @NonNull
    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> threadLocal = sTempTypedValue;
        TypedValue tv = threadLocal.get();
        if (tv != null) {
            return tv;
        }
        TypedValue tv2 = new TypedValue();
        threadLocal.set(tv2);
        return tv2;
    }

    private static TypedArray obtainAttributes(Resources res, Resources.Theme theme, AttributeSet set, int[] attrs) {
        if (theme == null) {
            return res.obtainAttributes(set, attrs);
        }
        return theme.obtainStyledAttributes(set, attrs, 0, 0);
    }

    @ColorInt
    private static int modulateColorAlpha(@ColorInt int color, @FloatRange(from = 0.0d, to = 1.0d) float alphaMod, @FloatRange(from = 0.0d, to = 100.0d) float lStar) {
        boolean validLStar = lStar >= 0.0f && lStar <= 100.0f;
        if (alphaMod == 1.0f && !validLStar) {
            return color;
        }
        int alpha = MathUtils.clamp((int) ((((float) Color.alpha(color)) * alphaMod) + 0.5f), 0, 255);
        if (validLStar) {
            CamColor baseCam = CamColor.fromColor(color);
            color = CamColor.toColor(baseCam.getHue(), baseCam.getChroma(), lStar);
        }
        return (16777215 & color) | (alpha << 24);
    }
}
