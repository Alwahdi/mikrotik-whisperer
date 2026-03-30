package defpackage;

import android.view.View;

/* renamed from: zy  reason: default package */
public final /* synthetic */ class zy implements View.OnClickListener {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ az f6054a;

    public /* synthetic */ zy(az azVar, int i) {
        this.f6054a = azVar;
        this.a = i;
    }

    public final void onClick(View view) {
        this.f6054a.b(this.a, view);
    }
}
