package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;

public abstract class StatsEvent extends x implements ReflectedParcelable {
    public abstract int m();

    public abstract long p();

    public abstract long r();

    public abstract String s();

    public String toString() {
        long p = p();
        int m = m();
        long r = r();
        String s = s();
        StringBuilder sb = new StringBuilder(String.valueOf(s).length() + 53);
        sb.append(p);
        sb.append("\t");
        sb.append(m);
        sb.append("\t");
        sb.append(r);
        sb.append(s);
        return sb.toString();
    }
}
