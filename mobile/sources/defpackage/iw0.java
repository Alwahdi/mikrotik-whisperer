package defpackage;

import android.util.Base64;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: iw0  reason: default package */
public abstract class iw0 {
    private static final byte[] a = {99, 111, 100, 105, 110, 103, 97, 119, 102, 97, 105, 114, 115, 99, 111, 109};

    public static String a(String encrypted) {
        return new String(b(e(encrypted)));
    }

    private static byte[] b(byte[] encrypted) {
        SecretKey skeySpec = new SecretKeySpec(a, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(2, skeySpec);
        return cipher.doFinal(encrypted);
    }

    public static byte[] e(String hexString) {
        int len = hexString.length() / 2;
        byte[] result = new byte[len];
        for (int i = 0; i < len; i++) {
            result[i] = Integer.valueOf(hexString.substring(i * 2, (i * 2) + 2), 16).byteValue();
        }
        return result;
    }

    public static String d(String value) {
        Key key = c();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, key);
        return Base64.encodeToString(cipher.doFinal(value.getBytes("utf-8")), 0);
    }

    private static Key c() {
        return new SecretKeySpec("kcU7JmSfPLLA9jc4".getBytes(), "AES");
    }
}
