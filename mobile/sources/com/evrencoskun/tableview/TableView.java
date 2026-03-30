package com.evrencoskun.tableview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.evrencoskun.tableview.layoutmanager.CellLayoutManager;
import com.evrencoskun.tableview.layoutmanager.ColumnHeaderLayoutManager;
import com.evrencoskun.tableview.sort.a;

public class TableView extends FrameLayout implements or {
    private static final String a = TableView.class.getSimpleName();

    /* renamed from: a  reason: collision with other field name */
    private int f1288a;

    /* renamed from: a  reason: collision with other field name */
    protected a8 f1289a;

    /* renamed from: a  reason: collision with other field name */
    private DividerItemDecoration f1290a;

    /* renamed from: a  reason: collision with other field name */
    private LinearLayoutManager f1291a;

    /* renamed from: a  reason: collision with other field name */
    private ba f1292a;

    /* renamed from: a  reason: collision with other field name */
    private bv0 f1293a;

    /* renamed from: a  reason: collision with other field name */
    private CellLayoutManager f1294a;

    /* renamed from: a  reason: collision with other field name */
    private ColumnHeaderLayoutManager f1295a;

    /* renamed from: a  reason: collision with other field name */
    protected d0 f1296a;

    /* renamed from: a  reason: collision with other field name */
    private fa f1297a;

    /* renamed from: a  reason: collision with other field name */
    private gf0 f1298a;

    /* renamed from: a  reason: collision with other field name */
    private ja0 f1299a;

    /* renamed from: a  reason: collision with other field name */
    private ja f1300a;

    /* renamed from: a  reason: collision with other field name */
    private nv0 f1301a;

    /* renamed from: a  reason: collision with other field name */
    private pr f1302a;

    /* renamed from: a  reason: collision with other field name */
    private rj0 f1303a;

    /* renamed from: a  reason: collision with other field name */
    private rq f1304a;

    /* renamed from: a  reason: collision with other field name */
    private vk f1305a;

    /* renamed from: a  reason: collision with other field name */
    private yj0 f1306a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f1307a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    protected a8 f1308b;

    /* renamed from: b  reason: collision with other field name */
    private DividerItemDecoration f1309b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f1310b;
    private int c;

    /* renamed from: c  reason: collision with other field name */
    protected a8 f1311c;

    /* renamed from: c  reason: collision with other field name */
    private boolean f1312c = true;
    private int d;

    /* renamed from: d  reason: collision with other field name */
    private boolean f1313d = true;
    private int e;

    /* renamed from: e  reason: collision with other field name */
    private boolean f1314e;
    private int f = -1;

    public TableView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        q(attrs);
        r();
    }

    private void q(AttributeSet attrs) {
        this.f1288a = (int) getResources().getDimension(bc0.default_row_header_width);
        this.b = (int) getResources().getDimension(bc0.default_column_header_height);
        this.c = ContextCompat.getColor(getContext(), ac0.table_view_default_selected_background_color);
        this.d = ContextCompat.getColor(getContext(), ac0.table_view_default_unselected_background_color);
        this.e = ContextCompat.getColor(getContext(), ac0.table_view_default_shadow_background_color);
        if (attrs != null) {
            TypedArray a2 = getContext().getTheme().obtainStyledAttributes(attrs, wc0.E, 0, 0);
            try {
                this.f1288a = (int) a2.getDimension(wc0.b, (float) this.f1288a);
                this.b = (int) a2.getDimension(wc0.a, (float) this.b);
                this.c = a2.getColor(wc0.c, this.c);
                this.d = a2.getColor(wc0.h, this.d);
                this.e = a2.getColor(wc0.e, this.e);
                this.f = a2.getColor(wc0.d, ContextCompat.getColor(getContext(), ac0.table_view_default_separator_color));
                this.f1313d = a2.getBoolean(wc0.g, this.f1313d);
                this.f1312c = a2.getBoolean(wc0.f, this.f1312c);
            } finally {
                a2.recycle();
            }
        }
    }

    private void r() {
        this.f1308b = n();
        this.f1311c = p();
        this.f1289a = m();
        addView(this.f1308b);
        addView(this.f1311c);
        addView(this.f1289a);
        this.f1306a = new yj0(this);
        this.f1301a = new nv0(this);
        this.f1303a = new rj0(this);
        this.f1299a = new ja0(this);
        this.f1300a = new ja(this);
        s();
    }

    /* access modifiers changed from: protected */
    public void s() {
        bv0 bv0 = new bv0(this);
        this.f1293a = bv0;
        this.f1311c.addOnItemTouchListener(bv0);
        this.f1289a.addOnItemTouchListener(this.f1293a);
        rq rqVar = new rq(this);
        this.f1304a = rqVar;
        this.f1308b.addOnItemTouchListener(rqVar);
        this.f1292a = new ba(this.f1308b, this);
        this.f1298a = new gf0(this.f1311c, this);
        this.f1308b.addOnItemTouchListener(this.f1292a);
        this.f1311c.addOnItemTouchListener(this.f1298a);
        pp0 layoutChangeListener = new pp0(this);
        this.f1308b.addOnLayoutChangeListener(layoutChangeListener);
        this.f1289a.addOnLayoutChangeListener(layoutChangeListener);
    }

    /* access modifiers changed from: protected */
    public a8 n() {
        a8 recyclerView = new a8(getContext());
        recyclerView.setLayoutManager(getColumnHeaderLayoutManager());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, this.b);
        layoutParams.leftMargin = this.f1288a;
        recyclerView.setLayoutParams(layoutParams);
        if (j()) {
            recyclerView.addItemDecoration(getHorizontalItemDecoration());
        }
        return recyclerView;
    }

    /* access modifiers changed from: protected */
    public a8 p() {
        a8 recyclerView = new a8(getContext());
        recyclerView.setLayoutManager(getRowHeaderLayoutManager());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f1288a, -2);
        layoutParams.topMargin = this.b;
        recyclerView.setLayoutParams(layoutParams);
        if (t()) {
            recyclerView.addItemDecoration(getVerticalItemDecoration());
        }
        return recyclerView;
    }

    /* access modifiers changed from: protected */
    public a8 m() {
        a8 recyclerView = new a8(getContext());
        recyclerView.setMotionEventSplittingEnabled(false);
        recyclerView.setLayoutManager(getCellLayoutManager());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.f1288a;
        layoutParams.topMargin = this.b;
        recyclerView.setLayoutParams(layoutParams);
        if (t()) {
            recyclerView.addItemDecoration(getVerticalItemDecoration());
        }
        return recyclerView;
    }

    public void setAdapter(d0 tableAdapter) {
        if (tableAdapter != null) {
            this.f1296a = tableAdapter;
            tableAdapter.C(this.f1288a);
            this.f1296a.z(this.b);
            this.f1296a.D(this);
            a8 a8Var = this.f1308b;
            if (a8Var != null) {
                a8Var.setAdapter(this.f1296a.s());
            }
            a8 a8Var2 = this.f1311c;
            if (a8Var2 != null) {
                a8Var2.setAdapter(this.f1296a.u());
            }
            a8 a8Var3 = this.f1289a;
            if (a8Var3 != null) {
                a8Var3.setAdapter(this.f1296a.q());
                this.f1297a = new fa(this);
                this.f1305a = new vk(this);
            }
        }
    }

    public boolean h() {
        return this.f1307a;
    }

    public void setHasFixedWidth(boolean hasFixedWidth) {
        this.f1307a = hasFixedWidth;
        this.f1308b.setHasFixedSize(hasFixedWidth);
    }

    public boolean e() {
        return this.f1310b;
    }

    public void setIgnoreSelectionColors(boolean ignoreSelectionColor) {
        this.f1310b = ignoreSelectionColor;
    }

    public boolean j() {
        return this.f1312c;
    }

    public boolean c() {
        return this.f1314e;
    }

    public void setShowHorizontalSeparators(boolean showSeparators) {
        this.f1312c = showSeparators;
    }

    public boolean t() {
        return this.f1313d;
    }

    public void setShowVerticalSeparators(boolean showSeparators) {
        this.f1313d = showSeparators;
    }

    public a8 getCellRecyclerView() {
        return this.f1289a;
    }

    public a8 getColumnHeaderRecyclerView() {
        return this.f1308b;
    }

    public a8 getRowHeaderRecyclerView() {
        return this.f1311c;
    }

    public ColumnHeaderLayoutManager getColumnHeaderLayoutManager() {
        if (this.f1295a == null) {
            this.f1295a = new ColumnHeaderLayoutManager(getContext(), this);
        }
        return this.f1295a;
    }

    public CellLayoutManager getCellLayoutManager() {
        if (this.f1294a == null) {
            this.f1294a = new CellLayoutManager(getContext(), this);
        }
        return this.f1294a;
    }

    public LinearLayoutManager getRowHeaderLayoutManager() {
        if (this.f1291a == null) {
            this.f1291a = new LinearLayoutManager(getContext(), 1, false);
        }
        return this.f1291a;
    }

    public rq getHorizontalRecyclerViewListener() {
        return this.f1304a;
    }

    public bv0 getVerticalRecyclerViewListener() {
        return this.f1293a;
    }

    public pr getTableViewListener() {
        return this.f1302a;
    }

    public void setTableViewListener(pr tableViewListener) {
        this.f1302a = tableViewListener;
    }

    public void l(int columnPosition, a sortState) {
        this.f1314e = true;
        this.f1297a.d(columnPosition, sortState);
    }

    public void f(a sortState) {
        this.f1314e = true;
        this.f1297a.e(sortState);
    }

    public d0 getAdapter() {
        return this.f1296a;
    }

    public void a(tk filter) {
        this.f1305a.f(filter);
    }

    public vk getFilterHandler() {
        return this.f1305a;
    }

    public a k(int column) {
        return this.f1297a.c(column);
    }

    public a getRowHeaderSortingStatus() {
        return this.f1297a.b();
    }

    public void b(int column) {
        this.f1303a.g(column);
    }

    public void d(int row) {
        this.f1303a.i(row);
    }

    public rj0 getScrollHandler() {
        return this.f1303a;
    }

    public void g(int row) {
        this.f1301a.c(row);
    }

    public void i(int row) {
        this.f1301a.b(row);
    }

    public int getSelectedRow() {
        return this.f1306a.j();
    }

    public void setSelectedRow(int row) {
        this.f1306a.z((com.evrencoskun.tableview.adapter.recyclerview.holder.a) getRowHeaderRecyclerView().findViewHolderForAdapterPosition(row), row);
    }

    public int getSelectedColumn() {
        return this.f1306a.i();
    }

    public void setSelectedColumn(int column) {
        this.f1306a.x((com.evrencoskun.tableview.adapter.recyclerview.holder.a) getColumnHeaderRecyclerView().findViewHolderForAdapterPosition(column), column);
    }

    public yj0 getSelectionHandler() {
        return this.f1306a;
    }

    public fa getColumnSortHandler() {
        return this.f1297a;
    }

    public DividerItemDecoration getHorizontalItemDecoration() {
        if (this.f1309b == null) {
            this.f1309b = o(0);
        }
        return this.f1309b;
    }

    public DividerItemDecoration getVerticalItemDecoration() {
        if (this.f1290a == null) {
            this.f1290a = o(1);
        }
        return this.f1290a;
    }

    /* access modifiers changed from: protected */
    public DividerItemDecoration o(int orientation) {
        Drawable divider = ContextCompat.getDrawable(getContext(), hc0.cell_line_divider);
        int i = this.f;
        if (i != -1) {
            divider.setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
        }
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), orientation);
        itemDecoration.setDrawable(divider);
        return itemDecoration;
    }

    public void setSelectedColor(@ColorInt int selectedColor) {
        this.c = selectedColor;
    }

    @ColorInt
    public int getSelectedColor() {
        return this.c;
    }

    public void setUnSelectedColor(@ColorInt int unSelectedColor) {
        this.d = unSelectedColor;
    }

    @ColorInt
    public int getUnSelectedColor() {
        return this.d;
    }

    public void setShadowColor(@ColorInt int shadowColor) {
        this.e = shadowColor;
    }

    @ColorInt
    public int getShadowColor() {
        return this.e;
    }

    public int getRowHeaderWidth() {
        return this.f1288a;
    }

    public void setRowHeaderWidth(int rowHeaderWidth) {
        this.f1288a = rowHeaderWidth;
        a8 a8Var = this.f1311c;
        if (a8Var != null) {
            ViewGroup.LayoutParams layoutParams = a8Var.getLayoutParams();
            layoutParams.width = rowHeaderWidth;
            this.f1311c.setLayoutParams(layoutParams);
            this.f1311c.requestLayout();
        }
        a8 a8Var2 = this.f1308b;
        if (a8Var2 != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) a8Var2.getLayoutParams();
            layoutParams2.leftMargin = rowHeaderWidth;
            this.f1308b.setLayoutParams(layoutParams2);
            this.f1308b.requestLayout();
        }
        a8 a8Var3 = this.f1289a;
        if (a8Var3 != null) {
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) a8Var3.getLayoutParams();
            layoutParams3.leftMargin = rowHeaderWidth;
            this.f1289a.setLayoutParams(layoutParams3);
            this.f1289a.requestLayout();
        }
        if (getAdapter() != null) {
            getAdapter().C(rowHeaderWidth);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        ti0 state = new ti0(super.onSaveInstanceState());
        state.a = this.f1299a.b();
        return state;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof ti0)) {
            super.onRestoreInstanceState(state);
            return;
        }
        ti0 savedState = (ti0) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f1299a.a(savedState.a);
    }
}
