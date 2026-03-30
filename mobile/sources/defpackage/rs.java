package defpackage;

import androidx.core.internal.view.SupportMenu;
import java.io.InputStream;

/* renamed from: rs  reason: default package */
public class rs {
    int a;

    /* renamed from: a  reason: collision with other field name */
    InputStream f4939a;

    public rs(InputStream in) {
        this.f4939a = in;
    }

    public int f() {
        this.a += 2;
        int k1 = this.f4939a.read();
        if (k1 < 0) {
            return 0;
        }
        return ((this.f4939a.read() << 8) + k1) & SupportMenu.USER_MASK;
    }

    public int e() {
        int k = f();
        if (k > 32767) {
            return k - 65536;
        }
        return k;
    }

    public int d() {
        this.a += 4;
        int k1 = this.f4939a.read();
        if (k1 < 0) {
            return 0;
        }
        return k1 + (this.f4939a.read() << 8) + (this.f4939a.read() << 16) + (this.f4939a.read() << 24);
    }

    public int b() {
        this.a++;
        return this.f4939a.read() & 255;
    }

    public void g(int len) {
        this.a += len;
        tu0.j(this.f4939a, len);
    }

    public int a() {
        return this.a;
    }

    public w5 c() {
        int red = b();
        int green = b();
        int blue = b();
        b();
        return new w5(red, green, blue);
    }
}
