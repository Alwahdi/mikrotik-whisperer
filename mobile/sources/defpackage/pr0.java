package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.Date;

/* renamed from: pr0  reason: default package */
public final class pr0 implements Comparable<pr0>, Parcelable {
    @NonNull
    public static final Parcelable.Creator<pr0> CREATOR = new a();
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final long f4728a;

    /* renamed from: pr0$a */
    class a implements Parcelable.Creator<pr0> {
        a() {
        }

        /* renamed from: a */
        public pr0 createFromParcel(Parcel source) {
            return new pr0(source);
        }

        /* renamed from: b */
        public pr0[] newArray(int size) {
            return new pr0[size];
        }
    }

    public pr0(long seconds, int nanoseconds) {
        s(seconds, nanoseconds);
        this.f4728a = seconds;
        this.a = nanoseconds;
    }

    protected pr0(Parcel in) {
        this.f4728a = in.readLong();
        this.a = in.readInt();
    }

    public pr0(Date date) {
        long millis = date.getTime();
        long seconds = millis / 1000;
        int nanoseconds = ((int) (millis % 1000)) * 1000000;
        if (nanoseconds < 0) {
            seconds--;
            nanoseconds += 1000000000;
        }
        s(seconds, nanoseconds);
        this.f4728a = seconds;
        this.a = nanoseconds;
    }

    public static pr0 q() {
        return new pr0(new Date());
    }

    public long p() {
        return this.f4728a;
    }

    public int o() {
        return this.a;
    }

    public Date r() {
        return new Date((this.f4728a * 1000) + ((long) (this.a / 1000000)));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.f4728a);
        dest.writeInt(this.a);
    }

    /* renamed from: i */
    public int compareTo(pr0 other) {
        long j = this.f4728a;
        long j2 = other.f4728a;
        if (j == j2) {
            return Integer.signum(this.a - other.a);
        }
        return Long.signum(j - j2);
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof pr0) && compareTo((pr0) other) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.f4728a;
        return (37 * ((37 * ((int) j) * 37) + ((int) (j >> 32)))) + this.a;
    }

    public String toString() {
        return "Timestamp(seconds=" + this.f4728a + ", nanoseconds=" + this.a + ")";
    }

    private static void s(long seconds, int nanoseconds) {
        boolean z = true;
        v90.h(nanoseconds >= 0, "Timestamp nanoseconds out of range: %s", nanoseconds);
        v90.h(((double) nanoseconds) < 1.0E9d, "Timestamp nanoseconds out of range: %s", nanoseconds);
        v90.i(seconds >= -62135596800L, "Timestamp seconds out of range: %s", seconds);
        if (seconds >= 253402300800L) {
            z = false;
        }
        v90.i(z, "Timestamp seconds out of range: %s", seconds);
    }
}
