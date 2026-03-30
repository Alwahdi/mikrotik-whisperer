package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;

final /* synthetic */ class d implements Runnable {
    private final JobParameters a;

    /* renamed from: a  reason: collision with other field name */
    private final JobInfoSchedulerService f1372a;

    private d(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.f1372a = jobInfoSchedulerService;
        this.a = jobParameters;
    }

    public static Runnable a(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        return new d(jobInfoSchedulerService, jobParameters);
    }

    public void run() {
        this.f1372a.jobFinished(this.a, false);
    }
}
