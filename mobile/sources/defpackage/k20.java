package defpackage;

import android.content.DialogInterface;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.MumsHomeActivity;

/* renamed from: k20  reason: default package */
public final /* synthetic */ class k20 implements DialogInterface.OnClickListener {
    public final /* synthetic */ MumsHomeActivity a;

    public /* synthetic */ k20(MumsHomeActivity mumsHomeActivity) {
        this.a = mumsHomeActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.C(dialogInterface, i);
    }
}
