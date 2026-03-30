package androidx.lifecycle;

final class Transformations$switchMap$2$onChanged$1 extends ow implements vn {
    final /* synthetic */ MediatorLiveData $result;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Transformations$switchMap$2$onChanged$1(MediatorLiveData mediatorLiveData) {
        super(1);
        this.$result = mediatorLiveData;
    }

    public final void invoke(Object y) {
        this.$result.setValue(y);
    }
}
