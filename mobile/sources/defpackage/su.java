package defpackage;

import java.io.IOException;
import java.util.Locale;

/* renamed from: su  reason: default package */
public class su extends IOException {
    public final float a;

    /* renamed from: a  reason: collision with other field name */
    public final String f5057a;
    public final float b;

    su(String detailMessage) {
        super(detailMessage);
        this.f5057a = "na";
        this.a = 0.0f;
        this.b = 0.0f;
    }

    su(String message, String property, float actualValue, float expectedValue) {
        super(String.format(Locale.getDefault(), message, new Object[]{property, Float.valueOf(actualValue), Float.valueOf(expectedValue)}));
        this.f5057a = property;
        this.b = actualValue;
        this.a = expectedValue;
    }
}
