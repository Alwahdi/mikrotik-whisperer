package butterknife;

import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ButterKnife {
    static final Map<Class<?>, Constructor<? extends Unbinder>> a = new LinkedHashMap();

    /* renamed from: a  reason: collision with other field name */
    private static boolean f256a = false;

    private ButterKnife() {
        throw new AssertionError("No instances.");
    }
}
