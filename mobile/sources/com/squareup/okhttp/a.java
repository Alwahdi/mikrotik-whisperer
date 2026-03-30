package com.squareup.okhttp;

import java.io.IOException;

public enum a {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");
    
    private final String protocol;

    private a(String protocol2) {
        this.protocol = protocol2;
    }

    public static a get(String protocol2) throws IOException {
        a aVar = HTTP_1_0;
        if (protocol2.equals(aVar.protocol)) {
            return aVar;
        }
        a aVar2 = HTTP_1_1;
        if (protocol2.equals(aVar2.protocol)) {
            return aVar2;
        }
        a aVar3 = HTTP_2;
        if (protocol2.equals(aVar3.protocol)) {
            return aVar3;
        }
        a aVar4 = SPDY_3;
        if (protocol2.equals(aVar4.protocol)) {
            return aVar4;
        }
        throw new IOException("Unexpected protocol: " + protocol2);
    }

    public String toString() {
        return this.protocol;
    }
}
