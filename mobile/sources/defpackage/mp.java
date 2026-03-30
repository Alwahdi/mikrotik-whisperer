package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.StringTokenizer;

/* renamed from: mp  reason: default package */
public abstract class mp {
    private static HashMap<Integer, String> a = new HashMap<>();
    private static HashMap<String, int[]> b = new HashMap<>();

    static {
        InputStream is = null;
        try {
            new ln();
            is = nn0.b("com/itextpdf/text/pdf/fonts/glyphlist.txt", ln.class.getClassLoader());
            if (is != null) {
                byte[] buf = new byte[1024];
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                while (true) {
                    int size = is.read(buf);
                    if (size < 0) {
                        break;
                    }
                    out.write(buf, 0, size);
                }
                is.close();
                InputStream is2 = null;
                StringTokenizer tk = new StringTokenizer(n60.d(out.toByteArray(), (String) null), "\r\n");
                while (tk.hasMoreTokens()) {
                    String line = tk.nextToken();
                    if (!line.startsWith("#")) {
                        StringTokenizer t2 = new StringTokenizer(line, " ;\r\n\t\f");
                        if (t2.hasMoreTokens()) {
                            String name = t2.nextToken();
                            if (t2.hasMoreTokens()) {
                                Integer num = Integer.valueOf(t2.nextToken(), 16);
                                a.put(num, name);
                                b.put(name, new int[]{num.intValue()});
                            }
                        }
                    }
                }
                if (is2 != null) {
                    try {
                        is2.close();
                    } catch (Exception e) {
                    }
                }
            } else {
                throw new Exception("glyphlist.txt not found as resource. (It must exist as resource in the package com.itextpdf.text.pdf.fonts)");
            }
        } catch (Exception e2) {
            PrintStream printStream = System.err;
            printStream.println("glyphlist.txt loading error: " + e2.getMessage());
            if (is != null) {
                is.close();
            }
        } catch (Throwable th) {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e3) {
                }
            }
            throw th;
        }
    }

    public static int[] a(String name) {
        int[] v = b.get(name);
        if (v == null && name.length() == 7 && name.toLowerCase().startsWith("uni")) {
            try {
                return new int[]{Integer.parseInt(name.substring(3), 16)};
            } catch (Exception e) {
            }
        }
        return v;
    }

    public static String b(int num) {
        return a.get(Integer.valueOf(num));
    }
}
