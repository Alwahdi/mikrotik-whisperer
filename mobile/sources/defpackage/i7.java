package defpackage;

/* renamed from: i7  reason: default package */
public class i7 extends g {
    private ys a = new ys(65537);

    /* access modifiers changed from: package-private */
    public void a(n80 mark, o70 code) {
        int codepoint;
        if (code instanceof k70) {
            String s = e(mark);
            if (tu0.h(s, 0)) {
                codepoint = tu0.c(s, 0);
            } else {
                codepoint = s.charAt(0);
            }
            this.a.d(((k70) code).J(), codepoint);
        }
    }

    public int n(int character) {
        return this.a.b(character);
    }
}
