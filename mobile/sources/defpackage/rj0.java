package defpackage;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.evrencoskun.tableview.layoutmanager.CellLayoutManager;
import com.evrencoskun.tableview.layoutmanager.ColumnHeaderLayoutManager;
import com.evrencoskun.tableview.layoutmanager.ColumnLayoutManager;

/* renamed from: rj0  reason: default package */
public class rj0 {
    private LinearLayoutManager a;

    /* renamed from: a  reason: collision with other field name */
    private CellLayoutManager f4899a;

    /* renamed from: a  reason: collision with other field name */
    private ColumnHeaderLayoutManager f4900a;

    /* renamed from: a  reason: collision with other field name */
    private or f4901a;

    public rj0(or tableView) {
        this.f4901a = tableView;
        this.f4899a = tableView.getCellLayoutManager();
        this.a = tableView.getRowHeaderLayoutManager();
        this.f4900a = tableView.getColumnHeaderLayoutManager();
    }

    public void g(int columnPosition) {
        if (!((View) this.f4901a).isShown()) {
            this.f4901a.getHorizontalRecyclerViewListener().e(columnPosition);
        }
        f(columnPosition, 0);
        e(columnPosition, 0);
    }

    public void h(int columnPosition, int offset) {
        if (!((View) this.f4901a).isShown()) {
            this.f4901a.getHorizontalRecyclerViewListener().e(columnPosition);
            this.f4901a.getHorizontalRecyclerViewListener().f(offset);
        }
        f(columnPosition, offset);
        e(columnPosition, offset);
    }

    public void i(int rowPosition) {
        this.a.scrollToPosition(rowPosition);
        this.f4899a.scrollToPosition(rowPosition);
    }

    public void j(int rowPosition, int offset) {
        this.a.scrollToPositionWithOffset(rowPosition, offset);
        this.f4899a.scrollToPositionWithOffset(rowPosition, offset);
    }

    private void e(int columnPosition, int offset) {
        CellLayoutManager cellLayoutManager = this.f4901a.getCellLayoutManager();
        for (int i = cellLayoutManager.findFirstVisibleItemPosition(); i < cellLayoutManager.findLastVisibleItemPosition() + 1; i++) {
            RecyclerView cellRowRecyclerView = (RecyclerView) cellLayoutManager.findViewByPosition(i);
            if (cellRowRecyclerView != null) {
                ((ColumnLayoutManager) cellRowRecyclerView.getLayoutManager()).scrollToPositionWithOffset(columnPosition, offset);
            }
        }
    }

    private void f(int columnPosition, int offset) {
        this.f4901a.getColumnHeaderLayoutManager().scrollToPositionWithOffset(columnPosition, offset);
    }

    public int a() {
        return this.f4900a.findFirstVisibleItemPosition();
    }

    public int b() {
        ColumnHeaderLayoutManager columnHeaderLayoutManager = this.f4900a;
        View child = columnHeaderLayoutManager.findViewByPosition(columnHeaderLayoutManager.findFirstVisibleItemPosition());
        if (child != null) {
            return child.getLeft();
        }
        return 0;
    }

    public int c() {
        return this.a.findFirstVisibleItemPosition();
    }

    public int d() {
        LinearLayoutManager linearLayoutManager = this.a;
        View child = linearLayoutManager.findViewByPosition(linearLayoutManager.findFirstVisibleItemPosition());
        if (child != null) {
            return child.getLeft();
        }
        return 0;
    }
}
