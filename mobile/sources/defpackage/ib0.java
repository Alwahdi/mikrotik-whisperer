package defpackage;

import kotlin.jvm.internal.a;

/* renamed from: ib0  reason: default package */
public abstract class ib0 extends a implements fw {
    private final boolean a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ib0(Object receiver, Class owner, String name, String signature, int flags) {
        super(receiver, owner, name, signature, (flags & 1) == 1);
        boolean z = false;
        this.a = (flags & 2) == 2 ? true : z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public fw getReflected() {
        if (!this.a) {
            return (fw) super.getReflected();
        }
        throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties");
    }

    public zv compute() {
        return this.a ? this : super.compute();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ib0) {
            ib0 other = (ib0) obj;
            if (!getOwner().equals(other.getOwner()) || !getName().equals(other.getName()) || !getSignature().equals(other.getSignature()) || !lu.a(getBoundReceiver(), other.getBoundReceiver())) {
                return false;
            }
            return true;
        } else if (obj instanceof fw) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public String toString() {
        zv reflected = compute();
        if (reflected != this) {
            return reflected.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }
}
