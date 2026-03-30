package com.blogspot.yemeninfo4it.mumsmobile_app.discover;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.MikrotikLoginActivity;
import java.util.ArrayList;

public class DiscoverAdapter extends RecyclerView.Adapter<a> {
    static Activity a;

    /* renamed from: a  reason: collision with other field name */
    private static ArrayList<pg> f1272a;

    /* renamed from: a  reason: collision with other field name */
    final int f1273a = Build.VERSION.SDK_INT;

    public native String mdMM();

    static {
        System.loadLibrary("native-lib");
    }

    /* renamed from: a */
    public void onBindViewHolder(a holder, int position) {
        pg cO = f1272a.get(position);
        holder.c.setText(cO.e());
        holder.b.setText(cO.f());
        holder.d.setText(cO.g());
        holder.f1274a.setText(cO.d());
    }

    /* renamed from: b */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        return new a(LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta_discover, parent, false));
    }

    public int getItemCount() {
        return f1272a.size();
    }

    public class a extends RecyclerView.ViewHolder implements View.OnClickListener {
        public LinearLayout a;

        /* renamed from: a  reason: collision with other field name */
        public TextView f1274a;
        public TextView b;
        public TextView c;
        public TextView d;

        public a(View v) {
            super(v);
            this.c = (TextView) v.findViewById(R.id.txtIdentityDiscover);
            this.b = (TextView) v.findViewById(R.id.txtIPDiscover);
            this.d = (TextView) v.findViewById(R.id.txtMacDiscover);
            this.f1274a = (TextView) v.findViewById(R.id.txtBoardNameDiscover);
            LinearLayout linearLayout = (LinearLayout) v.findViewById(R.id.l_tarjeta_discover);
            this.a = linearLayout;
            linearLayout.setOnClickListener(this);
        }

        public void onClick(View v) {
            Intent i = new Intent(DiscoverAdapter.a, MikrotikLoginActivity.class);
            i.putExtra("txtIp", this.b.getText());
            i.putExtra(DiscoverAdapter.this.mdMM(), true);
            i.setFlags(268468224);
            DiscoverAdapter.a.startActivity(i);
        }
    }

    public DiscoverAdapter(ArrayList<pg> discoverObjeto2, Activity contexto2) {
        f1272a = discoverObjeto2;
        a = contexto2;
    }
}
