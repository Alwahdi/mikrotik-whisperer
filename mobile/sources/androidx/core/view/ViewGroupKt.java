package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import java.util.Iterator;

public final class ViewGroupKt {
    public static final View get(ViewGroup $this$get, int index) {
        lu.f($this$get, "<this>");
        View childAt = $this$get.getChildAt(index);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + $this$get.getChildCount());
    }

    public static final boolean contains(ViewGroup $this$contains, View view) {
        lu.f($this$contains, "<this>");
        lu.f(view, "view");
        return $this$contains.indexOfChild(view) != -1;
    }

    public static final void plusAssign(ViewGroup $this$plusAssign, View view) {
        lu.f($this$plusAssign, "<this>");
        lu.f(view, "view");
        $this$plusAssign.addView(view);
    }

    public static final void minusAssign(ViewGroup $this$minusAssign, View view) {
        lu.f($this$minusAssign, "<this>");
        lu.f(view, "view");
        $this$minusAssign.removeView(view);
    }

    public static final int getSize(ViewGroup $this$size) {
        lu.f($this$size, "<this>");
        return $this$size.getChildCount();
    }

    public static final boolean isEmpty(ViewGroup $this$isEmpty) {
        lu.f($this$isEmpty, "<this>");
        return $this$isEmpty.getChildCount() == 0;
    }

    public static final boolean isNotEmpty(ViewGroup $this$isNotEmpty) {
        lu.f($this$isNotEmpty, "<this>");
        return $this$isNotEmpty.getChildCount() != 0;
    }

    public static final void forEach(ViewGroup $this$forEach, vn<? super View, jt0> action) {
        lu.f($this$forEach, "<this>");
        lu.f(action, "action");
        int childCount = $this$forEach.getChildCount();
        for (int index = 0; index < childCount; index++) {
            View childAt = $this$forEach.getChildAt(index);
            lu.e(childAt, "getChildAt(index)");
            action.invoke(childAt);
        }
    }

    public static final void forEachIndexed(ViewGroup $this$forEachIndexed, jo<? super Integer, ? super View, jt0> action) {
        lu.f($this$forEachIndexed, "<this>");
        lu.f(action, "action");
        int childCount = $this$forEachIndexed.getChildCount();
        for (int index = 0; index < childCount; index++) {
            Integer valueOf = Integer.valueOf(index);
            View childAt = $this$forEachIndexed.getChildAt(index);
            lu.e(childAt, "getChildAt(index)");
            action.invoke(valueOf, childAt);
        }
    }

    public static final dt getIndices(ViewGroup $this$indices) {
        lu.f($this$indices, "<this>");
        return hd0.e(0, $this$indices.getChildCount());
    }

    public static final Iterator<View> iterator(ViewGroup $this$iterator) {
        lu.f($this$iterator, "<this>");
        return new ViewGroupKt$iterator$1($this$iterator);
    }

    public static final ck0<View> getChildren(ViewGroup $this$children) {
        lu.f($this$children, "<this>");
        return new ViewGroupKt$children$1($this$children);
    }

    public static final ck0<View> getDescendants(ViewGroup $this$descendants) {
        lu.f($this$descendants, "<this>");
        return gk0.b(new ViewGroupKt$descendants$1($this$descendants, (rc<? super ViewGroupKt$descendants$1>) null));
    }

    public static final void setMargins(ViewGroup.MarginLayoutParams $this$setMargins, @Px int size) {
        lu.f($this$setMargins, "<this>");
        $this$setMargins.setMargins(size, size, size, size);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams $this$updateMargins_u24default, int left, int top, int right, int bottom, int i, Object obj) {
        if ((i & 1) != 0) {
            left = $this$updateMargins_u24default.leftMargin;
        }
        if ((i & 2) != 0) {
            top = $this$updateMargins_u24default.topMargin;
        }
        if ((i & 4) != 0) {
            right = $this$updateMargins_u24default.rightMargin;
        }
        if ((i & 8) != 0) {
            bottom = $this$updateMargins_u24default.bottomMargin;
        }
        lu.f($this$updateMargins_u24default, "<this>");
        $this$updateMargins_u24default.setMargins(left, top, right, bottom);
    }

    public static final void updateMargins(ViewGroup.MarginLayoutParams $this$updateMargins, @Px int left, @Px int top, @Px int right, @Px int bottom) {
        lu.f($this$updateMargins, "<this>");
        $this$updateMargins.setMargins(left, top, right, bottom);
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams $this$updateMarginsRelative_u24default, int start, int top, int end, int bottom, int i, Object obj) {
        if ((i & 1) != 0) {
            start = $this$updateMarginsRelative_u24default.getMarginStart();
        }
        if ((i & 2) != 0) {
            top = $this$updateMarginsRelative_u24default.topMargin;
        }
        if ((i & 4) != 0) {
            end = $this$updateMarginsRelative_u24default.getMarginEnd();
        }
        if ((i & 8) != 0) {
            bottom = $this$updateMarginsRelative_u24default.bottomMargin;
        }
        lu.f($this$updateMarginsRelative_u24default, "<this>");
        $this$updateMarginsRelative_u24default.setMarginStart(start);
        $this$updateMarginsRelative_u24default.topMargin = top;
        $this$updateMarginsRelative_u24default.setMarginEnd(end);
        $this$updateMarginsRelative_u24default.bottomMargin = bottom;
    }

    @RequiresApi(17)
    public static final void updateMarginsRelative(ViewGroup.MarginLayoutParams $this$updateMarginsRelative, @Px int start, @Px int top, @Px int end, @Px int bottom) {
        lu.f($this$updateMarginsRelative, "<this>");
        $this$updateMarginsRelative.setMarginStart(start);
        $this$updateMarginsRelative.topMargin = top;
        $this$updateMarginsRelative.setMarginEnd(end);
        $this$updateMarginsRelative.bottomMargin = bottom;
    }
}
