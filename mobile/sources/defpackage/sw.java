package defpackage;

/* renamed from: sw  reason: default package */
public class sw<T> implements mb0<T> {
    private static final Object b = new Object();
    private volatile Object a = b;

    /* renamed from: a  reason: collision with other field name */
    private volatile mb0<T> f5058a;

    public sw(mb0<T> provider) {
        this.f5058a = provider;
    }

    public T get() {
        Object result = this.a;
        Object obj = b;
        if (result == obj) {
            synchronized (this) {
                result = this.a;
                if (result == obj) {
                    result = this.f5058a.get();
                    this.a = result;
                    this.f5058a = null;
                }
            }
        }
        return result;
    }
}
