package defpackage;

import android.view.View;
import androidx.appcompat.app.AlertDialog;

/* renamed from: t10  reason: default package */
public final /* synthetic */ class t10 implements View.OnClickListener {
    public final /* synthetic */ AlertDialog a;

    public /* synthetic */ t10(AlertDialog alertDialog) {
        this.a = alertDialog;
    }

    public final void onClick(View view) {
        this.a.dismiss();
    }
}
