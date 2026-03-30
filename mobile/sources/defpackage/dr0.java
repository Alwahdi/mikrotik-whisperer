package defpackage;

/* renamed from: dr0  reason: default package */
final class dr0 {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    public final yc f2817a;

    /* renamed from: a  reason: collision with other field name */
    private final Object[] f2818a;

    /* renamed from: a  reason: collision with other field name */
    private final wq0<Object>[] f2819a;

    public dr0(yc context, int n) {
        this.f2817a = context;
        this.f2818a = new Object[n];
        this.f2819a = new wq0[n];
    }

    public final void a(wq0<?> element, Object value) {
        Object[] objArr = this.f2818a;
        int i = this.a;
        objArr[i] = value;
        wq0<Object>[] wq0Arr = this.f2819a;
        this.a = i + 1;
        wq0Arr[i] = element;
    }

    public final void b(yc context) {
        int length = this.f2819a.length - 1;
        if (length >= 0) {
            do {
                int i = length;
                length--;
                wq0<Object> wq0 = this.f2819a[i];
                lu.c(wq0);
                wq0.f(context, this.f2818a[i]);
            } while (length >= 0);
        }
    }
}
