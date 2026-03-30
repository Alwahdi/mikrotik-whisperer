package defpackage;

import java.util.NoSuchElementException;

/* renamed from: ct  reason: default package */
public final class ct extends zs {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f2673a;
    private final int b;
    private int c;

    public ct(int first, int last, int step) {
        this.a = step;
        this.b = last;
        boolean z = true;
        if (step <= 0 ? first < last : first > last) {
            z = false;
        }
        this.f2673a = z;
        this.c = z ? first : last;
    }

    public boolean hasNext() {
        return this.f2673a;
    }

    public int nextInt() {
        int value = this.c;
        if (value != this.b) {
            this.c += this.a;
        } else if (this.f2673a) {
            this.f2673a = false;
        } else {
            throw new NoSuchElementException();
        }
        return value;
    }
}
