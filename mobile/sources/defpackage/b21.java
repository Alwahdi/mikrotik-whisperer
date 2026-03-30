package defpackage;

import java.util.Arrays;

/* renamed from: b21  reason: default package */
public final class b21<K, V> {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f145a;

    /* renamed from: a  reason: collision with other field name */
    private Object[] f146a;

    public b21() {
        this(4);
    }

    private b21(int i) {
        this.f146a = new Object[8];
        this.a = 0;
        this.f145a = false;
    }

    public final b21<K, V> a(K k, V v) {
        int i = (this.a + 1) << 1;
        Object[] objArr = this.f146a;
        if (i > objArr.length) {
            int length = objArr.length;
            if (i >= 0) {
                int i2 = length + (length >> 1) + 1;
                if (i2 < i) {
                    i2 = Integer.highestOneBit(i - 1) << 1;
                }
                if (i2 < 0) {
                    i2 = Integer.MAX_VALUE;
                }
                this.f146a = Arrays.copyOf(objArr, i2);
                this.f145a = false;
            } else {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
        }
        s11.a(k, v);
        Object[] objArr2 = this.f146a;
        int i3 = this.a;
        objArr2[i3 * 2] = k;
        objArr2[(i3 * 2) + 1] = v;
        this.a = i3 + 1;
        return this;
    }

    public final d21<K, V> b() {
        this.f145a = true;
        return l21.f(this.a, this.f146a);
    }
}
