package defpackage;

/* renamed from: f8  reason: default package */
public abstract class f8 {
    public static f8 c() {
        return d.a;
    }

    public static f8 e() {
        return e.f2955a;
    }

    public static f8 b(char match) {
        return new b(match);
    }

    protected f8() {
    }

    /* access modifiers changed from: private */
    public static String d(char c2) {
        char[] tmp = {'\\', 'u', 0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            tmp[5 - i] = "0123456789ABCDEF".charAt(c2 & 15);
            c2 = (char) (c2 >> 4);
        }
        return String.copyValueOf(tmp);
    }

    /* renamed from: f8$a */
    static abstract class a extends f8 {
        a() {
        }
    }

    /* renamed from: f8$c */
    static abstract class c extends a {
        private final String a;

        c(String description) {
            this.a = (String) v90.n(description);
        }

        public final String toString() {
            return this.a;
        }
    }

    /* renamed from: f8$d */
    private static final class d extends c {
        static final d a = new d();

        private d() {
            super("CharMatcher.none()");
        }
    }

    /* renamed from: f8$e */
    static final class e extends c {
        static final int a = Integer.numberOfLeadingZeros(" 　\r   　 \u000b　   　 \t     \f 　 　　 \n 　".length() - 1);

        /* renamed from: a  reason: collision with other field name */
        static final e f2955a = new e();

        e() {
            super("CharMatcher.whitespace()");
        }
    }

    /* renamed from: f8$b */
    private static final class b extends a {
        private final char a;

        b(char match) {
            this.a = match;
        }

        public String toString() {
            return "CharMatcher.is('" + f8.d(this.a) + "')";
        }
    }
}
