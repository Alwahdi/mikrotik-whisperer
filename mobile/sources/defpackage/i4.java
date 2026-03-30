package defpackage;

import java.lang.reflect.Array;

/* renamed from: i4  reason: default package */
abstract class i4 {
    public static final <T> T[] a(T[] reference, int size) {
        lu.f(reference, "reference");
        Object newInstance = Array.newInstance(reference.getClass().getComponentType(), size);
        lu.d(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (Object[]) newInstance;
    }
}
