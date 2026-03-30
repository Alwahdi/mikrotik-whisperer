package defpackage;

import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: sn0  reason: default package */
public abstract class sn0 {
    public static boolean a(String string) {
        return i90.c(string);
    }

    public static String b(String template, Object... args) {
        int placeholderStart;
        String template2 = String.valueOf(template);
        if (args == null) {
            args = new Object[]{"(Object[])null"};
        } else {
            for (int i = 0; i < args.length; i++) {
                args[i] = c(args[i]);
            }
        }
        StringBuilder builder = new StringBuilder(template2.length() + (args.length * 16));
        int templateStart = 0;
        int i2 = 0;
        while (i2 < args.length && (placeholderStart = template2.indexOf("%s", templateStart)) != -1) {
            builder.append(template2, templateStart, placeholderStart);
            builder.append(args[i2]);
            templateStart = placeholderStart + 2;
            i2++;
        }
        builder.append(template2, templateStart, template2.length());
        if (i2 < args.length) {
            builder.append(" [");
            int i3 = i2 + 1;
            builder.append(args[i2]);
            while (true) {
                int i4 = i3;
                if (i4 >= args.length) {
                    break;
                }
                builder.append(", ");
                i3 = i4 + 1;
                builder.append(args[i4]);
            }
            builder.append(']');
        }
        return builder.toString();
    }

    private static String c(Object o) {
        if (o == null) {
            return "null";
        }
        try {
            return o.toString();
        } catch (Exception e) {
            String objectToString = o.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(o));
            Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + objectToString, e);
            return "<" + objectToString + " threw " + e.getClass().getName() + ">";
        }
    }
}
