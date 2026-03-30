package defpackage;

import java.util.Arrays;

/* renamed from: o61  reason: default package */
final class o61 extends g51 {
    private final byte[] a;

    o61(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.a = bArr;
    }

    /* access modifiers changed from: package-private */
    public final byte[] b() {
        return this.a;
    }
}
