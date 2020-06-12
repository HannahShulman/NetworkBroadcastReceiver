package com.hackeru.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;


class NetworkChangeBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getExtras() == null) {
            Toast.makeText(context, "No information attached", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean noConnection = intent.getExtras().getBoolean(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
        if(context instanceof NetworkDisplayer){ //check context if instance of interface, to enable implementation on selected screens.
            ((NetworkDisplayer) context).networkState(!noConnection);
        }
    }
}
