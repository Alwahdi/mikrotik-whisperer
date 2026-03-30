package defpackage;

/* renamed from: wj0  reason: default package */
abstract class wj0 {
    static long a;

    /* renamed from: a  reason: collision with other field name */
    static vj0 f5485a;

    static vj0 b() {
        synchronized (wj0.class) {
            vj0 result = f5485a;
            if (result == null) {
                return new vj0();
            }
            f5485a = result.f5387a;
            result.f5387a = null;
            a -= 8192;
            return result;
        }
    }

    static void a(vj0 segment) {
        if (segment.f5387a != null || segment.f5390b != null) {
            throw new IllegalArgumentException();
        } else if (!segment.f5388a) {
            synchronized (wj0.class) {
                long j = a;
                if (j + 8192 <= 65536) {
                    a = j + 8192;
                    segment.f5387a = f5485a;
                    segment.b = 0;
                    segment.a = 0;
                    f5485a = segment;
                }
            }
        }
    }
}
