package defpackage;

import android.os.Handler;
import android.os.Message;

/* renamed from: ia1  reason: default package */
final /* synthetic */ class ia1 implements Handler.Callback {
    private final aa1 a;

    ia1(aa1 aa1) {
        this.a = aa1;
    }

    public final boolean handleMessage(Message message) {
        return this.a.d(message);
    }
}
