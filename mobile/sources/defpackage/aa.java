package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import com.evrencoskun.tableview.adapter.recyclerview.holder.a;
import java.util.List;

/* renamed from: aa  reason: default package */
public class aa<CH> extends v<CH> {
    private static final String a = aa.class.getSimpleName();

    /* renamed from: a  reason: collision with other field name */
    private ga f39a;

    /* renamed from: a  reason: collision with other field name */
    private nr f40a;

    /* renamed from: a  reason: collision with other field name */
    private or f41a;

    public aa(Context context, List<CH> itemList, nr tableAdapter) {
        super(context, itemList);
        this.f40a = tableAdapter;
        this.f41a = tableAdapter.b();
    }

    /* renamed from: h */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        return this.f40a.f(parent, viewType);
    }

    /* renamed from: g */
    public void onBindViewHolder(a holder, int position) {
        this.f40a.a(holder, getItem(position), position);
    }

    public int getItemViewType(int position) {
        return this.f40a.k(position);
    }

    /* renamed from: i */
    public void onViewAttachedToWindow(a viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        a.C0008a selectionState = this.f41a.getSelectionHandler().g(viewHolder.getAdapterPosition());
        if (!this.f41a.e()) {
            this.f41a.getSelectionHandler().a(viewHolder, selectionState);
        }
        viewHolder.d(selectionState);
        if (this.f41a.c() && (viewHolder instanceof b0)) {
            ((b0) viewHolder).f(f().b(viewHolder.getAdapterPosition()));
        }
    }

    public ga f() {
        if (this.f39a == null) {
            this.f39a = new ga(this.f41a.getColumnHeaderLayoutManager());
        }
        return this.f39a;
    }
}
