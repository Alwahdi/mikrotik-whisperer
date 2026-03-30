package defpackage;

import io.grpc.okhttp.internal.framed.Header;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.ClientCookie;

/* renamed from: vq  reason: default package */
abstract class vq {
    /* access modifiers changed from: private */
    public static final a7 a = a7.d(":");
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public static final Map<a7, Integer> f5407a = f();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public static final pq[] f5408a;

    static {
        a7 a7Var = pq.d;
        a7 a7Var2 = pq.e;
        a7 a7Var3 = pq.f;
        a7 a7Var4 = pq.c;
        f5408a = new pq[]{new pq(pq.g, ""), new pq(a7Var, (String) HttpGet.METHOD_NAME), new pq(a7Var, (String) HttpPost.METHOD_NAME), new pq(a7Var2, "/"), new pq(a7Var2, "/index.html"), new pq(a7Var3, (String) HttpHost.DEFAULT_SCHEME_NAME), new pq(a7Var3, "https"), new pq(a7Var4, "200"), new pq(a7Var4, "204"), new pq(a7Var4, "206"), new pq(a7Var4, "304"), new pq(a7Var4, "400"), new pq(a7Var4, "404"), new pq(a7Var4, "500"), new pq("accept-charset", ""), new pq("accept-encoding", "gzip, deflate"), new pq("accept-language", ""), new pq("accept-ranges", ""), new pq("accept", ""), new pq("access-control-allow-origin", ""), new pq("age", ""), new pq("allow", ""), new pq("authorization", ""), new pq("cache-control", ""), new pq("content-disposition", ""), new pq("content-encoding", ""), new pq("content-language", ""), new pq("content-length", ""), new pq("content-location", ""), new pq("content-range", ""), new pq("content-type", ""), new pq("cookie", ""), new pq("date", ""), new pq("etag", ""), new pq("expect", ""), new pq((String) ClientCookie.EXPIRES_ATTR, ""), new pq("from", ""), new pq("host", ""), new pq("if-match", ""), new pq("if-modified-since", ""), new pq("if-none-match", ""), new pq("if-range", ""), new pq("if-unmodified-since", ""), new pq("last-modified", ""), new pq("link", ""), new pq("location", ""), new pq("max-forwards", ""), new pq("proxy-authenticate", ""), new pq("proxy-authorization", ""), new pq("range", ""), new pq("referer", ""), new pq("refresh", ""), new pq("retry-after", ""), new pq("server", ""), new pq("set-cookie", ""), new pq("strict-transport-security", ""), new pq("transfer-encoding", ""), new pq("user-agent", ""), new pq("vary", ""), new pq("via", ""), new pq("www-authenticate", "")};
    }

    /* renamed from: vq$a */
    static final class a {
        private int a;

        /* renamed from: a  reason: collision with other field name */
        private final List<pq> f5409a;

        /* renamed from: a  reason: collision with other field name */
        private final t6 f5410a;

        /* renamed from: a  reason: collision with other field name */
        pq[] f5411a;
        private int b;
        int c;
        int d;
        int e;

        a(int headerTableSizeSetting, jm0 source) {
            this(headerTableSizeSetting, headerTableSizeSetting, source);
        }

        a(int headerTableSizeSetting, int maxDynamicTableByteCount, jm0 source) {
            this.f5409a = new ArrayList();
            pq[] pqVarArr = new pq[8];
            this.f5411a = pqVarArr;
            this.c = pqVarArr.length - 1;
            this.d = 0;
            this.e = 0;
            this.a = headerTableSizeSetting;
            this.b = maxDynamicTableByteCount;
            this.f5410a = l40.b(source);
        }

        /* access modifiers changed from: package-private */
        public void g(int headerTableSizeSetting) {
            this.a = headerTableSizeSetting;
            this.b = headerTableSizeSetting;
            a();
        }

        private void a() {
            int i = this.b;
            int i2 = this.e;
            if (i >= i2) {
                return;
            }
            if (i == 0) {
                b();
            } else {
                d(i2 - i);
            }
        }

        private void b() {
            Arrays.fill(this.f5411a, (Object) null);
            this.c = this.f5411a.length - 1;
            this.d = 0;
            this.e = 0;
        }

        private int d(int bytesToRecover) {
            int i;
            int entriesToEvict = 0;
            if (bytesToRecover > 0) {
                int j = this.f5411a.length;
                while (true) {
                    j--;
                    i = this.c;
                    if (j < i || bytesToRecover <= 0) {
                        pq[] pqVarArr = this.f5411a;
                        System.arraycopy(pqVarArr, i + 1, pqVarArr, i + 1 + entriesToEvict, this.d);
                        this.c += entriesToEvict;
                    } else {
                        pq[] pqVarArr2 = this.f5411a;
                        bytesToRecover -= pqVarArr2[j].a;
                        this.e -= pqVarArr2[j].a;
                        this.d--;
                        entriesToEvict++;
                    }
                }
                pq[] pqVarArr3 = this.f5411a;
                System.arraycopy(pqVarArr3, i + 1, pqVarArr3, i + 1 + entriesToEvict, this.d);
                this.c += entriesToEvict;
            }
            return entriesToEvict;
        }

        /* access modifiers changed from: package-private */
        public void l() {
            while (!this.f5410a.F()) {
                int b2 = this.f5410a.readByte() & 255;
                if (b2 == 128) {
                    throw new IOException("index == 0");
                } else if ((b2 & 128) == 128) {
                    m(n(b2, 127) - 1);
                } else if (b2 == 64) {
                    p();
                } else if ((b2 & 64) == 64) {
                    o(n(b2, 63) - 1);
                } else if ((b2 & 32) == 32) {
                    int n = n(b2, 31);
                    this.b = n;
                    if (n < 0 || n > this.a) {
                        throw new IOException("Invalid dynamic table size update " + this.b);
                    }
                    a();
                } else if (b2 == 16 || b2 == 0) {
                    r();
                } else {
                    q(n(b2, 15) - 1);
                }
            }
        }

        public List<pq> e() {
            List<Header> result = new ArrayList<>(this.f5409a);
            this.f5409a.clear();
            return result;
        }

        private void m(int index) {
            if (i(index)) {
                this.f5409a.add(vq.f5408a[index]);
                return;
            }
            int dynamicTableIndex = c(index - vq.f5408a.length);
            if (dynamicTableIndex >= 0) {
                pq[] pqVarArr = this.f5411a;
                if (dynamicTableIndex <= pqVarArr.length - 1) {
                    this.f5409a.add(pqVarArr[dynamicTableIndex]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (index + 1));
        }

        private int c(int index) {
            return this.c + 1 + index;
        }

        private void q(int index) {
            this.f5409a.add(new pq(f(index), k()));
        }

        private void r() {
            this.f5409a.add(new pq(vq.e(k()), k()));
        }

        private void o(int nameIndex) {
            h(-1, new pq(f(nameIndex), k()));
        }

        private void p() {
            h(-1, new pq(vq.e(k()), k()));
        }

        private a7 f(int index) {
            if (i(index)) {
                return vq.f5408a[index].f4727a;
            }
            int dynamicTableIndex = c(index - vq.f5408a.length);
            if (dynamicTableIndex >= 0) {
                pq[] pqVarArr = this.f5411a;
                if (dynamicTableIndex < pqVarArr.length) {
                    return pqVarArr[dynamicTableIndex].f4727a;
                }
            }
            throw new IOException("Header index too large " + (index + 1));
        }

        private boolean i(int index) {
            return index >= 0 && index <= vq.f5408a.length - 1;
        }

        private void h(int index, pq entry) {
            this.f5409a.add(entry);
            int delta = entry.a;
            if (index != -1) {
                delta -= this.f5411a[c(index)].a;
            }
            int i = this.b;
            if (delta > i) {
                b();
                return;
            }
            int entriesEvicted = d((this.e + delta) - i);
            if (index == -1) {
                int i2 = this.d + 1;
                pq[] pqVarArr = this.f5411a;
                if (i2 > pqVarArr.length) {
                    pq[] doubled = new pq[(pqVarArr.length * 2)];
                    System.arraycopy(pqVarArr, 0, doubled, pqVarArr.length, pqVarArr.length);
                    this.c = this.f5411a.length - 1;
                    this.f5411a = doubled;
                }
                int index2 = this.c;
                this.c = index2 - 1;
                this.f5411a[index2] = entry;
                this.d++;
            } else {
                this.f5411a[index + c(index) + entriesEvicted] = entry;
            }
            this.e += delta;
        }

        private int j() {
            return this.f5410a.readByte() & 255;
        }

        /* access modifiers changed from: package-private */
        public int n(int firstByte, int prefixMask) {
            int prefix = firstByte & prefixMask;
            if (prefix < prefixMask) {
                return prefix;
            }
            int result = prefixMask;
            int shift = 0;
            while (true) {
                int b2 = j();
                if ((b2 & 128) == 0) {
                    return result + (b2 << shift);
                }
                result += (b2 & 127) << shift;
                shift += 7;
            }
        }

        /* access modifiers changed from: package-private */
        public a7 k() {
            int firstByte = j();
            boolean huffmanDecode = (firstByte & 128) == 128;
            int length = n(firstByte, 127);
            if (huffmanDecode) {
                return a7.i(zq.f().c(this.f5410a.N((long) length)));
            }
            return this.f5410a.n((long) length);
        }
    }

    private static Map<a7, Integer> f() {
        Map<ByteString, Integer> result = new LinkedHashMap<>(f5408a.length);
        int i = 0;
        while (true) {
            pq[] pqVarArr = f5408a;
            if (i >= pqVarArr.length) {
                return Collections.unmodifiableMap(result);
            }
            if (!result.containsKey(pqVarArr[i].f4727a)) {
                result.put(pqVarArr[i].f4727a, Integer.valueOf(i));
            }
            i++;
        }
    }

    /* renamed from: vq$b */
    static final class b {
        int a;

        /* renamed from: a  reason: collision with other field name */
        private final r6 f5412a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f5413a;

        /* renamed from: a  reason: collision with other field name */
        pq[] f5414a;
        private int b;

        /* renamed from: b  reason: collision with other field name */
        private boolean f5415b;
        private int c;
        int d;
        private int e;
        private int f;

        b(r6 out) {
            this(4096, false, out);
        }

        b(int headerTableSizeSetting, boolean useCompression, r6 out) {
            this.b = Integer.MAX_VALUE;
            pq[] pqVarArr = new pq[8];
            this.f5414a = pqVarArr;
            this.e = pqVarArr.length - 1;
            this.a = headerTableSizeSetting;
            this.c = headerTableSizeSetting;
            this.f5413a = useCompression;
            this.f5412a = out;
        }

        /* access modifiers changed from: package-private */
        public void e(List<pq> headerBlock) {
            if (this.f5415b) {
                int i = this.b;
                if (i < this.c) {
                    f(i, 31, 32);
                }
                this.f5415b = false;
                this.b = Integer.MAX_VALUE;
                f(this.c, 31, 32);
            }
            int size = headerBlock.size();
            for (int i2 = 0; i2 < size; i2++) {
                pq header = headerBlock.get(i2);
                a7 name = header.f4727a.q();
                a7 value = header.b;
                int headerIndex = -1;
                int headerNameIndex = -1;
                Integer staticIndex = (Integer) vq.f5407a.get(name);
                if (staticIndex != null && (headerNameIndex = staticIndex.intValue() + 1) >= 2 && headerNameIndex <= 7) {
                    if (vq.f5408a[headerNameIndex - 1].b.equals(value)) {
                        headerIndex = headerNameIndex;
                    } else if (vq.f5408a[headerNameIndex].b.equals(value)) {
                        headerIndex = headerNameIndex + 1;
                    }
                }
                if (headerIndex == -1) {
                    int j = this.e;
                    while (true) {
                        j++;
                        pq[] pqVarArr = this.f5414a;
                        if (j >= pqVarArr.length) {
                            break;
                        } else if (pqVarArr[j].f4727a.equals(name)) {
                            if (this.f5414a[j].b.equals(value)) {
                                headerIndex = (j - this.e) + vq.f5408a.length;
                                break;
                            } else if (headerNameIndex == -1) {
                                headerNameIndex = (j - this.e) + vq.f5408a.length;
                            }
                        }
                    }
                }
                if (headerIndex != -1) {
                    f(headerIndex, 127, 128);
                } else if (headerNameIndex == -1) {
                    this.f5412a.I(64);
                    d(name);
                    d(value);
                    c(header);
                } else if (!name.o(vq.a) || pq.g.equals(name)) {
                    f(headerNameIndex, 63, 64);
                    d(value);
                    c(header);
                } else {
                    f(headerNameIndex, 15, 0);
                    d(value);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void f(int value, int prefixMask, int bits) {
            if (value < prefixMask) {
                this.f5412a.I(bits | value);
                return;
            }
            this.f5412a.I(bits | prefixMask);
            int value2 = value - prefixMask;
            while (value2 >= 128) {
                this.f5412a.I((value2 & 127) | 128);
                value2 >>>= 7;
            }
            this.f5412a.I(value2);
        }

        /* access modifiers changed from: package-private */
        public void d(a7 data) {
            if (!this.f5413a || zq.f().e(data.r()) >= data.l()) {
                f(data.l(), 127, 0);
                this.f5412a.k0(data);
                return;
            }
            r6 huffmanBuffer = new r6();
            zq.f().d(data.r(), huffmanBuffer.V());
            a7 huffmanBytes = huffmanBuffer.Y();
            f(huffmanBytes.l(), 127, 128);
            this.f5412a.k0(huffmanBytes);
        }

        private void a() {
            Arrays.fill(this.f5414a, (Object) null);
            this.e = this.f5414a.length - 1;
            this.d = 0;
            this.f = 0;
        }

        private int b(int bytesToRecover) {
            int i;
            int entriesToEvict = 0;
            if (bytesToRecover > 0) {
                int j = this.f5414a.length;
                while (true) {
                    j--;
                    i = this.e;
                    if (j < i || bytesToRecover <= 0) {
                        pq[] pqVarArr = this.f5414a;
                        System.arraycopy(pqVarArr, i + 1, pqVarArr, i + 1 + entriesToEvict, this.d);
                        this.e += entriesToEvict;
                    } else {
                        pq[] pqVarArr2 = this.f5414a;
                        bytesToRecover -= pqVarArr2[j].a;
                        this.f -= pqVarArr2[j].a;
                        this.d--;
                        entriesToEvict++;
                    }
                }
                pq[] pqVarArr3 = this.f5414a;
                System.arraycopy(pqVarArr3, i + 1, pqVarArr3, i + 1 + entriesToEvict, this.d);
                this.e += entriesToEvict;
            }
            return entriesToEvict;
        }

        private void c(pq entry) {
            int delta = entry.a;
            int i = this.c;
            if (delta > i) {
                a();
                return;
            }
            b((this.f + delta) - i);
            int i2 = this.d + 1;
            pq[] pqVarArr = this.f5414a;
            if (i2 > pqVarArr.length) {
                pq[] doubled = new pq[(pqVarArr.length * 2)];
                System.arraycopy(pqVarArr, 0, doubled, pqVarArr.length, pqVarArr.length);
                this.e = this.f5414a.length - 1;
                this.f5414a = doubled;
            }
            int index = this.e;
            this.e = index - 1;
            this.f5414a[index] = entry;
            this.d++;
            this.f += delta;
        }
    }

    /* access modifiers changed from: private */
    public static a7 e(a7 name) {
        int i = 0;
        int length = name.l();
        while (i < length) {
            byte c = name.e(i);
            if (c < 65 || c > 90) {
                i++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + name.s());
            }
        }
        return name;
    }
}
