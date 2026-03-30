package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.Calendar;

final class MaterialCalendarGridView extends GridView {
    private final Calendar a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f1674a;

    public MaterialCalendarGridView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.a = p.k();
        if (h.x(getContext())) {
            setNextFocusLeftId(ic0.cancel_button);
            setNextFocusRightId(ic0.confirm_button);
        }
        this.f1674a = h.z(getContext());
        ViewCompat.setAccessibilityDelegate(this, new a());
    }

    class a extends AccessibilityDelegateCompat {
        a() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo((Object) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    public void setSelection(int position) {
        if (position < getAdapter().b()) {
            super.setSelection(getAdapter().b());
        } else {
            super.setSelection(position);
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (!super.onKeyDown(keyCode, event)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().b()) {
            return true;
        }
        if (19 != keyCode) {
            return false;
        }
        setSelection(getAdapter().b());
        return true;
    }

    /* renamed from: b */
    public k getAdapter() {
        return (k) super.getAdapter();
    }

    public final void setAdapter(ListAdapter adapter) {
        if (adapter instanceof k) {
            super.setAdapter(adapter);
        } else {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[]{MaterialCalendarGridView.class.getCanonicalName(), k.class.getCanonicalName()}));
        }
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        int firstHighlightPosition;
        int rangeHighlightStart;
        int firstVisiblePositionInMonth;
        int rangeHighlightStart2;
        int rangeHighlightEnd;
        int rangeHighlightStart3;
        int i;
        int left;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        k monthAdapter = getAdapter();
        xe<?> xeVar = monthAdapter.f1744a;
        c calendarStyle = monthAdapter.f1741a;
        int firstVisiblePositionInMonth2 = Math.max(monthAdapter.b(), getFirstVisiblePosition());
        int lastVisiblePositionInMonth = Math.min(monthAdapter.m(), getLastVisiblePosition());
        Long firstOfMonth = monthAdapter.getItem(firstVisiblePositionInMonth2);
        Long lastOfMonth = monthAdapter.getItem(lastVisiblePositionInMonth);
        for (Pair<Long, Long> range : xeVar.c()) {
            F f = range.first;
            if (f == null) {
                xe<?> xeVar2 = xeVar;
                int i2 = firstVisiblePositionInMonth2;
                int i3 = lastVisiblePositionInMonth;
                Long l = firstOfMonth;
                Long l2 = lastOfMonth;
                materialCalendarGridView = this;
            } else if (range.second != null) {
                long startItem = ((Long) f).longValue();
                long endItem = ((Long) range.second).longValue();
                if (!e(firstOfMonth, lastOfMonth, Long.valueOf(startItem), Long.valueOf(endItem))) {
                    boolean isRtl = lv0.g(this);
                    xe<?> xeVar3 = xeVar;
                    if (startItem < firstOfMonth.longValue()) {
                        firstHighlightPosition = firstVisiblePositionInMonth2;
                        if (monthAdapter.h(firstHighlightPosition)) {
                            rangeHighlightStart = 0;
                        } else if (!isRtl) {
                            rangeHighlightStart = materialCalendarGridView.c(firstHighlightPosition - 1).getRight();
                        } else {
                            rangeHighlightStart = materialCalendarGridView.c(firstHighlightPosition - 1).getLeft();
                        }
                    } else {
                        materialCalendarGridView.a.setTimeInMillis(startItem);
                        firstHighlightPosition = monthAdapter.a(materialCalendarGridView.a.get(5));
                        rangeHighlightStart = d(materialCalendarGridView.c(firstHighlightPosition));
                    }
                    if (endItem > lastOfMonth.longValue()) {
                        rangeHighlightStart2 = rangeHighlightStart;
                        rangeHighlightStart3 = lastVisiblePositionInMonth;
                        if (monthAdapter.i(rangeHighlightStart3) != 0) {
                            rangeHighlightEnd = getWidth();
                        } else if (!isRtl) {
                            rangeHighlightEnd = materialCalendarGridView.c(rangeHighlightStart3).getRight();
                        } else {
                            rangeHighlightEnd = materialCalendarGridView.c(rangeHighlightStart3).getLeft();
                        }
                        firstVisiblePositionInMonth = firstVisiblePositionInMonth2;
                    } else {
                        rangeHighlightStart2 = rangeHighlightStart;
                        materialCalendarGridView.a.setTimeInMillis(endItem);
                        firstVisiblePositionInMonth = firstVisiblePositionInMonth2;
                        rangeHighlightStart3 = monthAdapter.a(materialCalendarGridView.a.get(5));
                        rangeHighlightEnd = d(materialCalendarGridView.c(rangeHighlightStart3));
                    }
                    int lastVisiblePositionInMonth2 = lastVisiblePositionInMonth;
                    int firstRow = (int) monthAdapter.getItemId(firstHighlightPosition);
                    Long firstOfMonth2 = firstOfMonth;
                    Long lastOfMonth2 = lastOfMonth;
                    int lastRow = (int) monthAdapter.getItemId(rangeHighlightStart3);
                    int row = firstRow;
                    while (row <= lastRow) {
                        k monthAdapter2 = monthAdapter;
                        int firstPositionInRow = row * getNumColumns();
                        Long firstOfMonth3 = firstOfMonth2;
                        int lastPositionInRow = (firstPositionInRow + getNumColumns()) - 1;
                        View firstView = materialCalendarGridView.c(firstPositionInRow);
                        int top = firstView.getTop() + calendarStyle.f1685a.c();
                        int firstRow2 = firstRow;
                        int bottom = firstView.getBottom() - calendarStyle.f1685a.b();
                        if (!isRtl) {
                            left = firstPositionInRow > firstHighlightPosition ? 0 : rangeHighlightStart2;
                            i = rangeHighlightStart3 > lastPositionInRow ? getWidth() : rangeHighlightEnd;
                        } else {
                            left = rangeHighlightStart3 > lastPositionInRow ? 0 : rangeHighlightEnd;
                            i = firstPositionInRow > firstHighlightPosition ? getWidth() : rangeHighlightStart2;
                        }
                        int i4 = firstPositionInRow;
                        int left2 = left;
                        int lastHighlightPosition = rangeHighlightStart3;
                        int right = i;
                        int i5 = lastPositionInRow;
                        int i6 = left2;
                        int i7 = top;
                        int i8 = right;
                        int i9 = bottom;
                        canvas.drawRect((float) left2, (float) top, (float) right, (float) bottom, calendarStyle.a);
                        row++;
                        materialCalendarGridView = this;
                        monthAdapter = monthAdapter2;
                        firstOfMonth2 = firstOfMonth3;
                        rangeHighlightStart3 = lastHighlightPosition;
                        firstRow = firstRow2;
                    }
                    int i10 = rangeHighlightStart3;
                    Long firstOfMonth4 = firstOfMonth2;
                    int i11 = firstRow;
                    materialCalendarGridView = this;
                    xeVar = xeVar3;
                    firstVisiblePositionInMonth2 = firstVisiblePositionInMonth;
                    lastVisiblePositionInMonth = lastVisiblePositionInMonth2;
                    lastOfMonth = lastOfMonth2;
                    firstOfMonth = firstOfMonth4;
                }
            }
        }
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.f1674a) {
            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(ViewCompat.MEASURED_SIZE_MASK, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        if (gainFocus) {
            a(direction, previouslyFocusedRect);
        } else {
            super.onFocusChanged(false, direction, previouslyFocusedRect);
        }
    }

    private void a(int direction, Rect previouslyFocusedRect) {
        if (direction == 33) {
            setSelection(getAdapter().m());
        } else if (direction == 130) {
            setSelection(getAdapter().b());
        } else {
            super.onFocusChanged(true, direction, previouslyFocusedRect);
        }
    }

    private View c(int position) {
        return getChildAt(position - getFirstVisiblePosition());
    }

    private static boolean e(Long firstOfMonth, Long lastOfMonth, Long startDay, Long endDay) {
        if (firstOfMonth == null || lastOfMonth == null || startDay == null || endDay == null || startDay.longValue() > lastOfMonth.longValue() || endDay.longValue() < firstOfMonth.longValue()) {
            return true;
        }
        return false;
    }

    private static int d(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }
}
