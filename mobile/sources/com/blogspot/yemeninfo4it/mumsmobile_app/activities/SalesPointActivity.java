package com.blogspot.yemeninfo4it.mumsmobile_app.activities;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.SalesPointModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SalesPointActivity extends AppCompatActivity {
    int a = 1;

    /* renamed from: a  reason: collision with other field name */
    Context f1063a;

    /* renamed from: a  reason: collision with other field name */
    Button f1064a;

    /* renamed from: a  reason: collision with other field name */
    ImageView f1065a;

    /* renamed from: a  reason: collision with other field name */
    ListView f1066a;

    /* renamed from: a  reason: collision with other field name */
    RadioButton f1067a;

    /* renamed from: a  reason: collision with other field name */
    TextView f1068a;

    /* renamed from: a  reason: collision with other field name */
    d f1069a;

    /* renamed from: a  reason: collision with other field name */
    ArrayList<SalesPointModel> f1070a;

    /* renamed from: a  reason: collision with other field name */
    oi0 f1071a;

    /* renamed from: a  reason: collision with other field name */
    ue f1072a;

    /* renamed from: a  reason: collision with other field name */
    zd f1073a;
    ImageView b;

    /* renamed from: b  reason: collision with other field name */
    RadioButton f1074b;

    /* renamed from: b  reason: collision with other field name */
    TextView f1075b;
    RadioButton c;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.sales_point_activity);
        try {
            this.f1063a = this;
            this.f1070a = new ArrayList<>();
            this.f1072a = new ue(this.f1063a);
            this.f1066a = (ListView) findViewById(R.id.slsPoint_ListView);
            this.f1064a = (Button) findViewById(R.id.add_slsPoint);
            this.b = (ImageView) findViewById(R.id.back_img);
            this.f1068a = (TextView) findViewById(R.id.head_tit);
            this.f1067a = (RadioButton) findViewById(R.id.all_radio);
            this.f1074b = (RadioButton) findViewById(R.id.hots_radio);
            this.c = (RadioButton) findViewById(R.id.um_radio);
            this.f1065a = (ImageView) findViewById(R.id.refresh_slsPoint);
            this.f1068a.setText("قائمة نقاط البيع");
            this.b.setOnClickListener(new mi0(this));
            zd zdVar = new zd(this);
            this.f1073a = zdVar;
            this.f1075b = (TextView) zdVar.b().findViewById(R.id.cancel_btn);
            d dVar = new d();
            this.f1069a = dVar;
            dVar.execute(new String[0]);
            this.f1067a.setOnClickListener(new li0(this));
            this.f1074b.setOnClickListener(new ki0(this));
            this.c.setOnClickListener(new ni0(this));
            this.f1065a.setOnClickListener(new a());
            this.f1064a.setOnClickListener(new b());
        } catch (Exception e) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(View v) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(View v) {
        this.a = 0;
        this.f1067a.setChecked(true);
        this.f1074b.setChecked(false);
        this.c.setChecked(false);
        d dVar = new d();
        this.f1069a = dVar;
        dVar.execute(new String[0]);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p(View v) {
        this.a = 2;
        this.f1074b.setChecked(true);
        this.f1067a.setChecked(false);
        this.c.setChecked(false);
        d dVar = new d();
        this.f1069a = dVar;
        dVar.execute(new String[0]);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q(View v) {
        this.a = 1;
        this.c.setChecked(true);
        this.f1074b.setChecked(false);
        this.f1067a.setChecked(false);
        d dVar = new d();
        this.f1069a = dVar;
        dVar.execute(new String[0]);
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View v) {
            SalesPointActivity.this.f1069a = new d();
            SalesPointActivity.this.f1069a.execute(new String[0]);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View v) {
            SalesPointActivity.this.r();
        }
    }

    public void r() {
        try {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            View myView = getLayoutInflater().inflate(R.layout.save_hots_profile_pop, (ViewGroup) null);
            dialogBuilder.setView(myView);
            ((TextView) myView.findViewById(R.id.field_tit)).setText("الإسم");
            ((TextView) myView.findViewById(R.id.refresh_img)).setText("إضافة نقطة بيع");
            AlertDialog b2 = dialogBuilder.create();
            b2.show();
            ((TextView) myView.findViewById(R.id.save_profile_btn)).setOnClickListener(new c((EditText) myView.findViewById(R.id.save_profile_name), b2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class c implements View.OnClickListener {
        final /* synthetic */ EditText a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ AlertDialog f1076a;

        c(EditText editText, AlertDialog alertDialog) {
            this.a = editText;
            this.f1076a = alertDialog;
        }

        public void onClick(View v) {
            if (SalesPointActivity.this.f1072a.o0(this.a.getText().toString()).getCount() <= 0) {
                boolean P = SalesPointActivity.this.f1072a.P(this.a.getText().toString());
                SalesPointActivity salesPointActivity = SalesPointActivity.this;
                salesPointActivity.f1070a = salesPointActivity.f1072a.p0();
                SalesPointActivity salesPointActivity2 = SalesPointActivity.this;
                SalesPointActivity salesPointActivity3 = SalesPointActivity.this;
                salesPointActivity2.f1071a = new oi0(salesPointActivity3, salesPointActivity3, salesPointActivity3.f1070a, salesPointActivity3.a);
                SalesPointActivity salesPointActivity4 = SalesPointActivity.this;
                salesPointActivity4.f1066a.setAdapter(salesPointActivity4.f1071a);
                this.f1076a.dismiss();
                return;
            }
            Toast.makeText(SalesPointActivity.this, "اسم نقطة البيع موجوة بالفعل..قم بكتابة اسم اخر", 0).show();
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(jv0.b(newBase));
    }

    class d extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        String f1078a = "";

        /* renamed from: a  reason: collision with other field name */
        ArrayList<SalesPointModel> f1079a = new ArrayList<>();

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f1080a = null;

        /* renamed from: a  reason: collision with other field name */
        boolean f1081a = false;

        d() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            SalesPointActivity.this.f1073a.c("جاري جلب البيانات...");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                SalesPointActivity salesPointActivity = SalesPointActivity.this;
                this.f1079a = salesPointActivity.f1072a.q0(salesPointActivity.a);
                return null;
            } catch (Exception e) {
                this.f1078a = e.getMessage();
                this.f1081a = true;
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            SalesPointActivity.this.f1073a.a();
            try {
                SalesPointActivity salesPointActivity = SalesPointActivity.this;
                SalesPointActivity salesPointActivity2 = SalesPointActivity.this;
                salesPointActivity.f1071a = new oi0(salesPointActivity2, salesPointActivity2, this.f1079a, salesPointActivity2.a);
                SalesPointActivity salesPointActivity3 = SalesPointActivity.this;
                salesPointActivity3.f1066a.setAdapter(salesPointActivity3.f1071a);
            } catch (Exception e) {
                Toast.makeText(SalesPointActivity.this, e.getMessage(), 0).show();
            }
        }
    }
}
