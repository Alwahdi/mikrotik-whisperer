package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.SalesPointModel;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Sessions;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import org.apache.http.cookie.ClientCookie;

/* renamed from: ue  reason: default package */
public class ue extends SQLiteOpenHelper {
    public static Context a;

    /* renamed from: a  reason: collision with other field name */
    public static ue f5241a;

    /* renamed from: a  reason: collision with other field name */
    public SQLiteDatabase f5242a;

    /* renamed from: a  reason: collision with other field name */
    final String f5243a = "mLog";
    String b = "user_manager_added";

    public ue(Context context) {
        super(context, "Oryx.db", (SQLiteDatabase.CursorFactory) null, 15);
        if (f5241a == null) {
            f5241a = this;
            a = context;
            this.f5242a = getWritableDatabase();
        }
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE user_data (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,password TEXT,phone TEXT,starttime TEXT,login_status TEXT) ");
        db.execSQL("CREATE TABLE hotspot_profile (id INTEGER PRIMARY KEY AUTOINCREMENT,profile_name TEXT,limit_time TEXT,limit_download TEXT,limit_day TEXT,price TEXT,user_legnth TEXT,pass_legnth TEXT,card_size TEXT,image_url TEXT,user_position_x TEXT,user_position_y TEXT,pass_position_x TEXT,pass_position_y TEXT,selected_profile TEXT,hide_pass TEXT,profile TEXT,char_with_num TEXT,name_with_pass TEXT,minute_time TEXT,motabka TEXT,mega_giga TEXT,card_size_col TEXT,slspoint_position_x TEXT,slspoint_position_y TEXT,serial_position_x TEXT,serial_position_y TEXT)");
        db.execSQL("CREATE TABLE login_data  (id INTEGER PRIMARY KEY AUTOINCREMENT,ipaddress TEXT,username TEXT,password TEXT,port TEXT) ");
        db.execSQL("CREATE TABLE user_manager_added (id INTEGER PRIMARY KEY AUTOINCREMENT,u_id TEXT,username TEXT,password TEXT,profilename TEXT,insertdate TEXT,router_mac TEXT,uptime_used TEXT,download_used TEXT,upload_used TEXT,disabled TEXT,last_seen TEXT,status TEXT,sales_id INTEGER,serial_num TEXT,col2 TEXT) ");
        db.execSQL("CREATE TABLE user_manager_sales (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,price TEXT,st_from TEXT,nas_port_id TEXT,session_id TEXT,insertdate TEXT,router_mac TEXT,date1 TEXT,download TEXT,upload TEXT,uptime TEXT) ");
        db.execSQL("CREATE TABLE user_manager_sales_cach (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,price TEXT,st_from TEXT,nas_port_id TEXT,session_id_c TEXT,insertdate TEXT,router_mac TEXT,date1 TEXT,download TEXT,upload TEXT,uptime TEXT) ");
        db.execSQL("CREATE TABLE user_manager_deleted (id INTEGER PRIMARY KEY AUTOINCREMENT,u_id TEXT,username TEXT,password TEXT,profilename TEXT,custmoer TEXT,deletedate TEXT,router_mac TEXT,download_used TEXT,uptime_used TEXT) ");
        db.execSQL("CREATE TABLE hotpot_added (id INTEGER PRIMARY KEY AUTOINCREMENT,h_id TEXT,username TEXT,password TEXT,profilename TEXT,time_limt TEXT,download_limt TEXT,day_limt TEXT,price TEXT,insertdate TEXT,router_mac TEXT,sales_id INTEGER,serial_num TEXT,col2 TEXT) ");
        db.execSQL("CREATE TABLE hotpot_sales (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,price TEXT,st_from TEXT,user_id TEXT,insertdate TEXT,router_mac TEXT,date1 TEXT,download TEXT,upload TEXT,uptime TEXT) ");
        db.execSQL("CREATE TABLE hotpot_sales_cach (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,price TEXT,st_from TEXT,user_id TEXT,insertdate TEXT,router_mac TEXT,date1 TEXT,download TEXT,upload TEXT,uptime TEXT) ");
        db.execSQL("CREATE TABLE hotpot_deleted (id INTEGER PRIMARY KEY AUTOINCREMENT,h_id TEXT,username TEXT,password TEXT,profilename TEXT,deletedate TEXT,router_mac TEXT,download_used TEXT,uptime_used TEXT,day_used TEXT) ");
        db.execSQL("CREATE TABLE userman_profile (id INTEGER PRIMARY KEY AUTOINCREMENT,profile_name TEXT,profile TEXT,char_with_num TEXT,name_with_pass TEXT,motabka TEXT,user_legnth TEXT,pass_legnth TEXT,card_size TEXT,image_url TEXT,user_position_x TEXT,user_position_y TEXT,pass_position_x TEXT,pass_position_y TEXT,hide_pass TEXT,connect_with_mac TEXT,card_size_col TEXT,slspoint_position_x TEXT,slspoint_position_y TEXT,serial_position_x TEXT,serial_position_y TEXT) ");
        db.execSQL("CREATE TABLE IF NOT EXISTS salesPoints (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,other1 TEXT,other2 TEXT,other3 TEXT) ");
        db.execSQL("CREATE UNIQUE INDEX idx_session_id ON user_manager_sales (session_id);");
        db.execSQL("CREATE UNIQUE INDEX idx_user_id ON hotpot_sales (user_id);");
    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        Log.w("DatabaseHelper", "Upgrading database from version " + i + " to " + i1 + ", which will destroy all old data");
        db.execSQL("CREATE TABLE IF NOT EXISTS salesPoints (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,other1 TEXT,other2 TEXT,other3 TEXT) ");
        try {
            db.execSQL("ALTER TABLE hotspot_profile ADD COLUMN slspoint_position_x TEXT");
        } catch (SQLiteException ex) {
            Log.w("DatabaseHelper", "Altering shops: " + ex.getMessage());
        }
        try {
            db.execSQL("ALTER TABLE hotspot_profile ADD COLUMN slspoint_position_y TEXT");
        } catch (SQLiteException ex2) {
            Log.w("DatabaseHelper", "Altering shops: " + ex2.getMessage());
        }
        try {
            db.execSQL("ALTER TABLE hotspot_profile ADD COLUMN serial_position_x TEXT");
        } catch (SQLiteException ex3) {
            Log.w("DatabaseHelper", "Altering shops: " + ex3.getMessage());
        }
        try {
            db.execSQL("ALTER TABLE hotspot_profile ADD COLUMN serial_position_y TEXT");
        } catch (SQLiteException ex4) {
            Log.w("DatabaseHelper", "Altering shops: " + ex4.getMessage());
        }
        try {
            db.execSQL("ALTER TABLE userman_profile ADD COLUMN slspoint_position_x TEXT");
        } catch (SQLiteException ex5) {
            Log.w("DatabaseHelper", "Altering shops: " + ex5.getMessage());
        }
        try {
            db.execSQL("ALTER TABLE userman_profile ADD COLUMN slspoint_position_y TEXT");
        } catch (SQLiteException ex6) {
            Log.w("DatabaseHelper", "Altering shops: " + ex6.getMessage());
        }
        try {
            db.execSQL("ALTER TABLE userman_profile ADD COLUMN serial_position_x TEXT");
        } catch (SQLiteException ex7) {
            Log.w("DatabaseHelper", "Altering shops: " + ex7.getMessage());
        }
        try {
            db.execSQL("ALTER TABLE userman_profile ADD COLUMN serial_position_y TEXT");
        } catch (SQLiteException ex8) {
            Log.w("DatabaseHelper", "Altering shops: " + ex8.getMessage());
        }
        try {
            db.execSQL("ALTER TABLE user_manager_added ADD COLUMN sales_id INTEGER");
        } catch (SQLiteException ex9) {
            Log.w("DatabaseHelper", "Altering shops: " + ex9.getMessage());
        }
        try {
            db.execSQL("ALTER TABLE user_manager_added ADD COLUMN serial_num TEXT");
        } catch (SQLiteException ex10) {
            Log.w("DatabaseHelper", "Altering shops: " + ex10.getMessage());
        }
        try {
            db.execSQL("ALTER TABLE user_manager_added ADD COLUMN col2 TEXT");
        } catch (SQLiteException ex11) {
            Log.w("DatabaseHelper", "Altering shops: " + ex11.getMessage());
        }
        try {
            db.execSQL("ALTER TABLE hotpot_added ADD COLUMN sales_id INTEGER");
            db.execSQL("ALTER TABLE hotpot_added ADD COLUMN serial_num TEXT");
            db.execSQL("ALTER TABLE hotpot_added ADD COLUMN col2 TEXT");
        } catch (SQLiteException ex12) {
            Log.w("DatabaseHelper", "Altering shops: " + ex12.getMessage());
        }
        try {
            db.execSQL("ALTER TABLE user_manager_sales_cach ADD COLUMN download TEXT");
            db.execSQL("ALTER TABLE user_manager_sales_cach ADD COLUMN upload TEXT");
            db.execSQL("ALTER TABLE user_manager_sales_cach ADD COLUMN uptime TEXT");
        } catch (SQLiteException ex13) {
            Log.w("DatabaseHelper", "Altering shops: " + ex13.getMessage());
        }
        try {
            db.execSQL("ALTER TABLE user_manager_sales ADD COLUMN download TEXT");
            db.execSQL("ALTER TABLE user_manager_sales ADD COLUMN upload TEXT");
            db.execSQL("ALTER TABLE user_manager_sales ADD COLUMN uptime TEXT");
        } catch (SQLiteException ex14) {
            Log.w("DatabaseHelper", "Altering shops: " + ex14.getMessage());
        }
        try {
            db.execSQL("ALTER TABLE hotpot_sales_cach ADD COLUMN download TEXT");
            db.execSQL("ALTER TABLE hotpot_sales_cach ADD COLUMN upload TEXT");
            db.execSQL("ALTER TABLE hotpot_sales_cach ADD COLUMN uptime TEXT");
        } catch (SQLiteException ex15) {
            Log.w("DatabaseHelper", "Altering shops: " + ex15.getMessage());
        }
        try {
            db.execSQL("ALTER TABLE hotpot_sales ADD COLUMN download TEXT");
            db.execSQL("ALTER TABLE hotpot_sales ADD COLUMN upload TEXT");
            db.execSQL("ALTER TABLE hotpot_sales ADD COLUMN uptime TEXT");
        } catch (SQLiteException ex16) {
            Log.w("DatabaseHelper", "Altering shops: " + ex16.getMessage());
        }
    }

    public void b0() {
        try {
            SQLiteDatabase db = getWritableDatabase();
            Cursor data2 = db.rawQuery("SELECT COUNT(id) FROM hotpot_added", (String[]) null);
            data2.moveToFirst();
            int c2 = data2.getInt(0);
            Cursor data = db.rawQuery("SELECT COUNT(id) FROM user_manager_added", (String[]) null);
            data.moveToFirst();
            if (data.getInt(0) > 20000) {
                db.execSQL("delete from user_manager_added where id in (select id from user_manager_added order by id limit 1000)");
            }
            if (c2 > 20000) {
                db.execSQL("delete from hotpot_added where id in (select id from hotpot_added order by id limit 1000)");
            }
        } catch (Exception e) {
            Log.d("DAMMAG", "Deleted: " + e.getMessage());
        }
    }

    public boolean P(String name) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor rawQuery = db.rawQuery("SELECT id,name FROM salesPoints ", (String[]) null);
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        if (db.insert("salesPoints", (String) null, contentValues) == -1) {
            return false;
        }
        return true;
    }

    public ArrayList<HotspotCard> j0(int sales_id) {
        SQLiteDatabase db;
        ArrayList<HotspotCard> newList = new ArrayList<>();
        SQLiteDatabase db2 = getWritableDatabase();
        Cursor data = db2.rawQuery("SELECT * FROM hotpot_added where sales_id=" + sales_id, (String[]) null);
        while (data.moveToNext()) {
            try {
                String string = data.getString(1);
                String string2 = data.getString(2);
                String string3 = data.getString(3);
                String string4 = data.getString(4);
                String string5 = data.getString(5);
                String string6 = data.getString(6);
                String string7 = data.getString(9);
                String string8 = data.getString(7);
                StringBuilder sb = new StringBuilder();
                db = db2;
                try {
                    sb.append(data.getString(7));
                    sb.append("@0_");
                    sb.append(data.getString(8));
                    sb.append(".ptd");
                    newList.add(new HotspotCard(string, string2, string3, string4, "", string5, "0", "0", string6, string7, false, string8, sb.toString(), false, data.getInt(11)));
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                db = db2;
            }
            db2 = db;
        }
        return newList;
    }

    public ArrayList<UsermanagerCards> t0(int sales_id) {
        String aa;
        String bb;
        ArrayList<UsermanagerCards> newList = new ArrayList<>();
        Cursor data = getWritableDatabase().rawQuery("SELECT * FROM user_manager_added where sales_id=" + sales_id, (String[]) null);
        while (data.moveToNext()) {
            try {
                if (data.getString(8).equals("null")) {
                    aa = null;
                } else {
                    aa = data.getString(8);
                }
                if (data.getString(9).equals("null")) {
                    bb = null;
                } else {
                    bb = data.getString(9);
                }
                String str = aa;
                UsermanagerCards usermanagerCards = r7;
                UsermanagerCards usermanagerCards2 = new UsermanagerCards(data.getString(1), data.getString(2), data.getString(3), data.getString(4), data.getString(7), aa, bb, "print", false, Boolean.parseBoolean(data.getString(10)), data.getString(11), data.getInt(13));
                newList.add(usermanagerCards);
            } catch (Exception e) {
            }
        }
        return newList;
    }

    public ArrayList<SalesPointModel> p0() {
        ArrayList<SalesPointModel> newList = new ArrayList<>();
        Cursor data = getWritableDatabase().rawQuery("SELECT id,name FROM salesPoints", (String[]) null);
        while (data.moveToNext()) {
            try {
                newList.add(new SalesPointModel(data.getInt(0), data.getString(1), 0, 0));
            } catch (Exception e) {
            }
        }
        return newList;
    }

    public ArrayList<SalesPointModel> q0(int report_type1) {
        int i = report_type1;
        ArrayList<SalesPointModel> newList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        if (i == 0) {
            Cursor data = db.rawQuery("SELECT salesPoints.id,salesPoints.name,count(user_manager_added.u_id) count_unused,count(hotpot_added.h_id) h_count_unused FROM salesPoints  LEFT JOIN user_manager_added ON salesPoints.id=user_manager_added.sales_id LEFT JOIN hotpot_added ON salesPoints.id=hotpot_added.sales_id group by salesPoints.id", (String[]) null);
            while (data.moveToNext()) {
                try {
                    newList.add(new SalesPointModel(data.getInt(0), data.getString(1), 0, data.getInt(2) + data.getInt(3)));
                } catch (Exception e) {
                }
            }
            return newList;
        } else if (i == 1) {
            new ArrayList();
            Cursor data2 = db.rawQuery("SELECT salesPoints.id,salesPoints.name,count(user_manager_added.u_id) count_unused FROM salesPoints LEFT JOIN user_manager_added ON salesPoints.id=user_manager_added.sales_id where col2=0 or col2 is null group by salesPoints.id", (String[]) null);
            while (data2.moveToNext()) {
                int usedCount = 0;
                try {
                    new ArrayList();
                    Long newUsedCount = Long.valueOf(ln0.U(t0(data2.getInt(0))).q(te.a).o());
                    usedCount = (int) (newUsedCount != null ? newUsedCount.longValue() : 0);
                } catch (Exception e2) {
                }
                try {
                    newList.add(new SalesPointModel(data2.getInt(0), data2.getString(1), usedCount, data2.getInt(2)));
                } catch (Exception e3) {
                }
            }
            return newList;
        } else {
            new ArrayList();
            Cursor data3 = db.rawQuery("SELECT salesPoints.id,salesPoints.name,count(hotpot_added.h_id) count_unused FROM salesPoints LEFT JOIN hotpot_added ON salesPoints.id=hotpot_added.sales_id where col2=0 or col2 is null group by salesPoints.id", (String[]) null);
            while (data3.moveToNext()) {
                int usedCount2 = 0;
                try {
                    new ArrayList();
                    Long newUsedCount2 = Long.valueOf(ln0.U(j0(data3.getInt(0))).q(se.a).o());
                    usedCount2 = (int) (newUsedCount2 != null ? newUsedCount2.longValue() : 0);
                } catch (Exception e4) {
                }
                try {
                    newList.add(new SalesPointModel(data3.getInt(0), data3.getString(1), usedCount2, data3.getInt(2)));
                } catch (Exception e5) {
                }
            }
            return newList;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean w0(UsermanagerCards item, UsermanagerCards app2) {
        return app2.getUname().equals(item.getUname()) && !app2.getLast_seen().toLowerCase().equalsIgnoreCase("never") && !app2.getLast_seen().toLowerCase().equalsIgnoreCase("waiting");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean y0(HotspotCard item, HotspotCard app2) {
        return app2.getUname().equals(item.getUname()) && !app2.getUptime_used().equals("0s");
    }

    public boolean A0(int id, String name) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        if (((long) db.update("salesPoints", contentValues, "id=" + id, (String[]) null)) == -1) {
            return false;
        }
        return true;
    }

    public Cursor o0(String name) {
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery("SELECT id,name FROM salesPoints where name='" + name + "'", (String[]) null);
    }

    public void B0(List<String> u_id, int type) {
        try {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("col2", "1");
            if (type == 0) {
                for (String u : u_id) {
                    db.update("user_manager_added", contentValues, "u_id='" + u + "'", (String[]) null);
                }
                return;
            }
            for (String u2 : u_id) {
                db.update("hotpot_added", contentValues, "h_id='" + u2 + "'", (String[]) null);
            }
        } catch (SQLiteConstraintException e) {
            Log.e("insert", "SQLException: " + e.getLocalizedMessage());
        }
    }

    public boolean U(String username, String password, String phone, String login_status) {
        String strDate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(Calendar.getInstance().getTime());
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", username);
        contentValues.put("password", password);
        contentValues.put("phone", phone);
        contentValues.put("starttime", strDate);
        contentValues.put("login_status", login_status);
        if (db.insert("user_data", (String) null, contentValues) == -1) {
            return false;
        }
        return true;
    }

    public void V(ArrayList<UsermanagerCards> newList, String router_mac, int sales_id) {
        ArrayList<UsermanagerCards> arrayList = newList;
        StringBuilder stringBuilder = new StringBuilder();
        String strDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Calendar.getInstance().getTime());
        try {
            SQLiteDatabase db = getWritableDatabase();
            int l_size = newList.size();
            int i = 0;
            while (i < l_size) {
                ContentValues values = new ContentValues();
                values.put("u_id", arrayList.get(i).getId());
                values.put("username", arrayList.get(i).getUname());
                values.put("password", arrayList.get(i).getPassword());
                values.put("profilename", arrayList.get(i).getProfilename());
                values.put("insertdate", strDate);
                try {
                    values.put("router_mac", router_mac);
                    values.put("uptime_used", "0");
                    values.put("download_used", "0");
                    values.put("upload_used", "0");
                    values.put("disabled", "false");
                    values.put("last_seen", "0");
                    values.put(NotificationCompat.CATEGORY_STATUS, "0");
                    values.put("sales_id", Integer.valueOf(sales_id));
                    values.put("serial_num", "0");
                    values.put("col2", "0");
                    try {
                        db.insertOrThrow("user_manager_added", (String) null, values);
                    } catch (SQLiteConstraintException e) {
                        Log.e("insert", "SQLException: " + e.getLocalizedMessage());
                    }
                    i++;
                } catch (Exception e2) {
                    e = e2;
                    Log.d("mLog", e.getMessage() + "  errrrrrrrrrrrrrrror");
                    Toast.makeText(a, e.getMessage() + "error" + stringBuilder, 1).show();
                }
            }
            String str = router_mac;
            Toast.makeText(a, "ok", 0).show();
        } catch (Exception e3) {
            e = e3;
            String str2 = router_mac;
            Log.d("mLog", e.getMessage() + "  errrrrrrrrrrrrrrror");
            Toast.makeText(a, e.getMessage() + "error" + stringBuilder, 1).show();
        }
    }

    public ArrayList<Sessions> f0(String tableName) {
        ArrayList<Sessions> newList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + tableName + " where router_mac='" + qb0.f4800a + "'", (String[]) null);
        while (data.moveToNext()) {
            try {
                newList.add(new Sessions(data.getString(1), data.getString(3), data.getString(2), "", data.getString(4), data.getString(8), data.getString(9), data.getString(10)));
            } catch (Exception e) {
            }
        }
        return newList;
    }

    public void J(String tableName, ArrayList<Sessions> newList) {
        try {
            String strDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Calendar.getInstance().getTime());
            ContentValues values = new ContentValues();
            SQLiteDatabase db = getWritableDatabase();
            int l_size = newList.size();
            int i = 0;
            while (i < l_size) {
                try {
                    values.put("name", newList.get(i).getName());
                    values.put("price", newList.get(i).getPrice());
                    values.put("st_from", newList.get(i).getSt_from());
                    values.put("user_id", newList.get(i).getId());
                    values.put("insertdate", strDate);
                    values.put("router_mac", qb0.f4800a);
                    values.put("date1", "n");
                    values.put("download", newList.get(i).getDownload());
                    values.put("upload", newList.get(i).getUpload());
                    values.put("uptime", newList.get(i).getUptime());
                    try {
                        db.insertOrThrow(tableName, (String) null, values);
                    } catch (SQLiteConstraintException e) {
                        Log.e("insert", "SQLException: " + e.getLocalizedMessage());
                    }
                    values.clear();
                    i++;
                } catch (Exception e2) {
                    Toast.makeText(a, e2.getMessage(), 0).show();
                    return;
                }
            }
            Toast.makeText(a, "ok", 0).show();
        } catch (Exception e3) {
            Toast.makeText(a, e3.getMessage(), 0).show();
        }
    }

    /*  JADX ERROR: NullPointerException in pass: CodeShrinkVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.instructions.args.InsnArg.wrapInstruction(InsnArg.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.inline(CodeShrinkVisitor.java:146)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:71)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    public void w(java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard> r18, java.lang.String r19, int r20) {
        /*
            r17 = this;
            r1 = r18
            java.lang.String r0 = ""
            java.lang.String r2 = "0"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.util.Calendar r4 = java.util.Calendar.getInstance()
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            java.util.Locale r6 = java.util.Locale.ENGLISH
            java.lang.String r7 = "yyyy-MM-dd HH:mm:ss"
            r5.<init>(r7, r6)
            java.util.Date r6 = r4.getTime()
            java.lang.String r6 = r5.format(r6)
            android.content.ContentValues r7 = new android.content.ContentValues
            r7.<init>()
            android.database.sqlite.SQLiteDatabase r8 = r17.getWritableDatabase()     // Catch:{ Exception -> 0x0164 }
            int r9 = r18.size()     // Catch:{ Exception -> 0x0164 }
            r10 = r0
            r11 = 0
            r12 = r11
            r11 = r10
            r10 = r0
        L_0x0032:
            if (r12 >= r9) goto L_0x0151
            java.lang.Object r13 = r1.get(r12)     // Catch:{ Exception -> 0x00a2 }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r13 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r13     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r13 = r13.getEmail()     // Catch:{ Exception -> 0x00a2 }
            if (r13 == 0) goto L_0x009f
            java.lang.Object r13 = r1.get(r12)     // Catch:{ Exception -> 0x00a2 }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r13 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r13     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r13 = r13.getEmail()     // Catch:{ Exception -> 0x00a2 }
            r14 = 95
            int r13 = r13.indexOf(r14)     // Catch:{ Exception -> 0x00a2 }
            java.lang.Object r14 = r1.get(r12)     // Catch:{ Exception -> 0x00a2 }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r14 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r14     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r14 = r14.getEmail()     // Catch:{ Exception -> 0x00a2 }
            r15 = 46
            int r14 = r14.indexOf(r15)     // Catch:{ Exception -> 0x00a2 }
            java.lang.Object r15 = r1.get(r12)     // Catch:{ Exception -> 0x00a2 }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r15 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r15     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r15 = r15.getEmail()     // Catch:{ Exception -> 0x00a2 }
            r0 = 64
            int r0 = r15.indexOf(r0)     // Catch:{ Exception -> 0x00a2 }
            if (r13 <= 0) goto L_0x0088
            if (r14 <= 0) goto L_0x0088
            java.lang.Object r15 = r1.get(r12)     // Catch:{ Exception -> 0x00a2 }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r15 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r15     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r15 = r15.getEmail()     // Catch:{ Exception -> 0x00a2 }
            r16 = r4
            int r4 = r13 + 1
            java.lang.String r4 = r15.substring(r4, r14)     // Catch:{ Exception -> 0x009d }
            r11 = r4
            goto L_0x008c
        L_0x0088:
            r16 = r4
            r4 = r2
            r11 = r4
        L_0x008c:
            java.lang.Object r4 = r1.get(r12)     // Catch:{ Exception -> 0x009d }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r4 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r4     // Catch:{ Exception -> 0x009d }
            java.lang.String r4 = r4.getEmail()     // Catch:{ Exception -> 0x009d }
            r15 = 0
            java.lang.String r4 = r4.substring(r15, r0)     // Catch:{ Exception -> 0x009d }
            r10 = r4
            goto L_0x00a1
        L_0x009d:
            r0 = move-exception
            goto L_0x00a5
        L_0x009f:
            r16 = r4
        L_0x00a1:
            goto L_0x00a7
        L_0x00a2:
            r0 = move-exception
            r16 = r4
        L_0x00a5:
            r4 = r2
            r11 = r4
        L_0x00a7:
            java.lang.String r0 = "h_id"
            java.lang.Object r4 = r1.get(r12)     // Catch:{ Exception -> 0x014d }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r4 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r4     // Catch:{ Exception -> 0x014d }
            java.lang.String r4 = r4.getId()     // Catch:{ Exception -> 0x014d }
            r7.put(r0, r4)     // Catch:{ Exception -> 0x014d }
            java.lang.String r0 = "username"
            java.lang.Object r4 = r1.get(r12)     // Catch:{ Exception -> 0x014d }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r4 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r4     // Catch:{ Exception -> 0x014d }
            java.lang.String r4 = r4.getUname()     // Catch:{ Exception -> 0x014d }
            r7.put(r0, r4)     // Catch:{ Exception -> 0x014d }
            java.lang.String r0 = "password"
            java.lang.Object r4 = r1.get(r12)     // Catch:{ Exception -> 0x014d }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r4 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r4     // Catch:{ Exception -> 0x014d }
            java.lang.String r4 = r4.getPassword()     // Catch:{ Exception -> 0x014d }
            r7.put(r0, r4)     // Catch:{ Exception -> 0x014d }
            java.lang.String r0 = "profilename"
            java.lang.Object r4 = r1.get(r12)     // Catch:{ Exception -> 0x014d }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r4 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r4     // Catch:{ Exception -> 0x014d }
            java.lang.String r4 = r4.getProfilename()     // Catch:{ Exception -> 0x014d }
            r7.put(r0, r4)     // Catch:{ Exception -> 0x014d }
            java.lang.String r0 = "time_limt"
            java.lang.Object r4 = r1.get(r12)     // Catch:{ Exception -> 0x014d }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r4 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r4     // Catch:{ Exception -> 0x014d }
            java.lang.String r4 = r4.getLimitUptime()     // Catch:{ Exception -> 0x014d }
            r7.put(r0, r4)     // Catch:{ Exception -> 0x014d }
            java.lang.String r0 = "download_limt"
            java.lang.Object r4 = r1.get(r12)     // Catch:{ Exception -> 0x014d }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r4 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r4     // Catch:{ Exception -> 0x014d }
            java.lang.String r4 = r4.getLimitBytesTotal()     // Catch:{ Exception -> 0x014d }
            r7.put(r0, r4)     // Catch:{ Exception -> 0x014d }
            java.lang.String r0 = "day_limt"
            r7.put(r0, r10)     // Catch:{ Exception -> 0x014d }
            java.lang.String r0 = "price"
            r7.put(r0, r11)     // Catch:{ Exception -> 0x014d }
            java.lang.String r0 = "insertdate"
            r7.put(r0, r6)     // Catch:{ Exception -> 0x014d }
            java.lang.String r0 = "router_mac"
            r4 = r19
            r7.put(r0, r4)     // Catch:{ Exception -> 0x0162 }
            java.lang.String r0 = "sales_id"
            java.lang.Integer r13 = java.lang.Integer.valueOf(r20)     // Catch:{ Exception -> 0x0162 }
            r7.put(r0, r13)     // Catch:{ Exception -> 0x0162 }
            java.lang.String r0 = "col2"
            r7.put(r0, r2)     // Catch:{ Exception -> 0x0162 }
            java.lang.String r0 = "hotpot_added"
            r13 = 0
            r8.insertOrThrow(r0, r13, r7)     // Catch:{ SQLiteConstraintException -> 0x012c }
            goto L_0x0147
        L_0x012c:
            r0 = move-exception
            java.lang.String r13 = "insert"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0162 }
            r14.<init>()     // Catch:{ Exception -> 0x0162 }
            java.lang.String r15 = "SQLException: "
            r14.append(r15)     // Catch:{ Exception -> 0x0162 }
            java.lang.String r15 = r0.getLocalizedMessage()     // Catch:{ Exception -> 0x0162 }
            r14.append(r15)     // Catch:{ Exception -> 0x0162 }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x0162 }
            android.util.Log.e(r13, r14)     // Catch:{ Exception -> 0x0162 }
        L_0x0147:
            int r12 = r12 + 1
            r4 = r16
            goto L_0x0032
        L_0x014d:
            r0 = move-exception
            r4 = r19
            goto L_0x0169
        L_0x0151:
            r16 = r4
            r4 = r19
            android.content.Context r0 = a     // Catch:{ Exception -> 0x0162 }
            java.lang.String r2 = "ok"
            r12 = 0
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r2, r12)     // Catch:{ Exception -> 0x0162 }
            r0.show()     // Catch:{ Exception -> 0x0162 }
            goto L_0x01a5
        L_0x0162:
            r0 = move-exception
            goto L_0x0169
        L_0x0164:
            r0 = move-exception
            r16 = r4
            r4 = r19
        L_0x0169:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r8 = r0.getMessage()
            r2.append(r8)
            java.lang.String r8 = "  errrrrrrrrrrrrrrror"
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            java.lang.String r8 = "mLog"
            android.util.Log.d(r8, r2)
            android.content.Context r2 = a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = r0.getMessage()
            r8.append(r9)
            java.lang.String r9 = "error"
            r8.append(r9)
            r8.append(r3)
            java.lang.String r8 = r8.toString()
            r9 = 1
            android.widget.Toast r2 = android.widget.Toast.makeText(r2, r8, r9)
            r2.show()
        L_0x01a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ue.w(java.util.ArrayList, java.lang.String, int):void");
    }

    public ArrayList<HotspotCard> g0() {
        SQLiteDatabase db;
        ArrayList<HotspotCard> newList = new ArrayList<>();
        SQLiteDatabase db2 = getWritableDatabase();
        Cursor data = db2.rawQuery("SELECT * FROM hotpot_added ", (String[]) null);
        while (data.moveToNext()) {
            try {
                String string = data.getString(1);
                String string2 = data.getString(2);
                String string3 = data.getString(3);
                String string4 = data.getString(4);
                String string5 = data.getString(5);
                String string6 = data.getString(6);
                String string7 = data.getString(9);
                String string8 = data.getString(7);
                StringBuilder sb = new StringBuilder();
                db = db2;
                try {
                    sb.append(data.getString(7));
                    sb.append("@0_");
                    sb.append(data.getString(8));
                    sb.append(".ptd");
                    newList.add(new HotspotCard(string, string2, string3, string4, "", string5, "0", "0", string6, string7, false, string8, sb.toString(), false, data.getInt(11)));
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                db = db2;
            }
            db2 = db;
        }
        return newList;
    }

    public boolean K(String ipaddress, String username, String password, String port) {
        try {
            SQLiteDatabase db = getWritableDatabase();
            if (db.rawQuery("SELECT * FROM login_data where ipaddress='" + ipaddress + "'", (String[]) null).getCount() > 0) {
                db.execSQL("UPDATE login_data SET username='" + username + "',password='" + password + "' where ipaddress='" + ipaddress + "'");
                return true;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("ipaddress", ipaddress);
            contentValues.put("username", username);
            contentValues.put("password", password);
            contentValues.put(ClientCookie.PORT_ATTR, port);
            db.insert("login_data", (String) null, contentValues);
            return true;
        } catch (Exception e) {
            Log.i("DatabaseHelper", "addLoginData: " + e.getMessage().toString());
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:72:0x0129 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x012b A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean C(java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44) {
        /*
            r18 = this;
            r1 = -1
            android.database.sqlite.SQLiteDatabase r0 = r18.getWritableDatabase()     // Catch:{ Exception -> 0x00e8 }
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ Exception -> 0x00e8 }
            r3.<init>()     // Catch:{ Exception -> 0x00e8 }
            java.lang.String r4 = "profile_name"
            r5 = r19
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r4 = "limit_time"
            r6 = r20
            r3.put(r4, r6)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r4 = "limit_download"
            r7 = r21
            r3.put(r4, r7)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r4 = "limit_day"
            r8 = r22
            r3.put(r4, r8)     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r4 = "price"
            r9 = r23
            r3.put(r4, r9)     // Catch:{ Exception -> 0x00de }
            java.lang.String r4 = "user_legnth"
            r10 = r24
            r3.put(r4, r10)     // Catch:{ Exception -> 0x00dc }
            java.lang.String r4 = "pass_legnth"
            r11 = r25
            r3.put(r4, r11)     // Catch:{ Exception -> 0x00da }
            java.lang.String r4 = "card_size"
            r12 = r26
            r3.put(r4, r12)     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r4 = "image_url"
            r13 = r27
            r3.put(r4, r13)     // Catch:{ Exception -> 0x00d6 }
            java.lang.String r4 = "user_position_x"
            r14 = r28
            r3.put(r4, r14)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r4 = "user_position_y"
            r15 = r29
            r3.put(r4, r15)     // Catch:{ Exception -> 0x00d2 }
            java.lang.String r4 = "pass_position_x"
            r16 = r1
            r1 = r30
            r3.put(r4, r1)     // Catch:{ Exception -> 0x00ce }
            java.lang.String r2 = "pass_position_y"
            r4 = r31
            r3.put(r2, r4)     // Catch:{ Exception -> 0x00cc }
            java.lang.String r2 = "slspoint_position_x"
            r1 = r32
            r3.put(r2, r1)     // Catch:{ Exception -> 0x00cc }
            java.lang.String r2 = "slspoint_position_y"
            r1 = r33
            r3.put(r2, r1)     // Catch:{ Exception -> 0x00cc }
            java.lang.String r2 = "serial_position_x"
            r1 = r34
            r3.put(r2, r1)     // Catch:{ Exception -> 0x00cc }
            java.lang.String r2 = "serial_position_y"
            r1 = r35
            r3.put(r2, r1)     // Catch:{ Exception -> 0x00cc }
            java.lang.String r2 = "selected_profile"
            r1 = r36
            r3.put(r2, r1)     // Catch:{ Exception -> 0x00cc }
            java.lang.String r2 = "hide_pass"
            r1 = r37
            r3.put(r2, r1)     // Catch:{ Exception -> 0x00cc }
            java.lang.String r2 = "profile"
            r1 = r38
            r3.put(r2, r1)     // Catch:{ Exception -> 0x00cc }
            java.lang.String r2 = "char_with_num"
            r1 = r39
            r3.put(r2, r1)     // Catch:{ Exception -> 0x00cc }
            java.lang.String r2 = "name_with_pass"
            r1 = r40
            r3.put(r2, r1)     // Catch:{ Exception -> 0x00cc }
            java.lang.String r2 = "minute_time"
            r1 = r41
            r3.put(r2, r1)     // Catch:{ Exception -> 0x00cc }
            java.lang.String r2 = "motabka"
            r1 = r42
            r3.put(r2, r1)     // Catch:{ Exception -> 0x00cc }
            java.lang.String r2 = "mega_giga"
            r1 = r43
            r3.put(r2, r1)     // Catch:{ Exception -> 0x00cc }
            java.lang.String r2 = "card_size_col"
            r1 = r44
            r3.put(r2, r1)     // Catch:{ Exception -> 0x00cc }
            java.lang.String r2 = "hotspot_profile"
            r1 = 0
            long r1 = r0.insert(r2, r1, r3)     // Catch:{ Exception -> 0x00cc }
            goto L_0x0123
        L_0x00cc:
            r0 = move-exception
            goto L_0x0103
        L_0x00ce:
            r0 = move-exception
            r4 = r31
            goto L_0x0103
        L_0x00d2:
            r0 = move-exception
            goto L_0x00ff
        L_0x00d4:
            r0 = move-exception
            goto L_0x00fd
        L_0x00d6:
            r0 = move-exception
            goto L_0x00fb
        L_0x00d8:
            r0 = move-exception
            goto L_0x00f9
        L_0x00da:
            r0 = move-exception
            goto L_0x00f7
        L_0x00dc:
            r0 = move-exception
            goto L_0x00f5
        L_0x00de:
            r0 = move-exception
            goto L_0x00f3
        L_0x00e0:
            r0 = move-exception
            goto L_0x00f1
        L_0x00e2:
            r0 = move-exception
            goto L_0x00ef
        L_0x00e4:
            r0 = move-exception
            goto L_0x00ed
        L_0x00e6:
            r0 = move-exception
            goto L_0x00eb
        L_0x00e8:
            r0 = move-exception
            r5 = r19
        L_0x00eb:
            r6 = r20
        L_0x00ed:
            r7 = r21
        L_0x00ef:
            r8 = r22
        L_0x00f1:
            r9 = r23
        L_0x00f3:
            r10 = r24
        L_0x00f5:
            r11 = r25
        L_0x00f7:
            r12 = r26
        L_0x00f9:
            r13 = r27
        L_0x00fb:
            r14 = r28
        L_0x00fd:
            r15 = r29
        L_0x00ff:
            r4 = r31
            r16 = r1
        L_0x0103:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "addLoginData: "
            r1.append(r2)
            java.lang.String r2 = r0.getMessage()
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "DatabaseHelper"
            android.util.Log.i(r2, r1)
            r1 = r16
        L_0x0123:
            r16 = -1
            int r0 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r0 != 0) goto L_0x012b
            r0 = 0
            return r0
        L_0x012b:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ue.C(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:72:0x00ff A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0101 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean Z(java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38) {
        /*
            r18 = this;
            r1 = -1
            android.database.sqlite.SQLiteDatabase r0 = r18.getWritableDatabase()     // Catch:{ Exception -> 0x00be }
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ Exception -> 0x00be }
            r3.<init>()     // Catch:{ Exception -> 0x00be }
            java.lang.String r4 = "profile_name"
            r5 = r19
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00bc }
            java.lang.String r4 = "profile"
            r6 = r20
            r3.put(r4, r6)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r4 = "char_with_num"
            r7 = r21
            r3.put(r4, r7)     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r4 = "name_with_pass"
            r8 = r22
            r3.put(r4, r8)     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r4 = "motabka"
            r9 = r23
            r3.put(r4, r9)     // Catch:{ Exception -> 0x00b4 }
            java.lang.String r4 = "user_legnth"
            r10 = r24
            r3.put(r4, r10)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r4 = "pass_legnth"
            r11 = r25
            r3.put(r4, r11)     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r4 = "card_size"
            r12 = r26
            r3.put(r4, r12)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r4 = "image_url"
            r13 = r27
            r3.put(r4, r13)     // Catch:{ Exception -> 0x00ac }
            java.lang.String r4 = "user_position_x"
            r14 = r28
            r3.put(r4, r14)     // Catch:{ Exception -> 0x00aa }
            java.lang.String r4 = "user_position_y"
            r15 = r29
            r3.put(r4, r15)     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r4 = "pass_position_x"
            r16 = r1
            r1 = r30
            r3.put(r4, r1)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r2 = "pass_position_y"
            r4 = r31
            r3.put(r2, r4)     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r2 = "slspoint_position_x"
            r1 = r32
            r3.put(r2, r1)     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r2 = "slspoint_position_y"
            r1 = r33
            r3.put(r2, r1)     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r2 = "serial_position_x"
            r1 = r34
            r3.put(r2, r1)     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r2 = "serial_position_y"
            r1 = r35
            r3.put(r2, r1)     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r2 = "hide_pass"
            r1 = r36
            r3.put(r2, r1)     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r2 = "connect_with_mac"
            r1 = r37
            r3.put(r2, r1)     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r2 = "card_size_col"
            r1 = r38
            r3.put(r2, r1)     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r2 = "userman_profile"
            r1 = 0
            long r1 = r0.insert(r2, r1, r3)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00f9
        L_0x00a2:
            r0 = move-exception
            goto L_0x00d9
        L_0x00a4:
            r0 = move-exception
            r4 = r31
            goto L_0x00d9
        L_0x00a8:
            r0 = move-exception
            goto L_0x00d5
        L_0x00aa:
            r0 = move-exception
            goto L_0x00d3
        L_0x00ac:
            r0 = move-exception
            goto L_0x00d1
        L_0x00ae:
            r0 = move-exception
            goto L_0x00cf
        L_0x00b0:
            r0 = move-exception
            goto L_0x00cd
        L_0x00b2:
            r0 = move-exception
            goto L_0x00cb
        L_0x00b4:
            r0 = move-exception
            goto L_0x00c9
        L_0x00b6:
            r0 = move-exception
            goto L_0x00c7
        L_0x00b8:
            r0 = move-exception
            goto L_0x00c5
        L_0x00ba:
            r0 = move-exception
            goto L_0x00c3
        L_0x00bc:
            r0 = move-exception
            goto L_0x00c1
        L_0x00be:
            r0 = move-exception
            r5 = r19
        L_0x00c1:
            r6 = r20
        L_0x00c3:
            r7 = r21
        L_0x00c5:
            r8 = r22
        L_0x00c7:
            r9 = r23
        L_0x00c9:
            r10 = r24
        L_0x00cb:
            r11 = r25
        L_0x00cd:
            r12 = r26
        L_0x00cf:
            r13 = r27
        L_0x00d1:
            r14 = r28
        L_0x00d3:
            r15 = r29
        L_0x00d5:
            r4 = r31
            r16 = r1
        L_0x00d9:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "addLoginData: "
            r1.append(r2)
            java.lang.String r2 = r0.getMessage()
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "DatabaseHelper"
            android.util.Log.i(r2, r1)
            r1 = r16
        L_0x00f9:
            r16 = -1
            int r0 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r0 != 0) goto L_0x0101
            r0 = 0
            return r0
        L_0x0101:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ue.Z(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    public boolean Y() {
        try {
            new StringBuilder();
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Calendar.getInstance().getTime());
            SQLiteDatabase db = getWritableDatabase();
            new ContentValues();
            db.execSQL("INSERT OR REPLACE INTO user_manager_sales (name,price,st_from,nas_port_id,session_id,insertdate,router_mac,date1,download,upload,uptime)select name,price,st_from,nas_port_id,session_id_c,insertdate,router_mac,date1,download,upload,uptime from user_manager_sales_cach");
            Toast.makeText(a, "ok", 0).show();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void X(String tableName, ArrayList<Sessions> newList) {
        String se_id;
        String str = tableName;
        ArrayList<Sessions> arrayList = newList;
        try {
            new StringBuilder();
            String strDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Calendar.getInstance().getTime());
            ContentValues values = new ContentValues();
            SQLiteDatabase db = getWritableDatabase();
            int l_size = newList.size();
            String n = "n";
            if (str.equals("user_manager_sales_cach")) {
                se_id = "session_id_c";
            } else {
                se_id = "session_id";
            }
            int i = 0;
            while (i < l_size) {
                try {
                    values.put("name", arrayList.get(i).getName());
                    values.put("price", arrayList.get(i).getPrice());
                    values.put("st_from", arrayList.get(i).getSt_from());
                    values.put("nas_port_id", arrayList.get(i).getNas_port_id());
                    values.put(se_id, arrayList.get(i).getId());
                    values.put("insertdate", strDate);
                    values.put("router_mac", qb0.f4800a);
                    values.put("date1", n);
                    values.put("download", arrayList.get(i).getDownload());
                    values.put("upload", arrayList.get(i).getUpload());
                    values.put("uptime", arrayList.get(i).getUptime());
                    try {
                        db.insertOrThrow(str, (String) null, values);
                    } catch (SQLiteConstraintException e) {
                        SQLiteConstraintException e2 = e;
                        Log.e("insert", "SQLException: " + e2.getLocalizedMessage());
                    }
                    values.clear();
                    i++;
                } catch (Exception e3) {
                    return;
                }
            }
            Toast.makeText(a, "ok", 0).show();
        } catch (Exception e4) {
            Toast.makeText(a, e4.getMessage(), 0).show();
        }
    }

    public ArrayList<Sessions> m0(String tableName) {
        SimpleDateFormat formatter2;
        SQLiteDatabase db;
        String str;
        ArrayList<Sessions> newList = new ArrayList<>();
        SQLiteDatabase db2 = getWritableDatabase();
        Locale locale = Locale.ENGLISH;
        new SimpleDateFormat("MMM/dd/yyyy HH:mm:ss", locale);
        SimpleDateFormat formatter22 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", locale);
        Cursor data = db2.rawQuery("SELECT name,price,st_from,nas_port_id,session_id,download,upload FROM " + tableName + " where router_mac=='" + qb0.f4800a + "'", (String[]) null);
        while (data.moveToNext()) {
            try {
                String string = data.getString(0);
                String string2 = data.getString(2);
                String string3 = data.getString(1);
                String string4 = data.getString(3);
                String string5 = data.getString(4);
                db = db2;
                try {
                    if (!data.getString(5).equals("null")) {
                        try {
                            str = data.getString(5);
                        } catch (Exception e) {
                            formatter2 = formatter22;
                        }
                    } else {
                        str = "0";
                    }
                    formatter2 = formatter22;
                    try {
                        newList.add(new Sessions(string, string2, string3, string4, string5, str, !data.getString(6).equals("null") ? data.getString(6) : "0", "0"));
                    } catch (Exception e2) {
                    }
                } catch (Exception e3) {
                    formatter2 = formatter22;
                }
            } catch (Exception e4) {
                db = db2;
                formatter2 = formatter22;
            }
            db2 = db;
            formatter22 = formatter2;
        }
        return newList;
    }

    public int e0(String tableName) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor data = db.rawQuery("SELECT COUNT(*) FROM " + tableName + " where router_mac='" + qb0.f4800a + "'", (String[]) null);
        data.moveToFirst();
        return data.getInt(0);
    }

    public int r0(String tableName) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor data = db.rawQuery("SELECT SUM(price) FROM " + tableName + " where router_mac='" + qb0.f4800a + "'", (String[]) null);
        data.moveToFirst();
        return data.getInt(0);
    }

    public ArrayList<Sessions> n0(String tableName, String salseDate_from, String salseDate_to, String ether, String price, StringBuilder sum) {
        ArrayList<Sessions> newList;
        String str;
        String str2 = tableName;
        String str3 = salseDate_from;
        String str4 = salseDate_to;
        String str5 = ether;
        String str6 = price;
        ArrayList<Sessions> newList2 = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        StringBuilder stringBuilder = new StringBuilder();
        String se_id = "session_id";
        if (str2.equals("user_manager_sales_cach")) {
            se_id = "session_id_c";
        }
        stringBuilder.append("SELECT name,price,st_from,nas_port_id," + se_id + ",download,upload,uptime FROM " + str2 + " where router_mac='" + qb0.f4800a + "' and st_from BETWEEN '" + str3 + " 00:00:00' and '" + str4 + " 23:59:59'");
        if (!str5.equals("الكل")) {
            stringBuilder.append(" and nas_port_id ='" + str5 + "'");
        }
        String str7 = se_id;
        if (!str6.equals("الكل")) {
            stringBuilder.append(" and price ='" + str6 + "'");
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<Sessions> newList3 = newList2;
        sb.append("OR router_mac='");
        sb.append(qb0.f4800a);
        sb.append("' and st_from BETWEEN '");
        sb.append(str4);
        sb.append(" 00:00:00' and '");
        sb.append(str3);
        sb.append(" 23:59:59'");
        stringBuilder.append(sb.toString());
        if (!str5.equals("الكل")) {
            stringBuilder.append(" and nas_port_id ='" + str5 + "'");
        }
        if (!str6.equals("الكل")) {
            stringBuilder.append(" and price ='" + str6 + "'");
        }
        Cursor data = db.rawQuery(stringBuilder.toString(), (String[]) null);
        int m_sum = 0;
        while (data.moveToNext()) {
            try {
                String string = data.getString(0);
                String string2 = data.getString(2);
                String string3 = data.getString(1);
                String string4 = data.getString(3);
                String string5 = data.getString(4);
                if (!data.getString(5).equals("null")) {
                    try {
                        str = data.getString(5);
                    } catch (Exception e) {
                        newList = newList3;
                    }
                } else {
                    str = "0";
                }
                Sessions sessions = new Sessions(string, string2, string3, string4, string5, str, !data.getString(6).equals("null") ? data.getString(6) : "0", !data.getString(7).equals("null") ? data.getString(7) : "");
                newList = newList3;
                try {
                    newList.add(sessions);
                    if (data.getString(1) != null && !data.getString(1).equals("null")) {
                        m_sum += Integer.parseInt(data.getString(1));
                    }
                } catch (Exception e2) {
                }
            } catch (Exception e3) {
                newList = newList3;
            }
            newList3 = newList;
        }
        ArrayList<Sessions> newList4 = newList3;
        sum.append(m_sum);
        return newList4;
    }

    public Cursor k0() {
        return getWritableDatabase().rawQuery("SELECT * FROM login_data ", (String[]) null);
    }

    public Cursor h0() {
        return getWritableDatabase().rawQuery("SELECT * FROM hotspot_profile ", (String[]) null);
    }

    public Cursor i0(String profile_name) {
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery("SELECT * FROM hotspot_profile where profile_name='" + profile_name + "'", (String[]) null);
    }

    public Cursor u0() {
        return getWritableDatabase().rawQuery("SELECT * FROM userman_profile ", (String[]) null);
    }

    public Cursor v0(String profile_name) {
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery("SELECT * FROM userman_profile where profile_name='" + profile_name + "'", (String[]) null);
    }

    public Cursor l0(String ipadd) {
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery("SELECT * FROM login_data where ipaddress='" + ipadd + "'", (String[]) null);
    }

    public Cursor s0() {
        return getWritableDatabase().rawQuery("SELECT * FROM user_manager_added ", (String[]) null);
    }

    public boolean c0(String name) {
        long result = -1;
        try {
            SQLiteDatabase db = getWritableDatabase();
            String str = "DELETE FROM userman_profile WHERE profile_name= '" + name + "'";
            Log.d("DatabaseHelper", "deleteName: Deleting " + name + " from database.");
            result = (long) db.delete("userman_profile", "profile_name=?", new String[]{name});
        } catch (Exception e) {
            Log.i("DatabaseHelper", "addLoginData: " + e.getMessage().toString());
        }
        return result != -1;
    }

    public boolean d0(String name) {
        long result = -1;
        try {
            result = (long) getWritableDatabase().delete("hotspot_profile", "profile_name=?", new String[]{name});
        } catch (Exception e) {
            Log.i("DatabaseHelper", "addLoginData: " + e.getMessage().toString());
        }
        return result != -1;
    }

    public void a0(String TABLE_NAME) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }
}
