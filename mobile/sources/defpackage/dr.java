package defpackage;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/* renamed from: dr  reason: default package */
public class dr {
    private static HashMap<String, Integer> a;

    /* renamed from: a  reason: collision with other field name */
    protected int f2815a;

    /* renamed from: a  reason: collision with other field name */
    protected byte[] f2816a;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        a = hashMap;
        hashMap.put("XYZ ", 3);
        a.put("Lab ", 3);
        a.put("Luv ", 3);
        a.put("YCbr", 3);
        a.put("Yxy ", 3);
        a.put("RGB ", 3);
        a.put("GRAY", 1);
        a.put("HSV ", 3);
        a.put("HLS ", 3);
        a.put("CMYK", 4);
        a.put("CMY ", 3);
        a.put("2CLR", 2);
        a.put("3CLR", 3);
        a.put("4CLR", 4);
        a.put("5CLR", 5);
        a.put("6CLR", 6);
        a.put("7CLR", 7);
        a.put("8CLR", 8);
        a.put("9CLR", 9);
        a.put("ACLR", 10);
        a.put("BCLR", 11);
        a.put("CCLR", 12);
        a.put("DCLR", 13);
        a.put("ECLR", 14);
        a.put("FCLR", 15);
    }

    protected dr() {
    }

    public static dr c(byte[] data, int numComponents) {
        int nc = 0;
        if (data.length >= 128 && data[36] == 97 && data[37] == 99 && data[38] == 115 && data[39] == 112) {
            try {
                dr icc = new dr();
                icc.f2816a = data;
                Integer cs = a.get(new String(data, 16, 4, "US-ASCII"));
                if (cs != null) {
                    nc = cs.intValue();
                }
                icc.f2815a = nc;
                if (nc == numComponents) {
                    return icc;
                }
                throw new IllegalArgumentException("ICC profile contains " + nc + " component(s), the image data contains " + numComponents + " component(s)");
            } catch (UnsupportedEncodingException e) {
                throw new mj(e);
            }
        } else {
            throw new IllegalArgumentException(i10.b("invalid.icc.profile", new Object[0]));
        }
    }

    public static dr b(byte[] data) {
        try {
            Integer cs = a.get(new String(data, 16, 4, "US-ASCII"));
            return c(data, cs == null ? 0 : cs.intValue());
        } catch (UnsupportedEncodingException e) {
            throw new mj(e);
        }
    }

    public byte[] a() {
        return this.f2816a;
    }

    public int d() {
        return this.f2815a;
    }
}
