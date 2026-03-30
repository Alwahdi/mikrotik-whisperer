package defpackage;

import android.util.Log;
import android.view.MotionEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: rq  reason: default package */
public class rq extends RecyclerView.OnScrollListener implements RecyclerView.OnItemTouchListener {
    private static final String a = rq.class.getSimpleName();

    /* renamed from: a  reason: collision with other field name */
    private int f4927a;

    /* renamed from: a  reason: collision with other field name */
    private a8 f4928a;

    /* renamed from: a  reason: collision with other field name */
    private RecyclerView.LayoutManager f4929a;

    /* renamed from: a  reason: collision with other field name */
    private RecyclerView f4930a;

    /* renamed from: a  reason: collision with other field name */
    private bv0 f4931a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f4932a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private RecyclerView f4933b = null;
    private int c = 0;

    public rq(or tableView) {
        this.f4928a = tableView.getColumnHeaderRecyclerView();
        this.f4929a = tableView.getCellRecyclerView().getLayoutManager();
        this.f4931a = tableView.getVerticalRecyclerViewListener();
    }

    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        RecyclerView recyclerView = this.f4933b;
        if (recyclerView != null && rv != recyclerView) {
            return true;
        }
        if (e.getAction() == 0) {
            this.f4933b = rv;
            if (rv.getScrollState() == 0) {
                RecyclerView recyclerView2 = this.f4930a;
                if (!(recyclerView2 == null || rv == recyclerView2)) {
                    a8 a8Var = this.f4928a;
                    if (recyclerView2 == a8Var) {
                        a8Var.removeOnScrollListener(this);
                        this.f4928a.stopScroll();
                        Log.d(a, "Scroll listener  has been removed to mColumnHeaderRecyclerView at last touch control");
                    } else {
                        int lastTouchedIndex = a(recyclerView2);
                        if (lastTouchedIndex >= 0 && lastTouchedIndex < this.f4929a.getChildCount() && !((a8) this.f4930a).b()) {
                            ((RecyclerView) this.f4929a.getChildAt(lastTouchedIndex)).removeOnScrollListener(this);
                            String str = a;
                            Log.d(str, "Scroll listener  has been removed to " + this.f4930a.getId() + " CellRecyclerView " + "at last touch control");
                            ((RecyclerView) this.f4929a.getChildAt(lastTouchedIndex)).stopScroll();
                        }
                    }
                }
                this.f4927a = ((a8) rv).getScrolledX();
                rv.addOnScrollListener(this);
                String str2 = a;
                Log.d(str2, "Scroll listener  has been added to " + rv.getId() + " at action " + "down");
            }
        } else if (e.getAction() == 2) {
            this.f4933b = rv;
            this.f4932a = true;
        } else if (e.getAction() == 1) {
            this.f4933b = null;
            if (this.f4927a == ((a8) rv).getScrolledX() && !this.f4932a) {
                rv.removeOnScrollListener(this);
                String str3 = a;
                Log.d(str3, "Scroll listener  has been removed to " + rv.getId() + " at " + "action" + " up");
            }
            this.f4930a = rv;
        } else if (e.getAction() == 3) {
            d(rv);
            rv.removeOnScrollListener(this);
            String str4 = a;
            Log.d(str4, "Scroll listener  has been removed to " + rv.getId() + " at action " + "cancel");
            this.f4932a = false;
            this.f4930a = rv;
            this.f4933b = null;
        }
        return false;
    }

    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
    }

    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        if (recyclerView == this.f4928a) {
            super.onScrolled(recyclerView, dx, dy);
            for (int i = 0; i < this.f4929a.getChildCount(); i++) {
                ((a8) this.f4929a.getChildAt(i)).scrollBy(dx, 0);
            }
            return;
        }
        super.onScrolled(recyclerView, dx, dy);
        for (int i2 = 0; i2 < this.f4929a.getChildCount(); i2++) {
            a8 child = (a8) this.f4929a.getChildAt(i2);
            if (child != recyclerView) {
                child.scrollBy(dx, 0);
            }
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        if (newState == 0) {
            d(recyclerView);
            recyclerView.removeOnScrollListener(this);
            String str = a;
            Log.d(str, "Scroll listener has been removed to " + recyclerView.getId() + " at " + "onScrollStateChanged");
            boolean isNeeded = false;
            this.f4932a = false;
            if (this.f4930a != this.f4928a) {
                isNeeded = true;
            }
            this.f4931a.a(isNeeded);
        }
    }

    private int a(RecyclerView rv) {
        for (int i = 0; i < this.f4929a.getChildCount(); i++) {
            if (this.f4929a.getChildAt(i) == rv) {
                return i;
            }
        }
        return -1;
    }

    private void d(RecyclerView recyclerView) {
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int findFirstCompletelyVisibleItemPosition = layoutManager.findFirstCompletelyVisibleItemPosition();
        this.b = findFirstCompletelyVisibleItemPosition;
        if (findFirstCompletelyVisibleItemPosition == -1) {
            int findFirstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
            this.b = findFirstVisibleItemPosition;
            if (findFirstVisibleItemPosition != layoutManager.findLastVisibleItemPosition()) {
                this.b++;
            }
        }
        this.c = layoutManager.findViewByPosition(this.b).getLeft();
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public void f(int offset) {
        this.c = offset;
    }

    public void e(int position) {
        this.b = position;
    }
}
