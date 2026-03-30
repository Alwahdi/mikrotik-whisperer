package defpackage;

import android.content.Context;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/* renamed from: rs0  reason: default package */
public class rs0 extends qs0 {
    private static final rs0 a = new rs0();
    /* access modifiers changed from: private */
    public static final String c = rs0.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with other field name */
    public int f4940c = 50;

    public static rs0 q() {
        return a;
    }

    public rs0 A(Context context) {
        super.j(context);
        return this;
    }

    public rs0 x(int timeout) {
        super.h(timeout);
        return this;
    }

    public rs0 y(boolean isLoggingEnabled) {
        super.i(isLoggingEnabled);
        return this;
    }

    public rs0 z(int retryCount) {
        this.f4940c = retryCount;
        return this;
    }

    public vl0<Date> u(String ntpPoolAddress) {
        if (qs0.d()) {
            return vl0.c(qs0.e());
        }
        return t(ntpPoolAddress).d(new a());
    }

    /* renamed from: rs0$a */
    class a implements mo<long[], Date> {
        a() {
        }

        /* renamed from: a */
        public Date apply(long[] longs) {
            return qs0.e();
        }
    }

    public vl0<long[]> t(String ntpPool) {
        return km.r(ntpPool).c(w()).c(v()).m();
    }

    /* renamed from: rs0$b */
    class b implements in<InetAddress, long[]> {
        b() {
        }

        /* renamed from: rs0$b$c */
        class c implements mo<InetAddress, String> {
            c() {
            }

            /* renamed from: a */
            public String apply(InetAddress inetAddress) {
                return inetAddress.getHostAddress();
            }
        }

        /* renamed from: b */
        public km<long[]> a(km<InetAddress> inetAddressObservable) {
            return inetAddressObservable.s(new c()).n(rs0.this.p(5)).C(5).D().i().l(new C0058b()).s(rs0.this.s()).g(new a());
        }

        /* renamed from: rs0$b$b  reason: collision with other inner class name */
        class C0058b implements ga0<List<long[]>> {
            C0058b() {
            }

            /* renamed from: a */
            public boolean test(List<long[]> longs) {
                return longs.size() > 0;
            }
        }

        /* renamed from: rs0$b$a */
        class a implements ic<long[]> {
            a() {
            }

            /* renamed from: a */
            public void accept(long[] ntpResponse) {
                rs0.this.c(ntpResponse);
                qs0.g();
            }
        }
    }

    private in<InetAddress, long[]> v() {
        return new b();
    }

    /* renamed from: rs0$c */
    class c implements in<String, InetAddress> {
        c() {
        }

        public rb0<InetAddress> a(km<String> ntpPoolFlowable) {
            return ntpPoolFlowable.t(gj0.a()).n(new a());
        }

        /* renamed from: rs0$c$a */
        class a implements mo<String, km<InetAddress>> {
            a() {
            }

            /* renamed from: a */
            public km<InetAddress> apply(String ntpPoolAddress) {
                try {
                    String m = rs0.c;
                    ps0.a(m, "---- resolving ntpHost : " + ntpPoolAddress);
                    return km.p(InetAddress.getAllByName(ntpPoolAddress));
                } catch (UnknownHostException e) {
                    return km.j(e);
                }
            }
        }
    }

    private in<String, InetAddress> w() {
        return new c();
    }

    /* renamed from: rs0$d */
    class d implements mo<String, km<long[]>> {
        final /* synthetic */ int a;

        d(int i) {
            this.a = i;
        }

        /* renamed from: a */
        public km<long[]> apply(String singleIp) {
            return km.r(singleIp).v((long) this.a).n(new a()).D().i().s(rs0.this.r());
        }

        /* renamed from: rs0$d$a */
        class a implements mo<String, km<long[]>> {
            a() {
            }

            /* renamed from: rs0$d$a$b */
            class b implements zm<long[]> {
                final /* synthetic */ String a;

                b(String str) {
                    this.a = str;
                }

                public void a(pm<long[]> o) {
                    String m = rs0.c;
                    ps0.a(m, "---- requestTime from: " + this.a);
                    try {
                        o.c(rs0.this.f(this.a));
                        o.a();
                    } catch (IOException e) {
                        o.b(e);
                    }
                }
            }

            /* renamed from: a */
            public km<long[]> apply(String singleIpHostAddress) {
                return km.d(new b(singleIpHostAddress), io.reactivex.a.BUFFER).A(gj0.a()).f(new C0059a()).w((long) rs0.this.f4940c);
            }

            /* renamed from: rs0$d$a$a  reason: collision with other inner class name */
            class C0059a implements ic<Throwable> {
                C0059a() {
                }

                /* renamed from: a */
                public void accept(Throwable throwable) {
                    ps0.b(rs0.c, "---- Error requesting time", throwable);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public mo<String, km<long[]>> p(int repeatCount) {
        return new d(repeatCount);
    }

    /* renamed from: rs0$e */
    class e implements mo<List<long[]>, long[]> {
        e() {
        }

        /* renamed from: rs0$e$a */
        class a implements Comparator<long[]> {
            a() {
            }

            /* renamed from: a */
            public int compare(long[] lhsParam, long[] rhsLongParam) {
                long lhs = im0.f(lhsParam);
                long rhs = im0.f(rhsLongParam);
                if (lhs < rhs) {
                    return -1;
                }
                return lhs == rhs ? 0 : 1;
            }
        }

        /* renamed from: a */
        public long[] apply(List<long[]> responseTimeList) {
            Collections.sort(responseTimeList, new a());
            String m = rs0.c;
            ps0.a(m, "---- filterLeastRoundTrip: " + responseTimeList);
            return responseTimeList.get(0);
        }
    }

    /* access modifiers changed from: private */
    public mo<List<long[]>, long[]> r() {
        return new e();
    }

    /* renamed from: rs0$f */
    class f implements mo<List<long[]>, long[]> {
        f() {
        }

        /* renamed from: rs0$f$a */
        class a implements Comparator<long[]> {
            a() {
            }

            /* renamed from: a */
            public int compare(long[] lhsParam, long[] rhsParam) {
                long lhs = im0.e(lhsParam);
                long rhs = im0.e(rhsParam);
                if (lhs < rhs) {
                    return -1;
                }
                return lhs == rhs ? 0 : 1;
            }
        }

        /* renamed from: a */
        public long[] apply(List<long[]> bestResponses) {
            Collections.sort(bestResponses, new a());
            String m = rs0.c;
            ps0.a(m, "---- bestResponse: " + Arrays.toString(bestResponses.get(bestResponses.size() / 2)));
            return bestResponses.get(bestResponses.size() / 2);
        }
    }

    /* access modifiers changed from: private */
    public mo<List<long[]>, long[]> s() {
        return new f();
    }
}
