package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.text.TextPaint;
import android.util.Log;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;

/* renamed from: oq0  reason: default package */
public class oq0 {
    public final float a;

    /* renamed from: a  reason: collision with other field name */
    public final int f4573a;

    /* renamed from: a  reason: collision with other field name */
    public final ColorStateList f4574a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public Typeface f4575a;

    /* renamed from: a  reason: collision with other field name */
    public final String f4576a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f4577a;
    public final float b;

    /* renamed from: b  reason: collision with other field name */
    public final int f4578b;

    /* renamed from: b  reason: collision with other field name */
    public final ColorStateList f4579b;

    /* renamed from: b  reason: collision with other field name */
    public final boolean f4580b;
    public final float c;

    /* renamed from: c  reason: collision with other field name */
    private final int f4581c;

    /* renamed from: c  reason: collision with other field name */
    public final ColorStateList f4582c;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with other field name */
    public boolean f4583c = false;
    public final float d;

    /* renamed from: d  reason: collision with other field name */
    private ColorStateList f4584d;
    private float e;

    public oq0(Context context, int id) {
        TypedArray a2 = context.obtainStyledAttributes(id, xc0.f5594A1);
        l(a2.getDimension(xc0.A4, 0.0f));
        k(o00.a(context, a2, xc0.D4));
        this.f4574a = o00.a(context, a2, xc0.E4);
        this.f4579b = o00.a(context, a2, xc0.F4);
        this.f4573a = a2.getInt(xc0.C4, 0);
        this.f4578b = a2.getInt(xc0.B4, 1);
        int fontFamilyIndex = o00.f(a2, xc0.L4, xc0.K4);
        this.f4581c = a2.getResourceId(fontFamilyIndex, 0);
        this.f4576a = a2.getString(fontFamilyIndex);
        this.f4577a = a2.getBoolean(xc0.M4, false);
        this.f4582c = o00.a(context, a2, xc0.G4);
        this.a = a2.getFloat(xc0.H4, 0.0f);
        this.b = a2.getFloat(xc0.I4, 0.0f);
        this.c = a2.getFloat(xc0.J4, 0.0f);
        a2.recycle();
        if (Build.VERSION.SDK_INT >= 21) {
            TypedArray a3 = context.obtainStyledAttributes(id, xc0.f5614H0);
            int i = xc0.m3;
            this.f4580b = a3.hasValue(i);
            this.d = a3.getFloat(i, 0.0f);
            a3.recycle();
            return;
        }
        this.f4580b = false;
        this.d = 0.0f;
    }

    public Typeface f(Context context) {
        if (this.f4583c) {
            return this.f4575a;
        }
        if (!context.isRestricted()) {
            try {
                Typeface font = ResourcesCompat.getFont(context, this.f4581c);
                this.f4575a = font;
                if (font != null) {
                    this.f4575a = Typeface.create(font, this.f4573a);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException e2) {
            } catch (Exception e3) {
                Log.d("TextAppearance", "Error loading font " + this.f4576a, e3);
            }
        }
        d();
        this.f4583c = true;
        return this.f4575a;
    }

    public void g(Context context, qq0 callback) {
        if (m(context)) {
            f(context);
        } else {
            d();
        }
        int i = this.f4581c;
        if (i == 0) {
            this.f4583c = true;
        }
        if (this.f4583c) {
            callback.b(this.f4575a, true);
            return;
        }
        try {
            ResourcesCompat.getFont(context, i, new a(callback), (Handler) null);
        } catch (Resources.NotFoundException e2) {
            this.f4583c = true;
            callback.a(1);
        } catch (Exception e3) {
            Log.d("TextAppearance", "Error loading font " + this.f4576a, e3);
            this.f4583c = true;
            callback.a(-3);
        }
    }

    /* renamed from: oq0$a */
    class a extends ResourcesCompat.FontCallback {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ qq0 f4585a;

        a(qq0 qq0) {
            this.f4585a = qq0;
        }

        public void onFontRetrieved(Typeface typeface) {
            oq0 oq0 = oq0.this;
            Typeface unused = oq0.f4575a = Typeface.create(typeface, oq0.f4573a);
            boolean unused2 = oq0.this.f4583c = true;
            this.f4585a.b(oq0.this.f4575a, false);
        }

        public void onFontRetrievalFailed(int reason) {
            boolean unused = oq0.this.f4583c = true;
            this.f4585a.a(reason);
        }
    }

    public void h(Context context, TextPaint textPaint, qq0 callback) {
        p(context, textPaint, e());
        g(context, new b(context, textPaint, callback));
    }

    /* renamed from: oq0$b */
    class b extends qq0 {
        final /* synthetic */ Context a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ TextPaint f4586a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ qq0 f4588a;

        b(Context context, TextPaint textPaint, qq0 qq0) {
            this.a = context;
            this.f4586a = textPaint;
            this.f4588a = qq0;
        }

        public void b(Typeface typeface, boolean fontResolvedSynchronously) {
            oq0.this.p(this.a, this.f4586a, typeface);
            this.f4588a.b(typeface, fontResolvedSynchronously);
        }

        public void a(int i) {
            this.f4588a.a(i);
        }
    }

    public Typeface e() {
        d();
        return this.f4575a;
    }

    private void d() {
        String str;
        if (this.f4575a == null && (str = this.f4576a) != null) {
            this.f4575a = Typeface.create(str, this.f4573a);
        }
        if (this.f4575a == null) {
            switch (this.f4578b) {
                case 1:
                    this.f4575a = Typeface.SANS_SERIF;
                    break;
                case 2:
                    this.f4575a = Typeface.SERIF;
                    break;
                case 3:
                    this.f4575a = Typeface.MONOSPACE;
                    break;
                default:
                    this.f4575a = Typeface.DEFAULT;
                    break;
            }
            this.f4575a = Typeface.create(this.f4575a, this.f4573a);
        }
    }

    public void n(Context context, TextPaint textPaint, qq0 callback) {
        int i;
        int i2;
        o(context, textPaint, callback);
        ColorStateList colorStateList = this.f4584d;
        if (colorStateList != null) {
            i = colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor());
        } else {
            i = ViewCompat.MEASURED_STATE_MASK;
        }
        textPaint.setColor(i);
        float f = this.c;
        float f2 = this.a;
        float f3 = this.b;
        ColorStateList colorStateList2 = this.f4582c;
        if (colorStateList2 != null) {
            i2 = colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor());
        } else {
            i2 = 0;
        }
        textPaint.setShadowLayer(f, f2, f3, i2);
    }

    public void o(Context context, TextPaint textPaint, qq0 callback) {
        if (m(context)) {
            p(context, textPaint, f(context));
        } else {
            h(context, textPaint, callback);
        }
    }

    public void p(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface boldTypeface = at0.a(context, typeface);
        if (boldTypeface != null) {
            typeface = boldTypeface;
        }
        textPaint.setTypeface(typeface);
        int fake = this.f4573a & (~typeface.getStyle());
        textPaint.setFakeBoldText((fake & 1) != 0);
        textPaint.setTextSkewX((fake & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.e);
        if (Build.VERSION.SDK_INT >= 21 && this.f4580b) {
            textPaint.setLetterSpacing(this.d);
        }
    }

    public ColorStateList i() {
        return this.f4584d;
    }

    public void k(ColorStateList textColor) {
        this.f4584d = textColor;
    }

    public float j() {
        return this.e;
    }

    public void l(float textSize) {
        this.e = textSize;
    }

    private boolean m(Context context) {
        Typeface typeface;
        if (pq0.a()) {
            return true;
        }
        int i = this.f4581c;
        if (i != 0) {
            typeface = ResourcesCompat.getCachedFont(context, i);
        } else {
            typeface = null;
        }
        if (typeface != null) {
            return true;
        }
        return false;
    }
}
