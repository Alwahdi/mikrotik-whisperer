package defpackage;

import android.text.TextUtils;
import com.evrencoskun.tableview.filter.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: tk  reason: default package */
public class tk {
    private List<wk> a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    private or f5102a;

    public tk(or tableView) {
        this.f5102a = tableView;
    }

    public void e(int column, String filter) {
        wk filterItem = new wk(column == -1 ? a.ALL : a.COLUMN, column, filter);
        if (c(column, filterItem)) {
            if (TextUtils.isEmpty(filter)) {
                d(column, filterItem);
            } else {
                f(column, filterItem);
            }
        } else if (!TextUtils.isEmpty(filter)) {
            a(filterItem);
        }
    }

    private void a(wk filterItem) {
        this.a.add(filterItem);
        this.f5102a.a(this);
    }

    private void d(int column, wk filterItem) {
        Iterator<wk> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            wk item = it.next();
            if (column != -1 || !item.c().equals(filterItem.c())) {
                if (item.a() == filterItem.a()) {
                    it.remove();
                    break;
                }
            } else {
                it.remove();
                break;
            }
        }
        this.f5102a.a(this);
    }

    private void f(int column, wk filterItem) {
        Iterator<wk> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            wk item = it.next();
            if (column != -1 || !item.c().equals(filterItem.c())) {
                if (item.a() == filterItem.a()) {
                    List<wk> list = this.a;
                    list.set(list.indexOf(item), filterItem);
                    break;
                }
            } else {
                List<wk> list2 = this.a;
                list2.set(list2.indexOf(item), filterItem);
                break;
            }
        }
        this.f5102a.a(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c(int r6, defpackage.wk r7) {
        /*
            r5 = this;
            java.util.List<wk> r0 = r5.a
            java.util.Iterator r0 = r0.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0031
            java.lang.Object r1 = r0.next()
            wk r1 = (defpackage.wk) r1
            r2 = -1
            r3 = 1
            if (r6 != r2) goto L_0x0025
            com.evrencoskun.tableview.filter.a r2 = r1.c()
            com.evrencoskun.tableview.filter.a r4 = r7.c()
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0025
            return r3
        L_0x0025:
            int r2 = r1.a()
            int r4 = r7.a()
            if (r2 != r4) goto L_0x0030
            return r3
        L_0x0030:
            goto L_0x0006
        L_0x0031:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tk.c(int, wk):boolean");
    }

    public List<wk> b() {
        return this.a;
    }
}
