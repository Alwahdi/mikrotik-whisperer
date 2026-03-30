package defpackage;

import android.view.View;
import android.widget.TextView;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddUserActivity;

/* renamed from: x1  reason: default package */
public final /* synthetic */ class x1 implements View.OnClickListener {
    public final /* synthetic */ TextView a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ AddUserActivity f5562a;

    public /* synthetic */ x1(AddUserActivity addUserActivity, TextView textView) {
        this.f5562a = addUserActivity;
        this.a = textView;
    }

    public final void onClick(View view) {
        this.f5562a.o0(this.a, view);
    }
}
