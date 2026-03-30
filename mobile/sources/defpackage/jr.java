package defpackage;

import java.io.Closeable;
import java.io.IOException;

/* renamed from: jr  reason: default package */
public abstract class jr {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }
}
