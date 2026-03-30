package defpackage;

import java.util.List;

/* renamed from: ms  reason: default package */
abstract class ms implements np {
    /* access modifiers changed from: package-private */
    public abstract List<String> b();

    ms() {
    }

    public void a(List<lp> glyphList) {
        int i = 0;
        while (i < glyphList.size()) {
            lp glyph = glyphList.get(i);
            lp nextGlyph = c(glyphList, i);
            if (nextGlyph != null && b().contains(nextGlyph.f4267a)) {
                glyphList.set(i, nextGlyph);
                glyphList.set(i + 1, glyph);
                i++;
            }
            i++;
        }
    }

    private lp c(List<lp> glyphs, int currentIndex) {
        if (currentIndex + 1 < glyphs.size()) {
            return glyphs.get(currentIndex + 1);
        }
        return null;
    }
}
