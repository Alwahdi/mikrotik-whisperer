package defpackage;

import android.content.Context;
import android.view.View;
import com.blogspot.yemeninfo4it.mumsmobile_app.AsyncClasses.UserManagerAsync;

/* renamed from: fu0  reason: default package */
public final /* synthetic */ class fu0 implements View.OnClickListener {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ UserManagerAsync f2993a;

    public /* synthetic */ fu0(UserManagerAsync userManagerAsync, Context context) {
        this.f2993a = userManagerAsync;
        this.a = context;
    }

    public final void onClick(View view) {
        this.f2993a.c(this.a, view);
    }
}
