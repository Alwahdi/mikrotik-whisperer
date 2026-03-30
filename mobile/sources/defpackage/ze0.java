package defpackage;

import androidx.core.app.NotificationCompat;
import defpackage.ux;
import defpackage.v4;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.p;
import io.grpc.util.RoundRobinLoadBalancer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: ze0  reason: default package */
final class ze0 extends ux {
    private static final p a = p.f3953a.q("no subchannels ready");
    static final v4.c<d<fc>> c = v4.c.a("state-info");

    /* renamed from: a  reason: collision with other field name */
    private io.grpc.e f6025a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<ti, ux.h> f6026a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    private final Random f6027a;

    /* renamed from: a  reason: collision with other field name */
    private final ux.d f6028a;

    /* renamed from: a  reason: collision with other field name */
    private e f6029a = new b(a);

    ze0(ux.d helper) {
        this.f6028a = (ux.d) v90.o(helper, "helper");
        this.f6027a = new Random();
    }

    public void c(ux.g resolvedAddresses) {
        List<ti> a2 = resolvedAddresses.a();
        Set<ti> keySet = this.f6026a.keySet();
        Map<ti, ti> o = o(a2);
        Set<EquivalentAddressGroup> removedAddrs = l(keySet, o.keySet());
        for (Map.Entry<EquivalentAddressGroup, EquivalentAddressGroup> latestEntry : o.entrySet()) {
            ti strippedAddressGroup = (ti) latestEntry.getKey();
            ti originalAddressGroup = (ti) latestEntry.getValue();
            ux.h existingSubchannel = this.f6026a.get(strippedAddressGroup);
            if (existingSubchannel != null) {
                existingSubchannel.h(Collections.singletonList(originalAddressGroup));
            } else {
                ux.h subchannel = (ux.h) v90.o(this.f6028a.a(ux.b.c().b(originalAddressGroup).d(v4.c().d(c, new d(fc.a(io.grpc.e.IDLE))).a()).a()), "subchannel");
                subchannel.g(new a(subchannel));
                this.f6026a.put(strippedAddressGroup, subchannel);
                subchannel.e();
            }
        }
        ArrayList<LoadBalancer.Subchannel> removedSubchannels = new ArrayList<>();
        Iterator<EquivalentAddressGroup> it = removedAddrs.iterator();
        while (it.hasNext()) {
            removedSubchannels.add(this.f6026a.remove((ti) it.next()));
        }
        p();
        Iterator<LoadBalancer.Subchannel> it2 = removedSubchannels.iterator();
        while (it2.hasNext()) {
            m((ux.h) it2.next());
        }
    }

    /* renamed from: ze0$a */
    class a implements ux.j {
        final /* synthetic */ ux.h a;

        a(ux.h hVar) {
            this.a = hVar;
        }

        public void a(fc state) {
            ze0.this.k(this.a, state);
        }
    }

    public void b(p error) {
        io.grpc.e eVar = io.grpc.e.TRANSIENT_FAILURE;
        e eVar2 = this.f6029a;
        if (!(eVar2 instanceof c)) {
            eVar2 = new b(error);
        }
        q(eVar, eVar2);
    }

    /* access modifiers changed from: private */
    public void k(ux.h subchannel, fc stateInfo) {
        if (this.f6026a.get(n(subchannel.a())) == subchannel) {
            io.grpc.e c2 = stateInfo.c();
            io.grpc.e eVar = io.grpc.e.IDLE;
            if (c2 == eVar) {
                subchannel.e();
            }
            RoundRobinLoadBalancer.Ref<ConnectivityStateInfo> subchannelStateRef = h(subchannel);
            if (!((fc) subchannelStateRef.a).c().equals(io.grpc.e.TRANSIENT_FAILURE) || (!stateInfo.c().equals(io.grpc.e.CONNECTING) && !stateInfo.c().equals(eVar))) {
                subchannelStateRef.a = stateInfo;
                p();
            }
        }
    }

    private void m(ux.h subchannel) {
        subchannel.f();
        h(subchannel).a = fc.a(io.grpc.e.SHUTDOWN);
    }

    public void e() {
        for (ux.h subchannel : i()) {
            m(subchannel);
        }
    }

    private void p() {
        List<ux.h> g = g(i());
        if (g.isEmpty()) {
            boolean isConnecting = false;
            p aggStatus = a;
            for (ux.h subchannel : i()) {
                fc stateInfo = (fc) h(subchannel).a;
                if (stateInfo.c() == io.grpc.e.CONNECTING || stateInfo.c() == io.grpc.e.IDLE) {
                    isConnecting = true;
                }
                if (aggStatus == a || !aggStatus.o()) {
                    aggStatus = stateInfo.d();
                }
            }
            q(isConnecting ? io.grpc.e.CONNECTING : io.grpc.e.TRANSIENT_FAILURE, new b(aggStatus));
            return;
        }
        q(io.grpc.e.READY, new c(g, this.f6027a.nextInt(g.size())));
    }

    private void q(io.grpc.e state, e picker) {
        if (state != this.f6025a || !picker.c(this.f6029a)) {
            this.f6028a.d(state, picker);
            this.f6025a = state;
            this.f6029a = picker;
        }
    }

    private static List<ux.h> g(Collection<ux.h> subchannels) {
        List<LoadBalancer.Subchannel> readySubchannels = new ArrayList<>(subchannels.size());
        for (ux.h subchannel : subchannels) {
            if (j(subchannel)) {
                readySubchannels.add(subchannel);
            }
        }
        return readySubchannels;
    }

    private static Map<ti, ti> o(List<ti> groupList) {
        Map<EquivalentAddressGroup, EquivalentAddressGroup> addrs = new HashMap<>(groupList.size() * 2);
        for (ti group : groupList) {
            addrs.put(n(group), group);
        }
        return addrs;
    }

    private static ti n(ti eag) {
        return new ti(eag.a());
    }

    /* access modifiers changed from: package-private */
    public Collection<ux.h> i() {
        return this.f6026a.values();
    }

    private static d<fc> h(ux.h subchannel) {
        return (d) v90.o(subchannel.c().b(c), "STATE_INFO");
    }

    static boolean j(ux.h subchannel) {
        return ((fc) h(subchannel).a).c() == io.grpc.e.READY;
    }

    private static <T> Set<T> l(Set<T> a2, Set<T> b2) {
        Set<T> aCopy = new HashSet<>(a2);
        aCopy.removeAll(b2);
        return aCopy;
    }

    /* renamed from: ze0$e */
    private static abstract class e extends ux.i {
        /* access modifiers changed from: package-private */
        public abstract boolean c(e eVar);

        private e() {
        }

        /* synthetic */ e(a x0) {
            this();
        }
    }

    /* renamed from: ze0$c */
    static final class c extends e {
        private static final AtomicIntegerFieldUpdater<c> a = AtomicIntegerFieldUpdater.newUpdater(c.class, "a");

        /* renamed from: a  reason: collision with other field name */
        private volatile int f6031a;

        /* renamed from: a  reason: collision with other field name */
        private final List<ux.h> f6032a;

        c(List<ux.h> list, int startIndex) {
            super((a) null);
            v90.e(!list.isEmpty(), "empty list");
            this.f6032a = list;
            this.f6031a = startIndex - 1;
        }

        public ux.e a(ux.f args) {
            return ux.e.h(d());
        }

        public String toString() {
            return f20.b(c.class).d("list", this.f6032a).toString();
        }

        private ux.h d() {
            int size = this.f6032a.size();
            AtomicIntegerFieldUpdater<c> atomicIntegerFieldUpdater = a;
            int i = atomicIntegerFieldUpdater.incrementAndGet(this);
            if (i >= size) {
                int oldi = i;
                i %= size;
                atomicIntegerFieldUpdater.compareAndSet(this, oldi, i);
            }
            return this.f6032a.get(i);
        }

        /* JADX WARNING: type inference failed for: r5v0, types: [ze0$e] */
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean c(defpackage.ze0.e r5) {
            /*
                r4 = this;
                boolean r0 = r5 instanceof defpackage.ze0.c
                r1 = 0
                if (r0 != 0) goto L_0x0006
                return r1
            L_0x0006:
                r0 = r5
                ze0$c r0 = (defpackage.ze0.c) r0
                if (r0 == r4) goto L_0x0028
                java.util.List<ux$h> r2 = r4.f6032a
                int r2 = r2.size()
                java.util.List<ux$h> r3 = r0.f6032a
                int r3 = r3.size()
                if (r2 != r3) goto L_0x0029
                java.util.HashSet r2 = new java.util.HashSet
                java.util.List<ux$h> r3 = r4.f6032a
                r2.<init>(r3)
                java.util.List<ux$h> r3 = r0.f6032a
                boolean r2 = r2.containsAll(r3)
                if (r2 == 0) goto L_0x0029
            L_0x0028:
                r1 = 1
            L_0x0029:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.ze0.c.c(ze0$e):boolean");
        }
    }

    /* renamed from: ze0$b */
    static final class b extends e {
        private final p a;

        b(p status) {
            super((a) null);
            this.a = (p) v90.o(status, NotificationCompat.CATEGORY_STATUS);
        }

        public ux.e a(ux.f args) {
            return this.a.o() ? ux.e.g() : ux.e.f(this.a);
        }

        /* access modifiers changed from: package-private */
        public boolean c(e picker) {
            return (picker instanceof b) && (f40.a(this.a, ((b) picker).a) || (this.a.o() && ((b) picker).a.o()));
        }

        public String toString() {
            return f20.b(b.class).d(NotificationCompat.CATEGORY_STATUS, this.a).toString();
        }
    }

    /* renamed from: ze0$d */
    static final class d<T> {
        T a;

        d(T value) {
            this.a = value;
        }
    }
}
