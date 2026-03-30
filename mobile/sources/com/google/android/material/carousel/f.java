package com.google.android.material.carousel;

import com.google.android.material.carousel.KeylineState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class f {
    private final float a;

    /* renamed from: a  reason: collision with other field name */
    private final int f1591a;

    /* renamed from: a  reason: collision with other field name */
    private final List<c> f1592a;
    private final int b;

    private f(float itemSize, List<c> keylines, int firstFocalKeylineIndex, int lastFocalKeylineIndex) {
        this.a = itemSize;
        this.f1592a = Collections.unmodifiableList(keylines);
        this.f1591a = firstFocalKeylineIndex;
        this.b = lastFocalKeylineIndex;
    }

    /* access modifiers changed from: package-private */
    public float f() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public List<c> g() {
        return this.f1592a;
    }

    /* access modifiers changed from: package-private */
    public c a() {
        return this.f1592a.get(this.f1591a);
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f1591a;
    }

    /* access modifiers changed from: package-private */
    public c h() {
        return this.f1592a.get(this.b);
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public List<c> e() {
        return this.f1592a.subList(this.f1591a, this.b + 1);
    }

    /* access modifiers changed from: package-private */
    public c c() {
        return this.f1592a.get(0);
    }

    /* access modifiers changed from: package-private */
    public c j() {
        List<c> list = this.f1592a;
        return list.get(list.size() - 1);
    }

    /* access modifiers changed from: package-private */
    public c d() {
        for (int i = 0; i < this.f1592a.size(); i++) {
            c keyline = this.f1592a.get(i);
            if (!keyline.f1599a) {
                return keyline;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public c k() {
        for (int i = this.f1592a.size() - 1; i >= 0; i--) {
            c keyline = this.f1592a.get(i);
            if (!keyline.f1599a) {
                return keyline;
            }
        }
        return null;
    }

    static f l(f from, f to, float progress) {
        if (from.f() == to.f()) {
            List<c> g = from.g();
            List<c> g2 = to.g();
            if (g.size() == g2.size()) {
                List<KeylineState.Keyline> keylines = new ArrayList<>();
                for (int i = 0; i < from.g().size(); i++) {
                    keylines.add(c.a(g.get(i), g2.get(i), progress));
                }
                return new f(from.f(), keylines, f3.c(from.b(), to.b(), progress), f3.c(from.i(), to.i(), progress));
            }
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
    }

    static f m(f keylineState, float availableSpace) {
        b builder = new b(keylineState.f(), availableSpace);
        float start = (availableSpace - keylineState.j().b) - (keylineState.j().d / 2.0f);
        int i = keylineState.g().size() - 1;
        while (i >= 0) {
            c k = keylineState.g().get(i);
            builder.d(start + (k.d / 2.0f), k.c, k.d, i >= keylineState.b() && i <= keylineState.i(), k.f1599a);
            start += k.d;
            i--;
        }
        return builder.h();
    }

    static final class b {
        private final float a;

        /* renamed from: a  reason: collision with other field name */
        private int f1593a = -1;

        /* renamed from: a  reason: collision with other field name */
        private c f1594a;

        /* renamed from: a  reason: collision with other field name */
        private final List<c> f1595a = new ArrayList();
        private final float b;

        /* renamed from: b  reason: collision with other field name */
        private int f1596b = -1;

        /* renamed from: b  reason: collision with other field name */
        private c f1597b;
        private float c = 0.0f;

        /* renamed from: c  reason: collision with other field name */
        private int f1598c = -1;

        b(float itemSize, float availableSpace) {
            this.a = itemSize;
            this.b = availableSpace;
        }

        /* access modifiers changed from: package-private */
        public b c(float offsetLoc, float mask, float maskedItemSize, boolean isFocal) {
            return d(offsetLoc, mask, maskedItemSize, isFocal, false);
        }

        /* access modifiers changed from: package-private */
        public b b(float offsetLoc, float mask, float maskedItemSize) {
            return c(offsetLoc, mask, maskedItemSize, false);
        }

        /* access modifiers changed from: package-private */
        public b e(float offsetLoc, float mask, float maskedItemSize, boolean isFocal, boolean isAnchor, float cutoff) {
            if (maskedItemSize <= 0.0f) {
                return this;
            }
            if (isAnchor) {
                if (!isFocal) {
                    int i = this.f1598c;
                    if (i == -1 || i == 0) {
                        this.f1598c = this.f1595a.size();
                    } else {
                        throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
                    }
                } else {
                    throw new IllegalArgumentException("Anchor keylines cannot be focal.");
                }
            }
            c cVar = new c(Float.MIN_VALUE, offsetLoc, mask, maskedItemSize, isAnchor, cutoff);
            if (isFocal) {
                if (this.f1594a == null) {
                    this.f1594a = cVar;
                    this.f1593a = this.f1595a.size();
                }
                if (this.f1596b != -1 && this.f1595a.size() - this.f1596b > 1) {
                    throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                } else if (maskedItemSize == this.f1594a.d) {
                    this.f1597b = cVar;
                    this.f1596b = this.f1595a.size();
                } else {
                    throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
                }
            } else if (this.f1594a == null && cVar.d < this.c) {
                throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
            } else if (this.f1597b != null && cVar.d > this.c) {
                throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
            }
            this.c = cVar.d;
            this.f1595a.add(cVar);
            return this;
        }

        /* access modifiers changed from: package-private */
        public b d(float offsetLoc, float mask, float maskedItemSize, boolean isFocal, boolean isAnchor) {
            float cutoff = 0.0f;
            float keylineStart = offsetLoc - (maskedItemSize / 2.0f);
            float keylineEnd = (maskedItemSize / 2.0f) + offsetLoc;
            float f = this.b;
            if (keylineEnd > f) {
                cutoff = Math.abs(keylineEnd - Math.max(keylineEnd - maskedItemSize, f));
            } else if (keylineStart < 0.0f) {
                cutoff = Math.abs(keylineStart - Math.min(keylineStart + maskedItemSize, 0.0f));
            }
            return e(offsetLoc, mask, maskedItemSize, isFocal, isAnchor, cutoff);
        }

        /* access modifiers changed from: package-private */
        public b a(float offsetLoc, float mask, float maskedItemSize) {
            return d(offsetLoc, mask, maskedItemSize, false, true);
        }

        /* access modifiers changed from: package-private */
        public b f(float offsetLoc, float mask, float maskedItemSize, int count) {
            return g(offsetLoc, mask, maskedItemSize, count, false);
        }

        /* access modifiers changed from: package-private */
        public b g(float offsetLoc, float mask, float maskedItemSize, int count, boolean isFocal) {
            if (count <= 0 || maskedItemSize <= 0.0f) {
                return this;
            }
            for (int i = 0; i < count; i++) {
                c((((float) i) * maskedItemSize) + offsetLoc, mask, maskedItemSize, isFocal);
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public f h() {
            if (this.f1594a != null) {
                List<KeylineState.Keyline> keylines = new ArrayList<>();
                for (int i = 0; i < this.f1595a.size(); i++) {
                    c tmpKeyline = this.f1595a.get(i);
                    keylines.add(new c(i(this.f1594a.b, this.a, this.f1593a, i), tmpKeyline.b, tmpKeyline.c, tmpKeyline.d, tmpKeyline.f1599a, tmpKeyline.e));
                }
                return new f(this.a, keylines, this.f1593a, this.f1596b);
            }
            throw new IllegalStateException("There must be a keyline marked as focal.");
        }

        private static float i(float firstFocalLoc, float itemSize, int firstFocalPosition, int itemPosition) {
            return (firstFocalLoc - (((float) firstFocalPosition) * itemSize)) + (((float) itemPosition) * itemSize);
        }
    }

    static final class c {
        final float a;

        /* renamed from: a  reason: collision with other field name */
        final boolean f1599a;
        final float b;
        final float c;
        final float d;
        final float e;

        c(float loc, float locOffset, float mask, float maskedItemSize) {
            this(loc, locOffset, mask, maskedItemSize, false, 0.0f);
        }

        c(float loc, float locOffset, float mask, float maskedItemSize, boolean isAnchor, float cutoff) {
            this.a = loc;
            this.b = locOffset;
            this.c = mask;
            this.d = maskedItemSize;
            this.f1599a = isAnchor;
            this.e = cutoff;
        }

        static c a(c from, c to, float progress) {
            return new c(f3.a(from.a, to.a, progress), f3.a(from.b, to.b, progress), f3.a(from.c, to.c, progress), f3.a(from.d, to.d, progress));
        }
    }
}
