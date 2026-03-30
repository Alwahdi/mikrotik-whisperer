package org.apache.http.util;

import java.io.Serializable;

public final class ByteArrayBuffer implements Serializable {
    private static final long serialVersionUID = 4359112959524048036L;
    private byte[] buffer;
    private int len;

    public ByteArrayBuffer(int capacity) {
        if (capacity >= 0) {
            this.buffer = new byte[capacity];
            return;
        }
        throw new IllegalArgumentException("Buffer capacity may not be negative");
    }

    private void expand(int newlen) {
        byte[] newbuffer = new byte[Math.max(this.buffer.length << 1, newlen)];
        System.arraycopy(this.buffer, 0, newbuffer, 0, this.len);
        this.buffer = newbuffer;
    }

    public void append(byte[] b, int off, int len2) {
        if (b != null) {
            if (off < 0 || off > b.length || len2 < 0 || off + len2 < 0 || off + len2 > b.length) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("off: ");
                stringBuffer.append(off);
                stringBuffer.append(" len: ");
                stringBuffer.append(len2);
                stringBuffer.append(" b.length: ");
                stringBuffer.append(b.length);
                throw new IndexOutOfBoundsException(stringBuffer.toString());
            } else if (len2 != 0) {
                int newlen = this.len + len2;
                if (newlen > this.buffer.length) {
                    expand(newlen);
                }
                System.arraycopy(b, off, this.buffer, this.len, len2);
                this.len = newlen;
            }
        }
    }

    public void append(int b) {
        int newlen = this.len + 1;
        if (newlen > this.buffer.length) {
            expand(newlen);
        }
        this.buffer[this.len] = (byte) b;
        this.len = newlen;
    }

    public void append(char[] b, int off, int len2) {
        if (b != null) {
            if (off < 0 || off > b.length || len2 < 0 || off + len2 < 0 || off + len2 > b.length) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("off: ");
                stringBuffer.append(off);
                stringBuffer.append(" len: ");
                stringBuffer.append(len2);
                stringBuffer.append(" b.length: ");
                stringBuffer.append(b.length);
                throw new IndexOutOfBoundsException(stringBuffer.toString());
            } else if (len2 != 0) {
                int oldlen = this.len;
                int newlen = oldlen + len2;
                if (newlen > this.buffer.length) {
                    expand(newlen);
                }
                int i1 = off;
                for (int i2 = oldlen; i2 < newlen; i2++) {
                    this.buffer[i2] = (byte) b[i1];
                    i1++;
                }
                this.len = newlen;
            }
        }
    }

    public void append(CharArrayBuffer b, int off, int len2) {
        if (b != null) {
            append(b.buffer(), off, len2);
        }
    }

    public void clear() {
        this.len = 0;
    }

    public byte[] toByteArray() {
        int i = this.len;
        byte[] b = new byte[i];
        if (i > 0) {
            System.arraycopy(this.buffer, 0, b, 0, i);
        }
        return b;
    }

    public int byteAt(int i) {
        return this.buffer[i];
    }

    public int capacity() {
        return this.buffer.length;
    }

    public int length() {
        return this.len;
    }

    public void ensureCapacity(int required) {
        if (required > 0) {
            int length = this.buffer.length;
            int i = this.len;
            if (required > length - i) {
                expand(i + required);
            }
        }
    }

    public byte[] buffer() {
        return this.buffer;
    }

    public void setLength(int len2) {
        if (len2 < 0 || len2 > this.buffer.length) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("len: ");
            stringBuffer.append(len2);
            stringBuffer.append(" < 0 or > buffer len: ");
            stringBuffer.append(this.buffer.length);
            throw new IndexOutOfBoundsException(stringBuffer.toString());
        }
        this.len = len2;
    }

    public boolean isEmpty() {
        return this.len == 0;
    }

    public boolean isFull() {
        return this.len == this.buffer.length;
    }

    public int indexOf(byte b, int beginIndex, int endIndex) {
        if (beginIndex < 0) {
            beginIndex = 0;
        }
        if (endIndex > this.len) {
            endIndex = this.len;
        }
        if (beginIndex > endIndex) {
            return -1;
        }
        for (int i = beginIndex; i < endIndex; i++) {
            if (this.buffer[i] == b) {
                return i;
            }
        }
        return -1;
    }

    public int indexOf(byte b) {
        return indexOf(b, 0, this.len);
    }
}
