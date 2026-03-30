package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;

public final class MenuKt$iterator$1 implements Iterator<MenuItem> {
    final /* synthetic */ Menu $this_iterator;
    private int index;

    MenuKt$iterator$1(Menu $receiver) {
        this.$this_iterator = $receiver;
    }

    public boolean hasNext() {
        return this.index < this.$this_iterator.size();
    }

    public MenuItem next() {
        Menu menu = this.$this_iterator;
        int i = this.index;
        this.index = i + 1;
        MenuItem item = menu.getItem(i);
        if (item != null) {
            return item;
        }
        throw new IndexOutOfBoundsException();
    }

    public void remove() {
        jt0 jt0;
        Menu $this$removeItemAt$iv = this.$this_iterator;
        this.index--;
        MenuItem it$iv = $this$removeItemAt$iv.getItem(this.index);
        if (it$iv != null) {
            lu.e(it$iv, "getItem(index)");
            $this$removeItemAt$iv.removeItem(it$iv.getItemId());
            jt0 = jt0.a;
        } else {
            jt0 = null;
        }
        if (jt0 == null) {
            throw new IndexOutOfBoundsException();
        }
    }
}
