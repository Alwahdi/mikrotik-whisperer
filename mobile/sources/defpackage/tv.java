package defpackage;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* renamed from: tv  reason: default package */
public final class tv {
    private static final b a = new b((a) null);

    /* renamed from: a  reason: collision with other field name */
    private static final uu0<String> f5173a = rv.b();
    private static final uu0<Boolean> b = sv.b();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Map<Class<?>, y30<?>> f5174a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public final Map<Class<?>, uu0<?>> f5175b = new HashMap();

    /* renamed from: tv$b */
    private static final class b implements uu0<Date> {
        private static final DateFormat a;

        private b() {
        }

        /* synthetic */ b(a x0) {
            this();
        }

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        /* renamed from: b */
        public void a(Date o, vu0 ctx) {
            ctx.a(a.format(o));
        }
    }

    public tv() {
        g(String.class, f5173a);
        g(Boolean.class, b);
        g(Date.class, a);
    }

    public <T> tv f(Class<T> clazz, y30<? super T> objectEncoder) {
        if (!this.f5174a.containsKey(clazz)) {
            this.f5174a.put(clazz, objectEncoder);
            return this;
        }
        throw new IllegalArgumentException("Encoder already registered for " + clazz.getName());
    }

    public <T> tv g(Class<T> clazz, uu0<? super T> encoder) {
        if (!this.f5175b.containsKey(clazz)) {
            this.f5175b.put(clazz, encoder);
            return this;
        }
        throw new IllegalArgumentException("Encoder already registered for " + clazz.getName());
    }

    /* renamed from: tv$a */
    class a implements pe {
        a() {
        }

        public void a(Object o, Writer writer) {
            wv encoderContext = new wv(writer, tv.this.f5174a, tv.this.f5175b);
            encoderContext.h(o);
            encoderContext.o();
        }

        public String b(Object o) {
            StringWriter stringWriter = new StringWriter();
            try {
                a(o, stringWriter);
            } catch (IOException e) {
            }
            return stringWriter.toString();
        }
    }

    public pe c() {
        return new a();
    }
}
