package io.grpc.okhttp;

class n implements cw0 {
    n() {
    }

    public bw0 a(int capacityHint) {
        return new m(new r6(), Math.min(1048576, Math.max(4096, capacityHint)));
    }
}
