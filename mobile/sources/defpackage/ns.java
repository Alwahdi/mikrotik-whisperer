package defpackage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: ns  reason: default package */
public final class ns {
    public static final a a = new a((Cif) null);

    /* renamed from: a  reason: collision with other field name */
    private final Context f4454a;

    /* renamed from: a  reason: collision with other field name */
    private final AttributeSet f4455a;

    /* renamed from: a  reason: collision with other field name */
    private final View f4456a;

    /* renamed from: a  reason: collision with other field name */
    private final String f4457a;

    /* renamed from: a  reason: collision with other field name */
    private final kk f4458a;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ns)) {
            return false;
        }
        ns nsVar = (ns) obj;
        return lu.a(this.f4457a, nsVar.f4457a) && lu.a(this.f4454a, nsVar.f4454a) && lu.a(this.f4455a, nsVar.f4455a) && lu.a(this.f4456a, nsVar.f4456a) && lu.a(this.f4458a, nsVar.f4458a);
    }

    public int hashCode() {
        String str = this.f4457a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Context context = this.f4454a;
        int hashCode2 = (hashCode + (context != null ? context.hashCode() : 0)) * 31;
        AttributeSet attributeSet = this.f4455a;
        int hashCode3 = (hashCode2 + (attributeSet != null ? attributeSet.hashCode() : 0)) * 31;
        View view = this.f4456a;
        int hashCode4 = (hashCode3 + (view != null ? view.hashCode() : 0)) * 31;
        kk kkVar = this.f4458a;
        if (kkVar != null) {
            i = kkVar.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "InflateRequest(name=" + this.f4457a + ", context=" + this.f4454a + ", attrs=" + this.f4455a + ", parent=" + this.f4456a + ", fallbackViewCreator=" + this.f4458a + ")";
    }

    public ns(String name, Context context, AttributeSet attrs, View parent, kk fallbackViewCreator) {
        lu.g(name, "name");
        lu.g(context, "context");
        lu.g(fallbackViewCreator, "fallbackViewCreator");
        this.f4457a = name;
        this.f4454a = context;
        this.f4455a = attrs;
        this.f4456a = parent;
        this.f4458a = fallbackViewCreator;
    }

    public final String d() {
        return this.f4457a;
    }

    public final Context b() {
        return this.f4454a;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ns(java.lang.String r8, android.content.Context r9, android.util.AttributeSet r10, android.view.View r11, defpackage.kk r12, int r13, defpackage.Cif r14) {
        /*
            r7 = this;
            r14 = r13 & 4
            r0 = 0
            if (r14 == 0) goto L_0x0007
            r4 = r0
            goto L_0x0008
        L_0x0007:
            r4 = r10
        L_0x0008:
            r10 = r13 & 8
            if (r10 == 0) goto L_0x000e
            r5 = r0
            goto L_0x000f
        L_0x000e:
            r5 = r11
        L_0x000f:
            r1 = r7
            r2 = r8
            r3 = r9
            r6 = r12
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ns.<init>(java.lang.String, android.content.Context, android.util.AttributeSet, android.view.View, kk, int, if):void");
    }

    public final AttributeSet a() {
        return this.f4455a;
    }

    public final View e() {
        return this.f4456a;
    }

    public final kk c() {
        return this.f4458a;
    }

    /* renamed from: ns$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(Cif $constructor_marker) {
            this();
        }
    }
}
