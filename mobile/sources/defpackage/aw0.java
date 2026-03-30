package defpackage;

import android.content.Context;

/* renamed from: aw0  reason: default package */
public class aw0 {
    private static aw0 a = new aw0();

    /* renamed from: a  reason: collision with other field name */
    private c50 f124a = null;

    private final synchronized c50 b(Context context) {
        if (this.f124a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f124a = new c50(context);
        }
        return this.f124a;
    }

    public static c50 a(Context context) {
        return a.b(context);
    }
}
