package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.core.location.LocationRequestCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;
import org.apache.http.protocol.HTTP;

final class h0 {
    h0() {
    }

    /* access modifiers changed from: package-private */
    public final j0 a(Context context, String str) {
        j0 l = l(context, str);
        if (l != null) {
            return l;
        }
        return j(context, str);
    }

    /* access modifiers changed from: package-private */
    public final j0 j(Context context, String str) {
        j0 j0Var = new j0(tz0.d(i11.a().getPublic()), System.currentTimeMillis());
        j0 b = b(context, str, j0Var, true);
        if (b == null || b.equals(j0Var)) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Generated new key");
            }
            h(context, str, j0Var);
            return j0Var;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Loaded key after generating new one, using loaded one");
        }
        return b;
    }

    static void g(Context context) {
        for (File file : k(context).listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
    }

    private final j0 l(Context context, String str) {
        try {
            j0 m = m(context, str);
            if (m != null) {
                h(context, str, m);
                return m;
            }
            e = null;
            try {
                j0 c = c(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
                if (c != null) {
                    b(context, str, c, false);
                    return c;
                }
            } catch (k0 e) {
                e = e;
            }
            if (e == null) {
                return null;
            }
            throw e;
        } catch (k0 e2) {
            e = e2;
        }
    }

    private static PublicKey f(String str) {
        try {
            try {
                return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 8)));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 19);
                sb.append("Invalid key stored ");
                sb.append(valueOf);
                Log.w("FirebaseInstanceId", sb.toString());
                throw new k0((Exception) e);
            }
        } catch (IllegalArgumentException e2) {
            throw new k0((Exception) e2);
        }
    }

    private final j0 m(Context context, String str) {
        File n = n(context, str);
        if (!n.exists()) {
            return null;
        }
        try {
            return d(n);
        } catch (k0 | IOException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39);
                sb.append("Failed to read ID from file, retrying: ");
                sb.append(valueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            try {
                return d(n);
            } catch (IOException e2) {
                String valueOf2 = String.valueOf(e2);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 45);
                sb2.append("IID file exists, but failed to read from it: ");
                sb2.append(valueOf2);
                Log.w("FirebaseInstanceId", sb2.toString());
                throw new k0((Exception) e2);
            }
        }
    }

    private final j0 b(Context context, String str, j0 j0Var, boolean z) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Writing ID to properties file");
        }
        Properties properties = new Properties();
        properties.setProperty("id", j0Var.b());
        properties.setProperty("cre", String.valueOf(j0Var.a));
        File n = n(context, str);
        try {
            n.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(n, "rw");
            try {
                FileChannel channel = randomAccessFile.getChannel();
                try {
                    channel.lock();
                    if (z && channel.size() > 0) {
                        channel.position(0);
                        j0 e = e(channel);
                        channel.close();
                        randomAccessFile.close();
                        return e;
                    }
                } catch (k0 | IOException e2) {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        String valueOf = String.valueOf(e2);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 58);
                        sb.append("Tried reading ID before writing new one, but failed with: ");
                        sb.append(valueOf);
                        Log.d("FirebaseInstanceId", sb.toString());
                    }
                } catch (Throwable th) {
                    if (channel != null) {
                        channel.close();
                    }
                    throw th;
                }
                channel.truncate(0);
                properties.store(Channels.newOutputStream(channel), (String) null);
                channel.close();
                randomAccessFile.close();
                return j0Var;
            } catch (Throwable th2) {
                randomAccessFile.close();
                throw th2;
            }
        } catch (IOException e3) {
            String valueOf2 = String.valueOf(e3);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 21);
            sb2.append("Failed to write key: ");
            sb2.append(valueOf2);
            Log.w("FirebaseInstanceId", sb2.toString());
            return null;
        } catch (Throwable th3) {
            t81.b(th2, th3);
        }
    }

    private static File k(Context context) {
        File noBackupFilesDir = ContextCompat.getNoBackupFilesDir(context);
        if (noBackupFilesDir != null && noBackupFilesDir.isDirectory()) {
            return noBackupFilesDir;
        }
        Log.w("FirebaseInstanceId", "noBackupFilesDir doesn't exist, using regular files directory instead");
        return context.getFilesDir();
    }

    private static File n(Context context, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "com.google.InstanceId.properties";
        } else {
            try {
                String encodeToString = Base64.encodeToString(str.getBytes(HTTP.UTF_8), 11);
                StringBuilder sb = new StringBuilder(String.valueOf(encodeToString).length() + 33);
                sb.append("com.google.InstanceId_");
                sb.append(encodeToString);
                sb.append(".properties");
                str2 = sb.toString();
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return new File(k(context), str2);
    }

    private final j0 d(File file) {
        FileChannel channel;
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            channel = fileInputStream.getChannel();
            channel.lock(0, LocationRequestCompat.PASSIVE_INTERVAL, true);
            j0 e = e(channel);
            channel.close();
            fileInputStream.close();
            return e;
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                t81.b(th, th2);
            }
            throw th;
        }
        throw th;
    }

    private static j0 e(FileChannel fileChannel) {
        Properties properties = new Properties();
        properties.load(Channels.newInputStream(fileChannel));
        try {
            long parseLong = Long.parseLong(properties.getProperty("cre"));
            String property = properties.getProperty("id");
            if (property == null) {
                String property2 = properties.getProperty("pub");
                if (property2 != null) {
                    property = tz0.d(f(property2));
                } else {
                    throw new k0("Invalid properties file");
                }
            }
            return new j0(property, parseLong);
        } catch (NumberFormatException e) {
            throw new k0((Exception) e);
        }
    }

    private static j0 c(SharedPreferences sharedPreferences, String str) {
        long i = i(sharedPreferences, str);
        String string = sharedPreferences.getString(k.c(str, "id"), (String) null);
        if (string == null) {
            String string2 = sharedPreferences.getString(k.c(str, "|P|"), (String) null);
            if (string2 == null) {
                return null;
            }
            string = tz0.d(f(string2));
        }
        return new j0(string, i);
    }

    private final void h(Context context, String str, j0 j0Var) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        try {
            if (j0Var.equals(c(sharedPreferences, str))) {
                return;
            }
        } catch (k0 e) {
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Writing key to shared preferences");
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(k.c(str, "id"), j0Var.b());
        edit.putString(k.c(str, "cre"), String.valueOf(j0Var.a));
        edit.commit();
    }

    private static long i(SharedPreferences sharedPreferences, String str) {
        String string = sharedPreferences.getString(k.c(str, "cre"), (String) null);
        if (string == null) {
            return 0;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
