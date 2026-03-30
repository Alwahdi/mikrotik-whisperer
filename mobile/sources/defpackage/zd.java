package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;

/* renamed from: zd  reason: default package */
public class zd extends Dialog {
    private Dialog a;

    /* renamed from: a  reason: collision with other field name */
    private Context f6019a;

    /* renamed from: a  reason: collision with other field name */
    TextView f6020a = ((TextView) this.a.findViewById(R.id.cp_title));

    public zd(Context context) {
        super(context);
        this.f6019a = context;
        Dialog dialog = new Dialog(context);
        this.a = dialog;
        dialog.requestWindowFeature(1);
        this.a.getWindow().setBackgroundDrawable(context.getResources().getDrawable(R.drawable.radial_gradient_bkg));
        this.a.setContentView(R.layout.custom_dialog);
        this.a.setCancelable(false);
    }

    public void c(String title) {
        this.f6020a.setText(title);
        this.a.show();
    }

    public Dialog b() {
        return this.a;
    }

    public void a() {
        this.a.dismiss();
    }
}
