package defpackage;

import android.util.SparseArray;
import com.google.firebase.firestore.util.c;
import com.google.firebase.firestore.util.i;
import java.util.Comparator;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: iz  reason: default package */
public class iz {
    /* access modifiers changed from: private */
    public static final long a;
    /* access modifiers changed from: private */
    public static final long b;

    /* renamed from: a  reason: collision with other field name */
    private final fz f3993a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final a f3994a;

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        a = timeUnit.toMillis(1);
        b = timeUnit.toMillis(5);
    }

    /* renamed from: iz$a */
    public static class a {
        final int a;

        /* renamed from: a  reason: collision with other field name */
        final long f3995a;
        final int b;

        public static a a(long cacheSizeBytes) {
            return new a(cacheSizeBytes, 10, 1000);
        }

        a(long minBytesThreshold, int percentileToCollect, int maximumSequenceNumbersToCollect) {
            this.f3995a = minBytesThreshold;
            this.a = percentileToCollect;
            this.b = maximumSequenceNumbersToCollect;
        }
    }

    /* renamed from: iz$b */
    public static class b {
        private final int a;

        /* renamed from: a  reason: collision with other field name */
        private final boolean f3996a;
        private final int b;
        private final int c;

        static b a() {
            return new b(false, 0, 0, 0);
        }

        b(boolean hasRun, int sequenceNumbersCollected, int targetsRemoved, int documentsRemoved) {
            this.f3996a = hasRun;
            this.a = sequenceNumbersCollected;
            this.b = targetsRemoved;
            this.c = documentsRemoved;
        }
    }

    /* renamed from: iz$d */
    public class d {
        private c.b a;

        /* renamed from: a  reason: collision with other field name */
        private final com.google.firebase.firestore.util.c f3999a;

        /* renamed from: a  reason: collision with other field name */
        private final ky f4001a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f4002a = false;

        public d(com.google.firebase.firestore.util.c asyncQueue, ky localStore) {
            this.f3999a = asyncQueue;
            this.f4001a = localStore;
        }

        public void c() {
            if (iz.this.f3994a.f3995a != -1) {
                b();
            }
        }

        private void b() {
            this.a = this.f3999a.f(c.d.GARBAGE_COLLECTION, this.f4002a ? iz.b : iz.a, kz.a(this));
        }

        static /* synthetic */ void a(d dVar) {
            dVar.f4001a.e(iz.this);
            dVar.f4002a = true;
            dVar.b();
        }
    }

    iz(fz delegate, a params) {
        this.f3993a = delegate;
        this.f3994a = params;
    }

    public d i(com.google.firebase.firestore.util.c asyncQueue, ky localStore) {
        return new d(asyncQueue, localStore);
    }

    /* access modifiers changed from: package-private */
    public int d(int percentile) {
        return (int) ((((float) percentile) / 100.0f) * ((float) this.f3993a.o()));
    }

    /* renamed from: iz$c */
    private static class c {
        private static final Comparator<Long> a = jz.a();

        /* renamed from: a  reason: collision with other field name */
        private final int f3997a;

        /* renamed from: a  reason: collision with other field name */
        private final PriorityQueue<Long> f3998a;

        c(int count) {
            this.f3997a = count;
            this.f3998a = new PriorityQueue<>(count, a);
        }

        /* access modifiers changed from: package-private */
        public void a(Long sequenceNumber) {
            if (this.f3998a.size() < this.f3997a) {
                this.f3998a.add(sequenceNumber);
            } else if (sequenceNumber.longValue() < this.f3998a.peek().longValue()) {
                this.f3998a.poll();
                this.f3998a.add(sequenceNumber);
            }
        }

        /* access modifiers changed from: package-private */
        public long b() {
            return this.f3998a.peek().longValue();
        }
    }

    /* access modifiers changed from: package-private */
    public long g(int count) {
        if (count == 0) {
            return -1;
        }
        c buffer = new c(count);
        this.f3993a.n(gz.a(buffer));
        fz fzVar = this.f3993a;
        buffer.getClass();
        fzVar.h(hz.a(buffer));
        return buffer.b();
    }

    /* access modifiers changed from: package-private */
    public int k(long upperBound, SparseArray<?> activeTargetIds) {
        return this.f3993a.c(upperBound, activeTargetIds);
    }

    /* access modifiers changed from: package-private */
    public int j(long upperBound) {
        return this.f3993a.f(upperBound);
    }

    /* access modifiers changed from: package-private */
    public b e(SparseArray<?> activeTargetIds) {
        if (this.f3994a.f3995a == -1) {
            i.a("LruGarbageCollector", "Garbage collection skipped; disabled", new Object[0]);
            return b.a();
        }
        long cacheSize = f();
        if (cacheSize >= this.f3994a.f3995a) {
            return l(activeTargetIds);
        }
        i.a("LruGarbageCollector", "Garbage collection skipped; Cache size " + cacheSize + " is lower than threshold " + this.f3994a.f3995a, new Object[0]);
        return b.a();
    }

    private b l(SparseArray<?> liveTargetIds) {
        long startTs = System.currentTimeMillis();
        int sequenceNumbers = d(this.f3994a.a);
        if (sequenceNumbers > this.f3994a.b) {
            i.a("LruGarbageCollector", "Capping sequence numbers to collect down to the maximum of " + this.f3994a.b + " from " + sequenceNumbers, new Object[0]);
            sequenceNumbers = this.f3994a.b;
        }
        long countedTargetsTs = System.currentTimeMillis();
        long upperBound = g(sequenceNumbers);
        long foundUpperBoundTs = System.currentTimeMillis();
        int numTargetsRemoved = k(upperBound, liveTargetIds);
        long removedTargetsTs = System.currentTimeMillis();
        int numDocumentsRemoved = j(upperBound);
        long removedDocumentsTs = System.currentTimeMillis();
        if (i.c()) {
            StringBuilder sb = new StringBuilder();
            sb.append("LRU Garbage Collection:\n");
            Object obj = "LRU Garbage Collection:\n";
            sb.append("\tCounted targets in ");
            long j = upperBound;
            sb.append(countedTargetsTs - startTs);
            sb.append("ms\n");
            String desc = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(desc);
            Locale locale = Locale.ROOT;
            String str = desc;
            sb2.append(String.format(locale, "\tDetermined least recently used %d sequence numbers in %dms\n", new Object[]{Integer.valueOf(sequenceNumbers), Long.valueOf(foundUpperBoundTs - countedTargetsTs)}));
            String desc2 = sb2.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(desc2);
            String str2 = desc2;
            sb3.append(String.format(locale, "\tRemoved %d targets in %dms\n", new Object[]{Integer.valueOf(numTargetsRemoved), Long.valueOf(removedTargetsTs - foundUpperBoundTs)}));
            String desc3 = sb3.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(desc3);
            String str3 = desc3;
            sb4.append(String.format(locale, "\tRemoved %d documents in %dms\n", new Object[]{Integer.valueOf(numDocumentsRemoved), Long.valueOf(removedDocumentsTs - removedTargetsTs)}));
            String desc4 = sb4.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(desc4);
            String str4 = desc4;
            long j2 = startTs;
            sb5.append(String.format(locale, "Total Duration: %dms", new Object[]{Long.valueOf(removedDocumentsTs - startTs)}));
            i.a("LruGarbageCollector", sb5.toString(), new Object[0]);
        } else {
            long j3 = upperBound;
        }
        return new b(true, sequenceNumbers, numTargetsRemoved, numDocumentsRemoved);
    }

    /* access modifiers changed from: package-private */
    public long f() {
        return this.f3993a.g();
    }
}
