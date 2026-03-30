package defpackage;

import androidx.profileinstaller.DeviceProfileWriter;

/* renamed from: ig  reason: default package */
public final /* synthetic */ class ig implements Runnable {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ DeviceProfileWriter f3238a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f3239a;

    public /* synthetic */ ig(DeviceProfileWriter deviceProfileWriter, int i, Object obj) {
        this.f3238a = deviceProfileWriter;
        this.a = i;
        this.f3239a = obj;
    }

    public final void run() {
        this.f3238a.lambda$result$0(this.a, this.f3239a);
    }
}
