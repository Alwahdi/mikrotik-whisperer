package defpackage;

/* renamed from: eb0  reason: default package */
public abstract class eb0 extends ib0 implements dw {
    public eb0(Object receiver, Class owner, String name, String signature, int flags) {
        super(receiver, owner, name, signature, flags);
    }

    /* access modifiers changed from: protected */
    public zv computeReflected() {
        return xd0.d(this);
    }

    public Object invoke() {
        return get();
    }
}
