package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.google.firebase.iid.w;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class f {
    private static int a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static PendingIntent f2422a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f2423a;

    /* renamed from: a  reason: collision with other field name */
    private Messenger f2424a;

    /* renamed from: a  reason: collision with other field name */
    private final SimpleArrayMap<String, gq0<Bundle>> f2425a = new SimpleArrayMap<>();

    /* renamed from: a  reason: collision with other field name */
    private w f2426a;

    /* renamed from: a  reason: collision with other field name */
    private final tz0 f2427a;
    private Messenger b;

    public f(Context context, tz0 tz0) {
        this.f2423a = context;
        this.f2427a = tz0;
        this.f2424a = new Messenger(new i(this, Looper.getMainLooper()));
    }

    /* access modifiers changed from: private */
    public final void d(Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new w.a());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof w) {
                        this.f2426a = (w) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.b = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                    String stringExtra = intent2.getStringExtra("registration_id");
                    if (stringExtra == null) {
                        stringExtra = intent2.getStringExtra("unregistered");
                    }
                    if (stringExtra == null) {
                        String stringExtra2 = intent2.getStringExtra("error");
                        if (stringExtra2 == null) {
                            String valueOf = String.valueOf(intent2.getExtras());
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 49);
                            sb.append("Unexpected response, no error or registration id ");
                            sb.append(valueOf);
                            Log.w("FirebaseInstanceId", sb.toString());
                            return;
                        }
                        if (Log.isLoggable("FirebaseInstanceId", 3)) {
                            String valueOf2 = String.valueOf(stringExtra2);
                            Log.d("FirebaseInstanceId", valueOf2.length() != 0 ? "Received InstanceID error ".concat(valueOf2) : new String("Received InstanceID error "));
                        }
                        if (stringExtra2.startsWith("|")) {
                            String[] split = stringExtra2.split("\\|");
                            if (split.length <= 2 || !"ID".equals(split[1])) {
                                String valueOf3 = String.valueOf(stringExtra2);
                                Log.w("FirebaseInstanceId", valueOf3.length() != 0 ? "Unexpected structured response ".concat(valueOf3) : new String("Unexpected structured response "));
                                return;
                            }
                            String str = split[2];
                            String str2 = split[3];
                            if (str2.startsWith(":")) {
                                str2 = str2.substring(1);
                            }
                            f(str, intent2.putExtra("error", str2).getExtras());
                            return;
                        }
                        synchronized (this.f2425a) {
                            for (int i = 0; i < this.f2425a.size(); i++) {
                                f(this.f2425a.keyAt(i), intent2.getExtras());
                            }
                        }
                        return;
                    }
                    Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                    if (matcher.matches()) {
                        String group = matcher.group(1);
                        String group2 = matcher.group(2);
                        Bundle extras = intent2.getExtras();
                        extras.putString("registration_id", group2);
                        f(group, extras);
                        return;
                    } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        String valueOf4 = String.valueOf(stringExtra);
                        Log.d("FirebaseInstanceId", valueOf4.length() != 0 ? "Unexpected response string: ".concat(valueOf4) : new String("Unexpected response string: "));
                        return;
                    } else {
                        return;
                    }
                } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf5 = String.valueOf(action);
                    Log.d("FirebaseInstanceId", valueOf5.length() != 0 ? "Unexpected response action: ".concat(valueOf5) : new String("Unexpected response action: "));
                    return;
                } else {
                    return;
                }
            }
        }
        Log.w("FirebaseInstanceId", "Dropping invalid message");
    }

    private static synchronized void c(Context context, Intent intent) {
        synchronized (f.class) {
            if (f2422a == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                f2422a = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", f2422a);
        }
    }

    private final void f(String str, Bundle bundle) {
        synchronized (this.f2425a) {
            gq0 remove = this.f2425a.remove(str);
            if (remove == null) {
                String valueOf = String.valueOf(str);
                Log.w("FirebaseInstanceId", valueOf.length() != 0 ? "Missing callback for ".concat(valueOf) : new String("Missing callback for "));
                return;
            }
            remove.c(bundle);
        }
    }

    /* access modifiers changed from: package-private */
    public final Bundle a(Bundle bundle) {
        if (this.f2427a.g() < 12000000) {
            return g(bundle);
        }
        try {
            return (Bundle) lq0.a(y91.e(this.f2423a).f(1, bundle));
        } catch (InterruptedException | ExecutionException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
                sb.append("Error making request: ");
                sb.append(valueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            if (!(e.getCause() instanceof pz0) || ((pz0) e.getCause()).a() != 4) {
                return null;
            }
            return g(bundle);
        }
    }

    private final Bundle g(Bundle bundle) {
        Bundle h = h(bundle);
        if (h == null || !h.containsKey("google.messenger")) {
            return h;
        }
        Bundle h2 = h(bundle);
        if (h2 == null || !h2.containsKey("google.messenger")) {
            return h2;
        }
        return null;
    }

    private static synchronized String b() {
        String num;
        synchronized (f.class) {
            int i = a;
            a = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private final android.os.Bundle h(android.os.Bundle r9) {
        /*
            r8 = this;
            java.lang.String r0 = b()
            gq0 r1 = new gq0
            r1.<init>()
            androidx.collection.SimpleArrayMap<java.lang.String, gq0<android.os.Bundle>> r2 = r8.f2425a
            monitor-enter(r2)
            androidx.collection.SimpleArrayMap<java.lang.String, gq0<android.os.Bundle>> r3 = r8.f2425a     // Catch:{ all -> 0x0129 }
            r3.put(r0, r1)     // Catch:{ all -> 0x0129 }
            monitor-exit(r2)     // Catch:{ all -> 0x0129 }
            tz0 r2 = r8.f2427a
            int r2 = r2.a()
            if (r2 == 0) goto L_0x0121
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            java.lang.String r3 = "com.google.android.gms"
            r2.setPackage(r3)
            tz0 r3 = r8.f2427a
            int r3 = r3.a()
            r4 = 2
            if (r3 != r4) goto L_0x0034
            java.lang.String r3 = "com.google.iid.TOKEN_REQUEST"
            r2.setAction(r3)
            goto L_0x0039
        L_0x0034:
            java.lang.String r3 = "com.google.android.c2dm.intent.REGISTER"
            r2.setAction(r3)
        L_0x0039:
            r2.putExtras(r9)
            android.content.Context r9 = r8.f2423a
            c(r9, r2)
            java.lang.String r9 = "kid"
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            int r3 = r3 + 5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r3)
            java.lang.String r3 = "|ID|"
            r5.append(r3)
            r5.append(r0)
            java.lang.String r3 = "|"
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r2.putExtra(r9, r3)
            java.lang.String r9 = "FirebaseInstanceId"
            r3 = 3
            boolean r9 = android.util.Log.isLoggable(r9, r3)
            if (r9 == 0) goto L_0x0098
            java.lang.String r9 = "FirebaseInstanceId"
            android.os.Bundle r5 = r2.getExtras()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r6 = java.lang.String.valueOf(r5)
            int r6 = r6.length()
            int r6 = r6 + 8
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r6)
            java.lang.String r6 = "Sending "
            r7.append(r6)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            android.util.Log.d(r9, r5)
        L_0x0098:
            java.lang.String r9 = "google.messenger"
            android.os.Messenger r5 = r8.f2424a
            r2.putExtra(r9, r5)
            android.os.Messenger r9 = r8.b
            if (r9 != 0) goto L_0x00a7
            com.google.firebase.iid.w r9 = r8.f2426a
            if (r9 == 0) goto L_0x00cb
        L_0x00a7:
            android.os.Message r9 = android.os.Message.obtain()
            r9.obj = r2
            android.os.Messenger r5 = r8.b     // Catch:{ RemoteException -> 0x00bb }
            if (r5 == 0) goto L_0x00b5
            r5.send(r9)     // Catch:{ RemoteException -> 0x00bb }
            goto L_0x00de
        L_0x00b5:
            com.google.firebase.iid.w r5 = r8.f2426a     // Catch:{ RemoteException -> 0x00bb }
            r5.i(r9)     // Catch:{ RemoteException -> 0x00bb }
            goto L_0x00de
        L_0x00bb:
            r9 = move-exception
            java.lang.String r9 = "FirebaseInstanceId"
            boolean r9 = android.util.Log.isLoggable(r9, r3)
            if (r9 == 0) goto L_0x00cb
            java.lang.String r9 = "FirebaseInstanceId"
            java.lang.String r3 = "Messenger failed, fallback to startService"
            android.util.Log.d(r9, r3)
        L_0x00cb:
            tz0 r9 = r8.f2427a
            int r9 = r9.a()
            if (r9 != r4) goto L_0x00d9
            android.content.Context r9 = r8.f2423a
            r9.sendBroadcast(r2)
            goto L_0x00de
        L_0x00d9:
            android.content.Context r9 = r8.f2423a
            r9.startService(r2)
        L_0x00de:
            eq0 r9 = r1.a()     // Catch:{ InterruptedException -> 0x0104, TimeoutException -> 0x0102, ExecutionException -> 0x00fb }
            r1 = 30000(0x7530, double:1.4822E-319)
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x0104, TimeoutException -> 0x0102, ExecutionException -> 0x00fb }
            java.lang.Object r9 = defpackage.lq0.b(r9, r1, r3)     // Catch:{ InterruptedException -> 0x0104, TimeoutException -> 0x0102, ExecutionException -> 0x00fb }
            android.os.Bundle r9 = (android.os.Bundle) r9     // Catch:{ InterruptedException -> 0x0104, TimeoutException -> 0x0102, ExecutionException -> 0x00fb }
            androidx.collection.SimpleArrayMap<java.lang.String, gq0<android.os.Bundle>> r1 = r8.f2425a
            monitor-enter(r1)
            androidx.collection.SimpleArrayMap<java.lang.String, gq0<android.os.Bundle>> r2 = r8.f2425a     // Catch:{ all -> 0x00f6 }
            r2.remove(r0)     // Catch:{ all -> 0x00f6 }
            monitor-exit(r1)     // Catch:{ all -> 0x00f6 }
            return r9
        L_0x00f6:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00f6 }
            throw r9
        L_0x00f9:
            r9 = move-exception
            goto L_0x0114
        L_0x00fb:
            r9 = move-exception
            java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x00f9 }
            r1.<init>(r9)     // Catch:{ all -> 0x00f9 }
            throw r1     // Catch:{ all -> 0x00f9 }
        L_0x0102:
            r9 = move-exception
            goto L_0x0105
        L_0x0104:
            r9 = move-exception
        L_0x0105:
            java.lang.String r9 = "FirebaseInstanceId"
            java.lang.String r1 = "No response"
            android.util.Log.w(r9, r1)     // Catch:{ all -> 0x00f9 }
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x00f9 }
            java.lang.String r1 = "TIMEOUT"
            r9.<init>(r1)     // Catch:{ all -> 0x00f9 }
            throw r9     // Catch:{ all -> 0x00f9 }
        L_0x0114:
            androidx.collection.SimpleArrayMap<java.lang.String, gq0<android.os.Bundle>> r1 = r8.f2425a
            monitor-enter(r1)
            androidx.collection.SimpleArrayMap<java.lang.String, gq0<android.os.Bundle>> r2 = r8.f2425a     // Catch:{ all -> 0x011e }
            r2.remove(r0)     // Catch:{ all -> 0x011e }
            monitor-exit(r1)     // Catch:{ all -> 0x011e }
            throw r9
        L_0x011e:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x011e }
            throw r9
        L_0x0121:
            java.io.IOException r9 = new java.io.IOException
            java.lang.String r0 = "MISSING_INSTANCEID_SERVICE"
            r9.<init>(r0)
            throw r9
        L_0x0129:
            r9 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0129 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.f.h(android.os.Bundle):android.os.Bundle");
    }
}
