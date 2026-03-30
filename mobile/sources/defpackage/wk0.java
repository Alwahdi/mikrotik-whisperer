package defpackage;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Sessions;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.net.SocketFactory;

/* renamed from: wk0  reason: default package */
public class wk0 extends AsyncTask<Void, Void, ArrayList<Sessions>> {
    Context a;

    /* renamed from: a  reason: collision with other field name */
    TextView f5488a;

    /* renamed from: a  reason: collision with other field name */
    protected j3 f5489a;

    /* renamed from: a  reason: collision with other field name */
    String f5490a = "";

    /* renamed from: a  reason: collision with other field name */
    ArrayList<Sessions> f5491a;

    /* renamed from: a  reason: collision with other field name */
    List<Map<String, String>> f5492a = null;

    /* renamed from: a  reason: collision with other field name */
    s50 f5493a;

    /* renamed from: a  reason: collision with other field name */
    zd f5494a;

    /* renamed from: a  reason: collision with other field name */
    boolean f5495a = false;

    public wk0(Context context) {
        this.a = context;
        zd zdVar = new zd(context);
        this.f5494a = zdVar;
        this.f5488a = (TextView) zdVar.b().findViewById(R.id.cancel_btn);
        this.f5491a = new ArrayList<>();
        this.f5488a.setOnClickListener(new tk0(this, context));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(Context context, View v) {
        this.f5494a.a();
        try {
            j3 j3Var = this.f5489a;
            if (j3Var != null && j3Var.w()) {
                this.f5489a.close();
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
        this.f5494a.c("جاري تحميل الجلسات من السيرفر..");
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public ArrayList<Sessions> doInBackground(Void... strings) {
        j3 j3Var;
        try {
            j3 f = j3.f(SocketFactory.getDefault(), qb0.f4797a.getIp(), Integer.parseInt(qb0.f4797a.getPort()), 10000);
            this.f5489a = f;
            try {
                f.C(qb0.f4797a.getUname(), qb0.f4797a.getPass(), true);
                this.f5489a.J(450000);
                int version = qb0.f4798a.getVersion() != null ? Integer.parseInt(qb0.f4798a.getVersion().substring(0, 1)) : 6;
                if (version >= 7) {
                    List<Map<String, String>> q = this.f5489a.q("/user-manager/session/print return .id,user,started,nas-port-id,download,upload,uptime");
                    this.f5492a = q;
                    if (Build.VERSION.SDK_INT >= 24) {
                        this.f5491a = (ArrayList) ((List) q.stream().map(uk0.a).collect(Collectors.toList()));
                    } else {
                        for (Map<String, String> res : q) {
                            ArrayList<Sessions> arrayList = this.f5491a;
                            Sessions sessions = r12;
                            Sessions sessions2 = new Sessions(res.get("user"), res.get("started"), "", res.get("nas-port-id"), res.get(".id"), res.get("download"), res.get("upload"), res.get("uptime"));
                            arrayList.add(sessions);
                        }
                    }
                } else {
                    List<Map<String, String>> q2 = this.f5489a.q("/tool/user-manager/session/print return .id,user,from-time,nas-port-id,download,upload,uptime");
                    this.f5492a = q2;
                    if (Build.VERSION.SDK_INT >= 24) {
                        this.f5491a = (ArrayList) ((List) q2.stream().map(vk0.a).collect(Collectors.toList()));
                    } else {
                        for (Map<String, String> res2 : q2) {
                            ArrayList<Sessions> arrayList2 = this.f5491a;
                            int version2 = version;
                            Sessions sessions3 = r11;
                            Sessions sessions4 = new Sessions(res2.get("user"), res2.get("from-time"), "", res2.get("nas-port-id"), res2.get(".id"), res2.get("download"), res2.get("upload"), res2.get("uptime"));
                            arrayList2.add(sessions3);
                            version = version2;
                        }
                    }
                }
                if (this.f5489a.w()) {
                    j3Var = this.f5489a;
                    j3Var.close();
                }
            } catch (Exception e) {
                this.f5490a = e.getMessage();
                this.f5495a = true;
                if (this.f5489a.w()) {
                    j3Var = this.f5489a;
                }
            }
            return this.f5491a;
        } catch (Exception e2) {
            this.f5490a = e2.getMessage();
            this.f5495a = true;
            return null;
        } catch (Throwable th) {
            if (this.f5489a.w()) {
                this.f5489a.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Sessions e(Map res) {
        return new Sessions((String) res.get("user"), (String) res.get("started"), "", (String) res.get("nas-port-id"), (String) res.get(".id"), (String) res.get("download"), (String) res.get("upload"), (String) res.get("uptime"));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Sessions f(Map res) {
        return new Sessions((String) res.get("user"), (String) res.get("from-time"), "", (String) res.get("nas-port-id"), (String) res.get(".id"), (String) res.get("download"), (String) res.get("upload"), (String) res.get("uptime"));
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void onPostExecute(ArrayList<Sessions> result) {
        this.f5494a.a();
        try {
            if (this.f5495a) {
                Toast.makeText(this.a, this.f5490a, 0).show();
                return;
            }
            qb0.f4815d = result;
            qb0.f = result.size();
            s50 s50 = new s50(this.a);
            this.f5493a = s50;
            s50.execute(new Void[0]);
        } catch (Exception e) {
            Context context = this.a;
            Toast.makeText(context, e.getMessage() + "حصلت مشكلة ", 0).show();
        }
    }
}
