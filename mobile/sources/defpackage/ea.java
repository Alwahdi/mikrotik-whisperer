package defpackage;

import com.evrencoskun.tableview.sort.a;
import java.util.Comparator;
import java.util.List;

/* renamed from: ea  reason: default package */
public class ea extends a0 implements Comparator<List<mr>> {
    private int a;

    public ea(int xPosition, a sortState) {
        this.a = xPosition;
        this.a = sortState;
    }

    /* renamed from: e */
    public int compare(List<mr> t1, List<mr> t2) {
        Object o1 = t1.get(this.a).a();
        Object o2 = t2.get(this.a).a();
        if (this.a == a.DESCENDING) {
            return d(o2, o1);
        }
        return d(o1, o2);
    }
}
