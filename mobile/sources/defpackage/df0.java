package defpackage;

import com.evrencoskun.tableview.sort.a;
import java.util.Comparator;
import java.util.List;

/* renamed from: df0  reason: default package */
public class df0 implements Comparator {
    private a a;

    /* renamed from: a  reason: collision with other field name */
    private if0 f2755a;

    /* renamed from: a  reason: collision with other field name */
    private List<mr> f2756a;
    private List<List<mr>> b;

    public df0(List<mr> referenceList, List<List<mr>> columnList, a sortState) {
        this.f2756a = referenceList;
        this.b = columnList;
        this.a = sortState;
        this.f2755a = new if0(sortState);
    }

    public int compare(Object o, Object t1) {
        Object o1 = this.f2756a.get(this.b.indexOf(o)).a();
        Object o2 = this.f2756a.get(this.b.indexOf(t1)).a();
        if (this.a == a.DESCENDING) {
            return this.f2755a.d(o2, o1);
        }
        return this.f2755a.d(o1, o2);
    }
}
