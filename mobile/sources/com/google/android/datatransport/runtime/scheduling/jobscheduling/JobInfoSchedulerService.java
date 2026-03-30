package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import defpackage.es0;

@RequiresApi(api = 21)
public class JobInfoSchedulerService extends JobService {
    public boolean onStartJob(JobParameters params) {
        String backendName = params.getExtras().getString("backendName");
        String extras = params.getExtras().getString("extras");
        int priority = params.getExtras().getInt("priority");
        int attemptNumber = params.getExtras().getInt("attemptNumber");
        ls0.f(getApplicationContext());
        es0.a transportContext = es0.a().b(backendName).d(ta0.b(priority));
        if (extras != null) {
            transportContext.c(Base64.decode(extras, 0));
        }
        ls0.c().e().g(transportContext.a(), attemptNumber, d.a(this, params));
        return true;
    }

    public boolean onStopJob(JobParameters params) {
        return true;
    }
}
