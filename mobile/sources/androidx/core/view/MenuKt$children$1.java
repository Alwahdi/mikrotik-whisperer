package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;

public final class MenuKt$children$1 implements ck0<MenuItem> {
    final /* synthetic */ Menu $this_children;

    MenuKt$children$1(Menu $receiver) {
        this.$this_children = $receiver;
    }

    public Iterator<MenuItem> iterator() {
        return MenuKt.iterator(this.$this_children);
    }
}
