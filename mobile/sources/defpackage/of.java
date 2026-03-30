package defpackage;

/* renamed from: of  reason: default package */
final /* synthetic */ class of implements Runnable {
    private final aj a;

    /* renamed from: a  reason: collision with other field name */
    private final es0 f4530a;

    /* renamed from: a  reason: collision with other field name */
    private final os0 f4531a;

    /* renamed from: a  reason: collision with other field name */
    private final rf f4532a;

    private of(rf rfVar, es0 es0, os0 os0, aj ajVar) {
        this.f4532a = rfVar;
        this.f4530a = es0;
        this.f4531a = os0;
        this.a = ajVar;
    }

    public static Runnable a(rf rfVar, es0 es0, os0 os0, aj ajVar) {
        return new of(rfVar, es0, os0, ajVar);
    }

    public void run() {
        rf.c(this.f4532a, this.f4530a, this.f4531a, this.a);
    }
}
