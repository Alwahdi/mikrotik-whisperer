package kotlin.jvm.internal;

public abstract class b extends a implements wo, cw {
    private final int arity;
    private final int flags;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(int arity2, Object receiver, Class owner, String name, String signature, int flags2) {
        super(receiver, owner, name, signature, (flags2 & 1) == 1);
        this.arity = arity2;
        this.flags = flags2 >> 1;
    }

    public int getArity() {
        return this.arity;
    }

    /* access modifiers changed from: protected */
    public cw getReflected() {
        return (cw) super.getReflected();
    }

    /* access modifiers changed from: protected */
    public zv computeReflected() {
        return xd0.a(this);
    }

    public boolean isInline() {
        return getReflected().isInline();
    }

    public boolean isExternal() {
        return getReflected().isExternal();
    }

    public boolean isOperator() {
        return getReflected().isOperator();
    }

    public boolean isInfix() {
        return getReflected().isInfix();
    }

    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b other = (b) obj;
            if (!getName().equals(other.getName()) || !getSignature().equals(other.getSignature()) || this.flags != other.flags || this.arity != other.arity || !lu.a(getBoundReceiver(), other.getBoundReceiver()) || !lu.a(getOwner(), other.getOwner())) {
                return false;
            }
            return true;
        } else if (obj instanceof cw) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public String toString() {
        zv reflected = compute();
        if (reflected != this) {
            return reflected.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }
}
