package defpackage;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.os.UserManagerCompat;
import com.google.firebase.components.ComponentDiscoveryService;
import defpackage.j5;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: gl  reason: default package */
public class gl {
    /* access modifiers changed from: private */
    public static final Object a = new Object();

    /* renamed from: a  reason: collision with other field name */
    static final Map<String, gl> f3094a = new ArrayMap();

    /* renamed from: a  reason: collision with other field name */
    private static final Executor f3095a = new d();

    /* renamed from: a  reason: collision with other field name */
    private final Context f3096a;

    /* renamed from: a  reason: collision with other field name */
    private final bm f3097a;

    /* renamed from: a  reason: collision with other field name */
    private final String f3098a;

    /* renamed from: a  reason: collision with other field name */
    private final List<b> f3099a = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final AtomicBoolean f3100a = new AtomicBoolean(false);

    /* renamed from: a  reason: collision with other field name */
    private final pb f3101a;

    /* renamed from: a  reason: collision with other field name */
    private final sw<ne> f3102a;
    private final List<hl> b = new CopyOnWriteArrayList();

    /* renamed from: b  reason: collision with other field name */
    private final AtomicBoolean f3103b = new AtomicBoolean();

    /* renamed from: gl$b */
    public interface b {
        void a(boolean z);
    }

    public Context i() {
        f();
        return this.f3096a;
    }

    public String l() {
        f();
        return this.f3098a;
    }

    public bm m() {
        f();
        return this.f3097a;
    }

    public boolean equals(Object o) {
        if (!(o instanceof gl)) {
            return false;
        }
        return this.f3098a.equals(((gl) o).l());
    }

    public int hashCode() {
        return this.f3098a.hashCode();
    }

    public String toString() {
        return e40.c(this).a("name", this.f3098a).a("options", this.f3097a).toString();
    }

    public static gl j() {
        gl defaultApp;
        synchronized (a) {
            defaultApp = f3094a.get("[DEFAULT]");
            if (defaultApp == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + va0.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return defaultApp;
    }

    public static gl k(String name) {
        gl firebaseApp;
        String availableAppNamesMessage;
        synchronized (a) {
            firebaseApp = f3094a.get(v(name));
            if (firebaseApp == null) {
                List<String> availableAppNames = h();
                if (availableAppNames.isEmpty()) {
                    availableAppNamesMessage = "";
                } else {
                    availableAppNamesMessage = "Available app names: " + TextUtils.join(", ", availableAppNames);
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", new Object[]{name, availableAppNamesMessage}));
            }
        }
        return firebaseApp;
    }

    public static gl p(Context context) {
        synchronized (a) {
            if (f3094a.containsKey("[DEFAULT]")) {
                gl j = j();
                return j;
            }
            bm firebaseOptions = bm.a(context);
            if (firebaseOptions == null) {
                Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            gl q = q(context, firebaseOptions);
            return q;
        }
    }

    public static gl q(Context context, bm options) {
        return r(context, options, "[DEFAULT]");
    }

    public static gl r(Context context, bm options, String name) {
        Context applicationContext;
        gl firebaseApp;
        c.c(context);
        String normalizedName = v(name);
        if (context.getApplicationContext() == null) {
            applicationContext = context;
        } else {
            applicationContext = context.getApplicationContext();
        }
        synchronized (a) {
            Map<String, gl> map = f3094a;
            boolean z = !map.containsKey(normalizedName);
            y90.m(z, "FirebaseApp name " + normalizedName + " already exists!");
            y90.k(applicationContext, "Application context cannot be null.");
            firebaseApp = new gl(applicationContext, normalizedName, options);
            map.put(normalizedName, firebaseApp);
        }
        firebaseApp.o();
        return firebaseApp;
    }

    public <T> T g(Class<T> anInterface) {
        f();
        return this.f3101a.d(anInterface);
    }

    public boolean s() {
        f();
        return this.f3102a.get().b();
    }

    protected gl(Context applicationContext, String name, bm options) {
        this.f3096a = (Context) y90.j(applicationContext);
        this.f3098a = y90.f(name);
        this.f3097a = (bm) y90.j(options);
        List<lb> a2 = jb.b(applicationContext, ComponentDiscoveryService.class).a();
        String kotlinVersion = iw.a();
        Executor executor = f3095a;
        cb[] cbVarArr = new cb[8];
        cbVarArr[0] = cb.n(applicationContext, Context.class, new Class[0]);
        cbVarArr[1] = cb.n(this, gl.class, new Class[0]);
        cbVarArr[2] = cb.n(options, bm.class, new Class[0]);
        cbVarArr[3] = ax.a("fire-android", "");
        cbVarArr[4] = ax.a("fire-core", "19.3.0");
        cbVarArr[5] = kotlinVersion != null ? ax.a("kotlin", kotlinVersion) : null;
        cbVarArr[6] = vf.b();
        cbVarArr[7] = com.google.firebase.heartbeatinfo.b.b();
        this.f3101a = new pb(executor, a2, cbVarArr);
        this.f3102a = new sw<>(fl.a(this, applicationContext));
    }

    static /* synthetic */ ne u(gl glVar, Context applicationContext) {
        return new ne(applicationContext, glVar.n(), (sb0) glVar.f3101a.d(sb0.class));
    }

    private void f() {
        y90.m(!this.f3103b.get(), "FirebaseApp was deleted");
    }

    public boolean t() {
        return "[DEFAULT]".equals(l());
    }

    /* access modifiers changed from: private */
    public void w(boolean background) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (b listener : this.f3099a) {
            listener.a(background);
        }
    }

    public String n() {
        return v5.d(l().getBytes(Charset.defaultCharset())) + "+" + v5.d(m().c().getBytes(Charset.defaultCharset()));
    }

    public void e(hl listener) {
        f();
        y90.j(listener);
        this.b.add(listener);
    }

    private static List<String> h() {
        List<String> allAppNames = new ArrayList<>();
        synchronized (a) {
            for (gl app : f3094a.values()) {
                allAppNames.add(app.l());
            }
        }
        Collections.sort(allAppNames);
        return allAppNames;
    }

    /* access modifiers changed from: private */
    public void o() {
        if (!UserManagerCompat.isUserUnlocked(this.f3096a)) {
            e.b(this.f3096a);
        } else {
            this.f3101a.e(t());
        }
    }

    private static String v(String name) {
        return name.trim();
    }

    /* renamed from: gl$e */
    private static class e extends BroadcastReceiver {
        private static AtomicReference<e> a = new AtomicReference<>();

        /* renamed from: a  reason: collision with other field name */
        private final Context f3104a;

        public e(Context applicationContext) {
            this.f3104a = applicationContext;
        }

        /* access modifiers changed from: private */
        public static void b(Context applicationContext) {
            if (a.get() == null) {
                e receiver = new e(applicationContext);
                if (a.compareAndSet((Object) null, receiver)) {
                    applicationContext.registerReceiver(receiver, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void onReceive(Context context, Intent intent) {
            synchronized (gl.a) {
                for (gl app : gl.f3094a.values()) {
                    app.o();
                }
            }
            c();
        }

        public void c() {
            this.f3104a.unregisterReceiver(this);
        }
    }

    /* renamed from: gl$c */
    private static class c implements j5.a {
        private static AtomicReference<c> a = new AtomicReference<>();

        private c() {
        }

        /* access modifiers changed from: private */
        public static void c(Context context) {
            if (n90.a() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (a.get() == null) {
                    c listener = new c();
                    if (a.compareAndSet((Object) null, listener)) {
                        j5.c(application);
                        j5.b().a(listener);
                    }
                }
            }
        }

        public void a(boolean background) {
            synchronized (gl.a) {
                Iterator it = new ArrayList(gl.f3094a.values()).iterator();
                while (it.hasNext()) {
                    gl app = (gl) it.next();
                    if (app.f3100a.get()) {
                        app.w(background);
                    }
                }
            }
        }
    }

    /* renamed from: gl$d */
    private static class d implements Executor {
        private static final Handler a = new Handler(Looper.getMainLooper());

        private d() {
        }

        public void execute(Runnable command) {
            a.post(command);
        }
    }
}
