package defpackage;

import android.database.Cursor;
import defpackage.hg0;
import java.util.List;

/* renamed from: uf0  reason: default package */
final /* synthetic */ class uf0 implements hg0.b {
    private final es0 a;

    /* renamed from: a  reason: collision with other field name */
    private final List f5244a;

    private uf0(List list, es0 es0) {
        this.f5244a = list;
        this.a = es0;
    }

    public static hg0.b a(List list, es0 es0) {
        return new uf0(list, es0);
    }

    public Object apply(Object obj) {
        return hg0.g0(this.f5244a, this.a, (Cursor) obj);
    }
}
