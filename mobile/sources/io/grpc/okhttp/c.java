package io.grpc.okhttp;

import io.grpc.internal.h0;
import io.grpc.j;
import io.grpc.l;
import io.grpc.okhttp.internal.framed.Header;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

abstract class c {
    public static final pq a;
    public static final pq b;
    public static final pq c;
    public static final pq d;
    public static final pq e = new pq(h0.f.d(), "application/grpc");
    public static final pq f = new pq("te", "trailers");

    static {
        a7 a7Var = pq.f;
        a = new pq(a7Var, "https");
        b = new pq(a7Var, HttpHost.DEFAULT_SCHEME_NAME);
        a7 a7Var2 = pq.d;
        c = new pq(a7Var2, HttpPost.METHOD_NAME);
        d = new pq(a7Var2, HttpGet.METHOD_NAME);
    }

    public static List<pq> a(l headers, String defaultPath, String authority, String userAgent, boolean useGet, boolean usePlaintext) {
        v90.o(headers, "headers");
        v90.o(defaultPath, "defaultPath");
        v90.o(authority, "authority");
        headers.d(h0.f);
        headers.d(h0.g);
        l.g<String> gVar = h0.h;
        headers.d(gVar);
        List<Header> okhttpHeaders = new ArrayList<>(j.a(headers) + 7);
        if (usePlaintext) {
            okhttpHeaders.add(b);
        } else {
            okhttpHeaders.add(a);
        }
        if (useGet) {
            okhttpHeaders.add(d);
        } else {
            okhttpHeaders.add(c);
        }
        okhttpHeaders.add(new pq(pq.g, authority));
        okhttpHeaders.add(new pq(pq.e, defaultPath));
        okhttpHeaders.add(new pq(gVar.d(), userAgent));
        okhttpHeaders.add(e);
        okhttpHeaders.add(f);
        byte[][] serializedHeaders = hs0.d(headers);
        for (int i = 0; i < serializedHeaders.length; i += 2) {
            a7 key = a7.i(serializedHeaders[i]);
            if (b(key.s())) {
                okhttpHeaders.add(new pq(key, a7.i(serializedHeaders[i + 1])));
            }
        }
        return okhttpHeaders;
    }

    private static boolean b(String key) {
        return !key.startsWith(":") && !h0.f.d().equalsIgnoreCase(key) && !h0.h.d().equalsIgnoreCase(key);
    }
}
