package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import com.evrencoskun.tableview.adapter.recyclerview.holder.a;
import java.util.List;

/* renamed from: ff0  reason: default package */
public class ff0<RH> extends v<RH> {
    private jf0 a;

    /* renamed from: a  reason: collision with other field name */
    private nr f2968a;

    /* renamed from: a  reason: collision with other field name */
    private or f2969a;

    public ff0(Context context, List<RH> itemList, nr tableAdapter) {
        super(context, itemList);
        this.f2968a = tableAdapter;
        this.f2969a = tableAdapter.b();
    }

    /* renamed from: h */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        return this.f2968a.e(parent, viewType);
    }

    /* renamed from: g */
    public void onBindViewHolder(a holder, int position) {
        this.f2968a.i(holder, getItem(position), position);
    }

    public int getItemViewType(int position) {
        return this.f2968a.g(position);
    }

    /* renamed from: i */
    public void onViewAttachedToWindow(a viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        a.C0008a selectionState = this.f2969a.getSelectionHandler().h(viewHolder.getAdapterPosition());
        if (!this.f2969a.e()) {
            this.f2969a.getSelectionHandler().b(viewHolder, selectionState);
        }
        viewHolder.d(selectionState);
    }

    public jf0 f() {
        if (this.a == null) {
            this.a = new jf0();
        }
        return this.a;
    }
}
