package defpackage;

import android.content.res.Resources;
import android.view.View;

/* renamed from: g00  reason: default package */
public class g00 extends f00<View> {
    private final float a;
    private final float b;

    public g00(View view) {
        super(view);
        Resources resources = view.getResources();
        this.a = resources.getDimension(cc0.m3_back_progress_bottom_container_max_scale_x_distance);
        this.b = resources.getDimension(cc0.m3_back_progress_bottom_container_max_scale_y_distance);
    }
}
