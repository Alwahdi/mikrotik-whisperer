package com.google.firebase.iid;

import androidx.annotation.Keep;
import com.google.firebase.heartbeatinfo.c;
import java.util.Arrays;
import java.util.List;

@Keep
public final class Registrar implements lb {

    private static class a implements yl {
        private final FirebaseInstanceId a;

        public a(FirebaseInstanceId firebaseInstanceId) {
            this.a = firebaseInstanceId;
        }
    }

    @Keep
    public final List<cb<?>> getComponents() {
        Class<FirebaseInstanceId> cls = FirebaseInstanceId.class;
        return Arrays.asList(new cb[]{cb.a(cls).b(cg.g(gl.class)).b(cg.g(io0.class)).b(cg.g(zt0.class)).b(cg.g(c.class)).f(b.a).c().d(), cb.a(yl.class).b(cg.g(cls)).f(c.a).d(), ax.a("fire-iid", "20.0.2")});
    }
}
