package defpackage;

import java.util.List;

/* renamed from: qz  reason: default package */
public abstract class qz {
    private static final boolean a = true;

    public static final nz e(oz $this$tryCreateDispatcher, List<? extends oz> factories) {
        try {
            return $this$tryCreateDispatcher.a(factories);
        } catch (Throwable cause) {
            return a(cause, $this$tryCreateDispatcher.b());
        }
    }

    public static final boolean c(nz $this$isMissing) {
        return $this$isMissing.X() instanceof c20;
    }

    static /* synthetic */ c20 b(Throwable th, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return a(th, str);
    }

    private static final c20 a(Throwable cause, String errorHint) {
        if (a) {
            return new c20(cause, errorHint);
        }
        if (cause != null) {
            throw cause;
        }
        d();
        throw new jw();
    }

    public static final Void d() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }
}
