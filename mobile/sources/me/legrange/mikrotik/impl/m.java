package me.legrange.mikrotik.impl;

import java.util.Locale;

class m {
    private char a;

    /* renamed from: a  reason: collision with other field name */
    private int f4347a = 0;

    /* renamed from: a  reason: collision with other field name */
    private final String f4348a;

    /* renamed from: a  reason: collision with other field name */
    private StringBuilder f4349a;

    enum a {
        SLASH("/"),
        COMMA(","),
        EOL,
        WS,
        TEXT,
        LESS("<"),
        MORE(">"),
        EQUALS("="),
        NOT_EQUALS("!="),
        PIPE("!"),
        WHERE,
        NOT,
        AND,
        OR,
        RETURN;
        
        private final String symb;

        public String toString() {
            String str = this.symb;
            return str == null ? name() : str;
        }

        private a(String symb2) {
            this.symb = symb2;
        }
    }

    m(String line) {
        this.f4348a = line;
        d();
    }

    /* access modifiers changed from: package-private */
    public a c() {
        this.f4349a = null;
        switch (this.a) {
            case 9:
            case ' ':
                return i();
            case 10:
                return a.EOL;
            case '!':
                return e();
            case '\"':
                return g('\"');
            case '\'':
                return g('\'');
            case ',':
                d();
                return a.COMMA;
            case '/':
                d();
                return a.SLASH;
            case '<':
                d();
                return a.LESS;
            case '=':
                d();
                return a.EQUALS;
            case '>':
                d();
                return a.MORE;
            default:
                return b();
        }
    }

    /* access modifiers changed from: package-private */
    public String h() {
        StringBuilder sb = this.f4349a;
        if (sb != null) {
            return sb.toString();
        }
        return "";
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f4347a;
    }

    private a b() {
        this.f4349a = new StringBuilder();
        while (!a(this.a, "[ \t\r\n=<>!]")) {
            this.f4349a.append(this.a);
            d();
        }
        String val = this.f4349a.toString().toLowerCase(Locale.getDefault());
        char c = 65535;
        switch (val.hashCode()) {
            case -934396624:
                if (val.equals("return")) {
                    c = 4;
                    break;
                }
                break;
            case 3555:
                if (val.equals("or")) {
                    c = 3;
                    break;
                }
                break;
            case 96727:
                if (val.equals("and")) {
                    c = 2;
                    break;
                }
                break;
            case 109267:
                if (val.equals("not")) {
                    c = 1;
                    break;
                }
                break;
            case 113097959:
                if (val.equals("where")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return a.WHERE;
            case 1:
                return a.NOT;
            case 2:
                return a.AND;
            case 3:
                return a.OR;
            case 4:
                return a.RETURN;
            default:
                return a.TEXT;
        }
    }

    private a g(char quote) {
        d();
        this.f4349a = new StringBuilder();
        while (true) {
            char c = this.a;
            if (c == quote) {
                d();
                return a.TEXT;
            } else if (c != 10) {
                this.f4349a.append(c);
                d();
            } else {
                throw new l("Unclosed quoted text, reached end of line.");
            }
        }
    }

    private a e() {
        d();
        if (this.a != '=') {
            return a.PIPE;
        }
        d();
        return a.NOT_EQUALS;
    }

    private a i() {
        while (true) {
            char c = this.a;
            if (c != ' ' && c != 9) {
                return a.WS;
            }
            d();
        }
    }

    private void d() {
        if (this.f4347a < this.f4348a.length()) {
            this.a = this.f4348a.charAt(this.f4347a);
            this.f4347a++;
            return;
        }
        this.a = 10;
    }

    private boolean a(char c, String cs) {
        return ("" + c).matches(cs);
    }
}
