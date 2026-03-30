package defpackage;

import defpackage.se0;

/* renamed from: ef  reason: default package */
public abstract class ef {
    public static final String b(Object $this$hexAddress) {
        return Integer.toHexString(System.identityHashCode($this$hexAddress));
    }

    public static final String c(rc<?> $this$toDebugString) {
        String str;
        if ($this$toDebugString instanceof sg) {
            return $this$toDebugString.toString();
        }
        try {
            se0.a aVar = se0.a;
            rc $this$toDebugString_u24lambda_u2d0 = $this$toDebugString;
            str = se0.a($this$toDebugString_u24lambda_u2d0 + '@' + b($this$toDebugString_u24lambda_u2d0));
        } catch (Throwable th) {
            se0.a aVar2 = se0.a;
            str = se0.a(te0.a(th));
        }
        Throwable b = se0.b(str);
        if (b != null) {
            Throwable th2 = b;
            str = $this$toDebugString.getClass().getName() + '@' + b($this$toDebugString);
        }
        return (String) str;
    }

    public static final String a(Object $this$classSimpleName) {
        return $this$classSimpleName.getClass().getSimpleName();
    }
}
