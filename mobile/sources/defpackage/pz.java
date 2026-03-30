package defpackage;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/* renamed from: pz  reason: default package */
public final class pz {
    public static final nz a;

    /* renamed from: a  reason: collision with other field name */
    public static final pz f4736a;

    /* renamed from: a  reason: collision with other field name */
    private static final boolean f4737a = zo0.e("kotlinx.coroutines.fast.service.loader", true);

    private pz() {
    }

    static {
        pz pzVar = new pz();
        f4736a = pzVar;
        a = pzVar.a();
    }

    private final nz a() {
        List<oz> $this$maxByOrNull$iv;
        Object maxElem$iv;
        nz e;
        Class<oz> cls = oz.class;
        try {
            if (f4737a) {
                $this$maxByOrNull$iv = lk.a.c();
            } else {
                $this$maxByOrNull$iv = kk0.k(ik0.c(ServiceLoader.load(cls, cls.getClassLoader()).iterator()));
            }
            Iterator iterator$iv = $this$maxByOrNull$iv.iterator();
            if (!iterator$iv.hasNext()) {
                maxElem$iv = null;
            } else {
                maxElem$iv = iterator$iv.next();
                if (iterator$iv.hasNext()) {
                    int maxValue$iv = ((oz) maxElem$iv).c();
                    do {
                        Object next = iterator$iv.next();
                        int v$iv = ((oz) next).c();
                        if (maxValue$iv < v$iv) {
                            maxElem$iv = next;
                            maxValue$iv = v$iv;
                        }
                    } while (iterator$iv.hasNext());
                }
            }
            oz ozVar = (oz) maxElem$iv;
            if (ozVar == null || (e = qz.e(ozVar, $this$maxByOrNull$iv)) == null) {
                return qz.b((Throwable) null, (String) null, 3, (Object) null);
            }
            return e;
        } catch (Throwable e2) {
            return qz.b(e2, (String) null, 2, (Object) null);
        }
    }
}
