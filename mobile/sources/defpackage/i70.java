package defpackage;

import java.util.Arrays;
import java.util.HashMap;

/* renamed from: i70  reason: default package */
public abstract class i70 {
    public static j60 a(HashMap<String, ? extends o70> items, v80 writer) {
        HashMap<String, ? extends o70> hashMap = items;
        v80 v80 = writer;
        if (items.isEmpty()) {
            return null;
        }
        String[] names = (String[]) items.keySet().toArray(new String[items.size()]);
        Arrays.sort(names);
        if (names.length <= 64) {
            j60 dic = new j60();
            x50 ar = new x50();
            for (int k = 0; k < names.length; k++) {
                ar.I(new n80(names[k], (String) null));
                ar.I((o70) hashMap.get(names[k]));
            }
            dic.Q(h70.j7, ar);
            return dic;
        }
        int skip = 64;
        z60[] kids = new z60[(((names.length + 64) - 1) / 64)];
        for (int k2 = 0; k2 < kids.length; k2++) {
            int offset = k2 * 64;
            int end = Math.min(offset + 64, names.length);
            j60 dic2 = new j60();
            x50 arr = new x50();
            arr.I(new n80(names[offset], (String) null));
            arr.I(new n80(names[end - 1], (String) null));
            dic2.Q(h70.p6, arr);
            x50 arr2 = new x50();
            while (offset < end) {
                arr2.I(new n80(names[offset], (String) null));
                arr2.I((o70) hashMap.get(names[offset]));
                offset++;
            }
            dic2.Q(h70.j7, arr2);
            kids[k2] = v80.y(dic2).a();
        }
        int top = kids.length;
        for (int i = 64; top > i; i = 64) {
            skip *= 64;
            int tt = ((names.length + skip) - 1) / skip;
            for (int k3 = 0; k3 < tt; k3++) {
                int offset2 = k3 * 64;
                int end2 = Math.min(offset2 + 64, top);
                j60 dic3 = new j60();
                x50 arr3 = new x50();
                arr3.I(new n80(names[k3 * skip], (String) null));
                arr3.I(new n80(names[Math.min((k3 + 1) * skip, names.length) - 1], (String) null));
                dic3.Q(h70.p6, arr3);
                x50 arr4 = new x50();
                while (offset2 < end2) {
                    arr4.I(kids[offset2]);
                    offset2++;
                }
                dic3.Q(h70.Z5, arr4);
                kids[k3] = v80.y(dic3).a();
            }
            top = tt;
        }
        x50 arr5 = new x50();
        for (int k4 = 0; k4 < top; k4++) {
            arr5.I(kids[k4]);
        }
        j60 dic4 = new j60();
        dic4.Q(h70.Z5, arr5);
        return dic4;
    }
}
