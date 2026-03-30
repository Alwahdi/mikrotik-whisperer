package com.blogspot.yemeninfo4it.mumsmobile_app.activities;

import android.app.ProgressDialog;
import android.content.Context;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Model_images;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.SalesPointModel;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards;
import com.itextpdf.text.b;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class PrintCardsActivity extends AppCompatActivity {
    private static final String[] a = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    public static ArrayList<Model_images> c = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    float f888a = 14.0f;

    /* renamed from: a  reason: collision with other field name */
    int f889a = 0;

    /* renamed from: a  reason: collision with other field name */
    a2 f890a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f891a;

    /* renamed from: a  reason: collision with other field name */
    Context f892a;

    /* renamed from: a  reason: collision with other field name */
    Uri f893a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public ViewGroup f894a;

    /* renamed from: a  reason: collision with other field name */
    Button f895a;

    /* renamed from: a  reason: collision with other field name */
    CheckBox f896a;

    /* renamed from: a  reason: collision with other field name */
    EditText f897a;

    /* renamed from: a  reason: collision with other field name */
    ImageView f898a;

    /* renamed from: a  reason: collision with other field name */
    LinearLayout.LayoutParams f899a;

    /* renamed from: a  reason: collision with other field name */
    LinearLayout f900a;

    /* renamed from: a  reason: collision with other field name */
    Spinner f901a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public TextView f902a;

    /* renamed from: a  reason: collision with other field name */
    RecyclerView f903a;

    /* renamed from: a  reason: collision with other field name */
    MyHorizScrollView f904a;

    /* renamed from: a  reason: collision with other field name */
    MyScrollView f905a;

    /* renamed from: a  reason: collision with other field name */
    s f906a;

    /* renamed from: a  reason: collision with other field name */
    t f907a;

    /* renamed from: a  reason: collision with other field name */
    ConnectData f908a;

    /* renamed from: a  reason: collision with other field name */
    protected j3 f909a;

    /* renamed from: a  reason: collision with other field name */
    File f910a = null;

    /* renamed from: a  reason: collision with other field name */
    final String f911a = "mLog";

    /* renamed from: a  reason: collision with other field name */
    ArrayList<AddUser> f912a;

    /* renamed from: a  reason: collision with other field name */
    t0 f913a;

    /* renamed from: a  reason: collision with other field name */
    ue f914a;

    /* renamed from: a  reason: collision with other field name */
    w5 f915a = new w5(0, 0, 0);

    /* renamed from: a  reason: collision with other field name */
    boolean f916a = false;
    float b = 8.5f;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public int f917b;

    /* renamed from: b  reason: collision with other field name */
    Uri f918b = null;

    /* renamed from: b  reason: collision with other field name */
    CheckBox f919b;

    /* renamed from: b  reason: collision with other field name */
    EditText f920b;

    /* renamed from: b  reason: collision with other field name */
    ImageView f921b;

    /* renamed from: b  reason: collision with other field name */
    LinearLayout f922b;

    /* renamed from: b  reason: collision with other field name */
    Spinner f923b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public TextView f924b;

    /* renamed from: b  reason: collision with other field name */
    String f925b = "";

    /* renamed from: b  reason: collision with other field name */
    ArrayList<UsermanagerCards> f926b;

    /* renamed from: b  reason: collision with other field name */
    w5 f927b = new w5(0, 0, 0);

    /* renamed from: b  reason: collision with other field name */
    boolean f928b = false;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with other field name */
    public int f929c;

    /* renamed from: c  reason: collision with other field name */
    CheckBox f930c;

    /* renamed from: c  reason: collision with other field name */
    ImageView f931c;

    /* renamed from: c  reason: collision with other field name */
    Spinner f932c;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with other field name */
    public TextView f933c;

    /* renamed from: c  reason: collision with other field name */
    String f934c = null;

    /* renamed from: c  reason: collision with other field name */
    w5 f935c = new w5(0, 0, 0);
    int d = 10;

    /* renamed from: d  reason: collision with other field name */
    Spinner f936d;

    /* renamed from: d  reason: collision with other field name */
    private TextView f937d;

    /* renamed from: d  reason: collision with other field name */
    String f938d = "1";
    int e = 10;

    /* renamed from: e  reason: collision with other field name */
    private TextView f939e;

    /* renamed from: e  reason: collision with other field name */
    String f940e = "1";
    int f = 0;

    /* renamed from: f  reason: collision with other field name */
    private TextView f941f;

    /* renamed from: f  reason: collision with other field name */
    String f942f = "1";
    int g = 0;

    /* renamed from: g  reason: collision with other field name */
    TextView f943g;

    /* renamed from: g  reason: collision with other field name */
    String f944g = "1";
    int h = 0;

    /* renamed from: h  reason: collision with other field name */
    TextView f945h;

    /* renamed from: h  reason: collision with other field name */
    String f946h = "no";
    int i = 0;

    /* renamed from: i  reason: collision with other field name */
    TextView f947i;

    /* renamed from: i  reason: collision with other field name */
    String f948i = "";
    int j = 0;
    int k = 0;
    int l = 3;
    int m = 0;
    int n = 0;
    int o = 0;
    int p = 0;
    int q = 0;
    int r = 0;
    int s = 255;
    int t = 153;
    int u = 51;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_print_cards);
        this.f892a = this;
        try {
            this.f909a = qb0.d();
            if (!H()) {
                h0();
            }
            this.f912a = new ArrayList<>();
            this.f926b = new ArrayList<>();
            this.f894a = (ViewGroup) findViewById(R.id.main);
            this.f905a = (MyScrollView) findViewById(R.id.scrollview);
            this.f904a = (MyHorizScrollView) findViewById(R.id.horizscroll);
            this.f900a = (LinearLayout) findViewById(R.id.print_layout);
            this.f902a = (TextView) findViewById(R.id.cardunum);
            TextView textView = (TextView) findViewById(R.id.passnum);
            this.f924b = textView;
            textView.setOnTouchListener(f0());
            TextView textView2 = (TextView) findViewById(R.id.slsnum);
            this.f933c = textView2;
            textView2.setOnTouchListener(g0());
            this.f923b = (Spinner) findViewById(R.id.sls_name_spinner);
            this.f941f = (TextView) findViewById(R.id.fonts_options);
            this.f896a = (CheckBox) findViewById(R.id.usr);
            this.f919b = (CheckBox) findViewById(R.id.pas);
            this.f930c = (CheckBox) findViewById(R.id.slscheck);
            this.f902a.setOnTouchListener(e0());
            this.f914a = new ue(this.f892a);
            this.f937d = (TextView) findViewById(R.id.font_size_number);
            this.f936d = (Spinner) findViewById(R.id.saved_profiles);
            TextView textView3 = (TextView) findViewById(R.id.head_tit);
            this.f947i = textView3;
            textView3.setText("إعادة طباعة الكروت");
            this.f943g = (TextView) findViewById(R.id.selectimg);
            this.f898a = (ImageView) findViewById(R.id.plus);
            this.f921b = (ImageView) findViewById(R.id.menus);
            this.f931c = (ImageView) findViewById(R.id.back_img);
            this.f945h = (TextView) findViewById(R.id.delete_saveprofile_pop);
            this.f908a = new ConnectData();
            this.f903a = (RecyclerView) findViewById(R.id.recycler_adduser);
            this.f897a = (EditText) findViewById(R.id.intx);
            this.f920b = (EditText) findViewById(R.id.inty);
            this.f901a = (Spinner) findViewById(R.id.cardsize);
            this.f932c = (Spinner) findViewById(R.id.card_rows);
            this.f939e = (TextView) findViewById(R.id.print_note);
            this.f922b = (LinearLayout) findViewById(R.id.sls_layout);
            this.f891a = new ProgressDialog(this);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f894a.getLayoutParams();
            this.f899a = layoutParams;
            layoutParams.height = 465;
            layoutParams.width = 1400;
            this.f894a.setLayoutParams(layoutParams);
            this.m = 1400;
            int sw = i0();
            if (sw > 1400) {
                this.f894a.getLayoutParams().width = 1400;
                this.m = 1400;
            }
            j0(sw);
            this.f888a = this.f902a.getTextSize() / getResources().getDisplayMetrics().scaledDensity;
            ArrayList<AddUser> arrayList = qb0.n;
            if (arrayList != null) {
                this.f912a = arrayList;
                a2 a2Var = new a2(this, arrayList);
                this.f890a = a2Var;
                this.f903a.setAdapter(a2Var);
            }
            List<String> list4 = new ArrayList<>();
            list4.add("3");
            list4.add("4");
            ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<>(this, 17367048, list4);
            dataAdapter3.setDropDownViewResource(17367049);
            this.f901a.setAdapter(dataAdapter3);
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
            ArrayAdapter<String> dataAdapter6 = new ArrayAdapter<>(this, 17367048, list6);
            dataAdapter6.setDropDownViewResource(17367049);
            this.f932c.setAdapter(dataAdapter6);
            this.f895a = (Button) findViewById(R.id.printbtn);
            this.f903a.setLayoutManager(new LinearLayoutManager(this));
            a2 a2Var2 = new a2(this.f892a, this.f912a);
            this.f890a = a2Var2;
            this.f903a.setAdapter(a2Var2);
            this.f903a.setItemAnimator(new DefaultItemAnimator());
            try {
                ArrayList<SalesPointModel> salesPointModels = new ArrayList<>();
                salesPointModels.add(new SalesPointModel(0, "اختار اسم النقطة", 0, 0));
                salesPointModels.addAll(this.f914a.p0());
                ArrayAdapter arrayAdapter = new ArrayAdapter(this.f892a, 17367048, salesPointModels);
                arrayAdapter.setDropDownViewResource(17367049);
                this.f923b.setAdapter(arrayAdapter);
            } catch (Exception e2) {
            }
            this.f923b.setOnItemSelectedListener(new j());
            if (Build.VERSION.SDK_INT >= 30) {
                this.f939e.setVisibility(0);
            }
            this.f931c.setOnClickListener(new k());
            this.f941f.setOnClickListener(new la0(this));
            this.f943g.setOnClickListener(new ka0(this));
            this.f901a.setOnItemSelectedListener(new l());
            this.f932c.setOnItemSelectedListener(new m());
            this.f895a.setOnClickListener(new n());
            this.f896a.setOnClickListener(new o());
            this.f919b.setOnClickListener(new p());
            this.f930c.setOnClickListener(new ma0(this));
            this.f936d.setOnItemSelectedListener(new q());
            M();
        } catch (Exception e3) {
            Log.d("mLog", e3.toString() + "error odai dammag");
            Context context = this.f892a;
            Toast.makeText(context, e3.toString() + "error", 1).show();
        }
    }

    class j implements AdapterView.OnItemSelectedListener {
        j() {
        }

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SalesPointModel salesPointModel = (SalesPointModel) parent.getSelectedItem();
            if (salesPointModel.getId() != 0) {
                PrintCardsActivity.this.o = salesPointModel.getId();
                PrintCardsActivity.this.f948i = salesPointModel.getName();
                Context context = PrintCardsActivity.this.f892a;
                Toast.makeText(context, "تم تحديد النقطة: " + salesPointModel.getName(), 0).show();
                return;
            }
            PrintCardsActivity.this.f948i = "....";
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class k implements View.OnClickListener {
        k() {
        }

        public void onClick(View v) {
            PrintCardsActivity.this.onBackPressed();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V(View v) {
        k0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W(View v) {
        U();
    }

    class l implements AdapterView.OnItemSelectedListener {
        l() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            PrintCardsActivity.this.P(adapterView.getItemAtPosition(position).toString());
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class m implements AdapterView.OnItemSelectedListener {
        m() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            PrintCardsActivity.this.Q(adapterView.getItemAtPosition(position).toString());
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class n implements View.OnClickListener {
        n() {
        }

        public void onClick(View v) {
            try {
                if (!PrintCardsActivity.this.H()) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 30) {
                    int aa = 0;
                    for (int i = 0; i < PrintCardsActivity.this.f912a.size(); i++) {
                        if (PrintCardsActivity.this.f912a.get(i).getStatus().equals("yes")) {
                            aa++;
                        }
                    }
                    if (aa <= 0) {
                        Toast.makeText(PrintCardsActivity.this.f892a, "الرجاء اضافة الكروت اولا", 0).show();
                    } else if (!PrintCardsActivity.this.f925b.isEmpty()) {
                        PrintCardsActivity.this.f918b = MediaStore.Files.getContentUri("external");
                        PrintCardsActivity printCardsActivity = PrintCardsActivity.this;
                        printCardsActivity.L(printCardsActivity.f918b);
                    } else {
                        Toast.makeText(PrintCardsActivity.this.getApplicationContext(), "الرجاء تحديد الصوره", 0).show();
                    }
                } else if (!PrintCardsActivity.this.f925b.isEmpty()) {
                    PrintCardsActivity.this.f906a = new s();
                    PrintCardsActivity.this.f906a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                } else {
                    Toast.makeText(PrintCardsActivity.this.getApplicationContext(), "الرجاء تحديد الصوره", 0).show();
                }
            } catch (Exception e) {
                Toast.makeText(PrintCardsActivity.this.f892a, e.getMessage(), 0).show();
            }
        }
    }

    class o implements View.OnClickListener {
        o() {
        }

        public void onClick(View v) {
            if (PrintCardsActivity.this.f896a.isChecked()) {
                PrintCardsActivity.this.f902a.setVisibility(0);
            } else {
                PrintCardsActivity.this.f902a.setVisibility(8);
            }
        }
    }

    class p implements View.OnClickListener {
        p() {
        }

        public void onClick(View v) {
            if (PrintCardsActivity.this.f919b.isChecked()) {
                PrintCardsActivity.this.f924b.setVisibility(0);
            } else {
                PrintCardsActivity.this.f924b.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X(View v) {
        if (this.f930c.isChecked()) {
            this.f922b.setVisibility(0);
            this.f933c.setVisibility(0);
            return;
        }
        this.f922b.setVisibility(8);
        this.f933c.setVisibility(8);
    }

    class q implements AdapterView.OnItemSelectedListener {
        q() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            Object item = adapterView.getItemAtPosition(position);
            if (!item.toString().equals("تحديد باقة محفوظة") && !item.toString().equals("لا يوجد باقات محفوظة")) {
                PrintCardsActivity.this.T(item.toString());
                PrintCardsActivity.this.T(item.toString());
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(jv0.b(newBase));
    }

    class r implements View.OnTouchListener {
        r() {
        }

        public boolean onTouch(View view, MotionEvent event) {
            int minw = PrintCardsActivity.this.f924b.getWidth() / 2;
            int dd = 1400 / PrintCardsActivity.this.f894a.getWidth();
            int ww = PrintCardsActivity.this.f894a.getWidth() - PrintCardsActivity.this.f924b.getWidth();
            int height = PrintCardsActivity.this.f894a.getHeight() - PrintCardsActivity.this.f924b.getHeight();
            int x = (int) event.getRawX();
            int y = (int) event.getRawY();
            float scale = PrintCardsActivity.this.getResources().getDisplayMetrics().density;
            int width_ = (int) ((((float) PrintCardsActivity.this.f894a.getWidth()) / scale) + 0.5f);
            float I = PrintCardsActivity.I((float) ((int) ((((float) PrintCardsActivity.this.f894a.getHeight()) / scale) - 0.5f)));
            float I2 = PrintCardsActivity.I((float) width_);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            int action = event.getAction() & 255;
            int height2 = PrintCardsActivity.this.f924b.getHeight() / 2;
            switch (action) {
                case 0:
                    View view2 = view;
                    int i = dd;
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    int i2 = minw;
                    PrintCardsActivity.this.f905a.setVerticalScrollBarEnabled(false);
                    PrintCardsActivity.this.f905a.setHorizontalScrollBarEnabled(false);
                    PrintCardsActivity.this.f904a.setVerticalScrollBarEnabled(false);
                    PrintCardsActivity.this.f904a.setHorizontalScrollBarEnabled(false);
                    int unused = PrintCardsActivity.this.f917b = x - lParams.leftMargin;
                    int unused2 = PrintCardsActivity.this.f929c = y - lParams.topMargin;
                    break;
                case 1:
                    View view3 = view;
                    int i3 = dd;
                    PrintCardsActivity.this.f905a.setScrolling(true);
                    PrintCardsActivity.this.f904a.setScrolling(true);
                    PrintCardsActivity printCardsActivity = PrintCardsActivity.this;
                    printCardsActivity.f938d = String.valueOf((minw + ww) - (x - printCardsActivity.f917b));
                    PrintCardsActivity printCardsActivity2 = PrintCardsActivity.this;
                    printCardsActivity2.f940e = String.valueOf(y - printCardsActivity2.f929c);
                    int i4 = minw;
                    break;
                case 2:
                    PrintCardsActivity.this.f905a.setScrolling(false);
                    PrintCardsActivity.this.f904a.setScrolling(false);
                    layoutParams.leftMargin = x - PrintCardsActivity.this.f917b;
                    layoutParams.topMargin = y - PrintCardsActivity.this.f929c;
                    layoutParams.rightMargin = 0;
                    layoutParams.bottomMargin = 0;
                    PrintCardsActivity printCardsActivity3 = PrintCardsActivity.this;
                    printCardsActivity3.h = x - printCardsActivity3.f917b;
                    PrintCardsActivity printCardsActivity4 = PrintCardsActivity.this;
                    printCardsActivity4.i = y - printCardsActivity4.f929c;
                    PrintCardsActivity printCardsActivity5 = PrintCardsActivity.this;
                    printCardsActivity5.f938d = String.valueOf((minw + ww) - (x - printCardsActivity5.f917b));
                    PrintCardsActivity printCardsActivity6 = PrintCardsActivity.this;
                    printCardsActivity6.f940e = String.valueOf(y - printCardsActivity6.f929c);
                    view.setLayoutParams(layoutParams);
                    int i5 = minw;
                    int i6 = dd;
                    break;
                case 8:
                    layoutParams.leftMargin = x - PrintCardsActivity.this.f917b;
                    layoutParams.topMargin = y - PrintCardsActivity.this.f929c;
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
            PrintCardsActivity.this.f894a.invalidate();
            return true;
        }
    }

    private View.OnTouchListener f0() {
        return new r();
    }

    class a implements View.OnTouchListener {
        a() {
        }

        public boolean onTouch(View view, MotionEvent event) {
            int minw = PrintCardsActivity.this.f933c.getWidth() / 2;
            int ww = PrintCardsActivity.this.f894a.getWidth() - PrintCardsActivity.this.f933c.getWidth();
            int x = (int) event.getRawX();
            int y = (int) event.getRawY();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            switch (event.getAction() & 255) {
                case 0:
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    PrintCardsActivity.this.f905a.setVerticalScrollBarEnabled(false);
                    PrintCardsActivity.this.f905a.setHorizontalScrollBarEnabled(false);
                    PrintCardsActivity.this.f904a.setVerticalScrollBarEnabled(false);
                    PrintCardsActivity.this.f904a.setHorizontalScrollBarEnabled(false);
                    int unused = PrintCardsActivity.this.f917b = x - lParams.leftMargin;
                    int unused2 = PrintCardsActivity.this.f929c = y - lParams.topMargin;
                    break;
                case 1:
                    PrintCardsActivity.this.f905a.setScrolling(true);
                    PrintCardsActivity.this.f904a.setScrolling(true);
                    PrintCardsActivity printCardsActivity = PrintCardsActivity.this;
                    printCardsActivity.f942f = String.valueOf((minw + ww) - (x - printCardsActivity.f917b));
                    PrintCardsActivity printCardsActivity2 = PrintCardsActivity.this;
                    printCardsActivity2.f944g = String.valueOf(y - printCardsActivity2.f929c);
                    break;
                case 2:
                    PrintCardsActivity.this.f905a.setScrolling(false);
                    PrintCardsActivity.this.f904a.setScrolling(false);
                    layoutParams.leftMargin = x - PrintCardsActivity.this.f917b;
                    layoutParams.topMargin = y - PrintCardsActivity.this.f929c;
                    layoutParams.rightMargin = 0;
                    layoutParams.bottomMargin = 0;
                    PrintCardsActivity printCardsActivity3 = PrintCardsActivity.this;
                    printCardsActivity3.j = x - printCardsActivity3.f917b;
                    PrintCardsActivity printCardsActivity4 = PrintCardsActivity.this;
                    printCardsActivity4.k = y - printCardsActivity4.f929c;
                    PrintCardsActivity printCardsActivity5 = PrintCardsActivity.this;
                    printCardsActivity5.f942f = String.valueOf((minw + ww) - (x - printCardsActivity5.f917b));
                    PrintCardsActivity printCardsActivity6 = PrintCardsActivity.this;
                    printCardsActivity6.f944g = String.valueOf(y - printCardsActivity6.f929c);
                    view.setLayoutParams(layoutParams);
                    break;
                case 8:
                    layoutParams.leftMargin = x - PrintCardsActivity.this.f917b;
                    layoutParams.topMargin = y - PrintCardsActivity.this.f929c;
                    break;
            }
            PrintCardsActivity.this.f894a.invalidate();
            return true;
        }
    }

    private View.OnTouchListener g0() {
        return new a();
    }

    class b implements View.OnTouchListener {
        b() {
        }

        public boolean onTouch(View view, MotionEvent event) {
            int minw = PrintCardsActivity.this.f902a.getWidth() / 2;
            int dd = 1400 / PrintCardsActivity.this.f894a.getWidth();
            int ww = PrintCardsActivity.this.f894a.getWidth() - PrintCardsActivity.this.f902a.getWidth();
            int height = PrintCardsActivity.this.f894a.getHeight() - PrintCardsActivity.this.f902a.getHeight();
            int x = (int) event.getRawX();
            int y = (int) event.getRawY();
            float scale = PrintCardsActivity.this.getResources().getDisplayMetrics().density;
            int width_ = (int) ((((float) PrintCardsActivity.this.f894a.getWidth()) / scale) + 0.5f);
            float I = PrintCardsActivity.I((float) ((int) ((((float) PrintCardsActivity.this.f894a.getHeight()) / scale) - 0.5f)));
            float I2 = PrintCardsActivity.I((float) width_);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            int action = event.getAction() & 255;
            int height2 = PrintCardsActivity.this.f902a.getHeight() / 2;
            switch (action) {
                case 0:
                    View view2 = view;
                    int i = dd;
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    int i2 = minw;
                    PrintCardsActivity.this.f905a.setVerticalScrollBarEnabled(false);
                    PrintCardsActivity.this.f905a.setHorizontalScrollBarEnabled(false);
                    PrintCardsActivity.this.f904a.setVerticalScrollBarEnabled(false);
                    PrintCardsActivity.this.f904a.setHorizontalScrollBarEnabled(false);
                    int unused = PrintCardsActivity.this.f917b = x - lParams.leftMargin;
                    int unused2 = PrintCardsActivity.this.f929c = y - lParams.topMargin;
                    break;
                case 1:
                    View view3 = view;
                    int i3 = dd;
                    PrintCardsActivity.this.f905a.setScrolling(true);
                    PrintCardsActivity.this.f904a.setScrolling(true);
                    PrintCardsActivity printCardsActivity = PrintCardsActivity.this;
                    printCardsActivity.f897a.setText(String.valueOf((minw + ww) - (x - printCardsActivity.f917b)));
                    PrintCardsActivity printCardsActivity2 = PrintCardsActivity.this;
                    printCardsActivity2.f920b.setText(String.valueOf(y - printCardsActivity2.f929c));
                    int i4 = minw;
                    break;
                case 2:
                    PrintCardsActivity.this.f905a.setScrolling(false);
                    PrintCardsActivity.this.f904a.setScrolling(false);
                    layoutParams.leftMargin = x - PrintCardsActivity.this.f917b;
                    layoutParams.topMargin = y - PrintCardsActivity.this.f929c;
                    layoutParams.rightMargin = 0;
                    layoutParams.bottomMargin = 0;
                    PrintCardsActivity printCardsActivity3 = PrintCardsActivity.this;
                    printCardsActivity3.f = x - printCardsActivity3.f917b;
                    PrintCardsActivity printCardsActivity4 = PrintCardsActivity.this;
                    printCardsActivity4.g = y - printCardsActivity4.f929c;
                    PrintCardsActivity printCardsActivity5 = PrintCardsActivity.this;
                    printCardsActivity5.f897a.setText(String.valueOf((minw + ww) - (x - printCardsActivity5.f917b)));
                    PrintCardsActivity printCardsActivity6 = PrintCardsActivity.this;
                    printCardsActivity6.f920b.setText(String.valueOf(y - printCardsActivity6.f929c));
                    view.setLayoutParams(layoutParams);
                    int i5 = minw;
                    int i6 = dd;
                    break;
                case 8:
                    layoutParams.leftMargin = x - PrintCardsActivity.this.f917b;
                    layoutParams.topMargin = y - PrintCardsActivity.this.f929c;
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
            PrintCardsActivity.this.f894a.invalidate();
            return true;
        }
    }

    private View.OnTouchListener e0() {
        return new b();
    }

    /* access modifiers changed from: private */
    public boolean H() {
        if (Build.VERSION.SDK_INT >= 30) {
            return Environment.isExternalStorageManager();
        }
        return ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") == 0 && ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    /* access modifiers changed from: private */
    public void h0() {
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
                        this.f925b = cursor.getString(cursor.getColumnIndex(projection[0]));
                        cursor.close();
                        this.f894a.setBackground(new BitmapDrawable(BitmapFactory.decodeFile(this.f925b)));
                        try {
                            K(this.f925b, "/storage/emulated/0/MUMS_Images/");
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
                this.f925b = cursor2.getString(cursor2.getColumnIndex(projection2[0]));
                cursor2.close();
                this.f894a.setBackground(new BitmapDrawable(BitmapFactory.decodeFile(this.f925b)));
                try {
                    K(this.f925b, "/storage/emulated/0/MUMS_Images/");
                } catch (Exception e4) {
                }
            }
        } else if (requestCode == 5 && resultCode == -1) {
            Uri uri = data.getData();
            try {
                this.f934c = jw0.e(this.f892a, uri);
                this.f893a = uri;
            } catch (Exception e5) {
                e5.printStackTrace();
                Toast.makeText(this.f892a, e5.getMessage(), 0).show();
            }
            t tVar = new t();
            this.f907a = tVar;
            tVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 2296 && grantResults.length > 0) {
            boolean WRITE_EXTERNAL_STORAGE = true;
            boolean READ_EXTERNAL_STORAGE = grantResults[0] == 0;
            if (grantResults[1] != 0) {
                WRITE_EXTERNAL_STORAGE = false;
            }
            if (!READ_EXTERNAL_STORAGE || !WRITE_EXTERNAL_STORAGE) {
                Toast.makeText(this, "Allow permission for storage access!", 0).show();
            }
        }
    }

    public void K(String srcDir, String dstDir) {
        try {
            File src = new File(srcDir);
            File dst = new File(dstDir, src.getName());
            if (src.isDirectory()) {
                for (String file : src.list()) {
                    K(new File(src, file).getPath(), dst.getPath());
                }
                return;
            }
            J(src, dst);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void J(java.io.File r9, java.io.File r10) {
        /*
            java.io.File r0 = r10.getParentFile()
            java.util.Objects.requireNonNull(r0)
            r1 = r0
            java.io.File r1 = (java.io.File) r1
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0017
            java.io.File r0 = r10.getParentFile()
            r0.mkdirs()
        L_0x0017:
            boolean r0 = r10.exists()
            if (r0 != 0) goto L_0x0020
            r10.createNewFile()
        L_0x0020:
            r0 = 0
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x004b }
            r2.<init>(r9)     // Catch:{ all -> 0x004b }
            java.nio.channels.FileChannel r4 = r2.getChannel()     // Catch:{ all -> 0x004b }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ all -> 0x0049 }
            r0.<init>(r10)     // Catch:{ all -> 0x0049 }
            java.nio.channels.FileChannel r3 = r0.getChannel()     // Catch:{ all -> 0x0049 }
            r5 = 0
            long r7 = r4.size()     // Catch:{ all -> 0x0046 }
            r3.transferFrom(r4, r5, r7)     // Catch:{ all -> 0x0046 }
            r4.close()
            r3.close()
            return
        L_0x0046:
            r0 = move-exception
            r1 = r3
            goto L_0x004e
        L_0x0049:
            r0 = move-exception
            goto L_0x004e
        L_0x004b:
            r2 = move-exception
            r4 = r0
            r0 = r2
        L_0x004e:
            if (r4 == 0) goto L_0x0053
            r4.close()
        L_0x0053:
            if (r1 == 0) goto L_0x0058
            r1.close()
        L_0x0058:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blogspot.yemeninfo4it.mumsmobile_app.activities.PrintCardsActivity.J(java.io.File, java.io.File):void");
    }

    public void N(GridView gv_folder) {
        c.clear();
        try {
            File path = new File("/storage/emulated/0/MUMS_Images/");
            if (path.exists()) {
                String[] fileNames = path.list();
                if (fileNames != null) {
                    for (String fileName : fileNames) {
                        c.add(new Model_images(fileName, path.getPath() + "/" + fileName));
                    }
                    t0 t0Var = new t0(getApplicationContext(), c);
                    this.f913a = t0Var;
                    gv_folder.setAdapter(t0Var);
                    return;
                }
                throw new AssertionError();
            }
        } catch (Exception e2) {
        }
    }

    public void U() {
        try {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            View myView = getLayoutInflater().inflate(R.layout.imglist_pop, (ViewGroup) null);
            dialogBuilder.setView(myView);
            GridView gv_folder = (GridView) myView.findViewById(R.id.gv_folder);
            TextView refresh_img = (TextView) myView.findViewById(R.id.refresh_img);
            TextView from_geliry = (TextView) myView.findViewById(R.id.from_geliry);
            dialogBuilder.create().show();
            if (H()) {
                N(gv_folder);
            } else {
                h0();
            }
            gv_folder.setOnItemClickListener(new c());
            refresh_img.setOnClickListener(new d(gv_folder));
            from_geliry.setOnClickListener(new e());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    class c implements AdapterView.OnItemClickListener {
        c() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            PrintCardsActivity.this.f894a.setBackground(new BitmapDrawable(BitmapFactory.decodeFile(PrintCardsActivity.c.get(i).getAl_imagepath())));
            PrintCardsActivity.this.f925b = PrintCardsActivity.c.get(i).getAl_imagepath();
        }
    }

    class d implements View.OnClickListener {
        final /* synthetic */ GridView a;

        d(GridView gridView) {
            this.a = gridView;
        }

        public void onClick(View v) {
            PrintCardsActivity.this.N(this.a);
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View v) {
            if (Build.VERSION.SDK_INT < 23) {
                PrintCardsActivity.this.startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 1);
            } else if (PrintCardsActivity.this.H()) {
                PrintCardsActivity.this.startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 1);
            } else {
                PrintCardsActivity.this.h0();
            }
        }
    }

    public int i0() {
        Point size = new Point();
        WindowManager w = getWindowManager();
        if (Build.VERSION.SDK_INT < 11) {
            return w.getDefaultDisplay().getWidth();
        }
        w.getDefaultDisplay().getSize(size);
        return size.x;
    }

    public void j0(int sw) {
        if (sw <= 480) {
            this.f902a.setTextSize(27.0f);
            this.f924b.setTextSize(27.0f);
            this.f933c.setTextSize(25.0f);
        }
        if (sw > 480 && sw <= 768) {
            this.f902a.setTextSize(25.0f);
            this.f924b.setTextSize(25.0f);
            this.f933c.setTextSize(23.0f);
        }
        if (sw > 768 && sw <= 1080) {
            this.f902a.setTextSize(19.5f);
            this.f924b.setTextSize(19.5f);
            this.f933c.setTextSize(17.5f);
        } else if (sw >= 1200) {
            this.f902a.setTextSize(18.6f);
            this.f924b.setTextSize(18.6f);
            this.f933c.setTextSize(16.6f);
        }
    }

    /* access modifiers changed from: private */
    public void L(Uri pickerInitialUri) {
        String strDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Calendar.getInstance().getTime());
        Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("application/pdf");
        intent.putExtra("android.intent.extra.TITLE", "RePrint_Crds_" + strDate + ".pdf");
        intent.putExtra("android.provider.extra.INITIAL_URI", pickerInitialUri);
        startActivityForResult(intent, 5);
    }

    public static float I(float dp) {
        return (float) Math.round((((float) Resources.getSystem().getDisplayMetrics().densityDpi) / 160.0f) * dp);
    }

    public tr R(d60 cb, tr img, String watermark, int x, int y, String watermark2, int x2, int y2, String watermarkSls, int xSls, int ySls) {
        b.C0035b bVar = b.C0035b.HELVETICA;
        com.itextpdf.text.b font = new com.itextpdf.text.b(bVar, (float) this.d, 1);
        font.q(this.f915a);
        com.itextpdf.text.b font_p = new com.itextpdf.text.b(bVar, (float) this.e, 1);
        font_p.q(this.f927b);
        com.itextpdf.text.b fontSls = new com.itextpdf.text.b(y5.d("assets/fonts/HacenCasablanca.ttf", "Identity-H", true), this.b, 0);
        fontSls.q(this.f935c);
        float width = img.B0();
        float height = img.A0();
        q80 template = cb.Q(width, height);
        template.m(img, width, 0.0f, 0.0f, height, 0.0f, 0.0f);
        q80 q80 = template;
        ia.U(q80, 1, new com.itextpdf.text.d(watermark, font), width - ((float) x), height - ((float) y), 0.0f);
        if (this.f919b.isChecked()) {
            q80 q802 = template;
            ia.U(q802, 1, new com.itextpdf.text.d(watermark2, font_p), width - ((float) x2), height - ((float) y2), 0.0f);
        }
        if (this.f930c.isChecked()) {
            q80 q803 = template;
            ia.V(q803, 1, new com.itextpdf.text.d(watermarkSls, fontSls), width - ((float) xSls), height - ((float) ySls), 0.0f, 3, 0);
        }
        return tr.t0(template);
    }

    public File O(String albumName) {
        File file = new File(Environment.getExternalStorageDirectory() + albumName);
        if (!file.mkdirs()) {
            Log.e("MUMS_Cards", "Directory not created");
        }
        return file;
    }

    public int S() {
        int a2 = 0;
        for (int i2 = 0; i2 < this.f912a.size(); i2++) {
            if (this.f912a.get(i2).getStatus().equals("yes")) {
                a2++;
            }
        }
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0362 A[EDGE_INSN: B:106:0x0362->B:84:0x0362 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0213 A[Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0219 A[Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0252 A[Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0371 A[Catch:{ IOException -> 0x039e, ih -> 0x039c }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x037a A[Catch:{ IOException -> 0x039e, ih -> 0x039c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Boolean l0(java.lang.String r41, java.lang.String r42, int r43, int r44) {
        /*
            r40 = this;
            r15 = r40
            r14 = r41
            r13 = 0
            r10 = 1
            r15.f889a = r13     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.lang.String r0 = r15.f925b     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            boolean r0 = r0.isEmpty()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            if (r0 != 0) goto L_0x037d
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r1 = 30
            java.lang.String r2 = ".pdf"
            if (r0 < r1) goto L_0x0048
            java.io.File r0 = new java.io.File     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r1.<init>()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.lang.String r3 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.io.File r3 = android.os.Environment.getExternalStoragePublicDirectory(r3)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r1.append(r3)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.lang.String r3 = "/"
            r1.append(r3)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r1.append(r14)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r1.append(r2)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r15.f910a = r0     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            boolean r0 = r0.exists()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            if (r0 != 0) goto L_0x009e
            java.io.File r0 = r15.f910a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r0.createNewFile()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            goto L_0x009e
        L_0x0048:
            r1 = 29
            if (r0 != r1) goto L_0x0073
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r0.<init>()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.lang.String r1 = "/storage/emulated/0/"
            r0.append(r1)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r0.append(r14)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r0.append(r2)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r15.f910a = r1     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            boolean r1 = r1.exists()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            if (r1 != 0) goto L_0x0072
            java.io.File r1 = r15.f910a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r1.createNewFile()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
        L_0x0072:
            goto L_0x009e
        L_0x0073:
            java.lang.String r0 = "/MUMS_Cards"
            r15.O(r0)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r0.<init>()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.lang.String r1 = "/storage/emulated/0/MUMS_Cards/"
            r0.append(r1)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r0.append(r14)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r0.append(r2)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r15.f910a = r1     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            boolean r1 = r1.exists()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            if (r1 != 0) goto L_0x009e
            java.io.File r1 = r15.f910a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r1.createNewFile()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
        L_0x009e:
            gh r0 = new gh     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r0.<init>()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r1 = 1073741824(0x40000000, float:2.0)
            r2 = 1082130432(0x40800000, float:4.0)
            r3 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r0.a(r4, r1, r2, r3)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.io.File r2 = r15.f910a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.io.File r2 = r2.getAbsoluteFile()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            v80 r1 = defpackage.v80.e0(r0, r1)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r25 = r1
            r0.open()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            k50 r1 = new k50     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r1.<init>()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r26 = r1
            r1 = 15
            r2 = 30
            android.view.ViewGroup r3 = r15.f894a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r5 = 200(0xc8, float:2.8E-43)
            if (r3 >= r5) goto L_0x00de
            r1 = 3
            r2 = 60
            r27 = r1
            r28 = r2
            goto L_0x0141
        L_0x00de:
            android.view.ViewGroup r3 = r15.f894a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r5 = 306(0x132, float:4.29E-43)
            if (r3 >= r5) goto L_0x00fb
            android.view.ViewGroup r3 = r15.f894a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r6 = 250(0xfa, float:3.5E-43)
            if (r3 <= r6) goto L_0x00fb
            r1 = 32
            r2 = 23
            r27 = r1
            r28 = r2
            goto L_0x0141
        L_0x00fb:
            android.view.ViewGroup r3 = r15.f894a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r6 = 367(0x16f, float:5.14E-43)
            if (r3 <= r5) goto L_0x0116
            android.view.ViewGroup r3 = r15.f894a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            if (r3 > r6) goto L_0x0116
            r1 = 30
            r2 = 23
            r27 = r1
            r28 = r2
            goto L_0x0141
        L_0x0116:
            android.view.ViewGroup r3 = r15.f894a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r5 = 394(0x18a, float:5.52E-43)
            if (r3 <= r6) goto L_0x0131
            android.view.ViewGroup r3 = r15.f894a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            if (r3 > r5) goto L_0x0131
            r1 = 29
            r2 = 23
            r27 = r1
            r28 = r2
            goto L_0x0141
        L_0x0131:
            android.view.ViewGroup r3 = r15.f894a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            if (r3 <= r5) goto L_0x013d
            r1 = 28
            r2 = 23
        L_0x013d:
            r27 = r1
            r28 = r2
        L_0x0141:
            android.view.ViewGroup r1 = r15.f894a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r1 = r1.getWidth()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            double r1 = (double) r1     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r5 = 4619792497756654797(0x401ccccccccccccd, double:7.2)
            double r1 = r1 / r5
            int r1 = (int) r1     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r7 = r1 + 1
            android.view.ViewGroup r1 = r15.f894a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r1 = r1.getHeight()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            double r1 = (double) r1     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r5 = 4619342137793917747(0x401b333333333333, double:6.8)
            double r1 = r1 / r5
            int r1 = (int) r1     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            android.view.ViewGroup r2 = r15.f894a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r2 = r2.getHeight()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r3 = 460(0x1cc, float:6.45E-43)
            if (r2 != r3) goto L_0x016d
            int r1 = r1 + 2
            r3 = r1
            goto L_0x016e
        L_0x016d:
            r3 = r1
        L_0x016e:
            android.view.ViewGroup r1 = r15.f894a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r1 = r1.getWidth()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r1 = r1 / r7
            float r1 = (float) r1     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            android.view.ViewGroup r2 = r15.f894a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r2 = r2.getHeight()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r2 = r2 / r3
            float r2 = (float) r2     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            android.widget.TextView r5 = r15.f902a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r5 = r5.getHeight()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r6 = (int) r2     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r5 = r5 / r6
            r29 = r5
            android.widget.EditText r5 = r15.f897a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            android.text.Editable r5 = r5.getText()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r5 = r5 - r28
            int r6 = (int) r1     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r5 = r5 / r6
            android.widget.EditText r6 = r15.f920b     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            android.text.Editable r6 = r6.getText()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r6 = r6 + r27
            int r8 = (int) r2     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r6 = r6 / r8
            java.lang.String r8 = r15.f938d     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r8 = r8 - r28
            int r9 = (int) r1     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r8 = r8 / r9
            java.lang.String r9 = r15.f940e     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r9 = r9 + r27
            int r11 = (int) r2     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r9 = r9 / r11
            java.lang.String r11 = r15.f942f     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r11 = r11 - r28
            int r12 = (int) r1     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r11 = r11 / r12
            java.lang.String r12 = r15.f944g     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r12 = java.lang.Integer.parseInt(r12)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r12 = r12 + r27
            int r4 = (int) r2     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r12 = r12 / r4
            java.lang.String r4 = r15.f925b     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            tr r4 = defpackage.tr.u0(r4)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r17 = 1058642330(0x3f19999a, float:0.6)
            android.view.ViewGroup r13 = r15.f894a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r13 = r13.getHeight()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r10 = 286(0x11e, float:4.01E-43)
            if (r13 == r10) goto L_0x0203
            android.view.ViewGroup r10 = r15.f894a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r10 = r10.getHeight()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r13 = 323(0x143, float:4.53E-43)
            if (r10 == r13) goto L_0x0203
            android.view.ViewGroup r10 = r15.f894a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r10 = r10.getHeight()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r13 = 343(0x157, float:4.8E-43)
            if (r10 != r13) goto L_0x01fc
            goto L_0x0203
        L_0x01fc:
            r10 = 1058642330(0x3f19999a, float:0.6)
            r16 = 1058642330(0x3f19999a, float:0.6)
            goto L_0x0205
        L_0x0203:
            r16 = 1065353216(0x3f800000, float:1.0)
        L_0x0205:
            r10 = r16
            android.view.ViewGroup r13 = r15.f894a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r13 = r13.getHeight()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r16 = r1
            r1 = 271(0x10f, float:3.8E-43)
            if (r13 != r1) goto L_0x0219
            r10 = 1050253722(0x3e99999a, float:0.3)
            r30 = r10
            goto L_0x021b
        L_0x0219:
            r30 = r10
        L_0x021b:
            float r1 = (float) r7     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            float r10 = (float) r3     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            float r10 = r10 - r30
            r4.Y0(r1, r10)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            d60 r1 = r25.Z()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r31 = r2
            r2 = r1
            r1 = 1
            u70 r10 = new u70     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r13 = r15.l     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r10.<init>((int) r13)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r13 = r10
            r10 = 1120403456(0x42c80000, float:100.0)
            r13.x0(r10)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r10 = r40.S()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r17 = r1
            int r1 = r15.l     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r1 = r10 % r1
            r32 = r1
            r1 = 0
            r33 = r0
            r0 = r17
        L_0x0248:
            r17 = r3
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser> r3 = r15.f912a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r3 = r3.size()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            if (r1 >= r3) goto L_0x0362
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser> r3 = r15.f912a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser r3 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser) r3     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.lang.String r3 = r3.getStatus()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r20 = r7
            java.lang.String r7 = "yes"
            boolean r3 = r3.equals(r7)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            if (r3 == 0) goto L_0x0347
            int r3 = r15.f889a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r19 = 1
            int r3 = r3 + 1
            r15.f889a = r3     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            android.widget.CheckBox r3 = r15.f919b     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            boolean r3 = r3.isChecked()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            if (r3 == 0) goto L_0x02de
            q70 r3 = new q70     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser> r7 = r15.f912a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.lang.Object r7 = r7.get(r1)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser r7 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser) r7     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.lang.String r7 = r7.getUname()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser> r14 = r15.f912a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.lang.Object r14 = r14.get(r1)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser r14 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser) r14     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.lang.String r14 = r14.getPassword()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r23 = r10
            java.lang.String r10 = r15.f948i     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r35 = r1
            r34 = r16
            r1 = r40
            r16 = r13
            r36 = r17
            r13 = r3
            r3 = r4
            r37 = r4
            r4 = r7
            r38 = r20
            r7 = r14
            r14 = r23
            tr r1 = r1.R(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r13.<init>((defpackage.tr) r1)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r1 = r13
            if (r32 <= 0) goto L_0x02c2
            if (r0 != r14) goto L_0x02c0
            int r3 = r15.l     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            int r3 = r3 - r32
            r4 = 1
            int r3 = r3 + r4
            r1.A0(r3)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            goto L_0x02c3
        L_0x02c0:
            r4 = 1
            goto L_0x02c3
        L_0x02c2:
            r4 = 1
        L_0x02c3:
            r3 = 0
            r1.R(r3)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r7 = 1056964608(0x3f000000, float:0.5)
            r1.G0(r7)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r10 = 1076468122(0x4029999a, float:2.65)
            r1.F0(r10)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r13 = r16
            r13.e(r1)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r3 = r13
            r10 = r14
            r4 = r15
            r7 = r35
            goto L_0x0344
        L_0x02de:
            r35 = r1
            r37 = r4
            r14 = r10
            r34 = r16
            r36 = r17
            r38 = r20
            r3 = 0
            r4 = 1
            r7 = 1056964608(0x3f000000, float:0.5)
            r10 = 1076468122(0x4029999a, float:2.65)
            q70 r1 = new q70     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser> r3 = r15.f912a     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r7 = r35
            java.lang.Object r3 = r3.get(r7)     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser r3 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser) r3     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.lang.String r16 = r3.getUname()     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            java.lang.String r19 = ""
            r20 = 0
            r21 = 0
            java.lang.String r3 = r15.f948i     // Catch:{ IOException -> 0x03b4, ih -> 0x03a0 }
            r39 = r13
            r10 = 0
            r13 = r40
            r10 = r14
            r14 = r2
            r4 = r15
            r15 = r37
            r17 = r5
            r18 = r6
            r22 = r3
            r23 = r11
            r24 = r12
            tr r3 = r13.R(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ IOException -> 0x039e, ih -> 0x039c }
            r1.<init>((defpackage.tr) r3)     // Catch:{ IOException -> 0x039e, ih -> 0x039c }
            if (r32 <= 0) goto L_0x0330
            if (r0 != r10) goto L_0x0330
            int r3 = r4.l     // Catch:{ IOException -> 0x039e, ih -> 0x039c }
            int r3 = r3 - r32
            r13 = 1
            int r3 = r3 + r13
            r1.A0(r3)     // Catch:{ IOException -> 0x039e, ih -> 0x039c }
        L_0x0330:
            r3 = 0
            r1.R(r3)     // Catch:{ IOException -> 0x039e, ih -> 0x039c }
            r3 = 1056964608(0x3f000000, float:0.5)
            r1.G0(r3)     // Catch:{ IOException -> 0x039e, ih -> 0x039c }
            r3 = 1076468122(0x4029999a, float:2.65)
            r1.F0(r3)     // Catch:{ IOException -> 0x039e, ih -> 0x039c }
            r3 = r39
            r3.e(r1)     // Catch:{ IOException -> 0x039e, ih -> 0x039c }
        L_0x0344:
            int r0 = r0 + 1
            goto L_0x0352
        L_0x0347:
            r7 = r1
            r37 = r4
            r3 = r13
            r4 = r15
            r34 = r16
            r36 = r17
            r38 = r20
        L_0x0352:
            int r1 = r7 + 1
            r14 = r41
            r13 = r3
            r15 = r4
            r16 = r34
            r3 = r36
            r4 = r37
            r7 = r38
            goto L_0x0248
        L_0x0362:
            r37 = r4
            r38 = r7
            r3 = r13
            r4 = r15
            r34 = r16
            r36 = r17
            r7 = r1
            int r1 = r4.f889a     // Catch:{ IOException -> 0x039e, ih -> 0x039c }
            if (r1 <= 0) goto L_0x037a
            r1 = r33
            r1.c(r3)     // Catch:{ IOException -> 0x039e, ih -> 0x039c }
            r1.close()     // Catch:{ IOException -> 0x039e, ih -> 0x039c }
            goto L_0x037c
        L_0x037a:
            r1 = r33
        L_0x037c:
            goto L_0x038c
        L_0x037d:
            r4 = r15
            android.content.Context r0 = r40.getApplicationContext()     // Catch:{ IOException -> 0x039e, ih -> 0x039c }
            java.lang.String r1 = "الرجاء تحديد الصوره"
            r2 = 0
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r2)     // Catch:{ IOException -> 0x039e, ih -> 0x039c }
            r0.show()     // Catch:{ IOException -> 0x039e, ih -> 0x039c }
        L_0x038c:
            int r0 = r4.f889a     // Catch:{ IOException -> 0x039e, ih -> 0x039c }
            if (r0 <= 0) goto L_0x0396
            r1 = 1
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)     // Catch:{ IOException -> 0x039e, ih -> 0x039c }
            return r0
        L_0x0396:
            r1 = 0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)     // Catch:{ IOException -> 0x039e, ih -> 0x039c }
            return r0
        L_0x039c:
            r0 = move-exception
            goto L_0x03a2
        L_0x039e:
            r0 = move-exception
            goto L_0x03b6
        L_0x03a0:
            r0 = move-exception
            r4 = r15
        L_0x03a2:
            r0.printStackTrace()
            r1 = 1
            r4.f928b = r1
            java.lang.String r1 = r0.getMessage()
            r4.f946h = r1
            r1 = 0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            return r1
        L_0x03b4:
            r0 = move-exception
            r4 = r15
        L_0x03b6:
            r0.printStackTrace()
            r1 = 1
            r4.f928b = r1
            java.lang.String r1 = r0.getMessage()
            r4.f946h = r1
            r1 = 0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blogspot.yemeninfo4it.mumsmobile_app.activities.PrintCardsActivity.l0(java.lang.String, java.lang.String, int, int):java.lang.Boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:125:0x034a A[EDGE_INSN: B:125:0x034a->B:95:0x034a ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01af A[Catch:{ IOException -> 0x036f, ih -> 0x036a }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01eb A[Catch:{ IOException -> 0x036f, ih -> 0x036a }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x035e A[Catch:{ IOException -> 0x0396, ih -> 0x0394 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0367 A[Catch:{ IOException -> 0x0396, ih -> 0x0394 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Boolean m0(java.lang.String r44, android.net.Uri r45, int r46, int r47) {
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
            android.content.Context r2 = r15.f892a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r3 = 0
            java.io.File r2 = r2.getExternalFilesDir(r3)     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r1.append(r2)     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            java.lang.String r2 = "/"
            r1.append(r2)     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r25 = r1
            java.lang.String r1 = r15.f925b     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            boolean r1 = r1.isEmpty()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            if (r1 != 0) goto L_0x0374
            android.content.ContentResolver r1 = r43.getContentResolver()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            android.net.Uri r2 = r15.f893a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
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
            android.view.ViewGroup r3 = r15.f894a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r5 = 200(0xc8, float:2.8E-43)
            if (r3 >= r5) goto L_0x0088
            r1 = 3
            r2 = 60
            r29 = r1
            r30 = r2
            goto L_0x00eb
        L_0x0088:
            android.view.ViewGroup r3 = r15.f894a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r5 = 306(0x132, float:4.29E-43)
            if (r3 >= r5) goto L_0x00a5
            android.view.ViewGroup r3 = r15.f894a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r6 = 250(0xfa, float:3.5E-43)
            if (r3 <= r6) goto L_0x00a5
            r1 = 32
            r2 = 23
            r29 = r1
            r30 = r2
            goto L_0x00eb
        L_0x00a5:
            android.view.ViewGroup r3 = r15.f894a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r6 = 367(0x16f, float:5.14E-43)
            if (r3 <= r5) goto L_0x00c0
            android.view.ViewGroup r3 = r15.f894a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            if (r3 > r6) goto L_0x00c0
            r1 = 30
            r2 = 23
            r29 = r1
            r30 = r2
            goto L_0x00eb
        L_0x00c0:
            android.view.ViewGroup r3 = r15.f894a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r5 = 394(0x18a, float:5.52E-43)
            if (r3 <= r6) goto L_0x00db
            android.view.ViewGroup r3 = r15.f894a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            if (r3 > r5) goto L_0x00db
            r1 = 29
            r2 = 23
            r29 = r1
            r30 = r2
            goto L_0x00eb
        L_0x00db:
            android.view.ViewGroup r3 = r15.f894a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            if (r3 <= r5) goto L_0x00e7
            r1 = 28
            r2 = 23
        L_0x00e7:
            r29 = r1
            r30 = r2
        L_0x00eb:
            android.view.ViewGroup r1 = r15.f894a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r1 = r1.getWidth()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            double r1 = (double) r1     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r5 = 4619792497756654797(0x401ccccccccccccd, double:7.2)
            double r1 = r1 / r5
            int r1 = (int) r1     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r3 = r1 + 1
            android.view.ViewGroup r1 = r15.f894a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r1 = r1.getHeight()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            double r1 = (double) r1     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r5 = 4619342137793917747(0x401b333333333333, double:6.8)
            double r1 = r1 / r5
            int r1 = (int) r1     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            android.view.ViewGroup r2 = r15.f894a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r2 = r2.getHeight()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r5 = 460(0x1cc, float:6.45E-43)
            if (r2 != r5) goto L_0x0115
            int r1 = r1 + 2
        L_0x0115:
            android.view.ViewGroup r2 = r15.f894a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r2 = r2.getWidth()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r2 = r2 / r3
            float r2 = (float) r2     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            android.view.ViewGroup r5 = r15.f894a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r5 = r5.getHeight()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r5 = r5 / r1
            float r12 = (float) r5     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            android.widget.EditText r5 = r15.f897a     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            android.text.Editable r5 = r5.getText()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r5 = r5 - r30
            int r6 = (int) r2     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r5 = r5 / r6
            android.widget.EditText r6 = r15.f920b     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            android.text.Editable r6 = r6.getText()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r6 = r6 + r29
            int r8 = (int) r12     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r6 = r6 / r8
            java.lang.String r8 = r15.f938d     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r8 = r8 - r30
            int r9 = (int) r2     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r8 = r8 / r9
            java.lang.String r9 = r15.f940e     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r9 = r9 + r29
            int r11 = (int) r12     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r9 = r9 / r11
            java.lang.String r11 = r15.f942f     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r11 = r11 - r30
            int r4 = (int) r2     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r11 = r11 / r4
            java.lang.String r4 = r15.f944g     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r4 = r4 + r29
            int r14 = (int) r12     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            int r4 = r4 / r14
            r31 = r12
            r12 = r4
            java.lang.String r4 = r15.f925b     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            tr r4 = defpackage.tr.u0(r4)     // Catch:{ IOException -> 0x03ab, ih -> 0x0398 }
            r14 = r4
            r4 = 1058642330(0x3f19999a, float:0.6)
            android.view.ViewGroup r13 = r15.f894a     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            int r13 = r13.getHeight()     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            r32 = r0
            r0 = 286(0x11e, float:4.01E-43)
            if (r13 == r0) goto L_0x01a3
            android.view.ViewGroup r0 = r15.f894a     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            int r0 = r0.getHeight()     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            r13 = 323(0x143, float:4.53E-43)
            if (r0 == r13) goto L_0x01a3
            android.view.ViewGroup r0 = r15.f894a     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
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
            android.view.ViewGroup r4 = r15.f894a     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
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
            int r0 = r15.l     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            r13.<init>((int) r0)     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            r0 = r13
            r13 = 1120403456(0x42c80000, float:100.0)
            r0.x0(r13)     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            int r13 = r43.S()     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            r19 = r1
            int r1 = r15.l     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            int r1 = r13 % r1
            r35 = r1
            r1 = 0
            r42 = r4
            r4 = r1
            r1 = r42
        L_0x01e1:
            r20 = r1
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser> r1 = r15.f912a     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            int r1 = r1.size()     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            if (r4 >= r1) goto L_0x034a
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser> r1 = r15.f912a     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser r1 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser) r1     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            java.lang.String r1 = r1.getStatus()     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            r21 = r3
            java.lang.String r3 = "yes"
            boolean r1 = r1.equals(r3)     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            if (r1 == 0) goto L_0x0326
            int r1 = r15.f889a     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            r3 = 1
            int r1 = r1 + r3
            r15.f889a = r1     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            android.widget.CheckBox r1 = r15.f919b     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            boolean r1 = r1.isChecked()     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            r36 = r0
            if (r1 == 0) goto L_0x0294
            q70 r1 = new q70     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser> r3 = r15.f912a     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser r3 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser) r3     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            java.lang.String r23 = r3.getUname()     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser> r3 = r15.f912a     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser r3 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser) r3     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            java.lang.String r24 = r3.getPassword()     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
            java.lang.String r3 = r15.f948i     // Catch:{ IOException -> 0x036f, ih -> 0x036a }
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
            tr r1 = r1.R(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ IOException -> 0x028d, ih -> 0x0286 }
            r15.<init>((defpackage.tr) r1)     // Catch:{ IOException -> 0x028d, ih -> 0x0286 }
            r1 = r15
            if (r35 <= 0) goto L_0x0263
            if (r0 != r13) goto L_0x025f
            r3 = r43
            int r4 = r3.l     // Catch:{ IOException -> 0x0323, ih -> 0x0320 }
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
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser> r4 = r3.f912a     // Catch:{ IOException -> 0x0323, ih -> 0x0320 }
            r7 = r16
            java.lang.Object r4 = r4.get(r7)     // Catch:{ IOException -> 0x0323, ih -> 0x0320 }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser r4 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser) r4     // Catch:{ IOException -> 0x0323, ih -> 0x0320 }
            java.lang.String r16 = r4.getUname()     // Catch:{ IOException -> 0x0323, ih -> 0x0320 }
            java.lang.String r19 = ""
            r4 = 0
            r21 = 0
            java.lang.String r10 = r3.f948i     // Catch:{ IOException -> 0x0323, ih -> 0x0320 }
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
            tr r4 = r13.R(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ IOException -> 0x0323, ih -> 0x0320 }
            r1.<init>((defpackage.tr) r4)     // Catch:{ IOException -> 0x0323, ih -> 0x0320 }
            if (r35 <= 0) goto L_0x0300
            r4 = r40
            if (r0 != r4) goto L_0x02fe
            int r10 = r3.l     // Catch:{ IOException -> 0x02fa, ih -> 0x02f6 }
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
            int r1 = r3.f889a     // Catch:{ IOException -> 0x0396, ih -> 0x0394 }
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
            int r0 = r3.f889a     // Catch:{ IOException -> 0x0396, ih -> 0x0394 }
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
            r3.f928b = r13
            java.lang.String r1 = r0.getMessage()
            r3.f946h = r1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r10)
            return r1
        L_0x03ab:
            r0 = move-exception
            r3 = r15
        L_0x03ad:
            r10 = 0
        L_0x03ae:
            r0.printStackTrace()
            r3.f928b = r13
            java.lang.String r1 = r0.getMessage()
            r3.f946h = r1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r10)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blogspot.yemeninfo4it.mumsmobile_app.activities.PrintCardsActivity.m0(java.lang.String, android.net.Uri, int, int):java.lang.Boolean");
    }

    class t extends AsyncTask<String, Integer, String> {
        int a;

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f956a = null;

        t() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            PrintCardsActivity.this.f891a.setTitle("يرجى الانتظار..");
            PrintCardsActivity.this.f891a.setMessage("جاري طباعة الكروت الى ملف PDF ...");
            PrintCardsActivity.this.f891a.setCancelable(false);
            PrintCardsActivity.this.f891a.setIndeterminate(false);
            PrintCardsActivity.this.f891a.show();
            PrintCardsActivity printCardsActivity = PrintCardsActivity.this;
            printCardsActivity.f928b = false;
            printCardsActivity.f946h = "no";
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                PrintCardsActivity.this.f889a = 0;
                String strDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Calendar.getInstance().getTime());
                int x = Integer.parseInt(PrintCardsActivity.this.f897a.getText().toString());
                int y = Integer.parseInt(PrintCardsActivity.this.f920b.getText().toString());
                for (int i = 0; i < PrintCardsActivity.this.f912a.size(); i++) {
                    if (PrintCardsActivity.this.f912a.get(i).getStatus().equals("yes")) {
                        this.a++;
                    }
                }
                if (this.a <= 0) {
                    PrintCardsActivity.this.f916a = false;
                    return null;
                } else if (PrintCardsActivity.this.f925b.isEmpty()) {
                    return null;
                } else {
                    if (PrintCardsActivity.this.m0("RePrint_Crds_" + strDate, PrintCardsActivity.this.f918b, x, y).booleanValue()) {
                        PrintCardsActivity.this.f916a = true;
                        return null;
                    }
                    PrintCardsActivity.this.f916a = false;
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
            PrintCardsActivity printCardsActivity = PrintCardsActivity.this;
            if (printCardsActivity.f916a) {
                printCardsActivity.f891a.dismiss();
                Context context = PrintCardsActivity.this.f892a;
                Toast.makeText(context, "تم حفظ الملف بنجاح..عدد الكروت : " + String.valueOf(PrintCardsActivity.this.f889a), 0).show();
            } else {
                printCardsActivity.f891a.dismiss();
                PrintCardsActivity printCardsActivity2 = PrintCardsActivity.this;
                if (printCardsActivity2.f889a <= 0) {
                    Context context2 = printCardsActivity2.f892a;
                    Toast.makeText(context2, PrintCardsActivity.this.f946h + "لم يتم الحفظ..قم بإضافة الكروت الى السيرفر قبل الطباعة", 0).show();
                } else {
                    Toast.makeText(printCardsActivity2.f892a, "حدث خطأ اثناء الحفظ", 0).show();
                }
            }
            PrintCardsActivity printCardsActivity3 = PrintCardsActivity.this;
            if (printCardsActivity3.f928b) {
                Toast.makeText(printCardsActivity3.f892a, printCardsActivity3.f946h, 0).show();
            }
        }
    }

    class s extends AsyncTask<String, Integer, String> {
        int a;

        s() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            PrintCardsActivity.this.f891a.setTitle("يرجى الانتظار..");
            PrintCardsActivity.this.f891a.setMessage("جاري طباعة الكروت الى ملف PDF ...");
            PrintCardsActivity.this.f891a.setCancelable(false);
            PrintCardsActivity.this.f891a.setIndeterminate(false);
            PrintCardsActivity.this.f891a.show();
            PrintCardsActivity printCardsActivity = PrintCardsActivity.this;
            printCardsActivity.f928b = false;
            printCardsActivity.f946h = "no";
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                PrintCardsActivity.this.f889a = 0;
                String strDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Calendar.getInstance().getTime());
                int x = Integer.parseInt(PrintCardsActivity.this.f897a.getText().toString());
                int y = Integer.parseInt(PrintCardsActivity.this.f920b.getText().toString());
                for (int i = 0; i < PrintCardsActivity.this.f912a.size(); i++) {
                    if (PrintCardsActivity.this.f912a.get(i).getStatus().equals("yes")) {
                        this.a++;
                    }
                }
                if (this.a <= 0) {
                    PrintCardsActivity.this.f916a = false;
                    return null;
                } else if (PrintCardsActivity.this.f925b.isEmpty()) {
                    return null;
                } else {
                    if (PrintCardsActivity.this.l0("RePrint_Crds_" + strDate, "MUMS_odai_dammag", x, y).booleanValue()) {
                        PrintCardsActivity.this.f916a = true;
                        return null;
                    }
                    PrintCardsActivity.this.f916a = false;
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
            PrintCardsActivity printCardsActivity = PrintCardsActivity.this;
            if (printCardsActivity.f916a) {
                printCardsActivity.f891a.dismiss();
                if (Build.VERSION.SDK_INT >= 29) {
                    Context context = PrintCardsActivity.this.f892a;
                    Toast.makeText(context, "تم حفظ الملف بنجاح..عدد الكروت : " + String.valueOf(PrintCardsActivity.this.f889a) + " المسار الرئيسي للذاكرة ", 0).show();
                } else {
                    Context context2 = PrintCardsActivity.this.f892a;
                    Toast.makeText(context2, "تم حفظ الملف بنجاح..عدد الكروت : " + String.valueOf(PrintCardsActivity.this.f889a) + " مجلد MUMS_Cards ", 0).show();
                }
            } else {
                printCardsActivity.f891a.dismiss();
                PrintCardsActivity printCardsActivity2 = PrintCardsActivity.this;
                if (printCardsActivity2.f889a <= 0) {
                    Toast.makeText(printCardsActivity2.f892a, "لم يتم الحفظ..قم بإضافة الكروت الى السيرفر قبل الطباعة", 0).show();
                } else {
                    Toast.makeText(printCardsActivity2.f892a, "حدث خطأ اثناء الحفظ", 0).show();
                }
            }
            PrintCardsActivity printCardsActivity3 = PrintCardsActivity.this;
            if (printCardsActivity3.f928b) {
                Toast.makeText(printCardsActivity3.f892a, printCardsActivity3.f946h, 0).show();
            }
        }
    }

    /* access modifiers changed from: private */
    public void P(String selected_size) {
        if (selected_size.equals("3")) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f894a.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = this.f899a;
            layoutParams2.width = 1390;
            this.m = 1390;
            this.f894a.setLayoutParams(layoutParams2);
            this.l = 3;
        } else if (selected_size.equals("4")) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f894a.getLayoutParams();
            LinearLayout.LayoutParams layoutParams4 = this.f899a;
            layoutParams4.width = 1037;
            this.m = 1037;
            this.f894a.setLayoutParams(layoutParams4);
            this.l = 4;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Q(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = 2
            switch(r0) {
                case 1569: goto L_0x005a;
                case 1570: goto L_0x0050;
                case 1571: goto L_0x0046;
                case 1572: goto L_0x003c;
                case 1573: goto L_0x0032;
                case 1574: goto L_0x0028;
                case 1575: goto L_0x001e;
                case 1576: goto L_0x0014;
                case 1598: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0064
        L_0x0009:
            java.lang.String r0 = "20"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 8
            goto L_0x0065
        L_0x0014:
            java.lang.String r0 = "19"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 7
            goto L_0x0065
        L_0x001e:
            java.lang.String r0 = "18"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 6
            goto L_0x0065
        L_0x0028:
            java.lang.String r0 = "17"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 5
            goto L_0x0065
        L_0x0032:
            java.lang.String r0 = "16"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 4
            goto L_0x0065
        L_0x003c:
            java.lang.String r0 = "15"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 3
            goto L_0x0065
        L_0x0046:
            java.lang.String r0 = "14"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 2
            goto L_0x0065
        L_0x0050:
            java.lang.String r0 = "13"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 1
            goto L_0x0065
        L_0x005a:
            java.lang.String r0 = "12"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 0
            goto L_0x0065
        L_0x0064:
            r0 = -1
        L_0x0065:
            switch(r0) {
                case 0: goto L_0x015f;
                case 1: goto L_0x0141;
                case 2: goto L_0x0123;
                case 3: goto L_0x0105;
                case 4: goto L_0x00e6;
                case 5: goto L_0x00c7;
                case 6: goto L_0x00a8;
                case 7: goto L_0x0089;
                case 8: goto L_0x006a;
                default: goto L_0x0068;
            }
        L_0x0068:
            goto L_0x017c
        L_0x006a:
            android.view.ViewGroup r0 = r4.f894a
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            r2 = 271(0x10f, float:3.8E-43)
            r0.height = r2
            android.view.ViewGroup r2 = r4.f894a
            r2.setLayoutParams(r0)
            r2 = 1088212173(0x40dccccd, float:6.9)
            r4.b = r2
            android.widget.TextView r2 = r4.f933c
            r3 = 1097334784(0x41680000, float:14.5)
            r2.setTextSize(r1, r3)
            goto L_0x017c
        L_0x0089:
            android.view.ViewGroup r0 = r4.f894a
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            r2 = 286(0x11e, float:4.01E-43)
            r0.height = r2
            android.view.ViewGroup r2 = r4.f894a
            r2.setLayoutParams(r0)
            r2 = 1089051034(0x40e9999a, float:7.3)
            r4.b = r2
            android.widget.TextView r2 = r4.f933c
            r3 = 1097859072(0x41700000, float:15.0)
            r2.setTextSize(r1, r3)
            goto L_0x017c
        L_0x00a8:
            android.view.ViewGroup r0 = r4.f894a
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            r2 = 303(0x12f, float:4.25E-43)
            r0.height = r2
            android.view.ViewGroup r2 = r4.f894a
            r2.setLayoutParams(r0)
            r2 = 1089680179(0x40f33333, float:7.6)
            r4.b = r2
            android.widget.TextView r2 = r4.f933c
            r3 = 1098383360(0x41780000, float:15.5)
            r2.setTextSize(r1, r3)
            goto L_0x017c
        L_0x00c7:
            android.view.ViewGroup r0 = r4.f894a
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            r2 = 323(0x143, float:4.53E-43)
            r0.height = r2
            android.view.ViewGroup r2 = r4.f894a
            r2.setLayoutParams(r0)
            r2 = 1089889894(0x40f66666, float:7.7)
            r4.b = r2
            android.widget.TextView r2 = r4.f933c
            r3 = 1098907648(0x41800000, float:16.0)
            r2.setTextSize(r1, r3)
            goto L_0x017c
        L_0x00e6:
            android.view.ViewGroup r0 = r4.f894a
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            r2 = 343(0x157, float:4.8E-43)
            r0.height = r2
            android.view.ViewGroup r2 = r4.f894a
            r2.setLayoutParams(r0)
            r2 = 1090099610(0x40f9999a, float:7.8)
            r4.b = r2
            android.widget.TextView r2 = r4.f933c
            r3 = 1099169792(0x41840000, float:16.5)
            r2.setTextSize(r1, r3)
            goto L_0x017c
        L_0x0105:
            android.view.ViewGroup r0 = r4.f894a
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            r2 = 364(0x16c, float:5.1E-43)
            r0.height = r2
            android.view.ViewGroup r2 = r4.f894a
            r2.setLayoutParams(r0)
            r2 = 1090623898(0x4101999a, float:8.1)
            r4.b = r2
            android.widget.TextView r2 = r4.f933c
            r3 = 1099431936(0x41880000, float:17.0)
            r2.setTextSize(r1, r3)
            goto L_0x017c
        L_0x0123:
            android.view.ViewGroup r0 = r4.f894a
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            r2 = 391(0x187, float:5.48E-43)
            r0.height = r2
            android.view.ViewGroup r2 = r4.f894a
            r2.setLayoutParams(r0)
            r2 = 1090728755(0x41033333, float:8.2)
            r4.b = r2
            android.widget.TextView r2 = r4.f933c
            r3 = 1099694080(0x418c0000, float:17.5)
            r2.setTextSize(r1, r3)
            goto L_0x017c
        L_0x0141:
            android.view.ViewGroup r0 = r4.f894a
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            r2 = 424(0x1a8, float:5.94E-43)
            r0.height = r2
            android.view.ViewGroup r2 = r4.f894a
            r2.setLayoutParams(r0)
            r2 = 1090938470(0x41066666, float:8.4)
            r4.b = r2
            android.widget.TextView r2 = r4.f933c
            r3 = 1099956224(0x41900000, float:18.0)
            r2.setTextSize(r1, r3)
            goto L_0x017c
        L_0x015f:
            android.view.ViewGroup r0 = r4.f894a
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            r2 = 456(0x1c8, float:6.39E-43)
            r0.height = r2
            android.view.ViewGroup r2 = r4.f894a
            r2.setLayoutParams(r0)
            r2 = 1091043328(0x41080000, float:8.5)
            r4.b = r2
            android.widget.TextView r2 = r4.f933c
            r3 = 1100218368(0x41940000, float:18.5)
            r2.setTextSize(r1, r3)
        L_0x017c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blogspot.yemeninfo4it.mumsmobile_app.activities.PrintCardsActivity.Q(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public void T(String item) {
        try {
            try {
                Cursor data = this.f914a.v0(item);
                while (data.moveToNext()) {
                    try {
                        if (data.getString(14).equals("1")) {
                            this.f919b.setChecked(true);
                            this.f924b.setVisibility(0);
                        } else {
                            this.f919b.setChecked(false);
                            this.f924b.setVisibility(8);
                        }
                        this.f932c.setSelection(Integer.parseInt(data.getString(8)));
                        this.f901a.setSelection(Integer.parseInt(data.getString(16)));
                        Q(this.f932c.getSelectedItem().toString());
                        P(this.f901a.getSelectedItem().toString());
                        this.f925b = data.getString(9);
                        if (new File(this.f925b).exists()) {
                            this.f894a.setBackground(new BitmapDrawable(BitmapFactory.decodeFile(this.f925b)));
                        } else {
                            Toast.makeText(this.f892a, "لم يتم العثور على صورة القالب", 0).show();
                        }
                        if (data.getString(17) == null) {
                            this.f930c.setChecked(false);
                            this.f933c.setVisibility(8);
                        } else if (!data.getString(17).equals("0")) {
                            this.f930c.setChecked(true);
                            this.f933c.setVisibility(0);
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f902a.getLayoutParams();
                        layoutParams.leftMargin = Integer.parseInt(data.getString(10));
                        layoutParams.topMargin = Integer.parseInt(data.getString(11));
                        layoutParams.rightMargin = 0;
                        layoutParams.bottomMargin = 0;
                        this.f902a.setLayoutParams(layoutParams);
                        this.f897a.setText(String.valueOf(((this.f902a.getWidth() / 2) + (this.m - this.f902a.getWidth())) - Integer.parseInt(data.getString(10))));
                        this.f920b.setText(String.valueOf(Integer.valueOf(data.getString(11))));
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f924b.getLayoutParams();
                        layoutParams2.leftMargin = Integer.parseInt(data.getString(12));
                        layoutParams2.topMargin = Integer.parseInt(data.getString(13));
                        layoutParams2.rightMargin = 0;
                        layoutParams2.bottomMargin = 0;
                        this.f924b.setLayoutParams(layoutParams2);
                        this.f938d = String.valueOf(((this.f924b.getWidth() / 2) + (this.m - this.f924b.getWidth())) - Integer.parseInt(data.getString(12)));
                        this.f940e = String.valueOf(Integer.valueOf(data.getString(13)));
                        if (data.getString(17) == null) {
                            this.f933c.setVisibility(8);
                            this.f930c.setChecked(false);
                        } else if (Integer.parseInt(data.getString(17)) > 0) {
                            this.f933c.setVisibility(0);
                            this.f930c.setChecked(true);
                            RelativeLayout.LayoutParams layoutParamsSlsPoint = (RelativeLayout.LayoutParams) this.f933c.getLayoutParams();
                            layoutParamsSlsPoint.leftMargin = Integer.parseInt(data.getString(17));
                            layoutParamsSlsPoint.topMargin = Integer.parseInt(data.getString(18));
                            layoutParamsSlsPoint.rightMargin = 0;
                            layoutParamsSlsPoint.bottomMargin = 0;
                            this.f933c.setLayoutParams(layoutParamsSlsPoint);
                            this.j = Integer.parseInt(data.getString(17));
                            this.k = Integer.parseInt(data.getString(18));
                            this.f942f = String.valueOf(((this.f933c.getWidth() / 2) + (this.m - this.f933c.getWidth())) - Integer.parseInt(data.getString(17)));
                            this.f944g = String.valueOf(Integer.valueOf(data.getString(18)));
                        } else {
                            this.f933c.setVisibility(8);
                            this.f930c.setChecked(false);
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

    private void M() {
        try {
            this.f905a.setVerticalScrollBarEnabled(false);
            this.f905a.setHorizontalScrollBarEnabled(false);
            this.f904a.setVerticalScrollBarEnabled(false);
            this.f904a.setHorizontalScrollBarEnabled(false);
            Cursor data = this.f914a.u0();
            List<String> list5 = new ArrayList<>();
            if (data.getCount() > 0) {
                list5.add("تحديد باقة محفوظة");
                while (data.moveToNext()) {
                    list5.add(data.getString(1));
                }
            } else {
                list5.add("لا يوجد باقات محفوظة");
            }
            ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<>(this, 17367048, list5);
            dataAdapter4.setDropDownViewResource(17367049);
            this.f936d.setAdapter(dataAdapter4);
        } catch (Exception e2) {
        }
    }

    public void k0() {
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
            font_size_number_u.setText(String.valueOf(this.d));
            font_size_number_p.setText(String.valueOf(this.e));
            font_size_number_s.setText(String.valueOf(this.b));
            TextView submit_btn = (TextView) myView.findViewById(R.id.submit_btn);
            TextView textView = (TextView) myView.findViewById(R.id.refresh_img);
            AlertDialog b2 = dialogBuilder.create();
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
                    ArrayAdapter<SalesPointModel> color_type_s_adapter = new ArrayAdapter<>(this.f892a, 17367048, colorModel);
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
            color_type_s.setSelection(this.q, false);
            color_type_s.setOnItemSelectedListener(new f(colorList));
            color_type_u.setSelection(this.p, false);
            color_type_u.setOnItemSelectedListener(new g(colorList));
            color_type_p.setSelection(this.r, false);
            color_type_p.setOnItemSelectedListener(new h(colorList));
            plus_u.setOnClickListener(new pa0(this, font_size_number_u));
            menus_u.setOnClickListener(new sa0(this, font_size_number_u));
            plus_p.setOnClickListener(new na0(this, font_size_number_p));
            menus_p.setOnClickListener(new oa0(this, font_size_number_p));
            plus_s.setOnClickListener(new qa0(this, font_size_number_s));
            menus_s.setOnClickListener(new ra0(this, font_size_number_s));
            submit_btn.setOnClickListener(new i(b2));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    class f implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ String[] f950a;

        f(String[] strArr) {
            this.f950a = strArr;
        }

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SalesPointModel colorModel = (SalesPointModel) parent.getSelectedItem();
            String hexCode = this.f950a[colorModel.getId() - 1];
            int resultRed = Integer.valueOf(hexCode.substring(0, 2), 16).intValue();
            int resultGreen = Integer.valueOf(hexCode.substring(2, 4), 16).intValue();
            int resultBlue = Integer.valueOf(hexCode.substring(4, 6), 16).intValue();
            PrintCardsActivity.this.f933c.setTextColor(Color.rgb(resultRed, resultGreen, resultBlue));
            PrintCardsActivity.this.f935c = new w5(resultRed, resultGreen, resultBlue);
            PrintCardsActivity.this.q = colorModel.getId() - 1;
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class g implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ String[] f951a;

        g(String[] strArr) {
            this.f951a = strArr;
        }

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SalesPointModel colorModel = (SalesPointModel) parent.getSelectedItem();
            String hexCode = this.f951a[colorModel.getId() - 1];
            int resultRed = Integer.valueOf(hexCode.substring(0, 2), 16).intValue();
            int resultGreen = Integer.valueOf(hexCode.substring(2, 4), 16).intValue();
            int resultBlue = Integer.valueOf(hexCode.substring(4, 6), 16).intValue();
            PrintCardsActivity.this.f902a.setTextColor(Color.rgb(resultRed, resultGreen, resultBlue));
            PrintCardsActivity.this.f915a = new w5(resultRed, resultGreen, resultBlue);
            PrintCardsActivity.this.p = colorModel.getId() - 1;
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class h implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ String[] f952a;

        h(String[] strArr) {
            this.f952a = strArr;
        }

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SalesPointModel colorModel = (SalesPointModel) parent.getSelectedItem();
            String hexCode = this.f952a[colorModel.getId() - 1];
            int resultRed = Integer.valueOf(hexCode.substring(0, 2), 16).intValue();
            int resultGreen = Integer.valueOf(hexCode.substring(2, 4), 16).intValue();
            int resultBlue = Integer.valueOf(hexCode.substring(4, 6), 16).intValue();
            PrintCardsActivity.this.f924b.setTextColor(Color.rgb(resultRed, resultGreen, resultBlue));
            PrintCardsActivity.this.f927b = new w5(resultRed, resultGreen, resultBlue);
            PrintCardsActivity.this.r = colorModel.getId() - 1;
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y(TextView font_size_number_u, View v) {
        int i2 = this.d;
        if (i2 <= 13) {
            this.d = i2 + 1;
            TextView textView = this.f902a;
            textView.setTextSize(0, textView.getTextSize() + 2.0f);
            font_size_number_u.setText(String.valueOf(this.d));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z(TextView font_size_number_u, View v) {
        int i2 = this.d;
        if (i2 >= 8) {
            this.d = i2 - 1;
            TextView textView = this.f902a;
            textView.setTextSize(0, textView.getTextSize() - 2.0f);
            font_size_number_u.setText(String.valueOf(this.d));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a0(TextView font_size_number_p, View v) {
        int i2 = this.e;
        if (i2 <= 13) {
            this.e = i2 + 1;
            TextView textView = this.f924b;
            textView.setTextSize(0, textView.getTextSize() + 2.0f);
            font_size_number_p.setText(String.valueOf(this.e));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b0(TextView font_size_number_p, View v) {
        int i2 = this.e;
        if (i2 >= 8) {
            this.e = i2 - 1;
            TextView textView = this.f924b;
            textView.setTextSize(0, textView.getTextSize() - 2.0f);
            font_size_number_p.setText(String.valueOf(this.e));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c0(TextView font_size_number_s, View v) {
        float f2 = this.b;
        if (f2 <= 12.0f) {
            this.b = f2 + 1.0f;
            TextView textView = this.f933c;
            textView.setTextSize(0, textView.getTextSize() + 1.0f);
            font_size_number_s.setText(String.valueOf(this.b));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d0(TextView font_size_number_s, View v) {
        float f2 = this.b;
        if (f2 >= 8.0f) {
            this.b = f2 - 1.0f;
            TextView textView = this.f933c;
            textView.setTextSize(0, textView.getTextSize() - 1.0f);
            font_size_number_s.setText(String.valueOf(this.b));
        }
    }

    class i implements View.OnClickListener {
        final /* synthetic */ AlertDialog a;

        i(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        public void onClick(View v) {
            this.a.dismiss();
        }
    }
}
