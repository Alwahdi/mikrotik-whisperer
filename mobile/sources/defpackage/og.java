package defpackage;

import com.blogspot.yemeninfo4it.mumsmobile_app.model.ak;
import java.net.DatagramPacket;

/* renamed from: og  reason: default package */
public class og {
    String a = null;
    String b = null;
    String c = null;
    String d = null;
    String e = null;

    public og(DatagramPacket datagramPacket) {
        byte[] data = datagramPacket.getData();
        this.c = datagramPacket.getAddress().toString().substring(1);
        this.d = b(data, ak.DISCOVERY_TAG_MACADDR);
        this.b = b(data, ak.DISCOVERY_TAG_IDENTITY);
        this.e = b(data, ak.DISCOVERY_TAG_VERSION);
        this.a = b(data, ak.DISCOVERY_TAG_BOARDNAME);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String b(byte[] r7, com.blogspot.yemeninfo4it.mumsmobile_app.model.ak r8) {
        /*
            r6 = this;
            r0 = 0
        L_0x0001:
            int r1 = r7.length
            int r1 = r1 + -4
            if (r0 >= r1) goto L_0x0035
            int r1 = r0 + 1
            byte r1 = r7[r1]
            int r2 = r8.a()
            if (r1 != r2) goto L_0x0032
            int r1 = r0 + 4
            java.lang.String r2 = ""
            int r3 = r0 + 3
            byte r3 = r7[r3]
        L_0x0018:
            if (r3 <= 0) goto L_0x0031
            int r3 = r3 + -1
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            byte r5 = r7[r1]
            char r5 = (char) r5
            r4.append(r5)
            java.lang.String r2 = r4.toString()
            int r1 = r1 + 1
            goto L_0x0018
        L_0x0031:
            return r2
        L_0x0032:
            int r0 = r0 + 1
            goto L_0x0001
        L_0x0035:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.og.b(byte[], com.blogspot.yemeninfo4it.mumsmobile_app.model.ak):java.lang.String");
    }

    public String a() {
        return d2.a(this.d);
    }

    public String f() {
        return this.c;
    }

    public String g() {
        return d2.a(this.d);
    }

    public String e() {
        return this.b;
    }

    public String d() {
        return this.a;
    }

    public boolean c() {
        String str = this.c;
        int indexOf = str.indexOf("%");
        if (indexOf != -1) {
            str = str.substring(0, indexOf);
        }
        if (str.isEmpty() || this.d.isEmpty() || this.a.isEmpty()) {
            return false;
        }
        if (d2.c(str) || d2.d(str)) {
            return true;
        }
        return false;
    }
}
