package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* renamed from: ti0  reason: default package */
public class ti0 extends View.BaseSavedState {
    public static final Parcelable.Creator<ti0> CREATOR = new a();
    public ia0 a;

    /* synthetic */ ti0(Parcel x0, a x1) {
        this(x0);
    }

    public ti0(Parcelable superState) {
        super(superState);
    }

    private ti0(Parcel in) {
        super(in);
    }

    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeParcelable(this.a, flags);
    }

    /* renamed from: ti0$a */
    static class a implements Parcelable.Creator<ti0> {
        a() {
        }

        /* renamed from: a */
        public ti0 createFromParcel(Parcel in) {
            return new ti0(in, (a) null);
        }

        /* renamed from: b */
        public ti0[] newArray(int size) {
            return new ti0[size];
        }
    }
}
