package defpackage;

import java.util.Collections;
import java.util.Map;

/* renamed from: zz  reason: default package */
abstract class zz extends yz {
    public static final <K, V> Map<K, V> b(j50<? extends K, ? extends V> pair) {
        lu.f(pair, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(pair.c(), pair.d());
        lu.e(singletonMap, "singletonMap(pair.first, pair.second)");
        return singletonMap;
    }

    public static final <K, V> Map<K, V> c(Map<? extends K, ? extends V> $this$toSingletonMap) {
        lu.f($this$toSingletonMap, "<this>");
        Map.Entry $this$toSingletonMap_u24lambda_u245 = $this$toSingletonMap.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap($this$toSingletonMap_u24lambda_u245.getKey(), $this$toSingletonMap_u24lambda_u245.getValue());
        lu.e(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }

    public static int a(int expectedSize) {
        if (expectedSize < 0) {
            return expectedSize;
        }
        if (expectedSize < 3) {
            return expectedSize + 1;
        }
        if (expectedSize < 1073741824) {
            return (int) ((((float) expectedSize) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }
}
