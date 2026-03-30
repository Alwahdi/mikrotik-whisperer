package defpackage;

import java.util.Arrays;

/* renamed from: xj0  reason: default package */
final class xj0 extends a7 {
    final transient int[] a;

    /* renamed from: a  reason: collision with other field name */
    final transient byte[][] f5746a;

    xj0(r6 buffer, int byteCount) {
        super((byte[]) null);
        su0.b(buffer.f4882a, 0, (long) byteCount);
        int offset = 0;
        int segmentCount = 0;
        vj0 s = buffer.f4883a;
        while (offset < byteCount) {
            int i = s.b;
            int i2 = s.a;
            if (i != i2) {
                offset += i - i2;
                segmentCount++;
                s = s.f5387a;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f5746a = new byte[segmentCount][];
        this.a = new int[(segmentCount * 2)];
        int offset2 = 0;
        int segmentCount2 = 0;
        vj0 s2 = buffer.f4883a;
        while (offset2 < byteCount) {
            byte[][] bArr = this.f5746a;
            bArr[segmentCount2] = s2.f5389a;
            int i3 = s2.b;
            int i4 = s2.a;
            offset2 += i3 - i4;
            if (offset2 > byteCount) {
                offset2 = byteCount;
            }
            int[] iArr = this.a;
            iArr[segmentCount2] = offset2;
            iArr[bArr.length + segmentCount2] = i4;
            s2.f5388a = true;
            segmentCount2++;
            s2 = s2.f5387a;
        }
    }

    public String s() {
        return v().s();
    }

    public String a() {
        return v().a();
    }

    public String h() {
        return v().h();
    }

    public a7 q() {
        return v().q();
    }

    public a7 p(int beginIndex, int endIndex) {
        return v().p(beginIndex, endIndex);
    }

    public byte e(int pos) {
        su0.b((long) this.a[this.f5746a.length - 1], (long) pos, 1);
        int segment = u(pos);
        int segmentOffset = segment == 0 ? 0 : this.a[segment - 1];
        int[] iArr = this.a;
        byte[][] bArr = this.f5746a;
        return bArr[segment][(pos - segmentOffset) + iArr[bArr.length + segment]];
    }

    private int u(int pos) {
        int i = Arrays.binarySearch(this.a, 0, this.f5746a.length, pos + 1);
        return i >= 0 ? i : ~i;
    }

    public int l() {
        return this.a[this.f5746a.length - 1];
    }

    public byte[] r() {
        int[] iArr = this.a;
        byte[][] bArr = this.f5746a;
        byte[] result = new byte[iArr[bArr.length - 1]];
        int segmentOffset = 0;
        int segmentCount = bArr.length;
        for (int s = 0; s < segmentCount; s++) {
            int[] iArr2 = this.a;
            int segmentPos = iArr2[segmentCount + s];
            int nextSegmentOffset = iArr2[s];
            System.arraycopy(this.f5746a[s], segmentPos, result, segmentOffset, nextSegmentOffset - segmentOffset);
            segmentOffset = nextSegmentOffset;
        }
        return result;
    }

    /* access modifiers changed from: package-private */
    public void t(r6 buffer) {
        int segmentOffset = 0;
        int segmentCount = this.f5746a.length;
        for (int s = 0; s < segmentCount; s++) {
            int[] iArr = this.a;
            int segmentPos = iArr[segmentCount + s];
            int nextSegmentOffset = iArr[s];
            vj0 segment = new vj0(this.f5746a[s], segmentPos, (segmentPos + nextSegmentOffset) - segmentOffset);
            vj0 vj0 = buffer.f4883a;
            if (vj0 == null) {
                segment.f5390b = segment;
                segment.f5387a = segment;
                buffer.f4883a = segment;
            } else {
                vj0.f5390b.c(segment);
            }
            segmentOffset = nextSegmentOffset;
        }
        buffer.f4882a += (long) segmentOffset;
    }

    public boolean j(int offset, a7 other, int otherOffset, int byteCount) {
        if (offset < 0 || offset > l() - byteCount) {
            return false;
        }
        int s = u(offset);
        while (byteCount > 0) {
            int segmentOffset = s == 0 ? 0 : this.a[s - 1];
            int stepSize = Math.min(byteCount, (segmentOffset + (this.a[s] - segmentOffset)) - offset);
            int[] iArr = this.a;
            byte[][] bArr = this.f5746a;
            if (!other.k(otherOffset, bArr[s], (offset - segmentOffset) + iArr[bArr.length + s], stepSize)) {
                return false;
            }
            offset += stepSize;
            otherOffset += stepSize;
            byteCount -= stepSize;
            s++;
        }
        return true;
    }

    public boolean k(int offset, byte[] other, int otherOffset, int byteCount) {
        if (offset < 0 || offset > l() - byteCount || otherOffset < 0 || otherOffset > other.length - byteCount) {
            return false;
        }
        int s = u(offset);
        while (byteCount > 0) {
            int segmentOffset = s == 0 ? 0 : this.a[s - 1];
            int stepSize = Math.min(byteCount, (segmentOffset + (this.a[s] - segmentOffset)) - offset);
            int[] iArr = this.a;
            byte[][] bArr = this.f5746a;
            if (!su0.a(bArr[s], (offset - segmentOffset) + iArr[bArr.length + s], other, otherOffset, stepSize)) {
                return false;
            }
            offset += stepSize;
            otherOffset += stepSize;
            byteCount -= stepSize;
            s++;
        }
        return true;
    }

    private a7 v() {
        return new a7(r());
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof a7) || ((a7) o).l() != l() || !j(0, (a7) o, 0, l())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int result = this.f26a;
        if (result != 0) {
            return result;
        }
        int result2 = 1;
        int segmentOffset = 0;
        int segmentCount = this.f5746a.length;
        for (int s = 0; s < segmentCount; s++) {
            byte[] segment = this.f5746a[s];
            int[] iArr = this.a;
            int segmentPos = iArr[segmentCount + s];
            int nextSegmentOffset = iArr[s];
            int limit = segmentPos + (nextSegmentOffset - segmentOffset);
            for (int i = segmentPos; i < limit; i++) {
                result2 = (result2 * 31) + segment[i];
            }
            segmentOffset = nextSegmentOffset;
        }
        this.f26a = result2;
        return result2;
    }

    public String toString() {
        return v().toString();
    }
}
