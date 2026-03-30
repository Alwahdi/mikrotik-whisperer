package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import defpackage.il0;
import defpackage.jl0;
import defpackage.kl0;
import java.util.BitSet;

/* renamed from: p00  reason: default package */
public class p00 extends Drawable implements TintAwareDrawable, ll0 {
    private static final String a = p00.class.getSimpleName();
    private static final Paint c;

    /* renamed from: a  reason: collision with other field name */
    private int f4615a;

    /* renamed from: a  reason: collision with other field name */
    private final Matrix f4616a;

    /* renamed from: a  reason: collision with other field name */
    private final Paint f4617a;

    /* renamed from: a  reason: collision with other field name */
    private final Path f4618a;

    /* renamed from: a  reason: collision with other field name */
    private PorterDuffColorFilter f4619a;

    /* renamed from: a  reason: collision with other field name */
    private final RectF f4620a;

    /* renamed from: a  reason: collision with other field name */
    private final Region f4621a;

    /* renamed from: a  reason: collision with other field name */
    private final gl0 f4622a;

    /* renamed from: a  reason: collision with other field name */
    private il0 f4623a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final BitSet f4624a;

    /* renamed from: a  reason: collision with other field name */
    private final jl0.b f4625a;

    /* renamed from: a  reason: collision with other field name */
    private final jl0 f4626a;

    /* renamed from: a  reason: collision with other field name */
    private c f4627a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public boolean f4628a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final kl0.g[] f4629a;
    private final Paint b;

    /* renamed from: b  reason: collision with other field name */
    private final Path f4630b;

    /* renamed from: b  reason: collision with other field name */
    private PorterDuffColorFilter f4631b;

    /* renamed from: b  reason: collision with other field name */
    private final RectF f4632b;

    /* renamed from: b  reason: collision with other field name */
    private final Region f4633b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f4634b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public final kl0.g[] f4635b;

    /* renamed from: c  reason: collision with other field name */
    private final RectF f4636c;

    static {
        Paint paint = new Paint(1);
        c = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public static p00 m(Context context, float elevation, ColorStateList backgroundTint) {
        if (backgroundTint == null) {
            backgroundTint = ColorStateList.valueOf(k00.c(context, yb0.colorSurface, p00.class.getSimpleName()));
        }
        p00 materialShapeDrawable = new p00();
        materialShapeDrawable.K(context);
        materialShapeDrawable.V(backgroundTint);
        materialShapeDrawable.U(elevation);
        return materialShapeDrawable;
    }

    public p00() {
        this(new il0());
    }

    public p00(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this(il0.e(context, attrs, defStyleAttr, defStyleRes).m());
    }

    public p00(il0 shapeAppearanceModel) {
        this(new c(shapeAppearanceModel, (di) null));
    }

    protected p00(c drawableState) {
        jl0 jl0;
        this.f4629a = new kl0.g[4];
        this.f4635b = new kl0.g[4];
        this.f4624a = new BitSet(8);
        this.f4616a = new Matrix();
        this.f4618a = new Path();
        this.f4630b = new Path();
        this.f4620a = new RectF();
        this.f4632b = new RectF();
        this.f4621a = new Region();
        this.f4633b = new Region();
        Paint paint = new Paint(1);
        this.f4617a = paint;
        Paint paint2 = new Paint(1);
        this.b = paint2;
        this.f4622a = new gl0();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            jl0 = jl0.k();
        } else {
            jl0 = new jl0();
        }
        this.f4626a = jl0;
        this.f4636c = new RectF();
        this.f4634b = true;
        this.f4627a = drawableState;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        g0();
        f0(getState());
        this.f4625a = new a();
    }

    /* renamed from: p00$a */
    class a implements jl0.b {
        a() {
        }

        public void a(kl0 cornerPath, Matrix transform, int count) {
            p00.this.f4624a.set(count, cornerPath.e());
            p00.this.f4629a[count] = cornerPath.f(transform);
        }

        public void b(kl0 edgePath, Matrix transform, int count) {
            p00.this.f4624a.set(count + 4, edgePath.e());
            p00.this.f4635b[count] = edgePath.f(transform);
        }
    }

    public Drawable.ConstantState getConstantState() {
        return this.f4627a;
    }

    public Drawable mutate() {
        this.f4627a = new c(this.f4627a);
        return this;
    }

    private static int P(int paintAlpha, int alpha) {
        return (paintAlpha * ((alpha >>> 7) + alpha)) >>> 8;
    }

    public void setShapeAppearanceModel(il0 shapeAppearanceModel) {
        this.f4627a.f4645a = shapeAppearanceModel;
        invalidateSelf();
    }

    public il0 B() {
        return this.f4627a.f4645a;
    }

    public void V(ColorStateList fillColor) {
        c cVar = this.f4627a;
        if (cVar.f4639a != fillColor) {
            cVar.f4639a = fillColor;
            onStateChange(getState());
        }
    }

    public ColorStateList v() {
        return this.f4627a.f4639a;
    }

    public void d0(ColorStateList strokeColor) {
        c cVar = this.f4627a;
        if (cVar.f4648b != strokeColor) {
            cVar.f4648b = strokeColor;
            onStateChange(getState());
        }
    }

    public void setTintMode(PorterDuff.Mode tintMode) {
        c cVar = this.f4627a;
        if (cVar.f4642a != tintMode) {
            cVar.f4642a = tintMode;
            g0();
            L();
        }
    }

    public void setTintList(ColorStateList tintList) {
        this.f4627a.f4652d = tintList;
        g0();
        L();
    }

    public void setTint(int tintColor) {
        setTintList(ColorStateList.valueOf(tintColor));
    }

    public void b0(float strokeWidth, int strokeColor) {
        e0(strokeWidth);
        d0(ColorStateList.valueOf(strokeColor));
    }

    public void c0(float strokeWidth, ColorStateList strokeColor) {
        e0(strokeWidth);
        d0(strokeColor);
    }

    public void e0(float strokeWidth) {
        this.f4627a.c = strokeWidth;
        invalidateSelf();
    }

    public int y() {
        return this.f4615a;
    }

    public int getOpacity() {
        return -3;
    }

    public int getAlpha() {
        return this.f4627a.f4638a;
    }

    public void setAlpha(int alpha) {
        c cVar = this.f4627a;
        if (cVar.f4638a != alpha) {
            cVar.f4638a = alpha;
            L();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f4627a.f4640a = colorFilter;
        L();
    }

    public Region getTransparentRegion() {
        this.f4621a.set(getBounds());
        g(s(), this.f4618a);
        this.f4633b.setPath(this.f4618a, this.f4621a);
        this.f4621a.op(this.f4633b, Region.Op.DIFFERENCE);
        return this.f4621a;
    }

    /* access modifiers changed from: protected */
    public RectF s() {
        this.f4620a.set(getBounds());
        return this.f4620a;
    }

    public void S(float cornerSize) {
        setShapeAppearanceModel(this.f4627a.f4645a.w(cornerSize));
    }

    public void T(wc cornerSize) {
        setShapeAppearanceModel(this.f4627a.f4645a.x(cornerSize));
    }

    public boolean getPadding(Rect padding) {
        Rect rect = this.f4627a.f4643a;
        if (rect == null) {
            return super.getPadding(padding);
        }
        padding.set(rect);
        return true;
    }

    public void X(int left, int top, int right, int bottom) {
        c cVar = this.f4627a;
        if (cVar.f4643a == null) {
            cVar.f4643a = new Rect();
        }
        this.f4627a.f4643a.set(left, top, right, bottom);
        invalidateSelf();
    }

    public boolean M() {
        di diVar = this.f4627a.f4644a;
        return diVar != null && diVar.e();
    }

    public void K(Context context) {
        this.f4627a.f4644a = new di(context);
        h0();
    }

    /* access modifiers changed from: protected */
    public int l(int backgroundColor) {
        float elevation = G() + x();
        di diVar = this.f4627a.f4644a;
        if (diVar != null) {
            return diVar.c(backgroundColor, elevation);
        }
        return backgroundColor;
    }

    public float w() {
        return this.f4627a.b;
    }

    public void W(float interpolation) {
        c cVar = this.f4627a;
        if (cVar.b != interpolation) {
            cVar.b = interpolation;
            this.f4628a = true;
            invalidateSelf();
        }
    }

    public float x() {
        return this.f4627a.d;
    }

    public void Y(float parentAbsoluteElevation) {
        c cVar = this.f4627a;
        if (cVar.d != parentAbsoluteElevation) {
            cVar.d = parentAbsoluteElevation;
            h0();
        }
    }

    public float u() {
        return this.f4627a.e;
    }

    public void U(float elevation) {
        c cVar = this.f4627a;
        if (cVar.e != elevation) {
            cVar.e = elevation;
            h0();
        }
    }

    public float F() {
        return this.f4627a.f;
    }

    public float G() {
        return u() + F();
    }

    private void h0() {
        float z = G();
        this.f4627a.f4649c = (int) Math.ceil((double) (0.75f * z));
        this.f4627a.f4651d = (int) Math.ceil((double) (0.25f * z));
        g0();
        L();
    }

    public void a0(int shadowRotation) {
        c cVar = this.f4627a;
        if (cVar.f4653e != shadowRotation) {
            cVar.f4653e = shadowRotation;
            L();
        }
    }

    public boolean R() {
        int i = Build.VERSION.SDK_INT;
        return i < 21 || (!N() && !this.f4618a.isConvex() && i < 29);
    }

    public void invalidateSelf() {
        this.f4628a = true;
        super.invalidateSelf();
    }

    private void L() {
        super.invalidateSelf();
    }

    public void Z(int shadowColor) {
        this.f4622a.d(shadowColor);
        this.f4627a.f4646a = false;
        L();
    }

    private boolean H() {
        c cVar = this.f4627a;
        int i = cVar.f4647b;
        if (i == 1 || cVar.f4649c <= 0 || (i != 2 && !R())) {
            return false;
        }
        return true;
    }

    private boolean I() {
        Paint.Style style = this.f4627a.f4641a;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean J() {
        Paint.Style style = this.f4627a.f4641a;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.b.getStrokeWidth() > 0.0f;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect bounds) {
        this.f4628a = true;
        super.onBoundsChange(bounds);
    }

    public void draw(Canvas canvas) {
        this.f4617a.setColorFilter(this.f4619a);
        int prevAlpha = this.f4617a.getAlpha();
        this.f4617a.setAlpha(P(prevAlpha, this.f4627a.f4638a));
        this.b.setColorFilter(this.f4631b);
        this.b.setStrokeWidth(this.f4627a.c);
        int prevStrokeAlpha = this.b.getAlpha();
        this.b.setAlpha(P(prevStrokeAlpha, this.f4627a.f4638a));
        if (this.f4628a) {
            i();
            g(s(), this.f4618a);
            this.f4628a = false;
        }
        O(canvas);
        if (I()) {
            o(canvas);
        }
        if (J()) {
            r(canvas);
        }
        this.f4617a.setAlpha(prevAlpha);
        this.b.setAlpha(prevStrokeAlpha);
    }

    private void O(Canvas canvas) {
        if (H()) {
            canvas.save();
            Q(canvas);
            if (!this.f4634b) {
                n(canvas);
                canvas.restore();
                return;
            }
            int pathExtraWidth = (int) (this.f4636c.width() - ((float) getBounds().width()));
            int pathExtraHeight = (int) (this.f4636c.height() - ((float) getBounds().height()));
            if (pathExtraWidth < 0 || pathExtraHeight < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            Bitmap shadowLayer = Bitmap.createBitmap(((int) this.f4636c.width()) + (this.f4627a.f4649c * 2) + pathExtraWidth, ((int) this.f4636c.height()) + (this.f4627a.f4649c * 2) + pathExtraHeight, Bitmap.Config.ARGB_8888);
            Canvas shadowCanvas = new Canvas(shadowLayer);
            float shadowLeft = (float) ((getBounds().left - this.f4627a.f4649c) - pathExtraWidth);
            float shadowTop = (float) ((getBounds().top - this.f4627a.f4649c) - pathExtraHeight);
            shadowCanvas.translate(-shadowLeft, -shadowTop);
            n(shadowCanvas);
            canvas.drawBitmap(shadowLayer, shadowLeft, shadowTop, (Paint) null);
            shadowLayer.recycle();
            canvas.restore();
        }
    }

    /* access modifiers changed from: protected */
    public void q(Canvas canvas, Paint paint, Path path, RectF bounds) {
        p(canvas, paint, path, this.f4627a.f4645a, bounds);
    }

    private void p(Canvas canvas, Paint paint, Path path, il0 shapeAppearanceModel, RectF bounds) {
        if (shapeAppearanceModel.u(bounds)) {
            float cornerSize = shapeAppearanceModel.t().a(bounds) * this.f4627a.b;
            canvas.drawRoundRect(bounds, cornerSize, cornerSize, paint);
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void o(Canvas canvas) {
        p(canvas, this.f4617a, this.f4618a, this.f4627a.f4645a, s());
    }

    /* access modifiers changed from: protected */
    public void r(Canvas canvas) {
        p(canvas, this.b, this.f4630b, this.f4623a, t());
    }

    private void Q(Canvas canvas) {
        int shadowOffsetX = z();
        int shadowOffsetY = A();
        if (Build.VERSION.SDK_INT < 21 && this.f4634b) {
            Rect canvasClipBounds = canvas.getClipBounds();
            int i = this.f4627a.f4649c;
            canvasClipBounds.inset(-i, -i);
            canvasClipBounds.offset(shadowOffsetX, shadowOffsetY);
            canvas.clipRect(canvasClipBounds, Region.Op.REPLACE);
        }
        canvas.translate((float) shadowOffsetX, (float) shadowOffsetY);
    }

    private void n(Canvas canvas) {
        if (this.f4624a.cardinality() > 0) {
            Log.w(a, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f4627a.f4651d != 0) {
            canvas.drawPath(this.f4618a, this.f4622a.c());
        }
        for (int index = 0; index < 4; index++) {
            this.f4629a[index].a(this.f4622a, this.f4627a.f4649c, canvas);
            this.f4635b[index].a(this.f4622a, this.f4627a.f4649c, canvas);
        }
        if (this.f4634b != 0) {
            int shadowOffsetX = z();
            int shadowOffsetY = A();
            canvas.translate((float) (-shadowOffsetX), (float) (-shadowOffsetY));
            canvas.drawPath(this.f4618a, c);
            canvas.translate((float) shadowOffsetX, (float) shadowOffsetY);
        }
    }

    public int z() {
        c cVar = this.f4627a;
        return (int) (((double) cVar.f4651d) * Math.sin(Math.toRadians((double) cVar.f4653e)));
    }

    public int A() {
        c cVar = this.f4627a;
        return (int) (((double) cVar.f4651d) * Math.cos(Math.toRadians((double) cVar.f4653e)));
    }

    /* access modifiers changed from: protected */
    public final void h(RectF bounds, Path path) {
        jl0 jl0 = this.f4626a;
        c cVar = this.f4627a;
        il0 il0 = cVar.f4645a;
        float f = cVar.b;
        jl0.d(il0, f, bounds, this.f4625a, path);
    }

    private void i() {
        il0 y = B().y(new b(-C()));
        this.f4623a = y;
        this.f4626a.e(y, this.f4627a.b, t(), this.f4630b);
    }

    /* renamed from: p00$b */
    class b implements il0.c {
        final /* synthetic */ float a;

        b(float f) {
            this.a = f;
        }

        public wc a(wc cornerSize) {
            if (cornerSize instanceof be0) {
                return cornerSize;
            }
            return new e2(this.a, cornerSize);
        }
    }

    public void getOutline(Outline outline) {
        if (this.f4627a.f4647b != 2) {
            if (N()) {
                outline.setRoundRect(getBounds(), D() * this.f4627a.b);
                return;
            }
            g(s(), this.f4618a);
            yh.j(outline, this.f4618a);
        }
    }

    private void g(RectF bounds, Path path) {
        h(bounds, path);
        if (this.f4627a.a != 1.0f) {
            this.f4616a.reset();
            Matrix matrix = this.f4616a;
            float f = this.f4627a.a;
            matrix.setScale(f, f, bounds.width() / 2.0f, bounds.height() / 2.0f);
            path.transform(this.f4616a);
        }
        path.computeBounds(this.f4636c, true);
    }

    private boolean g0() {
        PorterDuffColorFilter originalTintFilter = this.f4619a;
        PorterDuffColorFilter originalStrokeTintFilter = this.f4631b;
        c cVar = this.f4627a;
        this.f4619a = k(cVar.f4652d, cVar.f4642a, this.f4617a, true);
        c cVar2 = this.f4627a;
        this.f4631b = k(cVar2.f4650c, cVar2.f4642a, this.b, false);
        c cVar3 = this.f4627a;
        if (cVar3.f4646a) {
            this.f4622a.d(cVar3.f4652d.getColorForState(getState(), 0));
        }
        if (!ObjectsCompat.equals(originalTintFilter, this.f4619a) || !ObjectsCompat.equals(originalStrokeTintFilter, this.f4631b)) {
            return true;
        }
        return false;
    }

    private PorterDuffColorFilter k(ColorStateList tintList, PorterDuff.Mode tintMode, Paint paint, boolean requiresElevationOverlay) {
        if (tintList == null || tintMode == null) {
            return f(paint, requiresElevationOverlay);
        }
        return j(tintList, tintMode, requiresElevationOverlay);
    }

    private PorterDuffColorFilter f(Paint paint, boolean requiresElevationOverlay) {
        if (!requiresElevationOverlay) {
            return null;
        }
        int paintColor = paint.getColor();
        int tintColor = l(paintColor);
        this.f4615a = tintColor;
        if (tintColor != paintColor) {
            return new PorterDuffColorFilter(tintColor, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    private PorterDuffColorFilter j(ColorStateList tintList, PorterDuff.Mode tintMode, boolean requiresElevationOverlay) {
        int tintColor = tintList.getColorForState(getState(), 0);
        if (requiresElevationOverlay) {
            tintColor = l(tintColor);
        }
        this.f4615a = tintColor;
        return new PorterDuffColorFilter(tintColor, tintMode);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        r0 = r1.f4627a.f4648b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        r0 = r1.f4627a.f4639a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.f4627a.f4652d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r0 = r1.f4627a.f4650c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            boolean r0 = super.isStateful()
            if (r0 != 0) goto L_0x0039
            p00$c r0 = r1.f4627a
            android.content.res.ColorStateList r0 = r0.f4652d
            if (r0 == 0) goto L_0x0012
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x0039
        L_0x0012:
            p00$c r0 = r1.f4627a
            android.content.res.ColorStateList r0 = r0.f4650c
            if (r0 == 0) goto L_0x001e
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x0039
        L_0x001e:
            p00$c r0 = r1.f4627a
            android.content.res.ColorStateList r0 = r0.f4648b
            if (r0 == 0) goto L_0x002a
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x0039
        L_0x002a:
            p00$c r0 = r1.f4627a
            android.content.res.ColorStateList r0 = r0.f4639a
            if (r0 == 0) goto L_0x0037
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            r0 = 0
            goto L_0x003a
        L_0x0039:
            r0 = 1
        L_0x003a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.p00.isStateful():boolean");
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] state) {
        boolean invalidateSelf = f0(state) || g0();
        if (invalidateSelf) {
            invalidateSelf();
        }
        return invalidateSelf;
    }

    private boolean f0(int[] state) {
        int previousStrokeColor;
        int newStrokeColor;
        int previousFillColor;
        int newFillColor;
        boolean invalidateSelf = false;
        if (!(this.f4627a.f4639a == null || (previousFillColor = this.f4617a.getColor()) == (newFillColor = this.f4627a.f4639a.getColorForState(state, previousFillColor)))) {
            this.f4617a.setColor(newFillColor);
            invalidateSelf = true;
        }
        if (this.f4627a.f4648b == null || (previousStrokeColor = this.b.getColor()) == (newStrokeColor = this.f4627a.f4648b.getColorForState(state, previousStrokeColor))) {
            return invalidateSelf;
        }
        this.b.setColor(newStrokeColor);
        return true;
    }

    private float C() {
        if (J()) {
            return this.b.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private RectF t() {
        this.f4632b.set(s());
        float inset = C();
        this.f4632b.inset(inset, inset);
        return this.f4632b;
    }

    public float D() {
        return this.f4627a.f4645a.r().a(s());
    }

    public float E() {
        return this.f4627a.f4645a.t().a(s());
    }

    public boolean N() {
        return this.f4627a.f4645a.u(s());
    }

    /* renamed from: p00$c */
    protected static class c extends Drawable.ConstantState {
        float a = 1.0f;

        /* renamed from: a  reason: collision with other field name */
        int f4638a = 255;

        /* renamed from: a  reason: collision with other field name */
        ColorStateList f4639a = null;

        /* renamed from: a  reason: collision with other field name */
        ColorFilter f4640a;

        /* renamed from: a  reason: collision with other field name */
        Paint.Style f4641a = Paint.Style.FILL_AND_STROKE;

        /* renamed from: a  reason: collision with other field name */
        PorterDuff.Mode f4642a = PorterDuff.Mode.SRC_IN;

        /* renamed from: a  reason: collision with other field name */
        Rect f4643a = null;

        /* renamed from: a  reason: collision with other field name */
        di f4644a;

        /* renamed from: a  reason: collision with other field name */
        il0 f4645a;

        /* renamed from: a  reason: collision with other field name */
        boolean f4646a = false;
        float b = 1.0f;

        /* renamed from: b  reason: collision with other field name */
        int f4647b = 0;

        /* renamed from: b  reason: collision with other field name */
        ColorStateList f4648b = null;
        float c;

        /* renamed from: c  reason: collision with other field name */
        int f4649c = 0;

        /* renamed from: c  reason: collision with other field name */
        ColorStateList f4650c = null;
        float d = 0.0f;

        /* renamed from: d  reason: collision with other field name */
        int f4651d = 0;

        /* renamed from: d  reason: collision with other field name */
        ColorStateList f4652d = null;
        float e = 0.0f;

        /* renamed from: e  reason: collision with other field name */
        int f4653e = 0;
        float f = 0.0f;

        public c(il0 shapeAppearanceModel, di elevationOverlayProvider) {
            this.f4645a = shapeAppearanceModel;
            this.f4644a = elevationOverlayProvider;
        }

        public c(c orig) {
            this.f4645a = orig.f4645a;
            this.f4644a = orig.f4644a;
            this.c = orig.c;
            this.f4640a = orig.f4640a;
            this.f4639a = orig.f4639a;
            this.f4648b = orig.f4648b;
            this.f4642a = orig.f4642a;
            this.f4652d = orig.f4652d;
            this.f4638a = orig.f4638a;
            this.a = orig.a;
            this.f4651d = orig.f4651d;
            this.f4647b = orig.f4647b;
            this.f4646a = orig.f4646a;
            this.b = orig.b;
            this.d = orig.d;
            this.e = orig.e;
            this.f = orig.f;
            this.f4649c = orig.f4649c;
            this.f4653e = orig.f4653e;
            this.f4650c = orig.f4650c;
            this.f4641a = orig.f4641a;
            if (orig.f4643a != null) {
                this.f4643a = new Rect(orig.f4643a);
            }
        }

        public Drawable newDrawable() {
            p00 msd = new p00(this);
            boolean unused = msd.f4628a = true;
            return msd;
        }

        public int getChangingConfigurations() {
            return 0;
        }
    }
}
