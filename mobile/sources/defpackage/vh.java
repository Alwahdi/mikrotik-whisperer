package defpackage;

import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.DragStartHelper;

/* renamed from: vh  reason: default package */
public final /* synthetic */ class vh implements View.OnTouchListener {
    public final /* synthetic */ DragStartHelper a;

    public /* synthetic */ vh(DragStartHelper dragStartHelper) {
        this.a = dragStartHelper;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.a.onTouch(view, motionEvent);
    }
}
