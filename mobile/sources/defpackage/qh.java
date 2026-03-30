package defpackage;

import com.google.firebase.firestore.model.b;
import java.util.Comparator;

/* renamed from: qh  reason: default package */
final /* synthetic */ class qh implements Comparator {
    private final Comparator a;

    private qh(Comparator comparator) {
        this.a = comparator;
    }

    public static Comparator a(Comparator comparator) {
        return new qh(comparator);
    }

    public int compare(Object obj, Object obj2) {
        return rh.g(this.a, (b) obj, (b) obj2);
    }
}
