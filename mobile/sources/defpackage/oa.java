package defpackage;

/* renamed from: oa  reason: default package */
abstract class oa {
    public static <T extends Comparable<?>> int a(T a, T b) {
        if (a == b) {
            return 0;
        }
        if (a == null) {
            return -1;
        }
        if (b == null) {
            return 1;
        }
        return a.compareTo(b);
    }
}
