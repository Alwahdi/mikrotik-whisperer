package com.blogspot.yemeninfo4it.mumsmobile_app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.RemoteInput;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Message;

public class DirectReplyReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);
        if (remoteInput != null) {
            new Message(remoteInput.getCharSequence("key_text_reply"), (CharSequence) null);
        }
    }
}
