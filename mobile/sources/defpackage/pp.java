package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

/* renamed from: pp  reason: default package */
public abstract class pp {
    private static final Object a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static pp f4723a;

    /* access modifiers changed from: protected */
    public abstract boolean c(a aVar, ServiceConnection serviceConnection, String str);

    /* access modifiers changed from: protected */
    public abstract void d(a aVar, ServiceConnection serviceConnection, String str);

    public static pp a(Context context) {
        synchronized (a) {
            if (f4723a == null) {
                f4723a = new a51(context.getApplicationContext());
            }
        }
        return f4723a;
    }

    /* renamed from: pp$a */
    protected static final class a {
        private final int a;

        /* renamed from: a  reason: collision with other field name */
        private final ComponentName f4724a = null;

        /* renamed from: a  reason: collision with other field name */
        private final String f4725a;
        private final String b;

        public a(String str, String str2, int i) {
            this.f4725a = y90.f(str);
            this.b = y90.f(str2);
            this.a = i;
        }

        public final String toString() {
            String str = this.f4725a;
            return str == null ? this.f4724a.flattenToString() : str;
        }

        public final String b() {
            return this.b;
        }

        public final ComponentName a() {
            return this.f4724a;
        }

        public final int d() {
            return this.a;
        }

        public final Intent c(Context context) {
            if (this.f4725a != null) {
                return new Intent(this.f4725a).setPackage(this.b);
            }
            return new Intent().setComponent(this.f4724a);
        }

        public final int hashCode() {
            return e40.b(this.f4725a, this.b, this.f4724a, Integer.valueOf(this.a));
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!e40.a(this.f4725a, aVar.f4725a) || !e40.a(this.b, aVar.b) || !e40.a(this.f4724a, aVar.f4724a) || this.a != aVar.a) {
                return false;
            }
            return true;
        }
    }

    public final void b(String str, String str2, int i, ServiceConnection serviceConnection, String str3) {
        d(new a(str, str2, i), serviceConnection, str3);
    }
}
