package com.google.protobuf;

import com.google.protobuf.p;

public abstract class b<MessageType extends p> implements n50<MessageType> {
    private static final fk a = fk.a();

    private ht0 d(MessageType message) {
        if (message instanceof a) {
            return ((a) message).k();
        }
        return new ht0(message);
    }

    private MessageType c(MessageType message) {
        if (message == null || message.c()) {
            return message;
        }
        throw d(message).a().i(message);
    }

    /* renamed from: e */
    public MessageType b(f input, fk extensionRegistry) {
        return c((p) a(input, extensionRegistry));
    }
}
