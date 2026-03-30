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
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/* renamed from: je  reason: default package */
public class je extends ArrayAdapter<UsermanagerCards> {
    Context a;

    /* renamed from: a  reason: collision with other field name */
    ArrayList<UsermanagerCards> f4053a;

    public je(Context context, ArrayList<UsermanagerCards> objects) {
        super(context, R.layout.dele_umanager_row, objects);
        this.f4053a = objects;
        this.a = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View convertView2;
        b holder;
        String formatted;
        String formatted2;
        int i = position;
        try {
            UsermanagerCards customer = (UsermanagerCards) getItem(position);
            DecimalFormat df = (DecimalFormat) NumberFormat.getNumberInstance(Locale.ENGLISH);
            df.applyPattern("#.##");
            if (convertView == null) {
                convertView2 = LayoutInflater.from(getContext()).inflate(R.layout.dele_umanager_row, (ViewGroup) null);
                try {
                    holder = new b();
                    holder.a = i;
                    holder.f4057a = (TextView) convertView2.findViewById(R.id.uname);
                    holder.b = (TextView) convertView2.findViewById(R.id.profile);
                    holder.c = (TextView) convertView2.findViewById(R.id.uptime);
                    holder.d = (TextView) convertView2.findViewById(R.id.download);
                    holder.e = (TextView) convertView2.findViewById(R.id.upload);
                    holder.f4055a = (CheckBox) convertView2.findViewById(R.id.chk_selected);
                    holder.f4056a = (LinearLayout) convertView2.findViewById(R.id.title);
                    convertView2.setTag(holder);
                } catch (Exception e) {
                    e = e;
                }
            } else {
                holder = (b) convertView.getTag();
                convertView2 = convertView;
            }
            if (i < 1) {
                holder.f4056a.setVisibility(0);
            } else {
                holder.f4056a.setVisibility(8);
            }
            if (customer.getDownload_used() != null) {
                double a2 = Double.parseDouble(customer.getDownload_used()) / 1048576.0d;
                formatted = df.format(a2) + " ميجا";
                if (a2 > 1024.0d) {
                    formatted = df.format(a2 / 1024.0d) + "جيجا";
                }
            } else {
                formatted = "0";
            }
            if (customer.getUpload_used() != null) {
                double a22 = Double.parseDouble(customer.getUpload_used()) / 1048576.0d;
                formatted2 = df.format(a22) + " ميجا";
                if (a22 > 1024.0d) {
                    formatted2 = df.format(a22 / 1024.0d) + " جيجا";
                }
            } else {
                formatted2 = "0";
            }
            holder.f4057a.setText(customer.getUname());
            holder.b.setText(customer.getProfilename());
            holder.c.setText(customer.getUptime_used());
            holder.d.setText(formatted);
            holder.e.setText(formatted2);
            holder.f4055a.setChecked(customer.isSelected());
            holder.f4055a.setTag(this.f4053a.get(i));
            holder.f4055a.setOnClickListener(new a(i));
        } catch (Exception e2) {
            e = e2;
            convertView2 = convertView;
            e.printStackTrace();
            Toast.makeText(this.a, e.getMessage(), 0).show();
            return convertView2;
        }
        return convertView2;
    }

    /* renamed from: je$a */
    class a implements View.OnClickListener {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        public void onClick(View v) {
            CheckBox cb = (CheckBox) v;
            ((UsermanagerCards) cb.getTag()).setSelected(cb.isChecked());
            je.this.f4053a.get(this.a).setSelected(cb.isChecked());
        }
    }

    /* renamed from: je$b */
    public class b {
        int a;

        /* renamed from: a  reason: collision with other field name */
        CheckBox f4055a;

        /* renamed from: a  reason: collision with other field name */
        LinearLayout f4056a;

        /* renamed from: a  reason: collision with other field name */
        TextView f4057a;
        TextView b;
        TextView c;
        TextView d;
        TextView e;

        public b() {
        }
    }
}
