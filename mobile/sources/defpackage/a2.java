package defpackage;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser;
import java.util.ArrayList;

/* renamed from: a2  reason: default package */
public class a2 extends RecyclerView.Adapter<e> {
    Context a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<AddUser> f5a;

    public a2(Context context, ArrayList<AddUser> home_modelArrayList) {
        this.a = context;
        this.f5a = home_modelArrayList;
    }

    /* renamed from: e */
    public e onCreateViewHolder(ViewGroup parent, int viewType) {
        return new e(LayoutInflater.from(parent.getContext()).inflate(R.layout.adduser_item, parent, false));
    }

    /* renamed from: d */
    public void onBindViewHolder(e holder, int position) {
        if (position != -1) {
            int pos = position;
            try {
                if (this.f5a.get(position).getStatus().equals("no")) {
                    holder.d.setBackgroundResource(R.color.mainColorDark);
                    holder.d.setText("لم تتم الإضافة");
                    holder.d.setTextColor(Color.parseColor("#ffffff"));
                } else {
                    holder.d.setBackgroundResource(R.drawable.added_ok);
                    holder.d.setTextColor(Color.parseColor("#ffffff"));
                    holder.d.setText("تمت الإضافة");
                }
                holder.f11a.setText(this.f5a.get(position).getUname());
                holder.b.setText(this.f5a.get(position).getPassword());
                holder.c.setText(this.f5a.get(position).getProfilename());
                holder.f9a.setChecked(this.f5a.get(position).isSelected());
                holder.f9a.setTag(this.f5a.get(position));
                holder.f9a.setOnClickListener(new a(pos));
                holder.f10a.setOnClickListener(new b(pos));
            } catch (Exception e2) {
                Toast.makeText(this.a, e2.getMessage(), 0).show();
            }
        }
    }

    /* renamed from: a2$a */
    class a implements View.OnClickListener {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        public void onClick(View v) {
            CheckBox cb = (CheckBox) v;
            ((AddUser) cb.getTag()).setSelected(cb.isChecked());
            ((AddUser) a2.this.f5a.get(this.a)).setSelected(cb.isChecked());
        }
    }

    /* renamed from: a2$b */
    class b implements View.OnClickListener {
        final /* synthetic */ int a;

        b(int i) {
            this.a = i;
        }

        public void onClick(View v) {
            a2.this.c(v, this.a);
        }
    }

    public int getItemCount() {
        return this.f5a.size();
    }

    /* access modifiers changed from: private */
    public void c(View v, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setMessage("هل تريد الحذف ؟").setCancelable(false).setPositiveButton("تأكيد", new d(position)).setNegativeButton("إلغاء", new c());
        builder.show();
    }

    /* renamed from: a2$d */
    class d implements DialogInterface.OnClickListener {
        final /* synthetic */ int a;

        d(int i) {
            this.a = i;
        }

        public void onClick(DialogInterface dialog, int id) {
            a2.this.f5a.remove(this.a);
            a2.this.notifyDataSetChanged();
        }
    }

    /* renamed from: a2$c */
    class c implements DialogInterface.OnClickListener {
        c() {
        }

        public void onClick(DialogInterface dialog, int id) {
        }
    }

    /* renamed from: a2$e */
    public class e extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with other field name */
        CheckBox f9a;

        /* renamed from: a  reason: collision with other field name */
        public ImageButton f10a;

        /* renamed from: a  reason: collision with other field name */
        TextView f11a;
        TextView b;
        TextView c;
        TextView d;

        public e(View itemView) {
            super(itemView);
            this.f11a = (TextView) itemView.findViewById(R.id.username);
            this.b = (TextView) itemView.findViewById(R.id.pass);
            this.c = (TextView) itemView.findViewById(R.id.profname);
            this.d = (TextView) itemView.findViewById(R.id.imgstatus);
            this.f9a = (CheckBox) itemView.findViewById(R.id.chk_selected);
            this.f10a = (ImageButton) itemView.findViewById(R.id.btn_delete_unit);
        }
    }
}
