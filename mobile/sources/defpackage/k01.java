package defpackage;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: k01  reason: default package */
public abstract class k01 {
    public static ga1 b(u61 u61) {
        if (u61 != null && !TextUtils.isEmpty(u61.m())) {
            return new mz0(u61.p(), u61.r(), u61.s(), u61.m());
        }
        return null;
    }

    public static List<ga1> a(List<u61> list) {
        if (list == null || list.isEmpty()) {
            return t11.j();
        }
        ArrayList arrayList = new ArrayList();
        for (u61 b : list) {
            ga1 b2 = b(b);
            if (b2 != null) {
                arrayList.add(b2);
            }
        }
        return arrayList;
    }
}
