package defpackage;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* renamed from: s5  reason: default package */
public class s5 extends ms {
    private static final String[] a = {"ি", "ে", "ৈ"};

    /* renamed from: a  reason: collision with other field name */
    private final Map<Integer, int[]> f4960a;
    private final Map<String, lp> b;

    public s5(Map<Integer, int[]> cmap31, Map<String, lp> glyphSubstitutionMap) {
        this.f4960a = cmap31;
        this.b = glyphSubstitutionMap;
    }

    public void a(List<lp> glyphList) {
        for (int i = 0; i < glyphList.size(); i++) {
            lp glyph = glyphList.get(i);
            if (glyph.f4267a.equals("ো")) {
                e(i, glyphList, 2503, 2494);
            } else if (glyph.f4267a.equals("ৌ")) {
                e(i, glyphList, 2503, 2519);
            }
        }
        super.a(glyphList);
    }

    public List<String> b() {
        return Arrays.asList(a);
    }

    private void e(int currentIndex, List<lp> glyphList, char first, char second) {
        lp g1 = d(first);
        lp g2 = d(second);
        glyphList.set(currentIndex, g1);
        glyphList.add(currentIndex + 1, g2);
    }

    private lp d(char c) {
        lp glyph = this.b.get(String.valueOf(c));
        if (glyph != null) {
            return glyph;
        }
        int[] metrics = this.f4960a.get(Integer.valueOf(c));
        return new lp(metrics[0], metrics[1], String.valueOf(c));
    }
}
