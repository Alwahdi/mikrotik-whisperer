package defpackage;

import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.InputDeviceCompat;

/* renamed from: fp0  reason: default package */
public class fp0 {
    int a;

    /* renamed from: a  reason: collision with other field name */
    byte[] f2985a = null;

    /* renamed from: a  reason: collision with other field name */
    int[] f2986a = {FrameMetricsAggregator.EVERY_DURATION, 1023, 2047, 4095};

    /* renamed from: a  reason: collision with other field name */
    byte[][] f2987a;
    int b = 9;

    /* renamed from: b  reason: collision with other field name */
    byte[] f2988b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    int i;
    int j = 0;
    int k = 0;

    public fp0(int w, int predictor, int samplesPerPixel) {
        this.f = w;
        this.h = predictor;
        this.i = samplesPerPixel;
    }

    public byte[] d(byte[] data, byte[] uncompData, int h2) {
        if (data[0] == 0 && data[1] == 1) {
            throw new UnsupportedOperationException(i10.b("tiff.5.0.style.lzw.codes.are.not.supported", new Object[0]));
        }
        f();
        this.f2985a = data;
        this.g = h2;
        this.f2988b = uncompData;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.j = 0;
        this.k = 0;
        int oldCode = 0;
        while (true) {
            int e2 = e();
            int code = e2;
            if (e2 == 257 || this.e >= uncompData.length) {
                break;
            } else if (code == 256) {
                f();
                int code2 = e();
                if (code2 == 257) {
                    break;
                }
                g(this.f2987a[code2]);
                oldCode = code2;
            } else if (code < this.a) {
                byte[] string = this.f2987a[code];
                g(string);
                b(this.f2987a[oldCode], string[0]);
                oldCode = code;
            } else {
                byte[] string2 = this.f2987a[oldCode];
                byte[] string3 = c(string2, string2[0]);
                g(string3);
                a(string3);
                oldCode = code;
            }
        }
        if (this.h == 2) {
            for (int j2 = 0; j2 < h2; j2++) {
                int count = this.i * ((this.f * j2) + 1);
                int i2 = this.i;
                while (true) {
                    int i3 = this.f;
                    int i4 = this.i;
                    if (i2 >= i3 * i4) {
                        break;
                    }
                    uncompData[count] = (byte) (uncompData[count] + uncompData[count - i4]);
                    count++;
                    i2++;
                }
            }
        }
        return uncompData;
    }

    public void f() {
        this.f2987a = new byte[4096][];
        for (int i2 = 0; i2 < 256; i2++) {
            byte[][] bArr = this.f2987a;
            bArr[i2] = new byte[1];
            bArr[i2][0] = (byte) i2;
        }
        this.a = 258;
        this.b = 9;
    }

    public void g(byte[] string) {
        byte[] bArr = this.f2988b;
        int length = bArr.length;
        int i2 = this.e;
        int max = length - i2;
        if (string.length < max) {
            max = string.length;
        }
        System.arraycopy(string, 0, bArr, i2, max);
        this.e += max;
    }

    public void b(byte[] oldString, byte newString) {
        int length = oldString.length;
        byte[] string = new byte[(length + 1)];
        System.arraycopy(oldString, 0, string, 0, length);
        string[length] = newString;
        byte[][] bArr = this.f2987a;
        int i2 = this.a;
        int i3 = i2 + 1;
        this.a = i3;
        bArr[i2] = string;
        if (i3 == 511) {
            this.b = 10;
        } else if (i3 == 1023) {
            this.b = 11;
        } else if (i3 == 2047) {
            this.b = 12;
        }
    }

    public void a(byte[] string) {
        byte[][] bArr = this.f2987a;
        int i2 = this.a;
        int i3 = i2 + 1;
        this.a = i3;
        bArr[i2] = string;
        if (i3 == 511) {
            this.b = 10;
        } else if (i3 == 1023) {
            this.b = 11;
        } else if (i3 == 2047) {
            this.b = 12;
        }
    }

    public byte[] c(byte[] oldString, byte newString) {
        int length = oldString.length;
        byte[] string = new byte[(length + 1)];
        System.arraycopy(oldString, 0, string, 0, length);
        string[length] = newString;
        return string;
    }

    public int e() {
        try {
            byte[] bArr = this.f2985a;
            int i2 = this.c;
            int i3 = i2 + 1;
            this.c = i3;
            byte b2 = (this.j << 8) | (bArr[i2] & 255);
            this.j = b2;
            int i4 = this.k + 8;
            this.k = i4;
            int i5 = this.b;
            if (i4 < i5) {
                this.c = i3 + 1;
                this.j = (b2 << 8) | (bArr[i3] & 255);
                this.k = i4 + 8;
            }
            int i6 = this.j;
            int i7 = this.k;
            int code = (i6 >> (i7 - i5)) & this.f2986a[i5 - 9];
            this.k = i7 - i5;
            return code;
        } catch (ArrayIndexOutOfBoundsException e2) {
            return InputDeviceCompat.SOURCE_KEYBOARD;
        }
    }
}
