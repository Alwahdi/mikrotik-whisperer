package com.google.protobuf;

import java.io.IOException;

public class m extends IOException {
    private p a = null;

    public m(String description) {
        super(description);
    }

    public m i(p unfinishedMessage) {
        this.a = unfinishedMessage;
        return this;
    }

    static m k() {
        return new m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static m f() {
        return new m("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static m e() {
        return new m("CodedInputStream encountered a malformed varint.");
    }

    static m b() {
        return new m("Protocol message contained an invalid tag (zero).");
    }

    static m a() {
        return new m("Protocol message end-group tag did not match expected tag.");
    }

    static m d() {
        return new m("Protocol message tag had invalid wire type.");
    }

    static m h() {
        return new m("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    static m j() {
        return new m("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static m c() {
        return new m("Protocol message had invalid UTF-8.");
    }
}
