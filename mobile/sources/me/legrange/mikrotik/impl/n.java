package me.legrange.mikrotik.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import org.apache.http.protocol.HTTP;

abstract class n {
    static void g(d cmd, OutputStream out) {
        String str;
        c(cmd.e(), out);
        Iterator<g> it = cmd.f().iterator();
        while (true) {
            str = "";
            if (!it.hasNext()) {
                break;
            }
            g param = it.next();
            Object[] objArr = new Object[2];
            objArr[0] = param.a();
            if (param.c()) {
                str = param.b();
            }
            objArr[1] = str;
            c(String.format("=%s=%s", objArr), out);
        }
        String tag = cmd.i();
        if (tag != null && !tag.equals(str)) {
            c(String.format(".tag=%s", new Object[]{tag}), out);
        }
        List<String> props = cmd.g();
        if (!props.isEmpty()) {
            StringBuilder buf = new StringBuilder("=.proplist=");
            for (int i = 0; i < props.size(); i++) {
                if (i > 0) {
                    buf.append(",");
                }
                buf.append(props.get(i));
            }
            c(buf.toString(), out);
        }
        for (String query : cmd.h()) {
            c(query, out);
        }
        out.write(0);
    }

    static String a(InputStream in) {
        StringBuilder res = new StringBuilder();
        b(in, res);
        return res.toString();
    }

    private static void b(InputStream in, StringBuilder result) {
        try {
            int len = f(in);
            if (len > 0) {
                byte[] buf = new byte[len];
                int i = 0;
                while (i < len) {
                    int c = in.read();
                    if (c >= 0) {
                        buf[i] = (byte) (c & 255);
                        i++;
                    } else {
                        throw new c("Truncated data. Expected to read more bytes");
                    }
                }
                String res = new String(buf, Charset.forName(HTTP.UTF_8));
                if (result.length() > 0) {
                    result.append("\n");
                }
                result.append(res);
                b(in, result);
            }
        } catch (IOException ex) {
            throw new k3(ex.getMessage(), ex);
        }
    }

    static String d(String s) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            byte[] defaultBytes = new byte[s.length()];
            for (int i = 0; i < s.length(); i++) {
                defaultBytes[i] = (byte) (s.charAt(i) & 255);
            }
            algorithm.reset();
            algorithm.update(defaultBytes);
            byte[] messageDigest = algorithm.digest();
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(b & 255);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new c("Cannot find MD5 digest algorithm");
        }
    }

    static String e(String s) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2) {
            ret.append((char) Integer.parseInt(s.substring(i, i + 2), 16));
        }
        return ret.toString();
    }

    private static void c(String word, OutputStream out) {
        byte[] bytes = word.getBytes(HTTP.UTF_8);
        int len = bytes.length;
        if (len < 128) {
            out.write(len);
        } else if (len < 16384) {
            int len2 = len | 32768;
            out.write(len2 >> 8);
            out.write(len2);
        } else if (len < 131072) {
            int len3 = len | 12582912;
            out.write(len3 >> 16);
            out.write(len3 >> 8);
            out.write(len3);
        } else if (len < 268435456) {
            int len4 = len | -536870912;
            out.write(len4 >> 24);
            out.write(len4 >> 16);
            out.write(len4 >> 8);
            out.write(len4);
        } else {
            out.write(240);
            out.write(len >> 24);
            out.write(len >> 16);
            out.write(len >> 8);
            out.write(len);
        }
        out.write(bytes);
    }

    private static int f(InputStream in) {
        int c = in.read();
        if (c <= 0 || (c & 128) == 0) {
            return c;
        }
        if ((c & 192) == 128) {
            return ((c & -193) << 8) | in.read();
        }
        if ((c & 224) == 192) {
            return ((((c & -225) << 8) | in.read()) << 8) | in.read();
        }
        if ((c & 240) == 224) {
            return ((((((c & -241) << 8) | in.read()) << 8) | in.read()) << 8) | in.read();
        }
        if ((c & 248) == 240) {
            return (((((((in.read() << 8) | in.read()) << 8) | in.read()) << 8) | in.read()) << 8) | in.read();
        }
        return c;
    }
}
