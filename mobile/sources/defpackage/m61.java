package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* renamed from: m61  reason: default package */
public final class m61 implements c2 {
    public static final Parcelable.Creator<m61> CREATOR = new c81();
    private final String a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, Object> f4311a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f4312a;
    private final String b;

    public m61(String str, String str2, boolean z) {
        y90.f(str);
        y90.f(str2);
        this.a = str;
        this.b = str2;
        this.f4311a = d01.d(str2);
        this.f4312a = z;
    }

    public m61(boolean z) {
        this.f4312a = z;
        this.b = null;
        this.a = null;
        this.f4311a = null;
    }

    public final String f() {
        return this.a;
    }

    public final boolean i() {
        return this.f4312a;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.l(parcel, 1, f(), false);
        fi0.l(parcel, 2, this.b, false);
        fi0.c(parcel, 3, i());
        fi0.b(parcel, a2);
    }

    public final int describeContents() {
        return 0;
    }
}
