package org.apache.http.entity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;

public class StringEntity extends AbstractHttpEntity implements Cloneable {
    protected final byte[] content;

    public StringEntity(String string, String mimeType, String charset) throws UnsupportedEncodingException {
        if (string != null) {
            mimeType = mimeType == null ? HTTP.PLAIN_TEXT_TYPE : mimeType;
            charset = charset == null ? "ISO-8859-1" : charset;
            this.content = string.getBytes(charset);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(mimeType);
            stringBuffer.append(HTTP.CHARSET_PARAM);
            stringBuffer.append(charset);
            setContentType(stringBuffer.toString());
            return;
        }
        throw new IllegalArgumentException("Source string may not be null");
    }

    public StringEntity(String string, String charset) throws UnsupportedEncodingException {
        this(string, (String) null, charset);
    }

    public StringEntity(String string) throws UnsupportedEncodingException {
        this(string, (String) null);
    }

    public boolean isRepeatable() {
        return true;
    }

    public long getContentLength() {
        return (long) this.content.length;
    }

    public InputStream getContent() throws IOException {
        return new ByteArrayInputStream(this.content);
    }

    public void writeTo(OutputStream outstream) throws IOException {
        if (outstream != null) {
            outstream.write(this.content);
            outstream.flush();
            return;
        }
        throw new IllegalArgumentException("Output stream may not be null");
    }

    public boolean isStreaming() {
        return false;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
