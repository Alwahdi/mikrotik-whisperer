package defpackage;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.ActiveUser;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.ConnectData;
import com.evrencoskun.tableview.TableView;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: j0  reason: default package */
public class j0 extends Fragment implements pr {
    public int a = 0;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f4003a;

    /* renamed from: a  reason: collision with other field name */
    Button f4004a;

    /* renamed from: a  reason: collision with other field name */
    TextView f4005a;

    /* renamed from: a  reason: collision with other field name */
    ConnectData f4006a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public TableView f4007a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public d0 f4008a;

    /* renamed from: a  reason: collision with other field name */
    a f4009a;

    /* renamed from: a  reason: collision with other field name */
    b f4010a;

    /* renamed from: a  reason: collision with other field name */
    c f4011a;

    /* renamed from: a  reason: collision with other field name */
    j3 f4012a;

    /* renamed from: a  reason: collision with other field name */
    final String f4013a = "mLog";

    /* renamed from: a  reason: collision with other field name */
    ArrayList<ActiveUser> f4014a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public sp0 f4015a;
    public int b = 0;

    /* renamed from: b  reason: collision with other field name */
    public String f4016b = "";
    public String c = "";
    public String d = "";

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f4006a = new ConnectData();
        this.f4003a = new ProgressDialog(getContext());
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.active_table_recycler, container, false);
        try {
            this.f4012a = qb0.d();
            this.f4014a = new ArrayList<>();
            this.f4004a = (Button) view.findViewById(R.id.activebtn);
            this.f4005a = (TextView) view.findViewById(R.id.activeacount);
            this.f4007a = (TableView) view.findViewById(R.id.tableview);
            this.f4004a.setOnClickListener(new i0(this));
            this.f4007a.setTableViewListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p(View v) {
        b bVar = new b();
        this.f4010a = bVar;
        bVar.execute(new String[0]);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        try {
            AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) menuInfo;
            if (this.a >= 0) {
                menu.setHeaderTitle(" رقم الكرت " + this.f4016b);
            } else {
                menu.setHeaderTitle("الرجاء تحديد السجل");
            }
            String[] menuItems = getResources().getStringArray(R.array.activelistoption);
            for (int i = 0; i < menuItems.length; i++) {
                menu.add(0, i, i, menuItems[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        try {
            AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            String str = getResources().getStringArray(R.array.activelistoption)[item.getItemId()];
            switch (item.getItemId()) {
                case 0:
                    if (this.a >= 0) {
                        c cVar = new c();
                        this.f4011a = cVar;
                        cVar.execute(new String[0]);
                        return true;
                    }
                    Snackbar.k0(this.f4007a, "الرجاء تحديد السجل", -1).V();
                    return true;
                case 1:
                    if (this.a >= 0) {
                        a aVar = new a();
                        this.f4009a = aVar;
                        aVar.execute(new String[0]);
                        return true;
                    }
                    Snackbar.k0(this.f4007a, "الرجاء تحديد السجل", -1).V();
                    return true;
                default:
                    return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
        e.printStackTrace();
        return true;
    }

    /* renamed from: j0$b */
    class b extends AsyncTask<String, String, List<Map<String, String>>> {

        /* renamed from: a  reason: collision with other field name */
        String f4019a = "";

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f4020a = null;

        /* renamed from: a  reason: collision with other field name */
        boolean f4021a = false;

        b() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            this.f4021a = false;
            j0.this.f4003a.setTitle("يرجى الانتظار");
            j0.this.f4003a.setMessage("يتم جلب المستخدمين النشطين");
            j0.this.f4003a.setCancelable(false);
            j0.this.f4003a.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public List<Map<String, String>> doInBackground(String... params) {
            try {
                j0.this.f4012a.J(15000);
                if (!j0.this.f4012a.w()) {
                    return null;
                }
                this.f4020a = j0.this.f4012a.q("/ip/hotspot/active/print return .id,user,uptime,address,bytes-in,bytes-out,session-time-left,mac-address");
                return this.f4020a;
            } catch (Exception e) {
                try {
                    this.f4019a = e.getMessage();
                    this.f4021a = true;
                } catch (Exception e2) {
                    this.f4019a = e2.getMessage();
                    this.f4021a = true;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(List<Map<String, String>> result) {
            j0.this.f4003a.dismiss();
            try {
                if (this.f4021a) {
                    Toast.makeText(j0.this.getContext(), this.f4019a, 0).show();
                } else if (result != null) {
                    j0.this.f4014a.clear();
                    for (Map<String, String> res : result) {
                        j0.this.f4014a.add(new ActiveUser(res.get(".id"), res.get("user"), res.get("uptime"), res.get("address"), res.get("bytes-in"), res.get("bytes-out"), res.get("session-time-left"), res.get("mac-address")));
                    }
                    TextView textView = j0.this.f4005a;
                    textView.setText("العدد: " + j0.this.f4014a.size());
                    j0 j0Var = j0.this;
                    qb0.f4803a = j0Var.f4014a;
                    sp0 unused = j0Var.f4015a = new sp0(j0Var.getContext(), j0.this.f4014a);
                    d0 unused2 = j0.this.f4008a = new jp0(j0.this.getContext(), j0.this.f4015a);
                    j0.this.f4007a.setAdapter(j0.this.f4008a);
                    j0.this.f4008a.x(j0.this.f4015a.c(), j0.this.f4015a.f(), j0.this.f4015a.a());
                    cancel(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(j0.this.getContext(), "حدثت مشكلة.. تأكد من اتصالك بالشبكة او قد يكون اتصالك ضعيف", 0).show();
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            try {
                if (this.f4021a) {
                    Toast.makeText(j0.this.getContext(), this.f4019a, 0).show();
                } else if (this.f4020a != null) {
                    j0.this.f4014a.clear();
                    for (Map<String, String> res : this.f4020a) {
                        Log.d("mLog", res.toString());
                        j0.this.f4014a.add(new ActiveUser(res.get(".id"), res.get("user"), res.get("uptime"), res.get("address"), res.get("bytes-in"), res.get("bytes-out"), res.get("session-time-left"), res.get("mac-address")));
                    }
                    TextView textView = j0.this.f4005a;
                    textView.setText("العدد: " + this.f4020a.size());
                    j0 j0Var = j0.this;
                    qb0.f4803a = j0Var.f4014a;
                    sp0 unused = j0Var.f4015a = new sp0(j0Var.getContext(), j0.this.f4014a);
                    d0 unused2 = j0.this.f4008a = new jp0(j0.this.getContext(), j0.this.f4015a);
                    j0.this.f4007a.setAdapter(j0.this.f4008a);
                    j0.this.f4008a.x(j0.this.f4015a.c(), j0.this.f4015a.f(), j0.this.f4015a.a());
                }
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(j0.this.getContext(), "حدثت مشكلة.. تأكد من اتصالك بالشبكة او قد يكون اتصالك ضعيف", 0).show();
            }
        }
    }

    /* renamed from: j0$c */
    class c extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        String f4022a = "";

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f4023a = null;

        /* renamed from: a  reason: collision with other field name */
        boolean f4024a = false;

        c() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            this.f4024a = false;
            j0.this.f4003a.setTitle("يرجى الانتظار");
            j0.this.f4003a.setMessage("جاري حذف المستخدم من قائمة الاكتيف");
            j0.this.f4003a.setCancelable(false);
            j0.this.f4003a.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                j0.this.f4012a.J(15000);
                if (!j0.this.f4012a.w()) {
                    return null;
                }
                j3 j3Var = j0.this.f4012a;
                j3Var.q("/ip/hotspot/active/remove .id=" + j0.this.c.toString() + "");
                return null;
            } catch (Exception e) {
                try {
                    this.f4022a = e.getMessage();
                    this.f4024a = true;
                    return null;
                } catch (Exception e2) {
                    this.f4022a = e2.getMessage();
                    this.f4024a = true;
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            try {
                if (this.f4024a) {
                    Toast.makeText(j0.this.getContext(), this.f4022a, 0).show();
                    return;
                }
                j0.this.f4003a.dismiss();
                j0 j0Var = j0.this;
                j0Var.f4014a.remove(j0Var.b);
                j0 j0Var2 = j0.this;
                sp0 unused = j0Var2.f4015a = new sp0(j0Var2.getContext(), j0.this.f4014a);
                d0 unused2 = j0.this.f4008a = new jp0(j0.this.getContext(), j0.this.f4015a);
                j0.this.f4007a.setAdapter(j0.this.f4008a);
                j0.this.f4008a.x(j0.this.f4015a.c(), j0.this.f4015a.f(), j0.this.f4015a.a());
            } catch (Exception e) {
                Toast.makeText(j0.this.getContext(), e.getMessage(), 0).show();
            }
        }
    }

    /* renamed from: j0$a */
    class a extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        String f4017a = "";

        /* renamed from: a  reason: collision with other field name */
        boolean f4018a = false;

        a() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            this.f4018a = false;
            j0.this.f4003a.setTitle("يرجى الانتظار");
            j0.this.f4003a.setMessage("جاري تنفيذ العملية");
            j0.this.f4003a.setCancelable(false);
            j0.this.f4003a.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                j0.this.f4012a.J(15000);
                if (!j0.this.f4012a.w()) {
                    return null;
                }
                j3 j3Var = j0.this.f4012a;
                j3Var.q("/ip/hotspot/ip-binding/add type=blocked server=all mac-address=" + j0.this.d + "");
                return null;
            } catch (Exception e) {
                try {
                    this.f4017a = e.getMessage();
                    this.f4018a = true;
                    return null;
                } catch (Exception e2) {
                    this.f4017a = e2.getMessage();
                    this.f4018a = true;
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            try {
                if (this.f4018a) {
                    Toast.makeText(j0.this.getContext(), this.f4017a, 0).show();
                    return;
                }
                j0.this.f4003a.dismiss();
                j0 j0Var = j0.this;
                j0Var.f4014a.remove(j0Var.b);
                j0 j0Var2 = j0.this;
                sp0 unused = j0Var2.f4015a = new sp0(j0Var2.getContext(), j0.this.f4014a);
                d0 unused2 = j0.this.f4008a = new jp0(j0.this.getContext(), j0.this.f4015a);
                j0.this.f4007a.setAdapter(j0.this.f4008a);
                j0.this.f4008a.x(j0.this.f4015a.c(), j0.this.f4015a.f(), j0.this.f4015a.a());
                Toast.makeText(j0.this.getContext(), "تم الحظر", 0).show();
            } catch (Exception e) {
                Toast.makeText(j0.this.getContext(), e.getMessage(), 0).show();
            }
        }
    }

    public void g(RecyclerView.ViewHolder cellView, int column, int row) {
        try {
            qb0.a = row;
        } catch (Exception e) {
        }
    }

    public void c(RecyclerView.ViewHolder cellView, int column, int row) {
        try {
            qb0.a = row;
            if (cellView != null) {
                ActiveUser c2 = this.f4014a.get(row);
                this.f4016b = c2.getName();
                this.c = c2.getId();
                this.d = c2.getMac_address();
                this.b = row;
                registerForContextMenu(this.f4007a);
                getActivity().openContextMenu(this.f4007a);
            }
        } catch (Exception e) {
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
}
