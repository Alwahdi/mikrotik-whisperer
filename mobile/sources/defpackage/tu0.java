package defpackage;

import com.itextpdf.text.pdf.a;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

/* renamed from: tu0  reason: default package */
public abstract class tu0 {
    public static Object[][] a(Object[][] original, Object[] item) {
        if (original == null) {
            return new Object[][]{item};
        }
        Object[][] original2 = new Object[(original.length + 1)][];
        System.arraycopy(original, 0, original2, 0, original.length);
        original2[original.length] = item;
        return original2;
    }

    public static String l(String src) {
        StringBuffer bf = new StringBuffer();
        char[] s = src.toCharArray();
        int k = 0;
        while (k < s.length) {
            char c = s[k];
            if (c != '%') {
                bf.append(c);
            } else if (k + 2 >= s.length) {
                bf.append(c);
            } else {
                int a0 = a.c(s[k + 1]);
                int a1 = a.c(s[k + 2]);
                if (a0 < 0 || a1 < 0) {
                    bf.append(c);
                } else {
                    bf.append((char) ((a0 * 16) + a1));
                    k += 2;
                }
            }
            k++;
        }
        return bf.toString();
    }

    public static URL k(String filename) {
        try {
            return new URL(filename);
        } catch (Exception e) {
            return new File(filename).toURI().toURL();
        }
    }

    public static void j(InputStream is, int size) {
        while (size > 0) {
            long n = is.skip((long) size);
            if (n > 0) {
                size = (int) (((long) size) - n);
            } else {
                return;
            }
        }
    }

    public static boolean f(char c) {
        return c >= 55296 && c <= 56319;
    }

    public static boolean g(char c) {
        return c >= 56320 && c <= 57343;
    }

    public static boolean h(String text, int idx) {
        if (idx < 0 || idx > text.length() - 2 || !f(text.charAt(idx)) || !g(text.charAt(idx + 1))) {
            return false;
        }
        return true;
    }

    public static boolean i(char[] text, int idx) {
        if (idx < 0 || idx > text.length - 2 || !f(text[idx]) || !g(text[idx + 1])) {
            return false;
        }
        return true;
    }

    public static int b(char highSurrogate, char lowSurrogate) {
        return ((((highSurrogate - 55296) * 1024) + lowSurrogate) - 56320) + 65536;
    }

    public static int d(char[] text, int idx) {
        return ((((text[idx] - 55296) * 1024) + text[idx + 1]) - 56320) + 65536;
    }

    public static int c(String text, int idx) {
        return ((((text.charAt(idx) - 55296) * 1024) + text.charAt(idx + 1)) - 56320) + 65536;
    }

    public static char[] e(char[] original, int from, int to) {
        int newLength = to - from;
        if (newLength >= 0) {
            char[] copy = new char[newLength];
            System.arraycopy(original, from, copy, 0, Math.min(original.length - from, newLength));
            return copy;
        }
        throw new IllegalArgumentException(from + " > " + to);
    }
}
