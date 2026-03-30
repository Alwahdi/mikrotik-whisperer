package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;

/* renamed from: iq  reason: default package */
public final class iq extends jq {
    private volatile iq _immediate;
    private final Handler a;

    /* renamed from: a  reason: collision with other field name */
    private final iq f3980a;

    /* renamed from: a  reason: collision with other field name */
    private final String f3981a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f3982a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private iq(Handler handler, String name, boolean invokeImmediately) {
        super((Cif) null);
        iq iqVar = null;
        this.a = handler;
        this.f3981a = name;
        this.f3982a = invokeImmediately;
        this._immediate = invokeImmediately ? this : iqVar;
        iq it = this._immediate;
        if (it == null) {
            it = new iq(handler, name, true);
            this._immediate = it;
        }
        this.f3980a = it;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ iq(Handler handler, String str, int i, Cif ifVar) {
        this(handler, (i & 2) != 0 ? null : str);
    }

    public iq(Handler handler, String name) {
        this(handler, name, false);
    }

    /* renamed from: a0 */
    public iq X() {
        return this.f3980a;
    }

    public boolean isDispatchNeeded(yc context) {
        return !this.f3982a || !lu.a(Looper.myLooper(), this.a.getLooper());
    }

    public void dispatch(yc context, Runnable block) {
        if (!this.a.post(block)) {
            Z(context, block);
        }
    }

    private final void Z(yc context, Runnable block) {
        jv.a(context, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        xg.b().dispatch(context, block);
    }

    public String toString() {
        String Y = Y();
        if (Y != null) {
            return Y;
        }
        String str = this.f3981a;
        if (str == null) {
            str = this.a.toString();
        }
        if (!this.f3982a) {
            return str;
        }
        return str + ".immediate";
    }

    public boolean equals(Object other) {
        return (other instanceof iq) && ((iq) other).a == this.a;
    }

    public int hashCode() {
        return System.identityHashCode(this.a);
    }
}
