package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.evrencoskun.tableview.adapter.recyclerview.holder.a;
import com.evrencoskun.tableview.layoutmanager.ColumnLayoutManager;
import java.util.List;

/* renamed from: b8  reason: default package */
public class b8<C> extends v<C> {
    private static final String a = b8.class.getSimpleName();

    /* renamed from: a  reason: collision with other field name */
    private int f210a = 0;

    /* renamed from: a  reason: collision with other field name */
    private final RecyclerView.RecycledViewPool f211a;

    /* renamed from: a  reason: collision with other field name */
    private or f212a;

    public b8(Context context, List<C> itemList, or tableView) {
        super(context, itemList);
        this.f212a = tableView;
        this.f211a = new RecyclerView.RecycledViewPool();
    }

    /* renamed from: g */
    public com.evrencoskun.tableview.adapter.recyclerview.holder.a onCreateViewHolder(ViewGroup parent, int viewType) {
        a8 recyclerView = new a8(this.a);
        recyclerView.setRecycledViewPool(this.f211a);
        if (this.f212a.j()) {
            recyclerView.addItemDecoration(this.f212a.getHorizontalItemDecoration());
        }
        recyclerView.setHasFixedSize(this.f212a.h());
        recyclerView.addOnItemTouchListener(this.f212a.getHorizontalRecyclerViewListener());
        recyclerView.addOnItemTouchListener(new c8(recyclerView, this.f212a));
        recyclerView.setLayoutManager(new ColumnLayoutManager(this.a, this.f212a));
        recyclerView.setAdapter(new d8(this.a, this.f212a));
        recyclerView.setId(this.f210a);
        this.f210a++;
        return new a(recyclerView);
    }

    /* renamed from: f */
    public void onBindViewHolder(com.evrencoskun.tableview.adapter.recyclerview.holder.a holder, int yPosition) {
        d8 viewAdapter = (d8) ((a) holder).a.getAdapter();
        viewAdapter.l(yPosition);
        viewAdapter.d(this.f5290a.get(yPosition));
    }

    /* renamed from: h */
    public void onViewAttachedToWindow(com.evrencoskun.tableview.adapter.recyclerview.holder.a holder) {
        super.onViewAttachedToWindow(holder);
        a viewHolder = (a) holder;
        rj0 scrollHandler = this.f212a.getScrollHandler();
        ((ColumnLayoutManager) viewHolder.a.getLayoutManager()).scrollToPositionWithOffset(scrollHandler.a(), scrollHandler.b());
        yj0 selectionHandler = this.f212a.getSelectionHandler();
        if (selectionHandler.k()) {
            com.evrencoskun.tableview.adapter.recyclerview.holder.a cellViewHolder = (com.evrencoskun.tableview.adapter.recyclerview.holder.a) viewHolder.a.findViewHolderForAdapterPosition(selectionHandler.i());
            if (cellViewHolder != null) {
                if (!this.f212a.e()) {
                    cellViewHolder.c(this.f212a.getSelectedColor());
                }
                cellViewHolder.d(a.C0008a.SELECTED);
            }
        } else if (selectionHandler.o(holder.getAdapterPosition())) {
            selectionHandler.c(viewHolder.a, a.C0008a.SELECTED, this.f212a.getSelectedColor());
        }
    }

    /* renamed from: i */
    public void onViewDetachedFromWindow(com.evrencoskun.tableview.adapter.recyclerview.holder.a holder) {
        super.onViewDetachedFromWindow(holder);
        this.f212a.getSelectionHandler().c(((a) holder).a, a.C0008a.UNSELECTED, this.f212a.getUnSelectedColor());
    }

    /* renamed from: j */
    public void onViewRecycled(com.evrencoskun.tableview.adapter.recyclerview.holder.a holder) {
        super.onViewRecycled(holder);
        ((a) holder).a.a();
    }

    /* renamed from: b8$a */
    static class a extends com.evrencoskun.tableview.adapter.recyclerview.holder.a {
        final a8 a;

        a(View itemView) {
            super(itemView);
            this.a = (a8) itemView;
        }
    }
}
