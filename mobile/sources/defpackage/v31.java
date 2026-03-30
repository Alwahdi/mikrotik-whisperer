package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.g;

/* renamed from: v31  reason: default package */
public final class v31 extends x {
    public static final Parcelable.Creator<v31> CREATOR = new a41();
    private final g a;

    /* renamed from: a  reason: collision with other field name */
    private final String f5297a;

    public v31(String str, g gVar) {
        this.f5297a = str;
        this.a = gVar;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.l(parcel, 1, this.f5297a, false);
        fi0.k(parcel, 2, this.a, i, false);
        fi0.b(parcel, a2);
    }
}
