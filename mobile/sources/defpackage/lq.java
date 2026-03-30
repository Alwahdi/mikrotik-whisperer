package defpackage;

import android.os.Handler;
import android.os.Message;
import defpackage.bj0;
import java.util.concurrent.TimeUnit;

/* renamed from: lq  reason: default package */
final class lq extends bj0 {
    private final Handler a;

    lq(Handler handler) {
        this.a = handler;
    }

    public yg c(Runnable run, long delay, TimeUnit unit) {
        if (run == null) {
            throw new NullPointerException("run == null");
        } else if (unit != null) {
            b scheduled = new b(this.a, of0.n(run));
            this.a.postDelayed(scheduled, unit.toMillis(delay));
            return scheduled;
        } else {
            throw new NullPointerException("unit == null");
        }
    }

    public bj0.b a() {
        return new a(this.a);
    }

    /* renamed from: lq$a */
    private static final class a extends bj0.b {
        private final Handler a;

        /* renamed from: a  reason: collision with other field name */
        private volatile boolean f4273a;

        a(Handler handler) {
            this.a = handler;
        }

        public yg c(Runnable run, long delay, TimeUnit unit) {
            if (run == null) {
                throw new NullPointerException("run == null");
            } else if (unit == null) {
                throw new NullPointerException("unit == null");
            } else if (this.f4273a) {
                return ch.a();
            } else {
                b scheduled = new b(this.a, of0.n(run));
                Message message = Message.obtain(this.a, scheduled);
                message.obj = this;
                this.a.sendMessageDelayed(message, unit.toMillis(delay));
                if (!this.f4273a) {
                    return scheduled;
                }
                this.a.removeCallbacks(scheduled);
                return ch.a();
            }
        }

        public void dispose() {
            this.f4273a = true;
            this.a.removeCallbacksAndMessages(this);
        }
    }

    /* renamed from: lq$b */
    private static final class b implements Runnable, yg {
        private final Handler a;

        /* renamed from: a  reason: collision with other field name */
        private final Runnable f4274a;

        /* renamed from: a  reason: collision with other field name */
        private volatile boolean f4275a;

        b(Handler handler, Runnable delegate) {
            this.a = handler;
            this.f4274a = delegate;
        }

        public void run() {
            try {
                this.f4274a.run();
            } catch (Throwable t) {
                of0.l(t);
            }
        }

        public void dispose() {
            this.f4275a = true;
            this.a.removeCallbacks(this);
        }
    }
}
