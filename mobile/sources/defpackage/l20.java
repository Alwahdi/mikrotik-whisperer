package defpackage;

import android.view.View;
import androidx.appcompat.app.AlertDialog;

/* renamed from: l20  reason: default package */
public final /* synthetic */ class l20 implements View.OnClickListener {
    public final /* synthetic */ AlertDialog a;

    public /* synthetic */ l20(AlertDialog alertDialog) {
        this.a = alertDialog;
    }

    public final void onClick(View view) {
        this.a.dismiss();
    }
}
