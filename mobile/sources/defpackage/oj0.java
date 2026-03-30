package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import java.util.Arrays;
import java.util.List;

/* renamed from: oj0  reason: default package */
final class oj0 extends SQLiteOpenHelper {
    private static final List<a> a;

    /* renamed from: a  reason: collision with other field name */
    private static final a f4550a;
    static int b = 3;

    /* renamed from: b  reason: collision with other field name */
    private static final a f4551b;
    private static final a c;

    /* renamed from: a  reason: collision with other field name */
    private final int f4552a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f4553a = false;

    /* renamed from: oj0$a */
    public interface a {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    static {
        a b2 = lj0.b();
        f4550a = b2;
        a b3 = mj0.b();
        f4551b = b3;
        a b4 = nj0.b();
        c = b4;
        a = Arrays.asList(new a[]{b2, b3, b4});
    }

    static /* synthetic */ void f(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        db.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        db.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        db.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        db.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    static /* synthetic */ void o(SQLiteDatabase db) {
        db.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        db.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        db.execSQL("DROP INDEX contexts_backend_priority");
    }

    oj0(Context context, int schemaVersion) {
        super(context, "com.google.android.datatransport.events", (SQLiteDatabase.CursorFactory) null, schemaVersion);
        this.f4552a = schemaVersion;
    }

    public void onConfigure(SQLiteDatabase db) {
        this.f4553a = true;
        db.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        if (Build.VERSION.SDK_INT >= 16) {
            db.setForeignKeyConstraintsEnabled(true);
        }
    }

    private void c(SQLiteDatabase db) {
        if (!this.f4553a) {
            onConfigure(db);
        }
    }

    public void onCreate(SQLiteDatabase db) {
        c(db);
        w(db, 0, this.f4552a);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        c(db);
        w(db, oldVersion, newVersion);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE events");
        db.execSQL("DROP TABLE event_metadata");
        db.execSQL("DROP TABLE transport_contexts");
        onCreate(db);
    }

    public void onOpen(SQLiteDatabase db) {
        c(db);
    }

    private void w(SQLiteDatabase db, int fromVersion, int toVersion) {
        List<a> list = a;
        if (toVersion <= list.size()) {
            for (int version = fromVersion; version < toVersion; version++) {
                a.get(version).a(db);
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + fromVersion + " to " + toVersion + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }
}
