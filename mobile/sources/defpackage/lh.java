package defpackage;

import java.util.Comparator;

/* renamed from: lh  reason: default package */
final /* synthetic */ class lh implements Comparator {
    private static final lh a = new lh();

    private lh() {
    }

    public static Comparator a() {
        return a;
    }

    public int compare(Object obj, Object obj2) {
        return ((mh) obj).compareTo((mh) obj2);
    }
}
