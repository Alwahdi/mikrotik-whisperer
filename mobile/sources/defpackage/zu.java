package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: zu  reason: default package */
public abstract class zu {
    /* JADX WARNING: Removed duplicated region for block: B:2:0x0006  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(java.util.Iterator<?> r4, java.util.Iterator<?> r5) {
        /*
        L_0x0000:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x001e
            boolean r0 = r5.hasNext()
            r1 = 0
            if (r0 != 0) goto L_0x000e
            return r1
        L_0x000e:
            java.lang.Object r0 = r4.next()
            java.lang.Object r2 = r5.next()
            boolean r3 = defpackage.f40.a(r0, r2)
            if (r3 != 0) goto L_0x001d
            return r1
        L_0x001d:
            goto L_0x0000
        L_0x001e:
            boolean r0 = r5.hasNext()
            r0 = r0 ^ 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.zu.b(java.util.Iterator, java.util.Iterator):boolean");
    }

    public static <T> boolean a(Collection<T> addTo, Iterator<? extends T> iterator) {
        v90.n(addTo);
        v90.n(iterator);
        boolean wasModified = false;
        while (iterator.hasNext()) {
            wasModified |= addTo.add(iterator.next());
        }
        return wasModified;
    }

    /* renamed from: zu$a */
    static class a extends lt0<T> {
        final /* synthetic */ Object a;

        /* renamed from: a  reason: collision with other field name */
        boolean f6050a;

        a(Object obj) {
            this.a = obj;
        }

        public boolean hasNext() {
            return !this.f6050a;
        }

        public T next() {
            if (!this.f6050a) {
                this.f6050a = true;
                return this.a;
            }
            throw new NoSuchElementException();
        }
    }

    public static <T> lt0<T> c(T value) {
        return new a(value);
    }
}
