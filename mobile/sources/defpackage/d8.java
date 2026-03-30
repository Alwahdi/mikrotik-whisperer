package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import com.evrencoskun.tableview.adapter.recyclerview.holder.a;
import java.util.List;

/* renamed from: d8  reason: default package */
public class d8<C> extends v<C> {
    private static final String a = d8.class.getSimpleName();

    /* renamed from: a  reason: collision with other field name */
    private int f2746a;

    /* renamed from: a  reason: collision with other field name */
    private nr f2747a;

    /* renamed from: a  reason: collision with other field name */
    private or f2748a;

    public d8(Context context, or tableView) {
        super(context, (List) null);
        this.f2747a = tableView.getAdapter();
        this.f2748a = tableView;
    }

    /* renamed from: h */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        return this.f2747a.d(parent, viewType);
    }

    /* renamed from: g */
    public void onBindViewHolder(a holder, int xPosition) {
        this.f2747a.j(holder, getItem(xPosition), xPosition, this.f2746a);
    }

    public int f() {
        return this.f2746a;
    }

    public void l(int rowPosition) {
        this.f2746a = rowPosition;
    }

    public int getItemViewType(int position) {
        return this.f2747a.h(position);
    }

    /* renamed from: j */
    public void onViewAttachedToWindow(a viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        a.C0008a selectionState = this.f2748a.getSelectionHandler().f(viewHolder.getAdapterPosition(), this.f2746a);
        if (!this.f2748a.e()) {
            if (selectionState == a.C0008a.SELECTED) {
                viewHolder.c(this.f2748a.getSelectedColor());
            } else {
                viewHolder.c(this.f2748a.getUnSelectedColor());
            }
        }
        viewHolder.d(selectionState);
    }

    /* renamed from: i */
    public boolean onFailedToRecycleView(a holder) {
        return holder.a();
    }

    /* renamed from: k */
    public void onViewRecycled(a holder) {
        super.onViewRecycled(holder);
        holder.b();
    }
}
