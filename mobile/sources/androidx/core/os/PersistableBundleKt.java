package androidx.core.os;

import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import java.util.Map;

public final class PersistableBundleKt {
    @RequiresApi(21)
    public static final PersistableBundle persistableBundleOf(j50<String, ? extends Object>... pairs) {
        lu.f(pairs, "pairs");
        PersistableBundle persistableBundle = PersistableBundleApi21ImplKt.createPersistableBundle(pairs.length);
        for (j50<String, ? extends Object> j50 : pairs) {
            PersistableBundleApi21ImplKt.putValue(persistableBundle, j50.a(), j50.b());
        }
        return persistableBundle;
    }

    @RequiresApi(21)
    public static final PersistableBundle persistableBundleOf() {
        return PersistableBundleApi21ImplKt.createPersistableBundle(0);
    }

    @RequiresApi(21)
    public static final PersistableBundle toPersistableBundle(Map<String, ? extends Object> $this$toPersistableBundle) {
        lu.f($this$toPersistableBundle, "<this>");
        PersistableBundle persistableBundle = PersistableBundleApi21ImplKt.createPersistableBundle($this$toPersistableBundle.size());
        for (Map.Entry next : $this$toPersistableBundle.entrySet()) {
            PersistableBundleApi21ImplKt.putValue(persistableBundle, (String) next.getKey(), next.getValue());
        }
        return persistableBundle;
    }
}
