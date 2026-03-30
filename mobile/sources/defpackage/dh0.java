package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import com.google.firebase.firestore.util.i;
import defpackage.iz;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: dh0  reason: default package */
public final class dh0 extends c90 {
    private SQLiteDatabase a;

    /* renamed from: a  reason: collision with other field name */
    private final SQLiteOpenHelper f2759a;

    /* renamed from: a  reason: collision with other field name */
    private final SQLiteTransactionListener f2760a;

    /* renamed from: a  reason: collision with other field name */
    private final di0 f2761a;

    /* renamed from: a  reason: collision with other field name */
    private final jh0 f2762a;

    /* renamed from: a  reason: collision with other field name */
    private final kg0 f2763a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final og0 f2764a;

    /* renamed from: a  reason: collision with other field name */
    private final zx f2765a;
    private boolean b;

    public static String m(String persistenceKey, ve databaseId) {
        try {
            return "firestore." + URLEncoder.encode(persistenceKey, "utf-8") + "." + URLEncoder.encode(databaseId.d(), "utf-8") + "." + URLEncoder.encode(databaseId.c(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: dh0$a */
    class a implements SQLiteTransactionListener {
        a() {
        }

        public void onBegin() {
            dh0.this.f2764a.e();
        }

        public void onCommit() {
            dh0.this.f2764a.k();
        }

        public void onRollback() {
        }
    }

    public dh0(Context context, String persistenceKey, ve databaseId, zx serializer, iz.a params) {
        this(serializer, params, new c(context, m(persistenceKey, databaseId)));
    }

    public dh0(zx serializer, iz.a params, SQLiteOpenHelper openHelper) {
        this.f2760a = new a();
        this.f2759a = openHelper;
        this.f2765a = serializer;
        this.f2761a = new di0(this, serializer);
        this.f2763a = new kg0(this);
        this.f2762a = new jh0(this, serializer);
        this.f2764a = new og0(this, params);
    }

    public void i() {
        n4.d(!this.b, "SQLitePersistence double-started!", new Object[0]);
        this.b = true;
        try {
            this.a = this.f2759a.getWritableDatabase();
            this.f2761a.w();
            this.f2764a.w(this.f2761a.l());
        } catch (SQLiteDatabaseLockedException e) {
            throw new RuntimeException("Failed to gain exclusive lock to the Cloud Firestore client's offline persistence. This generally means you are using Cloud Firestore from multiple processes in your app. Keep in mind that multi-process Android apps execute the code in your Application class in all processes, so you may need to avoid initializing Cloud Firestore in your Application class. If you are intentionally using Cloud Firestore from multiple processes, you can only enable offline persistence (that is, call setPersistenceEnabled(true)) in one of them.", e);
        }
    }

    public boolean f() {
        return this.b;
    }

    /* renamed from: s */
    public og0 c() {
        return this.f2764a;
    }

    /* access modifiers changed from: package-private */
    public x20 b(yt0 user) {
        return new ah0(this, this.f2765a, user);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public di0 e() {
        return this.f2761a;
    }

    /* access modifiers changed from: package-private */
    public ks a() {
        return this.f2763a;
    }

    /* access modifiers changed from: package-private */
    public de0 d() {
        return this.f2762a;
    }

    /* access modifiers changed from: package-private */
    public void h(String action, Runnable operation) {
        i.a(c90.a, "Starting transaction: %s", action);
        this.a.beginTransactionWithListener(this.f2760a);
        try {
            operation.run();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    /* access modifiers changed from: package-private */
    public <T> T g(String action, po0<T> operation) {
        i.a(c90.a, "Starting transaction: %s", action);
        this.a.beginTransactionWithListener(this.f2760a);
        try {
            T value = operation.get();
            this.a.setTransactionSuccessful();
            return value;
        } finally {
            this.a.endTransaction();
        }
    }

    /* access modifiers changed from: package-private */
    public long p() {
        return q() * r();
    }

    private long r() {
        return ((Long) x("PRAGMA page_size").c(bh0.a())).longValue();
    }

    private long q() {
        return ((Long) x("PRAGMA page_count").c(ch0.a())).longValue();
    }

    /* renamed from: dh0$c */
    private static class c extends SQLiteOpenHelper {
        private boolean a;

        c(Context context, String databaseName) {
            super(context, databaseName, (SQLiteDatabase.CursorFactory) null, 10);
        }

        public void onConfigure(SQLiteDatabase db) {
            this.a = true;
            db.rawQuery("PRAGMA locking_mode = EXCLUSIVE", new String[0]).close();
        }

        private void c(SQLiteDatabase db) {
            if (!this.a) {
                onConfigure(db);
            }
        }

        public void onCreate(SQLiteDatabase db) {
            c(db);
            new xh0(db).E(0);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            c(db);
            new xh0(db).E(oldVersion);
        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            c(db);
        }

        public void onOpen(SQLiteDatabase db) {
            c(db);
        }
    }

    /* access modifiers changed from: package-private */
    public void o(String sql, Object... args) {
        this.a.execSQL(sql, args);
    }

    /* access modifiers changed from: package-private */
    public SQLiteStatement w(String sql) {
        return this.a.compileStatement(sql);
    }

    /* access modifiers changed from: package-private */
    public int n(SQLiteStatement statement, Object... args) {
        statement.clearBindings();
        l(statement, args);
        return statement.executeUpdateDelete();
    }

    /* access modifiers changed from: package-private */
    public d x(String sql) {
        return new d(this.a, sql);
    }

    /* renamed from: dh0$d */
    static class d {
        private SQLiteDatabase.CursorFactory a;

        /* renamed from: a  reason: collision with other field name */
        private final SQLiteDatabase f2770a;

        /* renamed from: a  reason: collision with other field name */
        private final String f2771a;

        d(SQLiteDatabase db, String sql) {
            this.f2770a = db;
            this.f2771a = sql;
        }

        /* access modifiers changed from: package-private */
        public d a(Object... args) {
            this.a = eh0.a(args);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
            if (r1 != null) goto L_0x001a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x001f, code lost:
            throw r2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int d(defpackage.hc<android.database.Cursor> r5) {
            /*
                r4 = this;
                r0 = 0
                android.database.Cursor r1 = r4.g()
            L_0x0005:
                boolean r2 = r1.moveToNext()     // Catch:{ all -> 0x0015 }
                if (r2 == 0) goto L_0x0011
                int r0 = r0 + 1
                r5.accept(r1)     // Catch:{ all -> 0x0015 }
                goto L_0x0005
            L_0x0011:
                r1.close()
                return r0
            L_0x0015:
                r2 = move-exception
                throw r2     // Catch:{ all -> 0x0017 }
            L_0x0017:
                r2 = move-exception
                if (r1 == 0) goto L_0x001f
                r1.close()     // Catch:{ all -> 0x001e }
                goto L_0x001f
            L_0x001e:
                r3 = move-exception
            L_0x001f:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.dh0.d.d(hc):int");
        }

        /* access modifiers changed from: package-private */
        public int b(hc<Cursor> consumer) {
            Cursor cursor = null;
            try {
                Cursor cursor2 = g();
                if (cursor2.moveToFirst()) {
                    consumer.accept(cursor2);
                    cursor2.close();
                    return 1;
                }
                cursor2.close();
                return 0;
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        public <T> T c(ko<Cursor, T> function) {
            Cursor cursor = null;
            try {
                Cursor cursor2 = g();
                if (cursor2.moveToFirst()) {
                    T apply = function.apply(cursor2);
                    cursor2.close();
                    return apply;
                }
                cursor2.close();
                return null;
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            Cursor cursor = null;
            try {
                Cursor cursor2 = g();
                boolean z = !cursor2.moveToFirst();
                cursor2.close();
                return z;
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        private Cursor g() {
            SQLiteDatabase.CursorFactory cursorFactory = this.a;
            if (cursorFactory != null) {
                return this.f2770a.rawQueryWithFactory(cursorFactory, this.f2771a, (String[]) null, (String) null);
            }
            return this.f2770a.rawQuery(this.f2771a, (String[]) null);
        }
    }

    /* renamed from: dh0$b */
    static class b {
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private final dh0 f2766a;

        /* renamed from: a  reason: collision with other field name */
        private final String f2767a;

        /* renamed from: a  reason: collision with other field name */
        private final Iterator<Object> f2768a;

        /* renamed from: a  reason: collision with other field name */
        private final List<Object> f2769a;
        private final String b;

        b(dh0 db, String head, List<Object> allArgs, String tail) {
            this.f2766a = db;
            this.f2767a = head;
            this.f2769a = Collections.emptyList();
            this.b = tail;
            this.f2768a = allArgs.iterator();
        }

        b(dh0 db, String head, List<Object> argsHead, List<Object> allArgs, String tail) {
            this.f2766a = db;
            this.f2767a = head;
            this.f2769a = argsHead;
            this.b = tail;
            this.f2768a = allArgs.iterator();
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return this.f2768a.hasNext();
        }

        /* access modifiers changed from: package-private */
        public d c() {
            this.a++;
            List<Object> subqueryArgs = new ArrayList<>(this.f2769a);
            StringBuilder placeholdersBuilder = new StringBuilder();
            int i = 0;
            while (this.f2768a.hasNext() && i < 900 - this.f2769a.size()) {
                if (i > 0) {
                    placeholdersBuilder.append(", ");
                }
                placeholdersBuilder.append("?");
                subqueryArgs.add(this.f2768a.next());
                i++;
            }
            String placeholders = placeholdersBuilder.toString();
            return this.f2766a.x(this.f2767a + placeholders + this.b).a(subqueryArgs.toArray());
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.a;
        }
    }

    /* access modifiers changed from: private */
    public static void l(SQLiteProgram program, Object[] bindArgs) {
        for (int i = 0; i < bindArgs.length; i++) {
            Object arg = bindArgs[i];
            if (arg == null) {
                program.bindNull(i + 1);
            } else if (arg instanceof String) {
                program.bindString(i + 1, (String) arg);
            } else if (arg instanceof Integer) {
                program.bindLong(i + 1, (long) ((Integer) arg).intValue());
            } else if (arg instanceof Long) {
                program.bindLong(i + 1, ((Long) arg).longValue());
            } else if (arg instanceof Double) {
                program.bindDouble(i + 1, ((Double) arg).doubleValue());
            } else if (arg instanceof byte[]) {
                program.bindBlob(i + 1, (byte[]) arg);
            } else {
                throw n4.a("Unknown argument %s of type %s", arg, arg.getClass());
            }
        }
    }
}
