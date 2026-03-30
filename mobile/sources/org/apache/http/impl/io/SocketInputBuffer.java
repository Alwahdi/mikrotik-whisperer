package org.apache.http.impl.io;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import org.apache.http.io.EofSensor;
import org.apache.http.params.HttpParams;

public class SocketInputBuffer extends AbstractSessionInputBuffer implements EofSensor {
    private static final Class SOCKET_TIMEOUT_CLASS = SocketTimeoutExceptionClass();
    private boolean eof;
    private final Socket socket;

    private static Class SocketTimeoutExceptionClass() {
        try {
            return Class.forName("java.net.SocketTimeoutException");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    private static boolean isSocketTimeoutException(InterruptedIOException e) {
        Class cls = SOCKET_TIMEOUT_CLASS;
        if (cls != null) {
            return cls.isInstance(e);
        }
        return true;
    }

    public SocketInputBuffer(Socket socket2, int buffersize, HttpParams params) throws IOException {
        if (socket2 != null) {
            this.socket = socket2;
            this.eof = false;
            buffersize = buffersize < 0 ? socket2.getReceiveBufferSize() : buffersize;
            init(socket2.getInputStream(), buffersize < 1024 ? 1024 : buffersize, params);
            return;
        }
        throw new IllegalArgumentException("Socket may not be null");
    }

    /* access modifiers changed from: protected */
    public int fillBuffer() throws IOException {
        int i = super.fillBuffer();
        this.eof = i == -1;
        return i;
    }

    public boolean isDataAvailable(int timeout) throws IOException {
        boolean result = hasBufferedData();
        if (!result) {
            int oldtimeout = this.socket.getSoTimeout();
            try {
                this.socket.setSoTimeout(timeout);
                fillBuffer();
                result = hasBufferedData();
            } catch (InterruptedIOException e) {
                if (!isSocketTimeoutException(e)) {
                    throw e;
                }
            } catch (Throwable th) {
                this.socket.setSoTimeout(oldtimeout);
                throw th;
            }
            this.socket.setSoTimeout(oldtimeout);
        }
        return result;
    }

    public boolean isEof() {
        return this.eof;
    }
}
