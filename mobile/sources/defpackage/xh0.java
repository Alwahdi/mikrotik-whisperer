package defpackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.proto.c;
import com.google.firebase.firestore.util.Consumer;
import com.google.protobuf.m;
import defpackage.dh0;
import defpackage.z00;
import java.util.ArrayList;
import java.util.List;

/* renamed from: xh0  reason: default package */
class xh0 {
    private final SQLiteDatabase a;

    xh0(SQLiteDatabase db) {
        this.a = db;
    }

    /* access modifiers changed from: package-private */
    public void E(int fromVersion) {
        F(fromVersion, 10);
    }

    /* access modifiers changed from: package-private */
    public void F(int fromVersion, int toVersion) {
        if (fromVersion < 1 && toVersion >= 1) {
            e();
            g();
            f();
        }
        if (fromVersion < 3 && toVersion >= 3 && fromVersion != 0) {
            j();
            g();
        }
        if (fromVersion < 4 && toVersion >= 4) {
            l();
            c();
        }
        if (fromVersion < 5 && toVersion >= 5) {
            b();
        }
        if (fromVersion < 6 && toVersion >= 6) {
            C();
        }
        if (fromVersion < 7 && toVersion >= 7) {
            k();
        }
        if (fromVersion < 8 && toVersion >= 8) {
            h();
        }
        if (fromVersion < 9 && toVersion >= 9) {
            if (!n()) {
                a();
            } else {
                i();
            }
        }
        if (fromVersion == 9 && toVersion >= 10) {
            i();
        }
        if (fromVersion < 11 && toVersion >= 11) {
            v90.t(c90.f314a);
            d();
        }
    }

    private void o(String[] tables, Runnable fn) {
        String msg;
        boolean tablesFound = false;
        String allTables = "[" + TextUtils.join(", ", tables) + "]";
        for (int i = 0; i < tables.length; i++) {
            String table = tables[i];
            boolean tableFound = H(table);
            if (i == 0) {
                tablesFound = tableFound;
            } else if (tableFound != tablesFound) {
                String msg2 = "Expected all of " + allTables + " to either exist or not, but ";
                if (tablesFound) {
                    msg = msg2 + tables[0] + " exists and " + table + " does not";
                } else {
                    msg = msg2 + tables[0] + " does not exist and " + table + " does";
                }
                throw new IllegalStateException(msg);
            }
        }
        if (!tablesFound) {
            fn.run();
            return;
        }
        Log.d("SQLiteSchema", "Skipping migration because all of " + allTables + " already exist");
    }

    private void e() {
        o(new String[]{"mutation_queues", "mutations", "document_mutations"}, oh0.a(this));
    }

    static /* synthetic */ void q(xh0 xh0) {
        xh0.a.execSQL("CREATE TABLE mutation_queues (uid TEXT PRIMARY KEY, last_acknowledged_batch_id INTEGER, last_stream_token BLOB)");
        xh0.a.execSQL("CREATE TABLE mutations (uid TEXT, batch_id INTEGER, mutations BLOB, PRIMARY KEY (uid, batch_id))");
        xh0.a.execSQL("CREATE TABLE document_mutations (uid TEXT, path TEXT, batch_id INTEGER, PRIMARY KEY (uid, path, batch_id))");
    }

    private void C() {
        new dh0.d(this.a, "SELECT uid, last_acknowledged_batch_id FROM mutation_queues").d(ph0.a(this));
    }

    static /* synthetic */ void B(xh0 xh0, Cursor mutationQueueEntry) {
        String uid = mutationQueueEntry.getString(0);
        long lastAcknowledgedBatchId = mutationQueueEntry.getLong(1);
        new dh0.d(xh0.a, "SELECT batch_id FROM mutations WHERE uid = ? AND batch_id <= ?").a(uid, Long.valueOf(lastAcknowledgedBatchId)).d(nh0.a(xh0, uid));
    }

    /* access modifiers changed from: private */
    public void D(String uid, int batchId) {
        SQLiteStatement mutationDeleter = this.a.compileStatement("DELETE FROM mutations WHERE uid = ? AND batch_id = ?");
        mutationDeleter.bindString(1, uid);
        mutationDeleter.bindLong(2, (long) batchId);
        n4.d(mutationDeleter.executeUpdateDelete() != 0, "Mutatiohn batch (%s, %d) did not exist", uid, Integer.valueOf(batchId));
        this.a.execSQL("DELETE FROM document_mutations WHERE uid = ? AND batch_id = ?", new Object[]{uid, Integer.valueOf(batchId)});
    }

    private void g() {
        o(new String[]{"targets", "target_globals", "target_documents"}, qh0.a(this));
    }

    static /* synthetic */ void s(xh0 xh0) {
        xh0.a.execSQL("CREATE TABLE targets (target_id INTEGER PRIMARY KEY, canonical_id TEXT, snapshot_version_seconds INTEGER, snapshot_version_nanos INTEGER, resume_token BLOB, last_listen_sequence_number INTEGER,target_proto BLOB)");
        xh0.a.execSQL("CREATE INDEX query_targets ON targets (canonical_id, target_id)");
        xh0.a.execSQL("CREATE TABLE target_globals (highest_target_id INTEGER, highest_listen_sequence_number INTEGER, last_remote_snapshot_version_seconds INTEGER, last_remote_snapshot_version_nanos INTEGER)");
        xh0.a.execSQL("CREATE TABLE target_documents (target_id INTEGER, path TEXT, PRIMARY KEY (target_id, path))");
        xh0.a.execSQL("CREATE INDEX document_targets ON target_documents (path, target_id)");
    }

    private void j() {
        if (H("targets")) {
            this.a.execSQL("DROP TABLE targets");
        }
        if (H("target_globals")) {
            this.a.execSQL("DROP TABLE target_globals");
        }
        if (H("target_documents")) {
            this.a.execSQL("DROP TABLE target_documents");
        }
    }

    private void f() {
        o(new String[]{"remote_documents"}, rh0.a(this));
    }

    private void d() {
        o(new String[]{"collection_index"}, sh0.a(this));
    }

    private void l() {
        if (!(DatabaseUtils.queryNumEntries(this.a, "target_globals") == 1)) {
            this.a.execSQL("INSERT INTO target_globals (highest_target_id, highest_listen_sequence_number, last_remote_snapshot_version_seconds, last_remote_snapshot_version_nanos) VALUES (?, ?, ?, ?)", new String[]{"0", "0", "0", "0"});
        }
    }

    private void c() {
        if (!G("target_globals", "target_count")) {
            this.a.execSQL("ALTER TABLE target_globals ADD COLUMN target_count INTEGER");
        }
        long count = DatabaseUtils.queryNumEntries(this.a, "targets");
        ContentValues cv = new ContentValues();
        cv.put("target_count", Long.valueOf(count));
        this.a.update("target_globals", cv, (String) null, (String[]) null);
    }

    private void b() {
        if (!G("target_documents", "sequence_number")) {
            this.a.execSQL("ALTER TABLE target_documents ADD COLUMN sequence_number INTEGER");
        }
    }

    private boolean n() {
        boolean hasReadTimeSeconds = G("remote_documents", "read_time_seconds");
        boolean hasReadTimeNanos = G("remote_documents", "read_time_nanos");
        n4.d(hasReadTimeSeconds == hasReadTimeNanos, "Table contained just one of read_time_seconds or read_time_nanos", new Object[0]);
        if (!hasReadTimeSeconds || !hasReadTimeNanos) {
            return false;
        }
        return true;
    }

    private void a() {
        this.a.execSQL("ALTER TABLE remote_documents ADD COLUMN read_time_seconds INTEGER");
        this.a.execSQL("ALTER TABLE remote_documents ADD COLUMN read_time_nanos INTEGER");
    }

    private void i() {
        new dh0.d(this.a, "SELECT target_id, target_proto FROM targets").d(th0.a(this));
    }

    static /* synthetic */ void x(xh0 xh0, Cursor cursor) {
        int targetId = cursor.getInt(0);
        try {
            c targetProto = (c) ((c.b) c.d0(cursor.getBlob(1)).a()).x().q();
            xh0.a.execSQL("UPDATE targets SET target_proto = ? WHERE target_id = ?", new Object[]{targetProto.e(), Integer.valueOf(targetId)});
        } catch (m e) {
            throw n4.a("Failed to decode Query data for target %s", Integer.valueOf(targetId));
        }
    }

    private void k() {
        Long boxedSequenceNumber = (Long) new dh0.d(this.a, "SELECT highest_listen_sequence_number FROM target_globals LIMIT 1").c(uh0.a());
        n4.d(boxedSequenceNumber != null, "Missing highest sequence number", new Object[0]);
        long sequenceNumber = boxedSequenceNumber.longValue();
        SQLiteStatement tagDocument = this.a.compileStatement("INSERT INTO target_documents (target_id, path, sequence_number) VALUES (0, ?, ?)");
        dh0.d untaggedDocumentsQuery = new dh0.d(this.a, "SELECT RD.path FROM remote_documents AS RD WHERE NOT EXISTS (SELECT TD.path FROM target_documents AS TD WHERE RD.path = TD.path AND TD.target_id = 0) LIMIT ?").a(100);
        boolean[] resultsRemaining = new boolean[1];
        do {
            resultsRemaining[0] = false;
            untaggedDocumentsQuery.d(vh0.a(resultsRemaining, tagDocument, sequenceNumber));
        } while (resultsRemaining[0]);
    }

    static /* synthetic */ void z(boolean[] resultsRemaining, SQLiteStatement tagDocument, long sequenceNumber, Cursor row) {
        boolean z = true;
        resultsRemaining[0] = true;
        tagDocument.clearBindings();
        tagDocument.bindString(1, row.getString(0));
        tagDocument.bindLong(2, sequenceNumber);
        if (tagDocument.executeInsert() == -1) {
            z = false;
        }
        n4.d(z, "Failed to insert a sentinel row", new Object[0]);
    }

    private void h() {
        o(new String[]{"collection_parents"}, wh0.a(this));
        Consumer<ResourcePath> addEntry = kh0.a(new z00.a(), this.a.compileStatement("INSERT OR REPLACE INTO collection_parents (collection_id, parent) VALUES (?, ?)"));
        new dh0.d(this.a, "SELECT path FROM remote_documents").d(lh0.a(addEntry));
        new dh0.d(this.a, "SELECT path FROM document_mutations").d(mh0.a(addEntry));
    }

    static /* synthetic */ void t(z00.a cache, SQLiteStatement addIndexEntry, me0 collectionPath) {
        if (cache.a(collectionPath)) {
            String collectionId = collectionPath.h();
            addIndexEntry.clearBindings();
            addIndexEntry.bindString(1, collectionId);
            addIndexEntry.bindString(2, oi.c((me0) collectionPath.q()));
            addIndexEntry.execute();
        }
    }

    private boolean G(String table, String column) {
        return m(table).indexOf(column) != -1;
    }

    /* access modifiers changed from: package-private */
    public List<String> m(String table) {
        Cursor c = null;
        List<String> columns = new ArrayList<>();
        try {
            SQLiteDatabase sQLiteDatabase = this.a;
            Cursor c2 = sQLiteDatabase.rawQuery("PRAGMA table_info(" + table + ")", (String[]) null);
            int nameIndex = c2.getColumnIndex("name");
            while (c2.moveToNext()) {
                columns.add(c2.getString(nameIndex));
            }
            c2.close();
            return columns;
        } catch (Throwable th) {
            if (c != null) {
                c.close();
            }
            throw th;
        }
    }

    private boolean H(String table) {
        return !new dh0.d(this.a, "SELECT 1=1 FROM sqlite_master WHERE tbl_name = ?").a(table).e();
    }
}
