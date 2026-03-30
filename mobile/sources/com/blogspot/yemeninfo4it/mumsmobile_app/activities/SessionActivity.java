package com.blogspot.yemeninfo4it.mumsmobile_app.activities;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.SessionNew;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SessionActivity extends AppCompatActivity {
    ListView a;

    /* renamed from: a  reason: collision with other field name */
    TextView f1158a;

    /* renamed from: a  reason: collision with other field name */
    b f1159a;

    /* renamed from: a  reason: collision with other field name */
    j3 f1160a;

    /* renamed from: a  reason: collision with other field name */
    String f1161a;

    /* renamed from: a  reason: collision with other field name */
    ArrayList<SessionNew> f1162a;

    /* renamed from: a  reason: collision with other field name */
    sk0 f1163a;

    /* renamed from: a  reason: collision with other field name */
    zd f1164a;
    TextView b;
    TextView c;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.sesstion_layout);
        try {
            this.f1161a = getIntent().getExtras().getString("selected_id");
            this.f1162a = new ArrayList<>();
            this.a = (ListView) findViewById(R.id.sesstion_ListView);
            this.f1158a = (TextView) findViewById(R.id.reload_session);
            TextView textView = (TextView) findViewById(R.id.head_tit);
            this.b = textView;
            textView.setText("قائمة الجلسات للمستخدم " + this.f1161a);
            zd zdVar = new zd(this);
            this.f1164a = zdVar;
            TextView textView2 = (TextView) zdVar.b().findViewById(R.id.cancel_btn);
            this.c = textView2;
            textView2.setOnClickListener(new rk0(this));
            this.f1158a.setOnClickListener(new a());
            b bVar = new b();
            this.f1159a = bVar;
            bVar.execute(new String[0]);
        } catch (Exception e) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(View v) {
        this.f1164a.a();
        try {
            j3 j3Var = this.f1160a;
            if (j3Var != null && j3Var.w()) {
                this.f1160a.close();
            }
        } catch (k3 e) {
            try {
                e.printStackTrace();
                Toast.makeText(this, e.getMessage() + " ddd", 0).show();
            } catch (Exception e2) {
                e2.printStackTrace();
                Toast.makeText(this, e2.getMessage() + " ddd", 0).show();
                return;
            }
        }
        b bVar = this.f1159a;
        if (bVar != null) {
            bVar.cancel(true);
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View v) {
            SessionActivity.this.f1159a = new b();
            SessionActivity.this.f1159a.execute(new String[0]);
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(jv0.b(newBase));
    }

    class b extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        String f1165a = "";

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f1166a = null;

        /* renamed from: a  reason: collision with other field name */
        boolean f1167a = false;

        b() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            SessionActivity.this.f1162a.clear();
            SessionActivity.this.f1164a.c("جاري جلب الجلسات...");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                SessionActivity.this.f1160a = j3.c(qb0.f4797a.getIp(), Integer.valueOf(Integer.parseInt(qb0.f4797a.getPort())));
                try {
                    SessionActivity.this.f1160a.C(qb0.f4797a.getUname(), qb0.f4797a.getPass(), true);
                    SessionActivity.this.f1160a.J(150000);
                    if (SessionActivity.this.f1160a.w()) {
                        int version = qb0.f4798a.getVersion() != null ? Integer.parseInt(qb0.f4798a.getVersion().substring(0, 1)) : 6;
                        if (version >= 7) {
                            j3 j3Var = SessionActivity.this.f1160a;
                            List<Map<String, String>> q = j3Var.q("/user-manager/session/print where user=" + SessionActivity.this.f1161a + " return user,started,uptime,upload,download");
                            this.f1166a = q;
                            if (q != null) {
                                for (Map<String, String> res : q) {
                                    ArrayList<SessionNew> arrayList = SessionActivity.this.f1162a;
                                    SessionNew sessionNew = r10;
                                    SessionNew sessionNew2 = new SessionNew("1", res.get("user"), res.get("started"), res.get("uptime"), res.get("download"), res.get("upload"));
                                    arrayList.add(sessionNew);
                                }
                            }
                        } else {
                            j3 j3Var2 = SessionActivity.this.f1160a;
                            List<Map<String, String>> q2 = j3Var2.q("/tool/user-manager/session/print where user=" + SessionActivity.this.f1161a + " return user,from-time,uptime,upload,download");
                            this.f1166a = q2;
                            if (q2 != null) {
                                for (Map<String, String> res2 : q2) {
                                    ArrayList<SessionNew> arrayList2 = SessionActivity.this.f1162a;
                                    int version2 = version;
                                    SessionNew sessionNew3 = r9;
                                    SessionNew sessionNew4 = new SessionNew("1", res2.get("user"), res2.get("from-time"), res2.get("uptime"), res2.get("download"), res2.get("upload"));
                                    arrayList2.add(sessionNew3);
                                    version = version2;
                                }
                            }
                        }
                    }
                    SessionActivity.this.f1160a.close();
                    return null;
                } catch (Exception e) {
                    this.f1165a = e.getMessage();
                    this.f1167a = true;
                    return null;
                }
            } catch (Exception e2) {
                this.f1165a = e2.getMessage();
                this.f1167a = true;
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            SessionActivity.this.f1164a.a();
            try {
                if (this.f1167a) {
                    Toast.makeText(SessionActivity.this, this.f1165a, 0).show();
                } else if (SessionActivity.this.f1162a.size() > 0) {
                    Toast.makeText(SessionActivity.this, "تمت العملية", 0).show();
                } else {
                    Toast.makeText(SessionActivity.this, "لا يوجد جلسات", 0).show();
                }
                SessionActivity sessionActivity = SessionActivity.this;
                SessionActivity sessionActivity2 = SessionActivity.this;
                sessionActivity.f1163a = new sk0(sessionActivity2, sessionActivity2.f1162a);
                SessionActivity sessionActivity3 = SessionActivity.this;
                sessionActivity3.a.setAdapter(sessionActivity3.f1163a);
            } catch (Exception e) {
                Toast.makeText(SessionActivity.this, e.getMessage(), 0).show();
            }
        }
    }
}
