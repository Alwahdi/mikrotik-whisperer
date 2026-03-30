package defpackage;

import android.os.Build;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* renamed from: d3  reason: default package */
public final class d3 extends k implements bd {
    private volatile Object _preHandler = this;

    public d3() {
        super(bd.a);
    }

    private final Method X() {
        Object current = this._preHandler;
        if (current != this) {
            return (Method) current;
        }
        Method declared = null;
        boolean z = false;
        try {
            Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
            Method it = declaredMethod;
            if (Modifier.isPublic(it.getModifiers()) && Modifier.isStatic(it.getModifiers())) {
                z = true;
            }
            if (z) {
                declared = declaredMethod;
            }
        } catch (Throwable th) {
        }
        this._preHandler = declared;
        return declared;
    }

    public void q(yc context, Throwable exception) {
        int i = Build.VERSION.SDK_INT;
        if (26 <= i && i < 28) {
            Method X = X();
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;
            Object invoke = X != null ? X.invoke((Object) null, new Object[0]) : null;
            if (invoke instanceof Thread.UncaughtExceptionHandler) {
                uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) invoke;
            }
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), exception);
            }
        }
    }
}
