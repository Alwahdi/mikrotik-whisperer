package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards;
import com.blogspot.yemeninfo4it.mumsmobile_app.tableview.model.Cell;
import com.blogspot.yemeninfo4it.mumsmobile_app.tableview.model.ColumnHeader;
import com.blogspot.yemeninfo4it.mumsmobile_app.tableview.model.RowHeader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* renamed from: rp0  reason: default package */
public class rp0 {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private final Drawable f4924a;

    /* renamed from: a  reason: collision with other field name */
    ArrayList<UsermanagerCards> f4925a;

    /* renamed from: a  reason: collision with other field name */
    ue f4926a;
    private final Drawable b;
    private final Drawable c;
    private final Drawable d;

    public rp0(Context context) {
        this.a = context;
        this.f4926a = new ue(context);
        this.f4924a = ContextCompat.getDrawable(context, R.drawable.ic_plus);
        this.b = ContextCompat.getDrawable(context, R.drawable.ic_plus);
        this.c = ContextCompat.getDrawable(context, R.drawable.ic_plus);
        this.d = ContextCompat.getDrawable(context, R.drawable.ic_plus);
    }

    private List<cf0> g() {
        List<RowHeader> list = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            String valueOf = String.valueOf(i);
            list.add(new cf0(valueOf, "row " + i));
        }
        return list;
    }

    private List<y9> e() {
        List<ColumnHeader> list = new ArrayList<>();
        y9 header = new y9(String.valueOf(0), "اسم المستخدم");
        y9 header2 = new y9(String.valueOf(1), "كلمة المرور");
        y9 header3 = new y9(String.valueOf(2), "البروفايل");
        y9 header4 = new y9(String.valueOf(3), "الوقت المستخدم");
        y9 header5 = new y9(String.valueOf(4), "تم التحميل");
        y9 header6 = new y9(String.valueOf(5), "تم الرفع");
        y9 header7 = new y9(String.valueOf(6), "الحالة");
        list.add(header);
        list.add(header2);
        list.add(header3);
        list.add(header4);
        list.add(header5);
        list.add(header6);
        list.add(header7);
        return list;
    }

    private List<List<z7>> b() {
        z7 cell;
        List<List<Cell>> list = new ArrayList<>();
        Cursor s0 = this.f4926a.s0();
        this.f4925a = new ArrayList<>();
        for (int i = 0; i < qb0.f4807b.size(); i++) {
            List<Cell> cellList = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                Object text = qb0.f4807b.get(i).getUname();
                int nextInt = new Random().nextInt();
                if (j == 2) {
                    text = qb0.f4807b.get(i).getProfilename();
                } else if (j == 0) {
                    text = qb0.f4807b.get(i).getUname();
                } else if (j == 1) {
                    text = qb0.f4807b.get(i).getPassword();
                } else if (j == 5) {
                    if (qb0.f4807b.get(i).getUpload_used() != null) {
                        text = String.valueOf((Long.parseLong(qb0.f4807b.get(i).getUpload_used().toString()) / 1024) / 1024) + "ميجا";
                    } else {
                        text = qb0.f4807b.get(i).getUpload_used();
                    }
                } else if (j == 6) {
                    text = qb0.f4807b.get(i).getStatus();
                } else if (j == 3) {
                    text = qb0.f4807b.get(i).getUptime_used();
                } else if (j == 4) {
                    if (qb0.f4807b.get(i).getDownload_used() != null) {
                        long a2 = (Long.parseLong(qb0.f4807b.get(i).getDownload_used().toString()) / 1024) / 1024;
                        text = String.valueOf(a2) + "ميجا";
                    } else {
                        text = qb0.f4807b.get(i).getDownload_used();
                    }
                }
                String id = j + "-" + i;
                if (j == 3) {
                    cell = new z7(id, text);
                } else if (j == 4) {
                    cell = new z7(id, text);
                } else {
                    cell = new z7(id, text);
                }
                cellList.add(cell);
            }
            list.add(cellList);
        }
        return list;
    }

    public Drawable d(int value, boolean isGender) {
        return isGender ? value == 1 ? this.f4924a : this.b : value == 1 ? this.d : this.c;
    }

    public List<List<z7>> a() {
        return b();
    }

    public List<cf0> f() {
        return g();
    }

    public List<y9> c() {
        return e();
    }
}
