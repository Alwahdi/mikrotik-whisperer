package defpackage;

import java.util.Arrays;
import java.util.List;

/* renamed from: dg  reason: default package */
public class dg extends eg {
    private final List<cb<?>> a;

    public dg(List<cb<?>> componentsInCycle) {
        super("Dependency cycle detected: " + Arrays.toString(componentsInCycle.toArray()));
        this.a = componentsInCycle;
    }
}
