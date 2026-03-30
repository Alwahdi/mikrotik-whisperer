package defpackage;

import android.view.View;
import android.widget.TextView;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddUserActivity;

/* renamed from: v1  reason: default package */
public final /* synthetic */ class v1 implements View.OnClickListener {
    public final /* synthetic */ TextView a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ AddUserActivity f5293a;

    public /* synthetic */ v1(AddUserActivity addUserActivity, TextView textView) {
        this.f5293a = addUserActivity;
        this.a = textView;
    }

    public final void onClick(View view) {
        this.f5293a.q0(this.a, view);
    }
}
