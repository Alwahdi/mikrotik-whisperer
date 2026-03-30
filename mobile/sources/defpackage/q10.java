package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: q10  reason: default package */
class q10 implements h5 {
    private final Map<String, ds0> a;

    /* renamed from: a  reason: collision with other field name */
    private final a f4745a;

    /* renamed from: a  reason: collision with other field name */
    private final sd f4746a;

    q10(Context applicationContext, sd creationContextFactory) {
        this(new a(applicationContext), creationContextFactory);
    }

    q10(a backendFactoryProvider, sd creationContextFactory) {
        this.a = new HashMap();
        this.f4745a = backendFactoryProvider;
        this.f4746a = creationContextFactory;
    }

    public synchronized ds0 a(String name) {
        if (this.a.containsKey(name)) {
            return this.a.get(name);
        }
        g5 factory = this.f4745a.b(name);
        if (factory == null) {
            return null;
        }
        ds0 backend = factory.create(this.f4746a.a(name));
        this.a.put(name, backend);
        return backend;
    }

    /* renamed from: q10$a */
    static class a {
        private final Context a;

        /* renamed from: a  reason: collision with other field name */
        private Map<String, String> f4747a = null;

        a(Context applicationContext) {
            this.a = applicationContext;
        }

        /* access modifiers changed from: package-private */
        public g5 b(String name) {
            String backendProviderName = c().get(name);
            if (backendProviderName == null) {
                return null;
            }
            try {
                return (g5) Class.forName(backendProviderName).asSubclass(g5.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e) {
                Log.w("BackendRegistry", String.format("Class %s is not found.", new Object[]{backendProviderName}), e);
                return null;
            } catch (IllegalAccessException e2) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", new Object[]{backendProviderName}), e2);
                return null;
            } catch (InstantiationException e3) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", new Object[]{backendProviderName}), e3);
                return null;
            } catch (NoSuchMethodException e4) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", new Object[]{backendProviderName}), e4);
                return null;
            } catch (InvocationTargetException e5) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", new Object[]{backendProviderName}), e5);
                return null;
            }
        }

        private Map<String, String> c() {
            if (this.f4747a == null) {
                this.f4747a = a(this.a);
            }
            return this.f4747a;
        }

        private Map<String, String> a(Context ctx) {
            Bundle metadata = d(ctx);
            if (metadata == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.emptyMap();
            }
            Map<String, String> backendNames = new HashMap<>();
            for (String key : metadata.keySet()) {
                Object rawValue = metadata.get(key);
                if ((rawValue instanceof String) && key.startsWith("backend:")) {
                    for (String name : ((String) rawValue).split(",", -1)) {
                        String name2 = name.trim();
                        if (!name2.isEmpty()) {
                            backendNames.put(name2, key.substring("backend:".length()));
                        }
                    }
                }
            }
            return backendNames;
        }

        private static Bundle d(Context context) {
            try {
                PackageManager manager = context.getPackageManager();
                if (manager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo info = manager.getServiceInfo(new ComponentName(context, TransportBackendDiscovery.class), 128);
                if (info != null) {
                    return info.metaData;
                }
                Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException e) {
                Log.w("BackendRegistry", "Application info not found.");
                return null;
            }
        }
    }
}
