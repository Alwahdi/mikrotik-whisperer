package defpackage;

import com.evrencoskun.tableview.sort.a;
import java.util.Comparator;

/* renamed from: if0  reason: default package */
public class if0 extends a0 implements Comparator<mr> {
    private static final String a = if0.class.getSimpleName();

    public if0(a sortState) {
        this.a = sortState;
    }

    /* renamed from: e */
    public int compare(mr o1, mr o2) {
        if (this.a == a.DESCENDING) {
            return d(o2.a(), o1.a());
        }
        return d(o1.a(), o2.a());
    }
}
