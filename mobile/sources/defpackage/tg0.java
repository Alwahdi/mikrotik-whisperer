package defpackage;

import android.database.Cursor;
import java.util.List;

/* renamed from: tg0  reason: default package */
final /* synthetic */ class tg0 implements hc {
    private final List a;

    private tg0(List list) {
        this.a = list;
    }

    public static hc a(List list) {
        return new tg0(list);
    }

    public void accept(Object obj) {
        this.a.add(((Cursor) obj).getString(0));
    }
}
