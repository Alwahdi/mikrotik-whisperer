package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class g implements DynamiteModule.b {
    g() {
    }

    public final DynamiteModule.b.C0010b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0010b bVar = new DynamiteModule.b.C0010b();
        int a = aVar.a(context, str);
        bVar.a = a;
        if (a != 0) {
            bVar.b = aVar.b(context, str, false);
        } else {
            bVar.b = aVar.b(context, str, true);
        }
        int i = bVar.a;
        if (i == 0 && bVar.b == 0) {
            bVar.c = 0;
        } else if (bVar.b >= i) {
            bVar.c = 1;
        } else {
            bVar.c = -1;
        }
        return bVar;
    }
}
