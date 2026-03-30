package defpackage;

/* renamed from: we  reason: default package */
public final class we {
    private final String a;

    /* renamed from: a  reason: collision with other field name */
    private final ve f5482a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f5483a;
    private final String b;

    public we(ve databaseId, String persistenceKey, String host, boolean sslEnabled) {
        this.f5482a = databaseId;
        this.a = persistenceKey;
        this.b = host;
        this.f5483a = sslEnabled;
    }

    public ve a() {
        return this.f5482a;
    }

    public String c() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public boolean d() {
        return this.f5483a;
    }

    public String toString() {
        return "DatabaseInfo(databaseId:" + this.f5482a + " host:" + this.b + ")";
    }
}
