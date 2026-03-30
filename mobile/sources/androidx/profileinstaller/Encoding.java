package androidx.profileinstaller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

@RequiresApi(19)
class Encoding {
    static final int SIZEOF_BYTE = 8;
    static final int UINT_16_SIZE = 2;
    static final int UINT_32_SIZE = 4;
    static final int UINT_8_SIZE = 1;

    private Encoding() {
    }

    static int utf8Length(@NonNull String s) {
        return s.getBytes(StandardCharsets.UTF_8).length;
    }

    static void writeUInt(@NonNull OutputStream os, long value, int numberOfBytes) throws IOException {
        byte[] buffer = new byte[numberOfBytes];
        for (int i = 0; i < numberOfBytes; i++) {
            buffer[i] = (byte) ((int) ((value >> (i * 8)) & 255));
        }
        os.write(buffer);
    }

    static void writeUInt8(@NonNull OutputStream os, int value) throws IOException {
        writeUInt(os, (long) value, 1);
    }

    static void writeUInt16(@NonNull OutputStream os, int value) throws IOException {
        writeUInt(os, (long) value, 2);
    }

    static void writeUInt32(@NonNull OutputStream os, long value) throws IOException {
        writeUInt(os, value, 4);
    }

    static void writeString(@NonNull OutputStream os, @NonNull String s) throws IOException {
        os.write(s.getBytes(StandardCharsets.UTF_8));
    }

    static int bitsToBytes(int numberOfBits) {
        return (((numberOfBits + 8) - 1) & -8) / 8;
    }

    @NonNull
    static byte[] read(@NonNull InputStream is, int length) throws IOException {
        byte[] buffer = new byte[length];
        int offset = 0;
        while (offset < length) {
            int result = is.read(buffer, offset, length - offset);
            if (result >= 0) {
                offset += result;
            } else {
                throw error("Not enough bytes to read: " + length);
            }
        }
        return buffer;
    }

    static long readUInt(@NonNull InputStream is, int numberOfBytes) throws IOException {
        byte[] buffer = read(is, numberOfBytes);
        long value = 0;
        for (int i = 0; i < numberOfBytes; i++) {
            value += ((long) (buffer[i] & 255)) << (i * 8);
        }
        return value;
    }

    static int readUInt8(@NonNull InputStream is) throws IOException {
        return (int) readUInt(is, 1);
    }

    static int readUInt16(@NonNull InputStream is) throws IOException {
        return (int) readUInt(is, 2);
    }

    static long readUInt32(@NonNull InputStream is) throws IOException {
        return readUInt(is, 4);
    }

    @NonNull
    static String readString(InputStream is, int size) throws IOException {
        return new String(read(is, size), StandardCharsets.UTF_8);
    }

    @NonNull
    static byte[] readCompressed(@NonNull InputStream is, int compressedDataSize, int uncompressedDataSize) throws IOException {
        Inflater inf = new Inflater();
        try {
            byte[] result = new byte[uncompressedDataSize];
            int totalBytesRead = 0;
            int totalBytesInflated = 0;
            byte[] input = new byte[2048];
            while (!inf.finished() && !inf.needsDictionary() && totalBytesRead < compressedDataSize) {
                int bytesRead = is.read(input);
                if (bytesRead >= 0) {
                    inf.setInput(input, 0, bytesRead);
                    totalBytesInflated += inf.inflate(result, totalBytesInflated, uncompressedDataSize - totalBytesInflated);
                    totalBytesRead += bytesRead;
                } else {
                    throw error("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + compressedDataSize + " bytes");
                }
            }
            if (totalBytesRead != compressedDataSize) {
                throw error("Didn't read enough bytes during decompression. expected=" + compressedDataSize + " actual=" + totalBytesRead);
            } else if (inf.finished()) {
                inf.end();
                return result;
            } else {
                throw error("Inflater did not finish");
            }
        } catch (DataFormatException e) {
            throw error(e.getMessage());
        } catch (Throwable th) {
            inf.end();
            throw th;
        }
    }

    static void writeCompressed(@NonNull OutputStream os, byte[] data) throws IOException {
        writeUInt32(os, (long) data.length);
        byte[] outputData = compress(data);
        writeUInt32(os, (long) outputData.length);
        os.write(outputData);
    }

    static byte[] compress(@NonNull byte[] data) throws IOException {
        DeflaterOutputStream deflater;
        Deflater compressor = new Deflater(1);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            deflater = new DeflaterOutputStream(out, compressor);
            deflater.write(data);
            deflater.close();
            compressor.end();
            return out.toByteArray();
        } catch (Throwable th) {
            compressor.end();
            throw th;
        }
        throw th;
    }

    static void writeAll(@NonNull InputStream is, @NonNull OutputStream os) throws IOException {
        byte[] buf = new byte[512];
        while (true) {
            int read = is.read(buf);
            int length = read;
            if (read > 0) {
                os.write(buf, 0, length);
            } else {
                return;
            }
        }
    }

    @NonNull
    static RuntimeException error(@Nullable String message) {
        return new IllegalStateException(message);
    }
}
