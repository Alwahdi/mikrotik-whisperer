package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* renamed from: il0  reason: default package */
public class il0 {
    public static final wc e = new be0(0.5f);
    ai a;

    /* renamed from: a  reason: collision with other field name */
    wc f3246a;

    /* renamed from: a  reason: collision with other field name */
    xc f3247a;
    ai b;

    /* renamed from: b  reason: collision with other field name */
    wc f3248b;

    /* renamed from: b  reason: collision with other field name */
    xc f3249b;
    ai c;

    /* renamed from: c  reason: collision with other field name */
    wc f3250c;

    /* renamed from: c  reason: collision with other field name */
    xc f3251c;
    ai d;

    /* renamed from: d  reason: collision with other field name */
    wc f3252d;

    /* renamed from: d  reason: collision with other field name */
    xc f3253d;

    /* renamed from: il0$c */
    public interface c {
        wc a(wc wcVar);
    }

    /* renamed from: il0$b */
    public static final class b {
        /* access modifiers changed from: private */
        public ai a = q00.c();
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public wc f3254a = new f(0.0f);
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public xc f3255a = q00.b();
        /* access modifiers changed from: private */
        public ai b = q00.c();
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with other field name */
        public wc f3256b = new f(0.0f);
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with other field name */
        public xc f3257b = q00.b();
        /* access modifiers changed from: private */
        public ai c = q00.c();
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with other field name */
        public wc f3258c = new f(0.0f);
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with other field name */
        public xc f3259c = q00.b();
        /* access modifiers changed from: private */
        public ai d = q00.c();
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with other field name */
        public wc f3260d = new f(0.0f);
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with other field name */
        public xc f3261d = q00.b();

        public b() {
        }

        public b(il0 other) {
            this.f3255a = other.f3247a;
            this.f3257b = other.f3249b;
            this.f3259c = other.f3251c;
            this.f3261d = other.f3253d;
            this.f3254a = other.f3246a;
            this.f3256b = other.f3248b;
            this.f3258c = other.f3250c;
            this.f3260d = other.f3252d;
            this.a = other.a;
            this.b = other.b;
            this.c = other.c;
            this.d = other.d;
        }

        public b p(wc cornerSize) {
            return B(cornerSize).F(cornerSize).x(cornerSize).t(cornerSize);
        }

        public b o(float cornerSize) {
            return A(cornerSize).E(cornerSize).w(cornerSize).s(cornerSize);
        }

        public b A(float cornerSize) {
            this.f3254a = new f(cornerSize);
            return this;
        }

        public b B(wc cornerSize) {
            this.f3254a = cornerSize;
            return this;
        }

        public b E(float cornerSize) {
            this.f3256b = new f(cornerSize);
            return this;
        }

        public b F(wc cornerSize) {
            this.f3256b = cornerSize;
            return this;
        }

        public b w(float cornerSize) {
            this.f3258c = new f(cornerSize);
            return this;
        }

        public b x(wc cornerSize) {
            this.f3258c = cornerSize;
            return this;
        }

        public b s(float cornerSize) {
            this.f3260d = new f(cornerSize);
            return this;
        }

        public b t(wc cornerSize) {
            this.f3260d = cornerSize;
            return this;
        }

        public b y(int cornerFamily, wc cornerSize) {
            return z(q00.a(cornerFamily)).B(cornerSize);
        }

        public b z(xc topLeftCorner) {
            this.f3255a = topLeftCorner;
            float size = n(topLeftCorner);
            if (size != -1.0f) {
                A(size);
            }
            return this;
        }

        public b C(int cornerFamily, wc cornerSize) {
            return D(q00.a(cornerFamily)).F(cornerSize);
        }

        public b D(xc topRightCorner) {
            this.f3257b = topRightCorner;
            float size = n(topRightCorner);
            if (size != -1.0f) {
                E(size);
            }
            return this;
        }

        public b u(int cornerFamily, wc cornerSize) {
            return v(q00.a(cornerFamily)).x(cornerSize);
        }

        public b v(xc bottomRightCorner) {
            this.f3259c = bottomRightCorner;
            float size = n(bottomRightCorner);
            if (size != -1.0f) {
                w(size);
            }
            return this;
        }

        public b q(int cornerFamily, wc cornerSize) {
            return r(q00.a(cornerFamily)).t(cornerSize);
        }

        public b r(xc bottomLeftCorner) {
            this.f3261d = bottomLeftCorner;
            float size = n(bottomLeftCorner);
            if (size != -1.0f) {
                s(size);
            }
            return this;
        }

        private static float n(xc treatment) {
            if (treatment instanceof af0) {
                return ((af0) treatment).a;
            }
            if (treatment instanceof ke) {
                return ((ke) treatment).a;
            }
            return -1.0f;
        }

        public il0 m() {
            return new il0(this);
        }
    }

    public static b a() {
        return new b();
    }

    public static b e(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        return f(context, attrs, defStyleAttr, defStyleRes, 0);
    }

    public static b f(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes, int defaultCornerSize) {
        return g(context, attrs, defStyleAttr, defStyleRes, new f((float) defaultCornerSize));
    }

    public static b g(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes, wc defaultCornerSize) {
        TypedArray a2 = context.obtainStyledAttributes(attrs, xc0.f5608F0, defStyleAttr, defStyleRes);
        int shapeAppearanceResId = a2.getResourceId(xc0.k3, 0);
        int shapeAppearanceOverlayResId = a2.getResourceId(xc0.l3, 0);
        a2.recycle();
        return d(context, shapeAppearanceResId, shapeAppearanceOverlayResId, defaultCornerSize);
    }

    public static b b(Context context, int shapeAppearanceResId, int shapeAppearanceOverlayResId) {
        return c(context, shapeAppearanceResId, shapeAppearanceOverlayResId, 0);
    }

    private static b c(Context context, int shapeAppearanceResId, int shapeAppearanceOverlayResId, int defaultCornerSize) {
        return d(context, shapeAppearanceResId, shapeAppearanceOverlayResId, new f((float) defaultCornerSize));
    }

    private static b d(Context context, int shapeAppearanceResId, int shapeAppearanceOverlayResId, wc defaultCornerSize) {
        Context context2 = new ContextThemeWrapper(context, shapeAppearanceResId);
        if (shapeAppearanceOverlayResId != 0) {
            context2 = new ContextThemeWrapper(context2, shapeAppearanceOverlayResId);
        }
        TypedArray a2 = context2.obtainStyledAttributes(xc0.f5692l1);
        try {
            int cornerFamily = a2.getInt(xc0.A3, 0);
            int cornerFamilyTopLeft = a2.getInt(xc0.D3, cornerFamily);
            int cornerFamilyTopRight = a2.getInt(xc0.E3, cornerFamily);
            int cornerFamilyBottomRight = a2.getInt(xc0.C3, cornerFamily);
            int cornerFamilyBottomLeft = a2.getInt(xc0.B3, cornerFamily);
            wc cornerSize = m(a2, xc0.F3, defaultCornerSize);
            wc cornerSizeTopLeft = m(a2, xc0.I3, cornerSize);
            wc cornerSizeTopRight = m(a2, xc0.J3, cornerSize);
            wc cornerSizeBottomRight = m(a2, xc0.H3, cornerSize);
            return new b().y(cornerFamilyTopLeft, cornerSizeTopLeft).C(cornerFamilyTopRight, cornerSizeTopRight).u(cornerFamilyBottomRight, cornerSizeBottomRight).q(cornerFamilyBottomLeft, m(a2, xc0.G3, cornerSize));
        } finally {
            a2.recycle();
        }
    }

    private static wc m(TypedArray a2, int index, wc defaultValue) {
        TypedValue value = a2.peekValue(index);
        if (value == null) {
            return defaultValue;
        }
        int i = value.type;
        if (i == 5) {
            return new f((float) TypedValue.complexToDimensionPixelSize(value.data, a2.getResources().getDisplayMetrics()));
        }
        if (i == 6) {
            return new be0(value.getFraction(1.0f, 1.0f));
        }
        return defaultValue;
    }

    private il0(b builder) {
        this.f3247a = builder.f3255a;
        this.f3249b = builder.f3257b;
        this.f3251c = builder.f3259c;
        this.f3253d = builder.f3261d;
        this.f3246a = builder.f3254a;
        this.f3248b = builder.f3256b;
        this.f3250c = builder.f3258c;
        this.f3252d = builder.f3260d;
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
    }

    public il0() {
        this.f3247a = q00.b();
        this.f3249b = q00.b();
        this.f3251c = q00.b();
        this.f3253d = q00.b();
        this.f3246a = new f(0.0f);
        this.f3248b = new f(0.0f);
        this.f3250c = new f(0.0f);
        this.f3252d = new f(0.0f);
        this.a = q00.c();
        this.b = q00.c();
        this.c = q00.c();
        this.d = q00.c();
    }

    public xc q() {
        return this.f3247a;
    }

    public xc s() {
        return this.f3249b;
    }

    public xc k() {
        return this.f3251c;
    }

    public xc i() {
        return this.f3253d;
    }

    public wc r() {
        return this.f3246a;
    }

    public wc t() {
        return this.f3248b;
    }

    public wc l() {
        return this.f3250c;
    }

    public wc j() {
        return this.f3252d;
    }

    public ai n() {
        return this.d;
    }

    public ai p() {
        return this.a;
    }

    public ai o() {
        return this.b;
    }

    public ai h() {
        return this.c;
    }

    public b v() {
        return new b(this);
    }

    public il0 w(float cornerSize) {
        return v().o(cornerSize).m();
    }

    public il0 x(wc cornerSize) {
        return v().p(cornerSize).m();
    }

    public il0 y(c op) {
        return v().B(op.a(r())).F(op.a(t())).t(op.a(j())).x(op.a(l())).m();
    }

    public boolean u(RectF bounds) {
        Class<ai> cls = ai.class;
        boolean hasDefaultEdges = this.d.getClass().equals(cls) && this.b.getClass().equals(cls) && this.a.getClass().equals(cls) && this.c.getClass().equals(cls);
        float cornerSize = this.f3246a.a(bounds);
        boolean cornersHaveSameSize = this.f3248b.a(bounds) == cornerSize && this.f3252d.a(bounds) == cornerSize && this.f3250c.a(bounds) == cornerSize;
        boolean hasRoundedCorners = (this.f3249b instanceof af0) && (this.f3247a instanceof af0) && (this.f3251c instanceof af0) && (this.f3253d instanceof af0);
        if (!hasDefaultEdges || !cornersHaveSameSize || !hasRoundedCorners) {
            return false;
        }
        return true;
    }
}
