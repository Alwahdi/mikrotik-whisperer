package defpackage;

import com.google.firebase.firestore.core.c0;
import com.google.firebase.firestore.model.mutation.FieldTransform;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: bu0  reason: default package */
public class bu0 {
    /* access modifiers changed from: private */
    public final c0 a;

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<qk> f254a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private final Set<pk> f255a = new HashSet();

    public bu0(c0 dataSource) {
        this.a = dataSource;
    }

    public cu0 e() {
        return new cu0(this, pk.b, false, (au0) null);
    }

    public boolean d(pk fieldPath) {
        for (pk field : this.f255a) {
            if (fieldPath.l(field)) {
                return true;
            }
        }
        Iterator<qk> it = this.f254a.iterator();
        while (it.hasNext()) {
            if (fieldPath.l(it.next().a())) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void b(pk fieldPath) {
        this.f255a.add(fieldPath);
    }

    /* access modifiers changed from: package-private */
    public void c(pk fieldPath, yr0 transformOperation) {
        this.f254a.add(new qk(fieldPath, transformOperation));
    }

    public du0 f(c40 data) {
        return new du0(data, ok.b(this.f255a), Collections.unmodifiableList(this.f254a));
    }

    public du0 g(c40 data, ok userFieldMask) {
        ArrayList<FieldTransform> coveredFieldTransforms = new ArrayList<>();
        Iterator<qk> it = this.f254a.iterator();
        while (it.hasNext()) {
            qk parsedTransform = it.next();
            if (userFieldMask.a(parsedTransform.a())) {
                coveredFieldTransforms.add(parsedTransform);
            }
        }
        return new du0(data, userFieldMask, Collections.unmodifiableList(coveredFieldTransforms));
    }

    public du0 h(c40 data) {
        return new du0(data, (ok) null, Collections.unmodifiableList(this.f254a));
    }
}
