package defpackage;

import android.view.View;
import android.widget.TextView;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.PrintCardsActivity;

/* renamed from: sa0  reason: default package */
public final /* synthetic */ class sa0 implements View.OnClickListener {
    public final /* synthetic */ TextView a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ PrintCardsActivity f4977a;

    public /* synthetic */ sa0(PrintCardsActivity printCardsActivity, TextView textView) {
        this.f4977a = printCardsActivity;
        this.a = textView;
    }

    public final void onClick(View view) {
        this.f4977a.Z(this.a, view);
    }
}
