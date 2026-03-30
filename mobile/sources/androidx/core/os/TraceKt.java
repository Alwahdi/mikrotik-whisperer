package androidx.core.os;

public final class TraceKt {
    public static final <T> T trace(String sectionName, tn<? extends T> block) {
        lu.f(sectionName, "sectionName");
        lu.f(block, "block");
        TraceCompat.beginSection(sectionName);
        try {
            return block.invoke();
        } finally {
            ps.b(1);
            TraceCompat.endSection();
            ps.a(1);
        }
    }
}
