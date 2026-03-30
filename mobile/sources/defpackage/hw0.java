package defpackage;

/* renamed from: hw0  reason: default package */
public abstract class hw0 {
    public static String a(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i < str.length(); i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return b(bArr);
    }

    public static String b(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[i])}));
            if (i + 1 < bArr.length) {
                stringBuilder.append(":");
            }
        }
        return stringBuilder.toString();
    }

    public static boolean c(String str) {
        return str.matches("^\\/*(\\d{1,3}\\.){3}\\d{1,3}$");
    }

    public static boolean d(String str) {
        return str.matches("([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}");
    }
}
