package com.blogspot.yemeninfo4it.mumsmobile_app.AsyncClasses;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.cookie.ClientCookie;

public class HotspotAsync extends AsyncTask<Void, Integer, ArrayList<HotspotCard>> {
    int a = 0;

    /* renamed from: a  reason: collision with other field name */
    Context f347a;

    /* renamed from: a  reason: collision with other field name */
    TextView f348a;

    /* renamed from: a  reason: collision with other field name */
    j3 f349a;

    /* renamed from: a  reason: collision with other field name */
    String f350a = "";

    /* renamed from: a  reason: collision with other field name */
    ArrayList<HotspotCard> f351a;

    /* renamed from: a  reason: collision with other field name */
    List<Map<String, String>> f352a = null;

    /* renamed from: a  reason: collision with other field name */
    zd f353a;

    /* renamed from: a  reason: collision with other field name */
    boolean f354a = false;
    TextView b;

    static {
        System.loadLibrary("native-lib");
    }

    public HotspotAsync(Context context) {
        this.f347a = context;
        this.f351a = new ArrayList<>();
        zd zdVar = new zd(context);
        this.f353a = zdVar;
        this.f348a = (TextView) zdVar.b().findViewById(R.id.cancel_btn);
        TextView textView = (TextView) this.f353a.b().findViewById(R.id.cp_percent);
        this.b = textView;
        textView.setVisibility(0);
        this.f348a.setOnClickListener(new sq(this, context));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(Context context, View v) {
        this.f353a.a();
        try {
            j3 j3Var = this.f349a;
            if (j3Var != null && j3Var.w()) {
                this.f349a.close();
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
        this.f353a.c("جاري تحميل كروت هوتسبوت...");
        qb0.d = 0;
        qb0.e = 0;
        qb0.f4830i = false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public ArrayList<HotspotCard> doInBackground(Void... params) {
        try {
            j3 c = j3.c(qb0.f4797a.getIp(), Integer.valueOf(Integer.parseInt(qb0.f4797a.getPort())));
            this.f349a = c;
            try {
                c.C(qb0.f4797a.getUname(), qb0.f4797a.getPass(), true);
                this.f349a.J(150000);
                List<Map<String, String>> q = this.f349a.q(qb0.s.get(0).getAh());
                this.f352a = q;
                for (Map<String, String> res : q) {
                    ArrayList<HotspotCard> arrayList = this.f351a;
                    HotspotCard hotspotCard = r8;
                    HotspotCard hotspotCard2 = new HotspotCard(res.get(".id"), res.get("name"), res.get("password"), res.get("profile"), res.get("uptime"), res.get("limit-uptime"), res.get("bytes-out"), res.get("bytes-in"), res.get("limit-bytes-total"), "print", false, res.get(ClientCookie.COMMENT_ATTR), res.get(NotificationCompat.CATEGORY_EMAIL), Boolean.parseBoolean(res.get("disabled")));
                    arrayList.add(hotspotCard);
                    if (!res.get("uptime").equals("0s")) {
                        qb0.d++;
                    }
                    if (res.get("uptime").equals("0s")) {
                        qb0.e++;
                    }
                    publishProgress(new Integer[]{Integer.valueOf((int) ((((float) this.a) / ((float) this.f352a.size())) * 100.0f))});
                    this.a++;
                }
                this.f349a.close();
            } catch (Exception e) {
                this.f350a = e.getMessage();
                this.f354a = true;
            }
        } catch (Exception e2) {
            this.f350a = e2.getMessage();
            this.f354a = true;
        }
        return this.f351a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void onProgressUpdate(Integer... values) {
        TextView textView = this.b;
        textView.setText(values[0] + "%");
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void onPostExecute(ArrayList<HotspotCard> result) {
        super.onPostExecute(result);
        this.f353a.a();
        qb0.f4830i = true;
        try {
            if (this.f354a) {
                Toast.makeText(this.f347a, this.f350a, 1).show();
            }
            ((TextView) ((Activity) this.f347a).findViewById(R.id.hots_totle_card_used_count)).setText("مجموع عدد الكروت :" + (qb0.d + qb0.e));
            ((TextView) ((Activity) this.f347a).findViewById(R.id.hots_card_used_count)).setText("الكروت المستخدمة :" + qb0.d);
            ((TextView) ((Activity) this.f347a).findViewById(R.id.hots_card_unused_count)).setText("الكروت الغير مستخدمة :" + qb0.e);
            qb0.f4834l = result;
        } catch (Exception e) {
            e.printStackTrace();
            Context context = this.f347a;
            Toast.makeText(context, e.getMessage() + " At Load Hotspot", 1).show();
        }
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        qb0.f4830i = true;
    }
}
