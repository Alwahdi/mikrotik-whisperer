package com.blogspot.yemeninfo4it.mumsmobile_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.MikrotikLoginActivity;
import java.util.ArrayList;

public class DiscoverAdapter extends RecyclerView.Adapter<b> {
    Context a;

    /* renamed from: a  reason: collision with other field name */
    ArrayList<og> f368a;

    public native String mdMM();

    static {
        System.loadLibrary("native-lib");
    }

    public DiscoverAdapter(ArrayList<og> list, Context context) {
        this.f368a = list;
        this.a = context;
    }

    /* renamed from: a */
    public void onBindViewHolder(b discoverViewHolder, int position) {
        og discoverObjeto2 = this.f368a.get(position);
        discoverViewHolder.c.setText(discoverObjeto2.e());
        discoverViewHolder.b.setText(discoverObjeto2.f());
        discoverViewHolder.d.setText(discoverObjeto2.g());
        discoverViewHolder.f370a.setText(discoverObjeto2.d());
        discoverViewHolder.a.setOnClickListener(new a(discoverObjeto2));
    }

    class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ og f369a;

        a(og ogVar) {
            this.f369a = ogVar;
        }

        public void onClick(View v) {
            qb0.f4813c = true;
            Intent intent = new Intent(DiscoverAdapter.this.a, MikrotikLoginActivity.class);
            intent.putExtra("txtIp", this.f369a.f());
            intent.putExtra(DiscoverAdapter.this.mdMM(), true);
            intent.setFlags(268468224);
            DiscoverAdapter.this.a.startActivity(intent);
        }
    }

    /* renamed from: b */
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        return new b(LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta_discover, parent, false));
    }

    public int getItemCount() {
        return this.f368a.size();
    }

    public class b extends RecyclerView.ViewHolder {
        public LinearLayout a;

        /* renamed from: a  reason: collision with other field name */
        public TextView f370a;
        public TextView b;
        public TextView c;
        public TextView d;

        public b(View view) {
            super(view);
            this.c = (TextView) view.findViewById(R.id.txtIdentityDiscover);
            this.b = (TextView) view.findViewById(R.id.txtIPDiscover);
            this.d = (TextView) view.findViewById(R.id.txtMacDiscover);
            this.f370a = (TextView) view.findViewById(R.id.txtBoardNameDiscover);
            this.a = (LinearLayout) view.findViewById(R.id.l_tarjeta_discover);
        }
    }
}
