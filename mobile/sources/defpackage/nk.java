package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import org.apache.http.cookie.ClientCookie;

/* renamed from: nk  reason: default package */
public class nk extends x {
    public static final Parcelable.Creator<nk> CREATOR = new j11();
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final long f4441a;

    /* renamed from: a  reason: collision with other field name */
    private final String f4442a;

    public nk(String str, long j) {
        this.f4442a = str;
        this.f4441a = j;
        this.a = -1;
    }

    public nk(String str, int i, long j) {
        this.f4442a = str;
        this.a = i;
        this.f4441a = j;
    }

    public String m() {
        return this.f4442a;
    }

    public long p() {
        long j = this.f4441a;
        return j == -1 ? (long) this.a : j;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.l(parcel, 1, m(), false);
        fi0.h(parcel, 2, this.a);
        fi0.i(parcel, 3, p());
        fi0.b(parcel, a2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof nk)) {
            return false;
        }
        nk nkVar = (nk) obj;
        if (((m() == null || !m().equals(nkVar.m())) && (m() != null || nkVar.m() != null)) || p() != nkVar.p()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return e40.b(m(), Long.valueOf(p()));
    }

    public String toString() {
        return e40.c(this).a("name", m()).a(ClientCookie.VERSION_ATTR, Long.valueOf(p())).toString();
    }
}
