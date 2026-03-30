package com.google.firebase.heartbeatinfo;

import android.content.Context;
import com.google.firebase.heartbeatinfo.c;

public class b implements c {
    private d a;

    private b(Context context) {
        this.a = d.a(context);
    }

    public c.a a(String heartBeatTag) {
        long presentTime = System.currentTimeMillis();
        boolean shouldSendSdkHB = this.a.c(heartBeatTag, presentTime);
        boolean shouldSendGlobalHB = this.a.b(presentTime);
        if (shouldSendSdkHB && shouldSendGlobalHB) {
            return c.a.COMBINED;
        }
        if (shouldSendGlobalHB) {
            return c.a.GLOBAL;
        }
        if (shouldSendSdkHB) {
            return c.a.SDK;
        }
        return c.a.NONE;
    }

    public static cb<c> b() {
        return cb.a(c.class).b(cg.g(Context.class)).f(a.b()).d();
    }

    static /* synthetic */ c c(hb c) {
        return new b((Context) c.d(Context.class));
    }
}
