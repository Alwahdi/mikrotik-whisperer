package defpackage;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: cr  reason: default package */
public interface cr extends IInterface {

    /* renamed from: cr$a */
    public static abstract class a extends e11 implements cr {

        /* renamed from: cr$a$a  reason: collision with other inner class name */
        public static class C0037a extends sy0 implements cr {
            C0037a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            public final Account o() {
                Parcel b = b(2, a());
                Account account = (Account) a31.b(b, Account.CREATOR);
                b.recycle();
                return account;
            }
        }

        public static cr b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            if (queryLocalInterface instanceof cr) {
                return (cr) queryLocalInterface;
            }
            return new C0037a(iBinder);
        }
    }

    Account o();
}
