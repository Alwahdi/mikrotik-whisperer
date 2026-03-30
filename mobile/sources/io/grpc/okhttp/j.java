package io.grpc.okhttp;

class j extends u {
    private final r6 a;

    j(r6 buffer) {
        this.a = buffer;
    }

    public int b() {
        return (int) this.a.g0();
    }

    public int readUnsignedByte() {
        return this.a.readByte() & 255;
    }

    public void m(byte[] dest, int destOffset, int length) {
        while (length > 0) {
            int bytesRead = this.a.read(dest, destOffset, length);
            if (bytesRead != -1) {
                length -= bytesRead;
                destOffset += bytesRead;
            } else {
                throw new IndexOutOfBoundsException("EOF trying to read " + length + " bytes");
            }
        }
    }

    public id0 v(int length) {
        r6 buf = new r6();
        buf.G(this.a, (long) length);
        return new j(buf);
    }

    public void close() {
        this.a.c();
    }
}
