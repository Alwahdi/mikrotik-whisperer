package defpackage;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.evrencoskun.tableview.TableView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: d0  reason: default package */
public abstract class d0<CH, RH, C> implements nr {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private aa f2683a;

    /* renamed from: a  reason: collision with other field name */
    protected Context f2684a;

    /* renamed from: a  reason: collision with other field name */
    private View f2685a;

    /* renamed from: a  reason: collision with other field name */
    private b8 f2686a;

    /* renamed from: a  reason: collision with other field name */
    private ff0 f2687a;

    /* renamed from: a  reason: collision with other field name */
    protected List<CH> f2688a;

    /* renamed from: a  reason: collision with other field name */
    private or f2689a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    protected List<RH> f2690b;
    protected List<List<C>> c;
    private List<s0> d;

    public d0(Context context) {
        this.f2684a = context;
    }

    public void D(TableView tableView) {
        this.f2689a = tableView;
        v();
    }

    private void v() {
        this.f2683a = new aa(this.f2684a, this.f2688a, this);
        this.f2687a = new ff0(this.f2684a, this.f2690b, this);
        this.f2686a = new b8(this.f2684a, this.c, this.f2689a);
    }

    public void A(List<CH> columnHeaderItems) {
        if (columnHeaderItems != null) {
            this.f2688a = columnHeaderItems;
            this.f2683a.d(columnHeaderItems);
            o(columnHeaderItems);
        }
    }

    public void B(List<RH> rowHeaderItems) {
        if (rowHeaderItems != null) {
            this.f2690b = rowHeaderItems;
            this.f2687a.d(rowHeaderItems);
            p(this.f2690b);
        }
    }

    public void y(List<List<C>> cellItems) {
        if (cellItems != null) {
            this.c = cellItems;
            this.f2686a.d(cellItems);
            n(this.c);
        }
    }

    public void x(List<CH> columnHeaderItems, List<RH> rowHeaderItems, List<List<C>> cellItems) {
        A(columnHeaderItems);
        B(rowHeaderItems);
        y(cellItems);
        if (columnHeaderItems != null && !columnHeaderItems.isEmpty() && rowHeaderItems != null && !rowHeaderItems.isEmpty() && cellItems != null && !cellItems.isEmpty() && this.f2689a != null && this.f2685a == null) {
            View c2 = c();
            this.f2685a = c2;
            this.f2689a.addView(c2, new FrameLayout.LayoutParams(this.a, this.b));
        } else if (this.f2685a == null) {
        } else {
            if (rowHeaderItems == null || rowHeaderItems.isEmpty()) {
                this.f2685a.setVisibility(8);
            } else {
                this.f2685a.setVisibility(0);
            }
        }
    }

    public aa s() {
        return this.f2683a;
    }

    public ff0 u() {
        return this.f2687a;
    }

    public b8 q() {
        return this.f2686a;
    }

    public void C(int rowHeaderWidth) {
        this.a = rowHeaderWidth;
        View view = this.f2685a;
        if (view != null) {
            view.getLayoutParams().width = rowHeaderWidth;
        }
    }

    public void z(int columnHeaderHeight) {
        this.b = columnHeaderHeight;
    }

    public RH t(int position) {
        List<RH> list = this.f2690b;
        if (list == null || list.isEmpty() || position < 0 || position >= this.f2690b.size()) {
            return null;
        }
        return this.f2690b.get(position);
    }

    public List<C> r(int rowPosition) {
        return (List) this.f2686a.getItem(rowPosition);
    }

    public void w(int rowPosition) {
        this.f2686a.b(rowPosition);
        this.f2687a.b(rowPosition);
    }

    public void m(int rowPosition, RH rowHeaderItem, List<C> cellItems) {
        this.f2686a.a(rowPosition, cellItems);
        this.f2687a.a(rowPosition, rowHeaderItem);
    }

    public or b() {
        return this.f2689a;
    }

    private void o(List<CH> newColumnHeaderItems) {
        List<s0> list = this.d;
        if (list != null) {
            for (s0 listener : list) {
                listener.b(newColumnHeaderItems);
            }
        }
    }

    private void p(List<RH> newRowHeaderItems) {
        List<s0> list = this.d;
        if (list != null) {
            for (s0 listener : list) {
                listener.c(newRowHeaderItems);
            }
        }
    }

    private void n(List<List<C>> newCellItems) {
        List<s0> list = this.d;
        if (list != null) {
            for (s0 listener : list) {
                listener.a(newCellItems);
            }
        }
    }

    public void l(s0 listener) {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        this.d.add(listener);
    }
}
