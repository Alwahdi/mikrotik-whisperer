package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.MumsHomeActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.service.MyLocation;
import javax.net.SocketFactory;

/* renamed from: fp  reason: default package */
public class fp extends AsyncTask<Void, Void, String> {
    Context a;

    /* renamed from: a  reason: collision with other field name */
    j3 f2981a;

    /* renamed from: a  reason: collision with other field name */
    String f2982a = "v";

    /* renamed from: a  reason: collision with other field name */
    boolean f2983a = false;
    String b = "";

    /* renamed from: b  reason: collision with other field name */
    boolean f2984b = false;

    public fp(Context context) {
        this.a = context;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
        this.f2984b = false;
        try {
            qb0.d().close();
        } catch (k3 e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(Void... strings) {
        try {
            j3 f = j3.f(SocketFactory.getDefault(), qb0.f4797a.getIp(), Integer.parseInt(qb0.f4797a.getPort()), 10000);
            this.f2981a = f;
            try {
                f.C(qb0.f4797a.getUname(), qb0.f4797a.getPass(), true);
                if (this.f2981a.w()) {
                    try {
                        qb0.i(this.f2981a);
                    } catch (Exception e) {
                        this.f2982a = e.getMessage();
                    }
                    this.f2983a = true;
                    return null;
                }
                this.f2983a = false;
                return null;
            } catch (Exception e2) {
                this.f2984b = true;
                this.b = e2.getMessage();
                return null;
            }
        } catch (Exception e3) {
            this.f2984b = true;
            this.b = e3.getMessage();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void onPostExecute(String result) {
        if (this.f2983a) {
            try {
                Intent intentn = new Intent(this.a, MyLocation.class);
                intentn.putExtra("com.google.android.gms.location.sample.locationupdatesforegroundservice.started_from_notification", true);
                this.a.startService(intentn);
            } catch (Exception e) {
            }
            Toast.makeText(this.a, "تم إعادة الإتصال", 0).show();
            qb0.f4813c = true;
            Intent intent = new Intent(this.a.getApplicationContext(), MumsHomeActivity.class);
            intent.putExtra("l_data", true);
            intent.putExtra("restart", true);
            intent.addFlags(335577088);
            this.a.startActivity(intent);
            return;
        }
        Context context = this.a;
        Toast.makeText(context, " فشل إعادة الإتصال.يرجى إعادة تشغل التطبيق " + this.b, 0).show();
    }
}
