package defpackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import defpackage.aj;
import defpackage.xo0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* renamed from: hg0  reason: default package */
public class hg0 implements hj, xo0 {
    private static final qi a = qi.b("proto");

    /* renamed from: a  reason: collision with other field name */
    private final c9 f3161a;

    /* renamed from: a  reason: collision with other field name */
    private final ij f3162a;

    /* renamed from: a  reason: collision with other field name */
    private final oj0 f3163a;
    private final c9 b;

    /* renamed from: hg0$b */
    interface b<T, U> {
        U apply(T t);
    }

    /* renamed from: hg0$d */
    interface d<T> {
        T a();
    }

    hg0(c9 wallClock, c9 clock, ij config, oj0 schemaManager) {
        this.f3163a = schemaManager;
        this.f3161a = wallClock;
        this.b = clock;
        this.f3162a = config;
    }

    private SQLiteDatabase q() {
        oj0 oj0 = this.f3163a;
        oj0.getClass();
        return (SQLiteDatabase) o0(zf0.b(oj0), bg0.a());
    }

    static /* synthetic */ SQLiteDatabase Z(Throwable ex) {
        throw new wo0("Timed out while trying to open db.", ex);
    }

    public b90 z(es0 transportContext, aj event) {
        xy.b("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", transportContext.d(), event.j(), transportContext.b());
        long newRowId = ((Long) K(cg0.a(this, transportContext, event))).longValue();
        if (newRowId < 1) {
            return null;
        }
        return b90.a(newRowId, transportContext, event);
    }

    static /* synthetic */ Long i0(hg0 hg0, es0 transportContext, aj event, SQLiteDatabase db) {
        if (hg0.P()) {
            return -1L;
        }
        long contextId = hg0.o(db, transportContext);
        ContentValues values = new ContentValues();
        values.put("context_id", Long.valueOf(contextId));
        values.put("transport_name", event.j());
        values.put("timestamp_ms", Long.valueOf(event.f()));
        values.put("uptime_ms", Long.valueOf(event.k()));
        values.put("payload_encoding", event.e().b().a());
        values.put("payload", event.e().a());
        values.put("code", event.d());
        values.put("num_attempts", 0);
        long newEventId = db.insert("events", (String) null, values);
        for (Map.Entry<String, String> entry : event.i().entrySet()) {
            ContentValues metadata = new ContentValues();
            metadata.put("event_id", Long.valueOf(newEventId));
            metadata.put("name", entry.getKey());
            metadata.put("value", entry.getValue());
            db.insert("event_metadata", (String) null, metadata);
        }
        return Long.valueOf(newEventId);
    }

    private long o(SQLiteDatabase db, es0 transportContext) {
        Long existingId = J(db, transportContext);
        if (existingId != null) {
            return existingId.longValue();
        }
        ContentValues record = new ContentValues();
        record.put("backend_name", transportContext.b());
        record.put("priority", Integer.valueOf(ta0.a(transportContext.d())));
        record.put("next_request_ms", 0);
        if (transportContext.c() != null) {
            record.put("extras", Base64.encodeToString(transportContext.c(), 0));
        }
        return db.insert("transport_contexts", (String) null, record);
    }

    private Long J(SQLiteDatabase db, es0 transportContext) {
        StringBuilder selection = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList<String> selectionArgs = new ArrayList<>(Arrays.asList(new String[]{transportContext.b(), String.valueOf(ta0.a(transportContext.d()))}));
        if (transportContext.c() != null) {
            selection.append(" and extras = ?");
            selectionArgs.add(Base64.encodeToString(transportContext.c(), 0));
        }
        return (Long) r0(db.query("transport_contexts", new String[]{"_id"}, selection.toString(), (String[]) selectionArgs.toArray(new String[0]), (String) null, (String) null, (String) null), dg0.a());
    }

    static /* synthetic */ Long b0(Cursor cursor) {
        if (!cursor.moveToNext()) {
            return null;
        }
        return Long.valueOf(cursor.getLong(0));
    }

    public void l(Iterable<b90> events) {
        if (events.iterator().hasNext()) {
            K(eg0.a("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + q0(events)));
        }
    }

    static /* synthetic */ Object j0(String query, SQLiteDatabase db) {
        db.compileStatement(query).execute();
        db.compileStatement("DELETE FROM events WHERE num_attempts >= 10").execute();
        return null;
    }

    public void s(Iterable<b90> events) {
        if (events.iterator().hasNext()) {
            q().compileStatement("DELETE FROM events WHERE _id in " + q0(events)).execute();
        }
    }

    private static String q0(Iterable<b90> events) {
        StringBuilder idList = new StringBuilder("(");
        Iterator<b90> it = events.iterator();
        while (it.hasNext()) {
            idList.append(it.next().c());
            if (it.hasNext()) {
                idList.append(',');
            }
        }
        idList.append(')');
        return idList.toString();
    }

    public long S(es0 transportContext) {
        return ((Long) r0(q().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{transportContext.b(), String.valueOf(ta0.a(transportContext.d()))}), fg0.a())).longValue();
    }

    static /* synthetic */ Long a0(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    public boolean L(es0 transportContext) {
        return ((Boolean) K(gg0.a(this, transportContext))).booleanValue();
    }

    static /* synthetic */ Boolean c0(hg0 hg0, es0 transportContext, SQLiteDatabase db) {
        Long contextId = hg0.J(db, transportContext);
        if (contextId == null) {
            return false;
        }
        return (Boolean) r0(hg0.q().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{contextId.toString()}), ag0.a());
    }

    public void H(es0 transportContext, long timestampMs) {
        K(qf0.a(timestampMs, transportContext));
    }

    static /* synthetic */ Object k0(long timestampMs, es0 transportContext, SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put("next_request_ms", Long.valueOf(timestampMs));
        if (db.update("transport_contexts", values, "backend_name = ? and priority = ?", new String[]{transportContext.b(), String.valueOf(ta0.a(transportContext.d()))}) < 1) {
            values.put("backend_name", transportContext.b());
            values.put("priority", Integer.valueOf(ta0.a(transportContext.d())));
            db.insert("transport_contexts", (String) null, values);
        }
        return null;
    }

    public Iterable<b90> j(es0 transportContext) {
        return (Iterable) K(rf0.a(this, transportContext));
    }

    public Iterable<es0> r() {
        return (Iterable) K(sf0.a());
    }

    static /* synthetic */ List e0(SQLiteDatabase db) {
        return (List) r0(db.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), yf0.a());
    }

    static /* synthetic */ List d0(Cursor cursor) {
        List<TransportContext> results = new ArrayList<>();
        while (cursor.moveToNext()) {
            results.add(es0.a().b(cursor.getString(1)).d(ta0.b(cursor.getInt(2))).c(n0(cursor.getString(3))).a());
        }
        return results;
    }

    public int p() {
        return ((Integer) K(tf0.a(this.f3161a.a() - this.f3162a.c()))).intValue();
    }

    public void close() {
        this.f3163a.close();
    }

    private static byte[] n0(String value) {
        if (value == null) {
            return null;
        }
        return Base64.decode(value, 0);
    }

    /* access modifiers changed from: private */
    public List<b90> l0(SQLiteDatabase db, es0 transportContext) {
        List<PersistedEvent> events = new ArrayList<>();
        Long contextId = J(db, transportContext);
        if (contextId == null) {
            return events;
        }
        SQLiteDatabase sQLiteDatabase = db;
        r0(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code"}, "context_id = ?", new String[]{contextId.toString()}, (String) null, (String) null, (String) null, String.valueOf(this.f3162a.d())), uf0.a(events, transportContext));
        return events;
    }

    static /* synthetic */ Object g0(List events, es0 transportContext, Cursor cursor) {
        while (cursor.moveToNext()) {
            long id = cursor.getLong(0);
            aj.a event = aj.a().j(cursor.getString(1)).i(cursor.getLong(2)).k(cursor.getLong(3)).h(new pi(p0(cursor.getString(4)), cursor.getBlob(5)));
            if (!cursor.isNull(6)) {
                event.g(Integer.valueOf(cursor.getInt(6)));
            }
            events.add(b90.a(id, transportContext, event.d()));
        }
        return null;
    }

    private static qi p0(String value) {
        if (value == null) {
            return a;
        }
        return qi.b(value);
    }

    private Map<Long, Set<c>> m0(SQLiteDatabase db, List<b90> events) {
        Map<Long, Set<SQLiteEventStore.Metadata>> metadataIndex = new HashMap<>();
        StringBuilder whereClause = new StringBuilder("event_id IN (");
        for (int i = 0; i < events.size(); i++) {
            whereClause.append(events.get(i).c());
            if (i < events.size() - 1) {
                whereClause.append(',');
            }
        }
        whereClause.append(')');
        r0(db.query("event_metadata", new String[]{"event_id", "name", "value"}, whereClause.toString(), (String[]) null, (String) null, (String) null, (String) null), vf0.a(metadataIndex));
        return metadataIndex;
    }

    static /* synthetic */ Object h0(Map metadataIndex, Cursor cursor) {
        while (cursor.moveToNext()) {
            long eventId = cursor.getLong(0);
            Set<SQLiteEventStore.Metadata> currentSet = (Set) metadataIndex.get(Long.valueOf(eventId));
            if (currentSet == null) {
                currentSet = new HashSet<>();
                metadataIndex.put(Long.valueOf(eventId), currentSet);
            }
            currentSet.add(new c(cursor.getString(1), cursor.getString(2)));
        }
        return null;
    }

    private List<b90> U(List<b90> events, Map<Long, Set<c>> metadataIndex) {
        ListIterator<b90> listIterator = events.listIterator();
        while (listIterator.hasNext()) {
            b90 current = listIterator.next();
            if (metadataIndex.containsKey(Long.valueOf(current.c()))) {
                aj.a newEvent = current.b().l();
                for (c metadata : metadataIndex.get(Long.valueOf(current.c()))) {
                    newEvent.c(metadata.a, metadata.b);
                }
                listIterator.set(b90.a(current.c(), current.d(), newEvent.d()));
            }
        }
        return events;
    }

    private <T> T o0(d<T> retriable, b<Throwable, T> failureHandler) {
        long startTime = this.b.a();
        while (true) {
            try {
                return retriable.a();
            } catch (SQLiteDatabaseLockedException ex) {
                if (this.b.a() >= ((long) this.f3162a.b()) + startTime) {
                    return failureHandler.apply(ex);
                }
                SystemClock.sleep(50);
            }
        }
    }

    private void f(SQLiteDatabase db) {
        o0(wf0.b(db), xf0.a());
    }

    static /* synthetic */ Object Y(Throwable ex) {
        throw new wo0("Timed out while trying to acquire the lock.", ex);
    }

    public <T> T c(xo0.a<T> criticalSection) {
        SQLiteDatabase db = q();
        f(db);
        try {
            T result = criticalSection.a();
            db.setTransactionSuccessful();
            return result;
        } finally {
            db.endTransaction();
        }
    }

    private <T> T K(b<SQLiteDatabase, T> function) {
        SQLiteDatabase db = q();
        db.beginTransaction();
        try {
            T result = function.apply(db);
            db.setTransactionSuccessful();
            return result;
        } finally {
            db.endTransaction();
        }
    }

    /* renamed from: hg0$c */
    private static class c {
        final String a;
        final String b;

        private c(String key, String value) {
            this.a = key;
            this.b = value;
        }
    }

    private boolean P() {
        return w() * C() >= this.f3162a.e();
    }

    private long C() {
        return q().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    private long w() {
        return q().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    private static <T> T r0(Cursor c2, b<Cursor, T> function) {
        try {
            return function.apply(c2);
        } finally {
            c2.close();
        }
    }
}
