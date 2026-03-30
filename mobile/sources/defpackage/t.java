package defpackage;

import java.util.Random;

/* renamed from: t  reason: default package */
public abstract class t extends bd0 {
    public abstract Random d();

    public int b() {
        return d().nextInt();
    }

    public int c(int until) {
        return d().nextInt(until);
    }
}
