package defpackage;

import android.view.View;
import android.widget.TextView;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.PrintCardsActivity;

/* renamed from: oa0  reason: default package */
public final /* synthetic */ class oa0 implements View.OnClickListener {
    public final /* synthetic */ TextView a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ PrintCardsActivity f4524a;

    public /* synthetic */ oa0(PrintCardsActivity printCardsActivity, TextView textView) {
        this.f4524a = printCardsActivity;
        this.a = textView;
    }

    public final void onClick(View view) {
        this.f4524a.b0(this.a, view);
    }
}
