package defpackage;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;
import com.annimon.stream.Optional;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.DeleteUser;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Sessions;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UserProfile;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: cl  reason: default package */
public class cl extends AsyncTask<Void, Void, String> {
    int a = 0;

    /* renamed from: a  reason: collision with other field name */
    Context f337a;

    /* renamed from: a  reason: collision with other field name */
    ArrayList<Sessions> f338a;

    /* renamed from: a  reason: collision with other field name */
    List<UsermanagerCards> f339a;
    ArrayList<DeleteUser> b;

    /* renamed from: b  reason: collision with other field name */
    List<Map<String, String>> f340b = null;
    List<UserProfile> c;

    public cl(Context context, List<UsermanagerCards> usermanagerCards, List<UserProfile> userProfile, ArrayList<Sessions> resultSessin) {
        this.f337a = context;
        this.f339a = usermanagerCards;
        this.f338a = resultSessin;
        this.c = userProfile;
        new ArrayList<>();
        this.b = new ArrayList<>();
        this.a = 0;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        Toast.makeText(this.f337a, "يتم تهيئة وإعداد كروت يوزر مانجر", 0).show();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x026b A[Catch:{ Exception -> 0x02ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01a7 A[Catch:{ Exception -> 0x0204 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01ac A[Catch:{ Exception -> 0x0204 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01d7 A[Catch:{ Exception -> 0x0204 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01dc A[Catch:{ Exception -> 0x0204 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x020f A[Catch:{ Exception -> 0x02ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0221 A[Catch:{ Exception -> 0x02ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x022e A[Catch:{ Exception -> 0x02ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x023e A[Catch:{ Exception -> 0x02ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0249 A[Catch:{ Exception -> 0x02ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0259 A[Catch:{ Exception -> 0x02ae }] */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String doInBackground(java.lang.Void... r37) {
        /*
            r36 = this;
            r1 = r36
            java.lang.String r2 = "DAMMAG"
            java.lang.String r3 = ":"
            java.lang.String r4 = ""
            java.util.List<com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards> r0 = r1.f339a     // Catch:{ Exception -> 0x02ae }
            ln0 r0 = defpackage.ln0.U(r0)     // Catch:{ Exception -> 0x02ae }
            xk r5 = new xk     // Catch:{ Exception -> 0x02ae }
            r5.<init>(r1)     // Catch:{ Exception -> 0x02ae }
            r0.J(r5)     // Catch:{ Exception -> 0x02ae }
            java.util.List<com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards> r0 = r1.f339a     // Catch:{ Exception -> 0x02ae }
            java.util.Iterator r5 = r0.iterator()     // Catch:{ Exception -> 0x02ae }
        L_0x001c:
            boolean r0 = r5.hasNext()     // Catch:{ Exception -> 0x02ae }
            if (r0 == 0) goto L_0x02ad
            java.lang.Object r0 = r5.next()     // Catch:{ Exception -> 0x02ae }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards r0 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards) r0     // Catch:{ Exception -> 0x02ae }
            r6 = r0
            java.lang.String r0 = r6.last_seen     // Catch:{ Exception -> 0x02ae }
            java.lang.String r7 = "waiting"
            boolean r0 = r0.equals(r7)     // Catch:{ Exception -> 0x02ae }
            if (r0 != 0) goto L_0x02a1
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.Sessions> r0 = r1.f338a     // Catch:{ Exception -> 0x02ae }
            ln0 r0 = defpackage.ln0.U(r0)     // Catch:{ Exception -> 0x02ae }
            yk r7 = new yk     // Catch:{ Exception -> 0x02ae }
            r7.<init>(r6)     // Catch:{ Exception -> 0x02ae }
            ln0 r0 = r0.q(r7)     // Catch:{ Exception -> 0x02ae }
            u9 r7 = defpackage.v9.d()     // Catch:{ Exception -> 0x02ae }
            java.lang.Object r0 = r0.f(r7)     // Catch:{ Exception -> 0x02ae }
            java.util.List r0 = (java.util.List) r0     // Catch:{ Exception -> 0x02ae }
            r7 = r0
            r0 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r15 = r4
            r16 = r4
            r17 = r4
            r18 = r5
            java.lang.String r5 = "h"
            r19 = r8
            java.lang.String r8 = "s"
            r20 = r9
            java.lang.String r9 = "m"
            r22 = 0
            if (r7 == 0) goto L_0x0173
            int r10 = r7.size()     // Catch:{ Exception -> 0x02ae }
            if (r10 <= 0) goto L_0x0170
            java.util.Iterator r10 = r7.iterator()     // Catch:{ Exception -> 0x02ae }
        L_0x0074:
            boolean r24 = r10.hasNext()     // Catch:{ Exception -> 0x02ae }
            if (r24 == 0) goto L_0x0160
            java.lang.Object r24 = r10.next()     // Catch:{ Exception -> 0x02ae }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.Sessions r24 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.Sessions) r24     // Catch:{ Exception -> 0x02ae }
            java.lang.String r25 = r24.getDownload()     // Catch:{ Exception -> 0x02ae }
            java.util.Objects.requireNonNull(r25)     // Catch:{ Exception -> 0x02ae }
            r26 = r25
            java.lang.String r26 = (java.lang.String) r26     // Catch:{ Exception -> 0x02ae }
            float r25 = java.lang.Float.parseFloat(r25)     // Catch:{ Exception -> 0x02ae }
            float r25 = r0 + r25
            java.lang.String r0 = r24.getUpload()     // Catch:{ Exception -> 0x02ae }
            java.util.Objects.requireNonNull(r0)     // Catch:{ Exception -> 0x02ae }
            r26 = r0
            java.lang.String r26 = (java.lang.String) r26     // Catch:{ Exception -> 0x02ae }
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ Exception -> 0x02ae }
            float r19 = r19 + r0
            java.lang.String r0 = r24.getUptime()     // Catch:{ Exception -> 0x0152 }
            int r26 = r0.indexOf(r5)     // Catch:{ Exception -> 0x0152 }
            r27 = r26
            r26 = r7
            r7 = r27
            if (r7 < 0) goto L_0x00bd
            r27 = r10
            r10 = 0
            java.lang.String r29 = r0.substring(r10, r7)     // Catch:{ Exception -> 0x00ba }
            goto L_0x00c1
        L_0x00ba:
            r0 = move-exception
            goto L_0x0157
        L_0x00bd:
            r27 = r10
            r29 = r4
        L_0x00c1:
            r15 = r29
            boolean r10 = r15.isEmpty()     // Catch:{ Exception -> 0x00ba }
            if (r10 != 0) goto L_0x00e2
            boolean r10 = r0.contains(r9)     // Catch:{ Exception -> 0x00ba }
            if (r10 == 0) goto L_0x00dc
            int r10 = r7 + 1
            r29 = r7
            int r7 = r0.indexOf(r9)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r7 = r0.substring(r10, r7)     // Catch:{ Exception -> 0x00ba }
            goto L_0x00df
        L_0x00dc:
            r29 = r7
            r7 = r4
        L_0x00df:
            r16 = r7
            goto L_0x00f6
        L_0x00e2:
            r29 = r7
            int r7 = r0.indexOf(r9)     // Catch:{ Exception -> 0x00ba }
            if (r7 < 0) goto L_0x00f0
            r10 = 0
            java.lang.String r30 = r0.substring(r10, r7)     // Catch:{ Exception -> 0x00ba }
            goto L_0x00f2
        L_0x00f0:
            r30 = r4
        L_0x00f2:
            r10 = r30
            r16 = r10
        L_0x00f6:
            boolean r7 = r16.isEmpty()     // Catch:{ Exception -> 0x00ba }
            if (r7 != 0) goto L_0x0115
            boolean r7 = r0.contains(r8)     // Catch:{ Exception -> 0x00ba }
            if (r7 == 0) goto L_0x0111
            int r7 = r0.indexOf(r9)     // Catch:{ Exception -> 0x00ba }
            int r7 = r7 + 1
            int r10 = r0.indexOf(r8)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r7 = r0.substring(r7, r10)     // Catch:{ Exception -> 0x00ba }
            goto L_0x0112
        L_0x0111:
            r7 = r4
        L_0x0112:
            r17 = r7
            goto L_0x0124
        L_0x0115:
            int r7 = r0.indexOf(r8)     // Catch:{ Exception -> 0x00ba }
            if (r7 < 0) goto L_0x0121
            r10 = 0
            java.lang.String r10 = r0.substring(r10, r7)     // Catch:{ Exception -> 0x00ba }
            goto L_0x0122
        L_0x0121:
            r10 = r4
        L_0x0122:
            r17 = r10
        L_0x0124:
            int r7 = r15.length()     // Catch:{ Exception -> 0x00ba }
            if (r7 <= 0) goto L_0x012f
            long r30 = java.lang.Long.parseLong(r15)     // Catch:{ Exception -> 0x00ba }
            goto L_0x0131
        L_0x012f:
            r30 = r22
        L_0x0131:
            long r20 = r20 + r30
            int r7 = r16.length()     // Catch:{ Exception -> 0x00ba }
            if (r7 <= 0) goto L_0x013e
            long r30 = java.lang.Long.parseLong(r16)     // Catch:{ Exception -> 0x00ba }
            goto L_0x0140
        L_0x013e:
            r30 = r22
        L_0x0140:
            long r11 = r11 + r30
            int r7 = r17.length()     // Catch:{ Exception -> 0x00ba }
            if (r7 <= 0) goto L_0x014d
            long r30 = java.lang.Long.parseLong(r17)     // Catch:{ Exception -> 0x00ba }
            goto L_0x014f
        L_0x014d:
            r30 = r22
        L_0x014f:
            long r13 = r13 + r30
            goto L_0x0157
        L_0x0152:
            r0 = move-exception
            r26 = r7
            r27 = r10
        L_0x0157:
            r0 = r25
            r7 = r26
            r10 = r27
            goto L_0x0074
        L_0x0160:
            r26 = r7
            r7 = r0
            r35 = r16
            r16 = r15
            r14 = r13
            r12 = r11
            r10 = r20
            r20 = r17
            r17 = r35
            goto L_0x0182
        L_0x0170:
            r26 = r7
            goto L_0x0175
        L_0x0173:
            r26 = r7
        L_0x0175:
            r7 = r0
            r35 = r16
            r16 = r15
            r14 = r13
            r12 = r11
            r10 = r20
            r20 = r17
            r17 = r35
        L_0x0182:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0204 }
            r0.<init>()     // Catch:{ Exception -> 0x0204 }
            r0.append(r10)     // Catch:{ Exception -> 0x0204 }
            r0.append(r3)     // Catch:{ Exception -> 0x0204 }
            r0.append(r12)     // Catch:{ Exception -> 0x0204 }
            r0.append(r3)     // Catch:{ Exception -> 0x0204 }
            r0.append(r14)     // Catch:{ Exception -> 0x0204 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0204 }
            android.util.Log.d(r2, r0)     // Catch:{ Exception -> 0x0204 }
            r24 = 1
            r27 = 59
            r29 = 60
            int r0 = (r14 > r29 ? 1 : (r14 == r29 ? 0 : -1))
            if (r0 != 0) goto L_0x01ac
            long r12 = r12 + r24
            r14 = 0
            goto L_0x01b8
        L_0x01ac:
            int r0 = (r14 > r27 ? 1 : (r14 == r27 ? 0 : -1))
            if (r0 <= 0) goto L_0x01b8
            long r31 = r14 / r29
            long r12 = r12 + r31
            long r31 = r14 % r29
            r14 = r31
        L_0x01b8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0204 }
            r0.<init>()     // Catch:{ Exception -> 0x0204 }
            r0.append(r10)     // Catch:{ Exception -> 0x0204 }
            r0.append(r3)     // Catch:{ Exception -> 0x0204 }
            r0.append(r12)     // Catch:{ Exception -> 0x0204 }
            r0.append(r3)     // Catch:{ Exception -> 0x0204 }
            r0.append(r14)     // Catch:{ Exception -> 0x0204 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0204 }
            android.util.Log.d(r2, r0)     // Catch:{ Exception -> 0x0204 }
            int r0 = (r12 > r29 ? 1 : (r12 == r29 ? 0 : -1))
            if (r0 != 0) goto L_0x01dc
            long r10 = r10 + r24
            r12 = 0
            goto L_0x01e8
        L_0x01dc:
            int r0 = (r12 > r27 ? 1 : (r12 == r27 ? 0 : -1))
            if (r0 <= 0) goto L_0x01e8
            long r24 = r12 / r29
            long r10 = r10 + r24
            long r24 = r12 % r29
            r12 = r24
        L_0x01e8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0204 }
            r0.<init>()     // Catch:{ Exception -> 0x0204 }
            r0.append(r10)     // Catch:{ Exception -> 0x0204 }
            r0.append(r3)     // Catch:{ Exception -> 0x0204 }
            r0.append(r12)     // Catch:{ Exception -> 0x0204 }
            r0.append(r3)     // Catch:{ Exception -> 0x0204 }
            r0.append(r14)     // Catch:{ Exception -> 0x0204 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0204 }
            android.util.Log.d(r2, r0)     // Catch:{ Exception -> 0x0204 }
            goto L_0x0205
        L_0x0204:
            r0 = move-exception
        L_0x0205:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ae }
            r0.<init>()     // Catch:{ Exception -> 0x02ae }
            int r21 = (r10 > r22 ? 1 : (r10 == r22 ? 0 : -1))
            if (r21 <= 0) goto L_0x0221
            r21 = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ae }
            r2.<init>()     // Catch:{ Exception -> 0x02ae }
            r2.append(r10)     // Catch:{ Exception -> 0x02ae }
            r2.append(r5)     // Catch:{ Exception -> 0x02ae }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x02ae }
            goto L_0x0224
        L_0x0221:
            r21 = r2
            r2 = r4
        L_0x0224:
            r0.append(r2)     // Catch:{ Exception -> 0x02ae }
            r0.append(r4)     // Catch:{ Exception -> 0x02ae }
            int r2 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r2 <= 0) goto L_0x023e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ae }
            r2.<init>()     // Catch:{ Exception -> 0x02ae }
            r2.append(r12)     // Catch:{ Exception -> 0x02ae }
            r2.append(r9)     // Catch:{ Exception -> 0x02ae }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x02ae }
            goto L_0x023f
        L_0x023e:
            r2 = r4
        L_0x023f:
            r0.append(r2)     // Catch:{ Exception -> 0x02ae }
            r0.append(r4)     // Catch:{ Exception -> 0x02ae }
            int r2 = (r14 > r22 ? 1 : (r14 == r22 ? 0 : -1))
            if (r2 <= 0) goto L_0x0259
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ae }
            r2.<init>()     // Catch:{ Exception -> 0x02ae }
            r2.append(r14)     // Catch:{ Exception -> 0x02ae }
            r2.append(r8)     // Catch:{ Exception -> 0x02ae }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x02ae }
            goto L_0x025a
        L_0x0259:
            r2 = r4
        L_0x025a:
            r0.append(r2)     // Catch:{ Exception -> 0x02ae }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02ae }
            java.lang.String r2 = r6.last_seen     // Catch:{ Exception -> 0x02ae }
            java.lang.String r5 = "used"
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x02ae }
            if (r2 == 0) goto L_0x028f
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.DeleteUser> r2 = r1.b     // Catch:{ Exception -> 0x02ae }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.DeleteUser r5 = new com.blogspot.yemeninfo4it.mumsmobile_app.model.DeleteUser     // Catch:{ Exception -> 0x02ae }
            java.lang.String r8 = r6.id     // Catch:{ Exception -> 0x02ae }
            java.lang.String r9 = r6.uname     // Catch:{ Exception -> 0x02ae }
            java.lang.String r30 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x02ae }
            java.lang.String r31 = java.lang.String.valueOf(r19)     // Catch:{ Exception -> 0x02ae }
            java.lang.String r1 = r6.profilename     // Catch:{ Exception -> 0x02ae }
            r34 = 0
            r27 = r5
            r28 = r8
            r29 = r9
            r32 = r1
            r33 = r0
            r27.<init>(r28, r29, r30, r31, r32, r33, r34)     // Catch:{ Exception -> 0x02ae }
            r2.add(r5)     // Catch:{ Exception -> 0x02ae }
        L_0x028f:
            r6.setUptime_used(r0)     // Catch:{ Exception -> 0x02ae }
            java.lang.String r1 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x02ae }
            r6.setDownload_used(r1)     // Catch:{ Exception -> 0x02ae }
            java.lang.String r1 = java.lang.String.valueOf(r19)     // Catch:{ Exception -> 0x02ae }
            r6.setUpload_used(r1)     // Catch:{ Exception -> 0x02ae }
            goto L_0x02a5
        L_0x02a1:
            r21 = r2
            r18 = r5
        L_0x02a5:
            r1 = r36
            r5 = r18
            r2 = r21
            goto L_0x001c
        L_0x02ad:
            goto L_0x02af
        L_0x02ae:
            r0 = move-exception
        L_0x02af:
            java.lang.String r0 = "ok"
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cl.doInBackground(java.lang.Void[]):java.lang.String");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(UsermanagerCards aListElement) {
        Optional<UserProfile> matchingBElem = ln0.U(this.c).q(new zk(aListElement)).w();
        if (matchingBElem.c()) {
            aListElement.setProfilename(((UserProfile) matchingBElem.b()).getProfile());
            aListElement.setLast_seen(((UserProfile) matchingBElem.b()).getState());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void onPostExecute(String result) {
        try {
            qb0.f4830i = true;
            Long count = (Long) ln0.U(this.f339a).q(bl.a).f(v9.b());
            long co2 = 0;
            qb0.b = (int) (count != null ? count.longValue() : 0);
            Long count2 = (Long) ln0.U(this.f339a).q(al.a).f(v9.b());
            if (count2 != null) {
                co2 = count2.longValue();
            }
            qb0.c = (int) co2;
            Toast.makeText(this.f337a, "تمت تهيئة كروت يوزر مانجر", 0).show();
            qb0.q = new ArrayList<>();
            if (this.f339a.size() > 0) {
                qb0.r = this.b;
                qb0.f4807b = (ArrayList) this.f339a;
                TextView expire_card_used_count = (TextView) ((Activity) this.f337a).findViewById(R.id.expire_card_used_count);
                TextView card_used_count = (TextView) ((Activity) this.f337a).findViewById(R.id.card_used_count);
                TextView card_unused_count = (TextView) ((Activity) this.f337a).findViewById(R.id.card_unused_count);
                card_used_count.setTextSize(2, 13.7f);
                card_unused_count.setTextSize(2, 13.7f);
                expire_card_used_count.setTextSize(2, 13.7f);
                expire_card_used_count.setText("عدد الكروت منتهية الصلاحية :" + this.b.size());
                card_used_count.setText("الكروت المستخدمة :" + qb0.b);
                card_unused_count.setText("الكروت الغير مستخدمة :" + qb0.c);
            }
        } catch (Exception e) {
            Toast.makeText(this.f337a, e.getMessage(), 0).show();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean j(UsermanagerCards c2) {
        return !c2.getLast_seen().equalsIgnoreCase("waiting") && !c2.getLast_seen().equalsIgnoreCase("used");
    }
}
