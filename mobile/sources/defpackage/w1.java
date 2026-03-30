package defpackage;

import android.view.View;
import android.widget.TextView;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddUserActivity;

/* renamed from: w1  reason: default package */
public final /* synthetic */ class w1 implements View.OnClickListener {
    public final /* synthetic */ TextView a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ AddUserActivity f5424a;

    public /* synthetic */ w1(AddUserActivity addUserActivity, TextView textView) {
        this.f5424a = addUserActivity;
        this.a = textView;
    }

    public final void onClick(View view) {
        this.f5424a.s0(this.a, view);
    }
}
