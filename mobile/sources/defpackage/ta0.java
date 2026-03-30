package defpackage;

import android.util.SparseArray;
import com.google.android.datatransport.a;
import java.util.EnumMap;

/* renamed from: ta0  reason: default package */
public abstract class ta0 {
    private static SparseArray<a> a = new SparseArray<>();

    /* renamed from: a  reason: collision with other field name */
    private static EnumMap<a, Integer> f5096a;

    static {
        EnumMap<a, Integer> enumMap = new EnumMap<>(a.class);
        f5096a = enumMap;
        enumMap.put(a.DEFAULT, 0);
        f5096a.put(a.VERY_LOW, 1);
        f5096a.put(a.HIGHEST, 2);
        for (a p : f5096a.keySet()) {
            a.append(f5096a.get(p).intValue(), p);
        }
    }

    public static a b(int value) {
        a priority = a.get(value);
        if (priority != null) {
            return priority;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + value);
    }

    public static int a(a priority) {
        Integer integer = f5096a.get(priority);
        if (integer != null) {
            return integer.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + priority);
    }
}
