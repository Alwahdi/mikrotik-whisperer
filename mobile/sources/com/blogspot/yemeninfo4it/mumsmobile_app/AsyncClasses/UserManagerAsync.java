package com.blogspot.yemeninfo4it.mumsmobile_app.AsyncClasses;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.DeleteUser;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanCustomer;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanProfile;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserManagerAsync extends AsyncTask<Void, Integer, ArrayList<UsermanagerCards>> {
    int a = 0;

    /* renamed from: a  reason: collision with other field name */
    Context f355a;

    /* renamed from: a  reason: collision with other field name */
    TextView f356a;

    /* renamed from: a  reason: collision with other field name */
    HotspotAsync f357a;

    /* renamed from: a  reason: collision with other field name */
    j3 f358a;

    /* renamed from: a  reason: collision with other field name */
    String f359a = "";

    /* renamed from: a  reason: collision with other field name */
    ArrayList<UsermanProfile> f360a;

    /* renamed from: a  reason: collision with other field name */
    List<Map<String, String>> f361a = null;

    /* renamed from: a  reason: collision with other field name */
    ue f362a;

    /* renamed from: a  reason: collision with other field name */
    zd f363a;

    /* renamed from: a  reason: collision with other field name */
    boolean f364a = false;
    TextView b;

    /* renamed from: b  reason: collision with other field name */
    ArrayList<UsermanCustomer> f365b;

    /* renamed from: b  reason: collision with other field name */
    List<Map<String, String>> f366b = null;
    ArrayList<UsermanagerCards> c;

    /* renamed from: c  reason: collision with other field name */
    List<Map<String, String>> f367c = null;
    ArrayList<DeleteUser> d;

    static {
        System.loadLibrary("native-lib");
    }

    public UserManagerAsync(Context context) {
        this.f355a = context;
        this.f362a = new ue(context);
        this.f360a = new ArrayList<>();
        this.f365b = new ArrayList<>();
        this.c = new ArrayList<>();
        this.d = new ArrayList<>();
        zd zdVar = new zd(context);
        this.f363a = zdVar;
        this.f356a = (TextView) zdVar.b().findViewById(R.id.cancel_btn);
        TextView textView = (TextView) this.f363a.b().findViewById(R.id.cp_percent);
        this.b = textView;
        textView.setVisibility(0);
        this.f356a.setOnClickListener(new fu0(this, context));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(Context context, View v) {
        this.f363a.a();
        try {
            j3 j3Var = this.f358a;
            if (j3Var != null && j3Var.w()) {
                this.f358a.close();
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
        this.b.setText("0%");
        this.f363a.c("جاري تحميل كروت يوزر مانجر...");
        qb0.b = 0;
        qb0.c = 0;
        qb0.f4830i = false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public ArrayList<UsermanagerCards> doInBackground(Void... params) {
        try {
            j3 c2 = j3.c(qb0.f4797a.getIp(), Integer.valueOf(Integer.parseInt(qb0.f4797a.getPort())));
            this.f358a = c2;
            try {
                c2.C(qb0.f4797a.getUname(), qb0.f4797a.getPass(), true);
                this.f358a.J(200000);
                if (this.f358a.w()) {
                    this.f366b = this.f358a.q("/tool/user-manager/profile/print return .id,name,price");
                    this.f367c = this.f358a.q("/tool/user-manager/customer/print return login");
                }
                List<Map<String, String>> q = this.f358a.q(qb0.s.get(0).getAmng());
                this.f361a = q;
                if (q != null) {
                    for (Map<String, String> res : q) {
                        if (TextUtils.isEmpty(res.get("actual-profile"))) {
                            ArrayList<DeleteUser> arrayList = this.d;
                            DeleteUser deleteUser = r13;
                            DeleteUser deleteUser2 = new DeleteUser(res.get(".id"), res.get("username"), res.get("download-used"), res.get("upload-used"), res.get("actual-profile"), res.get("uptime-used"), false);
                            arrayList.add(deleteUser);
                        } else {
                            ArrayList<UsermanagerCards> arrayList2 = this.c;
                            UsermanagerCards usermanagerCards = r13;
                            UsermanagerCards usermanagerCards2 = new UsermanagerCards(res.get(".id"), res.get("username"), res.get("password"), res.get("actual-profile"), res.get("uptime-used"), res.get("download-used"), res.get("upload-used"), "print", false, Boolean.parseBoolean(res.get("disabled")), res.get("last-seen"), 0);
                            arrayList2.add(usermanagerCards);
                            if (res.get("last-seen").equals("never")) {
                                qb0.c++;
                            } else {
                                qb0.b++;
                            }
                        }
                        publishProgress(new Integer[]{Integer.valueOf((int) ((((float) this.a) / ((float) this.f361a.size())) * 100.0f))});
                    }
                    this.a++;
                }
                this.f358a.close();
            } catch (Exception e) {
                this.f359a = e.getMessage();
                this.f364a = true;
            }
        } catch (Exception e2) {
            this.f359a = e2.getMessage();
            this.f364a = true;
        }
        return this.c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void onProgressUpdate(Integer... values) {
        TextView textView = this.b;
        textView.setText(values[0] + "%");
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void onPostExecute(ArrayList<UsermanagerCards> result) {
        super.onPostExecute(result);
        this.f363a.a();
        qb0.f4830i = true;
        try {
            for (Map<String, String> res : this.f366b) {
                this.f360a.add(new UsermanProfile(res.get(".id"), res.get("name"), res.get("price")));
            }
            for (Map<String, String> res2 : this.f367c) {
                this.f365b.add(new UsermanCustomer(res2.get("login")));
            }
            if (this.f364a) {
                Toast.makeText(this.f355a, this.f359a, 1).show();
            }
            qb0.p = this.f360a;
            qb0.q = this.f365b;
            if (result != null) {
                qb0.r = this.d;
                qb0.f4807b = result;
                ((TextView) ((Activity) this.f355a).findViewById(R.id.expire_card_used_count)).setText("عدد الكروت منتهية الصلاحية :" + this.d.size());
                ((TextView) ((Activity) this.f355a).findViewById(R.id.card_used_count)).setText("الكروت المستخدمة :" + qb0.b);
                ((TextView) ((Activity) this.f355a).findViewById(R.id.card_unused_count)).setText("الكروت الغير مستخدمة :" + qb0.c);
            }
            HotspotAsync hotspotAsync = new HotspotAsync(this.f355a);
            this.f357a = hotspotAsync;
            hotspotAsync.execute(new Void[0]);
        } catch (Exception e) {
            e.printStackTrace();
            Context context = this.f355a;
            Toast.makeText(context, e.getMessage() + " خطا عند تحميل كروت يوزرمانجر", 1).show();
            HotspotAsync hotspotAsync2 = new HotspotAsync(this.f355a);
            this.f357a = hotspotAsync2;
            hotspotAsync2.execute(new Void[0]);
        }
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        qb0.f4830i = true;
        HotspotAsync hotspotAsync = new HotspotAsync(this.f355a);
        this.f357a = hotspotAsync;
        hotspotAsync.execute(new Void[0]);
    }
}
