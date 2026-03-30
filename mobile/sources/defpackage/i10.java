package defpackage;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import org.apache.http.protocol.HTTP;

/* renamed from: i10  reason: default package */
public final class i10 {
    private static HashMap<String, String> a;
    private static HashMap<String, String> b;

    static {
        a = new HashMap<>();
        try {
            a = c("en", (String) null);
        } catch (Exception e) {
        }
        if (a == null) {
            a = new HashMap<>();
        }
    }

    private i10() {
    }

    public static String d(String key) {
        return e(key, true);
    }

    public static String e(String key, boolean useDefaultLanguageIfMessageNotFound) {
        String val;
        String val2;
        HashMap<String, String> cl = b;
        if (cl != null && (val2 = cl.get(key)) != null) {
            return val2;
        }
        if (useDefaultLanguageIfMessageNotFound && (val = a.get(key)) != null) {
            return val;
        }
        return "No message found for " + key;
    }

    public static String a(String key, int p1) {
        return b(key, String.valueOf(p1), null, null, null);
    }

    public static String b(String key, Object... param) {
        String msg = d(key);
        if (param != null) {
            int i = 1;
            for (Object o : param) {
                if (o != null) {
                    msg = msg.replace("{" + i + "}", o.toString());
                }
                i++;
            }
        }
        return msg;
    }

    private static HashMap<String, String> c(String language, String country) {
        String file;
        Class<i10> cls = i10.class;
        if (language != null) {
            InputStream is = null;
            if (country != null) {
                try {
                    file = language + "_" + country + ".lng";
                } catch (Throwable th) {
                    if (is != null) {
                        try {
                            is.close();
                        } catch (Exception e) {
                        }
                    }
                    throw th;
                }
            } else {
                file = language + ".lng";
            }
            new i10();
            is = nn0.b("com/itextpdf/text/l10n/error/" + file, cls.getClassLoader());
            if (is != null) {
                HashMap<String, String> f = f(is);
                try {
                    is.close();
                } catch (Exception e2) {
                }
                return f;
            } else if (country == null) {
                if (is != null) {
                    try {
                        is.close();
                    } catch (Exception e3) {
                    }
                }
                return null;
            } else {
                new i10();
                InputStream is2 = nn0.b("com/itextpdf/text/l10n/error/" + (language + ".lng"), cls.getClassLoader());
                if (is2 != null) {
                    HashMap<String, String> f2 = f(is2);
                    try {
                        is2.close();
                    } catch (Exception e4) {
                    }
                    return f2;
                }
                if (is2 != null) {
                    try {
                        is2.close();
                    } catch (Exception e5) {
                    }
                }
                return null;
            }
        } else {
            throw new IllegalArgumentException("The language cannot be null.");
        }
    }

    private static HashMap<String, String> f(InputStream is) {
        return g(new InputStreamReader(is, HTTP.UTF_8));
    }

    private static HashMap<String, String> g(Reader r) {
        HashMap<String, String> lang = new HashMap<>();
        BufferedReader br = new BufferedReader(r);
        while (true) {
            String readLine = br.readLine();
            String line = readLine;
            if (readLine == null) {
                return lang;
            }
            int idxeq = line.indexOf(61);
            if (idxeq >= 0) {
                String key = line.substring(0, idxeq).trim();
                if (!key.startsWith("#")) {
                    lang.put(key, line.substring(idxeq + 1));
                }
            }
        }
    }
}
