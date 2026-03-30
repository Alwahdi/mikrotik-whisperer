package defpackage;

/* renamed from: v40  reason: default package */
public final class v40<T> {
    final float a;

    /* renamed from: a  reason: collision with other field name */
    int f5300a;

    /* renamed from: a  reason: collision with other field name */
    T[] f5301a;
    int b;
    int c;

    public v40() {
        this(16, 0.75f);
    }

    public v40(int capacity, float loadFactor) {
        this.a = loadFactor;
        int c2 = t90.a(capacity);
        this.f5300a = c2 - 1;
        this.c = (int) (((float) c2) * loadFactor);
        this.f5301a = new Object[c2];
    }

    public boolean a(T value) {
        T curr;
        T[] a2 = this.f5301a;
        int m = this.f5300a;
        int pos = c(value.hashCode()) & m;
        T curr2 = a2[pos];
        if (curr2 != null) {
            if (curr2.equals(value)) {
                return false;
            }
            do {
                pos = (pos + 1) & m;
                curr = a2[pos];
                if (curr == null) {
                }
            } while (!curr.equals(value));
            return false;
        }
        a2[pos] = value;
        int i = this.b + 1;
        this.b = i;
        if (i >= this.c) {
            d();
        }
        return true;
    }

    public boolean e(T value) {
        T curr;
        T[] a2 = this.f5301a;
        int m = this.f5300a;
        int pos = c(value.hashCode()) & m;
        T curr2 = a2[pos];
        if (curr2 == null) {
            return false;
        }
        if (curr2.equals(value)) {
            return f(pos, a2, m);
        }
        do {
            pos = (pos + 1) & m;
            curr = a2[pos];
            if (curr == null) {
                return false;
            }
        } while (!curr.equals(value));
        return f(pos, a2, m);
    }

    /* access modifiers changed from: package-private */
    public boolean f(int pos, T[] a2, int m) {
        T curr;
        this.b--;
        while (true) {
            int last = pos;
            pos = (pos + 1) & m;
            while (true) {
                curr = a2[pos];
                if (curr == null) {
                    a2[last] = null;
                    return true;
                }
                int slot = c(curr.hashCode()) & m;
                if (last <= pos) {
                    if (last >= slot || slot > pos) {
                        break;
                    }
                    pos = (pos + 1) & m;
                } else {
                    if (last >= slot && slot > pos) {
                        break;
                    }
                    pos = (pos + 1) & m;
                }
            }
            a2[last] = curr;
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        T[] a2 = this.f5301a;
        int i = a2.length;
        int newCap = i << 1;
        int m = newCap - 1;
        T[] b2 = new Object[newCap];
        int pos = this.b;
        while (true) {
            int j = pos - 1;
            if (pos != 0) {
                do {
                    i--;
                } while (a2[i] == null);
                int pos2 = c(a2[i].hashCode()) & m;
                if (b2[pos2] != null) {
                    do {
                        pos2 = (pos2 + 1) & m;
                    } while (b2[pos2] != null);
                }
                b2[pos2] = a2[i];
                pos = j;
            } else {
                this.f5300a = m;
                this.c = (int) (((float) newCap) * this.a);
                this.f5301a = b2;
                return;
            }
        }
    }

    static int c(int x) {
        int h = -1640531527 * x;
        return (h >>> 16) ^ h;
    }

    public Object[] b() {
        return this.f5301a;
    }
}
