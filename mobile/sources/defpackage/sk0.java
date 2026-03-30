package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.SessionNew;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/* renamed from: sk0  reason: default package */
public class sk0 extends ArrayAdapter<SessionNew> {
    Context a;

    /* renamed from: a  reason: collision with other field name */
    ArrayList<SessionNew> f4999a;

    public sk0(Context context, ArrayList<SessionNew> objects) {
        super(context, R.layout.sesstion_row, objects);
        this.f4999a = objects;
        this.a = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View convertView2;
        a holder;
        String formatted;
        int i = position;
        try {
            SessionNew customer = (SessionNew) getItem(position);
            ((DecimalFormat) NumberFormat.getNumberInstance(Locale.ENGLISH)).applyPattern("#.##");
            if (convertView == null) {
                convertView2 = LayoutInflater.from(getContext()).inflate(R.layout.sesstion_row, (ViewGroup) null);
                try {
                    holder = new a();
                    holder.a = i;
                    holder.f5002a = (TextView) convertView2.findViewById(R.id.uname);
                    holder.b = (TextView) convertView2.findViewById(R.id.st_form);
                    holder.c = (TextView) convertView2.findViewById(R.id.uptime);
                    holder.d = (TextView) convertView2.findViewById(R.id.download);
                    holder.e = (TextView) convertView2.findViewById(R.id.upload);
                    holder.f5000a = (CheckBox) convertView2.findViewById(R.id.chk_selected);
                    holder.f5001a = (LinearLayout) convertView2.findViewById(R.id.title);
                    convertView2.setTag(holder);
                } catch (Exception e) {
                    e = e;
                }
            } else {
                holder = (a) convertView.getTag();
                convertView2 = convertView;
            }
            if (i < 1) {
                holder.f5001a.setVisibility(0);
            } else {
                holder.f5001a.setVisibility(8);
            }
            String formatted2 = "0";
            if (customer.getDownload() != null) {
                formatted = qb0.e(customer.getDownload());
            } else {
                formatted = formatted2;
            }
            if (customer.getUpload() != null) {
                formatted2 = qb0.e(customer.getUpload());
            }
            holder.f5002a.setText(customer.getName());
            holder.b.setText(customer.getSt_from());
            holder.c.setText(customer.getUptime());
            holder.d.setText(formatted);
            holder.e.setText(formatted2);
        } catch (Exception e2) {
            e = e2;
            convertView2 = convertView;
            e.printStackTrace();
            Toast.makeText(this.a, e.getMessage(), 0).show();
            return convertView2;
        }
        return convertView2;
    }

    /* renamed from: sk0$a */
    public class a {
        int a;

        /* renamed from: a  reason: collision with other field name */
        CheckBox f5000a;

        /* renamed from: a  reason: collision with other field name */
        LinearLayout f5001a;

        /* renamed from: a  reason: collision with other field name */
        TextView f5002a;
        TextView b;
        TextView c;
        TextView d;
        TextView e;

        public a() {
        }
    }
}
