package defpackage;

import com.squareup.okhttp.a;
import java.net.ProtocolException;

/* renamed from: gn0  reason: default package */
public final class gn0 {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final a f3114a;

    /* renamed from: a  reason: collision with other field name */
    public final String f3115a;

    public gn0(a protocol, int code, String message) {
        this.f3114a = protocol;
        this.a = code;
        this.f3115a = message;
    }

    public static gn0 a(String statusLine) {
        a protocol;
        int codeStart;
        if (statusLine.startsWith("HTTP/1.")) {
            if (statusLine.length() < 9 || statusLine.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + statusLine);
            }
            int httpMinorVersion = statusLine.charAt(7) - '0';
            codeStart = 9;
            if (httpMinorVersion == 0) {
                protocol = a.HTTP_1_0;
            } else if (httpMinorVersion == 1) {
                protocol = a.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: " + statusLine);
            }
        } else if (statusLine.startsWith("ICY ")) {
            protocol = a.HTTP_1_0;
            codeStart = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + statusLine);
        }
        if (statusLine.length() >= codeStart + 3) {
            try {
                int code = Integer.parseInt(statusLine.substring(codeStart, codeStart + 3));
                String message = "";
                if (statusLine.length() > codeStart + 3) {
                    if (statusLine.charAt(codeStart + 3) == ' ') {
                        message = statusLine.substring(codeStart + 4);
                    } else {
                        throw new ProtocolException("Unexpected status line: " + statusLine);
                    }
                }
                return new gn0(protocol, code, message);
            } catch (NumberFormatException e) {
                throw new ProtocolException("Unexpected status line: " + statusLine);
            }
        } else {
            throw new ProtocolException("Unexpected status line: " + statusLine);
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(this.f3114a == a.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        result.append(' ');
        result.append(this.a);
        if (this.f3115a != null) {
            result.append(' ');
            result.append(this.f3115a);
        }
        return result.toString();
    }
}
