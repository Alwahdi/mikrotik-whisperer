package defpackage;

import android.content.Context;
import android.view.View;

/* renamed from: r50  reason: default package */
public final /* synthetic */ class r50 implements View.OnClickListener {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ s50 f4881a;

    public /* synthetic */ r50(s50 s50, Context context) {
        this.f4881a = s50;
        this.a = context;
    }

    public final void onClick(View view) {
        this.f4881a.c(this.a, view);
    }
}
