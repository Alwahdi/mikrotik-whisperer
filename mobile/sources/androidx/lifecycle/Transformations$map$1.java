package androidx.lifecycle;

final class Transformations$map$1 extends ow implements vn<X, jt0> {
    final /* synthetic */ MediatorLiveData<Y> $result;
    final /* synthetic */ vn<X, Y> $transform;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Transformations$map$1(MediatorLiveData<Y> mediatorLiveData, vn<X, Y> vnVar) {
        super(1);
        this.$result = mediatorLiveData;
        this.$transform = vnVar;
    }

    public final void invoke(X x) {
        this.$result.setValue(this.$transform.invoke(x));
    }
}
