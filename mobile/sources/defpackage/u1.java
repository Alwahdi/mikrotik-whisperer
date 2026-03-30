package defpackage;

import android.view.View;
import android.widget.TextView;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddUserActivity;

/* renamed from: u1  reason: default package */
public final /* synthetic */ class u1 implements View.OnClickListener {
    public final /* synthetic */ TextView a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ AddUserActivity f5186a;

    public /* synthetic */ u1(AddUserActivity addUserActivity, TextView textView) {
        this.f5186a = addUserActivity;
        this.a = textView;
    }

    public final void onClick(View view) {
        this.f5186a.p0(this.a, view);
    }
}
