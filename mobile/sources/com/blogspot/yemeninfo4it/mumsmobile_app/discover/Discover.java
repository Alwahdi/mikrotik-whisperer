package com.blogspot.yemeninfo4it.mumsmobile_app.discover;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import java.util.Locale;

public class Discover extends AppCompatActivity {
    ImageView a;

    /* renamed from: a  reason: collision with other field name */
    TextView f1270a;

    /* renamed from: a  reason: collision with other field name */
    public mg f1271a;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = new Locale("ar".toLowerCase());
        res.updateConfiguration(conf, dm);
        setContentView((int) R.layout.activity_discover);
        this.f1270a = (TextView) findViewById(R.id.header_text_title);
        ImageView imageView = (ImageView) findViewById(R.id.icontoolbar);
        this.a = imageView;
        imageView.setVisibility(8);
        this.f1270a.setText("اكتشاف الراوترات المتصلة");
        this.f1271a = new mg(this);
    }

    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(jv0.b(newBase));
    }

    public void onPause() {
        this.f1271a.e();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f1271a.f();
    }
}
