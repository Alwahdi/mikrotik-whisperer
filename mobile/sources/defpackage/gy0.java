package defpackage;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: gy0  reason: default package */
public final class gy0 extends x {
    public static final Parcelable.Creator<gy0> CREATOR = new ey0();
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final dc f3128a;

    /* renamed from: a  reason: collision with other field name */
    private final le0 f3129a;

    gy0(int i, dc dcVar, le0 le0) {
        this.a = i;
        this.f3128a = dcVar;
        this.f3129a = le0;
    }

    public gy0(int i) {
        this(new dc(8, (PendingIntent) null), (le0) null);
    }

    private gy0(dc dcVar, le0 le0) {
        this(1, dcVar, (le0) null);
    }

    public final dc m() {
        return this.f3128a;
    }

    public final le0 p() {
        return this.f3129a;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.h(parcel, 1, this.a);
        fi0.k(parcel, 2, this.f3128a, i, false);
        fi0.k(parcel, 3, this.f3129a, i, false);
        fi0.b(parcel, a2);
    }
}
