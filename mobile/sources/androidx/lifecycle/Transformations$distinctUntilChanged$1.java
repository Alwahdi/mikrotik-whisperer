package androidx.lifecycle;

final class Transformations$distinctUntilChanged$1 extends ow implements vn<X, jt0> {
    final /* synthetic */ rd0 $firstTime;
    final /* synthetic */ MediatorLiveData<X> $outputLiveData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Transformations$distinctUntilChanged$1(MediatorLiveData<X> mediatorLiveData, rd0 rd0) {
        super(1);
        this.$outputLiveData = mediatorLiveData;
        this.$firstTime = rd0;
    }

    public final void invoke(X value) {
        Object previousValue = this.$outputLiveData.getValue();
        if (this.$firstTime.a || ((previousValue == null && value != null) || (previousValue != null && !lu.a(previousValue, value)))) {
            this.$firstTime.a = false;
            this.$outputLiveData.setValue(value);
        }
    }
}
