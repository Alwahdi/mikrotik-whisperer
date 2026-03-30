package com.google.android.datatransport.cct;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.http.protocol.HTTP;

public final class a implements ni {
    public static final a a;

    /* renamed from: a  reason: collision with other field name */
    private static final Set<qi> f1333a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new qi[]{qi.b("proto"), qi.b("json")})));
    public static final a b;
    static final String c;
    static final String d;
    private static final String e;

    /* renamed from: a  reason: collision with other field name */
    private final String f1334a;

    /* renamed from: b  reason: collision with other field name */
    private final String f1335b;

    static {
        String a2 = e.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        c = a2;
        String a3 = e.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        d = a3;
        String a4 = e.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        e = a4;
        a = new a(a2, (String) null);
        b = new a(a3, a4);
    }

    public a(String str, String str2) {
        this.f1334a = str;
        this.f1335b = str2;
    }

    public static a d(byte[] bArr) {
        String str = new String(bArr, Charset.forName(HTTP.UTF_8));
        if (str.startsWith("1$")) {
            String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
            if (split.length == 2) {
                String str2 = split[0];
                if (!str2.isEmpty()) {
                    String str3 = split[1];
                    if (str3.isEmpty()) {
                        str3 = null;
                    }
                    return new a(str2, str3);
                }
                throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
            }
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        throw new IllegalArgumentException("Version marker missing from extras");
    }

    public byte[] a() {
        return c();
    }

    public Set<qi> b() {
        return f1333a;
    }

    public byte[] c() {
        String str = this.f1335b;
        if (str == null && this.f1334a == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "1$";
        objArr[1] = this.f1334a;
        objArr[2] = "\\";
        if (str == null) {
            str = "";
        }
        objArr[3] = str;
        return String.format("%s%s%s%s", objArr).getBytes(Charset.forName(HTTP.UTF_8));
    }

    public String e() {
        return this.f1335b;
    }

    public String f() {
        return this.f1334a;
    }

    public String getName() {
        return "cct";
    }
}
