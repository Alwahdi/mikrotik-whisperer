package com.evrencoskun.tableview.adapter.recyclerview.holder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class a extends RecyclerView.ViewHolder {
    private C0008a a = C0008a.UNSELECTED;

    /* renamed from: com.evrencoskun.tableview.adapter.recyclerview.holder.a$a  reason: collision with other inner class name */
    public enum C0008a {
        SELECTED,
        UNSELECTED,
        SHADOWED
    }

    public a(View itemView) {
        super(itemView);
    }

    public void d(C0008a selectionState) {
        this.a = selectionState;
        if (selectionState == C0008a.SELECTED) {
            this.itemView.setSelected(true);
        } else if (selectionState == C0008a.UNSELECTED) {
            this.itemView.setSelected(false);
        }
    }

    public void c(int p_nColor) {
        this.itemView.setBackgroundColor(p_nColor);
    }

    public void b() {
    }

    public boolean a() {
        return false;
    }
}
