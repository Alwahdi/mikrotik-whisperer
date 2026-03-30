package defpackage;

import java.util.Arrays;

/* renamed from: ys  reason: default package */
public class ys implements Cloneable {
    private float a;

    /* renamed from: a  reason: collision with other field name */
    private transient int f5933a;

    /* renamed from: a  reason: collision with other field name */
    private transient a[] f5934a;
    private int b;

    public ys() {
        this(150, 0.75f);
    }

    public ys(int initialCapacity) {
        this(initialCapacity, 0.75f);
    }

    public ys(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException(i10.a("illegal.capacity.1", initialCapacity));
        } else if (loadFactor > 0.0f) {
            initialCapacity = initialCapacity == 0 ? 1 : initialCapacity;
            this.a = loadFactor;
            this.f5934a = new a[initialCapacity];
            this.b = (int) (((float) initialCapacity) * loadFactor);
        } else {
            throw new IllegalArgumentException(i10.b("illegal.load.1", String.valueOf(loadFactor)));
        }
    }

    public int g() {
        return this.f5933a;
    }

    public boolean a(int key) {
        a[] tab = this.f5934a;
        int hash = key;
        for (a e = tab[(Integer.MAX_VALUE & hash) % tab.length]; e != null; e = e.f5935a) {
            if (e.a == hash && e.b == key) {
                return true;
            }
        }
        return false;
    }

    public int b(int key) {
        a[] tab = this.f5934a;
        int hash = key;
        for (a e = tab[(Integer.MAX_VALUE & hash) % tab.length]; e != null; e = e.f5935a) {
            if (e.a == hash && e.b == key) {
                return e.c;
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void e() {
        int oldCapacity = this.f5934a.length;
        a[] oldMap = this.f5934a;
        int newCapacity = (oldCapacity * 2) + 1;
        a[] newMap = new a[newCapacity];
        this.b = (int) (((float) newCapacity) * this.a);
        this.f5934a = newMap;
        int i = oldCapacity;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                a old = oldMap[i2];
                while (old != null) {
                    a e = old;
                    old = old.f5935a;
                    int index = (e.a & Integer.MAX_VALUE) % newCapacity;
                    e.f5935a = newMap[index];
                    newMap[index] = e;
                }
                i = i2;
            } else {
                return;
            }
        }
    }

    public int d(int key, int value) {
        a[] tab = this.f5934a;
        int hash = key;
        int index = (hash & Integer.MAX_VALUE) % tab.length;
        for (a e = tab[index]; e != null; e = e.f5935a) {
            if (e.a == hash && e.b == key) {
                int old = e.c;
                e.c = value;
                return old;
            }
        }
        if (this.f5933a >= this.b) {
            e();
            tab = this.f5934a;
            index = (Integer.MAX_VALUE & hash) % tab.length;
        }
        tab[index] = new a(hash, key, value, tab[index]);
        this.f5933a++;
        return 0;
    }

    /* renamed from: ys$a */
    static class a {
        int a;

        /* renamed from: a  reason: collision with other field name */
        a f5935a;
        int b;
        int c;

        protected a(int hash, int key, int value, a next) {
            this.a = hash;
            this.b = key;
            this.c = value;
            this.f5935a = next;
        }

        /* access modifiers changed from: protected */
        public Object clone() {
            int i = this.a;
            int i2 = this.b;
            int i3 = this.c;
            a aVar = this.f5935a;
            return new a(i, i2, i3, aVar != null ? (a) aVar.clone() : null);
        }
    }

    public int[] h() {
        int[] res = c();
        Arrays.sort(res);
        return res;
    }

    public int[] c() {
        int index;
        int[] res = new int[this.f5933a];
        int ptr = 0;
        int index2 = this.f5934a.length;
        a entry = null;
        while (true) {
            if (entry == null) {
                while (true) {
                    index = index2 - 1;
                    if (index2 <= 0) {
                        break;
                    }
                    a aVar = this.f5934a[index];
                    entry = aVar;
                    if (aVar != null) {
                        break;
                    }
                    index2 = index;
                }
                index2 = index;
            }
            if (entry == null) {
                return res;
            }
            a e = entry;
            entry = e.f5935a;
            res[ptr] = e.b;
            ptr++;
        }
    }

    public Object clone() {
        try {
            ys t = (ys) super.clone();
            t.f5934a = new a[this.f5934a.length];
            int i = this.f5934a.length;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    return t;
                }
                a[] aVarArr = t.f5934a;
                a[] aVarArr2 = this.f5934a;
                aVarArr[i2] = aVarArr2[i2] != null ? (a) aVarArr2[i2].clone() : null;
                i = i2;
            }
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
}
