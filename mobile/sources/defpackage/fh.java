package defpackage;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: fh  reason: default package */
public abstract class fh implements eh {
    protected gh a;

    /* renamed from: a  reason: collision with other field name */
    protected pd0 f2970a;

    /* renamed from: a  reason: collision with other field name */
    protected z40 f2971a;

    /* renamed from: a  reason: collision with other field name */
    protected boolean f2972a = false;
    protected boolean b = false;
    protected boolean c = true;

    protected fh(gh document, OutputStream os) {
        this.a = document;
        this.f2971a = new z40(new BufferedOutputStream(os));
    }

    public boolean c(bi element) {
        return false;
    }

    public void open() {
        this.f2972a = true;
    }

    public boolean d(pd0 pageSize) {
        this.f2970a = pageSize;
        return true;
    }

    public boolean a(float marginLeft, float marginRight, float marginTop, float marginBottom) {
        return false;
    }

    public boolean e() {
        if (!this.f2972a) {
            return false;
        }
        return true;
    }

    public void close() {
        this.f2972a = false;
        try {
            this.f2971a.flush();
            if (this.c) {
                this.f2971a.close();
            }
        } catch (IOException ioe) {
            throw new mj(ioe);
        }
    }

    public static final byte[] b(String text) {
        if (text == null) {
            return null;
        }
        int len = text.length();
        byte[] b2 = new byte[len];
        for (int k = 0; k < len; k++) {
            b2[k] = (byte) text.charAt(k);
        }
        return b2;
    }

    public boolean f() {
        return this.b;
    }
}
