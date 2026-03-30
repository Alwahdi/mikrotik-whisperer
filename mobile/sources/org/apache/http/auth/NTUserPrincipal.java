package org.apache.http.auth;

import java.io.Serializable;
import java.security.Principal;
import java.util.Locale;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.LangUtils;

@Immutable
public class NTUserPrincipal implements Principal, Serializable {
    private static final long serialVersionUID = -6870169797924406894L;
    private final String domain;
    private final String ntname;
    private final String username;

    public NTUserPrincipal(String domain2, String username2) {
        if (username2 != null) {
            this.username = username2;
            if (domain2 != null) {
                this.domain = domain2.toUpperCase(Locale.ENGLISH);
            } else {
                this.domain = null;
            }
            String str = this.domain;
            if (str == null || str.length() <= 0) {
                this.ntname = username2;
                return;
            }
            this.ntname = this.domain + '/' + username2;
            return;
        }
        throw new IllegalArgumentException("User name may not be null");
    }

    public String getName() {
        return this.ntname;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(17, (Object) this.username), (Object) this.domain);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NTUserPrincipal)) {
            return false;
        }
        NTUserPrincipal that = (NTUserPrincipal) o;
        if (!LangUtils.equals((Object) this.username, (Object) that.username) || !LangUtils.equals((Object) this.domain, (Object) that.domain)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return this.ntname;
    }
}
