package com.google.android.datatransport.cct.a;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.a.i;

public abstract class s {

    public static abstract class a {
        public abstract a a(b bVar);

        public abstract a b(c cVar);

        public abstract s c();
    }

    public enum b {
        UNKNOWN_MOBILE_SUBTYPE(0),
        GPRS(1),
        EDGE(2),
        UMTS(3),
        CDMA(4),
        EVDO_0(5),
        EVDO_A(6),
        RTT(7),
        HSDPA(8),
        HSUPA(9),
        HSPA(10),
        IDEN(11),
        EVDO_B(12),
        LTE(13),
        EHRPD(14),
        HSPAP(15),
        GSM(16),
        TD_SCDMA(17),
        IWLAN(18),
        LTE_CA(19),
        COMBINED(100);
        
        private static final SparseArray<b> zzv = null;
        private final int zzw;

        static {
            b bVar = new b("UNKNOWN_MOBILE_SUBTYPE", 0, 0);
            UNKNOWN_MOBILE_SUBTYPE = bVar;
            b bVar2 = new b("GPRS", 1, 1);
            GPRS = bVar2;
            b bVar3 = new b("EDGE", 2, 2);
            EDGE = bVar3;
            b bVar4 = new b("UMTS", 3, 3);
            UMTS = bVar4;
            b bVar5 = new b("CDMA", 4, 4);
            CDMA = bVar5;
            b bVar6 = new b("EVDO_0", 5, 5);
            EVDO_0 = bVar6;
            b bVar7 = new b("EVDO_A", 6, 6);
            EVDO_A = bVar7;
            b bVar8 = new b("RTT", 7, 7);
            RTT = bVar8;
            b bVar9 = new b("HSDPA", 8, 8);
            HSDPA = bVar9;
            b bVar10 = new b("HSUPA", 9, 9);
            HSUPA = bVar10;
            b bVar11 = new b("HSPA", 10, 10);
            HSPA = bVar11;
            b bVar12 = new b("IDEN", 11, 11);
            IDEN = bVar12;
            b bVar13 = new b("EVDO_B", 12, 12);
            EVDO_B = bVar13;
            b bVar14 = new b("LTE", 13, 13);
            LTE = bVar14;
            b bVar15 = bVar14;
            b bVar16 = new b("EHRPD", 14, 14);
            EHRPD = bVar16;
            b bVar17 = bVar16;
            b bVar18 = new b("HSPAP", 15, 15);
            HSPAP = bVar18;
            b bVar19 = bVar18;
            b bVar20 = new b("GSM", 16, 16);
            GSM = bVar20;
            b bVar21 = bVar20;
            b bVar22 = new b("TD_SCDMA", 17, 17);
            TD_SCDMA = bVar22;
            b bVar23 = bVar22;
            b bVar24 = new b("IWLAN", 18, 18);
            IWLAN = bVar24;
            b bVar25 = bVar24;
            b bVar26 = new b("LTE_CA", 19, 19);
            LTE_CA = bVar26;
            b bVar27 = bVar26;
            b bVar28 = bVar13;
            b bVar29 = new b("COMBINED", 20, 100);
            COMBINED = bVar29;
            b[] bVarArr = {bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, bVar9, bVar10, bVar11, bVar12, bVar28, bVar15, bVar17, bVar19, bVar21, bVar23, bVar25, bVar27, bVar29};
            SparseArray<b> sparseArray = new SparseArray<>();
            zzv = sparseArray;
            sparseArray.put(0, bVar);
            sparseArray.put(1, bVar2);
            sparseArray.put(2, bVar3);
            sparseArray.put(3, bVar4);
            sparseArray.put(4, bVar5);
            sparseArray.put(5, bVar6);
            sparseArray.put(6, bVar7);
            sparseArray.put(7, bVar8);
            sparseArray.put(8, bVar9);
            sparseArray.put(9, bVar10);
            sparseArray.put(10, bVar11);
            sparseArray.put(11, bVar12);
            sparseArray.put(12, bVar28);
            sparseArray.put(13, bVar15);
            sparseArray.put(14, bVar17);
            sparseArray.put(15, bVar19);
            sparseArray.put(16, bVar21);
            sparseArray.put(17, bVar23);
            sparseArray.put(18, bVar25);
            sparseArray.put(19, bVar27);
        }

        private b(int i) {
            this.zzw = i;
        }

        public int zza() {
            return this.zzw;
        }

        @Nullable
        public static b zza(int i) {
            return zzv.get(i);
        }
    }

    public enum c {
        MOBILE(0),
        WIFI(1),
        MOBILE_MMS(2),
        MOBILE_SUPL(3),
        MOBILE_DUN(4),
        MOBILE_HIPRI(5),
        WIMAX(6),
        BLUETOOTH(7),
        DUMMY(8),
        ETHERNET(9),
        MOBILE_FOTA(10),
        MOBILE_IMS(11),
        MOBILE_CBS(12),
        WIFI_P2P(13),
        MOBILE_IA(14),
        MOBILE_EMERGENCY(15),
        PROXY(16),
        VPN(17),
        NONE(-1);
        
        private static final SparseArray<c> zzt = null;
        private final int zzu;

        static {
            c cVar = new c("MOBILE", 0, 0);
            MOBILE = cVar;
            c cVar2 = new c("WIFI", 1, 1);
            WIFI = cVar2;
            c cVar3 = new c("MOBILE_MMS", 2, 2);
            MOBILE_MMS = cVar3;
            c cVar4 = new c("MOBILE_SUPL", 3, 3);
            MOBILE_SUPL = cVar4;
            c cVar5 = new c("MOBILE_DUN", 4, 4);
            MOBILE_DUN = cVar5;
            c cVar6 = new c("MOBILE_HIPRI", 5, 5);
            MOBILE_HIPRI = cVar6;
            c cVar7 = new c("WIMAX", 6, 6);
            WIMAX = cVar7;
            c cVar8 = new c("BLUETOOTH", 7, 7);
            BLUETOOTH = cVar8;
            c cVar9 = new c("DUMMY", 8, 8);
            DUMMY = cVar9;
            c cVar10 = new c("ETHERNET", 9, 9);
            ETHERNET = cVar10;
            c cVar11 = new c("MOBILE_FOTA", 10, 10);
            MOBILE_FOTA = cVar11;
            c cVar12 = new c("MOBILE_IMS", 11, 11);
            MOBILE_IMS = cVar12;
            c cVar13 = new c("MOBILE_CBS", 12, 12);
            MOBILE_CBS = cVar13;
            c cVar14 = new c("WIFI_P2P", 13, 13);
            WIFI_P2P = cVar14;
            c cVar15 = cVar14;
            c cVar16 = new c("MOBILE_IA", 14, 14);
            MOBILE_IA = cVar16;
            c cVar17 = cVar16;
            c cVar18 = new c("MOBILE_EMERGENCY", 15, 15);
            MOBILE_EMERGENCY = cVar18;
            c cVar19 = cVar18;
            c cVar20 = new c("PROXY", 16, 16);
            PROXY = cVar20;
            c cVar21 = cVar20;
            c cVar22 = new c("VPN", 17, 17);
            VPN = cVar22;
            c cVar23 = cVar22;
            c cVar24 = cVar13;
            c cVar25 = new c("NONE", 18, -1);
            NONE = cVar25;
            c[] cVarArr = {cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7, cVar8, cVar9, cVar10, cVar11, cVar12, cVar24, cVar15, cVar17, cVar19, cVar21, cVar23, cVar25};
            SparseArray<c> sparseArray = new SparseArray<>();
            zzt = sparseArray;
            sparseArray.put(0, cVar);
            sparseArray.put(1, cVar2);
            sparseArray.put(2, cVar3);
            sparseArray.put(3, cVar4);
            sparseArray.put(4, cVar5);
            sparseArray.put(5, cVar6);
            sparseArray.put(6, cVar7);
            sparseArray.put(7, cVar8);
            sparseArray.put(8, cVar9);
            sparseArray.put(9, cVar10);
            sparseArray.put(10, cVar11);
            sparseArray.put(11, cVar12);
            sparseArray.put(12, cVar24);
            sparseArray.put(13, cVar15);
            sparseArray.put(14, cVar17);
            sparseArray.put(15, cVar19);
            sparseArray.put(16, cVar21);
            sparseArray.put(17, cVar23);
            sparseArray.put(-1, cVar25);
        }

        private c(int i) {
            this.zzu = i;
        }

        public int zza() {
            return this.zzu;
        }

        @Nullable
        public static c zza(int i) {
            return zzt.get(i);
        }
    }

    public static a a() {
        return new i.b();
    }
}
