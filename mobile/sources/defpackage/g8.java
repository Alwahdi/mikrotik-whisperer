package defpackage;

/* renamed from: g8  reason: default package */
abstract class g8 {
    public static final boolean c(char $this$isWhitespace) {
        return Character.isWhitespace($this$isWhitespace) || Character.isSpaceChar($this$isWhitespace);
    }

    public static final int b(char c, int radix) {
        return Character.digit(c, radix);
    }

    public static final int a(int radix) {
        if (new dt(2, 36).g(radix)) {
            return radix;
        }
        throw new IllegalArgumentException("radix " + radix + " was not in valid range " + new dt(2, 36));
    }
}
