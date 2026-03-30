package com.google.firebase.firestore.remote;

import android.content.Context;
import android.os.Build;
import com.google.firebase.firestore.i;
import com.google.firebase.firestore.remote.j0;
import com.google.firebase.firestore.remote.k0;
import com.google.firebase.firestore.util.c;
import io.grpc.p;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.net.ssl.SSLHandshakeException;

public class i {
    static final Set<String> a = new HashSet(Arrays.asList(new String[]{"date", "x-google-backends", "x-google-netmon-label", "x-google-service", "x-google-gfe-request-trace"}));

    /* renamed from: a  reason: collision with other field name */
    private final a0 f2342a;

    /* renamed from: a  reason: collision with other field name */
    private final n f2343a;

    /* renamed from: a  reason: collision with other field name */
    private final c f2344a;

    /* renamed from: a  reason: collision with other field name */
    private final we f2345a;

    public i(we databaseInfo, c workerQueue, vd credentialsProvider, Context context, gq metadataProvider) {
        this.f2345a = databaseInfo;
        this.f2344a = workerQueue;
        this.f2342a = new a0(databaseInfo.a());
        this.f2343a = new n(workerQueue, context, credentialsProvider, databaseInfo, metadataProvider);
    }

    /* access modifiers changed from: package-private */
    public j0 a(j0.a listener) {
        return new j0(this.f2343a, this.f2344a, this.f2342a, listener);
    }

    /* access modifiers changed from: package-private */
    public k0 b(k0.a listener) {
        return new k0(this.f2343a, this.f2344a, this.f2342a, listener);
    }

    public static boolean e(p status) {
        return d(i.a.fromValue(status.m().value()));
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[i.a.values().length];
            a = iArr;
            try {
                iArr[i.a.OK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[i.a.CANCELLED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[i.a.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[i.a.DEADLINE_EXCEEDED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[i.a.RESOURCE_EXHAUSTED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[i.a.INTERNAL.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[i.a.UNAVAILABLE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                a[i.a.UNAUTHENTICATED.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                a[i.a.INVALID_ARGUMENT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                a[i.a.NOT_FOUND.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                a[i.a.ALREADY_EXISTS.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                a[i.a.PERMISSION_DENIED.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                a[i.a.FAILED_PRECONDITION.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                a[i.a.ABORTED.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                a[i.a.OUT_OF_RANGE.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                a[i.a.UNIMPLEMENTED.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                a[i.a.DATA_LOSS.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
        }
    }

    public static boolean d(i.a code) {
        switch (a.a[code.ordinal()]) {
            case 1:
                throw new IllegalArgumentException("Treated status OK as error");
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return false;
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                return true;
            default:
                throw new IllegalArgumentException("Unknown gRPC status code: " + code);
        }
    }

    public static boolean c(p status) {
        p.b code = status.m();
        Throwable t = status.l();
        boolean hasCipherError = false;
        if ((t instanceof SSLHandshakeException) && t.getMessage().contains("no ciphers available")) {
            hasCipherError = true;
        }
        return Build.VERSION.SDK_INT < 21 && code.equals(p.b.UNAVAILABLE) && hasCipherError;
    }

    public static boolean f(p status) {
        return e(status) && !status.m().equals(p.b.ABORTED);
    }
}
