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
import com.blogspot.yemeninfo4it.mumsmobile_app.model.DeleteUser;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/* renamed from: zf  reason: default package */
public class zf extends ArrayAdapter<DeleteUser> {
    Context a;

    /* renamed from: a  reason: collision with other field name */
    ArrayList<DeleteUser> f6033a;

    /* renamed from: zf$b */
    public static class b {
        int a;

        /* renamed from: a  reason: collision with other field name */
        CheckBox f6035a;

        /* renamed from: a  reason: collision with other field name */
        LinearLayout f6036a;

        /* renamed from: a  reason: collision with other field name */
        TextView f6037a;
        TextView b;
        TextView c;
        TextView d;
        TextView e;
    }

    public zf(Context context, ArrayList<DeleteUser> objects) {
        super(context, R.layout.dele_umanager_row, objects);
        this.f6033a = objects;
        this.a = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View convertView2;
        b holder;
        String formatted;
        String formatted2;
        int i = position;
        try {
            DeleteUser customer = (DeleteUser) getItem(position);
            DecimalFormat df = (DecimalFormat) NumberFormat.getNumberInstance(Locale.ENGLISH);
            df.applyPattern("#.##");
            if (convertView == null) {
                convertView2 = LayoutInflater.from(getContext()).inflate(R.layout.dele_umanager_row, (ViewGroup) null);
                try {
                    holder = new b();
                    holder.a = i;
                    holder.f6037a = (TextView) convertView2.findViewById(R.id.uname);
                    holder.b = (TextView) convertView2.findViewById(R.id.profile);
                    holder.c = (TextView) convertView2.findViewById(R.id.uptime);
                    holder.d = (TextView) convertView2.findViewById(R.id.download);
                    holder.e = (TextView) convertView2.findViewById(R.id.upload);
                    holder.f6035a = (CheckBox) convertView2.findViewById(R.id.chk_selected);
                    holder.f6036a = (LinearLayout) convertView2.findViewById(R.id.title);
                    convertView2.setTag(holder);
                } catch (Exception e) {
                    e = e;
                }
            } else {
                holder = (b) convertView.getTag();
                convertView2 = convertView;
            }
            if (i < 1) {
                holder.f6036a.setVisibility(0);
            } else {
                holder.f6036a.setVisibility(8);
            }
            if (customer.getDownload() != null) {
                double a2 = Double.parseDouble(customer.getDownload()) / 1048576.0d;
                formatted = df.format(a2) + " ميجا";
                if (a2 > 1024.0d) {
                    formatted = df.format(a2 / 1024.0d) + "جيجا";
                }
            } else {
                formatted = "0";
            }
            if (customer.getUpload() != null) {
                double a22 = Double.parseDouble(customer.getUpload()) / 1048576.0d;
                formatted2 = df.format(a22) + " ميجا";
                if (a22 > 1024.0d) {
                    formatted2 = df.format(a22 / 1024.0d) + " جيجا";
                }
            } else {
                formatted2 = "0";
            }
            holder.f6037a.setText(customer.getUname());
            holder.b.setText(customer.getProfilename());
            holder.c.setText(customer.getUptime());
            holder.d.setText(formatted);
            holder.e.setText(formatted2);
            holder.f6035a.setChecked(customer.isSelected());
            holder.f6035a.setTag(this.f6033a.get(i));
            holder.f6035a.setOnClickListener(new a(i));
        } catch (Exception e2) {
            e = e2;
            convertView2 = convertView;
            e.printStackTrace();
            Toast.makeText(this.a, e.getMessage(), 0).show();
            return convertView2;
        }
        return convertView2;
    }

    /* renamed from: zf$a */
    class a implements View.OnClickListener {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        public void onClick(View v) {
            CheckBox cb = (CheckBox) v;
            ((DeleteUser) cb.getTag()).setSelected(cb.isChecked());
            zf.this.f6033a.get(this.a).setSelected(cb.isChecked());
        }
    }
}
