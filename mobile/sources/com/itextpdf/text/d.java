package com.itextpdf.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class d extends ArrayList<bi> implements bi {
    protected float a;

    /* renamed from: a  reason: collision with other field name */
    protected ar f2630a;

    /* renamed from: a  reason: collision with other field name */
    protected b f2631a;

    /* renamed from: a  reason: collision with other field name */
    protected gp0 f2632a;
    protected float b;

    public d() {
        this(16.0f);
    }

    public d(d phrase) {
        this.a = Float.NaN;
        this.b = 0.0f;
        this.f2630a = null;
        addAll(phrase);
        N(phrase.G(), phrase.H());
        this.f2631a = phrase.E();
        phrase.I();
        M(phrase.F());
    }

    public d(float leading) {
        this.a = Float.NaN;
        this.b = 0.0f;
        this.f2630a = null;
        this.a = leading;
        this.f2631a = new b();
    }

    public d(a chunk) {
        this.a = Float.NaN;
        this.b = 0.0f;
        this.f2630a = null;
        super.add(chunk);
        this.f2631a = chunk.g();
        M(chunk.i());
    }

    public d(String string, b font) {
        this(Float.NaN, string, font);
    }

    public d(float leading, String string, b font) {
        this.a = Float.NaN;
        this.b = 0.0f;
        this.f2630a = null;
        this.a = leading;
        this.f2631a = font;
        if (string != null && string.length() != 0) {
            super.add(new a(string, font));
        }
    }

    public boolean a(ci listener) {
        try {
            Iterator i$ = iterator();
            while (i$.hasNext()) {
                listener.c((bi) i$.next());
            }
            return true;
        } catch (ih e) {
            return false;
        }
    }

    public int v() {
        return 11;
    }

    public List<a> t() {
        List<Chunk> tmp = new ArrayList<>();
        Iterator i$ = iterator();
        while (i$.hasNext()) {
            tmp.addAll(((bi) i$.next()).t());
        }
        return tmp;
    }

    public boolean r() {
        return true;
    }

    /* renamed from: z */
    public void add(int index, bi element) {
        if (element != null) {
            switch (element.v()) {
                case 10:
                    a chunk = (a) element;
                    if (!this.f2631a.n()) {
                        chunk.x(this.f2631a.b(chunk.g()));
                    }
                    if (this.f2630a != null && chunk.i() == null && !chunk.o()) {
                        chunk.y(this.f2630a);
                    }
                    super.add(index, chunk);
                    return;
                case 11:
                case 12:
                case 14:
                case 17:
                case 23:
                case 29:
                case 37:
                case 50:
                case 55:
                case 666:
                    super.add(index, element);
                    return;
                default:
                    throw new ClassCastException(i10.b("insertion.of.illegal.element.1", element.getClass().getName()));
            }
        }
    }

    /* renamed from: A */
    public boolean add(bi element) {
        if (element == null) {
            return false;
        }
        try {
            switch (element.v()) {
                case 10:
                    return B((a) element);
                case 11:
                case 12:
                    boolean success = true;
                    Iterator i$ = ((d) element).iterator();
                    while (i$.hasNext()) {
                        bi e = (bi) i$.next();
                        if (e instanceof a) {
                            success &= B((a) e);
                        } else {
                            success &= add(e);
                        }
                    }
                    return success;
                case 14:
                case 17:
                case 23:
                case 29:
                case 37:
                case 50:
                case 55:
                case 666:
                    return super.add(element);
                default:
                    throw new ClassCastException(String.valueOf(element.v()));
            }
        } catch (ClassCastException cce) {
            throw new ClassCastException(i10.b("insertion.of.illegal.element.1", cce.getMessage()));
        }
    }

    public boolean addAll(Collection<? extends bi> collection) {
        for (bi e : collection) {
            add(e);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean B(a chunk) {
        boolean sameRole;
        b f = chunk.g();
        String c = chunk.f();
        b bVar = this.f2631a;
        if (bVar != null && !bVar.n()) {
            f = this.f2631a.b(chunk.g());
        }
        if (size() > 0 && !chunk.n()) {
            try {
                a previous = (a) get(size() - 1);
                h70 previousRole = previous.j();
                h70 chunkRole = chunk.j();
                if (previousRole != null) {
                    if (chunkRole != null) {
                        sameRole = previousRole.equals(chunkRole);
                        if (sameRole && !previous.n() && !chunk.m() && !previous.m() && ((f == null || f.compareTo(previous.g()) == 0) && !"".equals(previous.f().trim()) && !"".equals(c.trim()))) {
                            previous.c(c);
                            return true;
                        }
                    }
                }
                sameRole = true;
                previous.c(c);
                return true;
            } catch (ClassCastException e) {
            }
        }
        a newChunk = new a(c, f);
        newChunk.w(chunk.e());
        newChunk.f2617a = chunk.j();
        newChunk.f2621b = chunk.u();
        if (this.f2630a != null && newChunk.i() == null && !newChunk.o()) {
            newChunk.y(this.f2630a);
        }
        return super.add(newChunk);
    }

    /* access modifiers changed from: protected */
    public void D(bi object) {
        super.add(object);
    }

    public void N(float fixedLeading, float multipliedLeading) {
        this.a = fixedLeading;
        this.b = multipliedLeading;
    }

    public void L(b font) {
        this.f2631a = font;
    }

    public float G() {
        b bVar;
        if (!Float.isNaN(this.a) || (bVar = this.f2631a) == null) {
            return this.a;
        }
        return bVar.e(1.5f);
    }

    public float H() {
        return this.b;
    }

    public float J() {
        b bVar = this.f2631a;
        float m = bVar == null ? this.b * 12.0f : bVar.e(this.b);
        if (m <= 0.0f || K()) {
            return G() + m;
        }
        return m;
    }

    public boolean K() {
        if (Float.isNaN(this.a)) {
            return false;
        }
        return true;
    }

    public b E() {
        return this.f2631a;
    }

    public boolean isEmpty() {
        switch (size()) {
            case 0:
                return true;
            case 1:
                bi element = (bi) get(0);
                return element.v() == 10 && ((a) element).o();
            default:
                return false;
        }
    }

    public ar F() {
        return this.f2630a;
    }

    public void M(ar hyphenation) {
        this.f2630a = hyphenation;
    }

    public gp0 I() {
        return this.f2632a;
    }

    public void O(gp0 tabSettings) {
    }
}
