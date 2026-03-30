package defpackage;

/* renamed from: h8  reason: default package */
abstract class h8 extends g8 {
    public static final boolean d(char $this$equals, char other, boolean ignoreCase) {
        if ($this$equals == other) {
            return true;
        }
        if (!ignoreCase) {
            return false;
        }
        char thisUpper = Character.toUpperCase($this$equals);
        char otherUpper = Character.toUpperCase(other);
        if (thisUpper == otherUpper || Character.toLowerCase(thisUpper) == Character.toLowerCase(otherUpper)) {
            return true;
        }
        return false;
    }
}
