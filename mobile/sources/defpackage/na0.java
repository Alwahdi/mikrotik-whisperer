package defpackage;

import android.view.View;
import android.widget.TextView;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.PrintCardsActivity;

/* renamed from: na0  reason: default package */
public final /* synthetic */ class na0 implements View.OnClickListener {
    public final /* synthetic */ TextView a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ PrintCardsActivity f4421a;

    public /* synthetic */ na0(PrintCardsActivity printCardsActivity, TextView textView) {
        this.f4421a = printCardsActivity;
        this.a = textView;
    }

    public final void onClick(View view) {
        this.f4421a.a0(this.a, view);
    }
}
