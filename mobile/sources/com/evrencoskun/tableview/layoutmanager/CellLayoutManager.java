package com.evrencoskun.tableview.layoutmanager;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.Map;

public class CellLayoutManager extends LinearLayoutManager {
    private static final String a = CellLayoutManager.class.getSimpleName();

    /* renamed from: a  reason: collision with other field name */
    private int f1315a = 0;

    /* renamed from: a  reason: collision with other field name */
    private a8 f1316a;

    /* renamed from: a  reason: collision with other field name */
    private LinearLayoutManager f1317a;

    /* renamed from: a  reason: collision with other field name */
    private ColumnHeaderLayoutManager f1318a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<Integer, Map<Integer, Integer>> f1319a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    private or f1320a;

    /* renamed from: a  reason: collision with other field name */
    private rq f1321a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f1322a;
    private a8 b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f1323b;

    public CellLayoutManager(Context context, or tableView) {
        super(context);
        this.f1320a = tableView;
        this.b = tableView.getCellRecyclerView();
        this.f1318a = tableView.getColumnHeaderLayoutManager();
        this.f1317a = tableView.getRowHeaderLayoutManager();
        this.f1316a = tableView.getRowHeaderRecyclerView();
        n();
    }

    private void n() {
        setOrientation(1);
    }

    public void onAttachedToWindow(RecyclerView view) {
        super.onAttachedToWindow(view);
        if (this.b == null) {
            this.b = this.f1320a.getCellRecyclerView();
        }
        if (this.f1321a == null) {
            this.f1321a = this.f1320a.getHorizontalRecyclerViewListener();
        }
    }

    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f1316a.getScrollState() == 0 && !this.f1316a.c()) {
            this.f1316a.scrollBy(0, dy);
        }
        int scroll = super.scrollVerticallyBy(dy, recycler, state);
        this.f1315a = dy;
        return scroll;
    }

    public void onScrollStateChanged(int state) {
        super.onScrollStateChanged(state);
        if (state == 0) {
            this.f1315a = 0;
        }
    }

    public void j(boolean scrollingUp) {
        int left = this.f1318a.g();
        for (int i = this.f1318a.findFirstVisibleItemPosition(); i < this.f1318a.findLastVisibleItemPosition() + 1; i++) {
            left = g(i, left, scrollingUp);
        }
        this.f1322a = false;
    }

    public void i(int position, boolean scrollingLeft) {
        g(position, -99999, false);
        if (this.f1322a && scrollingLeft) {
            new Handler().post(new a());
        }
    }

    class a implements Runnable {
        a() {
        }

        public void run() {
            CellLayoutManager.this.k(true);
        }
    }

    private int g(int position, int left, boolean scrollingUp) {
        int columnCacheWidth = this.f1318a.f(position);
        View column = this.f1318a.findViewByPosition(position);
        if (column != null) {
            int cellRight = column.getLeft() + columnCacheWidth + 1;
            if (scrollingUp) {
                int cellRight2 = cellRight;
                for (int i = findLastVisibleItemPosition(); i >= findFirstVisibleItemPosition(); i--) {
                    cellRight2 = e(position, i, left, cellRight2, columnCacheWidth);
                }
                return cellRight2;
            }
            int cellRight3 = cellRight;
            for (int j = findFirstVisibleItemPosition(); j < findLastVisibleItemPosition() + 1; j++) {
                cellRight3 = e(position, j, left, cellRight3, columnCacheWidth);
            }
            return cellRight3;
        }
        Log.e(a, "Warning: column couldn't found for " + position);
        return -1;
    }

    private int e(int xPosition, int yPosition, int left, int right, int columnCachedWidth) {
        int cellCacheWidth;
        int right2;
        int i = xPosition;
        int i2 = yPosition;
        int i3 = left;
        int i4 = columnCachedWidth;
        a8 child = (a8) findViewByPosition(i2);
        if (child != null) {
            ColumnLayoutManager childLayoutManager = (ColumnLayoutManager) child.getLayoutManager();
            int cellCacheWidth2 = l(i2, i);
            View cell = childLayoutManager.findViewByPosition(i);
            if (cell != null && (cellCacheWidth2 != i4 || this.f1322a)) {
                if (cellCacheWidth2 != i4) {
                    int cellCacheWidth3 = columnCachedWidth;
                    xp0.a(cell, cellCacheWidth3);
                    p(i2, i, cellCacheWidth3);
                    cellCacheWidth = cellCacheWidth3;
                } else {
                    cellCacheWidth = cellCacheWidth2;
                }
                if (!(i3 == -99999 || cell.getLeft() == i3)) {
                    int scrollX = Math.max(cell.getLeft(), i3) - Math.min(cell.getLeft(), i3);
                    cell.setLeft(i3);
                    if (this.f1321a.c() > 0 && i == childLayoutManager.findFirstVisibleItemPosition() && this.b.getScrollState() != 0) {
                        int scrollPosition = this.f1321a.b();
                        int offset = this.f1321a.c() + scrollX;
                        this.f1321a.f(offset);
                        childLayoutManager.scrollToPositionWithOffset(scrollPosition, offset);
                    }
                }
                if (cell.getWidth() != cellCacheWidth) {
                    if (i3 != -99999) {
                        int right3 = cell.getLeft() + cellCacheWidth + 1;
                        cell.setRight(right3);
                        right2 = right3;
                        childLayoutManager.layoutDecoratedWithMargins(cell, cell.getLeft(), cell.getTop(), cell.getRight(), cell.getBottom());
                    } else {
                        right2 = right;
                    }
                    this.f1322a = true;
                    return right2;
                }
            }
        }
        return right;
    }

    public void k(boolean scrollingLeft) {
        this.f1318a.e();
        int columnHeaderScrollPosition = this.f1320a.getColumnHeaderRecyclerView().getScrolledX();
        int columnHeaderOffset = this.f1318a.g();
        int columnHeaderFirstItem = this.f1318a.findFirstVisibleItemPosition();
        for (int i = this.f1318a.findFirstVisibleItemPosition(); i < this.f1318a.findLastVisibleItemPosition() + 1; i++) {
            h(i, scrollingLeft, columnHeaderScrollPosition, columnHeaderOffset, columnHeaderFirstItem);
        }
        this.f1322a = false;
    }

    private void h(int position, boolean scrollingLeft, int columnHeaderScrollPosition, int columnHeaderOffset, int columnHeaderFirstItem) {
        int i = position;
        int columnCacheWidth = this.f1318a.f(i);
        View column = this.f1318a.findViewByPosition(i);
        if (column != null) {
            for (int j = findFirstVisibleItemPosition(); j < findLastVisibleItemPosition() + 1; j++) {
                a8 child = (a8) findViewByPosition(j);
                if (child != null) {
                    ColumnLayoutManager childLayoutManager = (ColumnLayoutManager) child.getLayoutManager();
                    if (scrollingLeft) {
                        int i2 = columnHeaderScrollPosition;
                    } else if (columnHeaderScrollPosition != child.getScrolledX()) {
                        childLayoutManager.scrollToPositionWithOffset(columnHeaderFirstItem, columnHeaderOffset);
                        f(position, j, columnCacheWidth, column, childLayoutManager);
                    }
                    int i3 = columnHeaderOffset;
                    int i4 = columnHeaderFirstItem;
                    f(position, j, columnCacheWidth, column, childLayoutManager);
                } else {
                    int i5 = columnHeaderScrollPosition;
                    int i6 = columnHeaderOffset;
                    int i7 = columnHeaderFirstItem;
                }
            }
            int i8 = columnHeaderScrollPosition;
            int i9 = columnHeaderOffset;
            int i10 = columnHeaderFirstItem;
            return;
        }
        int i11 = columnHeaderScrollPosition;
        int i12 = columnHeaderOffset;
        int i13 = columnHeaderFirstItem;
    }

    private void f(int xPosition, int yPosition, int columnCachedWidth, View column, ColumnLayoutManager childLayoutManager) {
        int cellCacheWidth = l(yPosition, xPosition);
        View cell = childLayoutManager.findViewByPosition(xPosition);
        if (cell == null) {
            return;
        }
        if (cellCacheWidth != columnCachedWidth || this.f1322a) {
            if (cellCacheWidth != columnCachedWidth) {
                int cellCacheWidth2 = columnCachedWidth;
                xp0.a(cell, cellCacheWidth2);
                p(yPosition, xPosition, cellCacheWidth2);
            }
            if (column.getLeft() != cell.getLeft() || column.getRight() != cell.getRight()) {
                cell.setLeft(column.getLeft());
                cell.setRight(column.getRight() + 1);
                childLayoutManager.layoutDecoratedWithMargins(cell, cell.getLeft(), cell.getTop(), cell.getRight(), cell.getBottom());
                this.f1322a = true;
            }
        }
    }

    public boolean q(int yPosition) {
        if (this.b.getScrollState() != 0) {
            return false;
        }
        int lastVisiblePosition = findLastVisibleItemPosition();
        a8 lastCellRecyclerView = (a8) findViewByPosition(lastVisiblePosition);
        if (lastCellRecyclerView == null) {
            return false;
        }
        if (yPosition == lastVisiblePosition) {
            return true;
        }
        if (!lastCellRecyclerView.c() || yPosition != lastVisiblePosition - 1) {
            return false;
        }
        return true;
    }

    public void measureChildWithMargins(View child, int widthUsed, int heightUsed) {
        super.measureChildWithMargins(child, widthUsed, heightUsed);
        if (!this.f1320a.h()) {
            int position = getPosition(child);
            ColumnLayoutManager childLayoutManager = (ColumnLayoutManager) ((a8) child).getLayoutManager();
            if (this.b.getScrollState() != 0) {
                if (childLayoutManager.i()) {
                    if (this.f1315a < 0) {
                        String str = a;
                        Log.e(str, position + " fitWidthSize all vertically up");
                        j(true);
                    } else {
                        String str2 = a;
                        Log.e(str2, position + " fitWidthSize all vertically down");
                        j(false);
                    }
                    childLayoutManager.e();
                }
                childLayoutManager.setInitialPrefetchItemCount(childLayoutManager.getChildCount());
            } else if (childLayoutManager.g() == 0 && this.b.getScrollState() == 0) {
                if (childLayoutManager.i()) {
                    this.f1323b = true;
                    childLayoutManager.e();
                }
                if (this.f1323b && this.f1317a.findLastVisibleItemPosition() == position) {
                    k(false);
                    String str3 = a;
                    Log.e(str3, position + " fitWidthSize populating data for the first time");
                    this.f1323b = false;
                }
            }
        }
    }

    public com.evrencoskun.tableview.adapter.recyclerview.holder.a m(int xPosition, int yPosition) {
        a8 cellRowRecyclerView = (a8) findViewByPosition(yPosition);
        if (cellRowRecyclerView != null) {
            return (com.evrencoskun.tableview.adapter.recyclerview.holder.a) cellRowRecyclerView.findViewHolderForAdapterPosition(xPosition);
        }
        return null;
    }

    public void o() {
        for (int j = 0; j < getChildCount(); j++) {
            a8 recyclerView = (a8) getChildAt(j);
            recyclerView.getLayoutParams().width = -2;
            recyclerView.requestLayout();
        }
    }

    public void p(int row, int column, int width) {
        Map<Integer, Integer> cellRowCache = this.f1319a.get(Integer.valueOf(row));
        if (cellRowCache == null) {
            cellRowCache = new HashMap<>();
        }
        cellRowCache.put(Integer.valueOf(column), Integer.valueOf(width));
        this.f1319a.put(Integer.valueOf(row), cellRowCache);
    }

    public int l(int row, int column) {
        Map<Integer, Integer> cellRowCaches = this.f1319a.get(Integer.valueOf(row));
        if (cellRowCaches == null || cellRowCaches.get(Integer.valueOf(column)) == null) {
            return -1;
        }
        return cellRowCaches.get(Integer.valueOf(column)).intValue();
    }
}
