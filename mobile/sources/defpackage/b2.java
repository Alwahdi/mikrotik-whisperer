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
import androidx.recyclerview.widget.RecyclerView;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot;
import java.util.ArrayList;

/* renamed from: b2  reason: default package */
public class b2 extends RecyclerView.Adapter<e> {
    Context a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<AddUserHotspot> f138a;

    public b2(Context context, ArrayList<AddUserHotspot> home_modelArrayList) {
        this.a = context;
        this.f138a = home_modelArrayList;
    }

    /* renamed from: e */
    public e onCreateViewHolder(ViewGroup parent, int viewType) {
        return new e(LayoutInflater.from(parent.getContext()).inflate(R.layout.adduser_item, parent, false));
    }

    /* renamed from: d */
    public void onBindViewHolder(e holder, int position) {
        if (position != -1) {
            int pos = position;
            if (this.f138a.get(position).getStatus().equals("no")) {
                holder.d.setBackgroundResource(R.color.mainColorDark);
                holder.d.setText("لم تتم الإضافة");
                holder.d.setTextColor(Color.parseColor("#ffffff"));
            } else {
                holder.d.setBackgroundResource(R.drawable.added_ok);
                holder.d.setTextColor(Color.parseColor("#ffffff"));
                holder.d.setText("تمت الإضافة");
            }
            holder.f143a.setText(this.f138a.get(position).getUname());
            holder.b.setText(this.f138a.get(position).getPassword());
            holder.c.setText(this.f138a.get(position).getProfilename());
            holder.a.setChecked(this.f138a.get(position).isSelected());
            holder.a.setTag(this.f138a.get(position));
            holder.a.setOnClickListener(new a(pos));
            holder.f142a.setOnClickListener(new b(pos));
        }
    }

    /* renamed from: b2$a */
    class a implements View.OnClickListener {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        public void onClick(View v) {
            CheckBox cb = (CheckBox) v;
            ((AddUserHotspot) cb.getTag()).setSelected(cb.isChecked());
            ((AddUserHotspot) b2.this.f138a.get(this.a)).setSelected(cb.isChecked());
        }
    }

    /* renamed from: b2$b */
    class b implements View.OnClickListener {
        final /* synthetic */ int a;

        b(int i) {
            this.a = i;
        }

        public void onClick(View v) {
            b2.this.c(v, this.a);
        }
    }

    public int getItemCount() {
        return this.f138a.size();
    }

    /* access modifiers changed from: private */
    public void c(View v, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setMessage("هل تريد الحذف ؟").setCancelable(false).setPositiveButton("تأكيد", new d(position)).setNegativeButton("إلغاء", new c());
        builder.show();
    }

    /* renamed from: b2$d */
    class d implements DialogInterface.OnClickListener {
        final /* synthetic */ int a;

        d(int i) {
            this.a = i;
        }

        public void onClick(DialogInterface dialog, int id) {
            b2.this.f138a.remove(this.a);
            b2.this.notifyDataSetChanged();
        }
    }

    /* renamed from: b2$c */
    class c implements DialogInterface.OnClickListener {
        c() {
        }

        public void onClick(DialogInterface dialog, int id) {
        }
    }

    /* renamed from: b2$e */
    public class e extends RecyclerView.ViewHolder {
        CheckBox a;

        /* renamed from: a  reason: collision with other field name */
        public ImageButton f142a;

        /* renamed from: a  reason: collision with other field name */
        TextView f143a;
        TextView b;
        TextView c;
        TextView d;

        public e(View itemView) {
            super(itemView);
            this.f143a = (TextView) itemView.findViewById(R.id.username);
            this.b = (TextView) itemView.findViewById(R.id.pass);
            this.c = (TextView) itemView.findViewById(R.id.profname);
            this.d = (TextView) itemView.findViewById(R.id.imgstatus);
            this.a = (CheckBox) itemView.findViewById(R.id.chk_selected);
            this.f142a = (ImageButton) itemView.findViewById(R.id.btn_delete_unit);
        }
    }
}
