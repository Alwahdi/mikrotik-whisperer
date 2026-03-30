package defpackage;

import android.net.Uri;
import java.util.Set;

/* renamed from: l61  reason: default package */
public final class l61 {
    private static final d21<String, Integer> a = new b21().a("recoverEmail", 2).a("resetPassword", 0).a("signIn", 4).a("verifyEmail", 1).a("verifyBeforeChangeEmail", 5).a("revertSecondFactorAddition", 6).b();

    /* renamed from: a  reason: collision with other field name */
    private final String f4242a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;

    private l61(String str) {
        String a2 = a(str, "apiKey");
        this.f4242a = a2;
        String a3 = a(str, "oobCode");
        this.b = a3;
        String a4 = a(str, "mode");
        this.c = a4;
        if (a2 == null || a3 == null || a4 == null) {
            throw new IllegalArgumentException(String.format("%s, %s and %s are required in a valid action code URL", new Object[]{"apiKey", "oobCode", "mode"}));
        }
        this.d = a(str, "continueUrl");
        this.e = a(str, "languageCode");
        this.f = a(str, "tenantId");
    }

    public static l61 b(String str) {
        y90.f(str);
        try {
            return new l61(str);
        } catch (IllegalArgumentException e2) {
            return null;
        }
    }

    public final String c() {
        return this.f;
    }

    private static String a(String str, String str2) {
        Uri parse = Uri.parse(str);
        try {
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames.contains(str2)) {
                return parse.getQueryParameter(str2);
            }
            if (queryParameterNames.contains("link")) {
                return Uri.parse(parse.getQueryParameter("link")).getQueryParameter(str2);
            }
            return null;
        } catch (UnsupportedOperationException e2) {
            return null;
        }
    }
}
