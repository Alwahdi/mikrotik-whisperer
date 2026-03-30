package defpackage;

import android.util.Base64;
import defpackage.f5;

/* renamed from: es0  reason: default package */
public abstract class es0 {

    /* renamed from: es0$a */
    public static abstract class a {
        public abstract es0 a();

        public abstract a b(String str);

        public abstract a c(byte[] bArr);

        public abstract a d(com.google.android.datatransport.a aVar);
    }

    public abstract String b();

    public abstract byte[] c();

    public abstract com.google.android.datatransport.a d();

    public final String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = b();
        objArr[1] = d();
        objArr[2] = c() == null ? "" : Base64.encodeToString(c(), 2);
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }

    public static a a() {
        return new f5.b().d(com.google.android.datatransport.a.DEFAULT);
    }

    public es0 e(com.google.android.datatransport.a priority) {
        return a().b(b()).d(priority).c(c()).a();
    }
}
