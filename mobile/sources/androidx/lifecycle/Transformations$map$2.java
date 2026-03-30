package androidx.lifecycle;

import androidx.arch.core.util.Function;

final class Transformations$map$2 extends ow implements vn {
    final /* synthetic */ Function $mapFunction;
    final /* synthetic */ MediatorLiveData $result;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Transformations$map$2(MediatorLiveData mediatorLiveData, Function function) {
        super(1);
        this.$result = mediatorLiveData;
        this.$mapFunction = function;
    }

    public final void invoke(Object x) {
        this.$result.setValue(this.$mapFunction.apply(x));
    }
}
