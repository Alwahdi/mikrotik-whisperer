package defpackage;

import android.app.Activity;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import defpackage.xd;
import java.io.Serializable;

/* renamed from: w7  reason: default package */
public class w7 implements Serializable {
    /* access modifiers changed from: private */
    public int a = 1;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public Class<? extends Activity> f5460a = null;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public Integer f5461a = null;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public xd.c f5462a = null;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public boolean f5463a = true;
    /* access modifiers changed from: private */
    public int b = PathInterpolatorCompat.MAX_NUM_POINTS;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public Class<? extends Activity> f5464b = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public boolean f5465b = true;
    /* access modifiers changed from: private */
    public boolean c = true;
    /* access modifiers changed from: private */
    public boolean d = true;
    /* access modifiers changed from: private */
    public boolean e = false;

    public int z() {
        return this.a;
    }

    public boolean F() {
        return this.f5463a;
    }

    public boolean H() {
        return this.f5465b;
    }

    public boolean I() {
        return this.c;
    }

    public boolean G() {
        return this.d;
    }

    public boolean J() {
        return this.e;
    }

    public int D() {
        return this.b;
    }

    public Integer B() {
        return this.f5461a;
    }

    public Class<? extends Activity> A() {
        return this.f5460a;
    }

    public Class<? extends Activity> E() {
        return this.f5464b;
    }

    public void K(Class<? extends Activity> restartActivityClass) {
        this.f5464b = restartActivityClass;
    }

    public xd.c C() {
        return this.f5462a;
    }

    /* renamed from: w7$a */
    public static class a {
        private w7 a;

        public static a c() {
            a builder = new a();
            w7 currentConfig = xd.s();
            w7 config = new w7();
            int unused = config.a = currentConfig.a;
            boolean unused2 = config.f5463a = currentConfig.f5463a;
            boolean unused3 = config.f5465b = currentConfig.f5465b;
            boolean unused4 = config.c = currentConfig.c;
            boolean unused5 = config.d = currentConfig.d;
            boolean unused6 = config.e = currentConfig.e;
            int unused7 = config.b = currentConfig.b;
            Integer unused8 = config.f5461a = currentConfig.f5461a;
            Class unused9 = config.f5460a = currentConfig.f5460a;
            Class unused10 = config.f5464b = currentConfig.f5464b;
            xd.c unused11 = config.f5462a = currentConfig.f5462a;
            builder.a = config;
            return builder;
        }

        public a b(int backgroundMode) {
            int unused = this.a.a = backgroundMode;
            return this;
        }

        public a d(int minTimeBetweenCrashesMs) {
            int unused = this.a.b = minTimeBetweenCrashesMs;
            return this;
        }

        public void a() {
            xd.J(this.a);
        }
    }
}
