package defpackage;

import defpackage.yc;
import java.io.Serializable;

/* renamed from: ka  reason: default package */
public final class ka implements yc, Serializable {
    private final yc.b a;

    /* renamed from: a  reason: collision with other field name */
    private final yc f4110a;

    public ka(yc left, yc.b element) {
        lu.f(left, "left");
        lu.f(element, "element");
        this.f4110a = left;
        this.a = element;
    }

    public yc plus(yc context) {
        return yc.a.a(this, context);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: yc} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: ka} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <E extends defpackage.yc.b> E get(defpackage.yc.c<E> r4) {
        /*
            r3 = this;
            java.lang.String r0 = "key"
            defpackage.lu.f(r4, r0)
            r0 = r3
        L_0x0006:
            yc$b r1 = r0.a
            yc$b r1 = r1.get(r4)
            if (r1 == 0) goto L_0x0011
            r2 = 0
            return r1
        L_0x0011:
            yc r1 = r0.f4110a
            boolean r2 = r1 instanceof defpackage.ka
            if (r2 == 0) goto L_0x001b
            r0 = r1
            ka r0 = (defpackage.ka) r0
            goto L_0x0006
        L_0x001b:
            yc$b r2 = r1.get(r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ka.get(yc$c):yc$b");
    }

    public <R> R fold(R initial, jo<? super R, ? super yc.b, ? extends R> operation) {
        lu.f(operation, "operation");
        return operation.invoke(this.f4110a.fold(initial, operation), this.a);
    }

    public yc minusKey(yc.c<?> key) {
        lu.f(key, "key");
        if (this.a.get(key) != null) {
            return this.f4110a;
        }
        yc newLeft = this.f4110a.minusKey(key);
        if (newLeft == this.f4110a) {
            return this;
        }
        if (newLeft == gi.a) {
            return this.a;
        }
        return new ka(newLeft, this.a);
    }

    private final int d() {
        ka cur = this;
        int size = 2;
        while (true) {
            yc ycVar = cur.f4110a;
            ka kaVar = ycVar instanceof ka ? (ka) ycVar : null;
            if (kaVar == null) {
                return size;
            }
            cur = kaVar;
            size++;
        }
    }

    private final boolean a(yc.b element) {
        return lu.a(get(element.getKey()), element);
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [yc, java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean b(defpackage.ka r4) {
        /*
            r3 = this;
            r0 = r4
        L_0x0001:
            yc$b r1 = r0.a
            boolean r1 = r3.a(r1)
            if (r1 != 0) goto L_0x000c
            r1 = 0
            return r1
        L_0x000c:
            yc r1 = r0.f4110a
            boolean r2 = r1 instanceof defpackage.ka
            if (r2 == 0) goto L_0x0016
            r0 = r1
            ka r0 = (defpackage.ka) r0
            goto L_0x0001
        L_0x0016:
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element"
            defpackage.lu.d(r1, r2)
            r2 = r1
            yc$b r2 = (defpackage.yc.b) r2
            boolean r2 = r3.a(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ka.b(ka):boolean");
    }

    public boolean equals(Object other) {
        return this == other || ((other instanceof ka) && ((ka) other).d() == d() && ((ka) other).b(this));
    }

    public int hashCode() {
        return this.f4110a.hashCode() + this.a.hashCode();
    }

    /* renamed from: ka$a */
    static final class a extends ow implements jo<String, yc.b, String> {
        public static final a a = new a();

        a() {
            super(2);
        }

        /* renamed from: b */
        public final String invoke(String acc, yc.b element) {
            lu.f(acc, "acc");
            lu.f(element, "element");
            if (acc.length() == 0) {
                return element.toString();
            }
            return acc + ", " + element;
        }
    }

    public String toString() {
        return '[' + ((String) fold("", a.a)) + ']';
    }
}
