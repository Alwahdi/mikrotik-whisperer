package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.MikrotikLoginActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.LoginData;
import java.util.ArrayList;

/* renamed from: az  reason: default package */
public class az extends RecyclerView.Adapter<a> {
    Context a;

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<LoginData> f126a;

    public az(Context context, ArrayList<LoginData> home_modelArrayList) {
        this.a = context;
        this.f126a = home_modelArrayList;
    }

    /* renamed from: d */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        return new a(LayoutInflater.from(parent.getContext()).inflate(R.layout.logindata_list, parent, false));
    }

    /* renamed from: c */
    public void onBindViewHolder(a holder, int position) {
        try {
            holder.f127a.setText(this.f126a.get(position).getUsername());
            holder.c.setText(this.f126a.get(position).getPassword());
            holder.b.setText(this.f126a.get(position).getIpaddress());
            holder.d.setText(this.f126a.get(position).getPort());
            holder.e.setText(this.f126a.get(position).getDesc());
            holder.a.setOnClickListener(new zy(this, position));
        } catch (Exception e) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(int position, View v) {
        try {
            MikrotikLoginActivity.a.setText(this.f126a.get(position).getIpaddress());
            MikrotikLoginActivity.b.setText(this.f126a.get(position).getUsername());
            MikrotikLoginActivity.c.setText(this.f126a.get(position).getPassword());
            MikrotikLoginActivity.d.setText(this.f126a.get(position).getPort());
            if (MikrotikLoginActivity.f806a.K() == 3) {
                MikrotikLoginActivity.f806a.m0(4);
            }
        } catch (Exception e) {
        }
    }

    public int getItemCount() {
        return this.f126a.size();
    }

    /* renamed from: az$a */
    public class a extends RecyclerView.ViewHolder {
        LinearLayout a;

        /* renamed from: a  reason: collision with other field name */
        TextView f127a;
        TextView b;
        TextView c;
        TextView d;
        TextView e;

        public a(View itemView) {
            super(itemView);
            this.f127a = (TextView) itemView.findViewById(R.id.name);
            this.c = (TextView) itemView.findViewById(R.id.password);
            this.b = (TextView) itemView.findViewById(R.id.ipaddress);
            this.d = (TextView) itemView.findViewById(R.id.port);
            this.e = (TextView) itemView.findViewById(R.id.desc);
            this.a = (LinearLayout) itemView.findViewById(R.id.data_layout);
        }
    }
}
