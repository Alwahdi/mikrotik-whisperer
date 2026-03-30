package defpackage;

import kotlinx.coroutines.internal.b;

/* renamed from: k30  reason: default package */
public final class k30 extends qy implements gs {
    public boolean c() {
        return true;
    }

    public k30 d() {
        return this;
    }

    public final String s(String state) {
        StringBuilder sb = new StringBuilder();
        StringBuilder $this$getString_u24lambda_u2d1 = sb;
        $this$getString_u24lambda_u2d1.append("List{");
        $this$getString_u24lambda_u2d1.append(state);
        $this$getString_u24lambda_u2d1.append("}[");
        boolean first = true;
        for (b cur$iv = (b) k(); !lu.a(cur$iv, this); cur$iv = cur$iv.l()) {
            if (cur$iv instanceof lv) {
                lv node = (lv) cur$iv;
                if (first) {
                    first = false;
                } else {
                    $this$getString_u24lambda_u2d1.append(", ");
                }
                $this$getString_u24lambda_u2d1.append(node);
            }
        }
        $this$getString_u24lambda_u2d1.append("]");
        String sb2 = sb.toString();
        lu.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public String toString() {
        return af.c() ? s("Active") : super.toString();
    }
}
