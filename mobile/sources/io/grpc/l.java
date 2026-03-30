package io.grpc;

import io.grpc.Metadata;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public final class l {
    public static final d<String> a = new b();

    /* renamed from: a  reason: collision with other field name */
    public static final e<byte[]> f3798a = new a();

    /* renamed from: a  reason: collision with other field name */
    static final x5 f3799a = x5.a().k();

    /* renamed from: a  reason: collision with other field name */
    private int f3800a;

    /* renamed from: a  reason: collision with other field name */
    private Object[] f3801a;

    public interface d<T> {
        T a(String str);

        String b(T t);
    }

    public interface e<T> {
    }

    public interface f<T> {
        T a(InputStream inputStream);

        InputStream b(T t);
    }

    interface j<T> {
        byte[] a(T t);

        T b(byte[] bArr);
    }

    class a implements e<byte[]> {
        a() {
        }
    }

    class b implements d<String> {
        b() {
        }

        /* renamed from: d */
        public String b(String value) {
            return value;
        }

        /* renamed from: c */
        public String a(String serialized) {
            return serialized;
        }
    }

    l(byte[]... binaryValues) {
        this(binaryValues.length / 2, binaryValues);
    }

    l(int usedNames, byte[]... binaryValues) {
        this(usedNames, (Object[]) binaryValues);
    }

    l(int usedNames, Object[] namesAndValues) {
        if ((namesAndValues.length & 1) == 0) {
            this.f3800a = usedNames;
            this.f3801a = namesAndValues;
            return;
        }
        throw new AssertionError("Odd number of key-value pairs " + namesAndValues.length);
    }

    private byte[] n(int i2) {
        return (byte[]) this.f3801a[i2 * 2];
    }

    private void m(int i2, byte[] name) {
        this.f3801a[i2 * 2] = name;
    }

    private Object r(int i2) {
        return this.f3801a[(i2 * 2) + 1];
    }

    private void t(int i2, byte[] value) {
        this.f3801a[(i2 * 2) + 1] = value;
    }

    private void s(int i2, Object value) {
        if (this.f3801a instanceof byte[][]) {
            e(c());
        }
        this.f3801a[(i2 * 2) + 1] = value;
    }

    private byte[] u(int i2) {
        Object value = r(i2);
        if (value instanceof byte[]) {
            return (byte[]) value;
        }
        return ((h) value).c();
    }

    private <T> T v(int i2, g<T> key) {
        Object value = r(i2);
        if (value instanceof byte[]) {
            return key.h((byte[]) value);
        }
        return ((h) value).d(key);
    }

    private int c() {
        Object[] objArr = this.f3801a;
        if (objArr != null) {
            return objArr.length;
        }
        return 0;
    }

    private int j() {
        return this.f3800a * 2;
    }

    private boolean h() {
        return this.f3800a == 0;
    }

    public l() {
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f3800a;
    }

    public <T> T f(g<T> key) {
        for (int i2 = this.f3800a - 1; i2 >= 0; i2--) {
            if (b(key.a(), n(i2))) {
                return v(i2, key);
            }
        }
        return null;
    }

    public Set<String> i() {
        if (h()) {
            return Collections.emptySet();
        }
        Set<String> ks = new HashSet<>(this.f3800a);
        for (int i2 = 0; i2 < this.f3800a; i2++) {
            ks.add(new String(n(i2), 0));
        }
        return Collections.unmodifiableSet(ks);
    }

    public <T> void o(g<T> key, T value) {
        v90.o(key, "key");
        v90.o(value, "value");
        k();
        m(this.f3800a, key.a());
        if (key.i()) {
            s(this.f3800a, h.a(key, value));
        } else {
            t(this.f3800a, key.j(value));
        }
        this.f3800a++;
    }

    private void k() {
        if (j() == 0 || j() == c()) {
            e(Math.max(j() * 2, 8));
        }
    }

    private void e(int newCapacity) {
        Object[] newNamesAndValues = new Object[newCapacity];
        if (!h()) {
            System.arraycopy(this.f3801a, 0, newNamesAndValues, 0, j());
        }
        this.f3801a = newNamesAndValues;
    }

    public <T> void d(g<T> key) {
        if (!h()) {
            int writeIdx = 0;
            for (int readIdx = 0; readIdx < this.f3800a; readIdx++) {
                if (!b(key.a(), n(readIdx))) {
                    m(writeIdx, n(readIdx));
                    s(writeIdx, r(readIdx));
                    writeIdx++;
                }
            }
            Arrays.fill(this.f3801a, writeIdx * 2, j(), (Object) null);
            this.f3800a = writeIdx;
        }
    }

    /* access modifiers changed from: package-private */
    public byte[][] p() {
        byte[][] serialized = new byte[j()][];
        Object[] objArr = this.f3801a;
        if (objArr instanceof byte[][]) {
            System.arraycopy(objArr, 0, serialized, 0, j());
        } else {
            for (int i2 = 0; i2 < this.f3800a; i2++) {
                serialized[i2 * 2] = n(i2);
                serialized[(i2 * 2) + 1] = u(i2);
            }
        }
        return serialized;
    }

    public void l(l other) {
        if (!other.h()) {
            int remaining = c() - j();
            if (h() || remaining < other.j()) {
                e(j() + other.j());
            }
            System.arraycopy(other.f3801a, 0, this.f3801a, j(), other.j());
            this.f3800a += other.f3800a;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Metadata(");
        for (int i2 = 0; i2 < this.f3800a; i2++) {
            if (i2 != 0) {
                sb.append(',');
            }
            byte[] n = n(i2);
            Charset charset = j8.a;
            String headerName = new String(n, charset);
            sb.append(headerName);
            sb.append('=');
            if (headerName.endsWith("-bin")) {
                sb.append(f3799a.e(u(i2)));
            } else {
                sb.append(new String(u(i2), charset));
            }
        }
        sb.append(')');
        return sb.toString();
    }

    private boolean b(byte[] left, byte[] right) {
        return Arrays.equals(left, right);
    }

    public static abstract class g<T> {
        private static final BitSet a = b();

        /* renamed from: a  reason: collision with other field name */
        private final Object f3802a;

        /* renamed from: a  reason: collision with other field name */
        private final String f3803a;

        /* renamed from: a  reason: collision with other field name */
        private final byte[] f3804a;
        private final String b;

        /* access modifiers changed from: package-private */
        public abstract T h(byte[] bArr);

        /* access modifiers changed from: package-private */
        public abstract byte[] j(T t);

        /* synthetic */ g(String x0, boolean x1, Object x2, a x3) {
            this(x0, x1, x2);
        }

        public static <T> g<T> e(String name, d<T> marshaller) {
            return f(name, false, marshaller);
        }

        static <T> g<T> f(String name, boolean pseudo, d<T> marshaller) {
            return new c(name, pseudo, marshaller, (a) null);
        }

        static <T> g<T> g(String name, boolean pseudo, j<T> marshaller) {
            return new i(name, pseudo, marshaller, (a) null);
        }

        private static BitSet b() {
            BitSet valid = new BitSet(127);
            valid.set(45);
            valid.set(95);
            valid.set(46);
            for (char c = '0'; c <= '9'; c = (char) (c + 1)) {
                valid.set(c);
            }
            for (char c2 = 'a'; c2 <= 'z'; c2 = (char) (c2 + 1)) {
                valid.set(c2);
            }
            return valid;
        }

        private static String k(String n, boolean pseudo) {
            v90.o(n, "name");
            v90.e(!n.isEmpty(), "token must have at least 1 tchar");
            for (int i = 0; i < n.length(); i++) {
                char tChar = n.charAt(i);
                if (!pseudo || tChar != ':' || i != 0) {
                    v90.g(a.get(tChar), "Invalid character '%s' in key name '%s'", tChar, n);
                }
            }
            return n;
        }

        private g(String name, boolean pseudo, Object marshaller) {
            String str = (String) v90.o(name, "name");
            this.f3803a = str;
            String k = k(str.toLowerCase(Locale.ROOT), pseudo);
            this.b = k;
            this.f3804a = k.getBytes(j8.a);
            this.f3802a = marshaller;
        }

        public final String d() {
            return this.b;
        }

        /* access modifiers changed from: package-private */
        public byte[] a() {
            return this.f3804a;
        }

        public final boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            return this.b.equals(((g) o).b);
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return "Key{name='" + this.b + "'}";
        }

        /* access modifiers changed from: package-private */
        public boolean i() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public final <M> M c(Class<M> marshallerClass) {
            if (marshallerClass.isInstance(this.f3802a)) {
                return marshallerClass.cast(this.f3802a);
            }
            return null;
        }
    }

    static final class h<T> {
        private final f<T> a;

        /* renamed from: a  reason: collision with other field name */
        private final T f3805a;

        /* renamed from: a  reason: collision with other field name */
        private volatile byte[] f3806a;

        static <T> h<T> a(g<T> key, T value) {
            return new h<>((f) v90.n(b(key)), value);
        }

        h(f<T> marshaller, T value) {
            this.a = marshaller;
            this.f3805a = value;
        }

        /* access modifiers changed from: package-private */
        public InputStream e() {
            return this.a.b(this.f3805a);
        }

        /* access modifiers changed from: package-private */
        public byte[] c() {
            if (this.f3806a == null) {
                synchronized (this) {
                    if (this.f3806a == null) {
                        this.f3806a = l.q(e());
                    }
                }
            }
            return this.f3806a;
        }

        /* access modifiers changed from: package-private */
        public <T2> T2 d(g<T2> key) {
            Metadata.BinaryStreamMarshaller<T2> marshaller;
            if (!key.i() || (marshaller = b(key)) == null) {
                return key.h(c());
            }
            return marshaller.a(e());
        }

        private static <T> f<T> b(g<T> key) {
            return (f) key.c(f.class);
        }
    }

    private static class c<T> extends g<T> {
        private final d<T> a;

        /* synthetic */ c(String x0, boolean x1, d x2, a x3) {
            this(x0, x1, x2);
        }

        private c(String name, boolean pseudo, d<T> marshaller) {
            super(name, pseudo, marshaller, (a) null);
            v90.k(!name.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", name, "-bin");
            this.a = (d) v90.o(marshaller, "marshaller");
        }

        /* access modifiers changed from: package-private */
        public byte[] j(T value) {
            return this.a.b(value).getBytes(j8.a);
        }

        /* access modifiers changed from: package-private */
        public T h(byte[] serialized) {
            return this.a.a(new String(serialized, j8.a));
        }
    }

    private static final class i<T> extends g<T> {
        private final j<T> a;

        /* synthetic */ i(String x0, boolean x1, j x2, a x3) {
            this(x0, x1, x2);
        }

        private i(String name, boolean pseudo, j<T> marshaller) {
            super(name, pseudo, marshaller, (a) null);
            v90.k(!name.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", name, "-bin");
            this.a = (j) v90.o(marshaller, "marshaller");
        }

        /* access modifiers changed from: package-private */
        public byte[] j(T value) {
            return this.a.a(value);
        }

        /* access modifiers changed from: package-private */
        public T h(byte[] serialized) {
            return this.a.b(serialized);
        }
    }

    /* access modifiers changed from: private */
    public static byte[] q(InputStream stream) {
        try {
            return z6.d(stream);
        } catch (IOException ioe) {
            throw new RuntimeException("failure reading serialized stream", ioe);
        }
    }
}
