package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import java.util.Locale;

/* renamed from: q5  reason: default package */
public final class q5 {
    final float a;

    /* renamed from: a  reason: collision with other field name */
    final int f4752a;

    /* renamed from: a  reason: collision with other field name */
    private final a f4753a;
    final float b;

    /* renamed from: b  reason: collision with other field name */
    final int f4754b;

    /* renamed from: b  reason: collision with other field name */
    private final a f4755b;
    final float c;

    /* renamed from: c  reason: collision with other field name */
    int f4756c;
    final float d;
    final float e;
    final float f;

    q5(Context context, int badgeResId, int defStyleAttr, int defStyleRes, a storedState) {
        CharSequence charSequence;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z;
        Locale locale;
        a aVar = new a();
        this.f4755b = aVar;
        storedState = storedState == null ? new a() : storedState;
        if (badgeResId != 0) {
            int unused = storedState.a = badgeResId;
        }
        TypedArray a2 = a(context, storedState.a, defStyleAttr, defStyleRes);
        Resources res = context.getResources();
        this.a = (float) a2.getDimensionPixelSize(xc0.q, -1);
        this.f4752a = context.getResources().getDimensionPixelSize(cc0.mtrl_badge_horizontal_edge_offset);
        this.f4754b = context.getResources().getDimensionPixelSize(cc0.mtrl_badge_text_horizontal_edge_offset);
        this.b = (float) a2.getDimensionPixelSize(xc0.A, -1);
        int i19 = xc0.y;
        int i20 = cc0.m3_badge_size;
        this.c = a2.getDimension(i19, res.getDimension(i20));
        int i21 = xc0.D;
        int i22 = cc0.m3_badge_with_text_size;
        this.e = a2.getDimension(i21, res.getDimension(i22));
        this.d = a2.getDimension(xc0.p, res.getDimension(i20));
        this.f = a2.getDimension(xc0.z, res.getDimension(i22));
        boolean z2 = true;
        this.f4756c = a2.getInt(xc0.K, 1);
        int unused2 = aVar.b = storedState.b == -2 ? 255 : storedState.b;
        if (storedState.c != -2) {
            int unused3 = aVar.c = storedState.c;
        } else {
            int i23 = xc0.J;
            if (a2.hasValue(i23)) {
                int unused4 = aVar.c = a2.getInt(i23, 0);
            } else {
                int unused5 = aVar.c = -1;
            }
        }
        if (storedState.f4760a != null) {
            String unused6 = aVar.f4760a = storedState.f4760a;
        } else {
            int i24 = xc0.t;
            if (a2.hasValue(i24)) {
                String unused7 = aVar.f4760a = a2.getString(i24);
            }
        }
        CharSequence unused8 = aVar.f4758a = storedState.f4758a;
        if (storedState.f4763b == null) {
            charSequence = context.getString(sc0.mtrl_badge_numberless_content_description);
        } else {
            charSequence = storedState.f4763b;
        }
        CharSequence unused9 = aVar.f4763b = charSequence;
        if (storedState.f == 0) {
            i = pc0.mtrl_badge_content_description;
        } else {
            i = storedState.f;
        }
        int unused10 = aVar.f = i;
        if (storedState.g == 0) {
            i2 = sc0.mtrl_exceed_max_badge_number_content_description;
        } else {
            i2 = storedState.g;
        }
        int unused11 = aVar.g = i2;
        if (storedState.f4757a != null && !storedState.f4757a.booleanValue()) {
            z2 = false;
        }
        Boolean unused12 = aVar.f4757a = Boolean.valueOf(z2);
        if (storedState.d == -2) {
            i3 = a2.getInt(xc0.H, -2);
        } else {
            i3 = storedState.d;
        }
        int unused13 = aVar.d = i3;
        if (storedState.e == -2) {
            i4 = a2.getInt(xc0.I, -2);
        } else {
            i4 = storedState.e;
        }
        int unused14 = aVar.e = i4;
        if (storedState.f4766d == null) {
            i5 = a2.getResourceId(xc0.r, uc0.ShapeAppearance_M3_Sys_Shape_Corner_Full);
        } else {
            i5 = storedState.f4766d.intValue();
        }
        Integer unused15 = aVar.f4766d = Integer.valueOf(i5);
        if (storedState.f4767e == null) {
            i6 = a2.getResourceId(xc0.s, 0);
        } else {
            i6 = storedState.f4767e.intValue();
        }
        Integer unused16 = aVar.f4767e = Integer.valueOf(i6);
        if (storedState.f4768f == null) {
            i7 = a2.getResourceId(xc0.B, uc0.ShapeAppearance_M3_Sys_Shape_Corner_Full);
        } else {
            i7 = storedState.f4768f.intValue();
        }
        Integer unused17 = aVar.f4768f = Integer.valueOf(i7);
        if (storedState.f4769g == null) {
            i8 = a2.getResourceId(xc0.C, 0);
        } else {
            i8 = storedState.f4769g.intValue();
        }
        Integer unused18 = aVar.f4769g = Integer.valueOf(i8);
        if (storedState.f4759a == null) {
            i9 = G(context, a2, xc0.n);
        } else {
            i9 = storedState.f4759a.intValue();
        }
        Integer unused19 = aVar.f4759a = Integer.valueOf(i9);
        if (storedState.f4765c == null) {
            i10 = a2.getResourceId(xc0.u, uc0.TextAppearance_MaterialComponents_Badge);
        } else {
            i10 = storedState.f4765c.intValue();
        }
        Integer unused20 = aVar.f4765c = Integer.valueOf(i10);
        if (storedState.f4764b != null) {
            Integer unused21 = aVar.f4764b = storedState.f4764b;
        } else {
            int i25 = xc0.v;
            if (a2.hasValue(i25)) {
                Integer unused22 = aVar.f4764b = Integer.valueOf(G(context, a2, i25));
            } else {
                Integer unused23 = aVar.f4764b = Integer.valueOf(new oq0(context, aVar.f4765c.intValue()).i().getDefaultColor());
            }
        }
        if (storedState.h == null) {
            i11 = a2.getInt(xc0.o, 8388661);
        } else {
            i11 = storedState.h.intValue();
        }
        Integer unused24 = aVar.h = Integer.valueOf(i11);
        if (storedState.i == null) {
            i12 = a2.getDimensionPixelSize(xc0.x, res.getDimensionPixelSize(cc0.mtrl_badge_long_text_horizontal_padding));
        } else {
            i12 = storedState.i.intValue();
        }
        Integer unused25 = aVar.i = Integer.valueOf(i12);
        if (storedState.j == null) {
            i13 = a2.getDimensionPixelSize(xc0.w, res.getDimensionPixelSize(cc0.m3_badge_with_text_vertical_padding));
        } else {
            i13 = storedState.j.intValue();
        }
        Integer unused26 = aVar.j = Integer.valueOf(i13);
        if (storedState.k == null) {
            i14 = a2.getDimensionPixelOffset(xc0.E, 0);
        } else {
            i14 = storedState.k.intValue();
        }
        Integer unused27 = aVar.k = Integer.valueOf(i14);
        if (storedState.l == null) {
            i15 = a2.getDimensionPixelOffset(xc0.L, 0);
        } else {
            i15 = storedState.l.intValue();
        }
        Integer unused28 = aVar.l = Integer.valueOf(i15);
        if (storedState.m == null) {
            i16 = a2.getDimensionPixelOffset(xc0.F, aVar.k.intValue());
        } else {
            i16 = storedState.m.intValue();
        }
        Integer unused29 = aVar.m = Integer.valueOf(i16);
        if (storedState.n == null) {
            i17 = a2.getDimensionPixelOffset(xc0.M, aVar.l.intValue());
        } else {
            i17 = storedState.n.intValue();
        }
        Integer unused30 = aVar.n = Integer.valueOf(i17);
        if (storedState.q == null) {
            i18 = a2.getDimensionPixelOffset(xc0.G, 0);
        } else {
            i18 = storedState.q.intValue();
        }
        Integer unused31 = aVar.q = Integer.valueOf(i18);
        Integer unused32 = aVar.o = Integer.valueOf(storedState.o == null ? 0 : storedState.o.intValue());
        Integer unused33 = aVar.p = Integer.valueOf(storedState.p == null ? 0 : storedState.p.intValue());
        if (storedState.f4762b == null) {
            z = a2.getBoolean(xc0.m, false);
        } else {
            z = storedState.f4762b.booleanValue();
        }
        Boolean unused34 = aVar.f4762b = Boolean.valueOf(z);
        a2.recycle();
        if (storedState.f4761a == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = Locale.getDefault(Locale.Category.FORMAT);
            } else {
                locale = Locale.getDefault();
            }
            Locale unused35 = aVar.f4761a = locale;
        } else {
            Locale unused36 = aVar.f4761a = storedState.f4761a;
        }
        this.f4753a = storedState;
    }

    private TypedArray a(Context context, int badgeResId, int defStyleAttr, int defStyleRes) {
        AttributeSet attrs = null;
        int style = 0;
        if (badgeResId != 0) {
            attrs = yh.i(context, badgeResId, "badge");
            style = attrs.getStyleAttribute();
        }
        if (style == 0) {
            style = defStyleRes;
        }
        return vq0.i(context, attrs, xc0.f5714t, defStyleAttr, style, new int[0]);
    }

    /* access modifiers changed from: package-private */
    public boolean F() {
        return this.f4755b.f4757a.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public boolean C() {
        return this.f4755b.c != -1;
    }

    /* access modifiers changed from: package-private */
    public int w() {
        return this.f4755b.c;
    }

    /* access modifiers changed from: package-private */
    public boolean D() {
        return this.f4755b.f4760a != null;
    }

    /* access modifiers changed from: package-private */
    public String y() {
        return this.f4755b.f4760a;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f4755b.b;
    }

    /* access modifiers changed from: package-private */
    public void H(int alpha) {
        int unused = this.f4753a.b = alpha;
        int unused2 = this.f4755b.b = alpha;
    }

    /* access modifiers changed from: package-private */
    public int u() {
        return this.f4755b.d;
    }

    /* access modifiers changed from: package-private */
    public int v() {
        return this.f4755b.e;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f4755b.f4759a.intValue();
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return this.f4755b.f4764b.intValue();
    }

    /* access modifiers changed from: package-private */
    public int z() {
        return this.f4755b.f4765c.intValue();
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return this.f4755b.f4766d.intValue();
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.f4755b.f4767e.intValue();
    }

    /* access modifiers changed from: package-private */
    public int m() {
        return this.f4755b.f4768f.intValue();
    }

    /* access modifiers changed from: package-private */
    public int l() {
        return this.f4755b.f4769g.intValue();
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f4755b.h.intValue();
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f4755b.i.intValue();
    }

    /* access modifiers changed from: package-private */
    public int k() {
        return this.f4755b.j.intValue();
    }

    /* access modifiers changed from: package-private */
    public int s() {
        return this.f4755b.k.intValue();
    }

    /* access modifiers changed from: package-private */
    public int B() {
        return this.f4755b.l.intValue();
    }

    /* access modifiers changed from: package-private */
    public int r() {
        return this.f4755b.m.intValue();
    }

    /* access modifiers changed from: package-private */
    public int A() {
        return this.f4755b.n.intValue();
    }

    /* access modifiers changed from: package-private */
    public int t() {
        return this.f4755b.q.intValue();
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f4755b.o.intValue();
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f4755b.p.intValue();
    }

    /* access modifiers changed from: package-private */
    public CharSequence o() {
        return this.f4755b.f4758a;
    }

    /* access modifiers changed from: package-private */
    public CharSequence p() {
        return this.f4755b.f4763b;
    }

    /* access modifiers changed from: package-private */
    public int q() {
        return this.f4755b.f;
    }

    /* access modifiers changed from: package-private */
    public int n() {
        return this.f4755b.g;
    }

    /* access modifiers changed from: package-private */
    public Locale x() {
        return this.f4755b.f4761a;
    }

    /* access modifiers changed from: package-private */
    public boolean E() {
        return this.f4755b.f4762b.booleanValue();
    }

    private static int G(Context context, TypedArray a2, int index) {
        return o00.a(context, a2, index).getDefaultColor();
    }

    /* renamed from: q5$a */
    public static final class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new C0056a();
        /* access modifiers changed from: private */
        public int a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public Boolean f4757a = true;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public CharSequence f4758a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public Integer f4759a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public String f4760a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public Locale f4761a;
        /* access modifiers changed from: private */
        public int b = 255;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with other field name */
        public Boolean f4762b;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with other field name */
        public CharSequence f4763b;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with other field name */
        public Integer f4764b;
        /* access modifiers changed from: private */
        public int c = -2;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with other field name */
        public Integer f4765c;
        /* access modifiers changed from: private */
        public int d = -2;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with other field name */
        public Integer f4766d;
        /* access modifiers changed from: private */
        public int e = -2;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with other field name */
        public Integer f4767e;
        /* access modifiers changed from: private */
        public int f;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with other field name */
        public Integer f4768f;
        /* access modifiers changed from: private */
        public int g;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with other field name */
        public Integer f4769g;
        /* access modifiers changed from: private */
        public Integer h;
        /* access modifiers changed from: private */
        public Integer i;
        /* access modifiers changed from: private */
        public Integer j;
        /* access modifiers changed from: private */
        public Integer k;
        /* access modifiers changed from: private */
        public Integer l;
        /* access modifiers changed from: private */
        public Integer m;
        /* access modifiers changed from: private */
        public Integer n;
        /* access modifiers changed from: private */
        public Integer o;
        /* access modifiers changed from: private */
        public Integer p;
        /* access modifiers changed from: private */
        public Integer q;

        public a() {
        }

        a(Parcel in) {
            this.a = in.readInt();
            this.f4759a = (Integer) in.readSerializable();
            this.f4764b = (Integer) in.readSerializable();
            this.f4765c = (Integer) in.readSerializable();
            this.f4766d = (Integer) in.readSerializable();
            this.f4767e = (Integer) in.readSerializable();
            this.f4768f = (Integer) in.readSerializable();
            this.f4769g = (Integer) in.readSerializable();
            this.b = in.readInt();
            this.f4760a = in.readString();
            this.c = in.readInt();
            this.d = in.readInt();
            this.e = in.readInt();
            this.f4758a = in.readString();
            this.f4763b = in.readString();
            this.f = in.readInt();
            this.h = (Integer) in.readSerializable();
            this.i = (Integer) in.readSerializable();
            this.j = (Integer) in.readSerializable();
            this.k = (Integer) in.readSerializable();
            this.l = (Integer) in.readSerializable();
            this.m = (Integer) in.readSerializable();
            this.n = (Integer) in.readSerializable();
            this.q = (Integer) in.readSerializable();
            this.o = (Integer) in.readSerializable();
            this.p = (Integer) in.readSerializable();
            this.f4757a = (Boolean) in.readSerializable();
            this.f4761a = (Locale) in.readSerializable();
            this.f4762b = (Boolean) in.readSerializable();
        }

        /* renamed from: q5$a$a  reason: collision with other inner class name */
        class C0056a implements Parcelable.Creator<a> {
            C0056a() {
            }

            /* renamed from: a */
            public a createFromParcel(Parcel in) {
                return new a(in);
            }

            /* renamed from: b */
            public a[] newArray(int size) {
                return new a[size];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.a);
            dest.writeSerializable(this.f4759a);
            dest.writeSerializable(this.f4764b);
            dest.writeSerializable(this.f4765c);
            dest.writeSerializable(this.f4766d);
            dest.writeSerializable(this.f4767e);
            dest.writeSerializable(this.f4768f);
            dest.writeSerializable(this.f4769g);
            dest.writeInt(this.b);
            dest.writeString(this.f4760a);
            dest.writeInt(this.c);
            dest.writeInt(this.d);
            dest.writeInt(this.e);
            CharSequence charSequence = this.f4758a;
            String str = null;
            dest.writeString(charSequence != null ? charSequence.toString() : null);
            CharSequence charSequence2 = this.f4763b;
            if (charSequence2 != null) {
                str = charSequence2.toString();
            }
            dest.writeString(str);
            dest.writeInt(this.f);
            dest.writeSerializable(this.h);
            dest.writeSerializable(this.i);
            dest.writeSerializable(this.j);
            dest.writeSerializable(this.k);
            dest.writeSerializable(this.l);
            dest.writeSerializable(this.m);
            dest.writeSerializable(this.n);
            dest.writeSerializable(this.q);
            dest.writeSerializable(this.o);
            dest.writeSerializable(this.p);
            dest.writeSerializable(this.f4757a);
            dest.writeSerializable(this.f4761a);
            dest.writeSerializable(this.f4762b);
        }
    }
}
