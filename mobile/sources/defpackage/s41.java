package defpackage;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
import java.util.Collections;
import java.util.concurrent.Callable;

/* renamed from: s41  reason: default package */
final class s41 implements Callable<yz0<n51>> {
    private final Context a;

    /* renamed from: a  reason: collision with other field name */
    private final n51 f4959a;

    public s41(n51 n51, Context context) {
        this.f4959a = n51;
        this.a = context;
    }

    private final rp<n51> a(boolean z, Context context) {
        n51 n51 = (n51) this.f4959a.clone();
        n51.a = z;
        return new j01(context, l51.f4199a, n51, new xl());
    }

    public final /* synthetic */ Object call() {
        rp<n51> rpVar;
        int i;
        if (u41.a == -1 || u41.b == -1) {
            int a2 = DynamiteModule.a(this.a, "com.google.firebase.auth");
            if (a2 != 0) {
                switch (sp.m().g(this.a, 12451000)) {
                    case 0:
                    case 2:
                        i = DynamiteModule.c(this.a, "com.google.android.gms.firebase_auth");
                        break;
                    default:
                        i = 0;
                        break;
                }
            } else {
                i = 1;
            }
            int unused = u41.a = i;
            int unused2 = u41.b = a2;
        }
        rp<n51> rpVar2 = null;
        if (u41.b != 0) {
            rpVar = a(true, this.a);
        } else {
            rpVar = null;
        }
        if (u41.a != 0) {
            rpVar2 = a(false, this.a);
        }
        return new yz0(rpVar2, rpVar, new b01(u41.a, u41.b, Collections.emptyMap()));
    }
}
