package defpackage;

import android.os.Looper;
import java.util.List;

/* renamed from: c3  reason: default package */
public final class c3 implements oz {
    public nz a(List<? extends oz> allFactories) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new iq(kq.a(mainLooper, true), (String) null, 2, (Cif) null);
        }
        throw new IllegalStateException("The main looper is not available");
    }

    public String b() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    public int c() {
        return 1073741823;
    }
}
