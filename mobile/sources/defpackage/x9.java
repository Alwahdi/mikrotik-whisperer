package defpackage;

import com.evrencoskun.tableview.sort.a;
import java.util.Comparator;
import java.util.List;

/* renamed from: x9  reason: default package */
public class x9 implements Comparator {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private a f5577a;

    /* renamed from: a  reason: collision with other field name */
    private ea f5578a;

    /* renamed from: a  reason: collision with other field name */
    private List<mr> f5579a;
    private List<List<mr>> b;

    public x9(List<mr> rowHeader, List<List<mr>> referenceList, int column, a sortState) {
        this.f5579a = rowHeader;
        this.b = referenceList;
        this.a = column;
        this.f5577a = sortState;
        this.f5578a = new ea(column, sortState);
    }

    public int compare(Object o, Object t1) {
        Object o1 = ((mr) this.b.get(this.f5579a.indexOf(o)).get(this.a)).a();
        Object o2 = ((mr) this.b.get(this.f5579a.indexOf(t1)).get(this.a)).a();
        if (this.f5577a == a.DESCENDING) {
            return this.f5578a.d(o2, o1);
        }
        return this.f5578a.d(o1, o2);
    }
}
