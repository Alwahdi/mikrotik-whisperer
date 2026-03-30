package defpackage;

import java.io.UnsupportedEncodingException;

/* renamed from: ud  reason: default package */
public abstract class ud {
    public static String a(String userName, String password) {
        try {
            String encoded = a7.i((userName + ":" + password).getBytes("ISO-8859-1")).a();
            return "Basic " + encoded;
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError();
        }
    }
}
