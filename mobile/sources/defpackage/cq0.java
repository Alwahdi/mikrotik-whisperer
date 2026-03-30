package defpackage;

/* renamed from: cq0  reason: default package */
public class cq0 {
    private int a;
    private int b;

    public static cq0 b(int after) {
        cq0 generator = new cq0(0, after);
        generator.c();
        return generator;
    }

    public static cq0 a() {
        return new cq0(1, 1);
    }

    cq0(int generatorId, int seed) {
        n4.d((generatorId & 1) == generatorId, "Generator ID %d contains more than %d reserved bits", Integer.valueOf(generatorId), 1);
        this.b = generatorId;
        d(seed);
    }

    private void d(int targetId) {
        n4.d((targetId & 1) == this.b, "Cannot supply target ID from different generator ID", new Object[0]);
        this.a = targetId;
    }

    public int c() {
        int nextId = this.a;
        this.a += 2;
        return nextId;
    }
}
