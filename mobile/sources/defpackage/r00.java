package defpackage;

import android.content.res.Resources;
import android.view.View;

/* renamed from: r00  reason: default package */
public class r00 extends f00<View> {
    private final float a;
    private final float b;
    private final float c;

    public r00(View view) {
        super(view);
        Resources resources = view.getResources();
        this.a = resources.getDimension(cc0.m3_back_progress_side_container_max_scale_x_distance_shrink);
        this.b = resources.getDimension(cc0.m3_back_progress_side_container_max_scale_x_distance_grow);
        this.c = resources.getDimension(cc0.m3_back_progress_side_container_max_scale_y_distance);
    }
}
