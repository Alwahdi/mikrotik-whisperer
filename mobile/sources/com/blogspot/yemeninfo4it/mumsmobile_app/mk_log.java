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

public abstract class mk_log extends AppCompatActivity {
    public static int a = 10;

    /* renamed from: a  reason: collision with other field name */
    public static String f1277a = "ph";

    public native String dRde();

    static {
        System.loadLibrary("native-lib");
    }

    public void k(String startdates, String netDates, String ed_mobile_num) {
        if (j(startdates, netDates, "yyyy-MM-dd") < ((long) a)) {
            qb0.f4813c = true;
            ml0.b(this, "logged_in", "1");
            ml0.b(this, "pho", ed_mobile_num);
            Intent intent = new Intent(this, MikrotikLoginActivity.class);
            intent.putExtra(dRde(), true);
            startActivity(intent);
            FirebaseLoginActivity.a.dismiss();
            return;
        }
        FirebaseLoginActivity.a.dismiss();
        Toast.makeText(this, R.string.account_expier, 0).show();
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

    public String l() {
        return getString(R.string.oe145e);
    }

    public void m(String ed_mobile_num) {
        qb0.f4813c = true;
        ml0.b(this, "logged_in", "1");
        ml0.b(this, "pho", ed_mobile_num);
        Intent intent = new Intent(this, MikrotikLoginActivity.class);
        intent.putExtra(dRde(), true);
        FirebaseLoginActivity.a.dismiss();
        startActivity(intent);
    }
}
