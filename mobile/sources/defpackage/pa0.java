package defpackage;

import android.view.View;
import android.widget.TextView;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.PrintCardsActivity;

/* renamed from: pa0  reason: default package */
public final /* synthetic */ class pa0 implements View.OnClickListener {
    public final /* synthetic */ TextView a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ PrintCardsActivity f4695a;

    public /* synthetic */ pa0(PrintCardsActivity printCardsActivity, TextView textView) {
        this.f4695a = printCardsActivity;
        this.a = textView;
    }

    public final void onClick(View view) {
        this.f4695a.Y(this.a, view);
    }
}
