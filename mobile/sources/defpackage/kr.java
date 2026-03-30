package defpackage;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: kr  reason: default package */
public interface kr extends IInterface {

    /* renamed from: kr$a */
    public static abstract class a extends e11 implements kr {

        /* renamed from: kr$a$a  reason: collision with other inner class name */
        public static class C0054a extends sy0 implements kr {
            C0054a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IObjectWrapper");
            }
        }

        public a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static kr b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            if (queryLocalInterface instanceof kr) {
                return (kr) queryLocalInterface;
            }
            return new C0054a(iBinder);
        }
    }
}
