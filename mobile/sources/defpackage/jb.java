package defpackage;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: jb  reason: default package */
public final class jb<T> {
    private final T a;

    /* renamed from: a  reason: collision with other field name */
    private final c<T> f4049a;

    /* renamed from: jb$c */
    interface c<T> {
        List<String> a(T t);
    }

    public static jb<Context> b(Context context, Class<? extends Service> discoveryService) {
        return new jb<>(context, new b(discoveryService));
    }

    jb(T context, c<T> retriever) {
        this.a = context;
        this.f4049a = retriever;
    }

    public List<lb> a() {
        return c(this.f4049a.a(this.a));
    }

    private static List<lb> c(List<String> registrarNames) {
        List<ComponentRegistrar> registrars = new ArrayList<>();
        for (String name : registrarNames) {
            try {
                Class<?> loadedClass = Class.forName(name);
                if (!lb.class.isAssignableFrom(loadedClass)) {
                    Log.w("ComponentDiscovery", String.format("Class %s is not an instance of %s", new Object[]{name, "com.google.firebase.components.ComponentRegistrar"}));
                } else {
                    registrars.add((lb) loadedClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                }
            } catch (ClassNotFoundException e) {
                Log.w("ComponentDiscovery", String.format("Class %s is not an found.", new Object[]{name}), e);
            } catch (IllegalAccessException e2) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", new Object[]{name}), e2);
            } catch (InstantiationException e3) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", new Object[]{name}), e3);
            } catch (NoSuchMethodException e4) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s", new Object[]{name}), e4);
            } catch (InvocationTargetException e5) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s", new Object[]{name}), e5);
            }
        }
        return registrars;
    }

    /* renamed from: jb$b */
    private static class b implements c<Context> {
        private final Class<? extends Service> a;

        private b(Class<? extends Service> discoveryService) {
            this.a = discoveryService;
        }

        /* renamed from: c */
        public List<String> a(Context ctx) {
            Bundle metadata = b(ctx);
            if (metadata == null) {
                Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            List<String> registrarNames = new ArrayList<>();
            for (String key : metadata.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(metadata.get(key)) && key.startsWith("com.google.firebase.components:")) {
                    registrarNames.add(key.substring("com.google.firebase.components:".length()));
                }
            }
            return registrarNames;
        }

        private Bundle b(Context context) {
            try {
                PackageManager manager = context.getPackageManager();
                if (manager == null) {
                    Log.w("ComponentDiscovery", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo info = manager.getServiceInfo(new ComponentName(context, this.a), 128);
                if (info != null) {
                    return info.metaData;
                }
                Log.w("ComponentDiscovery", this.a + " has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException e) {
                Log.w("ComponentDiscovery", "Application info not found.");
                return null;
            }
        }
    }
}
