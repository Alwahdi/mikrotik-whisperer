package defpackage;

/* renamed from: t90  reason: default package */
public abstract class t90 {
    public static int a(int value) {
        return 1 << (32 - Integer.numberOfLeadingZeros(value - 1));
    }
}
