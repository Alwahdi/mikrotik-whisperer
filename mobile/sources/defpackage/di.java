package defpackage;

import android.content.Context;
import android.graphics.Color;
import androidx.core.graphics.ColorUtils;

/* renamed from: di  reason: default package */
public class di {
    private static final int d = ((int) Math.round(5.1000000000000005d));
    private final float a;

    /* renamed from: a  reason: collision with other field name */
    private final int f2772a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f2773a;
    private final int b;
    private final int c;

    public di(Context context) {
        this(e00.b(context, yb0.elevationOverlayEnabled, false), k00.b(context, yb0.elevationOverlayColor, 0), k00.b(context, yb0.elevationOverlayAccentColor, 0), k00.b(context, yb0.colorSurface, 0), context.getResources().getDisplayMetrics().density);
    }

    public di(boolean elevationOverlayEnabled, int elevationOverlayColor, int elevationOverlayAccentColor, int colorSurface, float displayDensity) {
        this.f2773a = elevationOverlayEnabled;
        this.f2772a = elevationOverlayColor;
        this.b = elevationOverlayAccentColor;
        this.c = colorSurface;
        this.a = displayDensity;
    }

    public int d(float elevation) {
        return c(this.c, elevation);
    }

    public int c(int backgroundColor, float elevation) {
        if (!this.f2773a || !f(backgroundColor)) {
            return backgroundColor;
        }
        return b(backgroundColor, elevation);
    }

    public int b(int backgroundColor, float elevation) {
        int i;
        float overlayAlphaFraction = a(elevation);
        int backgroundAlpha = Color.alpha(backgroundColor);
        int overlayColorOpaque = k00.k(ColorUtils.setAlphaComponent(backgroundColor, 255), this.f2772a, overlayAlphaFraction);
        if (overlayAlphaFraction > 0.0f && (i = this.b) != 0) {
            overlayColorOpaque = k00.j(overlayColorOpaque, ColorUtils.setAlphaComponent(i, d));
        }
        return ColorUtils.setAlphaComponent(overlayColorOpaque, backgroundAlpha);
    }

    public float a(float elevation) {
        float f = this.a;
        if (f <= 0.0f || elevation <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p((double) (elevation / f))) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public boolean e() {
        return this.f2773a;
    }

    private boolean f(int color) {
        return ColorUtils.setAlphaComponent(color, 255) == this.c;
    }
}
