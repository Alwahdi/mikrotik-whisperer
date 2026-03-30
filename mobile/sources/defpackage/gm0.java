package defpackage;

import android.view.View;
import com.google.android.material.snackbar.Snackbar;

/* renamed from: gm0  reason: default package */
public final /* synthetic */ class gm0 implements View.OnClickListener {
    public final /* synthetic */ View.OnClickListener a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Snackbar f3113a;

    public /* synthetic */ gm0(Snackbar snackbar, View.OnClickListener onClickListener) {
        this.f3113a = snackbar;
        this.a = onClickListener;
    }

    public final void onClick(View view) {
        this.f3113a.j0(this.a, view);
    }
}
