package io.grpc.internal;

import io.grpc.internal.w;

abstract class n0 implements w.g {
    private static final Throwable a = c();

    private static Throwable c() {
        try {
            Class.forName("javax.naming.directory.InitialDirContext");
            Class.forName("com.sun.jndi.dns.DnsContextFactory");
            return null;
        } catch (ClassNotFoundException e) {
            return e;
        } catch (RuntimeException e2) {
            return e2;
        } catch (Error e3) {
            return e3;
        }
    }
}
