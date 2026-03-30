package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.MikrotikLoginActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.ActiveUser;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUserHotspot;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.ConnectData;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.DeleteUser;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Interface;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.InterfaceList;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Mer;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Payment;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Sessions;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UserProfile;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanCustomer;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanProfile;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: qb0  reason: default package */
public abstract class qb0 {
    public static int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static ConnectData f4797a = null;

    /* renamed from: a  reason: collision with other field name */
    public static Interface f4798a;

    /* renamed from: a  reason: collision with other field name */
    public static j3 f4799a;

    /* renamed from: a  reason: collision with other field name */
    public static String f4800a = "";

    /* renamed from: a  reason: collision with other field name */
    public static DecimalFormat f4801a;

    /* renamed from: a  reason: collision with other field name */
    public static NumberFormat f4802a;

    /* renamed from: a  reason: collision with other field name */
    public static ArrayList<ActiveUser> f4803a = null;

    /* renamed from: a  reason: collision with other field name */
    public static List<String> f4804a = null;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f4805a = true;
    public static int b = 0;

    /* renamed from: b  reason: collision with other field name */
    public static String f4806b = "";

    /* renamed from: b  reason: collision with other field name */
    public static ArrayList<UsermanagerCards> f4807b = null;

    /* renamed from: b  reason: collision with other field name */
    public static List<String> f4808b = null;

    /* renamed from: b  reason: collision with other field name */
    public static boolean f4809b = true;
    public static int c = 0;

    /* renamed from: c  reason: collision with other field name */
    public static String f4810c = "";

    /* renamed from: c  reason: collision with other field name */
    public static ArrayList<UserProfile> f4811c = null;

    /* renamed from: c  reason: collision with other field name */
    public static List<Map<String, String>> f4812c = null;

    /* renamed from: c  reason: collision with other field name */
    public static boolean f4813c = false;
    public static int d = 0;

    /* renamed from: d  reason: collision with other field name */
    public static String f4814d = null;

    /* renamed from: d  reason: collision with other field name */
    public static ArrayList<Sessions> f4815d = null;

    /* renamed from: d  reason: collision with other field name */
    public static List<Map<String, String>> f4816d = null;

    /* renamed from: d  reason: collision with other field name */
    public static boolean f4817d = false;
    public static int e = 0;

    /* renamed from: e  reason: collision with other field name */
    public static String f4818e = null;

    /* renamed from: e  reason: collision with other field name */
    public static ArrayList<Sessions> f4819e = null;

    /* renamed from: e  reason: collision with other field name */
    public static boolean f4820e = false;
    public static int f = 0;

    /* renamed from: f  reason: collision with other field name */
    public static String f4821f = null;

    /* renamed from: f  reason: collision with other field name */
    public static ArrayList<ProfileModel> f4822f = null;

    /* renamed from: f  reason: collision with other field name */
    public static boolean f4823f = false;
    public static int g = 0;

    /* renamed from: g  reason: collision with other field name */
    public static String f4824g = null;

    /* renamed from: g  reason: collision with other field name */
    public static ArrayList<ProfileModel> f4825g = new ArrayList<>();

    /* renamed from: g  reason: collision with other field name */
    public static boolean f4826g = false;
    public static String h = "username";

    /* renamed from: h  reason: collision with other field name */
    public static ArrayList<Sessions> f4827h = null;

    /* renamed from: h  reason: collision with other field name */
    public static boolean f4828h = true;
    public static String i = "all";

    /* renamed from: i  reason: collision with other field name */
    public static ArrayList<Sessions> f4829i = new ArrayList<>();

    /* renamed from: i  reason: collision with other field name */
    public static boolean f4830i = true;
    public static String j = "";

    /* renamed from: j  reason: collision with other field name */
    public static ArrayList<InterfaceList> f4831j = null;

    /* renamed from: j  reason: collision with other field name */
    public static boolean f4832j = false;
    public static String k = "";

    /* renamed from: k  reason: collision with other field name */
    public static ArrayList<Payment> f4833k = null;
    public static String l = "";

    /* renamed from: l  reason: collision with other field name */
    public static ArrayList<HotspotCard> f4834l = null;
    public static String m = "l_data";

    /* renamed from: m  reason: collision with other field name */
    public static ArrayList<AddUser> f4835m = null;
    public static ArrayList<AddUser> n = null;
    public static ArrayList<AddUserHotspot> o = null;
    public static ArrayList<UsermanProfile> p = null;
    public static ArrayList<UsermanCustomer> q = null;
    public static ArrayList<DeleteUser> r = null;
    public static ArrayList<Mer> s = new ArrayList<>();

    static {
        NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.ENGLISH);
        f4802a = numberInstance;
        f4801a = (DecimalFormat) numberInstance;
    }

    public static j3 d() {
        return f4799a;
    }

    public static void i(j3 apiConnection) {
        f4799a = apiConnection;
    }

    public static List<Map<String, Object>> f(String name) {
        List<Map<String, Object>> strList = new ArrayList<>();
        if (f4825g.size() > 0) {
            for (int i2 = 0; i2 < f4825g.size(); i2++) {
                if (f4825g.get(i2).getName().equals(name)) {
                    Map<String, Object> m2 = new HashMap<>();
                    m2.put("name", f4825g.get(i2).getName());
                    m2.put("transmit_limit", f4825g.get(i2).getTrans_limit());
                    m2.put("time_limit", f4825g.get(i2).getTime_limit());
                    m2.put("download_limit", f4825g.get(i2).getDownload_limit());
                    strList.add(m2);
                }
            }
        }
        return strList;
    }

    public static String e(String inpu) {
        double sm2;
        String trans_str_u;
        f4801a.applyPattern("#.##");
        double sm = (inpu == null || inpu.isEmpty()) ? 0.0d : Double.parseDouble(inpu) / 1024.0d;
        if (sm >= 1024.0d) {
            sm2 = sm / 1024.0d;
            trans_str_u = "ميجا";
            if (sm2 >= 1024.0d) {
                sm2 /= 1024.0d;
                trans_str_u = "جيجا";
            }
        } else {
            sm2 = sm;
            trans_str_u = "كيلو";
        }
        return f4801a.format(sm2) + " " + trans_str_u;
    }

    public static <Sessions> ArrayList<Sessions> h(ArrayList<Sessions> list) {
        ArrayList<Sessions> newList = new ArrayList<>();
        Iterator<Sessions> it = list.iterator();
        while (it.hasNext()) {
            Sessions element = it.next();
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }

    public static void c(Context cont) {
        if (f4813c) {
            Intent intent = new Intent(cont, MikrotikLoginActivity.class);
            intent.putExtra(m, true);
            intent.setFlags(268468224);
            cont.startActivity(intent);
            return;
        }
        System.exit(0);
    }

    public static void g(String name, String transmit_limit, String time_limit, String download_limit) {
        f4825g.add(new ProfileModel("1", name, "0", transmit_limit, download_limit, time_limit, "0", "0", "0", "0"));
    }

    public static void j() {
        ArrayList<UsermanagerCards> arrayList = f4807b;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<UsermanagerCards> it = f4807b.iterator();
            while (it.hasNext()) {
                it.next().setSelected(false);
            }
        }
    }

    public static void a(Activity activity) {
        System.exit(0);
    }

    public static void b(Activity activity) {
        if (!activity.getIntent().getExtras().getBoolean("l_data")) {
            f4813c = false;
            System.exit(0);
        }
    }
}
