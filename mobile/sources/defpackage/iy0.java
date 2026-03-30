package defpackage;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* renamed from: iy0  reason: default package */
public final class iy0 implements Parcelable.Creator<ke0> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new ke0[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        Account account = null;
        GoogleSignInAccount googleSignInAccount = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            switch (ei0.h(l)) {
                case 1:
                    i = ei0.n(parcel, l);
                    break;
                case 2:
                    account = (Account) ei0.b(parcel, l, Account.CREATOR);
                    break;
                case 3:
                    i2 = ei0.n(parcel, l);
                    break;
                case 4:
                    googleSignInAccount = (GoogleSignInAccount) ei0.b(parcel, l, GoogleSignInAccount.CREATOR);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new ke0(i, account, i2, googleSignInAccount);
    }
}
