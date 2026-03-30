package defpackage;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import defpackage.i3;
import defpackage.vp;
import defpackage.z5;
import java.util.Collections;
import java.util.Set;

/* renamed from: op  reason: default package */
public abstract class op<T extends IInterface> extends z5<T> implements i3.f {
    private final Account a;

    /* renamed from: a  reason: collision with other field name */
    private final Set<Scope> f4566a;

    /* renamed from: a  reason: collision with other field name */
    private final y8 f4567a;

    protected op(Context context, Looper looper, int i, y8 y8Var, ac acVar, p40 p40) {
        this(context, looper, pp.a(context), sp.m(), i, y8Var, (ac) y90.j(acVar), (p40) y90.j(p40));
    }

    protected op(Context context, Looper looper, int i, y8 y8Var, vp.a aVar, vp.b bVar) {
        this(context, looper, i, y8Var, (ac) aVar, (p40) bVar);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected op(Context context, Looper looper, pp ppVar, sp spVar, int i, y8 y8Var, ac acVar, p40 p40) {
        super(context, looper, ppVar, spVar, i, g0(acVar), h0(p40), y8Var.e());
        this.f4567a = y8Var;
        this.a = y8Var.a();
        this.f4566a = i0(y8Var.c());
    }

    private final Set<Scope> i0(Set<Scope> set) {
        Set<Scope> f0 = f0(set);
        for (Scope contains : f0) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return f0;
    }

    /* access modifiers changed from: protected */
    public Set<Scope> f0(Set<Scope> set) {
        return set;
    }

    public final Account s() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    public final Set<Scope> y() {
        return this.f4566a;
    }

    public Set<Scope> j() {
        return h() ? this.f4566a : Collections.emptySet();
    }

    private static z5.a g0(ac acVar) {
        if (acVar == null) {
            return null;
        }
        return new wx0(acVar);
    }

    private static z5.b h0(p40 p40) {
        if (p40 == null) {
            return null;
        }
        return new ay0(p40);
    }
}
