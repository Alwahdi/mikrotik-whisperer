package defpackage;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.evrencoskun.tableview.adapter.recyclerview.holder.a;

/* renamed from: c8  reason: default package */
public class c8 extends q {
    private static final String a = c8.class.getSimpleName();
    private a8 b;

    public c8(a8 recyclerView, or tableView) {
        super(recyclerView, tableView);
        this.b = tableView.getCellRecyclerView();
    }

    /* access modifiers changed from: protected */
    public boolean a(RecyclerView view, MotionEvent e) {
        View childView = view.findChildViewUnder(e.getX(), e.getY());
        if (childView == null || !this.f4738a.onTouchEvent(e)) {
            return false;
        }
        a holder = (a) this.a.getChildViewHolder(childView);
        int column = holder.getAdapterPosition();
        int row = ((d8) this.a.getAdapter()).f();
        if (!this.f4739a.e()) {
            this.f4741a.v(holder, column, row);
        }
        if (b() == null) {
            return true;
        }
        b().g(holder, column, row);
        return true;
    }

    /* access modifiers changed from: protected */
    public void c(MotionEvent e) {
        View child;
        if (this.a.getScrollState() == 0 && this.b.getScrollState() == 0 && (child = this.a.findChildViewUnder(e.getX(), e.getY())) != null && b() != null) {
            RecyclerView.ViewHolder holder = this.a.getChildViewHolder(child);
            b().c(holder, holder.getAdapterPosition(), ((d8) this.a.getAdapter()).f());
        }
    }
}
