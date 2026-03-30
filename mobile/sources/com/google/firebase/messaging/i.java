package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Executor;

final class i implements Closeable {
    private eq0<Bitmap> a;

    /* renamed from: a  reason: collision with other field name */
    private volatile InputStream f2462a;

    /* renamed from: a  reason: collision with other field name */
    private final URL f2463a;

    public static i f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new i(new URL(str));
        } catch (MalformedURLException e) {
            String valueOf = String.valueOf(str);
            Log.w("FirebaseMessaging", valueOf.length() != 0 ? "Not downloading image, bad URL: ".concat(valueOf) : new String("Not downloading image, bad URL: "));
            return null;
        }
    }

    private i(URL url) {
        this.f2463a = url;
    }

    public final void o(Executor executor) {
        this.a = lq0.c(executor, new h(this));
    }

    public final eq0<Bitmap> c() {
        return (eq0) y90.j(this.a);
    }

    public final Bitmap q() {
        String valueOf = String.valueOf(this.f2463a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("Starting download of: ");
        sb.append(valueOf);
        Log.i("FirebaseMessaging", sb.toString());
        byte[] w = w();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(w, 0, w.length);
        if (decodeByteArray != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                String valueOf2 = String.valueOf(this.f2463a);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 31);
                sb2.append("Successfully downloaded image: ");
                sb2.append(valueOf2);
                Log.d("FirebaseMessaging", sb2.toString());
            }
            return decodeByteArray;
        }
        String valueOf3 = String.valueOf(this.f2463a);
        StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 24);
        sb3.append("Failed to decode image: ");
        sb3.append(valueOf3);
        throw new IOException(sb3.toString());
    }

    private final byte[] w() {
        URLConnection openConnection = this.f2463a.openConnection();
        if (openConnection.getContentLength() <= 1048576) {
            InputStream inputStream = openConnection.getInputStream();
            try {
                this.f2462a = inputStream;
                byte[] b = g81.b(g81.a(inputStream, 1048577));
                if (inputStream != null) {
                    inputStream.close();
                }
                if (Log.isLoggable("FirebaseMessaging", 2)) {
                    int length = b.length;
                    String valueOf = String.valueOf(this.f2463a);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 34);
                    sb.append("Downloaded ");
                    sb.append(length);
                    sb.append(" bytes from ");
                    sb.append(valueOf);
                    Log.v("FirebaseMessaging", sb.toString());
                }
                if (b.length <= 1048576) {
                    return b;
                }
                throw new IOException("Image exceeds max size of 1048576");
            } catch (Throwable th) {
                t81.b(th, th);
            }
        } else {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        throw th;
    }

    public final void close() {
        try {
            l81.a(this.f2462a);
        } catch (NullPointerException e) {
            Log.e("FirebaseMessaging", "Failed to close the image download stream.", e);
        }
    }
}
