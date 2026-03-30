package defpackage;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Scope;
import defpackage.i3;

/* renamed from: uw0  reason: default package */
public abstract class uw0 {
    private static final Scope a = new Scope("profile");

    /* renamed from: a  reason: collision with other field name */
    public static final i3.a<ql0, rl0> f5272a;

    /* renamed from: a  reason: collision with other field name */
    private static final i3.g<ql0> f5273a;

    /* renamed from: a  reason: collision with other field name */
    public static final i3<rl0> f5274a;
    private static final Scope b = new Scope(NotificationCompat.CATEGORY_EMAIL);

    /* renamed from: b  reason: collision with other field name */
    private static final i3.a<ql0, Object> f5275b;

    /* renamed from: b  reason: collision with other field name */
    private static final i3.g<ql0> f5276b;

    /* renamed from: b  reason: collision with other field name */
    private static final i3<Object> f5277b;

    static {
        i3.g<ql0> gVar = new i3.g<>();
        f5273a = gVar;
        i3.g<ql0> gVar2 = new i3.g<>();
        f5276b = gVar2;
        lw0 lw0 = new lw0();
        f5272a = lw0;
        rx0 rx0 = new rx0();
        f5275b = rx0;
        f5274a = new i3<>("SignIn.API", lw0, gVar);
        f5277b = new i3<>("SignIn.INTERNAL_API", rx0, gVar2);
    }
}
