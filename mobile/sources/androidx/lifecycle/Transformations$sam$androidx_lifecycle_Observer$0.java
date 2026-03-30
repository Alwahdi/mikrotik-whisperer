package androidx.lifecycle;

final class Transformations$sam$androidx_lifecycle_Observer$0 implements Observer, vo {
    private final /* synthetic */ vn function;

    Transformations$sam$androidx_lifecycle_Observer$0(vn vnVar) {
        lu.f(vnVar, "function");
        this.function = vnVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Observer) || !(obj instanceof vo)) {
            return false;
        }
        return lu.a(getFunctionDelegate(), ((vo) obj).getFunctionDelegate());
    }

    public final oo<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    public final /* synthetic */ void onChanged(Object obj) {
        this.function.invoke(obj);
    }
}
