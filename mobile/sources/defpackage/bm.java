package defpackage;

import android.content.Context;
import android.text.TextUtils;

/* renamed from: bm  reason: default package */
public final class bm {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;

    private bm(String applicationId, String apiKey, String databaseUrl, String gaTrackingId, String gcmSenderId, String storageBucket, String projectId) {
        y90.m(!tn0.b(applicationId), "ApplicationId must be set.");
        this.b = applicationId;
        this.a = apiKey;
        this.c = databaseUrl;
        this.d = gaTrackingId;
        this.e = gcmSenderId;
        this.f = storageBucket;
        this.g = projectId;
    }

    public static bm a(Context context) {
        pn0 reader = new pn0(context);
        String applicationId = reader.a("google_app_id");
        if (TextUtils.isEmpty(applicationId)) {
            return null;
        }
        return new bm(applicationId, reader.a("google_api_key"), reader.a("firebase_database_url"), reader.a("ga_trackingId"), reader.a("gcm_defaultSenderId"), reader.a("google_storage_bucket"), reader.a("project_id"));
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return this.g;
    }

    public boolean equals(Object o) {
        if (!(o instanceof bm)) {
            return false;
        }
        bm other = (bm) o;
        if (!e40.a(this.b, other.b) || !e40.a(this.a, other.a) || !e40.a(this.c, other.c) || !e40.a(this.d, other.d) || !e40.a(this.e, other.e) || !e40.a(this.f, other.f) || !e40.a(this.g, other.g)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return e40.b(this.b, this.a, this.c, this.d, this.e, this.f, this.g);
    }

    public String toString() {
        return e40.c(this).a("applicationId", this.b).a("apiKey", this.a).a("databaseUrl", this.c).a("gcmSenderId", this.e).a("storageBucket", this.f).a("projectId", this.g).toString();
    }
}
