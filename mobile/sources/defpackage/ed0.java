package defpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.channels.FileChannel;

/* renamed from: ed0  reason: default package */
public final class ed0 {
    private boolean a = false;
    private boolean b = false;
    private boolean c = false;

    public ed0 i(boolean forceRead) {
        this.a = forceRead;
        return this;
    }

    public ed0 j(boolean usePlainRandomAccess) {
        this.b = usePlainRandomAccess;
        return this;
    }

    public dd0 h(byte[] data) {
        return new d4(data);
    }

    public dd0 g(URL url) {
        InputStream is = url.openStream();
        try {
            return f(is);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
            }
        }
    }

    public dd0 f(InputStream is) {
        try {
            return h(nn0.c(is));
        } finally {
            try {
                is.close();
            } catch (IOException e) {
            }
        }
    }

    public dd0 b(String filename) {
        File file = new File(filename);
        if (!file.canRead()) {
            if (filename.startsWith("file:/") || filename.startsWith("http://") || filename.startsWith("https://") || filename.startsWith("jar:") || filename.startsWith("wsjar:") || filename.startsWith("wsjar:") || filename.startsWith("vfszip:")) {
                return g(new URL(filename));
            }
            return e(filename);
        } else if (this.a) {
            return d(new FileInputStream(filename));
        } else {
            RandomAccessFile raf = new RandomAccessFile(file, this.c ? "rw" : "r");
            if (this.c) {
                raf.getChannel().lock();
            }
            try {
                return a(raf);
            } catch (IOException e) {
                try {
                    raf.close();
                } catch (IOException e2) {
                }
                throw e;
            } catch (RuntimeException e3) {
                try {
                    raf.close();
                } catch (IOException e4) {
                }
                throw e3;
            }
        }
    }

    public dd0 a(RandomAccessFile raf) {
        if (this.b) {
            return new ad0(raf);
        }
        if (raf.length() <= 0) {
            return new ad0(raf);
        }
        try {
            return c(raf.getChannel());
        } catch (vz e) {
            return new ad0(raf);
        }
    }

    public dd0 c(FileChannel channel) {
        if (channel.size() <= 67108864) {
            return new ep(new sk(channel));
        }
        return new ep(new g50(channel));
    }

    private dd0 e(String filename) {
        InputStream is = nn0.a(filename);
        if (is != null) {
            return d(is);
        }
        throw new IOException(i10.b("1.not.found.as.file.or.resource", filename));
    }

    private dd0 d(InputStream is) {
        try {
            return new d4(nn0.c(is));
        } finally {
            try {
                is.close();
            } catch (IOException e) {
            }
        }
    }
}
