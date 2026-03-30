package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class LifecycleCallback {
    protected final dx a;

    @Keep
    private static dx getChimeraLifecycleFragmentImpl(bx bxVar) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    protected static dx b(bx bxVar) {
        if (bxVar.c()) {
            return x21.j(bxVar.b());
        }
        if (bxVar.d()) {
            return oy0.b(bxVar.a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    public static dx c(Activity activity) {
        return b(new bx(activity));
    }

    protected LifecycleCallback(dx dxVar) {
        this.a = dxVar;
    }

    public void e(Bundle bundle) {
    }

    public void i() {
    }

    public void g() {
    }

    public void h(Bundle bundle) {
    }

    public void d(int i, int i2, Intent intent) {
    }

    public void j() {
    }

    public void f() {
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }
}
