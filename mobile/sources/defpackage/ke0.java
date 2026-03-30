package defpackage;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* renamed from: ke0  reason: default package */
public class ke0 extends x {
    public static final Parcelable.Creator<ke0> CREATOR = new iy0();
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final Account f4114a;

    /* renamed from: a  reason: collision with other field name */
    private final GoogleSignInAccount f4115a;
    private final int b;

    ke0(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.a = i;
        this.f4114a = account;
        this.b = i2;
        this.f4115a = googleSignInAccount;
    }

    public ke0(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    public Account m() {
        return this.f4114a;
    }

    public int p() {
        return this.b;
    }

    public GoogleSignInAccount r() {
        return this.f4115a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.h(parcel, 1, this.a);
        fi0.k(parcel, 2, m(), i, false);
        fi0.h(parcel, 3, p());
        fi0.k(parcel, 4, r(), i, false);
        fi0.b(parcel, a2);
    }
}
