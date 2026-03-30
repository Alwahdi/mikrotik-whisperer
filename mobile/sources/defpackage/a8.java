package defpackage;

import android.content.Context;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: a8  reason: default package */
public class a8 extends RecyclerView {
    private static final String a = a8.class.getSimpleName();

    /* renamed from: a  reason: collision with other field name */
    private int f30a = 0;

    /* renamed from: a  reason: collision with other field name */
    private boolean f31a = true;
    private int b = 0;

    /* renamed from: b  reason: collision with other field name */
    private boolean f32b = true;

    public a8(Context context) {
        super(context);
        setHasFixedSize(false);
        setNestedScrollingEnabled(false);
        setItemViewCacheSize(context.getResources().getInteger(mc0.default_item_cache_size));
        setDrawingCacheEnabled(true);
        setDrawingCacheQuality(1048576);
    }

    public void onScrolled(int dx, int dy) {
        this.f30a += dx;
        this.b += dy;
        super.onScrolled(dx, dy);
    }

    public int getScrolledX() {
        return this.f30a;
    }

    public void a() {
        this.f30a = 0;
    }

    public int getScrolledY() {
        return this.b;
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener listener) {
        if (listener instanceof rq) {
            if (this.f31a) {
                this.f31a = false;
                super.addOnScrollListener(listener);
                return;
            }
            Log.w(a, "mIsHorizontalScrollListenerRemoved has been tried to add itself before remove the old one");
        } else if (!(listener instanceof bv0)) {
            super.addOnScrollListener(listener);
        } else if (this.f32b) {
            this.f32b = false;
            super.addOnScrollListener(listener);
        } else {
            Log.w(a, "mIsVerticalScrollListenerRemoved has been tried to add itself before remove the old one");
        }
    }

    public void removeOnScrollListener(RecyclerView.OnScrollListener listener) {
        if (listener instanceof rq) {
            if (this.f31a) {
                Log.e(a, "HorizontalRecyclerViewListener has been tried to remove itself before add new one");
                return;
            }
            this.f31a = true;
            super.removeOnScrollListener(listener);
        } else if (!(listener instanceof bv0)) {
            super.removeOnScrollListener(listener);
        } else if (this.f32b) {
            Log.e(a, "mIsVerticalScrollListenerRemoved has been tried to remove itself before add new one");
        } else {
            this.f32b = true;
            super.removeOnScrollListener(listener);
        }
    }

    public boolean b() {
        return this.f31a;
    }

    public boolean c() {
        return !this.f31a;
    }

    public boolean fling(int velocityX, int velocityY) {
        return super.fling(velocityX, velocityY);
    }
}
