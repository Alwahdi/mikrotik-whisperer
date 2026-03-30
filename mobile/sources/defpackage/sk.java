package defpackage;

import java.io.IOException;
import java.nio.channels.FileChannel;

/* renamed from: sk  reason: default package */
public class sk implements dd0 {
    private final FileChannel a;

    /* renamed from: a  reason: collision with other field name */
    private final wz f4998a;

    public sk(FileChannel channel) {
        this.a = channel;
        if (channel.size() != 0) {
            wz wzVar = new wz(channel, 0, channel.size());
            this.f4998a = wzVar;
            wzVar.e();
            return;
        }
        throw new IOException("File size is 0 bytes");
    }

    public void close() {
        this.f4998a.close();
        this.a.close();
    }

    public int a(long position) {
        return this.f4998a.a(position);
    }

    public int c(long position, byte[] bytes, int off, int len) {
        return this.f4998a.c(position, bytes, off, len);
    }

    public long b() {
        return this.f4998a.b();
    }
}
