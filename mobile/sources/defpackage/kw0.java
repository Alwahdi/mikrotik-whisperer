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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.ConnectData;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Neighbors;
import com.evrencoskun.tableview.TableView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.protocol.HTTP;

/* renamed from: kw0  reason: default package */
public class kw0 extends Fragment implements pr {
    /* access modifiers changed from: private */
    public ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    Button f4155a;

    /* renamed from: a  reason: collision with other field name */
    LinearLayout f4156a;

    /* renamed from: a  reason: collision with other field name */
    TextView f4157a;

    /* renamed from: a  reason: collision with other field name */
    ConnectData f4158a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public TableView f4159a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public d0 f4160a;

    /* renamed from: a  reason: collision with other field name */
    j3 f4161a;

    /* renamed from: a  reason: collision with other field name */
    final String f4162a = "mLog";

    /* renamed from: a  reason: collision with other field name */
    ArrayList<Neighbors> f4163a;

    /* renamed from: a  reason: collision with other field name */
    b f4164a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public up0 f4165a;
    LinearLayout b;

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            this.a = new ProgressDialog(getContext());
            this.f4158a = new ConnectData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.neighbors_layout, container, false);
        try {
            this.f4161a = qb0.d();
            this.f4159a = (TableView) view.findViewById(R.id.tableview);
            this.f4163a = new ArrayList<>();
            this.f4155a = (Button) view.findViewById(R.id.neighborbtn);
            this.f4156a = (LinearLayout) view.findViewById(R.id.noresults);
            this.b = (LinearLayout) view.findViewById(R.id.main_layout);
            this.f4157a = (TextView) view.findViewById(R.id.count_nig);
            this.f4155a.setOnClickListener(new a());
            this.f4159a.setTableViewListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    /* renamed from: kw0$a */
    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View v) {
            kw0.this.f4164a = new b();
            kw0.this.f4164a.execute(new String[0]);
        }
    }

    /* renamed from: kw0$b */
    class b extends AsyncTask<String, String, String> {
        List<Map<String, String>> a = null;

        b() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            kw0.this.a.setTitle("يرجى الانتظار");
            kw0.this.a.setMessage("يتم جلب البيانات");
            kw0.this.a.setCancelable(false);
            kw0.this.a.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                if (!kw0.this.f4161a.w()) {
                    return null;
                }
                this.a = kw0.this.f4161a.q("/ip/neighbor/print return identity,interface,mac-address,address4");
                return null;
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
            try {
                super.onPostExecute(result);
                kw0.this.f4163a.clear();
                List<Map<String, String>> list = this.a;
                if (list != null) {
                    for (Map<String, String> res : list) {
                        Log.d("mLog", res.toString());
                        kw0.this.f4163a.add(new Neighbors(res.get(HTTP.IDENTITY_CODING), res.get("interface"), res.get("mac-address"), res.get("address4")));
                    }
                    if (this.a.size() < 1) {
                        kw0.this.f4156a.setVisibility(0);
                        kw0.this.b.setVisibility(8);
                    } else {
                        kw0.this.b.setVisibility(0);
                        kw0.this.f4156a.setVisibility(8);
                        TextView textView = kw0.this.f4157a;
                        textView.setText("العدد: " + String.valueOf(this.a.size()));
                    }
                    kw0 kw0 = kw0.this;
                    up0 unused = kw0.f4165a = new up0(kw0.getContext(), kw0.this.f4163a);
                    d0 unused2 = kw0.this.f4160a = new lp0(kw0.this.getContext(), kw0.this.f4165a);
                    kw0.this.f4159a.setAdapter(kw0.this.f4160a);
                    kw0.this.f4160a.x(kw0.this.f4165a.c(), kw0.this.f4165a.f(), kw0.this.f4165a.a());
                }
                kw0.this.a.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
                kw0.this.a.dismiss();
                Context context = kw0.this.getContext();
                Toast.makeText(context, " حدثت مشكلة.. تأكد من اتصالك بالشبكة " + e.getMessage(), 1).show();
            }
        }
    }

    public void g(RecyclerView.ViewHolder cellView, int column, int row) {
        qb0.a = row;
    }

    public void c(RecyclerView.ViewHolder cellView, int column, int row) {
        if (cellView != null) {
            Neighbors c = this.f4163a.get(row);
            Context context = getContext();
            Toast.makeText(context, c.getName() + " - " + c.getIpaddress(), 0).show();
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
