package defpackage;

import java.util.HashMap;

/* renamed from: z70  reason: default package */
public class z70 extends j60 {
    public static final k70 a = new k70(0);

    /* renamed from: a  reason: collision with other field name */
    private static final h70[] f6006a = {h70.Q1, h70.qc, h70.N, h70.r0};

    /* renamed from: a  reason: collision with other field name */
    private static final String[] f6007a = {"crop", "trim", "art", "bleed"};
    public static final k70 b = new k70(90);
    public static final k70 c = new k70(180);
    public static final k70 d = new k70(270);

    /* renamed from: a  reason: collision with other field name */
    f80 f6008a;

    z70(f80 mediaBox, HashMap<String, f80> boxSize, j60 resources, int rotate) {
        super(j60.d);
        this.f6008a = mediaBox;
        if (mediaBox == null || (mediaBox.b0() <= 14400.0f && mediaBox.W() <= 14400.0f)) {
            Q(h70.Q6, mediaBox);
            Q(h70.N9, resources);
            if (rotate != 0) {
                Q(h70.ka, new k70(rotate));
            }
            int k = 0;
            while (true) {
                String[] strArr = f6007a;
                if (k < strArr.length) {
                    o70 rect = boxSize.get(strArr[k]);
                    if (rect != null) {
                        Q(f6006a[k], rect);
                    }
                    k++;
                } else {
                    return;
                }
            }
        } else {
            throw new ih(i10.b("the.page.size.must.be.smaller.than.14400.by.14400.its.1.by.2", Float.valueOf(mediaBox.b0()), Float.valueOf(mediaBox.W())));
        }
    }

    /* access modifiers changed from: package-private */
    public void T(z60 contents) {
        Q(h70.E1, contents);
    }
}
