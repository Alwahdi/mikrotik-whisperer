package org.apache.http.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;

public final class EntityUtils {
    private EntityUtils() {
    }

    public static void consume(HttpEntity entity) throws IOException {
        InputStream instream;
        if (entity != null && entity.isStreaming() && (instream = entity.getContent()) != null) {
            instream.close();
        }
    }

    public static byte[] toByteArray(HttpEntity entity) throws IOException {
        if (entity != null) {
            InputStream instream = entity.getContent();
            if (instream == null) {
                return null;
            }
            try {
                if (entity.getContentLength() <= 2147483647L) {
                    int i = (int) entity.getContentLength();
                    if (i < 0) {
                        i = 4096;
                    }
                    ByteArrayBuffer buffer = new ByteArrayBuffer(i);
                    byte[] tmp = new byte[4096];
                    while (true) {
                        int read = instream.read(tmp);
                        int l = read;
                        if (read == -1) {
                            return buffer.toByteArray();
                        }
                        buffer.append(tmp, 0, l);
                    }
                } else {
                    throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
                }
            } finally {
                instream.close();
            }
        } else {
            throw new IllegalArgumentException("HTTP entity may not be null");
        }
    }

    public static String getContentCharSet(HttpEntity entity) throws ParseException {
        NameValuePair param;
        if (entity == null) {
            throw new IllegalArgumentException("HTTP entity may not be null");
        } else if (entity.getContentType() == null) {
            return null;
        } else {
            HeaderElement[] values = entity.getContentType().getElements();
            if (values.length <= 0 || (param = values[0].getParameterByName("charset")) == null) {
                return null;
            }
            return param.getValue();
        }
    }

    public static String getContentMimeType(HttpEntity entity) throws ParseException {
        if (entity == null) {
            throw new IllegalArgumentException("HTTP entity may not be null");
        } else if (entity.getContentType() == null) {
            return null;
        } else {
            HeaderElement[] values = entity.getContentType().getElements();
            if (values.length > 0) {
                return values[0].getName();
            }
            return null;
        }
    }

    public static String toString(HttpEntity entity, String defaultCharset) throws IOException, ParseException {
        if (entity != null) {
            InputStream instream = entity.getContent();
            if (instream == null) {
                return null;
            }
            try {
                if (entity.getContentLength() <= 2147483647L) {
                    int i = (int) entity.getContentLength();
                    if (i < 0) {
                        i = 4096;
                    }
                    String charset = getContentCharSet(entity);
                    if (charset == null) {
                        charset = defaultCharset;
                    }
                    if (charset == null) {
                        charset = "ISO-8859-1";
                    }
                    Reader reader = new InputStreamReader(instream, charset);
                    CharArrayBuffer buffer = new CharArrayBuffer(i);
                    char[] tmp = new char[1024];
                    while (true) {
                        int read = reader.read(tmp);
                        int l = read;
                        if (read == -1) {
                            return buffer.toString();
                        }
                        buffer.append(tmp, 0, l);
                    }
                } else {
                    throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
                }
            } finally {
                instream.close();
            }
        } else {
            throw new IllegalArgumentException("HTTP entity may not be null");
        }
    }

    public static String toString(HttpEntity entity) throws IOException, ParseException {
        return toString(entity, (String) null);
    }
}
