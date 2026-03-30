package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.ActiveUser;
import com.blogspot.yemeninfo4it.mumsmobile_app.tableview.model.Cell;
import com.blogspot.yemeninfo4it.mumsmobile_app.tableview.model.ColumnHeader;
import com.blogspot.yemeninfo4it.mumsmobile_app.tableview.model.RowHeader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: sp0  reason: default package */
public class sp0 {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private final Drawable f5013a;

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<ActiveUser> f5014a;

    /* renamed from: a  reason: collision with other field name */
    ue f5015a;
    private final Drawable b;
    private final Drawable c;
    private final Drawable d;

    public sp0(Context context, ArrayList<ActiveUser> activeUsers) {
        this.a = context;
        this.f5015a = new ue(context);
        this.f5014a = activeUsers;
        this.f5013a = ContextCompat.getDrawable(context, R.drawable.ic_plus);
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
        y9 header2 = new y9(String.valueOf(1), "مدة الاتصال الحالي");
        y9 header3 = new y9(String.valueOf(2), "الوقت المتبقي");
        y9 header4 = new y9(String.valueOf(3), "تم التحميل");
        y9 header5 = new y9(String.valueOf(4), "ايبي ادرس");
        y9 header6 = new y9(String.valueOf(5), "الماك");
        list.add(header);
        list.add(header2);
        list.add(header3);
        list.add(header4);
        list.add(header5);
        list.add(header6);
        return list;
    }

    private List<List<z7>> b() {
        String timelift;
        String uptime;
        Double down;
        Double upload;
        String trans_str_u;
        z7 cell;
        String str = "";
        List<List<Cell>> list = new ArrayList<>();
        try {
            Cursor data = this.f5015a.s0();
            int i = 0;
            while (i < this.f5014a.size()) {
                String timelift2 = str;
                String uptime2 = str;
                String trans = str;
                Double valueOf = Double.valueOf(0.0d);
                Double valueOf2 = Double.valueOf(0.0d);
                Double valueOf3 = Double.valueOf(0.0d);
                String str2 = str;
                Cursor data2 = data;
                String str3 = timelift2;
                String str4 = uptime2;
                String trans_str_u2 = "ميجا";
                if (this.f5014a.get(i).getTimeleft() != null) {
                    timelift = this.f5014a.get(i).getTimeleft().replace("s", " ث ").replace("h", " ساعة ").replace("m", " د ").replace("d", " يوم ").replace("w", " اسبوع ");
                } else {
                    timelift = "غير محدود";
                }
                String timelift3 = trans;
                if (this.f5014a.get(i).getUptime() != null) {
                    uptime = this.f5014a.get(i).getUptime().replace("s", " ث ").replace("h", " ساعة ").replace("m", " د ").replace("d", " يوم ").replace("w", " اسبوع ");
                } else {
                    uptime = "غير محدود";
                }
                if (this.f5014a.get(i).getDownload() != null) {
                    down = Double.valueOf(Double.parseDouble(this.f5014a.get(i).getDownload()) / 1048576.0d);
                } else {
                    down = Double.valueOf(0.0d);
                }
                if (this.f5014a.get(i).getUpload() != null) {
                    upload = Double.valueOf(Double.parseDouble(this.f5014a.get(i).getUpload()) / 1048576.0d);
                } else {
                    upload = Double.valueOf(0.0d);
                }
                Double newdown = Double.valueOf(down.doubleValue() + upload.doubleValue());
                if (newdown.doubleValue() > 1024.0d) {
                    newdown = Double.valueOf(newdown.doubleValue() / 1024.0d);
                    trans_str_u = "جيجا";
                } else {
                    trans_str_u = trans_str_u2;
                }
                StringBuilder sb = new StringBuilder();
                int i2 = 1;
                sb.append(String.format(Locale.US, "%.1f", new Object[]{newdown}));
                sb.append(" ");
                sb.append(trans_str_u);
                String trans2 = sb.toString();
                List<Cell> cellList = new ArrayList<>();
                int j = 0;
                while (j < 6) {
                    String text = this.f5014a.get(i).getName();
                    if (j == 2) {
                        text = timelift;
                    } else if (j == 0) {
                        text = this.f5014a.get(i).getName();
                    } else if (j == i2) {
                        text = uptime;
                    } else if (j == 3) {
                        text = trans2;
                    } else if (j == 4) {
                        text = this.f5014a.get(i).getAddress();
                    } else if (j == 5) {
                        text = this.f5014a.get(i).getMac_address();
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
                    j++;
                    i2 = 1;
                }
                list.add(cellList);
                i++;
                str = str2;
                data = data2;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Drawable d(int value, boolean isGender) {
        return isGender ? value == 1 ? this.f5013a : this.b : value == 1 ? this.d : this.c;
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
