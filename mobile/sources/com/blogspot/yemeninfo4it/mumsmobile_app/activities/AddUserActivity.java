package com.blogspot.yemeninfo4it.mumsmobile_app.activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blogspot.yemeninfo4it.mumsmobile_app.MyHorizScrollView;
import com.blogspot.yemeninfo4it.mumsmobile_app.MyScrollView;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.ConnectData;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.DeleteUser;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Model_images;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.SalesPointModel;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards;
import com.google.android.material.snackbar.Snackbar;
import com.itextpdf.text.b;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.apache.http.HttpStatus;

public class AddUserActivity extends AppCompatActivity {
    private static String[] a = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    public static ArrayList<Model_images> b = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    float f517a = 14.0f;

    /* renamed from: a  reason: collision with other field name */
    int f518a = 0;

    /* renamed from: a  reason: collision with other field name */
    a2 f519a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f520a;

    /* renamed from: a  reason: collision with other field name */
    Context f521a;

    /* renamed from: a  reason: collision with other field name */
    Uri f522a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public ViewGroup f523a;

    /* renamed from: a  reason: collision with other field name */
    ArrayAdapter<String> f524a;

    /* renamed from: a  reason: collision with other field name */
    Button f525a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public CheckBox f526a;

    /* renamed from: a  reason: collision with other field name */
    EditText f527a;

    /* renamed from: a  reason: collision with other field name */
    ImageView f528a;

    /* renamed from: a  reason: collision with other field name */
    LinearLayout.LayoutParams f529a;

    /* renamed from: a  reason: collision with other field name */
    LinearLayout f530a;

    /* renamed from: a  reason: collision with other field name */
    NumberPicker f531a;

    /* renamed from: a  reason: collision with other field name */
    RadioButton f532a;

    /* renamed from: a  reason: collision with other field name */
    Spinner f533a;

    /* renamed from: a  reason: collision with other field name */
    TextView f534a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public RecyclerView f535a;

    /* renamed from: a  reason: collision with other field name */
    MyHorizScrollView f536a;

    /* renamed from: a  reason: collision with other field name */
    MyScrollView f537a;

    /* renamed from: a  reason: collision with other field name */
    o0 f538a;

    /* renamed from: a  reason: collision with other field name */
    p0 f539a;

    /* renamed from: a  reason: collision with other field name */
    q0 f540a;

    /* renamed from: a  reason: collision with other field name */
    r0 f541a;

    /* renamed from: a  reason: collision with other field name */
    s0 f542a;

    /* renamed from: a  reason: collision with other field name */
    ConnectData f543a;

    /* renamed from: a  reason: collision with other field name */
    protected j3 f544a;

    /* renamed from: a  reason: collision with other field name */
    File f545a = null;

    /* renamed from: a  reason: collision with other field name */
    final String f546a = "mLog";
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<AddUser> f547a;

    /* renamed from: a  reason: collision with other field name */
    t0 f548a;

    /* renamed from: a  reason: collision with other field name */
    ue f549a;

    /* renamed from: a  reason: collision with other field name */
    w5 f550a = new w5(0, 0, 0);

    /* renamed from: a  reason: collision with other field name */
    zd f551a;

    /* renamed from: a  reason: collision with other field name */
    boolean f552a = false;

    /* renamed from: b  reason: collision with other field name */
    float f553b = 8.5f;

    /* renamed from: b  reason: collision with other field name */
    int f554b = 0;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public ProgressDialog f555b;

    /* renamed from: b  reason: collision with other field name */
    Uri f556b = null;

    /* renamed from: b  reason: collision with other field name */
    Button f557b;

    /* renamed from: b  reason: collision with other field name */
    CheckBox f558b;

    /* renamed from: b  reason: collision with other field name */
    EditText f559b;

    /* renamed from: b  reason: collision with other field name */
    ImageView f560b;

    /* renamed from: b  reason: collision with other field name */
    LinearLayout f561b;

    /* renamed from: b  reason: collision with other field name */
    RadioButton f562b;

    /* renamed from: b  reason: collision with other field name */
    Spinner f563b;

    /* renamed from: b  reason: collision with other field name */
    TextView f564b;

    /* renamed from: b  reason: collision with other field name */
    j3 f565b;

    /* renamed from: b  reason: collision with other field name */
    String f566b;

    /* renamed from: b  reason: collision with other field name */
    w5 f567b = new w5(0, 0, 0);

    /* renamed from: b  reason: collision with other field name */
    boolean f568b = false;
    /* access modifiers changed from: private */
    public int c;

    /* renamed from: c  reason: collision with other field name */
    Button f569c;

    /* renamed from: c  reason: collision with other field name */
    CheckBox f570c;

    /* renamed from: c  reason: collision with other field name */
    EditText f571c;

    /* renamed from: c  reason: collision with other field name */
    ImageView f572c;

    /* renamed from: c  reason: collision with other field name */
    LinearLayout f573c;

    /* renamed from: c  reason: collision with other field name */
    RadioButton f574c;

    /* renamed from: c  reason: collision with other field name */
    Spinner f575c;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with other field name */
    public TextView f576c;

    /* renamed from: c  reason: collision with other field name */
    String f577c;

    /* renamed from: c  reason: collision with other field name */
    w5 f578c = new w5(0, 0, 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with other field name */
    public boolean f579c = false;
    /* access modifiers changed from: private */
    public int d;

    /* renamed from: d  reason: collision with other field name */
    Button f580d;

    /* renamed from: d  reason: collision with other field name */
    CheckBox f581d;

    /* renamed from: d  reason: collision with other field name */
    EditText f582d;

    /* renamed from: d  reason: collision with other field name */
    LinearLayout f583d;

    /* renamed from: d  reason: collision with other field name */
    RadioButton f584d;

    /* renamed from: d  reason: collision with other field name */
    Spinner f585d;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with other field name */
    public TextView f586d;

    /* renamed from: d  reason: collision with other field name */
    String f587d = "";
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with other field name */
    public boolean f588d = false;
    int e = 0;

    /* renamed from: e  reason: collision with other field name */
    Button f589e;

    /* renamed from: e  reason: collision with other field name */
    CheckBox f590e;

    /* renamed from: e  reason: collision with other field name */
    EditText f591e;

    /* renamed from: e  reason: collision with other field name */
    LinearLayout f592e;

    /* renamed from: e  reason: collision with other field name */
    RadioButton f593e;

    /* renamed from: e  reason: collision with other field name */
    Spinner f594e;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with other field name */
    public TextView f595e;

    /* renamed from: e  reason: collision with other field name */
    String f596e = null;

    /* renamed from: e  reason: collision with other field name */
    boolean f597e = false;
    int f = 10;

    /* renamed from: f  reason: collision with other field name */
    CheckBox f598f;

    /* renamed from: f  reason: collision with other field name */
    EditText f599f;

    /* renamed from: f  reason: collision with other field name */
    LinearLayout f600f;

    /* renamed from: f  reason: collision with other field name */
    RadioButton f601f;

    /* renamed from: f  reason: collision with other field name */
    Spinner f602f;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with other field name */
    public TextView f603f;

    /* renamed from: f  reason: collision with other field name */
    String f604f = "1";
    int g = 10;

    /* renamed from: g  reason: collision with other field name */
    EditText f605g;

    /* renamed from: g  reason: collision with other field name */
    LinearLayout f606g;

    /* renamed from: g  reason: collision with other field name */
    RadioButton f607g;

    /* renamed from: g  reason: collision with other field name */
    Spinner f608g;

    /* renamed from: g  reason: collision with other field name */
    TextView f609g;

    /* renamed from: g  reason: collision with other field name */
    String f610g = "1";
    int h = 0;

    /* renamed from: h  reason: collision with other field name */
    EditText f611h;

    /* renamed from: h  reason: collision with other field name */
    Spinner f612h;

    /* renamed from: h  reason: collision with other field name */
    TextView f613h;

    /* renamed from: h  reason: collision with other field name */
    String f614h = "1";
    int i = 0;

    /* renamed from: i  reason: collision with other field name */
    EditText f615i;

    /* renamed from: i  reason: collision with other field name */
    Spinner f616i;

    /* renamed from: i  reason: collision with other field name */
    TextView f617i;

    /* renamed from: i  reason: collision with other field name */
    String f618i = "1";
    int j = 0;

    /* renamed from: j  reason: collision with other field name */
    EditText f619j;

    /* renamed from: j  reason: collision with other field name */
    TextView f620j;

    /* renamed from: j  reason: collision with other field name */
    String f621j = "1";
    int k = 0;

    /* renamed from: k  reason: collision with other field name */
    TextView f622k;

    /* renamed from: k  reason: collision with other field name */
    String f623k = "1";
    int l = 0;

    /* renamed from: l  reason: collision with other field name */
    TextView f624l;

    /* renamed from: l  reason: collision with other field name */
    String f625l = "";
    int m = 0;

    /* renamed from: m  reason: collision with other field name */
    TextView f626m;

    /* renamed from: m  reason: collision with other field name */
    String f627m = "no";
    int n = 0;
    int o = 0;
    int p = 3;
    int q = 0;
    int r = 0;
    int s = 0;
    int t = 0;

    static {
        System.loadLibrary("native-lib");
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.add_user);
        this.f521a = this;
        try {
            this.f544a = qb0.d();
            if (!T()) {
                w0();
            }
            this.f547a = new ArrayList<>();
            this.f523a = (ViewGroup) findViewById(R.id.main);
            this.f537a = (MyScrollView) findViewById(R.id.scrollview);
            this.f536a = (MyHorizScrollView) findViewById(R.id.horizscroll);
            this.f530a = (LinearLayout) findViewById(R.id.print_layout);
            this.f576c = (TextView) findViewById(R.id.cardunum);
            this.f590e = (CheckBox) findViewById(R.id.user_pass_match);
            this.f598f = (CheckBox) findViewById(R.id.connect_with_mac);
            TextView textView = (TextView) findViewById(R.id.passnum);
            this.f586d = textView;
            textView.setOnTouchListener(u0());
            this.f558b = (CheckBox) findViewById(R.id.usr);
            this.f581d = (CheckBox) findViewById(R.id.slscheck);
            this.f570c = (CheckBox) findViewById(R.id.pas);
            this.f576c.setOnTouchListener(t0());
            TextView textView2 = (TextView) findViewById(R.id.slsnum);
            this.f595e = textView2;
            textView2.setOnTouchListener(v0());
            this.f549a = new ue(this.f521a);
            this.f532a = (RadioButton) findViewById(R.id.numberonly);
            this.f562b = (RadioButton) findViewById(R.id.charonly);
            this.f574c = (RadioButton) findViewById(R.id.numberandchar);
            this.f603f = (TextView) findViewById(R.id.font_size_number);
            this.f584d = (RadioButton) findViewById(R.id.nameonly);
            this.f593e = (RadioButton) findViewById(R.id.nameandpass);
            this.f608g = (Spinner) findViewById(R.id.saved_profiles);
            this.f601f = (RadioButton) findViewById(R.id.add_group);
            this.f607g = (RadioButton) findViewById(R.id.add_one);
            this.f573c = (LinearLayout) findViewById(R.id.group_add_layout);
            this.f561b = (LinearLayout) findViewById(R.id.one_add_layout);
            this.f583d = (LinearLayout) findViewById(R.id.sls_layout);
            this.f606g = (LinearLayout) findViewById(R.id.start_username_layout);
            this.f592e = (LinearLayout) findViewById(R.id.one_button_layout);
            this.f600f = (LinearLayout) findViewById(R.id.group_button_layout);
            this.f580d = (Button) findViewById(R.id.add_one_to_server);
            this.f591e = (EditText) findViewById(R.id.user_name_txt);
            this.f599f = (EditText) findViewById(R.id.password_txt);
            this.f605g = (EditText) findViewById(R.id.offsetx);
            this.f611h = (EditText) findViewById(R.id.offsety);
            this.f534a = (TextView) findViewById(R.id.set_h_w);
            this.f564b = (TextView) findViewById(R.id.print_note);
            this.f532a.setChecked(true);
            this.f593e.setChecked(true);
            this.f609g = (TextView) findViewById(R.id.selectimg);
            this.f528a = (ImageView) findViewById(R.id.plus);
            this.f560b = (ImageView) findViewById(R.id.menus);
            this.f572c = (ImageView) findViewById(R.id.back_img);
            NumberPicker numberPicker = (NumberPicker) findViewById(R.id.fontsize);
            this.f531a = numberPicker;
            numberPicker.setMinValue(8);
            this.f531a.setMaxValue(14);
            this.f531a.setValue(10);
            this.f613h = (TextView) findViewById(R.id.fonts_options);
            this.f617i = (TextView) findViewById(R.id.hide_show_print);
            this.f620j = (TextView) findViewById(R.id.show_saveprofile_pop);
            this.f622k = (TextView) findViewById(R.id.delete_saveprofile_pop);
            this.f526a = (CheckBox) findViewById(R.id.chk_select_all);
            this.f543a = new ConnectData();
            this.f535a = (RecyclerView) findViewById(R.id.recycler_adduser);
            this.f527a = (EditText) findViewById(R.id.cardcount);
            this.f559b = (EditText) findViewById(R.id.start_username);
            this.f571c = (EditText) findViewById(R.id.end_username);
            this.f582d = (EditText) findViewById(R.id.middel_username);
            this.f589e = (Button) findViewById(R.id.btn_delete_all);
            this.f563b = (Spinner) findViewById(R.id.customer);
            this.f612h = (Spinner) findViewById(R.id.userlength);
            this.f616i = (Spinner) findViewById(R.id.passlenght);
            this.f615i = (EditText) findViewById(R.id.intx);
            this.f619j = (EditText) findViewById(R.id.inty);
            this.f533a = (Spinner) findViewById(R.id.profilename);
            this.f575c = (Spinner) findViewById(R.id.sls_name_spinner);
            this.f602f = (Spinner) findViewById(R.id.add_one_profilename);
            this.f585d = (Spinner) findViewById(R.id.cardsize);
            this.f594e = (Spinner) findViewById(R.id.card_rows);
            ProgressDialog progressDialog = new ProgressDialog(this);
            this.f520a = progressDialog;
            progressDialog.setProgressStyle(1);
            zd zdVar = new zd(this);
            this.f551a = zdVar;
            this.f624l = (TextView) zdVar.b().findViewById(R.id.cancel_btn);
            TextView textView3 = (TextView) this.f551a.b().findViewById(R.id.cp_percent);
            this.f626m = textView3;
            textView3.setVisibility(0);
            this.f555b = new ProgressDialog(this);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f523a.getLayoutParams();
            this.f529a = layoutParams;
            layoutParams.height = 465;
            layoutParams.width = 1400;
            this.f523a.setLayoutParams(layoutParams);
            this.q = 1400;
            int sw = y0();
            if (sw > 1400) {
                this.f523a.getLayoutParams().width = 1400;
                this.q = 1400;
            }
            z0(sw);
            this.f517a = this.f576c.getTextSize() / getResources().getDisplayMetrics().scaledDensity;
            ArrayList<AddUser> arrayList = qb0.f4835m;
            if (arrayList != null) {
                this.f547a = arrayList;
                a2 a2Var = new a2(this, arrayList);
                this.f519a = a2Var;
                this.f535a.setAdapter(a2Var);
            }
            if (Build.VERSION.SDK_INT >= 30) {
                this.f564b.setVisibility(0);
            }
            h0();
            List<String> list2 = new ArrayList<>();
            list2.add("4");
            list2.add("5");
            list2.add("6");
            list2.add("7");
            list2.add("8");
            list2.add("9");
            list2.add("10");
            List<String> list3 = new ArrayList<>();
            list3.add("3");
            list3.add("4");
            list3.add("5");
            list3.add("6");
            list3.add("7");
            list3.add("8");
            list3.add("9");
            list3.add("10");
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<>(this, 17367048, list2);
            dataAdapter2.setDropDownViewResource(17367049);
            this.f612h.setAdapter(dataAdapter2);
            ArrayAdapter<String> dataAdapter5 = new ArrayAdapter<>(this, 17367048, list3);
            dataAdapter5.setDropDownViewResource(17367049);
            this.f616i.setAdapter(dataAdapter5);
            List<String> list4 = new ArrayList<>();
            list4.add("3");
            list4.add("4");
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367048, list4);
            arrayAdapter.setDropDownViewResource(17367049);
            this.f585d.setAdapter(arrayAdapter);
            List<String> list6 = new ArrayList<>();
            list6.add("12");
            list6.add("13");
            list6.add("14");
            list6.add("15");
            list6.add("16");
            list6.add("17");
            list6.add("18");
            list6.add("19");
            list6.add("20");
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, 17367048, list6);
            arrayAdapter2.setDropDownViewResource(17367049);
            this.f594e.setAdapter(arrayAdapter2);
            try {
                ArrayList<SalesPointModel> salesPointModels = new ArrayList<>();
                salesPointModels.add(new SalesPointModel(0, "اختار اسم النقطة", 0, 0));
                salesPointModels.addAll(this.f549a.p0());
                ArrayAdapter arrayAdapter3 = new ArrayAdapter(this.f521a, 17367048, salesPointModels);
                arrayAdapter3.setDropDownViewResource(17367049);
                this.f575c.setAdapter(arrayAdapter3);
            } catch (Exception e2) {
            }
            this.f575c.setOnItemSelectedListener(new k());
            this.f624l.setOnClickListener(new t1(this));
            this.f520a.setButton(-2, "إلغاء", new v());
            this.f569c = (Button) findViewById(R.id.printbtn);
            this.f557b = (Button) findViewById(R.id.add_to_server);
            this.f525a = (Button) findViewById(R.id.randombtn);
            this.f535a.setLayoutManager(new LinearLayoutManager(this));
            a2 a2Var2 = new a2(this.f521a, this.f547a);
            this.f519a = a2Var2;
            this.f535a.setAdapter(a2Var2);
            this.f535a.setItemAnimator(new DefaultItemAnimator());
            this.f534a.setOnClickListener(new g0());
            this.f525a.setOnClickListener(new i0());
            this.f572c.setOnClickListener(new j0());
            this.f526a.setOnClickListener(new k0());
            this.f589e.setOnClickListener(new l0());
            this.f557b.setOnClickListener(new m0());
            this.f580d.setOnClickListener(new n0());
            this.f613h.setOnClickListener(new a());
            this.f560b.setOnClickListener(new b());
            this.f581d.setOnClickListener(new s1(this));
            this.f609g.setOnClickListener(new c());
            this.f620j.setOnClickListener(new d());
            this.f622k.setOnClickListener(new e());
            this.f617i.setOnClickListener(new f());
            this.f585d.setOnItemSelectedListener(new g());
            this.f594e.setOnItemSelectedListener(new h());
            this.f569c.setOnClickListener(new i());
            this.f558b.setOnClickListener(new j());
            this.f570c.setOnClickListener(new l());
            this.f532a.setOnClickListener(new m());
            this.f562b.setOnClickListener(new n());
            this.f574c.setOnClickListener(new o());
            this.f584d.setOnClickListener(new p());
            this.f593e.setOnClickListener(new q());
            this.f601f.setOnClickListener(new r());
            this.f607g.setOnClickListener(new s());
            this.f608g.setOnItemSelectedListener(new t());
            Y();
        } catch (Exception e3) {
            Log.d("mLog", e3.toString() + "error odai dammag");
        }
    }

    class k implements AdapterView.OnItemSelectedListener {
        k() {
        }

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SalesPointModel salesPointModel = (SalesPointModel) parent.getSelectedItem();
            if (salesPointModel.getId() != 0) {
                AddUserActivity.this.e = salesPointModel.getId();
                AddUserActivity.this.f625l = salesPointModel.getName();
                Context context = AddUserActivity.this.f521a;
                Toast.makeText(context, "تم تحديد النقطة: " + salesPointModel.getName(), 0).show();
                return;
            }
            AddUserActivity.this.f625l = "....";
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l0(View v2) {
        this.f551a.a();
        try {
            this.f579c = true;
        } catch (Exception e2) {
            e2.printStackTrace();
            Context context = this.f521a;
            Toast.makeText(context, e2.getMessage() + " ddd", 0).show();
        }
    }

    class v implements DialogInterface.OnClickListener {
        v() {
        }

        public void onClick(DialogInterface dialog, int which) {
            AddUserActivity.this.f520a.dismiss();
            boolean unused = AddUserActivity.this.f588d = true;
        }
    }

    class g0 implements View.OnClickListener {
        g0() {
        }

        public void onClick(View v) {
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) AddUserActivity.this.f523a.getLayoutParams();
            params.height = Integer.parseInt(AddUserActivity.this.f611h.getText().toString());
            params.width = Integer.parseInt(AddUserActivity.this.f605g.getText().toString());
            AddUserActivity.this.f523a.setLayoutParams(params);
            AddUserActivity.this.p = 3;
        }
    }

    class i0 implements View.OnClickListener {
        i0() {
        }

        public void onClick(View v) {
            if (qb0.f4807b == null) {
                Toast.makeText(AddUserActivity.this.f521a, "الرجاء تحميل كروت يوزر مانجر لتتمكن من طباعة الكروت", 0).show();
            } else if (!AddUserActivity.this.f527a.getText().toString().trim().isEmpty()) {
                AddUserActivity.this.f535a.stopScroll();
                AddUserActivity addUserActivity = AddUserActivity.this;
                addUserActivity.f554b = Integer.parseInt(addUserActivity.f527a.getText().toString());
                AddUserActivity.this.f547a.clear();
                boolean unused = AddUserActivity.this.f588d = false;
                AddUserActivity.this.f542a = new s0();
                AddUserActivity.this.f542a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            } else {
                Toast.makeText(AddUserActivity.this.getApplicationContext(), "الرجاء تحديد عدد الكروت", 0).show();
            }
        }
    }

    class j0 implements View.OnClickListener {
        j0() {
        }

        public void onClick(View v) {
            AddUserActivity.this.onBackPressed();
        }
    }

    class k0 implements View.OnClickListener {
        k0() {
        }

        public void onClick(View v) {
            if (AddUserActivity.this.f547a.size() > 0) {
                if (AddUserActivity.this.f526a.isChecked()) {
                    Iterator it = AddUserActivity.this.f547a.iterator();
                    while (it.hasNext()) {
                        ((AddUser) it.next()).setSelected(true);
                    }
                } else {
                    Iterator it2 = AddUserActivity.this.f547a.iterator();
                    while (it2.hasNext()) {
                        ((AddUser) it2.next()).setSelected(false);
                    }
                }
                AddUserActivity.this.f519a.notifyDataSetChanged();
                return;
            }
            Snackbar.k0(v, "لا توجد سجلات للتحديد", 0).V();
        }
    }

    class l0 implements View.OnClickListener {
        l0() {
        }

        public void onClick(View v) {
            int iadd = 0;
            while (iadd < AddUserActivity.this.f547a.size()) {
                if (((AddUser) AddUserActivity.this.f547a.get(iadd)).isSelected()) {
                    AddUserActivity.this.f547a.remove(iadd);
                    AddUserActivity.this.f519a.notifyItemRemoved(iadd);
                    AddUserActivity addUserActivity = AddUserActivity.this;
                    addUserActivity.f519a.notifyItemRangeChanged(iadd, addUserActivity.f547a.size());
                    iadd = 0;
                }
                iadd++;
            }
        }
    }

    class m0 implements View.OnClickListener {
        m0() {
        }

        public void onClick(View v) {
            if (AddUserActivity.this.f547a.size() <= 0) {
                Toast.makeText(AddUserActivity.this.getApplicationContext(), "توليد الكروت اولا", 0).show();
            } else if (AddUserActivity.this.f581d.isChecked()) {
                AddUserActivity addUserActivity = AddUserActivity.this;
                if (addUserActivity.e != 0) {
                    new AlertDialog.Builder(AddUserActivity.this.f521a, R.style.CustomAlertDialog).setIcon(17301543).setTitle("تنبية !").setMessage("هل تريد اضافة الكروت التي تم توليدها الى السيرفر").setPositiveButton("نعم", new a()).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
                } else {
                    Toast.makeText(addUserActivity.getApplicationContext(), "اختر نقطة البيع اولا او قم بإلغاء خيار نقطة البيع", 0).show();
                }
            } else {
                new AlertDialog.Builder(AddUserActivity.this.f521a, R.style.CustomAlertDialog).setIcon(17301543).setTitle("تنبية !").setMessage("هل تريد اضافة الكروت التي تم توليدها الى السيرفر").setPositiveButton("نعم", new b()).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
            }
        }

        class a implements DialogInterface.OnClickListener {
            a() {
            }

            public void onClick(DialogInterface dialog, int which) {
                boolean unused = AddUserActivity.this.f579c = false;
                AddUserActivity.this.f538a = new o0();
                AddUserActivity.this.f538a.execute(new Void[0]);
            }
        }

        class b implements DialogInterface.OnClickListener {
            b() {
            }

            public void onClick(DialogInterface dialog, int which) {
                boolean unused = AddUserActivity.this.f579c = false;
                AddUserActivity.this.f538a = new o0();
                AddUserActivity.this.f538a.execute(new Void[0]);
            }
        }
    }

    class n0 implements View.OnClickListener {
        n0() {
        }

        public void onClick(View v) {
            new AlertDialog.Builder(AddUserActivity.this.f521a, R.style.CustomAlertDialog).setIcon(17301543).setTitle("تنبية !").setMessage("هل تريد اضافة الكرت الى السيرفر").setPositiveButton("نعم", new a()).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
        }

        class a implements DialogInterface.OnClickListener {
            a() {
            }

            public void onClick(DialogInterface dialog, int which) {
                AddUserActivity.this.f539a = new p0();
                AddUserActivity.this.f539a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            }
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View v) {
            AddUserActivity.this.A0();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View v) {
            AddUserActivity addUserActivity = AddUserActivity.this;
            int i = addUserActivity.f;
            if (i >= 8) {
                addUserActivity.f = i - 1;
                addUserActivity.f576c.setTextSize(0, AddUserActivity.this.f576c.getTextSize() - 2.0f);
                AddUserActivity.this.f586d.setTextSize(0, AddUserActivity.this.f586d.getTextSize() - 2.0f);
                AddUserActivity.this.f595e.setTextSize(0, AddUserActivity.this.f595e.getTextSize() - 1.0f);
                AddUserActivity.this.f603f.setText(String.valueOf(AddUserActivity.this.f));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m0(View v2) {
        if (this.f581d.isChecked()) {
            this.f583d.setVisibility(0);
            this.f595e.setVisibility(0);
            return;
        }
        this.f583d.setVisibility(8);
        this.f595e.setVisibility(8);
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View v) {
            AddUserActivity.this.j0();
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        public void onClick(View v) {
            AddUserActivity.this.x0();
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View v) {
            try {
                new AlertDialog.Builder(AddUserActivity.this.f521a, R.style.CustomAlertDialog).setIcon(17301543).setTitle("تنبية !").setMessage("هل تريد حذف القالب المحدد؟").setPositiveButton("نعم", new a()).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
            } catch (Exception e) {
            }
        }

        class a implements DialogInterface.OnClickListener {
            a() {
            }

            public void onClick(DialogInterface dialog, int which) {
                if (AddUserActivity.this.f608g.getSelectedItem().toString().equals("تحديد باقة محفوظة") || AddUserActivity.this.f608g.getSelectedItem().toString().equals("لا يوجد باقات محفوظة")) {
                    Toast.makeText(AddUserActivity.this.f521a, "الرجاء تحديد القالب قبل الحذف", 0).show();
                    return;
                }
                AddUserActivity addUserActivity = AddUserActivity.this;
                if (addUserActivity.f549a.c0(addUserActivity.f608g.getSelectedItem().toString())) {
                    Toast.makeText(AddUserActivity.this.f521a, "تم الحذف", 0).show();
                    AddUserActivity.this.Y();
                    return;
                }
                Toast.makeText(AddUserActivity.this.f521a, "حدثت مشكله عند الحذف", 0).show();
            }
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        public void onClick(View v) {
            AddUserActivity addUserActivity = AddUserActivity.this;
            if (addUserActivity.f552a) {
                addUserActivity.slideDown(addUserActivity.f530a);
                AddUserActivity.this.f617i.setText("اعدادات الطباعة");
            } else {
                addUserActivity.slideUp(addUserActivity.f530a);
                AddUserActivity.this.f617i.setText("اخفاء اعدادات الطباعة");
            }
            AddUserActivity addUserActivity2 = AddUserActivity.this;
            addUserActivity2.f552a = !addUserActivity2.f552a;
        }
    }

    class g implements AdapterView.OnItemSelectedListener {
        g() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            AddUserActivity.this.c0(adapterView.getItemAtPosition(position).toString());
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class h implements AdapterView.OnItemSelectedListener {
        h() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            AddUserActivity.this.d0(adapterView.getItemAtPosition(position).toString());
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class i implements View.OnClickListener {
        i() {
        }

        public void onClick(View v) {
            try {
                if (!AddUserActivity.this.T()) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 30) {
                    int aa = 0;
                    for (int i = 0; i < AddUserActivity.this.f547a.size(); i++) {
                        if (((AddUser) AddUserActivity.this.f547a.get(i)).getStatus().equals("yes")) {
                            aa++;
                        }
                    }
                    if (aa <= 0) {
                        Toast.makeText(AddUserActivity.this.f521a, "الرجاء اضافة الكروت اولا", 0).show();
                    } else if (!AddUserActivity.this.f587d.isEmpty()) {
                        AddUserActivity.this.f556b = MediaStore.Files.getContentUri("external");
                        AddUserActivity addUserActivity = AddUserActivity.this;
                        addUserActivity.X(addUserActivity.f556b);
                    } else {
                        Toast.makeText(AddUserActivity.this.getApplicationContext(), "الرجاء تحديد الصوره", 0).show();
                    }
                } else if (!AddUserActivity.this.f587d.isEmpty()) {
                    AddUserActivity.this.f540a = new q0();
                    AddUserActivity.this.f540a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                } else {
                    Toast.makeText(AddUserActivity.this.getApplicationContext(), "الرجاء تحديد الصوره", 0).show();
                }
            } catch (Exception e) {
                Toast.makeText(AddUserActivity.this.f521a, e.getMessage(), 0).show();
            }
        }
    }

    class j implements View.OnClickListener {
        j() {
        }

        public void onClick(View v) {
            if (AddUserActivity.this.f558b.isChecked()) {
                AddUserActivity.this.f576c.setVisibility(0);
            } else {
                AddUserActivity.this.f576c.setVisibility(8);
            }
        }
    }

    class l implements View.OnClickListener {
        l() {
        }

        public void onClick(View v) {
            if (AddUserActivity.this.f570c.isChecked()) {
                AddUserActivity.this.f586d.setVisibility(0);
            } else {
                AddUserActivity.this.f586d.setVisibility(8);
            }
        }
    }

    class m implements View.OnClickListener {
        m() {
        }

        public void onClick(View v) {
            AddUserActivity.this.f532a.setChecked(true);
            AddUserActivity.this.f562b.setChecked(false);
            AddUserActivity.this.f574c.setChecked(false);
        }
    }

    class n implements View.OnClickListener {
        n() {
        }

        public void onClick(View v) {
            AddUserActivity.this.f562b.setChecked(true);
            AddUserActivity.this.f532a.setChecked(false);
            AddUserActivity.this.f574c.setChecked(false);
        }
    }

    class o implements View.OnClickListener {
        o() {
        }

        public void onClick(View v) {
            AddUserActivity.this.f574c.setChecked(true);
            AddUserActivity.this.f562b.setChecked(false);
            AddUserActivity.this.f532a.setChecked(false);
        }
    }

    class p implements View.OnClickListener {
        p() {
        }

        public void onClick(View v) {
            AddUserActivity.this.f584d.setChecked(true);
            AddUserActivity.this.f590e.setEnabled(false);
            AddUserActivity.this.f590e.setChecked(false);
            AddUserActivity.this.f593e.setChecked(false);
        }
    }

    class q implements View.OnClickListener {
        q() {
        }

        public void onClick(View v) {
            AddUserActivity.this.f593e.setChecked(true);
            AddUserActivity.this.f590e.setEnabled(true);
            AddUserActivity.this.f584d.setChecked(false);
        }
    }

    class r implements View.OnClickListener {
        r() {
        }

        public void onClick(View v) {
            AddUserActivity.this.f601f.setChecked(true);
            AddUserActivity.this.f607g.setChecked(false);
            AddUserActivity.this.f573c.setVisibility(0);
            AddUserActivity.this.f606g.setVisibility(0);
            AddUserActivity.this.f600f.setVisibility(0);
            AddUserActivity.this.f590e.setVisibility(0);
            AddUserActivity.this.f617i.setVisibility(0);
            AddUserActivity.this.f527a.setEnabled(true);
            AddUserActivity.this.f592e.setVisibility(8);
            AddUserActivity.this.f561b.setVisibility(8);
        }
    }

    class s implements View.OnClickListener {
        s() {
        }

        public void onClick(View v) {
            AddUserActivity.this.f607g.setChecked(true);
            AddUserActivity.this.f601f.setChecked(false);
            AddUserActivity.this.f561b.setVisibility(0);
            AddUserActivity.this.f592e.setVisibility(0);
            AddUserActivity.this.f527a.setEnabled(false);
            AddUserActivity.this.f600f.setVisibility(8);
            AddUserActivity.this.f573c.setVisibility(8);
            AddUserActivity.this.f606g.setVisibility(8);
            AddUserActivity.this.f590e.setVisibility(8);
            AddUserActivity.this.f617i.setVisibility(8);
        }
    }

    class t implements AdapterView.OnItemSelectedListener {
        t() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            Object item = adapterView.getItemAtPosition(position);
            if (!item.toString().equals("تحديد باقة محفوظة") && !item.toString().equals("لا يوجد باقات محفوظة")) {
                AddUserActivity.this.i0(item.toString());
                AddUserActivity.this.i0(item.toString());
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        try {
            o0 o0Var = this.f538a;
            if (o0Var != null) {
                o0Var.cancel(true);
            }
            p0 p0Var = this.f539a;
            if (p0Var != null) {
                p0Var.cancel(true);
            }
            s0 s0Var = this.f542a;
            if (s0Var != null) {
                s0Var.cancel(true);
            }
            r0 r0Var = this.f541a;
            if (r0Var != null) {
                r0Var.cancel(true);
            }
            q0 q0Var = this.f540a;
            if (q0Var != null) {
                q0Var.cancel(true);
            }
        } catch (Exception e2) {
        }
    }

    public void z0(int sw) {
        if (sw <= 480) {
            this.f576c.setTextSize(27.0f);
            this.f586d.setTextSize(27.0f);
            this.f595e.setTextSize(25.0f);
        }
        if (sw > 480 && sw <= 768) {
            this.f576c.setTextSize(25.0f);
            this.f586d.setTextSize(25.0f);
            this.f595e.setTextSize(23.0f);
        }
        if (sw > 768 && sw <= 1080) {
            this.f576c.setTextSize(19.5f);
            this.f586d.setTextSize(19.5f);
            this.f595e.setTextSize(17.5f);
        } else if (sw >= 1200) {
            this.f576c.setTextSize(18.6f);
            this.f586d.setTextSize(18.6f);
            this.f595e.setTextSize(16.6f);
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(jv0.b(newBase));
    }

    class u implements View.OnTouchListener {
        u() {
        }

        public boolean onTouch(View view, MotionEvent event) {
            int minw = AddUserActivity.this.f586d.getWidth() / 2;
            int dd = 1400 / AddUserActivity.this.f523a.getWidth();
            int ww = AddUserActivity.this.f523a.getWidth() - AddUserActivity.this.f586d.getWidth();
            int height = AddUserActivity.this.f523a.getHeight() - AddUserActivity.this.f586d.getHeight();
            int x = (int) event.getRawX();
            int y = (int) event.getRawY();
            float scale = AddUserActivity.this.getResources().getDisplayMetrics().density;
            int width_ = (int) ((((float) AddUserActivity.this.f523a.getWidth()) / scale) + 0.5f);
            float U = AddUserActivity.U((float) ((int) ((((float) AddUserActivity.this.f523a.getHeight()) / scale) - 0.5f)));
            float U2 = AddUserActivity.U((float) width_);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            int action = event.getAction() & 255;
            int height2 = AddUserActivity.this.f586d.getHeight() / 2;
            switch (action) {
                case 0:
                    View view2 = view;
                    int i = dd;
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    int i2 = minw;
                    AddUserActivity.this.f537a.setVerticalScrollBarEnabled(false);
                    AddUserActivity.this.f537a.setHorizontalScrollBarEnabled(false);
                    AddUserActivity.this.f536a.setVerticalScrollBarEnabled(false);
                    AddUserActivity.this.f536a.setHorizontalScrollBarEnabled(false);
                    int unused = AddUserActivity.this.c = x - lParams.leftMargin;
                    int unused2 = AddUserActivity.this.d = y - lParams.topMargin;
                    break;
                case 1:
                    View view3 = view;
                    int i3 = dd;
                    AddUserActivity.this.f537a.setScrolling(true);
                    AddUserActivity.this.f536a.setScrolling(true);
                    AddUserActivity addUserActivity = AddUserActivity.this;
                    addUserActivity.f604f = String.valueOf((minw + ww) - (x - addUserActivity.c));
                    AddUserActivity addUserActivity2 = AddUserActivity.this;
                    addUserActivity2.f610g = String.valueOf(y - addUserActivity2.d);
                    int i4 = minw;
                    break;
                case 2:
                    AddUserActivity.this.f537a.setScrolling(false);
                    AddUserActivity.this.f536a.setScrolling(false);
                    layoutParams.leftMargin = x - AddUserActivity.this.c;
                    layoutParams.topMargin = y - AddUserActivity.this.d;
                    layoutParams.rightMargin = 0;
                    layoutParams.bottomMargin = 0;
                    AddUserActivity addUserActivity3 = AddUserActivity.this;
                    addUserActivity3.j = x - addUserActivity3.c;
                    AddUserActivity addUserActivity4 = AddUserActivity.this;
                    addUserActivity4.k = y - addUserActivity4.d;
                    AddUserActivity addUserActivity5 = AddUserActivity.this;
                    addUserActivity5.f604f = String.valueOf((minw + ww) - (x - addUserActivity5.c));
                    AddUserActivity addUserActivity6 = AddUserActivity.this;
                    addUserActivity6.f610g = String.valueOf(y - addUserActivity6.d);
                    view.setLayoutParams(layoutParams);
                    int i5 = minw;
                    int i6 = dd;
                    break;
                case 8:
                    layoutParams.leftMargin = x - AddUserActivity.this.c;
                    layoutParams.topMargin = y - AddUserActivity.this.d;
                    View view4 = view;
                    int i7 = minw;
                    int i8 = dd;
                    break;
                default:
                    View view5 = view;
                    int i9 = minw;
                    int i10 = dd;
                    break;
            }
            AddUserActivity.this.f523a.invalidate();
            return true;
        }
    }

    private View.OnTouchListener u0() {
        return new u();
    }

    class w implements View.OnTouchListener {
        w() {
        }

        public boolean onTouch(View view, MotionEvent event) {
            int minw = AddUserActivity.this.f576c.getWidth() / 2;
            int dd = 1400 / AddUserActivity.this.f523a.getWidth();
            int ww = AddUserActivity.this.f523a.getWidth() - AddUserActivity.this.f576c.getWidth();
            int height = AddUserActivity.this.f523a.getHeight() - AddUserActivity.this.f576c.getHeight();
            int x = (int) event.getRawX();
            int y = (int) event.getRawY();
            float scale = AddUserActivity.this.getResources().getDisplayMetrics().density;
            int width_ = (int) ((((float) AddUserActivity.this.f523a.getWidth()) / scale) + 0.5f);
            float U = AddUserActivity.U((float) ((int) ((((float) AddUserActivity.this.f523a.getHeight()) / scale) - 0.5f)));
            float U2 = AddUserActivity.U((float) width_);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            int action = event.getAction() & 255;
            int height2 = AddUserActivity.this.f576c.getHeight() / 2;
            switch (action) {
                case 0:
                    View view2 = view;
                    int i = dd;
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    int i2 = minw;
                    AddUserActivity.this.f537a.setVerticalScrollBarEnabled(false);
                    AddUserActivity.this.f537a.setHorizontalScrollBarEnabled(false);
                    AddUserActivity.this.f536a.setVerticalScrollBarEnabled(false);
                    AddUserActivity.this.f536a.setHorizontalScrollBarEnabled(false);
                    int unused = AddUserActivity.this.c = x - lParams.leftMargin;
                    int unused2 = AddUserActivity.this.d = y - lParams.topMargin;
                    break;
                case 1:
                    View view3 = view;
                    int i3 = dd;
                    AddUserActivity.this.f537a.setScrolling(true);
                    AddUserActivity.this.f536a.setScrolling(true);
                    AddUserActivity addUserActivity = AddUserActivity.this;
                    addUserActivity.f615i.setText(String.valueOf((minw + ww) - (x - addUserActivity.c)));
                    AddUserActivity addUserActivity2 = AddUserActivity.this;
                    addUserActivity2.f619j.setText(String.valueOf(y - addUserActivity2.d));
                    int i4 = minw;
                    break;
                case 2:
                    AddUserActivity.this.f537a.setScrolling(false);
                    AddUserActivity.this.f536a.setScrolling(false);
                    layoutParams.leftMargin = x - AddUserActivity.this.c;
                    layoutParams.topMargin = y - AddUserActivity.this.d;
                    layoutParams.rightMargin = 0;
                    layoutParams.bottomMargin = 0;
                    AddUserActivity addUserActivity3 = AddUserActivity.this;
                    addUserActivity3.h = x - addUserActivity3.c;
                    AddUserActivity addUserActivity4 = AddUserActivity.this;
                    addUserActivity4.i = y - addUserActivity4.d;
                    AddUserActivity addUserActivity5 = AddUserActivity.this;
                    addUserActivity5.f615i.setText(String.valueOf((minw + ww) - (x - addUserActivity5.c)));
                    AddUserActivity addUserActivity6 = AddUserActivity.this;
                    addUserActivity6.f619j.setText(String.valueOf(y - addUserActivity6.d));
                    view.setLayoutParams(layoutParams);
                    int i5 = minw;
                    int i6 = dd;
                    break;
                case 8:
                    layoutParams.leftMargin = x - AddUserActivity.this.c;
                    layoutParams.topMargin = y - AddUserActivity.this.d;
                    View view4 = view;
                    int i7 = minw;
                    int i8 = dd;
                    break;
                default:
                    View view5 = view;
                    int i9 = minw;
                    int i10 = dd;
                    break;
            }
            AddUserActivity.this.f523a.invalidate();
            return true;
        }
    }

    private View.OnTouchListener t0() {
        return new w();
    }

    class x implements View.OnTouchListener {
        x() {
        }

        public boolean onTouch(View view, MotionEvent event) {
            int minw = AddUserActivity.this.f595e.getWidth() / 2;
            int ww = AddUserActivity.this.f523a.getWidth() - AddUserActivity.this.f595e.getWidth();
            int x = (int) event.getRawX();
            int y = (int) event.getRawY();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            switch (event.getAction() & 255) {
                case 0:
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    AddUserActivity.this.f537a.setVerticalScrollBarEnabled(false);
                    AddUserActivity.this.f537a.setHorizontalScrollBarEnabled(false);
                    AddUserActivity.this.f536a.setVerticalScrollBarEnabled(false);
                    AddUserActivity.this.f536a.setHorizontalScrollBarEnabled(false);
                    int unused = AddUserActivity.this.c = x - lParams.leftMargin;
                    int unused2 = AddUserActivity.this.d = y - lParams.topMargin;
                    break;
                case 1:
                    AddUserActivity.this.f537a.setScrolling(true);
                    AddUserActivity.this.f536a.setScrolling(true);
                    AddUserActivity addUserActivity = AddUserActivity.this;
                    addUserActivity.f614h = String.valueOf((minw + ww) - (x - addUserActivity.c));
                    AddUserActivity addUserActivity2 = AddUserActivity.this;
                    addUserActivity2.f618i = String.valueOf(y - addUserActivity2.d);
                    break;
                case 2:
                    AddUserActivity.this.f537a.setScrolling(false);
                    AddUserActivity.this.f536a.setScrolling(false);
                    layoutParams.leftMargin = x - AddUserActivity.this.c;
                    layoutParams.topMargin = y - AddUserActivity.this.d;
                    layoutParams.rightMargin = 0;
                    layoutParams.bottomMargin = 0;
                    AddUserActivity addUserActivity3 = AddUserActivity.this;
                    addUserActivity3.l = x - addUserActivity3.c;
                    AddUserActivity addUserActivity4 = AddUserActivity.this;
                    addUserActivity4.m = y - addUserActivity4.d;
                    AddUserActivity addUserActivity5 = AddUserActivity.this;
                    addUserActivity5.f614h = String.valueOf((minw + ww) - (x - addUserActivity5.c));
                    AddUserActivity addUserActivity6 = AddUserActivity.this;
                    addUserActivity6.f618i = String.valueOf(y - addUserActivity6.d);
                    view.setLayoutParams(layoutParams);
                    break;
                case 8:
                    layoutParams.leftMargin = x - AddUserActivity.this.c;
                    layoutParams.topMargin = y - AddUserActivity.this.d;
                    break;
            }
            AddUserActivity.this.f523a.invalidate();
            return true;
        }
    }

    private View.OnTouchListener v0() {
        return new x();
    }

    public static int a0(int n2) {
        int m2 = (int) Math.pow(10.0d, (double) (n2 - 1));
        return new Random().nextInt(m2 * 9) + m2;
    }

    /* access modifiers changed from: private */
    public static String e0(int sizeOfRandomString) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(sizeOfRandomString);
        for (int i2 = 0; i2 < sizeOfRandomString; i2++) {
            sb.append("0123456789qwertyuiopasdfghjklzxcvbnm".charAt(random.nextInt("0123456789qwertyuiopasdfghjklzxcvbnm".length())));
        }
        return sb.toString();
    }

    public int y0() {
        Point size = new Point();
        WindowManager w2 = getWindowManager();
        if (Build.VERSION.SDK_INT < 11) {
            return w2.getDefaultDisplay().getWidth();
        }
        w2.getDefaultDisplay().getSize(size);
        return size.x;
    }

    public void h0() {
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        try {
            if (qb0.p != null) {
                for (int i2 = 0; i2 < qb0.p.size(); i2++) {
                    list.add(qb0.p.get(i2).getUname());
                }
            }
            if (qb0.q != null) {
                for (int i3 = 0; i3 < qb0.q.size(); i3++) {
                    list2.add(qb0.q.get(i3).getUname());
                }
            }
        } catch (Exception e2) {
            Log.d("mLog", e2.toString() + "error odai dammag");
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, 17367048, list);
        this.f524a = arrayAdapter;
        arrayAdapter.setDropDownViewResource(17367049);
        this.f533a.setAdapter(this.f524a);
        this.f602f.setAdapter(this.f524a);
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<>(this, 17367048, list2);
        dataAdapter2.setDropDownViewResource(17367049);
        this.f563b.setAdapter(dataAdapter2);
    }

    class o0 extends AsyncTask<Void, Integer, String> {
        int a = 6;

        /* renamed from: a  reason: collision with other field name */
        String f636a = "";

        /* renamed from: a  reason: collision with other field name */
        ArrayList<UsermanagerCards> f637a = new ArrayList<>();

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f638a = null;

        /* renamed from: a  reason: collision with other field name */
        boolean f639a = false;
        String b = qb0.s.get(0).getAdm();

        o0() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            int parseInt = qb0.f4798a.getVersion() != null ? Integer.parseInt(qb0.f4798a.getVersion().substring(0, 1)) : 6;
            this.a = parseInt;
            if (parseInt >= 7) {
                this.b = this.b.replace("/tool", "");
            }
            AddUserActivity.this.f626m.setText("0%");
            AddUserActivity.this.f551a.c("جاري إضافة الكروت الى السيرفر");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Void... params) {
            String str;
            try {
                AddUserActivity.this.f565b = j3.c(qb0.f4797a.getIp(), Integer.valueOf(Integer.parseInt(qb0.f4797a.getPort())));
                try {
                    AddUserActivity.this.f565b.C(qb0.f4797a.getUname(), qb0.f4797a.getPass(), true);
                    AddUserActivity.this.f565b.J(200000);
                    if (AddUserActivity.this.f547a.size() > 0) {
                        int iadd = 0;
                        while (true) {
                            if (iadd >= AddUserActivity.this.f547a.size()) {
                                break;
                            }
                            if (((AddUser) AddUserActivity.this.f547a.get(iadd)).getStatus().equals("no")) {
                                String str2 = " shared-users=0";
                                String str3 = " customer=";
                                if (!AddUserActivity.this.f593e.isChecked()) {
                                    str = "yes";
                                    String str4 = str2;
                                    String str5 = str3;
                                    if (AddUserActivity.this.f598f.isChecked()) {
                                        if (this.a <= 6) {
                                            this.f638a = AddUserActivity.this.f565b.q(this.b + " username=" + ((AddUser) AddUserActivity.this.f547a.get(iadd)).getUname() + " caller-id-bind-on-first-use=yes customer=" + AddUserActivity.this.f563b.getSelectedItem().toString() + "");
                                            AddUserActivity.this.f565b.q("/tool/user-manager/user/create-and-activate-profile numbers=" + ((String) this.f638a.get(0).get("ret")) + " profile=\"" + ((AddUser) AddUserActivity.this.f547a.get(iadd)).getProfilename() + "\" customer=" + AddUserActivity.this.f563b.getSelectedItem().toString() + "");
                                            ((AddUser) AddUserActivity.this.f547a.get(iadd)).setStatus(str);
                                        } else {
                                            this.f638a = AddUserActivity.this.f565b.q(this.b + " name=" + ((AddUser) AddUserActivity.this.f547a.get(iadd)).getUname() + " caller-id-bind-on-first-use=yes shared-users=0");
                                            AddUserActivity.this.f565b.q("/user-manager/user-profile/add user=" + ((String) this.f638a.get(0).get("ret")) + " profile=\"" + ((AddUser) AddUserActivity.this.f547a.get(iadd)).getProfilename() + "\"");
                                        }
                                        ((AddUser) AddUserActivity.this.f547a.get(iadd)).setStatus(str);
                                    } else {
                                        if (this.a <= 6) {
                                            this.f638a = AddUserActivity.this.f565b.q(this.b + " username=" + ((AddUser) AddUserActivity.this.f547a.get(iadd)).getUname() + str5 + AddUserActivity.this.f563b.getSelectedItem().toString() + "");
                                            AddUserActivity.this.f565b.q("/tool/user-manager/user/create-and-activate-profile numbers=" + ((String) this.f638a.get(0).get("ret")) + " profile=\"" + ((AddUser) AddUserActivity.this.f547a.get(iadd)).getProfilename() + "\" customer=" + AddUserActivity.this.f563b.getSelectedItem().toString() + "");
                                        } else {
                                            this.f638a = AddUserActivity.this.f565b.q(this.b + " name=" + ((AddUser) AddUserActivity.this.f547a.get(iadd)).getUname() + str2);
                                            AddUserActivity.this.f565b.q("/user-manager/user-profile/add user=" + ((String) this.f638a.get(0).get("ret")) + " profile=\"" + ((AddUser) AddUserActivity.this.f547a.get(iadd)).getProfilename() + "\"");
                                        }
                                        ((AddUser) AddUserActivity.this.f547a.get(iadd)).setStatus(str);
                                    }
                                } else if (AddUserActivity.this.f598f.isChecked()) {
                                    String str6 = "yes";
                                    if (this.a <= 6) {
                                        this.f638a = AddUserActivity.this.f565b.q(this.b + " username=" + ((AddUser) AddUserActivity.this.f547a.get(iadd)).getUname() + " password=" + ((AddUser) AddUserActivity.this.f547a.get(iadd)).getPassword().toString() + " caller-id-bind-on-first-use=yes customer=" + AddUserActivity.this.f563b.getSelectedItem().toString() + "");
                                        AddUserActivity.this.f565b.q("/tool/user-manager/user/create-and-activate-profile numbers=" + ((String) this.f638a.get(0).get("ret")) + " profile=\"" + ((AddUser) AddUserActivity.this.f547a.get(iadd)).getProfilename() + "\" customer=" + AddUserActivity.this.f563b.getSelectedItem().toString() + "");
                                    } else {
                                        this.f638a = AddUserActivity.this.f565b.q(this.b + " name=" + ((AddUser) AddUserActivity.this.f547a.get(iadd)).getUname() + " password=" + ((AddUser) AddUserActivity.this.f547a.get(iadd)).getPassword() + " shared-users=0 caller-id=bind");
                                        AddUserActivity.this.f565b.q("/user-manager/user-profile/add user=" + ((String) this.f638a.get(0).get("ret")) + " profile=\"" + ((AddUser) AddUserActivity.this.f547a.get(iadd)).getProfilename() + "\"");
                                    }
                                    str = str6;
                                    ((AddUser) AddUserActivity.this.f547a.get(iadd)).setStatus(str);
                                } else {
                                    str = "yes";
                                    if (this.a <= 6) {
                                        this.f638a = AddUserActivity.this.f565b.q(this.b + " username=" + ((AddUser) AddUserActivity.this.f547a.get(iadd)).getUname() + " password=" + ((AddUser) AddUserActivity.this.f547a.get(iadd)).getPassword() + str3 + AddUserActivity.this.f563b.getSelectedItem().toString() + "");
                                        AddUserActivity.this.f565b.q("/tool/user-manager/user/create-and-activate-profile numbers=" + ((String) this.f638a.get(0).get("ret")) + " profile=\"" + ((AddUser) AddUserActivity.this.f547a.get(iadd)).getProfilename() + "\" customer=" + AddUserActivity.this.f563b.getSelectedItem().toString() + "");
                                    } else {
                                        this.f638a = AddUserActivity.this.f565b.q(this.b + " name=" + ((AddUser) AddUserActivity.this.f547a.get(iadd)).getUname() + " password=" + ((AddUser) AddUserActivity.this.f547a.get(iadd)).getPassword() + str2);
                                        AddUserActivity.this.f565b.q("/user-manager/user-profile/add user=" + ((String) this.f638a.get(0).get("ret")) + " profile=\"" + ((AddUser) AddUserActivity.this.f547a.get(iadd)).getProfilename() + "\"");
                                    }
                                    ((AddUser) AddUserActivity.this.f547a.get(iadd)).setStatus(str);
                                }
                                ((AddUser) AddUserActivity.this.f547a.get(iadd)).setStatus(str);
                                publishProgress(new Integer[]{Integer.valueOf((int) ((((float) iadd) / ((float) AddUserActivity.this.f547a.size())) * 100.0f))});
                                qb0.c++;
                                qb0.f4807b.add(new UsermanagerCards((String) this.f638a.get(0).get("ret"), ((AddUser) AddUserActivity.this.f547a.get(iadd)).getUname().toString(), ((AddUser) AddUserActivity.this.f547a.get(iadd)).getPassword().toString(), ((AddUser) AddUserActivity.this.f547a.get(iadd)).getProfilename().toString(), "", "0", "0", "notprint", false, false, "never", AddUserActivity.this.e));
                                this.f637a.add(new UsermanagerCards((String) this.f638a.get(0).get("ret"), ((AddUser) AddUserActivity.this.f547a.get(iadd)).getUname().toString(), ((AddUser) AddUserActivity.this.f547a.get(iadd)).getPassword().toString(), ((AddUser) AddUserActivity.this.f547a.get(iadd)).getProfilename().toString(), "", "0", "0", "notprint", false, false, "never", AddUserActivity.this.e));
                            }
                            if (AddUserActivity.this.f579c) {
                                break;
                            }
                            iadd++;
                        }
                    }
                    AddUserActivity.this.f565b.close();
                    return null;
                } catch (Exception e) {
                    this.f636a = e.getMessage();
                    this.f639a = true;
                    return null;
                }
            } catch (Exception e2) {
                this.f636a = e2.getMessage();
                this.f639a = true;
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void onProgressUpdate(Integer... values) {
            TextView textView = AddUserActivity.this.f626m;
            textView.setText(values[0] + "%");
            AddUserActivity.this.f519a.notifyDataSetChanged();
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            AddUserActivity.this.f551a.a();
            try {
                if (this.f639a) {
                    Context context = AddUserActivity.this.f521a;
                    Toast.makeText(context, this.f636a + " v1 " + String.valueOf(this.a) + " - " + this.b, 0).show();
                }
                qb0.f4835m = AddUserActivity.this.f547a;
                try {
                    if (this.f637a.size() > 0) {
                        new ts(AddUserActivity.this.getApplicationContext(), this.f637a, AddUserActivity.this.e).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    }
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                Context context2 = AddUserActivity.this.f521a;
                Toast.makeText(context2, this.f636a + " v1 " + String.valueOf(this.a) + " - " + this.b, 0).show();
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean T() {
        if (Build.VERSION.SDK_INT >= 30) {
            return Environment.isExternalStorageManager();
        }
        return ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") == 0 && ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    /* access modifiers changed from: private */
    public void w0() {
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse(String.format("package:%s", new Object[]{getApplicationContext().getPackageName()})));
                startActivityForResult(intent, 2296);
            } catch (Exception e2) {
                Intent intent2 = new Intent();
                intent2.setAction("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION");
                startActivityForResult(intent2, 2296);
            }
        } else {
            ActivityCompat.requestPermissions(this, a, 1);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2296) {
            if (Build.VERSION.SDK_INT >= 30) {
                try {
                    if (!Environment.isExternalStorageManager()) {
                        Toast.makeText(this, "Allow permission for storage access!", 0).show();
                    } else if (resultCode == -1) {
                        String[] projection = {"_data"};
                        Cursor cursor = getContentResolver().query(data.getData(), projection, (String) null, (String[]) null, (String) null);
                        cursor.moveToFirst();
                        this.f587d = cursor.getString(cursor.getColumnIndex(projection[0]));
                        cursor.close();
                        this.f523a.setBackground(new BitmapDrawable(BitmapFactory.decodeFile(this.f587d)));
                        try {
                            W(this.f587d, "/storage/emulated/0/MUMS_Images/");
                        } catch (Exception e2) {
                        }
                    }
                } catch (Exception e3) {
                }
            }
        } else if (requestCode == 1) {
            if (resultCode == -1) {
                String[] projection2 = {"_data"};
                Cursor cursor2 = getContentResolver().query(data.getData(), projection2, (String) null, (String[]) null, (String) null);
                cursor2.moveToFirst();
                this.f587d = cursor2.getString(cursor2.getColumnIndex(projection2[0]));
                cursor2.close();
                this.f523a.setBackground(new BitmapDrawable(BitmapFactory.decodeFile(this.f587d)));
                try {
                    W(this.f587d, "/storage/emulated/0/MUMS_Images/");
                } catch (Exception e4) {
                }
            }
        } else if (requestCode == 5 && resultCode == -1) {
            Uri uri = data.getData();
            try {
                this.f596e = jw0.e(this.f521a, uri);
                this.f522a = uri;
            } catch (Exception e5) {
                e5.printStackTrace();
                Toast.makeText(this.f521a, e5.getMessage(), 0).show();
            }
            r0 r0Var = new r0();
            this.f541a = r0Var;
            r0Var.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 2296:
                if (grantResults.length > 0) {
                    boolean WRITE_EXTERNAL_STORAGE = true;
                    boolean READ_EXTERNAL_STORAGE = grantResults[0] == 0;
                    if (grantResults[1] != 0) {
                        WRITE_EXTERNAL_STORAGE = false;
                    }
                    if (!READ_EXTERNAL_STORAGE || !WRITE_EXTERNAL_STORAGE) {
                        Toast.makeText(this, "Allow permission for storage access!", 0).show();
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    class p0 extends AsyncTask<String, Void, String> {

        /* renamed from: a  reason: collision with other field name */
        String f640a = "''";

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f641a = null;

        /* renamed from: a  reason: collision with other field name */
        boolean f642a = false;
        String b = "";

        p0() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            if (AddUserActivity.this.f599f.getText().toString().trim().length() > 0) {
                this.f640a = AddUserActivity.this.f599f.getText().toString();
            }
            AddUserActivity.this.f555b.setTitle("يرجى الانتظار..");
            AddUserActivity.this.f555b.setMessage("جاري إضافة الكروت الى السيرفر");
            AddUserActivity.this.f555b.setCancelable(false);
            AddUserActivity.this.f555b.setIndeterminate(false);
            AddUserActivity.this.f555b.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                if (AddUserActivity.this.f591e.getText().toString().trim().length() > 4) {
                    if ((qb0.f4798a.getVersion() != null ? Integer.parseInt(qb0.f4798a.getVersion().substring(0, 1)) : 6) > 6) {
                        String cm = qb0.s.get(0).getAdm().replace("/tool", "");
                        j3 j3Var = AddUserActivity.this.f544a;
                        this.f641a = j3Var.q(cm + " name=" + AddUserActivity.this.f591e.getText().toString() + " password=" + this.f640a + " shared-users=0 caller-id=bind");
                        j3 j3Var2 = AddUserActivity.this.f544a;
                        j3Var2.q("/user-manager/user-profile/add user=" + ((String) this.f641a.get(0).get("ret")) + " profile=\"" + AddUserActivity.this.f602f.getSelectedItem().toString() + "\"");
                    } else if (AddUserActivity.this.f598f.isChecked()) {
                        j3 j3Var3 = AddUserActivity.this.f544a;
                        this.f641a = j3Var3.q(qb0.s.get(0).getAdm() + " username=" + AddUserActivity.this.f591e.getText().toString() + " password=" + this.f640a + " caller-id-bind-on-first-use=yes customer=" + AddUserActivity.this.f563b.getSelectedItem().toString() + "");
                        j3 j3Var4 = AddUserActivity.this.f544a;
                        j3Var4.q("/tool/user-manager/user/create-and-activate-profile numbers=" + ((String) this.f641a.get(0).get("ret")) + " profile=\"" + AddUserActivity.this.f602f.getSelectedItem().toString() + "\" customer=" + AddUserActivity.this.f563b.getSelectedItem().toString() + "");
                    } else {
                        j3 j3Var5 = AddUserActivity.this.f544a;
                        this.f641a = j3Var5.q(qb0.s.get(0).getAdm() + " username=" + AddUserActivity.this.f591e.getText().toString() + " password=" + this.f640a + " customer=" + AddUserActivity.this.f563b.getSelectedItem().toString() + "");
                        j3 j3Var6 = AddUserActivity.this.f544a;
                        j3Var6.q("/tool/user-manager/user/create-and-activate-profile numbers=" + ((String) this.f641a.get(0).get("ret")) + " profile=\"" + AddUserActivity.this.f602f.getSelectedItem().toString() + "\" customer=" + AddUserActivity.this.f563b.getSelectedItem().toString() + "");
                    }
                    qb0.f4807b.add(new UsermanagerCards((String) this.f641a.get(0).get("ret"), AddUserActivity.this.f591e.getText().toString(), AddUserActivity.this.f591e.getText().toString(), AddUserActivity.this.f602f.getSelectedItem().toString(), "", "0", "0", "notprint", false, false, "never", AddUserActivity.this.e));
                    return null;
                }
                this.b = "يجب ان يكون طول اسم المستخدم اكبر من او يساوي 5";
                this.f642a = true;
                return null;
            } catch (Exception e) {
                try {
                    this.b = e.getMessage();
                    this.f642a = true;
                    return null;
                } catch (Exception e2) {
                    this.b = e2.getMessage();
                    this.f642a = true;
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            try {
                AddUserActivity.this.f555b.dismiss();
                if (this.f642a) {
                    Toast.makeText(AddUserActivity.this.f521a, this.b, 1).show();
                } else {
                    Toast.makeText(AddUserActivity.this.f521a, "تمت الإضافة", 1).show();
                }
            } catch (Exception e) {
                AddUserActivity.this.f555b.dismiss();
                Toast.makeText(AddUserActivity.this.f521a, this.b, 1).show();
            }
        }
    }

    public String k0(String bag, String marble, int index) {
        String bagBegin = bag.substring(0, index);
        String bagEnd = bag.substring(index);
        return bagBegin + marble + bagEnd;
    }

    class s0 extends AsyncTask<String, Integer, String> {

        /* renamed from: a  reason: collision with other field name */
        String f646a = "";

        s0() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            AddUserActivity.this.f520a.setTitle("توليد كروت");
            AddUserActivity.this.f520a.setMessage("جاري توليد كروت يوزر مانجر");
            AddUserActivity.this.f520a.setCancelable(false);
            AddUserActivity.this.f520a.setIndeterminate(false);
            AddUserActivity.this.f520a.setMax(100);
            AddUserActivity.this.f520a.setProgress(0);
            AddUserActivity.this.f520a.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                Set<String> names = new HashSet<>();
                try {
                    if (qb0.f4807b != null) {
                        for (int j = 0; j < qb0.f4807b.size(); j++) {
                            names.add(qb0.f4807b.get(j).getUname());
                        }
                    }
                    ArrayList<DeleteUser> arrayList = qb0.r;
                    if (arrayList != null && arrayList.size() > 1) {
                        for (int j2 = 0; j2 < qb0.r.size(); j2++) {
                            names.add(qb0.r.get(j2).getUname());
                        }
                    }
                    int i = 0;
                    while (true) {
                        AddUserActivity addUserActivity = AddUserActivity.this;
                        if (i >= addUserActivity.f554b) {
                            return null;
                        }
                        if (addUserActivity.f588d) {
                            return null;
                        }
                        if (AddUserActivity.this.f532a.isChecked()) {
                            this.f646a = AddUserActivity.this.f559b.getText().toString().trim() + String.valueOf(AddUserActivity.a0(Integer.parseInt(AddUserActivity.this.f612h.getSelectedItem().toString()))) + AddUserActivity.this.f571c.getText().toString().trim();
                        } else {
                            this.f646a = AddUserActivity.this.f559b.getText().toString() + String.valueOf(AddUserActivity.e0(Integer.parseInt(AddUserActivity.this.f612h.getSelectedItem().toString()))) + AddUserActivity.this.f571c.getText().toString().trim();
                        }
                        if (AddUserActivity.this.f582d.getText().toString().trim().length() > 0) {
                            AddUserActivity addUserActivity2 = AddUserActivity.this;
                            addUserActivity2.f566b = addUserActivity2.k0(this.f646a, addUserActivity2.f582d.getText().toString(), this.f646a.length() / 2);
                        } else {
                            AddUserActivity.this.f566b = this.f646a;
                        }
                        if (AddUserActivity.this.f590e.isChecked()) {
                            AddUserActivity addUserActivity3 = AddUserActivity.this;
                            addUserActivity3.f577c = addUserActivity3.f566b;
                        } else if (AddUserActivity.this.f593e.isChecked()) {
                            AddUserActivity addUserActivity4 = AddUserActivity.this;
                            addUserActivity4.f577c = String.valueOf(AddUserActivity.a0(Integer.parseInt(addUserActivity4.f616i.getSelectedItem().toString())));
                        } else {
                            AddUserActivity.this.f577c = "";
                        }
                        Thread.sleep(2);
                        if (names.contains(AddUserActivity.this.f566b)) {
                            i--;
                        } else {
                            ArrayList L = AddUserActivity.this.f547a;
                            AddUserActivity addUserActivity5 = AddUserActivity.this;
                            L.add(new AddUser(addUserActivity5.f566b, addUserActivity5.f577c, addUserActivity5.f533a.getSelectedItem().toString(), "no", false));
                            names.add(AddUserActivity.this.f566b);
                        }
                        publishProgress(new Integer[]{Integer.valueOf((int) ((((float) i) / ((float) AddUserActivity.this.f554b)) * 100.0f))});
                        i++;
                    }
                } catch (Exception e) {
                    return null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void onProgressUpdate(Integer... values) {
            AddUserActivity.this.f520a.setProgress(values[0].intValue());
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            try {
                if (AddUserActivity.this.f520a.isShowing()) {
                    AddUserActivity.this.f520a.dismiss();
                }
                qb0.f4835m = AddUserActivity.this.f547a;
                AddUserActivity.this.f519a.notifyDataSetChanged();
            } catch (Exception e) {
            }
        }
    }

    class r0 extends AsyncTask<String, Integer, String> {
        int a;

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f645a = null;

        r0() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            AddUserActivity.this.f555b.setTitle("يرجى الانتظار..");
            AddUserActivity.this.f555b.setMessage("جاري طباعة الكروت الى ملف PDF ...");
            AddUserActivity.this.f555b.setCancelable(false);
            AddUserActivity.this.f555b.setIndeterminate(false);
            AddUserActivity.this.f555b.show();
            AddUserActivity addUserActivity = AddUserActivity.this;
            addUserActivity.f597e = false;
            addUserActivity.f627m = "no";
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                AddUserActivity.this.f518a = 0;
                String strDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Calendar.getInstance().getTime());
                int x = Integer.parseInt(AddUserActivity.this.f615i.getText().toString());
                int y = Integer.parseInt(AddUserActivity.this.f619j.getText().toString());
                for (int i = 0; i < AddUserActivity.this.f547a.size(); i++) {
                    if (((AddUser) AddUserActivity.this.f547a.get(i)).getStatus().equals("yes")) {
                        this.a++;
                    }
                }
                if (this.a <= 0) {
                    AddUserActivity.this.f568b = false;
                    return null;
                } else if (AddUserActivity.this.f587d.isEmpty()) {
                    return null;
                } else {
                    if (AddUserActivity.this.C0("cards_Userman_" + strDate, AddUserActivity.this.f556b, x, y).booleanValue()) {
                        AddUserActivity.this.f568b = true;
                        return null;
                    }
                    AddUserActivity.this.f568b = false;
                    return null;
                }
            } catch (Exception e) {
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            AddUserActivity addUserActivity = AddUserActivity.this;
            if (addUserActivity.f568b) {
                addUserActivity.f555b.dismiss();
                Context context = AddUserActivity.this.f521a;
                Toast.makeText(context, "تم حفظ الملف بنجاح..عدد الكروت : " + String.valueOf(AddUserActivity.this.f518a), 0).show();
            } else {
                addUserActivity.f555b.dismiss();
                AddUserActivity addUserActivity2 = AddUserActivity.this;
                if (addUserActivity2.f518a <= 0) {
                    Context context2 = addUserActivity2.f521a;
                    Toast.makeText(context2, AddUserActivity.this.f627m + "لم يتم الحفظ..قم بإضافة الكروت الى السيرفر قبل الطباعة", 0).show();
                } else {
                    Toast.makeText(addUserActivity2.f521a, "حدث خطأ اثناء الحفظ", 0).show();
                }
            }
            AddUserActivity addUserActivity3 = AddUserActivity.this;
            if (addUserActivity3.f597e) {
                Toast.makeText(addUserActivity3.f521a, addUserActivity3.f627m, 0).show();
            }
        }
    }

    class q0 extends AsyncTask<String, Integer, String> {
        int a;

        q0() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            AddUserActivity.this.f555b.setTitle("يرجى الانتظار..");
            AddUserActivity.this.f555b.setMessage("جاري طباعة الكروت الى ملف PDF ...");
            AddUserActivity.this.f555b.setCancelable(false);
            AddUserActivity.this.f555b.setIndeterminate(false);
            AddUserActivity.this.f555b.show();
            AddUserActivity addUserActivity = AddUserActivity.this;
            addUserActivity.f597e = false;
            addUserActivity.f627m = "no";
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                AddUserActivity.this.f518a = 0;
                String strDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Calendar.getInstance().getTime());
                int x = Integer.parseInt(AddUserActivity.this.f615i.getText().toString());
                int y = Integer.parseInt(AddUserActivity.this.f619j.getText().toString());
                for (int i = 0; i < AddUserActivity.this.f547a.size(); i++) {
                    if (((AddUser) AddUserActivity.this.f547a.get(i)).getStatus().equals("yes")) {
                        this.a++;
                    }
                }
                if (this.a <= 0) {
                    AddUserActivity.this.f568b = false;
                    return null;
                } else if (AddUserActivity.this.f587d.isEmpty()) {
                    return null;
                } else {
                    if (AddUserActivity.this.B0("cards_Userman_" + strDate, "MUMS_odai_dammag", x, y).booleanValue()) {
                        AddUserActivity.this.f568b = true;
                        return null;
                    }
                    AddUserActivity.this.f568b = false;
                    return null;
                }
            } catch (Exception e) {
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            AddUserActivity addUserActivity = AddUserActivity.this;
            if (addUserActivity.f568b) {
                addUserActivity.f555b.dismiss();
                if (Build.VERSION.SDK_INT >= 29) {
                    Context context = AddUserActivity.this.f521a;
                    Toast.makeText(context, "تم حفظ الملف بنجاح..عدد الكروت : " + String.valueOf(AddUserActivity.this.f518a) + " المسار الرئيسي للذاكرة ", 0).show();
                } else {
                    Context context2 = AddUserActivity.this.f521a;
                    Toast.makeText(context2, "تم حفظ الملف بنجاح..عدد الكروت : " + String.valueOf(AddUserActivity.this.f518a) + " مجلد MUMS_Cards ", 0).show();
                }
            } else {
                addUserActivity.f555b.dismiss();
                AddUserActivity addUserActivity2 = AddUserActivity.this;
                if (addUserActivity2.f518a <= 0) {
                    Toast.makeText(addUserActivity2.f521a, "لم يتم الحفظ..قم بإضافة الكروت الى السيرفر قبل الطباعة", 0).show();
                } else {
                    Toast.makeText(addUserActivity2.f521a, "حدث خطأ اثناء الحفظ", 0).show();
                }
            }
            AddUserActivity addUserActivity3 = AddUserActivity.this;
            if (addUserActivity3.f597e) {
                Toast.makeText(addUserActivity3.f521a, addUserActivity3.f627m, 0).show();
            }
        }
    }

    public File b0(String albumName) {
        File file = new File(Environment.getExternalStorageDirectory() + albumName);
        if (!file.mkdirs()) {
            Log.e("MUMS_Cards", "Directory not created");
        }
        return file;
    }

    public int g0() {
        int a2 = 0;
        for (int i2 = 0; i2 < this.f547a.size(); i2++) {
            if (this.f547a.get(i2).getStatus().equals("yes")) {
                a2++;
            }
        }
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:0x037e A[EDGE_INSN: B:114:0x037e->B:90:0x037e ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x020e A[Catch:{ IOException -> 0x03d3, ih -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0214 A[Catch:{ IOException -> 0x03d3, ih -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x024d A[Catch:{ IOException -> 0x03d3, ih -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0391 A[Catch:{ IOException -> 0x03bd, ih -> 0x03bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x039a A[Catch:{ IOException -> 0x03bd, ih -> 0x03bb }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Boolean B0(java.lang.String r40, java.lang.String r41, int r42, int r43) {
        /*
            r39 = this;
            r15 = r39
            r14 = r40
            r13 = 0
            r10 = 1
            r15.f518a = r13     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.lang.String r0 = r15.f587d     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            boolean r0 = r0.isEmpty()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            if (r0 != 0) goto L_0x039d
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r1 = 30
            java.lang.String r2 = ".pdf"
            if (r0 < r1) goto L_0x0048
            java.io.File r0 = new java.io.File     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r1.<init>()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.lang.String r3 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.io.File r3 = android.os.Environment.getExternalStoragePublicDirectory(r3)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r1.append(r3)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.lang.String r3 = "/"
            r1.append(r3)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r1.append(r14)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r1.append(r2)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r0.<init>(r1)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r15.f545a = r0     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            boolean r0 = r0.exists()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            if (r0 != 0) goto L_0x009e
            java.io.File r0 = r15.f545a     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r0.createNewFile()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            goto L_0x009e
        L_0x0048:
            r1 = 29
            if (r0 != r1) goto L_0x0073
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r0.<init>()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.lang.String r1 = "/storage/emulated/0/"
            r0.append(r1)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r0.append(r14)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r0.append(r2)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r1.<init>(r0)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r15.f545a = r1     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            boolean r1 = r1.exists()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            if (r1 != 0) goto L_0x0072
            java.io.File r1 = r15.f545a     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r1.createNewFile()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
        L_0x0072:
            goto L_0x009e
        L_0x0073:
            java.lang.String r0 = "/MUMS_Cards"
            r15.b0(r0)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r0.<init>()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.lang.String r1 = "/storage/emulated/0/MUMS_Cards/"
            r0.append(r1)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r0.append(r14)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r0.append(r2)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r1.<init>(r0)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r15.f545a = r1     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            boolean r1 = r1.exists()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            if (r1 != 0) goto L_0x009e
            java.io.File r1 = r15.f545a     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r1.createNewFile()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
        L_0x009e:
            gh r0 = new gh     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r0.<init>()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r1 = 1073741824(0x40000000, float:2.0)
            r2 = 1082130432(0x40800000, float:4.0)
            r3 = 0
            r7 = 1065353216(0x3f800000, float:1.0)
            r0.a(r7, r1, r2, r3)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.io.File r2 = r15.f545a     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.io.File r2 = r2.getAbsoluteFile()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r1.<init>(r2)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            v80 r1 = defpackage.v80.e0(r0, r1)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r25 = r1
            r0.open()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            k50 r1 = new k50     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r1.<init>()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r26 = r1
            r1 = 15
            r2 = 30
            android.view.ViewGroup r3 = r15.f523a     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 >= r4) goto L_0x00de
            r1 = 3
            r2 = 60
            r27 = r1
            r28 = r2
            goto L_0x0141
        L_0x00de:
            android.view.ViewGroup r3 = r15.f523a     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r4 = 306(0x132, float:4.29E-43)
            if (r3 >= r4) goto L_0x00fb
            android.view.ViewGroup r3 = r15.f523a     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r5 = 250(0xfa, float:3.5E-43)
            if (r3 <= r5) goto L_0x00fb
            r1 = 32
            r2 = 23
            r27 = r1
            r28 = r2
            goto L_0x0141
        L_0x00fb:
            android.view.ViewGroup r3 = r15.f523a     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r5 = 367(0x16f, float:5.14E-43)
            if (r3 <= r4) goto L_0x0116
            android.view.ViewGroup r3 = r15.f523a     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            if (r3 > r5) goto L_0x0116
            r1 = 30
            r2 = 23
            r27 = r1
            r28 = r2
            goto L_0x0141
        L_0x0116:
            android.view.ViewGroup r3 = r15.f523a     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r4 = 394(0x18a, float:5.52E-43)
            if (r3 <= r5) goto L_0x0131
            android.view.ViewGroup r3 = r15.f523a     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            if (r3 > r4) goto L_0x0131
            r1 = 29
            r2 = 23
            r27 = r1
            r28 = r2
            goto L_0x0141
        L_0x0131:
            android.view.ViewGroup r3 = r15.f523a     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            if (r3 <= r4) goto L_0x013d
            r1 = 28
            r2 = 23
        L_0x013d:
            r27 = r1
            r28 = r2
        L_0x0141:
            android.view.ViewGroup r1 = r15.f523a     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r1 = r1.getWidth()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            double r1 = (double) r1     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r3 = 4619792497756654797(0x401ccccccccccccd, double:7.2)
            double r1 = r1 / r3
            int r1 = (int) r1     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r4 = r1 + 1
            android.view.ViewGroup r1 = r15.f523a     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r1 = r1.getHeight()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            double r1 = (double) r1     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r5 = 4619342137793917747(0x401b333333333333, double:6.8)
            double r1 = r1 / r5
            int r1 = (int) r1     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            android.view.ViewGroup r2 = r15.f523a     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r2 = r2.getHeight()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r3 = 460(0x1cc, float:6.45E-43)
            if (r2 != r3) goto L_0x016d
            int r1 = r1 + 2
            r3 = r1
            goto L_0x016e
        L_0x016d:
            r3 = r1
        L_0x016e:
            android.view.ViewGroup r1 = r15.f523a     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r1 = r1.getWidth()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r1 = r1 / r4
            float r1 = (float) r1     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            android.view.ViewGroup r2 = r15.f523a     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r2 = r2.getHeight()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r2 = r2 / r3
            float r2 = (float) r2     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            android.widget.TextView r5 = r15.f576c     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r5 = r5.getHeight()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r6 = (int) r2     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r5 = r5 / r6
            r29 = r5
            android.widget.EditText r5 = r15.f615i     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            android.text.Editable r5 = r5.getText()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r5 = r5 - r28
            int r6 = (int) r1     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r5 = r5 / r6
            android.widget.EditText r6 = r15.f619j     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            android.text.Editable r6 = r6.getText()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r6 = r6 + r27
            int r8 = (int) r2     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r6 = r6 / r8
            java.lang.String r8 = r15.f604f     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r8 = r8 - r28
            int r9 = (int) r1     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r8 = r8 / r9
            java.lang.String r9 = r15.f610g     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r9 = r9 + r27
            int r11 = (int) r2     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r9 = r9 / r11
            java.lang.String r11 = r15.f614h     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r11 = r11 - r28
            int r12 = (int) r1     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r11 = r11 / r12
            java.lang.String r12 = r15.f618i     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r12 = java.lang.Integer.parseInt(r12)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r12 = r12 + r27
            int r7 = (int) r2     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r12 = r12 / r7
            java.lang.String r7 = r15.f587d     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            tr r7 = defpackage.tr.u0(r7)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r17 = 1058642330(0x3f19999a, float:0.6)
            android.view.ViewGroup r13 = r15.f523a     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r13 = r13.getHeight()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r10 = 286(0x11e, float:4.01E-43)
            if (r13 == r10) goto L_0x0200
            android.view.ViewGroup r10 = r15.f523a     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r10 = r10.getHeight()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r13 = 323(0x143, float:4.53E-43)
            if (r10 == r13) goto L_0x0200
            android.view.ViewGroup r10 = r15.f523a     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r10 = r10.getHeight()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r13 = 343(0x157, float:4.8E-43)
            if (r10 != r13) goto L_0x01fc
            goto L_0x0200
        L_0x01fc:
            r10 = 1058642330(0x3f19999a, float:0.6)
            goto L_0x0202
        L_0x0200:
            r10 = 1065353216(0x3f800000, float:1.0)
        L_0x0202:
            android.view.ViewGroup r13 = r15.f523a     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r13 = r13.getHeight()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r17 = r1
            r1 = 271(0x10f, float:3.8E-43)
            if (r13 != r1) goto L_0x0214
            r10 = 1050253722(0x3e99999a, float:0.3)
            r30 = r10
            goto L_0x0216
        L_0x0214:
            r30 = r10
        L_0x0216:
            float r1 = (float) r4     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            float r10 = (float) r3     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            float r10 = r10 - r30
            r7.Y0(r1, r10)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            d60 r1 = r25.Z()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r31 = r2
            r2 = r1
            r1 = 1
            u70 r10 = new u70     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r13 = r15.p     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r10.<init>((int) r13)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r13 = r10
            r10 = 1120403456(0x42c80000, float:100.0)
            r13.x0(r10)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r10 = r39.g0()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r20 = r1
            int r1 = r15.p     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r1 = r10 % r1
            r32 = r1
            r1 = 0
            r33 = r0
            r0 = r20
        L_0x0243:
            r20 = r3
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser> r3 = r15.f547a     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r3 = r3.size()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            if (r1 >= r3) goto L_0x037e
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser> r3 = r15.f547a     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser r3 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser) r3     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.lang.String r3 = r3.getStatus()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r21 = r4
            java.lang.String r4 = "yes"
            boolean r3 = r3.equals(r4)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            if (r3 == 0) goto L_0x0359
            int r3 = r15.f518a     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r19 = 1
            int r3 = r3 + 1
            r15.f518a = r3     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            android.widget.CheckBox r3 = r15.f570c     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            boolean r3 = r3.isChecked()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            if (r3 == 0) goto L_0x02e3
            q70 r3 = new q70     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser> r4 = r15.f547a     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.lang.Object r4 = r4.get(r1)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser r4 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser) r4     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.lang.String r4 = r4.getUname()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser> r14 = r15.f547a     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.lang.Object r14 = r14.get(r1)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser r14 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser) r14     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.lang.String r14 = r14.getPassword()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r24 = r10
            java.lang.String r10 = r15.f625l     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r35 = r1
            r34 = r17
            r1 = r39
            r17 = r13
            r36 = r20
            r13 = r3
            r3 = r7
            r37 = r21
            r38 = r7
            r7 = r14
            r14 = r24
            tr r1 = r1.f0(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r13.<init>((defpackage.tr) r1)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r1 = r13
            if (r32 <= 0) goto L_0x02bc
            if (r0 != r14) goto L_0x02ba
            int r3 = r15.p     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            int r3 = r3 - r32
            r4 = 1
            int r3 = r3 + r4
            r1.A0(r3)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            goto L_0x02bd
        L_0x02ba:
            r4 = 1
            goto L_0x02bd
        L_0x02bc:
            r4 = 1
        L_0x02bd:
            r3 = 0
            r1.R(r3)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r7 = 1075838976(0x40200000, float:2.5)
            r1.G0(r7)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r10 = 1065353216(0x3f800000, float:1.0)
            r1.H0(r10)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r13 = 1076468122(0x4029999a, float:2.65)
            r1.F0(r13)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r7 = r17
            r7.e(r1)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r3 = r1
            r1 = r7
            r4 = r14
            r10 = r35
            r7 = 0
            r13 = 1065353216(0x3f800000, float:1.0)
            r35 = r8
            r8 = r15
            goto L_0x0350
        L_0x02e3:
            r35 = r1
            r38 = r7
            r14 = r10
            r1 = r13
            r34 = r17
            r36 = r20
            r37 = r21
            r3 = 0
            r4 = 1
            r7 = 1075838976(0x40200000, float:2.5)
            r10 = 1065353216(0x3f800000, float:1.0)
            r13 = 1076468122(0x4029999a, float:2.65)
            q70 r3 = new q70     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser> r7 = r15.f547a     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r10 = r35
            java.lang.Object r7 = r7.get(r10)     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser r7 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser) r7     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.lang.String r16 = r7.getUname()     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            java.lang.String r19 = ""
            r20 = 0
            r21 = 0
            java.lang.String r7 = r15.f625l     // Catch:{ IOException -> 0x03d3, ih -> 0x03bf }
            r13 = r39
            r35 = r8
            r4 = r14
            r8 = 1075838976(0x40200000, float:2.5)
            r14 = r2
            r8 = r15
            r15 = r38
            r17 = r5
            r18 = r6
            r22 = r7
            r23 = r11
            r24 = r12
            tr r7 = r13.f0(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ IOException -> 0x0356, ih -> 0x0353 }
            r3.<init>((defpackage.tr) r7)     // Catch:{ IOException -> 0x0356, ih -> 0x0353 }
            if (r32 <= 0) goto L_0x0339
            if (r0 != r4) goto L_0x0339
            int r7 = r8.p     // Catch:{ IOException -> 0x0356, ih -> 0x0353 }
            int r7 = r7 - r32
            r13 = 1
            int r7 = r7 + r13
            r3.A0(r7)     // Catch:{ IOException -> 0x0356, ih -> 0x0353 }
        L_0x0339:
            r7 = 0
            r3.R(r7)     // Catch:{ IOException -> 0x03bd, ih -> 0x03bb }
            r13 = 1075838976(0x40200000, float:2.5)
            r3.G0(r13)     // Catch:{ IOException -> 0x03bd, ih -> 0x03bb }
            r13 = 1065353216(0x3f800000, float:1.0)
            r3.H0(r13)     // Catch:{ IOException -> 0x03bd, ih -> 0x03bb }
            r14 = 1076468122(0x4029999a, float:2.65)
            r3.F0(r14)     // Catch:{ IOException -> 0x03bd, ih -> 0x03bb }
            r1.e(r3)     // Catch:{ IOException -> 0x03bd, ih -> 0x03bb }
        L_0x0350:
            int r0 = r0 + 1
            goto L_0x036a
        L_0x0353:
            r0 = move-exception
            goto L_0x03c1
        L_0x0356:
            r0 = move-exception
            goto L_0x03d5
        L_0x0359:
            r38 = r7
            r35 = r8
            r4 = r10
            r8 = r15
            r34 = r17
            r36 = r20
            r37 = r21
            r7 = 0
            r10 = r1
            r1 = r13
            r13 = 1065353216(0x3f800000, float:1.0)
        L_0x036a:
            int r3 = r10 + 1
            r14 = r40
            r13 = r1
            r1 = r3
            r10 = r4
            r15 = r8
            r17 = r34
            r8 = r35
            r3 = r36
            r4 = r37
            r7 = r38
            goto L_0x0243
        L_0x037e:
            r37 = r4
            r38 = r7
            r35 = r8
            r4 = r10
            r8 = r15
            r34 = r17
            r36 = r20
            r7 = 0
            r10 = r1
            r1 = r13
            int r3 = r8.f518a     // Catch:{ IOException -> 0x03bd, ih -> 0x03bb }
            if (r3 <= 0) goto L_0x039a
            r3 = r33
            r3.c(r1)     // Catch:{ IOException -> 0x03bd, ih -> 0x03bb }
            r3.close()     // Catch:{ IOException -> 0x03bd, ih -> 0x03bb }
            goto L_0x039c
        L_0x039a:
            r3 = r33
        L_0x039c:
            goto L_0x03ac
        L_0x039d:
            r8 = r15
            r7 = 0
            android.content.Context r0 = r39.getApplicationContext()     // Catch:{ IOException -> 0x03bd, ih -> 0x03bb }
            java.lang.String r1 = "الرجاء تحديد الصوره"
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r7)     // Catch:{ IOException -> 0x03bd, ih -> 0x03bb }
            r0.show()     // Catch:{ IOException -> 0x03bd, ih -> 0x03bb }
        L_0x03ac:
            int r0 = r8.f518a     // Catch:{ IOException -> 0x03bd, ih -> 0x03bb }
            if (r0 <= 0) goto L_0x03b6
            r1 = 1
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)     // Catch:{ IOException -> 0x03bd, ih -> 0x03bb }
            return r0
        L_0x03b6:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r7)     // Catch:{ IOException -> 0x03bd, ih -> 0x03bb }
            return r0
        L_0x03bb:
            r0 = move-exception
            goto L_0x03c2
        L_0x03bd:
            r0 = move-exception
            goto L_0x03d6
        L_0x03bf:
            r0 = move-exception
            r8 = r15
        L_0x03c1:
            r7 = 0
        L_0x03c2:
            r0.printStackTrace()
            r1 = 1
            r8.f597e = r1
            java.lang.String r1 = r0.getMessage()
            r8.f627m = r1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r7)
            return r1
        L_0x03d3:
            r0 = move-exception
            r8 = r15
        L_0x03d5:
            r7 = 0
        L_0x03d6:
            r0.printStackTrace()
            r1 = 1
            r8.f597e = r1
            java.lang.String r1 = r0.getMessage()
            r8.f627m = r1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddUserActivity.B0(java.lang.String, java.lang.String, int, int):java.lang.Boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:125:0x034a A[EDGE_INSN: B:125:0x034a->B:95:0x034a ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01af A[Catch:{ IOException -> 0x036f, ih -> 0x036a }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01eb A[Catch:{ IOException -> 0x036f, ih -> 0x036a }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x035e A[Catch:{ IOException -> 0x0396, ih -> 0x0394 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0367 A[Catch:{ IOException -> 0x0396, ih -> 0x0394 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Boolean C0(java.lang.String r44, android.net.Uri r45, int r46, int r47) {
        /*
            r43 = this;
            r15 = r43
            r13 = 1
            java.lang.String r0 = ""
            gh r1 = new gh     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r1.<init>()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r10 = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r1.<init>()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r7 = r44
            r1.append(r7)     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            java.lang.String r2 = ".pdf"
            r1.append(r2)     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r0 = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r1.<init>()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            android.content.Context r2 = r15.f521a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r3 = 0
            java.io.File r2 = r2.getExternalFilesDir(r3)     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r1.append(r2)     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            java.lang.String r2 = "/"
            r1.append(r2)     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r25 = r1
            java.lang.String r1 = r15.f587d     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            boolean r1 = r1.isEmpty()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            if (r1 != 0) goto L_0x0374
            android.content.ContentResolver r1 = r43.getContentResolver()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            android.net.Uri r2 = r15.f522a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            java.lang.String r3 = "w"
            android.os.ParcelFileDescriptor r1 = r1.openFileDescriptor(r2, r3)     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r26 = r1
            r1 = 1073741824(0x40000000, float:2.0)
            r2 = 1082130432(0x40800000, float:4.0)
            r3 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r10.a(r4, r1, r2, r3)     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            java.io.FileDescriptor r2 = r26.getFileDescriptor()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            v80 r1 = defpackage.v80.e0(r10, r1)     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r27 = r1
            r10.open()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            k50 r1 = new k50     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r1.<init>()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r28 = r1
            r1 = 15
            r2 = 30
            android.view.ViewGroup r3 = r15.f523a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r5 = 200(0xc8, float:2.8E-43)
            if (r3 >= r5) goto L_0x0088
            r1 = 3
            r2 = 60
            r29 = r1
            r30 = r2
            goto L_0x00eb
        L_0x0088:
            android.view.ViewGroup r3 = r15.f523a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r5 = 306(0x132, float:4.29E-43)
            if (r3 >= r5) goto L_0x00a5
            android.view.ViewGroup r3 = r15.f523a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r6 = 250(0xfa, float:3.5E-43)
            if (r3 <= r6) goto L_0x00a5
            r1 = 32
            r2 = 23
            r29 = r1
            r30 = r2
            goto L_0x00eb
        L_0x00a5:
            android.view.ViewGroup r3 = r15.f523a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r6 = 367(0x16f, float:5.14E-43)
            if (r3 <= r5) goto L_0x00c0
            android.view.ViewGroup r3 = r15.f523a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            if (r3 > r6) goto L_0x00c0
            r1 = 30
            r2 = 23
            r29 = r1
            r30 = r2
            goto L_0x00eb
        L_0x00c0:
            android.view.ViewGroup r3 = r15.f523a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r5 = 394(0x18a, float:5.52E-43)
            if (r3 <= r6) goto L_0x00db
            android.view.ViewGroup r3 = r15.f523a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            if (r3 > r5) goto L_0x00db
            r1 = 29
            r2 = 23
            r29 = r1
            r30 = r2
            goto L_0x00eb
        L_0x00db:
            android.view.ViewGroup r3 = r15.f523a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            if (r3 <= r5) goto L_0x00e7
            r1 = 28
            r2 = 23
        L_0x00e7:
            r29 = r1
            r30 = r2
        L_0x00eb:
            android.view.ViewGroup r1 = r15.f523a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r1 = r1.getWidth()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            double r1 = (double) r1     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r5 = 4619792497756654797(0x401ccccccccccccd, double:7.2)
            double r1 = r1 / r5
            int r1 = (int) r1     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r3 = r1 + 1
            android.view.ViewGroup r1 = r15.f523a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r1 = r1.getHeight()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            double r1 = (double) r1     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r5 = 4619342137793917747(0x401b333333333333, double:6.8)
            double r1 = r1 / r5
            int r1 = (int) r1     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            android.view.ViewGroup r2 = r15.f523a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r2 = r2.getHeight()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r5 = 460(0x1cc, float:6.45E-43)
            if (r2 != r5) goto L_0x0115
            int r1 = r1 + 2
        L_0x0115:
            android.view.ViewGroup r2 = r15.f523a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r2 = r2.getWidth()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r2 = r2 / r3
            float r2 = (float) r2     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            android.view.ViewGroup r5 = r15.f523a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r5 = r5.getHeight()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r5 = r5 / r1
            float r12 = (float) r5     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            android.widget.EditText r5 = r15.f615i     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            android.text.Editable r5 = r5.getText()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r5 = r5 - r30
            int r6 = (int) r2     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r5 = r5 / r6
            android.widget.EditText r6 = r15.f619j     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            android.text.Editable r6 = r6.getText()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r6 = r6 + r29
            int r8 = (int) r12     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r6 = r6 / r8
            java.lang.String r8 = r15.f604f     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r8 = r8 - r30
            int r9 = (int) r2     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r8 = r8 / r9
            java.lang.String r9 = r15.f610g     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r9 = r9 + r29
            int r11 = (int) r12     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r9 = r9 / r11
            java.lang.String r11 = r15.f614h     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r11 = r11 - r30
            int r4 = (int) r2     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r11 = r11 / r4
            java.lang.String r4 = r15.f618i     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r4 = r4 + r29
            int r14 = (int) r12     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r4 = r4 / r14
            r31 = r12
            r12 = r4
            java.lang.String r4 = r15.f587d     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            tr r4 = defpackage.tr.u0(r4)     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r14 = r4
            r4 = 1058642330(0x3f19999a, float:0.6)
            android.view.ViewGroup r13 = r15.f523a     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            int r13 = r13.getHeight()     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            r32 = r0
            r0 = 286(0x11e, float:4.01E-43)
            if (r13 == r0) goto L_0x01a3
            android.view.ViewGroup r0 = r15.f523a     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            int r0 = r0.getHeight()     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            r13 = 323(0x143, float:4.53E-43)
            if (r0 == r13) goto L_0x01a3
            android.view.ViewGroup r0 = r15.f523a     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            int r0 = r0.getHeight()     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            r13 = 343(0x157, float:4.8E-43)
            if (r0 != r13) goto L_0x019f
            goto L_0x01a3
        L_0x019f:
            r0 = 1058642330(0x3f19999a, float:0.6)
            goto L_0x01a5
        L_0x01a3:
            r0 = 1065353216(0x3f800000, float:1.0)
        L_0x01a5:
            android.view.ViewGroup r4 = r15.f523a     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            int r4 = r4.getHeight()     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            r13 = 271(0x10f, float:3.8E-43)
            if (r4 != r13) goto L_0x01b2
            r0 = 1050253722(0x3e99999a, float:0.3)
        L_0x01b2:
            float r4 = (float) r3     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            float r13 = (float) r1     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            float r13 = r13 - r0
            r14.Y0(r4, r13)     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            d60 r4 = r27.Z()     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            r33 = r2
            r2 = r4
            r4 = 1
            u70 r13 = new u70     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            r34 = r0
            int r0 = r15.p     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            r13.<init>((int) r0)     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            r0 = r13
            r13 = 1120403456(0x42c80000, float:100.0)
            r0.x0(r13)     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            int r13 = r43.g0()     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            r19 = r1
            int r1 = r15.p     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            int r1 = r13 % r1
            r35 = r1
            r1 = 0
            r42 = r4
            r4 = r1
            r1 = r42
        L_0x01e1:
            r20 = r1
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser> r1 = r15.f547a     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            int r1 = r1.size()     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            if (r4 >= r1) goto L_0x034a
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser> r1 = r15.f547a     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser r1 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser) r1     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            java.lang.String r1 = r1.getStatus()     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            r21 = r3
            java.lang.String r3 = "yes"
            boolean r1 = r1.equals(r3)     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            if (r1 == 0) goto L_0x0326
            int r1 = r15.f518a     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            r3 = 1
            int r1 = r1 + r3
            r15.f518a = r1     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            android.widget.CheckBox r1 = r15.f570c     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            boolean r1 = r1.isChecked()     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            r36 = r0
            if (r1 == 0) goto L_0x0294
            q70 r1 = new q70     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser> r3 = r15.f547a     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser r3 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser) r3     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            java.lang.String r23 = r3.getUname()     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser> r3 = r15.f547a     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser r3 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser) r3     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            java.lang.String r24 = r3.getPassword()     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            java.lang.String r3 = r15.f625l     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            r15 = r1
            r37 = r19
            r0 = r20
            r1 = r43
            r19 = r3
            r38 = r21
            r3 = r14
            r16 = r4
            r20 = r14
            r14 = 1065353216(0x3f800000, float:1.0)
            r4 = r23
            r7 = r24
            r39 = r10
            r10 = r19
            tr r1 = r1.f0(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ IOException -> 0x028d, ih -> 0x0286 }
            r15.<init>((defpackage.tr) r1)     // Catch:{ IOException -> 0x028d, ih -> 0x0286 }
            r1 = r15
            if (r35 <= 0) goto L_0x0263
            if (r0 != r13) goto L_0x025f
            r3 = r43
            int r4 = r3.p     // Catch:{ IOException -> 0x0323, ih -> 0x0320 }
            int r4 = r4 - r35
            r7 = 1
            int r4 = r4 + r7
            r1.A0(r4)     // Catch:{ IOException -> 0x0323, ih -> 0x0320 }
            goto L_0x0266
        L_0x025f:
            r7 = 1
            r3 = r43
            goto L_0x0266
        L_0x0263:
            r7 = 1
            r3 = r43
        L_0x0266:
            r4 = 0
            r1.R(r4)     // Catch:{ IOException -> 0x0323, ih -> 0x0320 }
            r10 = 1075838976(0x40200000, float:2.5)
            r1.G0(r10)     // Catch:{ IOException -> 0x0323, ih -> 0x0320 }
            r1.H0(r14)     // Catch:{ IOException -> 0x0323, ih -> 0x0320 }
            r10 = 1076468122(0x4029999a, float:2.65)
            r1.F0(r10)     // Catch:{ IOException -> 0x0323, ih -> 0x0320 }
            r15 = r36
            r15.e(r1)     // Catch:{ IOException -> 0x0323, ih -> 0x0320 }
            r4 = r13
            r36 = r16
            r7 = r20
            r10 = 0
            r13 = 1
            goto L_0x031c
        L_0x0286:
            r0 = move-exception
            r10 = 0
            r13 = 1
            r3 = r43
            goto L_0x039b
        L_0x028d:
            r0 = move-exception
            r10 = 0
            r13 = 1
            r3 = r43
            goto L_0x03ae
        L_0x0294:
            r16 = r4
            r39 = r10
            r3 = r15
            r37 = r19
            r0 = r20
            r38 = r21
            r15 = r36
            r4 = 0
            r7 = 1
            r10 = 1076468122(0x4029999a, float:2.65)
            r20 = r14
            r14 = 1065353216(0x3f800000, float:1.0)
            q70 r1 = new q70     // Catch:{ IOException -> 0x0323, ih -> 0x0320 }
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser> r4 = r3.f547a     // Catch:{ IOException -> 0x0323, ih -> 0x0320 }
            r7 = r16
            java.lang.Object r4 = r4.get(r7)     // Catch:{ IOException -> 0x0323, ih -> 0x0320 }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser r4 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser) r4     // Catch:{ IOException -> 0x0323, ih -> 0x0320 }
            java.lang.String r16 = r4.getUname()     // Catch:{ IOException -> 0x0323, ih -> 0x0320 }
            java.lang.String r19 = ""
            r4 = 0
            r21 = 0
            java.lang.String r10 = r3.f625l     // Catch:{ IOException -> 0x0323, ih -> 0x0320 }
            r40 = r13
            r13 = r43
            r36 = r7
            r7 = r20
            r14 = r2
            r41 = r15
            r15 = r7
            r17 = r5
            r18 = r6
            r20 = r4
            r22 = r10
            r23 = r11
            r24 = r12
            tr r4 = r13.f0(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ IOException -> 0x0323, ih -> 0x0320 }
            r1.<init>((defpackage.tr) r4)     // Catch:{ IOException -> 0x0323, ih -> 0x0320 }
            if (r35 <= 0) goto L_0x0300
            r4 = r40
            if (r0 != r4) goto L_0x02fe
            int r10 = r3.p     // Catch:{ IOException -> 0x02fa, ih -> 0x02f6 }
            int r10 = r10 - r35
            r13 = 1
            int r10 = r10 + r13
            r1.A0(r10)     // Catch:{ IOException -> 0x02f3, ih -> 0x02f0 }
            goto L_0x0303
        L_0x02f0:
            r0 = move-exception
            goto L_0x039a
        L_0x02f3:
            r0 = move-exception
            goto L_0x03ad
        L_0x02f6:
            r0 = move-exception
            r13 = 1
            goto L_0x039a
        L_0x02fa:
            r0 = move-exception
            r13 = 1
            goto L_0x03ad
        L_0x02fe:
            r13 = 1
            goto L_0x0303
        L_0x0300:
            r4 = r40
            r13 = 1
        L_0x0303:
            r10 = 0
            r1.R(r10)     // Catch:{ IOException -> 0x0396, ih -> 0x0394 }
            r14 = 1075838976(0x40200000, float:2.5)
            r1.G0(r14)     // Catch:{ IOException -> 0x0396, ih -> 0x0394 }
            r14 = 1065353216(0x3f800000, float:1.0)
            r1.H0(r14)     // Catch:{ IOException -> 0x0396, ih -> 0x0394 }
            r15 = 1076468122(0x4029999a, float:2.65)
            r1.F0(r15)     // Catch:{ IOException -> 0x0396, ih -> 0x0394 }
            r15 = r41
            r15.e(r1)     // Catch:{ IOException -> 0x0396, ih -> 0x0394 }
        L_0x031c:
            int r0 = r0 + 1
            r1 = r0
            goto L_0x0339
        L_0x0320:
            r0 = move-exception
            goto L_0x036c
        L_0x0323:
            r0 = move-exception
            goto L_0x0371
        L_0x0326:
            r36 = r4
            r39 = r10
            r4 = r13
            r7 = r14
            r3 = r15
            r37 = r19
            r38 = r21
            r10 = 0
            r13 = 1
            r14 = 1065353216(0x3f800000, float:1.0)
            r15 = r0
            r0 = r20
            r1 = r0
        L_0x0339:
            int r0 = r36 + 1
            r13 = r4
            r14 = r7
            r19 = r37
            r10 = r39
            r7 = r44
            r4 = r0
            r0 = r15
            r15 = r3
            r3 = r38
            goto L_0x01e1
        L_0x034a:
            r38 = r3
            r36 = r4
            r39 = r10
            r4 = r13
            r7 = r14
            r3 = r15
            r37 = r19
            r10 = 0
            r13 = 1
            r15 = r0
            r0 = r20
            int r1 = r3.f518a     // Catch:{ IOException -> 0x0396, ih -> 0x0394 }
            if (r1 <= 0) goto L_0x0367
            r1 = r39
            r1.c(r15)     // Catch:{ IOException -> 0x0396, ih -> 0x0394 }
            r1.close()     // Catch:{ IOException -> 0x0396, ih -> 0x0394 }
            goto L_0x0369
        L_0x0367:
            r1 = r39
        L_0x0369:
            goto L_0x0386
        L_0x036a:
            r0 = move-exception
            r3 = r15
        L_0x036c:
            r10 = 0
            r13 = 1
            goto L_0x039b
        L_0x036f:
            r0 = move-exception
            r3 = r15
        L_0x0371:
            r10 = 0
            r13 = 1
            goto L_0x03ae
        L_0x0374:
            r32 = r0
            r1 = r10
            r3 = r15
            r10 = 0
            android.content.Context r0 = r43.getApplicationContext()     // Catch:{ IOException -> 0x0396, ih -> 0x0394 }
            java.lang.String r2 = "الرجاء تحديد الصوره"
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r2, r10)     // Catch:{ IOException -> 0x0396, ih -> 0x0394 }
            r0.show()     // Catch:{ IOException -> 0x0396, ih -> 0x0394 }
        L_0x0386:
            int r0 = r3.f518a     // Catch:{ IOException -> 0x0396, ih -> 0x0394 }
            if (r0 <= 0) goto L_0x038f
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r13)     // Catch:{ IOException -> 0x0396, ih -> 0x0394 }
            return r0
        L_0x038f:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r10)     // Catch:{ IOException -> 0x0396, ih -> 0x0394 }
            return r0
        L_0x0394:
            r0 = move-exception
            goto L_0x039b
        L_0x0396:
            r0 = move-exception
            goto L_0x03ae
        L_0x0398:
            r0 = move-exception
            r3 = r15
        L_0x039a:
            r10 = 0
        L_0x039b:
            r0.printStackTrace()
            r3.f597e = r13
            java.lang.String r1 = r0.getMessage()
            r3.f627m = r1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r10)
            return r1
        L_0x03ab:
            r0 = move-exception
            r3 = r15
        L_0x03ad:
            r10 = 0
        L_0x03ae:
            r0.printStackTrace()
            r3.f597e = r13
            java.lang.String r1 = r0.getMessage()
            r3.f627m = r1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r10)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddUserActivity.C0(java.lang.String, android.net.Uri, int, int):java.lang.Boolean");
    }

    /* access modifiers changed from: private */
    public void X(Uri pickerInitialUri) {
        String strDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Calendar.getInstance().getTime());
        Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("application/pdf");
        intent.putExtra("android.intent.extra.TITLE", "cards_Userman_" + strDate + ".pdf");
        intent.putExtra("android.provider.extra.INITIAL_URI", pickerInitialUri);
        startActivityForResult(intent, 5);
    }

    public static float U(float dp) {
        return (float) Math.round((((float) Resources.getSystem().getDisplayMetrics().densityDpi) / 160.0f) * dp);
    }

    public tr f0(d60 cb, tr img, String watermark, int x2, int y2, String watermark2, int x22, int y22, String watermarkSls, int xSls, int ySls) {
        b.C0035b bVar = b.C0035b.HELVETICA;
        com.itextpdf.text.b font = new com.itextpdf.text.b(bVar, (float) this.f, 1);
        font.q(this.f550a);
        com.itextpdf.text.b font_p = new com.itextpdf.text.b(bVar, (float) this.g, 1);
        font_p.q(this.f567b);
        com.itextpdf.text.b fontSls = new com.itextpdf.text.b(y5.d("assets/fonts/HacenCasablanca.ttf", "Identity-H", true), this.f553b, 0);
        fontSls.q(this.f578c);
        float width = img.B0();
        float height = img.A0();
        q80 template = cb.Q(width, height);
        template.m(img, width, 0.0f, 0.0f, height, 0.0f, 0.0f);
        q80 q80 = template;
        ia.U(q80, 1, new com.itextpdf.text.d(watermark, font), width - ((float) x2), height - ((float) y2), 0.0f);
        if (this.f570c.isChecked()) {
            q80 q802 = template;
            ia.U(q802, 1, new com.itextpdf.text.d(watermark2, font_p), width - ((float) x22), height - ((float) y22), 0.0f);
        }
        if (this.f581d.isChecked()) {
            q80 q803 = template;
            ia.V(q803, 1, new com.itextpdf.text.d(watermarkSls, fontSls), width - ((float) xSls), height - ((float) ySls), 0.0f, 3, 0);
        }
        return tr.t0(template);
    }

    public void slideUp(View view) {
        view.setVisibility(0);
        TranslateAnimation animate = new TranslateAnimation((float) view.getWidth(), 0.0f, 0.0f, 0.0f);
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
    }

    public void slideDown(View view) {
        TranslateAnimation animate = new TranslateAnimation(0.0f, (float) view.getWidth(), 0.0f, 0.0f);
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
        view.setVisibility(8);
    }

    public void onBackPressed() {
        new AlertDialog.Builder(this, R.style.CustomAlertDialog).setIcon(17301543).setTitle("تنبية !").setMessage("هل تريد الخروج من هذه النافذة؟").setPositiveButton("نعم", new y()).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
    }

    class y implements DialogInterface.OnClickListener {
        y() {
        }

        public void onClick(DialogInterface dialog, int which) {
            AddUserActivity.this.finish();
            i40.e(AddUserActivity.this.f521a);
        }
    }

    public void W(String srcDir, String dstDir) {
        try {
            File src = new File(srcDir);
            File dst = new File(dstDir, src.getName());
            if (src.isDirectory()) {
                for (String file : src.list()) {
                    W(new File(src, file).getPath(), dst.getPath());
                }
                return;
            }
            V(src, dst);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void V(java.io.File r9, java.io.File r10) {
        /*
            java.io.File r0 = r10.getParentFile()
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0011
            java.io.File r0 = r10.getParentFile()
            r0.mkdirs()
        L_0x0011:
            boolean r0 = r10.exists()
            if (r0 != 0) goto L_0x001a
            r10.createNewFile()
        L_0x001a:
            r0 = 0
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0045 }
            r2.<init>(r9)     // Catch:{ all -> 0x0045 }
            java.nio.channels.FileChannel r4 = r2.getChannel()     // Catch:{ all -> 0x0045 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ all -> 0x0043 }
            r0.<init>(r10)     // Catch:{ all -> 0x0043 }
            java.nio.channels.FileChannel r3 = r0.getChannel()     // Catch:{ all -> 0x0043 }
            r5 = 0
            long r7 = r4.size()     // Catch:{ all -> 0x0040 }
            r3.transferFrom(r4, r5, r7)     // Catch:{ all -> 0x0040 }
            r4.close()
            r3.close()
            return
        L_0x0040:
            r0 = move-exception
            r1 = r3
            goto L_0x0048
        L_0x0043:
            r0 = move-exception
            goto L_0x0048
        L_0x0045:
            r2 = move-exception
            r4 = r0
            r0 = r2
        L_0x0048:
            if (r4 == 0) goto L_0x004d
            r4.close()
        L_0x004d:
            if (r1 == 0) goto L_0x0052
            r1.close()
        L_0x0052:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddUserActivity.V(java.io.File, java.io.File):void");
    }

    public ArrayList<Model_images> Z(GridView gv_folder) {
        b.clear();
        try {
            File path = new File("/storage/emulated/0/MUMS_Images/");
            if (path.exists()) {
                String[] fileNames = path.list();
                for (int i2 = 0; i2 < fileNames.length; i2++) {
                    String str = fileNames[i2];
                    b.add(new Model_images(str, path.getPath() + "/" + fileNames[i2]));
                }
                t0 t0Var = new t0(getApplicationContext(), b);
                this.f548a = t0Var;
                gv_folder.setAdapter(t0Var);
            }
        } catch (Exception e2) {
        }
        return b;
    }

    public void j0() {
        try {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this, R.style.CustomAlertDialog);
            View myView = getLayoutInflater().inflate(R.layout.imglist_pop, (ViewGroup) null);
            dialogBuilder.setView(myView);
            GridView gv_folder = (GridView) myView.findViewById(R.id.gv_folder);
            TextView refresh_img = (TextView) myView.findViewById(R.id.refresh_img);
            TextView from_geliry = (TextView) myView.findViewById(R.id.from_geliry);
            dialogBuilder.create().show();
            if (T()) {
                Z(gv_folder);
            } else {
                w0();
            }
            gv_folder.setOnItemClickListener(new z());
            refresh_img.setOnClickListener(new a0(gv_folder));
            from_geliry.setOnClickListener(new b0());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    class z implements AdapterView.OnItemClickListener {
        z() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            AddUserActivity.this.f523a.setBackground(new BitmapDrawable(BitmapFactory.decodeFile(AddUserActivity.b.get(i).getAl_imagepath())));
            AddUserActivity.this.f587d = AddUserActivity.b.get(i).getAl_imagepath();
        }
    }

    class a0 implements View.OnClickListener {
        final /* synthetic */ GridView a;

        a0(GridView gridView) {
            this.a = gridView;
        }

        public void onClick(View v) {
            AddUserActivity.this.Z(this.a);
        }
    }

    class b0 implements View.OnClickListener {
        b0() {
        }

        public void onClick(View v) {
            if (Build.VERSION.SDK_INT < 23) {
                AddUserActivity.this.startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 1);
            } else if (AddUserActivity.this.T()) {
                AddUserActivity.this.startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 1);
            } else {
                AddUserActivity.this.w0();
            }
        }
    }

    public void x0() {
        try {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this, R.style.CustomAlertDialog);
            View myView = getLayoutInflater().inflate(R.layout.save_hots_profile_pop, (ViewGroup) null);
            dialogBuilder.setView(myView);
            androidx.appcompat.app.AlertDialog b2 = dialogBuilder.create();
            b2.show();
            ((TextView) myView.findViewById(R.id.save_profile_btn)).setOnClickListener(new c0((EditText) myView.findViewById(R.id.save_profile_name), b2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    class c0 implements View.OnClickListener {
        final /* synthetic */ EditText a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ androidx.appcompat.app.AlertDialog f629a;

        c0(EditText editText, androidx.appcompat.app.AlertDialog alertDialog) {
            this.a = editText;
            this.f629a = alertDialog;
        }

        public void onClick(View v) {
            if (AddUserActivity.this.S(this.a.getText().toString())) {
                this.f629a.dismiss();
            }
        }
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: NullPointerException in pass: CodeShrinkVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.instructions.args.InsnArg.wrapInstruction(InsnArg.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.inline(CodeShrinkVisitor.java:146)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:71)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    public boolean S(java.lang.String r31) {
        /*
            r30 = this;
            r1 = r30
            java.lang.String r0 = "1"
            java.lang.String r2 = "0"
            r3 = 0
            r4 = 0
            android.widget.Spinner r5 = r1.f612h     // Catch:{ Exception -> 0x013d }
            int r5 = r5.getSelectedItemPosition()     // Catch:{ Exception -> 0x013d }
            java.lang.String r12 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x013d }
            android.widget.Spinner r5 = r1.f616i     // Catch:{ Exception -> 0x013d }
            int r5 = r5.getSelectedItemPosition()     // Catch:{ Exception -> 0x013d }
            java.lang.String r13 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x013d }
            android.widget.Spinner r5 = r1.f594e     // Catch:{ Exception -> 0x013d }
            int r5 = r5.getSelectedItemPosition()     // Catch:{ Exception -> 0x013d }
            java.lang.String r14 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x013d }
            android.widget.Spinner r5 = r1.f585d     // Catch:{ Exception -> 0x013d }
            int r5 = r5.getSelectedItemPosition()     // Catch:{ Exception -> 0x013d }
            java.lang.String r26 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x013d }
            android.widget.Spinner r5 = r1.f533a     // Catch:{ Exception -> 0x013d }
            java.lang.Object r5 = r5.getSelectedItem()     // Catch:{ Exception -> 0x013d }
            java.lang.String r8 = r5.toString()     // Catch:{ Exception -> 0x013d }
            r5 = r0
            r6 = r0
            r7 = r2
            r9 = r2
            r10 = r2
            android.widget.RadioButton r11 = r1.f574c     // Catch:{ Exception -> 0x013d }
            boolean r11 = r11.isChecked()     // Catch:{ Exception -> 0x013d }
            if (r11 == 0) goto L_0x0049
            r5 = r0
            goto L_0x004a
        L_0x0049:
            r5 = r2
        L_0x004a:
            android.widget.RadioButton r11 = r1.f593e     // Catch:{ Exception -> 0x013d }
            boolean r11 = r11.isChecked()     // Catch:{ Exception -> 0x013d }
            if (r11 == 0) goto L_0x0056
            r6 = r0
            r27 = r6
            goto L_0x0059
        L_0x0056:
            r6 = r2
            r27 = r6
        L_0x0059:
            android.widget.CheckBox r6 = r1.f590e     // Catch:{ Exception -> 0x013d }
            boolean r6 = r6.isChecked()     // Catch:{ Exception -> 0x013d }
            if (r6 == 0) goto L_0x0065
            r6 = r0
            r28 = r6
            goto L_0x0068
        L_0x0065:
            r6 = r2
            r28 = r6
        L_0x0068:
            android.widget.CheckBox r6 = r1.f598f     // Catch:{ Exception -> 0x013d }
            boolean r6 = r6.isChecked()     // Catch:{ Exception -> 0x013d }
            if (r6 == 0) goto L_0x0074
            r6 = r0
            r29 = r6
            goto L_0x0077
        L_0x0074:
            r6 = r2
            r29 = r6
        L_0x0077:
            android.widget.CheckBox r6 = r1.f570c     // Catch:{ Exception -> 0x013d }
            boolean r6 = r6.isChecked()     // Catch:{ Exception -> 0x013d }
            if (r6 == 0) goto L_0x0081
            goto L_0x0082
        L_0x0081:
            r0 = r2
        L_0x0082:
            java.lang.String r2 = r31.trim()     // Catch:{ Exception -> 0x013d }
            int r2 = r2.length()     // Catch:{ Exception -> 0x013d }
            if (r2 > 0) goto L_0x0097
            java.lang.String r2 = "الرجاء كتابة اسم القالب"
            android.widget.Toast r2 = android.widget.Toast.makeText(r1, r2, r4)     // Catch:{ Exception -> 0x013d }
            r2.show()     // Catch:{ Exception -> 0x013d }
            goto L_0x0131
        L_0x0097:
            java.lang.String r2 = r8.trim()     // Catch:{ Exception -> 0x013d }
            int r2 = r2.length()     // Catch:{ Exception -> 0x013d }
            if (r2 > 0) goto L_0x00ac
            java.lang.String r2 = "الرجاء تحديد اسم فئة الكرت"
            android.widget.Toast r2 = android.widget.Toast.makeText(r1, r2, r4)     // Catch:{ Exception -> 0x013d }
            r2.show()     // Catch:{ Exception -> 0x013d }
            goto L_0x0131
        L_0x00ac:
            java.lang.String r2 = r1.f587d     // Catch:{ Exception -> 0x013d }
            boolean r2 = r2.isEmpty()     // Catch:{ Exception -> 0x013d }
            if (r2 == 0) goto L_0x00bf
            java.lang.String r2 = "الرجاء تحديد صورة قالب الطباعة"
            android.widget.Toast r2 = android.widget.Toast.makeText(r1, r2, r4)     // Catch:{ Exception -> 0x013d }
            r2.show()     // Catch:{ Exception -> 0x013d }
            goto L_0x0131
        L_0x00bf:
            ue r2 = r1.f549a     // Catch:{ Exception -> 0x013d }
            r15 = r31
            android.database.Cursor r2 = r2.v0(r15)     // Catch:{ Exception -> 0x013d }
            int r6 = r2.getCount()     // Catch:{ Exception -> 0x013d }
            if (r6 > 0) goto L_0x0133
            android.widget.CheckBox r6 = r1.f581d     // Catch:{ Exception -> 0x013d }
            boolean r6 = r6.isChecked()     // Catch:{ Exception -> 0x013d }
            if (r6 != 0) goto L_0x00d9
            r1.l = r4     // Catch:{ Exception -> 0x013d }
            r1.m = r4     // Catch:{ Exception -> 0x013d }
        L_0x00d9:
            ue r6 = r1.f549a     // Catch:{ Exception -> 0x013d }
            java.lang.String r11 = r1.f587d     // Catch:{ Exception -> 0x013d }
            int r7 = r1.h     // Catch:{ Exception -> 0x013d }
            java.lang.String r16 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x013d }
            int r7 = r1.i     // Catch:{ Exception -> 0x013d }
            java.lang.String r17 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x013d }
            int r7 = r1.j     // Catch:{ Exception -> 0x013d }
            java.lang.String r18 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x013d }
            int r7 = r1.k     // Catch:{ Exception -> 0x013d }
            java.lang.String r19 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x013d }
            int r7 = r1.l     // Catch:{ Exception -> 0x013d }
            java.lang.String r20 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x013d }
            int r7 = r1.m     // Catch:{ Exception -> 0x013d }
            java.lang.String r21 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x013d }
            int r7 = r1.n     // Catch:{ Exception -> 0x013d }
            java.lang.String r22 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x013d }
            int r7 = r1.o     // Catch:{ Exception -> 0x013d }
            java.lang.String r23 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x013d }
            r7 = r31
            r9 = r5
            r10 = r27
            r24 = r11
            r11 = r28
            r15 = r24
            r24 = r0
            r25 = r29
            boolean r6 = r6.Z(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)     // Catch:{ Exception -> 0x013d }
            r3 = r6
            if (r3 == 0) goto L_0x0131
            java.lang.String r6 = "تم حقظ البيانات بنجاح"
            android.widget.Toast r6 = android.widget.Toast.makeText(r1, r6, r4)     // Catch:{ Exception -> 0x013d }
            r6.show()     // Catch:{ Exception -> 0x013d }
            r30.Y()     // Catch:{ Exception -> 0x013d }
            r4 = 1
            return r4
        L_0x0131:
            return r3
        L_0x0133:
            java.lang.String r6 = "اسم الباقة موجوة بالفعل..قم بكتابة اسم اخر"
            android.widget.Toast r6 = android.widget.Toast.makeText(r1, r6, r4)     // Catch:{ Exception -> 0x013d }
            r6.show()     // Catch:{ Exception -> 0x013d }
            return r4
        L_0x013d:
            r0 = move-exception
            java.lang.String r2 = r0.getMessage()
            android.widget.Toast r2 = android.widget.Toast.makeText(r1, r2, r4)
            r2.show()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddUserActivity.S(java.lang.String):boolean");
    }

    /* access modifiers changed from: private */
    public void c0(String selected_size) {
        if (selected_size.equals("3")) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f523a.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = this.f529a;
            layoutParams2.width = 1390;
            this.q = 1390;
            this.f523a.setLayoutParams(layoutParams2);
            this.p = 3;
        } else if (selected_size.equals("4")) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f523a.getLayoutParams();
            LinearLayout.LayoutParams layoutParams4 = this.f529a;
            layoutParams4.width = 1037;
            this.q = 1037;
            this.f523a.setLayoutParams(layoutParams4);
            this.p = 4;
        }
    }

    /* access modifiers changed from: private */
    public void d0(String selected_size) {
        if (selected_size.equals("12")) {
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) this.f523a.getLayoutParams();
            params.height = 456;
            this.f523a.setLayoutParams(params);
            this.f553b = 8.5f;
            this.f595e.setTextSize(2, 18.5f);
        } else if (selected_size.equals("13")) {
            LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams) this.f523a.getLayoutParams();
            params2.height = HttpStatus.SC_FAILED_DEPENDENCY;
            this.f523a.setLayoutParams(params2);
            this.f553b = 8.4f;
            this.f595e.setTextSize(2, 18.0f);
        } else if (selected_size.equals("14")) {
            LinearLayout.LayoutParams params3 = (LinearLayout.LayoutParams) this.f523a.getLayoutParams();
            params3.height = 391;
            this.f523a.setLayoutParams(params3);
            this.f553b = 8.2f;
            this.f595e.setTextSize(2, 17.5f);
        } else if (selected_size.equals("15")) {
            LinearLayout.LayoutParams params4 = (LinearLayout.LayoutParams) this.f523a.getLayoutParams();
            params4.height = 364;
            this.f523a.setLayoutParams(params4);
            this.f553b = 8.1f;
            this.f595e.setTextSize(2, 17.0f);
        } else if (selected_size.equals("16")) {
            LinearLayout.LayoutParams params5 = (LinearLayout.LayoutParams) this.f523a.getLayoutParams();
            params5.height = 343;
            this.f523a.setLayoutParams(params5);
            this.f553b = 7.8f;
            this.f595e.setTextSize(2, 16.5f);
        } else if (selected_size.equals("17")) {
            LinearLayout.LayoutParams params6 = (LinearLayout.LayoutParams) this.f523a.getLayoutParams();
            params6.height = 323;
            this.f523a.setLayoutParams(params6);
            this.f553b = 7.7f;
            this.f595e.setTextSize(2, 16.0f);
        } else if (selected_size.equals("18")) {
            LinearLayout.LayoutParams params7 = (LinearLayout.LayoutParams) this.f523a.getLayoutParams();
            params7.height = HttpStatus.SC_SEE_OTHER;
            this.f523a.setLayoutParams(params7);
            this.f553b = 7.6f;
            this.f595e.setTextSize(2, 15.5f);
        } else if (selected_size.equals("19")) {
            LinearLayout.LayoutParams params8 = (LinearLayout.LayoutParams) this.f523a.getLayoutParams();
            params8.height = 286;
            this.f523a.setLayoutParams(params8);
            this.f553b = 7.3f;
            this.f595e.setTextSize(2, 15.0f);
        } else if (selected_size.equals("20")) {
            LinearLayout.LayoutParams params9 = (LinearLayout.LayoutParams) this.f523a.getLayoutParams();
            params9.height = 271;
            this.f523a.setLayoutParams(params9);
            this.f553b = 6.9f;
            this.f595e.setTextSize(2, 14.5f);
        }
    }

    /* access modifiers changed from: private */
    public void i0(String item) {
        try {
            try {
                Cursor data = this.f549a.v0(item);
                while (data.moveToNext()) {
                    try {
                        if (this.f524a != null) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= this.f524a.getCount()) {
                                    break;
                                } else if (this.f533a.getItemAtPosition(i2).equals(data.getString(2))) {
                                    this.f533a.setSelection(i2);
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                        }
                        if (data.getString(3).equals("1")) {
                            this.f574c.setChecked(true);
                            this.f532a.setChecked(false);
                        } else {
                            this.f574c.setChecked(false);
                            this.f532a.setChecked(true);
                        }
                        if (data.getString(14).equals("1")) {
                            this.f570c.setChecked(true);
                            this.f586d.setVisibility(0);
                        } else {
                            this.f570c.setChecked(false);
                            this.f586d.setVisibility(8);
                        }
                        if (data.getString(4).equals("1")) {
                            this.f593e.setChecked(true);
                            this.f584d.setChecked(false);
                        } else {
                            this.f593e.setChecked(false);
                            this.f584d.setChecked(true);
                        }
                        if (data.getString(5).equals("1")) {
                            this.f590e.setChecked(true);
                        } else {
                            this.f590e.setChecked(false);
                        }
                        if (data.getString(15).equals("1")) {
                            this.f598f.setChecked(true);
                        } else {
                            this.f598f.setChecked(false);
                        }
                        this.f612h.setSelection(Integer.parseInt(data.getString(6)));
                        this.f616i.setSelection(Integer.parseInt(data.getString(7)));
                        this.f594e.setSelection(Integer.parseInt(data.getString(8)));
                        this.f585d.setSelection(Integer.parseInt(data.getString(16)));
                        d0(this.f594e.getSelectedItem().toString());
                        c0(this.f585d.getSelectedItem().toString());
                        this.f587d = data.getString(9);
                        if (new File(this.f587d).exists()) {
                            this.f523a.setBackground(new BitmapDrawable(BitmapFactory.decodeFile(this.f587d)));
                        } else {
                            Toast.makeText(this.f521a, "لم يتم العثور على صورة القالب", 0).show();
                        }
                        if (data.getString(17) == null) {
                            this.f581d.setChecked(false);
                            this.f595e.setVisibility(8);
                        } else if (!data.getString(17).equals("0")) {
                            this.f581d.setChecked(true);
                            this.f595e.setVisibility(0);
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f576c.getLayoutParams();
                        layoutParams.leftMargin = Integer.parseInt(data.getString(10));
                        layoutParams.topMargin = Integer.parseInt(data.getString(11));
                        layoutParams.rightMargin = 0;
                        layoutParams.bottomMargin = 0;
                        this.f576c.setLayoutParams(layoutParams);
                        int ww = this.q - this.f576c.getWidth();
                        this.h = Integer.parseInt(data.getString(10));
                        this.i = Integer.parseInt(data.getString(11));
                        this.f615i.setText(String.valueOf(((this.f576c.getWidth() / 2) + ww) - Integer.parseInt(data.getString(10))));
                        this.f619j.setText(String.valueOf(Integer.valueOf(data.getString(11))));
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f586d.getLayoutParams();
                        layoutParams2.leftMargin = Integer.parseInt(data.getString(12));
                        layoutParams2.topMargin = Integer.parseInt(data.getString(13));
                        layoutParams2.rightMargin = 0;
                        layoutParams2.bottomMargin = 0;
                        this.f586d.setLayoutParams(layoutParams2);
                        this.j = Integer.parseInt(data.getString(12));
                        this.k = Integer.parseInt(data.getString(13));
                        this.f604f = String.valueOf(((this.f586d.getWidth() / 2) + (this.q - this.f586d.getWidth())) - Integer.parseInt(data.getString(12)));
                        this.f610g = String.valueOf(Integer.valueOf(data.getString(13)));
                        if (data.getString(17) == null) {
                            this.f595e.setVisibility(8);
                            this.f581d.setChecked(false);
                        } else if (Integer.parseInt(data.getString(17)) > 0) {
                            this.f595e.setVisibility(0);
                            this.f581d.setChecked(true);
                            RelativeLayout.LayoutParams layoutParamsSlsPoint = (RelativeLayout.LayoutParams) this.f595e.getLayoutParams();
                            layoutParamsSlsPoint.leftMargin = Integer.parseInt(data.getString(17));
                            layoutParamsSlsPoint.topMargin = Integer.parseInt(data.getString(18));
                            layoutParamsSlsPoint.rightMargin = 0;
                            layoutParamsSlsPoint.bottomMargin = 0;
                            this.f595e.setLayoutParams(layoutParamsSlsPoint);
                            this.l = Integer.parseInt(data.getString(17));
                            this.m = Integer.parseInt(data.getString(18));
                            this.f614h = String.valueOf(((this.f595e.getWidth() / 2) + (this.q - this.f595e.getWidth())) - Integer.parseInt(data.getString(17)));
                            this.f618i = String.valueOf(Integer.valueOf(data.getString(18)));
                        } else {
                            this.f595e.setVisibility(8);
                            this.f581d.setChecked(false);
                        }
                    } catch (Exception e2) {
                    }
                }
            } catch (Exception e3) {
            }
        } catch (Exception e4) {
            String str = item;
        }
    }

    /* access modifiers changed from: private */
    public void Y() {
        try {
            this.f537a.setVerticalScrollBarEnabled(false);
            this.f537a.setHorizontalScrollBarEnabled(false);
            this.f536a.setVerticalScrollBarEnabled(false);
            this.f536a.setHorizontalScrollBarEnabled(false);
            Cursor data = this.f549a.u0();
            List<String> list5 = new ArrayList<>();
            if (data.getCount() > 0) {
                list5.add("تحديد باقة محفوظة");
                slideUp(this.f530a);
                this.f617i.setText("اخفاء اعدادات الطباعة");
                this.f552a = true;
                while (data.moveToNext()) {
                    list5.add(data.getString(1));
                }
            } else {
                list5.add("لا يوجد باقات محفوظة");
            }
            ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<>(this, 17367048, list5);
            dataAdapter4.setDropDownViewResource(17367049);
            this.f608g.setAdapter(dataAdapter4);
        } catch (Exception e2) {
        }
    }

    public void A0() {
        ImageView plus_s;
        Spinner color_type_s;
        try {
            String[] colorList = {"000000", "FB0606", "0558FF", "00A200", "FFFF03", "FFA500", "FFFFFF"};
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this, R.style.CustomAlertDialog);
            LayoutInflater inflater = getLayoutInflater();
            View myView = inflater.inflate(R.layout.color_picker, (ViewGroup) null);
            dialogBuilder.setView(myView);
            TextView font_size_number_u = (TextView) myView.findViewById(R.id.font_size_number_u);
            ImageView plus_u = (ImageView) myView.findViewById(R.id.plus_u);
            ImageView menus_u = (ImageView) myView.findViewById(R.id.menus_u);
            Spinner color_type_u = (Spinner) myView.findViewById(R.id.color_type_u);
            TextView font_size_number_p = (TextView) myView.findViewById(R.id.font_size_number_p);
            ImageView plus_p = (ImageView) myView.findViewById(R.id.plus_p);
            ImageView menus_p = (ImageView) myView.findViewById(R.id.menus_p);
            Spinner color_type_p = (Spinner) myView.findViewById(R.id.color_type_p);
            TextView font_size_number_s = (TextView) myView.findViewById(R.id.font_size_number_s);
            ImageView plus_s2 = (ImageView) myView.findViewById(R.id.plus_s);
            ImageView menus_s = (ImageView) myView.findViewById(R.id.menus_s);
            Spinner color_type_s2 = (Spinner) myView.findViewById(R.id.color_type_s);
            font_size_number_u.setText(String.valueOf(this.f));
            font_size_number_p.setText(String.valueOf(this.g));
            font_size_number_s.setText(String.valueOf(this.f553b));
            TextView submit_btn = (TextView) myView.findViewById(R.id.submit_btn);
            TextView textView = (TextView) myView.findViewById(R.id.refresh_img);
            androidx.appcompat.app.AlertDialog b2 = dialogBuilder.create();
            b2.show();
            AlertDialog.Builder builder = dialogBuilder;
            try {
                ArrayList<SalesPointModel> colorModel = new ArrayList<>();
                LayoutInflater layoutInflater = inflater;
                View view = myView;
                plus_s = plus_s2;
                try {
                    colorModel.add(new SalesPointModel(1, "اسود", 0, 0));
                    colorModel.add(new SalesPointModel(2, "احمر", 0, 0));
                    colorModel.add(new SalesPointModel(3, "ازرق", 0, 0));
                    colorModel.add(new SalesPointModel(4, "اخضر", 0, 0));
                    colorModel.add(new SalesPointModel(5, "اصفر", 0, 0));
                    colorModel.add(new SalesPointModel(6, "برتقالي", 0, 0));
                    colorModel.add(new SalesPointModel(7, "ابيض", 0, 0));
                    ArrayAdapter<SalesPointModel> color_type_s_adapter = new ArrayAdapter<>(this.f521a, 17367048, colorModel);
                    color_type_s_adapter.setDropDownViewResource(17367049);
                    color_type_s = color_type_s2;
                    try {
                        color_type_s.setAdapter(color_type_s_adapter);
                        color_type_u.setAdapter(color_type_s_adapter);
                        color_type_p.setAdapter(color_type_s_adapter);
                    } catch (Exception e2) {
                    }
                } catch (Exception e3) {
                    color_type_s = color_type_s2;
                }
            } catch (Exception e4) {
                LayoutInflater layoutInflater2 = inflater;
                View view2 = myView;
                plus_s = plus_s2;
                color_type_s = color_type_s2;
            }
            color_type_s.setSelection(this.s, false);
            color_type_s.setOnItemSelectedListener(new d0(colorList));
            color_type_u.setSelection(this.r, false);
            color_type_u.setOnItemSelectedListener(new e0(colorList));
            color_type_p.setSelection(this.t, false);
            color_type_p.setOnItemSelectedListener(new f0(colorList));
            plus_u.setOnClickListener(new z1(this, font_size_number_u));
            menus_u.setOnClickListener(new x1(this, font_size_number_u));
            plus_p.setOnClickListener(new u1(this, font_size_number_p));
            menus_p.setOnClickListener(new v1(this, font_size_number_p));
            plus_s.setOnClickListener(new y1(this, font_size_number_s));
            menus_s.setOnClickListener(new w1(this, font_size_number_s));
            submit_btn.setOnClickListener(new h0(b2));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    class d0 implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ String[] f631a;

        d0(String[] strArr) {
            this.f631a = strArr;
        }

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SalesPointModel colorModel = (SalesPointModel) parent.getSelectedItem();
            String hexCode = this.f631a[colorModel.getId() - 1];
            int resultRed = Integer.valueOf(hexCode.substring(0, 2), 16).intValue();
            int resultGreen = Integer.valueOf(hexCode.substring(2, 4), 16).intValue();
            int resultBlue = Integer.valueOf(hexCode.substring(4, 6), 16).intValue();
            AddUserActivity.this.f595e.setTextColor(Color.rgb(resultRed, resultGreen, resultBlue));
            AddUserActivity.this.f578c = new w5(resultRed, resultGreen, resultBlue);
            AddUserActivity.this.s = colorModel.getId() - 1;
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class e0 implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ String[] f632a;

        e0(String[] strArr) {
            this.f632a = strArr;
        }

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SalesPointModel colorModel = (SalesPointModel) parent.getSelectedItem();
            String hexCode = this.f632a[colorModel.getId() - 1];
            int resultRed = Integer.valueOf(hexCode.substring(0, 2), 16).intValue();
            int resultGreen = Integer.valueOf(hexCode.substring(2, 4), 16).intValue();
            int resultBlue = Integer.valueOf(hexCode.substring(4, 6), 16).intValue();
            AddUserActivity.this.f576c.setTextColor(Color.rgb(resultRed, resultGreen, resultBlue));
            AddUserActivity.this.f550a = new w5(resultRed, resultGreen, resultBlue);
            AddUserActivity.this.r = colorModel.getId() - 1;
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class f0 implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ String[] f633a;

        f0(String[] strArr) {
            this.f633a = strArr;
        }

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SalesPointModel colorModel = (SalesPointModel) parent.getSelectedItem();
            String hexCode = this.f633a[colorModel.getId() - 1];
            int resultRed = Integer.valueOf(hexCode.substring(0, 2), 16).intValue();
            int resultGreen = Integer.valueOf(hexCode.substring(2, 4), 16).intValue();
            int resultBlue = Integer.valueOf(hexCode.substring(4, 6), 16).intValue();
            AddUserActivity.this.f586d.setTextColor(Color.rgb(resultRed, resultGreen, resultBlue));
            AddUserActivity.this.f567b = new w5(resultRed, resultGreen, resultBlue);
            AddUserActivity.this.t = colorModel.getId() - 1;
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n0(TextView font_size_number_u, View v2) {
        int i2 = this.f;
        if (i2 <= 13) {
            this.f = i2 + 1;
            TextView textView = this.f576c;
            textView.setTextSize(0, textView.getTextSize() + 2.0f);
            font_size_number_u.setText(String.valueOf(this.f));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o0(TextView font_size_number_u, View v2) {
        int i2 = this.f;
        if (i2 >= 8) {
            this.f = i2 - 1;
            TextView textView = this.f576c;
            textView.setTextSize(0, textView.getTextSize() - 2.0f);
            font_size_number_u.setText(String.valueOf(this.f));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p0(TextView font_size_number_p, View v2) {
        int i2 = this.g;
        if (i2 <= 13) {
            this.g = i2 + 1;
            TextView textView = this.f586d;
            textView.setTextSize(0, textView.getTextSize() + 2.0f);
            font_size_number_p.setText(String.valueOf(this.g));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q0(TextView font_size_number_p, View v2) {
        int i2 = this.g;
        if (i2 >= 8) {
            this.g = i2 - 1;
            TextView textView = this.f586d;
            textView.setTextSize(0, textView.getTextSize() - 2.0f);
            font_size_number_p.setText(String.valueOf(this.g));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r0(TextView font_size_number_s, View v2) {
        float f2 = this.f553b;
        if (f2 <= 12.0f) {
            this.f553b = f2 + 1.0f;
            TextView textView = this.f595e;
            textView.setTextSize(0, textView.getTextSize() + 1.0f);
            font_size_number_s.setText(String.valueOf(this.f553b));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s0(TextView font_size_number_s, View v2) {
        float f2 = this.f553b;
        if (f2 >= 8.0f) {
            this.f553b = f2 - 1.0f;
            TextView textView = this.f595e;
            textView.setTextSize(0, textView.getTextSize() - 1.0f);
            font_size_number_s.setText(String.valueOf(this.f553b));
        }
    }

    class h0 implements View.OnClickListener {
        final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        h0(androidx.appcompat.app.AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        public void onClick(View v) {
            this.a.dismiss();
        }
    }
}
