package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.evrencoskun.tableview.adapter.recyclerview.holder.a;

/* renamed from: e20  reason: default package */
public class e20 extends a {
    public final ImageView a;

    /* renamed from: a  reason: collision with other field name */
    public final LinearLayout f2840a;

    public e20(View itemView) {
        super(itemView);
        this.f2840a = (LinearLayout) itemView.findViewById(R.id.cell_container);
        this.a = (ImageView) itemView.findViewById(R.id.cell_image);
    }
}
