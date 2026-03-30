package com.blogspot.yemeninfo4it.mumsmobile_app.activities;

import com.blogspot.yemeninfo4it.mumsmobile_app.activities.SalesHotsArchevActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Sessions;
import java.util.Date;

public final /* synthetic */ class e implements ha0 {
    public final /* synthetic */ SalesHotsArchevActivity.e a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Date f1269a;
    public final /* synthetic */ Date b;

    public /* synthetic */ e(SalesHotsArchevActivity.e eVar, Date date, Date date2) {
        this.a = eVar;
        this.f1269a = date;
        this.b = date2;
    }

    public final boolean test(Object obj) {
        return this.a.c(this.f1269a, this.b, (Sessions) obj);
    }
}
