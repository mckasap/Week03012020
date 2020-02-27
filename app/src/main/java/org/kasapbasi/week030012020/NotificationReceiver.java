package org.kasapbasi.week030012020;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class NotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if("YES_ACTION".equals(action)){
            Log.d("NotificationAction","YES");
        }else if("NO_ACTION".equals(action)){
            Log.d("NotificationAction","NO");
        }

    }
}
