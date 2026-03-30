package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/* renamed from: bv  reason: default package */
public class bv {
    private int a = -1;

    /* renamed from: a  reason: collision with other field name */
    private cd0 f257a;

    /* renamed from: a  reason: collision with other field name */
    private final SortedMap<Integer, b> f258a = new TreeMap();

    /* renamed from: a  reason: collision with other field name */
    private final SortedSet<b> f259a = new TreeSet();

    /* renamed from: a  reason: collision with other field name */
    private boolean f260a;
    private final SortedMap<Integer, a> b = new TreeMap();

    /* renamed from: b  reason: collision with other field name */
    private boolean f261b;
    private boolean c = false;

    /* renamed from: bv$b */
    public static class b implements Comparable<b> {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public long f264a = -1;

        /* renamed from: a  reason: collision with other field name */
        public boolean f265a = false;

        /* renamed from: a  reason: collision with other field name */
        public byte[] f266a = null;

        /* renamed from: a  reason: collision with other field name */
        public int[] f267a = null;

        /* renamed from: a  reason: collision with other field name */
        public boolean[] f268a = null;
        public int b = -1;

        /* renamed from: b  reason: collision with other field name */
        public boolean f269b = false;

        /* renamed from: b  reason: collision with other field name */
        public byte[] f270b = null;
        public int c = -1;
        public int d = -1;
        public int e = -1;

        public b(int segment_number) {
            this.a = segment_number;
        }

        /* renamed from: a */
        public int compareTo(b s) {
            return this.a - s.a;
        }
    }

    /* renamed from: bv$a */
    public static class a {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        private final bv f262a;

        /* renamed from: a  reason: collision with other field name */
        private final SortedMap<Integer, b> f263a = new TreeMap();
        public int b = -1;
        public int c = -1;

        public a(int page, bv sr) {
            this.a = page;
            this.f262a = sr;
        }

        public byte[] b(boolean for_embedding) {
            int i;
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            for (Integer sn : this.f263a.keySet()) {
                b s = (b) this.f263a.get(sn);
                if (!for_embedding || !((i = s.c) == 51 || i == 49)) {
                    if (for_embedding) {
                        byte[] headerData_emb = bv.a(s.f270b);
                        if (s.f269b) {
                            int i2 = s.e;
                            headerData_emb[i2] = 0;
                            headerData_emb[i2 + 1] = 0;
                            headerData_emb[i2 + 2] = 0;
                            headerData_emb[i2 + 3] = 1;
                        } else {
                            headerData_emb[s.e] = 1;
                        }
                        os.write(headerData_emb);
                    } else {
                        os.write(s.f270b);
                    }
                    os.write(s.f266a);
                }
            }
            os.close();
            return os.toByteArray();
        }

        public void a(b s) {
            this.f263a.put(Integer.valueOf(s.a), s);
        }
    }

    public bv(cd0 ra) {
        this.f257a = ra;
    }

    public static byte[] a(byte[] b2) {
        byte[] bc = new byte[b2.length];
        System.arraycopy(b2, 0, bc, 0, b2.length);
        return bc;
    }

    public void e() {
        b tmp;
        if (!this.c) {
            this.c = true;
            f();
            if (this.f260a) {
                do {
                    b tmp2 = g();
                    h(tmp2);
                    this.f258a.put(Integer.valueOf(tmp2.a), tmp2);
                } while (this.f257a.a() < this.f257a.b());
                return;
            }
            do {
                tmp = g();
                this.f258a.put(Integer.valueOf(tmp.a), tmp);
            } while (tmp.c != 51);
            for (Integer num : this.f258a.keySet()) {
                h((b) this.f258a.get(num));
            }
            return;
        }
        throw new IllegalStateException(i10.b("already.attempted.a.read.on.this.jbig2.file", new Object[0]));
    }

    /* access modifiers changed from: package-private */
    public void h(b s) {
        int ptr = (int) this.f257a.a();
        long j = s.f264a;
        if (j != 4294967295L) {
            byte[] data = new byte[((int) j)];
            this.f257a.read(data);
            s.f266a = data;
            if (s.c == 48) {
                int last = (int) this.f257a.a();
                this.f257a.n((long) ptr);
                int page_bitmap_width = this.f257a.readInt();
                int page_bitmap_height = this.f257a.readInt();
                this.f257a.n((long) last);
                a p = (a) this.b.get(Integer.valueOf(s.b));
                if (p != null) {
                    p.b = page_bitmap_width;
                    p.c = page_bitmap_height;
                    return;
                }
                throw new IllegalStateException(i10.a("referring.to.widht.height.of.page.we.havent.seen.yet.1", s.b));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public b g() {
        int segment_page_association;
        int ptr = (int) this.f257a.a();
        int segment_number = this.f257a.readInt();
        b s = new b(segment_number);
        int segment_header_flags = this.f257a.read();
        boolean deferred_non_retain = (segment_header_flags & 128) == 128;
        s.f265a = deferred_non_retain;
        boolean page_association_size = (segment_header_flags & 64) == 64;
        int segment_type = segment_header_flags & 63;
        s.c = segment_type;
        int referred_to_byte0 = this.f257a.read();
        int i = (referred_to_byte0 & 224) >> 5;
        boolean[] segment_retention_flags = null;
        if (i == 7) {
            cd0 cd0 = this.f257a;
            cd0.n(cd0.a() - 1);
            int count_of_referred_to_segments = this.f257a.readInt() & 536870911;
            boolean[] segment_retention_flags2 = new boolean[(count_of_referred_to_segments + 1)];
            int i2 = 0;
            int referred_to_current_byte = 0;
            while (true) {
                int j = i2 % 8;
                if (j == 0) {
                    referred_to_current_byte = this.f257a.read();
                }
                int segment_header_flags2 = segment_header_flags;
                segment_retention_flags2[i2] = (((1 << j) & referred_to_current_byte) >> j) == 1;
                i2++;
                if (i2 > count_of_referred_to_segments) {
                    break;
                }
                segment_header_flags = segment_header_flags2;
            }
            i = count_of_referred_to_segments;
            segment_retention_flags = segment_retention_flags2;
        } else {
            if (i <= 4) {
                segment_retention_flags = new boolean[(i + 1)];
                int referred_to_byte02 = referred_to_byte0 & 31;
                for (int i3 = 0; i3 <= i; i3++) {
                    segment_retention_flags[i3] = (((1 << i3) & referred_to_byte02) >> i3) == 1;
                }
            } else if (i == 5 || i == 6) {
                int i4 = segment_type;
                throw new IllegalStateException(i10.b("count.of.referred.to.segments.had.bad.value.in.header.for.segment.1.starting.at.2", String.valueOf(segment_number), String.valueOf(ptr)));
            }
        }
        s.f268a = segment_retention_flags;
        s.d = i;
        int[] referred_to_segment_numbers = new int[(i + 1)];
        for (int i5 = 1; i5 <= i; i5++) {
            if (segment_number <= 256) {
                referred_to_segment_numbers[i5] = this.f257a.read();
            } else if (segment_number <= 65536) {
                referred_to_segment_numbers[i5] = this.f257a.readUnsignedShort();
            } else {
                referred_to_segment_numbers[i5] = (int) this.f257a.k();
            }
        }
        s.f267a = referred_to_segment_numbers;
        int page_association_offset = ((int) this.f257a.a()) - ptr;
        if (page_association_size) {
            segment_page_association = this.f257a.readInt();
        } else {
            segment_page_association = this.f257a.read();
        }
        if (segment_page_association >= 0) {
            s.b = segment_page_association;
            s.f269b = page_association_size;
            s.e = page_association_offset;
            if (segment_page_association > 0 && !this.b.containsKey(Integer.valueOf(segment_page_association))) {
                this.b.put(Integer.valueOf(segment_page_association), new a(segment_page_association, this));
            }
            if (segment_page_association > 0) {
                ((a) this.b.get(Integer.valueOf(segment_page_association))).a(s);
            } else {
                this.f259a.add(s);
            }
            s.f264a = this.f257a.k();
            int[] iArr = referred_to_segment_numbers;
            boolean z = deferred_non_retain;
            int end_ptr = (int) this.f257a.a();
            int i6 = page_association_offset;
            int i7 = segment_type;
            this.f257a.n((long) ptr);
            byte[] header_data = new byte[(end_ptr - ptr)];
            this.f257a.read(header_data);
            s.f270b = header_data;
            return s;
        }
        boolean z2 = deferred_non_retain;
        int i8 = page_association_offset;
        int i9 = segment_type;
        throw new IllegalStateException(i10.b("page.1.invalid.for.segment.2.starting.at.3", String.valueOf(segment_page_association), String.valueOf(segment_number), String.valueOf(ptr)));
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f257a.n(0);
        byte[] idstring = new byte[8];
        this.f257a.read(idstring);
        byte[] refidstring = {-105, 74, 66, 50, 13, 10, 26, 10};
        int i = 0;
        while (i < idstring.length) {
            if (idstring[i] == refidstring[i]) {
                i++;
            } else {
                throw new IllegalStateException(i10.a("file.header.idstring.not.good.at.byte.1", i));
            }
        }
        int fileheaderflags = this.f257a.read();
        boolean z = true;
        this.f260a = (fileheaderflags & 1) == 1;
        if ((fileheaderflags & 2) != 0) {
            z = false;
        }
        this.f261b = z;
        if ((fileheaderflags & 252) != 0) {
            throw new IllegalStateException(i10.b("file.header.flags.bits.2.7.not.0", new Object[0]));
        } else if (z) {
            this.a = this.f257a.readInt();
        }
    }

    public int d() {
        return this.b.size();
    }

    public a c(int page) {
        return (a) this.b.get(Integer.valueOf(page));
    }

    public byte[] b(boolean for_embedding) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            for (b s : this.f259a) {
                if (for_embedding) {
                    int i = s.c;
                    if (i != 51) {
                        if (i == 49) {
                        }
                    }
                }
                os.write(s.f270b);
                os.write(s.f266a);
            }
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (os.size() <= 0) {
            return null;
        }
        return os.toByteArray();
    }

    public String toString() {
        if (!this.c) {
            return "Jbig2SegmentReader in indeterminate state.";
        }
        return "Jbig2SegmentReader: number of pages: " + d();
    }
}
