package defpackage;

import io.grpc.j;
import io.grpc.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/* renamed from: hs0  reason: default package */
public abstract class hs0 {
    private static final Logger a = Logger.getLogger(hs0.class.getName());

    /* renamed from: a  reason: collision with other field name */
    private static final byte[] f3179a = "-bin".getBytes(j8.a);

    public static byte[][] d(l headers) {
        byte[][] serializedHeaders = j.d(headers);
        if (serializedHeaders == null) {
            return new byte[0][];
        }
        int k = 0;
        for (int i = 0; i < serializedHeaders.length; i += 2) {
            byte[] key = serializedHeaders[i];
            byte[] value = serializedHeaders[i + 1];
            if (a(key, f3179a)) {
                serializedHeaders[k] = key;
                serializedHeaders[k + 1] = j.f3797a.e(value).getBytes(j8.a);
                k += 2;
            } else if (b(value)) {
                serializedHeaders[k] = key;
                serializedHeaders[k + 1] = value;
                k += 2;
            } else {
                String keyString = new String(key, j8.a);
                Logger logger = a;
                logger.warning("Metadata key=" + keyString + ", value=" + Arrays.toString(value) + " contains invalid ASCII characters");
            }
        }
        if (k == serializedHeaders.length) {
            return serializedHeaders;
        }
        return (byte[][]) Arrays.copyOfRange(serializedHeaders, 0, k);
    }

    public static byte[][] e(byte[][] http2Headers) {
        for (int i = 0; i < http2Headers.length; i += 2) {
            byte[] key = http2Headers[i];
            byte[] value = http2Headers[i + 1];
            if (a(key, f3179a)) {
                for (byte b : value) {
                    if (b == 44) {
                        return c(http2Headers, i);
                    }
                }
                http2Headers[i + 1] = x5.a().b(new String(value, j8.a));
            }
        }
        return http2Headers;
    }

    private static byte[][] c(byte[][] http2Headers, int resumeFrom) {
        List<byte[]> headerList = new ArrayList<>(http2Headers.length + 10);
        for (int i = 0; i < resumeFrom; i++) {
            headerList.add(http2Headers[i]);
        }
        for (int i2 = resumeFrom; i2 < http2Headers.length; i2 += 2) {
            byte[] key = http2Headers[i2];
            byte[] value = http2Headers[i2 + 1];
            if (!a(key, f3179a)) {
                headerList.add(key);
                headerList.add(value);
            } else {
                int prevIdx = 0;
                for (int idx = 0; idx <= value.length; idx++) {
                    if (idx == value.length || value[idx] == 44) {
                        byte[] decodedVal = x5.a().b(new String(value, prevIdx, idx - prevIdx, j8.a));
                        prevIdx = idx + 1;
                        headerList.add(key);
                        headerList.add(decodedVal);
                    }
                }
            }
        }
        return (byte[][]) headerList.toArray(new byte[0][]);
    }

    private static boolean a(byte[] subject, byte[] suffix) {
        int start = subject.length - suffix.length;
        if (start < 0) {
            return false;
        }
        for (int i = start; i < subject.length; i++) {
            if (subject[i] != suffix[i - start]) {
                return false;
            }
        }
        return true;
    }

    private static boolean b(byte[] subject) {
        for (byte b : subject) {
            if (b < 32 || b > 126) {
                return false;
            }
        }
        return true;
    }
}
