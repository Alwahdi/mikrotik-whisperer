package defpackage;

import com.google.firebase.firestore.model.mutation.Mutation;
import java.util.ArrayList;
import java.util.List;

/* renamed from: du0  reason: default package */
public class du0 {
    private final c40 a;

    /* renamed from: a  reason: collision with other field name */
    private final List<qk> f2822a;

    /* renamed from: a  reason: collision with other field name */
    private final ok f2823a;

    du0(c40 data, ok fieldMask, List<qk> fieldTransforms) {
        this.a = data;
        this.f2823a = fieldMask;
        this.f2822a = fieldTransforms;
    }

    public List<u20> a(mh key, u90 precondition) {
        ArrayList<Mutation> mutations = new ArrayList<>();
        ok okVar = this.f2823a;
        if (okVar != null) {
            mutations.add(new o50(key, this.a, okVar, precondition));
        } else {
            mutations.add(new xk0(key, this.a, precondition));
        }
        if (!this.f2822a.isEmpty()) {
            mutations.add(new xr0(key, this.f2822a));
        }
        return mutations;
    }
}
