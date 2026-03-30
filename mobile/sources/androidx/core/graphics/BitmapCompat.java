package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;

public final class BitmapCompat {
    public static boolean hasMipMap(@NonNull Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Api17Impl.hasMipMap(bitmap);
        }
        return false;
    }

    public static void setHasMipMap(@NonNull Bitmap bitmap, boolean hasMipMap) {
        if (Build.VERSION.SDK_INT >= 17) {
            Api17Impl.setHasMipMap(bitmap, hasMipMap);
        }
    }

    public static int getAllocationByteCount(@NonNull Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Api19Impl.getAllocationByteCount(bitmap);
        }
        return bitmap.getByteCount();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01db, code lost:
        if (androidx.core.graphics.BitmapCompat.Api27Impl.isAlreadyF16AndLinear(r10) == false) goto L_0x01f2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0215  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0192  */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap createScaledBitmap(@androidx.annotation.NonNull android.graphics.Bitmap r29, int r30, int r31, @androidx.annotation.Nullable android.graphics.Rect r32, boolean r33) {
        /*
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r32
            if (r1 <= 0) goto L_0x0246
            if (r2 <= 0) goto L_0x0246
            if (r3 == 0) goto L_0x0035
            boolean r4 = r32.isEmpty()
            if (r4 != 0) goto L_0x002d
            int r4 = r3.left
            if (r4 < 0) goto L_0x002d
            int r4 = r3.right
            int r5 = r29.getWidth()
            if (r4 > r5) goto L_0x002d
            int r4 = r3.top
            if (r4 < 0) goto L_0x002d
            int r4 = r3.bottom
            int r5 = r29.getHeight()
            if (r4 > r5) goto L_0x002d
            goto L_0x0035
        L_0x002d:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "srcRect must be contained by srcBm!"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            r4 = r29
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 27
            if (r5 < r6) goto L_0x0041
            android.graphics.Bitmap r4 = androidx.core.graphics.BitmapCompat.Api27Impl.copyBitmapIfHardware(r29)
        L_0x0041:
            if (r3 == 0) goto L_0x0048
            int r7 = r32.width()
            goto L_0x004c
        L_0x0048:
            int r7 = r29.getWidth()
        L_0x004c:
            if (r3 == 0) goto L_0x0053
            int r8 = r32.height()
            goto L_0x0057
        L_0x0053:
            int r8 = r29.getHeight()
        L_0x0057:
            float r9 = (float) r1
            float r10 = (float) r7
            float r9 = r9 / r10
            float r10 = (float) r2
            float r11 = (float) r8
            float r10 = r10 / r11
            if (r3 == 0) goto L_0x0062
            int r12 = r3.left
            goto L_0x0063
        L_0x0062:
            r12 = 0
        L_0x0063:
            if (r3 == 0) goto L_0x0068
            int r13 = r3.top
            goto L_0x0069
        L_0x0068:
            r13 = 0
        L_0x0069:
            r14 = 1
            if (r12 != 0) goto L_0x008c
            if (r13 != 0) goto L_0x008c
            int r15 = r29.getWidth()
            if (r1 != r15) goto L_0x008c
            int r15 = r29.getHeight()
            if (r2 != r15) goto L_0x008c
            boolean r5 = r29.isMutable()
            if (r5 == 0) goto L_0x008b
            if (r0 != r4) goto L_0x008b
            android.graphics.Bitmap$Config r5 = r29.getConfig()
            android.graphics.Bitmap r5 = r0.copy(r5, r14)
            return r5
        L_0x008b:
            return r4
        L_0x008c:
            android.graphics.Paint r15 = new android.graphics.Paint
            r15.<init>(r14)
            r15.setFilterBitmap(r14)
            r11 = 29
            if (r5 < r11) goto L_0x009c
            androidx.core.graphics.BitmapCompat.Api29Impl.setPaintBlendMode(r15)
            goto L_0x00a6
        L_0x009c:
            android.graphics.PorterDuffXfermode r11 = new android.graphics.PorterDuffXfermode
            android.graphics.PorterDuff$Mode r14 = android.graphics.PorterDuff.Mode.SRC
            r11.<init>(r14)
            r15.setXfermode(r11)
        L_0x00a6:
            if (r7 != r1) goto L_0x00bf
            if (r8 != r2) goto L_0x00bf
            android.graphics.Bitmap$Config r5 = r4.getConfig()
            android.graphics.Bitmap r5 = android.graphics.Bitmap.createBitmap(r1, r2, r5)
            android.graphics.Canvas r6 = new android.graphics.Canvas
            r6.<init>(r5)
            int r11 = -r12
            float r11 = (float) r11
            int r14 = -r13
            float r14 = (float) r14
            r6.drawBitmap(r4, r11, r14, r15)
            return r5
        L_0x00bf:
            r18 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r18 = java.lang.Math.log(r18)
            r11 = 1065353216(0x3f800000, float:1.0)
            int r14 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r14 <= 0) goto L_0x00d9
            r14 = r7
            double r6 = (double) r9
            double r6 = java.lang.Math.log(r6)
            double r6 = r6 / r18
            double r6 = java.lang.Math.ceil(r6)
            int r6 = (int) r6
            goto L_0x00e6
        L_0x00d9:
            r14 = r7
            double r6 = (double) r9
            double r6 = java.lang.Math.log(r6)
            double r6 = r6 / r18
            double r6 = java.lang.Math.floor(r6)
            int r6 = (int) r6
        L_0x00e6:
            int r7 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r7 <= 0) goto L_0x00f9
            r7 = r4
            double r3 = (double) r10
            double r3 = java.lang.Math.log(r3)
            double r3 = r3 / r18
            double r3 = java.lang.Math.ceil(r3)
            int r3 = (int) r3
            goto L_0x0106
        L_0x00f9:
            r7 = r4
            double r3 = (double) r10
            double r3 = java.lang.Math.log(r3)
            double r3 = r3 / r18
            double r3 = java.lang.Math.floor(r3)
            int r3 = (int) r3
        L_0x0106:
            r4 = r6
            r11 = r3
            r20 = 0
            r21 = 0
            if (r33 == 0) goto L_0x015c
            r22 = r9
            r9 = 27
            if (r5 < r9) goto L_0x0154
            boolean r5 = androidx.core.graphics.BitmapCompat.Api27Impl.isAlreadyF16AndLinear(r29)
            if (r5 != 0) goto L_0x0154
            if (r6 <= 0) goto L_0x0124
            r5 = r14
            r9 = 1
            int r14 = sizeAtStep(r5, r1, r9, r4)
            goto L_0x0126
        L_0x0124:
            r5 = r14
            r9 = 1
        L_0x0126:
            if (r3 <= 0) goto L_0x012d
            int r17 = sizeAtStep(r8, r2, r9, r11)
            goto L_0x012f
        L_0x012d:
            r17 = r8
        L_0x012f:
            r23 = r17
            r17 = r3
            r3 = r23
            r23 = r6
            android.graphics.Bitmap r6 = androidx.core.graphics.BitmapCompat.Api27Impl.createBitmapWithSourceColorspace(r14, r3, r0, r9)
            android.graphics.Canvas r9 = new android.graphics.Canvas
            r9.<init>(r6)
            r24 = r3
            int r3 = -r12
            float r3 = (float) r3
            r25 = r10
            int r10 = -r13
            float r10 = (float) r10
            r9.drawBitmap(r7, r3, r10, r15)
            r12 = 0
            r13 = 0
            r3 = r6
            r20 = r7
            r21 = 1
            goto L_0x0166
        L_0x0154:
            r17 = r3
            r23 = r6
            r25 = r10
            r5 = r14
            goto L_0x0165
        L_0x015c:
            r17 = r3
            r23 = r6
            r22 = r9
            r25 = r10
            r5 = r14
        L_0x0165:
            r6 = r7
        L_0x0166:
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>(r12, r13, r5, r8)
            android.graphics.Rect r7 = new android.graphics.Rect
            r7.<init>()
            r9 = r6
            r10 = r20
            r6 = r23
        L_0x0175:
            if (r6 != 0) goto L_0x0182
            if (r17 == 0) goto L_0x017a
            goto L_0x0182
        L_0x017a:
            if (r10 == r0) goto L_0x0181
            if (r10 == 0) goto L_0x0181
            r10.recycle()
        L_0x0181:
            return r9
        L_0x0182:
            if (r6 >= 0) goto L_0x0187
            int r6 = r6 + 1
            goto L_0x018b
        L_0x0187:
            if (r6 <= 0) goto L_0x018b
            int r6 = r6 + -1
        L_0x018b:
            if (r17 >= 0) goto L_0x0192
            int r17 = r17 + 1
            r14 = r17
            goto L_0x019b
        L_0x0192:
            if (r17 <= 0) goto L_0x0199
            int r17 = r17 + -1
            r14 = r17
            goto L_0x019b
        L_0x0199:
            r14 = r17
        L_0x019b:
            r17 = r12
            int r12 = sizeAtStep(r5, r1, r6, r4)
            r20 = r13
            int r13 = sizeAtStep(r8, r2, r14, r11)
            r23 = r3
            r3 = 0
            r7.set(r3, r3, r12, r13)
            if (r6 != 0) goto L_0x01b4
            if (r14 != 0) goto L_0x01b4
            r16 = 1
            goto L_0x01b6
        L_0x01b4:
            r16 = 0
        L_0x01b6:
            if (r10 == 0) goto L_0x01c6
            int r3 = r10.getWidth()
            if (r3 != r1) goto L_0x01c6
            int r3 = r10.getHeight()
            if (r3 != r2) goto L_0x01c6
            r3 = 1
            goto L_0x01c7
        L_0x01c6:
            r3 = 0
        L_0x01c7:
            if (r10 == 0) goto L_0x01ee
            if (r10 == r0) goto L_0x01ee
            if (r33 == 0) goto L_0x01de
            r26 = r12
            int r12 = android.os.Build.VERSION.SDK_INT
            r27 = r13
            r13 = 27
            if (r12 < r13) goto L_0x01e2
            boolean r12 = androidx.core.graphics.BitmapCompat.Api27Impl.isAlreadyF16AndLinear(r10)
            if (r12 == 0) goto L_0x01e8
            goto L_0x01e2
        L_0x01de:
            r26 = r12
            r27 = r13
        L_0x01e2:
            if (r16 == 0) goto L_0x01e9
            if (r3 == 0) goto L_0x01e8
            if (r21 == 0) goto L_0x01e9
        L_0x01e8:
            goto L_0x01f2
        L_0x01e9:
            r28 = r3
            r3 = 27
            goto L_0x0229
        L_0x01ee:
            r26 = r12
            r27 = r13
        L_0x01f2:
            if (r10 == r0) goto L_0x01f9
            if (r10 == 0) goto L_0x01f9
            r10.recycle()
        L_0x01f9:
            r12 = r21
            if (r6 <= 0) goto L_0x01ff
            r13 = r12
            goto L_0x0200
        L_0x01ff:
            r13 = r6
        L_0x0200:
            int r13 = sizeAtStep(r5, r1, r13, r4)
            if (r14 <= 0) goto L_0x0208
            r1 = r12
            goto L_0x0209
        L_0x0208:
            r1 = r14
        L_0x0209:
            int r1 = sizeAtStep(r8, r2, r1, r11)
            int r2 = android.os.Build.VERSION.SDK_INT
            r28 = r3
            r3 = 27
            if (r2 < r3) goto L_0x0221
            if (r33 == 0) goto L_0x021b
            if (r16 != 0) goto L_0x021b
            r2 = 1
            goto L_0x021c
        L_0x021b:
            r2 = 0
        L_0x021c:
            android.graphics.Bitmap r10 = androidx.core.graphics.BitmapCompat.Api27Impl.createBitmapWithSourceColorspace(r13, r1, r0, r2)
            goto L_0x0229
        L_0x0221:
            android.graphics.Bitmap$Config r2 = r9.getConfig()
            android.graphics.Bitmap r10 = android.graphics.Bitmap.createBitmap(r13, r1, r2)
        L_0x0229:
            android.graphics.Canvas r1 = new android.graphics.Canvas
            r1.<init>(r10)
            r2 = r23
            r1.drawBitmap(r9, r2, r7, r15)
            r12 = r9
            r9 = r10
            r10 = r12
            r2.set(r7)
            r1 = r30
            r3 = r2
            r12 = r17
            r13 = r20
            r2 = r31
            r17 = r14
            goto L_0x0175
        L_0x0246:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "dstW and dstH must be > 0!"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.BitmapCompat.createScaledBitmap(android.graphics.Bitmap, int, int, android.graphics.Rect, boolean):android.graphics.Bitmap");
    }

    @VisibleForTesting
    public static int sizeAtStep(int srcSize, int dstSize, int step, int totalSteps) {
        if (step == 0) {
            return dstSize;
        }
        if (step > 0) {
            return (1 << (totalSteps - step)) * srcSize;
        }
        return dstSize << ((-step) - 1);
    }

    private BitmapCompat() {
    }

    @RequiresApi(17)
    static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        static boolean hasMipMap(Bitmap bitmap) {
            return bitmap.hasMipMap();
        }

        @DoNotInline
        static void setHasMipMap(Bitmap bitmap, boolean hasMipMap) {
            bitmap.setHasMipMap(hasMipMap);
        }
    }

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static int getAllocationByteCount(Bitmap bitmap) {
            return bitmap.getAllocationByteCount();
        }
    }

    @RequiresApi(27)
    static class Api27Impl {
        private Api27Impl() {
        }

        @DoNotInline
        static Bitmap createBitmapWithSourceColorspace(int w, int h, Bitmap src, boolean linear) {
            Bitmap.Config config = src.getConfig();
            ColorSpace colorSpace = src.getColorSpace();
            ColorSpace linearCs = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (linear && !src.getColorSpace().equals(linearCs)) {
                config = Bitmap.Config.RGBA_F16;
                colorSpace = linearCs;
            } else if (src.getConfig() == Bitmap.Config.HARDWARE) {
                config = Bitmap.Config.ARGB_8888;
                if (Build.VERSION.SDK_INT >= 31) {
                    config = Api31Impl.getHardwareBitmapConfig(src);
                }
            }
            return Bitmap.createBitmap(w, h, config, src.hasAlpha(), colorSpace);
        }

        @DoNotInline
        static boolean isAlreadyF16AndLinear(Bitmap b) {
            return b.getConfig() == Bitmap.Config.RGBA_F16 && b.getColorSpace().equals(ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB));
        }

        @DoNotInline
        static Bitmap copyBitmapIfHardware(Bitmap bm) {
            if (bm.getConfig() != Bitmap.Config.HARDWARE) {
                return bm;
            }
            Bitmap.Config newConfig = Bitmap.Config.ARGB_8888;
            if (Build.VERSION.SDK_INT >= 31) {
                newConfig = Api31Impl.getHardwareBitmapConfig(bm);
            }
            return bm.copy(newConfig, true);
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void setPaintBlendMode(Paint paint) {
            paint.setBlendMode(BlendMode.SRC);
        }
    }

    @RequiresApi(31)
    static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        static Bitmap.Config getHardwareBitmapConfig(Bitmap bm) {
            if (bm.getHardwareBuffer().getFormat() == 22) {
                return Bitmap.Config.RGBA_F16;
            }
            return Bitmap.Config.ARGB_8888;
        }
    }
}
