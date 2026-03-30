package defpackage;

import android.view.View;
import android.widget.TextView;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddUserActivity;

/* renamed from: y1  reason: default package */
public final /* synthetic */ class y1 implements View.OnClickListener {
    public final /* synthetic */ TextView a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ AddUserActivity f5786a;

    public /* synthetic */ y1(AddUserActivity addUserActivity, TextView textView) {
        this.f5786a = addUserActivity;
        this.a = textView;
    }

    public final void onClick(View view) {
        this.f5786a.r0(this.a, view);
    }
}
