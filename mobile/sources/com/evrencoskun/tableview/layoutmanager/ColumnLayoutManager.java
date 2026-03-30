package com.evrencoskun.tableview.layoutmanager;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ColumnLayoutManager extends LinearLayoutManager {
    private static final String a = ColumnLayoutManager.class.getSimpleName();

    /* renamed from: a  reason: collision with other field name */
    private int f1325a = 0;

    /* renamed from: a  reason: collision with other field name */
    private a8 f1326a;

    /* renamed from: a  reason: collision with other field name */
    private CellLayoutManager f1327a;

    /* renamed from: a  reason: collision with other field name */
    private ColumnHeaderLayoutManager f1328a;

    /* renamed from: a  reason: collision with other field name */
    private or f1329a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f1330a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private a8 f1331b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f1332b;

    public ColumnLayoutManager(Context context, or tableView) {
        super(context);
        this.f1329a = tableView;
        this.f1331b = tableView.getColumnHeaderRecyclerView();
        this.f1328a = this.f1329a.getColumnHeaderLayoutManager();
        this.f1327a = this.f1329a.getCellLayoutManager();
        setOrientation(0);
        setRecycleChildrenOnDetach(true);
    }

    public void onAttachedToWindow(RecyclerView view) {
        super.onAttachedToWindow(view);
        this.f1326a = (a8) view;
        this.b = h();
    }

    public void measureChildWithMargins(View child, int widthUsed, int heightUsed) {
        super.measureChildWithMargins(child, widthUsed, heightUsed);
        if (!this.f1329a.h()) {
            measureChild(child, widthUsed, heightUsed);
        }
    }

    public void measureChild(View child, int widthUsed, int heightUsed) {
        int columnPosition = getPosition(child);
        int cacheWidth = this.f1327a.l(this.b, columnPosition);
        int columnCacheWidth = this.f1328a.f(columnPosition);
        if (cacheWidth == -1 || cacheWidth != columnCacheWidth) {
            View columnHeaderChild = this.f1328a.findViewByPosition(columnPosition);
            if (columnHeaderChild != null) {
                f(child, this.b, columnPosition, cacheWidth, columnCacheWidth, columnHeaderChild);
            } else {
                return;
            }
        } else if (child.getMeasuredWidth() != cacheWidth) {
            xp0.a(child, cacheWidth);
        }
        if (j(columnPosition, this.b)) {
            if (this.f1325a < 0) {
                String str = a;
                Log.e(str, "x: " + columnPosition + " y: " + this.b + " fitWidthSize " + "left side ");
                this.f1327a.i(columnPosition, true);
            } else {
                this.f1327a.i(columnPosition, false);
                String str2 = a;
                Log.e(str2, "x: " + columnPosition + " y: " + this.b + " fitWidthSize " + "right side");
            }
            this.f1330a = false;
        }
        this.f1332b = false;
    }

    private void f(View child, int row, int column, int cellWidth, int columnHeaderWidth, View columnHeaderChild) {
        if (cellWidth == -1) {
            cellWidth = child.getMeasuredWidth();
        }
        if (columnHeaderWidth == -1) {
            columnHeaderWidth = columnHeaderChild.getMeasuredWidth();
        }
        if (cellWidth != 0) {
            if (columnHeaderWidth > cellWidth) {
                cellWidth = columnHeaderWidth;
            } else if (cellWidth > columnHeaderWidth) {
                columnHeaderWidth = cellWidth;
            }
            if (columnHeaderWidth != columnHeaderChild.getWidth()) {
                xp0.a(columnHeaderChild, columnHeaderWidth);
                this.f1330a = true;
                this.f1332b = true;
            }
            this.f1328a.i(column, columnHeaderWidth);
        }
        xp0.a(child, cellWidth);
        this.f1327a.p(row, column, cellWidth);
    }

    private boolean j(int xPosition, int yPosition) {
        if (!this.f1332b || this.f1326a.c() || !this.f1327a.q(yPosition)) {
            return false;
        }
        int i = this.f1325a;
        if (i > 0) {
            if (xPosition == findLastVisibleItemPosition()) {
                return true;
            }
            return false;
        } else if (i >= 0 || xPosition != findFirstVisibleItemPosition()) {
            return false;
        } else {
            return true;
        }
    }

    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f1331b.getScrollState() == 0 && this.f1326a.c()) {
            this.f1331b.scrollBy(dx, 0);
        }
        this.f1325a = dx;
        setInitialPrefetchItemCount(2);
        return super.scrollHorizontallyBy(dx, recycler, state);
    }

    private int h() {
        return this.f1327a.getPosition(this.f1326a);
    }

    public int g() {
        return this.f1325a;
    }

    public boolean i() {
        return this.f1330a;
    }

    public void e() {
        this.f1330a = false;
    }
}
