package defpackage;

import java.util.Arrays;
import java.util.HashMap;

/* renamed from: l70  reason: default package */
public abstract class l70 {
    public static <O extends o70> j60 a(HashMap<Integer, O> items, v80 writer) {
        if (items.isEmpty()) {
            return null;
        }
        Integer[] numbers = (Integer[]) items.keySet().toArray(new Integer[items.size()]);
        Arrays.sort(numbers);
        if (numbers.length <= 64) {
            j60 dic = new j60();
            x50 ar = new x50();
            for (int k = 0; k < numbers.length; k++) {
                ar.I(new k70(numbers[k].intValue()));
                ar.I((o70) items.get(numbers[k]));
            }
            dic.Q(h70.B7, ar);
            return dic;
        }
        int skip = 64;
        z60[] kids = new z60[(((numbers.length + 64) - 1) / 64)];
        for (int k2 = 0; k2 < kids.length; k2++) {
            int offset = k2 * 64;
            int end = Math.min(offset + 64, numbers.length);
            j60 dic2 = new j60();
            x50 arr = new x50();
            arr.I(new k70(numbers[offset].intValue()));
            arr.I(new k70(numbers[end - 1].intValue()));
            dic2.Q(h70.p6, arr);
            x50 arr2 = new x50();
            while (offset < end) {
                arr2.I(new k70(numbers[offset].intValue()));
                arr2.I((o70) items.get(numbers[offset]));
                offset++;
            }
            dic2.Q(h70.B7, arr2);
            kids[k2] = writer.y(dic2).a();
        }
        int top = kids.length;
        while (top > 64) {
            skip *= 64;
            int tt = ((numbers.length + skip) - 1) / skip;
            for (int k3 = 0; k3 < tt; k3++) {
                int offset2 = k3 * 64;
                int end2 = Math.min(offset2 + 64, top);
                j60 dic3 = new j60();
                x50 arr3 = new x50();
                arr3.I(new k70(numbers[k3 * skip].intValue()));
                arr3.I(new k70(numbers[Math.min((k3 + 1) * skip, numbers.length) - 1].intValue()));
                dic3.Q(h70.p6, arr3);
                x50 arr4 = new x50();
                while (offset2 < end2) {
                    arr4.I(kids[offset2]);
                    offset2++;
                }
                dic3.Q(h70.Z5, arr4);
                kids[k3] = writer.y(dic3).a();
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
