package defpackage;

/* renamed from: nx  reason: default package */
public class nx {
    private long a;

    public nx(long startAfter) {
        this.a = startAfter;
    }

    public long a() {
        long j = this.a + 1;
        this.a = j;
        return j;
    }
}
