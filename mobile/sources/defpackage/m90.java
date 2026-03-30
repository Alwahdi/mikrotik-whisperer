package defpackage;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* renamed from: m90  reason: default package */
public final class m90 extends t {
    public Random d() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        lu.e(current, "current()");
        return current;
    }
}
