package defpackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.evrencoskun.tableview.layoutmanager.CellLayoutManager;
import com.evrencoskun.tableview.layoutmanager.ColumnHeaderLayoutManager;
import com.evrencoskun.tableview.sort.a;

/* renamed from: or  reason: default package */
public interface or {
    void a(tk tkVar);

    void addView(View view, ViewGroup.LayoutParams layoutParams);

    void b(int i);

    boolean c();

    void d(int i);

    boolean e();

    void f(a aVar);

    void g(int i);

    d0 getAdapter();

    CellLayoutManager getCellLayoutManager();

    a8 getCellRecyclerView();

    ColumnHeaderLayoutManager getColumnHeaderLayoutManager();

    a8 getColumnHeaderRecyclerView();

    fa getColumnSortHandler();

    vk getFilterHandler();

    DividerItemDecoration getHorizontalItemDecoration();

    rq getHorizontalRecyclerViewListener();

    LinearLayoutManager getRowHeaderLayoutManager();

    a8 getRowHeaderRecyclerView();

    a getRowHeaderSortingStatus();

    rj0 getScrollHandler();

    int getSelectedColor();

    yj0 getSelectionHandler();

    int getShadowColor();

    pr getTableViewListener();

    int getUnSelectedColor();

    bv0 getVerticalRecyclerViewListener();

    boolean h();

    void i(int i);

    boolean j();

    a k(int i);

    void l(int i, a aVar);
}
