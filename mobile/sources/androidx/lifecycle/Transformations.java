package androidx.lifecycle;

import androidx.annotation.CheckResult;
import androidx.annotation.MainThread;
import androidx.arch.core.util.Function;

public final class Transformations {
    @CheckResult
    @MainThread
    public static final <X, Y> LiveData<Y> map(LiveData<X> $this$map, vn<X, Y> transform) {
        lu.f($this$map, "<this>");
        lu.f(transform, "transform");
        MediatorLiveData result = new MediatorLiveData();
        result.addSource($this$map, new Transformations$sam$androidx_lifecycle_Observer$0(new Transformations$map$1(result, transform)));
        return result;
    }

    @CheckResult
    @MainThread
    public static final /* synthetic */ LiveData map(LiveData $this$map, Function mapFunction) {
        lu.f($this$map, "<this>");
        lu.f(mapFunction, "mapFunction");
        MediatorLiveData result = new MediatorLiveData();
        result.addSource($this$map, new Transformations$sam$androidx_lifecycle_Observer$0(new Transformations$map$2(result, mapFunction)));
        return result;
    }

    @CheckResult
    @MainThread
    public static final <X, Y> LiveData<Y> switchMap(LiveData<X> $this$switchMap, vn<X, LiveData<Y>> transform) {
        lu.f($this$switchMap, "<this>");
        lu.f(transform, "transform");
        MediatorLiveData result = new MediatorLiveData();
        result.addSource($this$switchMap, new Transformations$switchMap$1(transform, result));
        return result;
    }

    @CheckResult
    @MainThread
    public static final /* synthetic */ LiveData switchMap(LiveData $this$switchMap, Function switchMapFunction) {
        lu.f($this$switchMap, "<this>");
        lu.f(switchMapFunction, "switchMapFunction");
        MediatorLiveData result = new MediatorLiveData();
        result.addSource($this$switchMap, new Transformations$switchMap$2(switchMapFunction, result));
        return result;
    }

    @CheckResult
    @MainThread
    public static final <X> LiveData<X> distinctUntilChanged(LiveData<X> $this$distinctUntilChanged) {
        lu.f($this$distinctUntilChanged, "<this>");
        MediatorLiveData outputLiveData = new MediatorLiveData();
        rd0 firstTime = new rd0();
        firstTime.a = true;
        if ($this$distinctUntilChanged.isInitialized()) {
            outputLiveData.setValue($this$distinctUntilChanged.getValue());
            firstTime.a = false;
        }
        outputLiveData.addSource($this$distinctUntilChanged, new Transformations$sam$androidx_lifecycle_Observer$0(new Transformations$distinctUntilChanged$1(outputLiveData, firstTime)));
        return outputLiveData;
    }
}
