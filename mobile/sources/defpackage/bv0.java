package defpackage;

import android.util.Log;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: bv0  reason: default package */
public class bv0 extends RecyclerView.OnScrollListener implements RecyclerView.OnItemTouchListener {
    private static final String a = bv0.class.getSimpleName();

    /* renamed from: a  reason: collision with other field name */
    private float f271a = 0.0f;

    /* renamed from: a  reason: collision with other field name */
    private int f272a;

    /* renamed from: a  reason: collision with other field name */
    private a8 f273a;

    /* renamed from: a  reason: collision with other field name */
    private RecyclerView f274a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f275a;
    private float b = 0.0f;

    /* renamed from: b  reason: collision with other field name */
    private a8 f276b;

    /* renamed from: b  reason: collision with other field name */
    private RecyclerView f277b = null;

    public bv0(or tableView) {
        this.f273a = tableView.getRowHeaderRecyclerView();
        this.f276b = tableView.getCellRecyclerView();
    }

    private boolean b(MotionEvent ev) {
        if (ev.getAction() != 2) {
            return true;
        }
        if (this.f271a == 0.0f) {
            this.f271a = ev.getX();
        }
        if (this.b == 0.0f) {
            this.b = ev.getY();
        }
        float xdiff = Math.abs(this.f271a - ev.getX());
        float ydiff = Math.abs(this.b - ev.getY());
        this.f271a = ev.getX();
        this.b = ev.getY();
        if (xdiff > ydiff) {
            return false;
        }
        return true;
    }

    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        if (!b(e)) {
            this.f277b = null;
            return false;
        }
        RecyclerView recyclerView = this.f277b;
        if (recyclerView != null && rv != recyclerView) {
            return true;
        }
        if (e.getAction() == 0) {
            this.f277b = rv;
            if (rv.getScrollState() == 0) {
                RecyclerView recyclerView2 = this.f274a;
                if (!(recyclerView2 == null || rv == recyclerView2)) {
                    a(false);
                }
                this.f272a = ((a8) rv).getScrolledY();
                rv.addOnScrollListener(this);
                if (rv == this.f276b) {
                    Log.d(a, "mCellRecyclerView scroll listener added");
                } else if (rv == this.f273a) {
                    Log.d(a, "mRowHeaderRecyclerView scroll listener added");
                }
                this.f275a = false;
            }
        } else if (e.getAction() == 2) {
            this.f277b = rv;
            this.f275a = true;
        } else if (e.getAction() == 1) {
            this.f277b = null;
            if (this.f272a == ((a8) rv).getScrolledY() && !this.f275a && rv.getScrollState() == 0) {
                rv.removeOnScrollListener(this);
                if (rv == this.f276b) {
                    Log.d(a, "mCellRecyclerView scroll listener removed from up ");
                } else if (rv == this.f273a) {
                    Log.d(a, "mRowHeaderRecyclerView scroll listener removed from up");
                }
            }
            this.f274a = rv;
        }
        return false;
    }

    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
    }

    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        if (recyclerView == this.f276b) {
            super.onScrolled(recyclerView, dx, dy);
        } else if (recyclerView == this.f273a) {
            super.onScrolled(recyclerView, dx, dy);
            this.f276b.scrollBy(0, dy);
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        if (newState == 0) {
            recyclerView.removeOnScrollListener(this);
            this.f275a = false;
            this.f277b = null;
            if (recyclerView == this.f276b) {
                Log.d(a, "mCellRecyclerView scroll listener removed from onScrollStateChanged");
            } else if (recyclerView == this.f273a) {
                Log.d(a, "mRowHeaderRecyclerView scroll listener removed from onScrollStateChanged");
            }
        }
    }

    public void a(boolean isNeeded) {
        RecyclerView recyclerView = this.f274a;
        a8 a8Var = this.f276b;
        if (recyclerView == a8Var) {
            a8Var.removeOnScrollListener(this);
            this.f276b.stopScroll();
            Log.d(a, "mCellRecyclerView scroll listener removed from last touched");
            return;
        }
        this.f273a.removeOnScrollListener(this);
        this.f273a.stopScroll();
        String str = a;
        Log.d(str, "mRowHeaderRecyclerView scroll listener removed from last touched");
        if (isNeeded) {
            this.f276b.removeOnScrollListener(this);
            this.f276b.stopScroll();
            Log.d(str, "mCellRecyclerView scroll listener removed from last touched");
        }
    }
}
