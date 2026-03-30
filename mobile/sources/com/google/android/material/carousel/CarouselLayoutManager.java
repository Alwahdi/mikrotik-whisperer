package com.google.android.material.carousel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.graphics.ColorUtils;
import androidx.core.math.MathUtils;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CarouselLayoutManager extends RecyclerView.LayoutManager implements b, RecyclerView.SmoothScroller.ScrollVectorProvider {
    int a;

    /* renamed from: a  reason: collision with other field name */
    private final View.OnLayoutChangeListener f1576a;

    /* renamed from: a  reason: collision with other field name */
    private final c f1577a;

    /* renamed from: a  reason: collision with other field name */
    private c f1578a;

    /* renamed from: a  reason: collision with other field name */
    private d f1579a;

    /* renamed from: a  reason: collision with other field name */
    private f f1580a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public g f1581a;

    /* renamed from: a  reason: collision with other field name */
    private Map<Integer, f> f1582a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f1583a;
    int b;
    int c;
    private int d;
    private int e;
    private int f;
    private int g;

    /* access modifiers changed from: private */
    public /* synthetic */ void P(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        if (left != oldLeft || top != oldTop || right != oldRight || bottom != oldBottom) {
            v.post(new y7(this));
        }
    }

    private static final class b {
        final float a;

        /* renamed from: a  reason: collision with other field name */
        final View f1584a;

        /* renamed from: a  reason: collision with other field name */
        final d f1585a;
        final float b;

        b(View child, float center, float offsetCenter, d range) {
            this.f1584a = child;
            this.a = center;
            this.b = offsetCenter;
            this.f1585a = range;
        }
    }

    public CarouselLayoutManager() {
        this(new h());
    }

    public CarouselLayoutManager(d strategy) {
        this(strategy, 0);
    }

    public CarouselLayoutManager(d strategy, int orientation) {
        this.f1583a = false;
        this.f1577a = new c();
        this.d = 0;
        this.f1576a = new x7(this);
        this.f = -1;
        this.g = 0;
        Z(strategy);
        setOrientation(orientation);
    }

    public CarouselLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.f1583a = false;
        this.f1577a = new c();
        this.d = 0;
        this.f1576a = new x7(this);
        this.f = -1;
        this.g = 0;
        Z(new h());
        Y(context, attrs);
    }

    private void Y(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a2 = context.obtainStyledAttributes(attrs, xc0.f5595B);
            X(a2.getInt(xc0.k0, 0));
            setOrientation(a2.getInt(xc0.y3, 0));
            a2.recycle();
        }
    }

    public void X(int alignment) {
        this.g = alignment;
        U();
    }

    public int d() {
        return this.g;
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public void Z(d carouselStrategy) {
        this.f1579a = carouselStrategy;
        U();
    }

    public void onAttachedToWindow(RecyclerView view) {
        super.onAttachedToWindow(view);
        U();
        view.addOnLayoutChangeListener(this.f1576a);
    }

    public void onDetachedFromWindow(RecyclerView view, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(view, recycler);
        view.removeOnLayoutChangeListener(this.f1576a);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.getItemCount() <= 0 || ((float) y()) <= 0.0f) {
            removeAndRecycleAllViews(recycler);
            this.d = 0;
            return;
        }
        boolean isRtl = M();
        boolean isInitialLoad = this.f1581a == null;
        if (isInitialLoad) {
            T(recycler);
        }
        int startScroll = w(this.f1581a);
        int endScroll = t(state, this.f1581a);
        this.b = isRtl ? endScroll : startScroll;
        this.c = isRtl ? startScroll : endScroll;
        if (isInitialLoad) {
            this.a = startScroll;
            this.f1582a = this.f1581a.i(getItemCount(), this.b, this.c, M());
            int i = this.f;
            if (i != -1) {
                this.a = J(i, A(i));
            }
        }
        int i2 = this.a;
        this.a = i2 + v(0, i2, this.b, this.c);
        this.d = MathUtils.clamp(this.d, 0, state.getItemCount());
        b0(this.f1581a);
        detachAndScrapAttachedViews(recycler);
        x(recycler, state);
        this.e = getItemCount();
    }

    private void T(RecyclerView.Recycler recycler) {
        View firstChild = recycler.getViewForPosition(0);
        measureChildWithMargins(firstChild, 0, 0);
        f keylineState = this.f1579a.c(this, firstChild);
        this.f1581a = g.f(this, M() ? f.m(keylineState, (float) y()) : keylineState);
    }

    /* access modifiers changed from: private */
    public void U() {
        this.f1581a = null;
        requestLayout();
    }

    private void x(RecyclerView.Recycler recycler, RecyclerView.State state) {
        V(recycler);
        if (getChildCount() == 0) {
            q(recycler, this.d - 1);
            p(recycler, state, this.d);
        } else {
            int firstPosition = getPosition(getChildAt(0));
            int lastPosition = getPosition(getChildAt(getChildCount() - 1));
            q(recycler, firstPosition - 1);
            p(recycler, state, lastPosition + 1);
        }
        d0();
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        if (getChildCount() == 0) {
            this.d = 0;
        } else {
            this.d = getPosition(getChildAt(0));
        }
        d0();
    }

    private void q(RecyclerView.Recycler recycler, int startPosition) {
        float start = s(startPosition);
        int i = startPosition;
        while (i >= 0) {
            b calculations = R(recycler, start, i);
            if (!O(calculations.b, calculations.f1585a)) {
                start = n(start, this.f1580a.f());
                if (!N(calculations.b, calculations.f1585a)) {
                    l(calculations.f1584a, 0, calculations);
                }
                i--;
            } else {
                return;
            }
        }
    }

    private void o(RecyclerView.Recycler recycler, int startPosition, int childIndex) {
        if (startPosition >= 0 && startPosition < getItemCount()) {
            b calculations = R(recycler, s(startPosition), startPosition);
            l(calculations.f1584a, childIndex, calculations);
        }
    }

    private void p(RecyclerView.Recycler recycler, RecyclerView.State state, int startPosition) {
        float start = s(startPosition);
        int i = startPosition;
        while (i < state.getItemCount()) {
            b calculations = R(recycler, start, i);
            if (!N(calculations.b, calculations.f1585a)) {
                start = m(start, this.f1580a.f());
                if (!O(calculations.b, calculations.f1585a)) {
                    l(calculations.f1584a, -1, calculations);
                }
                i++;
            } else {
                return;
            }
        }
    }

    private void Q() {
        if (this.f1583a && Log.isLoggable("CarouselLayoutManager", 3)) {
            Log.d("CarouselLayoutManager", "internal representation of views on the screen");
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                float center = z(child);
                Log.d("CarouselLayoutManager", "item position " + getPosition(child) + ", center:" + center + ", child index:" + i);
            }
            Log.d("CarouselLayoutManager", "==============");
        }
    }

    private void d0() {
        if (this.f1583a && getChildCount() >= 1) {
            int i = 0;
            while (i < getChildCount() - 1) {
                int currPos = getPosition(getChildAt(i));
                int nextPos = getPosition(getChildAt(i + 1));
                if (currPos <= nextPos) {
                    i++;
                } else {
                    Q();
                    throw new IllegalStateException("Detected invalid child order. Child at index [" + i + "] had adapter position [" + currPos + "] and child at index [" + (i + 1) + "] had adapter position [" + nextPos + "].");
                }
            }
        }
    }

    private b R(RecyclerView.Recycler recycler, float start, int position) {
        View child = recycler.getViewForPosition(position);
        measureChildWithMargins(child, 0, 0);
        float center = m(start, this.f1580a.f() / 2.0f);
        d range = L(this.f1580a.g(), center, false);
        return new b(child, center, r(child, center, range), range);
    }

    private void l(View child, int index, b calculations) {
        float halfItemSize = this.f1580a.f() / 2.0f;
        addView(child, index);
        float f2 = calculations.b;
        this.f1578a.k(child, (int) (f2 - halfItemSize), (int) (f2 + halfItemSize));
        a0(child, calculations.a, calculations.f1585a);
    }

    private boolean O(float locOffset, d range) {
        float maskedEnd = m(locOffset, B(locOffset, range) / 2.0f);
        if (M()) {
            if (maskedEnd > ((float) y())) {
                return true;
            }
        } else if (maskedEnd < 0.0f) {
            return true;
        }
        return false;
    }

    public boolean b() {
        return this.f1578a.a == 0;
    }

    private boolean N(float locOffset, d range) {
        float maskedStart = n(locOffset, B(locOffset, range) / 2.0f);
        if (M()) {
            if (maskedStart < 0.0f) {
                return true;
            }
        } else if (maskedStart > ((float) y())) {
            return true;
        }
        return false;
    }

    public void getDecoratedBoundsWithMargins(View view, Rect outBounds) {
        super.getDecoratedBoundsWithMargins(view, outBounds);
        float center = (float) outBounds.centerY();
        if (b()) {
            center = (float) outBounds.centerX();
        }
        float maskedSize = B(center, L(this.f1580a.g(), center, true));
        float f2 = 0.0f;
        float deltaX = b() ? (((float) outBounds.width()) - maskedSize) / 2.0f : 0.0f;
        if (!b()) {
            f2 = (((float) outBounds.height()) - maskedSize) / 2.0f;
        }
        float deltaY = f2;
        outBounds.set((int) (((float) outBounds.left) + deltaX), (int) (((float) outBounds.top) + deltaY), (int) (((float) outBounds.right) - deltaX), (int) (((float) outBounds.bottom) - deltaY));
    }

    private float z(View child) {
        Rect bounds = new Rect();
        super.getDecoratedBoundsWithMargins(child, bounds);
        if (b()) {
            return (float) bounds.centerX();
        }
        return (float) bounds.centerY();
    }

    private void V(RecyclerView.Recycler recycler) {
        while (getChildCount() > 0) {
            View child = getChildAt(0);
            float center = z(child);
            if (!O(center, L(this.f1580a.g(), center, true))) {
                break;
            }
            removeAndRecycleView(child, recycler);
        }
        while (getChildCount() - 1 >= 0) {
            View child2 = getChildAt(getChildCount() - 1);
            float center2 = z(child2);
            if (N(center2, L(this.f1580a.g(), center2, true))) {
                removeAndRecycleView(child2, recycler);
            } else {
                return;
            }
        }
    }

    private static d L(List<f.c> keylines, float location, boolean isOffset) {
        int startMinDistanceIndex = -1;
        float startMinDistance = Float.MAX_VALUE;
        int startMostIndex = -1;
        float startMostX = Float.MAX_VALUE;
        int endMinDistanceIndex = -1;
        float endMinDistance = Float.MAX_VALUE;
        int endMostIndex = -1;
        float endMostX = -3.4028235E38f;
        for (int i = 0; i < keylines.size(); i++) {
            f.c keyline = keylines.get(i);
            float currentLoc = isOffset ? keyline.b : keyline.a;
            float delta = Math.abs(currentLoc - location);
            if (currentLoc <= location && delta <= startMinDistance) {
                startMinDistance = delta;
                startMinDistanceIndex = i;
            }
            if (currentLoc > location && delta <= endMinDistance) {
                endMinDistance = delta;
                endMinDistanceIndex = i;
            }
            if (currentLoc <= startMostX) {
                startMostIndex = i;
                startMostX = currentLoc;
            }
            if (currentLoc > endMostX) {
                endMostIndex = i;
                endMostX = currentLoc;
            }
        }
        if (startMinDistanceIndex == -1) {
            startMinDistanceIndex = startMostIndex;
        }
        if (endMinDistanceIndex == -1) {
            endMinDistanceIndex = endMostIndex;
        }
        return new d(keylines.get(startMinDistanceIndex), keylines.get(endMinDistanceIndex));
    }

    private void b0(g keylineStateList) {
        int i = this.c;
        int i2 = this.b;
        if (i <= i2) {
            this.f1580a = M() ? keylineStateList.h() : keylineStateList.l();
        } else {
            this.f1580a = keylineStateList.j((float) this.a, (float) i2, (float) i);
        }
        this.f1577a.a(this.f1580a.g());
    }

    private static int v(int delta, int currentScroll, int minScroll, int maxScroll) {
        int targetScroll = currentScroll + delta;
        if (targetScroll < minScroll) {
            return minScroll - currentScroll;
        }
        if (targetScroll > maxScroll) {
            return maxScroll - currentScroll;
        }
        return delta;
    }

    private int w(g stateList) {
        boolean isRtl = M();
        f startState = isRtl ? stateList.h() : stateList.l();
        return (int) ((((float) H()) + ((float) (getPaddingStart() * (isRtl ? 1 : -1)))) - n((isRtl ? startState.h() : startState.a()).a, startState.f() / 2.0f));
    }

    private int t(RecyclerView.State state, g stateList) {
        boolean isRtl = M();
        f endState = isRtl ? stateList.l() : stateList.h();
        f.c endFocalKeyline = isRtl ? endState.a() : endState.h();
        int endScroll = (int) (((((((float) (state.getItemCount() - 1)) * endState.f()) + ((float) getPaddingEnd())) * (isRtl ? -1.0f : 1.0f)) - (endFocalKeyline.a - ((float) H()))) + (((float) E()) - endFocalKeyline.a));
        return isRtl ? Math.min(0, endScroll) : Math.max(0, endScroll);
    }

    private float s(int startPosition) {
        return m((float) (H() - this.a), this.f1580a.f() * ((float) startPosition));
    }

    private float r(View child, float childCenterLocation, d range) {
        f.c cVar = range.a;
        float f2 = cVar.b;
        f.c cVar2 = range.b;
        float offsetCenter = f3.b(f2, cVar2.b, cVar.a, cVar2.a, childCenterLocation);
        if (range.b != this.f1580a.c() && range.a != this.f1580a.j()) {
            return offsetCenter;
        }
        float marginMask = this.f1578a.d((RecyclerView.LayoutParams) child.getLayoutParams()) / this.f1580a.f();
        f.c cVar3 = range.b;
        return offsetCenter + ((childCenterLocation - cVar3.a) * ((1.0f - cVar3.c) + marginMask));
    }

    private float B(float locOffset, d range) {
        f.c cVar = range.a;
        float f2 = cVar.d;
        f.c cVar2 = range.b;
        return f3.b(f2, cVar2.d, cVar.b, cVar2.b, locOffset);
    }

    private void a0(View child, float childCenterLocation, d range) {
    }

    public void measureChildWithMargins(View child, int widthUsed, int heightUsed) {
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    /* access modifiers changed from: private */
    public int F() {
        return this.f1578a.g();
    }

    private int H() {
        return this.f1578a.i();
    }

    /* access modifiers changed from: private */
    public int G() {
        return this.f1578a.h();
    }

    private int E() {
        return this.f1578a.f();
    }

    /* access modifiers changed from: private */
    public int I() {
        return this.f1578a.j();
    }

    /* access modifiers changed from: private */
    public int D() {
        return this.f1578a.e();
    }

    public int a() {
        return getWidth();
    }

    public int c() {
        return getHeight();
    }

    private int y() {
        if (b()) {
            return a();
        }
        return c();
    }

    /* access modifiers changed from: package-private */
    public boolean M() {
        return b() && getLayoutDirection() == 1;
    }

    private float n(float value, float amount) {
        return M() ? value + amount : value - amount;
    }

    private float m(float value, float amount) {
        return M() ? value - amount : value + amount;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        if (getChildCount() > 0) {
            event.setFromIndex(getPosition(getChildAt(0)));
            event.setToIndex(getPosition(getChildAt(getChildCount() - 1)));
        }
    }

    private int J(int position, f keylineState) {
        if (M()) {
            return (int) (((((float) y()) - keylineState.h().a) - (((float) position) * keylineState.f())) - (keylineState.f() / 2.0f));
        }
        return (int) (((((float) position) * keylineState.f()) - keylineState.a().a) + (keylineState.f() / 2.0f));
    }

    private int K(int position, f keylineState) {
        int positionOffsetDistanceFromKeyline;
        int smallestScrollOffset = Integer.MAX_VALUE;
        for (f.c keyline : keylineState.e()) {
            float offsetWithKeylines = (((float) position) * keylineState.f()) + (keylineState.f() / 2.0f);
            if (M()) {
                positionOffsetDistanceFromKeyline = (int) ((((float) y()) - keyline.a) - offsetWithKeylines);
            } else {
                positionOffsetDistanceFromKeyline = (int) (offsetWithKeylines - keyline.a);
            }
            int positionOffsetDistanceFromKeyline2 = positionOffsetDistanceFromKeyline - this.a;
            if (Math.abs(smallestScrollOffset) > Math.abs(positionOffsetDistanceFromKeyline2)) {
                smallestScrollOffset = positionOffsetDistanceFromKeyline2;
            }
        }
        return smallestScrollOffset;
    }

    public PointF computeScrollVectorForPosition(int targetPosition) {
        if (this.f1581a == null) {
            return null;
        }
        int offset = C(targetPosition, A(targetPosition));
        if (b()) {
            return new PointF((float) offset, 0.0f);
        }
        return new PointF(0.0f, (float) offset);
    }

    /* access modifiers changed from: package-private */
    public int C(int position, f keylineState) {
        return J(position, keylineState) - this.a;
    }

    private f A(int position) {
        f keylineState;
        Map<Integer, f> map = this.f1582a;
        if (map == null || (keylineState = map.get(Integer.valueOf(MathUtils.clamp(position, 0, Math.max(0, getItemCount() - 1))))) == null) {
            return this.f1581a.g();
        }
        return keylineState;
    }

    public void scrollToPosition(int position) {
        this.f = position;
        if (this.f1581a != null) {
            this.a = J(position, A(position));
            this.d = MathUtils.clamp(position, 0, Math.max(0, getItemCount() - 1));
            b0(this.f1581a);
            requestLayout();
        }
    }

    class a extends LinearSmoothScroller {
        a(Context context) {
            super(context);
        }

        public PointF computeScrollVectorForPosition(int targetPosition) {
            return CarouselLayoutManager.this.computeScrollVectorForPosition(targetPosition);
        }

        public int calculateDxToMakeVisible(View view, int snapPreference) {
            if (CarouselLayoutManager.this.f1581a == null || !CarouselLayoutManager.this.b()) {
                return 0;
            }
            CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
            return carouselLayoutManager.u(carouselLayoutManager.getPosition(view));
        }

        public int calculateDyToMakeVisible(View view, int snapPreference) {
            if (CarouselLayoutManager.this.f1581a == null || CarouselLayoutManager.this.b()) {
                return 0;
            }
            CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
            return carouselLayoutManager.u(carouselLayoutManager.getPosition(view));
        }
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        LinearSmoothScroller linearSmoothScroller = new a(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(position);
        startSmoothScroll(linearSmoothScroller);
    }

    /* access modifiers changed from: package-private */
    public int u(int position) {
        return (int) (((float) this.a) - ((float) J(position, A(position))));
    }

    public boolean canScrollHorizontally() {
        return b();
    }

    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (canScrollHorizontally()) {
            return scrollBy(dx, recycler, state);
        }
        return 0;
    }

    public boolean canScrollVertically() {
        return !b();
    }

    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (canScrollVertically()) {
            return scrollBy(dy, recycler, state);
        }
        return 0;
    }

    private int convertFocusDirectionToLayoutDirection(int focusDirection) {
        int orientation = getOrientation();
        switch (focusDirection) {
            case 1:
                return -1;
            case 2:
                return 1;
            case 17:
                if (orientation != 0) {
                    return Integer.MIN_VALUE;
                }
                if (M()) {
                    return 1;
                }
                return -1;
            case 33:
                if (orientation == 1) {
                    return -1;
                }
                return Integer.MIN_VALUE;
            case 66:
                if (orientation != 0) {
                    return Integer.MIN_VALUE;
                }
                if (M()) {
                    return -1;
                }
                return 1;
            case 130:
                if (orientation == 1) {
                    return 1;
                }
                return Integer.MIN_VALUE;
            default:
                Log.d("CarouselLayoutManager", "Unknown focus request:" + focusDirection);
                return Integer.MIN_VALUE;
        }
    }

    public View onFocusSearchFailed(View focused, int focusDirection, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int layoutDir;
        if (getChildCount() == 0 || (layoutDir = convertFocusDirectionToLayoutDirection(focusDirection)) == Integer.MIN_VALUE) {
            return null;
        }
        if (layoutDir == -1) {
            if (getPosition(focused) == 0) {
                return null;
            }
            o(recycler, getPosition(getChildAt(0)) - 1, 0);
            return getChildClosestToStart();
        } else if (getPosition(focused) == getItemCount() - 1) {
            return null;
        } else {
            o(recycler, getPosition(getChildAt(getChildCount() - 1)) + 1, -1);
            return getChildClosestToEnd();
        }
    }

    private View getChildClosestToStart() {
        return getChildAt(M() ? getChildCount() - 1 : 0);
    }

    private View getChildClosestToEnd() {
        return getChildAt(M() ? 0 : getChildCount() - 1);
    }

    public boolean requestChildRectangleOnScreen(RecyclerView parent, View child, Rect rect, boolean immediate, boolean focusedChildVisible) {
        int delta;
        if (this.f1581a == null || (delta = K(getPosition(child), A(getPosition(child)))) == 0) {
            return false;
        }
        W(parent, K(getPosition(child), this.f1581a.j((float) (this.a + v(delta, this.a, this.b, this.c)), (float) this.b, (float) this.c)));
        return true;
    }

    private void W(RecyclerView recyclerView, int delta) {
        if (b()) {
            recyclerView.scrollBy(delta, 0);
        } else {
            recyclerView.scrollBy(0, delta);
        }
    }

    private int scrollBy(int distance, RecyclerView.Recycler recycler, RecyclerView.State state) {
        float firstFocalKeylineLoc;
        if (getChildCount() == 0 || distance == 0) {
            return 0;
        }
        if (this.f1581a == null) {
            T(recycler);
        }
        int scrolledBy = v(distance, this.a, this.b, this.c);
        this.a += scrolledBy;
        b0(this.f1581a);
        float halfItemSize = this.f1580a.f() / 2.0f;
        float start = s(getPosition(getChildAt(0)));
        Rect boundsRect = new Rect();
        if (M()) {
            firstFocalKeylineLoc = this.f1580a.h().b;
        } else {
            firstFocalKeylineLoc = this.f1580a.a().b;
        }
        float absDistanceToFirstFocal = Float.MAX_VALUE;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            float distanceToFirstFocal = Math.abs(firstFocalKeylineLoc - S(child, start, halfItemSize, boundsRect));
            if (child != null && distanceToFirstFocal < absDistanceToFirstFocal) {
                absDistanceToFirstFocal = distanceToFirstFocal;
                this.f = getPosition(child);
            }
            start = m(start, this.f1580a.f());
        }
        x(recycler, state);
        return scrolledBy;
    }

    private float S(View child, float startOffset, float halfItemSize, Rect boundsRect) {
        float center = m(startOffset, halfItemSize);
        d range = L(this.f1580a.g(), center, false);
        float offsetCenter = r(child, center, range);
        super.getDecoratedBoundsWithMargins(child, boundsRect);
        a0(child, center, range);
        this.f1578a.l(child, boundsRect, halfItemSize, offsetCenter);
        return offsetCenter;
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return this.a;
    }

    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0 || this.f1581a == null || getItemCount() <= 1) {
            return 0;
        }
        return (int) (((float) getWidth()) * (this.f1581a.g().f() / ((float) computeHorizontalScrollRange(state))));
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return this.c - this.b;
    }

    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return this.a;
    }

    public int computeVerticalScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0 || this.f1581a == null || getItemCount() <= 1) {
            return 0;
        }
        return (int) (((float) getHeight()) * (this.f1581a.g().f() / ((float) computeVerticalScrollRange(state))));
    }

    public int computeVerticalScrollRange(RecyclerView.State state) {
        return this.c - this.b;
    }

    public int getOrientation() {
        return this.f1578a.a;
    }

    public void setOrientation(int orientation) {
        if (orientation == 0 || orientation == 1) {
            assertNotInLayoutOrScroll((String) null);
            c cVar = this.f1578a;
            if (cVar == null || orientation != cVar.a) {
                this.f1578a = c.b(this, orientation);
                U();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + orientation);
    }

    public void onItemsAdded(RecyclerView recyclerView, int positionStart, int itemCount) {
        super.onItemsAdded(recyclerView, positionStart, itemCount);
        c0();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int positionStart, int itemCount) {
        super.onItemsRemoved(recyclerView, positionStart, itemCount);
        c0();
    }

    private void c0() {
        int newItemCount = getItemCount();
        int i = this.e;
        if (newItemCount != i && this.f1581a != null) {
            if (this.f1579a.d(this, i)) {
                U();
            }
            this.e = newItemCount;
        }
    }

    private static class d {
        final f.c a;
        final f.c b;

        d(f.c leftOrTop, f.c rightOrBottom) {
            Preconditions.checkArgument(leftOrTop.a <= rightOrBottom.a);
            this.a = leftOrTop;
            this.b = rightOrBottom;
        }
    }

    private static class c extends RecyclerView.ItemDecoration {
        private final Paint a;

        /* renamed from: a  reason: collision with other field name */
        private List<f.c> f1586a = Collections.unmodifiableList(new ArrayList());

        c() {
            Paint paint = new Paint();
            this.a = paint;
            paint.setStrokeWidth(5.0f);
            paint.setColor(-65281);
        }

        /* access modifiers changed from: package-private */
        public void a(List<f.c> keylines) {
            this.f1586a = Collections.unmodifiableList(keylines);
        }

        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
            super.onDrawOver(c, parent, state);
            this.a.setStrokeWidth(parent.getResources().getDimension(cc0.m3_carousel_debug_keyline_width));
            for (f.c keyline : this.f1586a) {
                this.a.setColor(ColorUtils.blendARGB(-65281, -16776961, keyline.c));
                if (((CarouselLayoutManager) parent.getLayoutManager()).b()) {
                    c.drawLine(keyline.b, (float) ((CarouselLayoutManager) parent.getLayoutManager()).I(), keyline.b, (float) ((CarouselLayoutManager) parent.getLayoutManager()).D(), this.a);
                } else {
                    c.drawLine((float) ((CarouselLayoutManager) parent.getLayoutManager()).F(), keyline.b, (float) ((CarouselLayoutManager) parent.getLayoutManager()).G(), keyline.b, this.a);
                }
            }
        }
    }
}
