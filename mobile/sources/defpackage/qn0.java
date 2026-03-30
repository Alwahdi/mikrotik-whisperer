package defpackage;

/* renamed from: qn0  reason: default package */
public abstract class qn0 {
    private static final byte[] a = fh.b("\\r");
    private static final byte[] b = fh.b("\\n");
    private static final byte[] c = fh.b("\\t");
    private static final byte[] d = fh.b("\\b");
    private static final byte[] e = fh.b("\\f");

    public static byte[] c(byte[] bytes) {
        w6 content = new w6();
        b(bytes, content);
        return content.c0();
    }

    public static void b(byte[] bytes, w6 content) {
        content.V(40);
        for (byte c2 : bytes) {
            switch (c2) {
                case 8:
                    content.K(d);
                    break;
                case 9:
                    content.K(c);
                    break;
                case 10:
                    content.K(b);
                    break;
                case 12:
                    content.K(e);
                    break;
                case 13:
                    content.K(a);
                    break;
                case 40:
                case 41:
                case 92:
                    content.V(92).V(c2);
                    break;
                default:
                    content.V(c2);
                    break;
            }
        }
        content.V(41);
    }

    public static byte[] a(char[] chars) {
        byte[] result = new byte[(chars.length * 2)];
        for (int i = 0; i < chars.length; i++) {
            result[i * 2] = (byte) (chars[i] / 256);
            result[(i * 2) + 1] = (byte) (chars[i] % 256);
        }
        return result;
    }
}
