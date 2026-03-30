package defpackage;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: dc  reason: default package */
public final class dc extends x {
    public static final Parcelable.Creator<dc> CREATOR = new xy0();
    public static final dc a = new dc(0);

    /* renamed from: a  reason: collision with other field name */
    private final int f2752a;

    /* renamed from: a  reason: collision with other field name */
    private final PendingIntent f2753a;

    /* renamed from: a  reason: collision with other field name */
    private final String f2754a;
    private final int b;

    dc(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f2752a = i;
        this.b = i2;
        this.f2753a = pendingIntent;
        this.f2754a = str;
    }

    public dc(int i) {
        this(i, (PendingIntent) null, (String) null);
    }

    public dc(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, (String) null);
    }

    public dc(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    public final boolean s() {
        return (this.b == 0 || this.f2753a == null) ? false : true;
    }

    public final boolean t() {
        return this.b == 0;
    }

    public final int m() {
        return this.b;
    }

    public final PendingIntent r() {
        return this.f2753a;
    }

    public final String p() {
        return this.f2754a;
    }

    static String u(int i) {
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            case 13:
                return "CANCELED";
            case 14:
                return "TIMEOUT";
            case 15:
                return "INTERRUPTED";
            case 16:
                return "API_UNAVAILABLE";
            case 17:
                return "SIGN_IN_FAILED";
            case 18:
                return "SERVICE_UPDATING";
            case 19:
                return "SERVICE_MISSING_PERMISSION";
            case 20:
                return "RESTRICTED_PROFILE";
            case 21:
                return "API_VERSION_UPDATE_REQUIRED";
            case 99:
                return "UNFINISHED";
            case 1500:
                return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
            default:
                StringBuilder sb = new StringBuilder(31);
                sb.append("UNKNOWN_ERROR_CODE(");
                sb.append(i);
                sb.append(")");
                return sb.toString();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof dc)) {
            return false;
        }
        dc dcVar = (dc) obj;
        if (this.b != dcVar.b || !e40.a(this.f2753a, dcVar.f2753a) || !e40.a(this.f2754a, dcVar.f2754a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return e40.b(Integer.valueOf(this.b), this.f2753a, this.f2754a);
    }

    public final String toString() {
        return e40.c(this).a("statusCode", u(this.b)).a("resolution", this.f2753a).a("message", this.f2754a).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.h(parcel, 1, this.f2752a);
        fi0.h(parcel, 2, m());
        fi0.k(parcel, 3, r(), i, false);
        fi0.l(parcel, 4, p(), false);
        fi0.b(parcel, a2);
    }
}
