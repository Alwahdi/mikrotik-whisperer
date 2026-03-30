package defpackage;

import android.content.Intent;

/* renamed from: mu0  reason: default package */
public abstract class mu0 extends Exception {
    private final Intent a;

    public mu0(String str, Intent intent) {
        super(str);
        this.a = intent;
    }
}
