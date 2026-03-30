package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class b implements DynamiteModule.b {
    b() {
    }

    public final DynamiteModule.b.C0010b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0010b bVar = new DynamiteModule.b.C0010b();
        int b = aVar.b(context, str, true);
        bVar.b = b;
        if (b != 0) {
            bVar.c = 1;
        } else {
            int a = aVar.a(context, str);
            bVar.a = a;
            if (a != 0) {
                bVar.c = -1;
            }
        }
        return bVar;
    }
}
