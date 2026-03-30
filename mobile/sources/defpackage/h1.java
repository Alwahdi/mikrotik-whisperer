package defpackage;

import android.view.View;
import android.widget.TextView;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity;

/* renamed from: h1  reason: default package */
public final /* synthetic */ class h1 implements View.OnClickListener {
    public final /* synthetic */ TextView a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ AddHostpotActivity f3130a;

    public /* synthetic */ h1(AddHostpotActivity addHostpotActivity, TextView textView) {
        this.f3130a = addHostpotActivity;
        this.a = textView;
    }

    public final void onClick(View view) {
        this.f3130a.O0(this.a, view);
    }
}
