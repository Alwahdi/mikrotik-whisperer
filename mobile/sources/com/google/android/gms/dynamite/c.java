package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class c implements DynamiteModule.b {
    c() {
    }

    public final DynamiteModule.b.C0010b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0010b bVar = new DynamiteModule.b.C0010b();
        int a = aVar.a(context, str);
        bVar.a = a;
        if (a != 0) {
            bVar.c = -1;
        } else {
            int b = aVar.b(context, str, true);
            bVar.b = b;
            if (b != 0) {
                bVar.c = 1;
            }
        }
        return bVar;
    }
}
