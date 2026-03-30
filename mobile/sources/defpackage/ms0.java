package defpackage;

import android.content.Context;
import java.io.Closeable;

/* renamed from: ms0  reason: default package */
abstract class ms0 implements Closeable {

    /* renamed from: ms0$a */
    interface a {
        ms0 a();

        a b(Context context);
    }

    /* access modifiers changed from: package-private */
    public abstract hj c();

    /* access modifiers changed from: package-private */
    public abstract ls0 f();

    ms0() {
    }

    public void close() {
        c().close();
    }
}
