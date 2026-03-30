package defpackage;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* renamed from: mv0  reason: default package */
public abstract class mv0 extends ImageButton {
    private int a = getVisibility();

    public mv0(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setVisibility(int visibility) {
        b(visibility, true);
    }

    public final void b(int visibility, boolean fromUser) {
        super.setVisibility(visibility);
        if (fromUser) {
            this.a = visibility;
        }
    }

    public final int getUserSetVisibility() {
        return this.a;
    }
}
