package defpackage;

import androidx.recyclerview.widget.DiffUtil;
import java.util.List;

/* renamed from: da  reason: default package */
public class da extends DiffUtil.Callback {
    private static final String a = da.class.getSimpleName();

    /* renamed from: a  reason: collision with other field name */
    private int f2750a;

    /* renamed from: a  reason: collision with other field name */
    private List<List<mr>> f2751a;
    private List<List<mr>> b;

    public da(List<List<mr>> oldCellItems, List<List<mr>> newCellItems, int column) {
        this.f2751a = oldCellItems;
        this.b = newCellItems;
        this.f2750a = column;
    }

    public int getOldListSize() {
        return this.f2751a.size();
    }

    public int getNewListSize() {
        return this.b.size();
    }

    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        if (this.f2751a.size() <= oldItemPosition || this.b.size() <= newItemPosition || this.f2751a.get(oldItemPosition).size() <= this.f2750a || this.b.get(newItemPosition).size() <= this.f2750a) {
            return false;
        }
        return ((mr) this.f2751a.get(oldItemPosition).get(this.f2750a)).b().equals(((mr) this.b.get(newItemPosition).get(this.f2750a)).b());
    }

    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        if (this.f2751a.size() <= oldItemPosition || this.b.size() <= newItemPosition || this.f2751a.get(oldItemPosition).size() <= this.f2750a || this.b.get(newItemPosition).size() <= this.f2750a) {
            return false;
        }
        return ((mr) this.f2751a.get(oldItemPosition).get(this.f2750a)).a().equals(((mr) this.b.get(newItemPosition).get(this.f2750a)).a());
    }
}
