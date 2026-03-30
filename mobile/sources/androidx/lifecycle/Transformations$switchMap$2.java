package androidx.lifecycle;

import androidx.arch.core.util.Function;

public final class Transformations$switchMap$2 implements Observer {
    final /* synthetic */ MediatorLiveData $result;
    final /* synthetic */ Function $switchMapFunction;
    private LiveData liveData;

    Transformations$switchMap$2(Function $switchMapFunction2, MediatorLiveData $result2) {
        this.$switchMapFunction = $switchMapFunction2;
        this.$result = $result2;
    }

    public final LiveData getLiveData() {
        return this.liveData;
    }

    public final void setLiveData(LiveData liveData2) {
        this.liveData = liveData2;
    }

    public void onChanged(Object value) {
        LiveData newLiveData = (LiveData) this.$switchMapFunction.apply(value);
        LiveData liveData2 = this.liveData;
        if (liveData2 != newLiveData) {
            if (liveData2 != null) {
                MediatorLiveData mediatorLiveData = this.$result;
                lu.c(liveData2);
                mediatorLiveData.removeSource(liveData2);
            }
            this.liveData = newLiveData;
            if (newLiveData != null) {
                MediatorLiveData mediatorLiveData2 = this.$result;
                lu.c(newLiveData);
                mediatorLiveData2.addSource(newLiveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Transformations$switchMap$2$onChanged$1(this.$result)));
            }
        }
    }
}
