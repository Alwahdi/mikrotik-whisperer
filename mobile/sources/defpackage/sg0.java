package defpackage;

import android.database.Cursor;
import com.google.protobuf.e;

/* renamed from: sg0  reason: default package */
final /* synthetic */ class sg0 implements hc {
    private final ah0 a;

    private sg0(ah0 ah0) {
        this.a = ah0;
    }

    public static hc a(ah0 ah0) {
        return new sg0(ah0);
    }

    public void accept(Object obj) {
        this.a.f60a = e.j(((Cursor) obj).getBlob(0));
    }
}
