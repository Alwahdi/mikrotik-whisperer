package com.google.android.datatransport.cct;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.android.datatransport.cct.a.j;
import com.google.android.datatransport.cct.a.l;
import com.google.android.datatransport.cct.a.n;
import com.google.android.datatransport.cct.a.o;
import com.google.android.datatransport.cct.a.q;
import com.google.android.datatransport.cct.a.s;
import defpackage.aj;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.protocol.HTTP;

final class d implements ds0 {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final ConnectivityManager f1360a;

    /* renamed from: a  reason: collision with other field name */
    private final c9 f1361a;

    /* renamed from: a  reason: collision with other field name */
    final URL f1362a;

    /* renamed from: a  reason: collision with other field name */
    private final pe f1363a = n.a();
    private final c9 b;

    static final class a {
        final j a;

        /* renamed from: a  reason: collision with other field name */
        final String f1364a;

        /* renamed from: a  reason: collision with other field name */
        final URL f1365a;

        a(URL url, j jVar, String str) {
            this.f1365a = url;
            this.a = jVar;
            this.f1364a = str;
        }

        /* access modifiers changed from: package-private */
        public a a(URL url) {
            return new a(url, this.a, this.f1364a);
        }
    }

    static final class b {
        final int a;

        /* renamed from: a  reason: collision with other field name */
        final long f1366a;

        /* renamed from: a  reason: collision with other field name */
        final URL f1367a;

        b(int i, URL url, long j) {
            this.a = i;
            this.f1367a = url;
            this.f1366a = j;
        }
    }

    d(Context context, c9 c9Var, c9 c9Var2) {
        this.f1360a = (ConnectivityManager) context.getSystemService("connectivity");
        this.f1362a = f(a.c);
        this.f1361a = c9Var2;
        this.b = c9Var;
        this.a = 40000;
    }

    private static URL f(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid url: " + str, e);
        }
    }

    public aj a(aj ajVar) {
        int i;
        int i2;
        NetworkInfo activeNetworkInfo = this.f1360a.getActiveNetworkInfo();
        aj.a c = ajVar.l().a("sdk-version", Build.VERSION.SDK_INT).c("model", Build.MODEL).c("hardware", Build.HARDWARE).c("device", Build.DEVICE).c("product", Build.PRODUCT).c("os-uild", Build.ID).c("manufacturer", Build.MANUFACTURER).c("fingerprint", Build.FINGERPRINT);
        Calendar.getInstance();
        aj.a b2 = c.b("tz-offset", (long) (TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000));
        if (activeNetworkInfo == null) {
            i = s.c.NONE.zza();
        } else {
            i = activeNetworkInfo.getType();
        }
        aj.a a2 = b2.a("net-type", i);
        if (activeNetworkInfo == null) {
            i2 = s.b.UNKNOWN_MOBILE_SUBTYPE.zza();
        } else {
            i2 = activeNetworkInfo.getSubtype();
            if (i2 == -1) {
                i2 = s.b.COMBINED.zza();
            } else if (s.b.zza(i2) == null) {
                i2 = 0;
            }
        }
        return a2.a("mobile-subtype", i2).d();
    }

    public com.google.android.datatransport.runtime.backends.b b(i5 i5Var) {
        o.a aVar;
        HashMap hashMap = new HashMap();
        for (aj next : i5Var.b()) {
            String j = next.j();
            if (!hashMap.containsKey(j)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                hashMap.put(j, arrayList);
            } else {
                ((List) hashMap.get(j)).add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            aj ajVar = (aj) ((List) entry.getValue()).get(0);
            q.a d = q.a().c(com.google.android.datatransport.cct.a.b.DEFAULT).b(this.b.a()).i(this.f1361a.a()).d(l.a().b(l.b.ANDROID).a(com.google.android.datatransport.cct.a.a.a().a(ajVar.g("sdk-version")).g(ajVar.b("model")).e(ajVar.b("hardware")).b(ajVar.b("device")).i(ajVar.b("product")).h(ajVar.b("os-uild")).f(ajVar.b("manufacturer")).d(ajVar.b("fingerprint")).c()).c());
            try {
                d.h(Integer.valueOf((String) entry.getKey()).intValue());
            } catch (NumberFormatException e) {
                d.j((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (aj ajVar2 : (List) entry.getValue()) {
                pi e2 = ajVar2.e();
                qi b2 = e2.b();
                if (b2.equals(qi.b("proto"))) {
                    aVar = o.c(e2.a());
                } else if (b2.equals(qi.b("json"))) {
                    aVar = o.b(new String(e2.a(), Charset.forName(HTTP.UTF_8)));
                } else {
                    xy.f("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", b2);
                }
                aVar.b(ajVar2.f()).g(ajVar2.k()).h(ajVar2.h("tz-offset")).c(s.a().b(s.c.zza(ajVar2.g("net-type"))).a(s.b.zza(ajVar2.g("mobile-subtype"))).c());
                if (ajVar2.d() != null) {
                    aVar.a(ajVar2.d().intValue());
                }
                arrayList3.add(aVar.f());
            }
            d.f(arrayList3);
            arrayList2.add(d.g());
        }
        j a2 = j.a(arrayList2);
        String str = null;
        URL url = this.f1362a;
        if (i5Var.c() != null) {
            try {
                a d2 = a.d(i5Var.c());
                if (d2.e() != null) {
                    str = d2.e();
                }
                if (d2.f() != null) {
                    url = f(d2.f());
                }
            } catch (IllegalArgumentException e3) {
                return com.google.android.datatransport.runtime.backends.b.a();
            }
        }
        try {
            b bVar = (b) ve0.a(5, new a(url, a2, str), b.a(this), c.b());
            int i = bVar.a;
            if (i == 200) {
                return com.google.android.datatransport.runtime.backends.b.d(bVar.f1366a);
            }
            if (i < 500) {
                if (i != 404) {
                    return com.google.android.datatransport.runtime.backends.b.a();
                }
            }
            return com.google.android.datatransport.runtime.backends.b.e();
        } catch (IOException e4) {
            xy.c("CctTransportBackend", "Could not make request to the backend", e4);
            return com.google.android.datatransport.runtime.backends.b.e();
        }
    }

    /* access modifiers changed from: private */
    public b d(a aVar) {
        GZIPOutputStream gZIPOutputStream;
        InputStream inputStream;
        xy.a("CctTransportBackend", "Making request to: %s", aVar.f1365a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.f1365a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.a);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", new Object[]{"2.2.0"}));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "gzip");
        String str = aVar.f1364a;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        WritableByteChannel newChannel = Channels.newChannel(httpURLConnection.getOutputStream());
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                this.f1363a.a(aVar.a, new OutputStreamWriter(gZIPOutputStream));
                gZIPOutputStream.close();
                newChannel.write(ByteBuffer.wrap(byteArrayOutputStream.toByteArray()));
                int responseCode = httpURLConnection.getResponseCode();
                StringBuilder sb = new StringBuilder();
                sb.append("Status Code: ");
                sb.append(responseCode);
                xy.e("CctTransportBackend", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Content-Type: ");
                sb2.append(httpURLConnection.getHeaderField("Content-Type"));
                xy.e("CctTransportBackend", sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Content-Encoding: ");
                sb3.append(httpURLConnection.getHeaderField("Content-Encoding"));
                xy.e("CctTransportBackend", sb3.toString());
                if (!(responseCode == 302 || responseCode == 301)) {
                    if (responseCode != 307) {
                        if (responseCode != 200) {
                            b bVar = new b(responseCode, (URL) null, 0);
                            newChannel.close();
                            return bVar;
                        }
                        String headerField = httpURLConnection.getHeaderField("Content-Encoding");
                        if (headerField == null || !headerField.equals("gzip")) {
                            inputStream = httpURLConnection.getInputStream();
                        } else {
                            inputStream = new GZIPInputStream(httpURLConnection.getInputStream());
                        }
                        b bVar2 = new b(responseCode, (URL) null, da1.b(new InputStreamReader(inputStream)).a());
                        inputStream.close();
                        newChannel.close();
                        return bVar2;
                    }
                }
                b bVar3 = new b(responseCode, new URL(httpURLConnection.getHeaderField(HttpHeaders.LOCATION)), 0);
                newChannel.close();
                return bVar3;
            } catch (IOException | ri e) {
                xy.c("CctTransportBackend", "Couldn't encode request, returning with 400", e);
                b bVar4 = new b(HttpStatus.SC_BAD_REQUEST, (URL) null, 0);
                gZIPOutputStream.close();
                newChannel.close();
                return bVar4;
            }
        } catch (Throwable th) {
            newChannel.close();
            throw th;
        }
    }

    static /* synthetic */ a c(a aVar, b bVar) {
        URL url = bVar.f1367a;
        if (url == null) {
            return null;
        }
        xy.a("CctTransportBackend", "Following redirect to: %s", url);
        return aVar.a(bVar.f1367a);
    }
}
