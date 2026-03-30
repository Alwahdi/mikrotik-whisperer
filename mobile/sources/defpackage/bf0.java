package defpackage;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.ConnectData;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Interface;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards;
import com.blogspot.yemeninfo4it.mumsmobile_app.service.MyLocation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.cookie.ClientCookie;

/* renamed from: bf0  reason: default package */
public class bf0 extends Fragment {
    public static final String b = (MyLocation.class.getName() + "GetResource");
    private ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    Context f219a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public RecyclerView f220a;

    /* renamed from: a  reason: collision with other field name */
    a f221a;

    /* renamed from: a  reason: collision with other field name */
    bu f222a;

    /* renamed from: a  reason: collision with other field name */
    ConnectData f223a;

    /* renamed from: a  reason: collision with other field name */
    j3 f224a;

    /* renamed from: a  reason: collision with other field name */
    final String f225a = "mLog";

    /* renamed from: a  reason: collision with other field name */
    ArrayList<Interface> f226a;

    /* renamed from: a  reason: collision with other field name */
    ue f227a;

    /* renamed from: b  reason: collision with other field name */
    ArrayList<UsermanagerCards> f228b;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.router_info, container, false);
        try {
            this.f219a = getContext();
            this.f224a = qb0.d();
            this.f223a = new ConnectData();
            this.f220a = (RecyclerView) view.findViewById(R.id.recycler5);
            this.f228b = new ArrayList<>();
            this.f226a = new ArrayList<>();
            this.f227a = new ue(this.f219a);
            ProgressDialog progressDialog = new ProgressDialog(this.f219a);
            this.a = progressDialog;
            progressDialog.setProgressStyle(1);
            a aVar = new a();
            this.f221a = aVar;
            aVar.execute(new String[0]);
        } catch (Exception e) {
            Toast.makeText(this.f219a, e.getMessage(), 0).show();
        }
        return view;
    }

    /* renamed from: bf0$a */
    class a extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f229a = null;
        List<Map<String, String>> b = null;

        a() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                Thread.sleep(1000);
                try {
                    if (!bf0.this.f224a.w()) {
                        return null;
                    }
                    this.b = bf0.this.f224a.q("/interface/print where default-name=ether1 return mac-address");
                    this.f229a = bf0.this.f224a.q("/system/resource/print return free-memory,uptime,total-memory,board-name,version");
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            try {
                List<Map<String, String>> list = this.b;
                if (list != null) {
                    qb0.f4800a = (String) list.get(0).get("mac-address");
                }
                if (this.f229a != null) {
                    bf0.this.f220a.setLayoutManager(new LinearLayoutManager(bf0.this.f219a));
                    bf0.this.f220a.setItemAnimator(new DefaultItemAnimator());
                    bf0.this.f226a.clear();
                    for (Map<String, String> res : this.f229a) {
                        Log.d("mLog", res.toString());
                        bf0.this.f226a.add(new Interface(res.get("free-memory"), res.get("uptime"), res.get("total-memory"), res.get("total-memory"), res.get("board-name"), res.get(ClientCookie.VERSION_ATTR)));
                    }
                    bf0 bf0 = bf0.this;
                    bf0.f222a = new bu(bf0.getActivity(), bf0.this.f226a);
                    bf0.this.f222a.notifyDataSetChanged();
                    bf0.this.f220a.setAdapter(bf0.this.f222a);
                    bf0.this.k((String) this.f229a.get(0).get("uptime"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public void k(String active_count) {
        if (active_count != null) {
            Intent intent = new Intent(b);
            intent.putExtra("uptime", active_count);
            LocalBroadcastManager.getInstance(this.f219a).sendBroadcast(intent);
        }
    }
}
