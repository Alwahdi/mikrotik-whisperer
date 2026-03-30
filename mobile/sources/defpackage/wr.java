package defpackage;

import java.net.URL;
import java.security.MessageDigest;

/* renamed from: wr  reason: default package */
public class wr extends tr {
    private byte[] c;
    private byte[] d;

    public wr(int width, int height, byte[] data, byte[] globals) {
        super((URL) null);
        this.c = 36;
        this.g = 9;
        float f = (float) height;
        this.o = f;
        Y(f);
        float f2 = (float) width;
        this.n = f2;
        W(f2);
        this.d = 1;
        this.f5149j = 1;
        this.f5139a = data;
        this.l = M();
        this.m = D();
        if (globals != null) {
            this.c = globals;
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                try {
                    md.update(this.c);
                    this.d = md.digest();
                } catch (Exception e) {
                }
            } catch (Exception e2) {
            }
        }
    }

    public byte[] t1() {
        return this.c;
    }
}
