package defpackage;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.BindingUser;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.ConnectData;
import com.evrencoskun.tableview.TableView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: yu  reason: default package */
public class yu extends Fragment implements pr {
    public int a = 0;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f5937a;

    /* renamed from: a  reason: collision with other field name */
    Context f5938a;

    /* renamed from: a  reason: collision with other field name */
    Button f5939a;

    /* renamed from: a  reason: collision with other field name */
    TextView f5940a;

    /* renamed from: a  reason: collision with other field name */
    AlertDialog f5941a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public RecyclerView f5942a;

    /* renamed from: a  reason: collision with other field name */
    ConnectData f5943a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public TableView f5944a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public d0 f5945a;

    /* renamed from: a  reason: collision with other field name */
    j3 f5946a;

    /* renamed from: a  reason: collision with other field name */
    final String f5947a = "mLog";

    /* renamed from: a  reason: collision with other field name */
    ArrayList<BindingUser> f5948a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public tp0 f5949a;

    /* renamed from: a  reason: collision with other field name */
    c f5950a;

    /* renamed from: a  reason: collision with other field name */
    d f5951a;
    public int b = 0;

    /* renamed from: b  reason: collision with other field name */
    public String f5952b = "";
    public String c = "";

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f5943a = new ConnectData();
        this.f5937a = new ProgressDialog(getContext());
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.binding_fragment, container, false);
        try {
            this.f5946a = qb0.d();
            this.f5942a = (RecyclerView) view.findViewById(R.id.recycleractive);
            this.f5948a = new ArrayList<>();
            this.f5939a = (Button) view.findViewById(R.id.activebtn);
            this.f5940a = (TextView) view.findViewById(R.id.activeacount);
            this.f5944a = (TableView) view.findViewById(R.id.tableview_binding);
            this.f5939a.setOnClickListener(new a());
            this.f5944a.setTableViewListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    /* renamed from: yu$a */
    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View v) {
            yu.this.f5950a = new c();
            yu.this.f5950a.execute(new String[0]);
        }
    }

    /* renamed from: yu$c */
    class c extends AsyncTask<String, String, List<Map<String, String>>> {
        String a = "";

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f5953a = null;

        /* renamed from: a  reason: collision with other field name */
        boolean f5955a = false;

        c() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            yu.this.f5937a.setTitle("يرجى الانتظار");
            yu.this.f5937a.setMessage("يتم جلب قائمة الحظر");
            yu.this.f5937a.setCancelable(false);
            yu.this.f5937a.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public List<Map<String, String>> doInBackground(String... params) {
            try {
                if (yu.this.f5946a.w()) {
                    this.f5953a = yu.this.f5946a.q("/ip/hotspot/ip-binding/print return .id,mac-address,address,server,type");
                }
            } catch (Exception e) {
                try {
                    this.a = e.getMessage();
                    this.f5955a = true;
                } catch (Exception e2) {
                    this.a = e2.getMessage();
                    this.f5955a = true;
                }
            }
            return this.f5953a;
        }

        /* access modifiers changed from: protected */
        /*  JADX ERROR: NullPointerException in pass: CodeShrinkVisitor
            java.lang.NullPointerException
            */
        /* renamed from: b */
        public void onPostExecute(java.util.List<java.util.Map<java.lang.String, java.lang.String>> r19) {
            /*
                r18 = this;
                r1 = r18
                java.lang.String r2 = "غير محدد"
                java.lang.String r3 = "address"
                java.lang.String r4 = "server"
                java.lang.String r5 = "type"
                r6 = 1
                super.onPostExecute(r19)     // Catch:{ Exception -> 0x0179 }
                boolean r0 = r1.f5955a     // Catch:{ Exception -> 0x0179 }
                if (r0 == 0) goto L_0x001f
                yu r0 = defpackage.yu.this     // Catch:{ Exception -> 0x0179 }
                android.content.Context r0 = r0.f5938a     // Catch:{ Exception -> 0x0179 }
                java.lang.String r7 = r1.a     // Catch:{ Exception -> 0x0179 }
                android.widget.Toast r0 = android.widget.Toast.makeText(r0, r7, r6)     // Catch:{ Exception -> 0x0179 }
                r0.show()     // Catch:{ Exception -> 0x0179 }
            L_0x001f:
                if (r19 == 0) goto L_0x016f
                yu r0 = defpackage.yu.this     // Catch:{ Exception -> 0x0179 }
                androidx.recyclerview.widget.RecyclerView r0 = r0.f5942a     // Catch:{ Exception -> 0x0179 }
                androidx.recyclerview.widget.LinearLayoutManager r7 = new androidx.recyclerview.widget.LinearLayoutManager     // Catch:{ Exception -> 0x0179 }
                yu r8 = defpackage.yu.this     // Catch:{ Exception -> 0x0179 }
                android.content.Context r8 = r8.getContext()     // Catch:{ Exception -> 0x0179 }
                r9 = 0
                r7.<init>(r8, r6, r9)     // Catch:{ Exception -> 0x0179 }
                r0.setLayoutManager(r7)     // Catch:{ Exception -> 0x0179 }
                yu r0 = defpackage.yu.this     // Catch:{ Exception -> 0x0179 }
                androidx.recyclerview.widget.RecyclerView r0 = r0.f5942a     // Catch:{ Exception -> 0x0179 }
                androidx.recyclerview.widget.DefaultItemAnimator r7 = new androidx.recyclerview.widget.DefaultItemAnimator     // Catch:{ Exception -> 0x0179 }
                r7.<init>()     // Catch:{ Exception -> 0x0179 }
                r0.setItemAnimator(r7)     // Catch:{ Exception -> 0x0179 }
                yu r0 = defpackage.yu.this     // Catch:{ Exception -> 0x0179 }
                java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.BindingUser> r0 = r0.f5948a     // Catch:{ Exception -> 0x0179 }
                r0.clear()     // Catch:{ Exception -> 0x0179 }
                java.util.Iterator r7 = r19.iterator()     // Catch:{ Exception -> 0x0179 }
            L_0x004f:
                boolean r0 = r7.hasNext()     // Catch:{ Exception -> 0x0179 }
                if (r0 == 0) goto L_0x00df
                java.lang.Object r0 = r7.next()     // Catch:{ Exception -> 0x0179 }
                java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x0179 }
                r8 = r0
                java.lang.String r0 = "mLog"
                java.lang.String r9 = r8.toString()     // Catch:{ Exception -> 0x0179 }
                android.util.Log.d(r0, r9)     // Catch:{ Exception -> 0x0179 }
                java.lang.String r0 = ""
                java.lang.Object r9 = r8.get(r5)     // Catch:{ Exception -> 0x0179 }
                if (r9 == 0) goto L_0x0089
                java.lang.Object r9 = r8.get(r5)     // Catch:{ Exception -> 0x0179 }
                java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0179 }
                java.lang.String r10 = "blocked"
                boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x0179 }
                if (r9 == 0) goto L_0x0080
                java.lang.String r9 = "محظور"
                r0 = r9
                r15 = r0
                goto L_0x0091
            L_0x0080:
                java.lang.Object r9 = r8.get(r5)     // Catch:{ Exception -> 0x0179 }
                java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0179 }
                r0 = r9
                r15 = r0
                goto L_0x0091
            L_0x0089:
                java.lang.Object r9 = r8.get(r5)     // Catch:{ Exception -> 0x0179 }
                java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0179 }
                r0 = r9
                r15 = r0
            L_0x0091:
                java.lang.Object r0 = r8.get(r4)     // Catch:{ Exception -> 0x0179 }
                if (r0 != 0) goto L_0x009c
                java.lang.String r0 = "الكل"
                r16 = r0
                goto L_0x00a4
            L_0x009c:
                java.lang.Object r0 = r8.get(r4)     // Catch:{ Exception -> 0x0179 }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0179 }
                r16 = r0
            L_0x00a4:
                java.lang.Object r0 = r8.get(r3)     // Catch:{ Exception -> 0x00b3 }
                if (r0 != 0) goto L_0x00ac
                r0 = r2
                goto L_0x00b2
            L_0x00ac:
                java.lang.Object r0 = r8.get(r3)     // Catch:{ Exception -> 0x00b3 }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x00b3 }
            L_0x00b2:
                goto L_0x00b6
            L_0x00b3:
                r0 = move-exception
                r9 = r2
                r0 = r9
            L_0x00b6:
                com.blogspot.yemeninfo4it.mumsmobile_app.model.BindingUser r17 = new com.blogspot.yemeninfo4it.mumsmobile_app.model.BindingUser     // Catch:{ Exception -> 0x0179 }
                java.lang.String r9 = ".id"
                java.lang.Object r9 = r8.get(r9)     // Catch:{ Exception -> 0x0179 }
                r10 = r9
                java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x0179 }
                java.lang.String r9 = "mac-address"
                java.lang.Object r9 = r8.get(r9)     // Catch:{ Exception -> 0x0179 }
                r11 = r9
                java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x0179 }
                r9 = r17
                r12 = r0
                r13 = r16
                r14 = r15
                r9.<init>(r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0179 }
                r9 = r17
                yu r10 = defpackage.yu.this     // Catch:{ Exception -> 0x0179 }
                java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.BindingUser> r10 = r10.f5948a     // Catch:{ Exception -> 0x0179 }
                r10.add(r9)     // Catch:{ Exception -> 0x0179 }
                goto L_0x004f
            L_0x00df:
                yu r0 = defpackage.yu.this     // Catch:{ Exception -> 0x0179 }
                java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.BindingUser> r0 = r0.f5948a     // Catch:{ Exception -> 0x0179 }
                int r0 = r0.size()     // Catch:{ Exception -> 0x0179 }
                if (r0 <= 0) goto L_0x0166
                yu r0 = defpackage.yu.this     // Catch:{ Exception -> 0x0179 }
                android.widget.TextView r0 = r0.f5940a     // Catch:{ Exception -> 0x0179 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0179 }
                r2.<init>()     // Catch:{ Exception -> 0x0179 }
                java.lang.String r3 = "العدد: "
                r2.append(r3)     // Catch:{ Exception -> 0x0179 }
                java.util.List<java.util.Map<java.lang.String, java.lang.String>> r3 = r1.f5953a     // Catch:{ Exception -> 0x0179 }
                int r3 = r3.size()     // Catch:{ Exception -> 0x0179 }
                r2.append(r3)     // Catch:{ Exception -> 0x0179 }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0179 }
                r0.setText(r2)     // Catch:{ Exception -> 0x0179 }
                yu r0 = defpackage.yu.this     // Catch:{ Exception -> 0x0179 }
                tp0 r2 = new tp0     // Catch:{ Exception -> 0x0179 }
                android.content.Context r3 = r0.getContext()     // Catch:{ Exception -> 0x0179 }
                yu r4 = defpackage.yu.this     // Catch:{ Exception -> 0x0179 }
                java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.BindingUser> r4 = r4.f5948a     // Catch:{ Exception -> 0x0179 }
                r2.<init>(r3, r4)     // Catch:{ Exception -> 0x0179 }
                defpackage.tp0 unused = r0.f5949a = r2     // Catch:{ Exception -> 0x0179 }
                yu r0 = defpackage.yu.this     // Catch:{ Exception -> 0x0179 }
                kp0 r2 = new kp0     // Catch:{ Exception -> 0x0179 }
                yu r3 = defpackage.yu.this     // Catch:{ Exception -> 0x0179 }
                android.content.Context r3 = r3.getContext()     // Catch:{ Exception -> 0x0179 }
                yu r4 = defpackage.yu.this     // Catch:{ Exception -> 0x0179 }
                tp0 r4 = r4.f5949a     // Catch:{ Exception -> 0x0179 }
                r2.<init>(r3, r4)     // Catch:{ Exception -> 0x0179 }
                defpackage.d0 unused = r0.f5945a = r2     // Catch:{ Exception -> 0x0179 }
                yu r0 = defpackage.yu.this     // Catch:{ Exception -> 0x0179 }
                com.evrencoskun.tableview.TableView r0 = r0.f5944a     // Catch:{ Exception -> 0x0179 }
                yu r2 = defpackage.yu.this     // Catch:{ Exception -> 0x0179 }
                d0 r2 = r2.f5945a     // Catch:{ Exception -> 0x0179 }
                r0.setAdapter(r2)     // Catch:{ Exception -> 0x0179 }
                yu r0 = defpackage.yu.this     // Catch:{ Exception -> 0x0179 }
                d0 r0 = r0.f5945a     // Catch:{ Exception -> 0x0179 }
                yu r2 = defpackage.yu.this     // Catch:{ Exception -> 0x0179 }
                tp0 r2 = r2.f5949a     // Catch:{ Exception -> 0x0179 }
                java.util.List r2 = r2.c()     // Catch:{ Exception -> 0x0179 }
                yu r3 = defpackage.yu.this     // Catch:{ Exception -> 0x0179 }
                tp0 r3 = r3.f5949a     // Catch:{ Exception -> 0x0179 }
                java.util.List r3 = r3.f()     // Catch:{ Exception -> 0x0179 }
                yu r4 = defpackage.yu.this     // Catch:{ Exception -> 0x0179 }
                tp0 r4 = r4.f5949a     // Catch:{ Exception -> 0x0179 }
                java.util.List r4 = r4.a()     // Catch:{ Exception -> 0x0179 }
                r0.x(r2, r3, r4)     // Catch:{ Exception -> 0x0179 }
                goto L_0x016f
            L_0x0166:
                yu r0 = defpackage.yu.this     // Catch:{ Exception -> 0x0179 }
                android.widget.TextView r0 = r0.f5940a     // Catch:{ Exception -> 0x0179 }
                java.lang.String r2 = "لا توجد بيانات"
                r0.setText(r2)     // Catch:{ Exception -> 0x0179 }
            L_0x016f:
                yu r0 = defpackage.yu.this     // Catch:{ Exception -> 0x0179 }
                android.app.ProgressDialog r0 = r0.f5937a     // Catch:{ Exception -> 0x0179 }
                r0.dismiss()     // Catch:{ Exception -> 0x0179 }
                goto L_0x01a8
            L_0x0179:
                r0 = move-exception
                r0.printStackTrace()
                yu r2 = defpackage.yu.this
                android.app.ProgressDialog r2 = r2.f5937a
                r2.dismiss()
                yu r2 = defpackage.yu.this
                android.content.Context r2 = r2.getContext()
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = " حدثت مشكلة.."
                r3.append(r4)
                java.lang.String r4 = r0.getMessage()
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                android.widget.Toast r2 = android.widget.Toast.makeText(r2, r3, r6)
                r2.show()
            L_0x01a8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.yu.c.onPostExecute(java.util.List):void");
        }
    }

    /* renamed from: yu$d */
    class d extends AsyncTask<String, String, String> {
        List<Map<String, String>> a = null;

        d() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            yu.this.f5937a.setTitle("يرجى الانتظار");
            yu.this.f5937a.setMessage("جاري إلغاء الحظر ");
            yu.this.f5937a.setCancelable(false);
            yu.this.f5937a.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                if (!yu.this.f5946a.w()) {
                    return null;
                }
                j3 j3Var = yu.this.f5946a;
                j3Var.q("/ip/hotspot/ip-binding/remove .id=" + yu.this.c.toString() + "");
                return null;
            } catch (Exception e) {
                try {
                    Log.d("TagBinding", e.toString() + "error");
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
                yu.this.f5937a.dismiss();
                yu yuVar = yu.this;
                yuVar.f5948a.remove(yuVar.b);
                yu yuVar2 = yu.this;
                tp0 unused = yuVar2.f5949a = new tp0(yuVar2.getContext(), yu.this.f5948a);
                d0 unused2 = yu.this.f5945a = new kp0(yu.this.getContext(), yu.this.f5949a);
                yu.this.f5944a.setAdapter(yu.this.f5945a);
                yu.this.f5945a.x(yu.this.f5949a.c(), yu.this.f5949a.f(), yu.this.f5949a.a());
                yu.this.f5941a.dismiss();
            } catch (Exception e) {
                Context context = yu.this.getContext();
                Toast.makeText(context, e.getMessage() + " حدثت مشكله ", 1).show();
            }
        }
    }

    public void g(RecyclerView.ViewHolder cellView, int column, int row) {
    }

    public void c(RecyclerView.ViewHolder cellView, int column, int row) {
        if (cellView != null) {
            BindingUser c2 = this.f5948a.get(row);
            this.c = c2.getId();
            this.f5952b = c2.getMac_address();
            this.b = row;
            p();
        }
    }

    public void d(RecyclerView.ViewHolder columnHeaderView, int column) {
    }

    public void b(RecyclerView.ViewHolder columnHeaderView, int column) {
    }

    public void f(RecyclerView.ViewHolder rowHeaderView, int row) {
    }

    public void a(RecyclerView.ViewHolder rowHeaderView, int row) {
    }

    public void p() {
        try {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
            View myView = getLayoutInflater().inflate(R.layout.iobinding_pop, (ViewGroup) null);
            dialogBuilder.setView(myView);
            AlertDialog create = dialogBuilder.create();
            this.f5941a = create;
            create.show();
            ((TextView) myView.findViewById(R.id.mactxt)).setText("(" + this.f5952b + ")");
            ((TextView) myView.findViewById(R.id.romve_from_binding)).setOnClickListener(new b());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: yu$b */
    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View v) {
            try {
                yu.this.f5951a = new d();
                yu.this.f5951a.execute(new String[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
