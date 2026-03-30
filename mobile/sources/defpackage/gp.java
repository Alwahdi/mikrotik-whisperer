package defpackage;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import defpackage.cr;

/* renamed from: gp  reason: default package */
public class gp extends x {
    public static final Parcelable.Creator<gp> CREATOR = new c41();
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    Account f3116a;

    /* renamed from: a  reason: collision with other field name */
    Bundle f3117a;

    /* renamed from: a  reason: collision with other field name */
    IBinder f3118a;

    /* renamed from: a  reason: collision with other field name */
    String f3119a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f3120a;

    /* renamed from: a  reason: collision with other field name */
    Scope[] f3121a;

    /* renamed from: a  reason: collision with other field name */
    nk[] f3122a;
    private final int b;

    /* renamed from: b  reason: collision with other field name */
    nk[] f3123b;
    private int c;

    public gp(int i) {
        this.a = 4;
        this.c = up.a;
        this.b = i;
        this.f3120a = true;
    }

    gp(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, nk[] nkVarArr, nk[] nkVarArr2, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        if ("com.google.android.gms".equals(str)) {
            this.f3119a = "com.google.android.gms";
        } else {
            this.f3119a = str;
        }
        if (i < 2) {
            this.f3116a = iBinder != null ? h0.c(cr.a.b(iBinder)) : null;
        } else {
            this.f3118a = iBinder;
            this.f3116a = account;
        }
        this.f3121a = scopeArr;
        this.f3117a = bundle;
        this.f3122a = nkVarArr;
        this.f3123b = nkVarArr2;
        this.f3120a = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.h(parcel, 1, this.a);
        fi0.h(parcel, 2, this.b);
        fi0.h(parcel, 3, this.c);
        fi0.l(parcel, 4, this.f3119a, false);
        fi0.g(parcel, 5, this.f3118a, false);
        fi0.n(parcel, 6, this.f3121a, i, false);
        fi0.e(parcel, 7, this.f3117a, false);
        fi0.k(parcel, 8, this.f3116a, i, false);
        fi0.n(parcel, 10, this.f3122a, i, false);
        fi0.n(parcel, 11, this.f3123b, i, false);
        fi0.c(parcel, 12, this.f3120a);
        fi0.b(parcel, a2);
    }
}
