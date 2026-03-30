package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Interface;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/* renamed from: bu  reason: default package */
public class bu extends RecyclerView.Adapter<a> {
    Context a;

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<Interface> f252a;

    public bu(Context context, ArrayList<Interface> home_modelArrayList) {
        this.a = context;
        this.f252a = home_modelArrayList;
    }

    /* renamed from: b */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        return new a(LayoutInflater.from(parent.getContext()).inflate(R.layout.all_home, parent, false));
    }

    /* renamed from: a */
    public void onBindViewHolder(a holder, int position) {
        String formatted;
        String formatted2;
        a aVar = holder;
        int i = position;
        try {
            DecimalFormat df = (DecimalFormat) NumberFormat.getNumberInstance(Locale.ENGLISH);
            df.applyPattern("#.##");
            if (this.f252a.get(i).getfree_memory() != null) {
                double aa = Double.parseDouble(this.f252a.get(i).getfree_memory()) / 1048576.0d;
                formatted = df.format(aa) + " ميجا";
                if (aa > 1024.0d) {
                    formatted = df.format(aa / 1024.0d) + "جيجا";
                }
            } else {
                formatted = "0";
            }
            if (this.f252a.get(i).getTotalMemory() != null) {
                double aa2 = Double.parseDouble(this.f252a.get(i).getTotalMemory()) / 1048576.0d;
                formatted2 = df.format(aa2) + " ميجا";
                if (aa2 > 1024.0d) {
                    formatted2 = df.format(aa2 / 1024.0d) + "جيجا";
                }
            } else {
                formatted2 = "0";
            }
            aVar.d.setText(formatted);
            aVar.c.setText(formatted2);
            aVar.b.setText(this.f252a.get(i).getuptime());
            aVar.a.setText(this.f252a.get(i).getboard_name());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getItemCount() {
        return this.f252a.size();
    }

    /* renamed from: bu$a */
    public class a extends RecyclerView.ViewHolder {
        TextView a;
        TextView b;
        TextView c;
        TextView d;

        public a(View itemView) {
            super(itemView);
            this.a = (TextView) itemView.findViewById(R.id.router_name);
            this.b = (TextView) itemView.findViewById(R.id.uptime_txt);
            this.c = (TextView) itemView.findViewById(R.id.used_memory);
            this.d = (TextView) itemView.findViewById(R.id.unused_memory);
        }
    }
}
