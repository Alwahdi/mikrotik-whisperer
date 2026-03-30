package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;

/* renamed from: t71  reason: default package */
public final class t71 implements w4 {
    public static final Parcelable.Creator<t71> CREATOR = new n81();
    private l71 a;

    /* renamed from: a  reason: collision with other field name */
    private m61 f5085a;

    /* renamed from: a  reason: collision with other field name */
    private y81 f5086a;

    t71(y81 y81, m61 m61, l71 l71) {
        this.f5086a = y81;
        this.f5085a = m61;
        this.a = l71;
    }

    public t71(y81 y81) {
        y81 y812 = (y81) y90.j(y81);
        this.f5086a = y812;
        List<i81> L = y812.L();
        this.f5085a = null;
        for (int i = 0; i < L.size(); i++) {
            if (!TextUtils.isEmpty(L.get(i).u())) {
                this.f5085a = new m61(L.get(i).i(), L.get(i).u(), y81.M());
            }
        }
        if (this.f5085a == null) {
            this.f5085a = new m61(y81.M());
        }
        this.a = y81.N();
    }

    public final dm j() {
        return this.f5086a;
    }

    public final c2 f() {
        return this.f5085a;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.k(parcel, 1, j(), i, false);
        fi0.k(parcel, 2, f(), i, false);
        fi0.k(parcel, 3, this.a, i, false);
        fi0.b(parcel, a2);
    }

    public final int describeContents() {
        return 0;
    }
}
