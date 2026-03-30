package defpackage;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.MenuItem;
import android.widget.PopupMenu;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import java.util.List;
import java.util.Map;

/* renamed from: z9  reason: default package */
public class z9 extends PopupMenu implements PopupMenu.OnMenuItemClickListener {
    private static final String a = z9.class.getSimpleName();

    /* renamed from: a  reason: collision with other field name */
    private int f6010a = this.f6013a.getAdapterPosition();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f6011a;

    /* renamed from: a  reason: collision with other field name */
    private Context f6012a;

    /* renamed from: a  reason: collision with other field name */
    private ca f6013a = ((ca) this.f6014a.getColumnHeaderRecyclerView().findViewHolderForAdapterPosition(this.f6010a));

    /* renamed from: a  reason: collision with other field name */
    private or f6014a;

    public z9(ca viewHolder, or tableView) {
        super(viewHolder.itemView.getContext(), viewHolder.itemView);
        this.f6013a = viewHolder;
        this.f6014a = tableView;
        this.f6012a = viewHolder.itemView.getContext();
        d();
    }

    private void d() {
        c();
        b();
        setOnMenuItemClickListener(this);
    }

    private void c() {
        getMenu().add(0, 1, 0, this.f6012a.getString(R.string.sort_ascending));
        getMenu().add(0, 2, 1, this.f6012a.getString(R.string.sort_descending));
        getMenu().add(0, 3, 2, this.f6012a.getString(R.string.hiding_row_sample));
        getMenu().add(0, 4, 3, this.f6012a.getString(R.string.showing_row_sample));
        getMenu().add(0, 5, 4, this.f6012a.getString(R.string.scroll_to_row_position));
        getMenu().add(0, 5, 0, "change width");
    }

    private void b() {
        com.evrencoskun.tableview.sort.a sortState = this.f6014a.k(this.f6010a);
        if (sortState != com.evrencoskun.tableview.sort.a.UNSORTED) {
            if (sortState == com.evrencoskun.tableview.sort.a.DESCENDING) {
                getMenu().getItem(1).setVisible(false);
            } else if (sortState == com.evrencoskun.tableview.sort.a.ASCENDING) {
                getMenu().getItem(0).setVisible(false);
            }
        }
    }

    /* renamed from: z9$a */
    class a extends AsyncTask<String, String, String> {
        List<Map<String, String>> a = null;

        a() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            z9.this.f6011a.setTitle("يرجى الانتظار");
            z9.this.f6011a.setMessage("جاري تنفيذ العملية");
            z9.this.f6011a.setCancelable(false);
            z9.this.f6011a.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                j3 con = j3.c(qb0.f4797a.getIp(), Integer.valueOf(Integer.parseInt(qb0.f4797a.getPort())));
                con.C(qb0.f4797a.getUname(), qb0.f4797a.getPass(), true);
                con.w();
                con.q("/tool/user-manager/user/create-and-activate-profile customer=admin profile=100 numbers=" + qb0.f4807b.get(qb0.a).getUname().toString() + "");
                con.close();
                return null;
            } catch (Exception e) {
                try {
                    Log.d("Tag", e.toString() + "error");
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            z9.this.f6011a.dismiss();
        }
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                this.f6011a = new ProgressDialog(this.f6012a);
                new a().execute(new String[0]);
                return true;
            case 2:
                this.f6014a.l(this.f6010a, com.evrencoskun.tableview.sort.a.DESCENDING);
                return true;
            case 3:
                this.f6014a.i(5);
                return true;
            case 4:
                this.f6014a.g(5);
                return true;
            case 5:
                this.f6014a.d(5);
                return true;
            default:
                return true;
        }
    }
}
