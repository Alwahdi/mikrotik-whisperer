package defpackage;

import android.os.RemoteException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* renamed from: g51  reason: default package */
abstract class g51 extends e81 {
    private int a;

    protected g51(byte[] bArr) {
        y90.a(bArr.length == 25);
        this.a = Arrays.hashCode(bArr);
    }

    /* access modifiers changed from: package-private */
    public abstract byte[] b();

    public int hashCode() {
        return this.a;
    }

    public boolean equals(Object obj) {
        kr Q;
        if (obj == null || !(obj instanceof w71)) {
            return false;
        }
        try {
            w71 w71 = (w71) obj;
            if (w71.p() != hashCode() || (Q = w71.Q()) == null) {
                return false;
            }
            return Arrays.equals(b(), (byte[]) d40.c(Q));
        } catch (RemoteException e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            return false;
        }
    }

    public final kr Q() {
        return d40.h0(b());
    }

    public final int p() {
        return hashCode();
    }

    protected static byte[] c(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
