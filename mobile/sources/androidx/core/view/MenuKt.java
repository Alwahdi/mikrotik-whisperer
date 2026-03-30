package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;

public final class MenuKt {
    public static final MenuItem get(Menu $this$get, int index) {
        lu.f($this$get, "<this>");
        MenuItem item = $this$get.getItem(index);
        lu.e(item, "getItem(index)");
        return item;
    }

    public static final boolean contains(Menu $this$contains, MenuItem item) {
        lu.f($this$contains, "<this>");
        lu.f(item, "item");
        int size = $this$contains.size();
        for (int index = 0; index < size; index++) {
            if (lu.a($this$contains.getItem(index), item)) {
                return true;
            }
        }
        return false;
    }

    public static final void minusAssign(Menu $this$minusAssign, MenuItem item) {
        lu.f($this$minusAssign, "<this>");
        lu.f(item, "item");
        $this$minusAssign.removeItem(item.getItemId());
    }

    public static final int getSize(Menu $this$size) {
        lu.f($this$size, "<this>");
        return $this$size.size();
    }

    public static final boolean isEmpty(Menu $this$isEmpty) {
        lu.f($this$isEmpty, "<this>");
        return $this$isEmpty.size() == 0;
    }

    public static final boolean isNotEmpty(Menu $this$isNotEmpty) {
        lu.f($this$isNotEmpty, "<this>");
        return $this$isNotEmpty.size() != 0;
    }

    public static final void forEach(Menu $this$forEach, vn<? super MenuItem, jt0> action) {
        lu.f($this$forEach, "<this>");
        lu.f(action, "action");
        int size = $this$forEach.size();
        for (int index = 0; index < size; index++) {
            MenuItem item = $this$forEach.getItem(index);
            lu.e(item, "getItem(index)");
            action.invoke(item);
        }
    }

    public static final void forEachIndexed(Menu $this$forEachIndexed, jo<? super Integer, ? super MenuItem, jt0> action) {
        lu.f($this$forEachIndexed, "<this>");
        lu.f(action, "action");
        int size = $this$forEachIndexed.size();
        for (int index = 0; index < size; index++) {
            Integer valueOf = Integer.valueOf(index);
            MenuItem item = $this$forEachIndexed.getItem(index);
            lu.e(item, "getItem(index)");
            action.invoke(valueOf, item);
        }
    }

    public static final Iterator<MenuItem> iterator(Menu $this$iterator) {
        lu.f($this$iterator, "<this>");
        return new MenuKt$iterator$1($this$iterator);
    }

    public static final void removeItemAt(Menu $this$removeItemAt, int index) {
        jt0 jt0;
        lu.f($this$removeItemAt, "<this>");
        MenuItem it = $this$removeItemAt.getItem(index);
        if (it != null) {
            $this$removeItemAt.removeItem(it.getItemId());
            jt0 = jt0.a;
        } else {
            jt0 = null;
        }
        if (jt0 == null) {
            throw new IndexOutOfBoundsException();
        }
    }

    public static final ck0<MenuItem> getChildren(Menu $this$children) {
        lu.f($this$children, "<this>");
        return new MenuKt$children$1($this$children);
    }
}
