package defpackage;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.e;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;
import org.apache.http.protocol.HTTP;

/* renamed from: iv  reason: default package */
public class iv implements yv0 {
    private final Context a;

    /* renamed from: a  reason: collision with other field name */
    private final e f3983a;

    /* renamed from: a  reason: collision with other field name */
    private final hj f3984a;

    public iv(Context applicationContext, hj eventStore, e config) {
        this.a = applicationContext;
        this.f3984a = eventStore;
        this.f3983a = config;
    }

    /* access modifiers changed from: package-private */
    public int b(es0 transportContext) {
        Adler32 checksum = new Adler32();
        checksum.update(this.a.getPackageName().getBytes(Charset.forName(HTTP.UTF_8)));
        checksum.update(transportContext.b().getBytes(Charset.forName(HTTP.UTF_8)));
        checksum.update(ByteBuffer.allocate(4).putInt(ta0.a(transportContext.d())).array());
        if (transportContext.c() != null) {
            checksum.update(transportContext.c());
        }
        return (int) checksum.getValue();
    }

    private boolean c(JobScheduler scheduler, int jobId, int attemptNumber) {
        for (JobInfo jobInfo : scheduler.getAllPendingJobs()) {
            int existingAttemptNumber = jobInfo.getExtras().getInt("attemptNumber");
            if (jobInfo.getId() == jobId) {
                if (existingAttemptNumber >= attemptNumber) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public void a(es0 transportContext, int attemptNumber) {
        ComponentName serviceComponent = new ComponentName(this.a, JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.a.getSystemService("jobscheduler");
        int jobId = b(transportContext);
        if (c(jobScheduler, jobId, attemptNumber)) {
            xy.a("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", transportContext);
            return;
        }
        long nextCallTime = this.f3984a.S(transportContext);
        JobInfo.Builder builder = this.f3983a.b(new JobInfo.Builder(jobId, serviceComponent), transportContext.d(), nextCallTime, attemptNumber);
        PersistableBundle bundle = new PersistableBundle();
        bundle.putInt("attemptNumber", attemptNumber);
        bundle.putString("backendName", transportContext.b());
        bundle.putInt("priority", ta0.a(transportContext.d()));
        if (transportContext.c() != null) {
            bundle.putString("extras", Base64.encodeToString(transportContext.c(), 0));
        }
        builder.setExtras(bundle);
        xy.b("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", transportContext, Integer.valueOf(jobId), Long.valueOf(this.f3983a.f(transportContext.d(), nextCallTime, attemptNumber)), Long.valueOf(nextCallTime), Integer.valueOf(attemptNumber));
        jobScheduler.schedule(builder.build());
    }
}
