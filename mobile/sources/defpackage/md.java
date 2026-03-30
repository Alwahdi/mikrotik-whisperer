package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/* renamed from: md  reason: default package */
public class md {
    private static List<md> a;

    /* renamed from: a  reason: collision with other field name */
    public static final md[] f4324a = {new md("YE", "الجمهورية اليمنية", "+967", R.drawable.flag_ye), new md("PS", "فلسطين", "+970", R.drawable.flag_ps), new md("AE", "الامارات", "+971", R.drawable.flag_ae), new md("DZ", "الجزائر", "+213", R.drawable.flag_dz), new md("EG", "مصر", "+20", R.drawable.flag_eg), new md("IQ", "جمهورية العراق", "+964", R.drawable.flag_iq), new md("KW", "الكويت", "+965", R.drawable.flag_kw), new md("LY", "ليبيا", "+218", R.drawable.flag_ly), new md("JO", "الاردن", "+962", R.drawable.flag_jo), new md("MA", "المغرب", "+212", R.drawable.flag_ma), new md("BH", "البحرين", "+973", R.drawable.flag_bh), new md("QA", "قطر", "+974", R.drawable.flag_qa), new md("LB", "لبنان", "+961", R.drawable.flag_lb), new md("SA", "المملكة العربية السعودية", "+966", R.drawable.flag_sa), new md("SD", "السودان", "+249", R.drawable.flag_sd), new md("SS", "شمال السودان", "+211", R.drawable.flag_ss), new md("SY", "الجمهورية العربية السورية", "+963", R.drawable.flag_sy)};

    /* renamed from: a  reason: collision with other field name */
    private int f4325a = -1;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public String f4326a;
    private String b;
    private String c;

    public md(String code, String name, String dialCode, int flag) {
        this.f4326a = code;
        this.b = name;
        this.c = dialCode;
        this.f4325a = flag;
    }

    public md() {
    }

    public static List<md> b() {
        if (a == null) {
            a = Arrays.asList(f4324a);
        }
        return a;
    }

    public static md d(String countryIsoCode) {
        String countryIsoCode2 = countryIsoCode.toUpperCase();
        md c2 = new md();
        c2.j(countryIsoCode2);
        md[] mdVarArr = f4324a;
        int i = Arrays.binarySearch(mdVarArr, c2, new a());
        if (i < 0) {
            return null;
        }
        return mdVarArr[i];
    }

    public static md e(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager.getSimState() != 1) {
            return d(telephonyManager.getSimCountryIso());
        }
        return null;
    }

    public String f() {
        return this.c;
    }

    public String c() {
        return this.f4326a;
    }

    public void j(String code) {
        this.f4326a = code;
        if (TextUtils.isEmpty(this.b)) {
            this.b = new Locale("", code).getDisplayName();
        }
    }

    public String h() {
        return this.b;
    }

    public int g() {
        return this.f4325a;
    }

    public void i(Context context) {
        if (this.f4325a == -1) {
            try {
                Resources resources = context.getResources();
                this.f4325a = resources.getIdentifier("flag_" + this.f4326a.toLowerCase(Locale.ENGLISH), "drawable", context.getPackageName());
            } catch (Exception e) {
                e.printStackTrace();
                this.f4325a = -1;
            }
        }
    }

    /* renamed from: md$a */
    public static class a implements Comparator<md> {
        /* renamed from: a */
        public int compare(md country, md t1) {
            return country.f4326a.compareTo(t1.f4326a);
        }
    }
}
