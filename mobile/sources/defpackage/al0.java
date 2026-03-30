package defpackage;

import java.util.Collections;
import java.util.Set;

/* renamed from: al0  reason: default package */
abstract class al0 {
    public static final <T> Set<T> a(T element) {
        Set<T> singleton = Collections.singleton(element);
        lu.e(singleton, "singleton(element)");
        return singleton;
    }
}
