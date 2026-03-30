package androidx.lifecycle;

public final class Transformations$switchMap$1 implements Observer<X> {
    final /* synthetic */ MediatorLiveData<Y> $result;
    final /* synthetic */ vn<X, LiveData<Y>> $transform;
    private LiveData<Y> liveData;

    Transformations$switchMap$1(vn<X, LiveData<Y>> $transform2, MediatorLiveData<Y> $result2) {
        this.$transform = $transform2;
        this.$result = $result2;
    }

    public final LiveData<Y> getLiveData() {
        return this.liveData;
    }

    public final void setLiveData(LiveData<Y> liveData2) {
        this.liveData = liveData2;
    }

    public void onChanged(X value) {
        LiveData newLiveData = this.$transform.invoke(value);
        LiveData liveData2 = this.liveData;
        if (liveData2 != newLiveData) {
            if (liveData2 != null) {
                MediatorLiveData<Y> mediatorLiveData = this.$result;
                lu.c(liveData2);
                mediatorLiveData.removeSource(liveData2);
            }
            this.liveData = newLiveData;
            if (newLiveData != null) {
                MediatorLiveData<Y> mediatorLiveData2 = this.$result;
                lu.c(newLiveData);
                mediatorLiveData2.addSource(newLiveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Transformations$switchMap$1$onChanged$1(this.$result)));
            }
        }
    }
}
