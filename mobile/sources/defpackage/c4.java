package defpackage;

/* renamed from: c4  reason: default package */
public class c4<T> {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private Object[] f283a = new Object[16];
    private int b;

    public final boolean c() {
        return this.a == this.b;
    }

    public final void a(T element) {
        Object[] objArr = this.f283a;
        int i = this.b;
        objArr[i] = element;
        int length = (objArr.length - 1) & (i + 1);
        this.b = length;
        if (length == this.a) {
            b();
        }
    }

    public final T d() {
        int i = this.a;
        if (i == this.b) {
            return null;
        }
        Object[] objArr = this.f283a;
        Object element = objArr[i];
        objArr[i] = null;
        this.a = (i + 1) & (objArr.length - 1);
        if (element != null) {
            return element;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
    }

    private final void b() {
        Object[] objArr = this.f283a;
        int currentSize = objArr.length;
        Object[] newElements = new Object[(currentSize << 1)];
        Object[] newElements2 = newElements;
        Object[] unused = k4.d(objArr, newElements2, 0, this.a, 0, 10, (Object) null);
        Object[] objArr2 = this.f283a;
        int length = objArr2.length;
        int i = this.a;
        Object[] unused2 = k4.d(objArr2, newElements, length - i, 0, i, 4, (Object) null);
        this.f283a = newElements2;
        this.a = 0;
        this.b = currentSize;
    }
}
