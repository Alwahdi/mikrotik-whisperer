package defpackage;

import com.evrencoskun.tableview.filter.IFilterableModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: vk  reason: default package */
public class vk<T> {
    private b8 a;

    /* renamed from: a  reason: collision with other field name */
    private ff0 f5392a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public List<List<fr>> f5393a;

    /* renamed from: a  reason: collision with other field name */
    private s0 f5394a = new a();
    private List<List<fr>> b;
    private List<List<fr>> c;
    /* access modifiers changed from: private */
    public List<T> d;
    private List<T> e;
    private List<T> f;
    private List<uk> g;

    public vk(or tableView) {
        tableView.getAdapter().l(this.f5394a);
        this.a = (b8) tableView.getCellRecyclerView().getAdapter();
        this.f5392a = (ff0) tableView.getRowHeaderRecyclerView().getAdapter();
    }

    public void f(tk filter) {
        if (this.f5393a != null && this.d != null) {
            this.b = new ArrayList(this.f5393a);
            this.e = new ArrayList(this.d);
            this.c = new ArrayList();
            this.f = new ArrayList();
            if (filter.b().isEmpty()) {
                this.c = new ArrayList(this.f5393a);
                this.f = new ArrayList(this.d);
                e(this.f5393a, this.d);
            } else {
                int x = 0;
                while (x < filter.b().size()) {
                    wk filterItem = filter.b().get(x);
                    if (filterItem.c().equals(com.evrencoskun.tableview.filter.a.ALL)) {
                        for (List<IFilterableModel> itemsList : this.b) {
                            Iterator<IFilterableModel> it = itemsList.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (((fr) it.next()).c().toLowerCase().contains(filterItem.b().toLowerCase())) {
                                        this.c.add(itemsList);
                                        this.f.add(this.e.get(this.c.indexOf(itemsList)));
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                    } else {
                        for (List<IFilterableModel> itemsList2 : this.b) {
                            if (((fr) itemsList2.get(filterItem.a())).c().toLowerCase().contains(filterItem.b().toLowerCase())) {
                                this.c.add(itemsList2);
                                this.f.add(this.e.get(this.c.indexOf(itemsList2)));
                            }
                        }
                    }
                    x++;
                    if (x < filter.b().size()) {
                        this.b = new ArrayList(this.c);
                        this.e = new ArrayList(this.f);
                        this.c.clear();
                        this.f.clear();
                    }
                }
            }
            this.f5392a.e(this.f, true);
            this.a.e(this.c, true);
            d(this.c, this.f);
        }
    }

    /* renamed from: vk$a */
    class a extends s0 {
        a() {
        }

        public void c(List rowHeaderItems) {
            if (rowHeaderItems != null) {
                List unused = vk.this.d = new ArrayList(rowHeaderItems);
            }
        }

        public void a(List cellItems) {
            if (cellItems != null) {
                List unused = vk.this.f5393a = new ArrayList(cellItems);
            }
        }
    }

    private void d(List<List<fr>> filteredCellItems, List<T> filteredRowHeaderItems) {
        List<uk> list = this.g;
        if (list != null) {
            for (uk listener : list) {
                listener.a(filteredCellItems, filteredRowHeaderItems);
            }
        }
    }

    private void e(List<List<fr>> originalCellItems, List<T> originalRowHeaderItems) {
        List<uk> list = this.g;
        if (list != null) {
            for (uk listener : list) {
                listener.b(originalCellItems, originalRowHeaderItems);
            }
        }
    }

    public void c(uk listener) {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        this.g.add(listener);
    }
}
