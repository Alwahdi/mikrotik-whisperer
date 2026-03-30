package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* renamed from: in0  reason: default package */
public class in0 {
    private static in0 a;
    private static final Lock b = new ReentrantLock();

    /* renamed from: a  reason: collision with other field name */
    private final SharedPreferences f3264a;

    /* renamed from: a  reason: collision with other field name */
    private final Lock f3265a = new ReentrantLock();

    public static in0 a(Context context) {
        y90.j(context);
        Lock lock = b;
        lock.lock();
        try {
            if (a == null) {
                a = new in0(context.getApplicationContext());
            }
            in0 in0 = a;
            lock.unlock();
            return in0;
        } catch (Throwable th) {
            b.unlock();
            throw th;
        }
    }

    private in0(Context context) {
        this.f3264a = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public GoogleSignInAccount b() {
        return d(e("defaultGoogleSignInAccount"));
    }

    private final GoogleSignInAccount d(String str) {
        String e;
        if (TextUtils.isEmpty(str) || (e = e(c("googleSignInAccount", str))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.y(e);
        } catch (JSONException e2) {
            return null;
        }
    }

    private final String e(String str) {
        this.f3265a.lock();
        try {
            return this.f3264a.getString(str, (String) null);
        } finally {
            this.f3265a.unlock();
        }
    }

    private static String c(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }
}
