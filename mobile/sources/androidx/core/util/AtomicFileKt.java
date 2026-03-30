package androidx.core.util;

import android.util.AtomicFile;
import androidx.annotation.RequiresApi;
import java.io.FileOutputStream;
import java.nio.charset.Charset;

public final class AtomicFileKt {
    @RequiresApi(17)
    public static final void tryWrite(AtomicFile $this$tryWrite, vn<? super FileOutputStream, jt0> block) {
        lu.f($this$tryWrite, "<this>");
        lu.f(block, "block");
        FileOutputStream stream = $this$tryWrite.startWrite();
        try {
            lu.e(stream, "stream");
            block.invoke(stream);
            ps.b(1);
            $this$tryWrite.finishWrite(stream);
            ps.a(1);
        } catch (Throwable th) {
            ps.b(1);
            $this$tryWrite.failWrite(stream);
            ps.a(1);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeBytes(AtomicFile $this$writeBytes, byte[] array) {
        lu.f($this$writeBytes, "<this>");
        lu.f(array, "array");
        AtomicFile $this$tryWrite$iv = $this$writeBytes;
        FileOutputStream stream$iv = $this$tryWrite$iv.startWrite();
        try {
            lu.e(stream$iv, "stream");
            stream$iv.write(array);
            $this$tryWrite$iv.finishWrite(stream$iv);
        } catch (Throwable th) {
            $this$tryWrite$iv.failWrite(stream$iv);
            throw th;
        }
    }

    public static /* synthetic */ void writeText$default(AtomicFile atomicFile, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = i8.f3207a;
        }
        writeText(atomicFile, str, charset);
    }

    @RequiresApi(17)
    public static final void writeText(AtomicFile $this$writeText, String text, Charset charset) {
        lu.f($this$writeText, "<this>");
        lu.f(text, "text");
        lu.f(charset, "charset");
        byte[] bytes = text.getBytes(charset);
        lu.e(bytes, "this as java.lang.String).getBytes(charset)");
        writeBytes($this$writeText, bytes);
    }

    @RequiresApi(17)
    public static final byte[] readBytes(AtomicFile $this$readBytes) {
        lu.f($this$readBytes, "<this>");
        byte[] readFully = $this$readBytes.readFully();
        lu.e(readFully, "readFully()");
        return readFully;
    }

    public static /* synthetic */ String readText$default(AtomicFile atomicFile, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = i8.f3207a;
        }
        return readText(atomicFile, charset);
    }

    @RequiresApi(17)
    public static final String readText(AtomicFile $this$readText, Charset charset) {
        lu.f($this$readText, "<this>");
        lu.f(charset, "charset");
        byte[] readFully = $this$readText.readFully();
        lu.e(readFully, "readFully()");
        return new String(readFully, charset);
    }
}
