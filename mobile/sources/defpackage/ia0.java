package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: ia0  reason: default package */
public class ia0 implements Parcelable {
    public static final Parcelable.Creator<ia0> CREATOR = new a();
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;

    public ia0() {
    }

    protected ia0(Parcel in) {
        this.a = in.readInt();
        this.b = in.readInt();
        this.c = in.readInt();
        this.d = in.readInt();
        this.e = in.readInt();
        this.f = in.readInt();
    }

    /* renamed from: ia0$a */
    static class a implements Parcelable.Creator<ia0> {
        a() {
        }

        /* renamed from: a */
        public ia0 createFromParcel(Parcel in) {
            return new ia0(in);
        }

        /* renamed from: b */
        public ia0[] newArray(int size) {
            return new ia0[size];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.a);
        dest.writeInt(this.b);
        dest.writeInt(this.c);
        dest.writeInt(this.d);
        dest.writeInt(this.e);
        dest.writeInt(this.f);
    }
}
