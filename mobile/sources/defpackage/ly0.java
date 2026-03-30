package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* renamed from: ly0  reason: default package */
public class ly0 extends Handler {
    private static volatile ky0 a = null;

    public ly0(Looper looper) {
        super(looper);
    }

    public ly0(Looper looper, Handler.Callback callback) {
        super(looper, callback);
    }

    public final void dispatchMessage(Message message) {
        super.dispatchMessage(message);
    }
}
