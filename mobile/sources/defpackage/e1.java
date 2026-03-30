package defpackage;

import android.view.View;
import android.widget.TextView;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity;

/* renamed from: e1  reason: default package */
public final /* synthetic */ class e1 implements View.OnClickListener {
    public final /* synthetic */ TextView a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ AddHostpotActivity f2837a;

    public /* synthetic */ e1(AddHostpotActivity addHostpotActivity, TextView textView) {
        this.f2837a = addHostpotActivity;
        this.a = textView;
    }

    public final void onClick(View view) {
        this.f2837a.N0(this.a, view);
    }
}
