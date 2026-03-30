package defpackage;

import java.util.Comparator;

/* renamed from: jz  reason: default package */
final /* synthetic */ class jz implements Comparator {
    private static final jz a = new jz();

    private jz() {
    }

    public static Comparator a() {
        return a;
    }

    public int compare(Object obj, Object obj2) {
        return ((Long) obj2).compareTo((Long) obj);
    }
}
