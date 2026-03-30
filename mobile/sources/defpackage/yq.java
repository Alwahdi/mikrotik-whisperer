package defpackage;

import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpHost;

/* renamed from: yq  reason: default package */
public final class yq {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with other field name */
    private final int f5917a;

    /* renamed from: a  reason: collision with other field name */
    private final String f5918a;

    /* renamed from: a  reason: collision with other field name */
    private final List<String> f5919a;
    private final String b;

    /* renamed from: b  reason: collision with other field name */
    private final List<String> f5920b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;

    private yq(b builder) {
        this.f5918a = builder.f5921a;
        this.b = g(builder.b, false);
        this.c = g(builder.c, false);
        this.d = builder.d;
        this.f5917a = builder.g();
        this.f5919a = h(builder.f5922a, false);
        List<String> list = builder.f5923b;
        String str = null;
        this.f5920b = list != null ? h(list, true) : null;
        String str2 = builder.e;
        this.e = str2 != null ? g(str2, false) : str;
        this.f = builder.toString();
    }

    public String c() {
        return this.d;
    }

    public int j() {
        return this.f5917a;
    }

    public static int b(String scheme) {
        if (scheme.equals(HttpHost.DEFAULT_SCHEME_NAME)) {
            return 80;
        }
        if (scheme.equals("https")) {
            return 443;
        }
        return -1;
    }

    static void e(StringBuilder out, List<String> pathSegments) {
        int size = pathSegments.size();
        for (int i = 0; i < size; i++) {
            out.append('/');
            out.append(pathSegments.get(i));
        }
    }

    static void d(StringBuilder out, List<String> namesAndValues) {
        int size = namesAndValues.size();
        for (int i = 0; i < size; i += 2) {
            String name = namesAndValues.get(i);
            String value = namesAndValues.get(i + 1);
            if (i > 0) {
                out.append('&');
            }
            out.append(name);
            if (value != null) {
                out.append('=');
                out.append(value);
            }
        }
    }

    public boolean equals(Object o) {
        return (o instanceof yq) && ((yq) o).f.equals(this.f);
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    public String toString() {
        return this.f;
    }

    /* renamed from: yq$b */
    public static final class b {
        int a = -1;

        /* renamed from: a  reason: collision with other field name */
        String f5921a;

        /* renamed from: a  reason: collision with other field name */
        final List<String> f5922a;
        String b = "";

        /* renamed from: b  reason: collision with other field name */
        List<String> f5923b;
        String c = "";
        String d;
        String e;

        public b() {
            ArrayList arrayList = new ArrayList();
            this.f5922a = arrayList;
            arrayList.add("");
        }

        public b k(String scheme) {
            if (scheme != null) {
                if (scheme.equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.f5921a = HttpHost.DEFAULT_SCHEME_NAME;
                } else if (scheme.equalsIgnoreCase("https")) {
                    this.f5921a = "https";
                } else {
                    throw new IllegalArgumentException("unexpected scheme: " + scheme);
                }
                return this;
            }
            throw new IllegalArgumentException("scheme == null");
        }

        public b h(String host) {
            if (host != null) {
                String encoded = b(host, 0, host.length());
                if (encoded != null) {
                    this.d = encoded;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + host);
            }
            throw new IllegalArgumentException("host == null");
        }

        public b j(int port) {
            if (port <= 0 || port > 65535) {
                throw new IllegalArgumentException("unexpected port: " + port);
            }
            this.a = port;
            return this;
        }

        /* access modifiers changed from: package-private */
        public int g() {
            int i = this.a;
            return i != -1 ? i : yq.b(this.f5921a);
        }

        public yq a() {
            if (this.f5921a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.d != null) {
                return new yq(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public String toString() {
            StringBuilder result = new StringBuilder();
            result.append(this.f5921a);
            result.append("://");
            if (!this.b.isEmpty() || !this.c.isEmpty()) {
                result.append(this.b);
                if (!this.c.isEmpty()) {
                    result.append(':');
                    result.append(this.c);
                }
                result.append('@');
            }
            if (this.d.indexOf(58) != -1) {
                result.append('[');
                result.append(this.d);
                result.append(']');
            } else {
                result.append(this.d);
            }
            int effectivePort = g();
            if (effectivePort != yq.b(this.f5921a)) {
                result.append(':');
                result.append(effectivePort);
            }
            yq.e(result, this.f5922a);
            if (this.f5923b != null) {
                result.append('?');
                yq.d(result, this.f5923b);
            }
            if (this.e != null) {
                result.append('#');
                result.append(this.e);
            }
            return result.toString();
        }

        private static String b(String input, int pos, int limit) {
            String percentDecoded = yq.f(input, pos, limit, false);
            if (!percentDecoded.startsWith("[") || !percentDecoded.endsWith("]")) {
                return f(percentDecoded);
            }
            InetAddress inetAddress = e(percentDecoded, 1, percentDecoded.length() - 1);
            if (inetAddress == null) {
                return null;
            }
            byte[] address = inetAddress.getAddress();
            if (address.length == 16) {
                return i(address);
            }
            throw new AssertionError();
        }

        private static InetAddress e(String input, int pos, int limit) {
            byte[] address = new byte[16];
            int b2 = 0;
            int compress = -1;
            int groupOffset = -1;
            int i = pos;
            while (true) {
                if (i >= limit) {
                    break;
                } else if (b2 == address.length) {
                    return null;
                } else {
                    if (i + 2 <= limit && input.regionMatches(i, "::", 0, 2)) {
                        if (compress == -1) {
                            i += 2;
                            b2 += 2;
                            compress = b2;
                            if (i == limit) {
                                break;
                            }
                        } else {
                            return null;
                        }
                    } else if (b2 != 0) {
                        if (input.regionMatches(i, ":", 0, 1)) {
                            i++;
                        } else if (!input.regionMatches(i, ".", 0, 1) || !d(input, groupOffset, limit, address, b2 - 2)) {
                            return null;
                        } else {
                            b2 += 2;
                        }
                    }
                    int value = 0;
                    groupOffset = i;
                    while (i < limit) {
                        int hexDigit = yq.a(input.charAt(i));
                        if (hexDigit == -1) {
                            break;
                        }
                        value = (value << 4) + hexDigit;
                        i++;
                    }
                    int groupLength = i - groupOffset;
                    if (groupLength == 0 || groupLength > 4) {
                        return null;
                    }
                    int b3 = b2 + 1;
                    address[b2] = (byte) ((value >>> 8) & 255);
                    b2 = b3 + 1;
                    address[b3] = (byte) (value & 255);
                }
            }
            if (b2 != address.length) {
                if (compress == -1) {
                    return null;
                }
                System.arraycopy(address, compress, address, address.length - (b2 - compress), b2 - compress);
                Arrays.fill(address, compress, (address.length - b2) + compress, (byte) 0);
            }
            try {
                return InetAddress.getByAddress(address);
            } catch (UnknownHostException e2) {
                throw new AssertionError();
            }
        }

        private static boolean d(String input, int pos, int limit, byte[] address, int addressOffset) {
            int b2 = addressOffset;
            int i = pos;
            while (i < limit) {
                if (b2 == address.length) {
                    return false;
                }
                if (b2 != addressOffset) {
                    if (input.charAt(i) != '.') {
                        return false;
                    }
                    i++;
                }
                int value = 0;
                int groupOffset = i;
                while (i < limit) {
                    char c2 = input.charAt(i);
                    if (c2 < '0' || c2 > '9') {
                        break;
                    } else if ((value == 0 && groupOffset != i) || ((value * 10) + c2) - 48 > 255) {
                        return false;
                    } else {
                        i++;
                    }
                }
                if (i - groupOffset == 0) {
                    return false;
                }
                address[b2] = (byte) value;
                b2++;
            }
            if (b2 != addressOffset + 4) {
                return false;
            }
            return true;
        }

        private static String f(String input) {
            try {
                String result = IDN.toASCII(input).toLowerCase(Locale.US);
                if (!result.isEmpty() && !c(result)) {
                    return result;
                }
                return null;
            } catch (IllegalArgumentException e2) {
                return null;
            }
        }

        private static boolean c(String hostnameAscii) {
            for (int i = 0; i < hostnameAscii.length(); i++) {
                char c2 = hostnameAscii.charAt(i);
                if (c2 <= 31 || c2 >= 127 || " #%/:?@[\\]".indexOf(c2) != -1) {
                    return true;
                }
            }
            return false;
        }

        private static String i(byte[] address) {
            int longestRunOffset = -1;
            int longestRunLength = 0;
            int i = 0;
            while (i < address.length) {
                int currentRunOffset = i;
                while (i < 16 && address[i] == 0 && address[i + 1] == 0) {
                    i += 2;
                }
                int currentRunLength = i - currentRunOffset;
                if (currentRunLength > longestRunLength) {
                    longestRunOffset = currentRunOffset;
                    longestRunLength = currentRunLength;
                }
                i += 2;
            }
            r6 result = new r6();
            int i2 = 0;
            while (i2 < address.length) {
                if (i2 == longestRunOffset) {
                    result.I(58);
                    i2 += longestRunLength;
                    if (i2 == 16) {
                        result.I(58);
                    }
                } else {
                    if (i2 > 0) {
                        result.I(58);
                    }
                    result.o0((long) (((address[i2] & 255) << 8) | (address[i2 + 1] & 255)));
                    i2 += 2;
                }
            }
            return result.b0();
        }
    }

    static String g(String encoded, boolean plusIsSpace) {
        return f(encoded, 0, encoded.length(), plusIsSpace);
    }

    private List<String> h(List<String> list, boolean plusIsSpace) {
        List<String> result = new ArrayList<>(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            result.add(s != null ? g(s, plusIsSpace) : null);
        }
        return Collections.unmodifiableList(result);
    }

    static String f(String encoded, int pos, int limit, boolean plusIsSpace) {
        for (int i = pos; i < limit; i++) {
            char c2 = encoded.charAt(i);
            if (c2 == '%' || (c2 == '+' && plusIsSpace)) {
                r6 out = new r6();
                out.s0(encoded, pos, i);
                i(out, encoded, i, limit, plusIsSpace);
                return out.b0();
            }
        }
        return encoded.substring(pos, limit);
    }

    static void i(r6 out, String encoded, int pos, int limit, boolean plusIsSpace) {
        int i = pos;
        while (i < limit) {
            int codePoint = encoded.codePointAt(i);
            if (codePoint == 37 && i + 2 < limit) {
                int d1 = a(encoded.charAt(i + 1));
                int d2 = a(encoded.charAt(i + 2));
                if (!(d1 == -1 || d2 == -1)) {
                    out.I((d1 << 4) + d2);
                    i += 2;
                    i += Character.charCount(codePoint);
                }
            } else if (codePoint == 43 && plusIsSpace) {
                out.I(32);
                i += Character.charCount(codePoint);
            }
            out.t0(codePoint);
            i += Character.charCount(codePoint);
        }
    }

    static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        if (c2 >= 'a' && c2 <= 'f') {
            return (c2 - 'a') + 10;
        }
        if (c2 < 'A' || c2 > 'F') {
            return -1;
        }
        return (c2 - 'A') + 10;
    }
}
