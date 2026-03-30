package defpackage;

import java.io.IOException;
import java.util.Iterator;

/* renamed from: ov  reason: default package */
public class ov {
    private final String a;

    public static ov e(char separator) {
        return new ov(String.valueOf(separator));
    }

    private ov(String separator) {
        this.a = (String) v90.n(separator);
    }

    public <A extends Appendable> A a(A appendable, Iterator<?> parts) {
        v90.n(appendable);
        if (parts.hasNext()) {
            appendable.append(f(parts.next()));
            while (parts.hasNext()) {
                appendable.append(this.a);
                appendable.append(f(parts.next()));
            }
        }
        return appendable;
    }

    public final StringBuilder b(StringBuilder builder, Iterator<?> parts) {
        try {
            a(builder, parts);
            return builder;
        } catch (IOException impossible) {
            throw new AssertionError(impossible);
        }
    }

    public final String c(Iterable<?> parts) {
        return d(parts.iterator());
    }

    public final String d(Iterator<?> parts) {
        return b(new StringBuilder(), parts).toString();
    }

    /* access modifiers changed from: package-private */
    public CharSequence f(Object part) {
        v90.n(part);
        return part instanceof CharSequence ? (CharSequence) part : part.toString();
    }
}
