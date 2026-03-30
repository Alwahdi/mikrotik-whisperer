package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.TintAwareDrawable;

/* renamed from: xe0  reason: default package */
public class xe0 extends Drawable implements ll0, TintAwareDrawable {
    private b a;

    public xe0(il0 shapeAppearanceModel) {
        this(new b(new p00(shapeAppearanceModel)));
    }

    private xe0(b state) {
        this.a = state;
    }

    public void setTint(int tintColor) {
        this.a.a.setTint(tintColor);
    }

    public void setTintMode(PorterDuff.Mode tintMode) {
        this.a.a.setTintMode(tintMode);
    }

    public void setTintList(ColorStateList tintList) {
        this.a.a.setTintList(tintList);
    }

    public void setShapeAppearanceModel(il0 shapeAppearanceModel) {
        this.a.a.setShapeAppearanceModel(shapeAppearanceModel);
    }

    public boolean isStateful() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] stateSet) {
        boolean changed = super.onStateChange(stateSet);
        if (this.a.a.setState(stateSet)) {
            changed = true;
        }
        boolean shouldDrawRipple = ye0.f(stateSet);
        b bVar = this.a;
        if (bVar.f5741a == shouldDrawRipple) {
            return changed;
        }
        bVar.f5741a = shouldDrawRipple;
        return true;
    }

    public void draw(Canvas canvas) {
        b bVar = this.a;
        if (bVar.f5741a) {
            bVar.a.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        this.a.a.setBounds(bounds);
    }

    public Drawable.ConstantState getConstantState() {
        return this.a;
    }

    /* renamed from: a */
    public xe0 mutate() {
        this.a = new b(this.a);
        return this;
    }

    public void setAlpha(int alpha) {
        this.a.a.setAlpha(alpha);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.a.a.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return this.a.a.getOpacity();
    }

    /* renamed from: xe0$b */
    static final class b extends Drawable.ConstantState {
        p00 a;

        /* renamed from: a  reason: collision with other field name */
        boolean f5741a;

        public b(p00 delegate) {
            this.a = delegate;
            this.f5741a = false;
        }

        public b(b orig) {
            this.a = (p00) orig.a.getConstantState().newDrawable();
            this.f5741a = orig.f5741a;
        }

        /* renamed from: a */
        public xe0 newDrawable() {
            return new xe0(new b(this));
        }

        public int getChangingConfigurations() {
            return 0;
        }
    }
}
