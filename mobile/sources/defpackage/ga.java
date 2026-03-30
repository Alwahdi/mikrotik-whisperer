package defpackage;

import com.evrencoskun.tableview.layoutmanager.ColumnHeaderLayoutManager;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ga  reason: default package */
public class ga {
    private static a a = new a(-1, com.evrencoskun.tableview.sort.a.UNSORTED);

    /* renamed from: a  reason: collision with other field name */
    private ColumnHeaderLayoutManager f3063a;

    /* renamed from: a  reason: collision with other field name */
    private List<a> f3064a = new ArrayList();

    public ga(ColumnHeaderLayoutManager columnHeaderLayoutManager) {
        this.f3063a = columnHeaderLayoutManager;
    }

    private void d(int column, com.evrencoskun.tableview.sort.a sortState) {
        com.evrencoskun.tableview.adapter.recyclerview.holder.a holder = this.f3063a.h(column);
        if (holder == null) {
            return;
        }
        if (holder instanceof b0) {
            ((b0) holder).f(sortState);
            return;
        }
        throw new IllegalArgumentException("Column Header ViewHolder must extend AbstractSorterViewHolder");
    }

    public void c(int column, com.evrencoskun.tableview.sort.a status) {
        a directive = a(column);
        if (directive != a) {
            this.f3064a.remove(directive);
        }
        if (status != com.evrencoskun.tableview.sort.a.UNSORTED) {
            this.f3064a.add(new a(column, status));
        }
        d(column, status);
    }

    public com.evrencoskun.tableview.sort.a b(int column) {
        return a(column).f3065a;
    }

    private a a(int column) {
        for (int i = 0; i < this.f3064a.size(); i++) {
            a directive = this.f3064a.get(i);
            if (directive.a == column) {
                return directive;
            }
        }
        return a;
    }

    /* renamed from: ga$a */
    private static class a {
        /* access modifiers changed from: private */
        public int a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public com.evrencoskun.tableview.sort.a f3065a;

        public a(int column, com.evrencoskun.tableview.sort.a direction) {
            this.a = column;
            this.f3065a = direction;
        }
    }
}
