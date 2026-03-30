package androidx.lifecycle.viewmodel;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class CreationExtras {
    private final Map<Key<?>, Object> map = new LinkedHashMap();

    public interface Key<T> {
    }

    public abstract <T> T get(Key<T> key);

    public final Map<Key<?>, Object> getMap$lifecycle_viewmodel_release() {
        return this.map;
    }

    public static final class Empty extends CreationExtras {
        public static final Empty INSTANCE = new Empty();

        private Empty() {
        }

        public <T> T get(Key<T> key) {
            lu.f(key, "key");
            return null;
        }
    }
}
