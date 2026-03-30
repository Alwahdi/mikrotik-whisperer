package defpackage;

import java.io.Serializable;

/* renamed from: g0  reason: default package */
public class g0 implements Comparable<g0>, Serializable {
    private static int b = 0;
    private int a = 0;

    public g0() {
        int i = b + 1;
        b = i;
        this.a = i;
    }

    public String toString() {
        return Integer.toString(this.a);
    }

    public int hashCode() {
        return this.a;
    }

    public boolean equals(Object o) {
        return (o instanceof g0) && this.a == ((g0) o).a;
    }

    /* renamed from: a */
    public int compareTo(g0 elementId) {
        int i = this.a;
        int i2 = elementId.a;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        return 0;
    }
}
