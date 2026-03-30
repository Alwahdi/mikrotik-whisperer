package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: r01  reason: default package */
public final class r01 {
    /* access modifiers changed from: private */
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    private final k11 f4871a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final oz0 f4872a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f4873a;

    private r01(k11 k11) {
        this(k11, false, wz0.a, Integer.MAX_VALUE);
    }

    private r01(k11 k11, boolean z, oz0 oz0, int i) {
        this.f4871a = k11;
        this.f4873a = false;
        this.f4872a = oz0;
        this.a = Integer.MAX_VALUE;
    }

    public static r01 c(char c) {
        sz0 sz0 = new sz0('.');
        t01.c(sz0);
        return new r01(new y01(sz0));
    }

    public final List<String> a(CharSequence charSequence) {
        t01.c(charSequence);
        Iterator<String> a2 = this.f4871a.a(this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (a2.hasNext()) {
            arrayList.add(a2.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
