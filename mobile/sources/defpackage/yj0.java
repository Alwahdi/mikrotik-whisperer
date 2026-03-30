package defpackage;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.evrencoskun.tableview.adapter.recyclerview.holder.a;
import com.evrencoskun.tableview.layoutmanager.CellLayoutManager;

/* renamed from: yj0  reason: default package */
public class yj0 {
    private int a = -1;

    /* renamed from: a  reason: collision with other field name */
    private a8 f5887a;

    /* renamed from: a  reason: collision with other field name */
    private a f5888a;

    /* renamed from: a  reason: collision with other field name */
    private CellLayoutManager f5889a;

    /* renamed from: a  reason: collision with other field name */
    private or f5890a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f5891a = true;
    private int b = -1;

    /* renamed from: b  reason: collision with other field name */
    private a8 f5892b;

    public yj0(or tableView) {
        this.f5890a = tableView;
        this.f5887a = tableView.getColumnHeaderRecyclerView();
        this.f5892b = this.f5890a.getRowHeaderRecyclerView();
        this.f5889a = this.f5890a.getCellLayoutManager();
    }

    public void v(a selectedViewHolder, int column, int row) {
        u(selectedViewHolder);
        this.b = column;
        this.a = row;
        if (this.f5891a) {
            r();
        }
    }

    public void x(a selectedViewHolder, int column) {
        u(selectedViewHolder);
        this.b = column;
        s();
        this.a = -1;
    }

    public int i() {
        return this.b;
    }

    public void z(a selectedViewHolder, int row) {
        u(selectedViewHolder);
        this.a = row;
        t();
        this.b = -1;
    }

    public int j() {
        return this.a;
    }

    public void u(a viewHolder) {
        q();
        a aVar = this.f5888a;
        if (aVar != null) {
            aVar.c(this.f5890a.getUnSelectedColor());
            this.f5888a.d(a.C0008a.UNSELECTED);
        }
        a oldViewHolder = this.f5889a.m(i(), j());
        if (oldViewHolder != null) {
            oldViewHolder.c(this.f5890a.getUnSelectedColor());
            oldViewHolder.d(a.C0008a.UNSELECTED);
        }
        this.f5888a = viewHolder;
        viewHolder.c(this.f5890a.getSelectedColor());
        this.f5888a.d(a.C0008a.SELECTED);
    }

    private void q() {
        int i = this.b;
        if (i != -1 && this.a != -1) {
            A();
        } else if (i != -1) {
            B();
        } else if (this.a != -1) {
            C();
        }
    }

    private void t() {
        e(this.a, true);
        if (this.f5891a) {
            c(this.f5887a, a.C0008a.SHADOWED, this.f5890a.getShadowColor());
        }
    }

    private void C() {
        e(this.a, false);
        c(this.f5887a, a.C0008a.UNSELECTED, this.f5890a.getUnSelectedColor());
    }

    private void r() {
        int shadowColor = this.f5890a.getShadowColor();
        a rowHeader = (a) this.f5892b.findViewHolderForAdapterPosition(this.a);
        if (rowHeader != null) {
            rowHeader.c(shadowColor);
            rowHeader.d(a.C0008a.SHADOWED);
        }
        a columnHeader = (a) this.f5887a.findViewHolderForAdapterPosition(this.b);
        if (columnHeader != null) {
            columnHeader.c(shadowColor);
            columnHeader.d(a.C0008a.SHADOWED);
        }
    }

    private void A() {
        int unSelectedColor = this.f5890a.getUnSelectedColor();
        a rowHeader = (a) this.f5892b.findViewHolderForAdapterPosition(this.a);
        if (rowHeader != null) {
            rowHeader.c(unSelectedColor);
            rowHeader.d(a.C0008a.UNSELECTED);
        }
        a columnHeader = (a) this.f5887a.findViewHolderForAdapterPosition(this.b);
        if (columnHeader != null) {
            columnHeader.c(unSelectedColor);
            columnHeader.d(a.C0008a.UNSELECTED);
        }
    }

    private void s() {
        d(this.b, true);
        c(this.f5892b, a.C0008a.SHADOWED, this.f5890a.getShadowColor());
    }

    private void B() {
        d(this.b, false);
        c(this.f5892b, a.C0008a.UNSELECTED, this.f5890a.getUnSelectedColor());
    }

    public boolean l(int column, int row) {
        return (i() == column && j() == row) || m(column) || o(row);
    }

    public a.C0008a f(int column, int row) {
        if (l(column, row)) {
            return a.C0008a.SELECTED;
        }
        return a.C0008a.UNSELECTED;
    }

    public boolean m(int column) {
        return i() == column && j() == -1;
    }

    public boolean n(int column) {
        return (i() == column && j() != -1) || (i() == -1 && j() != -1);
    }

    public boolean k() {
        return i() != -1 && j() == -1;
    }

    public a.C0008a g(int column) {
        if (n(column)) {
            return a.C0008a.SHADOWED;
        }
        if (m(column)) {
            return a.C0008a.SELECTED;
        }
        return a.C0008a.UNSELECTED;
    }

    public boolean o(int row) {
        return j() == row && i() == -1;
    }

    public boolean p(int row) {
        return (j() == row && i() != -1) || (j() == -1 && i() != -1);
    }

    public a.C0008a h(int row) {
        if (p(row)) {
            return a.C0008a.SHADOWED;
        }
        if (o(row)) {
            return a.C0008a.SELECTED;
        }
        return a.C0008a.UNSELECTED;
    }

    private void e(int row, boolean isSelected) {
        int backgroundColor = this.f5890a.getUnSelectedColor();
        a.C0008a selectionState = a.C0008a.UNSELECTED;
        if (isSelected) {
            backgroundColor = this.f5890a.getSelectedColor();
            selectionState = a.C0008a.SELECTED;
        }
        a8 recyclerView = (a8) this.f5889a.findViewByPosition(row);
        if (recyclerView != null) {
            c(recyclerView, selectionState, backgroundColor);
        }
    }

    private void d(int column, boolean isSelected) {
        int backgroundColor = this.f5890a.getUnSelectedColor();
        a.C0008a selectionState = a.C0008a.UNSELECTED;
        if (isSelected) {
            backgroundColor = this.f5890a.getSelectedColor();
            selectionState = a.C0008a.SELECTED;
        }
        for (int i = this.f5889a.findFirstVisibleItemPosition(); i < this.f5889a.findLastVisibleItemPosition() + 1; i++) {
            a holder = (a) ((a8) this.f5889a.findViewByPosition(i)).findViewHolderForAdapterPosition(column);
            if (holder != null) {
                holder.c(backgroundColor);
                holder.d(selectionState);
            }
        }
    }

    public void b(a viewHolder, a.C0008a selectionState) {
        if (this.f5891a && selectionState == a.C0008a.SHADOWED) {
            viewHolder.c(this.f5890a.getShadowColor());
        } else if (selectionState == a.C0008a.SELECTED) {
            viewHolder.c(this.f5890a.getSelectedColor());
        } else {
            viewHolder.c(this.f5890a.getUnSelectedColor());
        }
    }

    public void a(a viewHolder, a.C0008a selectionState) {
        if (this.f5891a && selectionState == a.C0008a.SHADOWED) {
            viewHolder.c(this.f5890a.getShadowColor());
        } else if (selectionState == a.C0008a.SELECTED) {
            viewHolder.c(this.f5890a.getSelectedColor());
        } else {
            viewHolder.c(this.f5890a.getUnSelectedColor());
        }
    }

    public void c(a8 recyclerView, a.C0008a selectionState, int backgroundColor) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        for (int i = linearLayoutManager.findFirstVisibleItemPosition(); i < linearLayoutManager.findLastVisibleItemPosition() + 1; i++) {
            a viewHolder = (a) recyclerView.findViewHolderForAdapterPosition(i);
            if (viewHolder != null) {
                if (!this.f5890a.e()) {
                    viewHolder.c(backgroundColor);
                }
                viewHolder.d(selectionState);
            }
        }
    }

    public void y(int row) {
        this.a = row;
    }

    public void w(int column) {
        this.b = column;
    }
}
