package com.blogspot.yemeninfo4it.mumsmobile_app;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.FirebaseLoginActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.MikrotikLoginActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public abstract class mk extends AppCompatActivity {
    public static int a = 10;
    public static String b = "ph";

    /* renamed from: a  reason: collision with other field name */
    public String f1276a = "logged_in";

    public native String mdMM();

    static {
        System.loadLibrary("native-lib");
    }

    public void l(String startdates, String netDates) {
        if (j(startdates, netDates, "yyyy-MM-dd") < ((long) a)) {
            qb0.f4813c = true;
            Intent intent = new Intent(this, MikrotikLoginActivity.class);
            intent.putExtra(mdMM(), true);
            intent.setFlags(268468224);
            startActivity(intent);
            finish();
            return;
        }
        Toast.makeText(this, R.string.account_expier, 0).show();
        startActivity(new Intent(this, FirebaseLoginActivity.class));
        finish();
    }

    public long j(String date1, String date2, String pattern) {
        Date Date1 = null;
        Date Date2 = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.ENGLISH);
            try {
                Date1 = sdf.parse(date1);
                Date2 = sdf.parse(date2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return (Date2.getTime() - Date1.getTime()) / 86400000;
        } catch (Exception e2) {
            Log.i("warning", "Error checking internet connection", e2);
            return 0;
        }
    }

    public void o() {
        ml0.b(this, this.f1276a, "0");
        startActivity(new Intent(this, FirebaseLoginActivity.class));
        finish();
    }

    public String k() {
        return ml0.a(this, "device_id");
    }

    public String m() {
        return getString(R.string.oe145e);
    }

    public void n() {
        qb0.f4813c = true;
        Intent intent = new Intent(this, MikrotikLoginActivity.class);
        intent.putExtra(mdMM(), true);
        intent.setFlags(268468224);
        startActivity(intent);
    }
}
