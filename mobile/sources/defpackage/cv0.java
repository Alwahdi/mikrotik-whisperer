package defpackage;

import com.google.firebase.firestore.core.f0;
import com.google.firebase.firestore.core.u;
import java.util.List;

/* renamed from: cv0  reason: default package */
public class cv0 {
    private final f0 a;

    /* renamed from: a  reason: collision with other field name */
    private final List<u> f2677a;

    public cv0(f0 snapshot, List<u> limboChanges) {
        this.a = snapshot;
        this.f2677a = limboChanges;
    }

    public f0 b() {
        return this.a;
    }

    public List<u> a() {
        return this.f2677a;
    }
}
