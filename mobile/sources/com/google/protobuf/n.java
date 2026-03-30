package com.google.protobuf;

import com.google.protobuf.p;
import com.google.protobuf.z;

public class n<K, V> {
    private final b<K, V> a;

    /* renamed from: a  reason: collision with other field name */
    private final K f2585a;
    private final V b;

    static class b<K, V> {
        public final z.b a;

        /* renamed from: a  reason: collision with other field name */
        public final K f2586a;
        public final z.b b;

        /* renamed from: b  reason: collision with other field name */
        public final V f2587b;

        public b(z.b keyType, K defaultKey, z.b valueType, V defaultValue) {
            this.a = keyType;
            this.f2586a = defaultKey;
            this.b = valueType;
            this.f2587b = defaultValue;
        }
    }

    private n(z.b keyType, K defaultKey, z.b valueType, V defaultValue) {
        this.a = new b<>(keyType, defaultKey, valueType, defaultValue);
        this.f2585a = defaultKey;
        this.b = defaultValue;
    }

    public static <K, V> n<K, V> c(z.b keyType, K defaultKey, z.b valueType, V defaultValue) {
        return new n<>(keyType, defaultKey, valueType, defaultValue);
    }

    static <K, V> void g(g output, b<K, V> metadata, K key, V value) {
        h.j(output, metadata.a, 1, key);
        h.j(output, metadata.b, 2, value);
    }

    static <K, V> int b(b<K, V> metadata, K key, V value) {
        return h.b(metadata.a, 1, key) + h.b(metadata.b, 2, value);
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[z.b.values().length];
            a = iArr;
            try {
                iArr[z.b.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[z.b.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[z.b.GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    static <T> T d(f input, fk extensionRegistry, z.b type, T value) {
        switch (a.a[type.ordinal()]) {
            case 1:
                p.a subBuilder = ((p) value).a();
                input.v(subBuilder, extensionRegistry);
                return subBuilder.f();
            case 2:
                return Integer.valueOf(input.o());
            case 3:
                throw new RuntimeException("Groups are not allowed in maps.");
            default:
                return h.g(input, type, true);
        }
    }

    public void f(g output, int fieldNumber, K key, V value) {
        output.t0(fieldNumber, 2);
        output.u0(b(this.a, key, value));
        g(output, this.a, key, value);
    }

    public int a(int fieldNumber, K key, V value) {
        return g.F(fieldNumber) + g.v(b(this.a, key, value));
    }

    public void e(o<K, V> map, f input, fk extensionRegistry) {
        int oldLimit = input.k(input.A());
        b<K, V> bVar = this.a;
        K key = bVar.f2586a;
        V value = bVar.f2587b;
        while (true) {
            int tag = input.J();
            if (tag == 0) {
                break;
            } else if (tag == z.c(1, this.a.a.getWireType())) {
                key = d(input, extensionRegistry, this.a.a, key);
            } else if (tag == z.c(2, this.a.b.getWireType())) {
                value = d(input, extensionRegistry, this.a.b, value);
            } else if (!input.P(tag)) {
                break;
            }
        }
        input.a(0);
        input.j(oldLimit);
        map.put(key, value);
    }
}
