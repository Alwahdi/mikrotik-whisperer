package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ba1  reason: default package */
public final class ba1 extends az0 {
    public static final Parcelable.Creator<ba1> CREATOR = new x91();
    private String a;

    /* renamed from: a  reason: collision with other field name */
    private List<mz0> f216a;
    private String b;

    private ba1() {
    }

    ba1(String str, String str2, List<mz0> list) {
        this.a = str;
        this.b = str2;
        this.f216a = list;
    }

    public static ba1 m(List<ga1> list, String str) {
        y90.j(list);
        y90.f(str);
        ba1 ba1 = new ba1();
        ba1.f216a = new ArrayList();
        for (ga1 next : list) {
            if (next instanceof mz0) {
                ba1.f216a.add((mz0) next);
            }
        }
        ba1.b = str;
        return ba1;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.l(parcel, 1, this.a, false);
        fi0.l(parcel, 2, this.b, false);
        fi0.o(parcel, 3, this.f216a, false);
        fi0.b(parcel, a2);
    }
}
