package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* renamed from: p51  reason: default package */
public final class p51 extends x {
    public static final Parcelable.Creator<p51> CREATOR = new t51();
    private String a;

    /* renamed from: a  reason: collision with other field name */
    private List<u61> f4680a;

    /* renamed from: a  reason: collision with other field name */
    private l71 f4681a;

    public p51(String str, List<u61> list, l71 l71) {
        this.a = str;
        this.f4680a = list;
        this.f4681a = l71;
    }

    public final String m() {
        return this.a;
    }

    public final l71 p() {
        return this.f4681a;
    }

    public final List<ga1> r() {
        return k01.a(this.f4680a);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.l(parcel, 1, this.a, false);
        fi0.o(parcel, 2, this.f4680a, false);
        fi0.k(parcel, 3, this.f4681a, i, false);
        fi0.b(parcel, a2);
    }
}
