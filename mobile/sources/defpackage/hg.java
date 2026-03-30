package defpackage;

/* renamed from: hg  reason: default package */
public class hg extends dk {
    i60 a;

    /* renamed from: a  reason: collision with other field name */
    float[] f3160a;

    public hg(i60 pdfDeviceNColor, float[] tints) {
        super(6);
        if (pdfDeviceNColor.b().length == tints.length) {
            this.f3160a = tints;
            return;
        }
        throw new RuntimeException(i10.b("devicen.color.shall.have.the.same.number.of.colorants.as.the.destination.DeviceN.color.space", new Object[0]));
    }

    public i60 k() {
        return this.a;
    }

    public float[] l() {
        return this.f3160a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof hg) || ((hg) obj).f3160a.length != this.f3160a.length) {
            return false;
        }
        int i = 0;
        for (float tint : this.f3160a) {
            if (tint != ((hg) obj).f3160a[i]) {
                return false;
            }
            i++;
        }
        return true;
    }

    public int hashCode() {
        this.a.hashCode();
        throw null;
    }
}
