package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;

/* renamed from: jv0  reason: default package */
public final class jv0 extends ContextWrapper {
    public static final a a = new a((Cif) null);

    /* renamed from: a  reason: collision with other field name */
    static final /* synthetic */ fw[] f4094a = {xd0.e(new hb0(xd0.b(jv0.class), "inflater", "getInflater()Lio/github/inflationx/viewpump/internal/-ViewPumpLayoutInflater;"))};

    /* renamed from: a  reason: collision with other field name */
    private final rw f4095a;

    private final e a() {
        rw rwVar = this.f4095a;
        fw fwVar = f4094a[0];
        return (e) rwVar.getValue();
    }

    public static final ContextWrapper b(Context context) {
        return a.a(context);
    }

    private jv0(Context base) {
        super(base);
        this.f4095a = vw.b(kotlin.a.NONE, new b(this));
    }

    public /* synthetic */ jv0(Context base, Cif $constructor_marker) {
        this(base);
    }

    /* renamed from: jv0$b */
    static final class b extends ow implements tn<e> {
        final /* synthetic */ jv0 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(jv0 jv0) {
            super(0);
            this.a = jv0;
        }

        /* renamed from: b */
        public final e invoke() {
            LayoutInflater from = LayoutInflater.from(this.a.getBaseContext());
            lu.b(from, "LayoutInflater.from(baseContext)");
            return new e(from, this.a, false);
        }
    }

    public Object getSystemService(String name) {
        lu.g(name, "name");
        if (lu.a("layout_inflater", name)) {
            return a();
        }
        return super.getSystemService(name);
    }

    /* renamed from: jv0$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(Cif $constructor_marker) {
            this();
        }

        public final ContextWrapper a(Context base) {
            lu.g(base, "base");
            return new jv0(base, (Cif) null);
        }
    }
}
