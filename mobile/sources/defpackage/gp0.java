package defpackage;

import com.itextpdf.text.e;

/* renamed from: gp0  reason: default package */
public abstract class gp0 {
    public abstract e a(float f);

    public static e b(float currentPosition, gp0 tabSettings) {
        if (tabSettings != null) {
            return tabSettings.a(currentPosition);
        }
        return e.f(currentPosition, 36.0f);
    }
}
