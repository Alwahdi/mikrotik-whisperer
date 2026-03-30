package defpackage;

import androidx.core.internal.view.SupportMenu;
import androidx.core.view.MotionEventCompat;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;

/* renamed from: o6  reason: default package */
public class o6 {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private long f4483a;

    /* renamed from: a  reason: collision with other field name */
    private InputStream f4484a;

    /* renamed from: a  reason: collision with other field name */
    public HashMap<String, Object> f4485a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private boolean f4486a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f4487a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private long f4488b;
    private int c;

    /* renamed from: c  reason: collision with other field name */
    private long f4489c;
    private int d;

    /* renamed from: d  reason: collision with other field name */
    private long f4490d;
    private int e;

    /* renamed from: e  reason: collision with other field name */
    private long f4491e;
    private int f;

    /* renamed from: f  reason: collision with other field name */
    private long f4492f;
    private int g;
    int h;
    int i;

    o6(InputStream is, boolean noHeader, int size) {
        this.f4483a = (long) size;
        this.f4488b = 0;
        j(is, noHeader);
    }

    public static tr g(URL url) {
        InputStream is = null;
        try {
            is = url.openStream();
            tr img = e(is);
            img.p1(url);
            return img;
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    public static tr e(InputStream is) {
        return f(is, false, 0);
    }

    public static tr f(InputStream is, boolean noHeader, int size) {
        o6 bmp = new o6(is, noHeader, size);
        try {
            tr img = bmp.d();
            img.f1((int) ((((double) bmp.f4491e) * 0.0254d) + 0.5d), (int) ((((double) bmp.f4492f) * 0.0254d) + 0.5d));
            img.k1(4);
            return img;
        } catch (n5 be) {
            throw new mj(be);
        }
    }

    /* access modifiers changed from: protected */
    public void j(InputStream stream, boolean noHeader) {
        int i2;
        int redZ;
        int redX;
        InputStream inputStream = stream;
        if (noHeader || (inputStream instanceof BufferedInputStream)) {
            this.f4484a = inputStream;
        } else {
            this.f4484a = new BufferedInputStream(inputStream);
        }
        if (!noHeader) {
            if (v(this.f4484a) == 66 && v(this.f4484a) == 77) {
                this.f4483a = p(this.f4484a);
                y(this.f4484a);
                y(this.f4484a);
                this.f4488b = p(this.f4484a);
            } else {
                throw new RuntimeException(i10.b("invalid.magic.value.for.bmp.file", new Object[0]));
            }
        }
        long size = p(this.f4484a);
        if (size == 12) {
            this.h = y(this.f4484a);
            this.i = y(this.f4484a);
        } else {
            this.h = r(this.f4484a);
            this.i = r(this.f4484a);
        }
        int planes = y(this.f4484a);
        this.c = y(this.f4484a);
        this.f4485a.put("color_planes", Integer.valueOf(planes));
        this.f4485a.put("bits_per_pixel", Integer.valueOf(this.c));
        this.b = 3;
        if (this.f4488b == 0) {
            this.f4488b = size;
        }
        if (size == 12) {
            this.f4485a.put("bmp_version", "BMP v. 2.x");
            int i3 = this.c;
            if (i3 == 1) {
                this.a = 0;
            } else if (i3 == 4) {
                this.a = 1;
            } else if (i3 == 8) {
                this.a = 2;
            } else if (i3 == 24) {
                this.a = 3;
            }
            long j = this.f4488b;
            int sizeOfPalette = ((int) (((j - 14) - size) / 3)) * 3;
            if (j == size) {
                switch (this.a) {
                    case 0:
                        sizeOfPalette = 6;
                        break;
                    case 1:
                        sizeOfPalette = 48;
                        break;
                    case 2:
                        sizeOfPalette = 768;
                        break;
                    case 3:
                        sizeOfPalette = 0;
                        break;
                }
                this.f4488b = ((long) sizeOfPalette) + size;
            }
            s(sizeOfPalette);
            int i4 = planes;
        } else {
            this.f4489c = p(this.f4484a);
            this.f4490d = p(this.f4484a);
            this.f4491e = (long) r(this.f4484a);
            this.f4492f = (long) r(this.f4484a);
            long colorsUsed = p(this.f4484a);
            long colorsImportant = p(this.f4484a);
            switch ((int) this.f4489c) {
                case 0:
                    this.f4485a.put("compression", "BI_RGB");
                    break;
                case 1:
                    this.f4485a.put("compression", "BI_RLE8");
                    break;
                case 2:
                    this.f4485a.put("compression", "BI_RLE4");
                    break;
                case 3:
                    this.f4485a.put("compression", "BI_BITFIELDS");
                    break;
            }
            this.f4485a.put("x_pixels_per_meter", Long.valueOf(this.f4491e));
            this.f4485a.put("y_pixels_per_meter", Long.valueOf(this.f4492f));
            this.f4485a.put("colors_used", Long.valueOf(colorsUsed));
            this.f4485a.put("colors_important", Long.valueOf(colorsImportant));
            if (size == 40 || size == 52) {
                int i5 = planes;
            } else if (size == 56) {
                int i6 = planes;
            } else if (size == 108) {
                this.f4485a.put("bmp_version", "BMP v. 4.x");
                this.d = (int) p(this.f4484a);
                this.e = (int) p(this.f4484a);
                this.f = (int) p(this.f4484a);
                this.g = (int) p(this.f4484a);
                long csType = p(this.f4484a);
                int redX2 = r(this.f4484a);
                int redY = r(this.f4484a);
                int redZ2 = r(this.f4484a);
                int greenX = r(this.f4484a);
                int i7 = planes;
                int greenY = r(this.f4484a);
                int greenZ = r(this.f4484a);
                int blueX = r(this.f4484a);
                int blueY = r(this.f4484a);
                int blueZ = r(this.f4484a);
                long gammaRed = p(this.f4484a);
                long gammaGreen = p(this.f4484a);
                long gammaBlue = p(this.f4484a);
                int i8 = this.c;
                int greenX2 = greenX;
                if (i8 == 1) {
                    this.a = 10;
                    redZ = redZ2;
                    redX = redX2;
                } else if (i8 == 4) {
                    this.a = 11;
                    redZ = redZ2;
                    redX = redX2;
                } else if (i8 == 8) {
                    this.a = 12;
                    redZ = redZ2;
                    redX = redX2;
                } else if (i8 == 16) {
                    this.a = 13;
                    redZ = redZ2;
                    redX = redX2;
                    if (((int) this.f4489c) == 0) {
                        this.d = 31744;
                        this.e = 992;
                        this.f = 31;
                    }
                } else {
                    redZ = redZ2;
                    redX = redX2;
                    if (i8 == 24) {
                        this.a = 14;
                    } else if (i8 == 32) {
                        this.a = 15;
                        if (((int) this.f4489c) == 0) {
                            this.d = 16711680;
                            this.e = MotionEventCompat.ACTION_POINTER_INDEX_MASK;
                            this.f = 255;
                        }
                    }
                }
                this.f4485a.put("red_mask", Integer.valueOf(this.d));
                this.f4485a.put("green_mask", Integer.valueOf(this.e));
                this.f4485a.put("blue_mask", Integer.valueOf(this.f));
                this.f4485a.put("alpha_mask", Integer.valueOf(this.g));
                long j2 = this.f4488b;
                int sizeOfPalette2 = ((int) (((j2 - 14) - size) / 4)) * 4;
                if (j2 == size) {
                    switch (this.a) {
                        case 10:
                            sizeOfPalette2 = ((int) (colorsUsed == 0 ? 2 : colorsUsed)) * 4;
                            break;
                        case 11:
                            sizeOfPalette2 = ((int) (colorsUsed == 0 ? 16 : colorsUsed)) * 4;
                            break;
                        case 12:
                            sizeOfPalette2 = ((int) (colorsUsed == 0 ? 256 : colorsUsed)) * 4;
                            break;
                        default:
                            sizeOfPalette2 = 0;
                            break;
                    }
                    this.f4488b = ((long) sizeOfPalette2) + size;
                }
                s(sizeOfPalette2);
                switch ((int) csType) {
                    case 0:
                        this.f4485a.put("color_space", "LCS_CALIBRATED_RGB");
                        this.f4485a.put("redX", Integer.valueOf(redX));
                        this.f4485a.put("redY", Integer.valueOf(redY));
                        this.f4485a.put("redZ", Integer.valueOf(redZ));
                        this.f4485a.put("greenX", Integer.valueOf(greenX2));
                        this.f4485a.put("greenY", Integer.valueOf(greenY));
                        this.f4485a.put("greenZ", Integer.valueOf(greenZ));
                        this.f4485a.put("blueX", Integer.valueOf(blueX));
                        this.f4485a.put("blueY", Integer.valueOf(blueY));
                        this.f4485a.put("blueZ", Integer.valueOf(blueZ));
                        this.f4485a.put("gamma_red", Long.valueOf(gammaRed));
                        this.f4485a.put("gamma_green", Long.valueOf(gammaGreen));
                        this.f4485a.put("gamma_blue", Long.valueOf(gammaBlue));
                        throw new RuntimeException("Not implemented yet.");
                    case 1:
                        this.f4485a.put("color_space", "LCS_sRGB");
                        break;
                    case 2:
                        this.f4485a.put("color_space", "LCS_CMYK");
                        throw new RuntimeException("Not implemented yet.");
                }
            } else {
                this.f4485a.put("bmp_version", "BMP v. 5.x");
                throw new RuntimeException("BMP version 5 not implemented yet.");
            }
            switch ((int) this.f4489c) {
                case 0:
                case 1:
                case 2:
                    int i9 = this.c;
                    if (i9 == 1) {
                        this.a = 4;
                    } else if (i9 == 4) {
                        this.a = 5;
                    } else if (i9 == 8) {
                        this.a = 6;
                    } else if (i9 == 24) {
                        this.a = 7;
                    } else if (i9 == 16) {
                        this.a = 8;
                        this.d = 31744;
                        this.e = 992;
                        this.f = 31;
                        this.f4485a.put("red_mask", 31744);
                        this.f4485a.put("green_mask", Integer.valueOf(this.e));
                        this.f4485a.put("blue_mask", Integer.valueOf(this.f));
                    } else if (i9 == 32) {
                        this.a = 9;
                        this.d = 16711680;
                        this.e = MotionEventCompat.ACTION_POINTER_INDEX_MASK;
                        this.f = 255;
                        this.f4485a.put("red_mask", 16711680);
                        this.f4485a.put("green_mask", Integer.valueOf(this.e));
                        this.f4485a.put("blue_mask", Integer.valueOf(this.f));
                    }
                    if (size >= 52) {
                        this.d = (int) p(this.f4484a);
                        this.e = (int) p(this.f4484a);
                        this.f = (int) p(this.f4484a);
                        this.f4485a.put("red_mask", Integer.valueOf(this.d));
                        this.f4485a.put("green_mask", Integer.valueOf(this.e));
                        this.f4485a.put("blue_mask", Integer.valueOf(this.f));
                    }
                    if (size == 56) {
                        int p = (int) p(this.f4484a);
                        this.g = p;
                        this.f4485a.put("alpha_mask", Integer.valueOf(p));
                    }
                    long j3 = this.f4488b;
                    int sizeOfPalette3 = ((int) (((j3 - 14) - size) / 4)) * 4;
                    if (j3 == size) {
                        switch (this.a) {
                            case 4:
                                sizeOfPalette3 = ((int) (colorsUsed == 0 ? 2 : colorsUsed)) * 4;
                                break;
                            case 5:
                                sizeOfPalette3 = ((int) (colorsUsed == 0 ? 16 : colorsUsed)) * 4;
                                break;
                            case 6:
                                sizeOfPalette3 = ((int) (colorsUsed == 0 ? 256 : colorsUsed)) * 4;
                                break;
                            default:
                                sizeOfPalette3 = 0;
                                break;
                        }
                        this.f4488b = ((long) sizeOfPalette3) + size;
                    }
                    s(sizeOfPalette3);
                    this.f4485a.put("bmp_version", "BMP v. 3.x");
                    break;
                case 3:
                    int i10 = this.c;
                    if (i10 == 16) {
                        this.a = 8;
                    } else if (i10 == 32) {
                        this.a = 9;
                    }
                    this.d = (int) p(this.f4484a);
                    this.e = (int) p(this.f4484a);
                    this.f = (int) p(this.f4484a);
                    if (size == 56) {
                        int p2 = (int) p(this.f4484a);
                        this.g = p2;
                        this.f4485a.put("alpha_mask", Integer.valueOf(p2));
                    }
                    this.f4485a.put("red_mask", Integer.valueOf(this.d));
                    this.f4485a.put("green_mask", Integer.valueOf(this.e));
                    this.f4485a.put("blue_mask", Integer.valueOf(this.f));
                    if (colorsUsed != 0) {
                        s(((int) colorsUsed) * 4);
                    }
                    this.f4485a.put("bmp_version", "BMP v. 3.x NT");
                    break;
                default:
                    throw new RuntimeException("Invalid compression specified in BMP file.");
            }
        }
        int i11 = this.i;
        if (i11 > 0) {
            i2 = 1;
            this.f4486a = true;
        } else {
            i2 = 1;
            this.f4486a = false;
            this.i = Math.abs(i11);
        }
        int i12 = this.c;
        if (i12 == i2 || i12 == 4 || i12 == 8) {
            this.b = 1;
            int i13 = this.a;
            if (i13 == 0 || i13 == 1 || i13 == 2) {
                int sizep = this.f4487a.length / 3;
                if (sizep > 256) {
                    sizep = 256;
                }
                byte[] r = new byte[sizep];
                byte[] g2 = new byte[sizep];
                byte[] b2 = new byte[sizep];
                for (int i14 = 0; i14 < sizep; i14++) {
                    int off = i14 * 3;
                    byte[] bArr = this.f4487a;
                    b2[i14] = bArr[off];
                    g2[i14] = bArr[off + 1];
                    r[i14] = bArr[off + 2];
                }
                return;
            }
            int sizep2 = this.f4487a.length / 4;
            if (sizep2 > 256) {
                sizep2 = 256;
            }
            byte[] r2 = new byte[sizep2];
            byte[] g3 = new byte[sizep2];
            byte[] b3 = new byte[sizep2];
            for (int i15 = 0; i15 < sizep2; i15++) {
                int off2 = i15 * 4;
                byte[] bArr2 = this.f4487a;
                b3[i15] = bArr2[off2];
                g3[i15] = bArr2[off2 + 1];
                r2[i15] = bArr2[off2 + 2];
            }
        } else if (i12 == 16) {
            this.b = 3;
        } else if (i12 == 32) {
            this.b = this.g == 0 ? 3 : 4;
        } else {
            this.b = 3;
        }
    }

    private byte[] h(int group) {
        byte[] bArr = this.f4487a;
        if (bArr == null) {
            return null;
        }
        byte[] np = new byte[((bArr.length / group) * 3)];
        int e2 = bArr.length / group;
        for (int k = 0; k < e2; k++) {
            int src = k * group;
            int dest = k * 3;
            byte[] bArr2 = this.f4487a;
            int src2 = src + 1;
            np[dest + 2] = bArr2[src];
            np[dest + 1] = bArr2[src2];
            np[dest] = bArr2[src2 + 1];
        }
        return np;
    }

    private tr d() {
        switch (this.a) {
            case 0:
                return l(3);
            case 1:
                return n(3);
            case 2:
                return o(3);
            case 3:
                byte[] bdata = new byte[(this.h * this.i * 3)];
                m(bdata);
                return new xr(this.h, this.i, 3, 8, bdata);
            case 4:
                return l(4);
            case 5:
                switch ((int) this.f4489c) {
                    case 0:
                        return n(4);
                    case 2:
                        return t();
                    default:
                        throw new RuntimeException("Invalid compression specified for BMP file.");
                }
            case 6:
                switch ((int) this.f4489c) {
                    case 0:
                        return o(4);
                    case 1:
                        return u();
                    default:
                        throw new RuntimeException("Invalid compression specified for BMP file.");
                }
            case 7:
                byte[] bdata2 = new byte[(this.h * this.i * 3)];
                m(bdata2);
                return new xr(this.h, this.i, 3, 8, bdata2);
            case 8:
                return k(false);
            case 9:
                return k(true);
            case 10:
                return l(4);
            case 11:
                switch ((int) this.f4489c) {
                    case 0:
                        return n(4);
                    case 2:
                        return t();
                    default:
                        throw new RuntimeException("Invalid compression specified for BMP file.");
                }
            case 12:
                switch ((int) this.f4489c) {
                    case 0:
                        return o(4);
                    case 1:
                        return u();
                    default:
                        throw new RuntimeException("Invalid compression specified for BMP file.");
                }
            case 13:
                return k(false);
            case 14:
                byte[] bdata3 = new byte[(this.h * this.i * 3)];
                m(bdata3);
                return new xr(this.h, this.i, 3, 8, bdata3);
            case 15:
                return k(true);
            default:
                return null;
        }
    }

    private tr i(byte[] bdata, int bpc, int paletteEntries) {
        tr img = new xr(this.h, this.i, 1, bpc, bdata);
        x50 colorspace = new x50();
        colorspace.I(h70.E5);
        colorspace.I(h70.s2);
        byte[] np = h(paletteEntries);
        colorspace.I(new k70((np.length / 3) - 1));
        colorspace.I(new n80(np));
        j60 ad = new j60();
        ad.Q(h70.n1, colorspace);
        img.c1(ad);
        return img;
    }

    private void s(int sizeOfPalette) {
        if (sizeOfPalette != 0) {
            this.f4487a = new byte[sizeOfPalette];
            int bytesRead = 0;
            while (bytesRead < sizeOfPalette) {
                int r = this.f4484a.read(this.f4487a, bytesRead, sizeOfPalette - bytesRead);
                if (r >= 0) {
                    bytesRead += r;
                } else {
                    throw new RuntimeException(i10.b("incomplete.palette", new Object[0]));
                }
            }
            this.f4485a.put("palette", this.f4487a);
        }
    }

    private tr l(int paletteEntries) {
        int i2 = this.h;
        byte[] bdata = new byte[(((i2 + 7) / 8) * this.i)];
        int padding = 0;
        int bytesPerScanline = (int) Math.ceil(((double) i2) / 8.0d);
        int remainder = bytesPerScanline % 4;
        if (remainder != 0) {
            padding = 4 - remainder;
        }
        int imSize = (bytesPerScanline + padding) * this.i;
        byte[] values = new byte[imSize];
        int bytesRead = 0;
        while (bytesRead < imSize) {
            bytesRead += this.f4484a.read(values, bytesRead, imSize - bytesRead);
        }
        if (this.f4486a) {
            for (int i3 = 0; i3 < this.i; i3++) {
                System.arraycopy(values, imSize - ((i3 + 1) * (bytesPerScanline + padding)), bdata, i3 * bytesPerScanline, bytesPerScanline);
            }
        } else {
            for (int i4 = 0; i4 < this.i; i4++) {
                System.arraycopy(values, (bytesPerScanline + padding) * i4, bdata, i4 * bytesPerScanline, bytesPerScanline);
            }
        }
        return i(bdata, 1, paletteEntries);
    }

    private tr n(int paletteEntries) {
        int i2 = this.h;
        byte[] bdata = new byte[(((i2 + 1) / 2) * this.i)];
        int padding = 0;
        int bytesPerScanline = (int) Math.ceil(((double) i2) / 2.0d);
        int remainder = bytesPerScanline % 4;
        if (remainder != 0) {
            padding = 4 - remainder;
        }
        int imSize = (bytesPerScanline + padding) * this.i;
        byte[] values = new byte[imSize];
        int bytesRead = 0;
        while (bytesRead < imSize) {
            bytesRead += this.f4484a.read(values, bytesRead, imSize - bytesRead);
        }
        if (this.f4486a) {
            for (int i3 = 0; i3 < this.i; i3++) {
                System.arraycopy(values, imSize - ((i3 + 1) * (bytesPerScanline + padding)), bdata, i3 * bytesPerScanline, bytesPerScanline);
            }
        } else {
            for (int i4 = 0; i4 < this.i; i4++) {
                System.arraycopy(values, (bytesPerScanline + padding) * i4, bdata, i4 * bytesPerScanline, bytesPerScanline);
            }
        }
        return i(bdata, 4, paletteEntries);
    }

    private tr o(int paletteEntries) {
        int i2 = this.h;
        byte[] bdata = new byte[(this.i * i2)];
        int padding = 0;
        int bitsPerScanline = i2 * 8;
        if (bitsPerScanline % 32 != 0) {
            padding = (int) Math.ceil(((double) ((((bitsPerScanline / 32) + 1) * 32) - bitsPerScanline)) / 8.0d);
        }
        int imSize = (this.h + padding) * this.i;
        byte[] values = new byte[imSize];
        int bytesRead = 0;
        while (bytesRead < imSize) {
            bytesRead += this.f4484a.read(values, bytesRead, imSize - bytesRead);
        }
        if (this.f4486a) {
            for (int i3 = 0; i3 < this.i; i3++) {
                int i4 = this.h;
                System.arraycopy(values, imSize - ((i3 + 1) * (i4 + padding)), bdata, i3 * i4, i4);
            }
        } else {
            for (int i5 = 0; i5 < this.i; i5++) {
                int i6 = this.h;
                System.arraycopy(values, (i6 + padding) * i5, bdata, i5 * i6, i6);
            }
        }
        return i(bdata, 8, paletteEntries);
    }

    private void m(byte[] bdata) {
        int padding = 0;
        int bitsPerScanline = this.h * 24;
        if (bitsPerScanline % 32 != 0) {
            padding = (int) Math.ceil(((double) ((((bitsPerScanline / 32) + 1) * 32) - bitsPerScanline)) / 8.0d);
        }
        int imSize = (((this.h * 3) + 3) / 4) * 4 * this.i;
        byte[] values = new byte[imSize];
        int bytesRead = 0;
        while (bytesRead < imSize) {
            try {
                int r = this.f4484a.read(values, bytesRead, imSize - bytesRead);
                if (r < 0) {
                    break;
                }
                bytesRead += r;
            } catch (IOException ioe) {
                throw new mj(ioe);
            }
        }
        int l = 0;
        if (this.f4486a) {
            int max = ((this.h * this.i) * 3) - 1;
            int count = -padding;
            int i2 = 0;
            while (i2 < this.i) {
                int l2 = (max - (((i2 + 1) * this.h) * 3)) + 1;
                count += padding;
                for (int j = 0; j < this.h; j++) {
                    int count2 = count + 1;
                    bdata[l2 + 2] = values[count];
                    int count3 = count2 + 1;
                    bdata[l2 + 1] = values[count2];
                    count = count3 + 1;
                    bdata[l2] = values[count3];
                    l2 += 3;
                }
                i2++;
                int i3 = l2;
            }
            return;
        }
        int count4 = -padding;
        for (int i4 = 0; i4 < this.i; i4++) {
            count4 += padding;
            for (int j2 = 0; j2 < this.h; j2++) {
                int count5 = count4 + 1;
                bdata[l + 2] = values[count4];
                int count6 = count5 + 1;
                bdata[l + 1] = values[count5];
                count4 = count6 + 1;
                bdata[l] = values[count6];
                l += 3;
            }
        }
        int i5 = count4;
    }

    private int b(int mask) {
        for (int k = 0; k < 32 && (mask & 1) != 1; k++) {
            mask >>>= 1;
        }
        return mask;
    }

    private int c(int mask) {
        int k = 0;
        while (k < 32 && (mask & 1) != 1) {
            mask >>>= 1;
            k++;
        }
        return k;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0063  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private defpackage.tr k(boolean r23) {
        /*
            r22 = this;
            r0 = r22
            int r1 = r0.d
            int r1 = r0.b(r1)
            int r2 = r0.d
            int r2 = r0.c(r2)
            int r3 = r1 + 1
            int r4 = r0.e
            int r4 = r0.b(r4)
            int r5 = r0.e
            int r5 = r0.c(r5)
            int r6 = r4 + 1
            int r7 = r0.f
            int r7 = r0.b(r7)
            int r8 = r0.f
            int r8 = r0.c(r8)
            int r9 = r7 + 1
            int r10 = r0.h
            int r11 = r0.i
            int r11 = r11 * r10
            int r11 = r11 * 3
            byte[] r11 = new byte[r11]
            r12 = 0
            if (r23 != 0) goto L_0x0052
            int r10 = r10 * 16
            int r13 = r10 % 32
            if (r13 == 0) goto L_0x0052
            int r13 = r10 / 32
            int r13 = r13 + 1
            int r13 = r13 * 32
            int r13 = r13 - r10
            double r14 = (double) r13
            r16 = 4620693217682128896(0x4020000000000000, double:8.0)
            double r14 = r14 / r16
            double r14 = java.lang.Math.ceil(r14)
            int r12 = (int) r14
            r10 = r12
            goto L_0x0053
        L_0x0052:
            r10 = r12
        L_0x0053:
            long r12 = r0.f4490d
            int r13 = (int) r12
            if (r13 != 0) goto L_0x0063
            long r14 = r0.f4483a
            r16 = r13
            long r12 = r0.f4488b
            long r14 = r14 - r12
            int r13 = (int) r14
            r18 = r13
            goto L_0x0067
        L_0x0063:
            r16 = r13
            r18 = r16
        L_0x0067:
            r12 = 0
            boolean r13 = r0.f4486a
            if (r13 == 0) goto L_0x00d8
            int r13 = r0.i
            int r13 = r13 + -1
        L_0x0070:
            if (r13 < 0) goto L_0x00d3
            int r14 = r0.h
            int r14 = r14 * 3
            int r14 = r14 * r13
            r12 = 0
        L_0x0079:
            int r15 = r0.h
            if (r12 >= r15) goto L_0x00c0
            if (r23 == 0) goto L_0x008b
            java.io.InputStream r15 = r0.f4484a
            r17 = r12
            r16 = r13
            long r12 = r0.p(r15)
            int r13 = (int) r12
            goto L_0x0095
        L_0x008b:
            r17 = r12
            r16 = r13
            java.io.InputStream r12 = r0.f4484a
            int r13 = r0.y(r12)
        L_0x0095:
            int r12 = r14 + 1
            int r15 = r13 >>> r2
            r15 = r15 & r1
            int r15 = r15 * 256
            int r15 = r15 / r3
            byte r15 = (byte) r15
            r11[r14] = r15
            int r14 = r12 + 1
            int r15 = r13 >>> r5
            r15 = r15 & r4
            int r15 = r15 * 256
            int r15 = r15 / r6
            byte r15 = (byte) r15
            r11[r12] = r15
            int r12 = r14 + 1
            int r15 = r13 >>> r8
            r15 = r15 & r7
            int r15 = r15 * 256
            int r15 = r15 / r9
            byte r15 = (byte) r15
            r11[r14] = r15
            int r14 = r17 + 1
            r13 = r16
            r21 = r14
            r14 = r12
            r12 = r21
            goto L_0x0079
        L_0x00c0:
            r17 = r12
            r16 = r13
            r12 = 0
        L_0x00c5:
            if (r12 >= r10) goto L_0x00cf
            java.io.InputStream r13 = r0.f4484a
            r13.read()
            int r12 = r12 + 1
            goto L_0x00c5
        L_0x00cf:
            int r13 = r16 + -1
            r12 = r14
            goto L_0x0070
        L_0x00d3:
            r16 = r13
            r19 = r12
            goto L_0x0138
        L_0x00d8:
            r13 = 0
        L_0x00d9:
            int r14 = r0.i
            if (r13 >= r14) goto L_0x0134
            r14 = 0
        L_0x00de:
            int r15 = r0.h
            if (r14 >= r15) goto L_0x0122
            if (r23 == 0) goto L_0x00f0
            java.io.InputStream r15 = r0.f4484a
            r16 = r13
            r17 = r14
            long r13 = r0.p(r15)
            int r14 = (int) r13
            goto L_0x00fa
        L_0x00f0:
            r16 = r13
            r17 = r14
            java.io.InputStream r13 = r0.f4484a
            int r14 = r0.y(r13)
        L_0x00fa:
            int r13 = r12 + 1
            int r15 = r14 >>> r2
            r15 = r15 & r1
            int r15 = r15 * 256
            int r15 = r15 / r3
            byte r15 = (byte) r15
            r11[r12] = r15
            int r12 = r13 + 1
            int r15 = r14 >>> r5
            r15 = r15 & r4
            int r15 = r15 * 256
            int r15 = r15 / r6
            byte r15 = (byte) r15
            r11[r13] = r15
            int r13 = r12 + 1
            int r15 = r14 >>> r8
            r15 = r15 & r7
            int r15 = r15 * 256
            int r15 = r15 / r9
            byte r15 = (byte) r15
            r11[r12] = r15
            int r12 = r17 + 1
            r14 = r12
            r12 = r13
            r13 = r16
            goto L_0x00de
        L_0x0122:
            r16 = r13
            r17 = r14
            r13 = 0
        L_0x0127:
            if (r13 >= r10) goto L_0x0131
            java.io.InputStream r14 = r0.f4484a
            r14.read()
            int r13 = r13 + 1
            goto L_0x0127
        L_0x0131:
            int r13 = r16 + 1
            goto L_0x00d9
        L_0x0134:
            r16 = r13
            r19 = r12
        L_0x0138:
            xr r20 = new xr
            int r13 = r0.h
            int r14 = r0.i
            r15 = 3
            r16 = 8
            r12 = r20
            r17 = r11
            r12.<init>(r13, r14, r15, r16, r17)
            return r20
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o6.k(boolean):tr");
    }

    private tr u() {
        int imSize = (int) this.f4490d;
        if (imSize == 0) {
            imSize = (int) (this.f4483a - this.f4488b);
        }
        byte[] values = new byte[imSize];
        int bytesRead = 0;
        while (bytesRead < imSize) {
            bytesRead += this.f4484a.read(values, bytesRead, imSize - bytesRead);
        }
        byte[] val = a(true, values);
        int imSize2 = this.h * this.i;
        if (this.f4486a != 0) {
            byte[] temp = new byte[val.length];
            int bytesPerScanline = this.h;
            for (int i2 = 0; i2 < this.i; i2++) {
                System.arraycopy(val, imSize2 - ((i2 + 1) * bytesPerScanline), temp, i2 * bytesPerScanline, bytesPerScanline);
            }
            val = temp;
        }
        return i(val, 8, 4);
    }

    private tr t() {
        int imSize = (int) this.f4490d;
        if (imSize == 0) {
            imSize = (int) (this.f4483a - this.f4488b);
        }
        byte[] values = new byte[imSize];
        int bytesRead = 0;
        while (bytesRead < imSize) {
            bytesRead += this.f4484a.read(values, bytesRead, imSize - bytesRead);
        }
        byte[] val = a(false, values);
        if (this.f4486a) {
            byte[] inverted = val;
            int i2 = this.h;
            int i3 = this.i;
            val = new byte[(i2 * i3)];
            int l = 0;
            for (int i4 = i3 - 1; i4 >= 0; i4--) {
                int i5 = this.h;
                int index = i4 * i5;
                int lineEnd = i5 + l;
                while (l != lineEnd) {
                    val[l] = inverted[index];
                    l++;
                    index++;
                }
            }
        }
        int stride = (this.h + 1) / 2;
        byte[] bdata = new byte[(this.i * stride)];
        int ptr = 0;
        int sh = 0;
        for (int h2 = 0; h2 < this.i; h2++) {
            for (int w = 0; w < this.h; w++) {
                if ((w & 1) == 0) {
                    bdata[(w / 2) + sh] = (byte) (val[ptr] << 4);
                    ptr++;
                } else {
                    int i6 = (w / 2) + sh;
                    bdata[i6] = (byte) (((byte) (val[ptr] & 15)) | bdata[i6]);
                    ptr++;
                }
            }
            sh += stride;
        }
        return i(bdata, 4, 4);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] a(boolean r12, byte[] r13) {
        /*
            r11 = this;
            int r0 = r11.h
            int r1 = r11.i
            int r0 = r0 * r1
            byte[] r0 = new byte[r0]
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x000c:
            int r5 = r11.i     // Catch:{ RuntimeException -> 0x00d1 }
            if (r4 >= r5) goto L_0x00d0
            int r5 = r13.length     // Catch:{ RuntimeException -> 0x00d1 }
            if (r1 >= r5) goto L_0x00d0
            int r5 = r1 + 1
            byte r1 = r13[r1]     // Catch:{ RuntimeException -> 0x00d1 }
            r1 = r1 & 255(0xff, float:3.57E-43)
            r6 = 1
            if (r1 == 0) goto L_0x004c
            int r7 = r5 + 1
            byte r5 = r13[r5]     // Catch:{ RuntimeException -> 0x00d1 }
            r5 = r5 & 255(0xff, float:3.57E-43)
            if (r12 == 0) goto L_0x0031
            r6 = r1
        L_0x0025:
            if (r6 == 0) goto L_0x0030
            int r8 = r3 + 1
            byte r9 = (byte) r5     // Catch:{ RuntimeException -> 0x00d1 }
            r0[r3] = r9     // Catch:{ RuntimeException -> 0x00d1 }
            int r6 = r6 + -1
            r3 = r8
            goto L_0x0025
        L_0x0030:
            goto L_0x0048
        L_0x0031:
            r8 = 0
        L_0x0032:
            if (r8 >= r1) goto L_0x0048
            int r9 = r3 + 1
            r10 = r8 & 1
            if (r10 != r6) goto L_0x003d
            r10 = r5 & 15
            goto L_0x0041
        L_0x003d:
            int r10 = r5 >>> 4
            r10 = r10 & 15
        L_0x0041:
            byte r10 = (byte) r10     // Catch:{ RuntimeException -> 0x00d1 }
            r0[r3] = r10     // Catch:{ RuntimeException -> 0x00d1 }
            int r8 = r8 + 1
            r3 = r9
            goto L_0x0032
        L_0x0048:
            int r2 = r2 + r1
            r1 = r7
            goto L_0x00ce
        L_0x004c:
            int r7 = r5 + 1
            byte r5 = r13[r5]     // Catch:{ RuntimeException -> 0x00d1 }
            r1 = r5 & 255(0xff, float:3.57E-43)
            if (r1 != r6) goto L_0x0056
            goto L_0x00d0
        L_0x0056:
            switch(r1) {
                case 0: goto L_0x0074;
                case 1: goto L_0x0059;
                case 2: goto L_0x005d;
                default: goto L_0x0059;
            }     // Catch:{ RuntimeException -> 0x00d1 }
        L_0x0059:
            if (r12 == 0) goto L_0x0091
            r5 = r1
            goto L_0x007e
        L_0x005d:
            int r5 = r7 + 1
            byte r6 = r13[r7]     // Catch:{ RuntimeException -> 0x00d1 }
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r2 = r2 + r6
            int r6 = r5 + 1
            byte r5 = r13[r5]     // Catch:{ RuntimeException -> 0x00d1 }
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r4 = r4 + r5
            int r5 = r11.h     // Catch:{ RuntimeException -> 0x00d1 }
            int r5 = r5 * r4
            int r5 = r5 + r2
            r3 = r5
            r1 = r6
            goto L_0x00ce
        L_0x0074:
            r2 = 0
            int r4 = r4 + 1
            int r5 = r11.h     // Catch:{ RuntimeException -> 0x00d1 }
            int r5 = r5 * r4
            r3 = r5
            r1 = r7
            goto L_0x00ce
        L_0x007e:
            if (r5 == 0) goto L_0x0090
            int r8 = r3 + 1
            int r9 = r7 + 1
            byte r7 = r13[r7]     // Catch:{ RuntimeException -> 0x00d1 }
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = (byte) r7     // Catch:{ RuntimeException -> 0x00d1 }
            r0[r3] = r7     // Catch:{ RuntimeException -> 0x00d1 }
            int r5 = r5 + -1
            r3 = r8
            r7 = r9
            goto L_0x007e
        L_0x0090:
            goto L_0x00b4
        L_0x0091:
            r5 = 0
            r8 = 0
        L_0x0093:
            if (r8 >= r1) goto L_0x00b4
            r9 = r8 & 1
            if (r9 != 0) goto L_0x00a0
            int r9 = r7 + 1
            byte r7 = r13[r7]     // Catch:{ RuntimeException -> 0x00d1 }
            r5 = r7 & 255(0xff, float:3.57E-43)
            r7 = r9
        L_0x00a0:
            int r9 = r3 + 1
            r10 = r8 & 1
            if (r10 != r6) goto L_0x00a9
            r10 = r5 & 15
            goto L_0x00ad
        L_0x00a9:
            int r10 = r5 >>> 4
            r10 = r10 & 15
        L_0x00ad:
            byte r10 = (byte) r10     // Catch:{ RuntimeException -> 0x00d1 }
            r0[r3] = r10     // Catch:{ RuntimeException -> 0x00d1 }
            int r8 = r8 + 1
            r3 = r9
            goto L_0x0093
        L_0x00b4:
            int r2 = r2 + r1
            if (r12 == 0) goto L_0x00bf
            r5 = r1 & 1
            if (r5 != r6) goto L_0x00c9
            int r7 = r7 + 1
            r1 = r7
            goto L_0x00ce
        L_0x00bf:
            r5 = r1 & 3
            if (r5 == r6) goto L_0x00cb
            r5 = r1 & 3
            r6 = 2
            if (r5 != r6) goto L_0x00c9
            goto L_0x00cb
        L_0x00c9:
            r1 = r7
            goto L_0x00ce
        L_0x00cb:
            int r7 = r7 + 1
            r1 = r7
        L_0x00ce:
            goto L_0x000c
        L_0x00d0:
            goto L_0x00d2
        L_0x00d1:
            r1 = move-exception
        L_0x00d2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o6.a(boolean, byte[]):byte[]");
    }

    private int v(InputStream stream) {
        return stream.read() & 255;
    }

    private int x(InputStream stream) {
        return ((v(stream) << 8) | v(stream)) & SupportMenu.USER_MASK;
    }

    private int y(InputStream stream) {
        return x(stream);
    }

    private long w(InputStream stream) {
        int b1 = v(stream);
        int b2 = v(stream);
        return -1 & ((long) ((v(stream) << 24) | (v(stream) << 16) | (b2 << 8) | b1));
    }

    private int q(InputStream stream) {
        int b1 = v(stream);
        int b2 = v(stream);
        return (v(stream) << 24) | (v(stream) << 16) | (b2 << 8) | b1;
    }

    private long p(InputStream stream) {
        return w(stream);
    }

    private int r(InputStream stream) {
        return q(stream);
    }
}
