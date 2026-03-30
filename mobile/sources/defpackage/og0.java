package defpackage;

import android.database.Cursor;
import android.util.SparseArray;
import defpackage.iz;

/* renamed from: og0  reason: default package */
class og0 implements td0, fz {
    private long a = -1;

    /* renamed from: a  reason: collision with other field name */
    private final dh0 f4536a;

    /* renamed from: a  reason: collision with other field name */
    private final iz f4537a;

    /* renamed from: a  reason: collision with other field name */
    private nx f4538a;

    /* renamed from: a  reason: collision with other field name */
    private vd0 f4539a;

    og0(dh0 persistence, iz.a params) {
        this.f4536a = persistence;
        this.f4537a = new iz(this, params);
    }

    /* access modifiers changed from: package-private */
    public void w(long highestSequenceNumber) {
        this.f4538a = new nx(highestSequenceNumber);
    }

    public void e() {
        n4.d(this.a == -1, "Starting a transaction without committing the previous one", new Object[0]);
        this.a = this.f4538a.a();
    }

    public void k() {
        n4.d(this.a != -1, "Committing a transaction without having started one", new Object[0]);
        this.a = -1;
    }

    public long b() {
        n4.d(this.a != -1, "Attempting to get a sequence number outside of a transaction", new Object[0]);
        return this.a;
    }

    public iz i() {
        return this.f4537a;
    }

    public long o() {
        return this.f4536a.e().m() + ((Long) this.f4536a.x("SELECT COUNT(*) FROM (SELECT sequence_number FROM target_documents GROUP BY path HAVING COUNT(*) = 1 AND target_id = 0)").c(lg0.a())).longValue();
    }

    public void n(hc<bq0> consumer) {
        this.f4536a.e().k(consumer);
    }

    public void h(hc<Long> consumer) {
        this.f4536a.x("select sequence_number from target_documents group by path having COUNT(*) = 1 AND target_id = 0").d(mg0.a(consumer));
    }

    public void j(vd0 inMemoryPins) {
        this.f4539a = inMemoryPins;
    }

    public void p(mh key) {
        x(key);
    }

    public void a(mh key) {
        x(key);
    }

    public int c(long upperBound, SparseArray<?> activeTargetIds) {
        return this.f4536a.e().t(upperBound, activeTargetIds);
    }

    public void d(mh key) {
        x(key);
    }

    private boolean u(mh key) {
        return !this.f4536a.x("SELECT 1 FROM document_mutations WHERE path = ?").a(oi.c(key.h())).e();
    }

    private boolean q(mh key) {
        if (this.f4539a.c(key)) {
            return true;
        }
        return u(key);
    }

    private void v(mh key) {
        this.f4536a.o("DELETE FROM target_documents WHERE path = ? AND target_id = 0", oi.c(key.h()));
    }

    public int f(long upperBound) {
        int[] count = new int[1];
        boolean resultsRemaining = true;
        while (true) {
            boolean z = false;
            if (!resultsRemaining) {
                return count[0];
            }
            if (this.f4536a.x("select path from target_documents group by path having COUNT(*) = 1 AND target_id = 0 AND sequence_number <= ? LIMIT ?").a(Long.valueOf(upperBound), 100).d(ng0.a(this, count)) == 100) {
                z = true;
            }
            resultsRemaining = z;
        }
    }

    static /* synthetic */ void t(og0 og0, int[] count, Cursor row) {
        mh key = mh.e(oi.b(row.getString(0)));
        if (!og0.q(key)) {
            count[0] = count[0] + 1;
            og0.f4536a.d().c(key);
            og0.v(key);
        }
    }

    public void l(bq0 targetData) {
        this.f4536a.e().a(targetData.j(b()));
    }

    public void m(mh key) {
        x(key);
    }

    private void x(mh key) {
        String path = oi.c(key.h());
        this.f4536a.o("INSERT OR REPLACE INTO target_documents (target_id, path, sequence_number) VALUES (0, ?, ?)", path, Long.valueOf(b()));
    }

    public long g() {
        return this.f4536a.p();
    }
}
