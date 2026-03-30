package com.google.protobuf;

import java.util.Arrays;

public final class w {
    private static final w a = new w(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with other field name */
    private int f2608a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f2609a;

    /* renamed from: a  reason: collision with other field name */
    private int[] f2610a;

    /* renamed from: a  reason: collision with other field name */
    private Object[] f2611a;
    private int b = -1;

    public static w a() {
        return a;
    }

    static w c(w first, w second) {
        int count = first.f2608a + second.f2608a;
        int[] tags = Arrays.copyOf(first.f2610a, count);
        System.arraycopy(second.f2610a, 0, tags, first.f2608a, second.f2608a);
        Object[] objects = Arrays.copyOf(first.f2611a, count);
        System.arraycopy(second.f2611a, 0, objects, first.f2608a, second.f2608a);
        return new w(count, tags, objects, true);
    }

    private w(int count, int[] tags, Object[] objects, boolean isMutable) {
        this.f2608a = count;
        this.f2610a = tags;
        this.f2611a = objects;
        this.f2609a = isMutable;
    }

    public void b() {
        this.f2609a = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof w)) {
            return false;
        }
        w other = (w) obj;
        if (this.f2608a != other.f2608a || !Arrays.equals(this.f2610a, other.f2610a) || !Arrays.deepEquals(this.f2611a, other.f2611a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((17 * 31) + this.f2608a) * 31) + Arrays.hashCode(this.f2610a)) * 31) + Arrays.deepHashCode(this.f2611a);
    }

    /* access modifiers changed from: package-private */
    public final void d(StringBuilder buffer, int indent) {
        for (int i = 0; i < this.f2608a; i++) {
            q.c(buffer, indent, String.valueOf(z.a(this.f2610a[i])), this.f2611a[i]);
        }
    }
}
