package defpackage;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.blogspot.yemeninfo4it.mumsmobile_app.AsyncClasses.HotspotAsync;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.DeleteUser;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Sessions;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UserProfile;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanCustomer;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanProfile;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: lu0  reason: default package */
public class lu0 extends AsyncTask<Void, Integer, ArrayList<UsermanagerCards>> {
    int a = 0;

    /* renamed from: a  reason: collision with other field name */
    Context f4279a;

    /* renamed from: a  reason: collision with other field name */
    TextView f4280a;

    /* renamed from: a  reason: collision with other field name */
    HotspotAsync f4281a;

    /* renamed from: a  reason: collision with other field name */
    j3 f4282a;

    /* renamed from: a  reason: collision with other field name */
    String f4283a = "";

    /* renamed from: a  reason: collision with other field name */
    ArrayList<UsermanProfile> f4284a;

    /* renamed from: a  reason: collision with other field name */
    List<Map<String, String>> f4285a = null;

    /* renamed from: a  reason: collision with other field name */
    ue f4286a;

    /* renamed from: a  reason: collision with other field name */
    zd f4287a;

    /* renamed from: a  reason: collision with other field name */
    boolean f4288a = false;
    int b = 0;

    /* renamed from: b  reason: collision with other field name */
    TextView f4289b;

    /* renamed from: b  reason: collision with other field name */
    ArrayList<UsermanCustomer> f4290b;

    /* renamed from: b  reason: collision with other field name */
    List<Map<String, String>> f4291b = null;
    ArrayList<UsermanagerCards> c;

    /* renamed from: c  reason: collision with other field name */
    List<Map<String, String>> f4292c = null;
    ArrayList<Sessions> d;

    /* renamed from: d  reason: collision with other field name */
    List<Map<String, String>> f4293d = null;
    ArrayList<DeleteUser> e;

    /* renamed from: e  reason: collision with other field name */
    List<UserProfile> f4294e;

    public lu0(Context context) {
        this.f4279a = context;
        this.f4286a = new ue(context);
        this.f4284a = new ArrayList<>();
        this.f4290b = new ArrayList<>();
        this.c = new ArrayList<>();
        this.d = new ArrayList<>();
        this.f4294e = new ArrayList();
        this.e = new ArrayList<>();
        this.a = 0;
        zd zdVar = new zd(context);
        this.f4287a = zdVar;
        this.f4280a = (TextView) zdVar.b().findViewById(R.id.cancel_btn);
        TextView textView = (TextView) this.f4287a.b().findViewById(R.id.cp_percent);
        this.f4289b = textView;
        textView.setVisibility(0);
        this.f4280a.setOnClickListener(new ku0(this, context));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(Context context, View v) {
        this.f4287a.a();
        try {
            j3 j3Var = this.f4282a;
            if (j3Var != null && j3Var.w()) {
                this.f4282a.close();
            }
        } catch (k3 e2) {
            try {
                e2.printStackTrace();
                Toast.makeText(context, e2.getMessage() + " ddd", 0).show();
            } catch (Exception e3) {
                e3.printStackTrace();
                Toast.makeText(context, e3.getMessage() + " ddd", 0).show();
                return;
            }
        }
        cancel(true);
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        this.a = 0;
        this.f4289b.setText("0%");
        this.f4287a.c("جاري تحميل كروت يوزر مانجر...");
        qb0.b = 0;
        qb0.c = 0;
        qb0.f4830i = false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public ArrayList<UsermanagerCards> doInBackground(Void... params) {
        try {
            j3 c2 = j3.c(qb0.f4797a.getIp(), Integer.valueOf(Integer.parseInt(qb0.f4797a.getPort())));
            this.f4282a = c2;
            try {
                c2.C(qb0.f4797a.getUname(), qb0.f4797a.getPass(), true);
                this.f4282a.J(200000);
                if (this.f4282a.w()) {
                    this.f4291b = this.f4282a.q("/user-manager/profile/print return .id,name,price");
                    this.f4292c = this.f4282a.q("/user-manager/user-profile/print return .id,user,profile,state");
                }
                this.f4285a = this.f4282a.q("/user-manager/user/print");
                this.f4293d = this.f4282a.q("/user-manager/session/print return .id,user,started,download,upload,uptime,nas-port-id");
                List<Map<String, String>> list = this.f4285a;
                if (list != null) {
                    this.c = (ArrayList) ((List) ln0.U(list).K(iu0.a).f(v9.d()));
                    this.b++;
                }
                List<Map<String, String>> list2 = this.f4293d;
                if (list2 != null) {
                    this.d = (ArrayList) ((List) ln0.U(list2).K(ju0.a).f(v9.d()));
                }
                this.f4282a.close();
            } catch (Exception e2) {
                this.f4283a = e2.getMessage();
                this.f4288a = true;
            }
        } catch (Exception e3) {
            this.f4283a = e3.getMessage();
            this.f4288a = true;
        }
        return this.c;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ UsermanagerCards f(Map res) {
        return new UsermanagerCards((String) res.get(".id"), (String) res.get("name"), (String) res.get("password"), "", "0s", "0", "0", "print", false, Boolean.parseBoolean((String) res.get("disabled")), "false", 0);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Sessions g(Map nres) {
        return new Sessions((String) nres.get("user"), (String) nres.get("started"), "", (String) nres.get("nas-port-id"), (String) nres.get(".id"), (String) nres.get("download"), (String) nres.get("upload"), (String) nres.get("uptime"));
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public void onProgressUpdate(Integer... values) {
        TextView textView = this.f4289b;
        textView.setText(values[0] + "%");
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void onPostExecute(ArrayList<UsermanagerCards> result) {
        super.onPostExecute(result);
        this.f4287a.a();
        qb0.f4830i = true;
        try {
            if (this.f4288a) {
                Toast.makeText(this.f4279a, this.f4283a, 1).show();
            }
            for (Map<String, String> res : this.f4291b) {
                this.f4284a.add(new UsermanProfile(res.get(".id"), res.get("name"), res.get("price")));
            }
            ArrayList<UserProfile> arrayList = (ArrayList) ((List) ln0.U(this.f4292c).K(hu0.a).V(ma.a(gu0.a).reversed()).f(v9.d()));
            this.f4294e = arrayList;
            ArrayList arrayList2 = arrayList;
            qb0.f4811c = arrayList;
            ArrayList<Sessions> arrayList3 = this.d;
            qb0.f4815d = arrayList3;
            qb0.f = arrayList3.size();
            qb0.p = this.f4284a;
            qb0.f4807b = result;
            try {
                TextView expire_card_used_count = (TextView) ((Activity) this.f4279a).findViewById(R.id.expire_card_used_count);
                TextView card_used_count = (TextView) ((Activity) this.f4279a).findViewById(R.id.card_used_count);
                TextView card_unused_count = (TextView) ((Activity) this.f4279a).findViewById(R.id.card_unused_count);
                card_used_count.setText("يتم تجميع بيانات الكروت...");
                expire_card_used_count.setText("يتم تجميع بيانات الكروت...");
                card_unused_count.setText("يتم تجميع بيانات الكروت...");
                card_used_count.setTextSize(2, 15.2f);
                expire_card_used_count.setTextSize(2, 15.2f);
                card_unused_count.setTextSize(2, 15.2f);
                new cl(this.f4279a, result, this.f4294e, this.d).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } catch (Exception e2) {
            }
            try {
                HotspotAsync hotspotAsync = new HotspotAsync(this.f4279a);
                this.f4281a = hotspotAsync;
                hotspotAsync.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } catch (Exception e3) {
            }
        } catch (Exception e4) {
            Context context = this.f4279a;
            Toast.makeText(context, e4.getMessage() + " خطا عند تحميل كروت يوزرمانجر", 1).show();
            HotspotAsync hotspotAsync2 = new HotspotAsync(this.f4279a);
            this.f4281a = hotspotAsync2;
            hotspotAsync2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            e4.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ UserProfile i(Map res) {
        return new UserProfile((String) res.get(".id"), (String) res.get("user"), (String) res.get("profile"), (String) res.get("state"));
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        qb0.f4830i = true;
        HotspotAsync hotspotAsync = new HotspotAsync(this.f4279a);
        this.f4281a = hotspotAsync;
        hotspotAsync.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
