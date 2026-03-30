package defpackage;

import com.google.firebase.firestore.core.b0;
import com.google.firebase.firestore.local.a;
import com.google.protobuf.e;

/* renamed from: bq0  reason: default package */
public final class bq0 {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final long f243a;

    /* renamed from: a  reason: collision with other field name */
    private final b0 f244a;

    /* renamed from: a  reason: collision with other field name */
    private final a f245a;

    /* renamed from: a  reason: collision with other field name */
    private final e f246a;

    /* renamed from: a  reason: collision with other field name */
    private final hm0 f247a;
    private final hm0 b;

    bq0(b0 target, int targetId, long sequenceNumber, a purpose, hm0 snapshotVersion, hm0 lastLimboFreeSnapshotVersion, e resumeToken) {
        this.f244a = (b0) v90.n(target);
        this.a = targetId;
        this.f243a = sequenceNumber;
        this.b = lastLimboFreeSnapshotVersion;
        this.f245a = purpose;
        this.f247a = (hm0) v90.n(snapshotVersion);
        this.f246a = (e) v90.n(resumeToken);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public bq0(com.google.firebase.firestore.core.b0 r10, int r11, long r12, com.google.firebase.firestore.local.a r14) {
        /*
            r9 = this;
            hm0 r7 = defpackage.hm0.a
            com.google.protobuf.e r8 = com.google.firebase.firestore.remote.j0.a
            r0 = r9
            r1 = r10
            r2 = r11
            r3 = r12
            r5 = r14
            r6 = r7
            r0.<init>(r1, r2, r3, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bq0.<init>(com.google.firebase.firestore.core.b0, int, long, com.google.firebase.firestore.local.a):void");
    }

    public bq0 j(long sequenceNumber) {
        return new bq0(this.f244a, this.a, sequenceNumber, this.f245a, this.f247a, this.b, this.f246a);
    }

    public bq0 i(e resumeToken, hm0 snapshotVersion) {
        return new bq0(this.f244a, this.a, this.f243a, this.f245a, snapshotVersion, this.b, resumeToken);
    }

    public bq0 h(hm0 lastLimboFreeSnapshotVersion) {
        return new bq0(this.f244a, this.a, this.f243a, this.f245a, this.f247a, lastLimboFreeSnapshotVersion, this.f246a);
    }

    public b0 f() {
        return this.f244a;
    }

    public int g() {
        return this.a;
    }

    public long d() {
        return this.f243a;
    }

    public a b() {
        return this.f245a;
    }

    public hm0 e() {
        return this.f247a;
    }

    public e c() {
        return this.f246a;
    }

    public hm0 a() {
        return this.b;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        bq0 targetData = (bq0) o;
        if (!this.f244a.equals(targetData.f244a) || this.a != targetData.a || this.f243a != targetData.f243a || !this.f245a.equals(targetData.f245a) || !this.f247a.equals(targetData.f247a) || !this.b.equals(targetData.b) || !this.f246a.equals(targetData.f246a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((((((this.f244a.hashCode() * 31) + this.a) * 31) + ((int) this.f243a)) * 31) + this.f245a.hashCode()) * 31) + this.f247a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.f246a.hashCode();
    }

    public String toString() {
        return "TargetData{target=" + this.f244a + ", targetId=" + this.a + ", sequenceNumber=" + this.f243a + ", purpose=" + this.f245a + ", snapshotVersion=" + this.f247a + ", lastLimboFreeSnapshotVersion=" + this.b + ", resumeToken=" + this.f246a + '}';
    }
}
