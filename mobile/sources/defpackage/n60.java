package defpackage;

import com.itextpdf.text.pdf.ExtraEncoding;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.HashMap;

/* renamed from: n60  reason: default package */
public abstract class n60 {
    static HashMap<String, gk> a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    static final ys f4399a = new ys();

    /* renamed from: a  reason: collision with other field name */
    static final char[] f4400a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, ' ', '!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ':', ';', '<', '=', '>', '?', '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '[', '\\', ']', '^', '_', '`', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '{', '|', '}', '~', 127, 8364, 65533, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 65533, 381, 65533, 65533, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 65533, 382, 376, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255};
    static final ys b = new ys();

    /* renamed from: b  reason: collision with other field name */
    static final char[] f4401b = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, ' ', '!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ':', ';', '<', '=', '>', '?', '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '[', '\\', ']', '^', '_', '`', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '{', '|', '}', '~', 127, 8226, 8224, 8225, 8230, 8212, 8211, 402, 8260, 8249, 8250, 8722, 8240, 8222, 8220, 8221, 8216, 8217, 8218, 8482, 64257, 64258, 321, 338, 352, 376, 381, 305, 322, 339, 353, 382, 65533, 8364, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255};

    static {
        for (int k = 128; k < 161; k++) {
            char c2 = f4400a[k];
            if (c2 != 65533) {
                f4399a.d(c2, k);
            }
        }
        for (int k2 = 128; k2 < 161; k2++) {
            char c3 = f4401b[k2];
            if (c3 != 65533) {
                b.d(c3, k2);
            }
        }
        a("Wingdings", new e());
        a("Symbol", new c(true));
        a("ZapfDingbats", new c(false));
        a("SymbolTT", new d());
        a("Cp437", new b());
    }

    public static final byte[] c(String text, String encoding) {
        int c2;
        byte[] b2;
        if (text == null) {
            return new byte[0];
        }
        if (encoding == null || encoding.length() == 0) {
            int len = text.length();
            byte[] b3 = new byte[len];
            for (int k = 0; k < len; k++) {
                b3[k] = (byte) text.charAt(k);
            }
            return b3;
        }
        gk extra = a.get(encoding.toLowerCase());
        if (extra != null && (b2 = extra.b(text, encoding)) != null) {
            return b2;
        }
        ys hash = null;
        if (encoding.equals("Cp1252")) {
            hash = f4399a;
        } else if (encoding.equals("PDF")) {
            hash = b;
        }
        if (hash != null) {
            int ptr = 0;
            byte[] b4 = new byte[len];
            for (char char1 : text.toCharArray()) {
                if (char1 < 128 || (char1 > 160 && char1 <= 255)) {
                    c2 = char1;
                } else {
                    c2 = hash.b(char1);
                }
                if (c2 != 0) {
                    b4[ptr] = (byte) c2;
                    ptr++;
                }
            }
            if (ptr == len) {
                return b4;
            }
            byte[] b22 = new byte[ptr];
            System.arraycopy(b4, 0, b22, 0, ptr);
            return b22;
        } else if (encoding.equals("UnicodeBig")) {
            char[] cc = text.toCharArray();
            byte[] b5 = new byte[((cc.length * 2) + 2)];
            b5[0] = -2;
            b5[1] = -1;
            int bptr = 2;
            for (char c3 : cc) {
                int bptr2 = bptr + 1;
                b5[bptr] = (byte) (c3 >> 8);
                bptr = bptr2 + 1;
                b5[bptr2] = (byte) (c3 & 255);
            }
            return b5;
        } else {
            try {
                CharsetEncoder ce = Charset.forName(encoding).newEncoder();
                ce.onUnmappableCharacter(CodingErrorAction.IGNORE);
                ByteBuffer bb = ce.encode(CharBuffer.wrap(text.toCharArray()));
                bb.rewind();
                byte[] br = new byte[bb.limit()];
                bb.get(br);
                return br;
            } catch (IOException e2) {
                throw new mj(e2);
            }
        }
    }

    public static final byte[] b(char char1, String encoding) {
        int c2;
        byte[] b2;
        if (encoding == null || encoding.length() == 0) {
            return new byte[]{(byte) char1};
        }
        gk extra = a.get(encoding.toLowerCase());
        if (extra != null && (b2 = extra.a(char1, encoding)) != null) {
            return b2;
        }
        ys hash = null;
        if (encoding.equals("Cp1252")) {
            hash = f4399a;
        } else if (encoding.equals("PDF")) {
            hash = b;
        }
        if (hash != null) {
            if (char1 < 128 || (char1 > 160 && char1 <= 255)) {
                c2 = char1;
            } else {
                c2 = hash.b(char1);
            }
            if (c2 == 0) {
                return new byte[0];
            }
            return new byte[]{(byte) c2};
        } else if (encoding.equals("UnicodeBig")) {
            return new byte[]{-2, -1, (byte) (char1 >> 8), (byte) (char1 & 255)};
        } else {
            try {
                CharsetEncoder ce = Charset.forName(encoding).newEncoder();
                ce.onUnmappableCharacter(CodingErrorAction.IGNORE);
                ByteBuffer bb = ce.encode(CharBuffer.wrap(new char[]{char1}));
                bb.rewind();
                byte[] br = new byte[bb.limit()];
                bb.get(br);
                return br;
            } catch (IOException e2) {
                throw new mj(e2);
            }
        }
    }

    public static final String d(byte[] bytes, String encoding) {
        String text;
        if (bytes == null) {
            return "";
        }
        if (encoding == null || encoding.length() == 0) {
            char[] c2 = new char[bytes.length];
            for (int k = 0; k < bytes.length; k++) {
                c2[k] = (char) (bytes[k] & 255);
            }
            return new String(c2);
        }
        gk extra = a.get(encoding.toLowerCase());
        if (extra != null && (text = extra.c(bytes, encoding)) != null) {
            return text;
        }
        char[] ch = null;
        if (encoding.equals("Cp1252")) {
            ch = f4400a;
        } else if (encoding.equals("PDF")) {
            ch = f4401b;
        }
        if (ch != null) {
            int len = bytes.length;
            char[] c3 = new char[len];
            for (int k2 = 0; k2 < len; k2++) {
                c3[k2] = ch[bytes[k2] & 255];
            }
            return new String(c3);
        }
        try {
            return new String(bytes, encoding);
        } catch (UnsupportedEncodingException e2) {
            throw new mj(e2);
        }
    }

    public static boolean e(String text) {
        if (text == null) {
            return true;
        }
        int len = text.length();
        for (int k = 0; k < len; k++) {
            char char1 = text.charAt(k);
            if (char1 >= 128 && ((char1 <= 160 || char1 > 255) && !b.a(char1))) {
                return false;
            }
        }
        return true;
    }

    public static void a(String name, gk enc) {
        synchronized (a) {
            HashMap<String, ExtraEncoding> newEncodings = (HashMap) a.clone();
            newEncodings.put(name.toLowerCase(), enc);
            a = newEncodings;
        }
    }

    /* renamed from: n60$e */
    private static class e implements gk {
        private static final byte[] a = {0, 35, 34, 0, 0, 0, 41, 62, 81, 42, 0, 0, 65, 63, 0, 0, 0, 0, 0, -4, 0, 0, 0, -5, 0, 0, 0, 0, 0, 0, 86, 0, 88, 89, 0, 0, 0, 0, 0, 0, 0, 0, -75, 0, 0, 0, 0, 0, -74, 0, 0, 0, -83, -81, -84, 0, 0, 0, 0, 0, 0, 0, 0, 124, 123, 0, 0, 0, 84, 0, 0, 0, 0, 0, 0, 0, 0, -90, 0, 0, 0, 113, 114, 0, 0, 0, 117, 0, 0, 0, 0, 0, 0, 125, 126, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -116, -115, -114, -113, -112, -111, -110, -109, -108, -107, -127, -126, -125, -124, -123, -122, -121, -120, -119, -118, -116, -115, -114, -113, -112, -111, -110, -109, -108, -107, -24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -24, -40, 0, 0, -60, -58, 0, 0, -16, 0, 0, 0, 0, 0, 0, 0, 0, 0, -36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        private e() {
        }

        public byte[] a(char char1, String encoding) {
            byte v;
            if (char1 == ' ') {
                return new byte[]{(byte) char1};
            } else if (char1 < 9985 || char1 > 10174 || (v = a[char1 - 9984]) == 0) {
                return new byte[0];
            } else {
                return new byte[]{v};
            }
        }

        public byte[] b(String text, String encoding) {
            byte v;
            char[] cc = text.toCharArray();
            byte[] b = new byte[cc.length];
            int ptr = 0;
            for (char c : cc) {
                if (c == ' ') {
                    b[ptr] = (byte) c;
                    ptr++;
                } else if (c >= 9985 && c <= 10174 && (v = a[c - 9984]) != 0) {
                    b[ptr] = v;
                    ptr++;
                }
            }
            if (ptr == len) {
                return b;
            }
            byte[] b2 = new byte[ptr];
            System.arraycopy(b, 0, b2, 0, ptr);
            return b2;
        }

        public String c(byte[] b, String encoding) {
            return null;
        }
    }

    /* renamed from: n60$b */
    private static class b implements gk {
        private static ys a = new ys();

        /* renamed from: a  reason: collision with other field name */
        private static final char[] f4402a = {199, 252, 233, 226, 228, 224, 229, 231, 234, 235, 232, 239, 238, 236, 196, 197, 201, 230, 198, 244, 246, 242, 251, 249, 255, 214, 220, 162, 163, 165, 8359, 402, 225, 237, 243, 250, 241, 209, 170, 186, 191, 8976, 172, 189, 188, 161, 171, 187, 9617, 9618, 9619, 9474, 9508, 9569, 9570, 9558, 9557, 9571, 9553, 9559, 9565, 9564, 9563, 9488, 9492, 9524, 9516, 9500, 9472, 9532, 9566, 9567, 9562, 9556, 9577, 9574, 9568, 9552, 9580, 9575, 9576, 9572, 9573, 9561, 9560, 9554, 9555, 9579, 9578, 9496, 9484, 9608, 9604, 9612, 9616, 9600, 945, 223, 915, 960, 931, 963, 181, 964, 934, 920, 937, 948, 8734, 966, 949, 8745, 8801, 177, 8805, 8804, 8992, 8993, 247, 8776, 176, 8729, 183, 8730, 8319, 178, 9632, 160};

        private b() {
        }

        static {
            int k = 0;
            while (true) {
                char[] cArr = f4402a;
                if (k < cArr.length) {
                    a.d(cArr[k], k + 128);
                    k++;
                } else {
                    return;
                }
            }
        }

        public byte[] b(String text, String encoding) {
            char[] cc = text.toCharArray();
            byte[] b = new byte[cc.length];
            int ptr = 0;
            for (char c : cc) {
                if (c < 128) {
                    b[ptr] = (byte) c;
                    ptr++;
                } else {
                    byte v = (byte) a.b(c);
                    if (v != 0) {
                        b[ptr] = v;
                        ptr++;
                    }
                }
            }
            if (ptr == len) {
                return b;
            }
            byte[] b2 = new byte[ptr];
            System.arraycopy(b, 0, b2, 0, ptr);
            return b2;
        }

        public byte[] a(char char1, String encoding) {
            if (char1 < 128) {
                return new byte[]{(byte) char1};
            }
            byte v = (byte) a.b(char1);
            if (v == 0) {
                return new byte[0];
            }
            return new byte[]{v};
        }

        public String c(byte[] b, String encoding) {
            char[] cc = new char[len];
            int ptr = 0;
            for (byte b2 : b) {
                int c = b2 & 255;
                if (c >= 32) {
                    if (c < 128) {
                        cc[ptr] = (char) c;
                        ptr++;
                    } else {
                        cc[ptr] = f4402a[c - 128];
                        ptr++;
                    }
                }
            }
            return new String(cc, 0, ptr);
        }
    }

    /* renamed from: n60$c */
    private static class c implements gk {
        private static final ys b = new ys();

        /* renamed from: b  reason: collision with other field name */
        private static final char[] f4403b = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ' ', '!', 8704, '#', 8707, '%', '&', 8715, '(', ')', '*', '+', ',', '-', '.', '/', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ':', ';', '<', '=', '>', '?', 8773, 913, 914, 935, 916, 917, 934, 915, 919, 921, 977, 922, 923, 924, 925, 927, 928, 920, 929, 931, 932, 933, 962, 937, 926, 936, 918, '[', 8756, ']', 8869, '_', 773, 945, 946, 967, 948, 949, 981, 947, 951, 953, 966, 954, 955, 956, 957, 959, 960, 952, 961, 963, 964, 965, 982, 969, 958, 968, 950, '{', '|', '}', '~', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8364, 978, 8242, 8804, 8260, 8734, 402, 9827, 9830, 9829, 9824, 8596, 8592, 8593, 8594, 8595, 176, 177, 8243, 8805, 215, 8733, 8706, 8226, 247, 8800, 8801, 8776, 8230, 9474, 9472, 8629, 8501, 8465, 8476, 8472, 8855, 8853, 8709, 8745, 8746, 8835, 8839, 8836, 8834, 8838, 8712, 8713, 8736, 8711, 174, 169, 8482, 8719, 8730, 8901, 172, 8743, 8744, 8660, 8656, 8657, 8658, 8659, 9674, 9001, 0, 0, 0, 8721, 9115, 9116, 9117, 9121, 9122, 9123, 9127, 9128, 9129, 9130, 0, 9002, 8747, 8992, 9134, 8993, 9118, 9119, 9120, 9124, 9125, 9126, 9131, 9132, 9133, 0};
        private static final ys c = new ys();

        /* renamed from: c  reason: collision with other field name */
        private static final char[] f4404c = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ' ', 9985, 9986, 9987, 9988, 9742, 9990, 9991, 9992, 9993, 9755, 9758, 9996, 9997, 9998, 9999, 10000, 10001, 10002, 10003, 10004, 10005, 10006, 10007, 10008, 10009, 10010, 10011, 10012, 10013, 10014, 10015, 10016, 10017, 10018, 10019, 10020, 10021, 10022, 10023, 9733, 10025, 10026, 10027, 10028, 10029, 10030, 10031, 10032, 10033, 10034, 10035, 10036, 10037, 10038, 10039, 10040, 10041, 10042, 10043, 10044, 10045, 10046, 10047, 10048, 10049, 10050, 10051, 10052, 10053, 10054, 10055, 10056, 10057, 10058, 10059, 9679, 10061, 9632, 10063, 10064, 10065, 10066, 9650, 9660, 9670, 10070, 9687, 10072, 10073, 10074, 10075, 10076, 10077, 10078, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10081, 10082, 10083, 10084, 10085, 10086, 10087, 9827, 9830, 9829, 9824, 9312, 9313, 9314, 9315, 9316, 9317, 9318, 9319, 9320, 9321, 10102, 10103, 10104, 10105, 10106, 10107, 10108, 10109, 10110, 10111, 10112, 10113, 10114, 10115, 10116, 10117, 10118, 10119, 10120, 10121, 10122, 10123, 10124, 10125, 10126, 10127, 10128, 10129, 10130, 10131, 10132, 8594, 8596, 8597, 10136, 10137, 10138, 10139, 10140, 10141, 10142, 10143, 10144, 10145, 10146, 10147, 10148, 10149, 10150, 10151, 10152, 10153, 10154, 10155, 10156, 10157, 10158, 10159, 0, 10161, 10162, 10163, 10164, 10165, 10166, 10167, 10168, 10169, 10170, 10171, 10172, 10173, 10174, 0};
        private ys a;

        /* renamed from: a  reason: collision with other field name */
        private final char[] f4405a;

        static {
            for (int k = 0; k < 256; k++) {
                char v = f4403b[k];
                if (v != 0) {
                    b.d(v, k);
                }
            }
            for (int k2 = 0; k2 < 256; k2++) {
                char v2 = f4404c[k2];
                if (v2 != 0) {
                    c.d(v2, k2);
                }
            }
        }

        c(boolean symbol) {
            if (symbol) {
                this.a = b;
                this.f4405a = f4403b;
                return;
            }
            this.a = c;
            this.f4405a = f4404c;
        }

        public byte[] b(String text, String encoding) {
            char[] cc = text.toCharArray();
            byte[] b2 = new byte[cc.length];
            int ptr = 0;
            for (char c2 : cc) {
                byte v = (byte) this.a.b(c2);
                if (v != 0) {
                    b2[ptr] = v;
                    ptr++;
                }
            }
            if (ptr == len) {
                return b2;
            }
            byte[] b22 = new byte[ptr];
            System.arraycopy(b2, 0, b22, 0, ptr);
            return b22;
        }

        public byte[] a(char char1, String encoding) {
            byte v = (byte) this.a.b(char1);
            if (v == 0) {
                return new byte[0];
            }
            return new byte[]{v};
        }

        public String c(byte[] b2, String encoding) {
            int len = b2.length;
            char[] cc = new char[len];
            int ptr = 0;
            int k = 0;
            while (k < len) {
                cc[ptr] = this.f4405a[b2[k] & 255];
                k++;
                ptr++;
            }
            return new String(cc, 0, ptr);
        }
    }

    /* renamed from: n60$d */
    private static class d implements gk {
        private d() {
        }

        public byte[] a(char char1, String encoding) {
            if ((char1 & 65280) != 0 && (65280 & char1) != 61440) {
                return new byte[0];
            }
            return new byte[]{(byte) char1};
        }

        public byte[] b(String text, String encoding) {
            char[] ch = text.toCharArray();
            byte[] b = new byte[ch.length];
            int ptr = 0;
            for (char c : ch) {
                if ((c & 65280) == 0 || (65280 & c) == 61440) {
                    b[ptr] = (byte) c;
                    ptr++;
                }
            }
            if (ptr == len) {
                return b;
            }
            byte[] b2 = new byte[ptr];
            System.arraycopy(b, 0, b2, 0, ptr);
            return b2;
        }

        public String c(byte[] b, String encoding) {
            return null;
        }
    }
}
