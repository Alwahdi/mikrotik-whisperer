package defpackage;

import android.view.View;
import android.widget.TextView;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddUserActivity;

/* renamed from: z1  reason: default package */
public final /* synthetic */ class z1 implements View.OnClickListener {
    public final /* synthetic */ TextView a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ AddUserActivity f5966a;

    public /* synthetic */ z1(AddUserActivity addUserActivity, TextView textView) {
        this.f5966a = addUserActivity;
        this.a = textView;
    }

    public final void onClick(View view) {
        this.f5966a.n0(this.a, view);
    }
}
