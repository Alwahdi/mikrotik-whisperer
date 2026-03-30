package com.blogspot.yemeninfo4it.mumsmobile_app.activities;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;

public class DiscoverActivity extends AppCompatActivity {
    public ng a;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_discover);
        ng ngVar = new ng(this);
        this.a = ngVar;
        ngVar.f();
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(jv0.b(newBase));
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.a.d();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.a.f();
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
