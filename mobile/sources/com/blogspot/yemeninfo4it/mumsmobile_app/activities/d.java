package com.blogspot.yemeninfo4it.mumsmobile_app.activities;

import com.blogspot.yemeninfo4it.mumsmobile_app.activities.MumsHomeActivity;
import java.util.Map;

public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ MumsHomeActivity.p.a a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Map f1268a;

    public /* synthetic */ d(MumsHomeActivity.p.a aVar, Map map) {
        this.a = aVar;
        this.f1268a = map;
    }

    public final void run() {
        this.a.e(this.f1268a);
    }
}
