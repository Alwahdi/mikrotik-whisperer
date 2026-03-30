package com.google.firebase.messaging;

import androidx.annotation.Keep;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.Arrays;
import java.util.List;

@Keep
public class FirebaseMessagingRegistrar implements lb {

    private static class b<T> implements cs0<T> {
        private b() {
        }

        public final void a(wi<T> wiVar) {
        }
    }

    public static class a implements fs0 {
        public final <T> cs0<T> a(String str, Class<T> cls, qi qiVar, as0<T, byte[]> as0) {
            return new b();
        }
    }

    @Keep
    public List<cb<?>> getComponents() {
        return Arrays.asList(new cb[]{cb.a(FirebaseMessaging.class).b(cg.g(gl.class)).b(cg.g(FirebaseInstanceId.class)).b(cg.e(fs0.class)).f(f.a).c().d()});
    }
}
