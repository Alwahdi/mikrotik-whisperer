package defpackage;

import java.util.HashMap;

/* renamed from: h7  reason: default package */
public class h7 extends g {
    private HashMap<Integer, byte[]> a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f3149a = new byte[0];

    /* access modifiers changed from: package-private */
    public void a(n80 mark, o70 code) {
        if (code instanceof k70) {
            this.a.put(Integer.valueOf(((k70) code).J()), g.d(mark));
        }
    }

    public byte[] n(int cid) {
        byte[] ser = this.a.get(Integer.valueOf(cid));
        if (ser == null) {
            return this.f3149a;
        }
        return ser;
    }
}
