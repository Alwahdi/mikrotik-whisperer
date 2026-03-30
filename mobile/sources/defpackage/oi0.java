package defpackage;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.SalesPointModel;
import java.util.ArrayList;

/* renamed from: oi0  reason: default package */
public class oi0 extends ArrayAdapter<SalesPointModel> {
    int a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public Activity f4540a;

    /* renamed from: a  reason: collision with other field name */
    Context f4541a;

    /* renamed from: a  reason: collision with other field name */
    ArrayList<SalesPointModel> f4542a;

    public oi0(Context context, Activity parentActivity, ArrayList<SalesPointModel> objects, int selectedReport) {
        super(context, R.layout.sales_pint_row, objects);
        this.f4542a = objects;
        this.f4541a = context;
        this.f4540a = parentActivity;
        this.a = selectedReport;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        c holder;
        try {
            SalesPointModel customer = (SalesPointModel) getItem(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.sales_pint_row, (ViewGroup) null);
                holder = new c();
                holder.a = position;
                holder.b = (TextView) convertView.findViewById(R.id.sls_name);
                holder.f4548a = (TextView) convertView.findViewById(R.id.sls_id);
                holder.c = (TextView) convertView.findViewById(R.id.used_count);
                holder.d = (TextView) convertView.findViewById(R.id.unused_count);
                holder.e = (TextView) convertView.findViewById(R.id.total_s);
                holder.f4547a = (LinearLayout) convertView.findViewById(R.id.title);
                convertView.setTag(holder);
            } else {
                holder = (c) convertView.getTag();
            }
            if (position < 1) {
                holder.f4547a.setVisibility(0);
            } else {
                holder.f4547a.setVisibility(8);
            }
            convertView.setOnClickListener(new a(customer));
            holder.f4548a.setText(String.valueOf(customer.getId()));
            holder.b.setText(customer.getName());
            holder.c.setText(String.valueOf(customer.getUsed_card_count()));
            holder.d.setText(String.valueOf(customer.getUnused_card_count() - customer.getUsed_card_count()));
            holder.e.setText(String.valueOf(customer.getUnused_card_count()));
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this.f4541a, e.getMessage(), 0).show();
        }
        return convertView;
    }

    /* renamed from: oi0$a */
    class a implements View.OnClickListener {
        final /* synthetic */ SalesPointModel a;

        a(SalesPointModel salesPointModel) {
            this.a = salesPointModel;
        }

        public void onClick(View v) {
            oi0.this.b(this.a.getId(), this.a.getName());
        }
    }

    public void b(int id, String name) {
        try {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this.f4540a);
            View myView = this.f4540a.getLayoutInflater().inflate(R.layout.save_hots_profile_pop, (ViewGroup) null);
            dialogBuilder.setView(myView);
            EditText save_profile_name = (EditText) myView.findViewById(R.id.save_profile_name);
            ((TextView) myView.findViewById(R.id.field_tit)).setText("الإسم");
            ((TextView) myView.findViewById(R.id.refresh_img)).setText("تعديل نقطة بيع");
            save_profile_name.setText(name);
            AlertDialog b2 = dialogBuilder.create();
            b2.show();
            ((TextView) myView.findViewById(R.id.save_profile_btn)).setOnClickListener(new b(save_profile_name, id, b2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: oi0$b */
    class b implements View.OnClickListener {
        final /* synthetic */ int a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ EditText f4544a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ AlertDialog f4545a;

        b(EditText editText, int i, AlertDialog alertDialog) {
            this.f4544a = editText;
            this.a = i;
            this.f4545a = alertDialog;
        }

        public void onClick(View v) {
            try {
                ue mDatabaseHelper = new ue(oi0.this.f4541a);
                Cursor cursor = mDatabaseHelper.o0(this.f4544a.getText().toString());
                int dbId = 0;
                while (cursor.moveToNext()) {
                    dbId = cursor.getInt(0);
                }
                if (cursor.getCount() <= 0) {
                    if (mDatabaseHelper.A0(this.a, this.f4544a.getText().toString())) {
                        Toast.makeText(oi0.this.f4540a, "تم الحفظ", 0).show();
                        ((ImageView) ((Activity) oi0.this.f4541a).findViewById(R.id.refresh_slsPoint)).performClick();
                        this.f4545a.dismiss();
                    }
                    return;
                }
                int i = this.a;
                if (dbId == i) {
                    if (mDatabaseHelper.A0(i, this.f4544a.getText().toString())) {
                        Toast.makeText(oi0.this.f4540a, "تم الحفظ", 0).show();
                        ((ImageView) ((Activity) oi0.this.f4541a).findViewById(R.id.refresh_slsPoint)).performClick();
                        this.f4545a.dismiss();
                    }
                    return;
                }
                Toast.makeText(oi0.this.f4540a, "اسم نقطة البيع موجوة بالفعل..قم بكتابة اسم اخر", 0).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: oi0$c */
    public class c {
        int a;

        /* renamed from: a  reason: collision with other field name */
        LinearLayout f4547a;

        /* renamed from: a  reason: collision with other field name */
        TextView f4548a;
        TextView b;
        TextView c;
        TextView d;
        TextView e;

        public c() {
        }
    }
}
