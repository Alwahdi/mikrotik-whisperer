package defpackage;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* renamed from: rq0  reason: default package */
public class rq0 {
    private float a;

    /* renamed from: a  reason: collision with other field name */
    private final TextPaint f4934a = new TextPaint(1);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public WeakReference<b> f4935a = new WeakReference<>((Object) null);

    /* renamed from: a  reason: collision with other field name */
    private oq0 f4936a;

    /* renamed from: a  reason: collision with other field name */
    private final qq0 f4937a = new a();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public boolean f4938a = true;
    private float b;

    /* renamed from: rq0$b */
    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    /* renamed from: rq0$a */
    class a extends qq0 {
        a() {
        }

        public void b(Typeface typeface, boolean fontResolvedSynchronously) {
            if (!fontResolvedSynchronously) {
                boolean unused = rq0.this.f4938a = true;
                b textDrawableDelegate = (b) rq0.this.f4935a.get();
                if (textDrawableDelegate != null) {
                    textDrawableDelegate.a();
                }
            }
        }

        public void a(int reason) {
            boolean unused = rq0.this.f4938a = true;
            b textDrawableDelegate = (b) rq0.this.f4935a.get();
            if (textDrawableDelegate != null) {
                textDrawableDelegate.a();
            }
        }
    }

    public rq0(b delegate) {
        j(delegate);
    }

    public void j(b delegate) {
        this.f4935a = new WeakReference<>(delegate);
    }

    public TextPaint g() {
        return this.f4934a;
    }

    public void m(boolean dirty) {
        this.f4938a = dirty;
    }

    public void l(boolean dirty) {
        this.f4938a = dirty;
    }

    private void i(String text) {
        this.a = d(text);
        this.b = c(text);
        this.f4938a = false;
    }

    public float h(String text) {
        if (!this.f4938a) {
            return this.a;
        }
        i(text);
        return this.a;
    }

    private float d(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f4934a.measureText(charSequence, 0, charSequence.length());
    }

    public float f(String text) {
        if (!this.f4938a) {
            return this.b;
        }
        i(text);
        return this.b;
    }

    private float c(String str) {
        if (str == null) {
            return 0.0f;
        }
        return Math.abs(this.f4934a.getFontMetrics().ascent);
    }

    public oq0 e() {
        return this.f4936a;
    }

    public void k(oq0 textAppearance, Context context) {
        if (this.f4936a != textAppearance) {
            this.f4936a = textAppearance;
            if (textAppearance != null) {
                textAppearance.o(context, this.f4934a, this.f4937a);
                b textDrawableDelegate = (b) this.f4935a.get();
                if (textDrawableDelegate != null) {
                    this.f4934a.drawableState = textDrawableDelegate.getState();
                }
                textAppearance.n(context, this.f4934a, this.f4937a);
                this.f4938a = true;
            }
            b textDrawableDelegate2 = (b) this.f4935a.get();
            if (textDrawableDelegate2 != null) {
                textDrawableDelegate2.a();
                textDrawableDelegate2.onStateChange(textDrawableDelegate2.getState());
            }
        }
    }

    public void n(Context context) {
        this.f4936a.n(context, this.f4934a, this.f4937a);
    }
}
