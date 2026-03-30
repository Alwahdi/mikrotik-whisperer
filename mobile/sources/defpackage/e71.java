package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: e71  reason: default package */
public final class e71 extends x {
    public static final Parcelable.Creator<e71> CREATOR = new g71();
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private List<String> f2872a;

    private e71(List<String> list) {
        this.a = 1;
        this.f2872a = new ArrayList();
        if (list != null && !list.isEmpty()) {
            this.f2872a.addAll(list);
        }
    }

    e71(int i, List<String> list) {
        this.a = i;
        if (list == null || list.isEmpty()) {
            this.f2872a = Collections.emptyList();
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            list.set(i2, tn0.a(list.get(i2)));
        }
        this.f2872a = Collections.unmodifiableList(list);
    }

    public static e71 p() {
        return new e71((List<String>) null);
    }

    public static e71 m(e71 e71) {
        List<String> list;
        if (e71 != null) {
            list = e71.f2872a;
        } else {
            list = null;
        }
        return new e71(list);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.h(parcel, 1, this.a);
        fi0.m(parcel, 2, this.f2872a, false);
        fi0.b(parcel, a2);
    }
}
