package io.grpc.internal;

import defpackage.b30;
import java.net.URI;

public final class x extends c30 {
    public static final /* synthetic */ int a = 0;

    /* renamed from: e */
    public w b(URI targetUri, b30.a args) {
        if (!"dns".equals(targetUri.getScheme())) {
            return null;
        }
        String targetPath = (String) v90.o(targetUri.getPath(), "targetPath");
        v90.k(targetPath.startsWith("/"), "the path component (%s) of the target (%s) must start with '/'", targetPath, targetUri);
        return new w(targetUri.getAuthority(), targetPath.substring(1), args, h0.f3423a, hn0.c(), iu.a(getClass().getClassLoader()));
    }

    public String a() {
        return "dns";
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        return true;
    }

    public int d() {
        return 5;
    }
}
