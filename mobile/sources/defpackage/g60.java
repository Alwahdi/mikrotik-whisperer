package defpackage;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* renamed from: g60  reason: default package */
public class g60 extends n80 {
    private static final int[] a = {1, 4, 0, 2, 2, -1, 5, 2, 0, 11, 2, 0, 12, 2, 0, 13, 2, 0};

    public g60(Calendar d) {
        StringBuffer date = new StringBuffer("D:");
        date.append(K(d.get(1), 4));
        date.append(K(d.get(2) + 1, 2));
        date.append(K(d.get(5), 2));
        date.append(K(d.get(11), 2));
        date.append(K(d.get(12), 2));
        date.append(K(d.get(13), 2));
        int timezone = (d.get(15) + d.get(16)) / 3600000;
        if (timezone == 0) {
            date.append('Z');
        } else if (timezone < 0) {
            date.append('-');
            timezone = -timezone;
        } else {
            date.append('+');
        }
        if (timezone != 0) {
            date.append(K(timezone, 2));
            date.append('\'');
            date.append(K(Math.abs((d.get(15) + d.get(16)) / 60000) - (timezone * 60), 2));
            date.append('\'');
        }
        this.a = date.toString();
    }

    public g60() {
        this(new GregorianCalendar());
    }

    private String K(int i, int length) {
        StringBuffer tmp = new StringBuffer();
        tmp.append(i);
        while (tmp.length() < length) {
            tmp.insert(0, "0");
        }
        tmp.setLength(length);
        return tmp.toString();
    }
}
