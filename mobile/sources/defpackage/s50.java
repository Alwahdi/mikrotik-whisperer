package defpackage;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Payment;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.SocketFactory;

/* renamed from: s50  reason: default package */
public class s50 extends AsyncTask<Void, Void, ArrayList<Payment>> {
    Context a;

    /* renamed from: a  reason: collision with other field name */
    TextView f4961a;

    /* renamed from: a  reason: collision with other field name */
    j3 f4962a;

    /* renamed from: a  reason: collision with other field name */
    String f4963a = "";

    /* renamed from: a  reason: collision with other field name */
    ArrayList<Payment> f4964a;

    /* renamed from: a  reason: collision with other field name */
    List<Map<String, String>> f4965a = null;

    /* renamed from: a  reason: collision with other field name */
    zd f4966a;

    /* renamed from: a  reason: collision with other field name */
    boolean f4967a = false;

    public s50(Context context) {
        this.a = context;
        this.f4966a = new zd(context);
        this.f4964a = new ArrayList<>();
        TextView textView = (TextView) this.f4966a.b().findViewById(R.id.cancel_btn);
        this.f4961a = textView;
        textView.setVisibility(8);
        this.f4961a.setOnClickListener(new r50(this, context));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(Context context, View v) {
        this.f4966a.a();
        try {
            j3 j3Var = this.f4962a;
            if (j3Var != null && j3Var.w()) {
                this.f4962a.close();
            }
        } catch (k3 e) {
            try {
                e.printStackTrace();
                Toast.makeText(context, e.getMessage() + " ddd", 0).show();
            } catch (Exception e2) {
                e2.printStackTrace();
                Toast.makeText(context, e2.getMessage() + " ddd", 0).show();
                return;
            }
        }
        cancel(true);
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        this.f4966a.c("جاري تحميل المبيعات من السيرفر...");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public ArrayList<Payment> doInBackground(Void... strings) {
        j3 j3Var;
        try {
            this.f4962a = j3.f(SocketFactory.getDefault(), qb0.f4797a.getIp(), Integer.parseInt(qb0.f4797a.getPort()), 10000);
            try {
                Set<String> names = new HashSet<>();
                names.add("1www1XXVVBBEERRDD");
                this.f4962a.C(qb0.f4797a.getUname(), qb0.f4797a.getPass(), true);
                this.f4962a.J(400000);
                if ((qb0.f4798a.getVersion() != null ? Integer.parseInt(qb0.f4798a.getVersion().substring(0, 1)) : 6) >= 7) {
                    this.f4965a = this.f4962a.q("/user-manager/payment/print return user,price");
                } else {
                    this.f4965a = this.f4962a.q(qb0.s.get(0).getAsa());
                }
                for (Map<String, String> res : this.f4965a) {
                    if (!names.contains(res.get("user"))) {
                        this.f4964a.add(new Payment(res.get("user"), res.get("price")));
                        names.add(res.get("user"));
                    }
                }
                if (this.f4962a.w()) {
                    j3Var = this.f4962a;
                    j3Var.close();
                }
            } catch (Exception e) {
                this.f4963a = e.getMessage();
                this.f4967a = true;
                if (this.f4962a.w()) {
                    j3Var = this.f4962a;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            this.f4963a = e2.getMessage();
            this.f4967a = true;
        } catch (Throwable th) {
            if (this.f4962a.w()) {
                this.f4962a.close();
            }
            throw th;
        }
        return this.f4964a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void onPostExecute(ArrayList<Payment> result) {
        this.f4966a.a();
        try {
            if (this.f4967a) {
                Toast.makeText(this.a, this.f4963a, 0).show();
                return;
            }
            qb0.f4833k = result;
            new si0(this.a).execute(new Void[0]);
        } catch (Exception e) {
            Context context = this.a;
            Toast.makeText(context, e.getMessage() + "حصلت مشكلة ", 0).show();
        }
    }
}
