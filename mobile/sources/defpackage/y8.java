package defpackage;

import android.accounts.Account;
import android.view.View;
import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: y8  reason: default package */
public final class y8 {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final Account f5841a;

    /* renamed from: a  reason: collision with other field name */
    private final View f5842a;

    /* renamed from: a  reason: collision with other field name */
    private Integer f5843a;

    /* renamed from: a  reason: collision with other field name */
    private final String f5844a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<i3<?>, Object> f5845a;

    /* renamed from: a  reason: collision with other field name */
    private final Set<Scope> f5846a;

    /* renamed from: a  reason: collision with other field name */
    private final rl0 f5847a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f5848a;
    private final String b;

    /* renamed from: b  reason: collision with other field name */
    private final Set<Scope> f5849b;

    /* renamed from: y8$a */
    public static final class a {
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private Account f5850a;

        /* renamed from: a  reason: collision with other field name */
        private View f5851a;

        /* renamed from: a  reason: collision with other field name */
        private ArraySet<Scope> f5852a;

        /* renamed from: a  reason: collision with other field name */
        private String f5853a;

        /* renamed from: a  reason: collision with other field name */
        private Map<i3<?>, Object> f5854a;

        /* renamed from: a  reason: collision with other field name */
        private rl0 f5855a = rl0.a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f5856a;
        private String b;

        public final a c(Account account) {
            this.f5850a = account;
            return this;
        }

        public final a a(Collection<Scope> collection) {
            if (this.f5852a == null) {
                this.f5852a = new ArraySet<>();
            }
            this.f5852a.addAll(collection);
            return this;
        }

        public final a e(String str) {
            this.f5853a = str;
            return this;
        }

        public final a d(String str) {
            this.b = str;
            return this;
        }

        public final y8 b() {
            return new y8(this.f5850a, this.f5852a, this.f5854a, this.a, this.f5851a, this.f5853a, this.b, this.f5855a, this.f5856a);
        }
    }

    public y8(Account account, Set<Scope> set, Map<i3<?>, Object> map, int i, View view, String str, String str2, rl0 rl0, boolean z) {
        this.f5841a = account;
        Set<Scope> emptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f5846a = emptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.f5845a = map;
        this.f5842a = view;
        this.a = i;
        this.f5844a = str;
        this.b = str2;
        this.f5847a = rl0;
        this.f5848a = z;
        HashSet hashSet = new HashSet(emptySet);
        Iterator<Object> it = map.values().iterator();
        if (!it.hasNext()) {
            this.f5849b = Collections.unmodifiableSet(hashSet);
        } else {
            b6.a(it.next());
            throw null;
        }
    }

    public final Account a() {
        return this.f5841a;
    }

    public final Account b() {
        Account account = this.f5841a;
        if (account != null) {
            return account;
        }
        return new Account("<<default account>>", "com.google");
    }

    public final Set<Scope> g() {
        return this.f5846a;
    }

    public final Set<Scope> c() {
        return this.f5849b;
    }

    public final String f() {
        return this.f5844a;
    }

    public final String e() {
        return this.b;
    }

    public final rl0 h() {
        return this.f5847a;
    }

    public final Integer d() {
        return this.f5843a;
    }

    public final void i(Integer num) {
        this.f5843a = num;
    }
}
