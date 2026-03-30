package defpackage;

import defpackage.yc;
import java.io.Closeable;

/* renamed from: vj  reason: default package */
public abstract class vj extends ad implements Closeable {
    public static final a a = new a((Cif) null);

    /* renamed from: vj$a */
    public static final class a extends l<ad, vj> {
        public /* synthetic */ a(Cif ifVar) {
            this();
        }

        private a() {
            super(ad.Key, C0061a.a);
        }

        /* renamed from: vj$a$a  reason: collision with other inner class name */
        static final class C0061a extends ow implements vn<yc.b, vj> {
            public static final C0061a a = new C0061a();

            C0061a() {
                super(1);
            }

            /* renamed from: b */
            public final vj invoke(yc.b it) {
                if (it instanceof vj) {
                    return (vj) it;
                }
                return null;
            }
        }
    }
}
