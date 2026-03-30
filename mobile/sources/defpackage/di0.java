package defpackage;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.util.SparseArray;
import com.google.firebase.database.collection.e;
import com.google.firebase.firestore.core.b0;
import com.google.protobuf.m;
import java.util.Iterator;

/* renamed from: di0  reason: default package */
final class di0 implements zp0 {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private long f2774a;

    /* renamed from: a  reason: collision with other field name */
    private final dh0 f2775a;

    /* renamed from: a  reason: collision with other field name */
    private hm0 f2776a = hm0.a;

    /* renamed from: a  reason: collision with other field name */
    private final zx f2777a;
    private long b;

    di0(dh0 db, zx localSerializer) {
        this.f2775a = db;
        this.f2777a = localSerializer;
    }

    /* access modifiers changed from: package-private */
    public void w() {
        boolean z = true;
        if (this.f2775a.x("SELECT highest_target_id, highest_listen_sequence_number, last_remote_snapshot_version_seconds, last_remote_snapshot_version_nanos, target_count FROM target_globals LIMIT 1").b(yh0.a(this)) != 1) {
            z = false;
        }
        n4.d(z, "Missing target_globals entry", new Object[0]);
    }

    static /* synthetic */ void r(di0 di0, Cursor row) {
        di0.a = row.getInt(0);
        di0.f2774a = (long) row.getInt(1);
        di0.f2776a = new hm0(new pr0(row.getLong(2), row.getInt(3)));
        di0.b = row.getLong(4);
    }

    public int d() {
        return this.a;
    }

    public long l() {
        return this.f2774a;
    }

    public long m() {
        return this.b;
    }

    public void k(hc<bq0> consumer) {
        this.f2775a.x("SELECT target_proto FROM targets").d(zh0.a(this, consumer));
    }

    public hm0 c() {
        return this.f2776a;
    }

    public void i(hm0 snapshotVersion) {
        this.f2776a = snapshotVersion;
        y();
    }

    private void v(bq0 targetData) {
        int targetId = targetData.g();
        String canonicalId = targetData.f().a();
        pr0 version = targetData.e().b();
        com.google.firebase.firestore.proto.c targetProto = this.f2777a.k(targetData);
        this.f2775a.o("INSERT OR REPLACE INTO targets (target_id, canonical_id, snapshot_version_seconds, snapshot_version_nanos, resume_token, last_listen_sequence_number, target_proto) VALUES (?, ?, ?, ?, ?, ?, ?)", Integer.valueOf(targetId), canonicalId, Long.valueOf(version.p()), Integer.valueOf(version.o()), targetData.c().B(), Long.valueOf(targetData.d()), targetProto.e());
    }

    private boolean x(bq0 targetData) {
        boolean wasUpdated = false;
        if (targetData.g() > this.a) {
            this.a = targetData.g();
            wasUpdated = true;
        }
        if (targetData.d() <= this.f2774a) {
            return wasUpdated;
        }
        this.f2774a = targetData.d();
        return true;
    }

    public void h(bq0 targetData) {
        v(targetData);
        x(targetData);
        this.b++;
        y();
    }

    public void a(bq0 targetData) {
        v(targetData);
        if (x(targetData)) {
            y();
        }
    }

    private void y() {
        this.f2775a.o("UPDATE target_globals SET highest_target_id = ?, highest_listen_sequence_number = ?, last_remote_snapshot_version_seconds = ?, last_remote_snapshot_version_nanos = ?, target_count = ?", Integer.valueOf(this.a), Long.valueOf(this.f2774a), Long.valueOf(this.f2776a.b().p()), Integer.valueOf(this.f2776a.b().o()), Long.valueOf(this.b));
    }

    private void u(int targetId) {
        s(targetId);
        this.f2775a.o("DELETE FROM targets WHERE target_id = ?", Integer.valueOf(targetId));
        this.b--;
    }

    /* access modifiers changed from: package-private */
    public int t(long upperBound, SparseArray<?> activeTargetIds) {
        int[] count = new int[1];
        this.f2775a.x("SELECT target_id FROM targets WHERE last_listen_sequence_number <= ?").a(Long.valueOf(upperBound)).d(ai0.a(this, activeTargetIds, count));
        y();
        return count[0];
    }

    static /* synthetic */ void q(di0 di0, SparseArray activeTargetIds, int[] count, Cursor row) {
        int targetId = row.getInt(0);
        if (activeTargetIds.get(targetId) == null) {
            di0.u(targetId);
            count[0] = count[0] + 1;
        }
    }

    public bq0 g(b0 target) {
        String canonicalId = target.a();
        c result = new c();
        this.f2775a.x("SELECT target_proto FROM targets WHERE canonical_id = ?").a(canonicalId).d(bi0.a(this, target, result));
        return result.a;
    }

    static /* synthetic */ void p(di0 di0, b0 target, c result, Cursor row) {
        bq0 found = di0.j(row.getBlob(0));
        if (target.equals(found.f())) {
            result.a = found;
        }
    }

    /* renamed from: di0$c */
    private static class c {
        bq0 a;

        private c() {
        }
    }

    private bq0 j(byte[] bytes) {
        try {
            return this.f2777a.e(com.google.firebase.firestore.proto.c.d0(bytes));
        } catch (m e) {
            throw n4.a("TargetData failed to parse: %s", e);
        }
    }

    public void b(e<mh> keys, int targetId) {
        SQLiteStatement inserter = this.f2775a.w("INSERT OR IGNORE INTO target_documents (target_id, path) VALUES (?, ?)");
        td0 delegate = this.f2775a.c();
        Iterator<mh> it = keys.iterator();
        while (it.hasNext()) {
            mh key = it.next();
            String path = oi.c(key.h());
            this.f2775a.n(inserter, Integer.valueOf(targetId), path);
            delegate.p(key);
        }
    }

    public void e(e<mh> keys, int targetId) {
        SQLiteStatement deleter = this.f2775a.w("DELETE FROM target_documents WHERE target_id = ? AND path = ?");
        td0 delegate = this.f2775a.c();
        Iterator<mh> it = keys.iterator();
        while (it.hasNext()) {
            mh key = it.next();
            String path = oi.c(key.h());
            this.f2775a.n(deleter, Integer.valueOf(targetId), path);
            delegate.a(key);
        }
    }

    private void s(int targetId) {
        this.f2775a.o("DELETE FROM target_documents WHERE target_id = ?", Integer.valueOf(targetId));
    }

    public e<mh> f(int targetId) {
        b holder = new b();
        this.f2775a.x("SELECT path FROM target_documents WHERE target_id = ?").a(Integer.valueOf(targetId)).d(ci0.a(holder));
        return holder.a;
    }

    /* renamed from: di0$b */
    private static class b {
        /* access modifiers changed from: package-private */
        public e<mh> a;

        private b() {
            this.a = mh.d();
        }
    }
}
