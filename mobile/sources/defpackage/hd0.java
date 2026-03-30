package defpackage;

/* renamed from: hd0  reason: default package */
abstract class hd0 extends gd0 {
    public static bt d(int $this$downTo, int to) {
        return bt.a.a($this$downTo, to, -1);
    }

    public static dt e(int $this$until, int to) {
        if (to <= Integer.MIN_VALUE) {
            return dt.a.a();
        }
        return new dt($this$until, to - 1);
    }

    public static int a(int $this$coerceAtLeast, int minimumValue) {
        return $this$coerceAtLeast < minimumValue ? minimumValue : $this$coerceAtLeast;
    }

    public static int b(int $this$coerceAtMost, int maximumValue) {
        return $this$coerceAtMost > maximumValue ? maximumValue : $this$coerceAtMost;
    }

    public static long c(long $this$coerceAtMost, long maximumValue) {
        return $this$coerceAtMost > maximumValue ? maximumValue : $this$coerceAtMost;
    }
}
