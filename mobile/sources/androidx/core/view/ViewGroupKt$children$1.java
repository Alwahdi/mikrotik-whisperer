package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

public final class ViewGroupKt$children$1 implements ck0<View> {
    final /* synthetic */ ViewGroup $this_children;

    ViewGroupKt$children$1(ViewGroup $receiver) {
        this.$this_children = $receiver;
    }

    public Iterator<View> iterator() {
        return ViewGroupKt.iterator(this.$this_children);
    }
}
