package defpackage;

import androidx.recyclerview.widget.DiffUtil;
import java.util.List;

/* renamed from: hf0  reason: default package */
public class hf0 extends DiffUtil.Callback {
    private static final String a = hf0.class.getSimpleName();

    /* renamed from: a  reason: collision with other field name */
    private List<mr> f3159a;
    private List<mr> b;

    public hf0(List<mr> oldCellItems, List<mr> newCellItems) {
        this.f3159a = oldCellItems;
        this.b = newCellItems;
    }

    public int getOldListSize() {
        return this.f3159a.size();
    }

    public int getNewListSize() {
        return this.b.size();
    }

    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        if (this.f3159a.size() <= oldItemPosition || this.b.size() <= newItemPosition) {
            return false;
        }
        return this.f3159a.get(oldItemPosition).b().equals(this.b.get(newItemPosition).b());
    }

    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        if (this.f3159a.size() <= oldItemPosition || this.b.size() <= newItemPosition) {
            return false;
        }
        return this.f3159a.get(oldItemPosition).a().equals(this.b.get(newItemPosition).a());
    }
}
