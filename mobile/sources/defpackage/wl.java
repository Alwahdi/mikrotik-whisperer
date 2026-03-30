package defpackage;

/* renamed from: wl  reason: default package */
public class wl extends Exception {
    public wl(String str) {
        super(y90.g(str, "Detail message must not be empty"));
    }

    public wl(String str, Throwable th) {
        super(y90.g(str, "Detail message must not be empty"), th);
    }
}
