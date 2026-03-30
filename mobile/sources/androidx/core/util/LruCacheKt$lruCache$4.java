package androidx.core.util;

import android.util.LruCache;

public final class LruCacheKt$lruCache$4 extends LruCache<K, V> {
    final /* synthetic */ vn<K, V> $create;
    final /* synthetic */ no<Boolean, K, V, V, jt0> $onEntryRemoved;
    final /* synthetic */ jo<K, V, Integer> $sizeOf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LruCacheKt$lruCache$4(int $maxSize, jo<? super K, ? super V, Integer> $sizeOf2, vn<? super K, ? extends V> $create2, no<? super Boolean, ? super K, ? super V, ? super V, jt0> $onEntryRemoved2) {
        super($maxSize);
        this.$sizeOf = $sizeOf2;
        this.$create = $create2;
        this.$onEntryRemoved = $onEntryRemoved2;
    }

    /* access modifiers changed from: protected */
    public int sizeOf(K key, V value) {
        lu.f(key, "key");
        lu.f(value, "value");
        return this.$sizeOf.invoke(key, value).intValue();
    }

    /* access modifiers changed from: protected */
    public V create(K key) {
        lu.f(key, "key");
        return this.$create.invoke(key);
    }

    /* access modifiers changed from: protected */
    public void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
        lu.f(key, "key");
        lu.f(oldValue, "oldValue");
        this.$onEntryRemoved.invoke(Boolean.valueOf(evicted), key, oldValue, newValue);
    }
}
