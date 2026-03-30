package defpackage;

import io.grpc.Attributes;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;

/* renamed from: v4  reason: default package */
public final class v4 {
    public static final v4 a = new v4(Collections.emptyMap());
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Map<c<?>, Object> f5298a;

    private v4(Map<c<?>, Object> data) {
        if (data != null) {
            this.f5298a = data;
            return;
        }
        throw new AssertionError();
    }

    public <T> T b(c<T> key) {
        return this.f5298a.get(key);
    }

    public static b c() {
        return new b();
    }

    public b d() {
        return new b();
    }

    /* renamed from: v4$c */
    public static final class c<T> {
        private final String a;

        private c(String debugString) {
            this.a = debugString;
        }

        public String toString() {
            return this.a;
        }

        public static <T> c<T> a(String debugString) {
            return new c<>(debugString);
        }
    }

    public String toString() {
        return this.f5298a.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r9) {
        /*
            r8 = this;
            r0 = 1
            if (r8 != r9) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            if (r9 == 0) goto L_0x005e
            java.lang.Class r2 = r8.getClass()
            java.lang.Class r3 = r9.getClass()
            if (r2 == r3) goto L_0x0012
            goto L_0x005e
        L_0x0012:
            r2 = r9
            v4 r2 = (defpackage.v4) r2
            java.util.Map<v4$c<?>, java.lang.Object> r3 = r8.f5298a
            int r3 = r3.size()
            java.util.Map<v4$c<?>, java.lang.Object> r4 = r2.f5298a
            int r4 = r4.size()
            if (r3 == r4) goto L_0x0024
            return r1
        L_0x0024:
            java.util.Map<v4$c<?>, java.lang.Object> r3 = r8.f5298a
            java.util.Set r3 = r3.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x002e:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x005d
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.util.Map<v4$c<?>, java.lang.Object> r5 = r2.f5298a
            java.lang.Object r6 = r4.getKey()
            boolean r5 = r5.containsKey(r6)
            if (r5 != 0) goto L_0x0047
            return r1
        L_0x0047:
            java.lang.Object r5 = r4.getValue()
            java.util.Map<v4$c<?>, java.lang.Object> r6 = r2.f5298a
            java.lang.Object r7 = r4.getKey()
            java.lang.Object r6 = r6.get(r7)
            boolean r5 = defpackage.f40.a(r5, r6)
            if (r5 != 0) goto L_0x005c
            return r1
        L_0x005c:
            goto L_0x002e
        L_0x005d:
            return r0
        L_0x005e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v4.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int hashCode = 0;
        for (Map.Entry<Attributes.Key<?>, Object> e : this.f5298a.entrySet()) {
            hashCode += f40.b(e.getKey(), e.getValue());
        }
        return hashCode;
    }

    /* renamed from: v4$b */
    public static final class b {
        private Map<c<?>, Object> a;

        /* renamed from: a  reason: collision with other field name */
        private v4 f5299a;

        private b(v4 base) {
            if (base != null) {
                this.f5299a = base;
                return;
            }
            throw new AssertionError();
        }

        private Map<c<?>, Object> b(int size) {
            if (this.a == null) {
                this.a = new IdentityHashMap(size);
            }
            return this.a;
        }

        public <T> b d(c<T> key, T value) {
            b(1).put(key, value);
            return this;
        }

        public <T> b c(c<T> key) {
            if (this.f5299a.f5298a.containsKey(key)) {
                Map<Attributes.Key<?>, Object> newBaseData = new IdentityHashMap<>(this.f5299a.f5298a);
                newBaseData.remove(key);
                this.f5299a = new v4(newBaseData);
            }
            Map<c<?>, Object> map = this.a;
            if (map != null) {
                map.remove(key);
            }
            return this;
        }

        public v4 a() {
            if (this.a != null) {
                for (Map.Entry<Attributes.Key<?>, Object> entry : this.f5299a.f5298a.entrySet()) {
                    if (!this.a.containsKey(entry.getKey())) {
                        this.a.put(entry.getKey(), entry.getValue());
                    }
                }
                this.f5299a = new v4(this.a);
                this.a = null;
            }
            return this.f5299a;
        }
    }
}
