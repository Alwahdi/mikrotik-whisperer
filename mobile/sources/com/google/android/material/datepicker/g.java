package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class g<S> extends m<S> {
    static final Object a = "MONTHS_VIEW_GROUP_TAG";
    static final Object b = "NAVIGATION_PREV_TAG";
    static final Object c = "NAVIGATION_NEXT_TAG";
    static final Object d = "SELECTOR_TOGGLE_TAG";

    /* renamed from: a  reason: collision with other field name */
    private int f1687a;

    /* renamed from: a  reason: collision with other field name */
    private View f1688a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public RecyclerView f1689a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public a f1690a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public c f1691a;

    /* renamed from: a  reason: collision with other field name */
    private l f1692a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public j f1693a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public xe<S> f1694a;

    /* renamed from: a  reason: collision with other field name */
    private ye f1695a;

    /* renamed from: b  reason: collision with other field name */
    private View f1696b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public RecyclerView f1697b;

    /* renamed from: c  reason: collision with other field name */
    private View f1698c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with other field name */
    public View f1699d;

    enum l {
        DAY,
        YEAR
    }

    interface m {
        void a(long j);
    }

    public static <T> g<T> A(xe<T> dateSelector, int themeResId, a calendarConstraints, ye dayViewDecorator) {
        MaterialCalendar<T> materialCalendar = new g<>();
        Bundle args = new Bundle();
        args.putInt("THEME_RES_ID_KEY", themeResId);
        args.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        args.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        args.putParcelable("DAY_VIEW_DECORATOR_KEY", dayViewDecorator);
        args.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.v());
        materialCalendar.setArguments(args);
        return materialCalendar;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f1687a);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f1694a);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f1690a);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f1695a);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f1693a);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle activeBundle = bundle == null ? getArguments() : bundle;
        this.f1687a = activeBundle.getInt("THEME_RES_ID_KEY");
        this.f1694a = (xe) activeBundle.getParcelable("GRID_SELECTOR_KEY");
        this.f1690a = (a) activeBundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        b6.a(activeBundle.getParcelable("DAY_VIEW_DECORATOR_KEY"));
        this.f1693a = (j) activeBundle.getParcelable("CURRENT_MONTH_KEY");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int orientation;
        int layout;
        f fVar;
        ContextThemeWrapper themedContext = new ContextThemeWrapper(getContext(), this.f1687a);
        this.f1691a = new c(themedContext);
        LayoutInflater themedInflater = layoutInflater.cloneInContext(themedContext);
        j earliestMonth = this.f1690a.w();
        if (h.x(themedContext)) {
            layout = nc0.mtrl_calendar_vertical;
            orientation = 1;
        } else {
            layout = nc0.mtrl_calendar_horizontal;
            orientation = 0;
        }
        View root = themedInflater.inflate(layout, viewGroup, false);
        root.setMinimumHeight(y(requireContext()));
        GridView daysHeader = (GridView) root.findViewById(ic0.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(daysHeader, new c());
        int firstDayOfWeek = this.f1690a.t();
        if (firstDayOfWeek <= 0) {
            fVar = new f();
        }
        daysHeader.setAdapter(fVar);
        daysHeader.setNumColumns(earliestMonth.c);
        daysHeader.setEnabled(false);
        this.f1697b = (RecyclerView) root.findViewById(ic0.mtrl_calendar_months);
        int i2 = firstDayOfWeek;
        d dVar = new d(getContext(), orientation, false, orientation);
        this.f1697b.setLayoutManager(dVar);
        this.f1697b.setTag(a);
        xe<S> xeVar = this.f1694a;
        GridView gridView = daysHeader;
        d dVar2 = dVar;
        View root2 = root;
        a aVar = this.f1690a;
        int i3 = layout;
        j jVar = earliestMonth;
        l lVar = new l(themedContext, xeVar, aVar, this.f1695a, new e());
        this.f1697b.setAdapter(lVar);
        int columns = themedContext.getResources().getInteger(lc0.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) root2.findViewById(ic0.mtrl_calendar_year_selector_frame);
        this.f1689a = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f1689a.setLayoutManager(new GridLayoutManager((Context) themedContext, columns, 1, false));
            this.f1689a.setAdapter(new q(this));
            this.f1689a.addItemDecoration(s());
        }
        if (root2.findViewById(ic0.month_navigation_fragment_toggle) != null) {
            r(root2, lVar);
        }
        if (!h.x(themedContext)) {
            new PagerSnapHelper().attachToRecyclerView(this.f1697b);
        }
        this.f1697b.scrollToPosition(lVar.d(this.f1693a));
        E();
        return root2;
    }

    class c extends AccessibilityDelegateCompat {
        c() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo((Object) null);
        }
    }

    class d extends n {
        final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Context context, int orientation, boolean reverseLayout, int i) {
            super(context, orientation, reverseLayout);
            this.a = i;
        }

        /* access modifiers changed from: protected */
        public void calculateExtraLayoutSpace(RecyclerView.State state, int[] ints) {
            if (this.a == 0) {
                ints[0] = g.this.f1697b.getWidth();
                ints[1] = g.this.f1697b.getWidth();
                return;
            }
            ints[0] = g.this.f1697b.getHeight();
            ints[1] = g.this.f1697b.getHeight();
        }
    }

    class e implements m {
        e() {
        }

        public void a(long day) {
            if (g.this.f1690a.r().g(day)) {
                g.this.f1694a.b(day);
                Iterator it = g.this.a.iterator();
                while (it.hasNext()) {
                    ((s40) it.next()).a(g.this.f1694a.a());
                }
                g.this.f1697b.getAdapter().notifyDataSetChanged();
                if (g.this.f1689a != null) {
                    g.this.f1689a.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    private void E() {
        ViewCompat.setAccessibilityDelegate(this.f1697b, new f());
    }

    class f extends AccessibilityDelegateCompat {
        f() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setScrollable(false);
        }
    }

    /* renamed from: com.google.android.material.datepicker.g$g  reason: collision with other inner class name */
    class C0014g extends RecyclerView.ItemDecoration {

        /* renamed from: a  reason: collision with other field name */
        private final Calendar f1703a = p.k();
        private final Calendar b = p.k();

        C0014g() {
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            int firstHighlightPosition;
            Iterator<Pair<Long, Long>> it;
            Pair<Long, Long> range;
            GridLayoutManager layoutManager;
            q adapter;
            int left;
            int i;
            if ((recyclerView.getAdapter() instanceof q) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                q adapter2 = (q) recyclerView.getAdapter();
                GridLayoutManager layoutManager2 = (GridLayoutManager) recyclerView.getLayoutManager();
                Iterator<Pair<Long, Long>> it2 = g.this.f1694a.c().iterator();
                while (it2.hasNext()) {
                    Pair<Long, Long> range2 = it2.next();
                    F f = range2.first;
                    if (f == null) {
                        GridLayoutManager gridLayoutManager = layoutManager2;
                        Iterator<Pair<Long, Long>> it3 = it2;
                        Pair<Long, Long> pair = range2;
                    } else if (range2.second != null) {
                        this.f1703a.setTimeInMillis(((Long) f).longValue());
                        this.b.setTimeInMillis(((Long) range2.second).longValue());
                        int firstHighlightPosition2 = adapter2.c(this.f1703a.get(1));
                        int lastHighlightPosition = adapter2.c(this.b.get(1));
                        View firstView = layoutManager2.findViewByPosition(firstHighlightPosition2);
                        View lastView = layoutManager2.findViewByPosition(lastHighlightPosition);
                        int firstRow = firstHighlightPosition2 / layoutManager2.getSpanCount();
                        int lastRow = lastHighlightPosition / layoutManager2.getSpanCount();
                        int row = firstRow;
                        while (row <= lastRow) {
                            View viewInRow = layoutManager2.findViewByPosition(layoutManager2.getSpanCount() * row);
                            if (viewInRow == null) {
                                adapter = adapter2;
                                layoutManager = layoutManager2;
                                it = it2;
                                range = range2;
                                firstHighlightPosition = firstHighlightPosition2;
                            } else {
                                int top = viewInRow.getTop() + g.this.f1691a.d.c();
                                adapter = adapter2;
                                int bottom = viewInRow.getBottom() - g.this.f1691a.d.b();
                                if (row != firstRow || firstView == null) {
                                    left = 0;
                                } else {
                                    left = firstView.getLeft() + (firstView.getWidth() / 2);
                                }
                                if (row != lastRow || lastView == null) {
                                    i = recyclerView.getWidth();
                                } else {
                                    i = lastView.getLeft() + (lastView.getWidth() / 2);
                                }
                                int right = i;
                                layoutManager = layoutManager2;
                                int i2 = left;
                                it = it2;
                                int right2 = right;
                                range = range2;
                                int i3 = right2;
                                firstHighlightPosition = firstHighlightPosition2;
                                canvas.drawRect((float) left, (float) top, (float) right2, (float) bottom, g.this.f1691a.a);
                            }
                            row++;
                            adapter2 = adapter;
                            layoutManager2 = layoutManager;
                            range2 = range;
                            it2 = it;
                            firstHighlightPosition2 = firstHighlightPosition;
                        }
                        GridLayoutManager gridLayoutManager2 = layoutManager2;
                        Iterator<Pair<Long, Long>> it4 = it2;
                        Pair<Long, Long> pair2 = range2;
                        int i4 = firstHighlightPosition2;
                    }
                }
            }
        }
    }

    private RecyclerView.ItemDecoration s() {
        return new C0014g();
    }

    /* access modifiers changed from: package-private */
    public j v() {
        return this.f1693a;
    }

    /* access modifiers changed from: package-private */
    public a t() {
        return this.f1690a;
    }

    /* access modifiers changed from: package-private */
    public void C(j moveTo) {
        l adapter = (l) this.f1697b.getAdapter();
        int moveToPosition = adapter.d(moveTo);
        int distance = moveToPosition - adapter.d(this.f1693a);
        boolean isForward = true;
        boolean jump = Math.abs(distance) > 3;
        if (distance <= 0) {
            isForward = false;
        }
        this.f1693a = moveTo;
        if (jump && isForward) {
            this.f1697b.scrollToPosition(moveToPosition - 3);
            B(moveToPosition);
        } else if (jump) {
            this.f1697b.scrollToPosition(moveToPosition + 3);
            B(moveToPosition);
        } else {
            B(moveToPosition);
        }
    }

    public xe<S> w() {
        return this.f1694a;
    }

    /* access modifiers changed from: package-private */
    public c u() {
        return this.f1691a;
    }

    static int x(Context context) {
        return context.getResources().getDimensionPixelSize(cc0.mtrl_calendar_day_height);
    }

    /* access modifiers changed from: package-private */
    public void D(l selector) {
        this.f1692a = selector;
        if (selector == l.YEAR) {
            this.f1689a.getLayoutManager().scrollToPosition(((q) this.f1689a.getAdapter()).c(this.f1693a.b));
            this.f1698c.setVisibility(0);
            this.f1699d.setVisibility(8);
            this.f1688a.setVisibility(8);
            this.f1696b.setVisibility(8);
        } else if (selector == l.DAY) {
            this.f1698c.setVisibility(8);
            this.f1699d.setVisibility(0);
            this.f1688a.setVisibility(0);
            this.f1696b.setVisibility(0);
            C(this.f1693a);
        }
    }

    /* access modifiers changed from: package-private */
    public void F() {
        l lVar = this.f1692a;
        l lVar2 = l.YEAR;
        if (lVar == lVar2) {
            D(l.DAY);
        } else if (lVar == l.DAY) {
            D(lVar2);
        }
    }

    private void r(View root, l monthsPagerAdapter) {
        MaterialButton monthDropSelect = (MaterialButton) root.findViewById(ic0.month_navigation_fragment_toggle);
        monthDropSelect.setTag(d);
        ViewCompat.setAccessibilityDelegate(monthDropSelect, new h());
        View findViewById = root.findViewById(ic0.month_navigation_previous);
        this.f1688a = findViewById;
        findViewById.setTag(b);
        View findViewById2 = root.findViewById(ic0.month_navigation_next);
        this.f1696b = findViewById2;
        findViewById2.setTag(c);
        this.f1698c = root.findViewById(ic0.mtrl_calendar_year_selector_frame);
        this.f1699d = root.findViewById(ic0.mtrl_calendar_day_selector_frame);
        D(l.DAY);
        monthDropSelect.setText(this.f1693a.u());
        this.f1697b.addOnScrollListener(new i(monthsPagerAdapter, monthDropSelect));
        monthDropSelect.setOnClickListener(new j());
        this.f1696b.setOnClickListener(new k(monthsPagerAdapter));
        this.f1688a.setOnClickListener(new a(monthsPagerAdapter));
    }

    class h extends AccessibilityDelegateCompat {
        h() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            String str;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (g.this.f1699d.getVisibility() == 0) {
                str = g.this.getString(sc0.mtrl_picker_toggle_to_year_selection);
            } else {
                str = g.this.getString(sc0.mtrl_picker_toggle_to_day_selection);
            }
            accessibilityNodeInfoCompat.setHintText(str);
        }
    }

    class i extends RecyclerView.OnScrollListener {
        final /* synthetic */ MaterialButton a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ l f1705a;

        i(l lVar, MaterialButton materialButton) {
            this.f1705a = lVar;
            this.a = materialButton;
        }

        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            int currentItem;
            if (dx < 0) {
                currentItem = g.this.z().findFirstVisibleItemPosition();
            } else {
                currentItem = g.this.z().findLastVisibleItemPosition();
            }
            j unused = g.this.f1693a = this.f1705a.b(currentItem);
            this.a.setText(this.f1705a.c(currentItem));
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            if (newState == 0) {
                CharSequence announcementText = this.a.getText();
                if (Build.VERSION.SDK_INT >= 16) {
                    recyclerView.announceForAccessibility(announcementText);
                } else {
                    recyclerView.sendAccessibilityEvent(2048);
                }
            }
        }
    }

    class j implements View.OnClickListener {
        j() {
        }

        public void onClick(View view) {
            g.this.F();
        }
    }

    class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ l f1706a;

        k(l lVar) {
            this.f1706a = lVar;
        }

        public void onClick(View view) {
            int currentItem = g.this.z().findFirstVisibleItemPosition();
            if (currentItem + 1 < g.this.f1697b.getAdapter().getItemCount()) {
                g.this.C(this.f1706a.b(currentItem + 1));
            }
        }
    }

    class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ l f1700a;

        a(l lVar) {
            this.f1700a = lVar;
        }

        public void onClick(View view) {
            int currentItem = g.this.z().findLastVisibleItemPosition();
            if (currentItem - 1 >= 0) {
                g.this.C(this.f1700a.b(currentItem - 1));
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ int a;

        b(int i) {
            this.a = i;
        }

        public void run() {
            g.this.f1697b.smoothScrollToPosition(this.a);
        }
    }

    private void B(int position) {
        this.f1697b.post(new b(position));
    }

    private static int y(Context context) {
        Resources resources = context.getResources();
        int navigationHeight = resources.getDimensionPixelSize(cc0.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(cc0.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(cc0.mtrl_calendar_navigation_bottom_padding);
        int daysOfWeekHeight = resources.getDimensionPixelSize(cc0.mtrl_calendar_days_of_week_height);
        int i2 = k.a;
        return navigationHeight + daysOfWeekHeight + (resources.getDimensionPixelSize(cc0.mtrl_calendar_day_height) * i2) + ((i2 - 1) * resources.getDimensionPixelOffset(cc0.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(cc0.mtrl_calendar_bottom_padding);
    }

    /* access modifiers changed from: package-private */
    public LinearLayoutManager z() {
        return (LinearLayoutManager) this.f1697b.getLayoutManager();
    }

    public boolean i(s40<S> listener) {
        return super.i(listener);
    }
}
