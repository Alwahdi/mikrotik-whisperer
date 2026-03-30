package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Sessions;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards;
import com.blogspot.yemeninfo4it.mumsmobile_app.tableview.model.Cell;
import com.blogspot.yemeninfo4it.mumsmobile_app.tableview.model.ColumnHeader;
import com.blogspot.yemeninfo4it.mumsmobile_app.tableview.model.RowHeader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* renamed from: wp0  reason: default package */
public class wp0 {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private final Drawable f5528a;

    /* renamed from: a  reason: collision with other field name */
    ArrayList<UsermanagerCards> f5529a;

    /* renamed from: a  reason: collision with other field name */
    ue f5530a;
    private final Drawable b;

    /* renamed from: b  reason: collision with other field name */
    ArrayList<Sessions> f5531b = new ArrayList<>();
    private final Drawable c;
    private final Drawable d;

    public wp0(Context context, ArrayList<Sessions> sessions2) {
        this.a = context;
        this.f5530a = new ue(context);
        this.f5531b = sessions2;
        this.f5528a = ContextCompat.getDrawable(context, R.drawable.ic_plus);
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
        y9 header2 = new y9(String.valueOf(1), "السعــر");
        y9 header3 = new y9(String.valueOf(2), "التحميــل");
        y9 header4 = new y9(String.valueOf(3), "الـرفع");
        y9 header5 = new y9(String.valueOf(4), "تاريخ الاستخدام");
        y9 header6 = new y9(String.valueOf(5), "المنفـذ");
        list.add(header);
        list.add(header2);
        list.add(header3);
        list.add(header4);
        list.add(header5);
        list.add(header6);
        return list;
    }

    private List<List<z7>> b() {
        z7 cell;
        List<List<Cell>> list = new ArrayList<>();
        Cursor s0 = this.f5530a.s0();
        this.f5529a = new ArrayList<>();
        for (int i = 0; i < this.f5531b.size(); i++) {
            List<Cell> cellList = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                Object text = this.f5531b.get(i).getName();
                int nextInt = new Random().nextInt();
                if (j == 2) {
                    try {
                        text = qb0.e(this.f5531b.get(i).getDownload());
                    } catch (Exception e) {
                    }
                } else if (j == 0) {
                    text = this.f5531b.get(i).getName();
                } else if (j == 1) {
                    text = this.f5531b.get(i).getPrice();
                } else if (j == 3) {
                    text = qb0.e(this.f5531b.get(i).getUpload());
                } else if (j == 4) {
                    text = this.f5531b.get(i).getStfrom();
                } else {
                    text = this.f5531b.get(i).getNas_port_id();
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
        return isGender ? value == 1 ? this.f5528a : this.b : value == 1 ? this.d : this.c;
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
