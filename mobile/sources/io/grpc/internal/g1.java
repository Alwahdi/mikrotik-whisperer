package io.grpc.internal;

import androidx.core.app.NotificationCompat;
import defpackage.b30;
import io.grpc.Status;
import io.grpc.internal.ServiceConfigUtil;
import io.grpc.internal.c1;
import io.grpc.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class g1 {
    public static Map<String, ?> b(Map<String, ?> serviceConfig) {
        if (serviceConfig == null) {
            return null;
        }
        return vv.j(serviceConfig, "healthCheckConfig");
    }

    static c1.z u(Map<String, ?> serviceConfig) {
        Map<String, ?> throttling;
        if (serviceConfig == null || (throttling = vv.j(serviceConfig, "retryThrottling")) == null) {
            return null;
        }
        float maxTokens = vv.h(throttling, "maxTokens").floatValue();
        float tokenRatio = vv.h(throttling, "tokenRatio").floatValue();
        boolean z = true;
        v90.u(maxTokens > 0.0f, "maxToken should be greater than zero");
        if (tokenRatio <= 0.0f) {
            z = false;
        }
        v90.u(z, "tokenRatio should be greater than zero");
        return new c1.z(maxTokens, tokenRatio);
    }

    static Integer i(Map<String, ?> retryPolicy) {
        return vv.i(retryPolicy, "maxAttempts");
    }

    static Long e(Map<String, ?> retryPolicy) {
        return vv.l(retryPolicy, "initialBackoff");
    }

    static Long j(Map<String, ?> retryPolicy) {
        return vv.l(retryPolicy, "maxBackoff");
    }

    static Double a(Map<String, ?> retryPolicy) {
        return vv.h(retryPolicy, "backoffMultiplier");
    }

    private static Set<p.b> f(Map<String, ?> obj, String key) {
        List<?> statuses = vv.e(obj, key);
        if (statuses == null) {
            return null;
        }
        return t(statuses);
    }

    private static Set<p.b> t(List<?> statuses) {
        p.b code;
        EnumSet<Status.Code> codes = EnumSet.noneOf(p.b.class);
        for (Object next : statuses) {
            if (next instanceof Double) {
                Double statusD = (Double) next;
                int codeValue = statusD.intValue();
                boolean z = true;
                xu0.a(((double) codeValue) == statusD.doubleValue(), "Status code %s is not integral", next);
                code = p.h(codeValue).m();
                if (code.value() != statusD.intValue()) {
                    z = false;
                }
                xu0.a(z, "Status code %s is not valid", next);
            } else if (next instanceof String) {
                try {
                    code = p.b.valueOf((String) next);
                } catch (IllegalArgumentException iae) {
                    throw new yu0("Status code " + next + " is not valid", iae);
                }
            } else {
                throw new yu0("Can not convert status code " + next + " to Status.Code, because its type is " + next.getClass());
            }
            codes.add(code);
        }
        return Collections.unmodifiableSet(codes);
    }

    static Set<p.b> r(Map<String, ?> retryPolicy) {
        Set<p.b> f = f(retryPolicy, "retryableStatusCodes");
        xu0.a(f != null, "%s is required in retry policy", "retryableStatusCodes");
        xu0.a(!f.isEmpty(), "%s must not be empty", "retryableStatusCodes");
        xu0.a(true ^ f.contains(p.b.OK), "%s must not contain OK", "retryableStatusCodes");
        return f;
    }

    static Integer h(Map<String, ?> hedgingPolicy) {
        return vv.i(hedgingPolicy, "maxAttempts");
    }

    static Long c(Map<String, ?> hedgingPolicy) {
        return vv.l(hedgingPolicy, "hedgingDelay");
    }

    static Set<p.b> p(Map<String, ?> hedgingPolicy) {
        Set<p.b> f = f(hedgingPolicy, "nonFatalStatusCodes");
        if (f == null) {
            return Collections.unmodifiableSet(EnumSet.noneOf(p.b.class));
        }
        xu0.a(!f.contains(p.b.OK), "%s must not contain OK", "nonFatalStatusCodes");
        return f;
    }

    static String s(Map<String, ?> name) {
        return vv.k(name, NotificationCompat.CATEGORY_SERVICE);
    }

    static String n(Map<String, ?> name) {
        return vv.k(name, "method");
    }

    static Map<String, ?> q(Map<String, ?> methodConfig) {
        return vv.j(methodConfig, "retryPolicy");
    }

    static Map<String, ?> d(Map<String, ?> methodConfig) {
        return vv.j(methodConfig, "hedgingPolicy");
    }

    static List<Map<String, ?>> o(Map<String, ?> methodConfig) {
        return vv.f(methodConfig, "name");
    }

    static Long v(Map<String, ?> methodConfig) {
        return vv.l(methodConfig, "timeout");
    }

    static Boolean w(Map<String, ?> methodConfig) {
        return vv.d(methodConfig, "waitForReady");
    }

    static Integer k(Map<String, ?> methodConfig) {
        return vv.i(methodConfig, "maxRequestMessageBytes");
    }

    static Integer l(Map<String, ?> methodConfig) {
        return vv.i(methodConfig, "maxResponseMessageBytes");
    }

    static List<Map<String, ?>> m(Map<String, ?> serviceConfig) {
        return vv.f(serviceConfig, "methodConfig");
    }

    public static List<Map<String, ?>> g(Map<String, ?> serviceConfig) {
        String policy;
        List<Map<String, ?>> lbConfigs = new ArrayList<>();
        if (serviceConfig.containsKey("loadBalancingConfig")) {
            lbConfigs.addAll(vv.f(serviceConfig, "loadBalancingConfig"));
        }
        if (lbConfigs.isEmpty() && (policy = vv.k(serviceConfig, "loadBalancingPolicy")) != null) {
            lbConfigs.add(Collections.singletonMap(policy.toLowerCase(Locale.ROOT), Collections.emptyMap()));
        }
        return Collections.unmodifiableList(lbConfigs);
    }

    public static a y(Map<String, ?> lbConfig) {
        if (lbConfig.size() == 1) {
            String key = (String) lbConfig.entrySet().iterator().next().getKey();
            return new a(key, vv.j(lbConfig, key));
        }
        throw new RuntimeException("There are " + lbConfig.size() + " fields in a LoadBalancingConfig object. Exactly one is expected. Config=" + lbConfig);
    }

    public static List<a> z(List<Map<String, ?>> list) {
        if (list == null) {
            return null;
        }
        ArrayList<ServiceConfigUtil.LbConfig> result = new ArrayList<>();
        for (Map<String, ?> rawChildPolicy : list) {
            result.add(y(rawChildPolicy));
        }
        return Collections.unmodifiableList(result);
    }

    public static b30.b x(List<a> lbConfigs, wx lbRegistry) {
        List<String> policiesTried = new ArrayList<>();
        for (a lbConfig : lbConfigs) {
            String policy = lbConfig.b();
            vx provider = lbRegistry.d(policy);
            if (provider == null) {
                policiesTried.add(policy);
            } else {
                if (!policiesTried.isEmpty()) {
                    Logger.getLogger(g1.class.getName()).log(Level.FINEST, "{0} specified by Service Config are not available", policiesTried);
                }
                b30.b parsedLbPolicyConfig = provider.e(lbConfig.c());
                if (parsedLbPolicyConfig.d() != null) {
                    return parsedLbPolicyConfig;
                }
                return b30.b.a(new b(provider, lbConfig.f3416a, parsedLbPolicyConfig.c()));
            }
        }
        p pVar = p.c;
        return b30.b.b(pVar.q("None of " + policiesTried + " specified by Service Config are available."));
    }

    public static final class a {
        private final String a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public final Map<String, ?> f3416a;

        public a(String policyName, Map<String, ?> rawConfigValue) {
            this.a = (String) v90.o(policyName, "policyName");
            this.f3416a = (Map) v90.o(rawConfigValue, "rawConfigValue");
        }

        public String b() {
            return this.a;
        }

        public Map<String, ?> c() {
            return this.f3416a;
        }

        public boolean equals(Object o) {
            if (!(o instanceof a)) {
                return false;
            }
            a other = (a) o;
            if (!this.a.equals(other.a) || !this.f3416a.equals(other.f3416a)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return f40.b(this.a, this.f3416a);
        }

        public String toString() {
            return f20.c(this).d("policyName", this.a).d("rawConfigValue", this.f3416a).toString();
        }
    }

    public static final class b {
        final Object a;

        /* renamed from: a  reason: collision with other field name */
        final Map<String, ?> f3417a;

        /* renamed from: a  reason: collision with other field name */
        final vx f3418a;

        public b(vx provider, Map<String, ?> rawConfig, Object config) {
            this.f3418a = (vx) v90.o(provider, "provider");
            this.f3417a = rawConfig;
            this.a = config;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            b that = (b) o;
            if (!f40.a(this.f3418a, that.f3418a) || !f40.a(this.f3417a, that.f3417a) || !f40.a(this.a, that.a)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return f40.b(this.f3418a, this.f3417a, this.a);
        }

        public String toString() {
            return f20.c(this).d("provider", this.f3418a).d("rawConfig", this.f3417a).d("config", this.a).toString();
        }
    }
}
