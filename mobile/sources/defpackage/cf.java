package defpackage;

import java.lang.reflect.Field;
import kotlin.coroutines.jvm.internal.a;

/* renamed from: cf  reason: default package */
public abstract class cf {
    public static final StackTraceElement d(a $this$getStackTraceElementImpl) {
        String moduleAndClass;
        lu.f($this$getStackTraceElementImpl, "<this>");
        bf debugMetadata = b($this$getStackTraceElementImpl);
        if (debugMetadata == null) {
            return null;
        }
        a(1, debugMetadata.v());
        int label = c($this$getStackTraceElementImpl);
        int lineNumber = label < 0 ? -1 : debugMetadata.l()[label];
        String moduleName = d20.f2697a.b($this$getStackTraceElementImpl);
        if (moduleName == null) {
            moduleAndClass = debugMetadata.c();
        } else {
            moduleAndClass = moduleName + '/' + debugMetadata.c();
        }
        return new StackTraceElement(moduleAndClass, debugMetadata.m(), debugMetadata.f(), lineNumber);
    }

    private static final bf b(a $this$getDebugMetadataAnnotation) {
        return (bf) $this$getDebugMetadataAnnotation.getClass().getAnnotation(bf.class);
    }

    private static final int c(a $this$getLabel) {
        try {
            Field field = $this$getLabel.getClass().getDeclaredField("label");
            field.setAccessible(true);
            Object obj = field.get($this$getLabel);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception e) {
            return -1;
        }
    }

    private static final void a(int expected, int actual) {
        if (actual > expected) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + expected + ", got " + actual + ". Please update the Kotlin standard library.").toString());
        }
    }
}
