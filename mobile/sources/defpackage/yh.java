package defpackage;

import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.ColorStateListDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import androidx.core.graphics.drawable.DrawableCompat;
import java.util.Arrays;

/* renamed from: yh  reason: default package */
public abstract class yh {
    public static void k(Drawable drawable, int color) {
        boolean hasTint = color != 0;
        if (Build.VERSION.SDK_INT == 21) {
            if (hasTint) {
                drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
            } else {
                drawable.setColorFilter((ColorFilter) null);
            }
        } else if (hasTint) {
            DrawableCompat.setTint(drawable, color);
        } else {
            DrawableCompat.setTintList(drawable, (ColorStateList) null);
        }
    }

    public static PorterDuffColorFilter l(Drawable drawable, ColorStateList tint, PorterDuff.Mode tintMode) {
        if (tint == null || tintMode == null) {
            return null;
        }
        return new PorterDuffColorFilter(tint.getColorForState(drawable.getState(), 0), tintMode);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003f A[Catch:{ IOException | XmlPullParserException -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0014 A[Catch:{ IOException | XmlPullParserException -> 0x0047 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.AttributeSet i(android.content.Context r5, int r6, java.lang.CharSequence r7) {
        /*
            android.content.res.Resources r0 = r5.getResources()     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            android.content.res.XmlResourceParser r0 = r0.getXml(r6)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
        L_0x0008:
            int r1 = r0.next()     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            r2 = 2
            if (r1 == r2) goto L_0x0012
            r3 = 1
            if (r1 != r3) goto L_0x0008
        L_0x0012:
            if (r1 != r2) goto L_0x003f
            java.lang.String r2 = r0.getName()     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            boolean r2 = android.text.TextUtils.equals(r2, r7)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            if (r2 == 0) goto L_0x0023
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r0)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            return r2
        L_0x0023:
            org.xmlpull.v1.XmlPullParserException r2 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            r3.<init>()     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            java.lang.String r4 = "Must have a <"
            r3.append(r4)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            r3.append(r7)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            java.lang.String r4 = "> start tag"
            r3.append(r4)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            java.lang.String r3 = r3.toString()     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            r2.<init>(r3)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            throw r2     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
        L_0x003f:
            org.xmlpull.v1.XmlPullParserException r2 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            java.lang.String r3 = "No start tag found"
            r2.<init>(r3)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            throw r2     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
        L_0x0047:
            r0 = move-exception
            goto L_0x004a
        L_0x0049:
            r0 = move-exception
        L_0x004a:
            android.content.res.Resources$NotFoundException r1 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Can't load badge resource ID #0x"
            r2.append(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r6)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            r1.initCause(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yh.i(android.content.Context, int, java.lang.CharSequence):android.util.AttributeSet");
    }

    public static Drawable c(Drawable drawable, ColorStateList tintList, PorterDuff.Mode tintMode) {
        return d(drawable, tintList, tintMode, Build.VERSION.SDK_INT < 23);
    }

    private static Drawable d(Drawable drawable, ColorStateList tintList, PorterDuff.Mode tintMode, boolean forceMutate) {
        if (drawable == null) {
            return null;
        }
        if (tintList != null) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (tintMode != null) {
                DrawableCompat.setTintMode(drawable, tintMode);
            }
        } else if (forceMutate) {
            drawable.mutate();
        }
        return drawable;
    }

    public static Drawable a(Drawable bottomLayerDrawable, Drawable topLayerDrawable) {
        return b(bottomLayerDrawable, topLayerDrawable, -1, -1);
    }

    public static Drawable b(Drawable bottomLayerDrawable, Drawable topLayerDrawable, int topLayerDesiredWidth, int topLayerDesiredHeight) {
        int topLayerNewHeight;
        int topLayerNewWidth;
        Drawable topLayerDrawable2 = topLayerDrawable;
        int topLayerDesiredWidth2 = topLayerDesiredWidth;
        int topLayerDesiredHeight2 = topLayerDesiredHeight;
        if (bottomLayerDrawable == null) {
            return topLayerDrawable2;
        }
        if (topLayerDrawable2 == null) {
            return bottomLayerDrawable;
        }
        boolean shouldScaleTopLayer = (topLayerDesiredWidth2 == -1 || topLayerDesiredHeight2 == -1) ? false : true;
        if (topLayerDesiredWidth2 == -1) {
            topLayerDesiredWidth2 = h(bottomLayerDrawable, topLayerDrawable);
        }
        if (topLayerDesiredHeight2 == -1) {
            topLayerDesiredHeight2 = g(bottomLayerDrawable, topLayerDrawable);
        }
        if (topLayerDesiredWidth2 > bottomLayerDrawable.getIntrinsicWidth() || topLayerDesiredHeight2 > bottomLayerDrawable.getIntrinsicHeight()) {
            float topLayerRatio = ((float) topLayerDesiredWidth2) / ((float) topLayerDesiredHeight2);
            if (topLayerRatio >= ((float) bottomLayerDrawable.getIntrinsicWidth()) / ((float) bottomLayerDrawable.getIntrinsicHeight())) {
                int topLayerNewWidth2 = bottomLayerDrawable.getIntrinsicWidth();
                topLayerNewWidth = topLayerNewWidth2;
                topLayerNewHeight = (int) (((float) topLayerNewWidth2) / topLayerRatio);
            } else {
                int topLayerNewWidth3 = bottomLayerDrawable.getIntrinsicHeight();
                topLayerNewHeight = topLayerNewWidth3;
                topLayerNewWidth = (int) (((float) topLayerNewWidth3) * topLayerRatio);
            }
        } else {
            topLayerNewWidth = topLayerDesiredWidth2;
            topLayerNewHeight = topLayerDesiredHeight2;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            LayerDrawable drawable = new LayerDrawable(new Drawable[]{bottomLayerDrawable, topLayerDrawable2});
            drawable.setLayerSize(1, topLayerNewWidth, topLayerNewHeight);
            drawable.setLayerGravity(1, 17);
            return drawable;
        }
        if (shouldScaleTopLayer) {
            topLayerDrawable2 = new yi0(topLayerDrawable2, topLayerNewWidth, topLayerNewHeight);
        }
        LayerDrawable drawable2 = new LayerDrawable(new Drawable[]{bottomLayerDrawable, topLayerDrawable2});
        int horizontalInset = Math.max((bottomLayerDrawable.getIntrinsicWidth() - topLayerNewWidth) / 2, 0);
        int verticalInset = Math.max((bottomLayerDrawable.getIntrinsicHeight() - topLayerNewHeight) / 2, 0);
        drawable2.setLayerInset(1, horizontalInset, verticalInset, horizontalInset, verticalInset);
        return drawable2;
    }

    private static int h(Drawable bottomLayerDrawable, Drawable topLayerDrawable) {
        int topLayerIntrinsicWidth = topLayerDrawable.getIntrinsicWidth();
        return topLayerIntrinsicWidth != -1 ? topLayerIntrinsicWidth : bottomLayerDrawable.getIntrinsicWidth();
    }

    private static int g(Drawable bottomLayerDrawable, Drawable topLayerDrawable) {
        int topLayerIntrinsicHeight = topLayerDrawable.getIntrinsicHeight();
        return topLayerIntrinsicHeight != -1 ? topLayerIntrinsicHeight : bottomLayerDrawable.getIntrinsicHeight();
    }

    public static int[] e(int[] state) {
        for (int i = 0; i < state.length; i++) {
            if (state[i] == 16842912) {
                return state;
            }
            if (state[i] == 0) {
                int[] newState = (int[]) state.clone();
                newState[i] = 16842912;
                return newState;
            }
        }
        int[] newState2 = Arrays.copyOf(state, state.length + 1);
        newState2[state.length] = 16842912;
        return newState2;
    }

    public static void j(Outline outline, Path path) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            outline.setPath(path);
        } else if (i >= 29) {
            try {
                outline.setConvexPath(path);
            } catch (IllegalArgumentException e) {
            }
        } else if (i >= 21 && path.isConvex()) {
            outline.setConvexPath(path);
        }
    }

    public static ColorStateList f(Drawable drawable) {
        if (drawable instanceof ColorDrawable) {
            return ColorStateList.valueOf(((ColorDrawable) drawable).getColor());
        }
        if (Build.VERSION.SDK_INT < 29 || !(drawable instanceof ColorStateListDrawable)) {
            return null;
        }
        return ((ColorStateListDrawable) drawable).getColorStateList();
    }
}
