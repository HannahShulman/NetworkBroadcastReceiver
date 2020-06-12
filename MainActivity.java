package com.hackeru.broadcastreceivers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements NetworkDisplayer {

    NetworkChangeBroadcast receiver = new NetworkChangeBroadcast();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    @Override
    public void networkState(boolean state) {
        findViewById(R.id.connectivity_state).setBackgroundColor(state ? Color.GREEN : Color.RED);
    }
}

