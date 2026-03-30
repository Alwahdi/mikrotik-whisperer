package com.google.android.gms.auth.api.signin;

import android.os.Parcelable;

public final class a implements Parcelable.Creator<GoogleSignInAccount> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }

    /* JADX WARNING: type inference failed for: r2v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r21) {
        /*
            r20 = this;
            r0 = r21
            int r1 = defpackage.ei0.s(r21)
            r2 = 0
            r3 = 0
            r4 = 0
            r8 = r2
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r16 = r13
            r17 = r16
            r18 = r17
            r19 = r18
            r14 = r4
            r7 = 0
        L_0x0025:
            int r2 = r21.dataPosition()
            if (r2 >= r1) goto L_0x0087
            int r2 = defpackage.ei0.l(r21)
            int r3 = defpackage.ei0.h(r2)
            switch(r3) {
                case 1: goto L_0x0081;
                case 2: goto L_0x007b;
                case 3: goto L_0x0075;
                case 4: goto L_0x006f;
                case 5: goto L_0x0069;
                case 6: goto L_0x005f;
                case 7: goto L_0x0059;
                case 8: goto L_0x0053;
                case 9: goto L_0x004d;
                case 10: goto L_0x0046;
                case 11: goto L_0x0040;
                case 12: goto L_0x003a;
                default: goto L_0x0036;
            }
        L_0x0036:
            defpackage.ei0.r(r0, r2)
            goto L_0x0025
        L_0x003a:
            java.lang.String r19 = defpackage.ei0.c(r0, r2)
            goto L_0x0025
        L_0x0040:
            java.lang.String r18 = defpackage.ei0.c(r0, r2)
            goto L_0x0025
        L_0x0046:
            android.os.Parcelable$Creator<com.google.android.gms.common.api.Scope> r3 = com.google.android.gms.common.api.Scope.CREATOR
            java.util.ArrayList r17 = defpackage.ei0.f(r0, r2, r3)
            goto L_0x0025
        L_0x004d:
            java.lang.String r16 = defpackage.ei0.c(r0, r2)
            goto L_0x0025
        L_0x0053:
            long r14 = defpackage.ei0.o(r0, r2)
            goto L_0x0025
        L_0x0059:
            java.lang.String r13 = defpackage.ei0.c(r0, r2)
            goto L_0x0025
        L_0x005f:
            android.os.Parcelable$Creator r3 = android.net.Uri.CREATOR
            android.os.Parcelable r2 = defpackage.ei0.b(r0, r2, r3)
            r12 = r2
            android.net.Uri r12 = (android.net.Uri) r12
            goto L_0x0025
        L_0x0069:
            java.lang.String r11 = defpackage.ei0.c(r0, r2)
            goto L_0x0025
        L_0x006f:
            java.lang.String r10 = defpackage.ei0.c(r0, r2)
            goto L_0x0025
        L_0x0075:
            java.lang.String r9 = defpackage.ei0.c(r0, r2)
            goto L_0x0025
        L_0x007b:
            java.lang.String r8 = defpackage.ei0.c(r0, r2)
            goto L_0x0025
        L_0x0081:
            int r7 = defpackage.ei0.n(r0, r2)
            goto L_0x0025
        L_0x0087:
            defpackage.ei0.g(r0, r1)
            com.google.android.gms.auth.api.signin.GoogleSignInAccount r0 = new com.google.android.gms.auth.api.signin.GoogleSignInAccount
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r16, r17, r18, r19)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.a.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
