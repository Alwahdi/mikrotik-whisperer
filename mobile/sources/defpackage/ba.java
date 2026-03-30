package defpackage;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.evrencoskun.tableview.adapter.recyclerview.holder.a;

/* renamed from: ba  reason: default package */
public class ba extends q {
    public ba(a8 recyclerView, or tableView) {
        super(recyclerView, tableView);
    }

    /* access modifiers changed from: protected */
    public boolean a(RecyclerView view, MotionEvent e) {
        View childView = view.findChildViewUnder(e.getX(), e.getY());
        if (childView == null || !this.f4738a.onTouchEvent(e)) {
            return false;
        }
        a holder = (a) this.a.getChildViewHolder(childView);
        int column = holder.getAdapterPosition();
        if (!this.f4739a.e()) {
            this.f4741a.x(holder, column);
        }
        if (b() == null) {
            return true;
        }
        b().d(holder, column);
        return true;
    }

    /* access modifiers changed from: protected */
    public void c(MotionEvent e) {
        View child;
        if (this.a.getScrollState() == 0 && (child = this.a.findChildViewUnder(e.getX(), e.getY())) != null && b() != null) {
            RecyclerView.ViewHolder holder = this.a.getChildViewHolder(child);
            b().b(holder, holder.getAdapterPosition());
        }
    }
}
