package defpackage;

import android.util.Log;

/* renamed from: ak0  reason: default package */
public class ak0 implements Runnable {
    final mg a;

    public ak0(mg a2) {
        this.a = a2;
    }

    public void run() {
        while (true) {
            mg mgVar = this.a;
            if (mgVar.f4358a) {
                try {
                    mgVar.f4357a.send(mgVar.f4356a);
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
