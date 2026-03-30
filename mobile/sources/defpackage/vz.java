package defpackage;

import java.io.IOException;

/* renamed from: vz  reason: default package */
public class vz extends IOException {
    public vz(IOException e) {
        super(e.getMessage());
        initCause(e);
    }
}
