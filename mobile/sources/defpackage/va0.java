package defpackage;

import android.os.Process;
import android.os.StrictMode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* renamed from: va0  reason: default package */
public abstract class va0 {
    private static int a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static String f5382a = null;

    public static String a() {
        if (f5382a == null) {
            if (a == 0) {
                a = Process.myPid();
            }
            f5382a = b(a);
        }
        return f5382a;
    }

    private static String b(int i) {
        BufferedReader bufferedReader;
        Throwable th;
        String str = null;
        if (i <= 0) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder(25);
            sb.append("/proc/");
            sb.append(i);
            sb.append("/cmdline");
            bufferedReader = c(sb.toString());
            try {
                str = bufferedReader.readLine().trim();
                jr.a(bufferedReader);
            } catch (IOException e) {
                jr.a(bufferedReader);
                return str;
            } catch (Throwable th2) {
                th = th2;
                jr.a(bufferedReader);
                throw th;
            }
        } catch (IOException e2) {
            bufferedReader = null;
            jr.a(bufferedReader);
            return str;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            jr.a(bufferedReader);
            throw th;
        }
        return str;
    }

    private static BufferedReader c(String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return new BufferedReader(new FileReader(str));
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
