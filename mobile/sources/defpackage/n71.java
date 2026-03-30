package defpackage;

import java.lang.ref.WeakReference;

/* renamed from: n71  reason: default package */
abstract class n71 extends g51 {
    private static final WeakReference<byte[]> b = new WeakReference<>((Object) null);
    private WeakReference<byte[]> a = b;

    n71(byte[] bArr) {
        super(bArr);
    }

    /* access modifiers changed from: protected */
    public abstract byte[] h0();

    /* access modifiers changed from: package-private */
    public final byte[] b() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.a.get();
            if (bArr == null) {
                bArr = h0();
                this.a = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }
}
