package defpackage;

import com.evrencoskun.tableview.sort.a;
import java.util.Date;

/* renamed from: a0  reason: default package */
public abstract class a0 {
    protected a a;

    /* access modifiers changed from: protected */
    public int d(Object o1, Object o2) {
        if (o1 == null && o2 == null) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        Class type = o1.getClass();
        if (Comparable.class.isAssignableFrom(type)) {
            return ((Comparable) o1).compareTo(o2);
        }
        if (type.getSuperclass() == Number.class) {
            return b((Number) o1, (Number) o2);
        }
        if (type == String.class) {
            return ((String) o1).compareTo((String) o2);
        }
        if (type == Date.class) {
            return c((Date) o1, (Date) o2);
        }
        if (type == Boolean.class) {
            return a((Boolean) o1, (Boolean) o2);
        }
        return ((String) o1).compareTo((String) o2);
    }

    public int b(Number o1, Number o2) {
        double n1 = o1.doubleValue();
        double n2 = o2.doubleValue();
        if (n1 < n2) {
            return -1;
        }
        if (n1 > n2) {
            return 1;
        }
        return 0;
    }

    public int c(Date o1, Date o2) {
        long n1 = o1.getTime();
        long n2 = o2.getTime();
        if (n1 < n2) {
            return -1;
        }
        if (n1 > n2) {
            return 1;
        }
        return 0;
    }

    public int a(Boolean o1, Boolean o2) {
        boolean b1 = o1.booleanValue();
        if (b1 == o2.booleanValue()) {
            return 0;
        }
        if (b1) {
            return 1;
        }
        return -1;
    }
}
