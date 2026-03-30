package defpackage;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: a00  reason: default package */
abstract class a00 extends zz {
    public static <K, V> Map<K, V> d() {
        ki kiVar = ki.a;
        lu.d(kiVar, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return kiVar;
    }

    public static final <K, V> void f(Map<? super K, ? super V> $this$putAll, Iterable<? extends j50<? extends K, ? extends V>> pairs) {
        lu.f($this$putAll, "<this>");
        lu.f(pairs, "pairs");
        for (j50 j50 : pairs) {
            $this$putAll.put(j50.a(), j50.b());
        }
    }

    public static <K, V> Map<K, V> g(Iterable<? extends j50<? extends K, ? extends V>> $this$toMap) {
        lu.f($this$toMap, "<this>");
        if (!($this$toMap instanceof Collection)) {
            return e(h($this$toMap, new LinkedHashMap()));
        }
        switch (((Collection) $this$toMap).size()) {
            case 0:
                return d();
            case 1:
                return zz.b((j50) ($this$toMap instanceof List ? ((List) $this$toMap).get(0) : $this$toMap.iterator().next()));
            default:
                return h($this$toMap, new LinkedHashMap(zz.a(((Collection) $this$toMap).size())));
        }
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M h(Iterable<? extends j50<? extends K, ? extends V>> $this$toMap, M destination) {
        lu.f($this$toMap, "<this>");
        lu.f(destination, "destination");
        f(destination, $this$toMap);
        return destination;
    }

    public static <K, V> Map<K, V> i(Map<? extends K, ? extends V> $this$toMap) {
        lu.f($this$toMap, "<this>");
        switch ($this$toMap.size()) {
            case 0:
                return d();
            case 1:
                return zz.c($this$toMap);
            default:
                return j($this$toMap);
        }
    }

    public static final <K, V> Map<K, V> j(Map<? extends K, ? extends V> $this$toMutableMap) {
        lu.f($this$toMutableMap, "<this>");
        return new LinkedHashMap($this$toMutableMap);
    }

    public static final <K, V> Map<K, V> e(Map<K, ? extends V> $this$optimizeReadOnlyMap) {
        lu.f($this$optimizeReadOnlyMap, "<this>");
        switch ($this$optimizeReadOnlyMap.size()) {
            case 0:
                return d();
            case 1:
                return zz.c($this$optimizeReadOnlyMap);
            default:
                return $this$optimizeReadOnlyMap;
        }
    }
}
