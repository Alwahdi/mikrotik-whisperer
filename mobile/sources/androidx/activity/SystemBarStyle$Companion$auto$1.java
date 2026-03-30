package androidx.activity;

import android.content.res.Resources;

final class SystemBarStyle$Companion$auto$1 extends ow implements vn<Resources, Boolean> {
    public static final SystemBarStyle$Companion$auto$1 INSTANCE = new SystemBarStyle$Companion$auto$1();

    SystemBarStyle$Companion$auto$1() {
        super(1);
    }

    public final Boolean invoke(Resources resources) {
        lu.f(resources, "resources");
        return Boolean.valueOf((resources.getConfiguration().uiMode & 48) == 32);
    }
}
