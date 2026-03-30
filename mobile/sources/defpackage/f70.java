package defpackage;

import java.io.OutputStream;

/* renamed from: f70  reason: default package */
public class f70 extends o70 {
    private long a;

    public f70(String text) {
        super(0, text);
    }

    public f70(byte[] b) {
        super(0, b);
    }

    public f70(int type, String text) {
        super(type, text);
    }

    public void F(v80 writer, OutputStream os) {
        if (os instanceof z40) {
            this.a = ((z40) os).c();
        }
        super.F(writer, os);
    }
}
