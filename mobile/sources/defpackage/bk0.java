package defpackage;

import android.util.Log;

/* renamed from: bk0  reason: default package */
public class bk0 implements Runnable {
    final ng a;

    public bk0(ng a2) {
        this.a = a2;
    }

    public void run() {
        while (true) {
            ng ngVar = this.a;
            if (ngVar.f4438a) {
                try {
                    ngVar.f4437a.send(ngVar.f4436a);
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Log.d("Discover service", "Discover thread interupted");
                    return;
                } catch (Exception e2) {
                    Log.d("Discover service", "no longer listening for UDP broadcasts cause of error " + e2.getMessage());
                    e2.printStackTrace();
                    return;
                }
            } else {
                return;
            }
        }
    }
}
