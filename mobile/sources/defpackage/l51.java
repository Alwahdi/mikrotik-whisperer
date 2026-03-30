package defpackage;

import android.content.Context;
import defpackage.i3;

/* renamed from: l51  reason: default package */
public abstract class l51 {
    private static final i3.a<w41, n51> a;

    /* renamed from: a  reason: collision with other field name */
    private static final i3.g<w41> f4198a;

    /* renamed from: a  reason: collision with other field name */
    public static final i3<n51> f4199a;

    public static p01 a(Context context, n51 n51) {
        return new p01(context, n51);
    }

    static {
        i3.g<w41> gVar = new i3.g<>();
        f4198a = gVar;
        o51 o51 = new o51();
        a = o51;
        f4199a = new i3<>("InternalFirebaseAuth.FIREBASE_AUTH_API", o51, gVar);
    }
}
