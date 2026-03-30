package defpackage;

import java.io.BufferedReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;

/* renamed from: lk  reason: default package */
public final class lk {
    public static final lk a = new lk();

    private lk() {
    }

    public final List<oz> c() {
        oz $this$loadMainDispatcherFactory_u24lambda_u2d0;
        Class clz = oz.class;
        if (!mk.a()) {
            return b(clz, clz.getClassLoader());
        }
        try {
            ArrayList result = new ArrayList(2);
            oz $this$loadMainDispatcherFactory_u24lambda_u2d1 = null;
            try {
                $this$loadMainDispatcherFactory_u24lambda_u2d0 = clz.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, clz.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException e) {
                $this$loadMainDispatcherFactory_u24lambda_u2d0 = null;
            }
            if ($this$loadMainDispatcherFactory_u24lambda_u2d0 != null) {
                result.add($this$loadMainDispatcherFactory_u24lambda_u2d0);
            }
            try {
                $this$loadMainDispatcherFactory_u24lambda_u2d1 = clz.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, clz.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException e2) {
            }
            if ($this$loadMainDispatcherFactory_u24lambda_u2d1 == null) {
                return result;
            }
            result.add($this$loadMainDispatcherFactory_u24lambda_u2d1);
            return result;
        } catch (Throwable th) {
            return b(clz, clz.getClassLoader());
        }
    }

    private final <S> List<S> b(Class<S> service, ClassLoader loader) {
        try {
            return d(service, loader);
        } catch (Throwable th) {
            return t9.o(ServiceLoader.load(service, loader));
        }
    }

    public final <S> List<S> d(Class<S> service, ClassLoader loader) {
        Iterable<URL> $this$flatMapTo$iv$iv = Collections.list(loader.getResources("META-INF/services/" + service.getName()));
        lu.e($this$flatMapTo$iv$iv, "list(this)");
        Collection destination$iv$iv = new ArrayList();
        for (URL it : $this$flatMapTo$iv$iv) {
            boolean unused = q9.k(destination$iv$iv, a.e(it));
        }
        Set providers = t9.r(destination$iv$iv);
        if (!providers.isEmpty()) {
            Iterable<String> $this$mapTo$iv$iv = providers;
            ArrayList arrayList = new ArrayList(m9.i($this$mapTo$iv$iv, 10));
            for (String it2 : $this$mapTo$iv$iv) {
                arrayList.add(a.a(it2, loader, service));
            }
            return arrayList;
        }
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }

    private final <S> S a(String name, ClassLoader loader, Class<S> service) {
        Class clazz = Class.forName(name, false, loader);
        if (service.isAssignableFrom(clazz)) {
            return service.cast(clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + service + ", but found " + clazz).toString());
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0056, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        defpackage.d9.a(r10, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005a, code lost:
        throw r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0087, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0088, code lost:
        defpackage.d9.a(r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x008b, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<java.lang.String> e(java.net.URL r15) {
        /*
            r14 = this;
            java.lang.String r0 = r15.toString()
            java.lang.String r1 = "jar"
            r2 = 0
            r3 = 2
            r4 = 0
            boolean r1 = defpackage.do0.g(r0, r1, r2, r3, r4)
            if (r1 == 0) goto L_0x006b
            java.lang.String r1 = "jar:file:"
            java.lang.String r1 = defpackage.eo0.w(r0, r1, r4, r3, r4)
            r5 = 33
            java.lang.String r1 = defpackage.eo0.B(r1, r5, r4, r3, r4)
            java.lang.String r5 = "!/"
            java.lang.String r3 = defpackage.eo0.w(r0, r5, r4, r3, r4)
            java.util.jar.JarFile r5 = new java.util.jar.JarFile
            r5.<init>(r1, r2)
            r2 = r5
            r5 = r14
            r6 = 0
            r7 = 0
            r8 = r2
            r9 = 0
            java.io.BufferedReader r10 = new java.io.BufferedReader     // Catch:{ all -> 0x005b }
            java.io.InputStreamReader r11 = new java.io.InputStreamReader     // Catch:{ all -> 0x005b }
            java.util.zip.ZipEntry r12 = new java.util.zip.ZipEntry     // Catch:{ all -> 0x005b }
            r12.<init>(r3)     // Catch:{ all -> 0x005b }
            java.io.InputStream r12 = r8.getInputStream(r12)     // Catch:{ all -> 0x005b }
            java.lang.String r13 = "UTF-8"
            r11.<init>(r12, r13)     // Catch:{ all -> 0x005b }
            r10.<init>(r11)     // Catch:{ all -> 0x005b }
            r11 = r10
            r12 = 0
            lk r13 = a     // Catch:{ all -> 0x0054 }
            java.util.List r13 = r13.f(r11)     // Catch:{ all -> 0x0054 }
            defpackage.d9.a(r10, r4)     // Catch:{ all -> 0x005b }
            r2.close()     // Catch:{ all -> 0x0052 }
            return r13
        L_0x0052:
            r2 = move-exception
            throw r2
        L_0x0054:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0056 }
        L_0x0056:
            r11 = move-exception
            defpackage.d9.a(r10, r4)     // Catch:{ all -> 0x005b }
            throw r11     // Catch:{ all -> 0x005b }
        L_0x005b:
            r4 = move-exception
            r7 = r4
            throw r4     // Catch:{ all -> 0x005f }
        L_0x005f:
            r4 = move-exception
            r2.close()     // Catch:{ all -> 0x0065 }
            throw r4
        L_0x0065:
            r4 = move-exception
            defpackage.rj.a(r7, r4)
            throw r7
        L_0x006b:
            java.io.BufferedReader r1 = new java.io.BufferedReader
            java.io.InputStreamReader r2 = new java.io.InputStreamReader
            java.io.InputStream r3 = r15.openStream()
            r2.<init>(r3)
            r1.<init>(r2)
            r2 = r1
            r3 = 0
            lk r5 = a     // Catch:{ all -> 0x0085 }
            java.util.List r5 = r5.f(r2)     // Catch:{ all -> 0x0085 }
            defpackage.d9.a(r1, r4)
            return r5
        L_0x0085:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0087 }
        L_0x0087:
            r3 = move-exception
            defpackage.d9.a(r1, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lk.e(java.net.URL):java.util.List");
    }

    private final List<String> f(BufferedReader r) {
        boolean z;
        Set names = new LinkedHashSet();
        while (true) {
            String line = r.readLine();
            if (line == null) {
                return t9.o(names);
            }
            String serviceName = eo0.D(eo0.C(line, "#", (String) null, 2, (Object) null)).toString();
            CharSequence $this$all$iv = serviceName;
            boolean z2 = false;
            int i = 0;
            while (true) {
                if (i >= $this$all$iv.length()) {
                    z = true;
                    break;
                }
                char it = $this$all$iv.charAt(i);
                if (((it == '.' || Character.isJavaIdentifierPart(it)) ? (char) 1 : 0) == 0) {
                    z = false;
                    break;
                }
                i++;
            }
            if (z) {
                if (serviceName.length() > 0) {
                    z2 = true;
                }
                if (z2) {
                    names.add(serviceName);
                }
            } else {
                throw new IllegalArgumentException(("Illegal service provider class name: " + serviceName).toString());
            }
        }
    }
}
