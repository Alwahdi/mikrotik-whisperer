package defpackage;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.util.Preconditions;
import java.lang.reflect.Constructor;

/* renamed from: an0  reason: default package */
final class an0 {
    private static Object a;

    /* renamed from: a  reason: collision with other field name */
    private static Constructor<StaticLayout> f78a;
    private static boolean c;
    static final int f = (Build.VERSION.SDK_INT >= 23 ? 1 : 0);

    /* renamed from: a  reason: collision with other field name */
    private float f79a;

    /* renamed from: a  reason: collision with other field name */
    private final int f80a;

    /* renamed from: a  reason: collision with other field name */
    private Layout.Alignment f81a;

    /* renamed from: a  reason: collision with other field name */
    private final TextPaint f82a;

    /* renamed from: a  reason: collision with other field name */
    private TextUtils.TruncateAt f83a;

    /* renamed from: a  reason: collision with other field name */
    private bn0 f84a;

    /* renamed from: a  reason: collision with other field name */
    private CharSequence f85a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f86a;
    private float b;

    /* renamed from: b  reason: collision with other field name */
    private int f87b = 0;

    /* renamed from: b  reason: collision with other field name */
    private boolean f88b;

    /* renamed from: c  reason: collision with other field name */
    private int f89c;
    private int d;
    private int e;

    private an0(CharSequence source, TextPaint paint, int width) {
        this.f85a = source;
        this.f82a = paint;
        this.f80a = width;
        this.f89c = source.length();
        this.f81a = Layout.Alignment.ALIGN_NORMAL;
        this.d = Integer.MAX_VALUE;
        this.f79a = 0.0f;
        this.b = 1.0f;
        this.e = f;
        this.f86a = true;
        this.f83a = null;
    }

    public static an0 c(CharSequence source, TextPaint paint, int width) {
        return new an0(source, paint, width);
    }

    public an0 d(Layout.Alignment alignment) {
        this.f81a = alignment;
        return this;
    }

    public an0 g(boolean includePad) {
        this.f86a = includePad;
        return this;
    }

    public an0 j(int maxLines) {
        this.d = maxLines;
        return this;
    }

    public an0 i(float spacingAdd, float lineSpacingMultiplier) {
        this.f79a = spacingAdd;
        this.b = lineSpacingMultiplier;
        return this;
    }

    public an0 f(int hyphenationFrequency) {
        this.e = hyphenationFrequency;
        return this;
    }

    public an0 e(TextUtils.TruncateAt ellipsize) {
        this.f83a = ellipsize;
        return this;
    }

    public an0 k(bn0 staticLayoutBuilderConfigurer) {
        this.f84a = staticLayoutBuilderConfigurer;
        return this;
    }

    public StaticLayout a() {
        TextDirectionHeuristic textDirectionHeuristic;
        if (this.f85a == null) {
            this.f85a = "";
        }
        int availableWidth = Math.max(0, this.f80a);
        CharSequence textToDraw = this.f85a;
        if (this.d == 1) {
            textToDraw = TextUtils.ellipsize(this.f85a, this.f82a, (float) availableWidth, this.f83a);
        }
        int min = Math.min(textToDraw.length(), this.f89c);
        this.f89c = min;
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.f88b && this.d == 1) {
                this.f81a = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder builder = StaticLayout.Builder.obtain(textToDraw, this.f87b, min, this.f82a, availableWidth);
            builder.setAlignment(this.f81a);
            builder.setIncludePad(this.f86a);
            if (this.f88b) {
                textDirectionHeuristic = TextDirectionHeuristics.RTL;
            } else {
                textDirectionHeuristic = TextDirectionHeuristics.LTR;
            }
            builder.setTextDirection(textDirectionHeuristic);
            TextUtils.TruncateAt truncateAt = this.f83a;
            if (truncateAt != null) {
                builder.setEllipsize(truncateAt);
            }
            builder.setMaxLines(this.d);
            float f2 = this.f79a;
            if (!(f2 == 0.0f && this.b == 1.0f)) {
                builder.setLineSpacing(f2, this.b);
            }
            if (this.d > 1) {
                builder.setHyphenationFrequency(this.e);
            }
            bn0 bn0 = this.f84a;
            if (bn0 != null) {
                bn0.a(builder);
            }
            return builder.build();
        }
        b();
        try {
            return (StaticLayout) ((Constructor) Preconditions.checkNotNull(f78a)).newInstance(new Object[]{textToDraw, Integer.valueOf(this.f87b), Integer.valueOf(this.f89c), this.f82a, Integer.valueOf(availableWidth), this.f81a, Preconditions.checkNotNull(a), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f86a), null, Integer.valueOf(availableWidth), Integer.valueOf(this.d)});
        } catch (Exception cause) {
            throw new a(cause);
        }
    }

    private void b() {
        Class cls;
        if (!c) {
            try {
                boolean useRtl = this.f88b && Build.VERSION.SDK_INT >= 23;
                if (Build.VERSION.SDK_INT >= 18) {
                    cls = TextDirectionHeuristic.class;
                    a = useRtl ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
                } else {
                    ClassLoader loader = an0.class.getClassLoader();
                    String textDirClassName = this.f88b ? "RTL" : "LTR";
                    Class<?> textDirClass = loader.loadClass("android.text.TextDirectionHeuristic");
                    Class<?> textDirsClass = loader.loadClass("android.text.TextDirectionHeuristics");
                    a = textDirsClass.getField(textDirClassName).get(textDirsClass);
                    cls = textDirClass;
                }
                Class cls2 = Integer.TYPE;
                Class cls3 = Float.TYPE;
                Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(new Class[]{CharSequence.class, cls2, cls2, TextPaint.class, cls2, Layout.Alignment.class, cls, cls3, cls3, Boolean.TYPE, TextUtils.TruncateAt.class, cls2, cls2});
                f78a = declaredConstructor;
                declaredConstructor.setAccessible(true);
                c = true;
            } catch (Exception cause) {
                throw new a(cause);
            }
        }
    }

    public an0 h(boolean isRtl) {
        this.f88b = isRtl;
        return this;
    }

    /* renamed from: an0$a */
    static class a extends Exception {
        a(Throwable cause) {
            super("Error thrown initializing StaticLayout " + cause.getMessage(), cause);
        }
    }
}
