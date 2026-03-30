package androidx.lifecycle;

import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;

public class MediatorLiveData<T> extends MutableLiveData<T> {
    private SafeIterableMap<LiveData<?>, Source<?>> mSources = new SafeIterableMap<>();

    public MediatorLiveData() {
    }

    public MediatorLiveData(T value) {
        super(value);
    }

    @MainThread
    public <S> void addSource(@NonNull LiveData<S> source, @NonNull Observer<? super S> onChanged) {
        if (source != null) {
            Source<S> e = new Source<>(source, onChanged);
            Source<?> existing = this.mSources.putIfAbsent(source, e);
            if (existing != null && existing.mObserver != onChanged) {
                throw new IllegalArgumentException("This source was already added with the different observer");
            } else if (existing == null && hasActiveObservers()) {
                e.plug();
            }
        } else {
            throw new NullPointerException("source cannot be null");
        }
    }

    @MainThread
    public <S> void removeSource(@NonNull LiveData<S> toRemote) {
        Source<?> source = this.mSources.remove(toRemote);
        if (source != null) {
            source.unplug();
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onActive() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> it = this.mSources.iterator();
        while (it.hasNext()) {
            it.next().getValue().plug();
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onInactive() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> it = this.mSources.iterator();
        while (it.hasNext()) {
            it.next().getValue().unplug();
        }
    }

    private static class Source<V> implements Observer<V> {
        final LiveData<V> mLiveData;
        final Observer<? super V> mObserver;
        int mVersion = -1;

        Source(LiveData<V> liveData, Observer<? super V> observer) {
            this.mLiveData = liveData;
            this.mObserver = observer;
        }

        /* access modifiers changed from: package-private */
        public void plug() {
            this.mLiveData.observeForever(this);
        }

        /* access modifiers changed from: package-private */
        public void unplug() {
            this.mLiveData.removeObserver(this);
        }

        public void onChanged(@Nullable V v) {
            if (this.mVersion != this.mLiveData.getVersion()) {
                this.mVersion = this.mLiveData.getVersion();
                this.mObserver.onChanged(v);
            }
        }
    }
}
