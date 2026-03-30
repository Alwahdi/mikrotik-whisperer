package io.grpc.okhttp.internal;

import java.io.IOException;

public enum d {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");
    
    private final String protocol;

    private d(String protocol2) {
        this.protocol = protocol2;
    }

    public static d get(String protocol2) throws IOException {
        d dVar = HTTP_1_0;
        if (protocol2.equals(dVar.protocol)) {
            return dVar;
        }
        d dVar2 = HTTP_1_1;
        if (protocol2.equals(dVar2.protocol)) {
            return dVar2;
        }
        d dVar3 = HTTP_2;
        if (protocol2.equals(dVar3.protocol)) {
            return dVar3;
        }
        d dVar4 = SPDY_3;
        if (protocol2.equals(dVar4.protocol)) {
            return dVar4;
        }
        throw new IOException("Unexpected protocol: " + protocol2);
    }

    public String toString() {
        return this.protocol;
    }
}
