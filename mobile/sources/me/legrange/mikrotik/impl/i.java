package me.legrange.mikrotik.impl;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import me.legrange.mikrotik.impl.m;

class i {
    private String a;

    /* renamed from: a  reason: collision with other field name */
    private d f4344a;

    /* renamed from: a  reason: collision with other field name */
    private m.a f4345a;

    /* renamed from: a  reason: collision with other field name */
    private final m f4346a;

    static d p(String text) {
        return new i(text).o();
    }

    private d o() {
        m.a aVar;
        m.a aVar2;
        m.a aVar3;
        b();
        while (true) {
            aVar = m.a.WHERE;
            aVar2 = m.a.RETURN;
            aVar3 = m.a.EOL;
            if (g(aVar, aVar2, aVar3)) {
                break;
            }
            n();
        }
        if (this.f4345a == aVar) {
            r();
        }
        if (this.f4345a == aVar2) {
            q();
        }
        d(aVar3);
        return this.f4344a;
    }

    private void b() {
        m.a aVar;
        StringBuilder path = new StringBuilder();
        do {
            aVar = m.a.SLASH;
            d(aVar);
            path.append("/");
            j();
            d(m.a.TEXT);
            path.append(this.a);
            j();
        } while (this.f4345a == aVar);
        this.f4344a = new d(path.toString());
    }

    private void n() {
        String name = this.a;
        j();
        if (this.f4345a == m.a.EQUALS) {
            j();
            StringBuilder val = new StringBuilder();
            m.a aVar = this.f4345a;
            if (aVar == m.a.PIPE) {
                val.append(aVar);
                j();
            }
            d(m.a.TEXT);
            val.append(this.a);
            j();
            while (true) {
                if (g(m.a.COMMA, m.a.SLASH)) {
                    val.append(this.f4345a);
                    j();
                    d(m.a.TEXT);
                    val.append(this.a);
                    j();
                } else {
                    this.f4344a.b(new g(name, val.toString()));
                    return;
                }
            }
        } else {
            this.f4344a.b(new g(name));
        }
    }

    private void r() {
        j();
        e();
    }

    private void e() {
        d(m.a.NOT, m.a.TEXT);
        int[] iArr = a.a;
        switch (iArr[this.f4345a.ordinal()]) {
            case 5:
                k();
                break;
            case 6:
                String name = this.a;
                j();
                d(m.a.EQUALS, m.a.LESS, m.a.MORE, m.a.NOT_EQUALS);
                switch (iArr[this.f4345a.ordinal()]) {
                    case 1:
                        c(name);
                        break;
                    case 2:
                        l(name);
                        break;
                    case 3:
                        h(name);
                        break;
                    case 4:
                        i(name);
                        break;
                    default:
                        f(name);
                        break;
                }
        }
        switch (iArr[this.f4345a.ordinal()]) {
            case 7:
                a();
                return;
            case 8:
                m();
                return;
            default:
                return;
        }
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[m.a.values().length];
            a = iArr;
            try {
                iArr[m.a.EQUALS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[m.a.NOT_EQUALS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[m.a.LESS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[m.a.MORE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[m.a.NOT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[m.a.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[m.a.AND.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                a[m.a.OR.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    private void a() {
        j();
        e();
        this.f4344a.d("?#&");
    }

    private void m() {
        j();
        e();
        this.f4344a.d("?#|");
    }

    private void k() {
        j();
        e();
        this.f4344a.d("?#!");
    }

    private void c(String name) {
        j();
        d(m.a.TEXT);
        this.f4344a.d(String.format("?%s=%s", new Object[]{name, this.a}));
        j();
    }

    private void h(String name) {
        j();
        this.f4344a.d(String.format("?<%s=%s", new Object[]{name, this.a}));
        j();
    }

    private void l(String name) {
        j();
        this.f4344a.d(String.format("?%s=%s", new Object[]{name, this.a}));
        this.f4344a.d("?#!");
        j();
    }

    private void i(String name) {
        j();
        this.f4344a.d(String.format("?>%s=%s", new Object[]{name, this.a}));
        j();
    }

    private void f(String name) {
        this.f4344a.d(String.format("?%s", new Object[]{name}));
    }

    private void q() {
        j();
        d(m.a.TEXT);
        List<String> props = new LinkedList<>();
        while (true) {
            m.a aVar = this.f4345a;
            if (aVar != m.a.EOL) {
                if (aVar != m.a.COMMA) {
                    props.add(this.a);
                }
                j();
            } else {
                this.f4344a.c((String[]) props.toArray(new String[props.size()]));
                return;
            }
        }
    }

    private void d(m.a... tokens) {
        if (!g(tokens)) {
            throw new h(String.format("Expected %s but found %s at position %d", new Object[]{Arrays.asList(tokens), this.f4345a, Integer.valueOf(this.f4346a.f())}));
        }
    }

    private boolean g(m.a... tokens) {
        for (m.a want : tokens) {
            if (this.f4345a == want) {
                return true;
            }
        }
        return false;
    }

    private void j() {
        this.f4345a = this.f4346a.c();
        while (this.f4345a == m.a.WS) {
            this.f4345a = this.f4346a.c();
        }
        this.a = this.f4346a.h();
    }

    private i(String line) {
        this.f4346a = new m(line.trim());
        j();
    }
}
