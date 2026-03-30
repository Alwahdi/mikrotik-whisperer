package defpackage;

import android.view.View;
import android.widget.TextView;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity;

/* renamed from: g1  reason: default package */
public final /* synthetic */ class g1 implements View.OnClickListener {
    public final /* synthetic */ TextView a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ AddHostpotActivity f3002a;

    public /* synthetic */ g1(AddHostpotActivity addHostpotActivity, TextView textView) {
        this.f3002a = addHostpotActivity;
        this.a = textView;
    }

    public final void onClick(View view) {
        this.f3002a.P0(this.a, view);
    }
}
