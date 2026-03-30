package defpackage;

import java.util.Comparator;

/* renamed from: ls  reason: default package */
public class ls implements Comparator<String> {
    /* renamed from: a */
    public int compare(String o1, String o2) {
        if (o1.length() < o2.length()) {
            return 1;
        }
        if (o1.length() > o2.length()) {
            return -1;
        }
        return o1.compareTo(o2);
    }
}
