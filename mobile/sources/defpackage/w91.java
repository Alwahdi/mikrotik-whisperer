package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.FirebaseAuth;
import java.util.ArrayList;
import java.util.List;

/* renamed from: w91  reason: default package */
public final class w91 extends cz0 {
    public static final Parcelable.Creator<w91> CREATOR = new t91();
    private final ba1 a;

    /* renamed from: a  reason: collision with other field name */
    private final String f5468a;

    /* renamed from: a  reason: collision with other field name */
    private final List<mz0> f5469a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    private final l71 f5470a;

    /* renamed from: a  reason: collision with other field name */
    private final y81 f5471a;

    public w91(List<mz0> list, ba1 ba1, String str, l71 l71, y81 y81) {
        for (ga1 next : list) {
            if (next instanceof mz0) {
                this.f5469a.add((mz0) next);
            }
        }
        this.a = (ba1) y90.j(ba1);
        this.f5468a = y90.f(str);
        this.f5470a = l71;
        this.f5471a = y81;
    }

    public static w91 m(p51 p51, FirebaseAuth firebaseAuth, dm dmVar) {
        List<ga1> r = p51.r();
        ArrayList arrayList = new ArrayList();
        for (ga1 next : r) {
            if (next instanceof mz0) {
                arrayList.add((mz0) next);
            }
        }
        return new w91(arrayList, ba1.m(p51.r(), p51.m()), firebaseAuth.q().l(), p51.p(), (y81) dmVar);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.o(parcel, 1, this.f5469a, false);
        fi0.k(parcel, 2, this.a, i, false);
        fi0.l(parcel, 3, this.f5468a, false);
        fi0.k(parcel, 4, this.f5470a, i, false);
        fi0.k(parcel, 5, this.f5471a, i, false);
        fi0.b(parcel, a2);
    }
}
