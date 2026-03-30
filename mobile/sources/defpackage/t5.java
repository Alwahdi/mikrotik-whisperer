package defpackage;

import java.io.UnsupportedEncodingException;

/* renamed from: t5  reason: default package */
abstract class t5 {
    private static final byte[] a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    public static String a(byte[] in) {
        return b(in, a);
    }

    private static String b(byte[] in, byte[] map) {
        byte[] out = new byte[(((in.length + 2) / 3) * 4)];
        int index = 0;
        int end = in.length - (in.length % 3);
        for (int i = 0; i < end; i += 3) {
            int index2 = index + 1;
            out[index] = map[(in[i] & 255) >> 2];
            int index3 = index2 + 1;
            out[index2] = map[((in[i] & 3) << 4) | ((in[i + 1] & 255) >> 4)];
            int index4 = index3 + 1;
            out[index3] = map[((in[i + 1] & 15) << 2) | ((in[i + 2] & 255) >> 6)];
            index = index4 + 1;
            out[index4] = map[in[i + 2] & 63];
        }
        switch (in.length % 3) {
            case 1:
                int index5 = index + 1;
                out[index] = map[(in[end] & 255) >> 2];
                int index6 = index5 + 1;
                out[index5] = map[(in[end] & 3) << 4];
                int index7 = index6 + 1;
                out[index6] = 61;
                int i2 = index7 + 1;
                out[index7] = 61;
                break;
            case 2:
                int index8 = index + 1;
                out[index] = map[(in[end] & 255) >> 2];
                int index9 = index8 + 1;
                out[index8] = map[((in[end] & 3) << 4) | ((in[end + 1] & 255) >> 4)];
                int index10 = index9 + 1;
                out[index9] = map[(in[end + 1] & 15) << 2];
                int i3 = index10 + 1;
                out[index10] = 61;
                break;
        }
        try {
            return new String(out, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
