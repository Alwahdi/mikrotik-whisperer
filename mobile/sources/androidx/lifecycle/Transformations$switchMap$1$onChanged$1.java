package androidx.lifecycle;

final class Transformations$switchMap$1$onChanged$1 extends ow implements vn<Y, jt0> {
    final /* synthetic */ MediatorLiveData<Y> $result;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Transformations$switchMap$1$onChanged$1(MediatorLiveData<Y> mediatorLiveData) {
        super(1);
        this.$result = mediatorLiveData;
    }

    public final void invoke(Y y) {
        this.$result.setValue(y);
    }
}
