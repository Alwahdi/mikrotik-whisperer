package defpackage;

import android.os.Bundle;
import android.util.Log;

/* renamed from: rz0  reason: default package */
abstract class rz0<T> {
    final int a;

    /* renamed from: a  reason: collision with other field name */
    final Bundle f4953a;

    /* renamed from: a  reason: collision with other field name */
    final gq0<T> f4954a = new gq0<>();
    final int b;

    rz0(int i, int i2, Bundle bundle) {
        this.a = i;
        this.b = i2;
        this.f4953a = bundle;
    }

    /* access modifiers changed from: package-private */
    public abstract void a(Bundle bundle);

    /* access modifiers changed from: package-private */
    public abstract boolean d();

    /* access modifiers changed from: package-private */
    public final void b(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16 + String.valueOf(valueOf2).length());
            sb.append("Finishing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.f4954a.c(t);
    }

    /* access modifiers changed from: package-private */
    public final void c(pz0 pz0) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(pz0);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14 + String.valueOf(valueOf2).length());
            sb.append("Failing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.f4954a.b(pz0);
    }

    public String toString() {
        int i = this.b;
        int i2 = this.a;
        boolean d = d();
        StringBuilder sb = new StringBuilder(55);
        sb.append("Request { what=");
        sb.append(i);
        sb.append(" id=");
        sb.append(i2);
        sb.append(" oneWay=");
        sb.append(d);
        sb.append("}");
        return sb.toString();
    }
}
