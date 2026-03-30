package defpackage;

import android.view.View;
import android.widget.TextView;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity;

/* renamed from: j1  reason: default package */
public final /* synthetic */ class j1 implements View.OnClickListener {
    public final /* synthetic */ TextView a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ AddHostpotActivity f4025a;

    public /* synthetic */ j1(AddHostpotActivity addHostpotActivity, TextView textView) {
        this.f4025a = addHostpotActivity;
        this.a = textView;
    }

    public final void onClick(View view) {
        this.f4025a.Q0(this.a, view);
    }
}
