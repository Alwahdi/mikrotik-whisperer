package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import defpackage.q5;
import defpackage.rq0;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;

/* renamed from: p5  reason: default package */
public class p5 extends Drawable implements rq0.b {
    private static final int b = uc0.Widget_MaterialComponents_Badge;
    private static final int c = yb0.badgeStyle;
    private float a;

    /* renamed from: a  reason: collision with other field name */
    private int f4668a;

    /* renamed from: a  reason: collision with other field name */
    private final Rect f4669a = new Rect();

    /* renamed from: a  reason: collision with other field name */
    private final WeakReference<Context> f4670a;

    /* renamed from: a  reason: collision with other field name */
    private final p00 f4671a;

    /* renamed from: a  reason: collision with other field name */
    private final q5 f4672a;

    /* renamed from: a  reason: collision with other field name */
    private final rq0 f4673a;

    /* renamed from: b  reason: collision with other field name */
    private float f4674b;

    /* renamed from: b  reason: collision with other field name */
    private WeakReference<View> f4675b;

    /* renamed from: c  reason: collision with other field name */
    private float f4676c;

    /* renamed from: c  reason: collision with other field name */
    private WeakReference<FrameLayout> f4677c;
    private float d;
    private float e;

    public static p5 d(Context context) {
        return new p5(context, 0, c, b, (q5.a) null);
    }

    private void J() {
        boolean visible = this.f4672a.F();
        setVisible(visible, false);
        if (r5.a && i() != null && !visible) {
            ((ViewGroup) i().getParent()).invalidate();
        }
    }

    private void K() {
        F();
        G();
        I();
        D();
        B();
        C();
        H();
        E();
        O();
        J();
    }

    private p5(Context context, int badgeResId, int defStyleAttr, int defStyleRes, q5.a savedState) {
        int i;
        int i2;
        this.f4670a = new WeakReference<>(context);
        vq0.c(context);
        rq0 rq0 = new rq0(this);
        this.f4673a = rq0;
        rq0.g().setTextAlign(Paint.Align.CENTER);
        q5 q5Var = new q5(context, badgeResId, defStyleAttr, defStyleRes, savedState);
        this.f4672a = q5Var;
        if (x()) {
            i = q5Var.m();
        } else {
            i = q5Var.i();
        }
        if (x()) {
            i2 = q5Var.l();
        } else {
            i2 = q5Var.h();
        }
        this.f4671a = new p00(il0.b(context, i, i2).m());
        K();
    }

    public void N(View anchorView, FrameLayout customBadgeParent) {
        this.f4675b = new WeakReference<>(anchorView);
        boolean z = r5.a;
        if (!z || customBadgeParent != null) {
            this.f4677c = new WeakReference<>(customBadgeParent);
        } else {
            L(anchorView);
        }
        if (!z) {
            M(anchorView);
        }
        O();
        invalidateSelf();
    }

    private boolean A() {
        View customBadgeAnchorParent = i();
        return customBadgeAnchorParent != null && customBadgeAnchorParent.getId() == ic0.mtrl_anchor_parent;
    }

    public FrameLayout i() {
        WeakReference<FrameLayout> weakReference = this.f4677c;
        if (weakReference != null) {
            return (FrameLayout) weakReference.get();
        }
        return null;
    }

    private void L(View anchorView) {
        ViewGroup anchorViewParent = (ViewGroup) anchorView.getParent();
        if (anchorViewParent == null || anchorViewParent.getId() != ic0.mtrl_anchor_parent) {
            WeakReference<FrameLayout> weakReference = this.f4677c;
            if (weakReference == null || weakReference.get() != anchorViewParent) {
                M(anchorView);
                FrameLayout frameLayout = new FrameLayout(anchorView.getContext());
                frameLayout.setId(ic0.mtrl_anchor_parent);
                frameLayout.setClipChildren(false);
                frameLayout.setClipToPadding(false);
                frameLayout.setLayoutParams(anchorView.getLayoutParams());
                frameLayout.setMinimumWidth(anchorView.getWidth());
                frameLayout.setMinimumHeight(anchorView.getHeight());
                int anchorIndex = anchorViewParent.indexOfChild(anchorView);
                anchorViewParent.removeViewAt(anchorIndex);
                anchorView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.addView(anchorView);
                anchorViewParent.addView(frameLayout, anchorIndex);
                this.f4677c = new WeakReference<>(frameLayout);
                frameLayout.post(new a(anchorView, frameLayout));
            }
        }
    }

    /* renamed from: p5$a */
    class a implements Runnable {
        final /* synthetic */ View a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ FrameLayout f4678a;

        a(View view, FrameLayout frameLayout) {
            this.a = view;
            this.f4678a = frameLayout;
        }

        public void run() {
            p5.this.N(this.a, this.f4678a);
        }
    }

    private static void M(View anchorView) {
        ViewGroup anchorViewParent = (ViewGroup) anchorView.getParent();
        anchorViewParent.setClipChildren(false);
        anchorViewParent.setClipToPadding(false);
    }

    private void C() {
        ColorStateList backgroundColorStateList = ColorStateList.valueOf(this.f4672a.e());
        if (this.f4671a.v() != backgroundColorStateList) {
            this.f4671a.V(backgroundColorStateList);
            invalidateSelf();
        }
    }

    private void H() {
        this.f4673a.g().setColor(this.f4672a.j());
        invalidateSelf();
    }

    public boolean y() {
        return !this.f4672a.D() && this.f4672a.C();
    }

    public int n() {
        if (this.f4672a.C()) {
            return this.f4672a.w();
        }
        return 0;
    }

    public boolean z() {
        return this.f4672a.D();
    }

    public String r() {
        return this.f4672a.y();
    }

    public int l() {
        return this.f4672a.u();
    }

    public int m() {
        return this.f4672a.v();
    }

    private void I() {
        P();
        this.f4673a.l(true);
        O();
        invalidateSelf();
    }

    private void E() {
        WeakReference<View> weakReference = this.f4675b;
        if (weakReference != null && weakReference.get() != null) {
            View view = (View) this.f4675b.get();
            WeakReference<FrameLayout> weakReference2 = this.f4677c;
            N(view, weakReference2 != null ? (FrameLayout) weakReference2.get() : null);
        }
    }

    public boolean isStateful() {
        return false;
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getAlpha() {
        return this.f4672a.d();
    }

    public void setAlpha(int alpha) {
        this.f4672a.H(alpha);
        B();
    }

    private void B() {
        this.f4673a.g().setAlpha(getAlpha());
        invalidateSelf();
    }

    public int getOpacity() {
        return -3;
    }

    public int getIntrinsicHeight() {
        return this.f4669a.height();
    }

    public int getIntrinsicWidth() {
        return this.f4669a.width();
    }

    public void draw(Canvas canvas) {
        if (!getBounds().isEmpty() && getAlpha() != 0 && isVisible()) {
            this.f4671a.draw(canvas);
            if (x()) {
                e(canvas);
            }
        }
    }

    public void a() {
        invalidateSelf();
    }

    public boolean onStateChange(int[] state) {
        return super.onStateChange(state);
    }

    public CharSequence h() {
        if (!isVisible()) {
            return null;
        }
        if (z()) {
            return t();
        }
        if (y()) {
            return p();
        }
        return j();
    }

    private String p() {
        Context context;
        if (this.f4672a.q() == 0 || (context = (Context) this.f4670a.get()) == null) {
            return null;
        }
        if (this.f4668a == -2 || n() <= this.f4668a) {
            return context.getResources().getQuantityString(this.f4672a.q(), n(), new Object[]{Integer.valueOf(n())});
        }
        return context.getString(this.f4672a.n(), new Object[]{Integer.valueOf(this.f4668a)});
    }

    private CharSequence t() {
        CharSequence contentDescription = this.f4672a.o();
        if (contentDescription != null) {
            return contentDescription;
        }
        return r();
    }

    private CharSequence j() {
        return this.f4672a.p();
    }

    private void G() {
        oq0 textAppearance;
        Context context = (Context) this.f4670a.get();
        if (context != null && this.f4673a.e() != (textAppearance = new oq0(context, this.f4672a.z()))) {
            this.f4673a.k(textAppearance, context);
            H();
            O();
            invalidateSelf();
        }
    }

    private void F() {
        int i;
        int i2;
        Context context = (Context) this.f4670a.get();
        if (context != null) {
            p00 p00 = this.f4671a;
            if (x()) {
                i = this.f4672a.m();
            } else {
                i = this.f4672a.i();
            }
            if (x()) {
                i2 = this.f4672a.l();
            } else {
                i2 = this.f4672a.h();
            }
            p00.setShapeAppearanceModel(il0.b(context, i, i2).m());
            invalidateSelf();
        }
    }

    private void O() {
        Context context = (Context) this.f4670a.get();
        WeakReference<View> weakReference = this.f4675b;
        ViewGroup customBadgeParent = null;
        View anchorView = weakReference != null ? (View) weakReference.get() : null;
        if (context != null && anchorView != null) {
            Rect tmpRect = new Rect();
            tmpRect.set(this.f4669a);
            Rect anchorRect = new Rect();
            anchorView.getDrawingRect(anchorRect);
            WeakReference<FrameLayout> weakReference2 = this.f4677c;
            if (weakReference2 != null) {
                customBadgeParent = (ViewGroup) weakReference2.get();
            }
            if (customBadgeParent != null || r5.a) {
                (customBadgeParent == null ? (ViewGroup) anchorView.getParent() : customBadgeParent).offsetDescendantRectToMyCoords(anchorView, anchorRect);
            }
            c(anchorRect, anchorView);
            r5.d(this.f4669a, this.a, this.f4674b, this.d, this.e);
            float f = this.f4676c;
            if (f != -1.0f) {
                this.f4671a.S(f);
            }
            if (!tmpRect.equals(this.f4669a)) {
                this.f4671a.setBounds(this.f4669a);
            }
        }
    }

    private int w() {
        int vOffset = this.f4672a.B();
        if (x()) {
            vOffset = this.f4672a.A();
            Context context = (Context) this.f4670a.get();
            if (context != null) {
                vOffset = f3.c(vOffset, vOffset - this.f4672a.t(), f3.b(0.0f, 1.0f, 0.3f, 1.0f, o00.e(context) - 1.0f));
            }
        }
        if (this.f4672a.f4756c == 0) {
            vOffset -= Math.round(this.e);
        }
        return this.f4672a.c() + vOffset;
    }

    private int v() {
        int hOffset;
        if (x()) {
            hOffset = this.f4672a.r();
        } else {
            hOffset = this.f4672a.s();
        }
        if (this.f4672a.f4756c == 1) {
            hOffset += x() ? this.f4672a.f4754b : this.f4672a.f4752a;
        }
        return this.f4672a.b() + hOffset;
    }

    private void c(Rect anchorRect, View anchorView) {
        float f;
        float f2;
        float f3 = x() ? this.f4672a.b : this.f4672a.a;
        this.f4676c = f3;
        if (f3 != -1.0f) {
            this.d = f3;
            this.e = f3;
        } else {
            this.d = (float) Math.round((x() ? this.f4672a.e : this.f4672a.c) / 2.0f);
            this.e = (float) Math.round((x() ? this.f4672a.f : this.f4672a.d) / 2.0f);
        }
        if (x()) {
            String badgeContent = f();
            this.d = Math.max(this.d, (this.f4673a.h(badgeContent) / 2.0f) + ((float) this.f4672a.g()));
            float max = Math.max(this.e, (this.f4673a.f(badgeContent) / 2.0f) + ((float) this.f4672a.k()));
            this.e = max;
            this.d = Math.max(this.d, max);
        }
        int totalVerticalOffset = w();
        switch (this.f4672a.f()) {
            case 8388691:
            case 8388693:
                this.f4674b = (float) (anchorRect.bottom - totalVerticalOffset);
                break;
            default:
                this.f4674b = (float) (anchorRect.top + totalVerticalOffset);
                break;
        }
        int totalHorizontalOffset = v();
        switch (this.f4672a.f()) {
            case 8388659:
            case 8388691:
                if (ViewCompat.getLayoutDirection(anchorView) == 0) {
                    f = (((float) anchorRect.left) - this.d) + ((float) totalHorizontalOffset);
                } else {
                    f = (((float) anchorRect.right) + this.d) - ((float) totalHorizontalOffset);
                }
                this.a = f;
                break;
            default:
                if (ViewCompat.getLayoutDirection(anchorView) == 0) {
                    f2 = (((float) anchorRect.right) + this.d) - ((float) totalHorizontalOffset);
                } else {
                    f2 = (((float) anchorRect.left) - this.d) + ((float) totalHorizontalOffset);
                }
                this.a = f2;
                break;
        }
        if (this.f4672a.E()) {
            b(anchorView);
        }
    }

    private void b(View anchorView) {
        View anchorParent;
        float anchorXOffset;
        float anchorYOffset;
        View customAnchorParent = i();
        if (customAnchorParent == null) {
            if (anchorView.getParent() instanceof View) {
                anchorYOffset = anchorView.getY();
                anchorXOffset = anchorView.getX();
                anchorParent = (View) anchorView.getParent();
            } else {
                return;
            }
        } else if (!A()) {
            anchorYOffset = 0.0f;
            anchorXOffset = 0.0f;
            anchorParent = customAnchorParent;
        } else if (customAnchorParent.getParent() instanceof View) {
            anchorYOffset = customAnchorParent.getY();
            anchorXOffset = customAnchorParent.getX();
            anchorParent = (View) customAnchorParent.getParent();
        } else {
            return;
        }
        float topCutOff = u(anchorParent, anchorYOffset);
        float leftCutOff = k(anchorParent, anchorXOffset);
        float bottomCutOff = g(anchorParent, anchorYOffset);
        float rightCutOff = q(anchorParent, anchorXOffset);
        if (topCutOff < 0.0f) {
            this.f4674b += Math.abs(topCutOff);
        }
        if (leftCutOff < 0.0f) {
            this.a += Math.abs(leftCutOff);
        }
        if (bottomCutOff > 0.0f) {
            this.f4674b -= Math.abs(bottomCutOff);
        }
        if (rightCutOff > 0.0f) {
            this.a -= Math.abs(rightCutOff);
        }
    }

    private float u(View anchorParent, float anchorViewOffset) {
        return (this.f4674b - this.e) + anchorParent.getY() + anchorViewOffset;
    }

    private float k(View anchorParent, float anchorViewOffset) {
        return (this.a - this.d) + anchorParent.getX() + anchorViewOffset;
    }

    private float g(View anchorParent, float anchorViewOffset) {
        if (anchorParent.getParent() instanceof View) {
            return ((this.f4674b + this.e) - (((float) ((View) anchorParent.getParent()).getHeight()) - anchorParent.getY())) + anchorViewOffset;
        }
        return 0.0f;
    }

    private float q(View anchorParent, float anchorViewOffset) {
        if (anchorParent.getParent() instanceof View) {
            return ((this.a + this.d) - (((float) ((View) anchorParent.getParent()).getWidth()) - anchorParent.getX())) + anchorViewOffset;
        }
        return 0.0f;
    }

    private void e(Canvas canvas) {
        String badgeContent = f();
        if (badgeContent != null) {
            Rect textBounds = new Rect();
            this.f4673a.g().getTextBounds(badgeContent, 0, badgeContent.length(), textBounds);
            float exactCenterY = this.f4674b - textBounds.exactCenterY();
            canvas.drawText(badgeContent, this.a, (float) (textBounds.bottom <= 0 ? (int) exactCenterY : Math.round(exactCenterY)), this.f4673a.g());
        }
    }

    private boolean x() {
        return z() || y();
    }

    private String f() {
        if (z()) {
            return s();
        }
        if (y()) {
            return o();
        }
        return null;
    }

    private String s() {
        String text = r();
        int maxCharacterCount = l();
        if (maxCharacterCount == -2 || text == null || text.length() <= maxCharacterCount) {
            return text;
        }
        Context context = (Context) this.f4670a.get();
        if (context == null) {
            return "";
        }
        String text2 = text.substring(0, maxCharacterCount - 1);
        return String.format(context.getString(sc0.m3_exceed_max_badge_text_suffix), new Object[]{text2, "…"});
    }

    private String o() {
        if (this.f4668a == -2 || n() <= this.f4668a) {
            return NumberFormat.getInstance(this.f4672a.x()).format((long) n());
        }
        Context context = (Context) this.f4670a.get();
        if (context == null) {
            return "";
        }
        return String.format(this.f4672a.x(), context.getString(sc0.mtrl_exceed_max_badge_number_suffix), new Object[]{Integer.valueOf(this.f4668a), "+"});
    }

    private void D() {
        this.f4673a.l(true);
        F();
        O();
        invalidateSelf();
    }

    private void P() {
        if (l() != -2) {
            this.f4668a = ((int) Math.pow(10.0d, ((double) l()) - 1.0d)) - 1;
        } else {
            this.f4668a = m();
        }
    }
}
