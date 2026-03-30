package defpackage;

/* renamed from: co0  reason: default package */
abstract class co0 extends bo0 {
    public static Long a(String $this$toLongOrNull) {
        lu.f($this$toLongOrNull, "<this>");
        return b($this$toLongOrNull, 10);
    }

    public static final Long b(String $this$toLongOrNull, int radix) {
        long limit;
        boolean isNegative;
        int start;
        long limitForMaxRadix;
        char firstChar;
        String str = $this$toLongOrNull;
        int i = radix;
        lu.f(str, "<this>");
        g8.a(radix);
        int length = $this$toLongOrNull.length();
        if (length == 0) {
            return null;
        }
        char firstChar2 = str.charAt(0);
        if (lu.h(firstChar2, 48) >= 0) {
            start = 0;
            isNegative = false;
            limit = -9223372036854775807L;
        } else if (length == 1) {
            return null;
        } else {
            start = 1;
            if (firstChar2 == '-') {
                isNegative = true;
                limit = Long.MIN_VALUE;
            } else if (firstChar2 != '+') {
                return null;
            } else {
                isNegative = false;
                limit = -9223372036854775807L;
            }
        }
        long limitForMaxRadix2 = -256204778801521550L;
        long limitBeforeMul = -256204778801521550L;
        long result = 0;
        int i2 = start;
        while (i2 < length) {
            int digit = g8.b(str.charAt(i2), i);
            if (digit < 0) {
                return null;
            }
            if (result >= limitBeforeMul) {
                firstChar = firstChar2;
                limitForMaxRadix = limitForMaxRadix2;
            } else if (limitBeforeMul != limitForMaxRadix2) {
                return null;
            } else {
                firstChar = firstChar2;
                limitForMaxRadix = limitForMaxRadix2;
                long limitBeforeMul2 = limit / ((long) i);
                if (result < limitBeforeMul2) {
                    return null;
                }
                limitBeforeMul = limitBeforeMul2;
            }
            long result2 = result * ((long) i);
            if (result2 < ((long) digit) + limit) {
                return null;
            }
            result = result2 - ((long) digit);
            i2++;
            firstChar2 = firstChar;
            limitForMaxRadix2 = limitForMaxRadix;
        }
        long j = limitForMaxRadix2;
        return isNegative ? Long.valueOf(result) : Long.valueOf(-result);
    }
}
