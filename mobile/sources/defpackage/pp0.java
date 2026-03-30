package defpackage;

import android.view.View;
import com.evrencoskun.tableview.layoutmanager.CellLayoutManager;

/* renamed from: pp0  reason: default package */
public class pp0 implements View.OnLayoutChangeListener {
    private a8 a;

    /* renamed from: a  reason: collision with other field name */
    private CellLayoutManager f4726a;
    private a8 b;

    public pp0(or tableView) {
        this.a = tableView.getCellRecyclerView();
        this.b = tableView.getColumnHeaderRecyclerView();
        this.f4726a = tableView.getCellLayoutManager();
    }

    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        if (v.isShown() && right - left != oldRight - oldLeft) {
            if (this.b.getWidth() > this.a.getWidth()) {
                this.f4726a.o();
            } else if (this.a.getWidth() > this.b.getWidth()) {
                this.b.getLayoutParams().width = -2;
                this.b.requestLayout();
            }
        }
    }
}
