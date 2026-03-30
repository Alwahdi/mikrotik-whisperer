package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.BindingUser;
import com.blogspot.yemeninfo4it.mumsmobile_app.tableview.model.Cell;
import com.blogspot.yemeninfo4it.mumsmobile_app.tableview.model.ColumnHeader;
import com.blogspot.yemeninfo4it.mumsmobile_app.tableview.model.RowHeader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* renamed from: tp0  reason: default package */
public class tp0 {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private final Drawable f5125a;

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<BindingUser> f5126a;

    /* renamed from: a  reason: collision with other field name */
    ue f5127a;
    private final Drawable b;
    private final Drawable c;
    private final Drawable d;

    public tp0(Context context, ArrayList<BindingUser> activeUsers) {
        this.a = context;
        this.f5127a = new ue(context);
        this.f5126a = activeUsers;
        this.f5125a = ContextCompat.getDrawable(context, R.drawable.ic_plus);
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
        y9 header = new y9(String.valueOf(0), "عنوان الماك");
        y9 header2 = new y9(String.valueOf(1), "عنوان الايبي");
        y9 header3 = new y9(String.valueOf(2), "السيرفـر");
        y9 header4 = new y9(String.valueOf(3), "النـوع");
        list.add(header);
        list.add(header2);
        list.add(header3);
        list.add(header4);
        return list;
    }

    private List<List<z7>> b() {
        z7 cell;
        List<List<Cell>> list = new ArrayList<>();
        try {
            Cursor s0 = this.f5127a.s0();
            for (int i = 0; i < this.f5126a.size(); i++) {
                List<Cell> cellList = new ArrayList<>();
                for (int j = 0; j < 4; j++) {
                    Object text = this.f5126a.get(i).getMac_address();
                    int nextInt = new Random().nextInt();
                    if (j == 2) {
                        text = this.f5126a.get(i).getServer();
                    } else if (j == 0) {
                        text = this.f5126a.get(i).getMac_address();
                    } else if (j == 1) {
                        text = this.f5126a.get(i).getAddress();
                    } else if (j == 3) {
                        text = this.f5126a.get(i).getType();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Drawable d(int value, boolean isGender) {
        return isGender ? value == 1 ? this.f5125a : this.b : value == 1 ? this.d : this.c;
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
