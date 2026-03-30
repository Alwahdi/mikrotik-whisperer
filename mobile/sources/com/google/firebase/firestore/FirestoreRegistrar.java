package com.google.firebase.firestore;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.RestrictTo;
import com.google.firebase.heartbeatinfo.c;
import java.util.Arrays;
import java.util.List;

@Keep
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class FirestoreRegistrar implements lb {
    @Keep
    public List<cb<?>> getComponents() {
        return Arrays.asList(new cb[]{cb.a(k.class).b(cg.g(gl.class)).b(cg.g(Context.class)).b(cg.f(c.class)).b(cg.f(zt0.class)).b(cg.e(cu.class)).f(l.b()).d(), ax.a("fire-fst", "21.4.0")});
    }

    static /* synthetic */ k lambda$getComponents$0(hb c) {
        return new k((Context) c.d(Context.class), (gl) c.d(gl.class), (cu) c.d(cu.class), new vl(c.b(zt0.class), c.b(c.class)));
    }
}
