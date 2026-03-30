package defpackage;

import com.evrencoskun.tableview.sort.ISortableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: h50  reason: default package */
public class h50<T> {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private b8 f3139a;

    /* renamed from: a  reason: collision with other field name */
    private ff0 f3140a;

    /* renamed from: a  reason: collision with other field name */
    private d f3141a;

    /* renamed from: a  reason: collision with other field name */
    private ha f3142a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public List<List<mr>> f3143a;

    /* renamed from: a  reason: collision with other field name */
    private or f3144a;

    /* renamed from: a  reason: collision with other field name */
    private s0 f3145a;

    /* renamed from: a  reason: collision with other field name */
    private uk f3146a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private List<List<mr>> f3147b;
    private int c;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with other field name */
    public List<mr> f3148c;
    private List<mr> d;

    /* renamed from: h50$d */
    public interface d {
        void a(int i, int i2, int i3);
    }

    public h50(or tableView) {
        this(tableView, 10, (d) null);
    }

    public h50(or tableView, int itemsPerPage, d listener) {
        this.f3145a = new a();
        this.f3146a = new b();
        this.f3142a = new c();
        h(tableView, itemsPerPage, listener);
    }

    private void h(or tableView, int itemsPerPage, d listener) {
        this.f3141a = listener;
        this.a = itemsPerPage;
        this.f3144a = tableView;
        this.f3140a = (ff0) tableView.getRowHeaderRecyclerView().getAdapter();
        this.f3139a = (b8) tableView.getCellRecyclerView().getAdapter();
        this.f3144a.getColumnSortHandler().a(this.f3142a);
        this.f3144a.getAdapter().l(this.f3145a);
        this.f3144a.getFilterHandler().c(this.f3146a);
        this.b = 1;
        m();
    }

    /* access modifiers changed from: private */
    public void m() {
        if (this.f3143a != null && this.f3148c != null) {
            j();
            g(this.b);
        }
    }

    private void j() {
        int end;
        int start;
        this.f3147b = new ArrayList();
        this.d = new ArrayList();
        int i = this.a;
        if (i == 0) {
            this.f3147b.addAll(this.f3143a);
            this.d.addAll(this.f3148c);
            this.c = 1;
            start = 0;
            end = this.f3147b.size();
        } else {
            int end2 = this.b;
            int start2 = (end2 * i) - i;
            end = end2 * i > this.f3143a.size() ? this.f3143a.size() : this.b * this.a;
            for (int x = start2; x < end; x++) {
                this.f3147b.add(this.f3143a.get(x));
                this.d.add(this.f3148c.get(x));
            }
            this.c = (int) Math.ceil(((double) this.f3143a.size()) / ((double) this.a));
            start = start2;
        }
        this.f3140a.e(this.d, true);
        this.f3139a.e(this.f3147b, true);
        d dVar = this.f3141a;
        if (dVar != null) {
            dVar.a(this.f3147b.size(), start, end - 1);
        }
    }

    public void i() {
        int i = this.b;
        if (i + 1 <= this.c) {
            i++;
            this.b = i;
        }
        this.b = i;
        j();
    }

    public void l() {
        int i = this.b;
        if (i - 1 != 0) {
            i--;
            this.b = i;
        }
        this.b = i;
        j();
    }

    public void g(int page) {
        int i = this.c;
        if (page <= i && page >= 1) {
            i = page;
        } else if (page <= i || i <= 0) {
            i = this.b;
        }
        this.b = i;
        j();
    }

    public void n(int numItems) {
        this.a = numItems;
        this.b = 1;
        j();
    }

    public void o(d onTableViewPageTurnedListener) {
        this.f3141a = onTableViewPageTurnedListener;
    }

    public int e() {
        return this.b;
    }

    public int f() {
        return this.c;
    }

    /* renamed from: h50$a */
    class a extends s0 {
        a() {
        }

        public void c(List rowHeaderItems) {
            if (rowHeaderItems != null) {
                List unused = h50.this.f3148c = new ArrayList(rowHeaderItems);
                h50.this.m();
            }
        }

        public void a(List cellItems) {
            if (cellItems != null) {
                List unused = h50.this.f3143a = new ArrayList(cellItems);
                h50.this.m();
            }
        }
    }

    /* renamed from: h50$b */
    class b extends uk {
        b() {
        }

        public void a(List filteredCellItems, List filteredRowHeaderItems) {
            List unused = h50.this.f3143a = new ArrayList(filteredCellItems);
            List unused2 = h50.this.f3148c = new ArrayList(filteredRowHeaderItems);
            h50.this.m();
        }

        public void b(List originalCellItems, List originalRowHeaderItems) {
            List unused = h50.this.f3143a = new ArrayList(originalCellItems);
            List unused2 = h50.this.f3148c = new ArrayList(originalRowHeaderItems);
            h50.this.m();
        }
    }

    /* renamed from: h50$c */
    class c extends ha {
        c() {
        }

        public void a(int column, com.evrencoskun.tableview.sort.a sortState) {
            h50.this.k(column, sortState);
        }

        public void b(com.evrencoskun.tableview.sort.a sortState) {
            h50.this.k(-1, sortState);
        }
    }

    /* access modifiers changed from: private */
    public void k(int column, com.evrencoskun.tableview.sort.a sortState) {
        List<ISortableModel> sortedRowHeaderList = new ArrayList<>(this.f3148c);
        List<List<ISortableModel>> sortedList = new ArrayList<>(this.f3143a);
        if (sortState != com.evrencoskun.tableview.sort.a.UNSORTED) {
            if (column == -1) {
                Collections.sort(sortedRowHeaderList, new if0(sortState));
                Collections.sort(sortedList, new df0(this.f3148c, this.f3143a, sortState));
            } else {
                Collections.sort(sortedList, new ea(column, sortState));
                Collections.sort(sortedRowHeaderList, new x9(this.f3148c, this.f3143a, column, sortState));
            }
        }
        this.f3148c = new ArrayList(sortedRowHeaderList);
        this.f3143a = new ArrayList(sortedList);
        m();
    }
}
