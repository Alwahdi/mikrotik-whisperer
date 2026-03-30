package defpackage;

import android.view.View;
import android.widget.TextView;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.PrintCardsActivity;

/* renamed from: ra0  reason: default package */
public final /* synthetic */ class ra0 implements View.OnClickListener {
    public final /* synthetic */ TextView a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ PrintCardsActivity f4887a;

    public /* synthetic */ ra0(PrintCardsActivity printCardsActivity, TextView textView) {
        this.f4887a = printCardsActivity;
        this.a = textView;
    }

    public final void onClick(View view) {
        this.f4887a.d0(this.a, view);
    }
}
