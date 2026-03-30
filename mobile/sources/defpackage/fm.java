package defpackage;

import android.content.Intent;
import androidx.core.app.NotificationCompat;

/* renamed from: fm  reason: default package */
final class fm {
    private final Intent a;

    /* renamed from: a  reason: collision with other field name */
    private final String f2977a;

    /* renamed from: fm$a */
    static class a implements y30<fm> {
        a() {
        }

        public final /* synthetic */ void a(Object obj, Object obj2) {
            fm fmVar = (fm) obj;
            z30 z30 = (z30) obj2;
            Intent a = fmVar.a();
            z30.e("ttl", c91.l(a));
            z30.b(NotificationCompat.CATEGORY_EVENT, fmVar.b());
            z30.b("instanceId", c91.g());
            z30.e("priority", c91.s(a));
            z30.b("packageName", c91.e());
            z30.b("sdkPlatform", "ANDROID");
            z30.b("messageType", c91.q(a));
            String p = c91.p(a);
            if (p != null) {
                z30.b("messageId", p);
            }
            String r = c91.r(a);
            if (r != null) {
                z30.b("topic", r);
            }
            String m = c91.m(a);
            if (m != null) {
                z30.b("collapseKey", m);
            }
            if (c91.o(a) != null) {
                z30.b("analyticsLabel", c91.o(a));
            }
            if (c91.n(a) != null) {
                z30.b("composerLabel", c91.n(a));
            }
            String i = c91.i();
            if (i != null) {
                z30.b("projectNumber", i);
            }
        }
    }

    /* renamed from: fm$b */
    static final class b implements y30<c> {
        b() {
        }

        public final /* synthetic */ void a(Object obj, Object obj2) {
            ((z30) obj2).b("messaging_client_event", ((c) obj).a());
        }
    }

    fm(String str, Intent intent) {
        this.f2977a = y90.g(str, "evenType must be non-null");
        this.a = (Intent) y90.k(intent, "intent must be non-null");
    }

    /* renamed from: fm$c */
    static final class c {
        private final fm a;

        c(fm fmVar) {
            this.a = (fm) y90.j(fmVar);
        }

        /* access modifiers changed from: package-private */
        public final fm a() {
            return this.a;
        }
    }

    /* access modifiers changed from: package-private */
    public final Intent a() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        return this.f2977a;
    }
}
