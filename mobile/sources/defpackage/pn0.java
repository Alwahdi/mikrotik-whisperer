package defpackage;

import android.content.Context;
import android.content.res.Resources;

/* renamed from: pn0  reason: default package */
public class pn0 {
    private final Resources a;

    /* renamed from: a  reason: collision with other field name */
    private final String f4722a;

    public pn0(Context context) {
        y90.j(context);
        Resources resources = context.getResources();
        this.a = resources;
        this.f4722a = resources.getResourcePackageName(rc0.common_google_play_services_unknown_issue);
    }

    public String a(String str) {
        int identifier = this.a.getIdentifier(str, "string", this.f4722a);
        if (identifier == 0) {
            return null;
        }
        return this.a.getString(identifier);
    }
}
