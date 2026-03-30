package defpackage;

import android.view.View;
import androidx.core.view.DragStartHelper;

/* renamed from: uh  reason: default package */
public final /* synthetic */ class uh implements View.OnLongClickListener {
    public final /* synthetic */ DragStartHelper a;

    public /* synthetic */ uh(DragStartHelper dragStartHelper) {
        this.a = dragStartHelper;
    }

    public final boolean onLongClick(View view) {
        return this.a.onLongClick(view);
    }
}
