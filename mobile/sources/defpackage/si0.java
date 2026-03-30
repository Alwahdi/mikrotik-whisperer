package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.SalesActivityNew;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Sessions;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanProfile;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* renamed from: si0  reason: default package */
public class si0 extends AsyncTask<Void, Void, String> {
    float a = 0.0f;

    /* renamed from: a  reason: collision with other field name */
    int f4986a;

    /* renamed from: a  reason: collision with other field name */
    Context f4987a;

    /* renamed from: a  reason: collision with other field name */
    TextView f4988a;

    /* renamed from: a  reason: collision with other field name */
    String f4989a = "";

    /* renamed from: a  reason: collision with other field name */
    SimpleDateFormat f4990a;

    /* renamed from: a  reason: collision with other field name */
    ArrayList<Sessions> f4991a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    Date f4992a;

    /* renamed from: a  reason: collision with other field name */
    Set<String> f4993a = new HashSet();

    /* renamed from: a  reason: collision with other field name */
    zd f4994a;

    /* renamed from: a  reason: collision with other field name */
    boolean f4995a = false;
    float b = 0.0f;

    /* renamed from: b  reason: collision with other field name */
    String f4996b;

    /* renamed from: b  reason: collision with other field name */
    SimpleDateFormat f4997b;
    String c;
    String d = "";
    String e = "";
    String f = "0";
    String g = "0";
    String h = "0s";
    String i;

    public si0(Context context) {
        Locale locale = Locale.ENGLISH;
        this.f4990a = new SimpleDateFormat("MMM/dd/yyyy HH:mm:ss", locale);
        this.f4997b = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", locale);
        this.i = "";
        int i2 = 6;
        this.f4986a = 6;
        this.f4987a = context;
        this.f4994a = new zd(context);
        this.f4986a = qb0.f4798a.getVersion() != null ? Integer.parseInt(qb0.f4798a.getVersion().substring(0, 1)) : i2;
        TextView textView = (TextView) this.f4994a.b().findViewById(R.id.cancel_btn);
        this.f4988a = textView;
        textView.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        this.f4994a.c("يتم الان التهيئة للعرض..");
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String doInBackground(Void... strings) {
        int i2 = 1;
        try {
            new ArrayList();
            ArrayList<Sessions> arrayList = qb0.f4815d;
            ArrayList<Sessions> sessionsList2 = arrayList;
            ArrayList<Sessions> sessionsList = qb0.h(arrayList);
            int i3 = 0;
            while (i3 < sessionsList.size()) {
                this.f4996b = sessionsList.get(i3).getName();
                this.c = sessionsList.get(i3).getNas_port_id();
                this.e = sessionsList.get(i3).getId();
                this.h = sessionsList.get(i3).getUptime();
                this.g = sessionsList.get(i3).getUpload();
                if (!this.f4993a.contains(this.f4996b)) {
                    this.a = 0.0f;
                    this.b = 0.0f;
                    List<Sessions> sessionsListm = (List) ln0.U(sessionsList2).q(new pi0(this)).f(v9.d());
                    if (sessionsListm != null) {
                        for (Sessions ses : sessionsListm) {
                            this.a += (ses.getDownload() == null || ses.getDownload().isEmpty()) ? 0.0f : Float.parseFloat(ses.getDownload());
                            this.b += (ses.getUpload() == null || ses.getUpload().isEmpty()) ? 1.0f : Float.parseFloat(ses.getUpload());
                        }
                    }
                    this.f4993a.add(sessionsList.get(i3).getName());
                    int c_pay = 0;
                    String str = "0";
                    if (this.f4986a >= 7) {
                        UsermanProfile mrsd = (UsermanProfile) ln0.U(qb0.p).q(new qi0(this)).C(new UsermanProfile(str, str, str));
                        if (mrsd != null) {
                            if (mrsd.getPrice() != null) {
                                str = mrsd.getPrice();
                            }
                            this.d = str;
                        } else {
                            this.d = str;
                        }
                    } else {
                        for (int w = 0; w < qb0.f4833k.size(); w++) {
                            if (this.f4996b.equals(qb0.f4833k.get(w).getName())) {
                                c_pay++;
                                if (qb0.f4833k.get(w).getPrice().length() > 2) {
                                    this.d = qb0.f4833k.get(w).getPrice().substring(0, qb0.f4833k.get(w).getPrice().length() - 2);
                                } else {
                                    this.d = qb0.f4833k.get(w).getPrice();
                                }
                            }
                        }
                        if (c_pay < i2) {
                            this.d = str;
                        }
                        int i4 = c_pay;
                    }
                    try {
                        Date parse = this.f4990a.parse(sessionsList.get(i3).getStfrom());
                        this.f4992a = parse;
                        this.i = this.f4997b.format(parse);
                    } catch (Exception e2) {
                    }
                    ArrayList<Sessions> arrayList2 = this.f4991a;
                    Sessions sessions = r8;
                    Sessions sessions2 = new Sessions(this.f4996b, this.i, this.d, this.c, this.e, String.valueOf(this.a), String.valueOf(this.b), this.h);
                    arrayList2.add(sessions);
                }
                i3++;
                i2 = 1;
            }
            return null;
        } catch (Exception e3) {
            this.f4989a = e3.getMessage();
            this.f4995a = true;
            return null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean e(Sessions item) {
        return item.name.equals(this.f4996b);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean g(UsermanProfile item) {
        return ln0.U(qb0.f4807b).c(new ri0(this, item));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean f(UsermanProfile item, UsermanagerCards app2) {
        return app2.getProfilename().equals(item.getUname()) && app2.getUname().equals(this.f4996b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void onPostExecute(String result) {
        this.f4994a.a();
        try {
            if (this.f4995a) {
                Toast.makeText(this.f4987a, this.f4989a, 0).show();
            }
            if (this.f4991a.size() > 0) {
                qb0.f4819e = this.f4991a;
                this.f4987a.startActivity(new Intent(this.f4987a, SalesActivityNew.class));
            }
        } catch (Exception e2) {
            Context context = this.f4987a;
            Toast.makeText(context, e2.getMessage() + "حصلت مشكلة ", 0).show();
        }
    }
}
