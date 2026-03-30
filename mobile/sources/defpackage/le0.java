package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.cr;

/* renamed from: le0  reason: default package */
public class le0 extends x {
    public static final Parcelable.Creator<le0> CREATOR = new jy0();
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private IBinder f4249a;

    /* renamed from: a  reason: collision with other field name */
    private dc f4250a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f4251a;
    private boolean b;

    le0(int i, IBinder iBinder, dc dcVar, boolean z, boolean z2) {
        this.a = i;
        this.f4249a = iBinder;
        this.f4250a = dcVar;
        this.f4251a = z;
        this.b = z2;
    }

    public cr m() {
        return cr.a.b(this.f4249a);
    }

    public dc p() {
        return this.f4250a;
    }

    public boolean r() {
        return this.f4251a;
    }

    public boolean s() {
        return this.b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.h(parcel, 1, this.a);
        fi0.g(parcel, 2, this.f4249a, false);
        fi0.k(parcel, 3, p(), i, false);
        fi0.c(parcel, 4, r());
        fi0.c(parcel, 5, s());
        fi0.b(parcel, a2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof le0)) {
            return false;
        }
        le0 le0 = (le0) obj;
        if (!this.f4250a.equals(le0.f4250a) || !m().equals(le0.m())) {
            return false;
        }
        return true;
    }
}
