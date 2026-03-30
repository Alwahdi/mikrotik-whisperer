package com.evrencoskun.tableview.layoutmanager;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.evrencoskun.tableview.adapter.recyclerview.holder.a;
import java.util.HashMap;
import java.util.Map;

public class ColumnHeaderLayoutManager extends LinearLayoutManager {
    private Map<Integer, Integer> a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    private or f1324a;

    public ColumnHeaderLayoutManager(Context context, or tableView) {
        super(context);
        this.f1324a = tableView;
        setOrientation(0);
    }

    public void measureChildWithMargins(View child, int widthUsed, int heightUsed) {
        super.measureChildWithMargins(child, widthUsed, heightUsed);
        if (!this.f1324a.h()) {
            measureChild(child, widthUsed, heightUsed);
        }
    }

    public void measureChild(View child, int widthUsed, int heightUsed) {
        if (this.f1324a.h()) {
            super.measureChild(child, widthUsed, heightUsed);
            return;
        }
        int cacheWidth = f(getPosition(child));
        if (cacheWidth != -1) {
            xp0.a(child, cacheWidth);
        } else {
            super.measureChild(child, widthUsed, heightUsed);
        }
    }

    public void i(int position, int width) {
        this.a.put(Integer.valueOf(position), Integer.valueOf(width));
    }

    public int f(int position) {
        Integer cachedWidth = this.a.get(Integer.valueOf(position));
        if (cachedWidth == null) {
            return -1;
        }
        return cachedWidth.intValue();
    }

    public int g() {
        return findViewByPosition(findFirstVisibleItemPosition()).getLeft();
    }

    public void e() {
        int left = g();
        for (int i = findFirstVisibleItemPosition(); i < findLastVisibleItemPosition() + 1; i++) {
            int right = f(i) + left;
            View columnHeader = findViewByPosition(i);
            columnHeader.setLeft(left);
            columnHeader.setRight(right);
            layoutDecoratedWithMargins(columnHeader, columnHeader.getLeft(), columnHeader.getTop(), columnHeader.getRight(), columnHeader.getBottom());
            left = right + 1;
        }
    }

    public a h(int xPosition) {
        return (a) this.f1324a.getColumnHeaderRecyclerView().findViewHolderForAdapterPosition(xPosition);
    }
}
