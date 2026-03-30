package defpackage;

import defpackage.ew;

/* renamed from: gb0  reason: default package */
public abstract class gb0 extends ib0 implements ew {
    public gb0(Object receiver, Class owner, String name, String signature, int flags) {
        super(receiver, owner, name, signature, flags);
    }

    /* access modifiers changed from: protected */
    public zv computeReflected() {
        return xd0.e(this);
    }

    public Object invoke(Object receiver) {
        return get(receiver);
    }

    public ew.a e() {
        return ((ew) getReflected()).e();
    }
}
