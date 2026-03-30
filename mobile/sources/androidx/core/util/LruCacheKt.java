package androidx.core.util;

import android.util.LruCache;

public final class LruCacheKt {
    public static /* synthetic */ LruCache lruCache$default(int maxSize, jo sizeOf, vn create, no onEntryRemoved, int i, Object obj) {
        if ((i & 2) != 0) {
            sizeOf = LruCacheKt$lruCache$1.INSTANCE;
        }
        if ((i & 4) != 0) {
            create = LruCacheKt$lruCache$2.INSTANCE;
        }
        if ((i & 8) != 0) {
            onEntryRemoved = LruCacheKt$lruCache$3.INSTANCE;
        }
        lu.f(sizeOf, "sizeOf");
        lu.f(create, "create");
        lu.f(onEntryRemoved, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(maxSize, sizeOf, create, onEntryRemoved);
    }

    public static final <K, V> LruCache<K, V> lruCache(int maxSize, jo<? super K, ? super V, Integer> sizeOf, vn<? super K, ? extends V> create, no<? super Boolean, ? super K, ? super V, ? super V, jt0> onEntryRemoved) {
        lu.f(sizeOf, "sizeOf");
        lu.f(create, "create");
        lu.f(onEntryRemoved, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(maxSize, sizeOf, create, onEntryRemoved);
    }
}
