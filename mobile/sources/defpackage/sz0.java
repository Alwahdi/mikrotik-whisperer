package defpackage;

/* renamed from: sz0  reason: default package */
final class sz0 extends uz0 {
    private final char a = '.';

    sz0(char c) {
    }

    public final boolean b(char c) {
        return c == this.a;
    }

    public final String toString() {
        String c = oz0.d(this.a);
        StringBuilder sb = new StringBuilder(String.valueOf(c).length() + 18);
        sb.append("CharMatcher.is('");
        sb.append(c);
        sb.append("')");
        return sb.toString();
    }
}
