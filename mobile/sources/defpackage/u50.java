package defpackage;

import java.io.OutputStream;
import java.net.URL;

/* renamed from: u50  reason: default package */
public class u50 extends j60 {
    public u50() {
    }

    public u50(URL url) {
        this(url.toExternalForm());
    }

    public u50(String url) {
        this(url, false);
    }

    public u50(String url, boolean isMap) {
        h70 h70 = h70.ta;
        h70 h702 = h70.Pc;
        Q(h70, h702);
        Q(h702, new n80(url));
        if (isMap) {
            Q(h70.M5, z50.a);
        }
    }

    u50(z60 destination) {
        Q(h70.ta, h70.E4);
        Q(h70.W1, destination);
    }

    public u50(String filename, String name) {
        Q(h70.ta, h70.H4);
        Q(h70.w3, new n80(filename));
        Q(h70.W1, new n80(name));
    }

    public u50(String filename, int page) {
        Q(h70.ta, h70.H4);
        Q(h70.w3, new n80(filename));
        h70 h70 = h70.W1;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(page - 1);
        sb.append(" /FitH 10000]");
        Q(h70, new f70(sb.toString()));
    }

    public u50(int named) {
        h70 h70 = h70.ta;
        Q(h70, h70.i7);
        switch (named) {
            case 1:
                Q(h70.b7, h70.N3);
                return;
            case 2:
                Q(h70.b7, h70.Y8);
                return;
            case 3:
                Q(h70.b7, h70.s7);
                return;
            case 4:
                Q(h70.b7, h70.h6);
                return;
            case 5:
                Q(h70, h70.R5);
                Q(h70.V5, new n80("this.print(true);\r"));
                return;
            default:
                throw new RuntimeException(i10.b("invalid.named.action", new Object[0]));
        }
    }

    public u50(String application, String parameters, String operation, String defaultDir) {
        Q(h70.ta, h70.i6);
        if (parameters == null && operation == null && defaultDir == null) {
            Q(h70.w3, new n80(application));
            return;
        }
        j60 dic = new j60();
        dic.Q(h70.w3, new n80(application));
        if (parameters != null) {
            dic.Q(h70.k8, new n80(parameters));
        }
        if (operation != null) {
            dic.Q(h70.C7, new n80(operation));
        }
        if (defaultDir != null) {
            dic.Q(h70.W1, new n80(defaultDir));
        }
        Q(h70.Cd, dic);
    }

    public static u50 V(String file, q60 fs, String mimeType, z60 ref) {
        u50 js = new u50();
        js.Q(h70.ta, h70.K9);
        js.Q(h70.u9, new g80(file, fs, mimeType));
        js.Q(new h70("OP"), new k70(0));
        js.Q(new h70("AN"), ref);
        return js;
    }

    public static u50 U(String code, v80 writer, boolean unicode) {
        u50 js = new u50();
        js.Q(h70.ta, h70.R5);
        String str = "UnicodeBig";
        if (unicode && code.length() < 50) {
            js.Q(h70.V5, new n80(code, str));
        } else if (unicode || code.length() >= 100) {
            if (!unicode) {
                str = "PDF";
            }
            try {
                m80 stream = new m80(n60.c(code, str));
                stream.T(writer.T());
                js.Q(h70.V5, writer.y(stream).a());
            } catch (Exception e) {
                js.Q(h70.V5, new n80(code));
            }
        } else {
            js.Q(h70.V5, new n80(code));
        }
        return js;
    }

    public static u50 T(String code, v80 writer) {
        return U(code, writer, false);
    }

    public void F(v80 writer, OutputStream os) {
        v80.H(writer, 14, this);
        super.F(writer, os);
    }
}
