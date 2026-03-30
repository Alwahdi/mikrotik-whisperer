package defpackage;

import java.io.OutputStream;

/* renamed from: z60  reason: default package */
public class z60 extends o70 {
    protected int b;
    protected int c;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    z60(int r3, int r4, int r5) {
        /*
            r2 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r0.append(r4)
            java.lang.String r1 = " "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r1 = " R"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 0
            r2.<init>((int) r1, (java.lang.String) r0)
            r2.c = r1
            r2.b = r4
            r2.c = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z60.<init>(int, int, int):void");
    }

    protected z60(int type, int number) {
        this(type, number, 0);
    }

    public int I() {
        return this.b;
    }

    public int H() {
        return this.c;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.b);
        stringBuffer.append(" ");
        stringBuffer.append(this.c);
        stringBuffer.append(" R");
        return stringBuffer.toString();
    }

    public void F(v80 writer, OutputStream os) {
        os.write(n60.c(toString(), (String) null));
    }
}
