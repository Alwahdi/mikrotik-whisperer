package com.blogspot.yemeninfo4it.mumsmobile_app.activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
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
import androidx.recyclerview.widget.RecyclerView;
import com.blogspot.yemeninfo4it.mumsmobile_app.MyHorizScrollView;
import com.blogspot.yemeninfo4it.mumsmobile_app.MyScrollView;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.ConnectData;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Model_images;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.SalesPointModel;
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

public class AddHostpotActivity extends AppCompatActivity {
    private static final String[] a = {"android.permission.WRITE_EXTERNAL_STORAGE"};

    /* renamed from: a  reason: collision with other field name */
    float f372a = 8.5f;

    /* renamed from: a  reason: collision with other field name */
    int f373a = 0;

    /* renamed from: a  reason: collision with other field name */
    ProgressDialog f374a;

    /* renamed from: a  reason: collision with other field name */
    Context f375a;

    /* renamed from: a  reason: collision with other field name */
    Uri f376a;

    /* renamed from: a  reason: collision with other field name */
    ViewGroup f377a;

    /* renamed from: a  reason: collision with other field name */
    ArrayAdapter<String> f378a;

    /* renamed from: a  reason: collision with other field name */
    Button f379a;

    /* renamed from: a  reason: collision with other field name */
    CheckBox f380a;

    /* renamed from: a  reason: collision with other field name */
    EditText f381a;

    /* renamed from: a  reason: collision with other field name */
    ImageView f382a;

    /* renamed from: a  reason: collision with other field name */
    LinearLayout f383a;

    /* renamed from: a  reason: collision with other field name */
    NumberPicker f384a;

    /* renamed from: a  reason: collision with other field name */
    RadioButton f385a;

    /* renamed from: a  reason: collision with other field name */
    Spinner f386a;

    /* renamed from: a  reason: collision with other field name */
    TextView f387a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public RecyclerView f388a;

    /* renamed from: a  reason: collision with other field name */
    b2 f389a;

    /* renamed from: a  reason: collision with other field name */
    MyHorizScrollView f390a;

    /* renamed from: a  reason: collision with other field name */
    MyScrollView f391a;

    /* renamed from: a  reason: collision with other field name */
    a0 f392a;

    /* renamed from: a  reason: collision with other field name */
    b0 f393a;

    /* renamed from: a  reason: collision with other field name */
    c0 f394a;

    /* renamed from: a  reason: collision with other field name */
    d0 f395a;

    /* renamed from: a  reason: collision with other field name */
    e0 f396a;

    /* renamed from: a  reason: collision with other field name */
    f0 f397a;

    /* renamed from: a  reason: collision with other field name */
    g0 f398a;

    /* renamed from: a  reason: collision with other field name */
    z f399a;

    /* renamed from: a  reason: collision with other field name */
    ConnectData f400a;

    /* renamed from: a  reason: collision with other field name */
    protected j3 f401a;

    /* renamed from: a  reason: collision with other field name */
    File f402a;

    /* renamed from: a  reason: collision with other field name */
    final String f403a = "mLog";
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<AddUserHotspot> f404a;

    /* renamed from: a  reason: collision with other field name */
    t0 f405a;

    /* renamed from: a  reason: collision with other field name */
    ue f406a;

    /* renamed from: a  reason: collision with other field name */
    w5 f407a = new w5(0, 0, 0);

    /* renamed from: a  reason: collision with other field name */
    zd f408a;

    /* renamed from: a  reason: collision with other field name */
    boolean f409a = false;
    /* access modifiers changed from: private */
    public int b;

    /* renamed from: b  reason: collision with other field name */
    ProgressDialog f410b;

    /* renamed from: b  reason: collision with other field name */
    Uri f411b = null;

    /* renamed from: b  reason: collision with other field name */
    ArrayAdapter<String> f412b;

    /* renamed from: b  reason: collision with other field name */
    Button f413b;

    /* renamed from: b  reason: collision with other field name */
    CheckBox f414b;

    /* renamed from: b  reason: collision with other field name */
    EditText f415b;

    /* renamed from: b  reason: collision with other field name */
    ImageView f416b;

    /* renamed from: b  reason: collision with other field name */
    LinearLayout f417b;

    /* renamed from: b  reason: collision with other field name */
    RadioButton f418b;

    /* renamed from: b  reason: collision with other field name */
    Spinner f419b;

    /* renamed from: b  reason: collision with other field name */
    TextView f420b;

    /* renamed from: b  reason: collision with other field name */
    j3 f421b;

    /* renamed from: b  reason: collision with other field name */
    public String f422b = "";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public ArrayList<HotspotCard> f423b;

    /* renamed from: b  reason: collision with other field name */
    w5 f424b = new w5(0, 0, 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public boolean f425b = false;
    /* access modifiers changed from: private */
    public int c;

    /* renamed from: c  reason: collision with other field name */
    Button f426c;

    /* renamed from: c  reason: collision with other field name */
    CheckBox f427c;

    /* renamed from: c  reason: collision with other field name */
    EditText f428c;

    /* renamed from: c  reason: collision with other field name */
    ImageView f429c;

    /* renamed from: c  reason: collision with other field name */
    LinearLayout f430c;

    /* renamed from: c  reason: collision with other field name */
    RadioButton f431c;

    /* renamed from: c  reason: collision with other field name */
    Spinner f432c;

    /* renamed from: c  reason: collision with other field name */
    TextView f433c;

    /* renamed from: c  reason: collision with other field name */
    String f434c;

    /* renamed from: c  reason: collision with other field name */
    public ArrayList<Model_images> f435c = new ArrayList<>();

    /* renamed from: c  reason: collision with other field name */
    w5 f436c = new w5(0, 0, 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with other field name */
    public boolean f437c = false;
    int d = 10;

    /* renamed from: d  reason: collision with other field name */
    Button f438d;

    /* renamed from: d  reason: collision with other field name */
    CheckBox f439d;

    /* renamed from: d  reason: collision with other field name */
    EditText f440d;

    /* renamed from: d  reason: collision with other field name */
    LinearLayout f441d;

    /* renamed from: d  reason: collision with other field name */
    RadioButton f442d;

    /* renamed from: d  reason: collision with other field name */
    Spinner f443d;

    /* renamed from: d  reason: collision with other field name */
    TextView f444d;

    /* renamed from: d  reason: collision with other field name */
    String f445d;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with other field name */
    public boolean f446d = false;
    int e = 10;

    /* renamed from: e  reason: collision with other field name */
    Button f447e;

    /* renamed from: e  reason: collision with other field name */
    CheckBox f448e;

    /* renamed from: e  reason: collision with other field name */
    EditText f449e;

    /* renamed from: e  reason: collision with other field name */
    LinearLayout f450e;

    /* renamed from: e  reason: collision with other field name */
    RadioButton f451e;

    /* renamed from: e  reason: collision with other field name */
    Spinner f452e;

    /* renamed from: e  reason: collision with other field name */
    TextView f453e;

    /* renamed from: e  reason: collision with other field name */
    String f454e = "";
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with other field name */
    public boolean f455e = false;
    int f = 0;

    /* renamed from: f  reason: collision with other field name */
    CheckBox f456f;

    /* renamed from: f  reason: collision with other field name */
    EditText f457f;

    /* renamed from: f  reason: collision with other field name */
    LinearLayout f458f;

    /* renamed from: f  reason: collision with other field name */
    RadioButton f459f;

    /* renamed from: f  reason: collision with other field name */
    Spinner f460f;

    /* renamed from: f  reason: collision with other field name */
    TextView f461f;

    /* renamed from: f  reason: collision with other field name */
    String f462f = "1";

    /* renamed from: f  reason: collision with other field name */
    boolean f463f = false;
    int g = 0;

    /* renamed from: g  reason: collision with other field name */
    CheckBox f464g;

    /* renamed from: g  reason: collision with other field name */
    EditText f465g;

    /* renamed from: g  reason: collision with other field name */
    LinearLayout f466g;

    /* renamed from: g  reason: collision with other field name */
    RadioButton f467g;

    /* renamed from: g  reason: collision with other field name */
    Spinner f468g;

    /* renamed from: g  reason: collision with other field name */
    TextView f469g;

    /* renamed from: g  reason: collision with other field name */
    String f470g = "1";
    int h = 0;

    /* renamed from: h  reason: collision with other field name */
    private CheckBox f471h;

    /* renamed from: h  reason: collision with other field name */
    EditText f472h;

    /* renamed from: h  reason: collision with other field name */
    Spinner f473h;

    /* renamed from: h  reason: collision with other field name */
    TextView f474h;

    /* renamed from: h  reason: collision with other field name */
    String f475h = "1";
    int i = 0;

    /* renamed from: i  reason: collision with other field name */
    EditText f476i;

    /* renamed from: i  reason: collision with other field name */
    Spinner f477i;

    /* renamed from: i  reason: collision with other field name */
    TextView f478i;

    /* renamed from: i  reason: collision with other field name */
    String f479i = "1";
    int j = 0;

    /* renamed from: j  reason: collision with other field name */
    EditText f480j;

    /* renamed from: j  reason: collision with other field name */
    TextView f481j;

    /* renamed from: j  reason: collision with other field name */
    String f482j = "1";
    int k = 0;

    /* renamed from: k  reason: collision with other field name */
    EditText f483k;

    /* renamed from: k  reason: collision with other field name */
    TextView f484k;

    /* renamed from: k  reason: collision with other field name */
    String f485k = "1";
    int l = 0;

    /* renamed from: l  reason: collision with other field name */
    EditText f486l;

    /* renamed from: l  reason: collision with other field name */
    TextView f487l;

    /* renamed from: l  reason: collision with other field name */
    String f488l;
    int m = 0;

    /* renamed from: m  reason: collision with other field name */
    EditText f489m;

    /* renamed from: m  reason: collision with other field name */
    TextView f490m;

    /* renamed from: m  reason: collision with other field name */
    String f491m = "";
    int n = 0;

    /* renamed from: n  reason: collision with other field name */
    EditText f492n;

    /* renamed from: n  reason: collision with other field name */
    String f493n = "no";
    int o = 0;

    /* renamed from: o  reason: collision with other field name */
    String f494o = null;
    int p = 3;
    int q = 0;
    int r = 0;
    int s = 0;
    int t = 0;
    int u = 0;

    static {
        System.loadLibrary("native-lib");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0427 A[Catch:{ Exception -> 0x06d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0430 A[Catch:{ Exception -> 0x06d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0439 A[Catch:{ Exception -> 0x06d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0442 A[Catch:{ Exception -> 0x06d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x04f4 A[Catch:{ Exception -> 0x06d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x04f9 A[Catch:{ Exception -> 0x06d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0507 A[Catch:{ Exception -> 0x0517 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x051f A[Catch:{ Exception -> 0x06d3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r17) {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r2 = "4"
            super.onCreate(r17)
            r3 = 2131492909(0x7f0c002d, float:1.8609283E38)
            r1.setContentView((int) r3)
            r3 = 1
            r1.f375a = r1     // Catch:{ Exception -> 0x06d3 }
            j3 r4 = defpackage.qb0.d()     // Catch:{ Exception -> 0x06d3 }
            r1.f401a = r4     // Catch:{ Exception -> 0x06d3 }
            boolean r4 = r16.e0()     // Catch:{ Exception -> 0x06d3 }
            if (r4 != 0) goto L_0x001f
            r16.V0()     // Catch:{ Exception -> 0x06d3 }
        L_0x001f:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x06d3 }
            r4.<init>()     // Catch:{ Exception -> 0x06d3 }
            r1.f404a = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296698(0x7f0901ba, float:1.821132E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f377a = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296940(0x7f0902ac, float:1.821181E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            com.blogspot.yemeninfo4it.mumsmobile_app.MyScrollView r4 = (com.blogspot.yemeninfo4it.mumsmobile_app.MyScrollView) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f391a = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296870(0x7f090266, float:1.8211669E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f383a = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296416(0x7f0900a0, float:1.8210748E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f433c = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131297150(0x7f09037e, float:1.8212237E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.CheckBox r4 = (android.widget.CheckBox) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f380a = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131297132(0x7f09036c, float:1.82122E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.CheckBox r4 = (android.widget.CheckBox) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f464g = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296960(0x7f0902c0, float:1.8211851E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.CheckBox r4 = (android.widget.CheckBox) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f414b = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296748(0x7f0901ec, float:1.8211421E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.CheckBox r4 = (android.widget.CheckBox) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f456f = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296847(0x7f09024f, float:1.8211622E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f444d = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296964(0x7f0902c4, float:1.821186E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f461f = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296595(0x7f090153, float:1.8211111E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f490m = r4     // Catch:{ Exception -> 0x06d3 }
            android.widget.TextView r4 = r1.f444d     // Catch:{ Exception -> 0x06d3 }
            android.view.View$OnTouchListener r5 = r16.T0()     // Catch:{ Exception -> 0x06d3 }
            r4.setOnTouchListener(r5)     // Catch:{ Exception -> 0x06d3 }
            android.widget.TextView r4 = r1.f433c     // Catch:{ Exception -> 0x06d3 }
            android.view.View$OnTouchListener r5 = r16.S0()     // Catch:{ Exception -> 0x06d3 }
            r4.setOnTouchListener(r5)     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296992(0x7f0902e0, float:1.8211916E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f453e = r4     // Catch:{ Exception -> 0x06d3 }
            android.view.View$OnTouchListener r5 = r16.U0()     // Catch:{ Exception -> 0x06d3 }
            r4.setOnTouchListener(r5)     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296591(0x7f09014f, float:1.8211103E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f469g = r4     // Catch:{ Exception -> 0x06d3 }
            ue r4 = new ue     // Catch:{ Exception -> 0x06d3 }
            android.content.Context r5 = r1.f375a     // Catch:{ Exception -> 0x06d3 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x06d3 }
            r1.f406a = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296810(0x7f09022a, float:1.8211547E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.RadioButton r4 = (android.widget.RadioButton) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f385a = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296427(0x7f0900ab, float:1.821077E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.RadioButton r4 = (android.widget.RadioButton) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f418b = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296809(0x7f090229, float:1.8211545E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.RadioButton r4 = (android.widget.RadioButton) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f431c = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296786(0x7f090212, float:1.8211499E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.RadioButton r4 = (android.widget.RadioButton) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f442d = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296785(0x7f090211, float:1.8211496E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.RadioButton r4 = (android.widget.RadioButton) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f451e = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296326(0x7f090046, float:1.8210566E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.RadioButton r4 = (android.widget.RadioButton) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f459f = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296333(0x7f09004d, float:1.821058E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.RadioButton r4 = (android.widget.RadioButton) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f467g = r4     // Catch:{ Exception -> 0x06d3 }
            android.widget.RadioButton r4 = r1.f385a     // Catch:{ Exception -> 0x06d3 }
            r4.setChecked(r3)     // Catch:{ Exception -> 0x06d3 }
            android.widget.RadioButton r4 = r1.f451e     // Catch:{ Exception -> 0x06d3 }
            r4.setChecked(r3)     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296394(0x7f09008a, float:1.8210703E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Button r4 = (android.widget.Button) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f447e = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296430(0x7f0900ae, float:1.8210776E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.CheckBox r4 = (android.widget.CheckBox) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f471h = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296962(0x7f0902c2, float:1.8211855E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f484k = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296858(0x7f09025a, float:1.8211645E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.ImageView r4 = (android.widget.ImageView) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f382a = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296730(0x7f0901da, float:1.8211385E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.ImageView r4 = (android.widget.ImageView) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f416b = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296375(0x7f090077, float:1.8210665E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.ImageView r4 = (android.widget.ImageView) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f429c = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296596(0x7f090154, float:1.8211113E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.NumberPicker r4 = (android.widget.NumberPicker) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f384a = r4     // Catch:{ Exception -> 0x06d3 }
            r5 = 8
            r4.setMinValue(r5)     // Catch:{ Exception -> 0x06d3 }
            android.widget.NumberPicker r4 = r1.f384a     // Catch:{ Exception -> 0x06d3 }
            r5 = 14
            r4.setMaxValue(r5)     // Catch:{ Exception -> 0x06d3 }
            android.widget.NumberPicker r4 = r1.f384a     // Catch:{ Exception -> 0x06d3 }
            r5 = 10
            r4.setValue(r5)     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296621(0x7f09016d, float:1.8211164E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f487l = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296627(0x7f090173, float:1.8211176E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            com.blogspot.yemeninfo4it.mumsmobile_app.MyHorizScrollView r4 = (com.blogspot.yemeninfo4it.mumsmobile_app.MyHorizScrollView) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f390a = r4     // Catch:{ Exception -> 0x06d3 }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.ConnectData r4 = new com.blogspot.yemeninfo4it.mumsmobile_app.model.ConnectData     // Catch:{ Exception -> 0x06d3 }
            r4.<init>()     // Catch:{ Exception -> 0x06d3 }
            r1.f400a = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296897(0x7f090281, float:1.8211724E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            androidx.recyclerview.widget.RecyclerView r4 = (androidx.recyclerview.widget.RecyclerView) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f388a = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296414(0x7f09009e, float:1.8210744E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.EditText r4 = (android.widget.EditText) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f381a = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131297022(0x7f0902fe, float:1.8211977E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.EditText r4 = (android.widget.EditText) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f415b = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296554(0x7f09012a, float:1.8211028E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.EditText r4 = (android.widget.EditText) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f428c = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296735(0x7f0901df, float:1.8211395E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.EditText r4 = (android.widget.EditText) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f440d = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131297151(0x7f09037f, float:1.8212239E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Spinner r4 = (android.widget.Spinner) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f473h = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296846(0x7f09024e, float:1.821162E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Spinner r4 = (android.widget.Spinner) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f477i = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131297082(0x7f09033a, float:1.8212099E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.EditText r4 = (android.widget.EditText) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f449e = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296495(0x7f0900ef, float:1.8210908E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.EditText r4 = (android.widget.EditText) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f457f = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131297107(0x7f090353, float:1.821215E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.EditText r4 = (android.widget.EditText) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f465g = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296738(0x7f0901e2, float:1.8211401E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.EditText r4 = (android.widget.EditText) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f486l = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296868(0x7f090264, float:1.8211665E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.EditText r4 = (android.widget.EditText) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f476i = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296976(0x7f0902d0, float:1.8211884E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f387a = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296502(0x7f0900f6, float:1.8210922E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f474h = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296931(0x7f0902a3, float:1.8211793E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Spinner r4 = (android.widget.Spinner) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f460f = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296819(0x7f090233, float:1.8211565E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.EditText r4 = (android.widget.EditText) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f472h = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131297161(0x7f090389, float:1.821226E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.CheckBox r4 = (android.widget.CheckBox) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f427c = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296844(0x7f09024c, float:1.8211616E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.CheckBox r4 = (android.widget.CheckBox) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f439d = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296991(0x7f0902df, float:1.8211914E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.CheckBox r4 = (android.widget.CheckBox) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f448e = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296654(0x7f09018e, float:1.821123E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.EditText r4 = (android.widget.EditText) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f489m = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296655(0x7f09018f, float:1.8211233E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.EditText r4 = (android.widget.EditText) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f492n = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296611(0x7f090163, float:1.8211144E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f441d = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296817(0x7f090231, float:1.8211561E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f417b = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296987(0x7f0902db, float:1.8211906E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f430c = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131297021(0x7f0902fd, float:1.8211975E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f466g = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296818(0x7f090232, float:1.8211563E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f450e = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296612(0x7f090164, float:1.8211146E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f458f = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296337(0x7f090051, float:1.8210588E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Button r4 = (android.widget.Button) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f438d = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131297149(0x7f09037d, float:1.8212235E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.EditText r4 = (android.widget.EditText) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f480j = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296850(0x7f090252, float:1.8211628E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.EditText r4 = (android.widget.EditText) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f483k = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296878(0x7f09026e, float:1.8211685E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Spinner r4 = (android.widget.Spinner) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f386a = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296965(0x7f0902c5, float:1.8211862E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Spinner r4 = (android.widget.Spinner) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f419b = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296989(0x7f0902dd, float:1.821191E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Spinner r4 = (android.widget.Spinner) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f443d = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131297108(0x7f090354, float:1.8212152E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Spinner r4 = (android.widget.Spinner) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f468g = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296415(0x7f09009f, float:1.8210746E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Spinner r4 = (android.widget.Spinner) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f432c = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296411(0x7f09009b, float:1.8210738E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Spinner r4 = (android.widget.Spinner) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f452e = r4     // Catch:{ Exception -> 0x06d3 }
            r4 = 2131296871(0x7f090267, float:1.821167E38)
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x06d3 }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f420b = r4     // Catch:{ Exception -> 0x06d3 }
            android.app.ProgressDialog r4 = new android.app.ProgressDialog     // Catch:{ Exception -> 0x06d3 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x06d3 }
            r1.f374a = r4     // Catch:{ Exception -> 0x06d3 }
            r4.setProgressStyle(r3)     // Catch:{ Exception -> 0x06d3 }
            zd r4 = new zd     // Catch:{ Exception -> 0x06d3 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x06d3 }
            r1.f408a = r4     // Catch:{ Exception -> 0x06d3 }
            android.app.Dialog r4 = r4.b()     // Catch:{ Exception -> 0x06d3 }
            r5 = 2131296408(0x7f090098, float:1.8210732E38)
            android.view.View r4 = r4.findViewById(r5)     // Catch:{ Exception -> 0x06d3 }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f478i = r4     // Catch:{ Exception -> 0x06d3 }
            zd r4 = r1.f408a     // Catch:{ Exception -> 0x06d3 }
            android.app.Dialog r4 = r4.b()     // Catch:{ Exception -> 0x06d3 }
            r5 = 2131296474(0x7f0900da, float:1.8210866E38)
            android.view.View r4 = r4.findViewById(r5)     // Catch:{ Exception -> 0x06d3 }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ Exception -> 0x06d3 }
            r1.f481j = r4     // Catch:{ Exception -> 0x06d3 }
            r5 = 0
            r4.setVisibility(r5)     // Catch:{ Exception -> 0x06d3 }
            android.app.ProgressDialog r4 = new android.app.ProgressDialog     // Catch:{ Exception -> 0x06d3 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x06d3 }
            r1.f410b = r4     // Catch:{ Exception -> 0x06d3 }
            android.view.ViewGroup r4 = r1.f377a     // Catch:{ Exception -> 0x06d3 }
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()     // Catch:{ Exception -> 0x06d3 }
            android.widget.LinearLayout$LayoutParams r4 = (android.widget.LinearLayout.LayoutParams) r4     // Catch:{ Exception -> 0x06d3 }
            r6 = 465(0x1d1, float:6.52E-43)
            r4.height = r6     // Catch:{ Exception -> 0x06d3 }
            r6 = 1400(0x578, float:1.962E-42)
            r4.width = r6     // Catch:{ Exception -> 0x06d3 }
            android.view.ViewGroup r7 = r1.f377a     // Catch:{ Exception -> 0x06d3 }
            r7.setLayoutParams(r4)     // Catch:{ Exception -> 0x06d3 }
            r1.q = r6     // Catch:{ Exception -> 0x06d3 }
            int r7 = r16.X0()     // Catch:{ Exception -> 0x06d3 }
            if (r7 <= r6) goto L_0x03a5
            android.view.ViewGroup r8 = r1.f377a     // Catch:{ Exception -> 0x06d3 }
            android.view.ViewGroup$LayoutParams r8 = r8.getLayoutParams()     // Catch:{ Exception -> 0x06d3 }
            r8.width = r6     // Catch:{ Exception -> 0x06d3 }
            r1.q = r6     // Catch:{ Exception -> 0x06d3 }
        L_0x03a5:
            r1.Y0(r7)     // Catch:{ Exception -> 0x06d3 }
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot> r6 = defpackage.qb0.o     // Catch:{ Exception -> 0x06d3 }
            if (r6 == 0) goto L_0x03ba
            r1.f404a = r6     // Catch:{ Exception -> 0x06d3 }
            b2 r8 = new b2     // Catch:{ Exception -> 0x06d3 }
            r8.<init>(r1, r6)     // Catch:{ Exception -> 0x06d3 }
            r1.f389a = r8     // Catch:{ Exception -> 0x06d3 }
            androidx.recyclerview.widget.RecyclerView r6 = r1.f388a     // Catch:{ Exception -> 0x06d3 }
            r6.setAdapter(r8)     // Catch:{ Exception -> 0x06d3 }
        L_0x03ba:
            java.util.List<java.lang.String> r6 = defpackage.qb0.f4804a     // Catch:{ Exception -> 0x06d3 }
            r8 = 17367049(0x1090009, float:2.516295E-38)
            r9 = 17367048(0x1090008, float:2.5162948E-38)
            if (r6 == 0) goto L_0x03f4
            java.util.List<java.lang.String> r6 = defpackage.qb0.f4808b     // Catch:{ Exception -> 0x06d3 }
            if (r6 != 0) goto L_0x03c9
            goto L_0x03f4
        L_0x03c9:
            android.widget.ArrayAdapter r6 = new android.widget.ArrayAdapter     // Catch:{ Exception -> 0x06d3 }
            java.util.List<java.lang.String> r10 = defpackage.qb0.f4804a     // Catch:{ Exception -> 0x06d3 }
            r6.<init>(r1, r9, r10)     // Catch:{ Exception -> 0x06d3 }
            r1.f378a = r6     // Catch:{ Exception -> 0x06d3 }
            r6.setDropDownViewResource(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Spinner r6 = r1.f386a     // Catch:{ Exception -> 0x06d3 }
            android.widget.ArrayAdapter<java.lang.String> r10 = r1.f378a     // Catch:{ Exception -> 0x06d3 }
            r6.setAdapter(r10)     // Catch:{ Exception -> 0x06d3 }
            java.util.List<java.lang.String> r6 = defpackage.qb0.f4808b     // Catch:{ Exception -> 0x06d3 }
            if (r6 == 0) goto L_0x0402
            android.widget.ArrayAdapter r6 = new android.widget.ArrayAdapter     // Catch:{ Exception -> 0x06d3 }
            java.util.List<java.lang.String> r10 = defpackage.qb0.f4808b     // Catch:{ Exception -> 0x06d3 }
            r6.<init>(r1, r9, r10)     // Catch:{ Exception -> 0x06d3 }
            r1.f412b = r6     // Catch:{ Exception -> 0x06d3 }
            r6.setDropDownViewResource(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Spinner r6 = r1.f419b     // Catch:{ Exception -> 0x06d3 }
            android.widget.ArrayAdapter<java.lang.String> r10 = r1.f412b     // Catch:{ Exception -> 0x06d3 }
            r6.setAdapter(r10)     // Catch:{ Exception -> 0x06d3 }
            goto L_0x0402
        L_0x03f4:
            com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$d0 r6 = new com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$d0     // Catch:{ Exception -> 0x06d3 }
            r6.<init>()     // Catch:{ Exception -> 0x06d3 }
            r1.f395a = r6     // Catch:{ Exception -> 0x06d3 }
            java.util.concurrent.Executor r10 = android.os.AsyncTask.THREAD_POOL_EXECUTOR     // Catch:{ Exception -> 0x06d3 }
            java.lang.String[] r11 = new java.lang.String[r5]     // Catch:{ Exception -> 0x06d3 }
            r6.executeOnExecutor(r10, r11)     // Catch:{ Exception -> 0x06d3 }
        L_0x0402:
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x06d3 }
            r6.<init>()     // Catch:{ Exception -> 0x06d3 }
            java.lang.String r10 = "ميجا"
            r6.add(r10)     // Catch:{ Exception -> 0x06d3 }
            java.lang.String r10 = "جيجا"
            r6.add(r10)     // Catch:{ Exception -> 0x06d3 }
            java.lang.String r10 = "غير محدود"
            r6.add(r10)     // Catch:{ Exception -> 0x06d3 }
            android.widget.ArrayAdapter r10 = new android.widget.ArrayAdapter     // Catch:{ Exception -> 0x06d3 }
            r10.<init>(r1, r9, r6)     // Catch:{ Exception -> 0x06d3 }
            r10.setDropDownViewResource(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Spinner r11 = r1.f468g     // Catch:{ Exception -> 0x06d3 }
            r11.setAdapter(r10)     // Catch:{ Exception -> 0x06d3 }
            java.lang.String r11 = defpackage.qb0.f4814d     // Catch:{ Exception -> 0x06d3 }
            if (r11 == 0) goto L_0x042c
            android.widget.EditText r12 = r1.f457f     // Catch:{ Exception -> 0x06d3 }
            r12.setText(r11)     // Catch:{ Exception -> 0x06d3 }
        L_0x042c:
            java.lang.String r11 = defpackage.qb0.f4818e     // Catch:{ Exception -> 0x06d3 }
            if (r11 == 0) goto L_0x0435
            android.widget.EditText r12 = r1.f476i     // Catch:{ Exception -> 0x06d3 }
            r12.setText(r11)     // Catch:{ Exception -> 0x06d3 }
        L_0x0435:
            java.lang.String r11 = defpackage.qb0.f4821f     // Catch:{ Exception -> 0x06d3 }
            if (r11 == 0) goto L_0x043e
            android.widget.EditText r12 = r1.f449e     // Catch:{ Exception -> 0x06d3 }
            r12.setText(r11)     // Catch:{ Exception -> 0x06d3 }
        L_0x043e:
            java.lang.String r11 = defpackage.qb0.f4824g     // Catch:{ Exception -> 0x06d3 }
            if (r11 == 0) goto L_0x0447
            android.widget.EditText r12 = r1.f465g     // Catch:{ Exception -> 0x06d3 }
            r12.setText(r11)     // Catch:{ Exception -> 0x06d3 }
        L_0x0447:
            com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$a0 r11 = new com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$a0     // Catch:{ Exception -> 0x06d3 }
            r11.<init>()     // Catch:{ Exception -> 0x06d3 }
            r1.f392a = r11     // Catch:{ Exception -> 0x06d3 }
            java.lang.String[] r12 = new java.lang.String[r5]     // Catch:{ Exception -> 0x06d3 }
            r11.execute(r12)     // Catch:{ Exception -> 0x06d3 }
            com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$z r11 = new com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$z     // Catch:{ Exception -> 0x06d3 }
            r11.<init>()     // Catch:{ Exception -> 0x06d3 }
            r1.f399a = r11     // Catch:{ Exception -> 0x06d3 }
            java.lang.String[] r12 = new java.lang.String[r5]     // Catch:{ Exception -> 0x06d3 }
            r11.execute(r12)     // Catch:{ Exception -> 0x06d3 }
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ Exception -> 0x06d3 }
            r11.<init>()     // Catch:{ Exception -> 0x06d3 }
            r11.add(r2)     // Catch:{ Exception -> 0x06d3 }
            java.lang.String r12 = "5"
            r11.add(r12)     // Catch:{ Exception -> 0x06d3 }
            java.lang.String r12 = "6"
            r11.add(r12)     // Catch:{ Exception -> 0x06d3 }
            java.lang.String r12 = "7"
            r11.add(r12)     // Catch:{ Exception -> 0x06d3 }
            java.lang.String r12 = "8"
            r11.add(r12)     // Catch:{ Exception -> 0x06d3 }
            java.lang.String r12 = "9"
            r11.add(r12)     // Catch:{ Exception -> 0x06d3 }
            java.lang.String r12 = "10"
            r11.add(r12)     // Catch:{ Exception -> 0x06d3 }
            android.widget.ArrayAdapter r12 = new android.widget.ArrayAdapter     // Catch:{ Exception -> 0x06d3 }
            r12.<init>(r1, r9, r11)     // Catch:{ Exception -> 0x06d3 }
            r12.setDropDownViewResource(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Spinner r13 = r1.f473h     // Catch:{ Exception -> 0x06d3 }
            r13.setAdapter(r12)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Spinner r13 = r1.f477i     // Catch:{ Exception -> 0x06d3 }
            r13.setAdapter(r12)     // Catch:{ Exception -> 0x06d3 }
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ Exception -> 0x06d3 }
            r13.<init>()     // Catch:{ Exception -> 0x06d3 }
            java.lang.String r14 = "3"
            r13.add(r14)     // Catch:{ Exception -> 0x06d3 }
            r13.add(r2)     // Catch:{ Exception -> 0x06d3 }
            android.widget.ArrayAdapter r2 = new android.widget.ArrayAdapter     // Catch:{ Exception -> 0x06d3 }
            r2.<init>(r1, r9, r13)     // Catch:{ Exception -> 0x06d3 }
            r2.setDropDownViewResource(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Spinner r14 = r1.f432c     // Catch:{ Exception -> 0x06d3 }
            r14.setAdapter(r2)     // Catch:{ Exception -> 0x06d3 }
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ Exception -> 0x06d3 }
            r14.<init>()     // Catch:{ Exception -> 0x06d3 }
            java.lang.String r15 = "12"
            r14.add(r15)     // Catch:{ Exception -> 0x06d3 }
            java.lang.String r15 = "13"
            r14.add(r15)     // Catch:{ Exception -> 0x06d3 }
            java.lang.String r15 = "14"
            r14.add(r15)     // Catch:{ Exception -> 0x06d3 }
            java.lang.String r15 = "15"
            r14.add(r15)     // Catch:{ Exception -> 0x06d3 }
            java.lang.String r15 = "16"
            r14.add(r15)     // Catch:{ Exception -> 0x06d3 }
            java.lang.String r15 = "17"
            r14.add(r15)     // Catch:{ Exception -> 0x06d3 }
            java.lang.String r15 = "18"
            r14.add(r15)     // Catch:{ Exception -> 0x06d3 }
            java.lang.String r15 = "19"
            r14.add(r15)     // Catch:{ Exception -> 0x06d3 }
            java.lang.String r15 = "20"
            r14.add(r15)     // Catch:{ Exception -> 0x06d3 }
            android.widget.ArrayAdapter r15 = new android.widget.ArrayAdapter     // Catch:{ Exception -> 0x06d3 }
            r15.<init>(r1, r9, r14)     // Catch:{ Exception -> 0x06d3 }
            r15.setDropDownViewResource(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Spinner r3 = r1.f452e     // Catch:{ Exception -> 0x06d3 }
            r3.setAdapter(r15)     // Catch:{ Exception -> 0x06d3 }
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard> r3 = defpackage.qb0.f4834l     // Catch:{ Exception -> 0x06d3 }
            if (r3 == 0) goto L_0x04f9
            int r3 = r3.size()     // Catch:{ Exception -> 0x06d3 }
            goto L_0x04fa
        L_0x04f9:
            r3 = 0
        L_0x04fa:
            r1.r = r3     // Catch:{ Exception -> 0x06d3 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x0517 }
            r3.<init>()     // Catch:{ Exception -> 0x0517 }
            r1.f423b = r3     // Catch:{ Exception -> 0x0517 }
            int r3 = r1.r     // Catch:{ Exception -> 0x0517 }
            if (r3 != 0) goto L_0x0518
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x0517 }
            r3.<init>()     // Catch:{ Exception -> 0x0517 }
            defpackage.qb0.f4834l = r3     // Catch:{ Exception -> 0x0517 }
            ue r3 = r1.f406a     // Catch:{ Exception -> 0x0517 }
            java.util.ArrayList r3 = r3.g0()     // Catch:{ Exception -> 0x0517 }
            r1.f423b = r3     // Catch:{ Exception -> 0x0517 }
            goto L_0x0518
        L_0x0517:
            r0 = move-exception
        L_0x0518:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x06d3 }
            r8 = 30
            if (r3 < r8) goto L_0x0524
            android.widget.TextView r3 = r1.f420b     // Catch:{ Exception -> 0x06d3 }
            r3.setVisibility(r5)     // Catch:{ Exception -> 0x06d3 }
        L_0x0524:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x0552 }
            r3.<init>()     // Catch:{ Exception -> 0x0552 }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.SalesPointModel r8 = new com.blogspot.yemeninfo4it.mumsmobile_app.model.SalesPointModel     // Catch:{ Exception -> 0x0552 }
            java.lang.String r9 = "اختار اسم النقطة"
            r8.<init>(r5, r9, r5, r5)     // Catch:{ Exception -> 0x0552 }
            r3.add(r8)     // Catch:{ Exception -> 0x0552 }
            ue r5 = r1.f406a     // Catch:{ Exception -> 0x0552 }
            java.util.ArrayList r5 = r5.p0()     // Catch:{ Exception -> 0x0552 }
            r3.addAll(r5)     // Catch:{ Exception -> 0x0552 }
            android.widget.ArrayAdapter r5 = new android.widget.ArrayAdapter     // Catch:{ Exception -> 0x0552 }
            android.content.Context r8 = r1.f375a     // Catch:{ Exception -> 0x0552 }
            r9 = 17367048(0x1090008, float:2.5162948E-38)
            r5.<init>(r8, r9, r3)     // Catch:{ Exception -> 0x0552 }
            r8 = 17367049(0x1090009, float:2.516295E-38)
            r5.setDropDownViewResource(r8)     // Catch:{ Exception -> 0x0552 }
            android.widget.Spinner r8 = r1.f443d     // Catch:{ Exception -> 0x0552 }
            r8.setAdapter(r5)     // Catch:{ Exception -> 0x0552 }
            goto L_0x0553
        L_0x0552:
            r0 = move-exception
        L_0x0553:
            android.widget.Spinner r3 = r1.f443d     // Catch:{ Exception -> 0x06d3 }
            com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$k r5 = new com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$k     // Catch:{ Exception -> 0x06d3 }
            r5.<init>()     // Catch:{ Exception -> 0x06d3 }
            r3.setOnItemSelectedListener(r5)     // Catch:{ Exception -> 0x06d3 }
            android.widget.TextView r3 = r1.f478i     // Catch:{ Exception -> 0x06d3 }
            a1 r5 = new a1     // Catch:{ Exception -> 0x06d3 }
            r5.<init>(r1)     // Catch:{ Exception -> 0x06d3 }
            r3.setOnClickListener(r5)     // Catch:{ Exception -> 0x06d3 }
            r3 = 2131296873(0x7f090269, float:1.8211675E38)
            android.view.View r3 = r1.findViewById(r3)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Button r3 = (android.widget.Button) r3     // Catch:{ Exception -> 0x06d3 }
            r1.f426c = r3     // Catch:{ Exception -> 0x06d3 }
            r3 = 2131296343(0x7f090057, float:1.82106E38)
            android.view.View r3 = r1.findViewById(r3)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Button r3 = (android.widget.Button) r3     // Catch:{ Exception -> 0x06d3 }
            r1.f413b = r3     // Catch:{ Exception -> 0x06d3 }
            r3 = 2131296886(0x7f090276, float:1.8211701E38)
            android.view.View r3 = r1.findViewById(r3)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Button r3 = (android.widget.Button) r3     // Catch:{ Exception -> 0x06d3 }
            r1.f379a = r3     // Catch:{ Exception -> 0x06d3 }
            androidx.recyclerview.widget.LinearLayoutManager r3 = new androidx.recyclerview.widget.LinearLayoutManager     // Catch:{ Exception -> 0x06d3 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x06d3 }
            androidx.recyclerview.widget.RecyclerView r5 = r1.f388a     // Catch:{ Exception -> 0x06d3 }
            r5.setLayoutManager(r3)     // Catch:{ Exception -> 0x06d3 }
            b2 r5 = new b2     // Catch:{ Exception -> 0x06d3 }
            android.content.Context r8 = r1.f375a     // Catch:{ Exception -> 0x06d3 }
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot> r9 = r1.f404a     // Catch:{ Exception -> 0x06d3 }
            r5.<init>(r8, r9)     // Catch:{ Exception -> 0x06d3 }
            r1.f389a = r5     // Catch:{ Exception -> 0x06d3 }
            androidx.recyclerview.widget.RecyclerView r8 = r1.f388a     // Catch:{ Exception -> 0x06d3 }
            r8.setAdapter(r5)     // Catch:{ Exception -> 0x06d3 }
            androidx.recyclerview.widget.RecyclerView r5 = r1.f388a     // Catch:{ Exception -> 0x06d3 }
            androidx.recyclerview.widget.DefaultItemAnimator r8 = new androidx.recyclerview.widget.DefaultItemAnimator     // Catch:{ Exception -> 0x06d3 }
            r8.<init>()     // Catch:{ Exception -> 0x06d3 }
            r5.setItemAnimator(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Button r5 = r1.f379a     // Catch:{ Exception -> 0x06d3 }
            com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$l r8 = new com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$l     // Catch:{ Exception -> 0x06d3 }
            r8.<init>()     // Catch:{ Exception -> 0x06d3 }
            r5.setOnClickListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.TextView r5 = r1.f387a     // Catch:{ Exception -> 0x06d3 }
            com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$s r8 = new com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$s     // Catch:{ Exception -> 0x06d3 }
            r8.<init>()     // Catch:{ Exception -> 0x06d3 }
            r5.setOnClickListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.TextView r5 = r1.f474h     // Catch:{ Exception -> 0x06d3 }
            com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$t r8 = new com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$t     // Catch:{ Exception -> 0x06d3 }
            r8.<init>()     // Catch:{ Exception -> 0x06d3 }
            r5.setOnClickListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Button r5 = r1.f413b     // Catch:{ Exception -> 0x06d3 }
            com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$u r8 = new com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$u     // Catch:{ Exception -> 0x06d3 }
            r8.<init>()     // Catch:{ Exception -> 0x06d3 }
            r5.setOnClickListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Spinner r5 = r1.f468g     // Catch:{ Exception -> 0x06d3 }
            com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$v r8 = new com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$v     // Catch:{ Exception -> 0x06d3 }
            r8.<init>()     // Catch:{ Exception -> 0x06d3 }
            r5.setOnItemSelectedListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Spinner r5 = r1.f432c     // Catch:{ Exception -> 0x06d3 }
            com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$w r8 = new com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$w     // Catch:{ Exception -> 0x06d3 }
            r8.<init>()     // Catch:{ Exception -> 0x06d3 }
            r5.setOnItemSelectedListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Spinner r5 = r1.f452e     // Catch:{ Exception -> 0x06d3 }
            com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$x r8 = new com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$x     // Catch:{ Exception -> 0x06d3 }
            r8.<init>()     // Catch:{ Exception -> 0x06d3 }
            r5.setOnItemSelectedListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.TextView r5 = r1.f490m     // Catch:{ Exception -> 0x06d3 }
            q1 r8 = new q1     // Catch:{ Exception -> 0x06d3 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x06d3 }
            r5.setOnClickListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.ImageView r5 = r1.f416b     // Catch:{ Exception -> 0x06d3 }
            com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$y r8 = new com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$y     // Catch:{ Exception -> 0x06d3 }
            r8.<init>()     // Catch:{ Exception -> 0x06d3 }
            r5.setOnClickListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.TextView r5 = r1.f484k     // Catch:{ Exception -> 0x06d3 }
            com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$a r8 = new com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$a     // Catch:{ Exception -> 0x06d3 }
            r8.<init>()     // Catch:{ Exception -> 0x06d3 }
            r5.setOnClickListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.TextView r5 = r1.f487l     // Catch:{ Exception -> 0x06d3 }
            com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$b r8 = new com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$b     // Catch:{ Exception -> 0x06d3 }
            r8.<init>()     // Catch:{ Exception -> 0x06d3 }
            r5.setOnClickListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Button r5 = r1.f426c     // Catch:{ Exception -> 0x06d3 }
            b1 r8 = new b1     // Catch:{ Exception -> 0x06d3 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x06d3 }
            r5.setOnClickListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.RadioButton r5 = r1.f385a     // Catch:{ Exception -> 0x06d3 }
            l1 r8 = new l1     // Catch:{ Exception -> 0x06d3 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x06d3 }
            r5.setOnClickListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.RadioButton r5 = r1.f418b     // Catch:{ Exception -> 0x06d3 }
            p1 r8 = new p1     // Catch:{ Exception -> 0x06d3 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x06d3 }
            r5.setOnClickListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.RadioButton r5 = r1.f431c     // Catch:{ Exception -> 0x06d3 }
            o1 r8 = new o1     // Catch:{ Exception -> 0x06d3 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x06d3 }
            r5.setOnClickListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.RadioButton r5 = r1.f442d     // Catch:{ Exception -> 0x06d3 }
            w0 r8 = new w0     // Catch:{ Exception -> 0x06d3 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x06d3 }
            r5.setOnClickListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.RadioButton r5 = r1.f451e     // Catch:{ Exception -> 0x06d3 }
            r1 r8 = new r1     // Catch:{ Exception -> 0x06d3 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x06d3 }
            r5.setOnClickListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.ImageView r5 = r1.f429c     // Catch:{ Exception -> 0x06d3 }
            u0 r8 = new u0     // Catch:{ Exception -> 0x06d3 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x06d3 }
            r5.setOnClickListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.CheckBox r5 = r1.f471h     // Catch:{ Exception -> 0x06d3 }
            n1 r8 = new n1     // Catch:{ Exception -> 0x06d3 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x06d3 }
            r5.setOnClickListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Button r5 = r1.f447e     // Catch:{ Exception -> 0x06d3 }
            f1 r8 = new f1     // Catch:{ Exception -> 0x06d3 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x06d3 }
            r5.setOnClickListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.CheckBox r5 = r1.f427c     // Catch:{ Exception -> 0x06d3 }
            y0 r8 = new y0     // Catch:{ Exception -> 0x06d3 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x06d3 }
            r5.setOnClickListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.CheckBox r5 = r1.f439d     // Catch:{ Exception -> 0x06d3 }
            c1 r8 = new c1     // Catch:{ Exception -> 0x06d3 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x06d3 }
            r5.setOnClickListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.CheckBox r5 = r1.f448e     // Catch:{ Exception -> 0x06d3 }
            z0 r8 = new z0     // Catch:{ Exception -> 0x06d3 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x06d3 }
            r5.setOnClickListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.CheckBox r5 = r1.f414b     // Catch:{ Exception -> 0x06d3 }
            x0 r8 = new x0     // Catch:{ Exception -> 0x06d3 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x06d3 }
            r5.setOnClickListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.CheckBox r5 = r1.f456f     // Catch:{ Exception -> 0x06d3 }
            k1 r8 = new k1     // Catch:{ Exception -> 0x06d3 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x06d3 }
            r5.setOnClickListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.RadioButton r5 = r1.f459f     // Catch:{ Exception -> 0x06d3 }
            m1 r8 = new m1     // Catch:{ Exception -> 0x06d3 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x06d3 }
            r5.setOnClickListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.RadioButton r5 = r1.f467g     // Catch:{ Exception -> 0x06d3 }
            v0 r8 = new v0     // Catch:{ Exception -> 0x06d3 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x06d3 }
            r5.setOnClickListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Button r5 = r1.f438d     // Catch:{ Exception -> 0x06d3 }
            com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$c r8 = new com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$c     // Catch:{ Exception -> 0x06d3 }
            r8.<init>()     // Catch:{ Exception -> 0x06d3 }
            r5.setOnClickListener(r8)     // Catch:{ Exception -> 0x06d3 }
            android.widget.Spinner r5 = r1.f460f     // Catch:{ Exception -> 0x06d3 }
            com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$d r8 = new com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity$d     // Catch:{ Exception -> 0x06d3 }
            r8.<init>()     // Catch:{ Exception -> 0x06d3 }
            r5.setOnItemSelectedListener(r8)     // Catch:{ Exception -> 0x06d3 }
            r16.i0()     // Catch:{ Exception -> 0x06d3 }
            goto L_0x06f2
        L_0x06d3:
            r0 = move-exception
            r2 = r0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r2.toString()
            r3.append(r4)
            java.lang.String r4 = " حدثت مشكله "
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r4 = 1
            android.widget.Toast r3 = android.widget.Toast.makeText(r1, r3, r4)
            r3.show()
        L_0x06f2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity.onCreate(android.os.Bundle):void");
    }

    class k implements AdapterView.OnItemSelectedListener {
        k() {
        }

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SalesPointModel salesPointModel = (SalesPointModel) parent.getSelectedItem();
            if (salesPointModel.getId() != 0) {
                AddHostpotActivity.this.f = salesPointModel.getId();
                AddHostpotActivity.this.f491m = salesPointModel.getName();
                Context context = AddHostpotActivity.this.f375a;
                Toast.makeText(context, "تم تحديد النقطة: " + salesPointModel.getName(), 0).show();
                return;
            }
            AddHostpotActivity.this.f491m = "....";
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u0(View v2) {
        this.f408a.a();
        try {
            this.f455e = true;
        } catch (Exception e2) {
            e2.printStackTrace();
            Context context = this.f375a;
            Toast.makeText(context, e2.getMessage() + " ddd", 0).show();
        }
    }

    class l implements View.OnClickListener {
        l() {
        }

        public void onClick(View v) {
            String code = AddHostpotActivity.this.f381a.getText().toString();
            String codetime_limit = AddHostpotActivity.this.f449e.getText().toString().trim();
            String minute_time_limit = AddHostpotActivity.this.f486l.getText().toString().trim();
            String day_limitcode = AddHostpotActivity.this.f457f.getText().toString().trim();
            String trans_limitcode = AddHostpotActivity.this.f465g.getText().toString().trim();
            String pricecode = AddHostpotActivity.this.f476i.getText().toString().trim();
            if (TextUtils.isEmpty(code)) {
                AddHostpotActivity.this.f381a.setError("الرجاء تعبئة الحقل");
            } else if (TextUtils.isEmpty(codetime_limit) && TextUtils.isEmpty(minute_time_limit)) {
                AddHostpotActivity.this.f449e.setError("الرجاء تعبئة حقل الوقت");
            } else if (TextUtils.isEmpty(day_limitcode)) {
                AddHostpotActivity.this.f457f.setError("الرجاء تعبئة حقل الصلاحية");
            } else if (TextUtils.isEmpty(trans_limitcode) && !AddHostpotActivity.this.f468g.getSelectedItem().toString().equals("غير محدود")) {
                AddHostpotActivity.this.f465g.setError("الرجاء تعبئة حقل التحميل");
            } else if (TextUtils.isEmpty(pricecode)) {
                AddHostpotActivity.this.f476i.setError("الرجاء تعبئة حقل السعر");
            } else if (AddHostpotActivity.this.f404a.size() > 0) {
                new AlertDialog.Builder(AddHostpotActivity.this.f375a, R.style.CustomAlertDialog).setIcon(17301543).setTitle("تنبية !").setMessage("هل تريد إعادة توليد الكروت؟").setPositiveButton("نعم", new a()).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
            } else {
                AddHostpotActivity.this.f388a.stopScroll();
                AddHostpotActivity addHostpotActivity = AddHostpotActivity.this;
                addHostpotActivity.f373a = Integer.parseInt(addHostpotActivity.f381a.getText().toString());
                AddHostpotActivity.this.f404a.clear();
                boolean unused = AddHostpotActivity.this.f455e = false;
                AddHostpotActivity.this.f398a = new g0();
                AddHostpotActivity.this.f398a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            }
        }

        class a implements DialogInterface.OnClickListener {
            a() {
            }

            public void onClick(DialogInterface dialog, int which) {
                AddHostpotActivity.this.f388a.stopScroll();
                AddHostpotActivity addHostpotActivity = AddHostpotActivity.this;
                addHostpotActivity.f373a = Integer.parseInt(addHostpotActivity.f381a.getText().toString());
                AddHostpotActivity.this.f404a.clear();
                boolean unused = AddHostpotActivity.this.f455e = false;
                AddHostpotActivity.this.f398a = new g0();
                AddHostpotActivity.this.f398a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            }
        }
    }

    class s implements View.OnClickListener {
        s() {
        }

        public void onClick(View v) {
            AddHostpotActivity.this.W0();
        }
    }

    class t implements View.OnClickListener {
        t() {
        }

        public void onClick(View v) {
            try {
                new AlertDialog.Builder(AddHostpotActivity.this.f375a, R.style.CustomAlertDialog).setIcon(17301543).setTitle("تنبية !").setMessage("هل تريد حذف القالب المحدد؟").setPositiveButton("نعم", new a()).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
            } catch (Exception e) {
            }
        }

        class a implements DialogInterface.OnClickListener {
            a() {
            }

            public void onClick(DialogInterface dialog, int which) {
                if (AddHostpotActivity.this.f460f.getSelectedItem().toString().equals("تحديد باقة محفوظة") || AddHostpotActivity.this.f460f.getSelectedItem().toString().equals("لا يوجد باقات محفوظة")) {
                    Toast.makeText(AddHostpotActivity.this.f375a, "الرجاء تحديد القالب قبل الحذف", 0).show();
                    return;
                }
                AddHostpotActivity addHostpotActivity = AddHostpotActivity.this;
                if (addHostpotActivity.f406a.d0(addHostpotActivity.f460f.getSelectedItem().toString())) {
                    Toast.makeText(AddHostpotActivity.this.f375a, "تم الحذف", 0).show();
                    AddHostpotActivity.this.i0();
                    return;
                }
                Toast.makeText(AddHostpotActivity.this.f375a, "حدثت مشكله عند الحذف", 0).show();
            }
        }
    }

    class u implements View.OnClickListener {
        u() {
        }

        public void onClick(View v) {
            if (AddHostpotActivity.this.f404a.size() <= 0) {
                Toast.makeText(AddHostpotActivity.this.getApplicationContext(), "توليد الكروت اولا", 0).show();
            } else if (AddHostpotActivity.this.f448e.isChecked()) {
                AddHostpotActivity addHostpotActivity = AddHostpotActivity.this;
                if (addHostpotActivity.f != 0) {
                    new AlertDialog.Builder(AddHostpotActivity.this.f375a, R.style.CustomAlertDialog).setIcon(17301543).setTitle("تنبية !").setMessage("هل تريد اضافة الكروت التي تم توليدها الى السيرفر").setPositiveButton("نعم", new a()).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
                } else {
                    Toast.makeText(addHostpotActivity.getApplicationContext(), "اختر نقطة البيع اولا او قم بإلغاء خيار نقطة البيع", 0).show();
                }
            } else {
                new AlertDialog.Builder(AddHostpotActivity.this, R.style.CustomAlertDialog).setIcon(17301543).setTitle("تنبية !").setMessage("هل تريد اضافة الكروت التي تم توليدها الى السيرفر").setPositiveButton("نعم", new c(this)).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
            }
        }

        class a implements DialogInterface.OnClickListener {
            a() {
            }

            public void onClick(DialogInterface dialog, int which) {
                boolean unused = AddHostpotActivity.this.f455e = false;
                AddHostpotActivity.this.f393a = new b0();
                AddHostpotActivity.this.f393a.execute(new String[0]);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(DialogInterface dialog, int which) {
            boolean unused = AddHostpotActivity.this.f455e = false;
            AddHostpotActivity.this.f393a = new b0();
            AddHostpotActivity.this.f393a.execute(new String[0]);
        }
    }

    class v implements AdapterView.OnItemSelectedListener {
        v() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            if (adapterView.getItemAtPosition(position).toString().equals("غير محدود")) {
                AddHostpotActivity.this.f465g.getText().clear();
                AddHostpotActivity.this.f465g.setEnabled(false);
                return;
            }
            AddHostpotActivity.this.f465g.setEnabled(true);
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class w implements AdapterView.OnItemSelectedListener {
        w() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            AddHostpotActivity.this.m0(adapterView.getItemAtPosition(position).toString());
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class x implements AdapterView.OnItemSelectedListener {
        x() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            AddHostpotActivity.this.n0(adapterView.getItemAtPosition(position).toString());
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v0(View v2) {
        Z0();
    }

    class y implements View.OnClickListener {
        y() {
        }

        public void onClick(View v) {
            AddHostpotActivity addHostpotActivity = AddHostpotActivity.this;
            int i = addHostpotActivity.d;
            if (i >= 8) {
                addHostpotActivity.d = i - 1;
                TextView textView = addHostpotActivity.f433c;
                textView.setTextSize(0, textView.getTextSize() - 2.0f);
                TextView textView2 = AddHostpotActivity.this.f444d;
                textView2.setTextSize(0, textView2.getTextSize() - 2.0f);
                TextView textView3 = AddHostpotActivity.this.f453e;
                textView3.setTextSize(0, textView3.getTextSize() - 1.0f);
                AddHostpotActivity addHostpotActivity2 = AddHostpotActivity.this;
                addHostpotActivity2.f469g.setText(String.valueOf(addHostpotActivity2.d));
            }
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View v) {
            AddHostpotActivity.this.s0();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View v) {
            AddHostpotActivity addHostpotActivity = AddHostpotActivity.this;
            if (addHostpotActivity.f409a) {
                addHostpotActivity.slideDown(addHostpotActivity.f383a);
                AddHostpotActivity.this.f487l.setText("اعدادات الطباعة");
            } else {
                addHostpotActivity.slideUp(addHostpotActivity.f383a);
                AddHostpotActivity.this.f487l.setText("اخفاء اعدادات الطباعة");
            }
            AddHostpotActivity addHostpotActivity2 = AddHostpotActivity.this;
            addHostpotActivity2.f409a = !addHostpotActivity2.f409a;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E0(View v2) {
        try {
            if (!e0()) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                int aa = 0;
                for (int i2 = 0; i2 < this.f404a.size(); i2++) {
                    if (this.f404a.get(i2).getStatus().equals("yes")) {
                        aa++;
                    }
                }
                if (aa <= 0) {
                    Toast.makeText(this.f375a, "الرجاء اضافة الكروت اولا", 0).show();
                } else if (!this.f454e.isEmpty()) {
                    Uri contentUri = MediaStore.Files.getContentUri("external");
                    this.f411b = contentUri;
                    h0(contentUri);
                } else {
                    Toast.makeText(getApplicationContext(), "الرجاء تحديد الصوره", 0).show();
                }
            } else if (!this.f454e.isEmpty()) {
                e0 e0Var = new e0();
                this.f396a = e0Var;
                e0Var.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            } else {
                Toast.makeText(getApplicationContext(), "الرجاء تحديد الصوره", 0).show();
            }
        } catch (Exception e2) {
            Toast.makeText(this.f375a, e2.getMessage(), 0).show();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F0(View v2) {
        this.f385a.setChecked(true);
        this.f418b.setChecked(false);
        this.f431c.setChecked(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G0(View v2) {
        this.f418b.setChecked(true);
        this.f385a.setChecked(false);
        this.f431c.setChecked(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H0(View v2) {
        this.f431c.setChecked(true);
        this.f418b.setChecked(false);
        this.f385a.setChecked(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I0(View v2) {
        this.f442d.setChecked(true);
        this.f380a.setEnabled(false);
        this.f380a.setChecked(false);
        this.f451e.setChecked(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J0(View v2) {
        this.f451e.setChecked(true);
        this.f380a.setEnabled(true);
        this.f442d.setChecked(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K0(View v2) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L0(View v2) {
        if (this.f404a.size() > 0) {
            if (this.f471h.isChecked()) {
                Iterator<AddUserHotspot> it = this.f404a.iterator();
                while (it.hasNext()) {
                    it.next().setSelected(true);
                }
            } else {
                Iterator<AddUserHotspot> it2 = this.f404a.iterator();
                while (it2.hasNext()) {
                    it2.next().setSelected(false);
                }
            }
            this.f389a.notifyDataSetChanged();
            return;
        }
        Snackbar.k0(v2, "لا توجد سجلات للتحديد", 0).V();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w0(View v2) {
        if (this.f471h.isChecked()) {
            this.f404a.clear();
            this.f389a.notifyDataSetChanged();
            this.f471h.setChecked(false);
            return;
        }
        Snackbar.k0(v2, "الرجاء الضغط فوق زر تحديد الكل ثم قم بالضغط على حذف الكل", 0).V();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x0(View v2) {
        if (this.f427c.isChecked()) {
            this.f433c.setVisibility(0);
        } else {
            this.f433c.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y0(View v2) {
        if (this.f439d.isChecked()) {
            this.f444d.setVisibility(0);
        } else {
            this.f444d.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z0(View v2) {
        if (this.f448e.isChecked()) {
            this.f430c.setVisibility(0);
            this.f453e.setVisibility(0);
            return;
        }
        this.f430c.setVisibility(8);
        this.f453e.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A0(View v2) {
        if (this.f414b.isChecked()) {
            this.f386a.setVisibility(0);
        } else {
            this.f386a.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B0(View v2) {
        if (this.f456f.isChecked()) {
            this.f449e.setEnabled(false);
            this.f486l.setEnabled(false);
            this.f457f.setEnabled(false);
            this.f449e.setText("720");
            this.f457f.setText("30");
            return;
        }
        this.f449e.setEnabled(true);
        this.f486l.setEnabled(true);
        this.f457f.setEnabled(true);
        this.f449e.getText().clear();
        this.f457f.getText().clear();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C0(View v2) {
        this.f459f.setChecked(true);
        this.f467g.setChecked(false);
        this.f441d.setVisibility(0);
        this.f466g.setVisibility(0);
        this.f458f.setVisibility(0);
        this.f380a.setVisibility(0);
        this.f487l.setVisibility(0);
        this.f381a.setEnabled(true);
        this.f450e.setVisibility(8);
        this.f417b.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D0(View v2) {
        this.f467g.setChecked(true);
        this.f459f.setChecked(false);
        this.f417b.setVisibility(0);
        this.f450e.setVisibility(0);
        this.f381a.setEnabled(false);
        this.f458f.setVisibility(8);
        this.f441d.setVisibility(8);
        this.f466g.setVisibility(8);
        this.f380a.setVisibility(8);
        this.f487l.setVisibility(8);
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View v) {
            String codetime_limit = AddHostpotActivity.this.f449e.getText().toString().trim();
            String minute_time_limit = AddHostpotActivity.this.f486l.getText().toString().trim();
            String day_limitcode = AddHostpotActivity.this.f457f.getText().toString().trim();
            String trans_limitcode = AddHostpotActivity.this.f465g.getText().toString().trim();
            String pricecode = AddHostpotActivity.this.f476i.getText().toString().trim();
            String username = AddHostpotActivity.this.f480j.getText().toString().trim();
            if (AddHostpotActivity.this.f464g.isChecked()) {
                if (TextUtils.isEmpty(trans_limitcode) && !AddHostpotActivity.this.f468g.getSelectedItem().toString().equals("غير محدود")) {
                    AddHostpotActivity.this.f465g.setError("الرجاء تعبئة حقل التحميل");
                } else if (TextUtils.isEmpty(pricecode)) {
                    AddHostpotActivity.this.f476i.setError("الرجاء تعبئة حقل السعر");
                } else if (TextUtils.isEmpty(username)) {
                    AddHostpotActivity.this.f480j.setError("الرجاء كتابة اسم المستخدم على الاقل");
                } else {
                    new AlertDialog.Builder(AddHostpotActivity.this, R.style.CustomAlertDialog).setIcon(17301543).setTitle("تنبية !").setMessage("هل تريد اضافة الكرت الى السيرفر").setPositiveButton("نعم", new a(this)).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
                }
            } else if (TextUtils.isEmpty(codetime_limit) && TextUtils.isEmpty(minute_time_limit)) {
                AddHostpotActivity.this.f449e.setError("الرجاء تعبئة حقل الوقت");
            } else if (TextUtils.isEmpty(day_limitcode)) {
                AddHostpotActivity.this.f457f.setError("الرجاء تعبئة حقل الصلاحية");
            } else if (TextUtils.isEmpty(trans_limitcode) && !AddHostpotActivity.this.f468g.getSelectedItem().toString().equals("غير محدود")) {
                AddHostpotActivity.this.f465g.setError("الرجاء تعبئة حقل التحميل");
            } else if (TextUtils.isEmpty(pricecode)) {
                AddHostpotActivity.this.f476i.setError("الرجاء تعبئة حقل السعر");
            } else if (TextUtils.isEmpty(username)) {
                AddHostpotActivity.this.f480j.setError("الرجاء كتابة اسم المستخدم على الاقل");
            } else {
                new AlertDialog.Builder(AddHostpotActivity.this, R.style.CustomAlertDialog).setIcon(17301543).setTitle("تنبية !").setMessage("هل تريد اضافة الكرت الى السيرفر").setPositiveButton("نعم", new b(this)).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(DialogInterface dialog, int which) {
            AddHostpotActivity.this.f394a = new c0();
            AddHostpotActivity.this.f394a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(DialogInterface dialog, int which) {
            AddHostpotActivity.this.f394a = new c0();
            AddHostpotActivity.this.f394a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        }
    }

    class d implements AdapterView.OnItemSelectedListener {
        d() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            Object item = adapterView.getItemAtPosition(position);
            try {
                if (!item.toString().equals("تحديد باقة محفوظة") && !item.toString().equals("لا يوجد باقات محفوظة")) {
                    AddHostpotActivity.this.r0(item.toString());
                }
            } catch (Exception e) {
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        try {
            b0 b0Var = this.f393a;
            if (b0Var != null) {
                b0Var.cancel(true);
            }
            c0 c0Var = this.f394a;
            if (c0Var != null) {
                c0Var.cancel(true);
            }
            g0 g0Var = this.f398a;
            if (g0Var != null) {
                g0Var.cancel(true);
            }
            f0 f0Var = this.f397a;
            if (f0Var != null) {
                f0Var.cancel(true);
            }
            e0 e0Var = this.f396a;
            if (e0Var != null) {
                e0Var.cancel(true);
            }
            d0 d0Var = this.f395a;
            if (d0Var != null) {
                d0Var.cancel(true);
            }
            a0 a0Var = this.f392a;
            if (a0Var != null) {
                a0Var.cancel(true);
            }
            z zVar = this.f399a;
            if (zVar != null) {
                zVar.cancel(true);
            }
        } catch (Exception e2) {
        }
    }

    public void Y0(int sw) {
        if (sw <= 480) {
            this.f433c.setTextSize(27.0f);
            this.f444d.setTextSize(27.0f);
            this.f453e.setTextSize(25.0f);
            this.f461f.setTextSize(25.0f);
        }
        if (sw > 480 && sw <= 768) {
            this.f433c.setTextSize(25.0f);
            this.f444d.setTextSize(25.0f);
            this.f453e.setTextSize(23.0f);
            this.f461f.setTextSize(23.0f);
        }
        if (sw > 768 && sw <= 1080) {
            this.f433c.setTextSize(19.5f);
            this.f444d.setTextSize(19.5f);
            this.f453e.setTextSize(17.5f);
            this.f461f.setTextSize(17.5f);
        } else if (sw >= 1200) {
            this.f433c.setTextSize(18.6f);
            this.f444d.setTextSize(18.6f);
            this.f453e.setTextSize(16.6f);
            this.f461f.setTextSize(16.6f);
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(jv0.b(newBase));
    }

    class e implements View.OnTouchListener {
        e() {
        }

        public boolean onTouch(View view, MotionEvent event) {
            int minw = AddHostpotActivity.this.f444d.getWidth() / 2;
            int ww = AddHostpotActivity.this.f377a.getWidth() - AddHostpotActivity.this.f444d.getWidth();
            int x = (int) event.getRawX();
            int y = (int) event.getRawY();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            switch (event.getAction() & 255) {
                case 0:
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    AddHostpotActivity.this.f391a.setVerticalScrollBarEnabled(false);
                    AddHostpotActivity.this.f391a.setHorizontalScrollBarEnabled(false);
                    AddHostpotActivity.this.f390a.setVerticalScrollBarEnabled(false);
                    AddHostpotActivity.this.f390a.setHorizontalScrollBarEnabled(false);
                    int unused = AddHostpotActivity.this.b = x - lParams.leftMargin;
                    int unused2 = AddHostpotActivity.this.c = y - lParams.topMargin;
                    break;
                case 1:
                    AddHostpotActivity.this.f391a.setScrolling(true);
                    AddHostpotActivity.this.f390a.setScrolling(true);
                    AddHostpotActivity addHostpotActivity = AddHostpotActivity.this;
                    addHostpotActivity.f462f = String.valueOf((minw + ww) - (x - addHostpotActivity.b));
                    AddHostpotActivity addHostpotActivity2 = AddHostpotActivity.this;
                    addHostpotActivity2.f470g = String.valueOf(y - addHostpotActivity2.c);
                    break;
                case 2:
                    AddHostpotActivity.this.f391a.setScrolling(false);
                    AddHostpotActivity.this.f390a.setScrolling(false);
                    layoutParams.leftMargin = x - AddHostpotActivity.this.b;
                    layoutParams.topMargin = y - AddHostpotActivity.this.c;
                    layoutParams.rightMargin = 0;
                    layoutParams.bottomMargin = 0;
                    AddHostpotActivity addHostpotActivity3 = AddHostpotActivity.this;
                    addHostpotActivity3.j = x - addHostpotActivity3.b;
                    AddHostpotActivity addHostpotActivity4 = AddHostpotActivity.this;
                    addHostpotActivity4.k = y - addHostpotActivity4.c;
                    AddHostpotActivity addHostpotActivity5 = AddHostpotActivity.this;
                    addHostpotActivity5.f462f = String.valueOf((minw + ww) - (x - addHostpotActivity5.b));
                    AddHostpotActivity addHostpotActivity6 = AddHostpotActivity.this;
                    addHostpotActivity6.f470g = String.valueOf(y - addHostpotActivity6.c);
                    view.setLayoutParams(layoutParams);
                    break;
                case 8:
                    layoutParams.leftMargin = x - AddHostpotActivity.this.b;
                    layoutParams.topMargin = y - AddHostpotActivity.this.c;
                    break;
            }
            AddHostpotActivity.this.f377a.invalidate();
            return true;
        }
    }

    private View.OnTouchListener T0() {
        return new e();
    }

    class f implements View.OnTouchListener {
        f() {
        }

        public boolean onTouch(View view, MotionEvent event) {
            int minw = AddHostpotActivity.this.f453e.getWidth() / 2;
            int ww = AddHostpotActivity.this.f377a.getWidth() - AddHostpotActivity.this.f453e.getWidth();
            int x = (int) event.getRawX();
            int y = (int) event.getRawY();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            switch (event.getAction() & 255) {
                case 0:
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    AddHostpotActivity.this.f391a.setVerticalScrollBarEnabled(false);
                    AddHostpotActivity.this.f391a.setHorizontalScrollBarEnabled(false);
                    AddHostpotActivity.this.f390a.setVerticalScrollBarEnabled(false);
                    AddHostpotActivity.this.f390a.setHorizontalScrollBarEnabled(false);
                    int unused = AddHostpotActivity.this.b = x - lParams.leftMargin;
                    int unused2 = AddHostpotActivity.this.c = y - lParams.topMargin;
                    break;
                case 1:
                    AddHostpotActivity.this.f391a.setScrolling(true);
                    AddHostpotActivity.this.f390a.setScrolling(true);
                    AddHostpotActivity addHostpotActivity = AddHostpotActivity.this;
                    addHostpotActivity.f475h = String.valueOf((minw + ww) - (x - addHostpotActivity.b));
                    AddHostpotActivity addHostpotActivity2 = AddHostpotActivity.this;
                    addHostpotActivity2.f479i = String.valueOf(y - addHostpotActivity2.c);
                    break;
                case 2:
                    AddHostpotActivity.this.f391a.setScrolling(false);
                    AddHostpotActivity.this.f390a.setScrolling(false);
                    layoutParams.leftMargin = x - AddHostpotActivity.this.b;
                    layoutParams.topMargin = y - AddHostpotActivity.this.c;
                    layoutParams.rightMargin = 0;
                    layoutParams.bottomMargin = 0;
                    AddHostpotActivity addHostpotActivity3 = AddHostpotActivity.this;
                    addHostpotActivity3.l = x - addHostpotActivity3.b;
                    AddHostpotActivity addHostpotActivity4 = AddHostpotActivity.this;
                    addHostpotActivity4.m = y - addHostpotActivity4.c;
                    AddHostpotActivity addHostpotActivity5 = AddHostpotActivity.this;
                    addHostpotActivity5.f475h = String.valueOf((minw + ww) - (x - addHostpotActivity5.b));
                    AddHostpotActivity addHostpotActivity6 = AddHostpotActivity.this;
                    addHostpotActivity6.f479i = String.valueOf(y - addHostpotActivity6.c);
                    view.setLayoutParams(layoutParams);
                    break;
                case 8:
                    layoutParams.leftMargin = x - AddHostpotActivity.this.b;
                    layoutParams.topMargin = y - AddHostpotActivity.this.c;
                    break;
            }
            AddHostpotActivity.this.f377a.invalidate();
            return true;
        }
    }

    private View.OnTouchListener U0() {
        return new f();
    }

    class g implements View.OnTouchListener {
        g() {
        }

        public boolean onTouch(View view, MotionEvent event) {
            int minw = AddHostpotActivity.this.f433c.getWidth() / 2;
            int ww = AddHostpotActivity.this.f377a.getWidth() - AddHostpotActivity.this.f433c.getWidth();
            int x = (int) event.getRawX();
            int y = (int) event.getRawY();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            switch (event.getAction() & 255) {
                case 0:
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    AddHostpotActivity.this.f391a.setVerticalScrollBarEnabled(false);
                    AddHostpotActivity.this.f391a.setHorizontalScrollBarEnabled(false);
                    AddHostpotActivity.this.f390a.setVerticalScrollBarEnabled(false);
                    AddHostpotActivity.this.f390a.setHorizontalScrollBarEnabled(false);
                    int unused = AddHostpotActivity.this.b = x - lParams.leftMargin;
                    int unused2 = AddHostpotActivity.this.c = y - lParams.topMargin;
                    break;
                case 1:
                    AddHostpotActivity.this.f391a.setScrolling(true);
                    AddHostpotActivity.this.f390a.setScrolling(true);
                    AddHostpotActivity addHostpotActivity = AddHostpotActivity.this;
                    addHostpotActivity.f489m.setText(String.valueOf((minw + ww) - (x - addHostpotActivity.b)));
                    AddHostpotActivity addHostpotActivity2 = AddHostpotActivity.this;
                    addHostpotActivity2.f492n.setText(String.valueOf(y - addHostpotActivity2.c));
                    break;
                case 2:
                    AddHostpotActivity.this.f391a.setScrolling(false);
                    AddHostpotActivity.this.f390a.setScrolling(false);
                    layoutParams.leftMargin = x - AddHostpotActivity.this.b;
                    layoutParams.topMargin = y - AddHostpotActivity.this.c;
                    layoutParams.rightMargin = 0;
                    layoutParams.bottomMargin = 0;
                    AddHostpotActivity addHostpotActivity3 = AddHostpotActivity.this;
                    addHostpotActivity3.h = x - addHostpotActivity3.b;
                    AddHostpotActivity addHostpotActivity4 = AddHostpotActivity.this;
                    addHostpotActivity4.i = y - addHostpotActivity4.c;
                    AddHostpotActivity addHostpotActivity5 = AddHostpotActivity.this;
                    addHostpotActivity5.f489m.setText(String.valueOf((minw + ww) - (x - addHostpotActivity5.b)));
                    AddHostpotActivity addHostpotActivity6 = AddHostpotActivity.this;
                    addHostpotActivity6.f492n.setText(String.valueOf(y - addHostpotActivity6.c));
                    view.setLayoutParams(layoutParams);
                    break;
                case 8:
                    layoutParams.leftMargin = x - AddHostpotActivity.this.b;
                    layoutParams.topMargin = y - AddHostpotActivity.this.c;
                    break;
            }
            AddHostpotActivity.this.f377a.invalidate();
            return true;
        }
    }

    private View.OnTouchListener S0() {
        return new g();
    }

    public static int k0(int n2) {
        int m2 = (int) Math.pow(10.0d, (double) (n2 - 1));
        return new Random().nextInt(m2 * 9) + m2;
    }

    /* access modifiers changed from: private */
    public static String o0(int sizeOfRandomString) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(sizeOfRandomString);
        for (int i2 = 0; i2 < sizeOfRandomString; i2++) {
            sb.append("0123456789qwertyuiopasdfghjklzxcvbnm".charAt(random.nextInt("0123456789qwertyuiopasdfghjklzxcvbnm".length())));
        }
        return sb.toString();
    }

    public int X0() {
        Point size = new Point();
        WindowManager w2 = getWindowManager();
        if (Build.VERSION.SDK_INT < 11) {
            return w2.getDefaultDisplay().getWidth();
        }
        w2.getDefaultDisplay().getSize(size);
        return size.x;
    }

    class d0 extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f503a = null;
        List<Map<String, String>> b = null;

        d0() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                AddHostpotActivity.this.f401a.J(100000);
                if (!AddHostpotActivity.this.f401a.w()) {
                    return null;
                }
                this.f503a = AddHostpotActivity.this.f401a.q("/ip/hotspot/user/profile/print return name");
                this.b = AddHostpotActivity.this.f401a.q("/ip/hotspot/print return name");
                return null;
            } catch (Exception e) {
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            try {
                List<String> list = new ArrayList<>();
                List<String> list2 = new ArrayList<>();
                if (this.f503a.size() > 0) {
                    for (Map<String, String> res : this.f503a) {
                        Log.d("mLog", res.toString());
                        list.add(res.get("name"));
                    }
                    qb0.f4804a = list;
                    AddHostpotActivity.this.f378a = new ArrayAdapter<>(AddHostpotActivity.this, 17367048, list);
                    AddHostpotActivity.this.f378a.setDropDownViewResource(17367049);
                    AddHostpotActivity addHostpotActivity = AddHostpotActivity.this;
                    addHostpotActivity.f386a.setAdapter(addHostpotActivity.f378a);
                }
                list2.add("all");
                if (this.b.size() > 0) {
                    for (Map<String, String> res2 : this.b) {
                        Log.d("mLog", res2.toString());
                        list2.add(res2.get("name"));
                    }
                    qb0.f4808b = list2;
                    AddHostpotActivity.this.f412b = new ArrayAdapter<>(AddHostpotActivity.this, 17367048, list2);
                    AddHostpotActivity.this.f412b.setDropDownViewResource(17367049);
                    AddHostpotActivity addHostpotActivity2 = AddHostpotActivity.this;
                    addHostpotActivity2.f419b.setAdapter(addHostpotActivity2.f412b);
                }
            } catch (Exception e) {
            }
        }
    }

    class a0 extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f495a = null;
        List<Map<String, String>> b = null;
        List<Map<String, String>> c = null;

        a0() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                AddHostpotActivity.this.f401a.J(100000);
                if (AddHostpotActivity.this.f401a.w()) {
                    this.f495a = AddHostpotActivity.this.f401a.q("/system/scheduler/print where name=ex_dis_new");
                    this.b = AddHostpotActivity.this.f401a.q("/ip/hotspot/user/profile/print where name=mumpro");
                }
                List<Map<String, String>> list = this.f495a;
                if (list == null) {
                    boolean unused = AddHostpotActivity.this.f437c = false;
                    return null;
                } else if (list.size() <= 0) {
                    return null;
                } else {
                    boolean unused2 = AddHostpotActivity.this.f437c = true;
                    return null;
                }
            } catch (Exception e) {
                try {
                    Log.d("mLog", e.toString() + "error");
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            try {
                List<Map<String, String>> list = this.b;
                if (list == null) {
                    boolean unused = AddHostpotActivity.this.f446d = false;
                } else if (list.size() > 0) {
                    boolean unused2 = AddHostpotActivity.this.f446d = true;
                    for (Map<String, String> res : this.b) {
                        Log.d("mLog", res.toString());
                        AddHostpotActivity.this.f422b = res.get(".id");
                    }
                }
            } catch (Exception e) {
                Toast.makeText(AddHostpotActivity.this, "حدثت مشكلة.. تأكد من اتصالك بالشبكة او قد يكون اتصالك ضعيف", 1).show();
            }
        }
    }

    class z extends AsyncTask<String, String, Void> {

        /* renamed from: a  reason: collision with other field name */
        String f515a = "";

        /* renamed from: a  reason: collision with other field name */
        boolean f516a = false;

        z() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(String... params) {
            try {
                if (!AddHostpotActivity.this.f401a.w()) {
                    return null;
                }
                if (!AddHostpotActivity.this.f437c) {
                    AddHostpotActivity.this.f401a.q("/system/scheduler/add interval=12:00:00 name=ex_dis_new on-event=\"/system script run ex_dis_user_new\" policy=ftp,reboot,read,write,policy,test,password,sniff,sensitive,romon start-time=startup");
                }
                if (AddHostpotActivity.this.f446d) {
                    return null;
                }
                AddHostpotActivity.this.f401a.q("/ip/hotspot/user/profile/add name=mumpro on-login='{:local date [ /system clock get date ];:if ( [ /ip hotspot user get $user comment ] = \"\" ) do={[ /ip hotspot user set $user comment=\"mums-$date\" ];}}'");
                return null;
            } catch (Exception e) {
                try {
                    this.f515a = e.getMessage();
                    this.f516a = true;
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.f515a = e2.getMessage();
                    this.f516a = true;
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Void result) {
            super.onPostExecute(result);
        }
    }

    class b0 extends AsyncTask<String, Integer, Void> {

        /* renamed from: a  reason: collision with other field name */
        String f496a = "";

        /* renamed from: a  reason: collision with other field name */
        ArrayList<HotspotCard> f497a = new ArrayList<>();

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f498a = null;

        /* renamed from: a  reason: collision with other field name */
        boolean f499a = false;
        String b = "";
        String c = "";

        b0() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            this.f497a.clear();
            AddHostpotActivity.this.f481j.setText("0%");
            AddHostpotActivity.this.f408a.c("جاري إضافة الكروت الى السيرفر");
            if (AddHostpotActivity.this.f449e.getText().toString().trim().length() > 0) {
                this.f496a = AddHostpotActivity.this.f449e.getText().toString() + ":00:00";
                if (AddHostpotActivity.this.f486l.getText().toString().trim().length() > 0) {
                    this.f496a = AddHostpotActivity.this.f449e.getText().toString() + ":" + AddHostpotActivity.this.f486l.getText().toString().trim() + ":00";
                }
            } else {
                this.f496a = "00:" + AddHostpotActivity.this.f486l.getText().toString().trim() + ":00";
            }
            if (AddHostpotActivity.this.f468g.getSelectedItem().toString().equals("ميجا")) {
                this.b = String.valueOf((long) (Double.parseDouble(AddHostpotActivity.this.f465g.getText().toString()) * 1048576.0d));
            } else if (AddHostpotActivity.this.f468g.getSelectedItem().toString().equals("جيجا")) {
                this.b = String.valueOf((long) (Double.parseDouble(AddHostpotActivity.this.f465g.getText().toString()) * 1.073741824E9d));
            } else {
                this.b = "0";
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(String... params) {
            String pr;
            String pr2;
            String str;
            String pr3;
            int iadd;
            String str2;
            String str3;
            String str4 = ".ptd";
            String str5 = "h";
            String str6 = "ret";
            try {
                AddHostpotActivity.this.f421b = j3.c(qb0.f4797a.getIp(), Integer.valueOf(Integer.parseInt(qb0.f4797a.getPort())));
                try {
                    AddHostpotActivity.this.f421b.C(qb0.f4797a.getUname(), qb0.f4797a.getPass(), true);
                    AddHostpotActivity.this.f421b.J(60000);
                    if (AddHostpotActivity.this.f414b.isChecked()) {
                        pr = AddHostpotActivity.this.f386a.getSelectedItem().toString();
                    } else {
                        pr = "mumpro";
                    }
                    if (AddHostpotActivity.this.f404a.size() > 0) {
                        int iadd2 = 0;
                        while (true) {
                            if (iadd2 >= AddHostpotActivity.this.f404a.size()) {
                                int i = iadd2;
                                break;
                            } else if (AddHostpotActivity.this.f455e) {
                                String str7 = pr;
                                break;
                            } else {
                                if (((AddUserHotspot) AddHostpotActivity.this.f404a.get(iadd2)).getStatus().equals("no")) {
                                    String str8 = str4;
                                    if (AddHostpotActivity.this.f451e.isChecked()) {
                                        j3 j3Var = AddHostpotActivity.this.f421b;
                                        StringBuilder sb = new StringBuilder();
                                        str3 = str5;
                                        str2 = str6;
                                        sb.append(qb0.s.get(0).getAdh());
                                        sb.append(" name=");
                                        sb.append(((AddUserHotspot) AddHostpotActivity.this.f404a.get(iadd2)).getUname());
                                        sb.append(" password=");
                                        sb.append(((AddUserHotspot) AddHostpotActivity.this.f404a.get(iadd2)).getPassword());
                                        sb.append(" profile=\"");
                                        sb.append(pr);
                                        sb.append("\" server=\"");
                                        sb.append(AddHostpotActivity.this.f419b.getSelectedItem().toString());
                                        sb.append("\" email=");
                                        sb.append(AddHostpotActivity.this.f457f.getText().toString());
                                        sb.append("@0_");
                                        sb.append(AddHostpotActivity.this.f476i.getText().toString());
                                        sb.append(".ptd limit-uptime=");
                                        sb.append(this.f496a);
                                        sb.append(" limit-bytes-total=");
                                        sb.append(this.b);
                                        sb.append("");
                                        this.f498a = j3Var.q(sb.toString());
                                        ((AddUserHotspot) AddHostpotActivity.this.f404a.get(iadd2)).setStatus("yes");
                                    } else {
                                        str3 = str5;
                                        str2 = str6;
                                        this.f498a = AddHostpotActivity.this.f421b.q(qb0.s.get(0).getAdh() + " name=" + ((AddUserHotspot) AddHostpotActivity.this.f404a.get(iadd2)).getUname() + " profile=\"" + pr + "\" server=\"" + AddHostpotActivity.this.f419b.getSelectedItem().toString() + "\" email=" + AddHostpotActivity.this.f457f.getText().toString() + "@0_" + AddHostpotActivity.this.f476i.getText().toString() + ".ptd limit-uptime=" + this.f496a + " limit-bytes-total=" + this.b + "");
                                        ((AddUserHotspot) AddHostpotActivity.this.f404a.get(iadd2)).setStatus("yes");
                                    }
                                    ArrayList<HotspotCard> arrayList = qb0.f4834l;
                                    String str9 = str2;
                                    String uname = ((AddUserHotspot) AddHostpotActivity.this.f404a.get(iadd2)).getUname();
                                    String password = ((AddUserHotspot) AddHostpotActivity.this.f404a.get(iadd2)).getPassword();
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(AddHostpotActivity.this.f449e.getText().toString());
                                    String str10 = str3;
                                    sb2.append(str10);
                                    String sb3 = sb2.toString();
                                    String str11 = this.b;
                                    StringBuilder sb4 = new StringBuilder();
                                    String str12 = str11;
                                    sb4.append(AddHostpotActivity.this.f457f.getText().toString());
                                    sb4.append("@0_");
                                    sb4.append(AddHostpotActivity.this.f476i.getText().toString());
                                    String str13 = str8;
                                    sb4.append(str13);
                                    String str14 = str13;
                                    String str15 = pr;
                                    pr2 = pr;
                                    pr3 = str10;
                                    str6 = str9;
                                    iadd = iadd2;
                                    arrayList.add(new HotspotCard((String) this.f498a.get(0).get(str9), uname, password, str15, "0s", sb3, "0", "0", str12, "printed", false, (String) null, sb4.toString(), false));
                                    String str16 = this.b;
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append(AddHostpotActivity.this.f457f.getText().toString());
                                    sb5.append("@0_");
                                    sb5.append(AddHostpotActivity.this.f476i.getText().toString());
                                    String str17 = str14;
                                    sb5.append(str17);
                                    str = str17;
                                    this.f497a.add(new HotspotCard((String) this.f498a.get(0).get(str6), ((AddUserHotspot) AddHostpotActivity.this.f404a.get(iadd)).getUname(), ((AddUserHotspot) AddHostpotActivity.this.f404a.get(iadd)).getPassword(), pr2, "", AddHostpotActivity.this.f449e.getText().toString() + pr3, "0", "0", str16, "printed", false, (String) null, sb5.toString(), false));
                                    publishProgress(new Integer[]{Integer.valueOf((int) ((((float) iadd) / ((float) AddHostpotActivity.this.f404a.size())) * 100.0f))});
                                    qb0.e++;
                                } else {
                                    str = str4;
                                    pr2 = pr;
                                    iadd = iadd2;
                                    pr3 = str5;
                                }
                                iadd2 = iadd + 1;
                                str5 = pr3;
                                str4 = str;
                                pr = pr2;
                            }
                        }
                    }
                    AddHostpotActivity.this.f421b.close();
                    return null;
                } catch (Exception e) {
                    this.c = e.getMessage();
                    this.f499a = true;
                    return null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                this.c = e2.getMessage();
                this.f499a = true;
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void onProgressUpdate(Integer... values) {
            TextView textView = AddHostpotActivity.this.f481j;
            textView.setText(values[0] + "%");
            AddHostpotActivity.this.f389a.notifyDataSetChanged();
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Void result) {
            super.onPostExecute(result);
            AddHostpotActivity.this.f408a.a();
            try {
                if (this.f497a.size() > 0) {
                    new ss(AddHostpotActivity.this.getApplicationContext(), this.f497a, AddHostpotActivity.this.f).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                }
                if (this.f499a) {
                    Toast.makeText(AddHostpotActivity.this.f375a, this.c, 0).show();
                }
                AddHostpotActivity.this.f389a.notifyDataSetChanged();
                qb0.o = AddHostpotActivity.this.f404a;
            } catch (Exception e) {
                AddHostpotActivity addHostpotActivity = AddHostpotActivity.this;
                Toast.makeText(addHostpotActivity, e.getMessage() + "error", 0).show();
            }
        }
    }

    class c0 extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        String f500a = "''";

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f501a = null;

        /* renamed from: a  reason: collision with other field name */
        boolean f502a = false;
        String b = "";
        String c = "";
        String d;
        String e = "";

        c0() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            this.f502a = false;
            if (AddHostpotActivity.this.f483k.getText().toString().trim().length() > 0) {
                Toast.makeText(AddHostpotActivity.this.f375a, "ok", 0).show();
                this.f500a = AddHostpotActivity.this.f483k.getText().toString();
            }
            if (AddHostpotActivity.this.f449e.getText().toString().trim().length() > 0) {
                this.b = AddHostpotActivity.this.f449e.getText().toString() + ":00:00";
                if (AddHostpotActivity.this.f486l.getText().toString().trim().length() > 0) {
                    this.b = AddHostpotActivity.this.f449e.getText().toString() + ":" + AddHostpotActivity.this.f486l.getText().toString().trim() + ":00";
                }
            } else {
                this.b = "00:" + AddHostpotActivity.this.f486l.getText().toString().trim() + ":00";
            }
            if (AddHostpotActivity.this.f468g.getSelectedItem().toString().equals("ميجا")) {
                this.c = String.valueOf((long) (Double.parseDouble(AddHostpotActivity.this.f465g.getText().toString()) * 1048576.0d));
            } else if (AddHostpotActivity.this.f468g.getSelectedItem().toString().equals("جيجا")) {
                this.c = String.valueOf((long) (Double.parseDouble(AddHostpotActivity.this.f465g.getText().toString()) * 1.073741824E9d));
            } else {
                this.c = "0";
            }
            if (AddHostpotActivity.this.f464g.isChecked()) {
                this.b = "0";
                this.d = "0";
            } else {
                this.d = AddHostpotActivity.this.f457f.getText().toString();
            }
            AddHostpotActivity.this.f410b.setTitle("يرجى الانتظار..");
            AddHostpotActivity.this.f410b.setMessage("جاري اضافة الكرت الى السيرفر ...");
            AddHostpotActivity.this.f410b.setCancelable(false);
            AddHostpotActivity.this.f410b.setIndeterminate(false);
            AddHostpotActivity.this.f410b.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            String pr;
            try {
                if (AddHostpotActivity.this.f414b.isChecked()) {
                    pr = AddHostpotActivity.this.f386a.getSelectedItem().toString();
                } else {
                    pr = "mumpro";
                }
                if (!AddHostpotActivity.this.f401a.w()) {
                    return null;
                } else if (!AddHostpotActivity.this.f480j.getText().toString().trim().isEmpty()) {
                    List<Map<String, String>> q = AddHostpotActivity.this.f401a.q(qb0.s.get(0).getAdh() + " name=" + AddHostpotActivity.this.f480j.getText() + " password=" + this.f500a + " profile=\"" + pr + "\" server=\"" + AddHostpotActivity.this.f419b.getSelectedItem().toString() + "\" email=" + this.d + "@0_" + AddHostpotActivity.this.f476i.getText().toString() + ".ptd limit-uptime=" + this.b + " limit-bytes-total=" + this.c + "");
                    this.f501a = q;
                    for (Map<String, String> res : q) {
                        AddHostpotActivity.this.f488l = res.get("ret");
                    }
                    ArrayList<HotspotCard> arrayList = qb0.f4834l;
                    if (arrayList != null) {
                        AddHostpotActivity addHostpotActivity = AddHostpotActivity.this;
                        String str = this.c;
                        StringBuilder sb = new StringBuilder();
                        String str2 = pr;
                        sb.append(AddHostpotActivity.this.f457f.getText().toString());
                        sb.append("@0_");
                        sb.append(AddHostpotActivity.this.f476i.getText().toString());
                        sb.append(".ptd");
                        HotspotCard hotspotCard = r4;
                        HotspotCard hotspotCard2 = new HotspotCard(addHostpotActivity.f488l, addHostpotActivity.f480j.getText().toString(), AddHostpotActivity.this.f483k.getText().toString(), "mumpro", "0s", AddHostpotActivity.this.f449e.getText().toString() + "h", "0", "0", str, "printed", false, (String) null, sb.toString(), false);
                        arrayList.add(hotspotCard);
                        return null;
                    }
                    return null;
                } else {
                    return null;
                }
            } catch (Exception e2) {
                try {
                    this.e = e2.getMessage();
                    this.f502a = true;
                    return null;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    this.e = e3.getMessage();
                    this.f502a = true;
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            AddHostpotActivity.this.f410b.dismiss();
            if (this.f502a) {
                Toast.makeText(AddHostpotActivity.this.f375a, this.e, 1).show();
            } else {
                Toast.makeText(AddHostpotActivity.this, "تمت الإضافة", 1).show();
            }
        }
    }

    public String t0(String bag, String marble, int index) {
        String bagBegin = bag.substring(0, index);
        String bagEnd = bag.substring(index);
        return bagBegin + marble + bagEnd;
    }

    class g0 extends AsyncTask<String, Integer, String> {

        /* renamed from: a  reason: collision with other field name */
        String f508a = "";

        g0() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            AddHostpotActivity.this.f481j.setText("0%");
            AddHostpotActivity.this.f408a.c("جاري توليد كروت هوتسبوت..");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            String pr;
            try {
                Set<String> names = new HashSet<>();
                try {
                    AddHostpotActivity addHostpotActivity = AddHostpotActivity.this;
                    if (addHostpotActivity.r > 0) {
                        for (int j = 0; j < qb0.f4834l.size(); j++) {
                            names.add(qb0.f4834l.get(j).getUname());
                        }
                    } else if (addHostpotActivity.f423b.size() > 4000) {
                        for (int j2 = 0; j2 < AddHostpotActivity.this.f423b.size(); j2++) {
                            names.add(((HotspotCard) AddHostpotActivity.this.f423b.get(j2)).getUname());
                        }
                    }
                    int i = 0;
                    while (true) {
                        AddHostpotActivity addHostpotActivity2 = AddHostpotActivity.this;
                        if (i >= addHostpotActivity2.f373a) {
                            return null;
                        }
                        if (addHostpotActivity2.f455e) {
                            return null;
                        }
                        if (AddHostpotActivity.this.f385a.isChecked()) {
                            this.f508a = AddHostpotActivity.this.f415b.getText().toString().trim() + AddHostpotActivity.k0(Integer.parseInt(AddHostpotActivity.this.f473h.getSelectedItem().toString())) + AddHostpotActivity.this.f428c.getText().toString().trim();
                        } else {
                            this.f508a = AddHostpotActivity.this.f415b.getText().toString().trim() + AddHostpotActivity.o0(Integer.parseInt(AddHostpotActivity.this.f473h.getSelectedItem().toString())) + AddHostpotActivity.this.f428c.getText().toString().trim();
                        }
                        if (AddHostpotActivity.this.f440d.getText().toString().trim().length() > 0) {
                            AddHostpotActivity addHostpotActivity3 = AddHostpotActivity.this;
                            addHostpotActivity3.f434c = addHostpotActivity3.t0(this.f508a, addHostpotActivity3.f440d.getText().toString(), this.f508a.length() / 2);
                        } else {
                            AddHostpotActivity.this.f434c = this.f508a;
                        }
                        if (AddHostpotActivity.this.f380a.isChecked()) {
                            AddHostpotActivity addHostpotActivity4 = AddHostpotActivity.this;
                            addHostpotActivity4.f445d = addHostpotActivity4.f434c;
                        } else if (AddHostpotActivity.this.f451e.isChecked()) {
                            AddHostpotActivity addHostpotActivity5 = AddHostpotActivity.this;
                            addHostpotActivity5.f445d = String.valueOf(AddHostpotActivity.k0(Integer.parseInt(addHostpotActivity5.f477i.getSelectedItem().toString())));
                        } else {
                            AddHostpotActivity.this.f445d = "";
                        }
                        Thread.sleep(3);
                        if (names.contains(AddHostpotActivity.this.f434c)) {
                            i--;
                        } else {
                            if (AddHostpotActivity.this.f414b.isChecked()) {
                                pr = AddHostpotActivity.this.f386a.getSelectedItem().toString();
                            } else {
                                pr = "mumpro";
                            }
                            ArrayList H = AddHostpotActivity.this.f404a;
                            AddHostpotActivity addHostpotActivity6 = AddHostpotActivity.this;
                            H.add(new AddUserHotspot(addHostpotActivity6.f434c, addHostpotActivity6.f445d, pr, "no", false));
                            names.add(AddHostpotActivity.this.f434c);
                        }
                        publishProgress(new Integer[]{Integer.valueOf((int) ((((float) i) / ((float) AddHostpotActivity.this.f373a)) * 100.0f))});
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
            TextView textView = AddHostpotActivity.this.f481j;
            textView.setText(values[0] + "%");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            AddHostpotActivity.this.f408a.a();
            try {
                qb0.o = AddHostpotActivity.this.f404a;
                AddHostpotActivity.this.f389a.notifyDataSetChanged();
                qb0.f4821f = AddHostpotActivity.this.f449e.getText().toString();
                qb0.f4814d = AddHostpotActivity.this.f457f.getText().toString();
                qb0.f4818e = AddHostpotActivity.this.f476i.getText().toString();
                qb0.f4824g = AddHostpotActivity.this.f465g.getText().toString();
                cancel(false);
            } catch (Exception e) {
            }
        }
    }

    class f0 extends AsyncTask<String, Integer, String> {
        int a;

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f507a = null;

        f0() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            AddHostpotActivity.this.f410b.setTitle("يرجى الانتظار..");
            AddHostpotActivity.this.f410b.setMessage("جاري طباعة الكروت الى ملف PDF ...");
            AddHostpotActivity.this.f410b.setCancelable(false);
            AddHostpotActivity.this.f410b.setIndeterminate(false);
            AddHostpotActivity.this.f410b.show();
            AddHostpotActivity addHostpotActivity = AddHostpotActivity.this;
            addHostpotActivity.f463f = false;
            addHostpotActivity.f493n = "no";
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                AddHostpotActivity.this.g = 0;
                String strDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Calendar.getInstance().getTime());
                for (int i = 0; i < AddHostpotActivity.this.f404a.size(); i++) {
                    if (((AddUserHotspot) AddHostpotActivity.this.f404a.get(i)).getStatus().equals("yes")) {
                        this.a++;
                    }
                }
                if (this.a <= 0) {
                    boolean unused = AddHostpotActivity.this.f425b = false;
                    return null;
                } else if (AddHostpotActivity.this.f454e.isEmpty()) {
                    return null;
                } else {
                    if (AddHostpotActivity.this.b1("cards_Hotspot_" + strDate).booleanValue()) {
                        boolean unused2 = AddHostpotActivity.this.f425b = true;
                        return null;
                    }
                    boolean unused3 = AddHostpotActivity.this.f425b = false;
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
            if (AddHostpotActivity.this.f425b) {
                AddHostpotActivity.this.f410b.dismiss();
                Context context = AddHostpotActivity.this.f375a;
                Toast.makeText(context, "تم حفظ الملف بنجاح..عدد الكروت : " + String.valueOf(AddHostpotActivity.this.g), 0).show();
            } else {
                AddHostpotActivity.this.f410b.dismiss();
                AddHostpotActivity addHostpotActivity = AddHostpotActivity.this;
                if (addHostpotActivity.g <= 0) {
                    Context context2 = addHostpotActivity.f375a;
                    Toast.makeText(context2, AddHostpotActivity.this.f493n + "لم يتم الحفظ..قم بإضافة الكروت الى السيرفر قبل الطباعة", 0).show();
                } else {
                    Toast.makeText(addHostpotActivity.f375a, "حدث خطأ اثناء الحفظ", 0).show();
                }
            }
            AddHostpotActivity addHostpotActivity2 = AddHostpotActivity.this;
            if (addHostpotActivity2.f463f) {
                Toast.makeText(addHostpotActivity2.f375a, addHostpotActivity2.f493n, 0).show();
            }
        }
    }

    class e0 extends AsyncTask<String, Integer, String> {
        int a;

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f505a = null;

        e0() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            AddHostpotActivity.this.f410b.setTitle("يرجى الانتظار..");
            AddHostpotActivity.this.f410b.setMessage("جاري طباعة الكروت الى ملف PDF ...");
            AddHostpotActivity.this.f410b.setCancelable(false);
            AddHostpotActivity.this.f410b.setIndeterminate(false);
            AddHostpotActivity.this.f410b.show();
            AddHostpotActivity addHostpotActivity = AddHostpotActivity.this;
            addHostpotActivity.f463f = false;
            addHostpotActivity.f493n = "no";
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                AddHostpotActivity.this.g = 0;
                String strDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Calendar.getInstance().getTime());
                int x = Integer.parseInt(AddHostpotActivity.this.f489m.getText().toString());
                int y = Integer.parseInt(AddHostpotActivity.this.f492n.getText().toString());
                for (int i = 0; i < AddHostpotActivity.this.f404a.size(); i++) {
                    if (((AddUserHotspot) AddHostpotActivity.this.f404a.get(i)).getStatus().equals("yes")) {
                        this.a++;
                    }
                }
                if (this.a <= 0) {
                    boolean unused = AddHostpotActivity.this.f425b = false;
                    return null;
                } else if (AddHostpotActivity.this.f454e.isEmpty()) {
                    return null;
                } else {
                    if (AddHostpotActivity.this.a1("cards_Hotspot_" + strDate, "MUMS_odai_dammag", x, y).booleanValue()) {
                        boolean unused2 = AddHostpotActivity.this.f425b = true;
                        return null;
                    }
                    boolean unused3 = AddHostpotActivity.this.f425b = false;
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
            if (AddHostpotActivity.this.f425b) {
                AddHostpotActivity.this.f410b.dismiss();
                if (Build.VERSION.SDK_INT >= 29) {
                    Context context = AddHostpotActivity.this.f375a;
                    Toast.makeText(context, "تم حفظ الملف بنجاح..عدد الكروت : " + String.valueOf(AddHostpotActivity.this.g) + " المسار الرئيسي للذاكرة ", 0).show();
                } else {
                    Context context2 = AddHostpotActivity.this.f375a;
                    Toast.makeText(context2, "تم حفظ الملف بنجاح..عدد الكروت : " + String.valueOf(AddHostpotActivity.this.g) + " مجلد MUMS_Cards ", 0).show();
                }
            } else {
                AddHostpotActivity.this.f410b.dismiss();
                AddHostpotActivity addHostpotActivity = AddHostpotActivity.this;
                if (addHostpotActivity.g <= 0) {
                    Toast.makeText(addHostpotActivity.f375a, "لم يتم الحفظ..قم بإضافة الكروت الى السيرفر قبل الطباعة", 0).show();
                } else {
                    Toast.makeText(addHostpotActivity.f375a, "حدث خطأ اثناء الحفظ", 0).show();
                }
            }
            AddHostpotActivity addHostpotActivity2 = AddHostpotActivity.this;
            if (addHostpotActivity2.f463f) {
                Toast.makeText(addHostpotActivity2.f375a, addHostpotActivity2.f493n, 0).show();
            }
        }
    }

    public File l0(String albumName) {
        File file = new File(Environment.getExternalStorageDirectory() + albumName);
        if (!file.mkdirs()) {
            Log.e("MUMS_Cards", "Directory not created");
        }
        return file;
    }

    public int q0() {
        int a2 = 0;
        for (int i2 = 0; i2 < this.f404a.size(); i2++) {
            if (this.f404a.get(i2).getStatus().equals("yes")) {
                a2++;
            }
        }
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x034a A[EDGE_INSN: B:109:0x034a->B:85:0x034a ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01da A[Catch:{ IOException -> 0x039f, ih -> 0x038b }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01e0 A[Catch:{ IOException -> 0x039f, ih -> 0x038b }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0219 A[Catch:{ IOException -> 0x039f, ih -> 0x038b }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x035d A[Catch:{ IOException -> 0x0389, ih -> 0x0387 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0366 A[Catch:{ IOException -> 0x0389, ih -> 0x0387 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Boolean a1(java.lang.String r40, java.lang.String r41, int r42, int r43) {
        /*
            r39 = this;
            r15 = r39
            r14 = r40
            r13 = 0
            r10 = 1
            r15.g = r13     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            java.lang.String r0 = r15.f454e     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            boolean r0 = r0.isEmpty()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            if (r0 != 0) goto L_0x0369
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r1 = 29
            java.lang.String r2 = ".pdf"
            if (r0 < r1) goto L_0x003f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r0.<init>()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            java.lang.String r1 = "/storage/emulated/0/"
            r0.append(r1)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r0.append(r14)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r0.append(r2)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r1.<init>(r0)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r15.f402a = r1     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            boolean r1 = r1.exists()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            if (r1 != 0) goto L_0x003e
            java.io.File r1 = r15.f402a     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r1.createNewFile()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
        L_0x003e:
            goto L_0x006a
        L_0x003f:
            java.lang.String r0 = "/MUMS_Cards"
            r15.l0(r0)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r0.<init>()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            java.lang.String r1 = "/storage/emulated/0/MUMS_Cards/"
            r0.append(r1)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r0.append(r14)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r0.append(r2)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r1.<init>(r0)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r15.f402a = r1     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            boolean r1 = r1.exists()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            if (r1 != 0) goto L_0x006a
            java.io.File r1 = r15.f402a     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r1.createNewFile()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
        L_0x006a:
            gh r0 = new gh     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r0.<init>()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r1 = 1073741824(0x40000000, float:2.0)
            r2 = 1082130432(0x40800000, float:4.0)
            r3 = 0
            r7 = 1065353216(0x3f800000, float:1.0)
            r0.a(r7, r1, r2, r3)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            java.io.File r2 = r15.f402a     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            java.io.File r2 = r2.getAbsoluteFile()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r1.<init>(r2)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            v80 r1 = defpackage.v80.e0(r0, r1)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r25 = r1
            r0.open()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            k50 r1 = new k50     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r1.<init>()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r26 = r1
            r1 = 15
            r2 = 30
            android.view.ViewGroup r3 = r15.f377a     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 >= r4) goto L_0x00aa
            r1 = 3
            r2 = 60
            r27 = r1
            r28 = r2
            goto L_0x010d
        L_0x00aa:
            android.view.ViewGroup r3 = r15.f377a     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r4 = 306(0x132, float:4.29E-43)
            if (r3 >= r4) goto L_0x00c7
            android.view.ViewGroup r3 = r15.f377a     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r5 = 250(0xfa, float:3.5E-43)
            if (r3 <= r5) goto L_0x00c7
            r1 = 32
            r2 = 23
            r27 = r1
            r28 = r2
            goto L_0x010d
        L_0x00c7:
            android.view.ViewGroup r3 = r15.f377a     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r5 = 367(0x16f, float:5.14E-43)
            if (r3 <= r4) goto L_0x00e2
            android.view.ViewGroup r3 = r15.f377a     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            if (r3 > r5) goto L_0x00e2
            r1 = 30
            r2 = 23
            r27 = r1
            r28 = r2
            goto L_0x010d
        L_0x00e2:
            android.view.ViewGroup r3 = r15.f377a     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r4 = 394(0x18a, float:5.52E-43)
            if (r3 <= r5) goto L_0x00fd
            android.view.ViewGroup r3 = r15.f377a     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            if (r3 > r4) goto L_0x00fd
            r1 = 29
            r2 = 23
            r27 = r1
            r28 = r2
            goto L_0x010d
        L_0x00fd:
            android.view.ViewGroup r3 = r15.f377a     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            if (r3 <= r4) goto L_0x0109
            r1 = 28
            r2 = 23
        L_0x0109:
            r27 = r1
            r28 = r2
        L_0x010d:
            android.view.ViewGroup r1 = r15.f377a     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r1 = r1.getWidth()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            double r1 = (double) r1     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r3 = 4619792497756654797(0x401ccccccccccccd, double:7.2)
            double r1 = r1 / r3
            int r1 = (int) r1     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r4 = r1 + 1
            android.view.ViewGroup r1 = r15.f377a     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r1 = r1.getHeight()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            double r1 = (double) r1     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r5 = 4619342137793917747(0x401b333333333333, double:6.8)
            double r1 = r1 / r5
            int r1 = (int) r1     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            android.view.ViewGroup r2 = r15.f377a     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r2 = r2.getHeight()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r3 = 460(0x1cc, float:6.45E-43)
            if (r2 != r3) goto L_0x0139
            int r1 = r1 + 2
            r3 = r1
            goto L_0x013a
        L_0x0139:
            r3 = r1
        L_0x013a:
            android.view.ViewGroup r1 = r15.f377a     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r1 = r1.getWidth()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r1 = r1 / r4
            float r1 = (float) r1     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            android.view.ViewGroup r2 = r15.f377a     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r2 = r2.getHeight()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r2 = r2 / r3
            float r2 = (float) r2     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            android.widget.TextView r5 = r15.f433c     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r5 = r5.getHeight()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r6 = (int) r2     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r5 = r5 / r6
            r29 = r5
            android.widget.EditText r5 = r15.f489m     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            android.text.Editable r5 = r5.getText()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r5 = r5 - r28
            int r6 = (int) r1     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r5 = r5 / r6
            android.widget.EditText r6 = r15.f492n     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            android.text.Editable r6 = r6.getText()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r6 = r6 + r27
            int r8 = (int) r2     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r6 = r6 / r8
            java.lang.String r8 = r15.f462f     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r8 = r8 - r28
            int r9 = (int) r1     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r8 = r8 / r9
            java.lang.String r9 = r15.f470g     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r9 = r9 + r27
            int r11 = (int) r2     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r9 = r9 / r11
            java.lang.String r11 = r15.f475h     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r11 = r11 - r28
            int r12 = (int) r1     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r11 = r11 / r12
            java.lang.String r12 = r15.f479i     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r12 = java.lang.Integer.parseInt(r12)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r12 = r12 + r27
            int r7 = (int) r2     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r12 = r12 / r7
            java.lang.String r7 = r15.f454e     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            tr r7 = defpackage.tr.u0(r7)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r17 = 1058642330(0x3f19999a, float:0.6)
            android.view.ViewGroup r13 = r15.f377a     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r13 = r13.getHeight()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r10 = 286(0x11e, float:4.01E-43)
            if (r13 == r10) goto L_0x01cc
            android.view.ViewGroup r10 = r15.f377a     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r10 = r10.getHeight()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r13 = 323(0x143, float:4.53E-43)
            if (r10 == r13) goto L_0x01cc
            android.view.ViewGroup r10 = r15.f377a     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r10 = r10.getHeight()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r13 = 343(0x157, float:4.8E-43)
            if (r10 != r13) goto L_0x01c8
            goto L_0x01cc
        L_0x01c8:
            r10 = 1058642330(0x3f19999a, float:0.6)
            goto L_0x01ce
        L_0x01cc:
            r10 = 1065353216(0x3f800000, float:1.0)
        L_0x01ce:
            android.view.ViewGroup r13 = r15.f377a     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r13 = r13.getHeight()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r17 = r1
            r1 = 271(0x10f, float:3.8E-43)
            if (r13 != r1) goto L_0x01e0
            r10 = 1050253722(0x3e99999a, float:0.3)
            r30 = r10
            goto L_0x01e2
        L_0x01e0:
            r30 = r10
        L_0x01e2:
            float r1 = (float) r4     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            float r10 = (float) r3     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            float r10 = r10 - r30
            r7.Y0(r1, r10)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            d60 r1 = r25.Z()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r31 = r2
            r2 = r1
            r1 = 1
            u70 r10 = new u70     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r13 = r15.p     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r10.<init>((int) r13)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r13 = r10
            r10 = 1120403456(0x42c80000, float:100.0)
            r13.x0(r10)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r10 = r39.q0()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r20 = r1
            int r1 = r15.p     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r1 = r10 % r1
            r32 = r1
            r1 = 0
            r33 = r0
            r0 = r20
        L_0x020f:
            r20 = r3
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot> r3 = r15.f404a     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r3 = r3.size()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            if (r1 >= r3) goto L_0x034a
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot> r3 = r15.f404a     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot r3 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot) r3     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            java.lang.String r3 = r3.getStatus()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r21 = r4
            java.lang.String r4 = "yes"
            boolean r3 = r3.equals(r4)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            if (r3 == 0) goto L_0x0325
            int r3 = r15.g     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r19 = 1
            int r3 = r3 + 1
            r15.g = r3     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            android.widget.CheckBox r3 = r15.f439d     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            boolean r3 = r3.isChecked()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            if (r3 == 0) goto L_0x02af
            q70 r3 = new q70     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot> r4 = r15.f404a     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            java.lang.Object r4 = r4.get(r1)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot r4 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot) r4     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            java.lang.String r4 = r4.getUname()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot> r14 = r15.f404a     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            java.lang.Object r14 = r14.get(r1)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot r14 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot) r14     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            java.lang.String r14 = r14.getPassword()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r24 = r10
            java.lang.String r10 = r15.f491m     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
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
            tr r1 = r1.p0(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r13.<init>((defpackage.tr) r1)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r1 = r13
            if (r32 <= 0) goto L_0x0288
            if (r0 != r14) goto L_0x0286
            int r3 = r15.p     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            int r3 = r3 - r32
            r4 = 1
            int r3 = r3 + r4
            r1.A0(r3)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            goto L_0x0289
        L_0x0286:
            r4 = 1
            goto L_0x0289
        L_0x0288:
            r4 = 1
        L_0x0289:
            r3 = 0
            r1.R(r3)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r7 = 1075838976(0x40200000, float:2.5)
            r1.G0(r7)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r10 = 1065353216(0x3f800000, float:1.0)
            r1.H0(r10)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r13 = 1076468122(0x4029999a, float:2.65)
            r1.F0(r13)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r7 = r17
            r7.e(r1)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r3 = r1
            r1 = r7
            r4 = r14
            r10 = r35
            r7 = 0
            r13 = 1065353216(0x3f800000, float:1.0)
            r35 = r8
            r8 = r15
            goto L_0x031c
        L_0x02af:
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
            q70 r3 = new q70     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot> r7 = r15.f404a     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            r10 = r35
            java.lang.Object r7 = r7.get(r10)     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot r7 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot) r7     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            java.lang.String r16 = r7.getUname()     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
            java.lang.String r19 = ""
            r20 = 0
            r21 = 0
            java.lang.String r7 = r15.f491m     // Catch:{ IOException -> 0x039f, ih -> 0x038b }
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
            tr r7 = r13.p0(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ IOException -> 0x0322, ih -> 0x031f }
            r3.<init>((defpackage.tr) r7)     // Catch:{ IOException -> 0x0322, ih -> 0x031f }
            if (r32 <= 0) goto L_0x0305
            if (r0 != r4) goto L_0x0305
            int r7 = r8.p     // Catch:{ IOException -> 0x0322, ih -> 0x031f }
            int r7 = r7 - r32
            r13 = 1
            int r7 = r7 + r13
            r3.A0(r7)     // Catch:{ IOException -> 0x0322, ih -> 0x031f }
        L_0x0305:
            r7 = 0
            r3.R(r7)     // Catch:{ IOException -> 0x0389, ih -> 0x0387 }
            r13 = 1075838976(0x40200000, float:2.5)
            r3.G0(r13)     // Catch:{ IOException -> 0x0389, ih -> 0x0387 }
            r13 = 1065353216(0x3f800000, float:1.0)
            r3.H0(r13)     // Catch:{ IOException -> 0x0389, ih -> 0x0387 }
            r14 = 1076468122(0x4029999a, float:2.65)
            r3.F0(r14)     // Catch:{ IOException -> 0x0389, ih -> 0x0387 }
            r1.e(r3)     // Catch:{ IOException -> 0x0389, ih -> 0x0387 }
        L_0x031c:
            int r0 = r0 + 1
            goto L_0x0336
        L_0x031f:
            r0 = move-exception
            goto L_0x038d
        L_0x0322:
            r0 = move-exception
            goto L_0x03a1
        L_0x0325:
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
        L_0x0336:
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
            goto L_0x020f
        L_0x034a:
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
            int r3 = r8.g     // Catch:{ IOException -> 0x0389, ih -> 0x0387 }
            if (r3 <= 0) goto L_0x0366
            r3 = r33
            r3.c(r1)     // Catch:{ IOException -> 0x0389, ih -> 0x0387 }
            r3.close()     // Catch:{ IOException -> 0x0389, ih -> 0x0387 }
            goto L_0x0368
        L_0x0366:
            r3 = r33
        L_0x0368:
            goto L_0x0378
        L_0x0369:
            r8 = r15
            r7 = 0
            android.content.Context r0 = r39.getApplicationContext()     // Catch:{ IOException -> 0x0389, ih -> 0x0387 }
            java.lang.String r1 = "الرجاء تحديد الصوره"
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r7)     // Catch:{ IOException -> 0x0389, ih -> 0x0387 }
            r0.show()     // Catch:{ IOException -> 0x0389, ih -> 0x0387 }
        L_0x0378:
            int r0 = r8.g     // Catch:{ IOException -> 0x0389, ih -> 0x0387 }
            if (r0 <= 0) goto L_0x0382
            r1 = 1
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)     // Catch:{ IOException -> 0x0389, ih -> 0x0387 }
            return r0
        L_0x0382:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r7)     // Catch:{ IOException -> 0x0389, ih -> 0x0387 }
            return r0
        L_0x0387:
            r0 = move-exception
            goto L_0x038e
        L_0x0389:
            r0 = move-exception
            goto L_0x03a2
        L_0x038b:
            r0 = move-exception
            r8 = r15
        L_0x038d:
            r7 = 0
        L_0x038e:
            r0.printStackTrace()
            r1 = 1
            r8.f463f = r1
            java.lang.String r1 = r0.getMessage()
            r8.f493n = r1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r7)
            return r1
        L_0x039f:
            r0 = move-exception
            r8 = r15
        L_0x03a1:
            r7 = 0
        L_0x03a2:
            r0.printStackTrace()
            r1 = 1
            r8.f463f = r1
            java.lang.String r1 = r0.getMessage()
            r8.f493n = r1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity.a1(java.lang.String, java.lang.String, int, int):java.lang.Boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0307 A[EDGE_INSN: B:106:0x0307->B:82:0x0307 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0181 A[Catch:{ IOException -> 0x0361, ih -> 0x034d }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0187 A[Catch:{ IOException -> 0x0361, ih -> 0x034d }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01c1 A[Catch:{ IOException -> 0x0361, ih -> 0x034d }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x031e A[Catch:{ IOException -> 0x034b, ih -> 0x0349 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0327 A[Catch:{ IOException -> 0x034b, ih -> 0x0349 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Boolean b1(java.lang.String r42) {
        /*
            r41 = this;
            r15 = r41
            r13 = 1
            gh r0 = new gh     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r0.<init>()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            java.lang.String r1 = r15.f454e     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            boolean r1 = r1.isEmpty()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            if (r1 != 0) goto L_0x032a
            android.content.ContentResolver r1 = r41.getContentResolver()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            android.net.Uri r2 = r15.f376a     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            java.lang.String r3 = "w"
            android.os.ParcelFileDescriptor r1 = r1.openFileDescriptor(r2, r3)     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r25 = r1
            r1 = 1073741824(0x40000000, float:2.0)
            r2 = 1082130432(0x40800000, float:4.0)
            r3 = 0
            r10 = 1065353216(0x3f800000, float:1.0)
            r0.a(r10, r1, r2, r3)     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            java.io.FileDescriptor r2 = r25.getFileDescriptor()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            v80 r1 = defpackage.v80.e0(r0, r1)     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r26 = r1
            r0.open()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            k50 r1 = new k50     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r1.<init>()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r27 = r1
            r1 = 15
            r2 = 30
            android.view.ViewGroup r3 = r15.f377a     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 >= r4) goto L_0x0057
            r1 = 3
            r2 = 60
            r28 = r1
            r29 = r2
            goto L_0x00ba
        L_0x0057:
            android.view.ViewGroup r3 = r15.f377a     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r4 = 306(0x132, float:4.29E-43)
            if (r3 >= r4) goto L_0x0074
            android.view.ViewGroup r3 = r15.f377a     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r5 = 250(0xfa, float:3.5E-43)
            if (r3 <= r5) goto L_0x0074
            r1 = 32
            r2 = 23
            r28 = r1
            r29 = r2
            goto L_0x00ba
        L_0x0074:
            android.view.ViewGroup r3 = r15.f377a     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r5 = 367(0x16f, float:5.14E-43)
            if (r3 <= r4) goto L_0x008f
            android.view.ViewGroup r3 = r15.f377a     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            if (r3 > r5) goto L_0x008f
            r1 = 30
            r2 = 23
            r28 = r1
            r29 = r2
            goto L_0x00ba
        L_0x008f:
            android.view.ViewGroup r3 = r15.f377a     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r4 = 394(0x18a, float:5.52E-43)
            if (r3 <= r5) goto L_0x00aa
            android.view.ViewGroup r3 = r15.f377a     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            if (r3 > r4) goto L_0x00aa
            r1 = 29
            r2 = 23
            r28 = r1
            r29 = r2
            goto L_0x00ba
        L_0x00aa:
            android.view.ViewGroup r3 = r15.f377a     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r3 = r3.getHeight()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            if (r3 <= r4) goto L_0x00b6
            r1 = 28
            r2 = 23
        L_0x00b6:
            r28 = r1
            r29 = r2
        L_0x00ba:
            android.view.ViewGroup r1 = r15.f377a     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r1 = r1.getWidth()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            double r1 = (double) r1     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r3 = 4619792497756654797(0x401ccccccccccccd, double:7.2)
            double r1 = r1 / r3
            int r1 = (int) r1     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r7 = r1 + 1
            android.view.ViewGroup r1 = r15.f377a     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r1 = r1.getHeight()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            double r1 = (double) r1     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r3 = 4619342137793917747(0x401b333333333333, double:6.8)
            double r1 = r1 / r3
            int r1 = (int) r1     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            android.view.ViewGroup r2 = r15.f377a     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r2 = r2.getHeight()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r3 = 460(0x1cc, float:6.45E-43)
            if (r2 != r3) goto L_0x00e6
            int r1 = r1 + 2
            r4 = r1
            goto L_0x00e7
        L_0x00e6:
            r4 = r1
        L_0x00e7:
            android.view.ViewGroup r1 = r15.f377a     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r1 = r1.getWidth()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r1 = r1 / r7
            float r3 = (float) r1     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            android.view.ViewGroup r1 = r15.f377a     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r1 = r1.getHeight()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r1 = r1 / r4
            float r1 = (float) r1     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            android.widget.EditText r2 = r15.f489m     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            android.text.Editable r2 = r2.getText()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r2 = r2 - r29
            int r5 = (int) r3     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r5 = r2 / r5
            android.widget.EditText r2 = r15.f492n     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            android.text.Editable r2 = r2.getText()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r2 = r2 + r28
            int r6 = (int) r1     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r6 = r2 / r6
            java.lang.String r2 = r15.f462f     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r2 = r2 - r29
            int r8 = (int) r3     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r8 = r2 / r8
            java.lang.String r2 = r15.f470g     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r2 = r2 + r28
            int r9 = (int) r1     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r9 = r2 / r9
            java.lang.String r2 = r15.f475h     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r2 = r2 - r29
            int r11 = (int) r3     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r11 = r2 / r11
            java.lang.String r2 = r15.f479i     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r2 = r2 + r28
            int r12 = (int) r1     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r12 = r2 / r12
            java.lang.String r2 = r15.f454e     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            tr r2 = defpackage.tr.u0(r2)     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r16 = 1058642330(0x3f19999a, float:0.6)
            android.view.ViewGroup r10 = r15.f377a     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r10 = r10.getHeight()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r14 = 286(0x11e, float:4.01E-43)
            if (r10 == r14) goto L_0x0175
            android.view.ViewGroup r10 = r15.f377a     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r10 = r10.getHeight()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r14 = 323(0x143, float:4.53E-43)
            if (r10 == r14) goto L_0x0175
            android.view.ViewGroup r10 = r15.f377a     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r10 = r10.getHeight()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r14 = 343(0x157, float:4.8E-43)
            if (r10 != r14) goto L_0x0171
            goto L_0x0175
        L_0x0171:
            r10 = 1058642330(0x3f19999a, float:0.6)
            goto L_0x0177
        L_0x0175:
            r10 = 1065353216(0x3f800000, float:1.0)
        L_0x0177:
            android.view.ViewGroup r14 = r15.f377a     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r14 = r14.getHeight()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r13 = 271(0x10f, float:3.8E-43)
            if (r14 != r13) goto L_0x0187
            r10 = 1050253722(0x3e99999a, float:0.3)
            r30 = r10
            goto L_0x0189
        L_0x0187:
            r30 = r10
        L_0x0189:
            float r10 = (float) r7     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            float r13 = (float) r4     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            float r13 = r13 - r30
            r2.Y0(r10, r13)     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            d60 r10 = r26.Z()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r31 = r2
            r2 = r10
            r10 = 1
            u70 r13 = new u70     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r14 = r15.p     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r13.<init>((int) r14)     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r14 = r13
            r13 = 1120403456(0x42c80000, float:100.0)
            r14.x0(r13)     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r13 = r41.q0()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r19 = r1
            int r1 = r15.p     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r1 = r13 % r1
            r32 = r1
            r1 = 0
            r40 = r10
            r10 = r1
            r1 = r40
        L_0x01b7:
            r20 = r1
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot> r1 = r15.f404a     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r1 = r1.size()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            if (r10 >= r1) goto L_0x0307
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot> r1 = r15.f404a     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            java.lang.Object r1 = r1.get(r10)     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot r1 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot) r1     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            java.lang.String r1 = r1.getStatus()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r21 = r3
            java.lang.String r3 = "yes"
            boolean r1 = r1.equals(r3)     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            if (r1 == 0) goto L_0x02dd
            int r1 = r15.g     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r3 = 1
            int r1 = r1 + r3
            r15.g = r1     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            android.widget.CheckBox r1 = r15.f439d     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            boolean r1 = r1.isChecked()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r33 = r0
            if (r1 == 0) goto L_0x025b
            q70 r1 = new q70     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot> r3 = r15.f404a     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            java.lang.Object r3 = r3.get(r10)     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot r3 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot) r3     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            java.lang.String r23 = r3.getUname()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot> r3 = r15.f404a     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            java.lang.Object r3 = r3.get(r10)     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot r3 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot) r3     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            java.lang.String r24 = r3.getPassword()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            java.lang.String r3 = r15.f491m     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r34 = r19
            r0 = r20
            r19 = r14
            r14 = r1
            r1 = r41
            r20 = r3
            r35 = r21
            r3 = r31
            r36 = r4
            r4 = r23
            r37 = r7
            r7 = r24
            r38 = r10
            r10 = r20
            tr r1 = r1.p0(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r14.<init>((defpackage.tr) r1)     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r1 = r14
            if (r32 <= 0) goto L_0x0236
            if (r0 != r13) goto L_0x0234
            int r3 = r15.p     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            int r3 = r3 - r32
            r4 = 1
            int r3 = r3 + r4
            r1.A0(r3)     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            goto L_0x0237
        L_0x0234:
            r4 = 1
            goto L_0x0237
        L_0x0236:
            r4 = 1
        L_0x0237:
            r3 = 0
            r1.R(r3)     // Catch:{ IOException -> 0x02d9, ih -> 0x02d5 }
            r7 = 1075838976(0x40200000, float:2.5)
            r1.G0(r7)     // Catch:{ IOException -> 0x02d9, ih -> 0x02d5 }
            r7 = 1065353216(0x3f800000, float:1.0)
            r1.H0(r7)     // Catch:{ IOException -> 0x02d9, ih -> 0x02d5 }
            r10 = 1076468122(0x4029999a, float:2.65)
            r1.F0(r10)     // Catch:{ IOException -> 0x02d9, ih -> 0x02d5 }
            r14 = r19
            r14.e(r1)     // Catch:{ IOException -> 0x02d9, ih -> 0x02d5 }
            r7 = r13
            r13 = r14
            r4 = r38
            r10 = 1065353216(0x3f800000, float:1.0)
            r38 = r8
            r8 = r15
            goto L_0x02cb
        L_0x025b:
            r36 = r4
            r37 = r7
            r38 = r10
            r34 = r19
            r0 = r20
            r35 = r21
            r3 = 0
            r4 = 1
            r7 = 1065353216(0x3f800000, float:1.0)
            r10 = 1076468122(0x4029999a, float:2.65)
            q70 r1 = new q70     // Catch:{ IOException -> 0x02d9, ih -> 0x02d5 }
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot> r3 = r15.f404a     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r4 = r38
            java.lang.Object r3 = r3.get(r4)     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot r3 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot) r3     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            java.lang.String r3 = r3.getUname()     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            java.lang.String r19 = ""
            r20 = 0
            r21 = 0
            java.lang.String r10 = r15.f491m     // Catch:{ IOException -> 0x0361, ih -> 0x034d }
            r38 = r8
            r7 = r13
            r8 = 1
            r13 = r41
            r39 = r14
            r14 = r2
            r8 = r15
            r15 = r31
            r16 = r3
            r17 = r5
            r18 = r6
            r22 = r10
            r23 = r11
            r24 = r12
            tr r3 = r13.p0(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ IOException -> 0x02d2, ih -> 0x02cf }
            r1.<init>((defpackage.tr) r3)     // Catch:{ IOException -> 0x02d2, ih -> 0x02cf }
            if (r32 <= 0) goto L_0x02b2
            if (r0 != r7) goto L_0x02b2
            int r3 = r8.p     // Catch:{ IOException -> 0x02d2, ih -> 0x02cf }
            int r3 = r3 - r32
            r10 = 1
            int r3 = r3 + r10
            r1.A0(r3)     // Catch:{ IOException -> 0x02d2, ih -> 0x02cf }
        L_0x02b2:
            r3 = 0
            r1.R(r3)     // Catch:{ IOException -> 0x034b, ih -> 0x0349 }
            r10 = 1075838976(0x40200000, float:2.5)
            r1.G0(r10)     // Catch:{ IOException -> 0x034b, ih -> 0x0349 }
            r10 = 1065353216(0x3f800000, float:1.0)
            r1.H0(r10)     // Catch:{ IOException -> 0x034b, ih -> 0x0349 }
            r13 = 1076468122(0x4029999a, float:2.65)
            r1.F0(r13)     // Catch:{ IOException -> 0x034b, ih -> 0x0349 }
            r13 = r39
            r13.e(r1)     // Catch:{ IOException -> 0x034b, ih -> 0x0349 }
        L_0x02cb:
            int r0 = r0 + 1
            r1 = r0
            goto L_0x02f3
        L_0x02cf:
            r0 = move-exception
            goto L_0x034f
        L_0x02d2:
            r0 = move-exception
            goto L_0x0363
        L_0x02d5:
            r0 = move-exception
            r8 = r15
            goto L_0x0350
        L_0x02d9:
            r0 = move-exception
            r8 = r15
            goto L_0x0364
        L_0x02dd:
            r33 = r0
            r36 = r4
            r37 = r7
            r38 = r8
            r4 = r10
            r7 = r13
            r13 = r14
            r8 = r15
            r34 = r19
            r0 = r20
            r35 = r21
            r3 = 0
            r10 = 1065353216(0x3f800000, float:1.0)
            r1 = r0
        L_0x02f3:
            int r0 = r4 + 1
            r10 = r0
            r15 = r8
            r14 = r13
            r0 = r33
            r19 = r34
            r3 = r35
            r4 = r36
            r8 = r38
            r13 = r7
            r7 = r37
            goto L_0x01b7
        L_0x0307:
            r33 = r0
            r35 = r3
            r36 = r4
            r37 = r7
            r38 = r8
            r4 = r10
            r7 = r13
            r13 = r14
            r8 = r15
            r34 = r19
            r0 = r20
            r3 = 0
            int r1 = r8.g     // Catch:{ IOException -> 0x034b, ih -> 0x0349 }
            if (r1 <= 0) goto L_0x0327
            r1 = r33
            r1.c(r13)     // Catch:{ IOException -> 0x034b, ih -> 0x0349 }
            r1.close()     // Catch:{ IOException -> 0x034b, ih -> 0x0349 }
            goto L_0x0329
        L_0x0327:
            r1 = r33
        L_0x0329:
            goto L_0x033a
        L_0x032a:
            r1 = r0
            r8 = r15
            r3 = 0
            android.content.Context r0 = r41.getApplicationContext()     // Catch:{ IOException -> 0x034b, ih -> 0x0349 }
            java.lang.String r2 = "الرجاء تحديد الصوره"
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r2, r3)     // Catch:{ IOException -> 0x034b, ih -> 0x0349 }
            r0.show()     // Catch:{ IOException -> 0x034b, ih -> 0x0349 }
        L_0x033a:
            int r0 = r8.g     // Catch:{ IOException -> 0x034b, ih -> 0x0349 }
            if (r0 <= 0) goto L_0x0344
            r2 = 1
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)     // Catch:{ IOException -> 0x034b, ih -> 0x0349 }
            return r0
        L_0x0344:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)     // Catch:{ IOException -> 0x034b, ih -> 0x0349 }
            return r0
        L_0x0349:
            r0 = move-exception
            goto L_0x0350
        L_0x034b:
            r0 = move-exception
            goto L_0x0364
        L_0x034d:
            r0 = move-exception
            r8 = r15
        L_0x034f:
            r3 = 0
        L_0x0350:
            r0.printStackTrace()
            r1 = 1
            r8.f463f = r1
            java.lang.String r1 = r0.getMessage()
            r8.f493n = r1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r3)
            return r1
        L_0x0361:
            r0 = move-exception
            r8 = r15
        L_0x0363:
            r3 = 0
        L_0x0364:
            r0.printStackTrace()
            r1 = 1
            r8.f463f = r1
            java.lang.String r1 = r0.getMessage()
            r8.f493n = r1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity.b1(java.lang.String):java.lang.Boolean");
    }

    private void h0(Uri pickerInitialUri) {
        String strDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Calendar.getInstance().getTime());
        Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("application/pdf");
        intent.putExtra("android.intent.extra.TITLE", "cards_Hotspot_" + strDate + ".pdf");
        intent.putExtra("android.provider.extra.INITIAL_URI", pickerInitialUri);
        startActivityForResult(intent, 5);
    }

    public tr p0(d60 cb, tr img, String watermark, int x2, int y2, String watermark2, int x22, int y22, String watermarkSls, int xSls, int ySls) {
        b.C0035b bVar = b.C0035b.HELVETICA;
        com.itextpdf.text.b font = new com.itextpdf.text.b(bVar, (float) this.d, 1);
        font.q(this.f407a);
        com.itextpdf.text.b font_p = new com.itextpdf.text.b(bVar, (float) this.e, 1);
        font_p.q(this.f424b);
        com.itextpdf.text.b fontSls = new com.itextpdf.text.b(y5.d("assets/fonts/HacenCasablanca.ttf", "Identity-H", true), this.f372a, 0);
        fontSls.q(this.f436c);
        float width = img.B0();
        float height = img.A0();
        q80 template = cb.Q(width, height);
        template.m(img, width, 0.0f, 0.0f, height, 0.0f, 0.0f);
        q80 q80 = template;
        ia.U(q80, 1, new com.itextpdf.text.d(watermark, font), width - ((float) x2), height - ((float) y2), 0.0f);
        if (this.f439d.isChecked()) {
            q80 q802 = template;
            ia.U(q802, 1, new com.itextpdf.text.d(watermark2, font_p), width - ((float) x22), height - ((float) y22), 0.0f);
        }
        if (this.f448e.isChecked()) {
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

    /* access modifiers changed from: private */
    public boolean e0() {
        if (Build.VERSION.SDK_INT >= 30) {
            return Environment.isExternalStorageManager();
        }
        return ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") == 0 && ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    /* access modifiers changed from: private */
    public void V0() {
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
                        this.f454e = cursor.getString(cursor.getColumnIndex(projection[0]));
                        cursor.close();
                        this.f377a.setBackground(new BitmapDrawable(BitmapFactory.decodeFile(this.f454e)));
                        try {
                            g0(this.f454e, "/storage/emulated/0/MUMS_Images/");
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
                this.f454e = cursor2.getString(cursor2.getColumnIndex(projection2[0]));
                cursor2.close();
                this.f377a.setBackground(new BitmapDrawable(BitmapFactory.decodeFile(this.f454e)));
                try {
                    g0(this.f454e, "/storage/emulated/0/MUMS_Images/");
                } catch (Exception e4) {
                }
            }
        } else if (requestCode == 5 && resultCode == -1) {
            Uri uri = data.getData();
            try {
                this.f494o = jw0.e(this.f375a, uri);
                this.f376a = uri;
            } catch (Exception e5) {
                e5.printStackTrace();
                Toast.makeText(this.f375a, e5.getMessage(), 0).show();
            }
            f0 f0Var = new f0();
            this.f397a = f0Var;
            f0Var.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
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

    public void onBackPressed() {
        new AlertDialog.Builder(this, R.style.CustomAlertDialog).setIcon(17301543).setTitle("تنبية !").setMessage("هل تريد الخروج من هذه النافذة؟").setPositiveButton("نعم", new h()).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
    }

    class h implements DialogInterface.OnClickListener {
        h() {
        }

        public void onClick(DialogInterface dialog, int which) {
            AddHostpotActivity.this.finish();
            i40.e(AddHostpotActivity.this.f375a);
        }
    }

    public void g0(String srcDir, String dstDir) {
        try {
            File src = new File(srcDir);
            File dst = new File(dstDir, src.getName());
            if (src.isDirectory()) {
                for (String file : src.list()) {
                    g0(new File(src, file).getPath(), dst.getPath());
                }
                return;
            }
            f0(src, dst);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void f0(java.io.File r9, java.io.File r10) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity.f0(java.io.File, java.io.File):void");
    }

    public ArrayList<Model_images> j0(GridView gv_folder) {
        this.f435c.clear();
        try {
            File path = new File("/storage/emulated/0/MUMS_Images/");
            if (path.exists()) {
                String[] fileNames = path.list();
                for (int i2 = 0; i2 < fileNames.length; i2++) {
                    String str = fileNames[i2];
                    this.f435c.add(new Model_images(str, path.getPath() + "/" + fileNames[i2]));
                }
                t0 t0Var = new t0(getApplicationContext(), this.f435c);
                this.f405a = t0Var;
                gv_folder.setAdapter(t0Var);
            }
        } catch (Exception e2) {
        }
        return this.f435c;
    }

    public void s0() {
        try {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this, R.style.CustomAlertDialog);
            View myView = getLayoutInflater().inflate(R.layout.imglist_pop, (ViewGroup) null);
            dialogBuilder.setView(myView);
            GridView gv_folder = (GridView) myView.findViewById(R.id.gv_folder);
            TextView refresh_img = (TextView) myView.findViewById(R.id.refresh_img);
            TextView from_geliry = (TextView) myView.findViewById(R.id.from_geliry);
            dialogBuilder.create().show();
            if (e0()) {
                j0(gv_folder);
            } else {
                V0();
            }
            gv_folder.setOnItemClickListener(new i());
            refresh_img.setOnClickListener(new j(gv_folder));
            from_geliry.setOnClickListener(new m());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    class i implements AdapterView.OnItemClickListener {
        i() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            AddHostpotActivity.this.f377a.setBackground(new BitmapDrawable(BitmapFactory.decodeFile(AddHostpotActivity.this.f435c.get(i).getAl_imagepath())));
            AddHostpotActivity addHostpotActivity = AddHostpotActivity.this;
            addHostpotActivity.f454e = addHostpotActivity.f435c.get(i).getAl_imagepath();
        }
    }

    class j implements View.OnClickListener {
        final /* synthetic */ GridView a;

        j(GridView gridView) {
            this.a = gridView;
        }

        public void onClick(View v) {
            AddHostpotActivity.this.j0(this.a);
        }
    }

    class m implements View.OnClickListener {
        m() {
        }

        public void onClick(View v) {
            if (Build.VERSION.SDK_INT < 23) {
                AddHostpotActivity.this.startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 1);
            } else if (AddHostpotActivity.this.e0()) {
                AddHostpotActivity.this.startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 1);
            } else {
                AddHostpotActivity.this.V0();
            }
        }
    }

    public void W0() {
        try {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this, R.style.CustomAlertDialog);
            View myView = getLayoutInflater().inflate(R.layout.save_hots_profile_pop, (ViewGroup) null);
            dialogBuilder.setView(myView);
            dialogBuilder.create().show();
            ((TextView) myView.findViewById(R.id.save_profile_btn)).setOnClickListener(new n((EditText) myView.findViewById(R.id.save_profile_name)));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    class n implements View.OnClickListener {
        final /* synthetic */ EditText a;

        n(EditText editText) {
            this.a = editText;
        }

        public void onClick(View v) {
            AddHostpotActivity.this.d0(this.a.getText().toString());
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
    public void d0(java.lang.String r42) {
        /*
            r41 = this;
            r1 = r41
            java.lang.String r0 = "الرجاء تعبئة حقل السعر"
            java.lang.String r2 = "الرجاء تعبئة حقل التحميل"
            java.lang.String r3 = "الرجاء تعبئة حقل الصلاحية"
            java.lang.String r4 = "الرجاء تعبئة حقل الوقت"
            java.lang.String r5 = ""
            java.lang.String r6 = "1"
            java.lang.String r7 = "0"
            android.widget.EditText r9 = r1.f449e     // Catch:{ Exception -> 0x01fc }
            android.text.Editable r9 = r9.getText()     // Catch:{ Exception -> 0x01fc }
            java.lang.String r12 = r9.toString()     // Catch:{ Exception -> 0x01fc }
            android.widget.EditText r9 = r1.f457f     // Catch:{ Exception -> 0x01fc }
            android.text.Editable r9 = r9.getText()     // Catch:{ Exception -> 0x01fc }
            java.lang.String r14 = r9.toString()     // Catch:{ Exception -> 0x01fc }
            android.widget.EditText r9 = r1.f465g     // Catch:{ Exception -> 0x01fc }
            android.text.Editable r9 = r9.getText()     // Catch:{ Exception -> 0x01fc }
            java.lang.String r13 = r9.toString()     // Catch:{ Exception -> 0x01fc }
            android.widget.EditText r9 = r1.f476i     // Catch:{ Exception -> 0x01fc }
            android.text.Editable r9 = r9.getText()     // Catch:{ Exception -> 0x01fc }
            java.lang.String r15 = r9.toString()     // Catch:{ Exception -> 0x01fc }
            android.widget.Spinner r9 = r1.f473h     // Catch:{ Exception -> 0x01fc }
            int r9 = r9.getSelectedItemPosition()     // Catch:{ Exception -> 0x01fc }
            java.lang.String r16 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x01fc }
            android.widget.Spinner r9 = r1.f477i     // Catch:{ Exception -> 0x01fc }
            int r9 = r9.getSelectedItemPosition()     // Catch:{ Exception -> 0x01fc }
            java.lang.String r17 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x01fc }
            android.widget.Spinner r9 = r1.f452e     // Catch:{ Exception -> 0x01fc }
            int r9 = r9.getSelectedItemPosition()     // Catch:{ Exception -> 0x01fc }
            java.lang.String r18 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x01fc }
            android.widget.Spinner r9 = r1.f432c     // Catch:{ Exception -> 0x01fc }
            int r9 = r9.getSelectedItemPosition()     // Catch:{ Exception -> 0x01fc }
            java.lang.String r36 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x01fc }
            android.widget.Spinner r9 = r1.f386a     // Catch:{ Exception -> 0x01fc }
            java.lang.Object r9 = r9.getSelectedItem()     // Catch:{ Exception -> 0x01fc }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x01fc }
            r10 = r7
            r11 = r7
            r19 = r6
            r20 = r6
            r21 = r7
            r22 = r5
            android.widget.Spinner r8 = r1.f468g     // Catch:{ Exception -> 0x01fc }
            int r8 = r8.getSelectedItemPosition()     // Catch:{ Exception -> 0x01fc }
            java.lang.String r35 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x01fc }
            android.widget.EditText r8 = r1.f486l     // Catch:{ Exception -> 0x01fc }
            android.text.Editable r8 = r8.getText()     // Catch:{ Exception -> 0x01fc }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x01fc }
            java.lang.String r8 = r8.trim()     // Catch:{ Exception -> 0x01fc }
            int r8 = r8.length()     // Catch:{ Exception -> 0x01fc }
            if (r8 <= 0) goto L_0x00a3
            android.widget.EditText r8 = r1.f486l     // Catch:{ Exception -> 0x01fc }
            android.text.Editable r8 = r8.getText()     // Catch:{ Exception -> 0x01fc }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x01fc }
            java.lang.String r8 = r8.trim()     // Catch:{ Exception -> 0x01fc }
            r22 = r8
            goto L_0x00a5
        L_0x00a3:
            r8 = r22
        L_0x00a5:
            r22 = r9
            android.widget.RadioButton r9 = r1.f431c     // Catch:{ Exception -> 0x01fc }
            boolean r9 = r9.isChecked()     // Catch:{ Exception -> 0x01fc }
            if (r9 == 0) goto L_0x00b1
            r9 = r6
            goto L_0x00b2
        L_0x00b1:
            r9 = r7
        L_0x00b2:
            r19 = r10
            android.widget.RadioButton r10 = r1.f451e     // Catch:{ Exception -> 0x01fc }
            boolean r10 = r10.isChecked()     // Catch:{ Exception -> 0x01fc }
            if (r10 == 0) goto L_0x00c0
            r10 = r6
            r37 = r10
            goto L_0x00c3
        L_0x00c0:
            r10 = r7
            r37 = r10
        L_0x00c3:
            android.widget.CheckBox r10 = r1.f380a     // Catch:{ Exception -> 0x01fc }
            boolean r10 = r10.isChecked()     // Catch:{ Exception -> 0x01fc }
            if (r10 == 0) goto L_0x00cf
            r10 = r6
            r38 = r10
            goto L_0x00d2
        L_0x00cf:
            r10 = r7
            r38 = r10
        L_0x00d2:
            android.widget.CheckBox r10 = r1.f439d     // Catch:{ Exception -> 0x01fc }
            boolean r10 = r10.isChecked()     // Catch:{ Exception -> 0x01fc }
            if (r10 == 0) goto L_0x00de
            r10 = r6
            r39 = r10
            goto L_0x00e1
        L_0x00de:
            r10 = r7
            r39 = r10
        L_0x00e1:
            android.widget.CheckBox r10 = r1.f414b     // Catch:{ Exception -> 0x01fc }
            boolean r10 = r10.isChecked()     // Catch:{ Exception -> 0x01fc }
            if (r10 == 0) goto L_0x00ed
            r5 = r6
            r6 = r22
            goto L_0x00f3
        L_0x00ed:
            r6 = r7
            r40 = r6
            r6 = r5
            r5 = r40
        L_0x00f3:
            java.lang.String r7 = r42.trim()     // Catch:{ Exception -> 0x01fc }
            int r7 = r7.length()     // Catch:{ Exception -> 0x01fc }
            if (r7 > 0) goto L_0x0108
            java.lang.String r0 = "الرجاء كتابة اسم القالب"
            r2 = 0
            android.widget.Toast r0 = android.widget.Toast.makeText(r1, r0, r2)     // Catch:{ Exception -> 0x01fc }
            r0.show()     // Catch:{ Exception -> 0x01fc }
            return
        L_0x0108:
            boolean r7 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x01fc }
            if (r7 == 0) goto L_0x011c
            android.widget.EditText r0 = r1.f449e     // Catch:{ Exception -> 0x01fc }
            r0.setError(r4)     // Catch:{ Exception -> 0x01fc }
            r2 = 0
            android.widget.Toast r0 = android.widget.Toast.makeText(r1, r4, r2)     // Catch:{ Exception -> 0x01fc }
            r0.show()     // Catch:{ Exception -> 0x01fc }
            return
        L_0x011c:
            boolean r4 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x01fc }
            if (r4 == 0) goto L_0x0130
            android.widget.EditText r0 = r1.f457f     // Catch:{ Exception -> 0x01fc }
            r0.setError(r3)     // Catch:{ Exception -> 0x01fc }
            r2 = 0
            android.widget.Toast r0 = android.widget.Toast.makeText(r1, r3, r2)     // Catch:{ Exception -> 0x01fc }
            r0.show()     // Catch:{ Exception -> 0x01fc }
            return
        L_0x0130:
            boolean r3 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x01fc }
            if (r3 == 0) goto L_0x0144
            android.widget.EditText r0 = r1.f465g     // Catch:{ Exception -> 0x01fc }
            r0.setError(r2)     // Catch:{ Exception -> 0x01fc }
            r3 = 0
            android.widget.Toast r0 = android.widget.Toast.makeText(r1, r2, r3)     // Catch:{ Exception -> 0x01fc }
            r0.show()     // Catch:{ Exception -> 0x01fc }
            return
        L_0x0144:
            boolean r2 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x01fc }
            if (r2 == 0) goto L_0x0158
            android.widget.EditText r2 = r1.f476i     // Catch:{ Exception -> 0x01fc }
            r2.setError(r0)     // Catch:{ Exception -> 0x01fc }
            r2 = 0
            android.widget.Toast r0 = android.widget.Toast.makeText(r1, r0, r2)     // Catch:{ Exception -> 0x01fc }
            r0.show()     // Catch:{ Exception -> 0x01fc }
            return
        L_0x0158:
            java.lang.String r0 = r1.f454e     // Catch:{ Exception -> 0x01fc }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01fc }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x01fc }
            if (r0 == 0) goto L_0x016f
            java.lang.String r0 = "الرجاء تحديد صورة قالب الطباعة"
            r2 = 0
            android.widget.Toast r0 = android.widget.Toast.makeText(r1, r0, r2)     // Catch:{ Exception -> 0x01fc }
            r0.show()     // Catch:{ Exception -> 0x01fc }
            return
        L_0x016f:
            ue r0 = r1.f406a     // Catch:{ Exception -> 0x01fc }
            r2 = r42
            android.database.Cursor r0 = r0.i0(r2)     // Catch:{ Exception -> 0x01fa }
            int r3 = r0.getCount()     // Catch:{ Exception -> 0x01fa }
            if (r3 > 0) goto L_0x01ef
            android.widget.CheckBox r3 = r1.f448e     // Catch:{ Exception -> 0x01fa }
            boolean r3 = r3.isChecked()     // Catch:{ Exception -> 0x01fa }
            if (r3 != 0) goto L_0x018a
            r3 = 0
            r1.l = r3     // Catch:{ Exception -> 0x01fa }
            r1.m = r3     // Catch:{ Exception -> 0x01fa }
        L_0x018a:
            ue r10 = r1.f406a     // Catch:{ Exception -> 0x01fa }
            java.lang.String r3 = r1.f454e     // Catch:{ Exception -> 0x01fa }
            int r4 = r1.h     // Catch:{ Exception -> 0x01fa }
            java.lang.String r20 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x01fa }
            int r4 = r1.i     // Catch:{ Exception -> 0x01fa }
            java.lang.String r21 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x01fa }
            int r4 = r1.j     // Catch:{ Exception -> 0x01fa }
            java.lang.String r22 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x01fa }
            int r4 = r1.k     // Catch:{ Exception -> 0x01fa }
            java.lang.String r23 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x01fa }
            int r4 = r1.l     // Catch:{ Exception -> 0x01fa }
            java.lang.String r24 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x01fa }
            int r4 = r1.m     // Catch:{ Exception -> 0x01fa }
            java.lang.String r25 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x01fa }
            int r4 = r1.n     // Catch:{ Exception -> 0x01fa }
            java.lang.String r26 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x01fa }
            int r4 = r1.o     // Catch:{ Exception -> 0x01fa }
            java.lang.String r27 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x01fa }
            r11 = r42
            r19 = r3
            r28 = r5
            r29 = r39
            r30 = r6
            r31 = r9
            r32 = r37
            r33 = r8
            r34 = r38
            boolean r3 = r10.C(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)     // Catch:{ Exception -> 0x01fa }
            if (r3 == 0) goto L_0x01e4
            java.lang.String r4 = "تم حقظ البيانات بنجاح"
            r7 = 0
            android.widget.Toast r4 = android.widget.Toast.makeText(r1, r4, r7)     // Catch:{ Exception -> 0x01fa }
            r4.show()     // Catch:{ Exception -> 0x01fa }
            r41.i0()     // Catch:{ Exception -> 0x01fa }
            goto L_0x01ee
        L_0x01e4:
            java.lang.String r4 = "لم يتم حفظ الملف تاكد من تعبئة كافة البيانات"
            r7 = 0
            android.widget.Toast r4 = android.widget.Toast.makeText(r1, r4, r7)     // Catch:{ Exception -> 0x01fa }
            r4.show()     // Catch:{ Exception -> 0x01fa }
        L_0x01ee:
            goto L_0x01f9
        L_0x01ef:
            java.lang.String r3 = "اسم الباقة موجوة بالفعل..قم بكتابة اسم اخر"
            r4 = 0
            android.widget.Toast r3 = android.widget.Toast.makeText(r1, r3, r4)     // Catch:{ Exception -> 0x01fa }
            r3.show()     // Catch:{ Exception -> 0x01fa }
        L_0x01f9:
            goto L_0x020b
        L_0x01fa:
            r0 = move-exception
            goto L_0x01ff
        L_0x01fc:
            r0 = move-exception
            r2 = r42
        L_0x01ff:
            java.lang.String r3 = r0.getMessage()
            r4 = 0
            android.widget.Toast r3 = android.widget.Toast.makeText(r1, r3, r4)
            r3.show()
        L_0x020b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity.d0(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public void m0(String selected_size) {
        if (selected_size.equals("3")) {
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) this.f377a.getLayoutParams();
            params.width = 1390;
            this.q = 1390;
            this.f377a.setLayoutParams(params);
            this.p = 3;
        } else if (selected_size.equals("4")) {
            LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams) this.f377a.getLayoutParams();
            params2.width = 1037;
            this.q = 1037;
            this.f377a.setLayoutParams(params2);
            this.p = 4;
        }
    }

    /* access modifiers changed from: private */
    public void n0(String selected_size) {
        if (selected_size.equals("12")) {
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) this.f377a.getLayoutParams();
            params.height = 456;
            this.f377a.setLayoutParams(params);
            this.f372a = 8.5f;
            this.f453e.setTextSize(2, 18.5f);
        } else if (selected_size.equals("13")) {
            LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams) this.f377a.getLayoutParams();
            params2.height = HttpStatus.SC_FAILED_DEPENDENCY;
            this.f377a.setLayoutParams(params2);
            this.f372a = 8.4f;
            this.f453e.setTextSize(2, 18.0f);
        } else if (selected_size.equals("14")) {
            LinearLayout.LayoutParams params3 = (LinearLayout.LayoutParams) this.f377a.getLayoutParams();
            params3.height = 391;
            this.f377a.setLayoutParams(params3);
            this.f372a = 8.2f;
            this.f453e.setTextSize(2, 17.5f);
        } else if (selected_size.equals("15")) {
            LinearLayout.LayoutParams params4 = (LinearLayout.LayoutParams) this.f377a.getLayoutParams();
            params4.height = 364;
            this.f377a.setLayoutParams(params4);
            this.f372a = 8.1f;
            this.f453e.setTextSize(2, 17.0f);
        } else if (selected_size.equals("16")) {
            LinearLayout.LayoutParams params5 = (LinearLayout.LayoutParams) this.f377a.getLayoutParams();
            params5.height = 343;
            this.f377a.setLayoutParams(params5);
            this.f372a = 7.8f;
            this.f453e.setTextSize(2, 16.5f);
        } else if (selected_size.equals("17")) {
            LinearLayout.LayoutParams params6 = (LinearLayout.LayoutParams) this.f377a.getLayoutParams();
            params6.height = 323;
            this.f377a.setLayoutParams(params6);
            this.f372a = 7.7f;
            this.f453e.setTextSize(2, 16.0f);
        } else if (selected_size.equals("18")) {
            LinearLayout.LayoutParams params7 = (LinearLayout.LayoutParams) this.f377a.getLayoutParams();
            params7.height = HttpStatus.SC_SEE_OTHER;
            this.f377a.setLayoutParams(params7);
            this.f372a = 7.6f;
            this.f453e.setTextSize(2, 15.5f);
        } else if (selected_size.equals("19")) {
            LinearLayout.LayoutParams params8 = (LinearLayout.LayoutParams) this.f377a.getLayoutParams();
            params8.height = 286;
            this.f377a.setLayoutParams(params8);
            this.f372a = 7.3f;
            this.f453e.setTextSize(2, 15.0f);
        } else if (selected_size.equals("20")) {
            LinearLayout.LayoutParams params9 = (LinearLayout.LayoutParams) this.f377a.getLayoutParams();
            params9.height = 271;
            this.f377a.setLayoutParams(params9);
            this.f372a = 6.9f;
            this.f453e.setTextSize(2, 14.5f);
        }
    }

    public void r0(String item) {
        boolean z2 = false;
        try {
            Cursor data = this.f406a.i0(item.toString());
            while (data.moveToNext()) {
                try {
                    this.f449e.setText(data.getString(2));
                    this.f457f.setText(data.getString(4));
                    this.f465g.setText(data.getString(3));
                    this.f476i.setText(data.getString(5));
                    this.f473h.setSelection(Integer.parseInt(data.getString(6)));
                    this.f477i.setSelection(Integer.parseInt(data.getString(7)));
                    this.f452e.setSelection(Integer.parseInt(data.getString(8)));
                    this.f432c.setSelection(Integer.parseInt(data.getString(22)));
                    this.f486l.setText(data.getString(19));
                    this.f454e = data.getString(9);
                    this.f468g.setSelection(Integer.parseInt(data.getString(21)));
                    if (data.getString(15).equals("1")) {
                        this.f439d.setChecked(true);
                        this.f444d.setVisibility(z2);
                    } else {
                        this.f439d.setChecked(z2);
                        this.f444d.setVisibility(8);
                    }
                    if (data.getString(17).equals("1")) {
                        this.f431c.setChecked(true);
                        this.f385a.setChecked(z2);
                    } else {
                        this.f431c.setChecked(z2);
                        this.f385a.setChecked(true);
                    }
                    if (data.getString(18).equals("1")) {
                        this.f451e.setChecked(true);
                        this.f442d.setChecked(z2);
                    } else {
                        this.f451e.setChecked(z2);
                        this.f442d.setChecked(true);
                    }
                    if (data.getString(20).equals("1")) {
                        this.f380a.setChecked(true);
                    } else {
                        this.f380a.setChecked(z2);
                    }
                    if (data.getString(14).equals("1")) {
                        this.f414b.setChecked(true);
                        this.f386a.setVisibility(z2);
                        if (this.f378a != null) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= this.f378a.getCount()) {
                                    break;
                                } else if (this.f386a.getItemAtPosition(i2).equals(data.getString(16))) {
                                    this.f386a.setSelection(i2);
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                        }
                    } else {
                        this.f414b.setChecked(z2);
                        this.f386a.setVisibility(8);
                    }
                    if (data.getString(23) == null) {
                        this.f448e.setChecked(z2);
                        this.f453e.setVisibility(8);
                    } else if (!data.getString(23).equals("0")) {
                        this.f448e.setChecked(true);
                        this.f453e.setVisibility(z2);
                    }
                    if (new File(this.f454e).exists()) {
                        this.f377a.setBackground(new BitmapDrawable(BitmapFactory.decodeFile(this.f454e)));
                    }
                    n0(this.f452e.getSelectedItem().toString());
                    m0(this.f432c.getSelectedItem().toString());
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f433c.getLayoutParams();
                    layoutParams.leftMargin = Integer.parseInt(data.getString(10));
                    layoutParams.topMargin = Integer.parseInt(data.getString(11));
                    layoutParams.rightMargin = z2 ? 1 : 0;
                    layoutParams.bottomMargin = z2;
                    this.f433c.setLayoutParams(layoutParams);
                    this.h = Integer.parseInt(data.getString(10));
                    this.i = Integer.parseInt(data.getString(11));
                    this.f489m.setText(String.valueOf(((this.f433c.getWidth() / 2) + (this.q - this.f433c.getWidth())) - Integer.parseInt(data.getString(10))));
                    this.f492n.setText(String.valueOf(Integer.valueOf(data.getString(11))));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f444d.getLayoutParams();
                    layoutParams2.leftMargin = Integer.parseInt(data.getString(12));
                    layoutParams2.topMargin = Integer.parseInt(data.getString(13));
                    layoutParams2.rightMargin = z2;
                    layoutParams2.bottomMargin = z2;
                    this.f444d.setLayoutParams(layoutParams2);
                    this.j = Integer.parseInt(data.getString(12));
                    this.k = Integer.parseInt(data.getString(13));
                    this.f462f = String.valueOf(((this.f444d.getWidth() / 2) + (this.q - this.f444d.getWidth())) - Integer.parseInt(data.getString(12)));
                    this.f470g = String.valueOf(Integer.valueOf(data.getString(13)));
                    if (data.getString(23) == null) {
                        this.f453e.setVisibility(8);
                        this.f448e.setChecked(false);
                    } else if (Integer.parseInt(data.getString(23)) > 0) {
                        this.f453e.setVisibility(z2);
                        this.f448e.setChecked(true);
                        RelativeLayout.LayoutParams layoutParamsSlsPoint = (RelativeLayout.LayoutParams) this.f453e.getLayoutParams();
                        layoutParamsSlsPoint.leftMargin = Integer.parseInt(data.getString(23));
                        layoutParamsSlsPoint.topMargin = Integer.parseInt(data.getString(24));
                        layoutParamsSlsPoint.rightMargin = z2;
                        layoutParamsSlsPoint.bottomMargin = z2;
                        this.f453e.setLayoutParams(layoutParamsSlsPoint);
                        this.l = Integer.parseInt(data.getString(23));
                        this.m = Integer.parseInt(data.getString(24));
                        this.f475h = String.valueOf(((this.f453e.getWidth() / 2) + (this.q - this.f453e.getWidth())) - Integer.parseInt(data.getString(23)));
                        this.f479i = String.valueOf(Integer.valueOf(data.getString(24)));
                    } else {
                        this.f453e.setVisibility(8);
                        this.f448e.setChecked(false);
                    }
                    z2 = false;
                } catch (Exception er) {
                    Toast.makeText(this.f375a, er.getMessage(), 0);
                    z2 = false;
                }
            }
        } catch (Exception et) {
            Toast.makeText(this.f375a, et.getMessage(), 0);
        }
    }

    /* access modifiers changed from: private */
    public void i0() {
        try {
            Cursor data = this.f406a.h0();
            List<String> list4 = new ArrayList<>();
            if (data.getCount() > 0) {
                slideUp(this.f383a);
                this.f487l.setText("اخفاء اعدادات الطباعة");
                this.f409a = true;
                list4.add("تحديد باقة محفوظة");
                while (data.moveToNext()) {
                    list4.add(data.getString(1));
                }
            } else {
                list4.add("لا يوجد باقات محفوظة");
            }
            ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<>(this, 17367048, list4);
            dataAdapter4.setDropDownViewResource(17367049);
            this.f460f.setAdapter(dataAdapter4);
        } catch (Exception e2) {
        }
    }

    public void Z0() {
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
            font_size_number_s.setText(String.valueOf(this.f372a));
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
                    ArrayAdapter<SalesPointModel> color_type_s_adapter = new ArrayAdapter<>(this.f375a, 17367048, colorModel);
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
            color_type_s.setSelection(this.t, false);
            color_type_s.setOnItemSelectedListener(new o(colorList));
            color_type_u.setSelection(this.s, false);
            color_type_u.setOnItemSelectedListener(new p(colorList));
            color_type_p.setSelection(this.u, false);
            color_type_p.setOnItemSelectedListener(new q(colorList));
            plus_u.setOnClickListener(new i1(this, font_size_number_u));
            menus_u.setOnClickListener(new e1(this, font_size_number_u));
            plus_p.setOnClickListener(new h1(this, font_size_number_p));
            menus_p.setOnClickListener(new g1(this, font_size_number_p));
            plus_s.setOnClickListener(new j1(this, font_size_number_s));
            menus_s.setOnClickListener(new d1(this, font_size_number_s));
            submit_btn.setOnClickListener(new r(b2));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    class o implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ String[] f511a;

        o(String[] strArr) {
            this.f511a = strArr;
        }

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SalesPointModel colorModel = (SalesPointModel) parent.getSelectedItem();
            String hexCode = this.f511a[colorModel.getId() - 1];
            int resultRed = Integer.valueOf(hexCode.substring(0, 2), 16).intValue();
            int resultGreen = Integer.valueOf(hexCode.substring(2, 4), 16).intValue();
            int resultBlue = Integer.valueOf(hexCode.substring(4, 6), 16).intValue();
            AddHostpotActivity.this.f453e.setTextColor(Color.rgb(resultRed, resultGreen, resultBlue));
            AddHostpotActivity.this.f436c = new w5(resultRed, resultGreen, resultBlue);
            AddHostpotActivity.this.t = colorModel.getId() - 1;
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class p implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ String[] f512a;

        p(String[] strArr) {
            this.f512a = strArr;
        }

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SalesPointModel colorModel = (SalesPointModel) parent.getSelectedItem();
            String hexCode = this.f512a[colorModel.getId() - 1];
            int resultRed = Integer.valueOf(hexCode.substring(0, 2), 16).intValue();
            int resultGreen = Integer.valueOf(hexCode.substring(2, 4), 16).intValue();
            int resultBlue = Integer.valueOf(hexCode.substring(4, 6), 16).intValue();
            AddHostpotActivity.this.f433c.setTextColor(Color.rgb(resultRed, resultGreen, resultBlue));
            AddHostpotActivity.this.f407a = new w5(resultRed, resultGreen, resultBlue);
            AddHostpotActivity.this.s = colorModel.getId() - 1;
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class q implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ String[] f513a;

        q(String[] strArr) {
            this.f513a = strArr;
        }

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SalesPointModel colorModel = (SalesPointModel) parent.getSelectedItem();
            String hexCode = this.f513a[colorModel.getId() - 1];
            int resultRed = Integer.valueOf(hexCode.substring(0, 2), 16).intValue();
            int resultGreen = Integer.valueOf(hexCode.substring(2, 4), 16).intValue();
            int resultBlue = Integer.valueOf(hexCode.substring(4, 6), 16).intValue();
            AddHostpotActivity.this.f444d.setTextColor(Color.rgb(resultRed, resultGreen, resultBlue));
            AddHostpotActivity.this.f424b = new w5(resultRed, resultGreen, resultBlue);
            AddHostpotActivity.this.u = colorModel.getId() - 1;
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M0(TextView font_size_number_u, View v2) {
        int i2 = this.d;
        if (i2 <= 13) {
            this.d = i2 + 1;
            TextView textView = this.f433c;
            textView.setTextSize(0, textView.getTextSize() + 2.0f);
            font_size_number_u.setText(String.valueOf(this.d));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N0(TextView font_size_number_u, View v2) {
        int i2 = this.d;
        if (i2 >= 8) {
            this.d = i2 - 1;
            TextView textView = this.f433c;
            textView.setTextSize(0, textView.getTextSize() - 2.0f);
            font_size_number_u.setText(String.valueOf(this.d));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0(TextView font_size_number_p, View v2) {
        int i2 = this.e;
        if (i2 <= 13) {
            this.e = i2 + 1;
            TextView textView = this.f444d;
            textView.setTextSize(0, textView.getTextSize() + 2.0f);
            font_size_number_p.setText(String.valueOf(this.e));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P0(TextView font_size_number_p, View v2) {
        int i2 = this.e;
        if (i2 >= 8) {
            this.e = i2 - 1;
            TextView textView = this.f444d;
            textView.setTextSize(0, textView.getTextSize() - 2.0f);
            font_size_number_p.setText(String.valueOf(this.e));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q0(TextView font_size_number_s, View v2) {
        float f2 = this.f372a;
        if (f2 <= 12.0f) {
            this.f372a = f2 + 1.0f;
            TextView textView = this.f453e;
            textView.setTextSize(0, textView.getTextSize() + 1.0f);
            font_size_number_s.setText(String.valueOf(this.f372a));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void R0(TextView font_size_number_s, View v2) {
        float f2 = this.f372a;
        if (f2 >= 8.0f) {
            this.f372a = f2 - 1.0f;
            TextView textView = this.f453e;
            textView.setTextSize(0, textView.getTextSize() - 1.0f);
            font_size_number_s.setText(String.valueOf(this.f372a));
        }
    }

    class r implements View.OnClickListener {
        final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        r(androidx.appcompat.app.AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        public void onClick(View v) {
            this.a.dismiss();
        }
    }
}
