package com.google.android.datatransport.cct.a;

import android.util.SparseArray;

public enum b {
    DEFAULT(0),
    UNMETERED_ONLY(1),
    UNMETERED_OR_DAILY(2),
    FAST_IF_RADIO_AWAKE(3),
    NEVER(4),
    UNRECOGNIZED(-1);
    
    private static final SparseArray<b> zzg = null;

    static {
        b bVar = new b("DEFAULT", 0, 0);
        DEFAULT = bVar;
        b bVar2 = new b("UNMETERED_ONLY", 1, 1);
        UNMETERED_ONLY = bVar2;
        b bVar3 = new b("UNMETERED_OR_DAILY", 2, 2);
        UNMETERED_OR_DAILY = bVar3;
        b bVar4 = new b("FAST_IF_RADIO_AWAKE", 3, 3);
        FAST_IF_RADIO_AWAKE = bVar4;
        b bVar5 = new b("NEVER", 4, 4);
        NEVER = bVar5;
        b bVar6 = new b("UNRECOGNIZED", 5, -1);
        UNRECOGNIZED = bVar6;
        b[] bVarArr = {bVar, bVar2, bVar3, bVar4, bVar5, bVar6};
        SparseArray<b> sparseArray = new SparseArray<>();
        zzg = sparseArray;
        sparseArray.put(0, bVar);
        sparseArray.put(1, bVar2);
        sparseArray.put(2, bVar3);
        sparseArray.put(3, bVar4);
        sparseArray.put(4, bVar5);
        sparseArray.put(-1, bVar6);
    }

    private b(int i) {
    }
}
