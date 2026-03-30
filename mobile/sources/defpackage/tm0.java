package defpackage;

import defpackage.se0;
import java.util.ArrayDeque;
import java.util.Iterator;

/* renamed from: tm0  reason: default package */
public abstract class tm0 {
    private static final String a;
    private static final String b;

    static {
        Object obj;
        Object obj2;
        try {
            se0.a aVar = se0.a;
            obj = se0.a(Class.forName("kotlin.coroutines.jvm.internal.a").getCanonicalName());
        } catch (Throwable th) {
            se0.a aVar2 = se0.a;
            obj = se0.a(te0.a(th));
        }
        Throwable b2 = se0.b(obj);
        if (b2 != null) {
            Throwable th2 = b2;
            obj = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        a = (String) obj;
        try {
            se0.a aVar3 = se0.a;
            obj2 = se0.a(tm0.class.getCanonicalName());
        } catch (Throwable th3) {
            se0.a aVar4 = se0.a;
            obj2 = se0.a(te0.a(th3));
        }
        Throwable b3 = se0.b(obj2);
        if (b3 != null) {
            Throwable th4 = b3;
            obj2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        b = (String) obj2;
    }

    /* access modifiers changed from: private */
    public static final <E extends Throwable> E j(E exception, id continuation) {
        j50 c = c(exception);
        Throwable cause = (Throwable) c.a();
        StackTraceElement[] recoveredStacktrace = (StackTraceElement[]) c.b();
        Throwable newException = k(cause);
        if (newException == null) {
            return exception;
        }
        ArrayDeque stacktrace = e(continuation);
        if (stacktrace.isEmpty()) {
            return exception;
        }
        if (cause != exception) {
            i(recoveredStacktrace, stacktrace);
        }
        return d(cause, newException, stacktrace);
    }

    private static final <E extends Throwable> E k(E exception) {
        Throwable newException = pj.g(exception);
        if (newException == null) {
            return null;
        }
        if ((exception instanceof vc) || lu.a(newException.getMessage(), exception.getMessage())) {
            return newException;
        }
        return null;
    }

    private static final <E extends Throwable> E d(E cause, E result, ArrayDeque<StackTraceElement> resultStackTrace) {
        resultStackTrace.addFirst(b("Coroutine boundary"));
        StackTraceElement[] causeTrace = cause.getStackTrace();
        int size = g(causeTrace, a);
        int i = 0;
        if (size == -1) {
            Object[] array = resultStackTrace.toArray(new StackTraceElement[0]);
            if (array != null) {
                result.setStackTrace((StackTraceElement[]) array);
                return result;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        StackTraceElement[] mergedStackTrace = new StackTraceElement[(resultStackTrace.size() + size)];
        for (int i2 = 0; i2 < size; i2++) {
            mergedStackTrace[i2] = causeTrace[i2];
        }
        Iterator<StackTraceElement> it = resultStackTrace.iterator();
        while (it.hasNext()) {
            int index = i;
            i++;
            mergedStackTrace[size + index] = it.next();
        }
        result.setStackTrace(mergedStackTrace);
        return result;
    }

    private static final <E extends Throwable> j50<E, StackTraceElement[]> c(E $this$causeAndStacktrace) {
        boolean z;
        Throwable cause = $this$causeAndStacktrace.getCause();
        if (cause == null || !lu.a(cause.getClass(), $this$causeAndStacktrace.getClass())) {
            return ws0.a($this$causeAndStacktrace, new StackTraceElement[0]);
        }
        StackTraceElement[] currentTrace = $this$causeAndStacktrace.getStackTrace();
        StackTraceElement[] stackTraceElementArr = currentTrace;
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (h(stackTraceElementArr[i])) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return ws0.a(cause, currentTrace);
        }
        return ws0.a($this$causeAndStacktrace, new StackTraceElement[0]);
    }

    private static final void i(StackTraceElement[] recoveredStacktrace, ArrayDeque<StackTraceElement> result) {
        StackTraceElement[] stackTraceElementArr = recoveredStacktrace;
        int index$iv = 0;
        int length = stackTraceElementArr.length;
        while (true) {
            if (index$iv >= length) {
                index$iv = -1;
                break;
            } else if (h(stackTraceElementArr[index$iv])) {
                break;
            } else {
                index$iv++;
            }
        }
        int startIndex = index$iv + 1;
        int i = recoveredStacktrace.length - 1;
        if (startIndex <= i) {
            while (true) {
                if (f(recoveredStacktrace[i], result.getLast())) {
                    result.removeLast();
                }
                result.addFirst(recoveredStacktrace[i]);
                if (i != startIndex) {
                    i--;
                } else {
                    return;
                }
            }
        }
    }

    public static final <E extends Throwable> E l(E exception) {
        Throwable cause = exception.getCause();
        if (cause == null || !lu.a(cause.getClass(), exception.getClass())) {
            return exception;
        }
        StackTraceElement[] stackTrace = exception.getStackTrace();
        int length = stackTrace.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (h(stackTrace[i])) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return cause;
        }
        return exception;
    }

    private static final ArrayDeque<StackTraceElement> e(id continuation) {
        ArrayDeque stack = new ArrayDeque();
        StackTraceElement it = continuation.getStackTraceElement();
        if (it != null) {
            stack.add(it);
        }
        id last = continuation;
        while (true) {
            id callerFrame = last.getCallerFrame();
            if (callerFrame == null) {
                return stack;
            }
            last = callerFrame;
            StackTraceElement it2 = last.getStackTraceElement();
            if (it2 != null) {
                stack.add(it2);
            }
        }
    }

    public static final StackTraceElement b(String message) {
        return new StackTraceElement("\b\b\b(" + message, "\b", "\b", -1);
    }

    public static final boolean h(StackTraceElement $this$isArtificial) {
        return do0.g($this$isArtificial.getClassName(), "\b\b\b", false, 2, (Object) null);
    }

    private static final int g(StackTraceElement[] $this$frameIndex, String methodName) {
        StackTraceElement[] stackTraceElementArr = $this$frameIndex;
        int length = stackTraceElementArr.length;
        for (int index$iv = 0; index$iv < length; index$iv++) {
            if (lu.a(methodName, stackTraceElementArr[index$iv].getClassName())) {
                return index$iv;
            }
        }
        return -1;
    }

    private static final boolean f(StackTraceElement $this$elementWiseEquals, StackTraceElement e) {
        return $this$elementWiseEquals.getLineNumber() == e.getLineNumber() && lu.a($this$elementWiseEquals.getMethodName(), e.getMethodName()) && lu.a($this$elementWiseEquals.getFileName(), e.getFileName()) && lu.a($this$elementWiseEquals.getClassName(), e.getClassName());
    }
}
