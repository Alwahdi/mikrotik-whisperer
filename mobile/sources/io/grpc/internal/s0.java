package io.grpc.internal;

import io.grpc.internal.ManagedChannelServiceConfig;
import io.grpc.internal.c1;
import io.grpc.m;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class s0 {
    private final c1.z a;

    /* renamed from: a  reason: collision with other field name */
    private final a f3675a;

    /* renamed from: a  reason: collision with other field name */
    private final Object f3676a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<String, a> f3677a;
    private final Map<String, a> b;
    private final Map<String, ?> c;

    s0(a defaultMethodConfig, Map<String, a> serviceMethodMap, Map<String, a> serviceMap, c1.z retryThrottling, Object loadBalancingConfig, Map<String, ?> healthCheckingConfig) {
        Map<String, ?> map;
        this.f3675a = defaultMethodConfig;
        this.f3677a = Collections.unmodifiableMap(new HashMap(serviceMethodMap));
        this.b = Collections.unmodifiableMap(new HashMap(serviceMap));
        this.a = retryThrottling;
        this.f3676a = loadBalancingConfig;
        if (healthCheckingConfig != null) {
            map = Collections.unmodifiableMap(new HashMap(healthCheckingConfig));
        } else {
            map = null;
        }
        this.c = map;
    }

    static s0 a() {
        return new s0((a) null, new HashMap(), new HashMap(), (c1.z) null, (Object) null, (Map<String, ?>) null);
    }

    static s0 b(Map<String, ?> serviceConfig, boolean retryEnabled, int maxRetryAttemptsLimit, int maxHedgedAttemptsLimit, Object loadBalancingConfig) {
        List<Map<String, ?>> methodConfigs;
        Iterator<Map<String, ?>> it;
        Map<String, ?> methodConfig;
        boolean z = retryEnabled;
        c1.z retryThrottling = null;
        if (z) {
            retryThrottling = g1.u(serviceConfig);
        }
        Map<String, ManagedChannelServiceConfig.MethodInfo> serviceMethodMap = new HashMap<>();
        Map<String, ManagedChannelServiceConfig.MethodInfo> serviceMap = new HashMap<>();
        Map<String, ?> healthCheckingConfig = g1.b(serviceConfig);
        List<Map<String, ?>> methodConfigs2 = g1.m(serviceConfig);
        if (methodConfigs2 == null) {
            return new s0((a) null, serviceMethodMap, serviceMap, retryThrottling, loadBalancingConfig, healthCheckingConfig);
        }
        Iterator<Map<String, ?>> it2 = methodConfigs2.iterator();
        a defaultMethodConfig = null;
        while (it2.hasNext()) {
            Map<String, ?> methodConfig2 = it2.next();
            a info = new a(methodConfig2, z, maxRetryAttemptsLimit, maxHedgedAttemptsLimit);
            List<Map<String, ?>> nameList = g1.o(methodConfig2);
            if (nameList == null) {
                Map<String, ?> map = methodConfig2;
            } else if (!nameList.isEmpty()) {
                for (Map<String, ?> name : nameList) {
                    String serviceName = g1.s(name);
                    String methodName = g1.n(name);
                    if (sn0.a(serviceName)) {
                        methodConfig = methodConfig2;
                        it = it2;
                        v90.j(sn0.a(methodName), "missing service name for method %s", methodName);
                        methodConfigs = methodConfigs2;
                        v90.j(defaultMethodConfig == null, "Duplicate default method config in service config %s", serviceConfig);
                        defaultMethodConfig = info;
                    } else {
                        methodConfig = methodConfig2;
                        it = it2;
                        methodConfigs = methodConfigs2;
                        Map<String, ?> map2 = serviceConfig;
                        if (sn0.a(methodName)) {
                            v90.j(!serviceMap.containsKey(serviceName), "Duplicate service %s", serviceName);
                            serviceMap.put(serviceName, info);
                        } else {
                            String fullMethodName = m.b(serviceName, methodName);
                            String str = methodName;
                            v90.j(!serviceMethodMap.containsKey(fullMethodName), "Duplicate method name %s", fullMethodName);
                            serviceMethodMap.put(fullMethodName, info);
                        }
                    }
                    boolean z2 = retryEnabled;
                    methodConfig2 = methodConfig;
                    it2 = it;
                    methodConfigs2 = methodConfigs;
                }
                Iterator<Map<String, ?>> it3 = it2;
                List<Map<String, ?>> methodConfigs3 = methodConfigs2;
                Map<String, ?> map3 = serviceConfig;
                z = retryEnabled;
                methodConfigs2 = methodConfigs3;
            }
            List<Map<String, ?>> methodConfigs4 = methodConfigs2;
            Map<String, ?> map4 = serviceConfig;
            z = retryEnabled;
            it2 = it2;
            methodConfigs2 = methodConfigs4;
        }
        return new s0(defaultMethodConfig, serviceMethodMap, serviceMap, retryThrottling, loadBalancingConfig, healthCheckingConfig);
    }

    /* access modifiers changed from: package-private */
    public Map<String, a> g() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public Map<String, ?> d() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public Map<String, a> h() {
        return this.f3677a;
    }

    /* access modifiers changed from: package-private */
    public a c() {
        return this.f3675a;
    }

    /* access modifiers changed from: package-private */
    public Object e() {
        return this.f3676a;
    }

    /* access modifiers changed from: package-private */
    public c1.z f() {
        return this.a;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        s0 that = (s0) o;
        if (!f40.a(this.f3677a, that.f3677a) || !f40.a(this.b, that.b) || !f40.a(this.a, that.a) || !f40.a(this.f3676a, that.f3676a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return f40.b(this.f3677a, this.b, this.a, this.f3676a);
    }

    public String toString() {
        return f20.c(this).d("serviceMethodMap", this.f3677a).d("serviceMap", this.b).d("retryThrottling", this.a).d("loadBalancingConfig", this.f3676a).toString();
    }

    static final class a {
        final d1 a;

        /* renamed from: a  reason: collision with other field name */
        final j0 f3678a;

        /* renamed from: a  reason: collision with other field name */
        final Boolean f3679a;

        /* renamed from: a  reason: collision with other field name */
        final Integer f3680a;

        /* renamed from: a  reason: collision with other field name */
        final Long f3681a;
        final Integer b;

        a(Map<String, ?> methodConfig, boolean retryEnabled, int maxRetryAttemptsLimit, int maxHedgedAttemptsLimit) {
            this.f3681a = g1.v(methodConfig);
            this.f3679a = g1.w(methodConfig);
            Integer l = g1.l(methodConfig);
            this.f3680a = l;
            boolean z = true;
            if (l != null) {
                v90.j(l.intValue() >= 0, "maxInboundMessageSize %s exceeds bounds", l);
            }
            Integer k = g1.k(methodConfig);
            this.b = k;
            if (k != null) {
                v90.j(k.intValue() < 0 ? false : z, "maxOutboundMessageSize %s exceeds bounds", k);
            }
            Map<String, ?> hedgingPolicyMap = null;
            Map<String, ?> retryPolicyMap = retryEnabled ? g1.q(methodConfig) : null;
            this.a = retryPolicyMap == null ? d1.a : b(retryPolicyMap, maxRetryAttemptsLimit);
            hedgingPolicyMap = retryEnabled ? g1.d(methodConfig) : hedgingPolicyMap;
            this.f3678a = hedgingPolicyMap == null ? j0.a : a(hedgingPolicyMap, maxHedgedAttemptsLimit);
        }

        public int hashCode() {
            return f40.b(this.f3681a, this.f3679a, this.f3680a, this.b, this.a, this.f3678a);
        }

        public boolean equals(Object other) {
            if (!(other instanceof a)) {
                return false;
            }
            a that = (a) other;
            if (!f40.a(this.f3681a, that.f3681a) || !f40.a(this.f3679a, that.f3679a) || !f40.a(this.f3680a, that.f3680a) || !f40.a(this.b, that.b) || !f40.a(this.a, that.a) || !f40.a(this.f3678a, that.f3678a)) {
                return false;
            }
            return true;
        }

        public String toString() {
            return f20.c(this).d("timeoutNanos", this.f3681a).d("waitForReady", this.f3679a).d("maxInboundMessageSize", this.f3680a).d("maxOutboundMessageSize", this.b).d("retryPolicy", this.a).d("hedgingPolicy", this.f3678a).toString();
        }

        private static d1 b(Map<String, ?> retryPolicy, int maxAttemptsLimit) {
            int maxAttempts = ((Integer) v90.o(g1.i(retryPolicy), "maxAttempts cannot be empty")).intValue();
            boolean z = true;
            v90.h(maxAttempts >= 2, "maxAttempts must be greater than 1: %s", maxAttempts);
            int maxAttempts2 = Math.min(maxAttempts, maxAttemptsLimit);
            long initialBackoffNanos = ((Long) v90.o(g1.e(retryPolicy), "initialBackoff cannot be empty")).longValue();
            v90.i(initialBackoffNanos > 0, "initialBackoffNanos must be greater than 0: %s", initialBackoffNanos);
            long maxBackoffNanos = ((Long) v90.o(g1.j(retryPolicy), "maxBackoff cannot be empty")).longValue();
            v90.i(maxBackoffNanos > 0, "maxBackoff must be greater than 0: %s", maxBackoffNanos);
            double backoffMultiplier = ((Double) v90.o(g1.a(retryPolicy), "backoffMultiplier cannot be empty")).doubleValue();
            if (backoffMultiplier <= 0.0d) {
                z = false;
            }
            v90.j(z, "backoffMultiplier must be greater than 0: %s", Double.valueOf(backoffMultiplier));
            long j = maxBackoffNanos;
            return new d1(maxAttempts2, initialBackoffNanos, maxBackoffNanos, backoffMultiplier, g1.r(retryPolicy));
        }

        private static j0 a(Map<String, ?> hedgingPolicy, int maxAttemptsLimit) {
            int maxAttempts = ((Integer) v90.o(g1.h(hedgingPolicy), "maxAttempts cannot be empty")).intValue();
            boolean z = true;
            v90.h(maxAttempts >= 2, "maxAttempts must be greater than 1: %s", maxAttempts);
            int maxAttempts2 = Math.min(maxAttempts, maxAttemptsLimit);
            long hedgingDelayNanos = ((Long) v90.o(g1.c(hedgingPolicy), "hedgingDelay cannot be empty")).longValue();
            if (hedgingDelayNanos < 0) {
                z = false;
            }
            v90.i(z, "hedgingDelay must not be negative: %s", hedgingDelayNanos);
            return new j0(maxAttempts2, hedgingDelayNanos, g1.p(hedgingPolicy));
        }
    }
}
