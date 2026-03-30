package defpackage;

import defpackage.f9;
import io.grpc.DecompressorRegistry;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: gf  reason: default package */
public final class gf {
    private static final gf a = a().f(new f9.a(), true).f(f9.b.a, false);

    /* renamed from: a  reason: collision with other field name */
    static final ov f3073a = ov.e(',');

    /* renamed from: a  reason: collision with other field name */
    private final Map<String, a> f3074a;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f3075a;

    public static gf a() {
        return new gf();
    }

    public static gf c() {
        return a;
    }

    public gf f(ff d, boolean advertised) {
        return new gf(d, advertised, this);
    }

    private gf(ff d, boolean advertised, gf parent) {
        String encoding = d.a();
        v90.e(!encoding.contains(","), "Comma is currently not allowed in message encoding");
        int newSize = parent.f3074a.size();
        Map<String, DecompressorRegistry.DecompressorInfo> newDecompressors = new LinkedHashMap<>(!parent.f3074a.containsKey(d.a()) ? newSize + 1 : newSize);
        for (a di : parent.f3074a.values()) {
            String previousEncoding = di.a.a();
            if (!previousEncoding.equals(encoding)) {
                newDecompressors.put(previousEncoding, new a(di.a, di.f3076a));
            }
        }
        newDecompressors.put(encoding, new a(d, advertised));
        this.f3074a = Collections.unmodifiableMap(newDecompressors);
        this.f3075a = f3073a.c(b()).getBytes(Charset.forName("US-ASCII"));
    }

    private gf() {
        this.f3074a = new LinkedHashMap(0);
        this.f3075a = new byte[0];
    }

    /* access modifiers changed from: package-private */
    public byte[] d() {
        return this.f3075a;
    }

    public Set<String> b() {
        Set<String> advertisedDecompressors = new HashSet<>(this.f3074a.size());
        for (Map.Entry<String, DecompressorRegistry.DecompressorInfo> entry : this.f3074a.entrySet()) {
            if (((a) entry.getValue()).f3076a) {
                advertisedDecompressors.add(entry.getKey());
            }
        }
        return Collections.unmodifiableSet(advertisedDecompressors);
    }

    public ff e(String messageEncoding) {
        a info = this.f3074a.get(messageEncoding);
        if (info != null) {
            return info.a;
        }
        return null;
    }

    /* renamed from: gf$a */
    private static final class a {
        final ff a;

        /* renamed from: a  reason: collision with other field name */
        final boolean f3076a;

        a(ff decompressor, boolean advertised) {
            this.a = (ff) v90.o(decompressor, "decompressor");
            this.f3076a = advertised;
        }
    }
}
