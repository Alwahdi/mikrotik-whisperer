package defpackage;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: h9  reason: default package */
public abstract class h9 {
    private static final Object[] a = new Object[0];

    public static final Object[] a(Collection<?> collection) {
        lu.f(collection, "collection");
        int size$iv = collection.size();
        if (size$iv == 0) {
            return a;
        }
        Iterator iter$iv = collection.iterator();
        if (!iter$iv.hasNext()) {
            return a;
        }
        Object[] result$iv = new Object[size$iv];
        int newSize$iv = 0;
        while (true) {
            int i$iv = newSize$iv + 1;
            result$iv[newSize$iv] = iter$iv.next();
            if (i$iv >= result$iv.length) {
                if (!iter$iv.hasNext()) {
                    return result$iv;
                }
                int newSize$iv2 = ((i$iv * 3) + 1) >>> 1;
                if (newSize$iv2 <= i$iv) {
                    if (i$iv < 2147483645) {
                        newSize$iv2 = 2147483645;
                    } else {
                        throw new OutOfMemoryError();
                    }
                }
                Object[] copyOf = Arrays.copyOf(result$iv, newSize$iv2);
                lu.e(copyOf, "copyOf(result, newSize)");
                result$iv = copyOf;
                newSize$iv = i$iv;
            } else if (!iter$iv.hasNext()) {
                Object[] copyOf2 = Arrays.copyOf(result$iv, i$iv);
                lu.e(copyOf2, "copyOf(result, size)");
                return copyOf2;
            } else {
                newSize$iv = i$iv;
            }
        }
    }

    public static final Object[] b(Collection<?> collection, Object[] a2) {
        Object[] objArr;
        Object[] result$iv;
        lu.f(collection, "collection");
        if (a2 != null) {
            int size$iv = collection.size();
            if (size$iv != 0) {
                Iterator iter$iv = collection.iterator();
                if (iter$iv.hasNext()) {
                    int size = size$iv;
                    if (size <= a2.length) {
                        objArr = a2;
                    } else {
                        Object newInstance = Array.newInstance(a2.getClass().getComponentType(), size);
                        lu.d(newInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                        objArr = (Object[]) newInstance;
                    }
                    Object[] result$iv2 = objArr;
                    int newSize$iv = 0;
                    while (true) {
                        int i$iv = newSize$iv + 1;
                        result$iv2[newSize$iv] = iter$iv.next();
                        if (i$iv >= result$iv2.length) {
                            if (!iter$iv.hasNext()) {
                                return result$iv2;
                            }
                            int newSize$iv2 = ((i$iv * 3) + 1) >>> 1;
                            if (newSize$iv2 <= i$iv) {
                                if (i$iv < 2147483645) {
                                    newSize$iv2 = 2147483645;
                                } else {
                                    throw new OutOfMemoryError();
                                }
                            }
                            Object[] copyOf = Arrays.copyOf(result$iv2, newSize$iv2);
                            lu.e(copyOf, "copyOf(result, newSize)");
                            result$iv2 = copyOf;
                            newSize$iv = i$iv;
                        } else if (!iter$iv.hasNext()) {
                            Object[] result = result$iv2;
                            int size2 = i$iv;
                            if (result == a2) {
                                a2[size2] = null;
                                result$iv = a2;
                            } else {
                                result$iv = Arrays.copyOf(result, size2);
                                lu.e(result$iv, "copyOf(result, size)");
                            }
                            return result$iv;
                        } else {
                            newSize$iv = i$iv;
                        }
                    }
                } else if (a2.length > 0) {
                    a2[0] = null;
                }
            } else if (a2.length > 0) {
                a2[0] = null;
            }
            return a2;
        }
        throw new NullPointerException();
    }
}
