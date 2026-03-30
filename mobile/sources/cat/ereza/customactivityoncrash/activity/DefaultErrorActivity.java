package cat.ereza.customactivityoncrash.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public final class DefaultErrorActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TypedArray a2 = obtainStyledAttributes(zc0.k);
        if (!a2.hasValue(zc0.a)) {
            setTheme(vc0.a);
        }
        a2.recycle();
        setContentView(oc0.customactivityoncrash_default_error_activity);
        Button restartButton = (Button) findViewById(kc0.customactivityoncrash_error_activity_restart_button);
        w7 config = xd.t(getIntent());
        if (config == null) {
            finish();
            return;
        }
        if (!config.I() || config.E() == null) {
            restartButton.setOnClickListener(new b(config));
        } else {
            restartButton.setText(tc0.customactivityoncrash_error_activity_restart_app);
            restartButton.setOnClickListener(new a(config));
        }
        Button moreInfoButton = (Button) findViewById(kc0.customactivityoncrash_error_activity_more_info_button);
        if (config.H()) {
            moreInfoButton.setOnClickListener(new c());
        } else {
            moreInfoButton.setVisibility(8);
        }
        Integer defaultErrorActivityDrawableId = config.B();
        ImageView errorImageView = (ImageView) findViewById(kc0.customactivityoncrash_error_activity_image);
        if (defaultErrorActivityDrawableId != null) {
            errorImageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), defaultErrorActivityDrawableId.intValue(), getTheme()));
        }
    }

    class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ w7 f321a;

        a(w7 w7Var) {
            this.f321a = w7Var;
        }

        public void onClick(View v) {
            xd.H(DefaultErrorActivity.this, this.f321a);
        }
    }

    class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ w7 f322a;

        b(w7 w7Var) {
            this.f322a = w7Var;
        }

        public void onClick(View v) {
            xd.o(DefaultErrorActivity.this, this.f322a);
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View v) {
            AlertDialog.Builder title = new AlertDialog.Builder(DefaultErrorActivity.this).setTitle(tc0.customactivityoncrash_error_activity_error_details_title);
            DefaultErrorActivity defaultErrorActivity = DefaultErrorActivity.this;
            TextView textView = (TextView) title.setMessage((CharSequence) xd.q(defaultErrorActivity, defaultErrorActivity.getIntent())).setPositiveButton(tc0.customactivityoncrash_error_activity_error_details_close, (DialogInterface.OnClickListener) null).setNeutralButton(tc0.customactivityoncrash_error_activity_error_details_copy, (DialogInterface.OnClickListener) new a()).show().findViewById(16908299);
            if (textView != null) {
                textView.setTextSize(0, DefaultErrorActivity.this.getResources().getDimension(ec0.customactivityoncrash_error_activity_error_details_text_size));
            }
        }

        class a implements DialogInterface.OnClickListener {
            a() {
            }

            public void onClick(DialogInterface dialog, int which) {
                DefaultErrorActivity.this.k();
            }
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        String errorInformation = xd.q(this, getIntent());
        ClipboardManager clipboard = (ClipboardManager) getSystemService("clipboard");
        if (clipboard != null) {
            clipboard.setPrimaryClip(ClipData.newPlainText(getString(tc0.customactivityoncrash_error_activity_error_details_clipboard_label), errorInformation));
            Toast.makeText(this, tc0.customactivityoncrash_error_activity_error_details_copied, 0).show();
        }
    }
}
