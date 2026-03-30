package defpackage;

import android.graphics.Typeface;

/* renamed from: q7  reason: default package */
public final class q7 extends qq0 {
    private final Typeface a;

    /* renamed from: a  reason: collision with other field name */
    private final a f4773a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f4774a;

    /* renamed from: q7$a */
    public interface a {
        void a(Typeface typeface);
    }

    public q7(a applyFont, Typeface fallbackFont) {
        this.a = fallbackFont;
        this.f4773a = applyFont;
    }

    public void b(Typeface font, boolean fontResolvedSynchronously) {
        d(font);
    }

    public void a(int reason) {
        d(this.a);
    }

    public void c() {
        this.f4774a = true;
    }

    private void d(Typeface updatedFont) {
        if (!this.f4774a) {
            this.f4773a.a(updatedFont);
        }
    }
}
