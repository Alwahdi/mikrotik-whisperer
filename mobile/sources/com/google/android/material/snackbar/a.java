package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class a {
    private static a a;

    /* renamed from: a  reason: collision with other field name */
    private final Handler f1898a = new Handler(Looper.getMainLooper(), new C0017a());

    /* renamed from: a  reason: collision with other field name */
    private c f1899a;

    /* renamed from: a  reason: collision with other field name */
    private final Object f1900a = new Object();
    private c b;

    interface b {
        void a(int i);

        void show();
    }

    static a c() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    private a() {
    }

    /* renamed from: com.google.android.material.snackbar.a$a  reason: collision with other inner class name */
    class C0017a implements Handler.Callback {
        C0017a() {
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    a.this.d((c) message.obj);
                    return true;
                default:
                    return false;
            }
        }
    }

    public void m(int duration, b callback) {
        synchronized (this.f1900a) {
            if (f(callback)) {
                c cVar = this.f1899a;
                cVar.a = duration;
                this.f1898a.removeCallbacksAndMessages(cVar);
                l(this.f1899a);
                return;
            }
            if (g(callback)) {
                this.b.a = duration;
            } else {
                this.b = new c(duration, callback);
            }
            c cVar2 = this.f1899a;
            if (cVar2 == null || !a(cVar2, 4)) {
                this.f1899a = null;
                n();
            }
        }
    }

    public void b(b callback, int event) {
        synchronized (this.f1900a) {
            if (f(callback)) {
                a(this.f1899a, event);
            } else if (g(callback)) {
                a(this.b, event);
            }
        }
    }

    public void h(b callback) {
        synchronized (this.f1900a) {
            if (f(callback)) {
                this.f1899a = null;
                if (this.b != null) {
                    n();
                }
            }
        }
    }

    public void i(b callback) {
        synchronized (this.f1900a) {
            if (f(callback)) {
                l(this.f1899a);
            }
        }
    }

    public void j(b callback) {
        synchronized (this.f1900a) {
            if (f(callback)) {
                c cVar = this.f1899a;
                if (!cVar.f1902a) {
                    cVar.f1902a = true;
                    this.f1898a.removeCallbacksAndMessages(cVar);
                }
            }
        }
    }

    public void k(b callback) {
        synchronized (this.f1900a) {
            if (f(callback)) {
                c cVar = this.f1899a;
                if (cVar.f1902a) {
                    cVar.f1902a = false;
                    l(cVar);
                }
            }
        }
    }

    public boolean e(b callback) {
        boolean z;
        synchronized (this.f1900a) {
            if (!f(callback)) {
                if (!g(callback)) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    private static class c {
        int a;

        /* renamed from: a  reason: collision with other field name */
        final WeakReference<b> f1901a;

        /* renamed from: a  reason: collision with other field name */
        boolean f1902a;

        c(int duration, b callback) {
            this.f1901a = new WeakReference<>(callback);
            this.a = duration;
        }

        /* access modifiers changed from: package-private */
        public boolean a(b callback) {
            return callback != null && this.f1901a.get() == callback;
        }
    }

    private void n() {
        c cVar = this.b;
        if (cVar != null) {
            this.f1899a = cVar;
            this.b = null;
            b callback = (b) cVar.f1901a.get();
            if (callback != null) {
                callback.show();
            } else {
                this.f1899a = null;
            }
        }
    }

    private boolean a(c record, int event) {
        b callback = (b) record.f1901a.get();
        if (callback == null) {
            return false;
        }
        this.f1898a.removeCallbacksAndMessages(record);
        callback.a(event);
        return true;
    }

    private boolean f(b callback) {
        c cVar = this.f1899a;
        return cVar != null && cVar.a(callback);
    }

    private boolean g(b callback) {
        c cVar = this.b;
        return cVar != null && cVar.a(callback);
    }

    private void l(c r) {
        int i = r.a;
        if (i != -2) {
            int durationMs = 2750;
            if (i > 0) {
                durationMs = r.a;
            } else if (i == -1) {
                durationMs = 1500;
            }
            this.f1898a.removeCallbacksAndMessages(r);
            Handler handler = this.f1898a;
            handler.sendMessageDelayed(Message.obtain(handler, 0, r), (long) durationMs);
        }
    }

    /* access modifiers changed from: package-private */
    public void d(c record) {
        synchronized (this.f1900a) {
            if (this.f1899a == record || this.b == record) {
                a(record, 2);
            }
        }
    }
}
