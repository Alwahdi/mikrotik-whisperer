package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class f implements DynamiteModule.b {
    f() {
    }

    public final DynamiteModule.b.C0010b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0010b bVar = new DynamiteModule.b.C0010b();
        bVar.a = aVar.a(context, str);
        int b = aVar.b(context, str, true);
        bVar.b = b;
        int i = bVar.a;
        if (i == 0 && b == 0) {
            bVar.c = 0;
        } else if (b >= i) {
            bVar.c = 1;
        } else {
            bVar.c = -1;
        }
        return bVar;
    }
}
