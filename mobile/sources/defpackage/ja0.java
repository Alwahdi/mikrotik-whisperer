package defpackage;

import com.evrencoskun.tableview.TableView;

/* renamed from: ja0  reason: default package */
public class ja0 {
    private TableView a;

    /* renamed from: a  reason: collision with other field name */
    private rj0 f4047a;

    /* renamed from: a  reason: collision with other field name */
    private yj0 f4048a;

    public ja0(TableView tableView) {
        this.a = tableView;
        this.f4047a = tableView.getScrollHandler();
        this.f4048a = tableView.getSelectionHandler();
    }

    public ia0 b() {
        ia0 preferences = new ia0();
        preferences.c = this.f4047a.a();
        preferences.d = this.f4047a.b();
        preferences.a = this.f4047a.c();
        preferences.b = this.f4047a.d();
        preferences.f = this.f4048a.i();
        preferences.e = this.f4048a.j();
        return preferences;
    }

    public void a(ia0 preferences) {
        this.f4047a.h(preferences.c, preferences.d);
        this.f4047a.j(preferences.a, preferences.b);
        this.f4048a.w(preferences.f);
        this.f4048a.y(preferences.e);
    }
}
