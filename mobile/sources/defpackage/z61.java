package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: z61  reason: default package */
public final class z61 extends x {
    public static final Parcelable.Creator<z61> CREATOR = new x61();
    private List<w61> a;

    public z61() {
        this.a = new ArrayList();
    }

    z61(List<w61> list) {
        if (list == null || list.isEmpty()) {
            this.a = Collections.emptyList();
        } else {
            this.a = Collections.unmodifiableList(list);
        }
    }

    public final List<w61> m() {
        return this.a;
    }

    public static z61 p(z61 z61) {
        List<w61> list = z61.a;
        z61 z612 = new z61();
        if (list != null) {
            z612.a.addAll(list);
        }
        return z612;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.o(parcel, 2, this.a, false);
        fi0.b(parcel, a2);
    }
}
