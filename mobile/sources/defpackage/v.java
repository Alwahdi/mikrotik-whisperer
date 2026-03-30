package defpackage;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.evrencoskun.tableview.adapter.recyclerview.holder.a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: v  reason: default package */
public abstract class v<T> extends RecyclerView.Adapter<a> {
    protected Context a;

    /* renamed from: a  reason: collision with other field name */
    protected List<T> f5290a;

    public v(Context context, List<T> itemList) {
        this.a = context;
        if (itemList == null) {
            this.f5290a = new ArrayList();
        } else {
            d(itemList);
        }
    }

    public int getItemCount() {
        return this.f5290a.size();
    }

    public List<T> c() {
        return this.f5290a;
    }

    public void d(List<T> itemList) {
        this.f5290a = new ArrayList(itemList);
        notifyDataSetChanged();
    }

    public void e(List<T> itemList, boolean notifyDataSet) {
        this.f5290a = new ArrayList(itemList);
        if (notifyDataSet) {
            notifyDataSetChanged();
        }
    }

    public T getItem(int position) {
        List<T> list = this.f5290a;
        if (list == null || list.isEmpty() || position < 0 || position >= this.f5290a.size()) {
            return null;
        }
        return this.f5290a.get(position);
    }

    public void b(int position) {
        if (position != -1) {
            this.f5290a.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void a(int position, T item) {
        if (position != -1 && item != null) {
            this.f5290a.add(position, item);
            notifyItemInserted(position);
        }
    }

    public int getItemViewType(int position) {
        return 1;
    }
}
