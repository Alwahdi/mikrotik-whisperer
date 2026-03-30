package defpackage;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: q  reason: default package */
public abstract class q implements RecyclerView.OnItemTouchListener {
    protected a8 a;

    /* renamed from: a  reason: collision with other field name */
    protected GestureDetector f4738a = new GestureDetector(this.a.getContext(), new a());

    /* renamed from: a  reason: collision with other field name */
    protected or f4739a;

    /* renamed from: a  reason: collision with other field name */
    private pr f4740a;

    /* renamed from: a  reason: collision with other field name */
    protected yj0 f4741a;

    /* access modifiers changed from: protected */
    public abstract boolean a(RecyclerView recyclerView, MotionEvent motionEvent);

    /* access modifiers changed from: protected */
    public abstract void c(MotionEvent motionEvent);

    public q(a8 recyclerView, or tableView) {
        this.a = recyclerView;
        this.f4739a = tableView;
        this.f4741a = tableView.getSelectionHandler();
    }

    /* renamed from: q$a */
    class a extends GestureDetector.SimpleOnGestureListener {
        MotionEvent a;

        a() {
        }

        public boolean onSingleTapUp(MotionEvent e) {
            return true;
        }

        public boolean onDown(MotionEvent e) {
            this.a = e;
            return false;
        }

        public void onLongPress(MotionEvent e) {
            MotionEvent motionEvent = this.a;
            if (motionEvent != null && Math.abs(motionEvent.getRawX() - e.getRawX()) < 20.0f && Math.abs(this.a.getRawY() - e.getRawY()) < 20.0f) {
                q.this.c(e);
            }
        }
    }

    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        return a(view, e);
    }

    public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
    }

    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }

    /* access modifiers changed from: protected */
    public pr b() {
        if (this.f4740a == null) {
            this.f4740a = this.f4739a.getTableViewListener();
        }
        return this.f4740a;
    }
}
