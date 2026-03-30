package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.cookie.ClientCookie;

/* renamed from: zw  reason: default package */
public class zw {
    private static final qp a = new qp("LibraryVersion", "");

    /* renamed from: a  reason: collision with other field name */
    private static zw f6052a = new zw();

    /* renamed from: a  reason: collision with other field name */
    private ConcurrentHashMap<String, String> f6053a = new ConcurrentHashMap<>();

    public static zw a() {
        return f6052a;
    }

    protected zw() {
    }

    public String b(String str) {
        y90.g(str, "Please provide a valid libraryName");
        if (this.f6053a.containsKey(str)) {
            return this.f6053a.get(str);
        }
        Properties properties = new Properties();
        String str2 = null;
        try {
            InputStream resourceAsStream = zw.class.getResourceAsStream(String.format("/%s.properties", new Object[]{str}));
            if (resourceAsStream != null) {
                properties.load(resourceAsStream);
                str2 = properties.getProperty(ClientCookie.VERSION_ATTR, (String) null);
                qp qpVar = a;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12 + String.valueOf(str2).length());
                sb.append(str);
                sb.append(" version is ");
                sb.append(str2);
                qpVar.e("LibraryVersion", sb.toString());
            } else {
                qp qpVar2 = a;
                String valueOf = String.valueOf(str);
                qpVar2.c("LibraryVersion", valueOf.length() != 0 ? "Failed to get app version for libraryName: ".concat(valueOf) : new String("Failed to get app version for libraryName: "));
            }
        } catch (IOException e) {
            qp qpVar3 = a;
            String valueOf2 = String.valueOf(str);
            qpVar3.d("LibraryVersion", valueOf2.length() != 0 ? "Failed to get app version for libraryName: ".concat(valueOf2) : new String("Failed to get app version for libraryName: "), e);
        }
        if (str2 == null) {
            a.b("LibraryVersion", ".properties file is dropped during release process. Failure to read app version isexpected druing Google internal testing where locally-built libraries are used");
            str2 = "UNKNOWN";
        }
        this.f6053a.put(str, str2);
        return str2;
    }
}
