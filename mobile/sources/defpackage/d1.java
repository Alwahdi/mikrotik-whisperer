package defpackage;

import android.view.View;
import android.widget.TextView;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity;

/* renamed from: d1  reason: default package */
public final /* synthetic */ class d1 implements View.OnClickListener {
    public final /* synthetic */ TextView a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ AddHostpotActivity f2691a;

    public /* synthetic */ d1(AddHostpotActivity addHostpotActivity, TextView textView) {
        this.f2691a = addHostpotActivity;
        this.a = textView;
    }

    public final void onClick(View view) {
        this.f2691a.R0(this.a, view);
    }
}
